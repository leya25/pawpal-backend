package com.pawpal.pawpal_backend.dto;

import java.util.List;

//information that goes back to the frontend after prediction
public class AdviceResponse {
    private String label;
    private String urgency;
    private String summary;
    private List<String> possibleCauses;
    private List<String> safeHomeCare;
    private List<String> goToVetIf;
    private String disclaimer;
    private Long historyId;

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

    public List<String> getPossibleCauses() {
        return possibleCauses;
    }

    public void setPossibleCauses(List<String> possibleCauses) {
        this.possibleCauses = possibleCauses;
    }

    public List<String> getSafeHomeCare() {
        return safeHomeCare;
    }

    public void setSafeHomeCare(List<String> safeHomeCare) {
        this.safeHomeCare = safeHomeCare;
    }

    public List<String> getGoToVetIf() {
        return goToVetIf;
    }

    public void setGoToVetIf(List<String> goToVetIf) {
        this.goToVetIf = goToVetIf;
    }

    public String getDisclaimer() {
        return disclaimer;
    }

    public void setDisclaimer(String disclaimer) {
        this.disclaimer = disclaimer;
    }

    public Long getHistoryId() {
        return historyId;
    }

    public void setHistoryId(Long historyId) {
        this.historyId = historyId;
    }
}