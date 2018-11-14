package Ventanas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.toedter.calendar.JDateChooser;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class Form_DatosClientes extends JFrame {
	private JPanel contentPane;
	boolean emailOk;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtApellido2;
	private JTextField txtDireccion;
	private JTextField txtCorreo;

	public void run() {
		try {
			Form_DatosClientes frame = new Form_DatosClientes();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean comrpobarEmail(String correo) {

		// Patrón para validar el email
		Pattern pattern = Pattern.compile(
				"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		// El email a validar
		String email = correo;
		Matcher mather = pattern.matcher(email);

		if (!correo.equals("")) {
			if (mather.find() == true) {
				emailOk = true;
			} else {
				emailOk = false;
			}

		}
		return emailOk;
	}

	public Form_DatosClientes() {
		setTitle("Concesionario Esteve");
		setIconImage(Toolkit.getDefaultToolkit().getImage("imagenes/et.png"));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 428, 551);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("DATOS CLIENTE");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));

		JLabel lblNewLabel_1 = new JLabel("Nombre *");

		JLabel lblPrimerApellido = new JLabel("Primer apellido *");
		Form_Login lf = new Form_Login();

		JLabel lblUsuario = new JLabel("Usuario: " + lf.nom);

		JLabel lblSegundoApellido = new JLabel("Segundo apellido *");

		JLabel lblNewLabel_2 = new JLabel("Direcci\u00F3n *");

		JLabel lblNewLabel_3 = new JLabel("Correo electr\u00F3nico *");

		JLabel lblNewLabel_4 = new JLabel("G\u00E9nero");

		JRadioButton rbHombre = new JRadioButton("Hombre");

		JRadioButton rbMujer = new JRadioButton("Mujer");

		JRadioButton rbNo = new JRadioButton("No determinado");

		ButtonGroup group = new ButtonGroup();
		group.add(rbHombre);
		group.add(rbMujer);
		group.add(rbNo);

		JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento");

		JDateChooser dateChooser = new JDateChooser();

		JButton btnGuardar = new JButton("GUARDAR");
		btnGuardar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (txtNombre.getText().equals("") || txtApellido.getText().equals("")
						|| txtApellido2.getText().equals("") || txtDireccion.getText().equals("")
						|| txtCorreo.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Los campos (*) son obligatiorios !", "Atencion",
							JOptionPane.WARNING_MESSAGE);
				} else {
					if (comrpobarEmail(txtCorreo.getText()) == true) {
						File file = new File("fs_employee.txt");
						if (file.exists()) {
							FileWriter fw;
							BufferedWriter bw;
							try {
								fw = new FileWriter(file.getAbsoluteFile(), true);
								bw = new BufferedWriter(fw);
								PrintWriter pwr = new PrintWriter(bw);
								pwr.write("DATOS CLIENTE - Nombre: " + txtNombre.getText() + " --- "
										+ "Primer apellido: " + txtApellido.getText() + " --- " + "Segundo apellido: "
										+ txtApellido2.getText() + " --- " + "Direccion: " + txtDireccion.getText()
										+ " --- " + "Correo electronico: " + txtCorreo.getText());
								if (rbHombre.isSelected()) {
									pwr.write(" --- " + "Genero: " + rbHombre.getText() + " --- ");
								} else if (rbMujer.isSelected()) {
									pwr.write(" --- " + "Genero: " + rbMujer.getText() + " --- ");
								} else {
									pwr.write(" --- " + "Genero: " + rbNo.getText() + " --- ");
								}

								try {
									SimpleDateFormat geekonjavadate = new SimpleDateFormat("dd/MM/yyyy",
											Locale.getDefault());
									String gojdate = geekonjavadate.format(dateChooser.getDate());
									pwr.write("Fecha de nacimiento: " + gojdate + "\r\n");
								} catch (Exception e1) {
									pwr.write("Fecha de nacimiento: \r\n");
								}
								pwr.close();
								bw.close();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
						JOptionPane.showMessageDialog(null, "Datos guardados.", "Mensaje",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "El email ingresado es inválido.", "Error",
								JOptionPane.ERROR_MESSAGE);
					}

				}

			}
		});

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {

				String linea;
				File archivo = new File("fs_employee.txt");
				if (archivo.exists()) {
					try {
						FileReader fr2 = new FileReader(archivo);
						BufferedReader br2 = new BufferedReader(fr2);
						while ((linea = br2.readLine()) != null) {
							String[] datos = linea.split(" ");
							if (!datos[0].equals("DADES")) {
								dispose();
							}else if(!datos[0].equals("LOGIN")){
								dispose();
							} else {
								int confirmed = JOptionPane.showConfirmDialog(null,
										"Desea salir sin guardar los datos ?", "Confirmar salir",
										JOptionPane.YES_NO_OPTION);

								if (confirmed == JOptionPane.YES_OPTION) {
									dispose();
								}
							}
						}
						br2.close();
					} catch (FileNotFoundException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
				}
			}
		});
		JButton btnSiguiente = new JButton("SIGUIENTE");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (txtNombre.getText().equals("") || txtApellido.getText().equals("")
						|| txtApellido2.getText().equals("") || txtDireccion.getText().equals("")
						|| txtCorreo.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Los campos (*) son obligatiorios !", "Atencion",
							JOptionPane.WARNING_MESSAGE);
				} else {
					if (comrpobarEmail(txtCorreo.getText()) == true) {
						
						String linea;
						File archivo = new File("fs_employee.txt");
						File archivo2 = new File("copia.txt");
						if (archivo.exists()) {
							try {
								FileReader fr = new FileReader(archivo);
								BufferedReader br = new BufferedReader(fr);
								FileWriter fw = new FileWriter(archivo2);
								BufferedWriter bw = new BufferedWriter(fw);
								PrintWriter pwr = new PrintWriter(bw);
								while ((linea = br.readLine()) != null) {
									String[] datos = linea.split(" ");
									if (!datos[0].equals("DATOS")) {
										pwr.write(linea + "\r\n");
									}
								}
								br.close();
								pwr.close();
							} catch (FileNotFoundException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						archivo.delete();
						File renombre = new File("fs_employee.txt");
						archivo2.renameTo(renombre);
						
						// txt
						File file = new File("fs_employee.txt");
						if (file.exists()) {
							FileWriter fw;
							BufferedWriter bw;
							try {
								fw = new FileWriter(file.getAbsoluteFile(), true);
								bw = new BufferedWriter(fw);
								PrintWriter pwr = new PrintWriter(bw);
								pwr.write("DATOS CLIENTE - Nombre: " + txtNombre.getText() + " --- "
										+ "Primer apellido: " + txtApellido.getText() + " --- " + "Segundo apellido: "
										+ txtApellido2.getText() + " --- " + "Direccion: " + txtDireccion.getText()
										+ " --- " + "Correo electronico: " + txtCorreo.getText());
								if (rbHombre.isSelected()) {
									pwr.write(" --- " + "Genero: " + rbHombre.getText() + " --- ");
								} else if (rbMujer.isSelected()) {
									pwr.write(" --- " + "Genero: " + rbMujer.getText() + " --- ");
								} else {
									pwr.write(" --- " + "Genero: " + rbNo.getText() + " --- ");
								}

								try {
									SimpleDateFormat geekonjavadate = new SimpleDateFormat("dd/MM/yyyy",
											Locale.getDefault());
									String gojdate = geekonjavadate.format(dateChooser.getDate());
									pwr.write("Fecha de nacimiento: " + gojdate + "\r\n");
								} catch (Exception e) {
									pwr.write("Fecha de nacimiento: \r\n");
								}
								pwr.close();
								bw.close();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}

						Form_Coches fmc = new Form_Coches();
						fmc.run();
					} else {
						JOptionPane.showMessageDialog(null, "El email ingresado es inválido.", "Error",
								JOptionPane.ERROR_MESSAGE);
					}

				}
			}
		});

		txtNombre = new JTextField();
		txtNombre.setText("Pepe");
		txtNombre.setColumns(10);

		txtApellido = new JTextField();
		txtApellido.setText("Rodriguez");
		txtApellido.setColumns(10);

		txtApellido2 = new JTextField();
		txtApellido2.setText("Gomez");
		txtApellido2.setColumns(10);

		txtDireccion = new JTextField();
		txtDireccion.setText("Calle Falsa 123");
		txtDireccion.setColumns(10);

		txtCorreo = new JTextField();
		txtCorreo.setText("pepe@gmail.com");
		txtCorreo.setColumns(10);

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.TRAILING).addGroup(gl_contentPane.createSequentialGroup()
						.addGap(52).addComponent(lblNewLabel).addPreferredGap(ComponentPlacement.RELATED, 113,
								Short.MAX_VALUE)
						.addComponent(lblUsuario).addGap(77))
						.addGroup(gl_contentPane.createSequentialGroup().addContainerGap().addGroup(gl_contentPane
								.createParallelGroup(Alignment.LEADING)
								.addGroup(
										gl_contentPane.createSequentialGroup().addComponent(lblNewLabel_4)
												.addPreferredGap(ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
												.addComponent(rbHombre).addGap(18).addComponent(rbMujer).addGap(18)
												.addComponent(rbNo))
								.addGroup(gl_contentPane.createSequentialGroup().addGroup(gl_contentPane
										.createParallelGroup(Alignment.LEADING).addComponent(lblPrimerApellido)
										.addComponent(lblNewLabel_1).addComponent(lblNewLabel_2)
										.addComponent(lblNewLabel_3).addComponent(lblFechaDeNacimiento)
										.addComponent(lblSegundoApellido, GroupLayout.PREFERRED_SIZE, 112,
												GroupLayout.PREFERRED_SIZE))
										.addGap(40)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
												.addComponent(txtNombre, GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
												.addComponent(txtApellido).addComponent(txtApellido2)
												.addComponent(txtDireccion).addComponent(txtCorreo)
												.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, 186,
														GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)))
								.addContainerGap(42, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
								.addComponent(btnGuardar, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE).addGap(99)
								.addComponent(btnSiguiente, GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
								.addContainerGap()));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel)
								.addComponent(lblUsuario))
						.addGap(28)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_1)
								.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblPrimerApellido)
								.addComponent(txtApellido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblSegundoApellido).addComponent(txtApellido2, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_2)
								.addComponent(txtDireccion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(12)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_3).addComponent(txtCorreo, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_4)
								.addComponent(rbNo).addComponent(rbMujer).addComponent(rbHombre))
						.addGap(20)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblFechaDeNacimiento).addComponent(dateChooser,
										GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED, 186, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(btnGuardar)
								.addComponent(btnSiguiente))
						.addContainerGap()));
		contentPane.setLayout(gl_contentPane);
	}
}
