import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class LlavePrivada extends JFrame {


	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LlavePrivada frame = new LlavePrivada();
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
	public LlavePrivada() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 591, 303);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton abrirExplorador = new JButton("ABRE EL EXPLORADOR DE ARCHIVOS Y ELIGE EL TEXTO A DESCIFRAR");
		abrirExplorador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Exploradordearchivos();
			}
		});
		abrirExplorador.setBounds(31, 11, 525, 41);
		contentPane.add(abrirExplorador);
		
		
	}
	
	public void Exploradordearchivos() {
		  JFileChooser fileChooser = new JFileChooser();

        int seleccion = fileChooser.showOpenDialog(null);

        if (seleccion == JFileChooser.APPROVE_OPTION) {
            String rutaArchivo = fileChooser.getSelectedFile().getAbsolutePath();
            File archivbo = new File(rutaArchivo);
            if(archivbo.exists()) {
            	Scanner leer = null;
				try {
					leer = new Scanner(archivbo);
				} catch (FileNotFoundException e) {
					// TODO Bloque catch generado automáticamente
					e.printStackTrace();
				}
            	String TextoDescifrado;
    			while(leer.hasNextLine()) {
    				String linea = leer.nextLine();
    				TextoDescifrado = linea.
    						replace('@','a').
    						replace('˘','b').
    						replace('~','c').
    						replace('÷','d' ).
    						replace('̅','e').
    						replace('˿','f').
    						replace('̔','g').
    						replace(':','h').
    						replace(';','i').
    						replace('}','j').
    						replace('{','k').
    						replace('%','l').
    						replace('/','m').
    						replace('^','n').
    						replace('|','ñ').
    						replace('?','o').
    						replace('+','p').
    						replace('*','q').
    						replace('&','r').
    						replace('#','s').
    						replace('-','t').
    						replace('<','u').
    						replace('.','v').
    						replace('>','w').
    						replace(',','x').
    						replace(']','y').
    						replace('[','z').
    						replace('0','₼').
    						replace('1','¿').
    						replace('₼','0').
    						replace('¿','1').
    						replace('₾','2').
    						replace('⃀' ,'3').
    						replace('₿' ,'4').
    						replace('ↄ','5').
    						replace('₽','6').
    						replace('Ⱡ','7' ).
    						replace('ⱸ','8' ).
    						replace('⸗', '9' );
    				
    				String Name = null;
    				try {
    					Name = JOptionPane.showInputDialog("Nombre del archivo(Agrega la terminacion *.txt*)");
    					String SaveTextCifrado = Name;
    					
    					
    					FileWriter lapiz = new FileWriter(SaveTextCifrado);
    					
    					lapiz.write(TextoDescifrado);
    					lapiz.close();
    					JOptionPane.showMessageDialog(null,"Texto descifrado con exito.","Archivo Creado", JOptionPane.INFORMATION_MESSAGE);
    				}catch(IOException e) {
    					e.printStackTrace();
    				}
    				
    				
    				try {
    					File SaveTextCifrado = new File(Name);
    					FileReader Lector = new FileReader(SaveTextCifrado);
    					BufferedReader Texto1 = new BufferedReader(Lector);
    					
    					String linea1;
    					StringBuilder contenido = new StringBuilder();
    					
    					while((linea1 = Texto1.readLine())!= null) {
    						contenido.append(linea1).append("\n");
    					}
    					Lector.close();
    					Texto1.close();
    					JTextArea textoMostrarP = new JTextArea();
    					textoMostrarP.setWrapStyleWord(true);
    					textoMostrarP.setLineWrap(true);
    					textoMostrarP.setEditable(false);
    					textoMostrarP.setBounds(41, 63, 502, 190);
    					contentPane.add(textoMostrarP);
    					textoMostrarP.setText(contenido.toString());
    					
    				}catch(IOException e) {
    					e.printStackTrace();
    				
    			}
    			}
    			leer.close();
        		
        		
            }
            
            String archivo = rutaArchivo;
            System.out.println(archivo);
    		
    		
    		
			
    		
		}
        }
	}


	

