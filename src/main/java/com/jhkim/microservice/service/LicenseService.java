package com.jhkim.microservice.service;

import com.jhkim.microservice.model.License;
import io.micrometer.core.instrument.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Random;

@Service
public class LicenseService {

    @Autowired
    MessageSource messages;

    public License getLisence(String licenseId, String organizationId) {
        License license = new License();
        license.setId(new Random().nextInt(1000));
        license.setLicenseId(licenseId);
        license.setOrganizationId(organizationId);
        license.setDescription("Software product");
        license.setProductName("Ostock");
        license.setLicenseType("full");

        return license;
    }

    public String createLicense(License license, String organizationId, Locale locale) {
        String responseMessage = null;
        if(!StringUtils.isEmpty(String.valueOf(license))){
            license.setOrganizationId(organizationId);
            responseMessage = String.format(messages.getMessage("license.create.message",null, locale), license.toString());
        }

        return responseMessage;
    }

    public String updateLicense(License license, String organizationId) {
        String responseMessage = null;
        if(!StringUtils.isEmpty(organizationId)) {
            license.setOrganizationId(organizationId);
            responseMessage = String.format(messages.getMessage("license.update.message", null, null), license.toString());
        }

        return responseMessage;
    }

    public String deleteLicense(String licenseId, String organizationId) {
        String responseMessage = null;
        responseMessage = String.format("Deleting License with id %s for the organization %s", licenseId, organizationId);

        return responseMessage;
    }
}
