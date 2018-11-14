package Ventanas;


import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JCheckBox;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import Idao.IAccesories;
import Idao.ISubmodels;
import XML.Read_XMLAccesories;
import XML.Read_XMLSubmodels;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.awt.event.ActionEvent;

public class Form_ExtrasCoche {

	private JFrame frmConcesionarioEsteve;
	private String a1, a2, a3, a4, a5, a6;
	private String[] availableM;
	private int dispo, suma = 0, precio = 0;
	private static String sumatxt, preciotxt;
	private JLabel lbl_precio;
	private static JCheckBox[] checkBoxes;


	/**
	 * Launch the application.
	 */
	public void run(String modelo, String submodelo, String nombre_sm) {
		try {
			Form_ExtrasCoche window = new Form_ExtrasCoche(modelo, submodelo, nombre_sm);
			window.frmConcesionarioEsteve.setVisible(true);
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

	public Form_ExtrasCoche() {

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String modelo, String submodelo, String nombre_sm) {
		frmConcesionarioEsteve = new JFrame();
		frmConcesionarioEsteve.setTitle("Concesionario Esteve");
		frmConcesionarioEsteve.setIconImage(Toolkit.getDefaultToolkit().getImage("imagenes/et.png"));
		frmConcesionarioEsteve.setBounds(100, 100, 541, 490);
		frmConcesionarioEsteve.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel lbl_titulo = new JLabel("Compra de Accesorios");
		lbl_titulo.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JLabel lbl_submodelo = new JLabel(submodelo);
		lbl_submodelo.setFont(new Font("Tahoma", Font.PLAIN, 12));

		IAccesories gestorA = new Read_XMLAccesories();
		ISubmodels gestorS = new Read_XMLSubmodels();

		
		JCheckBox cbA1 = new JCheckBox(gestorA.getAccesoryAll().get(0).getName());

		JCheckBox cbA2 = new JCheckBox(gestorA.getAccesoryAll().get(1).getName());

		JCheckBox cbA3 = new JCheckBox(gestorA.getAccesoryAll().get(2).getName());

		JCheckBox cbA4 = new JCheckBox(gestorA.getAccesoryAll().get(3).getName());

		JCheckBox cbA5 = new JCheckBox(gestorA.getAccesoryAll().get(4).getName());

		JCheckBox cbA6 = new JCheckBox(gestorA.getAccesoryAll().get(5).getName());

		// Comprobante de que el accesorio esta dispnible en el submodelo
		// elegido en la ventana anterior

		// ACCESORIO 1

		availableM = gestorA.getAccesoryAll().get(0).getModel_available();
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

		if (!cbA1.isEnabled()) {
			cbA1.setToolTipText("Accesorio no disponible para este modelo.");
		}

		// ACCESORIO 2

		availableM = gestorA.getAccesoryAll().get(1).getModel_available();
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

		if (!cbA2.isEnabled()) {
			cbA2.setToolTipText("Accesorio no disponible para este modelo.");
		}

		// ACCESORIO 3

		availableM = gestorA.getAccesoryAll().get(2).getModel_available();
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

		if (!cbA3.isEnabled()) {
			cbA3.setToolTipText("Accesorio no disponible para este modelo.");
		}

		// ACCESORIO 4

		availableM = gestorA.getAccesoryAll().get(3).getModel_available();
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

		if (!cbA4.isEnabled()) {
			cbA4.setToolTipText("Accesorio no disponible para este modelo.");
		}

		// ACCESORIO 5

		availableM = gestorA.getAccesoryAll().get(4).getModel_available();
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

		if (!cbA5.isEnabled()) {
			cbA5.setToolTipText("Accesorio no disponible para este modelo.");
		}

		// ACCESORIO 6

		availableM = gestorA.getAccesoryAll().get(5).getModel_available();
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

		if (!cbA6.isEnabled()) {
			cbA6.setToolTipText("Accesorio no disponible para este modelo.");
		}

		JLabel lbl_txtprecio = new JLabel("Augmento en el precio:");
		lbl_txtprecio.setFont(new Font("Tahoma", Font.PLAIN, 16));

		for (int i = 0; i < gestorS.getSubmodelAll().size(); i++) {

			if (nombre_sm.equals(gestorS.getSubmodelAll().get(i).getName())) {
				lbl_precio = new JLabel(gestorS.getSubmodelAll().get(i).getPrice());

				suma = Integer.parseInt(lbl_precio.getText());

			}

		}

		cbA1.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				int precio = Integer.parseInt(gestorA.getAccesoryAll().get(0).getPrice());
				if (cbA1.isSelected()) {
					suma = suma + precio;
				} else {
					suma = suma - precio;
				}

				sumatxt = suma + "";

				lbl_precio.setText(sumatxt);

			}

		});

