package Databse;

/* si tiene "//" es porque es el codigo basico para que se ejecute, para no confundirme cuando crezca el codigo */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.RowId;
import java.sql.SQLException;

public class Connect {

    Connection conecta = null;//

    public Connection conectar() {//

        try {//
            Class.forName("org.sqlite.JDBC");//
            conecta = DriverManager.getConnection("jdbc:sqlite:Presupuestos.db");//
            System.out.println("Database Connection Established!");
            Statement statement = conecta.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.

            //Crear Tabla
            statement.executeUpdate("drop table if exists person");
            statement.executeUpdate("create table person (id integer PRIMARY KEY, name string, apellido string, telefono string, correo string)");

        } catch (Exception e) {//
            System.err.println(e.getMessage());//
        }

        return conecta;//
    }

    public void agregarPresupuesto(String name, String apellido, String telefono, String correo){
        try (PreparedStatement Pstatement = conecta.prepareStatement("insert into person values(?,?,?,?,?)")) {

            Pstatement.setInt(1, getIndex() + 1);
            Pstatement.setString(2, name);
            Pstatement.setString(3, apellido);
            Pstatement.setString(4, telefono);
            Pstatement.setString(5, correo);
            Pstatement.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println(e.getMessage());//

        }
    }
    private int getIndex(){
        try{
            int index = 0;
            Statement statement = conecta.createStatement();

            ResultSet rs = statement.executeQuery("select COUNT(id) from person");

            while(rs.next()){
                index = Integer.parseInt(rs.getString(1));
                //System.out.println("Indice = " + index);
            }
            return index;

            
        } catch (SQLException e) {
            e.printStackTrace(); 
            return 0;
        }

    }

}
