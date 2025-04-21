package dev.dt.pickspotapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Container {
    private String id;
    private String size; // Size could be : "small" or "big"
    private boolean needsCold;
    private int x;
    private int y;


}