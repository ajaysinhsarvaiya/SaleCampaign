package com.example.SaleCampaign.Repository;


import com.example.SaleCampaign.Model.History;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface HistoryRepository extends JpaRepository<History,Integer>{

    @Query(value = "select * from history where product_pid=?1 and date=?2",nativeQuery = true)
    History getOldHistory(@Param("product_pid")int pid, @Param("date")LocalDate date);
}
