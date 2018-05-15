package com.dao;

import com.pojo.InfoQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IInfoQuestionDAO extends JpaRepository<InfoQuestion, Long> {
}