package com.dao.JPAInterface;

import com.pojo.OrderSmall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface IOrderSmallDAO extends JpaRepository<OrderSmall, Long> ,JpaSpecificationExecutor<OrderSmall> {

    List<OrderSmall> findBySumid(Long sumid);

    @Query(value = "select avg(r.itemstar) as star from order_small r where r.itemid=?1",nativeQuery = true)
    List<Map<String,Object>> avgByItemid(Long itemid);
}