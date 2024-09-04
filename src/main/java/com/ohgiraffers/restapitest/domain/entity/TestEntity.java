package com.ohgiraffers.restapitest.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Post")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class TestEntity {
// 데이터 베이스의 실제 컬럼 이름과 일치하고, 소문자로 사용하기 위해 컬럼명을 고쳤습니다!
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private int postId;

    @Column(name = "title")
    private String Title;

    @Column(name = "content")
    private String Content;
}
