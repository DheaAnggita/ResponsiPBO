/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsipbo.controllers;
import javax.swing.JOptionPane;
import responsipbo.models.Film;

/**
 *
 * @author hp
 */
public class MovieController {
    Film film;
    Object[][] movie = new Object[100][4];
    public MovieController(Film film){
       this.film = film;
    }
    
    public Object[][] getFilm(){
       movie = film.getFilm();
       return movie;
    } 
    
    public void inputFilm(String judul, double alur, double penokohan, double akting){
        boolean found = false;
        for (int i = 0; movie[i][0] != null; i++) {
            if(movie[i][0].toString().equals(judul)){
                found = true;
                break;
            }
        }
        if(found){
            JOptionPane.showMessageDialog(null,"Film Sudah Ada!");
        } 
        else {
            if(alur > 5.0 || penokohan > 5.0 || akting > 5.0){
               JOptionPane.showMessageDialog(null,"Nilai Maksimal adalah 5!"); 
            } 
            else if(alur < 0 || penokohan < 0 || akting < 0){
                JOptionPane.showMessageDialog(null,"Nilai Minimal adalah 0!");
            } 
            else{
                film.input(judul, alur, penokohan, akting);
                JOptionPane.showMessageDialog(null,"Berhasil Menambah Film!");
            }
        }
    }
    
    public void updateFilm(String judul, double alur, double penokohan, double akting){
        boolean ketemu = false;
        int index = -1;
        for (int i = 0; movie[i][0] != null; i++) {
            if(movie[i][0].toString().equals(judul)){
                index = i;
                ketemu = true;
                break;
            }
        }
        if(ketemu){
            if(alur > 5.0 || penokohan > 5.0 || akting > 5.0){
               JOptionPane.showMessageDialog(null,"Nilai Maksimal adalah 5!"); 
            } 
            else if(alur < 0 || penokohan < 0 || akting < 0){
                JOptionPane.showMessageDialog(null,"Nilai Minimal adalah 0!");
            } 
            else{
                film.update(movie[index][0].toString(), alur, penokohan, akting);
                JOptionPane.showMessageDialog(null,"Berhasil Mengupdate Data!");
            }
        }
        else{
           JOptionPane.showMessageDialog(null,"Film Tidak Ditemukan!"); 
        }
    }
    
    public void deleteFilm(String judul){
        boolean ketemu = false;
        int index = -1;
        for (int i = 0; movie[i][0] != null; i++) {
            if(movie[i][0].toString().equals(judul)){
                index = i;
                ketemu = true;
                break;
            }
        }
        if(ketemu){
            film.delete(movie[index][0].toString());
            JOptionPane.showMessageDialog(null,"Berhasil Menghapus Film!");
        }
        else{
           JOptionPane.showMessageDialog(null,"Film Tidak Ditemukan!"); 
        }
    }
   
}

    

