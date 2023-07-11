package org.example.homework17.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;


@Builder
@Data
public class Topic {
    private int id;
    private String name;
    private int rating;
    private LocalDateTime updateAt;
}

