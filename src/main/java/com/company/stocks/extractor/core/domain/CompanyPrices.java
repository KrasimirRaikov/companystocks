package com.company.stocks.extractor.core.domain;

import java.util.List;

public class CompanyPrices {
    private String id;
    private List<Double> prices;

    public CompanyPrices(String id, List<Double> prices) {
        this.id = id;
        this.prices = prices;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Double> getPrices() {
        return prices;
    }

    public void setPrices(List<Double> prices) {
        this.prices = prices;
    }
}
