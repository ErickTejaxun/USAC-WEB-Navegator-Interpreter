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
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.EventListenerList;
import javax.swing.plaf.ComponentUI;
import static Principal.Pagina.botonAgregar;

/**
 *
 * @author erick
 */
public class Boton extends JButton
{
    private String ruta;
    private String grupo;
    private String id;
    private String cadena;
    private String alineado;
    private int alto;
    private int ancho;
    private String metodo;
    
    public Boton()
    {
        this.alto=30;
        this.ancho=100;
        this.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt) 
            {
                click(evt);
            }
        });
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    public String getMetodo() {
        return metodo;
    }
    
    
    
    public void actionPerformed(java.awt.event.ActionEvent evt) 
    {
        click(evt);
    }
            
    private static void click(java.awt.event.ActionEvent evt)
    {                           
        System.out.println("-------------------------Soy un botón, prros.-----------------------------------------");
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

    public void setModel(ButtonModel model) {
        this.model = model;
    }

    public void setChangeListener(ChangeListener changeListener) {
        this.changeListener = changeListener;
    }

    public void setActionListener(ActionListener actionListener) {
        this.actionListener = actionListener;
    }

    public void setItemListener(ItemListener itemListener) {
        this.itemListener = itemListener;
    }

    public void setChangeEvent(ChangeEvent changeEvent) {
        this.changeEvent = changeEvent;
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

    public static String getMODEL_CHANGED_PROPERTY() {
        return MODEL_CHANGED_PROPERTY;
    }

    public static String getTEXT_CHANGED_PROPERTY() {
        return TEXT_CHANGED_PROPERTY;
    }

    public static String getMNEMONIC_CHANGED_PROPERTY() {
        return MNEMONIC_CHANGED_PROPERTY;
    }

    public static String getMARGIN_CHANGED_PROPERTY() {
        return MARGIN_CHANGED_PROPERTY;
    }

    public static String getVERTICAL_ALIGNMENT_CHANGED_PROPERTY() {
        return VERTICAL_ALIGNMENT_CHANGED_PROPERTY;
    }

    public static String getHORIZONTAL_ALIGNMENT_CHANGED_PROPERTY() {
        return HORIZONTAL_ALIGNMENT_CHANGED_PROPERTY;
    }

    public static String getVERTICAL_TEXT_POSITION_CHANGED_PROPERTY() {
        return VERTICAL_TEXT_POSITION_CHANGED_PROPERTY;
    }

    public static String getHORIZONTAL_TEXT_POSITION_CHANGED_PROPERTY() {
        return HORIZONTAL_TEXT_POSITION_CHANGED_PROPERTY;
    }

    public static String getBORDER_PAINTED_CHANGED_PROPERTY() {
        return BORDER_PAINTED_CHANGED_PROPERTY;
    }

    public static String getFOCUS_PAINTED_CHANGED_PROPERTY() {
        return FOCUS_PAINTED_CHANGED_PROPERTY;
    }

    public static String getROLLOVER_ENABLED_CHANGED_PROPERTY() {
        return ROLLOVER_ENABLED_CHANGED_PROPERTY;
    }

    public static String getCONTENT_AREA_FILLED_CHANGED_PROPERTY() {
        return CONTENT_AREA_FILLED_CHANGED_PROPERTY;
    }

    public static String getICON_CHANGED_PROPERTY() {
        return ICON_CHANGED_PROPERTY;
    }

    public static String getPRESSED_ICON_CHANGED_PROPERTY() {
        return PRESSED_ICON_CHANGED_PROPERTY;
    }

    public static String getSELECTED_ICON_CHANGED_PROPERTY() {
        return SELECTED_ICON_CHANGED_PROPERTY;
    }

    public static String getROLLOVER_ICON_CHANGED_PROPERTY() {
        return ROLLOVER_ICON_CHANGED_PROPERTY;
    }

    public static String getROLLOVER_SELECTED_ICON_CHANGED_PROPERTY() {
        return ROLLOVER_SELECTED_ICON_CHANGED_PROPERTY;
    }

    public static String getDISABLED_ICON_CHANGED_PROPERTY() {
        return DISABLED_ICON_CHANGED_PROPERTY;
    }

    public static String getDISABLED_SELECTED_ICON_CHANGED_PROPERTY() {
        return DISABLED_SELECTED_ICON_CHANGED_PROPERTY;
    }

    public ButtonModel getModel() {
        return model;
    }

    public ChangeListener getChangeListener() {
        return changeListener;
    }

    public ActionListener getActionListener() {
        return actionListener;
    }

    public ItemListener getItemListener() {
        return itemListener;
    }

    public ChangeEvent getChangeEvent() {
        return changeEvent;
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

    public static int getCENTER() {
        return CENTER;
    }

    public static int getTOP() {
        return TOP;
    }

    public static int getLEFT() {
        return LEFT;
    }

    public static int getBOTTOM() {
        return BOTTOM;
    }

    public static int getRIGHT() {
        return RIGHT;
    }

    public static int getNORTH() {
        return NORTH;
    }

    public static int getNORTH_EAST() {
        return NORTH_EAST;
    }

    public static int getEAST() {
        return EAST;
    }

    public static int getSOUTH_EAST() {
        return SOUTH_EAST;
    }

    public static int getSOUTH() {
        return SOUTH;
    }

    public static int getSOUTH_WEST() {
        return SOUTH_WEST;
    }

    public static int getWEST() {
        return WEST;
    }

    public static int getNORTH_WEST() {
        return NORTH_WEST;
    }

    public static int getHORIZONTAL() {
        return HORIZONTAL;
    }

    public static int getVERTICAL() {
        return VERTICAL;
    }

    public static int getLEADING() {
        return LEADING;
    }

    public static int getTRAILING() {
        return TRAILING;
    }

    public static int getNEXT() {
        return NEXT;
    }

    public static int getPREVIOUS() {
        return PREVIOUS;
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
