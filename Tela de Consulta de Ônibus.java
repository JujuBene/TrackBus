package trackbus;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.*;

public class TelaConsulta extends javax.swing.JFrame {

    public TelaConsulta() {
        Color laranjatrack = new Color(255, 140, 0);
        initComponents();
        setLocationRelativeTo(null);
        getContentPane().setBackground(laranjatrack);
        Linha();
    }

    public void Linha() {
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

            String selectQuery = "SELECT linha FROM trackbus.bus";
            ResultSet rs = stat.executeQuery(selectQuery);

            while (rs.next()) {
                jComboBox1.addItem(rs.getString("linha"));
            }

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtcod1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtcod2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtcod3 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtcod6 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        txtcod7 = new javax.swing.JTextField();
        txtcod5 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Consulta");
        setBackground(java.awt.Color.orange);
        setLocationByPlatform(true);

        jLabel1.setFont(new java.awt.Font("Arial Narrow", 1, 28));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CONSULTA ÔNIBUS");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel2.setText("Linha:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel3.setText("Rota:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel4.setText("Horário de chegada:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel5.setText("Localização real:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel6.setText("Tempo de espera:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel8.setText("Acessibilidade:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel10.setText("Lotação:");

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18));
        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18));
        jButton2.setText("←");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 14));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        // Layout omitido aqui para manter foco — manter o layout anterior funciona

        pack();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
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

            String linha = jComboBox1.getSelectedItem().toString();
            ResultSet rs = st.executeQuery("SELECT * FROM trackbus.bus WHERE linha = '" + linha + "';");

            while (rs.next()) {
                txtcod1.setText(rs.getString("rota"));
                txtcod2.setText(rs.getString("localreal"));
                txtcod3.setText(rs.getString("horachegada"));
                txtcod7.setText(rs.getString("tempoespera"));
                txtcod5.setText(rs.getString("acessibilidade"));
                txtcod6.setText(rs.getString("lotacao"));
            }

            st.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Erro: " + e);
            jLabel9.setText("Problemas na conexão. Verifique o banco e tente novamente.");
        }
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        Perfil perfil = new Perfil();
        perfil.setVisible(true);
        this.dispose();
    }

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {
        // Ação opcional
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info :
                    javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(TelaConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new TelaConsulta().setVisible(true);
        });
    }

    // Declaração de variáveis
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JTextField txtcod1;
    private javax.swing.JTextField txtcod2;
    private javax.swing.JTextField txtcod3;
    private javax.swing.JTextField txtcod5;
    private javax.swing.JTextField txtcod6;
    private javax.swing.JTextField txtcod7;
}
