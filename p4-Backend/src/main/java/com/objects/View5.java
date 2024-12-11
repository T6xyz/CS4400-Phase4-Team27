package com.objects;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class View5 {
    private String productName;
    private String location;
    private Long amountAvailable;
    private Long lowPrice;
    private Long highPrice;

    public View5(String productName, String location, Long amountAvailable,
    Long lowPrice, Long highPrice) {
        this.productName = productName;
        this.location = location;
        this.amountAvailable = amountAvailable;
        this.lowPrice = lowPrice;
        this.highPrice = highPrice;
    }
}