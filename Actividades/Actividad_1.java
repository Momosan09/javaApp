package Actividades;

import java.text.*;
import java.awt.Font;
import java.awt.Color;

import java.awt.event.ActionListener;//para los eventos
import java.awt.event.ActionEvent;//para los eventos
import java.awt.event.KeyEvent;//eventos de teclado
import java.awt.event.KeyListener;//eventos de teclado
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.util.*;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

import Recursos.Radio;
import Recursos.Area;
import Recursos.Button;
import Recursos.Label;
import Recursos.TextField;

import Databse.*;

public class Actividad_1 extends SuperActividades implements KeyListener {
    JPanel jp1 = new JPanel();// jp1 es para los inputs
    JPanel jpDatosPers = new JPanel();
    JPanel radiosPanel = new JPanel();

    public double medidaTela, medidaTotalTela, precioTela, precioTotalTela, precioPano, precioConfeccion, Total,
            cantidadPanos, multiplicadorModelo;
    public String medidaTelaOut, modeloElegido;
    public int paddingM = 5;

    // Button btn1 = new Button("Boton 1", 200, 0, 100, 20);

    /* INPUT */

    /* Medida Tela */
    JLabel lbMedidaTela = new Label("Ancho total a cubrir (Mts)", "Ancho Total terminado en Metros", paddingM, paddingM, 250, 25, jp1);
    TextField txfMedidaTela = new TextField(250, lbMedidaTela.getY(), 150, 25, 5, jp1, "");

    /* Precio un solo pano */
    JLabel lbPrecioPanos = new Label("Precio de confeccion por paño", "Precio por unidad de paño", paddingM, 35 + paddingM, 300, 25, jp1);
    TextField txfPrecioUnPano = new TextField(300, lbPrecioPanos.getY(), 150, 25, 5, jp1, "");

    /* Precio Tela */
    JLabel lbPrecioTela = new Label("Precio de la tela", "Precio de la tela", paddingM, 70 + paddingM, 250, 25, jp1);
    TextField txfPrecioTela = new TextField(250, lbPrecioTela.getY(), 150, 25, 5, jp1, "");

    /* Modelo elegido */
    ButtonGroup bg = new ButtonGroup();

    JRadioButton r1 = new Radio("Modelo 1", 10, 110, 100, 30, jp1, 2);
    JRadioButton r2 = new Radio("Modelo 2", 10, 140, 100, 30, jp1, 2);
    JRadioButton r3 = new Radio("Modelo 3", 10, 170, 100, 30, jp1, 2);

    JRadioButton r4 = new Radio("Modelo 4", 110, 110, 100, 30, jp1, 2);
    JRadioButton r5 = new Radio("Modelo 5", 110, 140, 100, 30, jp1, 2);
    JRadioButton r6 = new Radio("Modelo 6", 110, 170, 100, 30, jp1, 2);

    JRadioButton r7 = new Radio("Modelo 7", 220, 110, 100, 30, jp1, 2);
    JRadioButton r8 = new Radio("Modelo 8", 220, 140, 100, 30, jp1, 2);
    JRadioButton r9 = new Radio("Modelo 9", 220, 170, 100, 30, jp1, 2);

    /* Datos personales */
    /* Nombre */
    JLabel nombreLbl = new Label("Nombre del cliente: ", "Ingrese el nombre del Cliente", paddingM, paddingM, 250, 20, jpDatosPers);

    TextField nombreTxtField = new TextField(nombreLbl.getX() + nombreLbl.getWidth(), nombreLbl.getY(), 200, 20, 5, jpDatosPers, "");

    /* Apellido */
    JLabel apellidoLbl = new Label("Apellido del cliente: ", "Ingrese el Apellido del Cliente", paddingM, nombreLbl.getHeight() + nombreLbl.getY() + paddingM, 250, 20, jpDatosPers);

    TextField apellidoTxtField = new TextField(apellidoLbl.getX() + apellidoLbl.getWidth(), apellidoLbl.getY(), 200, 20, 5, jpDatosPers, "");

    /* Telefono */

    JLabel telefonoLbl = new Label("Telefono del cliente: ", "Ingrese el Telefono del Cliente", paddingM, nombreLbl.getHeight()+ apellidoLbl.getY() + paddingM, 250, 20, jpDatosPers);

    TextField telefonoTxtField = new TextField(telefonoLbl.getX() + telefonoLbl.getWidth(), telefonoLbl.getY(), 200, 20, 5, jpDatosPers, "");

    /* Correo */

