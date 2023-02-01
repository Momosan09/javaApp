
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
            Statement statement = conecta.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.

            statement.executeUpdate("drop table if exists person");
            statement.executeUpdate("create table person (id integer PRIMARY KEY, name string)");
            statement.executeUpdate("insert into person values(1,'leo')");
            statement.executeUpdate("insert into person values(2,'yui')");
            agregarPresupuesto("is something about you");
            agregarPresupuesto("is hard to explain");
            agregarPresupuesto("is around you boy");
            agregarPresupuesto("but you still the same");

            ResultSet rs = statement.executeQuery("select * from person");
            while(rs.next())
            {
              // read the result set
              System.out.println("id = " + rs.getInt("id"));
              System.out.println("name = " + rs.getString("name"));
            }

        } catch (Exception e) {//
            System.err.println(e.getMessage());//
        }

        return conecta;//
    }

    public void agregarPresupuesto(String name){
        try (PreparedStatement Pstatement = conecta.prepareStatement("insert into person values(?,?)")) {

            Pstatement.setInt(1, getIndex() + 1);
            Pstatement.setString(2, name);
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
                System.out.println("Indice = " + index);
            }
            return index;

            
        } catch (SQLException e) {
            e.printStackTrace(); 
            return 0;
        }

    }

}
