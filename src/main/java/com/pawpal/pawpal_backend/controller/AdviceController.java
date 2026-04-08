package com.pawpal.pawpal_backend.controller;

import com.pawpal.pawpal_backend.dto.AdviceRequest;
import com.pawpal.pawpal_backend.dto.AdviceResponse;
import com.pawpal.pawpal_backend.model.ScanHistory;
import com.pawpal.pawpal_backend.repository.ScanHistoryRepository;
import com.pawpal.pawpal_backend.service.AdviceService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/advice")
@CrossOrigin
public class AdviceController {

    private final AdviceService adviceService;
    private final ScanHistoryRepository scanHistoryRepository;

    public AdviceController(AdviceService adviceService, ScanHistoryRepository scanHistoryRepository) {
        this.adviceService = adviceService;
        this.scanHistoryRepository = scanHistoryRepository;
    }

    @PostMapping
    public AdviceResponse getAdvice(@RequestBody AdviceRequest request) {
        AdviceResponse advice = adviceService.generateAdvice(request);

        ScanHistory history;

        //checks if user already has history that can be updated or if a new one needs to be created
        if (request.getHistoryId() != null) {
            history = scanHistoryRepository.findById(request.getHistoryId())
                    .orElseThrow(() -> new RuntimeException("History record not found"));
        } else {
            history = new ScanHistory(
                    request.getUserEmail(),
                    request.getPetId(),
                    request.getPetName(),
                    request.getPetType(),
                    advice.getLabel(),
                    advice.getUrgency(),
                    advice.getSummary()
            );
        }
        
        //updates history
        history.setUserEmail(request.getUserEmail());
        history.setPetId(request.getPetId());
        history.setPetName(request.getPetName());
        history.setPetType(request.getPetType());
        history.setLabel(advice.getLabel());
        history.setUrgency(advice.getUrgency());
        history.setSummary(advice.getSummary());

        //sets time of when history was created
        if (history.getCreatedAt() == null) {
            history.setCreatedAt(LocalDateTime.now());
        }

        //saves history object to the database
        ScanHistory savedHistory = scanHistoryRepository.save(history);
        advice.setHistoryId(savedHistory.getId());

        return advice;
    }

    //returns entire history record for a specific user
    @GetMapping("/history/{email}")
    public List<ScanHistory> getHistory(@PathVariable String email) {
        return scanHistoryRepository.findByUserEmailOrderByCreatedAtDesc(email);
    }
}