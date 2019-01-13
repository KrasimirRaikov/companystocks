package com.company.stocks.extractor.core;

import com.company.stocks.extractor.core.domain.CompanyInfo;
import com.company.stocks.extractor.core.domain.CompanyLogo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class CompanyInformationExtractor {

    private String STOCK_ENDPOINT = "https://api.iextrading.com/1.0/stock/";
    private String PRICE_SUFFIX = "/price";
    private String LOGO_SUFFIX = "/logo";
    private String COMPANY_SUFFIX = "/company";
    private RestTemplate restTemplate;

    @Autowired
    public CompanyInformationExtractor() {
        this.restTemplate = new RestTemplate();
    }

    public Double extractCompanyPrice(String companyId){
        return restTemplate.getForObject(STOCK_ENDPOINT+companyId+PRICE_SUFFIX, Double.class);
    }

    public CompanyLogo extractCompanyLogo(String companyId){
        return restTemplate.getForObject(STOCK_ENDPOINT+companyId+LOGO_SUFFIX, CompanyLogo.class);
    }

    public CompanyInfo extractCompanyDetails(String companyId){
        return restTemplate.getForObject(STOCK_ENDPOINT+companyId+COMPANY_SUFFIX, CompanyInfo.class);
    }
}
