package igu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;

import java.awt.Component;

import javax.swing.Box;
import javax.swing.JTextPane;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.border.TitledBorder;

import logica.Pedido;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPasswordField;

public class VentanaRegistro extends JFrame {
	private JPanel contentPane;
	private JTextField txtTxnombre;
	private JTextField txtTxapellido;
	private JPanel panelSexo;
	private JRadioButton rdbtnRbhombre;
	private JRadioButton rdbtnRbmujer;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JPanel panel;
	private JComboBox cbDias;
	private JComboBox cbMeses;
	private JComboBox cbAnios;
	private JLabel lblDia;
	private JLabel lblMes;
	private JLabel lblAo;
	private JButton btSiguiente;
	private JButton btCancelar;
	private JTextField txtNombre;
	private JPasswordField txtContra;
	private JPasswordField passwordField_1;
	private JPasswordField txtContra2;
	
	Pedido p;
	VentanaPrincipal vP;
	
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {

				try {
					VentanaRegistro frame = new VentanaRegistro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public VentanaRegistro(Pedido p, VentanaPrincipal vP) {
		this.vP=vP;
		this.p=p;
		setTitle("Formulario de Registro");
		setBackground(Color.LIGHT_GRAY);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 362);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLbnombre = new JLabel("Nombre:");
		lblLbnombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLbnombre.setBounds(29, 45, 106, 14);
		contentPane.add(lblLbnombre);
		
		txtTxnombre = new JTextField();
		txtTxnombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTxnombre.setText("\r\n");
		txtTxnombre.setBounds(115, 42, 86, 20);
		contentPane.add(txtTxnombre);
		txtTxnombre.setColumns(10);
		JLabel lblLbapellido = new JLabel("Apellido:");
		lblLbapellido.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLbapellido.setBounds(298, 45, 86, 14);
		contentPane.add(lblLbapellido);
		
		txtTxapellido = new JTextField();
		txtTxapellido.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTxapellido.setBounds(394, 42, 254, 20);
		contentPane.add(txtTxapellido);
		txtTxapellido.setColumns(10);
		contentPane.add(getPanelSexo());
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new TitledBorder(null, "Fecha de Nacimiento", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(373, 95, 294, 71);
		contentPane.add(panel);
		panel.setLayout(null);
		panel.add(getCbDias());
		panel.add(getCbMeses());
		panel.add(getCbAnios());
		panel.add(getLblDia());
		panel.add(getLblMes());
		panel.add(getLblAo());
		contentPane.add(getBtSiguiente());
		contentPane.add(getBtCancelar());
		
		JPanel panelusrctr = new JPanel();
		panelusrctr.setBackground(Color.WHITE);
		panelusrctr.setBounds(29, 192, 294, 104);
		contentPane.add(panelusrctr);
		panelusrctr.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario:");
		lblNewLabel.setBounds(10, 11, 69, 14);
		panelusrctr.add(lblNewLabel);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(125, 8, 146, 20);
		panelusrctr.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Contrase\u00F1a:");
		lblNewLabel_1.setBounds(10, 45, 69, 14);
		panelusrctr.add(lblNewLabel_1);
		
		txtContra = new JPasswordField();
		txtContra.setBounds(125, 42, 146, 20);
		panelusrctr.add(txtContra);
		
		JLabel lblNewLabel_2 = new JLabel("Repita contrase\u00F1a:");
		lblNewLabel_2.setBounds(10, 79, 96, 14);
		panelusrctr.add(lblNewLabel_2);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(262, 76, -139, 20);
		panelusrctr.add(passwordField_1);
		
		txtContra2 = new JPasswordField();
		txtContra2.setBounds(125, 76, 146, 20);
		panelusrctr.add(txtContra2);
		rdbtnRbhombre.setSelected(true);
	}
	public JPanel getPanelSexo() {
		if (panelSexo == null) {
			panelSexo = new JPanel();
			panelSexo.setBorder(new TitledBorder(null, "Sexo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelSexo.setBackground(Color.WHITE);
			panelSexo.setBounds(29, 95, 294, 71);
			panelSexo.add(getRdbtnRbhombre());
			
			rdbtnRbmujer = new JRadioButton("Mujer");
			buttonGroup.add(rdbtnRbmujer);
			rdbtnRbmujer.setBackground(Color.WHITE);
			panelSexo.add(rdbtnRbmujer);
		}
		return panelSexo;
	}
	public JRadioButton getRdbtnRbhombre() {
		if (rdbtnRbhombre == null) {
			rdbtnRbhombre = new JRadioButton("Hombre");
			buttonGroup.add(rdbtnRbhombre);
			rdbtnRbhombre.setBackground(Color.WHITE);
		}
		return rdbtnRbhombre;
	}
	public JComboBox <String >getCbDias() {
		if (cbDias == null) {
			cbDias = new JComboBox();
			cbDias.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
			cbDias.setBounds(6, 40, 63, 20);
		}
		return cbDias;
	}
	public JComboBox<String> getCbMeses() {
		if (cbMeses == null) {
			cbMeses = new JComboBox();
			cbMeses.setModel(new DefaultComboBoxModel(new String[] {"Enero", "Febrero", "Marzo", "Abril", "Mayo ", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"}));
			cbMeses.setBounds(81, 40, 74, 20);
		}
		return cbMeses;
	}
	public JComboBox getCbAnios() {
		if (cbAnios == null) {
			cbAnios = new JComboBox();
			cbAnios.setModel(new DefaultComboBoxModel(new String[] {"1930", "1931", "1932", "1933", "1934", "1935", "1936", "1937", "1938", "1939", "1940", "1941", "1942", "1943", "1944", "1945", "1946", "1947", "1948", "1949", "1950", "1951", "1952", "1953", "1954", "1955", "1956", "1957", "1958", "1959", "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969", "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017"}));
			cbAnios.setBounds(175, 40, 86, 20);
		}
		return cbAnios;
	}
	public JLabel getLblDia() {
		if (lblDia == null) {
			lblDia = new JLabel("Dia");
			lblDia.setBounds(23, 24, 28, 14);
		}
		return lblDia;
	}
	public JLabel getLblMes() {
		if (lblMes == null) {
			lblMes = new JLabel("Mes");
			lblMes.setBounds(81, 24, 46, 14);
		}
		return lblMes;
	}
	public JLabel getLblAo() {
		if (lblAo == null) {
			lblAo = new JLabel("A\u00F1o");
			lblAo.setBounds(175, 24, 46, 14);
		}
		return lblAo;
	}
	public boolean checkPasswords()
	{
		String password = String.valueOf(txtContra.getPassword());
        String password2 = String.valueOf(txtContra2.getPassword());
        if(password.equals( password2))
        {
        	return true;
        }
        return false;
	}
	public JButton getBtSiguiente() {
		if (btSiguiente == null) {
			
			btSiguiente = new JButton("Siguiente");
			btSiguiente.setMnemonic('s');
			Pedido ped= new Pedido();
			btSiguiente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String problema = "";
					if(txtNombre.getText().length()<=0)
					{problema=problema+ " usuario " ;}
					if(String.valueOf(txtContra.getPassword()).length()<=0)
					{problema=problema+ " contrase�a " ;}
					if(String.valueOf(txtContra2.getPassword()).length()<=0)
					{problema=problema+ " contrase�a2 " ;}
					if(txtTxnombre.getText().length()<=0)
					{problema=problema+ " nombre " ;}
					if(txtTxapellido.getText().length()<=0)
					{problema=problema+ " apellido " ;}
					if(rdbtnRbmujer.isSelected()==false && rdbtnRbhombre.isSelected()==false)
					{
						problema=problema+" sexo ";
					}
					if(problema!="")
					{
						JOptionPane.showMessageDialog(null,"falta por rellenar el/los campo/s de: " + problema);
					}
					if(checkPasswords()==false)
					{
						JOptionPane.showMessageDialog(null,"las contrase�as no coinciden");
					}
					if(problema=="" && checkPasswords()==true)
					{
						mostrarVentanaRegistro();
					}
					
					
				}
			});
			btSiguiente.setBounds(444, 269, 89, 23);
		}
		return btSiguiente;
	}
	private void mostrarVentanaRegistro()
	{
		VentanaConfirmacion vC=new VentanaConfirmacion(p, vP,this);
//		vC.setLocationRelativeTo(this);
		//.setModal(true);
		vC.setVisible(true);
	}
	public JButton getBtCancelar() {
		if (btCancelar == null) {
			btCancelar = new JButton("Cancelar");
			btCancelar.setMnemonic('c');
			btCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.exit(0);
				}
			});
			btCancelar.setBounds(568, 269, 89, 23);
		}
		return btCancelar;
	}
	
		public String datos()
		{
			String sexo="";
			if(rdbtnRbhombre.isSelected())
			{
				sexo="hombre";
			}
			if(rdbtnRbmujer.isSelected())
			{
				sexo="mujer";
			}
			return(txtTxnombre.getText()+" "+txtTxapellido.getText()+" "+sexo+
					" "+"fecha de nacimiento : "+getLblDia().getText()+" - "+getLblMes().getText()+" - "+
					getLblAo().getText());
		}
	}

