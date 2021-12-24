package com.ec.final_project.Controllers;

import com.ec.final_project.Beans.taikhoan_tietkiem;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

public class checkModel {
    public static void check_and_update() {
        final String query = "select *from taikhoan_tietkiem where NgayDaoHan = CURDATE();";

        final String query1 = "insert into lichsustonk (id, NgayStonk, LaiSuat, Stonk, thongtintk_Acc_id)\n" +
                "select tkTK.id,\n" +
                "       tkTK.NgayDaoHan,\n" +
                "       LS.LaiSuat,\n" +
                "       tkTK.SoTien * LS.LaiSuat,\n" +
                "       tkTK.Acc_id\n" +
                "from taikhoan_tietkiem tkTK\n" +
                "         join laisuat LS on tkTK.KyHan = LS.KyHan\n" +
                "where tkTK.NgayDaoHan = CURDATE();";

        final String query2 = "update taikhoan_thanhtoan tkTT,(select sum(SoTien * LaiSuat) as sotien, Acc_id\n" +
                "                                from taikhoan_tietkiem\n" +
                "                                         join laisuat l on taikhoan_tietkiem.KyHan = l.KyHan\n" +
                "                                where NgayDaoHan = CURDATE()\n" +
                "                                group by Acc_id) as tkTK\n" +
                "set tkTT.SoTien=tkTT.SoTien + tkTK.sotien\n" +
                "where tkTT.Acc_id = tkTK.Acc_id;";

        final String query3 = "update taikhoan_thanhtoan tkTT,(select sum(SoTien) as sotien, Acc_id\n" +
                "                                from taikhoan_tietkiem\n" +
                "                                where NgayDaoHan = CURDATE()\n" +
                "                                group by Acc_id) as tkTK\n" +
                "set tkTT.SoTien=tkTT.SoTien + tkTK.sotien\n" +
                "where tkTT.Acc_id = tkTK.Acc_id;";

        final String query4 = "delete\n" +
                "from taikhoan_tietkiem tkTK\n" +
                "where tkTK.NgayDaoHan = CURDATE()\n" +
                "  and tkTK.TuyChon = 2;";

        final String query5 = "update taikhoan_tietkiem tkTK\n" +
                "set tkTK.NgayDaoHan=DATE_ADD(tkTK.NgayDaoHan, INTERVAL tkTK.KyHan month),\n" +
                "    tkTK.NgayGui= CURDATE()\n" +
                "where tkTK.NgayDaoHan = CURDATE();";

        Sql2o s = new Sql2o("jdbc:mysql://database1-ec-p207.c4pgklhrrezb.us-east-2.rds.amazonaws.com:3306/digbank", "admin", "Lamdong#090411");

        Connection connection = s.open();
        if (connection.createQuery(query).executeAndFetch(taikhoan_tietkiem.class).size() > 0) {

            Sql2o s1 = new Sql2o("jdbc:mysql://database1-ec-p207.c4pgklhrrezb.us-east-2.rds.amazonaws.com:3306/digbank", "admin", "Lamdong#090411");
            Sql2o s2 = new Sql2o("jdbc:mysql://database1-ec-p207.c4pgklhrrezb.us-east-2.rds.amazonaws.com:3306/digbank", "admin", "Lamdong#090411");
            Sql2o s3 = new Sql2o("jdbc:mysql://database1-ec-p207.c4pgklhrrezb.us-east-2.rds.amazonaws.com:3306/digbank", "admin", "Lamdong#090411");
            Sql2o s4 = new Sql2o("jdbc:mysql://database1-ec-p207.c4pgklhrrezb.us-east-2.rds.amazonaws.com:3306/digbank", "admin", "Lamdong#090411");
            Sql2o s5 = new Sql2o("jdbc:mysql://database1-ec-p207.c4pgklhrrezb.us-east-2.rds.amazonaws.com:3306/digbank", "admin", "Lamdong#090411");

            Connection connection1 = s1.open();
            Connection connection2 = s2.open();
            Connection connection3 = s3.open();
            Connection connection4 = s4.open();
            Connection connection5 = s5.open();

            connection1.createQuery(query1).executeUpdate();

            connection2.createQuery(query2).executeUpdate();

            connection3.createQuery(query3).executeUpdate();

            connection4.createQuery(query4).executeUpdate();

            connection5.createQuery(query5).executeUpdate();

            connection1.close();
            connection2.close();
            connection3.close();
            connection4.close();
            connection5.close();
        }
        connection.close();
    }
}
