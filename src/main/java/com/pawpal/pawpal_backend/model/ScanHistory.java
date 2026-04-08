package com.pawpal.pawpal_backend.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "scan_history")

public class ScanHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    //user and pet details
    private String userEmail;
    private Long petId;

    private String petName;
    private String petType;

    //prediction result and summary
    private String label;
    private String urgency;

    @Column(length = 1000)
    private String summary;

    //timestamp of when the history record was created
    private LocalDateTime createdAt;

    public ScanHistory() {
    }

    public ScanHistory(
            String userEmail,
            Long petId,
            String petName,
            String petType,
            String label,
            String urgency,
            String summary
    ) {
        this.userEmail = userEmail;
        this.petId = petId;
        this.petName = petName;
        this.petType = petType;
        this.label = label;
        this.urgency = urgency;
        this.summary = summary;
        this.createdAt = LocalDateTime.now();
    }
    
    //getters and setters
    public Long getId() {
        return id;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Long getPetId() {
        return petId;
    }

    public void setPetId(Long petId) {
        this.petId = petId;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getPetType() {
        return petType;
    }

    public void setPetType(String petType) {
        this.petType = petType;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getUrgency() {
        return urgency;
    }

    public void setUrgency(String urgency) {
        this.urgency = urgency;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}