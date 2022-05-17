package com.ec.final_project.Repositories;

import com.ec.final_project.Entity.admin;
import com.ec.final_project.Entity.useraccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface adminRepository extends JpaRepository<admin, Integer> {
    @Query(value = "SELECT * from admin where admin_account=:adminAccount and admin_password=:adminPassword", nativeQuery = true)
    admin validate(@Param("adminAccount") String adminAccount, @Param("adminPassword") String adminPassword);
}
