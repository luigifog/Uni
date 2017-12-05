package igu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private JLabel lbLogo;
	private JLabel lbnombredelaempresa;
	private JLabel lbArticulos;
	private JComboBox cbArticulos;
	private JLabel lbUnidades;
	private JTextField txUnidades;
	private JButton btncomprar;
	private JLabel lbPrecioPedido;
	private JTextField txPrecioPedido;
	private JButton btSiguiente;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/img/logo.jpg")));
		setTitle("Venta de accesorios de ordenador");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 614, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLbLogo());
		contentPane.add(getLbnombredelaempresa());
		contentPane.add(getLbArticulos());
		contentPane.add(getCbArticulos());
		contentPane.add(getLbUnidades());
		contentPane.add(getTxUnidades());
		contentPane.add(getBtncomprar());
		contentPane.add(getLbPrecioPedido());
		contentPane.add(getTxPrecioPedido());
		contentPane.add(getBtSiguiente());
		contentPane.add(getBtnNewButton());
	}
	private JLabel getLbLogo() {
		if (lbLogo == null) {
			lbLogo = new JLabel("New label");
			lbLogo.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/logo.jpg")));
			lbLogo.setBounds(10, 11, 135, 147);
		}
		return lbLogo;
	}
	private JLabel getLbnombredelaempresa() {
		if (lbnombredelaempresa == null) {
			lbnombredelaempresa = new JLabel("PC ACCESORIOS");
			lbnombredelaempresa.setHorizontalAlignment(SwingConstants.CENTER);
			lbnombredelaempresa.setForeground(Color.MAGENTA);
			lbnombredelaempresa.setFont(new Font("Tahoma", Font.BOLD, 20));
			lbnombredelaempresa.setBounds(249, 36, 218, 30);
		}
		return lbnombredelaempresa;
	}
	private JLabel getLbArticulos() {
		if (lbArticulos == null) {
			lbArticulos = new JLabel("Articulos: ");
			lbArticulos.setLabelFor(getCbArticulos());
			lbArticulos.setBounds(20, 185, 155, 14);
		}
		return lbArticulos;
	}
	private JComboBox getCbArticulos() {
		if (cbArticulos == null) {
			cbArticulos = new JComboBox();
			cbArticulos.setBounds(20, 210, 229, 20);
		}
		return cbArticulos;
	}
	private JLabel getLbUnidades() {
		if (lbUnidades == null) {
			lbUnidades = new JLabel("Unidades:");
			lbUnidades.setLabelFor(getTxUnidades());
			lbUnidades.setBounds(327, 185, 145, 14);
		}
		return lbUnidades;
	}
	private JTextField getTxUnidades() {
		if (txUnidades == null) {
			txUnidades = new JTextField();
			txUnidades.setBounds(327, 210, 145, 20);
			txUnidades.setColumns(10);
		}
		return txUnidades;
	}

	private JButton getBtncomprar() {
		if (btncomprar == null) {
			btncomprar = new JButton("Comprar");
			btncomprar.setMnemonic('o');
			btncomprar.setBounds(484, 209, 89, 23);
		}
		return btncomprar;
	}
	private JLabel getLbPrecioPedido() {
		if (lbPrecioPedido == null) {
			lbPrecioPedido = new JLabel("Precio del Pedido: ");
			lbPrecioPedido.setLabelFor(getTxPrecioPedido());
			lbPrecioPedido.setBounds(327, 241, 145, 14);
		}
		return lbPrecioPedido;
	}
	private JTextField getTxPrecioPedido() {
		if (txPrecioPedido == null) {
			txPrecioPedido = new JTextField();
			txPrecioPedido.setBounds(327, 260, 145, 20);
			txPrecioPedido.setColumns(10);
		}
		return txPrecioPedido;
	}
	private JButton getBtSiguiente() {
		if (btSiguiente == null) {
			btSiguiente = new JButton("Siguiente");
			btSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				mostrarVentanaRegistro();
			}
		});
			btSiguiente.setMnemonic('s');
			btSiguiente.setBounds(383, 350, 89, 23);
		}
		return btSiguiente;
	}
	private void mostrarVentanaRegistro()
	{
		VentanaRegistro vReg=new VentanaRegistro();
		vReg.setLocationRelativeTo(this);
		//vReg.setModal(true);
		vReg.setVisible(true);
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Cancelar");
			btnNewButton.setMnemonic('c');
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.exit(0);
				}
			});
			btnNewButton.setBounds(482, 350, 89, 23);
			
		}
		return btnNewButton;
	}
}
