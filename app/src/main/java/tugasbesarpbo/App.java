package tugasbesarpbo;

import tugasbesarpbo.Database.databaseConnection;
import tugasbesarpbo.view.LoginView;

import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class App {

    public static void main(String[] args) {

        try (Connection connection = databaseConnection.getConnection()) {

            System.out.println("Koneksi PostgreSQL berhasil!");
            System.out.println("Database: " + connection.getCatalog());
            SwingUtilities.invokeLater(LoginView::new);

        } catch (SQLException e) {

           SwingUtilities.invokeLater(new Runnable() {
    @Override
    public void run() {
        JOptionPane.showMessageDialog(
            null,
            "Koneksi database gagal!\n" + e.getMessage(),
            "Database Error",
            JOptionPane.ERROR_MESSAGE
        );
    }
});
        }
    }
}