package com.company.stocks.extractor.rest.dto;

public class CompanyDto {
    private String symbol;

    public CompanyDto(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
