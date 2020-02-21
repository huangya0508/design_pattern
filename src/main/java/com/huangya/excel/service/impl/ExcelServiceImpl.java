package com.huangya.excel.service.impl;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import com.huangya.excel.service.ExcelService;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author nonpool
 * @version 1.0
 * @since 2020/2/21
 */
@Service
public class ExcelServiceImpl implements ExcelService {
    @Override
    public Workbook excelTemplate(TemplateExportParams params) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("reimburseUserName", "张三");
        map.put("reimburseTime", "2020年1月");
        map.put("reimburseAllMoney", "520");
        map.put("approver", "李四");
        map.put("depart","软件开发部门");
        List<Map<String,Object>> listMap = new ArrayList<>();
        for (int i = 1; i < 3; i++) {
            Map<String, Object> lm = new HashMap<>();
            lm.put("reimburseNumber",i );
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
        map.put("maplist",listMap);
        return ExcelExportUtil.exportExcel(params, map);
    }
}
