package controlador;

import vista.*;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import modelo.*;



public class Controlador implements ActionListener{

	private Vista vista;
	
	public Controlador(Vista vista) {		
		this.vista=vista;
		this.vista.btnEmpezar.addActionListener(this);
		imagenes();
	}
	//Funcionalidad
	  @Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.vista.btnEmpezar) {
			this.vista.panelInicio.setVisible(false);
			this.vista.PanelPlantilla.setVisible(true);
		}
	}
	
	//Metodoos
	public ImageIcon fotoEscalarLabel(JLabel label, String url) {
		ImageIcon imagenDefecto = new ImageIcon(url);
	    ImageIcon icono = new ImageIcon(imagenDefecto.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH));
	    return icono;
	}
	public ImageIcon fotoEscalarButton(JButton label, String url) {
		ImageIcon imagenDefecto = new ImageIcon(url);
	    ImageIcon icono = new ImageIcon(imagenDefecto.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH));
	    return icono;
	}
	public void imagenes() {
		this.vista.lblFondo.setIcon(fotoEscalarLabel(this.vista.lblFondo,"imagenes/fondo-principal.jpg"));
		this.vista.lblLogo.setIcon(fotoEscalarLabel(this.vista.lblLogo,"imagenes/logo.png"));
		this.vista.lblFondoPlantilla.setIcon(fotoEscalarLabel(this.vista.lblFondoPlantilla,"imagenes/cesped.png"));
		this.vista.btnEmpezar.setIcon(fotoEscalarButton(this.vista.btnEmpezar,"imagenes/boton-inicio.png"));
	}
}
