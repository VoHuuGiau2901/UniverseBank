package com.ec.final_project.Beans;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class lichsustonk {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int laisuat;

    private int stonk;

    private Date ngaystonk;

    private int saving_account_id;

    @ManyToOne
    private taikhoan_tietkiem saving_Acc;
}
