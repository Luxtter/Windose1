package windose;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class administrarPersonas {

    private ArrayList<Usuario> listaUsuarios = new ArrayList();
    private File archivo = null;

    public administrarPersonas(String path) {
        archivo = new File(path);
    }

    public File getArchivo() {
        return archivo;
    }
    

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    public ArrayList<Usuario> getListaPersonas() {
        return listaUsuarios;
    }

    public void setListaPersonas(ArrayList<Usuario> listaPersonas) {
        this.listaUsuarios = listaPersonas;
    }

    @Override
    public String toString() {
        return "listaPersonas=" + listaUsuarios;
    }

    //extra mutador
    public void setPersona(Usuario u) {
        this.listaUsuarios.add(u);
    }

    //metodos de administracion
    public void escribirArchivo() throws IOException {
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(archivo, true);
            bw = new BufferedWriter(fw);
            for (Usuario t : listaUsuarios) {
                bw.write(t.getUser()+ ";");
                bw.write(t.getPass()+ "\n");
                
            }
            bw.flush();
        } catch (Exception ex) {
        }
        bw.close();
        fw.close();
    }

    public void cargarArchivo() {
        Scanner sc = null;
        listaUsuarios = new ArrayList();
        if (archivo.exists()) {
            try {
                sc = new Scanner(archivo);
                sc.useDelimiter("\n");
                while (sc.hasNext()) {
                    String next = sc.next();
                    Scanner sc1 = new Scanner(next);
                    listaUsuarios.add(new Usuario(sc1.next(),
                                    sc1.next()
                                 )
                    );
                }
            } catch (Exception ex) {
            }
            sc.close();
        }//FIN IF
    }

}
