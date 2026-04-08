package com.pawpal.pawpal_backend.dto;

import java.util.List;
import java.util.Map;

//stores the prediction response from the ML service
public class MlPredictionResponse {
    public String label;
    public double confidence;
    public List<Map<String, Object>> top3;
    public Map<String, Object> quality;
}
