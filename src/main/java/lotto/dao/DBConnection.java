package lotto.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    static {
        loadDriver();
    }

    private static void loadDriver() {
        // 드라이버 로딩
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println(" !! JDBC Driver load 오류: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        Connection con = null;
        String server = "127.0.0.1"; // MySQL 서버 주소
        String database = "lotto"; // MySQL DATABASE 이름
        String userName = "lotto_olaf"; //  MySQL 서버 아이디
        String password = "lotto_olaf"; // MySQL 서버 비밀번호

        // 드라이버 연결
        try {
            con = DriverManager.getConnection("jdbc:mysql://" + server + "/" + database + "?serverTimezone=UTC&allowPublicKeyRetrieval=true&useSSL=false", userName, password);
            System.out.println("정상적으로 연결되었습니다.");
        } catch (SQLException e) {
            System.err.println("연결 오류:" + e.getMessage());
            e.printStackTrace();
        }

        return con;
    }

    // 드라이버 연결해제
    public static void closeConnection(Connection con) {
        try {
            if (con != null)
                con.close();
        } catch (SQLException e) {
            System.err.println("con 오류:" + e.getMessage());
        }
    }
}
