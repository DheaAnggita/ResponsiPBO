/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsipbo.models;
import java.sql.ResultSet;

/**
 *
 * @author hp
 */
public class Film {
     public Db DB;
    
    public Film (Db DB){
        this.DB = DB;
    }
    
    public Object[][] getFilm(){
        Object[][] film = new Object[100][5];
        try{
            DB.statement = DB.koneksi.createStatement();
            ResultSet result = DB.statement.executeQuery("SELECT * FROM `movie`");
            
            int i = 0;
            while(result.next()){
                film[i][0] = result.getString("judul");
                film[i][1] = result.getString("alur");
                film[i][2] = result.getString("penokohan");
                film[i][3] = result.getString("akting");
                film[i][4] = result.getString("nilai");
                i++;
            }
            DB.statement.close();
        } 
        catch(Exception err){
            System.out.println(err);
        }
        return film;
    }
    
    public void input(String judul, double alur, double penokohan, double akting){
        try{
            double nilai = (alur+penokohan+akting)/3.0;
            DB.statement = DB.koneksi.createStatement(); 
            String query = "INSERT INTO `movie` (`judul`, `alur`, `penokohan`, `akting`, `nilai`) VALUES ('"+ judul +"', '"+ alur +"', '"+penokohan+"', '"+akting+"', '"+nilai+"')";
            DB.statement.execute(query);
        }
        catch(Exception err){
            System.out.println(err);
        }
    }
    
    public void update(String judul, double alur, double penokohan, double akting){
        try{
            double nilai = (alur+penokohan+akting)/3.0;
            DB.statement = DB.koneksi.createStatement(); 
            String query = "UPDATE `movie` SET `alur` = '"+alur+"', `penokohan` = '"+penokohan+"', `akting` = '"+ akting +"', `nilai` = '" + nilai + "' WHERE `movie`.`judul` = '" + judul + "'";
            DB.statement.execute(query);
        }
        catch(Exception err){
            System.out.println(err);
        }
    }
    
    public void delete(String judul){
        try{
            DB.statement = DB.koneksi.createStatement(); 
            String query = "DELETE FROM `movie` WHERE `movie`.`judul` = \'"+judul+"\'";
            DB.statement.execute(query);
        }
        catch(Exception err){
            System.out.println(err);
        }
    }
}
