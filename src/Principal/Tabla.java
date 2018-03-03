/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.util.Hashtable;
import javax.accessibility.AccessibleContext;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.EventListenerList;
import javax.swing.plaf.ComponentUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

/**
 *
 * @author erick
 */
public class Tabla extends JTable
{
    private String ruta;
    private String grupo;
    private String id;
    private String cadena;
    private String alineado;
    private int alto;
    private int ancho;
    private String metodo; 
    DefaultTableModel filasErrores = new DefaultTableModel(); 

    public Tabla() 
    {
        alto=200;
        ancho=200;
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

    public void setDataModel(TableModel dataModel) {
        this.dataModel = dataModel;
    }

    public void setColumnModel(TableColumnModel columnModel) {
        this.columnModel = columnModel;
    }

    public void setSelectionModel(ListSelectionModel selectionModel) {
        this.selectionModel = selectionModel;
    }

    public void setTableHeader(JTableHeader tableHeader) {
        this.tableHeader = tableHeader;
    }

    public void setRowHeight(int rowHeight) {
        this.rowHeight = rowHeight;
    }

    public void setRowMargin(int rowMargin) {
        this.rowMargin = rowMargin;
    }

    public void setGridColor(Color gridColor) {
        this.gridColor = gridColor;
    }

    public void setShowHorizontalLines(boolean showHorizontalLines) {
        this.showHorizontalLines = showHorizontalLines;
    }

    public void setShowVerticalLines(boolean showVerticalLines) {
        this.showVerticalLines = showVerticalLines;
    }

    public void setAutoResizeMode(int autoResizeMode) {
        this.autoResizeMode = autoResizeMode;
    }

    public void setAutoCreateColumnsFromModel(boolean autoCreateColumnsFromModel) {
        this.autoCreateColumnsFromModel = autoCreateColumnsFromModel;
    }

    public void setPreferredViewportSize(Dimension preferredViewportSize) {
        this.preferredViewportSize = preferredViewportSize;
    }

    public void setRowSelectionAllowed(boolean rowSelectionAllowed) {
        this.rowSelectionAllowed = rowSelectionAllowed;
    }

    public void setCellSelectionEnabled(boolean cellSelectionEnabled) {
        this.cellSelectionEnabled = cellSelectionEnabled;
    }

    public void setEditorComp(Component editorComp) {
        this.editorComp = editorComp;
    }

    public void setCellEditor(TableCellEditor cellEditor) {
        this.cellEditor = cellEditor;
    }

    public void setEditingColumn(int editingColumn) {
        this.editingColumn = editingColumn;
    }

    public void setEditingRow(int editingRow) {
        this.editingRow = editingRow;
    }

    public void setDefaultRenderersByColumnClass(Hashtable defaultRenderersByColumnClass) {
        this.defaultRenderersByColumnClass = defaultRenderersByColumnClass;
    }

    public void setDefaultEditorsByColumnClass(Hashtable defaultEditorsByColumnClass) {
        this.defaultEditorsByColumnClass = defaultEditorsByColumnClass;
    }

    public void setSelectionForeground(Color selectionForeground) {
        this.selectionForeground = selectionForeground;
    }

    public void setSelectionBackground(Color selectionBackground) {
        this.selectionBackground = selectionBackground;
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

    public static int getAUTO_RESIZE_OFF() {
        return AUTO_RESIZE_OFF;
    }

    public static int getAUTO_RESIZE_NEXT_COLUMN() {
        return AUTO_RESIZE_NEXT_COLUMN;
    }

    public static int getAUTO_RESIZE_SUBSEQUENT_COLUMNS() {
        return AUTO_RESIZE_SUBSEQUENT_COLUMNS;
    }

    public static int getAUTO_RESIZE_LAST_COLUMN() {
        return AUTO_RESIZE_LAST_COLUMN;
    }

    public static int getAUTO_RESIZE_ALL_COLUMNS() {
        return AUTO_RESIZE_ALL_COLUMNS;
    }

    public TableModel getDataModel() {
        return dataModel;
    }

    public TableColumnModel getColumnModel() {
        return columnModel;
    }

    public ListSelectionModel getSelectionModel() {
        return selectionModel;
    }

    public JTableHeader getTableHeader() {
        return tableHeader;
    }

    public int getRowHeight() {
        return rowHeight;
    }

    public int getRowMargin() {
        return rowMargin;
    }

    public Color getGridColor() {
        return gridColor;
    }

    public boolean isShowHorizontalLines() {
        return showHorizontalLines;
    }

    public boolean isShowVerticalLines() {
        return showVerticalLines;
    }

    public int getAutoResizeMode() {
        return autoResizeMode;
    }

    public boolean isAutoCreateColumnsFromModel() {
        return autoCreateColumnsFromModel;
    }

    public Dimension getPreferredViewportSize() {
        return preferredViewportSize;
    }

    public boolean isRowSelectionAllowed() {
        return rowSelectionAllowed;
    }

    public boolean isCellSelectionEnabled() {
        return cellSelectionEnabled;
    }

    public Component getEditorComp() {
        return editorComp;
    }

    public TableCellEditor getCellEditor() {
        return cellEditor;
    }

    public int getEditingColumn() {
        return editingColumn;
    }

    public int getEditingRow() {
        return editingRow;
    }

    public Hashtable getDefaultRenderersByColumnClass() {
        return defaultRenderersByColumnClass;
    }

    public Hashtable getDefaultEditorsByColumnClass() {
        return defaultEditorsByColumnClass;
    }

    public Color getSelectionForeground() {
        return selectionForeground;
    }

    public Color getSelectionBackground() {
        return selectionBackground;
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
