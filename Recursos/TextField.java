package Recursos;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.io.*;
import java.awt.event.KeyEvent;//eventos de teclado
import java.awt.event.KeyListener;//eventos de teclado

public class TextField extends JTextField implements KeyListener {

  public float valor;

  JLabel display = new JLabel();

  public String textoDefault;

  public TextField(int posX, int posY, int width, int height, int col, JPanel jp, String textoLabel) {

    textoDefault = textoLabel;

    setBounds(posX, posY, width, height);
    setColumns(col);
    dispayLabel(posX - posX, posY + 200, width, height, jp, textoLabel);
    jp.add(this);// se auto agrega al panel pasado como parametro
    eventosTeclado();
  }

  // Esto es para mostrar el valor en labels
  // No me gusta mucho como quedo pero ya no se me ocurre nada mejor
  private void dispayLabel(int posX, int posY, int width, int height, JPanel jp, String texto) {
    display.setBounds(posX, posY, width, height);
    display.setText(texto);
    jp.add(display);
  }

  private void eventosTeclado() {

    addKeyListener(this);

  }

  @Override
  public void keyTyped(KeyEvent e) {
    // TODO Auto-generated method stub
    // System.out.println(getText());

  }

  @Override
  public void keyPressed(KeyEvent e) {
    // TODO Auto-generated method stub
    // System.out.println(getText());

  }

  @Override
  public void keyReleased(KeyEvent e) {
    // TODO Auto-generated method stub
    // valor = Float.parseFloat(getText());
    // System.out.println(valor);

    display.setText(textoDefault + getText());

  }
}
