/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package windose;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;

/**
 *
 * @author luxte
 */
public class HiloFecha extends Thread{
    private JLabel fecha;

    public HiloFecha(JLabel fecha) {
        this.fecha = fecha;
    }
    
    

    @Override
    public void run() {
        while(true){
            Date h=new Date();
            DateFormat f=new SimpleDateFormat("dd/MM/yyyy");
            fecha.setText( f.format(h) );
            try {
                Thread.sleep(0);
            } catch (InterruptedException ex) {
                
            }
        }        
    }
}
