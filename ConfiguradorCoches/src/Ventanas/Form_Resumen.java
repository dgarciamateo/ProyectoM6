package Ventanas;



import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JCheckBox;

import Ventanas.Form_ExtrasCoche;
import XML.XMLConfig;

import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.LayoutStyle.ComponentPlacement;

import Configuracion.ConfigurationLoader;;

public class Form_Resumen {

	private JFrame frame;

	/**
	 * Launch the application.
	 */

	public void run() {
		try {
			Form_Resumen window = new Form_Resumen();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the application.
	 */
	public Form_Resumen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Resumen Datos");
		frame.setBounds(100, 100, 514, 394);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton btnVolver = new JButton("VOLVER");
		btnVolver.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Window[] windows = Window.getWindows();
				for(int i=0;i<windows.length;i++) {
					windows[i].dispose();
				}
				Form_Login fl = new Form_Login();
				
				fl.run();
			}
		});

		JTextArea jtx = new JTextArea();
		jtx.setFont(new Font("Arial", Font.BOLD, 14));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(55)
					.addComponent(jtx, GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(235, Short.MAX_VALUE)
					.addComponent(btnVolver)
					.addGap(192))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(31)
					.addComponent(jtx, GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btnVolver)
					.addGap(38))
		);
		frame.getContentPane().setLayout(groupLayout);

		Form_SubModelos fsm = new Form_SubModelos();
		Form_ExtrasCoche fxc = new Form_ExtrasCoche();
		jtx.setOpaque(false);
		jtx.setEditable(false);
		jtx.append(fsm.getTextoSubmodelo() + "\n\nAccesorios Seleccionados: \n\n");

		JCheckBox[] cb = fxc.getCheckBoxes();
		for (int i = 0; i < cb.length; i++) {
			if (cb[i].isSelected()) {
				jtx.append("- " + cb[i].getText() + "\n");
			}
		}
		jtx.append("\nPrecio: "+fxc.getSumaPrecio()+"€\n");
		XMLConfig single = ConfigurationLoader.getInstance();
		
		double descuentoP=single.getDiscount();
		int descuento;
		int precioA=Integer.parseInt(fxc.getSumaPrecio());
		int precioB;
		
		descuentoP=descuentoP/100;
		
		
		descuento=(int) (descuentoP*precioA);
		
		precioB=precioA-descuento;
		
		
		/*AQUIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII*/
		jtx.append("\nPrecio con Descuento Aplicado: "+precioB+"€");
	}
}
