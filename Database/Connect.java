package Database;

/* si tiene "//" es porque es el codigo basico para que se ejecute, para no confundirme cuando crezca el codigo */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

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

    public void select(){
        try{
            Statement statement = conecta.createStatement();

            ResultSet rs = statement.executeQuery("select * from presupuesto");

        }catch(SQLException e){
            System.err.println("Algo salio mal al solicitar los datos!");
            System.err.println("Origin: Database/Connect.java/ function select() ");
            e.printStackTrace();
            System.err.println("--- Error ---");

        }

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


