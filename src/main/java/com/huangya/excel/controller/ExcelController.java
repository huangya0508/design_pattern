package com.huangya.excel.controller;

import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import com.huangya.excel.service.ExcelService;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;

/**
 * 模版导出excel
 * @author nonpool
 * @version 1.0
 * @since 2020/2/21
 */
@RestController("excelController/")
public class ExcelController {

    @Autowired
    private ExcelService excelService;

    /**
     * 通过模版导入数据
     * @param request
     * @param response
     */
    @GetMapping("excelTemplate")
    public void excelTemplate(HttpServletRequest request, HttpServletResponse response){
        try {
            String realPath = request.getSession().getServletContext().getRealPath("/");
            TemplateExportParams params = new TemplateExportParams(realPath+"/resources/template/报销.xlsx");
            Workbook workbook = excelService.excelTemplate(params);
            response.reset();
            response.setContentType("application/octet-stream");
            response.setHeader("Content-Disposition", "attachment;filename=".concat(String.valueOf(URLEncoder.encode("报销.xlsx", "UTF-8"))));
            workbook.write(response.getOutputStream());
        }catch (Exception e){

        }
    }
}

