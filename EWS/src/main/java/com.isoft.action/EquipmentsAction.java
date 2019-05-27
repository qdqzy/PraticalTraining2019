package com.isoft.action;

import com.isoft.service.IEquimentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/equipments")
public class EquipmentsAction {
    @Autowired
    IEquimentsService equimentsService;


    @RequestMapping("/findAllEquipments.do")
    @ResponseBody
    public Map<String, Object> findAllEuqipments(int page, int limit) {
        System.out.println(page + "," + limit);
        List<Map<String, Object>> list = equimentsService.findAllEquipments(page, limit);
        Map<String, Object> equipmentsCount = equimentsService.findEquipmentsCount();
        Map map = new HashMap();
        map.put("code", 0);
        map.put("msg", "用户信息");
        map.put("count", equipmentsCount.get("count"));//用户表中的总记录数
        map.put("data", list);
        return map;//返回JSON格式数据，但是不能转换，因为找不到JSON消息转换器

    }




    @RequestMapping("/deleteEquipmentsInfoById.do")
    @ResponseBody
    public String deleteEquipmentsInfoById(String id) {
        System.out.println(id);
        String result = "success";
        int i=0;
        try{
            String  [] arr= id.split(",");
            for (String index:arr) {
                i= equimentsService.deleteEquipmentsInfoById(Integer.parseInt(index));
                System.out.println("正在删除第"+index+"条");
            }
        }catch ( Exception e){
            i=0;
            e.printStackTrace();
        }
        if (i == 0)
            result = "fault";
        return result;//返回JSON格式数据，但是不能转换，因为找不到JSON消息转换器
    }


}