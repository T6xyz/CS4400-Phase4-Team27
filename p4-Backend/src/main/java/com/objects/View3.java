package com.objects;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class View3 {
    private String username;
    private String licenseID;
    private Long driverExperience;
    private Long numVan;

    public View3(String username, String licenseID, Long driverExperience, Long numVan) {
        this.username = username;
        this.licenseID = licenseID;
        this.driverExperience = driverExperience;
        this.numVan = numVan;
    }
}