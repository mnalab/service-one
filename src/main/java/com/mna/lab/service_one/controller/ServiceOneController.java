package com.mna.lab.service_one.controller;

import com.mna.lab.service_one.config.ConfigProperties;
import com.mna.lab.service_one.dto.DataBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ServiceOneController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    ConfigProperties configProperties;

    @RequestMapping("/")
    public String HelloServiceOne(){
        return "Hello Service from ServiceOne \n";
    }

    @RequestMapping("/data")
    public String DataServiceOne(){

        return "Data Service from ServiceOne \n";
    }

    @RequestMapping("/data/service-b")
    public DataBean getSvcBData(){
        //   http://service-b:8080/userdata
        String serviceAUrl = "http://" +
                configProperties.getHost() +
                ":" +
                configProperties.getPort() +
                "/userdata";
        DataBean dataBean = restTemplate.getForObject(serviceAUrl, DataBean.class);
        return dataBean;
    }

}