    JLabel correoLbl = new Label("Correo del cliente: ", "Ingrese el Correo del Cliente", paddingM, nombreLbl.getHeight() + telefonoLbl.getY() + paddingM, 250, 20, jpDatosPers);

    TextField correoTxtField = new TextField(correoLbl.getX() + correoLbl.getWidth(), correoLbl.getY(), 200, 20, 5, jpDatosPers, "");

    /* Texto adicional */
    JLabel txtALabel = new Label("Anotaciones especiales", "Campo opcional, no es requerido", 20, 320, 250, 20, jp1);
    JTextArea txtA = new JTextArea();

    /* OUTPUT */
    JLabel outMedidaTotalTela = new Label("Medida total de la tela = ", "medida total de la tela en cm", 0, 200, 400,
            25, jp1);
    JLabel outprecioTotalTela = new Label("Precio total de la tela = ", "precio total de la tela", 0, 230, 400, 25,
            jp1);
    JLabel outprecioConfeccion = new Label("Precio de la confeccion = ", "precio de la confeccion", 0, 260, 400, 25,
            jp1);
    JLabel outTotal = new Label("Precio Total = ", "Total a pagar", 0, 290, 400, 25, jp1);

    /* Errores */
    JLabel LberrorDeNoLlenado = new Label("* Porfavor, completar todos los campos", "Algunos campos estan vacios", 100,
            90, 400, 25, jp1);

    /* Imprimir */
    Button btnImprimir = new Button("Imprimir", this.getWidth()-200, 0, 100, 40, jpDatosPers);
    // Check Error
    public boolean checkError;

    //Data Base connect
    Connect cc = new Connect();
    Connection cn = cc.conectar(); 

    public Actividad_1() {
        this.setTitle("Presupuesto 1");
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        // this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        // this.setFocusable(true);

        ponerPanel(jpDatosPers);
        ponerPanel(jp1); 
        ui();
        addEventKey();
        /* cc.agregarPresupuesto("elamigos", "Games", "11111111", "elamigos@amigomail.com"); */
        addEventRadio();

        // checkRadios();
        clickImprimir();

    }

    private void ui() {
        btnImprimir.setEnabled(false);
        ponerEtiqueta();
        ponerRadio();
        ponerTextArea();
        jpDatosPersStyle();

    }
    private void jpDatosPersStyle(){

        jpDatosPers.setBounds(0,460,this.getWidth(),105);
        jpDatosPers.setBackground(Color.decode("#c66d6d"));
    }

    private void ponerTextArea() {
        int padding = 20;
        txtALabel.setFont(new Font("LINUX", Font.CENTER_BASELINE, 16));
        txtA.setBounds(padding, 340, this.getWidth() - padding * 3, 100);
        txtA.setLineWrap(true);
        txtA.setWrapStyleWord(true);
        txtA.setFont(new Font("LINUX", Font.PLAIN, 16));
        txtA.setVisible(true);
        jp1.add(txtA);
    }

