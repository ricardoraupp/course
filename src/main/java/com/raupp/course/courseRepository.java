package com.raupp.course;

import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface courseRepository extends JpaRepository<Course, BigInteger> {

}
