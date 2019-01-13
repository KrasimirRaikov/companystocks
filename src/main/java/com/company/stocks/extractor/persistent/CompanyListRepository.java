package com.company.stocks.extractor.persistent;

import com.company.stocks.extractor.core.domain.Company;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CompanyListRepository {
    private Map<String, Company> companyFakeStorage;

    public CompanyListRepository() {
        this.companyFakeStorage = new HashMap<>();
    }

    public List<Company> getCompanyList(){
        return companyFakeStorage.values().stream().filter(company -> !company.isDeleted()).collect(Collectors.toList());
    }

    public void storeCompany(Company company) {
        companyFakeStorage.put(company.getId(), company);
    }

    public void removeCompany(String companyId) {
        if (companyFakeStorage.containsKey(companyId)) {
            Company company = companyFakeStorage.get(companyId);
            company.setDeleted(true);
            companyFakeStorage.put(companyId, company);
        }
    }
}
