package com.ohgiraffers.restapitest.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "post")
@Table(name = "post")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder(toBuilder = true)
@ToString
public class TestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int postId;

    @Column(name = "Title")
    private String title;

    @Column(name = "Content")
    private String content;

}
