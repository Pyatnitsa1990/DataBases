package org.example.homework17.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class Question {

    private int id;
    private String text;
    private LocalDateTime updateAt;
}
