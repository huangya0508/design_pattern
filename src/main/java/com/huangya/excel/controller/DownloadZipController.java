package com.huangya.excel.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import com.huangya.excel.util.XSSFSheetCopyUtil;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author nonpool
 * @version 1.0
 * @since 2020/2/21
 * 下载压缩包 压缩包里创建文件夹
 */
@RestController
public class DownloadZipController {

    @GetMapping("/downloadZip")
    public void downloadZip(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.reset();
            response.setContentType("application/octet-stream");
            response.setHeader("Content-Disposition", "attachment;filename=".concat(String.valueOf(URLEncoder.encode("报销.xlsx", "UTF-8"))));
            String realPath = request.getSession().getServletContext().getRealPath("/");
            //创建已经ZipOutputStream
            ZipOutputStream zop = new ZipOutputStream(response.getOutputStream());
            //创建一个ZipEntry
            ZipEntry zipEntry = new ZipEntry(realPath + "a/1.png");
            zop.putNextEntry(zipEntry);
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(realPath + "upload/1.png"));
            int size = 0;
            byte[] buffer = new byte[1024];  //设置读取数据缓存大小
            while ((size = bis.read(buffer)) > 0) {
                zop.write(buffer, 0, size);
            }
            //关闭输入输出流
            zop.closeEntry();
            bis.close();
            zop.close();
        } catch (Exception e) {
        }
    }


    /**
     * 拷贝sheet
     *
     * @param request
     * @param response
     */
    @GetMapping("copysheet")
    public ResponseEntity<Resource> copySheet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ClassPathResource classPathResource = new ClassPathResource("template/报销.xlsx");
        TemplateExportParams params = new TemplateExportParams(classPathResource.getPath());
        //第一个excel的第一个sheet模版数据写入
        HashMap<String, Object> map = getStringObjectHashMap();
        Workbook workbook = ExcelExportUtil.exportExcel(params, map);
        //创建一个sheet
        Sheet sheet = workbook.createSheet();
        //第二个excel模版数据写入
        HashMap<String, Object> mapNew = getStringObjectHashMap();
        Workbook workbookNew = ExcelExportUtil.exportExcel(params, mapNew);
        //将第二个excel的sheet拷贝到第一个excel新建的sheet里面去
        XSSFSheetCopyUtil.copySheets((XSSFSheet) sheet, (XSSFSheet) workbookNew.getSheetAt(0));
        //输出
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        workbook.write(byteArrayOutputStream);
        Resource resource = new ByteArrayResource(byteArrayOutputStream.toByteArray());

        /*
         * 构造响应的头
         */
        HttpHeaders headers = new HttpHeaders();
        // 下载之后需要在请求头中放置文件名，该文件名按照ISO_8859_1编码。
        String filenames = new String("报销.xlsx".getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1);
        headers.setContentDispositionFormData("attachment", filenames);
        headers.setContentType(MediaType.parseMediaType(MediaType.APPLICATION_OCTET_STREAM_VALUE));
        /*
         * 返还资源
         */
        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(resource.getInputStream().available())
                .body(resource);
    }

    /**
     * 数据写入到excel模版里面
     *
     * @return
     */
    private HashMap<String, Object> getStringObjectHashMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("reimburseUserName", "张三");
        map.put("reimburseTime", "2020年1月");
        map.put("reimburseAllMoney", "520");
        map.put("approver", "李四");
        map.put("depart", "软件开发部门");
        List<Map<String, Object>> listMap = new ArrayList<>();
        for (int i = 1; i < 3; i++) {
            Map<String, Object> lm = new HashMap<>();
            lm.put("reimburseNumber", i);
            lm.put("reimburseTime", "2020-01-15");
            lm.put("reimburseMoney", "460");
            lm.put("reimburseType", "餐补");
            lm.put("invoiceType", "电子发票");
            lm.put("invoiceName", "2#餐补抵扣发票");
            lm.put("custom", "xxx有限公司");
            lm.put("projectName", "xxx管理项目");
            lm.put("remark", "会客发票");
            listMap.add(lm);
        }
        map.put("maplist", listMap);
        return map;
    }
}
