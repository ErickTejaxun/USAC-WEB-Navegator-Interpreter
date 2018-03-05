/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import javax.accessibility.AccessibleContext;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.EventListenerList;
import javax.swing.plaf.ComponentUI;
import static Principal.Navegador.botonAgregar;

/**
 *
 * @author erick
 */
public class Spinner extends JSpinner
{
    private String ruta;
    private String grupo;
    private String id;
    private String cadena;
    private String alineado;
    private int alto;
    private int ancho;
    private String metodo;
    
    public Spinner()
    {
        this.alto=30;
        this.ancho=100;

    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }

    public void setAlineado(String alineado) {
        this.alineado = alineado;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    public void setUi(ComponentUI ui) {
        this.ui = ui;
    }

    public void setListenerList(EventListenerList listenerList) {
        this.listenerList = listenerList;
    }

    public void setAccessibleContext(AccessibleContext accessibleContext) {
        this.accessibleContext = accessibleContext;
    }

    public String getRuta() {
        return ruta;
    }

    public String getGrupo() {
        return grupo;
    }

    public String getId() {
        return id;
    }

    public String getCadena() {
        return cadena;
    }

    public String getAlineado() {
        return alineado;
    }

    public int getAlto() {
        return alto;
    }

    public int getAncho() {
        return ancho;
    }

    public String getMetodo() {
        return metodo;
    }

    public ComponentUI getUi() {
        return ui;
    }

    public EventListenerList getListenerList() {
        return listenerList;
    }

    public static int getWHEN_FOCUSED() {
        return WHEN_FOCUSED;
    }

    public static int getWHEN_ANCESTOR_OF_FOCUSED_COMPONENT() {
        return WHEN_ANCESTOR_OF_FOCUSED_COMPONENT;
    }

    public static int getWHEN_IN_FOCUSED_WINDOW() {
        return WHEN_IN_FOCUSED_WINDOW;
    }

    public static int getUNDEFINED_CONDITION() {
        return UNDEFINED_CONDITION;
    }

    public static String getTOOL_TIP_TEXT_KEY() {
        return TOOL_TIP_TEXT_KEY;
    }

    public static float getTOP_ALIGNMENT() {
        return TOP_ALIGNMENT;
    }

    public static float getCENTER_ALIGNMENT() {
        return CENTER_ALIGNMENT;
    }

    public static float getBOTTOM_ALIGNMENT() {
        return BOTTOM_ALIGNMENT;
    }

    public static float getLEFT_ALIGNMENT() {
        return LEFT_ALIGNMENT;
    }

    public static float getRIGHT_ALIGNMENT() {
        return RIGHT_ALIGNMENT;
    }

    public AccessibleContext getAccessibleContext() {
        return accessibleContext;
    }

    public static int getWIDTH() {
        return WIDTH;
    }

    public static int getHEIGHT() {
        return HEIGHT;
    }

    public static int getPROPERTIES() {
        return PROPERTIES;
    }

    public static int getSOMEBITS() {
        return SOMEBITS;
    }

    public static int getFRAMEBITS() {
        return FRAMEBITS;
    }

    public static int getALLBITS() {
        return ALLBITS;
    }

    public static int getERROR() {
        return ERROR;
    }

    public static int getABORT() {
        return ABORT;
    }

 
    
}
