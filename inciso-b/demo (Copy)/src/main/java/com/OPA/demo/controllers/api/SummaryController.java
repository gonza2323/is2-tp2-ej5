package com.OPA.demo.controllers.api;

import com.OPA.demo.services.SummaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/summary")
@RequiredArgsConstructor
@PreAuthorize("isAuthenticated()")
public class SummaryController {

    private final SummaryService summaryService;

    @GetMapping
    public ResponseEntity<Map<String, Object>> getSummary() {
        return ResponseEntity.ok(summaryService.buildSummary());
    }
}
