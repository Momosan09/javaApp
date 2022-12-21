import javax.swing.JPanel;

import Actividades.*;

public class Main{
  
  public static void main(String [] args){
    JPanel jp = new JPanel();
    //Window window = new Window();

    SuperActividades sup = new SuperActividades() {
      Actividad_1 act = new Actividad_1();
    };
    
  /*
    se necesitan x inputs
      -Modelo elegido el cual contiene un nombre y un valor numerico(multiplicadorDelaTelaElegida)
      -cantidad de paños (int)
      -precio del paño (float)
      -precio de la tela (float)(mas adelante ver de conectar a sql?)
      -Medida de la tela

    con esos inputs se hacen los siguientes calculos:
      medidaTotalDeLaTela = (medida * multiplicadorDelaTelaElegida)
      precioTotalDeLaTela = medidaTotalDeLaTela * precioTela
      cantidadDePaños = medidaTotalDeLaTela / 1.5 (redondear para arriba la cantidad de paños)
      precioConfeccion = pañosRedondeados(cantidadDePaños) * precioDelPaño

      Total = precioTotalDeLaTela + precioConfeccion

      ver lo de los botones y eventos en el directorio "cartas"
  */

  }
}
