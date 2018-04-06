/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Source.CJS.principal;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author BARRIOS
 */
public class Simbolo implements Cloneable  {
    
    public String name;
    public String value;
    public String tipe;
    public String rol;
    public String ambito;
    public boolean existe;

    boolean statico;
    public String acceso;

    //parte de objeto
    boolean isobjeto;
    Hashtable<String, Simbolo> atributos;
    
    ArrayList<String> arreglo;
        ArrayList<String> tipoarreglo;
    int tamvec;
    boolean isArray;

    //parte de funcion
    public Proc metodo;
    
    public Simbolo() {
        this.value = "";
        this.tipe = "";
        this.name = "";
        this.rol = "";
        this.ambito = "";
        statico = false;
        acceso = "publico";
        isobjeto = false;
        atributos = null;
        metodo = null;
        arreglo=new ArrayList<>(150);
        tipoarreglo=new ArrayList<>(150);
        tamvec=0;
        isArray=false;
        existe=false;
    }
    
    @Override
    @SuppressWarnings({"CloneDeclaresCloneNotSupported", "RedundantStringConstructorCall", "null"})
    protected Object clone() {
        Simbolo obj = null;
        try {
            obj = (Simbolo) super.clone(); //To change body of generated methods, choose Tools | Templates.
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(Simbolo.class.getName()).log(Level.SEVERE, null, ex);
        }
        obj.name = new String(name);
        obj.value = new String(value);
        obj.tipe = new String(tipe);
        obj.rol = new String(rol);
        obj.ambito = new String(ambito);
        obj.isArray=new Boolean(isArray);
        obj.tipoarreglo=new ArrayList<>(tipoarreglo);
        obj.arreglo=new ArrayList<>(arreglo);
        obj.tamvec=new Integer(tamvec);
        
        
        obj.isobjeto = isobjeto;
        obj.existe=existe;
        obj.statico = statico;
        obj.atributos=atributos;


        return obj;
    }
    
}
