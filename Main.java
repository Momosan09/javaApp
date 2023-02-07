import Actividades.*;
import Database.Connect;

import java.io.File;
import java.sql.Connection;

public class Main {

  public static void main(String[] args) {

    //Cada vez que compila borra el archivo Main.class para no tener problemas en la siguiente compilacion (Cambio de sistema operativo)
    /* File file = new File("Main.class");
    if(file.exists()){
      file.delete();
      System.out.println("Main Class Deleted!");
    }else{
      System.out.println("Couldn't find Class!");

    } */
    /*
     * window.setVisible(true);
     * 
     * window.setExtendedState(window.getExtendedState() | window.MAXIMIZED_BOTH);
     * 
     * window.getContentPane().add(jp);
     */

    Manager mn = new Manager();
    {
       //Actividad_1 act = new Actividad_1();

    }
  }

}