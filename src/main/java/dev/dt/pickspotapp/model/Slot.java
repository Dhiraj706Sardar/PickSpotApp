package dev.dt.pickspotapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Slot {

    private int x;
    private int y;
    // Size can represents the size of slot which could be "small" or "big"
    private String sizeCap;
    private boolean hasColdUnit;
    private boolean occupied;
}
