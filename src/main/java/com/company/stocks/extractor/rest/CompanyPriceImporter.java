package com.company.stocks.extractor.rest;

import com.company.stocks.extractor.core.CompanyPricesService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompanyPriceImporter {

    private CompanyPricesService companyPricesService;
    private String successMessage = "Companies prices imported";

    @RequestMapping(value = "/companies/prices/import", method = RequestMethod.GET)
    public String importCompaniesPrices() {
        companyPricesService.importCompaniesPrices();
        return successMessage;
    }

}
