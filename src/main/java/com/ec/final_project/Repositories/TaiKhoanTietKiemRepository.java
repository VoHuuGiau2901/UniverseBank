package com.ec.final_project.Repositories;

import com.ec.final_project.Beans.TaiKhoanTietKiem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaiKhoanTietKiemRepository extends JpaRepository<TaiKhoanTietKiem,Integer> {
    @Query("SELECT tk from TaiKhoanTietKiem tk where tk.Acc_id=:Acc_id")
    List<TaiKhoanTietKiem> getAllByAcc_id(@Param("Acc_id") int id);
}
