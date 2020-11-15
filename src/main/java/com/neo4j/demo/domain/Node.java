package com.neo4j.demo.domain;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Node {
    private Long id;
    private String name;
    private final boolean extend = false;
    private final boolean selected = true;
    private final int degree = 0;
    @JsonAlias(value = "style")
    private Style style;
}
