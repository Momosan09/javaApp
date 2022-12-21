package Actividades;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Recursos.Button;
import Recursos.Label;
import Recursos.TextField;

public class Actividad_1 extends SuperActividades {
    JPanel jp1 = new JPanel();

    
    //Button btn1 = new Button("Boton 1", 200, 0, 100, 20);
    
    /*Medida Tela*/
    JLabel lbMedidaTela = new Label("Ingrese medida de la tela", "Medida de la tela en cm", 0, 0, 250, 25, jp1);
    TextField txfMedidaTela = new TextField(250, 0, 150, 25, jp1);
    
    /*Precio un solo pano*/
    JLabel lbPrecioPanos = new Label("Precio de un paño", "Precio por unidad de paño", 0,30,250,25,jp1);
    TextField txfPrecioUnPano = new TextField(250, 30, 150, 25, jp1);

    /*Precio Tela */
    JLabel lbPrecioTela = new Label("Precio de la tela", "Precio de la tela", 0, 60, 250,25,jp1);
    TextField txfPrecioTela = new TextField(250, 60, 150, 25, jp1);


    
    public Actividad_1() {
        this.setTitle("Presupuesto 1");
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        ui();
        setValues();

        ponerPanel(jp1);
        
    }

    private void ui() {
        ponerEtiqueta();
        ponerBoton();
    }
    
    private void ponerEtiqueta(){
        lbMedidaTela.setLabelFor(txfMedidaTela);
        lbPrecioPanos.setLabelFor(txfPrecioUnPano);
        lbPrecioTela.setLabelFor(txfPrecioTela);

    }

    private void ponerBoton() {
        //jp1.add(btn1);

    }
    private void setValues(){
        txfMedidaTela.setText("Medida ingresada");
        txfPrecioUnPano.setText("Precio Paño Ingresado");
        txfPrecioTela.setText("Precio Tela ingrsado");

    }

}
