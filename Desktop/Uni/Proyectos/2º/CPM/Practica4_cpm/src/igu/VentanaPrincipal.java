package igu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jvnet.substance.SubstanceLookAndFeel;

import logica.Articulo;
import logica.Catalogo;
import logica.Pedido;

import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JTextArea;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private JLabel lbLogo;
	private JLabel lbnombredelaempresa;
	private JLabel lbArticulos;
	private JComboBox<Articulo> cbArticulos;
	private JLabel lbUnidades;
	private JTextField txUnidades;
	private JButton btncomprar;
	private JLabel lbPrecioPedido;
	private JTextField txPrecioPedido;
	private JButton btSiguiente;
	private JButton btnNewButton;
	
	Catalogo cat=new Catalogo();
	Pedido ped=new Pedido();
	VentanaConfirmacion vc=new VentanaConfirmacion();
	private JTextArea txtrA;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame.setDefaultLookAndFeelDecorated(true);
					JDialog.setDefaultLookAndFeelDecorated(true);
					SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.DustSkin");
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
		setResizable(false);
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
		
		JButton btnPlus = new JButton("+\n");
		btnPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int aux=0;
				aux=Integer.parseInt(txUnidades.getText())+1;
				txUnidades.setText(String.valueOf(aux));
			}
		});
		btnPlus.setBounds(502, 206, 42, 29);
		contentPane.add(btnPlus);
		
		JButton btnMinus = new JButton("-\n");
		btnMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int aux=0;
				aux=Integer.parseInt(txUnidades.getText())-1;
				txUnidades.setText(String.valueOf(aux));
			}
		});
		btnMinus.setBounds(537, 206, 42, 29);
		contentPane.add(btnMinus);
		
		txtrA = new JTextArea();
		txtrA.setLineWrap(true);
		txtrA.setWrapStyleWord(true);
		txtrA.setText("");
		txtrA.setBounds(20, 247, 276, 147);
		contentPane.add(txtrA);
	}
	
	private void cambiarJText(String prod,String num)
	{
		if(txtrA.getText()=="")
		{
			txtrA.setText(prod+"  -  "+num+" uds"+"\n");
		}
		else
		{
			txtrA.append(prod+"  -  "+num+" uds"+"\n");
		}
	}
	
	private void completar()
	{
		String prod=((Articulo) getCbArticulos().getSelectedItem()).getDenominacion();
		int num=((Articulo) getCbArticulos().getSelectedItem()).getUnidades();
		
		cambiarJText(prod,String.valueOf(num));
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
			cbArticulos.setEditable(true);
			cbArticulos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					txUnidades.setText("");
				}
			});
			cbArticulos.setModel(new DefaultComboBoxModel(cat.getArticulos()));
			cbArticulos.setBounds(20, 210, 276, 20);
			
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
			txUnidades.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent arg0) {
					txUnidades.setText("1");
					txUnidades.selectAll();
				}
				@Override
				public void focusLost(FocusEvent e) {
					int unidades=0;
					boolean error=false;
					try
					{
						unidades=Integer.parseInt(txUnidades.getText());
					}
					catch(NumberFormatException ex)
					{
						error=true;
					}
					if(error || unidades<0)
					{
						txUnidades.setText("");
					}
				}
			});
			txUnidades.setBounds(327, 210, 145, 20);
			txUnidades.setColumns(10);
		}
		return txUnidades;
	}

	private JButton getBtncomprar() {
		if (btncomprar == null) {
			btncomprar = new JButton("Comprar");
			btncomprar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try
					{
						int uds=Integer.parseInt(txUnidades.getText());
						Articulo articuloSeleccionado=(Articulo)getCbArticulos().getSelectedItem();
						ped.add(articuloSeleccionado, uds);
						if(btSiguiente.isEnabled()==false)
						{
							btSiguiente.setEnabled(true);
						}
						
						if(articuloSeleccionado.getUnidades()>=10)
						{
							JOptionPane.showMessageDialog(null, "Se ha aplicado un descuento del 15% en el artiÌ�culo"+ articuloSeleccionado.getDenominacion());
						}
						getTxPrecioPedido().setText(String.valueOf(ped.calcularTotalSinIva()));
						
					}
					catch(NumberFormatException ex)
					{
						JOptionPane.showMessageDialog(null, "Deben ser introducidos numeros");
					}
					completar();
				}
			});
			btncomprar.setMnemonic('o');
			btncomprar.setBounds(494, 260, 89, 23);
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
			txPrecioPedido.setText(String.valueOf(ped.calcularTotalSinIva()));
			txPrecioPedido.setBounds(327, 260, 145, 20);
			txPrecioPedido.setColumns(10);
		}
		return txPrecioPedido;
	}
	private JButton getBtSiguiente() {
		if (btSiguiente == null) {
			btSiguiente = new JButton("Siguiente");
			btSiguiente.setEnabled(false);
			btSiguiente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				if(btSiguiente.isEnabled())
				{
					vc.setVisible(true);
					ped.grabarPedido("UO25873.txt");
				}
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
	public Pedido getPedido()
	{
		return ped;
	}
}
