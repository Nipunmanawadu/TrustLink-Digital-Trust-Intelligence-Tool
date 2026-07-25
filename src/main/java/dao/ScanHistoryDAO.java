package dao;


import database.DatabaseConnection;
import model.ScanHistory;

import java.sql.*;
import java.util.ArrayList;


public class ScanHistoryDAO {


    public void saveScan(ScanHistory scan) {


        String sql =
        "INSERT INTO scan_history(input_value,trust_score,status) VALUES(?,?,?)";


        try {


            Connection con =
                    DatabaseConnection.getConnection();


            PreparedStatement ps =
                    con.prepareStatement(sql);



            ps.setString(
                    1,
                    scan.getInputValue()
            );


            ps.setInt(
                    2,
                    scan.getTrustScore()
            );


            ps.setString(
                    3,
                    scan.getStatus()
            );


            ps.executeUpdate();


            System.out.println(
                    "Scan saved successfully!"
            );


            ps.close();

            con.close();



        } catch(Exception e) {


            e.printStackTrace();

        }

    }



    public ArrayList<ScanHistory> getAllScans() {


        ArrayList<ScanHistory> list =
                new ArrayList<>();


        try {


            Connection con =
                    DatabaseConnection.getConnection();



            String sql =
            "SELECT * FROM scan_history ORDER BY scan_time DESC";



            PreparedStatement ps =
                    con.prepareStatement(sql);



            ResultSet rs =
                    ps.executeQuery();



            while(rs.next()) {


                ScanHistory scan =
                        new ScanHistory(

                        rs.getString("input_value"),

                        rs.getInt("trust_score"),

                        rs.getString("status")

                        );


                list.add(scan);


            }



        } catch(Exception e) {


            e.printStackTrace();

        }



        return list;

    }

}