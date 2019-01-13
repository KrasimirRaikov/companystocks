package com.company.stocks.extractor.core;

import com.company.stocks.extractor.core.domain.Company;
import com.company.stocks.extractor.core.domain.CompanyInfoPrices;
import com.company.stocks.extractor.core.domain.CompanyPrices;
import com.company.stocks.extractor.persistent.CompanyListRepository;
import com.company.stocks.extractor.persistent.CompanyPricesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyPricesService {

    private CompanyListRepository companyListRepository;
    private CompanyInformationExtractor companyInformationExtractor;
    private CompanyPricesRepository companyPricesRepository;

    @Autowired
    public CompanyPricesService(CompanyListRepository companyListRepository,
                                CompanyInformationExtractor companyInformationExtractor,
                                CompanyPricesRepository companyPricesRepository) {
        this.companyListRepository = companyListRepository;
        this.companyInformationExtractor = companyInformationExtractor;
        this.companyPricesRepository = companyPricesRepository;
    }

    public void importCompaniesPrices(){
        List<String> companyIds = companyListRepository.getCompanyList().stream().map(Company::getId).collect(Collectors.toList());
        for(String company: companyIds){
            Double companyPrice = companyInformationExtractor.extractCompanyPrice(company);
            companyPricesRepository.storePrice(company, companyPrice);
        }
    }

    public List<CompanyInfoPrices> getCompaniesPrices() {
        List<Company> companies = companyListRepository.getCompanyList();
        List<CompanyInfoPrices> result = new ArrayList<>();
        for(Company company: companies){
            CompanyPrices companyPrices = companyPricesRepository.getCompanyPrices(company.getId());

            CompanyInfoPrices companyInfoPrices = new CompanyInfoPrices();
            companyInfoPrices.setId(company.getId());
            companyInfoPrices.setName(company.getName());
            companyInfoPrices.setLogoUrl(company.getLogoUrl());
            companyInfoPrices.setPrices(companyPrices.getPrices());

            result.add(companyInfoPrices);
        }
        return result;
    }
}
