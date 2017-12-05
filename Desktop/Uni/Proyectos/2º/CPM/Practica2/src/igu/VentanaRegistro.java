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
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
	}

	/**
	 * Create the frame.
	 */
	public VentanaRegistro() {
		setTitle("Formulario de Registro");
		setBackground(Color.LIGHT_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 362);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLbnombre = new JLabel("lbNombre:");
		lblLbnombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLbnombre.setBounds(29, 45, 106, 14);
		contentPane.add(lblLbnombre);
		
		txtTxnombre = new JTextField();
		txtTxnombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtTxnombre.setText("txNombre");
		txtTxnombre.setBounds(115, 42, 86, 20);
		contentPane.add(txtTxnombre);
		txtTxnombre.setColumns(10);
		
		JLabel lblLbapellido = new JLabel("lbApellido:");
		lblLbapellido.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLbapellido.setBounds(298, 45, 86, 14);
		contentPane.add(lblLbapellido);
		
		txtTxapellido = new JTextField();
		txtTxapellido.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtTxapellido.setText("txApellido");
		txtTxapellido.setBounds(394, 42, 254, 20);
		contentPane.add(txtTxapellido);
		txtTxapellido.setColumns(10);
		contentPane.add(getPanelSexo());
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new TitledBorder(null, "Fecha de Nacimiento", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(377, 125, 294, 71);
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
	}
	public JPanel getPanelSexo() {
		if (panelSexo == null) {
			panelSexo = new JPanel();
			panelSexo.setBorder(new TitledBorder(null, "Sexo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelSexo.setBackground(Color.WHITE);
			panelSexo.setBounds(73, 125, 237, 71);
			panelSexo.add(getRdbtnRbhombre());
			
			rdbtnRbmujer = new JRadioButton("rbMujer");
			buttonGroup.add(rdbtnRbmujer);
			rdbtnRbmujer.setBackground(Color.WHITE);
			panelSexo.add(rdbtnRbmujer);
		}
		return panelSexo;
	}
	public JRadioButton getRdbtnRbhombre() {
		if (rdbtnRbhombre == null) {
			rdbtnRbhombre = new JRadioButton("rbHombre");
			buttonGroup.add(rdbtnRbhombre);
			rdbtnRbhombre.setBackground(Color.WHITE);
		}
		return rdbtnRbhombre;
	}
	public JComboBox getCbDias() {
		if (cbDias == null) {
			cbDias = new JComboBox();
			cbDias.setBounds(23, 40, 28, 20);
		}
		return cbDias;
	}
	public JComboBox getCbMeses() {
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
	public JButton getBtSiguiente() {
		if (btSiguiente == null) {
			btSiguiente = new JButton("Siguiente");
			btSiguiente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//si hay algun campo vacio o no coinciden las contrsaseñas
					JOptionPane.showMessageDialog(null,"ha habido un error");
				}
			});
			btSiguiente.setBounds(444, 269, 89, 23);
		}
		return btSiguiente;
	}
	public JButton getBtCancelar() {
		if (btCancelar == null) {
			btCancelar = new JButton("Cancelar");
			btCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.exit(0);
				}
			});
			btCancelar.setBounds(568, 269, 89, 23);
		}
		return btCancelar;
	}
}
