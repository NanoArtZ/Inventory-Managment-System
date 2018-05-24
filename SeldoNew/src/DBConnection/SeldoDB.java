/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Nano ArtZ
 */
public class SeldoDB {
    private static Connection c;

    public static Connection GetMyConnection() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        c = DriverManager.getConnection("jdbc:mysql://127.0.1.1:3306/seldo?useseldo=true&characterEncoding=UTF-8", "root", "123");
        return c;
    }
}
