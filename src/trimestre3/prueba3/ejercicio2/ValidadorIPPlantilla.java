package trimestre3.prueba3.ejercicio2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.FlowLayout;

public class ValidadorIPPlantilla {

	private JFrame frmValidadorDeDirecciones;
	private JTextField txtOcteto1;
	private JTextField txtOcteto2;
	private JTextField txtOcteto3;
	private JTextField txtOcteto4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ValidadorIPPlantilla window = new ValidadorIPPlantilla();
					window.frmValidadorDeDirecciones.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ValidadorIPPlantilla() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmValidadorDeDirecciones = new JFrame();
		frmValidadorDeDirecciones.setTitle("Validador de Direcciones IP");
		frmValidadorDeDirecciones.setBounds(100, 100, 304, 300);
		frmValidadorDeDirecciones.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmValidadorDeDirecciones.getContentPane().setLayout(new GridLayout(3, 1, 0, 10));
		
		JPanel pnDireccion = new JPanel();
		pnDireccion.setBorder(new LineBorder(new Color(0, 0, 0)));
		frmValidadorDeDirecciones.getContentPane().add(pnDireccion);
		pnDireccion.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Escriba los 4 octetos de la direcci\u00F3n IP:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(24, 11, 303, 21);
		pnDireccion.add(lblNewLabel);
		
		txtOcteto1 = new JTextField();
		txtOcteto1.setBounds(34, 49, 53, 20);
		pnDireccion.add(txtOcteto1);
		txtOcteto1.setColumns(3);
		
		txtOcteto2 = new JTextField();
		txtOcteto2.setColumns(3);
		txtOcteto2.setBounds(97, 49, 53, 20);
		pnDireccion.add(txtOcteto2);
		
		txtOcteto3 = new JTextField();
		txtOcteto3.setColumns(3);
		txtOcteto3.setBounds(160, 49, 53, 20);
		pnDireccion.add(txtOcteto3);
		
		txtOcteto4 = new JTextField();
		txtOcteto4.setColumns(3);
		txtOcteto4.setBounds(223, 49, 53, 20);
		pnDireccion.add(txtOcteto4);
		
		JPanel pnResultado = new JPanel();
		FlowLayout flowLayout = (FlowLayout) pnResultado.getLayout();
		flowLayout.setVgap(0);
		flowLayout.setHgap(0);
		pnResultado.setBorder(new LineBorder(new Color(0, 0, 0)));
		frmValidadorDeDirecciones.getContentPane().add(pnResultado);
		
		JPanel pnBotonera = new JPanel();
		pnBotonera.setBorder(new LineBorder(new Color(0, 0, 0)));
		frmValidadorDeDirecciones.getContentPane().add(pnBotonera);
		pnBotonera.setLayout(null);
		
		JButton btnValidar = new JButton("Validar");
		btnValidar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnValidar.setBounds(105, 30, 89, 23);
		pnBotonera.add(btnValidar);
	}
}
