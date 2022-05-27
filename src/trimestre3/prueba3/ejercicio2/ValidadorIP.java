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

import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/*
 * Tipo enumerado con las clases de direcciones IP existentes
 */
enum ClasesIP { A, B, C, ESPECIAL};

public class ValidadorIP {

	private JFrame frmValidadorDeDirecciones;
	private JTextField txtOcteto1;
	private JTextField txtOcteto2;
	private JTextField txtOcteto3;
	private JTextField txtOcteto4;
	private JButton btnLimpiar;
	private JLabel lblResultado;
	final String ERROR="La dirección IP no es válida";
	
	/**
	 * campos par guardar el valor de cada octeto
	 */
	private int octeto1, octeto2,octeto3,octeto4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ValidadorIP window = new ValidadorIP();
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
	public ValidadorIP() {
		initialize();
	}
	
	/**
	 * Método para validar un octeto de una dirección IP
	 * @param valor Cadena con el valor del octeto
	 * @return valor entero convertido del octedo
	 * @throws Exception si el valor no es un número válido o no está en el rango permitido (0-255)
	 */
	int validarOcteto(String valor) throws Exception{
		try {
			int octeto= Integer.parseInt(valor);
			if (octeto<0 || octeto>255)
				throw new Exception("Valores fuera de rango");
			return octeto;
			//se tratan correctamente las excepciones tamto por estar fuera de rango como por
		} catch (Exception e) {
			throw e;
		}
		
	}
	
	/**
	 * Método para validar y recoger la direción IP de los campos de texto del formulario
	 * @return Verdadero si se pueden recoger los 4 campos de direcciones y son válidas, Falso en otro caso
	 */
	boolean recogerDireccionIP() {
		try {
			this.octeto1=validarOcteto(txtOcteto1.getText());
			this.octeto2=validarOcteto(txtOcteto2.getText());
			this.octeto3=validarOcteto(txtOcteto3.getText());
			this.octeto4=validarOcteto(txtOcteto4.getText());
			return true;
		} catch (Exception e) {
			//falla alguna validación, por tanto la dirección no es válida
			return false;
		}
	}
	
	/**
	 * Método para determinar la clase a la que pertenece una dirección IP a partir de sus octetos
	 * @return Clase de la dirección IP, tomada del tipo enumerado ClasesIP
	 */
	ClasesIP calcularClase() {
		if (this.octeto1<128){
			return ClasesIP.A;
		} else if (octeto1<192) {
			return ClasesIP.B;
		} else if (octeto1<224) {
			return ClasesIP.C;
		} else {
			return ClasesIP.ESPECIAL;
		}
	}
	
	
	/**
	 * Método para determinar si una dirección IP es pública o privada
	 * @return Verdadero si la dirección es Privada, Falso en otro caso
	 */
	boolean esPrivada() {
		boolean privada=false;
		switch (calcularClase()) {
			case A:
				if (this.octeto1==10 || this.octeto1==127) {
					privada=true;
					break;
				}
				
			case B:
				if (this.octeto1==172) {
					if (this.octeto2>=16 && this.octeto2<=31) {
						privada=true;
					}
					
					break;
				}
				
			case C:
				if (this.octeto1==192 && this.octeto2==168) {
					privada=true;
				}
				break;
			case ESPECIAL:
				break;
			
		}//fin del switch
		return privada;
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
		pnResultado.setBorder(new LineBorder(new Color(0, 0, 0)));
		frmValidadorDeDirecciones.getContentPane().add(pnResultado);
		pnResultado.setLayout(null);
		
		lblResultado = new JLabel("");
		lblResultado.setForeground(Color.RED);
		lblResultado.setHorizontalAlignment(SwingConstants.CENTER);
		lblResultado.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblResultado.setBounds(27, 21, 240, 34);
		lblResultado.setVisible(false);
		pnResultado.add(lblResultado);
		
		JPanel pnBotonera = new JPanel();
		pnBotonera.setBorder(new LineBorder(new Color(0, 0, 0)));
		frmValidadorDeDirecciones.getContentPane().add(pnBotonera);
		pnBotonera.setLayout(null);
		
		JButton btnValidar = new JButton("Validar");
		btnValidar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				if (!recogerDireccionIP()) {
					//si al validar la dirección IP, no es correcta
				
					lblResultado.setText(ERROR);
				} else {
					//la dirección es válida, determinamos su clase y la indicamos en resultado
					String resultado="La dirección es de clase "+calcularClase();
					//si no es de clase especial, vemos además si es pública o privaa
					if (calcularClase()!=ClasesIP.ESPECIAL) {
						resultado += (esPrivada()?" Privada":" Pública");
					}
					lblResultado.setText(resultado);
					
					
					
				}
				//activamos la etiqueta
				lblResultado.setVisible(true);
			}
		});
		btnValidar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnValidar.setBounds(38, 30, 89, 23);
		pnBotonera.add(btnValidar);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//limpiamos todos los campos de texto
				txtOcteto1.setText("");
				txtOcteto2.setText("");
				txtOcteto3.setText("");
				txtOcteto4.setText("");
				//ocultamos el campo de resultado
				lblResultado.setVisible(false);
			}
		});
		btnLimpiar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLimpiar.setBounds(154, 31, 89, 23);
		pnBotonera.add(btnLimpiar);
	}
}
