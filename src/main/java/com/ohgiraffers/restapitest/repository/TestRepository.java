package com.ohgiraffers.restapitest.repository;

import com.ohgiraffers.restapitest.domain.entity.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TestRepository extends JpaRepository<TestEntity,Integer> {

}
