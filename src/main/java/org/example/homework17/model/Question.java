package org.example.homework17.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Question {

    private int id;
    private String text;
    private int topic_id;
}
