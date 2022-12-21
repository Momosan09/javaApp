package Actividades;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;


import Recursos.Radio;
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

    /*Modelo elegido */
    ButtonGroup bg = new ButtonGroup();

    JRadioButton r1 = new Radio("Modelo 1",10,100,100,30,jp1);
    JRadioButton r2 = new Radio("Modelo 2",10,130,100,30,jp1);
    JRadioButton r3 = new Radio("Modelo 3",10,160,100,30,jp1);

    JRadioButton r4 = new Radio("Modelo 4",110,100,100,30,jp1);
    JRadioButton r5 = new Radio("Modelo 5",110,130,100,30,jp1);
    JRadioButton r6 = new Radio("Modelo 6",110,160,100,30,jp1);

    JRadioButton r7 = new Radio("Modelo 7",220,100,100,30,jp1);
    JRadioButton r8 = new Radio("Modelo 8",220,130,100,30,jp1);
    JRadioButton r9 = new Radio("Modelo 9",220,160,100,30,jp1);



    
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
        ponerRadio();
    }
    
    private void ponerEtiqueta(){
        lbMedidaTela.setLabelFor(txfMedidaTela);
        lbPrecioPanos.setLabelFor(txfPrecioUnPano);
        lbPrecioTela.setLabelFor(txfPrecioTela);

    }

    private void ponerRadio() {
        bg.add(r1);
        bg.add(r2);
        bg.add(r3);
        bg.add(r4);
        bg.add(r5);
        bg.add(r6);
        bg.add(r7);
        bg.add(r8);
        bg.add(r9);
    }
    private void setValues(){
        txfMedidaTela.getText();
        txfPrecioUnPano.getText();
        txfPrecioTela.getText();

    }

}
