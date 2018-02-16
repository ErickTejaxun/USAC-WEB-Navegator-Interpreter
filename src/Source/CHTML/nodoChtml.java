/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Source.CHTML;



/**
 *
 * @author erick
 */
public class nodoChtml 
{
    private String tipo;
    private String value;
    private int columna;
    private int linea;    
    private nodoChtml hijoD;
    private nodoChtml hijoI;

    public nodoChtml() {
    }

    public String getTipo() {
        return tipo;
    }

    public String getValue() {
        return value;
    }

    public int getColumna() {
        return columna;
    }

    public int getLinea() {
        return linea;
    }

    public nodoChtml getHijoD() {
        return hijoD;
    }

    public nodoChtml getHijoI() {
        return hijoI;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public void setLinea(int linea) {
        this.linea = linea;
    }

    public void setHijoD(nodoChtml hijoD) {
        this.hijoD = hijoD;
    }

    public void setHijoI(nodoChtml hijoI) {
        this.hijoI = hijoI;
    }
    
    
    
}
