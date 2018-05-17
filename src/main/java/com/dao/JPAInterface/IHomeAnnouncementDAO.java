package com.dao.JPAInterface;

import com.pojo.HomeAnnouncement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IHomeAnnouncementDAO extends JpaRepository<HomeAnnouncement, Long> ,JpaSpecificationExecutor<HomeAnnouncement> {
}