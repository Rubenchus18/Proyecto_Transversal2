package controlador;

import vista.*;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Controlador implements ActionListener,MouseListener {

    private Vista vista;
    private ControladorHibernate hibernate;
    public Controlador(Vista vista) {
        this.vista = vista;
        
        this.vista.btnEmpezar.addActionListener(this);
        this.vista.btnEmpezar.setActionCommand("empezar");
        //Porteros
        this.vista.btnPortero.addActionListener(this);
        //Delanteros
        this.vista.btnDelanteroDerecho.addActionListener(this);
        
        this.vista.btnDelanteroIzquierda.addActionListener(this);
        //CentroCampistas
        this.vista.btnCentroCampistaDerecho.addActionListener(this);
        this.vista.btnCentroCampistaDerechoCentro.addActionListener(this);
        this.vista.btnCentroCampistaIzquierdoCentro.addActionListener(this);
        this.vista.btnCentroCampistaIzquierdo.addActionListener(this);
        //Defensas
        this.vista.btnDefensaDerecha.addActionListener(this);
        this.vista.btnDefensaDerechaCentro.addActionListener(this);
        this.vista.btnDefensaIzquierda.addActionListener(this);
        this.vista.btnDefensaIzquierdaCentro.addActionListener(this);
        //Eleccion
        this.vista.btnEleccionUno.addActionListener(this);
        this.vista.btnEleccionDos.addActionListener(this);
        this.vista.btnEleccionTres.addActionListener(this);
        this.vista.btnEleccionCuatro.addActionListener(this);
        this.vista.lblSalir.addMouseListener(this);
        imagenes();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton[] botonesDeshabilitar = {
            vista.btnDelanteroDerecho,
            vista.btnDelanteroIzquierda,
            vista.btnCentroCampistaDerecho,
            vista.btnCentroCampistaDerechoCentro,
            vista.btnCentroCampistaIzquierdoCentro,
            vista.btnCentroCampistaIzquierdo,
            vista.btnDefensaDerecha,
            vista.btnDefensaDerechaCentro,
            vista.btnDefensaIzquierda,
            vista.btnDefensaIzquierdaCentro,
            vista.btnPortero
        };
        switch(e.getActionCommand()) {
        
        }
        if (e.getSource() == this.vista.btnEmpezar) {
            this.vista.panelInicio.setVisible(false);
            this.vista.PanelPlantilla.setVisible(true);
        } else if (isPlayerButton(e.getSource())) {
            vista.panelElecion.setVisible(true);
            disableButtons(botonesDeshabilitar);
        } else if (isEleccionButton(e.getSource())) {
            vista.panelElecion.setVisible(false);
            enableButtons(botonesDeshabilitar);
        }
        
        if(e.getSource()==this.vista.lblFondoDraft) {
        	vista.panelElecion.setVisible(false);
        }
        
    }

    public boolean isPlayerButton(Object source) {
        return source == this.vista.btnPortero ||
               source == this.vista.btnDelanteroDerecho ||
               source == this.vista.btnDelanteroIzquierda ||
               source == this.vista.btnCentroCampistaDerecho ||
               source == this.vista.btnCentroCampistaDerechoCentro ||
               source == this.vista.btnCentroCampistaIzquierdo ||
               source == this.vista.btnCentroCampistaIzquierdoCentro ||
               source == this.vista.btnDefensaDerecha ||
               source == this.vista.btnDefensaDerechaCentro ||
               source == this.vista.btnDefensaIzquierda ||
               source == this.vista.btnDefensaIzquierdaCentro;
    }

    public boolean isEleccionButton(Object source) {
        return source == this.vista.btnEleccionUno ||
               source == this.vista.btnEleccionDos ||
               source == this.vista.btnEleccionTres ||
               source == this.vista.btnEleccionCuatro;
    }

    public void disableButtons(JButton[] botones) {
        for (JButton boton : botones) {
            boton.setEnabled(false);
            boton.setVisible(false);
        }
    }

    public void enableButtons(JButton[] botones) {
        for (JButton boton : botones) {
            boton.setEnabled(true);
            boton.setVisible(true);
        }
    }
    

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
        this.vista.lblFondo.setIcon(fotoEscalarLabel(this.vista.lblFondo, "imagenes/fondo-principal.jpg"));
        this.vista.lblLogo.setIcon(fotoEscalarLabel(this.vista.lblLogo, "imagenes/logo.png"));
        this.vista.lblFondoPlantilla.setIcon(fotoEscalarLabel(this.vista.lblFondoPlantilla, "imagenes/cesped.png"));
        this.vista.btnEmpezar.setIcon(fotoEscalarButton(this.vista.btnEmpezar, "imagenes/boton-inicio.png"));
        this.vista.btnPortero.setIcon(fotoEscalarButton(this.vista.btnPortero, "imagenes/camiseta-de-futbol.png"));
        this.vista.btnDefensaIzquierda.setIcon(fotoEscalarButton(this.vista.btnDefensaIzquierda, "imagenes/camiseta-de-futbol.png"));
        this.vista.btnCentroCampistaIzquierdoCentro.setIcon(fotoEscalarButton(this.vista.btnCentroCampistaIzquierdoCentro, "imagenes/camiseta-de-futbol.png"));
        this.vista.btnDefensaIzquierdaCentro.setIcon(fotoEscalarButton(this.vista.btnDefensaIzquierdaCentro, "imagenes/camiseta-de-futbol.png"));
        this.vista.btnDefensaDerechaCentro.setIcon(fotoEscalarButton(this.vista.btnDefensaDerechaCentro, "imagenes/camiseta-de-futbol.png"));
        this.vista.btnDefensaDerecha.setIcon(fotoEscalarButton(this.vista.btnDefensaDerecha, "imagenes/camiseta-de-futbol.png"));
        this.vista.btnCentroCampistaIzquierdo.setIcon(fotoEscalarButton(this.vista.btnCentroCampistaIzquierdo, "imagenes/camiseta-de-futbol.png"));
        this.vista.btnCentroCampistaDerechoCentro.setIcon(fotoEscalarButton(this.vista.btnCentroCampistaDerechoCentro, "imagenes/camiseta-de-futbol.png"));
        this.vista.btnCentroCampistaDerecho.setIcon(fotoEscalarButton(this.vista.btnCentroCampistaDerecho, "imagenes/camiseta-de-futbol.png"));
        this.vista.btnDelanteroDerecho.setIcon(fotoEscalarButton(this.vista.btnDelanteroDerecho, "imagenes/camiseta-de-futbol.png"));
        this.vista.btnDelanteroIzquierda.setIcon(fotoEscalarButton(this.vista.btnDelanteroIzquierda, "imagenes/camiseta-de-futbol.png"));
        this.vista.lblFondoDraft.setIcon(fotoEscalarLabel(this.vista.lblFondoDraft, "imagenes/fondo_futDraft.jpg"));
        this.vista.lblSalir.setIcon(fotoEscalarLabel(this.vista.lblSalir,"imagenes/salir.png"));
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == this.vista.lblSalir) {
            this.vista.panelElecion.setVisible(false);
            
          
            JButton[] botonesHabilitar = {
                vista.btnDelanteroDerecho,
                vista.btnDelanteroIzquierda,
                vista.btnCentroCampistaDerecho,
                vista.btnCentroCampistaDerechoCentro,
                vista.btnCentroCampistaIzquierdoCentro,
                vista.btnCentroCampistaIzquierdo,
                vista.btnDefensaDerecha,
                vista.btnDefensaDerechaCentro,
                vista.btnDefensaIzquierda,
                vista.btnDefensaIzquierdaCentro,
                vista.btnPortero
            };

            enableButtons(botonesHabilitar);
        }
    }

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}