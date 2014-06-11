package uz.micros.jstore.util;


import uz.micros.jstore.entity.blog.Post;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DbManager {
    private static Connection connect() {
        System.out.println("JDBC Connection Test");
        Connection res = null;

        try {
            //Class.forName("org.postgresql.Driver");
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            res = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/jstore",
                    "root", "root"
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return res;
    }

    public static List<Map<String, Object>> runQuery(String query) {
        Connection conn = connect();

        List<Map<String, Object>> list = new ArrayList<>();

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);


            list = parseList2(rs);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;

    }

    /*private static List<Post> parseList(ResultSet rs) throws SQLException {

        List<Post> list = new ArrayList<>();

        while (rs.next()) {
            Post p = new Post();
            p.setId(rs.getInt(1));
            p.setSubject(rs.getString(2));
            p.setDate(rs.getDate(3));
            p.setText(rs.getString(4));


            list.add(p);

        }
        return list;
    }*/

    private static List<Map<String, Object>> parseList2(ResultSet rs) throws SQLException {

        List<Map<String,Object>> res = new ArrayList<>();
        ResultSetMetaData meta = rs.getMetaData();

        int cols = meta.getColumnCount();

        while (rs.next()) {
            Map<String, Object> columns = new LinkedHashMap<>();
            for (int i = 1; i <= cols; i++)
                columns.put(meta.getColumnLabel(i),rs.getObject(i));

            res.add(columns);
        }
        return res;
    }

}

