package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JCheckBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import Idao.ICoches;
import XML.Read_XMLCars;
import objetos.Accesory;
import objetos.Engine;
import objetos.Model;
import objetos.Submodel;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.awt.event.ActionEvent;

public class Form_ExtrasCoche implements ICoches {

	private JFrame frame;
	private String a1, a2, a3, a4, a5, a6;
	private String[] availableM;
	private int dispo, suma = 0, precio = 0;
	private String sumatxt, preciotxt;

	/**
	 * Launch the application.
	 */
	public void run(String modelo, String submodelo, String nombre_sm) {
		try {
			Form_ExtrasCoche window = new Form_ExtrasCoche(modelo, submodelo, nombre_sm);
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the application.
	 */
	public Form_ExtrasCoche(String modelo, String submodelo, String nombre_sm) {
		initialize(modelo, submodelo, nombre_sm);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String modelo, String submodelo, String nombre_sm) {
		frame = new JFrame();
		frame.setBounds(100, 100, 541, 490);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel lbl_titulo = new JLabel("Compra de Accesorios");
		lbl_titulo.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JLabel lbl_submodelo = new JLabel(submodelo);
		lbl_submodelo.setFont(new Font("Tahoma", Font.PLAIN, 12));

		ICoches gestorCars = new Read_XMLCars();

		JCheckBox cbA1 = new JCheckBox(gestorCars.getAccesoryAll().get(0).getName());

		JCheckBox cbA2 = new JCheckBox(gestorCars.getAccesoryAll().get(1).getName());

		JCheckBox cbA3 = new JCheckBox(gestorCars.getAccesoryAll().get(2).getName());

		JCheckBox cbA4 = new JCheckBox(gestorCars.getAccesoryAll().get(3).getName());

		JCheckBox cbA5 = new JCheckBox(gestorCars.getAccesoryAll().get(4).getName());

		JCheckBox cbA6 = new JCheckBox(gestorCars.getAccesoryAll().get(5).getName());

		// Comprobante de que el accesorio esta dispnible en el submodelo
		// elegido en la ventana anterior

		// ACCESORIO 1

		availableM = gestorCars.getAccesoryAll().get(0).getModel_available();
		dispo = 0;

		for (int i = 0; i < availableM.length; i++) {

			if (nombre_sm.equals(availableM[i])) {
				dispo = 1;
			}

		}

		if (dispo == 0) {
			cbA1.setEnabled(false);
			cbA1.setToolTipText("");
		} else {
			cbA1.setEnabled(true);
			
		}
		
		if(!cbA1.isEnabled()) {
			cbA1.setToolTipText("Accesorio no disponible para este modelo.");
		}

		// ACCESORIO 2

		availableM = gestorCars.getAccesoryAll().get(1).getModel_available();
		dispo = 0;

		for (int i = 0; i < availableM.length; i++) {

			if (nombre_sm.equals(availableM[i])) {
				dispo = 1;
			}

		}

		if (dispo == 0) {
			cbA2.setEnabled(false);
		} else {
			cbA2.setEnabled(true);

		}
		
		if(!cbA2.isEnabled()) {
			cbA2.setToolTipText("Accesorio no disponible para este modelo.");
		}

		// ACCESORIO 3

		availableM = gestorCars.getAccesoryAll().get(2).getModel_available();
		dispo = 0;

		for (int i = 0; i < availableM.length; i++) {

			if (nombre_sm.equals(availableM[i])) {
				dispo = 1;
			}

		}

		if (dispo == 0) {
			cbA3.setEnabled(false);
		} else {
			cbA3.setEnabled(true);

		}
		
		if(!cbA3.isEnabled()) {
			cbA3.setToolTipText("Accesorio no disponible para este modelo.");
		}

		// ACCESORIO 4

		availableM = gestorCars.getAccesoryAll().get(3).getModel_available();
		dispo = 0;

		for (int i = 0; i < availableM.length; i++) {

			if (nombre_sm.equals(availableM[i])) {
				dispo = 1;
			}

		}

		if (dispo == 0) {
			cbA4.setEnabled(false);
		} else {
			cbA4.setEnabled(true);

		}
		
		if(!cbA4.isEnabled()) {
			cbA4.setToolTipText("Accesorio no disponible para este modelo.");
		}

		// ACCESORIO 5

		availableM = gestorCars.getAccesoryAll().get(4).getModel_available();
		dispo = 0;

		for (int i = 0; i < availableM.length; i++) {

			if (nombre_sm.equals(availableM[i])) {
				dispo = 1;
			}

		}

		if (dispo == 0) {
			cbA5.setEnabled(false);
		} else {
			cbA5.setEnabled(true);

		}
		
		if(!cbA5.isEnabled()) {
			cbA5.setToolTipText("Accesorio no disponible para este modelo.");
		}

		// ACCESORIO 6

		availableM = gestorCars.getAccesoryAll().get(5).getModel_available();
		dispo = 0;

		for (int i = 0; i < availableM.length; i++) {

			if (nombre_sm.equals(availableM[i])) {
				dispo = 1;
			}

		}

		if (dispo == 0) {
			cbA6.setEnabled(false);
			
		} else {
			cbA6.setEnabled(true);

		}

		if(!cbA6.isEnabled()) {
			cbA6.setToolTipText("Accesorio no disponible para este modelo.");
		}
		
		
		JLabel lbl_txtprecio = new JLabel("Augmento en el precio:");
		lbl_txtprecio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		
		
		
		JLabel lbl_precio = new JLabel("0");

		Border border = LineBorder.createGrayLineBorder();
		lbl_precio.setBorder(border);

		JButton btn_atras = new JButton("ATRAS");

		btn_atras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				frame.setVisible(false);

			}
		});