		cbA2.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				int precio = Integer.parseInt(gestorA.getAccesoryAll().get(1).getPrice());
				if (cbA2.isSelected()) {
					suma = suma + precio;
				} else {
					suma = suma - precio;
				}

				sumatxt = suma + "";

				lbl_precio.setText(sumatxt);

			}

		});

		cbA3.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				int precio = Integer.parseInt(gestorA.getAccesoryAll().get(2).getPrice());
				if (cbA3.isSelected()) {
					suma = suma + precio;
				} else {
					suma = suma - precio;
				}

				sumatxt = suma + "";

				lbl_precio.setText(sumatxt);

			}

		});

		cbA4.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				int precio = Integer.parseInt(gestorA.getAccesoryAll().get(3).getPrice());
				if (cbA4.isSelected()) {
					suma = suma + precio;
				} else {
					suma = suma - precio;
				}

				sumatxt = suma + "";

				lbl_precio.setText(sumatxt);

			}

		});

		cbA5.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				int precio = Integer.parseInt(gestorA.getAccesoryAll().get(4).getPrice());
				if (cbA5.isSelected()) {
					suma = suma + precio;
				} else {
					suma = suma - precio;
				}

				sumatxt = suma + "";

				lbl_precio.setText(sumatxt);

			}

		});

		cbA6.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				int precio = Integer.parseInt(gestorA.getAccesoryAll().get(5).getPrice());
				if (cbA6.isSelected()) {
					suma = suma + precio;
				} else {
					suma = suma - precio;
				}

				sumatxt = suma + "";

				lbl_precio.setText(sumatxt);

			}

		});

		Border border = LineBorder.createGrayLineBorder();
		lbl_precio.setBorder(border);

		JButton btn_atras = new JButton("ATRAS");

		btn_atras.addActionListener(new ActionListener() {
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
							if (!datos[0].equals("CARACTERISTICAS")) {
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
				frmConcesionarioEsteve.setVisible(false);
				archivo.delete();
				File renombre = new File("fs_employee.txt");
				archivo2.renameTo(renombre);
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
						pwr.write("ACCESORIOS - ");
						if (cbA1.isSelected()) {
							pwr.write(cbA1.getText() + " --- ");
						}
						if (cbA2.isSelected()) {
							pwr.write(cbA2.getText() + " --- ");
						}
						if (cbA3.isSelected()) {
							pwr.write(cbA3.getText() + " --- ");
						}
						if (cbA4.isSelected()) {
							pwr.write(cbA4.getText() + " --- ");
						}
						if (cbA5.isSelected()) {
							pwr.write(cbA5.getText() + " --- ");
						}
						if (cbA6.isSelected()) {
							pwr.write(cbA6.getText() + " --- ");
						}
						pwr.write("Aumento en el precio: " + lbl_precio.getText());
						pwr.close();
						bw.close();

						// renombrar txt con fecha y hora quitando "dades
						// temporals"
						String linea;
						File archivo = new File("fs_employee.txt");
						File archivo2 = new File("copia.txt");
						if (archivo.exists()) {
							try {
								FileReader fr2 = new FileReader(archivo);
								BufferedReader br2 = new BufferedReader(fr2);
								FileWriter fw2 = new FileWriter(archivo2);
								BufferedWriter bw2 = new BufferedWriter(fw2);
								PrintWriter pwr2 = new PrintWriter(bw2);
								while ((linea = br2.readLine()) != null) {
									String[] datos = linea.split(" ");
									if (!datos[0].equals("DADES")) {
										pwr2.write(linea + "\r\n");
									}
								}
								br2.close();
								pwr2.close();
							} catch (FileNotFoundException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}

						// xml
						String line;
						File archivoAleer = new File("copia.txt");
						if (archivoAleer.exists()) {
							try {
								FileReader fr3 = new FileReader(archivoAleer);
								BufferedReader br3 = new BufferedReader(fr3);
								try {
									DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
									DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
									Document doc = docBuilder.newDocument();
									// raiz
									Element presupueto = doc.createElement("Presupueto");
									doc.appendChild(presupueto);
									while ((line = br3.readLine()) != null) {
										String[] datos = line.split(" ");
										if (datos[0].equals("LOGIN")) {
											String resultado = line;
											// primera ventana
											Element usuario = doc.createElement("Usuario");
											usuario.appendChild(doc.createTextNode(resultado.toString()));
											presupueto.appendChild(usuario);
										} else if (datos[0].equals("DATOS")) {
											String resultado = line;
											// segunda ventana
											Element cliente = doc.createElement("Datos");
											cliente.appendChild(doc.createTextNode(resultado.toString()));
											presupueto.appendChild(cliente);
										}else if (datos[0].equals("MODELO")) {
											String resultado = line;
											// tercera ventana
											Element modelo = doc.createElement("Modelo");
											modelo.appendChild(doc.createTextNode(resultado.toString()));
											presupueto.appendChild(modelo);
										}else if (datos[0].equals("CARACTERISTICAS")) {
											String resultado = line;
											// cuarta ventana
											Element caracteristicas = doc.createElement("Caracteristicas");
											caracteristicas.appendChild(doc.createTextNode(resultado.toString()));
											presupueto.appendChild(caracteristicas);
										}else if (datos[0].equals("ACCESORIOS")) {
											String resultado = line;
											// quinta ventana
											Element accesorios = doc.createElement("Accesorios");
											accesorios.appendChild(doc.createTextNode(resultado.toString()));
											presupueto.appendChild(accesorios);
										}
									}
									br3.close();

									SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy_HH.mm.ss",
											Locale.getDefault());
									Date now = new Date(System.currentTimeMillis());
									String fechayhora = formato.format(now);

									TransformerFactory transformerFactory = TransformerFactory.newInstance();
									Transformer transformer = transformerFactory.newTransformer();
									DOMSource source = new DOMSource(doc);
									StreamResult result = new StreamResult(
											new File("fs_employee_" + fechayhora + ".xml"));

									transformer.transform(source, result);

								} catch (ParserConfigurationException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} catch (TransformerConfigurationException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} catch (TransformerException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							} catch (FileNotFoundException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

						}

						//

						//
						// // tercera ventana
						// Element modelo = doc.createElement("Modelo");
						// modelo.appendChild(doc.createTextNode("pasara tercer
						// ventana"));
						// presupueto.appendChild(modelo);
						//
						// // cuarta ventana
						// Element caracteristicas =
						// doc.createElement("Caracteristicas");
						// caracteristicas.appendChild(doc.createTextNode("asdasd"));
						// presupueto.appendChild(caracteristicas);
						//
						// // quinta ventana
						// Element accesorios = doc.createElement("Accesorios");
						// accesorios.appendChild(doc.createTextNode("asdasd"));
						// presupueto.appendChild(accesorios);
						//

						SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy_HH.mm.ss", Locale.getDefault());
						Date now = new Date(System.currentTimeMillis());
						String fechayhora = formato.format(now);

						archivo.delete();
						File renombre = new File("fs_employee_" + fechayhora + ".txt");
						archivo2.renameTo(renombre);

						// crear txt vacio
						File archivoVacio = new File("fs_employee.txt");
						FileWriter fw2 = new FileWriter(archivoVacio);
						BufferedWriter bw2 = new BufferedWriter(fw2);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

				checkBoxes = new JCheckBox[] { cbA1, cbA2, cbA3, cbA4, cbA5, cbA6 };
				Form_Resumen fr = new Form_Resumen();
				fr.run();
			}
		});
		GroupLayout groupLayout = new GroupLayout(frmConcesionarioEsteve.getContentPane());
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
		frmConcesionarioEsteve.getContentPane().setLayout(groupLayout);
	}

	
	public JCheckBox[] getCheckBoxes() {
		return checkBoxes;

	}
	
	public String getSumaPrecio() {
		return sumatxt;
	}

}
