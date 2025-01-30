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
	public JPanel PanelPlantilla;
	public JLabel lblFondoPlantilla;
	public JButton btnNewButton_1;
	public JButton btnNewButton_2;
	public JButton btnNewButton_3;
	public JButton btnNewButton_4;
	public JButton btnNewButton_5;
	public JButton btnNewButton_6;
	public JButton btnNewButton_7;
	public JButton btnNewButton_8;
	public JButton btnNewButton_9;
	public JButton btnNewButton_10;
	public JButton btnDelanteroIzquierda;
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
		  
		   PanelPlantilla = new JPanel();
		   PanelPlantilla.setBounds(0, 0, 1329, 742);
		   PanelPlantilla.setVisible(false);
		   contentPane.add(PanelPlantilla);
		   PanelPlantilla.setLayout(null);
		    
		    btnNewButton_10 = new JButton("");
		    btnNewButton_10.setBounds(626, 622, 85, 91);
		    PanelPlantilla.add(btnNewButton_10);
		    
		    btnNewButton_9 = new JButton("");
		    btnNewButton_9.setBounds(870, 482, 85, 91);
		    PanelPlantilla.add(btnNewButton_9);
		    
		    btnNewButton_4 = new JButton("");
		    btnNewButton_4.setBounds(747, 343, 85, 91);
		    PanelPlantilla.add(btnNewButton_4);
		    
		    btnNewButton_8 = new JButton("");
		    btnNewButton_8.setBounds(747, 482, 85, 91);
		    PanelPlantilla.add(btnNewButton_8);
		    
		    btnNewButton_7 = new JButton("");
		    btnNewButton_7.setBounds(525, 482, 85, 91);
		    PanelPlantilla.add(btnNewButton_7);
		    
		    btnNewButton_6 = new JButton("");
		    btnNewButton_6.setBounds(403, 482, 85, 91);
		    PanelPlantilla.add(btnNewButton_6);
		    
		    btnNewButton_5 = new JButton("");
		    btnNewButton_5.setBounds(870, 343, 85, 91);
		    PanelPlantilla.add(btnNewButton_5);
		    
		    btnNewButton_3 = new JButton("");
		    btnNewButton_3.setBounds(525, 343, 85, 91);
		    PanelPlantilla.add(btnNewButton_3);
		    
		    btnNewButton_2 = new JButton("");
		    btnNewButton_2.setBounds(403, 343, 85, 91);
		    PanelPlantilla.add(btnNewButton_2);
		    
		    btnNewButton_1 = new JButton("");
		    btnNewButton_1.setBounds(735, 148, 85, 91);
		    PanelPlantilla.add(btnNewButton_1);
		    
		     btnDelanteroIzquierda = new JButton("");
		    btnDelanteroIzquierda.setBounds(525, 148, 85, 91);
		    PanelPlantilla.add(btnDelanteroIzquierda);
		   
		    lblFondoPlantilla = new JLabel("");
		    lblFondoPlantilla.setBounds(0, 0, 1329, 742);
		    PanelPlantilla.add(lblFondoPlantilla);
		 
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
	}
	
	public static ImageIcon ajustarTamañoImg(String ruta, int ancho, int alto) {
        ImageIcon imagen = new ImageIcon((ruta));
        Image imagenOriginal = imagen.getImage();
        Image imagenAjustada = imagenOriginal.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        return new ImageIcon(imagenAjustada);
    }//FIN AJUSTAR TAMAÑO IMG
}
