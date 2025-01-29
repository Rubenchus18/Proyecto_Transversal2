package vista;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import controlador.*;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

public class Vista extends JFrame {

	private static final long serialVersionUID = 1L;
	public  JPanel contentPane;
	public JPanel panelInicio;
	public JLabel lblLogo;
	public JLabel lblFondo;
	public JLabel lblTexto;
	public JButton btnEmpezar;
	public  JPanel panelPlantilla;
	public JLabel lblfondocesped;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vista vista = new Vista();
					Controlador controlador=new Controlador(vista);

					vista.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Vista() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1337, 773);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		  ImageIcon imagenApp = (ajustarTamañoImg("imagenes/logo.png", 64, 64));
		  setTitle("DreamDraft");
	       setIconImage(imagenApp.getImage()); 
	       setLocationRelativeTo(null);
	       setResizable(false); 
	        
		setContentPane(contentPane);
		 contentPane.setLayout(null);
		
		 panelInicio = new JPanel();
		 panelInicio.setBounds(0, 0, 1329, 742);
		contentPane.add(panelInicio);
		panelInicio.setLayout(null);
		 
		 lblTexto = new JLabel("Comienza");
		 lblTexto.setFont(new Font("Consolas", Font.BOLD, 45));
		 lblTexto.setBounds(470, 547, 281, 78);
		 panelInicio.add(lblTexto);
		 
		 btnEmpezar = new JButton("");
		 btnEmpezar.setBounds(741, 530, 193, 106);
		 btnEmpezar.setContentAreaFilled(false); 
		 btnEmpezar.setBorderPainted(false); 
		 btnEmpezar.setFocusPainted(false);
		 btnEmpezar.setOpaque(false); 
		 panelInicio.add(btnEmpezar);
		
		 lblLogo = new JLabel("");
		lblLogo.setBounds(450, 98, 500, 338);
		panelInicio.add(lblLogo);
		
		 lblFondo = new JLabel("");
		lblFondo.setBounds(0, 0, 1329, 825);
		panelInicio.add(lblFondo);
		
		panelPlantilla = new JPanel();
		panelPlantilla.setBounds(0, 0, 1329, 742);
		contentPane.add(panelPlantilla);
		panelPlantilla.setLayout(null);
		
		lblfondocesped = new JLabel("");
		lblfondocesped.setBounds(0, 0, 1329, 825);
		panelPlantilla.add(lblfondocesped);
	}
	
	public static ImageIcon ajustarTamañoImg(String ruta, int ancho, int alto) {
        ImageIcon imagen = new ImageIcon((ruta));
        Image imagenOriginal = imagen.getImage();
        Image imagenAjustada = imagenOriginal.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        return new ImageIcon(imagenAjustada);
    }//FIN AJUSTAR TAMAÑO IMG
}
