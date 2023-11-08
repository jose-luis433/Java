import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DropMode;
import javax.swing.JFormattedTextField;
import javax.swing.SwingConstants;
import javax.swing.JScrollBar;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;

public class LlavePublica extends JFrame {

	private JPanel contentPane;
	private static JTextField ingresar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LlavePublica frame = new LlavePublica();
					frame.setVisible(true);
					ingresar.requestFocus();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LlavePublica() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 512, 375);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton encriptar = new JButton("ENCRIPTAR");
		
		contentPane.add(encriptar);
		
		JLabel lblNewLabel = new JLabel("TEXTO QUE SE DESEA CIFRAR");
		lblNewLabel.setForeground(new Color(0, 255, 0));
		lblNewLabel.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 18));
		lblNewLabel.setBounds(117, 12, 304, 23);
		contentPane.add(lblNewLabel);
		
		JButton btnEncriptar = new JButton("ENCRIPTAR");
		btnEncriptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				cifrar();
			}
		});
		btnEncriptar.setBounds(185, 91, 104, 23);
		contentPane.add(btnEncriptar);
		
		ingresar = new JTextField();
		ingresar.setToolTipText("Ingresa Texto");
		ingresar.setForeground(new Color(128, 255, 128));
		ingresar.setBackground(new Color(0, 0, 0));
		ingresar.setBounds(160, 46, 188, 23);
		contentPane.add(ingresar);
		ingresar.setColumns(10);
		
		
		JLabel lblNewLabel_1 = new JLabel("Ingresa el mensaje");
		lblNewLabel_1.setForeground(new Color(0, 255, 255));
		lblNewLabel_1.setBounds(25, 50, 125, 14);
		contentPane.add(lblNewLabel_1);
		
		
		

	}
	
	public  void cifrar() {
		String textoCifrar = ingresar.getText().toLowerCase();
		
		String TextoCifrado ;
		
		
		TextoCifrado = textoCifrar.
				replace('a','@').
				replace('b','˘').
				replace('c', '~').
				replace('d', '÷').
				replace('e', '̅').
				replace('f', '˿').
				replace('g', '̔').
				replace('h', ':').
				replace('i', ';').
				replace('j', '}').
				replace('k', '{').
				replace('l', '%').
				replace('m', '/').
				replace('n', '^').
				replace('ñ', '|').
				replace('o', '?').
				replace('p', '+').
				replace('q', '*').
				replace('r', '&').
				replace('s', '#').
				replace('t', '-').
				replace('u', '<').
				replace('v', '.').
				replace('w', '>').
				replace('x', ',').
				replace('y', ']').
				replace('z', '[').
				replace('0', '₼').
				replace('1','¿').
				replace('2', '₾').
				replace('3', '⃀').
				replace('4', '₿').
				replace('5', 'ↄ').
				replace('6', '₽').
				replace('7', 'Ⱡ').
				replace('8', 'ⱸ').
				replace('9', '⸗');
		//TextoCifrado
		String SaveTextCifrado;
		String Name = null;
		try {
			
			 Name = JOptionPane.showInputDialog("Nombre del archivo(Agrega la terminacion *.txt*)");
			
			SaveTextCifrado= Name;
			
			FileWriter lapiz = new FileWriter(SaveTextCifrado);
			lapiz.write(TextoCifrado);
			lapiz.close();
			JOptionPane.showMessageDialog(null,"Texto cifrado con exito.","Archivo Creado", JOptionPane.INFORMATION_MESSAGE);
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		
		try {
			File SaveTextCifrado1 = new File(Name);
			FileReader Lector = new FileReader(SaveTextCifrado1);
			BufferedReader Texto = new BufferedReader(Lector);
			
			String linea;
			StringBuilder contenido = new StringBuilder();
			
			while((linea = Texto.readLine())!= null) {
				contenido.append(linea).append("\n");
			}
			Lector.close();
			Texto.close();
			JTextArea textoMostrarP = new JTextArea();
			textoMostrarP.setWrapStyleWord(true);
			textoMostrarP.setLineWrap(true);
			textoMostrarP.setEditable(false);
			textoMostrarP.setBounds(60, 127, 333, 125);
			contentPane.add(textoMostrarP);
			textoMostrarP.setText(contenido.toString());
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
