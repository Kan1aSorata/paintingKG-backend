package com.neo4j.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Style {
    private String image;
    private final boolean hide = false;
    private final int r = 30;
}
