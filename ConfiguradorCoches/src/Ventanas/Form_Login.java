package Ventanas;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JTextField;

import Configuracion.ConfigurationLoader;
import XML.XMLConfig;

import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class Form_Login {

	private JFrame frame;
	private JTextField textfield_login;
	private JLabel label_psw;
	private JPasswordField passwordField;
	private JButton button_entrar;
	static String nom;
	String pw;
	String[] usuarios;
	String[] passwords;
	boolean existe;
	boolean correcto;

	/**
	 * Launch the application.
	 */

	public void run() {
		try {
			Form_Login window = new Form_Login();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the application.
	 */
	public Form_Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Concesionario Esteve");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("imagenes/et.png"));
		frame.setSize(330, 213);
		frame.setResizable(false);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 21, 44, 45, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 48, 19, 49, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		frame.getContentPane().setLayout(gridBagLayout);

		JLabel label_login = new JLabel("Login:");
		label_login.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_label_login = new GridBagConstraints();
		gbc_label_login.anchor = GridBagConstraints.WEST;
		gbc_label_login.insets = new Insets(0, 0, 5, 5);
		gbc_label_login.gridx = 1;
		gbc_label_login.gridy = 1;
		frame.getContentPane().add(label_login, gbc_label_login);

		textfield_login = new JTextField();
		GridBagConstraints gbc_textfield_login = new GridBagConstraints();
		gbc_textfield_login.insets = new Insets(0, 0, 5, 5);
		gbc_textfield_login.fill = GridBagConstraints.BOTH;
		gbc_textfield_login.gridx = 3;
		gbc_textfield_login.gridy = 1;
		frame.getContentPane().add(textfield_login, gbc_textfield_login);
		textfield_login.setColumns(10);

		label_psw = new JLabel("Password:");
		label_psw.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_label_psw = new GridBagConstraints();
		gbc_label_psw.anchor = GridBagConstraints.WEST;
		gbc_label_psw.insets = new Insets(0, 0, 5, 5);
		gbc_label_psw.gridx = 1;
		gbc_label_psw.gridy = 2;
		frame.getContentPane().add(label_psw, gbc_label_psw);

		passwordField = new JPasswordField();
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.gridx = 3;
		gbc_passwordField.gridy = 2;
		frame.getContentPane().add(passwordField, gbc_passwordField);

		button_entrar = new JButton("ENTRAR");
		button_entrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					comprobarUsername();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		passwordField.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyChar() == KeyEvent.VK_ENTER) {
					try {
						comprobarUsername();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

			}
		});

		GridBagConstraints gbc_button_entrar = new GridBagConstraints();
		gbc_button_entrar.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_entrar.insets = new Insets(0, 0, 0, 5);
		gbc_button_entrar.gridx = 3;
		gbc_button_entrar.gridy = 3;
		frame.getContentPane().add(button_entrar, gbc_button_entrar);

	}

	public void comprobarUsername() throws IOException {
		nom = textfield_login.getText();
		pw = String.valueOf(passwordField.getPassword());
		XMLConfig single = ConfigurationLoader.getInstance();
		usuarios = single.getUsers();
		passwords = single.getPass();

		/****** COMPRUEBA PRIMERO EL USERNAME ******/
		for (int y = 0; y < usuarios.length; y++) {
			if (usuarios[y].equals(nom)) {
				comprobarLogin(nom, pw, usuarios, passwords);
				existe = true;
				break;
			}
		}
		if (existe == false) {
			JOptionPane.showMessageDialog(null, "El usuario no existe !", "Atencion", JOptionPane.ERROR_MESSAGE);

		}

	}

	/******
	 * SI EXISTE EL USUARIO, COMPRUEBA LA CONTRASEÑA
	 * 
	 * @throws IOException
	 ******/
	public void comprobarLogin(String nom, String pw, String[] usuarios, String[] passwords) throws IOException {
		for (int i = 0; i < usuarios.length; i++) {
			if (usuarios[i].equals(nom) && passwords[i].equals(pw)) {
				correcto = true;
				JOptionPane.showMessageDialog(null, "Bienvenido !", "Mensaje", JOptionPane.INFORMATION_MESSAGE);

				// Crear y escribir txt
				String linea;
				int nLineas = 1;
				File archivo = new File("fs_employee.txt");
				if (archivo.exists()) {
					FileReader fr = new FileReader(archivo);
					BufferedReader br = new BufferedReader(fr);
					// si hay algo escrito salta el joptionpane
					if ((linea = br.readLine()) != null) {
						int res = JOptionPane.showConfirmDialog(null,
								"Hay datos temporales, quieres cargarlos? En caso contrario seran eliminados",
								"Atencion", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
						// contador de lineas en el txt
						while ((linea = br.readLine()) != null) {
							nLineas++;
						}

						// abrir ventana donde se quedo
						if (res == JOptionPane.YES_OPTION) {
							if (nLineas == 2) {
								Form_DatosClientes fdc = new Form_DatosClientes();
								fdc.run();
								break;
							} else if (nLineas == 3) {
								Form_Coches fmc = new Form_Coches();
								fmc.run();
								break;
								// } else if (nLineas == 4) {
								// Form_SubModelos fsm = new
								// Form_SubModelos(mChoose);
								// fsm.run(mChoose);
								// break;
								// } else {
								// Form_ExtrasCoche fec = new
								// Form_ExtrasCoche(modelo, smChoose,
								// nombre_sm);
								// fec.run(modelo, smChoose, nombre_sm);
							}
						} else {
							FileWriter fw = new FileWriter(archivo);
							BufferedWriter bw = new BufferedWriter(fw);
							PrintWriter pwr = new PrintWriter(bw);
							pwr.write("");
							pwr.close();
							bw.close();
							JOptionPane.showMessageDialog(null, "Datos temporales eliminados");
							textfield_login.setText("");
							passwordField.setText("");
							textfield_login.requestFocus();
						}
						break;
					}
					br.close();
				}
				FileWriter fw2 = new FileWriter(archivo);
				BufferedWriter bw2 = new BufferedWriter(fw2);
				PrintWriter pwr2 = new PrintWriter(bw2);
				pwr2.write("DADES TEMPORALS\r\n");
				pwr2.write("LOGIN - Usuario: " + textfield_login.getText() + "\r\n");
				pwr2.close();
				bw2.close();

				Form_DatosClientes fdc = new Form_DatosClientes();
				fdc.run();
				break;
			} else {
				correcto = false;
			}
		}
		if (correcto == false) {
			JOptionPane.showMessageDialog(null, "Los datos no coinciden !", "Atencion", JOptionPane.ERROR_MESSAGE);
		}
	}
}
