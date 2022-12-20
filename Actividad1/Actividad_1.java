package Actividad1;
import javax.swing.JPanel;
import javax.swing.JFrame;
import Recursos.Button;

public class Actividad_1 extends JFrame{
    JPanel act1P = new JPanel();
    Button btn1 = new Button("Boton", 0, 0, 20, 10);
    
    public Actividad_1(){
        setSize(500,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Actividad 1");
        iniciar();
    }

    private void iniciar(){
        act1P.add(btn1);
        this.getContentPane().add(act1P);

    }



}

  
  