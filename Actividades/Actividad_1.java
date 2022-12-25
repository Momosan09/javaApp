package Actividades;

import java.awt.Component;
import java.awt.event.ActionListener;//para los eventos
import java.awt.event.ActionEvent;//para los eventos

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JRadioButton;

import Recursos.Radio;
import Recursos.Button;
import Recursos.Label;
import Recursos.TextField;

public class Actividad_1 extends SuperActividades {
    JPanel jp1 = new JPanel();// jp1 es para los inputs
    JPanel jp2 = new JPanel();// jp2 es para los outputs

    public double medidaTela, medidaTotalTela, precioTela, precioTotalTela, precioPano, precioConfeccion, Total,
            cantidadPanos, multiplicadorModelo;
    public String medidaTelaOut, modeloElegido;

    // Button btn1 = new Button("Boton 1", 200, 0, 100, 20);

    /* INPUT */

    /* Medida Tela */
    JLabel lbMedidaTela = new Label("Ingrese medida de la tela", "Medida de la tela en cm", 0, 0, 250, 25, jp1);
    TextField txfMedidaTela = new TextField(250, 0, 150, 25, 5, jp1, "Medida de la tela = ");

    /* Precio un solo pano */
    JLabel lbPrecioPanos = new Label("Precio de un paño", "Precio por unidad de paño", 0, 30, 250, 25, jp1);
    TextField txfPrecioUnPano = new TextField(250, 30, 150, 25, 5, jp1, "Precio de un paño = ");

    /* Precio Tela */
    JLabel lbPrecioTela = new Label("Precio de la tela", "Precio de la tela", 0, 60, 250, 25, jp1);
    TextField txfPrecioTela = new TextField(250, 60, 150, 25, 5, jp1, "Precio de la tela = ");

    /* Modelo elegido */
    ButtonGroup bg = new ButtonGroup();

    JRadioButton r1 = new Radio("Modelo 1", 10, 100, 100, 30, jp1, 2);
    JRadioButton r2 = new Radio("Modelo 2", 10, 130, 100, 30, jp1, 2);
    JRadioButton r3 = new Radio("Modelo 3", 10, 160, 100, 30, jp1, 2);

    JRadioButton r4 = new Radio("Modelo 4", 110, 100, 100, 30, jp1, 2);
    JRadioButton r5 = new Radio("Modelo 5", 110, 130, 100, 30, jp1, 2);
    JRadioButton r6 = new Radio("Modelo 6", 110, 160, 100, 30, jp1, 2);

    JRadioButton r7 = new Radio("Modelo 7", 220, 100, 100, 30, jp1, 2);
    JRadioButton r8 = new Radio("Modelo 8", 220, 130, 100, 30, jp1, 2);
    JRadioButton r9 = new Radio("Modelo 9", 220, 160, 100, 30, jp1, 2);

    /* OUTPUT */
    JLabel outMedidaTotalTela = new Label("Medida total de la tela = ", "medida total de la tela en cm", 0, 300, 300, 25, jp1);
    JLabel outprecioTotalTela = new Label("Precio total de la tela = ", "precio total de la tela", 0, 330, 300, 25, jp1);
    JLabel outprecioConfeccion = new Label("Precio de la confeccion = ", "precio de la confeccion", 0, 360, 300, 25, jp1);
    JLabel outTotal = new Label("Precio Total = ", "Total a pagar", 0, 390, 300, 25, jp1);

    public Actividad_1() {
        this.setTitle("Presupuesto 1");
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        ui();

        addEventRadio();
        ponerPanel(jp1);
        // checkRadios();

    }

    private void ui() {
        ponerEtiqueta();
        ponerRadio();

    }

    private void ponerEtiqueta() {
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
        // modeloElegido = bg.getSelection().getActionCommand();
    }

    private void checkRadios() {

        if (r1.isSelected()) {
            multiplicadorModelo = 1;
            System.out.println(multiplicadorModelo);
        }
        if (r2.isSelected()) {
            multiplicadorModelo = 2;
            System.out.println(multiplicadorModelo);
        }
        if (r3.isSelected()) {
            multiplicadorModelo = 3;
            System.out.println(multiplicadorModelo);
        }
        if (r4.isSelected()) {
            multiplicadorModelo = 4;
            System.out.println(multiplicadorModelo);
        }
        if (r5.isSelected()) {
            multiplicadorModelo = 5;
            System.out.println(multiplicadorModelo);
        }
        if (r6.isSelected()) {
            multiplicadorModelo = 2.5;
            System.out.println(multiplicadorModelo);
        }
        if (r7.isSelected()) {
            multiplicadorModelo = 1.5;
            System.out.println(multiplicadorModelo);
        }
        if (r8.isSelected()) {
            multiplicadorModelo = 1.6;
            System.out.println(multiplicadorModelo);
        }
        if (r9.isSelected()) {
            multiplicadorModelo = 2;
            System.out.println(multiplicadorModelo);
        }

    }

    public Double truncateNumber(Double value, int cantidadDecimales){
        value = value * Math.pow(10, cantidadDecimales);
        value = Math.floor(value);
        value = value / Math.pow(10,cantidadDecimales);
        return value;
    }

    public void calCular() {
        // multiplicadorModelo=2;
        medidaTela = Float.parseFloat(txfMedidaTela.getText());
        precioPano = Float.parseFloat(txfPrecioUnPano.getText());
        precioTela = Float.parseFloat(txfPrecioTela.getText());


        medidaTotalTela = (medidaTela * multiplicadorModelo);
        precioTotalTela = medidaTotalTela * precioTela;
        cantidadPanos = (float) (medidaTotalTela / 1.5); // (redondear para arriba la cantidad de paños)
        precioConfeccion = cantidadPanos * precioPano;
        Total = precioTotalTela + precioConfeccion;
        Total = truncateNumber(Total, 2);

        //System.out.println(Total);

    }

    public void changeOutputLabel() {
        outMedidaTotalTela.setText("Medida total de la tela = " + String.valueOf(medidaTotalTela) + "cm");// Convierte a string
        outprecioTotalTela.setText("Precio total de la tela = $" + String.valueOf(precioTotalTela));// Convierte a string
        outprecioConfeccion.setText("Precio de la confeccion = $" + String.valueOf(precioConfeccion));
        outTotal.setText("Precio Total = $" + String.valueOf(Total));// Convierte a string
    }


    public void addEventRadio() {

        ActionListener clickRadio = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                checkRadios();
                calCular();
                changeOutputLabel();
            }
        };
        r1.addActionListener(clickRadio);
        r2.addActionListener(clickRadio);
        r3.addActionListener(clickRadio);
        r4.addActionListener(clickRadio);
        r5.addActionListener(clickRadio);
        r6.addActionListener(clickRadio);
        r7.addActionListener(clickRadio);
        r8.addActionListener(clickRadio);
        r9.addActionListener(clickRadio);
    }

}