		JButton btn_finalizar = new JButton("FINALIZAR");
		btn_finalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				File file = new File("fs_employee.txt");
				if (file.exists()) {
					FileWriter fw;
					BufferedWriter bw;
					try {
						fw = new FileWriter(file.getAbsoluteFile(), true);
						bw = new BufferedWriter(fw);
						PrintWriter pwr = new PrintWriter(bw);
						pwr.write("\r\nAccesorios:");
						if (cbA1.isSelected()) {
							pwr.write("\r\n" + cbA1.getText());
						}
						if (cbA2.isSelected()) {
							pwr.write("\r\n" + cbA2.getText());
						}
						if (cbA3.isSelected()) {
							pwr.write("\r\n" + cbA3.getText());
						}
						if (cbA4.isSelected()) {
							pwr.write("\r\n" + cbA4.getText());
						}
						if (cbA5.isSelected()) {
							pwr.write("\r\n" + cbA5.getText());
						}
						if (cbA6.isSelected()) {
							pwr.write("\r\n" + cbA6.getText());
						}
						pwr.write("\r\nAumento en el precio:" + lbl_precio.getText());
						pwr.write("\r\n---------------------------------");
						pwr.close();
						bw.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				Form_SubModelos fsm = new Form_SubModelos();
				JFrame ventana2 = new JFrame("Resumen");
				ventana2.setSize(400,150);
				ventana2.setLayout(new BorderLayout());
				JTextArea jtx = new JTextArea();
				
				jtx.setEditable(false);
				jtx.append(fsm.getTextoSubmodelo()+"\nAccesorios Selecionados: \n");

				ventana2.add(jtx);
				ventana2.setVisible(true);
				JCheckBox[] checkBoxes = {cbA1,cbA2,cbA3,cbA4,cbA5,cbA6};
				for(int i=0;i<checkBoxes.length;i++) {
					if(checkBoxes[i].isSelected()) {
						jtx.append(checkBoxes[i].getText()+"\n");
					}
				}
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout
				.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addGap(21).addComponent(lbl_submodelo)
								.addContainerGap(82, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup().addContainerGap(225, Short.MAX_VALUE)
								.addComponent(lbl_titulo).addGap(104))
						.addGroup(groupLayout
								.createSequentialGroup().addGap(62).addGroup(groupLayout
										.createParallelGroup(Alignment.TRAILING, false).addGroup(groupLayout
												.createSequentialGroup()
												.addComponent(btn_atras, GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addGap(66).addComponent(btn_finalizar, GroupLayout.PREFERRED_SIZE, 167,
														GroupLayout.PREFERRED_SIZE))
										.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
												.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
														.addComponent(cbA1, Alignment.LEADING)
														.addComponent(cbA2, Alignment.LEADING)
														.addComponent(cbA3, Alignment.LEADING)
														.addComponent(lbl_txtprecio, Alignment.LEADING,
																GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE))
												.addGap(86)
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
														.addComponent(lbl_precio, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(cbA6, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(cbA5).addComponent(cbA4))))
								.addContainerGap(63, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addContainerGap().addComponent(lbl_titulo).addGap(18)
				.addComponent(lbl_submodelo).addGap(30)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(cbA1).addComponent(cbA4))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(cbA2).addComponent(cbA5))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(cbA3).addComponent(cbA6))
				.addGap(18).addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)).addGap(45)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lbl_txtprecio)
						.addComponent(lbl_precio, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
				.addGap(33).addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(btn_atras)
						.addComponent(btn_finalizar))
				.addContainerGap(86, Short.MAX_VALUE)));
		frame.getContentPane().setLayout(groupLayout);
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
}
