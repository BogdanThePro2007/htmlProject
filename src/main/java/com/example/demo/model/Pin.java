package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Pin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "pinUrl")
    private String pinUrl;

    @Column(name = "name")
    private String name;

    @Column(name = "axisX")
    private double axisX;

    @Column(name = "axisY")
    private double axisY;

    @Column(name = "type")
    private String type;

    @Column(name = "description")
    private String description;

    @Column(name = "imageUrl")
    private String imageUrl;

    @Column(name = "isMarked")
    private boolean isMarked;

    @Column(name = "userId")
    private Long userId;
}
