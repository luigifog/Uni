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
	private Pedido ped;
	private JTextField txtEw;
	VentanaPrincipal vP;
	VentanaRegistro vr;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			VentanaConfirmacion dialog = new VentanaConfirmacion();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
*/
	
	public void cambiarImporteTotal()
	{
		txtEw.setText(ped.calcularTotalSinIva()+"");
	}
	/**
	 * Create the dialog.
	 */
	public VentanaConfirmacion(Pedido p,VentanaPrincipal vP,VentanaRegistro vr) {
		this.vP=vP;
		this.ped=p;
		this.vr=vr;
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
			txCodigo.setText(ped.codigoPedido());
			txCodigo.setEditable(false);
			txCodigo.setBounds(280, 146, 188, 20);
			contentPanel.add(txCodigo);
			txCodigo.setColumns(10);
		}
		{
			JButton btFinalizar = new JButton("Finalizar");
			btFinalizar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cerrar();
				}
			});
			btFinalizar.setMnemonic('f');
			btFinalizar.setBounds(379, 207, 89, 23);
			contentPanel.add(btFinalizar);
		}
		
		
		txtEw = new JTextField();
		txtEw.setEditable(false);
		txtEw.setText(ped.calcularTotalSinIva()+"");
		txtEw.setBounds(280, 176, 198, 20);
		contentPanel.add(txtEw);
		txtEw.setColumns(10);
		
		JLabel lblElImporteTotal = new JLabel("El importe total es:");
		lblElImporteTotal.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblElImporteTotal.setBounds(32, 179, 188, 14);
		contentPanel.add(lblElImporteTotal);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}
	private void cerrar()

	{
		ped.grabarPedido("cliente.txt", vr.datos());
		ped.inicializar();
		vP.inicializar();
		vr.dispose();
		this.dispose();
	}
}
