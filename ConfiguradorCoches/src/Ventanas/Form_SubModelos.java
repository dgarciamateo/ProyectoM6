package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Idao.ICoches;
import XML.Read_XMLCars;
import objetos.Accesory;
import objetos.Engine;
import objetos.Model;
import objetos.Submodel;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public class Form_SubModelos extends JFrame implements ICoches {

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 392);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		ICoches gestorCars = new Read_XMLCars();

		/*
		 * String[] arraySubmodelos = new
		 * String[gestorCars.getSubmodelAll().size()];
		 * 
		 * for (int i = 0; i < arraySubmodelos.length; i++) {
		 * 
		 * arraySubmodelos[i] = gestorCars.getSubmodelAll().get(i).getName() +
		 * " | " + gestorCars.getSubmodelAll().get(i).getCv() + " | " +
		 * gestorCars.getSubmodelAll().get(i).getDoors() + " | " +
		 * gestorCars.getSubmodelAll().get(i).getEngine() + " | " +
		 * gestorCars.getSubmodelAll().get(i).getPrice();
		 * 
		 * }
		 * 
		 * System.out.println(Arrays.toString(arraySubmodelos));
		 * 
		 */
		JList list = new JList();
		DefaultListModel modelolista = new DefaultListModel();

		list.setModel(modelolista);

		for (int j = 0; j < gestorCars.getSubmodelAll().size(); j++) {

			if (modelo.equals(gestorCars.getSubmodelAll().get(j).getModel_id())) {

				textoSubmodelo = gestorCars.getSubmodelAll().get(j).getName() + "- "
						+ gestorCars.getSubmodelAll().get(j).getCv() + " - "
						+ gestorCars.getSubmodelAll().get(j).getDoors() + " - "
						+ gestorCars.getSubmodelAll().get(j).getEngine() + " - "
						+ gestorCars.getSubmodelAll().get(j).getPrice() + "€";

				modelolista.addElement(textoSubmodelo);

				// System.out.println(textoSubmodelo);
			} else {

			}

		}

		JButton btnAnterior = new JButton("Anterior");

		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// setVisible(false);

				setVisible(false);
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

							pwr.write("\r\nCaracteristicas del modelo: " + smChoose);
							pwr.write("\r\n---------------------------------");
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
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<Model> getModelAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Engine> getEngineAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Accesory> getAccesoryAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Submodel> getSubmodelAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addModel(Model model) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addEngine(Engine engine) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addAccesory(Accesory accesory) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addSubmodel(Submodel submodel) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actualizarModel(Model model) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actualizarEngine(Engine engine) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actualizarAccesory(Accesory accesory) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actualizarSubmodel(Submodel submodel) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminarModel(Model model) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminarEngine(Engine engine) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminarAccesory(Accesory accesory) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminarSubmodel(Submodel submodel) {
		// TODO Auto-generated method stub

	}
	public String getTextoSubmodelo() {
		return textoSubmodelo;
	}
}
