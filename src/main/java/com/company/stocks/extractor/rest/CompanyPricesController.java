package com.company.stocks.extractor.rest;

import com.company.stocks.extractor.core.CompanyPricesService;
import com.company.stocks.extractor.core.domain.CompanyInfoPrices;
import com.company.stocks.extractor.rest.dto.CompanyPricesDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CompanyPricesController {
    private CompanyPricesService companyPricesService;

    @Autowired
    public CompanyPricesController(CompanyPricesService companyPricesService) {
        this.companyPricesService = companyPricesService;
    }

    @RequestMapping(value = "/companies/{symbol}/prices", method = RequestMethod.GET)
    public List<CompanyPricesDto> importCompaniesPrices(@PathVariable("symbol") String id) {
        List<CompanyInfoPrices> companyPrices = companyPricesService.getCompaniesPrices();
        return mapToDtos(companyPrices);

    }

    private List<CompanyPricesDto> mapToDtos(List<CompanyInfoPrices> companyPrices) {
        List<CompanyPricesDto> companyPricesDtos = new ArrayList<>();
        for(CompanyInfoPrices companyInfoPrices: companyPrices){
            companyPricesDtos.add(mapToDto(companyInfoPrices));
        }
        return companyPricesDtos;
    }

    private CompanyPricesDto mapToDto(CompanyInfoPrices companyInfoPrices) {
        CompanyPricesDto companyPricesDto = new CompanyPricesDto();
        companyPricesDto.setId(companyInfoPrices.getId());
        companyPricesDto.setName(companyInfoPrices.getName());
        companyPricesDto.setLogoUrl(companyInfoPrices.getLogoUrl());
        companyPricesDto.setPrices(companyInfoPrices.getPrices());
        return companyPricesDto;
    }
}
