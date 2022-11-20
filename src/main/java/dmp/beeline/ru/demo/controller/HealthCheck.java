package dmp.beeline.ru.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/health")
public class HealthCheck {
    @GetMapping
    public ResponseEntity<Map<String, String>> checkHealth() {
        Map<String, String> map = new HashMap<>();
        map.put("status", "ok");
        return ResponseEntity.ok(map);
    }
}
