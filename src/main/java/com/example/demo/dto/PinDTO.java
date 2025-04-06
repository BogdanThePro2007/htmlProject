package com.example.demo.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Builder
@Data
@ToString
public class PinDTO {
    private Long id;
    private String pinUrl;
    private String name;
    private double axisX;
    private double axisY;
    private String type;
    private String description;
    private String imageUrl;
    private boolean isMarked;
    private Long userId;
}
