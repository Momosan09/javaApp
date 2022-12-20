package Actividades;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Recursos.Button;
import Recursos.Label;
import Recursos.TextField;

public class Actividad_1 extends SuperActividades {
    JPanel jp1 = new JPanel();
    
    Button btn1 = new Button("Boton 1", 200, 0, 100, 20);
    
    /*Medida Tela*/
    JLabel labelMedidaTela = new Label("Ingrese medida de la tela", "Medida de la tela en cm", 0, 0, 250, 200, jp1);
    TextField cajaTextoMedidaTela = new TextField(250, 0, 200, 20, jp1);
    
    public Actividad_1() {
        this.setTitle("Presupuesto 1");
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        ui();
        ponerPanel(jp1);
        
    }

    private void ui() {
        ponerEtiqueta();
        ponerCajaTexto();
        ponerBoton();
    }
    
    private void ponerEtiqueta(){
        labelMedidaTela.setLabelFor(cajaTextoMedidaTela);

    }

    private void ponerCajaTexto(){

    }

    private void ponerBoton() {
        //jp1.add(btn1);

    }

}
