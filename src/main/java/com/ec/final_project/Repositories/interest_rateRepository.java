package com.ec.final_project.Repositories;

import com.ec.final_project.Entity.interest_rate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface interest_rateRepository extends JpaRepository<interest_rate, String> {

    @Modifying
    @Query(value = "update interest_rate ls set ls.interest_rate=:interest_rate where ls.period=:period", nativeQuery = true)
    @Transactional
    void Update(@Param("interest_rate") double interest_rate, @Param("period") String period);

    @Modifying
    @Query(value = "insert into interest_rate values (:interest_rate,:period)", nativeQuery = true)
    @Transactional
    void Insert_First(@Param("interest_rate") double interest_rate, @Param("period") String period);
}
