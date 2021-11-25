package com.ec.final_project.Repositories;

import com.ec.final_project.Beans.thongtintk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface thongtintkRepository extends JpaRepository<thongtintk,Integer> {
}
