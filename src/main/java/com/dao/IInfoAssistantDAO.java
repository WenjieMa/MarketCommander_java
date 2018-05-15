package com.dao;

import com.pojo.InfoAssistant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IInfoAssistantDAO extends JpaRepository<InfoAssistant, Long> {
}