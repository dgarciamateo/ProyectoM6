package Ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;

import Idao.IModels;
import XML.Read_XMLModels;
import objetos.Accesory;
import objetos.Engine;
import objetos.Model;
import objetos.Submodel;

import Ventanas.Form_Login;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.SwingConstants;

public class Form_Coches {

	private JFrame frame;
	private int seleccion;
	private String mChoose;
	private JPanel contentPane;
	private ArrayList<JButton> botones;

	/**
	 * Launch the application.
	 */

			public void run() {
				try {
					Form_Coches window = new Form_Coches();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			
	}

	/**
	 * Create the application.
	 */
	public Form_Coches() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		IModels gestorM = new Read_XMLModels();
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 653, 795);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelBotones = new JPanel();
		panelBotones.setBackground(Color.WHITE);
		
		JLabel label = new JLabel("SELECCIONAR EL MODELO DEL COCHE ");
		label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		
		ImageIcon imageiconDef = new ImageIcon("imagenes/" + gestorM.getModelAll().get(0).getImage_name());
		JLabel lblCoche = new JLabel();
		Icon iconDef= new ImageIcon(imageiconDef.getImage().getScaledInstance(320,160, Image.SCALE_DEFAULT));
		lblCoche.setIcon(iconDef);
		lblCoche.setHorizontalAlignment(SwingConstants.CENTER);
		
		JTextArea txtDescripcion = new JTextArea( gestorM.getModelAll().get(0).getDescript());
		txtDescripcion.setLineWrap(true);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setForeground(Color.WHITE);
		
		JLabel lblNombreModelo = new JLabel( gestorM.getModelAll().get(0).getName());
		
		
		Form_Login fl = new Form_Login();
		JLabel lblUsuario = new JLabel("Usuario: "+fl.nom);
		
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(70)
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblUsuario, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(25)
							.addComponent(panelBotones, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(190)
									.addComponent(lblNombreModelo, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(43)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(txtDescripcion, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE)
										.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 354, GroupLayout.PREFERRED_SIZE)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblCoche, GroupLayout.PREFERRED_SIZE, 355, GroupLayout.PREFERRED_SIZE)
											.addGap(24)))))))
					.addContainerGap(51, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblUsuario))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panelBotones, GroupLayout.PREFERRED_SIZE, 662, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblCoche, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNombreModelo)
							.addGap(93)
							.addComponent(txtDescripcion, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
							.addGap(72)
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(20, Short.MAX_VALUE))
		);
		
		botones = new ArrayList<>();
		for (int i = 0; i < gestorM.getModelAll().size(); i++) {
			JLabel labelImagen = new JLabel();
			ImageIcon imageicon = new ImageIcon("imagenes/" + gestorM.getModelAll().get(i).getImage_name());
			Icon icon= new ImageIcon(imageicon.getImage().getScaledInstance(128,84, Image.SCALE_DEFAULT));
			labelImagen.setIcon(icon);
			JButton button = new JButton();
			button.add(labelImagen);
			button.setBackground(Color.white);
			int aux = i;
			button.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					Icon icon= new ImageIcon(imageicon.getImage().getScaledInstance(320,145, Image.SCALE_DEFAULT));
					lblCoche.setIcon(icon);
					txtDescripcion.setText(gestorM.getModelAll().get(aux).getDescript());
					lblNombreModelo.setText(gestorM.getModelAll().get(aux).getName());
					mChoose=gestorM.getModelAll().get(aux).getId();
					seleccion=aux;

				}
			});
			botones.add(button);
		}
		for (JButton jButton : botones) {
			panelBotones.add(jButton);
		}
		
		
		JButton btnAnterior = new JButton("Anterior");

		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
				frame.setVisible(false);
				archivo.delete();
				File renombre = new File("fs_employee.txt");
				archivo2.renameTo(renombre);
			}
		});

		JButton btnSiguiente = new JButton("Siguiente");

		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					
				
					File file = new File("fs_employee.txt");
					if (file.exists()) {
						FileWriter fw;
						BufferedWriter bw;
						try {
							fw = new FileWriter(file.getAbsoluteFile(), true);
							bw = new BufferedWriter(fw);
							PrintWriter pwr = new PrintWriter(bw);
							pwr.write("MODELO - "+gestorM.getModelAll().get(seleccion).getName()+"\r\n");
							pwr.close();
							bw.close();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					Form_SubModelos fsm = new Form_SubModelos();
					fsm.run(mChoose);
			}
		});
		
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addComponent(btnAnterior)
					.addPreferredGap(ComponentPlacement.RELATED, 206, Short.MAX_VALUE)
					.addComponent(btnSiguiente))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAnterior)
						.addComponent(btnSiguiente)))
		);
		panel_1.setLayout(gl_panel_1);
		frame.getContentPane().setLayout(groupLayout);
	}
}

