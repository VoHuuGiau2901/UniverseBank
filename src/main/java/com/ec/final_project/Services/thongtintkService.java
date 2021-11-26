package com.ec.final_project.Services;

import com.ec.final_project.Beans.thongtintk;

import java.util.List;
import java.util.Optional;

public interface thongtintkService {
        public thongtintk kiemtratk(thongtintk tk);
        public void savethongtintk(thongtintk tk);
        public thongtintk timthongtin(thongtintk tk);
        public List<thongtintk> getAlltk();
        public Optional<thongtintk> findbyID(int id);
}
