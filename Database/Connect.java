package Database;

/* si tiene "//" es porque es el codigo basico para que se ejecute, para no confundirme cuando crezca el codigo */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Recursos.ConsoleColors;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Connect {

    Connection conecta = null;//
    int index = 0;

    public Connection conectar() {//

        try {//
            Class.forName("org.sqlite.JDBC");//
            conecta = DriverManager.getConnection("jdbc:sqlite:Presupuestos.db");//
            System.out.println(ConsoleColors.GREEN + "Database Connection Established!" + ConsoleColors.RESET);
            Statement statement = conecta.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.

            //Crear Tabla

            statement.executeUpdate("create table if not exists presupuesto (id integer PRIMARY KEY, name string, apellido string, telefono string, correo string, anotaciones string, cantidadTela string, modeloTela string, precioTela string, precioConfeccion string, total string, checked boolean )");
            //getIndex();
            //pDelete(2);

        } catch (Exception e) {//
            System.err.println(ConsoleColors.RED + "Algo salio mal con la vinculacion de la base de datos o la creacion de las tablas!" + ConsoleColors.RESET);
            System.err.println(ConsoleColors.YELLOW + "Origin: Database/Connect.java/:16" + ConsoleColors.RESET);    
            System.err.println(e.getMessage());//
            System.err.println("--- Error ---");

        }

        return conecta;//
    }

    public void agregarPresupuesto(String name, String apellido, String telefono, String correo, String anotaciones, String cantidadTela, String modeloTela, String precioTela, String precioConfeccion, String total, Boolean checked){
        try (PreparedStatement Pstatement = conecta.prepareStatement("insert into presupuesto values(?,?,?,?,?,?,?,?,?,?,?,?)")) {

            Pstatement.setInt(1, getIndex() + 1);
            Pstatement.setString(2, name);
            Pstatement.setString(3, apellido);
            Pstatement.setString(4, telefono);
            Pstatement.setString(5, correo);
            Pstatement.setString(6, anotaciones);
            Pstatement.setString(7, cantidadTela);
            Pstatement.setString(8, modeloTela);
            Pstatement.setString(9, precioTela);
            Pstatement.setString(10, precioConfeccion);
            Pstatement.setString(11, total);
            Pstatement.setBoolean(12, checked);

            Pstatement.executeUpdate();
            
        } catch (SQLException e) {
            System.err.println(ConsoleColors.RED + "Algo salio mal con el pedido de creacion de otra fila!" + ConsoleColors.RESET);
            System.err.println(ConsoleColors.YELLOW + "Origin: Database/Connect.java/:36" + ConsoleColors.RESET);    
            e.printStackTrace();
            System.err.println(e.getMessage());//
            System.err.println("--- Error ---");

        }
    }
    public int getIndex(){
        try{
            Statement statement = conecta.createStatement();

            ResultSet rs = statement.executeQuery("select COUNT(id) from presupuesto");

            while(rs.next()){
                index = Integer.parseInt(rs.getString(1));
                //System.out.println("Indice = " + index);
            }
            return index;

            
        } catch (SQLException e) {
            System.err.println(ConsoleColors.RED + "Algo salio mal con el pedido de los indices!" + ConsoleColors.RESET);
            System.err.println(ConsoleColors.YELLOW + "Origin: Database/Connect.java/:54" + ConsoleColors.RESET);
            e.printStackTrace(); 
            System.err.println("--- Error ---");

            return 0;
        }

    }

    public Object[][] select(String actividad){
        Object tbData[][] = {};
        try{
            Statement statement = conecta.createStatement();

            ResultSet rs = statement.executeQuery("SELECT * FROM presupuesto");
            try{
                  
                String columns[] = { "ID", "Name", "Apellido", "Telefono", "Correo", "Anotaciones", "Modelo Tela", "Total" };

                String data[][] = new String[2147483646][8];  //Ver como arreglar esto, por ahora le puse el valor del tamaño de una variable del tipo "int"-1
                int i = 0;
                while (rs.next()) {
                  int id = rs.getInt(1);
                  String nom = rs.getString(2);
                  String apellido = rs.getString(3);
                  String telefono = rs.getString(4);
                  String correo = rs.getString(5);
                  String anotaciones = rs.getString(6);
                  String modelo = rs.getString(8);
                  String total = rs.getString(11);
                  data[i][0] = id + "";
                  data[i][1] = nom;
                  data[i][2] = apellido;
                  data[i][3] = telefono;
                  data[i][4] = correo;
                  data[i][5] = anotaciones;
                  data[i][6] = modelo;
                  data[i][7] = total;
                  i++;
                }

                DefaultTableModel model = new DefaultTableModel(data, columns);
                JTable table = new JTable(model);
                table.setSize(700, 250);
                table.setShowGrid(true);
                table.setShowVerticalLines(true);
                JScrollPane pane = new JScrollPane(table);
                JFrame f = new JFrame(actividad + " Database");
                JPanel panel = new JPanel();
                panel.add(pane);
                f.add(panel);
                f.setSize(700, 250);
                //f.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                f.setVisible(true);

            System.out.println(ConsoleColors.BLUE + "Anda martin" + ConsoleColors.RESET);
            return tbData;
        }catch (SQLException e) {
            e.printStackTrace();

        };

        }catch(SQLException e){
            System.err.println("Algo salio mal al solicitar los datos!");
            System.err.println("Origin: Database/Connect.java/ function select() ");
            e.printStackTrace();
            System.err.println("--- Error ---");
            return null;

        }
        return null;

        }
    }

    /* public void pDelete(int id){
        try(PreparedStatement Pstatement = conecta.prepareStatement("DELETE FROM presupuesto where id = ?")){
            //Pstatement.setString(2, "name");
            Pstatement.setInt(1, id);

            Pstatement.executeUpdate();

        }catch(SQLException e){
            System.err.println("Algo salio mal al intentar borrar la fila!");
            System.err.println("Origin: Database/Connect.java/:83!");
            e.printStackTrace();
            System.err.println("--- Error ---");

        }
    } */


