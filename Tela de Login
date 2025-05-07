	package trackbus;

	import java.sql.*;
	import javax.swing.JOptionPane;
	import java.util.ArrayList;
	import java.applet.Applet;
	import java.awt.*;
	import javax.swing.*;
	import javax.swing.JList;
	import java.awt.event.*;
	import java.io.*;
	import java.util.*;

	public class Tela_Login extends javax.swing.JFrame {
		DefaultListModel model = new DefaultListModel();

		public void Logar() {
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
				String coduser = userlogin.getText();
				String Senha = jPasswordField1.getText();
				ResultSet rs = st.executeQuery("SELECT * FROM trackbus.cadastro where coduser='" +
					coduser + "' and Senha='" + Senha + "';");
				System.out.println(" rs = " + rs);
				if (rs.next()) {
					Perfil init = new Perfil();
					User model = new User();
					model.setNome(userlogin.getText());
					Perfil frm = new Perfil();
					frm.pegarUser(model);
					frm.setVisible(true);
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Usuário e/ou Senha Incorretos!");
				}
				st.close();
				con.close();
			} catch (Exception e) {
				System.out.println(" e " + e);
				JOptionPane.showMessageDialog(null, "Problemas na conexão. Verifique a digitação dos nomes e a existência da fonte de dados. \nRecompile e execute novamente.");
			}
			dispose();
		}

		public Tela_Login(JTextField jTextField1) {
			this.userlogin = jTextField1;
		}

		public JTextField getjTextField1() {
			return userlogin;
		}

		public void setjTextField1(JTextField jTextField1) {
			this.userlogin = jTextField1;
		}

		public Tela_Login() {
			initComponents();
			setLocationRelativeTo(null);
		}

		@SuppressWarnings("unchecked")
		private void initComponents() {
			jPanel1 = new javax.swing.JPanel();
			jPanel3 = new javax.swing.JPanel();
			jLabel1 = new javax.swing.JLabel();
			userlogin = new javax.swing.JTextField();
			jButton1 = new javax.swing.JButton();
			jPasswordField1 = new javax.swing.JPasswordField();
			jLabel2 = new javax.swing.JLabel();
			jButton2 = new javax.swing.JButton();
			jLabel4 = new javax.swing.JLabel();
			jCheckBox1 = new javax.swing.JCheckBox();
			jLabel3 = new javax.swing.JLabel();

			setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
			setTitle("LOGIN");
			setBackground(new java.awt.Color(255, 204, 204));

			jPanel1.setBackground(new java.awt.Color(255, 165, 0));
			jPanel3.setBackground(new java.awt.Color(255, 140, 0));
			jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
			jPanel3.setToolTipText("");

			jLabel1.setFont(new java.awt.Font("Arial Narrow", 1, 36));
			jLabel1.setForeground(new java.awt.Color(255, 255, 255));
			jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
			jLabel1.setText("USER LOGIN");

			userlogin.setForeground(new java.awt.Color(153, 153, 153));
			userlogin.setText("Usuário");
			userlogin.addFocusListener(new java.awt.event.FocusAdapter() {
				public void focusGained(java.awt.event.FocusEvent evt) {
					userloginFocusGained(evt);
				}
				public void focusLost(java.awt.event.FocusEvent evt) {
					userloginFocusLost(evt);
				}
			});
			userlogin.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent evt) {
					userloginActionPerformed(evt);
				}
			});

			jButton1.setFont(new java.awt.Font("Arial Narrow", 1, 24));
			jButton1.setText("Entrar");
			jButton1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent evt) {
					jButton1ActionPerformed(evt);
				}
			});

			jPasswordField1.setForeground(new java.awt.Color(153, 153, 153));
			jPasswordField1.setText("Senha");
			jPasswordField1.addFocusListener(new java.awt.event.FocusAdapter() {
				public void focusGained(java.awt.event.FocusEvent evt) {
					jPasswordField1FocusGained(evt);
				}
				public void focusLost(java.awt.event.FocusEvent evt) {
					jPasswordField1FocusLost(evt);
				}
			});

			jButton2.setFont(new java.awt.Font("Arial Narrow", 1, 18));
			jButton2.setText("Cadastro");
			jButton2.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent evt) {
					jButton2ActionPerformed(evt);
				}
			});

			jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\natal\\Downloads\\aaaaaaaaaaaaaaa22.png"));

			jCheckBox1.setText("Mantenha-me conectado");
			jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent evt) {
					jCheckBox1ActionPerformed(evt);
				}
			});

			jLabel3.setText("Esqueci a senha");

			javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
			jPanel3.setLayout(jPanel3Layout);

			jPanel3Layout.setHorizontalGroup(
				jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
					.addGroup(jPanel3Layout.createSequentialGroup()
						.addGap(63, 63, 63)
						.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
							.addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
							.addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING,
								javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGroup(jPanel3Layout.createSequentialGroup()
						.addGap(54, 54, 54)
						.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
							.addComponent(userlogin)
							.addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(jPasswordField1)
							.addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(0, 55, Short.MAX_VALUE))
					.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
							.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
								.addComponent(jLabel1)
								.addGap(77, 77, 77))
							.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
								.addComponent(jCheckBox1)
								.addGap(97, 97, 97))
							.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
								.addComponent(jLabel3)
								.addGap(130, 130, 130))))
			);

			jPanel3Layout.setVerticalGroup(
				jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
					.addGroup(jPanel3Layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jLabel2)
						.addGap(11, 11, 11)
						.addComponent(jLabel1)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jLabel4)
						.addGap(4, 4, 4)
						.addComponent(userlogin, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(jCheckBox1)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jLabel3)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jButton2)
						.addContainerGap())
			);

			javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
			jPanel1.setLayout(jPanel1Layout);
			jPanel1Layout.setHorizontalGroup(
				jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
					.addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
			);
			jPanel1Layout.setVerticalGroup(
				jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
					.addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
			);

			javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
			getContentPane().setLayout(layout);
			layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
					.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
			);
			layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
					.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
			);

			pack();
		}

		private void userloginActionPerformed(java.awt.event.ActionEvent evt) {}

		private void userloginFocusGained(java.awt.event.FocusEvent evt) {
			if (userlogin.getText().equals("Usuário")) {
				userlogin.setText("");
				userlogin.setForeground(new Color(0, 0, 0));
			}
		}

		private void userloginFocusLost(java.awt.event.FocusEvent evt) {
			if (userlogin.getText().equals("")) {
				userlogin.setText("Usuário");
				userlogin.setForeground(new Color(153, 153, 153));
			}
		}

		private void jPasswordField1FocusGained(java.awt.event.FocusEvent evt) {
			if (jPasswordField1.getText().equals("Senha")) {
				jPasswordField1.setText("");
				jPasswordField1.setForeground(new Color(0, 0, 0));
				jPasswordField1.setEchoChar('*');
			}
		}

		private void jPasswordField1FocusLost(java.awt.event.FocusEvent evt) {
			if (jPasswordField1.getText().equals("")) {
				jPasswordField1.setText("Senha");
				jPasswordField1.setForeground(new Color(153, 153, 153));
				jPasswordField1.setEchoChar('\u0000');
			}
		}

		private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
			Logar();
		}

		private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
			TelaCadastro cadastro = new TelaCadastro();
			cadastro.setVisible(true);
			dispose();
		}

		private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {}

		public static void main(String args[]) {
			try {
				for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
					if ("Nimbus".equals(info.getName())) {
						javax.swing.UIManager.setLookAndFeel(info.getClassName());
						break;
					}
				}
			} catch (Exception ex) {
				java.util.logging.Logger.getLogger(Tela_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
			}

			java.awt.EventQueue.invokeLater(new Runnable() {
				public void run() {
					new Tela_Login().setVisible(true);
				}
			});
		}

		// Variables declaration - do not modify
		private javax.swing.JButton jButton1;
		private javax.swing.JButton jButton2;
		private javax.swing.JCheckBox jCheckBox1;
		private javax.swing.JLabel jLabel1;
		private javax.swing.JLabel jLabel2;
		private javax.swing.JLabel jLabel3;
		private javax.swing.JLabel jLabel4;
		private javax.swing.JPanel jPanel1;
		private javax.swing.JPanel jPanel3;
		private javax.swing.JPasswordField jPasswordField1;
		public javax.swing.JTextField userlogin;
		// End of variables declaration
	}
