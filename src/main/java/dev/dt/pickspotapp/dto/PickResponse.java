package dev.dt.pickspotapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PickResponse {
    private String containerId;
    private int targetX;
    private int targetY;
}
