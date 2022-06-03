package ordinario.ejercicio6;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConvertirLongitudResuelto {

	//constante de conversión
	static final double FACTOR_CONVERSION= 3.2808;
	private JFrame frmConversorDeLongitudes;
	private JTextField textMetros;
	private JTextField textPies;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConvertirLongitudResuelto window = new ConvertirLongitudResuelto();
					window.frmConversorDeLongitudes.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ConvertirLongitudResuelto() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmConversorDeLongitudes = new JFrame();
		frmConversorDeLongitudes.setTitle("Conversor de Longitudes");
		frmConversorDeLongitudes.setBounds(100, 100, 330, 281);
		frmConversorDeLongitudes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmConversorDeLongitudes.getContentPane().setLayout(null);
		
		JPanel pnDatos = new JPanel();
		pnDatos.setBorder(new TitledBorder(null, "Valores", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnDatos.setBounds(10, 11, 293, 101);
		frmConversorDeLongitudes.getContentPane().add(pnDatos);
		pnDatos.setLayout(null);
		
		JLabel lblMetros = new JLabel("Valor en metros:");
		lblMetros.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMetros.setBounds(20, 21, 118, 19);
		pnDatos.add(lblMetros);
		
		JLabel lblPies = new JLabel("Valor en pies:");
		lblPies.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPies.setBounds(20, 62, 118, 19);
		pnDatos.add(lblPies);
		
		textMetros = new JTextField();
		textMetros.setBounds(127, 20, 95, 20);
		pnDatos.add(textMetros);
		textMetros.setColumns(10);
		
		textPies = new JTextField();
		textPies.setColumns(10);
		textPies.setBounds(127, 61, 95, 20);
		pnDatos.add(textPies);
		
		JPanel pnAcciones = new JPanel();
		pnAcciones.setLayout(null);
		pnAcciones.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Acciones", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnAcciones.setBounds(10, 123, 293, 111);
		frmConversorDeLongitudes.getContentPane().add(pnAcciones);
		
		JLabel lblErrores = new JLabel("");
		lblErrores.setForeground(Color.RED);
		lblErrores.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblErrores.setBounds(10, 28, 273, 26);
		pnAcciones.add(lblErrores);
		
		JButton btnMetrosPies = new JButton("Metros -> Pies");
		btnMetrosPies.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblErrores.setText("");
				try {
					double metros= Double.parseDouble(textMetros.getText());
					//convertimos y mostramos el resultado 
					if (metros>=0) {
						textPies.setText(String.format("%.2f",metros*FACTOR_CONVERSION));
					} else {
						lblErrores.setText("El valor a convertir no puede ser negativo");
					}
				}catch (NumberFormatException err) {
					lblErrores.setText("Has introducido un valor no numérico");
				}
			}
		});
		btnMetrosPies.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnMetrosPies.setForeground(new Color(0, 0, 0));
		btnMetrosPies.setBounds(10, 65, 125, 23);
		pnAcciones.add(btnMetrosPies);
		
		JButton btnPiesMetros = new JButton("Pies -> Metros");
		btnPiesMetros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				lblErrores.setText("");
				try {
					double pies= Double.parseDouble(textPies.getText());
					//convertimos y mostramos el resultado 
					if (pies>=0) {
						textMetros.setText(String.format("%.2f",pies/FACTOR_CONVERSION));
					} else {
						lblErrores.setText("El valor a convertir no puede ser negativo");
					}
				}catch (NumberFormatException err) {
					lblErrores.setText("Has introducido un valor no numérico");
				}
			}
		});
		btnPiesMetros.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnPiesMetros.setForeground(Color.BLACK);
		btnPiesMetros.setBounds(145, 65, 125, 23);
		pnAcciones.add(btnPiesMetros);
	}
}