    private void ponerEtiqueta() {
        LberrorDeNoLlenado.setVisible(false);
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

    // ERRORES
    public void errores() {

        /* error Dejar un campo vacio */
        if (txfMedidaTela.getText().isEmpty() || txfPrecioTela.getText().isEmpty()
                || txfPrecioUnPano.getText().isEmpty()) {

            System.out.println("Error, ingrese datos en todos los campos");
            errorDeNoLlenado(true);
            checkError = true;
        } else {
            LberrorDeNoLlenado.setVisible(false);
            checkError = false;

        }
        if (checkError) {
            btnImprimir.setEnabled(false);
        } else {
            btnImprimir.setEnabled(true);
        }
    }

    public void errorDeNoLlenado(boolean b) {
        LberrorDeNoLlenado.setVisible(b);
        LberrorDeNoLlenado.setFont(new Font("LINUX", Font.PLAIN, 12));
        LberrorDeNoLlenado.setForeground(Color.RED);

    }

/*     public void errorTipoDeDatos(TextField tx) {
        try {
            btnImprimir.setEnabled(true);
            Float.parseFloat(tx.getText());
            System.out.println("A number");
        } catch (NumberFormatException e) {
            // Not an integer
            btnImprimir.setEnabled(false);
            System.out.println("Not a number");

        }
    } */

    private void checkRadios() {

        if (r1.isSelected()) {
            multiplicadorModelo = 1;
            modeloElegido = "modelo 1";
            System.out.println(multiplicadorModelo);
        }
        if (r2.isSelected()) {
            multiplicadorModelo = 2;
            modeloElegido = "modelo 2";
            System.out.println(multiplicadorModelo);
        }
        if (r3.isSelected()) {
            multiplicadorModelo = 3;
            modeloElegido = "modelo 3";
            System.out.println(multiplicadorModelo);
        }
        if (r4.isSelected()) {
            multiplicadorModelo = 4;
            modeloElegido = "modelo 4";
            System.out.println(multiplicadorModelo);
        }
        if (r5.isSelected()) {
            multiplicadorModelo = 5;
            modeloElegido = "modelo 5";
            System.out.println(multiplicadorModelo);
        }
        if (r6.isSelected()) {
            multiplicadorModelo = 2.5;
            modeloElegido = "modelo 6";
            System.out.println(multiplicadorModelo);
        }
        if (r7.isSelected()) {
            multiplicadorModelo = 1.5;
            modeloElegido = "modelo 7";
            System.out.println(multiplicadorModelo);
        }
        if (r8.isSelected()) {
            multiplicadorModelo = 1.6;
            modeloElegido = "modelo 8";
            System.out.println(multiplicadorModelo);
        }
        if (r9.isSelected()) {
            multiplicadorModelo = 2;
            modeloElegido = "modelo 9";
            System.out.println(multiplicadorModelo);
        }

    }

    public Double truncateNumber(Double value, int cantidadDecimales) {
        value = value * Math.pow(10, cantidadDecimales);
        value = Math.floor(value);
        value = value / Math.pow(10, cantidadDecimales);
        return value;
    }

    /* https://docs.oracle.com/javase/tutorial/java/data/numberformat.html */
    /*
     * public static String customFormat(String pattern, double value ) { // esto
     * hace que los numeros tengan cierto formato
     * DecimalFormat myFormatter = new DecimalFormat(pattern);
     * String output = myFormatter.format(value);
     * //System.out.println(value + "  " + pattern + "  " + output);
     * return output;
     * }
     */

    public String formatNumber(double number) {// le da formato a los numeros
        NumberFormat nf = NumberFormat.getInstance(Locale.ITALY);// ITALY es el modelo que usamos ###.###,###
        String output = nf.format(number);
        return output;

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
        // Total = truncateNumber(Total, 2);

        // System.out.println(Total);

    }

    public void changeOutputLabel() {
        outMedidaTotalTela.setText("Medida total de la tela = " + String.valueOf(medidaTotalTela) + "Mts");// Convierte
                                                                                                           // a string
        outprecioTotalTela.setText("Precio total de la tela = $" + formatNumber(precioTotalTela));// Convierte a string
        outprecioConfeccion.setText("Precio de la confeccion = $" + formatNumber(precioConfeccion));
        outTotal.setText("Precio Total = $" + formatNumber(Total));// Convierte a string

    }

    public void addEventRadio() {

        ActionListener clickRadio = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                errores();
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

    public void clickImprimir() {
        ActionListener clickPrint = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Area imprimir = new Area();
                System.out.println("Printing...");
                imprimir.out1.setText("Cantidad de tela = " + String.valueOf(medidaTotalTela) + "Mts");
                imprimir.out2.setText("Modelo Elegido: " + String.valueOf(modeloElegido));
                imprimir.out3.setText("Precio de la tela = $" + formatNumber(precioTotalTela));
                imprimir.out4.setText("Precio de la Confeccion = $" + formatNumber(precioConfeccion));
                imprimir.out5.setText("Precio Total = $" + formatNumber(Total));
                imprimir.anotaciones.setText(txtA.getText());
                try {
                    cc.agregarPresupuesto(nombreTxtField.getText(), apellidoTxtField.getText(), telefonoTxtField.getText(), correoTxtField.getText());
                    System.out.print("Presupuesto Añadido a la base de datos!");
                    /*
                     * imprimir.fill(outMedidaTotalTela);
                     * imprimir.fill(outprecioConfeccion);
                     * imprimir.fill(outprecioConfeccion);
                     * imprimir.fill(outTotal);
                     */

                    imprimir.print();
                } catch (PrinterException e) {
                    e.printStackTrace();
                }

            }
        };
        btnImprimir.addActionListener(clickPrint);
    }

    @Override
    public void keyTyped(KeyEvent e) {


    }

    @Override
    public void keyPressed(KeyEvent e) {


    }

    @Override
    public void keyReleased(KeyEvent e) {

        errores();
        checkRadios();
        calCular();
        changeOutputLabel();
        //errorTipoDeDatos(txfMedidaTela);

    }

    public void addEventKey() {
        txfMedidaTela.addKeyListener(this);
        txfPrecioUnPano.addKeyListener(this);
        txfPrecioTela.addKeyListener(this);

    }

}
