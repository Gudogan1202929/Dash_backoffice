package com.asd.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RolesAndWhatAllowedModel {

    private String role;

    private List<String> paths = new ArrayList<>();
    public RolesAndWhatAllowedModel(String role) {
        this.role = role;
    }
}
