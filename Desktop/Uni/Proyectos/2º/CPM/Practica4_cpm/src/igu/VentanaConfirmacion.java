package igu;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.Pedido;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaConfirmacion extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txCodigo;
	private Pedido ped=new Pedido();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VentanaConfirmacion dialog = new VentanaConfirmacion();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VentanaConfirmacion() {
		setTitle("Confirmacion de Pedido");
		setBounds(100, 100, 525, 322);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setForeground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("New label");
			lblNewLabel.setIcon(new ImageIcon(VentanaConfirmacion.class.getResource("/img/ok.png")));
			lblNewLabel.setBounds(32, 34, 53, 58);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lbAviso = new JLabel("Estamos procesando su pedido");
			lbAviso.setFont(new Font("Tahoma", Font.BOLD, 22));
			lbAviso.setBounds(120, 40, 348, 36);
			contentPanel.add(lbAviso);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("El codigo de recogida es: ");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblNewLabel_1.setBounds(32, 141, 238, 24);
			contentPanel.add(lblNewLabel_1);
		}
		{
			txCodigo = new JTextField();
			txCodigo.setText("UO2giHdoihew");
			txCodigo.setEditable(false);
			txCodigo.setBounds(280, 146, 188, 20);
			contentPanel.add(txCodigo);
			txCodigo.setColumns(10);
		}
		{
			JButton btFinalizar = new JButton("Finalizar");
			btFinalizar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ped.grabarPedido("cliente.txt");
					ped.inicializar();
					System.exit(0);
				}
			});
			btFinalizar.setMnemonic('f');
			btFinalizar.setBounds(379, 207, 89, 23);
			contentPanel.add(btFinalizar);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}

}
