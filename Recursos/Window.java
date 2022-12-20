package Recursos;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Window extends JFrame{
  public JPanel panel = new JPanel();

  public Window(){
    setSize(500,500);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setTitle("Untitled");
    this.setVisible(false);

  }

  public void ponerPanel(JPanel panel){
    panel.setLayout(null);
    this.getContentPane().add(panel);

  }


}
