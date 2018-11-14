package Ventanas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Idao.ISubmodels;

import XML.Read_XMLSubmodels;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
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

public class Form_SubModelos extends JFrame {

	private JPanel contentPane;
	private String modelo;
	private static String smChoose;
	private static String textoSubmodelo;

	/**
	 * Launch the application.
	 */

	public void run(String modelo) {
		try {
			Form_SubModelos frame = new Form_SubModelos(modelo);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("unchecked")
	public Form_SubModelos(String modelo) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("imagenes/et.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 392);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		ISubmodels gestorS = new Read_XMLSubmodels();
		JList list = new JList();
		DefaultListModel modelolista = new DefaultListModel();

		list.setModel(modelolista);

		for (int j = 0; j < gestorS.getSubmodelAll().size(); j++) {

			if (modelo.equals(gestorS.getSubmodelAll().get(j).getModel_id())) {

				textoSubmodelo = gestorS.getSubmodelAll().get(j).getName() + "- "
						+ gestorS.getSubmodelAll().get(j).getCv() + " - "
						+ gestorS.getSubmodelAll().get(j).getDoors() + " - "
						+ gestorS.getSubmodelAll().get(j).getEngine() + " - "
						+ gestorS.getSubmodelAll().get(j).getPrice() + "€";

				modelolista.addElement(textoSubmodelo);

				// System.out.println(textoSubmodelo);
			} else {

			}

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
							if (!datos[0].equals("MODELO")) {
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
				setVisible(false);
				archivo.delete();
				File renombre = new File("fs_employee.txt");
				archivo2.renameTo(renombre);
			}
		});

		JButton btnSiguiente = new JButton("Siguiente");

		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				smChoose = (String) list.getSelectedValue();

				if (smChoose == null) {

					JOptionPane.showMessageDialog(null, "Debes elegir un submodelo!!", "Atencion",
							JOptionPane.ERROR_MESSAGE);

				} else {

					String[] arraySubm;

					arraySubm = smChoose.split("-");

					String nombre_sm = arraySubm[0];

					File file = new File("fs_employee.txt");
					if (file.exists()) {
						FileWriter fw;
						BufferedWriter bw;
						try {
							fw = new FileWriter(file.getAbsoluteFile(), true);
							bw = new BufferedWriter(fw);
							PrintWriter pwr = new PrintWriter(bw);

							pwr.write("CARACTERISTICAS - " + smChoose + "\r\n");
							pwr.close();
							bw.close();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					Form_ExtrasCoche fec = new Form_ExtrasCoche(modelo, smChoose, nombre_sm);
					fec.run(modelo, smChoose, nombre_sm);
				}

			}
		});

		JLabel lblNewLabel = new JLabel("Selecci\u00F3n de caracter\u00EDsticas de modelo");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup().addGap(29).addComponent(lblNewLabel,
										GroupLayout.PREFERRED_SIZE, 333, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(list, GroupLayout.DEFAULT_SIZE, 404,
														Short.MAX_VALUE)
												.addGroup(gl_contentPane.createSequentialGroup()
														.addComponent(btnAnterior, GroupLayout.PREFERRED_SIZE, 112,
																GroupLayout.PREFERRED_SIZE)
														.addGap(180).addComponent(btnSiguiente,
																GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)))))
						.addContainerGap()));
		gl_contentPane
				.setVerticalGroup(
						gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(Alignment.TRAILING,
										gl_contentPane.createSequentialGroup().addContainerGap()
												.addComponent(lblNewLabel).addGap(32)
												.addComponent(list, GroupLayout.PREFERRED_SIZE, 102,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED, 132, Short.MAX_VALUE)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
														.addComponent(btnAnterior).addComponent(btnSiguiente))
												.addGap(20)));
		contentPane.setLayout(gl_contentPane);
	}

	public Form_SubModelos() {
		setTitle("Concesionario Esteve");
		// TODO Auto-generated constructor stub
	}

	public String getTextoSubmodelo() {
		return textoSubmodelo;
	}
}
