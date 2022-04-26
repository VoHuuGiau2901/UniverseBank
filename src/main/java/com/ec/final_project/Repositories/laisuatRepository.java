package com.ec.final_project.Repositories;

import com.ec.final_project.Beans.laisuat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface laisuatRepository extends JpaRepository<laisuat, String> {

    @Modifying
    @Query(value = "update laisuat ls set ls.LaiSuat=:laisuat where ls.KyHan=:kyhan", nativeQuery = true)
    @Transactional
    void Update(@Param("laisuat") float l, @Param("kyhan") String k);
}
