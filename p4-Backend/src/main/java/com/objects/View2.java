package com.objects;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class View2 {
    private String username;
    private String taxID;
    private Long salary;
    private String hired;
    private Long employeeExperience;
    private String licenseID;
    private Long drivingExperience;
    private String managerStatus;

    public View2(String username, String taxID, Long salary, String hired,
    Long employeeExperience, String licenseID, Long drivingExperience, String managerStatus) {
        this.username = username;
        this.taxID = taxID;
        this.salary = salary;
        this.hired = hired;
        this.employeeExperience = employeeExperience;
        this.licenseID = licenseID;
        this.drivingExperience = drivingExperience;
        this.managerStatus = managerStatus;
    }
}