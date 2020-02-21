package com.huangya.excel.util;

import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public final class XSSFSheetCopyUtil {




    /**
     * DEFAULT CONSTRUCTOR.
     */
    private XSSFSheetCopyUtil() {
    }

    /**
     * @param newSheet the sheet to create from the copy.
     * @param sheet    the sheet to copy.
     */
    public static void copySheets(XSSFSheet newSheet, XSSFSheet sheet) {
        copySheets(newSheet, sheet, true);
    }

    /**
     * @param newSheet  the sheet to create from the copy.
     * @param sheet     the sheet to copy.
     * @param copyStyle true copy the style.
     */
    public static void copySheets(XSSFSheet newSheet, XSSFSheet sheet, boolean copyStyle) {
        int maxColumnNum = 0;
        Map<Integer, XSSFCellStyle> styleMap = (copyStyle) ? new HashMap<Integer, XSSFCellStyle>() : null;
        for (int i = sheet.getFirstRowNum(); i <= sheet.getLastRowNum(); i++) {
            XSSFRow srcRow = sheet.getRow(i);
            XSSFRow destRow = newSheet.createRow(i);
            if (srcRow != null) {
                // System.out.println("srcRow = " + srcRow.toString());
                copyRow(sheet, newSheet, srcRow, destRow, styleMap);
                if (srcRow.getLastCellNum() > maxColumnNum) {
                    maxColumnNum = srcRow.getLastCellNum();
                }
            }
        }
        for (int i = 0; i <= maxColumnNum; i++) {
            newSheet.setColumnWidth(i, sheet.getColumnWidth(i));
        }
    }

    /**
     * @param srcSheet  the sheet to copy.
     * @param destSheet the sheet to create.
     * @param srcRow    the row to copy.
     * @param destRow   the row to create.
     * @param styleMap  -
     */
    public static void copyRow(XSSFSheet srcSheet, XSSFSheet destSheet, XSSFRow srcRow, XSSFRow destRow,
                               Map<Integer, XSSFCellStyle> styleMap) {
        // manage a list of merged zone in order to not insert two times a merged zone
        Set<CellRangeAddressWrapper> mergedRegions = new TreeSet<CellRangeAddressWrapper>();
        destRow.setHeight(srcRow.getHeight());
        // pour chaque row
        for (int j = srcRow.getFirstCellNum(); j <= srcRow.getLastCellNum(); j++) {

            XSSFCell oldCell = srcRow.getCell(j); // old cell
            XSSFCell newCell = destRow.getCell(j); // new cell
            if (oldCell != null) {
                if (newCell == null) {
                    newCell = destRow.createCell(j);
                }
                copyCell(oldCell, newCell, styleMap);
                // System.out.println("row num: " + srcRow.getRowNum() + " , col: " + (short) oldCell.getColumnIndex());
                try {
                    CellRangeAddress mergedRegion = getMergedRegion(srcSheet, srcRow.getRowNum(), (short) oldCell
                            .getColumnIndex());
                    // System.out.println("mergedRegion: " + mergedRegion);

                    if (mergedRegion != null) {
                        // System.out.println("Selected merged region: " + mergedRegion.toString());
                        CellRangeAddress newMergedRegion = new CellRangeAddress(mergedRegion.getFirstRow(),
                                mergedRegion.getLastRow(), mergedRegion.getFirstColumn(), mergedRegion.getLastColumn());
                        // System.out.println("New merged region: " + newMergedRegion.toString());
                        CellRangeAddressWrapper wrapper = new CellRangeAddressWrapper(newMergedRegion);

                        if (isNewMergedRegion(wrapper, mergedRegions)) {
                            // System.out.println("Adding new region");
                            mergedRegions.add(wrapper);
                            destSheet.addMergedRegion(wrapper.range);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /**
     * @param oldCell
     * @param newCell
     * @param styleMap
     */
    public static void copyCell(XSSFCell oldCell, XSSFCell newCell, Map<Integer, XSSFCellStyle> styleMap) {

        if (styleMap != null) {
            if (oldCell.getSheet().getWorkbook() == newCell.getSheet().getWorkbook()) {
                newCell.setCellStyle(oldCell.getCellStyle());
            } else {
                int stHashCode = oldCell.getCellStyle().hashCode();
                XSSFCellStyle newCellStyle = styleMap.get(stHashCode);
                if (newCellStyle == null) {
                    newCellStyle = newCell.getSheet().getWorkbook().createCellStyle();
                    newCellStyle.cloneStyleFrom(oldCell.getCellStyle());
                    styleMap.put(stHashCode, newCellStyle);
                }
                newCell.setCellStyle(newCellStyle);
            }
        }
        switch (oldCell.getCellType()) {
            case XSSFCell.CELL_TYPE_STRING:
                newCell.setCellValue(oldCell.getStringCellValue());
                // System.out.println("oldCell = " + oldCell.getStringCellValue());
                // System.out.println("newCell = " + newCell.getStringCellValue());

                break;
            case XSSFCell.CELL_TYPE_NUMERIC:
                newCell.setCellValue(oldCell.getNumericCellValue());
                // System.out.println("oldCell = " + oldCell.getNumericCellValue());
                // System.out.println("newCell = " + newCell.getNumericCellValue());
                break;
            case XSSFCell.CELL_TYPE_BLANK:
                newCell.setCellType(XSSFCell.CELL_TYPE_BLANK);
                break;
            case XSSFCell.CELL_TYPE_BOOLEAN:
                newCell.setCellValue(oldCell.getBooleanCellValue());
                break;
            case XSSFCell.CELL_TYPE_ERROR:
                newCell.setCellErrorValue(oldCell.getErrorCellValue());
                break;
            case XSSFCell.CELL_TYPE_FORMULA:
                newCell.setCellFormula(oldCell.getCellFormula());
                break;
            default:
                break;
        }
    }

    /**
     * @param sheet   the sheet containing the data.
     * @param rowNum  the num of the row to copy.
     * @param cellNum the num of the cell to copy.
     * @return the CellRangeAddress created.
     */
    public static CellRangeAddress getMergedRegion(XSSFSheet sheet, int rowNum, short cellNum) {
        for (int i = 0; i < sheet.getNumMergedRegions(); i++) {
            CellRangeAddress merged = sheet.getMergedRegion(i);

            if (merged.isInRange(rowNum, cellNum)) {
                return merged;
            }
        }
        return null;
    }

    /**
     * Check that the merged region has been created in the destination sheet.
     *
     * @param newMergedRegion the merged region to copy or not in the destination sheet.
     * @param mergedRegions   the list containing all the merged region.
     * @return true if the merged region is already in the list or not.
     */
    private static boolean isNewMergedRegion(CellRangeAddressWrapper newMergedRegion,
                                             Set<CellRangeAddressWrapper> mergedRegions) {
        return !mergedRegions.contains(newMergedRegion);
    }
}