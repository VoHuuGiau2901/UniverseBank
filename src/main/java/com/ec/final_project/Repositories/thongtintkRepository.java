package com.ec.final_project.Repositories;

import com.ec.final_project.Beans.thongtintk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface thongtintkRepository extends JpaRepository<thongtintk,Integer> {

    @Query("SELECT tk FROM thongtintk tk WHERE tk.taikhoan = :taikhoan")
    thongtintk checktaikhoanExists(@Param("taikhoan") String taikhoan);

//    @Query("SELECT tk FROM thongtintk tk WHERE tk.taikhoan = :taikhoan AND tk.matkhau = :matkhau")
//    thongtintk findBytaikhoanANDmatkhau(@Param("taikhoan") String taikhoan,@Param("matkhau") String matkhau);
}
