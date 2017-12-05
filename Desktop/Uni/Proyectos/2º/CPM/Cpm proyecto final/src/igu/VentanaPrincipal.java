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
import java.awt.Image;
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
import javax.swing.JScrollPane;

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
	
	VentanaRegistro vR;
	Catalogo cat;
	Pedido ped;
	
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
					SubstanceLookAndFeel.setSkin("org.jvnet.substance.api.skin.GeminiSkin");
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
		this.cat=new Catalogo();
		this.ped=new Pedido();
		setResizable(false);
		setLocationRelativeTo(null);
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
		btnPlus.setMnemonic('+');
		btnPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int aux=0;
				int unidades=Integer.parseInt(txUnidades.getText());
				if(unidades>0) {
				aux=Integer.parseInt(txUnidades.getText())+1;
				txUnidades.setText(String.valueOf(aux));
				}
				else
					
				{
					txUnidades.grabFocus();
				}
			}
		});
		btnPlus.setBounds(492, 207, 42, 29);
		contentPane.add(btnPlus);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 261, 264, 117);
		contentPane.add(scrollPane);
		
		txtrA = new JTextArea();
		txtrA.setText(ped.mostrarPedido());
		txtrA.setWrapStyleWord(true);
		txtrA.setLineWrap(true);
		scrollPane.setViewportView(txtrA);
		
		JButton btnEliminar = new JButton("Eliminar\n");
		btnEliminar.setMnemonic('e');
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					int uds=Integer.parseInt(txUnidades.getText())*-1;
					Articulo articuloSeleccionado=(Articulo)getCbArticulos().getSelectedItem();
					ped.eliminar(articuloSeleccionado, uds);
					if(btSiguiente.isEnabled()==false)
					{
						btSiguiente.setEnabled(true);
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
		btnEliminar.setBounds(446, 314, 83, 29);
		contentPane.add(btnEliminar);
		adaptarImagen(btncomprar, "/img/carrito.png");
	}

	
	private void completar()
	{
		String prod=((Articulo) getCbArticulos().getSelectedItem()).getDenominacion();
		int num=((Articulo) getCbArticulos().getSelectedItem()).getUnidades();
		txtrA.setText(ped.mostrarPedido());
		//cambiarJText(prod,String.valueOf(num));
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
			lbUnidades = new JLabel("Uds:");
			lbUnidades.setLabelFor(getTxUnidades());
			lbUnidades.setBounds(308, 213, 42, 14);
		}
		return lbUnidades;
	}
	
	
	private JTextField getTxUnidades() {
		if (txUnidades == null) {
			txUnidades = new JTextField();
			txUnidades.setText("1");
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
			txUnidades.setBounds(350, 210, 107, 20);
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
			btncomprar.setBounds(336, 314, 83, 29);
		}
		return btncomprar;
	}
	

	private void adaptarImagen(JButton boton, String rutaImagen) {
			Image imgOriginal = null;
			try {
				imgOriginal = new ImageIcon(getClass().getResource(rutaImagen))
						.getImage();
			} catch (Exception e) {
				imgOriginal = new ImageIcon(getClass().getResource(rutaImagen)).getImage();
			}
			Image imgCarrito = imgOriginal.getScaledInstance((int) (boton.getWidth()), (int) (boton.getHeight()),
					Image.SCALE_FAST);

			boton.setIcon(null);

			boton.setDisabledIcon(new ImageIcon(imgCarrito));
		}

	private JLabel getLbPrecioPedido() {
		if (lbPrecioPedido == null) {
			lbPrecioPedido = new JLabel("Precio del Pedido: ");
			lbPrecioPedido.setLabelFor(getTxPrecioPedido());
			lbPrecioPedido.setBounds(308, 264, 145, 14);
		}
		return lbPrecioPedido;
	}
	private JTextField getTxPrecioPedido() {
		if (txPrecioPedido == null) {
			txPrecioPedido = new JTextField();
			txPrecioPedido.setText(devuelvePrecio());
			txPrecioPedido.setBounds(440, 261, 89, 20);
			txPrecioPedido.setColumns(10);
		}
		return txPrecioPedido;
	}
	public String devuelvePrecio()
	{
		if(ped.calcularTotalSinIva()<0)
		{
			return "0";
		}else {
			return String.valueOf(ped.calcularTotalSinIva());
		}	
	}
	
	private JButton getBtSiguiente() {
		if (btSiguiente == null) {
			btSiguiente = new JButton("Siguiente");
			btSiguiente.setEnabled(false);
			btSiguiente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				if(btSiguiente.isEnabled())
				{
					mostrarVentanaRegistro();
				}
				}
			});
			
			
			btSiguiente.setMnemonic('s');
			btSiguiente.setBounds(336, 355, 89, 23);
		}
		return btSiguiente;
	
	}
	private void mostrarVentanaRegistro()
	{
		vR=new VentanaRegistro(ped,this);
		vR.setLocationRelativeTo(this);
		//vReg.setModal(true);
		vR.setVisible(true);
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
			btnNewButton.setBounds(440, 355, 94, 23);
			
		}
		return btnNewButton;
	}
	public Pedido getPedido()
	{
		return ped;
	}

	public void inicializar()
	{
		txUnidades.setText("");
		txPrecioPedido.setText("");
		btSiguiente.setEnabled(false);
		cbArticulos.setSelectedIndex(0);
		txtrA.setText("");
	}
}