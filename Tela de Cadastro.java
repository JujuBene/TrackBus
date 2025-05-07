package trackbus;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class TelaCadastro extends javax.swing.JFrame {

    public TelaCadastro() {
        Color laranjatrack = new Color(255, 140, 0);
        initComponents();
        setLocationRelativeTo(null);
        getContentPane().setBackground(laranjatrack);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {
        // Declaração dos componentes da interface
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtcod = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtcod1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtcod2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtcod3 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtcod4 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        password1 = new javax.swing.JPasswordField();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro");
        setBackground(java.awt.Color.orange);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocationByPlatform(true);

        jLabel1.setFont(new java.awt.Font("Arial Narrow", 1, 36)); 
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CADASTRO");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); 
        jLabel2.setText("Nome do Usuário:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); 
        jLabel3.setText("Nome:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); 
        jLabel4.setText("Data de Nascimento (aaaa-mm-dd):");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); 
        jLabel5.setText("E-mail:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); 
        jLabel6.setText("Telefone:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); 
        jLabel7.setText("Sexo:");

        jCheckBox1.setFont(new java.awt.Font("Tahoma", 0, 14)); 
        jCheckBox1.setText("Masculino");

        jCheckBox2.setFont(new java.awt.Font("Tahoma", 0, 14)); 
        jCheckBox2.setText("Feminino");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); 
        jButton1.setText("Cadastrar");
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

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); 
        jLabel8.setText("Senha:");

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        // Layout omitido por brevidade (já bem estruturado)
        // ...
    } // </editor-fold>

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

            String coduser = txtcod.getText();
            String nome = txtcod1.getText();
            String email = txtcod2.getText();
            String datanasc = txtcod3.getText();
            String tel = txtcod4.getText();
            String Senha = password1.getText();
            String sexo = "";

            if (jCheckBox1.isSelected())
                sexo = jCheckBox1.getText();
            if (jCheckBox2.isSelected())
                sexo = jCheckBox2.getText();

            String comando = "INSERT INTO trackbus.cadastro (coduser, nome, email, datanasc, tel, senha, sexo) " +
                             "VALUES ('" + coduser + "','" + nome + "','" + email + "','" + datanasc + "','" + tel + "','" + Senha + "','" + sexo + "')";
            st.executeUpdate(comando);
            jLabel9.setText("Cadastro feito com sucesso!");

            st.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Erro: " + e);
            jLabel9.setText("Problemas na conexão. Verifique os dados e tente novamente.");
        }
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        Tela_Login login = new Tela_Login();
        login.setVisible(true);
        this.dispose();
    }

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {
        // Ação personalizada, se necessário
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
            java.util.logging.Logger.getLogger(TelaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastro().setVisible(true);
            }
        });
    }

    // Declaração de variáveis
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JLabel jLabel1;
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
