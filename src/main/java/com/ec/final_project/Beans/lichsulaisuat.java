package com.ec.final_project.Beans;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class lichsulaisuat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int laisuatcu;

    private Date ngayhethan;

    private int kyhan;

    @ManyToOne
    private laisuat ls;
}
