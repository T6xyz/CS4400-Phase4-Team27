package com.objects;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class View4 {
    private String label;
    private String resolvedLongName;
    private Long x;
    private Long y;
    private Long space;
    private Long numVans;
    private String vanIDs;
    private Long remainingCapacity;

    public View4(String label, String resolvedLongName, Long x, Long y, Long space, 
    Long numVans, String vanIDs, Long remainingCapacity) {
        this.label = label;
        this.resolvedLongName = resolvedLongName;
        this.x = x;
        this.y = y;
        this.space = space;
        this.numVans = numVans;
        this.vanIDs = vanIDs;
        this.remainingCapacity = remainingCapacity;
    }
}