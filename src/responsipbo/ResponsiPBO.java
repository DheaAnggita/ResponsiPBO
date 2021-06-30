/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsipbo;
import responsipbo.models.Db;
import responsipbo.views.ViewTampilan;
import javax.swing.*;
/**
 *
 * @author hp
 */
public class ResponsiPBO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Db DB = new Db();
        JFrame viewtampil = new ViewTampilan(DB);
        viewtampil.setVisible(true);
    }
    
}
