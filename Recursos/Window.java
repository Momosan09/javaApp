package Recursos;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Window extends JFrame{
  public JPanel panel = new JPanel();

  public Window(){
    //setExtendedState(JFrame.MAXIMIZED_BOTH); //pantalla completa

    setSize(500,500);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setTitle("Untitled");
    setVisible(false);
    setUndecorated(false);
    setResizable(false);
    //setExtendedState(JFrame.MAXIMIZED_BOTH);
  }

  public void ponerPanel(JPanel panel){
    panel.setLayout(null);
    this.getContentPane().add(panel);

  }


}
