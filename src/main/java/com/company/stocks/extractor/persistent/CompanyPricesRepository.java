package com.company.stocks.extractor.persistent;

import com.company.stocks.extractor.core.domain.CompanyPrices;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CompanyPricesRepository {
    private Map<String, CompanyPrices> companyPricesFakeStorage;

    public CompanyPricesRepository() {
        this.companyPricesFakeStorage = new HashMap<>();
    }

    public void storePrice(String companyId, Double price) {
        if (companyPricesFakeStorage.containsKey(companyId)) {
            CompanyPrices companyPrices = companyPricesFakeStorage.get(companyId);
            List<Double> prices = companyPrices.getPrices();
            prices.add(price);
            companyPrices.setPrices(prices);
            companyPricesFakeStorage.put(companyId, companyPrices);
        }
    }

    public CompanyPrices getCompanyPrices(String companyId) {
        return companyPricesFakeStorage.get(companyId);
    }
}
