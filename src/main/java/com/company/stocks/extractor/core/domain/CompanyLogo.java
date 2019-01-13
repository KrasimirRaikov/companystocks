package com.company.stocks.extractor.core.domain;

public class CompanyLogo {
    private String url;

    public CompanyLogo(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
