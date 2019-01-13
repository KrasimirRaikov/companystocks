package com.company.stocks.extractor.rest;

import com.company.stocks.extractor.core.CompanyListService;
import com.company.stocks.extractor.rest.dto.CompanyDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
public class CompanyListController {
    private String successfullStorageMessage = "Successfully stored company";
    private String successfullDeletionMessage = "Successfully removed company";
    private CompanyListService companyListService;

    @Autowired
    public CompanyListController(CompanyListService companyListService) {
        this.companyListService = companyListService;
    }

    @RequestMapping(value = "/companies", method = RequestMethod.POST)
    public String importCompaniesPrices(@RequestBody CompanyDto company) {
        companyListService.addCompany(company.getSymbol());
        return successfullStorageMessage;
    }

    @RequestMapping(value = "/companies/{symbol}", method = RequestMethod.DELETE)
    public String removeCompany(
                                @PathVariable("symbol") String id
                                ){
        companyListService.removeCompany(id);
        return successfullDeletionMessage;
    }
}
