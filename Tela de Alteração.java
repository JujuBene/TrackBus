package trackbus;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Tela_alterar extends javax.swing.JFrame {

    public Tela_alterar() {
        Color laranjatrack = new Color(255, 140, 0);
        initComponents();
        setLocationRelativeTo(null);
        getContentPane().setBackground(laranjatrack);
        CodUser();
        consult();
    }

    public void mudar() {
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
            String coduser = txtcod.getText();
            ResultSet rs = st.executeQuery("SELECT * FROM trackbus.cadastro WHERE coduser='" + coduser + "';");
            while (rs.next()) {
                jLabel11.setText(rs.getString("coduser"));
            }
            st.close();
            con.close();
        } catch (Exception e) {
            System.out.println(" e " + e);
            jLabel5.setText("Problemas na conexão. Verifique a digitação dos nomes e a existência da fonte de dados.\nRecompile e execute novamente.");
        }
    }

    public void consult() {
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
            String coduser = jLabel11.getText();
            ResultSet rs = st.executeQuery("SELECT * FROM trackbus.cadastro WHERE coduser='" + coduser + "';");
            while (rs.next()) {
                txtcod.setText(rs.getString("coduser"));
                txtcod1.setText(rs.getString("nome"));
                txtcod2.setText(rs.getString("email"));
                txtcod3.setText(rs.getString("datanasc"));
                txtcod4.setText(rs.getString("tel"));
                password1.setText(rs.getString("senha"));
                jLabel11.setText(rs.getString("coduser"));
                String sexo = rs.getString("sexo");
                if ("Masculino".equals(sexo)) {
                    jCheckBox1.setSelected(true);
                }
                if ("Feminino".equals(sexo)) {
                    jCheckBox2.setSelected(true);
                }
            }
            st.close();
            con.close();
        } catch (Exception e) {
            System.out.println(" e " + e);
            jLabel5.setText("Problemas na conexão. Verifique a digitação dos nomes e a existência da fonte de dados.\nRecompile e execute novamente.");
        }
    }

    public void CodUser() {
        try {
            String driverName = "com.mysql.cj.jdbc.Driver";
            String serverName = "localhost:3306";
            String mydatabase = "trackbus";
            String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
            String usuario = "root";
            String senha = "root";
            Class.forName(driverName);
            Connection con = DriverManager.getConnection(url, usuario, senha);
            Statement stat = con.createStatement();
            ResultSet rs = stat.executeQuery("SELECT coduser FROM trackbus.cadastro");
            while (rs.next()) {
                jLabel11.setText(rs.getString("coduser"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void alterar() {
        try {
            String driverName = "com.mysql.cj.jdbc.Driver";
            String serverName = "localhost:3306";
            String mydatabase = "trackbus";
            String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
            String usuario = "root";
            String senha = "root";
            Class.forName(driverName);
            Connection con = DriverManager.getConnection(url, usuario, senha);
            String user = jLabel11.getText();
            String coduser = txtcod.getText();
            String nome = txtcod1.getText();
            String email = txtcod2.getText();
            String datanasc = txtcod3.getText();
            String tel = txtcod4.getText();
            String senhaUser = password1.getText();
            String sexo = "";
            if (jCheckBox1.isSelected()) {
                sexo = jCheckBox1.getText();
            }
            if (jCheckBox2.isSelected()) {
                sexo = jCheckBox2.getText();
            }
            Statement st = con.createStatement();
            String comando = "UPDATE trackbus.cadastro SET coduser='" + coduser +
                    "', nome='" + nome +
                    "', email='" + email +
                    "', datanasc='" + datanasc +
                    "', tel='" + tel +
                    "', senha='" + senhaUser +
                    "', sexo='" + sexo +
                    "' WHERE coduser='" + user + "';";
            st.executeUpdate(comando);
            JOptionPane.showMessageDialog(null, "Alteração de perfil com sucesso.");
            st.close();
            con.close();
        } catch (Exception e) {
            System.out.println(" e " + e);
            JOptionPane.showMessageDialog(null, "Problemas na conexão. Verifique a digitação dos nomes e a existência da fonte de dados.\nRecompile e execute novamente.");
        }
    }

    public void pegarUser(User model) {
        jLabel11.setText(model.getNome());
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        alterar();
        mudar();
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        User model1 = new User();
        if (txtcod.equals(jLabel11)) {
            model1.setNome(txtcod.getText());
        } else {
            model1.setNome(jLabel11.getText());
        }
        Perfil frm = new Perfil();
        frm.pegarUser(model1);
        frm.setVisible(true);
        dispose();
    }

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {
        // Intencionalmente vazio
    }

    private void formWindowActivated(java.awt.event.WindowEvent evt) {
        consult();
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(Tela_alterar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> new Tela_alterar().setVisible(true));
    }

    // Declaração de variáveis
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPasswordField password1;
    private javax.swing.JTextField txtcod;
    private javax.swing.JTextField txtcod1;
    private javax.swing.JTextField txtcod2;
    private javax.swing.JTextField txtcod3;
    private javax.swing.JTextField txtcod4;
}
