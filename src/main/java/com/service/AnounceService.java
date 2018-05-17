package com.service;

import com.dao.JPAInterface.IHomeAnnouncementDAO;
import com.dao.JPAInterface.IHomeAnnouncementDAO;
import com.dto.PageTools;
import com.pojo.HomeAnnouncement;
import com.pojo.HomeAnnouncement;
import com.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class AnounceService {
    @Autowired
    IHomeAnnouncementDAO iHomeAnnouncementDAO;

    public void insert(HomeAnnouncement homeAnnouncement) {
        iHomeAnnouncementDAO.save(homeAnnouncement);
    }

    public void update(HomeAnnouncement homeAnnouncement) {
        iHomeAnnouncementDAO.save(homeAnnouncement);

    }

    public void delete(Long id) {
        iHomeAnnouncementDAO.deleteById(id);

    }

    public Page<HomeAnnouncement> findAll(PageVo pageVo) {
        return iHomeAnnouncementDAO.findAll(PageTools.basicPage(pageVo.getPage(), pageVo.getSize()));
    }

}