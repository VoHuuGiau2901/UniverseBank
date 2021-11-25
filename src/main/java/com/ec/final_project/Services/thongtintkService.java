package com.ec.final_project.Services;

import com.ec.final_project.Beans.thongtintk;

import java.util.List;

public interface thongtintkService {
        public thongtintk kiemtratk(thongtintk tk);
        public thongtintk savethongtintk(thongtintk tk);
        public String timthongtin(thongtintk tk);
        public List<thongtintk> getalltk();
}
