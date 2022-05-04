package com.ec.final_project.Repositories;

import com.ec.final_project.Beans.laisuat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface laisuatRepository extends JpaRepository<laisuat, String> {

    @Modifying
    @Query(value = "update laisuat ls set ls.LaiSuat=:laisuat where ls.KyHan=:kyhan", nativeQuery = true)
    @Transactional
    void Update(@Param("laisuat") double l, @Param("kyhan") String k);

    @Modifying
    @Query(value = "insert into laisuat values (:kyhan,:laisuat)", nativeQuery = true)
    @Transactional
    void Insert_First(@Param("laisuat") double l, @Param("kyhan") String k);
}
