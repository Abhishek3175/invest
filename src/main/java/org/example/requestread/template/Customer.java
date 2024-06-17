package org.example.requestread.template;

import java.util.List;

public class Customer {
    private String name;
    private List<Security> security;

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Security> getSecurity() {
        return security;
    }

    public void setSecurity(List<Security> security) {
        this.security = security;
    }
}

