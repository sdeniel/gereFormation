/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gereformation;

import java.sql.*;

// Etablit la connection à la base de données
public class JDBCConnect {

    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;

    public JDBCConnect() throws SQLException {
        try {
            connection = DriverManager.getConnection(Config.connection_url, Config.DATABASE_USER_ID, Config.DATABASE_PASSWORD);

        } catch (SQLException ex) {
            System.out.println("Erreur relevée : " + ex.getMessage());
        }
    }

    // Retourne la connection
    public Connection getConnection() {
        return connection;
    }

    // Permet de créer le statement
    public void ExecuteSQLStatement(String sql_stmt) {
        try {
            statement = connection.createStatement();

            statement.executeUpdate(sql_stmt);
        } catch (SQLException ex) {
            System.out.println("Erreur relevée : " + ex.getMessage());
        }
    }
}
