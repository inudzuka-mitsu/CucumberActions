package com.testproject.cucumber;

import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {

    public Map<String, Object> scenarioContext = new HashMap<>();
    public DriverManager driverManager;

    public void setAttribute(String key, Object value) {
        if (isContains(key)) {
            scenarioContext.remove(key);
        }
        scenarioContext.put(key, value);
    }

    public Boolean isContains(String key) {
        return scenarioContext.containsKey(key);
    }

    public Object getAttribute(String key) {
        return scenarioContext.get(key);
    }
}
