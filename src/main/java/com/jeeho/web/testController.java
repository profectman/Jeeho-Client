package com.jeeho.web;

import com.jeeho.common.ServerResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class testController {

    @RequestMapping(value = {"/","/index"})
    public String test01(){
        return "index";
    }

    @RequestMapping(value = {"/json"})
    @ResponseBody
    public ServerResponse<Map> test02(){
        Map map = new HashMap();
        map.put("name","jihao");
        map.put("phone","11234560");
        ServerResponse serverResponse = ServerResponse.createSuccess("success", map);
        return serverResponse;
    }

}
