package trackbus;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Perfil extends javax.swing.JFrame {

    public Perfil() {
        initComponents();
    }

    public void Info() {
        Color laranjatrack = new Color(255, 140, 0);
        setLocationRelativeTo(null);
        getContentPane().setBackground(laranjatrack);

        try {
            String driverName = "com.mysql.cj.jdbc.Driver";
            String serverName = "localhost:3306";
            String mydatabase = "trackbus";
            String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
            String usuario = "root";
            String senha = "root";

            Class.forName(driverName);
            Connection con = DriverManager.getConnection(url, usuario, senha);
            Statement st = con.createStatement();

            String User = userperfil.getText();
            ResultSet rs = st.executeQuery("SELECT * FROM trackbus.cadastro WHERE coduser='" + User + "';");

            while (rs.next()) {
                jLabel7.setText(rs.getString("nome"));
                jLabel8.setText(rs.getString("datanasc"));
                jLabel9.setText(rs.getString("email"));
                jLabel12.setText(rs.getString("tel"));
            }

            st.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Erro: " + e);
            jLabel4.setText("Problemas na conexão. Verifique os dados e tente novamente.");
        }
    }

    public void pegarUser(User model) {
        userperfil.setText(model.getNome());
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        Tela_Login login = new Tela_Login();
        login.setVisible(true);
        this.dispose();
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        int msg = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir esse Perfil?", "Atenção", JOptionPane.YES_NO_OPTION);
        if (msg == JOptionPane.YES_OPTION) {
            try {
                String driverName = "com.mysql.cj.jdbc.Driver";
                String serverName = "localhost:3306";
                String mydatabase = "trackbus";
                String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
                String usuario = "root";
                String senha = "root";

                Class.forName(driverName);
                Connection con = DriverManager.getConnection(url, usuario, senha);

                String coduser = userperfil.getText();
                Statement st = con.createStatement();
                String comando = "DELETE FROM trackbus.cadastro WHERE coduser = '" + coduser + "';";
                st.executeUpdate(comando);

                JOptionPane.showMessageDialog(null, "Usuário excluído com sucesso!");
                st.close();
                con.close();
                dispose();
            } catch (Exception e) {
                System.out.println("Erro: " + e);
                JOptionPane.showMessageDialog(null, "Problemas na conexão. Verifique os dados e tente novamente.");
            }
        }
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        Tela_alterar alterar = new Tela_alterar();
        alterar.setVisible(true);
        dispose();
    }

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
        TelaConsulta consulta = new TelaConsulta();
        consulta.setVisible(true);
        dispose();
    }

    private void formWindowActivated(java.awt.event.WindowEvent evt) {
        Info();
    }

    private void formWindowOpened(java.awt.event.WindowEvent evt) {}

    private void formWindowStateChanged(java.awt.event.WindowEvent evt) {}

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(Perfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> new Perfil().setVisible(true));
    }

    // Variables declaration - do not modify
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public javax.swing.JLabel userperfil;
    // End of variables declaration
}
