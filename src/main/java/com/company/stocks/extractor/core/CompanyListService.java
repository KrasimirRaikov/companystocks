package com.company.stocks.extractor.core;

import com.company.stocks.extractor.core.domain.Company;
import com.company.stocks.extractor.persistent.CompanyListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyListService {
    private CompanyInformationExtractor companyInformationExtractor;
    private CompanyListRepository companyListRepository;

    @Autowired
    public CompanyListService(CompanyInformationExtractor companyInformationExtractor,
                              CompanyListRepository companyListRepository) {
        this.companyInformationExtractor = companyInformationExtractor;
        this.companyListRepository = companyListRepository;
    }

    public void addCompany(String companyId){
        String companyLogo = companyInformationExtractor.extractCompanyLogo(companyId).getUrl();
        String companyName = companyInformationExtractor.extractCompanyDetails(companyId).getCompanyName();
        Company company = new Company(companyId, companyName, companyLogo);
        company.setDeleted(false);
        companyListRepository.storeCompany(company);
    }

    public void removeCompany(String companyId){
        companyListRepository.removeCompany(companyId);
    }
}
