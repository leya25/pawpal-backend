package com.pawpal.pawpal_backend.dto;

public class AdviceRequest {
    private String label;

    //user and pet information
    private String userEmail;
    private String userId;
    private Long petId;
    private String petName;
    private String petType;
    private Long historyId;

    //follow-up questions information for rash
    private boolean scratching;
    private boolean spreading;
    private boolean bloodOrPus;
    private boolean petUnwell;
    private boolean lastingDays;

    //follow-up questions information for rash
    private boolean bleeding;
    private boolean deep;
    private boolean biteOrAnimalCause;
    private boolean painOrLimping;
    private boolean swellingOrSmell;

    //getters and setters
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public boolean isScratching() {
        return scratching;
    }

    public void setScratching(boolean scratching) {
        this.scratching = scratching;
    }

    public boolean isSpreading() {
        return spreading;
    }

    public void setSpreading(boolean spreading) {
        this.spreading = spreading;
    }

    public boolean isBloodOrPus() {
        return bloodOrPus;
    }

    public void setBloodOrPus(boolean bloodOrPus) {
        this.bloodOrPus = bloodOrPus;
    }

    public boolean isPetUnwell() {
        return petUnwell;
    }

    public void setPetUnwell(boolean petUnwell) {
        this.petUnwell = petUnwell;
    }

    public boolean isLastingDays() {
        return lastingDays;
    }

    public void setLastingDays(boolean lastingDays) {
        this.lastingDays = lastingDays;
    }

    public boolean isBleeding() {
        return bleeding;
    }

    public void setBleeding(boolean bleeding) {
        this.bleeding = bleeding;
    }

    public boolean isDeep() {
        return deep;
    }

    public void setDeep(boolean deep) {
        this.deep = deep;
    }

    public boolean isBiteOrAnimalCause() {
        return biteOrAnimalCause;
    }

    public void setBiteOrAnimalCause(boolean biteOrAnimalCause) {
        this.biteOrAnimalCause = biteOrAnimalCause;
    }

    public boolean isPainOrLimping() {
        return painOrLimping;
    }

    public void setPainOrLimping(boolean painOrLimping) {
        this.painOrLimping = painOrLimping;
    }

    public boolean isSwellingOrSmell() {
        return swellingOrSmell;
    }

    public void setSwellingOrSmell(boolean swellingOrSmell) {
        this.swellingOrSmell = swellingOrSmell;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public Long getHistoryId() {
        return historyId;
    }

    public void setHistoryId(Long historyId) {
        this.historyId = historyId;
    }
}