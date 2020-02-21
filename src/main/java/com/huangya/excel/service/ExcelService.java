package com.huangya.excel.service;

import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import org.apache.poi.ss.usermodel.Workbook;

/**
 * @author nonpool
 * @version 1.0
 * @since 2020/2/21
 */
public interface ExcelService {
    Workbook excelTemplate(TemplateExportParams params);
}
