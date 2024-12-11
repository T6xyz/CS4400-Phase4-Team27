package com.objects;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class View6 {
    private String id;
    private String longName;
    private String homeBase;
    private String manager;
    private Long revenue;
    private Long productsCarried;
    private Long costCarried;
    private Long weightCarried;

    public View6(String id, String longName, String homeBase, String manager, Long revenue, Long productsCarried,
    Long costCarried, Long weightCarried) {
        this.id = id;
        this.longName = longName;
        this.homeBase = homeBase;
        this.manager = manager;
        this.revenue = revenue;
        this.productsCarried = productsCarried;
        this.costCarried = costCarried;
        this.weightCarried = weightCarried;
    }
}