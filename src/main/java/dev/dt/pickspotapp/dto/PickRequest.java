package dev.dt.pickspotapp.dto;

import dev.dt.pickspotapp.model.Container;
import dev.dt.pickspotapp.model.Slot;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PickRequest {
    private Container container;
    private List<Slot> yardMap;
}