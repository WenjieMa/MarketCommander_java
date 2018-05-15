package com.dao;

import com.pojo.HomeAnnouncement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IHomeAnnouncementDAO extends JpaRepository<HomeAnnouncement, Long> {
}