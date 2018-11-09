package Ventanas;
 
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

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.Color;

public class Form_ModeloCoche extends JFrame implements ICoches{

	
	private int seleccion;
	private String mChoose;
	private JPanel contentPane;
	
	public static void main(String[] args) {
		run();
	}
	
	public static void run() {
				try {
					Form_ModeloCoche frame = new Form_ModeloCoche();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			
	}	
	public Form_ModeloCoche() {
		setTitle("Concesionario Esteve");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 555, 598);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("SELECCIONAR EL MODELO DEL COCHE ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));

		Form_Login fl= new Form_Login();
		JLabel lblUsuario = new JLabel("Usuario: "+fl.nom); 

		JTextPane txtDescripcion = new JTextPane();

		JLabel lblCoche = new JLabel("");
		lblCoche.setBackground(Color.WHITE);

		// boton 1
		JButton btnAlhambra = new JButton();
		ImageIcon alhambra = new ImageIcon("imagenes/alhambra.jpg");
		btnAlhambra.setIcon(alhambra);
		
		ImageIcon coche1 = new ImageIcon("imagenes/alhambra_label.jpg");
		lblCoche.setIcon(coche1);
		txtDescripcion.setText(
				"SEAT ALHAMBRA:\n-7 plazas con 5 asientos plegables\n-Climatizador\n-Volante multifunción\n-Bluetooth\n-Faros antiniebla con función cornering\n-Cristales traseros oscurecidos");
		seleccion=1;
		mChoose = "M01";

		btnAlhambra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ImageIcon coche1 = new ImageIcon("imagenes/alhambra_label.jpg");
				lblCoche.setIcon(coche1);
				txtDescripcion.setText(
						"SEAT ALHAMBRA:\n-7 plazas con 5 asientos plegables\n-Climatizador\n-Volante multifunción\n-Bluetooth\n-Faros antiniebla con función cornering\n-Cristales traseros oscurecidos");
				seleccion=1;
				mChoose = "M01";
			}
		});

		// boton 2
		JButton btnIbiza = new JButton();
		ImageIcon ibiza = new ImageIcon("imagenes/ibiza.png");
		btnIbiza.setIcon(ibiza);

		btnIbiza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ImageIcon coche2 = new ImageIcon("imagenes/ibiza_label.png");
				lblCoche.setIcon(coche2);
				txtDescripcion.setText("SEAT IBIZA:\n-Climatizador\n-Volante multifunción\n-Bluetooth\n-Faros antiniebla con función cornering\n-Cristales traseros oscurecidos");
				seleccion=2;
				mChoose = "M02";
			}
		});

		// boton 3
		JButton btnLeon = new JButton();
		ImageIcon leon = new ImageIcon("imagenes/leon.png");
		btnLeon.setIcon(leon);

		btnLeon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ImageIcon coche3 = new ImageIcon("imagenes/leon_label.png");
				lblCoche.setIcon(coche3);
				txtDescripcion.setText("SEAT LEON:\n-Climatizador\n-Volante multifunción\n-Bluetooth\n-Faros antiniebla con función cornering\n-Cristales traseros oscurecidos");
				seleccion=3;
				mChoose = "M03";
			}
		});

		// boton 4
		JButton btnToledo = new JButton();
		ImageIcon toledo = new ImageIcon("imagenes/toledo.png");
		btnToledo.setIcon(toledo);

		btnToledo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ImageIcon coche4 = new ImageIcon("imagenes/toledo_label.png");
				lblCoche.setIcon(coche4);
				txtDescripcion.setText("SEAT TOLEDO:\n-Climatizador\n-Volante multifunción\n-Bluetooth\n-Faros antiniebla con función cornering\n-Cristales traseros oscurecidos");
				seleccion=4;
				mChoose = "M04";
			}
		});

		// boton 5
		JButton btnMii = new JButton();
		ImageIcon mii = new ImageIcon("imagenes/mii.png");
		btnMii.setIcon(mii);

		btnMii.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ImageIcon coche5 = new ImageIcon("imagenes/mii_label.png");
				lblCoche.setIcon(coche5);
				txtDescripcion.setText("SEAT MII:\n-Climatizador\n-Volante multifunción\n-Bluetooth\n-Faros antiniebla con función cornering\n-Cristales traseros oscurecidos");
				seleccion=5;
				mChoose = "M05";
			}
		});

		JButton btnAnterior = new JButton("Anterior");
		
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				setVisible(false);
				
			}
		});

		JButton btnSiguiente = new JButton("Siguiente");
		
		
		
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if(seleccion==1) {
					File file = new File("fs_employee.txt");
					if (file.exists()) {
						FileWriter fw;
						BufferedWriter bw;
						try {
							fw = new FileWriter(file.getAbsoluteFile(), true);
							bw = new BufferedWriter(fw);
							PrintWriter pwr = new PrintWriter(bw);
							pwr.write("\r\nModelo: Seat Alhambra");
							pwr.write("\r\n---------------------------------");
							pwr.close();
							bw.close();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					Form_SubModelos fsm =new Form_SubModelos(mChoose);
					fsm.run(mChoose);
				
				
				}else if(seleccion==2) {
					File file = new File("fs_employee.txt");
					if (file.exists()) {
						FileWriter fw;
						BufferedWriter bw;
						try {
							fw = new FileWriter(file.getAbsoluteFile(), true);
							bw = new BufferedWriter(fw);
							PrintWriter pwr = new PrintWriter(bw);
							pwr.write("\r\nModelo: Seat Ibiza");
							pwr.write("\r\n---------------------------------");
							pwr.close();
							bw.close();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					Form_SubModelos fsm =new Form_SubModelos(mChoose);
					fsm.run(mChoose);
				
				
				}else if(seleccion==3) {
					File file = new File("fs_employee.txt");
					if (file.exists()) {
						FileWriter fw;
						BufferedWriter bw;
						try {
							fw = new FileWriter(file.getAbsoluteFile(), true);
							bw = new BufferedWriter(fw);
							PrintWriter pwr = new PrintWriter(bw);
							pwr.write("\r\nModelo: Seat Leon");
							pwr.write("\r\n---------------------------------");
							pwr.close();
							bw.close();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					Form_SubModelos fsm =new Form_SubModelos(mChoose);
					fsm.run(mChoose);
				
				
				}else if(seleccion==4) {
					File file = new File("fs_employee.txt");
					if (file.exists()) {
						FileWriter fw;
						BufferedWriter bw;
						try {
							fw = new FileWriter(file.getAbsoluteFile(), true);
							bw = new BufferedWriter(fw);
							PrintWriter pwr = new PrintWriter(bw);
							pwr.write("\r\nModelo: Seat Toledo");
							pwr.write("\r\n---------------------------------");
							pwr.close();
							bw.close();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					Form_SubModelos fsm =new Form_SubModelos(mChoose);
					fsm.run(mChoose);
				
				
				}else if(seleccion==5) {
					File file = new File("fs_employee.txt");
					if (file.exists()) {
						FileWriter fw;
						BufferedWriter bw;
						try {
							fw = new FileWriter(file.getAbsoluteFile(), true);
							bw = new BufferedWriter(fw);
							PrintWriter pwr = new PrintWriter(bw);
							pwr.write("\r\nModelo: Seat Mii");
							pwr.write("\r\n---------------------------------");
							pwr.close();
							bw.close();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					Form_SubModelos fsm =new Form_SubModelos(mChoose);
					fsm.run(mChoose);
				
				
				}else {
					
				}
			}
		});

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane
				.setHorizontalGroup(
						gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addGroup(
												gl_contentPane.createParallelGroup(Alignment.LEADING)
														.addGroup(gl_contentPane.createSequentialGroup().addGap(53)
																.addComponent(lblNewLabel).addGap(79)
																.addComponent(lblUsuario))
														.addGroup(gl_contentPane.createSequentialGroup().addGap(162)
																.addComponent(btnAnterior))
														.addGroup(gl_contentPane.createSequentialGroup()
																.addContainerGap()
																.addGroup(gl_contentPane
																		.createParallelGroup(Alignment.TRAILING, false)
																		.addGroup(gl_contentPane.createSequentialGroup()
																				.addGroup(gl_contentPane
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(btnLeon,
																								GroupLayout.PREFERRED_SIZE,
																								120,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(btnIbiza,
																								GroupLayout.PREFERRED_SIZE,
																								120,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(btnAlhambra,
																								GroupLayout.PREFERRED_SIZE,
																								120,
																								GroupLayout.PREFERRED_SIZE))
																				.addGap(48)
																				.addComponent(lblCoche,
																						GroupLayout.PREFERRED_SIZE, 357, GroupLayout.PREFERRED_SIZE)
																				.addGap(20))
																		.addGroup(gl_contentPane.createSequentialGroup()
																				.addGroup(gl_contentPane
																						.createParallelGroup(
																								Alignment.TRAILING)
																						.addComponent(btnSiguiente)
																						.addGroup(Alignment.LEADING,
																								gl_contentPane
																										.createSequentialGroup()
																										.addGroup(
																												gl_contentPane
																														.createParallelGroup(
																																Alignment.LEADING)
																														.addComponent(
																																btnToledo,
																																GroupLayout.PREFERRED_SIZE,
																																120,
																																GroupLayout.PREFERRED_SIZE)
																														.addComponent(
																																btnMii,
																																GroupLayout.PREFERRED_SIZE,
																																120,
																																GroupLayout.PREFERRED_SIZE))
																										.addPreferredGap(
																												ComponentPlacement.RELATED,
																												115,
																												Short.MAX_VALUE)
																										.addComponent(
																												txtDescripcion,
																												GroupLayout.PREFERRED_SIZE,
																												252,
																												GroupLayout.PREFERRED_SIZE)))
																				.addGap(58)))))
										.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGroup(
								gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addGroup(
												gl_contentPane.createSequentialGroup().addGap(308)
														.addComponent(btnToledo, GroupLayout.PREFERRED_SIZE, 80,
																GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(
																btnMii, GroupLayout.PREFERRED_SIZE, 80,
																GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup()
												.addContainerGap().addGroup(
														gl_contentPane.createParallelGroup(Alignment.BASELINE)
																.addComponent(lblNewLabel).addComponent(lblUsuario))
												.addGap(20)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
														.addGroup(gl_contentPane.createSequentialGroup()
																.addComponent(btnAlhambra, GroupLayout.PREFERRED_SIZE,
																		80, GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(btnIbiza, GroupLayout.PREFERRED_SIZE, 80,
																		GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(btnLeon, GroupLayout.PREFERRED_SIZE,
																		80, GroupLayout.PREFERRED_SIZE))
														.addComponent(lblCoche, Alignment.TRAILING,
																GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE))
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addComponent(txtDescripcion)))
						.addPreferredGap(ComponentPlacement.RELATED, 37, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(btnAnterior)
								.addComponent(btnSiguiente))
						.addContainerGap(13, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);
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
