package igu;
import java.awt.Color;

import javax.swing.*;

public class Ventana extends JFrame{
	
	private JPanel panelPrincipal;
	private JButton botonAceptar;
	private JLabel nombre;
	private JTextField cuadro;
	
	public Ventana()
	{
		setTitle("ventana de ejemplo");
		setBounds(10,10,500,500);
		setLocationRelativeTo(null);
		
		panelPrincipal=new JPanel();
		
		panelPrincipal.setBackground(Color.white);
		setContentPane(panelPrincipal);
		panelPrincipal.setLayout(null);
		
		botonAceptar=new JButton();
		botonAceptar.setText("aceptar");
		botonAceptar.setBounds(50,80,200,50);
		panelPrincipal.add(botonAceptar);
		
		nombre=new JLabel();
		cuadro=new JTextField();
		nombre.setText("Nombre: ");
		panelPrincipal.add(nombre);
		nombre.setBounds(30,30,150,30);
		cuadro.setBounds(90,30,200,35);		
		panelPrincipal.add(cuadro);
		
		
		
	}
	public static void main(String[] args) {
	
		Ventana v=new Ventana();
		v.setVisible (true);
		

	}

}
