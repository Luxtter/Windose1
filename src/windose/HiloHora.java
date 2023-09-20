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
public class HiloHora extends Thread{
    private JLabel hora;
    public HiloHora(JLabel hora) {
        this.hora = hora;
    }        

    @Override
    public void run() {
        while(true){
            Date h=new Date();
            DateFormat f=new SimpleDateFormat("hh:mm");
            hora.setText( f.format(h) );
            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                
            }
        }        
    }
}
