package com.example.cicd.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
public class HomeController {

    @Value("${app.version:1.0.0}")
    private String appVersion;

    @GetMapping("/")
    public Map<String, Object> home(){
        Map<String, Object>  response = new HashMap<>();
        response.put("message", "Hello from Spring Boot on Azure!");
        response.put("version", appVersion);
        response.put("timeStamp", LocalDateTime.now());
        response.put("status", "running");
        return response;
    }

    @GetMapping("/api/health")
    public Map<String, String> health(){
        Map<String, String> status = new HashMap<>();
        status.put("status", "UP");
        status.put("service", "Spring Boot App");
        return status;
    }

    @GetMapping("/api/info")
    public Map<String, String> info(){
        Map<String, String> info = new HashMap<>();
        info.put("app", "Spring Boot App");
        info.put("version", appVersion);
        info.put("java.version", System.getProperty("java.version"));
        info.put("os.name", System.getProperty("os.name"));
        info.put("deployed.on", "Azure App Serviec");

        return info;
    }
}
