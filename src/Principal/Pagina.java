/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;


import static Principal.Navegador.contenedorPaginas;
import Source.CHTML.Scanner;
import Source.CHTML.dibujador;
import Source.CHTML.nodoChtml;
import Source.CHTML.sintactico;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import Source.CCSS.*;
import Source.CCSS.Ejecucion.*;
import Source.CJS.Analizadores.lexico_cjs;
import Source.CJS.Analizadores.sintactico_cjs;
import Source.CJS.principal.Execute;
import java.awt.Component;
import java.awt.LayoutManager;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.StringReader;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 *
 * @author erick
 */
public class Pagina extends javax.swing.JPanel implements ActionListener{

    public int auxContador = 0;
    public static int contadorPagina= 0;
    public ArrayList<tablaSimbolos> tablaSimbolos_ = new ArrayList();
    public ArrayList<Errores> erroresSintacticos = new ArrayList();
    public ArrayList<Errores> erroresLexicos = new ArrayList();
    public ArrayList<Errores> erroresSemanticos = new ArrayList();
    public ArrayList<Errores> listaErrores = new ArrayList();  /* Errores */
    Hashtable<String, Opcion> opciones
     = new Hashtable<String, Opcion>();
        
    
    public ArrayList<Salida> listaConsola = new ArrayList();
    
    public ArrayList<String> salidas = new ArrayList();
    
    public static ArrayList<String> historial = new ArrayList();
    public String analisisLexico="";      
    public String analisisLexico_="";
    public String resultado="";
    public String ELexico="";
    public String analisisSintactico="";
    public String analisisSemantico="";   
    public Scanner scanner;
    public sintactico parser;
    public nodoChtml raizChtml = new nodoChtml();
    public int contadorChtml=0;
    public int contadorPaginas=0;
    public String consolaSalida = "";
    public String pathCcss ="";
    
    DefaultTableModel filasErrores = new DefaultTableModel(); 
    DefaultTableModel filasSalidas = new DefaultTableModel();
    int flagOpciones = 0;
    int posX, posXAux = 0;
    int posY, posYAux = 0;
    public Color colorFondo = Color.WHITE ;
    public ArrayList<Elemento> elementos = new ArrayList();
    int xMax,  xMaxAux=0;
    int yMax, yMaxAux=0;
    int flagTabla = 0; // 0 Significa Que no pertence a tabla, 1. que sí.
    
    Tabla tablaActual;
    Pagina panelActual = null;
    public int anchoActual=0;
    public Panel panelPrincipal = new Panel();
    public Execute ejecucion;
    
    public String pathCjs="";  

    public sintactico_cjs sintacticoCjs;
    public lexico_cjs lexCjs;
    public Source.CCSS.Analizadores.sintacticoCCSS sintacticoCcss;
    public Source.CCSS.Analizadores.lexicoCCSS lexicoCcss;

    
    //JScrollPane scroll = new JScrollPane();
    /*Lista de elementos CCSS*/   
    public ArrayList<Source.CCSS.Ejecucion.nodoLista> estilosPagina = new ArrayList<>();
    
    public ArrayList<String> archivos = new ArrayList();
    /**
     * Creates new form Panel
     */
    public Pagina() 
    {
        initComponents();        
        filasSalidas = new DefaultTableModel();        
        filasSalidas.addColumn("Archivo");
        filasSalidas.addColumn("Línea");
        filasSalidas.addColumn("Columna");
        filasSalidas.addColumn("Salida consola"); 
        //tablaSalida.setModel(filasSalidas);
        //this.panelContenido.add(scroll);
        
        //
        //areaOpciones.setVisible(false);
        //panelOpciones.setVisible(false);
                
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        Panel = new javax.swing.JPanel();
        panelMenu = new javax.swing.JPanel();
        Menu = new javax.swing.JPanel();
        botonAtras = new javax.swing.JButton();
        botonAdelante = new javax.swing.JButton();
        botonIr = new javax.swing.JButton();
        textRuta = new javax.swing.JTextField();
        botonOpciones = new javax.swing.JButton();
        botonHistorial = new javax.swing.JButton();
        etiquetaNombre = new javax.swing.JLabel();
        botonCerrar = new javax.swing.JButton();
        panelContenido = new javax.swing.JPanel();
        scrollPanel = new javax.swing.JScrollPane();
        scroll = new javax.swing.JPanel();
        panelOpciones = new javax.swing.JPanel();
        areaOpciones = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        archivoCHTML = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        ccss1 = new javax.swing.JTabbedPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        ccssArea1 = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        cjs1 = new javax.swing.JTabbedPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        cjsArea1 = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        contenedorSalidas = new javax.swing.JPanel();
        panelErrores = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        contenedorErrores = new javax.swing.JPanel();

        jMenu1.setText("Favoritos :v");

        jMenuItem1.setText("jMenuItem1");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        setPreferredSize(new java.awt.Dimension(800, 800));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });
        setLayout(new javax.swing.OverlayLayout(this));

        Panel.setPreferredSize(new java.awt.Dimension(600, 600));
        Panel.setLayout(new java.awt.BorderLayout());

        panelMenu.setBackground(new java.awt.Color(0, 255, 102));
        panelMenu.setLayout(new java.awt.BorderLayout());

        Menu.setForeground(new java.awt.Color(255, 204, 0));

        botonAtras.setText("<-");
        botonAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAtrasActionPerformed(evt);
            }
        });

        botonAdelante.setText("->");
        botonAdelante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAdelanteActionPerformed(evt);
            }
        });

        botonIr.setText("Ir a");
        botonIr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonIrActionPerformed(evt);
            }
        });

        textRuta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textRutaKeyPressed(evt);
            }
        });

        botonOpciones.setText("Opciones");
        botonOpciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonOpcionesActionPerformed(evt);
            }
        });

        botonHistorial.setText("Historial");
        botonHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonHistorialActionPerformed(evt);
            }
        });

        etiquetaNombre.setText("USAC WEB NAVEGATOR");

        botonCerrar.setText("X");
        botonCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MenuLayout = new javax.swing.GroupLayout(Menu);
        Menu.setLayout(MenuLayout);
        MenuLayout.setHorizontalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MenuLayout.createSequentialGroup()
                        .addComponent(botonOpciones)
                        .addGap(18, 18, 18)
                        .addComponent(botonHistorial, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MenuLayout.createSequentialGroup()
                        .addComponent(botonAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonAdelante, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonIr, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31)
                .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textRuta)
                    .addGroup(MenuLayout.createSequentialGroup()
                        .addComponent(etiquetaNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 673, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        MenuLayout.setVerticalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MenuLayout.createSequentialGroup()
                .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonCerrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonAdelante, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonIr, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonHistorial, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        panelMenu.add(Menu, java.awt.BorderLayout.CENTER);

        Panel.add(panelMenu, java.awt.BorderLayout.PAGE_START);

        panelContenido.setBackground(new java.awt.Color(51, 204, 255));
        panelContenido.setPreferredSize(new java.awt.Dimension(600, 600));
        panelContenido.setLayout(new java.awt.CardLayout());

        scrollPanel.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPanel.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPanel.setViewportBorder(javax.swing.BorderFactory.createCompoundBorder());
        scrollPanel.setPreferredSize(new java.awt.Dimension(600, 600));

        scroll.setBackground(new java.awt.Color(153, 255, 255));
        scroll.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        scroll.setMinimumSize(new java.awt.Dimension(0, 15767));
        scroll.setPreferredSize(new java.awt.Dimension(600, 3000));
        scroll.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                scrollComponentResized(evt);
            }
        });

        javax.swing.GroupLayout scrollLayout = new javax.swing.GroupLayout(scroll);
        scroll.setLayout(scrollLayout);
        scrollLayout.setHorizontalGroup(
            scrollLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2972, Short.MAX_VALUE)
        );
        scrollLayout.setVerticalGroup(
            scrollLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15767, Short.MAX_VALUE)
        );

        scrollPanel.setViewportView(scroll);

        panelContenido.add(scrollPanel, "card2");

        Panel.add(panelContenido, java.awt.BorderLayout.CENTER);

        panelOpciones.setPreferredSize(new java.awt.Dimension(457, 350));
        panelOpciones.setLayout(new javax.swing.OverlayLayout(panelOpciones));

        areaOpciones.setToolTipText("");

        jPanel1.setLayout(new javax.swing.OverlayLayout(jPanel1));

        archivoCHTML.setColumns(20);
        archivoCHTML.setRows(5);
        jScrollPane3.setViewportView(archivoCHTML);

        jPanel1.add(jScrollPane3);

        areaOpciones.addTab("CHTML", jPanel1);

        jPanel2.setLayout(new javax.swing.OverlayLayout(jPanel2));

        ccssArea1.setColumns(20);
        ccssArea1.setRows(5);
        jScrollPane4.setViewportView(ccssArea1);

        ccss1.addTab("1", jScrollPane4);

        jPanel2.add(ccss1);

        areaOpciones.addTab("CCSS", jPanel2);

        jPanel3.setLayout(new javax.swing.OverlayLayout(jPanel3));

        cjsArea1.setColumns(20);
        cjsArea1.setRows(5);
        jScrollPane5.setViewportView(cjsArea1);

        cjs1.addTab("tab1", jScrollPane5);

        jPanel3.add(cjs1);

        areaOpciones.addTab("CJS", jPanel3);

        jPanel4.setLayout(new javax.swing.OverlayLayout(jPanel4));

        contenedorSalidas.setLayout(new javax.swing.OverlayLayout(contenedorSalidas));
        jScrollPane6.setViewportView(contenedorSalidas);

        jPanel4.add(jScrollPane6);

        areaOpciones.addTab("Consolo Salida", jPanel4);

        panelErrores.setLayout(new javax.swing.OverlayLayout(panelErrores));

        contenedorErrores.setLayout(new javax.swing.OverlayLayout(contenedorErrores));
        jScrollPane2.setViewportView(contenedorErrores);

        panelErrores.add(jScrollPane2);

        areaOpciones.addTab("Consola Errores", panelErrores);

        panelOpciones.add(areaOpciones);

        Panel.add(panelOpciones, java.awt.BorderLayout.PAGE_END);

        add(Panel);
    }// </editor-fold>//GEN-END:initComponents

    private void botonAdelanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAdelanteActionPerformed
        try {
            verPaginaSiguiente();
        } catch (IOException ex) {
            Logger.getLogger(Pagina.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_botonAdelanteActionPerformed

    private void botonEjecutarPerformed(java.awt.event.ActionEvent evt)
    {
        
        
    }
    
    
    private void botonIrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonIrActionPerformed
        try 
        {
            analizar();
            Pagina.contadorPagina=0;
        } 
        catch (IOException ex)
        {
            //Logger.getLogger(this.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }//GEN-LAST:event_botonIrActionPerformed

    private void botonHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonHistorialActionPerformed
                       
            Pagina pagina = new Pagina();
            String currentPath= PathActual()+"\\Historial.chtml"; 
        try {
            imprimirHistorial();
        } catch (IOException ex) {
            Logger.getLogger(Pagina.class.getName()).log(Level.SEVERE, null, ex);
        }
            pagina.textRuta.setText(currentPath); 
            scroll.add(pagina);
        try {
            pagina.analizar();
        } catch (IOException ex) {
            Logger.getLogger(Pagina.class.getName()).log(Level.SEVERE, null, ex);
        }
           contenedorPaginas.addTab("Historial", null, pagina);                                                               
    }//GEN-LAST:event_botonHistorialActionPerformed

    public void imprimirHistorial() throws IOException
    {
        String contenido="< chtml >\n"
                + "    < encabezado >\n" +
            "< titulo > Historial< fin-titulo> \n" +
            "< fin-encabezado >"
                 + "<cuerpo>\n  ";
        
        for(String item : Pagina.historial)
        {
            String partes[] = item.split(",");
            contenido= contenido+
                    "<texto alto=\"30\"; ancho=\"500\"; > " + partes[0] + " <fin-texto> \n "+
                   "<enlace alto=\"30\"; ancho=\"200\"; ruta=\"" + partes[0] + "\";> Ir  <fin-enlace>\n "+
                   "<texto alto=\"30\"; ancho=\"300\"; > " + partes[1] + " <fin-texto> \n "+
                   "<salto-fin> \n";
        }
        
        contenido = contenido + "< fin-cuerpo >\n"
                + "<fin-chtml>";
        
        String ruta = PathActual()+"\\Historial.chtml";
        File archivo = new File(ruta);
        BufferedWriter bw;
        if(archivo.exists()) {
            bw = new BufferedWriter(new FileWriter(archivo));
            bw.write(contenido);
        } else {
            bw = new BufferedWriter(new FileWriter(archivo));
            bw.write(contenido);
        }
        bw.close();        
        

    }
    
    private void botonOpcionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonOpcionesActionPerformed
        if(flagOpciones==0)
        {
            panelOpciones.setVisible(true);            
            flagOpciones = 1;
        }else
        if(flagOpciones==1)
        {
            panelOpciones.setVisible(false);
            flagOpciones = 0;
        }          
    }//GEN-LAST:event_botonOpcionesActionPerformed

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized


    }//GEN-LAST:event_formComponentResized

    private void textRutaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textRutaKeyPressed
          if(evt.getKeyCode() == evt.VK_ENTER) 
          {
                try 
                {
                    analizar();
                } 
                catch (IOException ex)
                {
                    //Logger.getLogger(this.class.getName()).log(Level.SEVERE, null, ex);
                }                                                
          }    
        
        
 
    }//GEN-LAST:event_textRutaKeyPressed

    private void botonAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAtrasActionPerformed
        try {
            verPaginaAnterior();
        } catch (IOException ex) {
            Logger.getLogger(Pagina.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_botonAtrasActionPerformed

    private void botonCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCerrarActionPerformed
        int actual = Navegador.contenedorPaginas.getSelectedIndex();
        Navegador.contenedorPaginas.remove(actual);
    }//GEN-LAST:event_botonCerrarActionPerformed

    private void scrollComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_scrollComponentResized
        posX = posY = xMax = yMax=  0;
        //panelPrincipal = new Panel();
        panelPrincipal = new Panel();
        panelPrincipal.setBounds(0, 0, scroll.getWidth(), Panel.getHeight());
        panelPrincipal.setAncho(Panel.getWidth());
        panelPrincipal.setAlto(scroll.getHeight());
        prepararPanel(panelPrincipal);
        generarObjetos(raizChtml,panelPrincipal);
        Interfaz(panelPrincipal); // Generamos la interfaz
        scroll.add(panelPrincipal);
    }//GEN-LAST:event_scrollComponentResized

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void botonActionPerformed(java.awt.event.ActionEvent evt)
    {
       etiquetaNombre.setText("Has pulsado el botón " );	 
    }
    

public void prepararPanel(Panel nuevo)
{
    nuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    nuevo.setMinimumSize(new java.awt.Dimension(0, 15767));
    nuevo.setPreferredSize(new java.awt.Dimension(nuevo.getAncho(),nuevo.getAlto()));
}
    
public void analizar() throws IOException
{
        scroll.removeAll();
        tablaSimbolos_.clear();
        erroresLexicos.clear();
        elementos.clear();
        erroresSintacticos.clear();
        elementos.clear();
        archivos.clear();
        compilar(); 
        
        if(
                (!erroresLexicos.isEmpty())
                ||(!erroresSintacticos.isEmpty())
                ||(erroresSemanticos.size()!=0))
        {
            errores_consola();
        }  
        
        ponerTitulo();
        
        /*Generamos la gráfica del arbol.*/
        dibujador aux = new dibujador();           
        //aux.generarGrafica(raizChtml);
        
        /*Preparamos el panel a insertar a la página.*/
        posX = posY = xMax = yMax=  0;
        panelPrincipal = new Panel();        
        panelPrincipal.setBounds(0, 0, scroll.getWidth(), 3000);
        panelPrincipal.setAncho(scroll.getWidth());
        panelPrincipal.setAlto(3000);        
        prepararPanel(panelPrincipal);
        
        /*Analizamos el arbol y generamos lista de objetos*/
        generarObjetos(raizChtml,panelPrincipal);  
        
        /*Analizar los archivos cjs y ccss*/
        analizarArchivos();    
        estilosPagina = (ArrayList)listaBloque.lbloques.clone(); // Copiamos de la clase estatatica.
        listaBloque.lbloques.clear(); // Liberamos la clase estatica.
        
        /*Agregamos el panel principal a la lista de elementos.*/
        Elemento elemento = new Elemento("cuerpo", "panel", panelPrincipal);
        elementos.add(elemento);
        
        

        
        

        
        /*A partir de la lista de objetos los dibujamos sobre el panelPrincipal.*/
        Interfaz(panelPrincipal);   
        
        //interpretarcjs(texto, this);
        
        lanzarCjs();
                        
        /*Agregamos el panel a nuestro scroll(en pagina vacía).*/
        scroll.add(panelPrincipal);
        
        imprimirReporteLexico();
        imprimirResultado();
        imprimirLexicos();
        imprimirSintacticos();
        imprimirSemanticos(); 
        mostrarChtml();
        mostrarCjs();
        errores_consola();
        
        
        //
        //ejecucion.page = this;        
} 
    
    public void interprestarCjs(String path) throws FileNotFoundException
    {
        InputStream is = new FileInputStream(path);
        Reader reader = new InputStreamReader(is);        
        lexCjs=new  lexico_cjs(new BufferedReader(reader));
        sintacticoCjs=new sintactico_cjs(lexCjs);
        try {
            sintacticoCjs.parse();
            if(sintacticoCjs.Raiz!=null){
                //graficar.graficar(sintactico.Raiz, "prueba");
                System.out.println("graficado");
                
                ejecucion=new  Execute(this);
                ejecucion.page = this;
                ejecucion.addVariables_Funciones(sintacticoCjs.Raiz);
                ejecucion.InitialExecute();
                

                
                
                //System.out.print("finejecucion");
            }
        } catch (Exception ex) {
            //Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }

    public void interpretarccss(String path) {
        
        
        
        
        try {
            InputStream is = new FileInputStream(path);
            Reader reader = new InputStreamReader(is);
            lexicoCcss  = new Source.CCSS.Analizadores.lexicoCCSS(reader);
            sintacticoCcss=new Source.CCSS.Analizadores.sintacticoCCSS( lexicoCcss);
            sintacticoCcss.parse(); 
            
            Source.CCSS.AST.nodo raiz = sintacticoCcss.getRaiz();
            Source.CCSS.Ejecucion.recorrerArbol.recorrido(raiz);            
            Source.CCSS.AST.graficarAST graficar = new Source.CCSS.AST.graficarAST(raiz);
            Source.CCSS.Ejecucion.listaElemento.imprimirBloque();
        } catch (Exception ex) {
            System.out.println("Error fatal en compilación de entrada." );
            System.out.println("Causa: "+ex.getMessage());
        } 
    }



public void ponerTitulo()
{       
    String ruta = textRuta.getText();
    StringTokenizer token = new StringTokenizer(ruta, "\\");
    while (token.hasMoreTokens()) {
            ruta = token.nextToken();                
    }       
    
    int panelActual =  Navegador.contenedorPaginas.getSelectedIndex();      
}

public MouseListener agregarListener()
{
    MouseListener boton =new MouseListener(){

        public void mouseClicked(MouseEvent event) 
        {

            Boton fuente = (Boton)event.getSource();
            Mensaje(fuente.getCadena(), fuente.getCadena());
        }

        @Override
        public void mousePressed(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseExited(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    };    
    
    return boton;
}


public void mostrarCjs()
{
      ccss1.removeAll();
      cjs1.removeAll();
      File archivo = null;
      FileReader fr = null;
      BufferedReader br = null;
      String contenido="";
      boolean existe=false;

      String nombre="";
      for(String texto: archivos)
      {
        File archivoExiste = new File(texto);   
        if (archivoExiste.exists()){existe=true;}else{existe=false;}
        archivoExiste = null;
        if(existe)
        {
            
            try 
            {
               archivoExiste = new File (texto);
               fr = new FileReader (archivoExiste);
               br = new BufferedReader(fr);
               String linea;
               while((linea=br.readLine())!=null)
                   contenido = contenido +"\n"+ linea;              
            }
            catch(Exception e){
               e.printStackTrace();
            }finally{
               try{                    
                  if( null != fr ){   
                     fr.close();     
                  }                  
               }catch (Exception e2){ 
                  e2.printStackTrace();
               }
            }
            StringTokenizer token = new StringTokenizer(texto, "\\");
            while (token.hasMoreTokens()) {
                    nombre = token.nextToken();                
            }  
            token  = new StringTokenizer(nombre, ".");
            String tipo ="";
            while (token.hasMoreTokens()) {
                    tipo = token.nextToken();                
            }          
            switch(tipo)
            {
                case "ccss":
                                        
                    JPanel contPanel = new JPanel();
                    contPanel.setLayout(new javax.swing.OverlayLayout(contPanel));
                    JTextArea nuevo = new JTextArea(contenido);
                    contPanel.add(nuevo);                    
                    ccss1.add(nombre,  new JScrollPane(contPanel));                 
                    break;
                case "cjs":  
                    contPanel = new JPanel();
                    contPanel.setLayout(new javax.swing.OverlayLayout(contPanel));
                    nuevo = new JTextArea(contenido);
                    contPanel.add(nuevo);
                    cjs1.add(nombre, new JScrollPane(contPanel));                 
                    break;   
                 default:
                     archivoCHTML.setText(contenido);
                     break;
            }            
        }

        contenido="";
      }
}


public void analizarArchivos()
{
      String nombre="";
      for(String texto: archivos)
      {                    
            StringTokenizer token  = new StringTokenizer(texto, ".");
            String tipo ="";
            while (token.hasMoreTokens()) 
            {
                    tipo = token.nextToken();                
            }          
            switch(tipo)
            {
                case "ccss":
                    /*Quitar lo static y poner que nos devuelva la lista.*/
                    this.pathCcss = texto;
                    interpretarccss(texto);
                    break;
                case "cjs":
                    
                    break;   
            }                   
      }
}


public void lanzarCjs() throws FileNotFoundException
{
      String nombre="";
      for(String texto: archivos)
      {                    
            StringTokenizer token  = new StringTokenizer(texto, ".");
            String tipo ="";
            while (token.hasMoreTokens()) 
            {
                    tipo = token.nextToken();                
            }          
            switch(tipo)
            {
                case "ccss":
                    /*Quitar lo static y poner que nos devuelva la lista.*/
                    //interpretarccss(texto);
                    break;
                case "cjs":
                    this.pathCjs = texto;
                    interprestarCjs(texto);
                    break;   
            }                   
      }
}


public void mostrarChtml()
{
      File archivo = null;
      FileReader fr = null;
      BufferedReader br = null;

      try 
      {
         archivo = new File (textRuta.getText());         
         if(archivo.isFile() && archivo.exists())
         {
            fr = new FileReader (archivo);
            br = new BufferedReader(fr);
            String linea;
            while((linea=br.readLine())!=null)
            archivoCHTML.setText(archivoCHTML.getText() +"\n" + linea);         
         }

      }
      catch(Exception e){
         e.printStackTrace();
      }finally{
         // En el finally cerramos el fichero, para asegurarnos
         // que se cierra tanto si todo va bien como si salta 
         // una excepcion.
         try{                    
            if( null != fr ){   
               fr.close();     
            }                  
         }catch (Exception e2){ 
            e2.printStackTrace();
         }
      }
}
public void limpiarSalidas()
{
        filasErrores = new DefaultTableModel(); 
        filasSalidas = new DefaultTableModel();
        filasErrores.addColumn("Archivo");
        filasErrores.addColumn("Línea");
        filasErrores.addColumn("Columna");
        filasErrores.addColumn("Tipo");
        filasErrores.addColumn("Descripción");
            
        filasSalidas.addColumn("Archivo");
        filasSalidas.addColumn("Línea");
        filasSalidas.addColumn("Columna");
        filasSalidas.addColumn("SalidaX"); 
        //tablaSalida.setModel(filasSalidas);
}

public void compilar(){

        Scanner.listaErrores.clear();
        String path=textRuta.getText();
        path = quitarComillas(path);
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        Pagina.historial.add(path+ "," + date);      
        
        File archivo = new File(path);             
        if(archivo.exists() && !archivo.isDirectory())
        {
            try 
            {            
               scanner=new Scanner(new java.io.FileReader(path));      
               erroresLexicos = Scanner.listaErrores;
               Scanner.tablaSimbolos_.clear();
               parser = new sintactico(scanner);
               parser.parse();
               tablaSimbolos_ = Scanner.tablaSimbolos_;
               raizChtml = sintactico.raizChtml;
               int numero= tablaSimbolos_.size();
               System.out.println("Columna\tLinea\tValor\tTipo\tDescripción");                
               for(int n=0;n<numero;n++)
               {
                   System.out.println(
                           tablaSimbolos_.get(n).columna +
                           "\t"+tablaSimbolos_.get(n).linea+
                           "\t"+tablaSimbolos_.get(n).Valor+ 
                           "\t"+tablaSimbolos_.get(n).tipo+ 
                           "\t\t"+tablaSimbolos_.get(n).descripcion);
               }
               System.out.println(numero);
           }
           catch(Exception e) { System.out.println(e.getMessage());}        
        }
        else
        {
            JOptionPane.showMessageDialog(areaOpciones, "El archivo no ha sido encontrado.");
        }
}



   public void generarObjetos(nodoChtml raiz, Panel panel)
    {
        
        String retorno="";
        if(raiz!=null)
        {
            System.out.println(raiz.getValue());
            switch(raiz.getValue())
            {
                case "DOCUMENTO":
                    for(nodoChtml aux: raiz.getHijos())
                    {
                        generarObjetos(aux, panel);
                    }
                    break;
                    
                case "ENCABEZADO":                                
                    for(nodoChtml aux: raiz.getHijos())
                    {
                        generarObjetos(aux, panel);
                    }
                    break;
                case "LISTAARCHIVOS":
                    for(nodoChtml aux: raiz.getHijos())
                    {                        
                        archivos.add(quitarComillas(aux.getValue())); // Agregamos los archivos a analizar.
                    }
                    break;
                case "TITULO": 
                    String titulo = "";
                    for(nodoChtml aux: raiz.getHijos())
                    {
                        titulo = titulo + aux.getValue();
                    }                                    
                    etiquetaNombre.setText(quitarComillas(titulo));
                    break;
                case "SALTO":                                   
                    Elemento salto = new Elemento();
                    salto.setNombre("salto");
                    salto.setTipo("salto");
                    panel.getElementos().add(salto);
                    break;                    
                case  "CUERPO":
                    for(nodoChtml aux: raiz.getHijos())
                    {
                        generarObjetos(aux,panel);
                    }
                    break;
                case "ELEMENTO":
                        nodoChtml hijoI = raiz.getHijos().get(0);
                        nodoChtml hijoD = raiz.getHijos().get(1);
                        switch(hijoI.getValue().toLowerCase())
                        {                                                                 
                            case "id":
                                panel.setName(quitarComillas(hijoD.getValue()));
                                panel.setId(quitarComillas(hijoD.getValue()));
                                break;
                            case "grupo":
                                panel.setGrupo(quitarComillas(hijoD.getValue()));                                    
                                break;
                            case "cadena":
                                panel.setCadena(quitarComillas(hijoD.getValue()));                                                                                           
                                break; 
                            case "ancho":                                                                        
                                String numero = hijoD.getValue();
                                numero = numero.substring(1,numero.length()-1);
                                if (esNumero(numero))
                                {
                                    panel.setAncho(Integer.valueOf(numero));
                                } 
                                break;
                            case "alto":            
                                numero = hijoD.getValue();
                                numero = numero.substring(1,numero.length()-1);
                                if (esNumero(numero))
                                {
                                    panel.setAlto(Integer.valueOf(numero));
                                }     
                                break; 
                            case "alineado":                                                                        
                                switch(hijoD.getValue())
                                {
                                    case "\"izquierda\"":
                                        panel.setAlineado("izquierda");                                        
                                        panel.setAlignmentX(LEFT_ALIGNMENT);
                                        panel.setLayout(new FlowLayout(FlowLayout.LEFT));
                                        break;
                                    case "\"derecha\"":
                                        panel.setAlineado("derecha");
                                        panel.setAlignmentX(RIGHT_ALIGNMENT);
                                        panel.setLayout(new FlowLayout(FlowLayout.RIGHT));
                                        break;  
                                    case "\"centrado\"":
                                        panel.setAlineado("centrado");
                                        panel.setAlignmentX(CENTER_ALIGNMENT);
                                        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
                                        break;   
                                    default :
                                        //filasErrores.addRow(new String[]{"CHTML",String.valueOf(hijoD.getLinea()),String.valueOf(hijoD.getColumna()),
                                          //  "Sintactico","Valor de alineacion incorrecto"});
                                        String mensaje = raiz.getValue() + "Nombre de color no válido.";
                                        erroresSemanticos.add( new Errores("Sematico", raiz.getLinea(), raiz.getColumna(), mensaje ));                                        
                                        break;                                          
                                }
                                break;  
                            case "click":                                                                       
                                panel.setMetodo(quitarComillas(hijoD.getValue()));
                                break; 
                            case "ruta":                                                                       
                                panel.setRuta(quitarComillas(hijoD.getValue()));
                                break;   
                            case "color":
                                if(hijoD.getValue().substring(1,2).equals("#"))
                                {
                                    if(hijoD.getValue().length()==9)
                                    {
                                        //Color colorFodo = new Color(int r, int g, int b, int a);
                                        //this.scroll.setBackground(colorFondo);
                                        int r,g,b,a;
                                        String hr,hg,hb,ha;
                                        String entrada= hijoD.getValue();
                                        hr = entrada.substring(2,4);
                                        hg = entrada.substring(4,6);
                                        hb = entrada.substring(6,8);

                                        r = hexToDec(hr);
                                        g = hexToDec(hg);
                                        b = hexToDec(hb);
                                        a=0;
                                        if(r==300 || g ==300 || b==300)
                                        {
                                            //filasErrores.addRow(new String[]{"CHTML",String.valueOf(hijoD.getLinea()),String.valueOf(hijoD.getColumna()),"Semantico", hijoD.getValue() + " Valor rgb no valido."});
                                            String mensaje = raiz.getValue() + "Valor rgb no válido.";
                                            erroresSemanticos.add( new Errores("Sematico", raiz.getLinea(), raiz.getColumna(), mensaje ));
                                            break;
                                        }

                                        panel.setBackground(new Color(r,g,b));
                                        colorFondo = new Color(r,g,b);
                                    }
                                    else
                                    {
                                        //filasErrores.addRow(new String[]{"CHTML",String.valueOf(hijoD.getLinea()),String.valueOf(hijoD.getColumna()),"Semantico","Valor rgb no valido."});
                                        String mensaje = raiz.getValue() + "Valor rgb no válido.";
                                        erroresSemanticos.add( new Errores("Sematico", raiz.getLinea(), raiz.getColumna(), mensaje ));                                        
                                        break;
                                    }
                                }
                                else
                                {
                                    panel.setBackground(buscarColor(hijoD));
                                    colorFondo = buscarColor(raiz.getHijos().get(0));
                                }  
                                break;
                        }                                                                                                                 
                    break;
                    
                    
                case "CONTENIDO"   :
                    for(nodoChtml aux: raiz.getHijos())
                    {
                        generarObjetos(aux,panel);
                    }
                    break;
                    
                case "ENLACE":
                    System.out.println("---------------------------ENLACE---------------------");
                    //Vemos todos los elementos :v
                    Enlace enlace = new Enlace();
                    enlace.setBackground(colorFondo);
                    enlace.setOpaque(true);
                    for(nodoChtml aux: raiz.getHijos())
                    {                        
                        if(aux.getValue().equals("ELEMENTO"))
                        {
                            switch(aux.getHijos().get(0).getValue().toLowerCase())
                            {
                                
                                case "ruta":                                    
                                    enlace.setRuta(quitarComillas(aux.getHijos().get(1).getValue()));                                    
                                    break;
                                case "id":
                                    enlace.setId(quitarComillas(aux.getHijos().get(1).getValue()));                                    
                                    break;
                                case "grupo":
                                    enlace.setGrupo(quitarComillas(aux.getHijos().get(1).getValue()));                                    
                                    break;
                                case "cadena":
                                    enlace.setCadena(quitarComillas(aux.getHijos().get(1).getValue()));                                    
                                    enlace.setText(quitarComillas(enlace.getCadena()));
                                    break; 
                                case "ancho":                                                                        
                                    if (esNumero(aux.getHijos().get(1).getValue()))
                                    {
                                        enlace.setAncho(Integer.valueOf(aux.getHijos().get(1).getValue()));
                                    }                                       
                                    break;
                                case "alto":                                                                        
                                    if (esNumero(aux.getHijos().get(1).getValue()))
                                    {
                                        enlace.setAlto(Integer.valueOf(aux.getHijos().get(1).getValue()));
                                    }                                                                                                                                   
                                    break; 
                                case "alineado":                                                                        
                                    switch(aux.getHijos().get(1).getValue())
                                    {
                                        case "\"izquierda\"":
                                            enlace.setAlineado("izquierda");
                                            enlace.setAlignmentX(LEFT_ALIGNMENT);
                                            break;
                                        case "\"derecha\"":
                                            enlace.setAlineado("derecha");
                                            enlace.setAlignmentX(RIGHT_ALIGNMENT);
                                            break;  
                                        case "\"centrado\"":
                                            enlace.setAlineado("centrado");
                                            enlace.setAlignmentX(CENTER_ALIGNMENT);
                                            break;   
                                        default :
                                            filasErrores.addRow(new String[]{"CHTML",String.valueOf(aux.getHijos().get(1).getLinea()),String.valueOf(aux.getHijos().get(1).getColumna()),
                                                "Sintactico","Valor de alineacion incorrecto"});
                                            break;                                          
                                    }
                                    System.out.println("------------ALINEACION: \t"+enlace.getAlineado());
                                    break;                                     
                            }
                        }
                    }
                    /*
                    
                    */                    
                    Elemento elemento = new Elemento(enlace.getId(),"enlace",enlace);
                   panel.getElementos().add(elemento);                                     
                    break;
                    
                case "BOTON":
                    System.out.println("---------------------------BOTON---------------------");                    
                    Boton boton = new Boton();                    
                    for(nodoChtml aux: raiz.getHijos())
                    {                        
                        if(aux.getValue().equals("ELEMENTO"))
                        {
                            switch(aux.getHijos().get(0).getValue().toLowerCase())
                            {
                                case "ruta":
                                    boton.setRuta(quitarComillas(aux.getHijos().get(1).getValue()));                                    
                                    break;
                                case "click":                                                                       
                                    boton.setMetodo(quitarComillas(aux.getHijos().get(1).getValue()));
                                    break;                                     
                                case "id":
                                    boton.setId(quitarComillas(aux.getHijos().get(1).getValue()));                                    
                                    break;
                                case "grupo":
                                    boton.setGrupo(quitarComillas(aux.getHijos().get(1).getValue()));                                    
                                    break;
                                case "cadena":
                                    boton.setCadena(quitarComillas(aux.getHijos().get(1).getValue()));                                    
                                    boton.setText(quitarComillas(boton.getCadena()));
                                    break; 
                                case "ancho":          
                                    String numero = aux.getHijos().get(1).getValue().substring(1,aux.getHijos().get(1).getValue().length()-1);
                                    if (esNumero(numero))
                                    {
                                        boton.setAncho(Integer.valueOf(numero));
                                    }                                       
                                    break;
                                case "alto":  
                                    numero = aux.getHijos().get(1).getValue().substring(1,aux.getHijos().get(1).getValue().length()-1);                                    
                                    if (esNumero(numero))
                                    {
                                        boton.setAlto(Integer.valueOf(numero));
                                    }                                                                                                                                   
                                    break; 
                                case "alineado":                                                                        
                                    switch(aux.getHijos().get(1).getValue())
                                    {
                                        case "\"izquierda\"":
                                            boton.setAlineado("izquierda");
                                            boton.setAlignmentX(LEFT_ALIGNMENT);
                                            break;
                                        case "\"derecha\"":
                                            boton.setAlineado("derecha");
                                            boton.setAlignmentX(RIGHT_ALIGNMENT);
                                            break;  
                                        case "\"centrado\"":
                                            boton.setAlineado("centrado");
                                            boton.setAlignmentX(CENTER_ALIGNMENT);
                                            break;   
                                        default :
                                            filasErrores.addRow(new String[]{"CHTML",String.valueOf(aux.getHijos().get(1).getLinea()),String.valueOf(aux.getHijos().get(1).getColumna()),
                                                "Sintactico","Valor de alineacion incorrecto"});
                                            break;                                          
                                    }
                                    break;                                     
                            }
                        }
                    }      
                    if(flagTabla==1)
                    {
                        Elemento tablaAuxiliar =  elementos.get(elementos.size());                                                
                    }
                    elemento = new Elemento(boton.getId(),"boton",boton);
                    panel.getElementos().add(elemento);                                     
                    break;                    
                    
                    
                case "SPINNER":
                    System.out.println("---------------------------SPINNER---------------------");                    
                    Spinner spinner = new Spinner();
                    for(nodoChtml aux: raiz.getHijos())
                    {                        
                        if(aux.getValue().equals("ELEMENTO"))
                        {
                            switch(aux.getHijos().get(0).getValue().toLowerCase())
                            {
                                case "ruta":
                                    spinner.setRuta(quitarComillas(aux.getHijos().get(1).getValue()));                                    
                                    break;
                                case "click":                                                                       
                                    spinner.setMetodo(quitarComillas(aux.getHijos().get(1).getValue()));
                                    break;                                     
                                case "id":
                                    spinner.setId(quitarComillas(aux.getHijos().get(1).getValue()));                                    
                                    break;
                                case "grupo":
                                    spinner.setGrupo(quitarComillas(aux.getHijos().get(1).getValue()));                                    
                                    break;
                                case "entero":
                                    spinner.setCadena(quitarComillas(aux.getHijos().get(1).getValue()));                                                                        
                                    break; 
                                case "ancho":                                                                        
                                    if (esNumero(aux.getHijos().get(1).getValue()))
                                    {
                                        spinner.setAncho(Integer.valueOf(aux.getHijos().get(1).getValue()));
                                    }                                       
                                    break;
                                case "alto":                                                                        
                                    if (esNumero(aux.getHijos().get(1).getValue()))
                                    {
                                        spinner.setAlto(Integer.valueOf(aux.getHijos().get(1).getValue()));
                                    }                                                                                                                                   
                                    break; 
                                case "alineado":                                                                        
                                    switch(aux.getHijos().get(1).getValue())
                                    {
                                        case "\"izquierda\"":
                                            spinner.setAlineado("izquierda");
                                            spinner.setAlignmentX(LEFT_ALIGNMENT);
                                            break;
                                        case "\"derecha\"":
                                            spinner.setAlineado("derecha");
                                            spinner.setAlignmentX(RIGHT_ALIGNMENT);
                                            break;  
                                        case "\"centrado\"":
                                            spinner.setAlineado("centrado");
                                            spinner.setAlignmentX(CENTER_ALIGNMENT);
                                            break;   
                                        default :
                                            filasErrores.addRow(new String[]{"CHTML",String.valueOf(aux.getHijos().get(1).getLinea()),String.valueOf(aux.getHijos().get(1).getColumna()),
                                                "Sintactico","Valor de alineacion incorrecto"});
                                            break;                                          
                                    }
                                    System.out.println("------------ALINEACION: \t"+spinner.getAlineado());
                                    break;                                     
                            }
                        }
                    }                   
                    elemento = new Elemento(spinner.getId(),"spinner",spinner);
                    panel.getElementos().add(elemento);                                     
                    break;                    
                    
                case "TEXTO":
                    System.out.println("---------------------------TEXTO---------------------");
                    //Vemos todos los elementos :v
                    Texto texto = new Texto();
                    //texto.setBackground(colorFondo);
                    for(nodoChtml aux: raiz.getHijos())
                    {                        
                        if(aux.getValue().equals("ELEMENTO"))
                        {
                            switch(aux.getHijos().get(0).getValue().toLowerCase())
                            {                                                                 
                                case "id":
                                    texto.setId(quitarComillas(aux.getHijos().get(1).getValue()));
                                    break;
                                case "grupo":
                                    texto.setGrupo(quitarComillas(aux.getHijos().get(1).getValue()));                                    
                                    break;
                                case "cadena":
                                    texto.setCadena(quitarComillas(aux.getHijos().get(1).getValue()));                                    
                                    texto.setText(quitarComillas(texto.getCadena()));
                                    //texto.setAlto(texto.cadena.length());
                                    break; 
                                case "ancho":                                                                        
                                    String ancho = aux.getHijos().get(1).getValue().substring(1,aux.getHijos().get(1).getValue().length()-1);
                                    System.out.println(aux.getHijos().get(1).getValue()+"  ANCHO ---- "+ancho);
                                    if (esNumero(ancho))
                                    {
                                        System.out.println("--Valor válido--");
                                        texto.setAncho(Integer.valueOf(ancho));
                                    }                                       
                                    break;
                                case "alto":                                                                        
                                    String alto = aux.getHijos().get(1).getValue().substring(1,aux.getHijos().get(1).getValue().length()-1);
                                    System.out.println(aux.getHijos().get(1).getValue()+"  ALTO ---- "+alto);
                                    if (esNumero(alto))
                                    {
                                        System.out.println("--Valor válido--");
                                        texto.setAlto(Integer.valueOf(alto));
                                    }                                                                                                                                   
                                    break; 
                                case "alineado":                                                                        
                                    switch(aux.getHijos().get(1).getValue())
                                    {
                                        case "\"izquierda\"":
                                            texto.setAlineado("izquierda");
                                            texto.setAlignmentX(LEFT_ALIGNMENT);
                                            break;
                                        case "\"derecha\"":
                                            texto.setAlineado("derecha");
                                            texto.setAlignmentX(RIGHT_ALIGNMENT);
                                            break;  
                                        case "\"centrado\"":
                                            texto.setAlineado("centrado");
                                            texto.setAlignmentX(CENTER_ALIGNMENT);
                                            break;   
                                        default :
                                            filasErrores.addRow(new String[]{"CHTML",String.valueOf(aux.getHijos().get(1).getLinea()),String.valueOf(aux.getHijos().get(1).getColumna()),
                                                "Sintactico","Valor de alineacion incorrecto"});
                                            break;                                          
                                    }
                                    System.out.println("------------ALINEACION: \t"+texto.getAlineado());
                                    break;                                     
                            }
                        }
                    }                    
                    elemento = new Elemento(texto.getId(),"texto",texto);    
                    panel.getElementos().add(elemento);
                    break;  
/*--------------------------------------------------Caja area de texto--------------------------------------------------*/                   
                case "TEXTOA":
                    System.out.println("---------------------------TEXTOA---------------------");
                    //Vemos todos los elementos :v
                    areaTexto area = new areaTexto();
                    area.setBackground(Color.white);
                    for(nodoChtml aux: raiz.getHijos())
                    {                        
                        if(aux.getValue().equals("ELEMENTO"))
                        {
                            switch(aux.getHijos().get(0).getValue().toLowerCase())
                            {                                                                 
                                case "id":
                                    area.setId(quitarComillas(aux.getHijos().get(1).getValue()));
                                    break;
                                case "grupo":
                                    area.setGrupo(quitarComillas(aux.getHijos().get(1).getValue()));                                    
                                    break;
                                case "cadena":
                                    area.setCadena(quitarComillas(aux.getHijos().get(1).getValue()));                                    
                                    area.setText(quitarComillas(area.getCadena()));
                                    //texto.setAlto(texto.cadena.length());
                                    break; 
                                case "ancho":     
                                    String ancho = aux.getHijos().get(1).getValue().substring(1,aux.getHijos().get(1).getValue().length()-1);
                                    System.out.println("ANCHO ---- "+ancho);
                                    if (esNumero(ancho))
                                    {
                                        area.setAncho(Integer.valueOf(ancho));
                                        area.setAncho(area.getAncho());
                                    }                                       
                                    break;
                                case "alto": 
                                    String alto = aux.getHijos().get(1).getValue().substring(1,aux.getHijos().get(1).getValue().length()-1);
                                    System.out.println("ALTO ---- "+alto);
                                    if (esNumero(alto))
                                    {
                                        area.setAlto(Integer.valueOf(alto));
                                        area.setAlto(area.getAlto());
                                    }                                                                                                                                   
                                    break; 
                                case "alineado":                                                                        
                                    switch(aux.getHijos().get(1).getValue())
                                    {
                                        case "\"izquierda\"":
                                            area.setAlineado("izquierda");
                                            area.setAlignmentX(LEFT_ALIGNMENT);
                                            break;
                                        case "\"derecha\"":
                                            area.setAlineado("derecha");
                                            area.setAlignmentX(RIGHT_ALIGNMENT);
                                            break;  
                                        case "\"centrado\"":
                                            area.setAlineado("centrado");
                                            area.setAlignmentX(CENTER_ALIGNMENT);
                                            break;   
                                        default :
                                            filasErrores.addRow(new String[]{"CHTML",String.valueOf(aux.getHijos().get(1).getLinea()),String.valueOf(aux.getHijos().get(1).getColumna()),
                                                "Sintactico","Valor de alineacion incorrecto"});
                                            break;                                          
                                    }
                                    System.out.println("------------ALINEACION: \t"+area.getAlineado());
                                    break;                                     
                            }
                        }
                    }   
                    area.setBorder(BorderFactory.createLineBorder(Color.black));
                    elemento = new Elemento(area.getId(),"area",area);    
                    panel.getElementos().add(elemento);
                    break;      
                    
/*CAJA DE TEXTO SIN LINEAS-----------------------------------------------*/  
                    
                case "CAJATEXTO":
                    System.out.println("---------------------------CAJATEXTO---------------------");
                    //Vemos todos los elementos :v
                    Caja caja = new Caja();                    
                    for(nodoChtml aux: raiz.getHijos())
                    {                        
                        if(aux.getValue().equals("ELEMENTO"))
                        {
                            switch(aux.getHijos().get(0).getValue().toLowerCase())
                            {                                                                 
                                case "id":
                                    caja.setId(quitarComillas(aux.getHijos().get(1).getValue()));
                                    break;
                                case "grupo":
                                    caja.setGrupo(quitarComillas(aux.getHijos().get(1).getValue()));                                    
                                    break;
                                case "cadena":
                                    caja.setCadena(quitarComillas(aux.getHijos().get(1).getValue()));                                    
                                    caja.setText(quitarComillas(caja.getCadena()));
                                    //texto.setAlto(texto.cadena.length());
                                    break; 
                                case "ancho":     
                                    String ancho = aux.getHijos().get(1).getValue().substring(1,aux.getHijos().get(1).getValue().length()-1);
                                    System.out.println("ANCHO ---- "+ancho);
                                    if (esNumero(ancho))
                                    {
                                        caja.setAncho(Integer.valueOf(ancho));
                                        caja.setAncho(caja.getAncho());
                                    }                                       
                                    break;
                                case "alto": 
                                    String alto = aux.getHijos().get(1).getValue().substring(1,aux.getHijos().get(1).getValue().length()-1);
                                    System.out.println("ALTO ---- "+alto);
                                    if (esNumero(alto))
                                    {
                                        caja.setAlto(Integer.valueOf(alto));
                                        caja.setAlto(caja.getAlto());
                                    }                                                                                                                                   
                                    break; 
                                case "alineado":                                                                        
                                    switch(aux.getHijos().get(1).getValue())
                                    {
                                        case "\"izquierda\"":
                                            caja.setAlineado("izquierda");
                                            caja.setAlignmentX(LEFT_ALIGNMENT);
                                            break;
                                        case "\"derecha\"":
                                            caja.setAlineado("derecha");
                                            caja.setAlignmentX(RIGHT_ALIGNMENT);
                                            break;  
                                        case "\"centrado\"":
                                            caja.setAlineado("centrado");
                                            caja.setAlignmentX(CENTER_ALIGNMENT);
                                            break;   
                                        default :
                                            filasErrores.addRow(new String[]{"CHTML",String.valueOf(aux.getHijos().get(1).getLinea()),String.valueOf(aux.getHijos().get(1).getColumna()),
                                                "Sintactico","Valor de alineacion incorrecto"});
                                            break;                                          
                                    }
                                    System.out.println("------------ALINEACION: \t"+caja.getAlineado());
                                    break;                                     
                            }
                        }
                    }   
                    caja.setBorder(BorderFactory.createLineBorder(Color.black));
                    elemento = new Elemento(caja.getId(),"caja",caja);    
                    panel.getElementos().add(elemento);
                    break;  

/*----------------------------IMAGEN--------------------------------------*/                    
                case "IMAGEN":
                    System.out.println("---------------------------IMAGEN---------------------");
                    Imagen imagen = new Imagen();
                    imagen.setBackground(colorFondo);
                    for(nodoChtml aux: raiz.getHijos())
                    {                        
                        if(aux.getValue().equals("ELEMENTO"))
                        {
                            switch(aux.getHijos().get(0).getValue().toLowerCase())
                            {                                                                 
                                case "id":
                                    imagen.setId(quitarComillas(aux.getHijos().get(1).getValue()));
                                    break;
                                case "grupo":
                                    imagen.setGrupo(quitarComillas(aux.getHijos().get(1).getValue()));                                    
                                    break;
                                case "cadena":
                                    imagen.setCadena(quitarComillas(aux.getHijos().get(1).getValue()));                                    
                                    imagen.setText(imagen.getCadena());                                    
                                    break; 
                                case "ancho":                                                                        
                                    String numero = aux.getHijos().get(1).getValue();
                                    numero = numero.substring(1,numero.length()-1);
                                    if (esNumero(numero))
                                    {
                                        imagen.setAncho(Integer.valueOf(numero));
                                    } 
                                    break;
                                case "alto":            
                                    numero = aux.getHijos().get(1).getValue();
                                    numero = numero.substring(1,numero.length()-1);
                                    if (esNumero(numero))
                                    {
                                        imagen.setAlto(Integer.valueOf(numero));
                                    }     
                                    break; 
                                case "alineado":                                                                        
                                    switch(aux.getHijos().get(1).getValue())
                                    {
                                        case "\"izquierda\"":
                                            imagen.setAlineado("izquierda");
                                            imagen.setAlignmentX(LEFT_ALIGNMENT);
                                            break;
                                        case "\"derecha\"":
                                            imagen.setAlineado("derecha");
                                            imagen.setAlignmentX(RIGHT_ALIGNMENT);
                                            break;  
                                        case "\"centrado\"":
                                            imagen.setAlineado("centrado");
                                            imagen.setAlignmentX(CENTER_ALIGNMENT);
                                            break;   
                                        default :
                                            filasErrores.addRow(new String[]{"CHTML",String.valueOf(aux.getHijos().get(1).getLinea()),String.valueOf(aux.getHijos().get(1).getColumna()),
                                                "Sintactico","Valor de alineacion incorrecto"});
                                            break;                                          
                                    }
                                    break;  
                                case "click":                                                                       
                                    imagen.setMetodo(aux.getHijos().get(1).getValue());
                                    break; 
                                case "ruta":                                                                       
                                    imagen.setRuta(aux.getHijos().get(1).getValue());
                                    break;                                    
                            }
                        }
                    }                    
                    elemento = new Elemento(imagen.getId(),"imagen",imagen);    
                    panel.getElementos().add(elemento);
                    break;                        
                    
                  
/*------------------------CAJA DE OPCIONES-----------------------*/                    
                case "CAJAOPCIONES":
                    System.out.println("---------------------------IMAGEN---------------------");
                    CajaOpciones cajaOpciones = new CajaOpciones();
                    cajaOpciones.setBounds(posX, posY, 100, 20);
                    int contadorOpciones = 0;
                    for(nodoChtml aux: raiz.getHijos())
                    {       
                        System.out.println(aux.getValue());
                        switch(aux.getValue().toLowerCase())
                        {                                      
                            /*------------OPCIONES----------*/  
                            case "elemento":
                                switch(aux.getHijos().get(0).getValue().toLowerCase())
                                {                                                                 
                                    case "id":
                                        cajaOpciones.setId(quitarComillas(aux.getHijos().get(1).getValue()));
                                        break;
                                    case "grupo":
                                        cajaOpciones.setGrupo(quitarComillas(aux.getHijos().get(1).getValue()));                                    
                                        break;
                                    case "cadena":
                                        cajaOpciones.setCadena(quitarComillas(aux.getHijos().get(1).getValue()));                                    
                                        //cajaOpciones.setText(imagen.getCadena());                                    
                                        break; 
                                    case "ancho":                                                                        
                                        String numero = aux.getHijos().get(1).getValue();
                                        numero = numero.substring(1,numero.length()-1);
                                        if (esNumero(numero))
                                        {
                                            cajaOpciones.setAncho(Integer.valueOf(numero));
                                        } 
                                        break;
                                    case "alto":            
                                        numero = aux.getHijos().get(1).getValue();
                                        numero = numero.substring(1,numero.length()-1);
                                        if (esNumero(numero))
                                        {
                                            cajaOpciones.setAlto(Integer.valueOf(numero));
                                        }     
                                        break; 
                                    case "alineado":                                                                        
                                        switch(aux.getHijos().get(1).getValue())
                                        {
                                            case "\"izquierda\"":
                                                cajaOpciones.setAlineado("izquierda");
                                                cajaOpciones.setAlignmentX(LEFT_ALIGNMENT);
                                                break;
                                            case "\"derecha\"":
                                                cajaOpciones.setAlineado("derecha");
                                                cajaOpciones.setAlignmentX(RIGHT_ALIGNMENT);
                                                break;  
                                            case "\"centrado\"":
                                                cajaOpciones.setAlineado("centrado");
                                                cajaOpciones.setAlignmentX(CENTER_ALIGNMENT);
                                                break;   
                                            default :
                                                filasErrores.addRow(new String[]{"CHTML",String.valueOf(aux.getHijos().get(1).getLinea()),String.valueOf(aux.getHijos().get(1).getColumna()),
                                                    "Sintactico","Valor de alineacion incorrecto"});
                                                break;                                          
                                        }
                                        break;  
                                    case "click":                                                                       
                                        cajaOpciones.setMetodo(aux.getHijos().get(1).getValue());
                                        break; 
                                    case "ruta":                                                                       
                                        cajaOpciones.setRuta(aux.getHijos().get(1).getValue());
                                        break;                                    
                                }

                                break;
                            case "opcion":
                                
                                String valor = "";                                
                                Opcion op = new Opcion();
                                String item = "";
                                for(nodoChtml opcion: aux.getHijos())
                                {     
                                    if(opcion.getValue().equals("ELEMENTO"))
                                    {
                                        nodoChtml izquierda = opcion.getHijos().get(0);
                                        nodoChtml derecha = opcion.getHijos().get(1);
                                        //System.out.println(izquierda.getValue().toLowerCase()+"***********************************************"+derecha.getValue());
                                        switch(izquierda.getValue().toLowerCase())
                                        {
                                            case "valor":                                                                                                                           
                                                item = quitarComillas(derecha.getValue());
                                                
                                                break; 
                                            case "cadena":
                                                if(item.equals(""))
                                                {
                                                    item = quitarComillas(derecha.getValue());                                               
                                                }
                                                    
                                                break;
                                            case "click":                                                                       
                                                    valor = quitarComillas(derecha.getValue());
                                                    op.setMetodo(valor);
                                                break;
                                            case "grupo":                                                                       
                                                    valor = quitarComillas(derecha.getValue());
                                                    op.setGrupo(valor);
                                                break;       
                                            case "id":                                                                       
                                                if(valor.equals(""))
                                                {
                                                    valor = quitarComillas(derecha.getValue());
                                                    op.setId(valor);
                                                }
                                                break;                                                   
                                                
                                        }                                                        
                                    }
                                }
                                op.setCadena(item);
                                cajaOpciones.addItem(item);                                
                                cajaOpciones.addOpcion(op);  
                                addOpcion(op);
                                break;                                                                                                    
                        }
                        contadorOpciones++;
                    }                    
                    //elemento = new Elemento(cajaOpciones.getId(),"cajaOpciones",cajaOpciones);    
                    elemento = new Elemento("cajaOpciones","cajaOpciones",cajaOpciones);    
                    panel.getElementos().add(elemento);
                    break;                        
                  
                    
                case "PANEL":
                    System.out.println("---------------------------PANEL---------------------");
                    Panel panelNuevo = new Panel();
                    prepararPanel(panelNuevo);
                    for(nodoChtml hijoAuxiliar: raiz.getHijos())
                    {
                        generarObjetos(hijoAuxiliar, panelNuevo);                                  
                    }                              
                    anchoActual = scroll.getWidth();
                    elemento = new Elemento("panel","panel",panelNuevo); 
                    panel.getElementos().add(elemento);
                    break;                    
                    
                case "TABLA":
                    System.out.println("---------------------------TABLA---------------------");
                    Tab tabla = generarTabla(raiz);
                    elemento = new Elemento(tabla.getId(),"tabla",tabla);
                    panel.getElementos().add(elemento);
                    break;                                                            
            }
        }        
    
    }
   
   public Tab generarTabla(nodoChtml raiz)
   {
       Tab tabla = new Tab();
       DefaultTableModel dataTablaFila = new DefaultTableModel();
       ArrayList<Elemento> listaCeldas = new ArrayList();
       for(nodoChtml aux: raiz.getHijos())
       {           
           switch(aux.getValue())
           {
                case "ELEMENTO":                    
                    switch(aux.getHijos().get(0).getValue().toLowerCase())
                    {                                                                 
                        case "id":
                            tabla.setId(quitarComillas(aux.getHijos().get(1).getValue()));
                            break;
                        case "grupo":
                            tabla.setGrupo(quitarComillas(aux.getHijos().get(1).getValue()));                                    
                            break;
                        case "cadena":
                            tabla.setCadena(quitarComillas(aux.getHijos().get(1).getValue()));                                                                                               
                            break; 
                        case "ancho":                                                                        
                            String numero = aux.getHijos().get(1).getValue();
                            numero = numero.substring(1,numero.length()-1);
                            if (esNumero(numero))
                            {
                                tabla.setAncho(Integer.valueOf(numero));
                            } 
                            break;
                        case "alto":            
                            numero = aux.getHijos().get(1).getValue();
                            numero = numero.substring(1,numero.length()-1);
                            if (esNumero(numero))
                            {
                                tabla.setAlto(Integer.valueOf(numero));
                            }     
                            break; 
                        case "alineado":                                                                        
                            switch(aux.getHijos().get(1).getValue())
                            {
                                case "\"izquierda\"":
                                    tabla.setAlineado("izquierda");
                                    tabla.setAlignmentX(LEFT_ALIGNMENT);
                                    break;
                                case "\"derecha\"":
                                    tabla.setAlineado("derecha");
                                    tabla.setAlignmentX(RIGHT_ALIGNMENT);
                                    break;  
                                case "\"centrado\"":
                                    tabla.setAlineado("centrado");
                                    tabla.setAlignmentX(CENTER_ALIGNMENT);
                                    break;   
                                default :
                                    filasErrores.addRow(new String[]{"CHTML",String.valueOf(aux.getHijos().get(1).getLinea()),String.valueOf(aux.getHijos().get(1).getColumna()),
                                        "Sintactico","Valor de alineacion incorrecto"});
                                    break;                                          
                            }
                            break;  
                        case "click":                                                                       
                            tabla.setMetodo(aux.getHijos().get(1).getValue());
                            break; 
                        case "ruta":                                                                       
                            tabla.setRuta(aux.getHijos().get(1).getValue());
                            break;                                    
                    }
                break;
                case "FILA":                    
                    for(nodoChtml fila: aux.getHijos())
                    {                                                
                        for(nodoChtml elemento :  fila.getHijos())
                        {
                            switch(elemento.getValue())
                            {
                                case "ELEMENTO":
                                        nodoChtml valorI = elemento.getHijos().get(0);
                                        nodoChtml valorD = elemento.getHijos().get(1);
                                        switch(valorI.getValue().toLowerCase())
                                        {
                                            case "id":
                                                tabla.setId(quitarComillas(valorD.getValue()));
                                                break;
                                            case "grupo":
                                                tabla.setGrupo(quitarComillas(valorD.getValue()));                                    
                                                break;
                                            case "cadena":
                                                Texto nuevoTexto = new Texto();
                                                nuevoTexto.setText(quitarComillas(valorD.getValue()));
                                                nuevoTexto.setCadena(quitarComillas(valorD.getValue()));
                                                Elemento nuevoElemento = new Elemento();
                                                nuevoElemento.setTipo("texto");
                                                nuevoElemento.setValor(nuevoTexto);                                                        
                                                if(nuevoTexto.getText().length()!=0){listaCeldas.add(nuevoElemento);}                                                
                                                break; 
                                            case "ancho":                                                                        
                                                String numero = valorD.getValue();
                                                numero = numero.substring(1,numero.length()-1);
                                                if (esNumero(numero))
                                                {
                                                    tabla.setAncho(Integer.valueOf(numero));
                                                } 
                                                break;
                                            case "alto":            
                                                numero = valorD.getValue();
                                                numero = numero.substring(1,numero.length()-1);
                                                if (esNumero(numero))
                                                {
                                                    tabla.setAlto(Integer.valueOf(numero));
                                                }     
                                                break; 
                                            case "alineado":                                                                        
                                                switch(valorD.getValue())
                                                {
                                                    case "\"izquierda\"":
                                                        tabla.setAlineado("izquierda");
                                                        tabla.setAlignmentX(LEFT_ALIGNMENT);
                                                        break;
                                                    case "\"derecha\"":
                                                        tabla.setAlineado("derecha");
                                                        tabla.setAlignmentX(RIGHT_ALIGNMENT);
                                                        break;  
                                                    case "\"centrado\"":
                                                        tabla.setAlineado("centrado");
                                                        tabla.setAlignmentX(CENTER_ALIGNMENT);
                                                        break;   
                                                    default :
                                                        filasErrores.addRow(new String[]{"CHTML",String.valueOf(valorD.getLinea()),String.valueOf(valorD.getColumna()),
                                                            "Sintactico","Valor de alineacion incorrecto"});
                                                        break;                                          
                                                }
                                                break;  
                                            case "click":                                                                       
                                                tabla.setMetodo(valorD.getValue());
                                                break; 
                                            case "ruta":                                                                       
                                                tabla.setRuta(valorD.getValue());
                                                break;                                                                                                 
                                        }
                                        break;
                            /*-----------------------------------------/ELEMENTOS------------------------------------------*/                                                
                            /*-----------------------------------------BOTON------------------------------------------*/
                            case "BOTON":
                                System.out.println("---------------------------BOTON---------------------");                    
                                Boton boton = new Boton();                    
                                for(nodoChtml nodoBoton: elemento.getHijos())
                                {                        
                                    if(nodoBoton.getValue().equals("ELEMENTO"))
                                    {
                                        valorI = nodoBoton.getHijos().get(0);
                                        valorI.setValue(quitarComillas(valorI.getValue()));
                                        valorD = nodoBoton.getHijos().get(1);
                                        valorD.setValue(quitarComillas(valorD.getValue()));
                                        switch(valorI.getValue().toLowerCase())
                                        {
                                            case "ruta":
                                                boton.setRuta(valorD.getValue());                                    
                                                break;
                                            case "click":                                                                       
                                                boton.setMetodo(valorD.getValue());
                                                break;                                     
                                            case "id":
                                                boton.setId(valorD.getValue());                                    
                                                break;
                                            case "grupo":
                                                boton.setGrupo(valorD.getValue());                                    
                                                break;
                                            case "cadena":
                                                boton.setCadena(valorD.getValue());                                    
                                                boton.setText(boton.getCadena());
                                                break; 
                                            case "ancho":          
                                                String numero = valorD.getValue().substring(1,valorD.getValue().length()-1);
                                                if (esNumero(numero))
                                                {
                                                    boton.setAncho(Integer.valueOf(numero));
                                                }                                       
                                                break;
                                            case "alto":  
                                                numero = valorD.getValue().substring(1,valorD.getValue().length()-1);                                    
                                                if (esNumero(numero))
                                                {
                                                    boton.setAlto(Integer.valueOf(numero));
                                                }                                                                                                                                   
                                                break; 
                                            case "alineado":                                                                        
                                                switch(valorD.getValue())
                                                {
                                                    case "\"izquierda\"":
                                                        boton.setAlineado("izquierda");
                                                        boton.setAlignmentX(LEFT_ALIGNMENT);
                                                        break;
                                                    case "\"derecha\"":
                                                        boton.setAlineado("derecha");
                                                        boton.setAlignmentX(RIGHT_ALIGNMENT);
                                                        break;  
                                                    case "\"centrado\"":
                                                        boton.setAlineado("centrado");
                                                        boton.setAlignmentX(CENTER_ALIGNMENT);
                                                        break;   
                                                    default :
                                                        filasErrores.addRow(new String[]{"CHTML",String.valueOf(valorD.getLinea()),String.valueOf(valorD.getColumna()),
                                                            "Sintactico","Valor de alineacion incorrecto"});
                                                        break;                                          
                                                }
                                                break;                                     
                                        }
                                    }
                                } 
                                Elemento nuevoElemento = new Elemento();
                                nuevoElemento.setTipo("boton");
                                nuevoElemento.setValor(boton);
                                listaCeldas.add(nuevoElemento);
                                break;
                            /*-----------------------------------------/BOTON------------------------------------------*/
                            /*-----------------------------------------IMAGEN------------------------------------------*/                                        
                            case "IMAGEN":
                                System.out.println("---------------------------IMAGEN---------------------");
                                Imagen imagen = new Imagen();
                                imagen.setBackground(colorFondo);
                                for(nodoChtml nodoImagen: elemento.getHijos())
                                {                        
                                    if(nodoImagen.getValue().equals("ELEMENTO"))
                                    { 
                                        valorI = nodoImagen.getHijos().get(0);
                                        valorI.setValue(quitarComillas(valorI.getValue()));
                                        valorD = nodoImagen.getHijos().get(1);
                                        valorD.setValue(quitarComillas(valorD.getValue()));                                        
                                        switch(valorI.getValue().toLowerCase())
                                        {                                                                 
                                            case "id":
                                                imagen.setId(quitarComillas(valorD.getValue()));
                                                break;
                                            case "grupo":
                                                imagen.setGrupo(quitarComillas(valorD.getValue()));                                    
                                                break;
                                            case "cadena":
                                                imagen.setCadena(quitarComillas(valorD.getValue()));                                    
                                                imagen.setText(imagen.getCadena());                                    
                                                break; 
                                            case "ancho":                                                                        
                                                String numero = valorD.getValue();
                                                numero = numero.substring(1,numero.length()-1);
                                                if (esNumero(numero))
                                                {
                                                    imagen.setAncho(Integer.valueOf(numero));
                                                } 
                                                break;
                                            case "alto":            
                                                numero = valorD.getValue();
                                                numero = numero.substring(1,numero.length()-1);
                                                if (esNumero(numero))
                                                {
                                                    imagen.setAlto(Integer.valueOf(numero));
                                                }     
                                                break; 
                                            case "alineado":                                                                        
                                                switch(valorD.getValue())
                                                {
                                                    case "\"izquierda\"":
                                                        imagen.setAlineado("izquierda");
                                                        imagen.setAlignmentX(LEFT_ALIGNMENT);
                                                        break;
                                                    case "\"derecha\"":
                                                        imagen.setAlineado("derecha");
                                                        imagen.setAlignmentX(RIGHT_ALIGNMENT);
                                                        break;  
                                                    case "\"centrado\"":
                                                        imagen.setAlineado("centrado");
                                                        imagen.setAlignmentX(CENTER_ALIGNMENT);
                                                        break;   
                                                    default :
                                                        filasErrores.addRow(new String[]{"CHTML",String.valueOf(valorD.getLinea()),String.valueOf(valorD.getColumna()),
                                                            "Sintactico","Valor de alineacion incorrecto"});
                                                        break;                                          
                                                }
                                                break;  
                                            case "click":                                                                       
                                                imagen.setMetodo(valorD.getValue());
                                                break; 
                                            case "ruta":                                                                       
                                                imagen.setRuta(valorD.getValue());
                                                break;                                    
                                        }
                                    }
                                }                    
                                nuevoElemento = new Elemento(imagen.getId(),"imagen",imagen);    
                                listaCeldas.add(nuevoElemento);    
                                break;
                            /*-----------------------------------------/IMAGEN------------------------------------------*/                                         
                            }
                        }                                                                                                                                    
                    }
                    Elemento nuevoElemento = new Elemento ("nuevaLinea","nuevaLinea", new String(""));
                    listaCeldas.add(nuevoElemento);
                        /*Aquí agregamos la fila*/
                    /*    Object[] arrayFila = new Object[listaCeldas.size()];
                        dataTablaFila.setColumnCount(listaCeldas.size());
                        int contador= 0;
                        for(Elemento auxElemento: listaCeldas)
                        {
                            //elementos.add(auxElemento);
                            switch(auxElemento.getTipo())
                            {
                                
                                case "texto":
                                    Texto nuevoTexto = (Texto)auxElemento.getValor();
                                    nuevoTexto.setText(nuevoTexto.getCadena());
                                    nuevoTexto.setPreferredSize(new java.awt.Dimension(nuevoTexto.getText().length()*4,20));
                                    if(nuevoTexto.getAncho()!=0 && nuevoTexto.getAlto()!=0)
                                    {
                                        nuevoTexto.setPreferredSize(new java.awt.Dimension(nuevoTexto.getAncho(),nuevoTexto.getAlto()));
                                    }                                    
                                    arrayFila[contador] = nuevoTexto;                                    
                                    //tabla.add(nuevoTexto);
                                    break;
                                case "boton":
                                    Boton nuevoBoton = (Boton)auxElemento.getValor();
                                    nuevoBoton.setPreferredSize(new java.awt.Dimension(nuevoBoton.getAncho(),nuevoBoton.getAlto()));
                                    arrayFila[contador] = nuevoBoton;
                                    //tabla.add(nuevoBoton);
                                    break;  
                                case "imagen":                                  
                                    Imagen imagen =(Imagen)auxElemento.getValor();
                                    imagen.setBounds(posXAux, posYAux, imagen.getAncho(),imagen.getAlto());
                                    ImageIcon icono = new ImageIcon(); 
                                    if(imagen.getRuta()!=null )
                                    {
                                        if(!imagen.getRuta().equals(""))
                                        {
                                            icono =   new ImageIcon(imagen.getRuta().substring(1,imagen.getRuta().length()-1));
                                        }   
                                        if(!imagen.getRuta().substring(0,1).equals("\""))
                                        {
                                            icono = new ImageIcon(imagen.getRuta());
                                        }  
                                        ImageIcon iconoEscala = new ImageIcon(icono.getImage().getScaledInstance(imagen.getAncho(), imagen.getAlto(), java.awt.Image.SCALE_DEFAULT));                
                                        imagen.setIcon(iconoEscala);                     

                                    }                                                       
                                    imagen.setPreferredSize(new java.awt.Dimension(imagen.getAncho(),imagen.getAlto()));
                                    arrayFila[contador] = imagen;
                                    //tabla.add(imagen);
                                    break;                                                                           
                            }
                        }
                        dataTablaFila.addRow(arrayFila);                        
                        //dataTablaFila.addRow(new Object[] {"Nombre", "Apellido"});       
                    */
                    break;                           
           }
       }              
              
       tabla.setElementos(listaCeldas);
       return tabla;       
   }
   
   
   /*-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
   public Panel generarPanel(nodoChtml raiz)
   {             
       ArrayList<Elemento> elementosPanel = new ArrayList();
       Panel panelNuevo = new Panel();
        if(raiz!=null)
        {
          for(nodoChtml hijo : raiz.getHijos())
          {                                      
            switch(hijo.getValue())
            {               
                case "CONTENIDO":
                    for(nodoChtml nieto: hijo.getHijos())
                    {
                       switch(nieto.getValue())
                       {
                                    case "SALTO":                                   
                                    Elemento salto = new Elemento();
                                    salto.setNombre("salto");
                                    salto.setTipo("salto");
                                    elementosPanel.add(salto);
                                    break;                                                                                    
                                    case "ENLACE":
                                        System.out.println("---------------------------ENLACE---------------------");                    
                                        Enlace enlace = new Enlace();
                                        enlace.setBackground(colorFondo);
                                        for(nodoChtml aux: nieto.getHijos())
                                        {                        
                                            if(aux.getValue().equals("ELEMENTO"))
                                            {
                                                switch(aux.getHijos().get(0).getValue().toLowerCase())
                                                {
                                                    case "ruta":
                                                        enlace.setRuta(aux.getHijos().get(1).getValue());                                    
                                                        break;
                                                    case "id":
                                                        enlace.setId(aux.getHijos().get(1).getValue());                                    
                                                        break;
                                                    case "grupo":
                                                        enlace.setGrupo(aux.getHijos().get(1).getValue());                                    
                                                        break;
                                                    case "cadena":
                                                        enlace.setCadena(aux.getHijos().get(1).getValue());                                    
                                                        enlace.setText(enlace.getCadena());
                                                        break; 
                                                    case "ancho":                                                                        
                                                        if (esNumero(aux.getHijos().get(1).getValue()))
                                                        {
                                                            enlace.setAncho(Integer.valueOf(aux.getHijos().get(1).getValue()));
                                                        }                                       
                                                        break;
                                                    case "alto":                                                                        
                                                        if (esNumero(aux.getHijos().get(1).getValue()))
                                                        {
                                                            enlace.setAlto(Integer.valueOf(aux.getHijos().get(1).getValue()));
                                                        }                                                                                                                                   
                                                        break; 
                                                    case "alineado":                                                                        
                                                        switch(aux.getHijos().get(1).getValue())
                                                        {
                                                            case "\"izquierda\"":
                                                                enlace.setAlineado("izquierda");
                                                                enlace.setAlignmentX(LEFT_ALIGNMENT);
                                                                break;
                                                            case "\"derecha\"":
                                                                enlace.setAlineado("derecha");
                                                                enlace.setAlignmentX(RIGHT_ALIGNMENT);
                                                                break;  
                                                            case "\"centrado\"":
                                                                enlace.setAlineado("centrado");
                                                                enlace.setAlignmentX(CENTER_ALIGNMENT);
                                                                break;   
                                                            default :
                                                                filasErrores.addRow(new String[]{"CHTML",String.valueOf(aux.getHijos().get(1).getLinea()),String.valueOf(aux.getHijos().get(1).getColumna()),
                                                                    "Sintactico","Valor de alineacion incorrecto"});
                                                                break;                                          
                                                        }
                                                        System.out.println("------------ALINEACION: \t"+enlace.getAlineado());
                                                        break;                                     
                                                }
                                            }
                                        }
                                        /*

                                        */                    
                                        Elemento elemento = new Elemento(enlace.getId(),"enlace",enlace);
                                        elementosPanel.add(elemento);                                     
                                        break;

                                    case "BOTON":
                                        System.out.println("---------------------------BOTON---------------------");                    
                                        Boton boton = new Boton();                    
                                        for(nodoChtml aux: nieto.getHijos())
                                        {                        
                                            if(aux.getValue().equals("ELEMENTO"))
                                            {
                                                switch(aux.getHijos().get(0).getValue().toLowerCase())
                                                {
                                                    case "ruta":
                                                        boton.setRuta(aux.getHijos().get(1).getValue());                                    
                                                        break;
                                                    case "click":                                                                       
                                                        boton.setMetodo(aux.getHijos().get(1).getValue());
                                                        break;                                     
                                                    case "id":
                                                        boton.setId(aux.getHijos().get(1).getValue());                                    
                                                        break;
                                                    case "grupo":
                                                        boton.setGrupo(aux.getHijos().get(1).getValue());                                    
                                                        break;
                                                    case "cadena":
                                                        boton.setCadena(aux.getHijos().get(1).getValue());                                    
                                                        boton.setText(boton.getCadena());
                                                        break; 
                                                    case "ancho":          
                                                        String numero = aux.getHijos().get(1).getValue().substring(1,aux.getHijos().get(1).getValue().length()-1);
                                                        if (esNumero(numero))
                                                        {
                                                            boton.setAncho(Integer.valueOf(numero));
                                                        }                                       
                                                        break;
                                                    case "alto":  
                                                        numero = aux.getHijos().get(1).getValue().substring(1,aux.getHijos().get(1).getValue().length()-1);                                    
                                                        if (esNumero(numero))
                                                        {
                                                            boton.setAlto(Integer.valueOf(numero));
                                                        }                                                                                                                                   
                                                        break; 
                                                    case "alineado":                                                                        
                                                        switch(aux.getHijos().get(1).getValue())
                                                        {
                                                            case "\"izquierda\"":
                                                                boton.setAlineado("izquierda");
                                                                boton.setAlignmentX(LEFT_ALIGNMENT);
                                                                break;
                                                            case "\"derecha\"":
                                                                boton.setAlineado("derecha");
                                                                boton.setAlignmentX(RIGHT_ALIGNMENT);
                                                                break;  
                                                            case "\"centrado\"":
                                                                boton.setAlineado("centrado");
                                                                boton.setAlignmentX(CENTER_ALIGNMENT);
                                                                break;   
                                                            default :
                                                                filasErrores.addRow(new String[]{"CHTML",String.valueOf(aux.getHijos().get(1).getLinea()),String.valueOf(aux.getHijos().get(1).getColumna()),
                                                                    "Sintactico","Valor de alineacion incorrecto"});
                                                                break;                                          
                                                        }
                                                        break;                                     
                                                }
                                            }
                                        }      
                                        elemento = new Elemento(boton.getId(),"boton",boton);
                                        elementosPanel.add(elemento);                                     
                                        break;                    


                                    case "SPINNER":
                                        System.out.println("---------------------------SPINNER---------------------");                    
                                        Spinner spinner = new Spinner();
                                        for(nodoChtml aux: nieto.getHijos())
                                        {                        
                                            if(aux.getValue().equals("ELEMENTO"))
                                            {
                                                switch(aux.getHijos().get(0).getValue().toLowerCase())
                                                {
                                                    case "ruta":
                                                        spinner.setRuta(aux.getHijos().get(1).getValue());                                    
                                                        break;
                                                    case "click":                                                                       
                                                        spinner.setMetodo(aux.getHijos().get(1).getValue());
                                                        break;                                     
                                                    case "id":
                                                        spinner.setId(aux.getHijos().get(1).getValue());                                    
                                                        break;
                                                    case "grupo":
                                                        spinner.setGrupo(aux.getHijos().get(1).getValue());                                    
                                                        break;
                                                    case "entero":
                                                        spinner.setCadena(aux.getHijos().get(1).getValue());                                                                        
                                                        break; 
                                                    case "ancho":                                                                        
                                                        if (esNumero(aux.getHijos().get(1).getValue()))
                                                        {
                                                            spinner.setAncho(Integer.valueOf(aux.getHijos().get(1).getValue()));
                                                        }                                       
                                                        break;
                                                    case "alto":                                                                        
                                                        if (esNumero(aux.getHijos().get(1).getValue()))
                                                        {
                                                            spinner.setAlto(Integer.valueOf(aux.getHijos().get(1).getValue()));
                                                        }                                                                                                                                   
                                                        break; 
                                                    case "alineado":                                                                        
                                                        switch(aux.getHijos().get(1).getValue())
                                                        {
                                                            case "\"izquierda\"":
                                                                spinner.setAlineado("izquierda");
                                                                spinner.setAlignmentX(LEFT_ALIGNMENT);
                                                                break;
                                                            case "\"derecha\"":
                                                                spinner.setAlineado("derecha");
                                                                spinner.setAlignmentX(RIGHT_ALIGNMENT);
                                                                break;  
                                                            case "\"centrado\"":
                                                                spinner.setAlineado("centrado");
                                                                spinner.setAlignmentX(CENTER_ALIGNMENT);
                                                                break;   
                                                            default :
                                                                filasErrores.addRow(new String[]{"CHTML",String.valueOf(aux.getHijos().get(1).getLinea()),String.valueOf(aux.getHijos().get(1).getColumna()),
                                                                    "Sintactico","Valor de alineacion incorrecto"});
                                                                break;                                          
                                                        }
                                                        System.out.println("------------ALINEACION: \t"+spinner.getAlineado());
                                                        break;                                     
                                                }
                                            }
                                        }                   
                                        elemento = new Elemento(spinner.getId(),"spinner",spinner);
                                        elementosPanel.add(elemento);                                     
                                        break;                    

                                    case "TEXTO":
                                        System.out.println("---------------------------TEXTO---------------------");
                                        //Vemos todos los elementosPanel :v
                                        Texto texto = new Texto();
                                        //texto.setBackground(colorFondo);
                                        for(nodoChtml aux: nieto.getHijos())
                                        {                        
                                            if(aux.getValue().equals("ELEMENTO"))
                                            {
                                                switch(aux.getHijos().get(0).getValue().toLowerCase())
                                                {                                                                 
                                                    case "id":
                                                        texto.setName(aux.getHijos().get(1).getValue());
                                                        break;
                                                    case "grupo":
                                                        texto.setGrupo(aux.getHijos().get(1).getValue());                                    
                                                        break;
                                                    case "cadena":
                                                        texto.setCadena(aux.getHijos().get(1).getValue());                                    
                                                        texto.setText(texto.getCadena());
                                                        //texto.setAlto(texto.cadena.length());
                                                        break; 
                                                    case "ancho":                                                                        
                                                        String ancho = aux.getHijos().get(1).getValue().substring(1,aux.getHijos().get(1).getValue().length()-1);
                                                        System.out.println(aux.getHijos().get(1).getValue()+"  ANCHO ---- "+ancho);
                                                        if (esNumero(ancho))
                                                        {
                                                            System.out.println("--Valor válido--");
                                                            texto.setAncho(Integer.valueOf(ancho));
                                                        }                                       
                                                        break;
                                                    case "alto":                                                                        
                                                        String alto = aux.getHijos().get(1).getValue().substring(1,aux.getHijos().get(1).getValue().length()-1);
                                                        System.out.println(aux.getHijos().get(1).getValue()+"  ALTO ---- "+alto);
                                                        if (esNumero(alto))
                                                        {
                                                            System.out.println("--Valor válido--");
                                                            texto.setAlto(Integer.valueOf(alto));
                                                        }                                                                                                                                   
                                                        break; 
                                                    case "alineado":                                                                        
                                                        switch(aux.getHijos().get(1).getValue())
                                                        {
                                                            case "\"izquierda\"":
                                                                texto.setAlineado("izquierda");
                                                                texto.setAlignmentX(LEFT_ALIGNMENT);
                                                                break;
                                                            case "\"derecha\"":
                                                                texto.setAlineado("derecha");
                                                                texto.setAlignmentX(RIGHT_ALIGNMENT);
                                                                break;  
                                                            case "\"centrado\"":
                                                                texto.setAlineado("centrado");
                                                                texto.setAlignmentX(CENTER_ALIGNMENT);
                                                                break;   
                                                            default :
                                                                filasErrores.addRow(new String[]{"CHTML",String.valueOf(aux.getHijos().get(1).getLinea()),String.valueOf(aux.getHijos().get(1).getColumna()),
                                                                    "Sintactico","Valor de alineacion incorrecto"});
                                                                break;                                          
                                                        }
                                                        System.out.println("------------ALINEACION: \t"+texto.getAlineado());
                                                        break;                                     
                                                }
                                            }
                                        }                    
                                        elemento = new Elemento(texto.getId(),"texto",texto);    
                                        elementosPanel.add(elemento);
                                        break;  
                    /*Caja area de texto*/                   
                                    case "TEXTOA":
                                        System.out.println("---------------------------TEXTOA---------------------");
                                        //Vemos todos los elementosPanel :v
                                        areaTexto area = new areaTexto();
                                        area.setBackground(Color.white);
                                        for(nodoChtml aux: nieto.getHijos())
                                        {                        
                                            if(aux.getValue().equals("ELEMENTO"))
                                            {
                                                switch(aux.getHijos().get(0).getValue().toLowerCase())
                                                {                                                                 
                                                    case "id":
                                                        area.setName(aux.getHijos().get(1).getValue());
                                                        break;
                                                    case "grupo":
                                                        area.setGrupo(aux.getHijos().get(1).getValue());                                    
                                                        break;
                                                    case "cadena":
                                                        area.setCadena(aux.getHijos().get(1).getValue());                                    
                                                        area.setText(area.getCadena());
                                                        //texto.setAlto(texto.cadena.length());
                                                        break; 
                                                    case "ancho":     
                                                        String ancho = aux.getHijos().get(1).getValue().substring(1,aux.getHijos().get(1).getValue().length()-1);
                                                        System.out.println("ANCHO ---- "+ancho);
                                                        if (esNumero(ancho))
                                                        {
                                                            area.setAncho(Integer.valueOf(ancho));
                                                            area.setAncho(area.getAncho());
                                                            area.setSize(Integer.valueOf(ancho),area.getHeight());
                                                        }                                       
                                                        break;
                                                    case "alto": 
                                                        String alto = aux.getHijos().get(1).getValue().substring(1,aux.getHijos().get(1).getValue().length()-1);
                                                        System.out.println("ALTO ---- "+alto);
                                                        if (esNumero(alto))
                                                        {
                                                            area.setAlto(Integer.valueOf(alto));
                                                            area.setAlto(area.getAlto());
                                                            area.setSize(area.getWidth(), Integer.valueOf(alto));
                                                        }                                                                                                                                   
                                                        break; 
                                                    case "alineado":                                                                        
                                                        switch(aux.getHijos().get(1).getValue())
                                                        {
                                                            case "\"izquierda\"":
                                                                area.setAlineado("izquierda");
                                                                area.setAlignmentX(LEFT_ALIGNMENT);
                                                                break;
                                                            case "\"derecha\"":
                                                                area.setAlineado("derecha");
                                                                area.setAlignmentX(RIGHT_ALIGNMENT);
                                                                break;  
                                                            case "\"centrado\"":
                                                                area.setAlineado("centrado");
                                                                area.setAlignmentX(CENTER_ALIGNMENT);
                                                                break;   
                                                            default :
                                                                filasErrores.addRow(new String[]{"CHTML",String.valueOf(aux.getHijos().get(1).getLinea()),String.valueOf(aux.getHijos().get(1).getColumna()),
                                                                    "Sintactico","Valor de alineacion incorrecto"});
                                                                break;                                          
                                                        }
                                                        System.out.println("------------ALINEACION: \t"+area.getAlineado());
                                                        break;                                     
                                                }
                                            }
                                        }   
                                        area.setBorder(BorderFactory.createLineBorder(Color.black));
                                        elemento = new Elemento(area.getId(),"area",area);    
                                        elementosPanel.add(elemento);
                                        break;      

                    /*CAJA DE TEXTO SIN LINEAS*/  

                                    case "CAJATEXTO":
                                        System.out.println("---------------------------CAJATEXTO---------------------");
                                        //Vemos todos los elementosPanel :v
                                        Caja caja = new Caja();                    
                                        for(nodoChtml aux: nieto.getHijos())
                                        {                        
                                            if(aux.getValue().equals("ELEMENTO"))
                                            {
                                                switch(aux.getHijos().get(0).getValue().toLowerCase())
                                                {                                                                 
                                                    case "id":
                                                        caja.setName(aux.getHijos().get(1).getValue());
                                                        break;
                                                    case "grupo":
                                                        caja.setGrupo(aux.getHijos().get(1).getValue());                                    
                                                        break;
                                                    case "cadena":
                                                        caja.setCadena(aux.getHijos().get(1).getValue());                                    
                                                        caja.setText(caja.getCadena());
                                                        //texto.setAlto(texto.cadena.length());
                                                        break; 
                                                    case "ancho":     
                                                        String ancho = aux.getHijos().get(1).getValue().substring(1,aux.getHijos().get(1).getValue().length()-1);
                                                        System.out.println("ANCHO ---- "+ancho);
                                                        if (esNumero(ancho))
                                                        {
                                                            caja.setAncho(Integer.valueOf(ancho));
                                                            caja.setAncho(caja.getAncho());
                                                        }                                       
                                                        break;
                                                    case "alto": 
                                                        String alto = aux.getHijos().get(1).getValue().substring(1,aux.getHijos().get(1).getValue().length()-1);
                                                        System.out.println("ALTO ---- "+alto);
                                                        if (esNumero(alto))
                                                        {
                                                            caja.setAlto(Integer.valueOf(alto));
                                                            caja.setAlto(caja.getAlto());
                                                        }                                                                                                                                   
                                                        break; 
                                                    case "alineado":                                                                        
                                                        switch(aux.getHijos().get(1).getValue())
                                                        {
                                                            case "\"izquierda\"":
                                                                caja.setAlineado("izquierda");
                                                                caja.setAlignmentX(LEFT_ALIGNMENT);
                                                                break;
                                                            case "\"derecha\"":
                                                                caja.setAlineado("derecha");
                                                                caja.setAlignmentX(RIGHT_ALIGNMENT);
                                                                break;  
                                                            case "\"centrado\"":
                                                                caja.setAlineado("centrado");
                                                                caja.setAlignmentX(CENTER_ALIGNMENT);
                                                                break;   
                                                            default :
                                                                filasErrores.addRow(new String[]{"CHTML",String.valueOf(aux.getHijos().get(1).getLinea()),String.valueOf(aux.getHijos().get(1).getColumna()),
                                                                    "Sintactico","Valor de alineacion incorrecto"});
                                                                break;                                          
                                                        }
                                                        System.out.println("------------ALINEACION: \t"+caja.getAlineado());
                                                        break;                                     
                                                }
                                            }
                                        }   
                                        caja.setBorder(BorderFactory.createLineBorder(Color.black));
                                        elemento = new Elemento(caja.getId(),"caja",caja);    
                                        elementosPanel.add(elemento);
                                        break;  

                    /*----------------------------IMAGEN--------------------------------------*/                    
                                    case "IMAGEN":
                                        System.out.println("---------------------------IMAGEN---------------------");
                                        Imagen imagen = new Imagen();
                                        imagen.setBackground(colorFondo);
                                        for(nodoChtml aux: nieto.getHijos())
                                        {                        
                                            if(aux.getValue().equals("ELEMENTO"))
                                            {
                                                switch(aux.getHijos().get(0).getValue().toLowerCase())
                                                {                                                                 
                                                    case "id":
                                                        imagen.setName(quitarComillas(aux.getHijos().get(1).getValue()));
                                                        break;
                                                    case "grupo":
                                                        imagen.setGrupo(quitarComillas(aux.getHijos().get(1).getValue()));                                    
                                                        break;
                                                    case "cadena":
                                                        imagen.setCadena(quitarComillas(aux.getHijos().get(1).getValue()));                                    
                                                        imagen.setText(imagen.getCadena());                                    
                                                        break; 
                                                    case "ancho":                                                                        
                                                        String numero = aux.getHijos().get(1).getValue();
                                                        numero = numero.substring(1,numero.length()-1);
                                                        if (esNumero(numero))
                                                        {
                                                            imagen.setAncho(Integer.valueOf(numero));
                                                        } 
                                                        break;
                                                    case "alto":            
                                                        numero = aux.getHijos().get(1).getValue();
                                                        numero = numero.substring(1,numero.length()-1);
                                                        if (esNumero(numero))
                                                        {
                                                            imagen.setAlto(Integer.valueOf(numero));
                                                        }     
                                                        break; 
                                                    case "alineado":                                                                        
                                                        switch(aux.getHijos().get(1).getValue())
                                                        {
                                                            case "\"izquierda\"":
                                                                imagen.setAlineado("izquierda");
                                                                imagen.setAlignmentX(LEFT_ALIGNMENT);
                                                                break;
                                                            case "\"derecha\"":
                                                                imagen.setAlineado("derecha");
                                                                imagen.setAlignmentX(RIGHT_ALIGNMENT);
                                                                break;  
                                                            case "\"centrado\"":
                                                                imagen.setAlineado("centrado");
                                                                imagen.setAlignmentX(CENTER_ALIGNMENT);
                                                                break;   
                                                            default :
                                                                filasErrores.addRow(new String[]{"CHTML",String.valueOf(aux.getHijos().get(1).getLinea()),String.valueOf(aux.getHijos().get(1).getColumna()),
                                                                    "Sintactico","Valor de alineacion incorrecto"});
                                                                break;                                          
                                                        }
                                                        break;  
                                                    case "click":                                                                       
                                                        imagen.setMetodo(aux.getHijos().get(1).getValue());
                                                        break; 
                                                    case "ruta":                                                                       
                                                        imagen.setRuta(aux.getHijos().get(1).getValue());
                                                        break;                                    
                                                }
                                            }
                                        }                    
                                        elemento = new Elemento(imagen.getId(),"imagen",imagen);    
                                        elementosPanel.add(elemento);
                                        break;                        


                    /*------------------------CAJA DE OPCIONES-----------------------*/                    
                                    case "CAJAOPCIONES":
                                        System.out.println("---------------------------IMAGEN---------------------");
                                        JComboBox cajaOpciones = new JComboBox();
                                        cajaOpciones.setBounds(posX, posY, 100, 20);
                                        int contadorOpciones = 0;
                                        for(nodoChtml aux: nieto.getHijos())
                                        {       
                                            System.out.println(aux.getValue());
                                            switch(aux.getValue().toLowerCase())
                                            {                                      
                                                /*------------OPCIONES----------*/                                        
                                                case "opcion":

                                                    String valor = "";                                
                                                    for(nodoChtml opcion: aux.getHijos())
                                                    {     
                                                        if(opcion.getValue().equals("ELEMENTO"))
                                                        {
                                                            nodoChtml izquierda = opcion.getHijos().get(0);
                                                            nodoChtml derecha = opcion.getHijos().get(1);
                                                            System.out.println(izquierda.getValue().toLowerCase()+"***********************************************"+derecha.getValue());
                                                            switch(izquierda.getValue().toLowerCase())
                                                            {
                                                                case "valor":                                                                                                                           
                                                                    valor = quitarComillas(derecha.getValue());
                                                                    break; 
                                                                case "cadena":                                                                       
                                                                    if(valor.equals(""))
                                                                    {
                                                                        valor = quitarComillas(derecha.getValue());
                                                                    }
                                                                    break;                                                
                                                            }                                                        
                                                        }
                                                    }
                                                    cajaOpciones.addItem(valor);
                                                    break;                                                                                                    
                                            }
                                            contadorOpciones++;
                                        }                    
                                        //elemento = new Elemento(cajaOpciones.getId(),"cajaOpciones",cajaOpciones);    
                                        elemento = new Elemento("cajaOpciones","cajaOpciones",cajaOpciones);    
                                        elementosPanel.add(elemento);
                                        break;                        


                                    case "PANEL":
                                        System.out.println("---------------------------PANEL---------------------");
                                        Panel panelNuevo_ = generarPanel(nieto);
                                        elemento = new Elemento("panel","panel",panelNuevo_); 
                                        elementosPanel.add(elemento);
                                        break;                                    
                                    case "TABLA":
                                        System.out.println("---------------------------TABLA---------------------");
                                        Tab tabla = generarTabla(nieto);
                                        elemento = new Elemento(tabla.getId(),"tabla",tabla);
                                        elementosPanel.add(elemento);                                     
                                        break;                            

                                           }
                                    }
                                break;
                                
                            case "ELEMENTO":
                                    System.out.println("---------------ELEMENTOS DE OBJETO DE PANEL----------------------");
                                    nodoChtml hijoI = hijo.getHijos().get(0);
                                    nodoChtml hijoD = hijo.getHijos().get(1);
                                    System.out.println(hijoI.getValue() +"--->" + hijoD.getValue());
                                    switch(hijoI.getValue().toLowerCase())
                                    {                                                                 
                                        case "id":
                                            panelNuevo.setName(hijoD.getValue());
                                            break;
                                        case "grupo":
                                            panelNuevo.setGrupo(hijoD.getValue());                                    
                                            break;
                                        case "cadena":
                                            panelNuevo.setCadena(hijoD.getValue());                                                                    
                                            //texto.setAlto(texto.cadena.length());
                                            break; 
                                        case "ancho":     
                                            String ancho = hijoD.getValue().substring(1,hijoD.getValue().length()-1);                                
                                            if (esNumero(ancho))
                                            {
                                                panelNuevo.setAncho(Integer.valueOf(ancho));     
                                                panelNuevo.setSize(panelNuevo.getAncho(), panelNuevo.getHeight());
                                            }                                       
                                            break;
                                        case "alto": 
                                            String alto =  hijoD.getValue().substring(1,hijoD.getValue().length()-1);                                
                                            if (esNumero(alto))
                                            {
                                                panelNuevo.setAlto(Integer.valueOf(alto));
                                                panelNuevo.setSize(panelNuevo.getWidth(), panelNuevo.getAlto());
                                            }                                                                                                                                   
                                            break; 
                                        case "alineado":                                                                        
                                            switch(hijoD.getValue())
                                            {
                                                case "\"izquierda\"":
                                                    panelNuevo.setAlineado("izquierda");
                                                    panelNuevo.setAlignmentX(LEFT_ALIGNMENT);
                                                    break;
                                                case "\"derecha\"":
                                                    panelNuevo.setAlineado("derecha");
                                                    panelNuevo.setAlignmentX(RIGHT_ALIGNMENT);
                                                    break;  
                                                case "\"centrado\"":
                                                    panelNuevo.setAlineado("centrado");
                                                    panelNuevo.setAlignmentX(CENTER_ALIGNMENT);
                                                    break;   
                                                default :
                                                    filasErrores.addRow(new String[]{"CHTML",String.valueOf(hijoD.getLinea()),String.valueOf(hijoD.getColumna()),
                                                        "Sintactico","Valor de alineacion incorrecto"});
                                                    break;                                          
                                            }                                
                                            break;                                     
                        }                    
                break;                      
                }                         
            }
        }
        panelNuevo.setElementos(elementosPanel);
        //dibujarPanel(panelNuevo);
        return panelNuevo;
   }
   

    
public void dibujarPanel(Panel contenedor)
{    
    posXAux = posYAux = xMaxAux = yMaxAux = 0;
    ArrayList<Elemento> lista = contenedor.getElementos();
    for(Elemento aux: lista)
    {
        switch(aux.getTipo())
        {
            case "boton":
                Boton boton =(Boton)aux.getValor();                
                boton.setBounds(posXAux, posYAux, boton.getAncho(),boton.getAlto());                  
                posicionesPanel(boton.getAncho(), boton.getAlto(), contenedor);         
                contenedor.add(boton);
                break;
            case "enlace":
                Enlace enlace =(Enlace)aux.getValor();                
                enlace.setBounds(posXAux, posYAux, enlace.getAncho(),enlace.getAlto());                
                posicionesPanel(enlace.getAncho(), enlace.getAlto(), contenedor);        
                contenedor.add(enlace);
                break; 
            case "salto":
                System.out.println("Salto de línea dentro del panel");
                if(yMaxAux == 0)
                {
                    yMaxAux = 15;
                }
                JLabel label = new JLabel();
                label.setBackground(contenedor.getBackground());
                //label.setSize(yMaxAux, contenedor.getWidth()-xMaxAux-50);
                label.setSize(contenedor.getWidth()-xMaxAux-50,yMaxAux);
                for(int contador = 0 ; contador<contenedor.getWidth()-xMaxAux-50;contador++){label.setText(label.getText() + " ");}
                //label.setBorder(BorderFactory.createLineBorder(Color.BLUE));
                posicionesPanel(label.getWidth(), label.getHeight(), contenedor);  
                
                
                
                //contenedor.add(label);                
                break;                 
            case "spinner":
                Spinner spinner =(Spinner)aux.getValor();
                spinner.setBounds(posXAux, posYAux, spinner.getAncho(),spinner.getAlto());
                if(esNumero(spinner.getCadena()))
                {
                    spinner.setValue(Integer.valueOf(spinner.getCadena()));
                }                
                posicionesPanel(spinner.getAncho(), spinner.getAlto(), contenedor);                
                contenedor.add(spinner);
                break;                
            case "cajaOpciones":
                JComboBox opciones =(JComboBox)aux.getValor();
                opciones.setBounds(posXAux, posYAux, opciones.getWidth(), opciones.getHeight());                
                posicionesPanel(opciones.getWidth(), opciones.getHeight(), contenedor);                
                contenedor.add(opciones);
                break;                
            case "imagen":
                Imagen imagen =(Imagen)aux.getValor();
                imagen.setBounds(posXAux, posYAux, imagen.getAncho(),imagen.getAlto());
                ImageIcon icono = new ImageIcon(); 
                if(imagen.getRuta()!=null )
                {
                    if(!imagen.getRuta().equals(""))
                    {
                        icono =   new ImageIcon(imagen.getRuta().substring(1,imagen.getRuta().length()-1));
                    }   
                    if(!imagen.getRuta().substring(0,1).equals("\""))
                    {
                        icono = new ImageIcon(imagen.getRuta());
                    }  
                    ImageIcon iconoEscala = new ImageIcon(icono.getImage().getScaledInstance(imagen.getAncho(), imagen.getAlto(), java.awt.Image.SCALE_DEFAULT));                
                    imagen.setIcon(iconoEscala);                                         
                }                                                       
                posicionesPanel(imagen.getAncho(), imagen.getAlto(), contenedor);                
                contenedor.add(imagen);       
                break;                  
            case "texto":
                Texto texto =(Texto)aux.getValor();
                if(texto.getAlto()==0 && texto.getAncho()==0)
                {
                    
                    String[] auxiliar = texto.getCadena().split("\r");
                    int alto= auxiliar.length*20;
                    System.out.println("El texto no tiene dimensiones definidas");
                    System.out.println("\t"+texto.getCadena());
                    System.out.println("\tNo. líneas \t"+alto);
                    int ancho = 0;
                    for(String cad : auxiliar)
                    {
                        if(cad.length()>ancho){ancho=cad.length();}
                        System.out.println("\tNo. caracteres \t"+ancho);
                    }
                    texto.setText(texto.getText());   
                    texto.setAlto(alto);
                    texto.setAncho(ancho*7);                    
                }
                texto.setBounds(posXAux, posYAux, texto.getAncho(),texto.getAlto());
                posicionesPanel(texto.getAncho(), texto.getAlto(), contenedor);                
                contenedor.add(texto);                
                break;  
                
            case "caja":
                Caja caja =(Caja)aux.getValor();
                if(caja.getAlto()==0 && caja.getAncho()==0)
                {
                    String[] auxiliar = caja.getCadena().split("\r");
                    int alto = auxiliar.length;
                    int ancho = 0;
                    String valorCaja= "";
                    for(String cad : auxiliar)
                    {
                        valorCaja = valorCaja + cad;                        
                        ancho = ancho + cad.length();
                    }                    
                    caja.setText(valorCaja);   
                    caja.setAlto(20);
                    caja.setAncho(ancho*7);
                }
                caja.setBounds(posXAux, posYAux, caja.getAncho(),caja.getAlto());
                posicionesPanel(caja.getAncho(), caja.getAlto(), contenedor);                
                contenedor.add(caja);                
                break;                  
                
            case "area":
                areaTexto area =(areaTexto)aux.getValor();
                //area.setBounds(posX, posY, area.getAncho(),area.getAlto());                                
                JScrollPane nuevo = new JScrollPane(area);
                nuevo.setBounds(posXAux, posYAux, area.getWidth(),area.getHeight());
                posicionesPanel(area.getWidth(), area.getHeight(),contenedor); 
                contenedor.add(nuevo);                
                break;                 
                
            case "tabla":
                Tabla tabla =(Tabla)aux.getValor();
                tabla.setBounds(posXAux, posYAux, tabla.getAncho(),tabla.getAlto());                
                posicionesPanel(tabla.getAncho(), tabla.getAlto(), contenedor);       
                contenedor.add(tabla);
                break;     
                
            case "panel":
                Panel panel =(Panel)aux.getValor();
                //panel.setBackground(Color.black);
                if(panel.getWidth()==0){ panel.setSize(contenedor.getWidth(), panel.getHeight());}
                if(panel.getHeight()==0){panel.setSize(panel.getWidth(),100);}
                if(panel.getWidth()==0 && panel.getHeight() ==0){panel.setSize(contenedor.getWidth(),100);}                
                panel.setBorder(BorderFactory.createLineBorder(Color.black));
                panel.setSize(panel.getAncho(), panel.getAlto());
                panel.setBounds(posXAux, posYAux, panel.getAncho(),panel.getAlto());                
                posicionesPanel( panel.getAncho(),panel.getAlto(), contenedor);       
                contenedor.add(panel);
                break;                  
        }
    }
    this.repaint();
    
}  


public void posicionesPanel(int ancho, int alto, Panel contenedor)
{   
    int limite = contenedor.getAncho(); 
    if(alto>yMaxAux){yMaxAux = alto;}    
    if((posXAux + ancho)>= limite-ancho)        
    {
        posXAux = 0;
        posYAux = posYAux + yMaxAux;            
        yMaxAux= 0;              
    }
    else
    {
        posXAux = posXAux + ancho;
    }

}


public int[] posicionPanel(int ancho, int alto, Panel contenedor , int saltoY, int x, int y)
{   
    int valores[] = new int[5];
    int limite = contenedor.getAncho(); 
    if(alto>saltoY){saltoY = alto;}    
    if(limite>0)
    {
        if((x + ancho)>= limite-ancho)        
        {
            x = contenedor.getInicio();
            y = y + saltoY;            
            saltoY= 0;              
        }
        else
        {
            x = x + ancho;
        }        
    }
    else
    {
        x = x + ancho;            
    }
    
    valores[0]= x;
    valores[1]= y;
    valores[2]= saltoY;       
    return valores;

}


public void posicionTabla(int ancho, int alto, Tab contenedor , int saltoY, int x, int y, int xMax, int yMax)
{   
    int limite = contenedor.getAncho(); 
    if(alto>saltoY){saltoY = alto;}    
    if(limite>0)
    {
        if((x + ancho)>= limite-ancho)        
        {
            x = 0;
            y = y + saltoY;            
            saltoY= 0;              
        }
        else
        {
            x = x + ancho;
        }        
    }
    else
    {
        x = x + ancho;            
    }

}

public static void Mensaje(String mensaje, String titulo)
{
    JOptionPane.showMessageDialog(contenedorPaginas, mensaje, titulo, HEIGHT);
}
   
public void calcularTamaño(Panel contenedor)
{   
    if(contenedor.getAlto()==0 || contenedor.getAncho()==0)
    {
        int x = 0;
        int y = 0;
        int saltoY = 0;
        int saltoX = 0;
        int anchoMaximo = 0;
        int altoMaximo = 0;
        ArrayList<Elemento> elementosContenedor = contenedor.getElementos(); 
        Elemento finalAuxiliar = null;
        for(Elemento aux: elementosContenedor)
        {
            finalAuxiliar = aux;
            switch(aux.getTipo())
            {
                case "boton":
                    Boton boton =(Boton)aux.getValor();                
                    x+= boton.getAncho();
                    if(anchoMaximo<x){anchoMaximo=x;}
                    if(altoMaximo<boton.getAlto()){ altoMaximo = boton.getAlto();}
                    break;
                case "enlace":
                    Enlace enlace =(Enlace)aux.getValor();
                    //aplicarEstilo(aux, contenedor);                    
                    if(enlace.getAlto()==0 && enlace.getAncho()==0)
                    {
                        String[] auxiliar = enlace.getCadena().split("\r");
                        int alto= auxiliar.length;
                        System.out.println("El texto no tiene dimensiones definidas");
                        System.out.println("\t"+enlace.getCadena());
                        System.out.println("\tNo. líneas \t"+alto);
                        int ancho = 0;
                        for(String cad : auxiliar)
                        {
                            if(cad.length()>ancho){ancho=cad.length();}
                            System.out.println("\tNo. caracteres \t"+ancho);
                        }
                        enlace.setText(enlace.getText());   
                        enlace.setAlto(alto*25);
                        enlace.setAncho(ancho*alto*8);                  
                    }
                    aplicarEstiloGrupo(aux, contenedor);
                    aplicarEstiloId(aux, contenedor);
                    enlace.setAncho(enlace.getAncho()*enlace.getFont().getSize()/10);
                    enlace.setPreferredSize(new java.awt.Dimension(enlace.getAncho(),enlace.getAlto()));
                    enlace.setBounds(x, y, enlace.getAncho(),enlace.getAlto());                
                    x+= enlace.getAncho();
                    if(anchoMaximo<x){anchoMaximo=x;}
                    if(altoMaximo<enlace.getAlto()){ altoMaximo = enlace.getAlto();} 
                    break; 
                case "salto":
                    if(altoMaximo == 0)
                    {
                        altoMaximo = 10;
                    } 
                    y = y + altoMaximo;                
                    altoMaximo=0;
                    x=0;                
                    break;                 
                case "spinner":
                    Spinner spinner =(Spinner)aux.getValor();
                    x+= spinner.getAncho();                    
                    if(anchoMaximo<x){anchoMaximo=x;}
                    if(altoMaximo<spinner.getAlto()){ altoMaximo = spinner.getAlto();}                               
                    break;                
                case "cajaOpciones":
                    JComboBox opciones =(JComboBox)aux.getValor();
                    x+= opciones.getWidth();
                    if(anchoMaximo<x){anchoMaximo=x;}
                    if(altoMaximo<25){ altoMaximo = 25;}                                      
                    break;                
                case "imagen":
                    Imagen imagen =(Imagen)aux.getValor();
                    imagen.setBounds(x, y, imagen.getAncho(),imagen.getAlto());
                    ImageIcon icono = new ImageIcon(); 
                    if(imagen.getRuta()!=null )
                    {
                        if(!imagen.getRuta().equals(""))
                        {
                            icono =   new ImageIcon(imagen.getRuta().substring(1,imagen.getRuta().length()-1));
                        }
                        if(imagen.getRuta().length()>2)
                        {
                            if(!imagen.getRuta().substring(0,1).equals("\""))
                            {
                                icono = new ImageIcon(imagen.getRuta());
                            }
                        }  
                        ImageIcon iconoEscala = new ImageIcon(icono.getImage().getScaledInstance(imagen.getAncho(), imagen.getAlto(), java.awt.Image.SCALE_DEFAULT));                
                        imagen.setIcon(iconoEscala);                     

                    }                                   
                    x+= imagen.getAncho();
                    if(anchoMaximo<x){anchoMaximo=x;}
                    if(altoMaximo<imagen.getAlto()){ altoMaximo = imagen.getAlto();}    
                    break;                  
                case "texto":
                    Texto texto =(Texto)aux.getValor();
                    if(texto.getAlto()==0 && texto.getAncho()==0)
                    {                        
                        String[] auxiliar = texto.getCadena().split("\t");
                        int alto= auxiliar.length;
                        System.out.println("El texto no tiene dimensiones definidas");
                        System.out.println("\t"+texto.getCadena());
                        System.out.println("\tNo. líneas \t"+alto);
                        int ancho = 0;
                        for(String cad : auxiliar)
                        {
                            if(cad.length()>ancho){ancho=cad.length();}
                            System.out.println("\tNo. caracteres \t"+ancho);
                        }
                        texto.setText(texto.getText());   
                        texto.setAlto(alto*25);
                        texto.setAncho(ancho*8);                    
                    }
                    aplicarEstiloGrupo(aux, contenedor);
                    aplicarEstiloId(aux, contenedor);
                    texto.setAncho(texto.getAncho()*texto.getFont().getSize()/10);
                    //texto.setAlto(texto.getAlto()*texto.getFont().getSize()/10);
                    texto.setPreferredSize(new java.awt.Dimension(texto.getAncho(),texto.getAlto()));
                    texto.setBounds(x, y, texto.getAncho(),texto.getAlto());                
                    x+= texto.getAncho();
                    if(anchoMaximo<x){anchoMaximo=x;}
                    if(altoMaximo<=texto.getAlto()){ altoMaximo = texto.getAlto();}     
                    break;
                case "caja":
                    Caja caja =(Caja)aux.getValor();
                    if(caja.getAlto()==0 && caja.getAncho()==0)
                    {
                        String[] auxiliar = caja.getCadena().split("\r");
                        int alto = auxiliar.length;
                        int ancho = 0;
                        String valorCaja= "";
                        for(String cad : auxiliar)
                        {
                            valorCaja = valorCaja + cad;                        
                            ancho = ancho + cad.length();
                        }                    
                        caja.setText(valorCaja);   
                        caja.setAlto(20*alto);
                        caja.setAncho(ancho*7);
                    }
                    x+= caja.getAncho();
                    if(anchoMaximo<x){anchoMaximo=x;}
                    if(altoMaximo<caja.getAlto()){ altoMaximo = caja.getAlto();}               
                    break;                  

                case "area":
                    areaTexto area =(areaTexto)aux.getValor();
                    x+= area.getAncho();
                    if(anchoMaximo<x){anchoMaximo=x;}
                    if(altoMaximo<area.getAlto()){ altoMaximo = area.getAlto();}                  
                    break;                 

                case "tabla":
                    Tab tabla =(Tab)aux.getValor();                               
                    x+= tabla.getAncho();
                    if(anchoMaximo<x){anchoMaximo=x;}
                    if(altoMaximo<tabla.getAlto()){ altoMaximo = tabla.getAlto();} 
                    break;     

                case "panel":
                    Panel panel =(Panel)aux.getValor();                
                    contenedor.setFlagPanel(true);
                    Interfaz(panel);                                  
                    x+= panel.getAncho();
                    y+= panel.getAlto();
                    if(anchoMaximo<x){anchoMaximo=x;}
                    if(altoMaximo<panel.getAlto()){ altoMaximo = panel.getAlto();} 
                    break;                  
            }        
        }   

        
        if(altoMaximo!=0)
        {
            contenedor.setAncho(anchoMaximo+50);
            contenedor.setAlto(y+altoMaximo+50);            
        }
        else
        {
            contenedor.setAncho(anchoMaximo+50);
            contenedor.setAlto(y+50);             
        }                
    }
    else
    {
        for(Elemento elemento : contenedor.getElementos())
        {
            if(elemento.getTipo().equals("panel"))
            {
                contenedor.setFlagPanel(true);
                break;
            }
        }
    }        
}

public void Interfaz(Panel contenedor) // Este metodo genera un panel con todos los elementos.
{               
    int val[] = new int[3];
    int x = 10;
    int y = 5;
    int saltoY = 0;
    int saltoX = 0;
    int anchoMaximo = 0;
    int altoMaximo = 0;
    ArrayList<Elemento> elementosContenedor = contenedor.getElementos();            
    /*Verificamos el tipo de alineacion
    Por defecto es izquierda
    */
    if(contenedor.getAncho()!=0)
    {
        Panel auxiliar = new Panel();
        auxiliar.setElementos(contenedor.getElementos());
        calcularTamaño(auxiliar);
        if(!contenedor.getAlineado().equals(""))
        {
            if(quitarComillas(contenedor.getAlineado()).toLowerCase().equals("izquierda"))
            {
                x = 10;
            }                
            if(quitarComillas(contenedor.getAlineado()).toLowerCase().equals("derecha"))
            {
                x = contenedor.getAncho() - auxiliar.getAncho()-50;
            }
            if(quitarComillas(contenedor.getAlineado()).toLowerCase().equals("centrado"))
            {        
                x = (contenedor.getAncho() - auxiliar.getAncho()-50)/2;
            }            
        }
        contenedor.setInicio(x);            
    }      
    
    calcularTamaño(contenedor);
    //contenedor.setLayout(null);
    //contenedor.setLayout(null);/*Verificar*/
    if(!contenedor.isFlagPanel())
    {
        contenedor.setLayout(null);
    }           
    else
    {
        //contenedor.setAncho(contenedor.getAncho()/2);
        contenedor.setAlto(contenedor.getAlto()/2);    
    }
    for(Elemento aux: elementosContenedor)
    {
        switch(aux.getTipo())
        {
            case "boton":
                Boton boton =(Boton)aux.getValor();                
                boton.setPreferredSize(new java.awt.Dimension(boton.getAncho(),boton.getAlto()));                  
                boton.setBounds(x, y, boton.getAncho(),boton.getAlto()); 
                boton.removeMouseListener(mouseListenerBoton);
                boton.addMouseListener(mouseListenerBoton);     
                //System.out.println("Objeto insertado "+aux.getTipo()+" \tx: " +x + "\ty: "+ y);}
                aplicarEstiloGrupo(aux, contenedor);
                aplicarEstiloId(aux, contenedor);
                //aplicarObservador(aux);
                contenedor.add(boton);          
                val = posicionPanel(boton.getAncho(), boton.getAlto(),  contenedor, saltoY, x, y); 
                x  = val[0];
                y  = val[1];
                saltoY = val[2];                
                break;
            case "enlace":
                Enlace enlace =(Enlace)aux.getValor();
                enlace.setOpaque(false);
                enlace.removeMouseListener(listenerEnlace);
                enlace.addMouseListener(listenerEnlace);                
                if(enlace.getAlto()==0 && enlace.getAncho()==0)
                {
                    
                    String[] auxiliar = enlace.getCadena().split("\r");
                    int alto= auxiliar.length;
                    System.out.println("El texto no tiene dimensiones definidas");
                    System.out.println("\t"+enlace.getCadena());
                    System.out.println("\tNo. líneas \t"+alto);
                    int ancho = 0;
                    for(String cad : auxiliar)
                    {
                        if(cad.length()>ancho){ancho=cad.length();}
                        System.out.println("\tNo. caracteres \t"+ancho);
                    }
                    enlace.setText(enlace.getText());   
                    enlace.setAlto(alto*20);
                    enlace.setAncho(ancho*8);                    
                }                     
                aplicarEstiloGrupo(aux, contenedor);
                aplicarEstiloId(aux, contenedor);
                //enlace.setAncho(enlace.getAncho()*enlace.getFont().getSize()/11);
                enlace.setPreferredSize(new java.awt.Dimension(enlace.getAncho(),enlace.getAlto()));
                enlace.setBounds(x, y, enlace.getAncho(),enlace.getAlto());                 
                contenedor.add(enlace);
                //System.out.println("Objeto insertado "+aux.getTipo()+" x: " +x + "\ty: "+ y);
                val = posicionPanel(enlace.getAncho(), enlace.getAlto(),  contenedor, saltoY, x, y); 
                x  = val[0];
                y  = val[1];
                saltoY = val[2];                
                break; 
            case "salto":                
                if(saltoY == 0)
                {
                    saltoY = 5;
                }                
                //y = y + saltoY;
                Texto espacio = new Texto();
                //espacio.setBackground(Color.black);
                //espacio.setBackground(contenedor.getBackground());
                espacio.setBackground(Color.PINK);
                espacio.setEnabled(false);
                espacio.setAncho(contenedor.getAncho()-x-30);                
                espacio.setAlto(saltoY);
                //contenedor.setAlto(contenedor.getAlto()+ saltoY);
                
                for(int cont=0; cont<espacio.getAncho();cont++){espacio.setText(espacio.getText() +" ");}                
                if(contenedor.isFlagPanel())
                {
                    espacio.setPreferredSize(new java.awt.Dimension(espacio.getAncho(),espacio.getAlto() ));
                    espacio.setOpaque(false);
                    contenedor.add(espacio); 
                    contenedor.setAlto(contenedor.getAlto()+espacio.getAlto());
                    contenedor.setPreferredSize(new java.awt.Dimension(contenedor.getAncho(), contenedor.getAlto()+espacio.getAlto() ));
                }                
                val = posicionPanel(espacio.getAncho(), espacio.getAlto(),  contenedor, saltoY, x, y);                 
                x  = val[0];
                y  = val[1];
                saltoY = val[2];                 
                break;                 
            case "spinner":
                Spinner spinner =(Spinner)aux.getValor();
                spinner.setBounds(x, y, spinner.getAncho(),spinner.getAlto());
                if(esNumero(spinner.getCadena()))
                {
                    spinner.setValue(Integer.valueOf(spinner.getCadena()));
                }    
                spinner.setPreferredSize(new java.awt.Dimension(spinner.getAncho(),spinner.getAlto())); 
                aplicarEstiloGrupo(aux, contenedor);
                aplicarEstiloId(aux, contenedor);
                contenedor.add(spinner);
                //System.out.println("Objeto insertado\t"+aux.getTipo()+" \tx: " +x + "\ty: "+ y);
                val = posicionPanel(spinner.getAncho(), spinner.getAlto(),  contenedor, saltoY, x, y); 
                x  = val[0];
                y  = val[1];
                saltoY = val[2];                 
                break;                
            case "cajaOpciones":
                CajaOpciones op = (CajaOpciones)aux.getValor();
                JComboBox opciones =(JComboBox)aux.getValor();
                opciones.addItemListener(changeClick);
                opciones.setBounds(x, y, op.getAncho(), op.getAlto());    
                opciones.setPreferredSize(new java.awt.Dimension(op.getAncho(),op.getAlto()));     
                aplicarEstiloGrupo(aux, contenedor);
                aplicarEstiloId(aux, contenedor);
                contenedor.add(opciones);
                //System.out.println("Objeto insertado\t"+aux.getTipo()+" \tx: " +x + "\ty: "+ y);
                val = posicionPanel(opciones.getWidth(), opciones.getHeight(),  contenedor, saltoY, x, y); 
                x  = val[0];
                y  = val[1];
                saltoY = val[2];                  
                break;                
            case "imagen":
                Imagen imagen =(Imagen)aux.getValor();
                imagen.setBounds(x, y, imagen.getAncho(),imagen.getAlto());
                ImageIcon icono = new ImageIcon();
                imagen.removeMouseListener(mouseListenerImagen);
                imagen.addMouseListener(mouseListenerImagen);                  
                if(imagen.getRuta()!=null )
                {
                    if(!imagen.getRuta().equals(""))
                    {
                        icono =   new ImageIcon(imagen.getRuta().substring(1,imagen.getRuta().length()-1));
                    }   
                    if(!imagen.getRuta().substring(0,1).equals("\""))
                    {
                        icono = new ImageIcon(imagen.getRuta());
                    }  
                    ImageIcon iconoEscala = new ImageIcon(icono.getImage().getScaledInstance(imagen.getAncho(), imagen.getAlto(), java.awt.Image.SCALE_DEFAULT));                
                    imagen.setIcon(iconoEscala);                     
                    
                }                    
                imagen.setPreferredSize(new java.awt.Dimension(imagen.getAncho(),imagen.getAlto()));     
                aplicarEstiloGrupo(aux, contenedor);
                aplicarEstiloId(aux, contenedor);
                contenedor.add(imagen); 
                //System.out.println("Objeto insertado\t"+aux.getTipo()+" \tx: " +x + "\ty: "+ y);
                val = posicionPanel(imagen.getAncho(), imagen.getAlto(),  contenedor, saltoY, x, y); 
                x  = val[0];
                y  = val[1];
                saltoY = val[2];                 
                break;                  
            case "texto":
                Texto texto =(Texto)aux.getValor();
                //texto.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                texto.setOpaque(false);
                texto.setCadena(texto.getCadena().replace("\t", ""));
                texto.setCadena(texto.getCadena().replace("\r", "\n"));
                if(texto.getAlto()==0 && texto.getAncho()==0)
                {
                    //s = s.replace("xxxxx xxx xxxx ",s2)                     
                    String[] auxiliar = texto.getCadena().split("\n");
                    int alto= auxiliar.length;
                    System.out.println("El texto no tiene dimensiones definidas");
                    System.out.println("\t"+texto.getCadena());
                    System.out.println("\tNo. líneas \t"+alto);
                    int ancho = 0;
                    for(String cad : auxiliar)
                    {
                        if(cad.length()>ancho){ancho=cad.length();}
                        System.out.println("\tNo. caracteres \t"+ancho);
                    }
                    texto.setText(texto.getText());   
                    texto.setAlto(alto*20);
                    texto.setAncho(ancho * 12 * texto.getFont().getSize());                    
                }
                texto.setPreferredSize(new java.awt.Dimension(texto.getAncho(),texto.getAlto()));
                texto.setBounds(x, y, texto.getAncho(),texto.getAlto());  
                aplicarEstiloGrupo(aux, contenedor);
                aplicarEstiloId(aux, contenedor);
                contenedor.add(texto);
                //System.out.println("Objeto insertado\t"+aux.getTipo()+" \tx: " +x + "\ty: "+ y); 
                val = posicionPanel(texto.getAncho(), texto.getAlto(),  contenedor, saltoY, x, y); 
                x  = val[0];
                y  = val[1];
                saltoY = val[2];                
                break;  
                
            case "caja":
                Caja caja =(Caja)aux.getValor();
                if(caja.getAlto()==0 && caja.getAncho()==0)
                {
                    String[] auxiliar = caja.getCadena().split("\r");
                    int alto = auxiliar.length;
                    int ancho = 0;
                    String valorCaja= "";
                    for(String cad : auxiliar)
                    {
                        valorCaja = valorCaja + cad;                        
                        ancho = ancho + cad.length();
                    }                    
                    caja.setText(valorCaja);   
                    caja.setAlto(20);
                    caja.setAncho(ancho*7);
                }
                caja.setPreferredSize(new java.awt.Dimension(caja.getAncho(),caja.getAlto()));
                caja.setBounds(x, y, caja.getAncho(),caja.getAlto());     
                aplicarEstiloGrupo(aux, contenedor);
                aplicarEstiloId(aux, contenedor);
                contenedor.add(caja); 
                //System.out.println("Objeto insertado\t"+aux.getTipo()+" \tx: " +x + "\ty: "+ y);
                val = posicionPanel(caja.getAncho(), caja.getAlto(),  contenedor, saltoY, x, y); 
                x  = val[0];
                y  = val[1];
                saltoY = val[2];                 
                break;                  
                
            case "area":
                areaTexto area =(areaTexto)aux.getValor();
                area.setText(area.getCadena());  
                aplicarEstiloGrupo(aux, contenedor);
                aplicarEstiloId(aux, contenedor);
                JScrollPane nuevo = new JScrollPane(area);
                area.setPreferredSize(new java.awt.Dimension(area.getAncho(),area.getAlto()));
                area.setBounds(x, y, area.getAncho(),area.getAlto());                                
                nuevo.setBounds(x, y, area.getAncho(),area.getAlto());                 
                //aplicarEstiloGrupo(aux, contenedor);
                //contenedor.add(nuevo); 
                contenedor.add(area);
                //System.out.println("Objeto insertado\t"+aux.getTipo()+" \tx: " +x + "\ty: "+ y);
                val = posicionPanel(area.getAncho(), area.getAlto(),  contenedor, saltoY, x, y); 
                x  = val[0];
                y  = val[1];
                saltoY = val[2];                    
                break;                                 
            case "tabla":
                Tab tabla =(Tab)aux.getValor();                 
                tabla.setSize(tabla.getAncho(), tabla.getAlto());
                tabla.setBackground(Color.white);                
                tabla.setPreferredSize(new java.awt.Dimension(tabla.getAncho(),tabla.getAlto()));                
                aplicarEstiloGrupo(aux, contenedor);
                aplicarEstiloId(aux, contenedor);
                InterfazTabla(tabla);
                contenedor.add(tabla);                
                val = posicionPanel(tabla.getWidth(), tabla.getHeight(),  contenedor, saltoY, x, y); 
                x  = val[0];
                y  = val[1];
                saltoY = val[2];                 
                break;                     
            case "panel":
                Panel panel =(Panel)aux.getValor();                                                 
                panel.setBorder(BorderFactory.createLineBorder(Color.black));
                panel.setPreferredSize(new java.awt.Dimension(panel.getAncho(),panel.getAlto()));                                
                panel.setBounds(x, y, panel.getAncho(),panel.getAlto());                
                aplicarEstiloGrupo(aux, contenedor);
                aplicarEstiloId(aux, contenedor);                
                contenedor.add(panel);                
                val = posicionPanel(panel.getAncho(), panel.getAlto(),  contenedor, saltoY, x, y); 
                x  = val[0];
                y  = val[1];
                saltoY = val[2];                 
                break;                  
        }
        contenedor.repaint();
    }   
    this.repaint();
}

public void InterfazTabla(Tab contenedor)
{
    int x = 20;
    int y = 20;
    int saltoY = 0;
    int saltoX = 0;
    int anchoMaximo = 0;
    int altoMaximo = 0;
    ArrayList<Elemento> elementosContenedor = contenedor.getElementos();   
    
    int anchoContenedor = contenedor.getAncho();
    int altoContenedor = contenedor.getAlto();
    ArrayList<Integer> listaNumeroCeldas = new ArrayList();
    int celdas = 0;
    for(Elemento aux: contenedor.getElementos())
    {
        if(aux.getTipo().equals("nuevaLinea"))
        {
            listaNumeroCeldas.add(celdas);
            celdas = 0;
            
        }
        else
        {
            celdas++;
        }
    }
    
    int numeroCeldas = 0;
    int numeroFilas = listaNumeroCeldas.size();
    int cursor = 0;
    int index=0;
    for(Elemento aux: elementosContenedor)
    {
        numeroCeldas = listaNumeroCeldas.get(index);
        if(cursor==numeroCeldas)
        {
            if(index<numeroFilas-1)
            {
                index++;
                numeroCeldas = listaNumeroCeldas.get(index);
                cursor=0;                
            }
        }       
        int altoCelda = (altoContenedor-50)/numeroFilas;
        int anchoCelda = (anchoContenedor-50)/numeroCeldas;
        switch(aux.getTipo())
        {
            case "boton":
                Boton boton =(Boton)aux.getValor();                
                boton.setPreferredSize(new java.awt.Dimension(anchoCelda,altoCelda));
                boton.setBounds(x, y,anchoCelda, altoCelda);   
                boton.removeMouseListener(mouseListenerBoton);
                boton.addMouseListener(mouseListenerBoton);                   
                posicionTabla(anchoCelda, altoCelda,  contenedor, saltoY, x, y,anchoMaximo,altoMaximo);  
                aplicarEstiloGrupo(aux,contenedor);
                aplicarEstiloId(aux, contenedor);
                contenedor.add(boton);
                break;                                           
            case "imagen":
                Imagen imagen =(Imagen)aux.getValor();
                imagen.setBounds(x, y, anchoCelda,altoCelda);
                ImageIcon icono = new ImageIcon(); 
                imagen.removeMouseListener(mouseListenerImagen);
                imagen.addMouseListener(mouseListenerImagen);                
                if(imagen.getRuta()!=null )
                {
                    if(!imagen.getRuta().equals(""))
                    {
                        icono =   new ImageIcon(imagen.getRuta().substring(1,imagen.getRuta().length()-1));
                    }   
                    if(!imagen.getRuta().substring(0,1).equals("\""))
                    {
                        icono = new ImageIcon(imagen.getRuta());
                    }  
                    ImageIcon iconoEscala = new ImageIcon(icono.getImage().getScaledInstance(anchoCelda, altoCelda, java.awt.Image.SCALE_DEFAULT));                
                    imagen.setIcon(iconoEscala);                     
                    
                }                    
                imagen.setPreferredSize(new java.awt.Dimension(anchoCelda,altoCelda));
                posicionTabla(anchoCelda, altoCelda, contenedor, saltoY, x, y ,anchoMaximo,altoMaximo);                
                contenedor.add(imagen);       
                break;                  
            case "texto":
                Texto texto =(Texto)aux.getValor();
                if(texto.getAlto()==0 && texto.getAncho()==0)
                {
                    
                    String[] auxiliar = texto.getCadena().split("\r");
                    int alto= auxiliar.length*20;
                    System.out.println("El texto no tiene dimensiones definidas");
                    System.out.println("\t"+texto.getCadena());
                    System.out.println("\tNo. líneas \t"+alto);
                    int ancho = 0;
                    for(String cad : auxiliar)
                    {
                        if(cad.length()>ancho){ancho=cad.length();}
                        System.out.println("\tNo. caracteres \t"+ancho);
                    }
                    texto.setText(texto.getText());   
                    texto.setAlto(alto);
                    texto.setAncho(ancho*7);                    
                }
                texto.setPreferredSize(new java.awt.Dimension(anchoCelda,altoCelda));
                texto.setBounds(x, y, anchoCelda,altoCelda);                
                posicionTabla(anchoCelda, altoCelda, contenedor, saltoY, x, y ,anchoMaximo,altoMaximo);                
                contenedor.add(texto);                
                break;                  
        }
        cursor++;
        contenedor.repaint();
    }   
    this.repaint();
}






  

public String quitarComillas(String cadena)
{
    if(cadena!=null)
    {
        if(!cadena.equals(""))
        {
            String inicio = cadena.substring(0, 1);
            if(inicio.equals("\""))
            {
                return cadena.substring(1, cadena.length()-1);
            }
            return cadena.trim();            
        }
        return cadena.trim();
    }
    return cadena.trim();
}
     
private static boolean esNumero(String cadena){
	try 
        {
		Integer.parseInt(cadena);
		return true;
	} catch (NumberFormatException nfe){
		return false;
	}
}   
   
   public Color colorFuente(String color)
   {
       color = quitarComillas(color).toLowerCase();       
       Color retorno = Color.WHITE ;
       System.out.println("Buscando color: \t "+color);
       
       if(color.contains("#"))
       {
            //Mensaje("Buscando color: \t "+color,"");           
            //Color colorFodo = new Color(int r, int g, int b, int a);
            //this.scroll.setBackground(colorFondo);
            int r,g,b,a;
            String hr,hg,hb,ha;
            String entrada= color;
            hr = entrada.substring(1,3);
            hg = entrada.substring(3,5);
            hb = entrada.substring(5,7);

            r = hexToDec(hr);
            g = hexToDec(hg);
            b = hexToDec(hb);
            a=0;
            if(r==300 || g ==300 || b==300)
            {
                //filasErrores.addRow(new String[]{"CHTML",String.valueOf(hijoD.getLinea()),String.valueOf(hijoD.getColumna()),"Semantico", hijoD.getValue() + " Valor rgb no valido."});
                String mensaje = color + "Valor rgb no válido.";
                erroresSemanticos.add( new Errores("Sematico", 0,0, mensaje ));                
            }
            else
            {
                //panel.setBackground(new Color(r,g,b));
                retorno = new Color(r,g,b);            
            }        
       }
       else
       {              
            switch(color)
            {
                case "blue":
                    retorno = Color.blue;
                    break;
                case "black":
                    retorno = Color.BLACK;
                    break;
                case "gray":
                    retorno = Color.GRAY;
                    break;
                case "cyan":
                    retorno = Color.CYAN;
                    break;
                case "dark_gray":
                    retorno = Color.DARK_GRAY;
                    break;   
                case "green":
                    retorno = Color.GREEN;
                    break;
                case "light_gray":
                    retorno = Color.LIGHT_GRAY;
                    break;
                case "magenta":
                    retorno = Color.MAGENTA;
                    break;
                case "orange":
                    retorno = Color.ORANGE;
                    break;
                case "pink":
                    retorno = Color.PINK;
                    break;
                case "red":
                    retorno = Color.RED;
                    break;
                case "white":
                    retorno = Color.WHITE;
                    break;
                case "yellow":
                    retorno = Color.YELLOW;
                    break;  
                default:
                    //filasErrores.addRow(new String[]{"CHTML",String.valueOf(raiz.getLinea()),String.valueOf(raiz.getColumna()),"Semantico","Nombre de color no válido."});
                    //Errores(String tipo, int linea, int columna, String valor)
                    String mensaje = color + "Nombre de color no válido.";
                    erroresSemanticos.add( new Errores("Sematico", 0, 0, mensaje ));
                    break;
            }   
       }
        return retorno;
   }

   public Color buscarColor(nodoChtml raiz)
   {
       Color retorno = Color.white ;
       System.out.println("Buscando color: \t "+raiz.getValue());
        switch(raiz.getValue().toLowerCase())
        {
            case "\"blue\"":
                retorno = Color.blue;
                break;
            case "\"black\"":
                retorno = Color.BLACK;
                break;
            case "\"gray\"":
                retorno = Color.GRAY;
                break;
            case "\"cyan\"":
                retorno = Color.CYAN;
                break;
            case "\"dark_gray\"":
                retorno = Color.DARK_GRAY;
                break;   
            case "\"green\"":
                retorno = Color.GREEN;
                break;
            case "\"light_gray\"":
                retorno = Color.LIGHT_GRAY;
                break;
            case "\"magenta\"":
                retorno = Color.MAGENTA;
                break;
            case "\"orange\"":
                retorno = Color.ORANGE;
                break;
            case "\"pink\"":
                retorno = Color.PINK;
                break;
            case "\"red\"":
                retorno = Color.RED;
                break;
            case "\"white\"":
                retorno = Color.WHITE;
                break;
            case "\"yellow\"":
                retorno = Color.YELLOW;
                break;  
            default:
                //filasErrores.addRow(new String[]{"CHTML",String.valueOf(raiz.getLinea()),String.valueOf(raiz.getColumna()),"Semantico","Nombre de color no válido."});
                //Errores(String tipo, int linea, int columna, String valor)
                String mensaje = raiz.getValue() + "Nombre de color no válido.";
                erroresSemanticos.add( new Errores("Sematico", raiz.getLinea(), raiz.getColumna(), mensaje ));
                break;
        }   
        return retorno;
   }
   
   
   private static int hexToDec(String hex) {  
       Integer outputDecimal = 0;
        try
        { 
            outputDecimal = Integer.parseInt(hex, 16);
            System.out.print(outputDecimal+"\t D:\t" + hex);
            return outputDecimal;
        }

        catch(NumberFormatException ne)
        {
            return 300;
        }            
}
    
    
    
    
    public void imprimirReporteLexico(){
          String directorioHtml=PathActual()+"\\Lexico.html";

            if(tablaSimbolos_.isEmpty()){
                //JOptionPane.showMessageDialog(this,"No se ha hecho ningun analisis :v");
            }else{
                File html=new File(directorioHtml);
                PrintWriter writer;

                try {
                    writer=new PrintWriter(html);
                    String texto="<html>\n <meta http-equiv=\"Content-type\" content=\"text/html;charset=UTF-8\" />"
                        + "<head>\n" + "<title>TABLA DE TOKENS</title>\n" + "</head>\n"
                        + "<body>\n"
                        + "<h1 align=\"center\">ANALISIS LEXICO </h1>\n"
                        + "<hr width=\"75%\" size=\"2\" color=\"black\"/>"
                        + "<table border=\"1\">\n"
                        + "<tr>\n"
                        + "<td>No.</td>\n"
                        + "<td>Columna</td>\n"
                        + "<td>Linea</td>\n"
                        + "<td>Tipo</td>\n"
                        + "<td>Valor</td>\n"
                            + "<td>Descripcion</td>\n";

                           for(int x=0;x<tablaSimbolos_.size();x++){
                           texto+="</tr>\n"+ "<td>"+x+"</td>\n"
                        + "<td>"+tablaSimbolos_.get(x).columna+"</td>\n"
                        + "<td>"+tablaSimbolos_.get(x).linea+"</td>\n"
                        + "<td>"+tablaSimbolos_.get(x).tipo+"</td>\n"
                        + "<td>"+tablaSimbolos_.get(x).Valor+"</td>\n"
                        + "<td>"+tablaSimbolos_.get(x).descripcion+"</td>\n";
                           }

                        texto+="</tr>\n"+                    
                        "</table>\n"
                        + "</body>"
                        + "</html>";
                    writer.print(texto);
                    analisisLexico=texto;
                    writer.close();
                  //   abrirHtml(directorioHtml);
                } catch (FileNotFoundException ex) {

                }
            } 
    }    
    
    
    public void imprimirResultado(){
          String directorioHtml=PathActual()+"\\Resultado.html";

            if(tablaSimbolos_.isEmpty())
            {
                JOptionPane.showMessageDialog(this,"Error en análisis. Ver tabla de errores.");

            }
            else
            {
                File html=new File(directorioHtml);
                PrintWriter writer;

                try {
                    writer=new PrintWriter(html);

                    writer.print(resultado);
                  //  resultado=Interfaz.resultado;
                    writer.close();
                  //   abrirHtml(directorioHtml);
                } catch (FileNotFoundException ex) {

                }
            } 
    }    
    
    public void imprimirLexicos(){
         String directorioHtml=PathActual()+"\\Erores_lexicos.html";

           if(erroresLexicos.isEmpty()){
               //JOptionPane.showMessageDialog(this,"No se ha hecho ningun analisis :v");

           }else{
               File html=new File(directorioHtml);
               PrintWriter writer;

               try {
                   writer=new PrintWriter(html);
                   String texto="<html>\n <meta http-equiv=\"Content-type\" content=\"text/html;charset=UTF-8\" />"
                       + "<head>\n" + "<title>TABLA DE ERRORES</title>\n" + "</head>\n"
                       + "<body>\n"
                       + "<h1 align=\"center\">Errores Lexicos </h1>\n"
                       + "<hr width=\"75%\" size=\"2\" color=\"black\"/>"
                       + "<table border=\"1\">\n"
                       + "<tr>\n"
                       + "<td>No.</td>\n"
                       + "<td>Columna</td>\n"
                       + "<td>Linea</td>\n"
                       + "<td>Tipo</td>\n"
                           + "<td>Descripcion</td>\n";

                          for(int x=0;x<erroresLexicos.size();x++){
                          texto+="</tr>\n"+ "<td>"+x+"</td>\n"
                       + "<td>"+erroresLexicos.get(x).columna+"</td>\n"
                       + "<td>"+erroresLexicos.get(x).linea+"</td>\n"
                       + "<td>"+erroresLexicos.get(x).tipo+"</td>\n"
                       + "<td>"+erroresLexicos.get(x).descripcion+"</td>\n";
                          }

                       texto+="</tr>\n"+                    
                       "</table>\n"
                       + "</body>"
                       + "</html>";
                   writer.print(texto);
                   this.ELexico=texto;
                   writer.close();
                 //   abrirHtml(directorioHtml);
               } catch (FileNotFoundException ex) {

               }
           } 
   }

   public void imprimirSintacticos(){
         String directorioHtml=PathActual()+"\\Erores_sintacticos.html";

           if(erroresLexicos.isEmpty()){
               //JOptionPane.showMessageDialog(this,"No se ha hecho ningun analisis :v");

           }else{
               File html=new File(directorioHtml);
               PrintWriter writer;

               try {
                   writer=new PrintWriter(html);
                   String texto="<html>\n <meta http-equiv=\"Content-type\" content=\"text/html;charset=UTF-8\" />"
                       + "<head>\n" + "<title>TABLA DE ERRORES</title>\n" + "</head>\n"
                       + "<body>\n"
                       + "<h1 align=\"center\">Errores Sintacticos </h1>\n"
                       + "<hr width=\"75%\" size=\"2\" color=\"black\"/>"
                       + "<table border=\"1\">\n"
                       + "<tr>\n"
                       + "<td>No.</td>\n"
                       + "<td>Columna</td>\n"
                       + "<td>Linea</td>\n"
                       + "<td>Tipo</td>\n"
                           + "<td>Descripcion</td>\n";

                          for(int x=0;x<erroresSintacticos.size();x++){
                          texto+="</tr>\n"+ "<td>"+x+"</td>\n"
                       + "<td>"+erroresSintacticos.get(x).columna+"</td>\n"
                       + "<td>"+erroresSintacticos.get(x).linea+"</td>\n"
                       + "<td>"+erroresSintacticos.get(x).tipo+"</td>\n"
                       + "<td>"+erroresSintacticos.get(x).descripcion+"</td>\n";
                          }

                       texto+="</tr>\n"+                    
                       "</table>\n"
                       + "</body>"
                       + "</html>";
                   writer.print(texto);
                   analisisSintactico=texto;
                   writer.close();
                 //   abrirHtml(directorioHtml);
               } catch (FileNotFoundException ex) {

               }
           } 
   }

   public void imprimirSemanticos(){
         String directorioHtml=PathActual()+"\\Erores_semanticos.html";

           if(erroresSemanticos.isEmpty()){
              // JOptionPane.showMessageDialog(this,"No hay errores Semanticos");

           }else{
               File html=new File(directorioHtml);
               PrintWriter writer;

               try {
                   writer=new PrintWriter(html);
                   String texto="<html>\n <meta http-equiv=\"Content-type\" content=\"text/html;charset=UTF-8\" />"
                       + "<head>\n" + "<title>TABLA De ERRORES</title>\n" + "</head>\n"
                       + "<body>\n"
                       + "<h1 align=\"center\">Errores Semanticos </h1>\n"
                       + "<hr width=\"75%\" size=\"2\" color=\"black\"/>"
                       + "<table border=\"1\">\n"
                       + "<tr>\n"
                       + "<td>No.</td>\n"
                       + "<td>Columna</td>\n"
                       + "<td>Linea</td>\n"
                       + "<td>Tipo</td>\n"
                           + "<td>Descripcion</td>\n";

                          for(int x=0;x<erroresSemanticos.size();x++){
                          texto+="</tr>\n"+ "<td>"+x+"</td>\n"
                       + "<td>"+erroresSemanticos.get(x).columna+"</td>\n"
                       + "<td>"+erroresSemanticos.get(x).linea+"</td>\n"
                       + "<td>"+erroresSemanticos.get(x).tipo+"</td>\n"
                       + "<td>"+erroresSemanticos.get(x).descripcion+"</td>\n";
                          }

                       texto+="</tr>\n"+                    
                       "</table>\n"
                       + "</body>"
                       + "</html>";
                   writer.print(texto);
                   analisisSemantico=texto;
                   writer.close();
                 //   abrirHtml(directorioHtml);
               } catch (FileNotFoundException ex) {

               }
           } 
   }

   

    
    public String PathActual(){
        String path="";
         File miDir = new File (".");
         try {
           //System.out.println (miDir.getCanonicalPath());
           path=miDir.getCanonicalPath();
         }
         catch(Exception e) 
         {
           e.printStackTrace();
         }
         return path;
    }    
    
    public void errores_consola()
    {                
        
        JTable tablaErrores = new JTable();        
        filasErrores = new DefaultTableModel();        
        filasErrores.addColumn("Archivo");
        filasErrores.addColumn("Línea");
        filasErrores.addColumn("Columna");
        filasErrores.addColumn("Detalle"); 
        filasErrores.addColumn("Tipo");         
        filasErrores.addRow(new String[]{"Archivo","Linea","Columna","Detalle","Tipo"});
        tablaErrores.setModel(filasErrores);       
        
             
        
        String temporal=
        "Linea           Columna           Descripcion                TIPO";
        
        /*Errores CHTML*/
        for(int x=0;x<erroresLexicos.size();x++)
        {
            if(!erroresLexicos.get(x).getDescripcion().equals("Caracter Ilegal: \""))
            {
                filasErrores.addRow(new Object[]{this.textRuta.getText(), erroresLexicos.get(x).linea,erroresLexicos.get(x).columna,erroresLexicos.get(x).getDescripcion(),"Lexico"});
                temporal+="\n"+erroresLexicos.get(x).linea+"                "+erroresLexicos.get(x).columna+"          "+erroresLexicos.get(x).getDescripcion()+"       Lexico";                 
            }
        }
        for(int x=0;x<erroresSintacticos.size();x++){
            if(!erroresSintacticos.get(x).getDescripcion().equals(""))
            {
                filasErrores.addRow(new Object[]{this.textRuta.getText(), erroresSintacticos.get(x).linea,erroresSintacticos.get(x).columna,erroresSintacticos.get(x).getDescripcion(),"Sintactico"});                
            }
        }
        for(int x=0;x<erroresSemanticos.size();x++)
        {
            filasErrores.addRow(new Object[]{this.textRuta.getText(), erroresSemanticos.get(x).linea,erroresSemanticos.get(x).columna,erroresSemanticos.get(x).getDescripcion(),"Semanticos"});
        }      
        
        
        /*ERRORES CCSS*/
        
        for(Source.CCSS.errorCcss err : Source.CCSS.listaError.listaErrores)
        {
            filasErrores.addRow(new Object[]{this.pathCcss, err.fila, err.columna,err.descripcion,err.tipoerror});
        }                               
        /*ERRORES CJS*/
        
        for (Iterator i = lexico_cjs.TablaEL.iterator(); i.hasNext();) {
          Source.CJS.Analizadores.Terror error = (Source.CJS.Analizadores.Terror) i.next();
          filasErrores.addRow(new Object[]{this.pathCjs,error.getLinea(), error.getColumna(),error.getDescripcion(),"Lexico"});
        }
         lexico_cjs.TablaEL.clear();
         
        for (Iterator i = sintactico_cjs.TablaES.iterator(); i.hasNext();) {
          Source.CJS.Analizadores.Terror error = (Source.CJS.Analizadores.Terror) i.next();
          filasErrores.addRow(new Object[]{this.pathCjs,error.getLinea(), error.getColumna(),error.getDescripcion(),"Lexico"});
        }
         sintactico_cjs.TablaES.clear();         
         

         
        for (Iterator i = Execute.TablaES.iterator(); i.hasNext();) {
          Source.CJS.Analizadores.Terror error = (Source.CJS.Analizadores.Terror) i.next();
          filasErrores.addRow(new Object[]{this.pathCjs,error.getLinea(), error.getColumna(),error.getDescripcion(),"Semantico"});
        }         
        
        Execute.TablaES.clear();
        
         
        
        
        //tablaErrores.setText(temporal);
        //Mensaje(temporal, temporal);

        //panelErrores.add(tablaErrores);
        contenedorErrores.removeAll();
        contenedorErrores.add(tablaErrores);
        //System.out.println(temporal);                        
    }  
    
    
    
    
    public void imprimirSalidaConsola()
    {                
        
      /*  JTable tablaSalida = new JTable();        
        DefaultTableModel filasSalida = new DefaultTableModel();        
        filasSalida.addColumn("Archivo");
        filasSalida.addColumn("Línea");
        filasSalida.addColumn("Columna");
        filasSalida.addColumn("Salida");             
        filasSalida.addRow(new String[]{"Archivo","Linea","Columna","Salida"});
        tablaSalida.setModel(filasSalida);        
        

        for(Salida out: this.listaConsola)
        {
            filasSalida.addRow(new Object[]{out.getArchivo(), out.getLinea(), out.getColumna(), out.getSalida()});            
        }

        JPanel salidaPanel = new JPanel();
        salidaPanel.add(tablaSalida);
        scrollSalidas.add(salidaPanel);*/
        
        //System.out.println(temporal);                        
    }    
    
    
    @Override
    public void actionPerformed(ActionEvent evento)
    {
        Boton objeto = (Boton)evento.getSource();
        JOptionPane.showMessageDialog( this, objeto.getMetodo(), objeto.getCadena(), 0);
    }
    
    public void addChtml(String tipo, int linea, int columna, String descripcion, String valor)
    {                
        auxContador++;                                
        //Generamos la entrada en la tabla de simbolos.
        tablaSimbolos simbolo=new tablaSimbolos();
        simbolo.setTipo(tipo);
        simbolo.setLinea(linea);
        simbolo.setColumna(columna);
        simbolo.setDescripcion(descripcion);
        simbolo.setIndex(auxContador);
        simbolo.setValor(valor);                 
        tablaSimbolos_.add(simbolo);	            
    }
    private class BotonPulsadoListener implements ActionListener{		

      @Override
      public void actionPerformed(ActionEvent e) {
        etiquetaNombre.setText("Has pulsado el botón " + e.getActionCommand());			
      }					
    }   
    
    
    
    MouseListener mouseListenerBoton= new MouseListener() 
    {

        @Override
        public void mouseReleased(MouseEvent e)
        {
        }

        @Override
        public void mousePressed(MouseEvent e) 
        {                
            Boton boton = (Boton)e.getSource(); 
            if(!boton.getRuta().equals(""))
            {
                try 
                {
                    //Mensaje("Abriendo nueva página.",boton.getRuta());  
                    abrirEnlace(boton.getRuta());
                } 
                catch (IOException ex) 
                {
                    Logger.getLogger(Pagina.class.getName()).log(Level.SEVERE, null, ex);
                }            
            }            
            ejecutar(boton.getMetodo());
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseClicked(MouseEvent e) 
        {
             
        }
    };    
    
    
    MouseListener mouseListenerImagen= new MouseListener() 
    {

        @Override
        public void mouseReleased(MouseEvent e)
        {
        }

        @Override
        public void mousePressed(MouseEvent e) 
        {                
            Imagen boton = (Imagen)e.getSource();  
            
                                              
            /*if(!boton.getRuta().equals(""))
            {
                try 
                {
                    //Mensaje("Abriendo nueva página.",boton.getRuta());  
                    abrirEnlace(boton.getRuta());
                } 
                catch (IOException ex) 
                {
                    Logger.getLogger(Pagina.class.getName()).log(Level.SEVERE, null, ex);
                }            
            }**/
            ejecutar(boton.getMetodo());
                       
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseClicked(MouseEvent e) 
        {
             
        }
    };       
    
    MouseListener listenerEnlace= new MouseListener() 
    {

        @Override
        public void mouseReleased(MouseEvent e)
        {
        }

        @Override
        public void mousePressed(MouseEvent e) 
        {                
            Enlace boton = (Enlace)e.getSource();                        
            if(!boton.getRuta().equals(""))
            {
                try 
                {          
                    abrirEnlace(boton.getRuta());
                } 
                catch (IOException ex) 
                {
                    Logger.getLogger(Pagina.class.getName()).log(Level.SEVERE, null, ex);
                }                
            }
            else
            {
                //Mensaje("",boton.getMetodo());
            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseClicked(MouseEvent e) 
        {
             
        }
    };   
    
    public void abrirEnlace(String path) throws IOException
    {
            Pagina pagina = new Pagina();            
            pagina.textRuta.setText(quitarComillas(path)); 
            scroll.add(pagina);
            contenedorPaginas.addTab("Historial", null, pagina);
            pagina.analizar();
                                                                     
    }

    
    public void verPaginaAnterior() throws IOException
    {
        if(Pagina.contadorPagina>1)
        {

                Pagina.contadorPagina--;
                String rutaAuxiliar[] = Pagina.historial.get(Pagina.contadorPagina).split(",");
                textRuta.setText(rutaAuxiliar[0]);
                analizar();                            
        }        
    }
    
    public void verPaginaSiguiente() throws IOException
    {
        if(Pagina.contadorPagina< Pagina.historial.size())
        {
                Pagina.contadorPagina++;
                String rutaAuxiliar[] = Pagina.historial.get(Pagina.contadorPagina).split(",");                
                textRuta.setText(rutaAuxiliar[0]);
                analizar();                
        }    
    }
    

    
    public void actualizarEstilos(String id, String grupo, Object comp)
  {      
        Source.CCSS.Ejecucion.nodoLista  estilo = null;
        if(comp instanceof Panel)
        { 
            Panel item = (Panel)comp; 
            estilo = buscarEstilo(item.getGrupo(),null);
            if(estilo!=null)
            {
                 cambiosPanel(item ,estilo);
            }
            estilo = null;
            estilo = buscarEstilo(null,item.getId());
            if(estilo!=null)
            {
                 cambiosPanel(item ,estilo);
            }            
        }
        if(comp instanceof Tab)
        { 
            Tab item = (Tab)comp; 
            estilo = buscarEstilo(item.getGrupo(),null);
            if(estilo!=null)
            {
                 cambiosTab(item ,estilo);
            }
            estilo = null;
            estilo = buscarEstilo(null,item.getId());
            if(estilo!=null)
            {
                 cambiosTab(item ,estilo);
            }            
        }      
        if(comp instanceof Boton)
        { 
            Boton item = (Boton)comp; 
            estilo =buscarEstilo(item.getGrupo(),null);
            if(estilo!=null)
            {
                 cambiosBoton(item ,estilo);
            }
            estilo = null;
            estilo = buscarEstilo(item.getId(), null);
            if(estilo!=null)
            {
                 cambiosBoton(item ,estilo);
            }            
        }           
        if(comp instanceof Texto)
        { 
            Texto item = (Texto)comp; 
            estilo = buscarEstilo(item.getGrupo(),null);
            if(estilo!=null)
            {
                 cambiosTexto(item ,estilo);
            }
            estilo = null;
            estilo = buscarEstilo(item.getId(), null);
            if(estilo!=null)
            {
                 cambiosTexto(item ,estilo);
            }            
        }    
        if(comp instanceof Caja)
        { 
            Caja item = (Caja)comp; 
            estilo = buscarEstilo(item.getGrupo(),null);
            if(estilo!=null)
            {
                 cambiosCaja(item ,estilo);
            }
            estilo = null;
            estilo = buscarEstilo(item.getId(), null);
            if(estilo!=null)
            {
                 cambiosCaja(item ,estilo);
            }            
        }      
        if(comp instanceof Enlace)
        { 
            Enlace item = (Enlace)comp; 
            estilo = buscarEstilo(item.getGrupo(),null);
            if(estilo!=null)
            {
                 cambiosEnlace(item ,estilo);
            }
            estilo = null;
            estilo = buscarEstilo(item.getId(), null);
            if(estilo!=null)
            {
                 cambiosEnlace(item ,estilo);
            }            
        }  
        if(comp instanceof Imagen)
        { 
            Imagen item = (Imagen)comp; 
            estilo = buscarEstilo(item.getGrupo(),null);
            if(estilo!=null)
            {
                 cambiosImagen(item ,estilo);
            }
            estilo = null;
            estilo = buscarEstilo(item.getId(), null);
            if(estilo!=null)
            {
                 cambiosImagen(item ,estilo);
            }            
        }  
        if(comp instanceof Spinner)
        { 
            Spinner item = (Spinner)comp; 
            estilo = buscarEstilo(item.getGrupo(),null);
            if(estilo!=null)
            {
                 cambiosSpinner(item ,estilo);
            }
            estilo = null;
            estilo = buscarEstilo(item.getId(), null);
            if(estilo!=null)
            {
                 cambiosSpinner(item ,estilo);
            }            
        }   
        
        if(comp instanceof areaTexto)
        { 
            areaTexto item = (areaTexto)comp; 
            estilo = buscarEstilo(item.getGrupo(),null);
            if(estilo!=null)
            {
                 cambiosAreaTexto(item ,estilo);
            }
            estilo = null;
            estilo = buscarEstilo(item.getId(), null);
            if(estilo!=null)
            {
                 cambiosAreaTexto(item ,estilo);
            }            
        }        
                                                 
        if(comp instanceof CajaOpciones)
        { 
            CajaOpciones item = (CajaOpciones)comp; 
            estilo = buscarEstilo(item.getGrupo(),null);
            if(estilo!=null)
            {
                 cambiosCajaOpciones(item ,estilo);
            }
            estilo = null;
            estilo = buscarEstilo(item.getId(), null);
            if(estilo!=null)
            {
                 cambiosCajaOpciones(item ,estilo);
            }            
        }                                                              
        this.repaint();
        
    }
    public void cambiosCajaOpciones(CajaOpciones objeto ,Source.CCSS.Ejecucion.nodoLista nodoEstilo )
    {
        if(nodoEstilo!=null)
        {
            for(Object estiloElemento: nodoEstilo.getAtributos())
            {
                if(estiloElemento instanceof ArrayList)
                { 
                    ArrayList arreglo = (ArrayList)estiloElemento;
                    for(Object element: arreglo)
                    {
                        if(element instanceof Source.CCSS.AST.nodo)
                        {
                            Source.CCSS.AST.nodo elementArray = (Source.CCSS.AST.nodo)element;
                            switch(quitarComillas(elementArray.texto).toLowerCase())
                            {
                                case "minuscula":                                                
                                        //objeto.setText(objeto.getText().toLowerCase());                                                    
                                    break;
                                case "mayuscula": 
                                        //objeto.setText(objeto.getText().toUpperCase());                                                                                                        
                                    break;
                                case "negrilla":
                                    if(objeto.getFont().getStyle()==2)
                                    {
                                        objeto.setFont(new Font(objeto.getFont().getName(),3,objeto.getFont().getSize()));
                                    }
                                    else
                                    {
                                        objeto.setFont(new Font(objeto.getFont().getName(),1,objeto.getFont().getSize()));
                                    }
                                    break;
                                case "cursiva":
                                    if(objeto.getFont().getSize()==1)
                                    {
                                        objeto.setFont(new Font(objeto.getFont().getName(),3,objeto.getFont().getSize()));
                                    }
                                    else
                                    {
                                        objeto.setFont(new Font(objeto.getFont().getName(),2,objeto.getFont().getSize()));
                                    }
                                    break;                                    
                            }//Fin switch formato
                        }// Fin verificacion de tipo Source.CCSS. nodo                                
                    }// Fin for de array
                }// Fin verificacion tipo arrayList 
                if(estiloElemento instanceof Source.CCSS.Ejecucion.tipoEstilo)
                {
                    Source.CCSS.Ejecucion.tipoEstilo estilo = (Source.CCSS.Ejecucion.tipoEstilo)estiloElemento;
                    switch(estilo.getNombre().toLowerCase())
                    {
                        case "alineado":
                            String valor ="";
                            if(estilo.getValor() instanceof String){ valor = (String)estilo.getValor();}
                            switch(valor.toLowerCase())
                            {
                                case "izquierda": 
                                    objeto.setAlignmentX(LEFT_ALIGNMENT);
                                    break;
                                case "derecha": 
                                    objeto.setAlignmentX(RIGHT_ALIGNMENT);
                                    break;
                                case "centrado": 
                                    objeto.setAlignmentX(CENTER_ALIGNMENT);
                                    break;                                                
                            }
                            break;// Fin caso alineado                                    
                        case "texto":
                            valor ="";
                            if(estilo.getValor() instanceof String)
                            {
                                valor = (String)estilo.getValor();
                                //objeto.setText(valor);
                            }                                    
                            break;                                    
                        case "letra":
                            valor ="";
                            if(estilo.getValor() instanceof String){ valor = (String)estilo.getValor(); valor= quitarComillas(valor);}                                                                   
                            try 
                            {
                                Font fuente = objeto.getFont();                                                                                
                                objeto.setFont(new Font(valor, fuente.getStyle(), fuente.getSize()));   
                            } 
                            catch (Exception e)
                            {
                            }                               
                            break;  // Fin caso letra
                        case "tamtex":
                            Double tamTex = 0.00;
                            if(estilo.getValor() instanceof Double){ tamTex = (Double)estilo.getValor();}                                                                   
                            try 
                            {
                                Font fuente = objeto.getFont();  
                                if(tamTex==0){tamTex = (double)fuente.getSize();}
                                int tamText = Integer.valueOf(tamTex.intValue());
                                objeto.setFont(new Font(fuente.getName(), fuente.getStyle(), tamText));   
                            } 
                            catch (Exception e){}  
                            break; //Fin caso tamtex
                        case "visible":
                            valor ="";
                            Boolean visibilidad = true;
                            if(estilo.getValor() instanceof Boolean){ visibilidad = (Boolean)estilo.getValor();}   
                            objeto.setVisible(visibilidad);
                            break;//Fin visible 
                        case "fondoelemento":
                            valor ="";
                            if(estilo.getValor() instanceof String)
                            {
                                valor = (String)estilo.getValor();
                                valor = quitarComillas(valor);
                                objeto.setBackground(colorFuente(valor));
                                //valor = (String)estilo.getValor();
                                //objeto.setColorFuente(colorFuente(valor));
                            }
                            break;//Fin colortext  

                        case "borde":
                            valor = "";
                            if(estilo.getValor() instanceof ArrayList)
                            {
                                ArrayList arreglo = (ArrayList)estilo.getValor();
                                String color ="";
                                Boolean borde = true;
                                int grosor = 10;

                                for(Object item : arreglo )
                                {
                                    if(item instanceof String)
                                    {
                                        color = quitarComillas((String)item);
                                    }
                                    if(item instanceof Boolean)
                                    {                                                                                                                                                        
                                         borde = (Boolean)item;                                                                                                       
                                    }
                                    if(item instanceof Double)
                                    {
                                        Double auxiliar = (Double)item;
                                        grosor = auxiliar.intValue();
                                    }
                                }                                            
                                if(!color.equals(""))
                                {
                                    objeto.setBorder(new LineBorder(colorFuente(color),grosor, borde));
                                }                                            
                            }
                            break; // Fin caso borde   
                        case "opaque":
                            valor ="";
                            Boolean opacacidad = true;
                            if(estilo.getValor() instanceof Boolean){ opacacidad = (Boolean)estilo.getValor();}   
                            objeto.setOpaque(!opacacidad);
                            break;//Fin Opacacidad      
                        case "colortexto":                                        
                            valor ="";
                            if(estilo.getValor() instanceof String)
                            {
                                valor = (String)estilo.getValor();
                                //objeto.setColorFuente(colorFuente(valor));
                                objeto.setForeground(colorFuente(valor));
                            }
                            break;//Fin colortext                                          
                    }// Fin switch                                                                                                    
                } // Fin if instancia estilo
            }//Fin for
        }//Fin if !=null

        
    }    
    public void cambiosAreaTexto(areaTexto objeto ,Source.CCSS.Ejecucion.nodoLista nodoEstilo )
    {
        if(nodoEstilo!=null)
        {
            for(Object estiloElemento: nodoEstilo.getAtributos())
            {
                if(estiloElemento instanceof ArrayList)
                { 
                    ArrayList arreglo = (ArrayList)estiloElemento;
                    for(Object element: arreglo)
                    {
                        if(element instanceof Source.CCSS.AST.nodo)
                        {
                            Source.CCSS.AST.nodo elementArray = (Source.CCSS.AST.nodo)element;
                            switch(quitarComillas(elementArray.texto).toLowerCase())
                            {
                                case "minuscula":                                                
                                        objeto.setText(objeto.getText().toLowerCase());                                                    
                                    break;
                                case "mayuscula": 
                                        objeto.setText(objeto.getText().toUpperCase());                                                                                                        
                                    break;
                                case "negrilla":
                                    if(objeto.getFont().getStyle()==2)
                                    {
                                        objeto.setFont(new Font(objeto.getFont().getName(),3,objeto.getFont().getSize()));
                                    }
                                    else
                                    {
                                        objeto.setFont(new Font(objeto.getFont().getName(),1,objeto.getFont().getSize()));
                                    }
                                    break;
                                case "cursiva":
                                    if(objeto.getFont().getSize()==1)
                                    {
                                        objeto.setFont(new Font(objeto.getFont().getName(),3,objeto.getFont().getSize()));
                                    }
                                    else
                                    {
                                        objeto.setFont(new Font(objeto.getFont().getName(),2,objeto.getFont().getSize()));
                                    }
                                    break;
                                case "capital-t":
                                    String[] palabras = objeto.getText().split(" ");
                                    String cadena = "";
                                    if(palabras.length>0)
                                    {
                                        for(String palabra: palabras)
                                        {
                                            if(palabra.length()>2)
                                            {
                                                palabra = palabra.substring(0,1).toUpperCase() + palabra.substring(1,palabra.length()) + " ";                                                       
                                                cadena = cadena + palabra;                                                            
                                            }
                                        }
                                    }
                                    objeto.setText(cadena);
                                    break;
                            }//Fin switch formato
                        }// Fin verificacion de tipo Source.CCSS. nodo                                
                    }// Fin for de array
                }// Fin verificacion tipo arrayList 
                if(estiloElemento instanceof Source.CCSS.Ejecucion.tipoEstilo)
                {
                    Source.CCSS.Ejecucion.tipoEstilo estilo = (Source.CCSS.Ejecucion.tipoEstilo)estiloElemento;
                    switch(estilo.getNombre().toLowerCase())
                    {
                        case "alineado":
                            String valor ="";
                            if(estilo.getValor() instanceof String){ valor = (String)estilo.getValor();}
                            switch(valor.toLowerCase())
                            {
                                case "izquierda": 
                                    objeto.setAlignmentX(LEFT_ALIGNMENT);
                                    break;
                                case "derecha": 
                                    objeto.setAlignmentX(RIGHT_ALIGNMENT);
                                    break;
                                case "centrado": 
                                    objeto.setAlignmentX(CENTER_ALIGNMENT);
                                    break;                                                
                            }
                            break;// Fin caso alineado                                    
                        case "texto":
                            valor ="";
                            if(estilo.getValor() instanceof String)
                            {
                                valor = (String)estilo.getValor();
                                objeto.setText(valor);
                            }                                    
                            break;                                    
                        case "letra":
                            valor ="";
                            if(estilo.getValor() instanceof String){ valor = (String)estilo.getValor(); valor= quitarComillas(valor);}                                                                   
                            try 
                            {
                                Font fuente = objeto.getFont();                                                                                
                                objeto.setFont(new Font(valor, fuente.getStyle(), fuente.getSize()));   
                            } 
                            catch (Exception e)
                            {
                            }                               
                            break;  // Fin caso letra
                        case "tamtex":
                            Double tamTex = 0.00;
                            if(estilo.getValor() instanceof Double){ tamTex = (Double)estilo.getValor();}                                                                   
                            try 
                            {
                                Font fuente = objeto.getFont();  
                                if(tamTex==0){tamTex = (double)fuente.getSize();}
                                int tamText = Integer.valueOf(tamTex.intValue());
                                objeto.setFont(new Font(fuente.getName(), fuente.getStyle(), tamText));   
                            } 
                            catch (Exception e){}  
                            break; //Fin caso tamtex
                        case "visible":
                            valor ="";
                            Boolean visibilidad = true;
                            if(estilo.getValor() instanceof Boolean){ visibilidad = (Boolean)estilo.getValor();}   
                            objeto.setVisible(visibilidad);
                            break;//Fin visible 
                        case "fondoelemento":
                            valor ="";
                            if(estilo.getValor() instanceof String)
                            {
                                valor = (String)estilo.getValor();
                                valor = quitarComillas(valor);
                                objeto.setBackground(colorFuente(valor));
                                //valor = (String)estilo.getValor();
                                //objeto.setColorFuente(colorFuente(valor));
                            }
                            break;//Fin colortext  

                        case "borde":
                            valor = "";
                            if(estilo.getValor() instanceof ArrayList)
                            {
                                ArrayList arreglo = (ArrayList)estilo.getValor();
                                String color ="";
                                Boolean borde = true;
                                int grosor = 10;

                                for(Object item : arreglo )
                                {
                                    if(item instanceof String)
                                    {
                                        color = quitarComillas((String)item);
                                    }
                                    if(item instanceof Boolean)
                                    {                                                                                                                                                        
                                         borde = (Boolean)item;                                                                                                       
                                    }
                                    if(item instanceof Double)
                                    {
                                        Double auxiliar = (Double)item;
                                        grosor = auxiliar.intValue();
                                    }
                                }                                            
                                if(!color.equals(""))
                                {
                                    objeto.setBorder(new LineBorder(colorFuente(color),grosor, borde));
                                }                                            
                            }
                            break; // Fin caso borde   
                        case "opaque":
                            valor ="";
                            Boolean opacacidad = true;
                            if(estilo.getValor() instanceof Boolean){ opacacidad = (Boolean)estilo.getValor();}   
                            objeto.setOpaque(!opacacidad);
                            break;//Fin Opacacidad      
                        case "colortexto":                                        
                            valor ="";
                            if(estilo.getValor() instanceof String)
                            {
                                valor = (String)estilo.getValor();
                                //objeto.setColorFuente(colorFuente(valor));
                                objeto.setForeground(colorFuente(valor));
                            }
                            break;//Fin colortext                                          
                    }// Fin switch                                                                                                    
                } // Fin if instancia estilo
            }//Fin for
        }//Fin if !=null

        
    }    
    public void cambiosSpinner(Spinner objeto ,Source.CCSS.Ejecucion.nodoLista nodoEstilo )
    {
        if(nodoEstilo!=null)
        {
            for(Object estiloElemento: nodoEstilo.getAtributos())
            {
                if(estiloElemento instanceof ArrayList)
                { 
                    ArrayList arreglo = (ArrayList)estiloElemento;
                    for(Object element: arreglo)
                    {
                        if(element instanceof Source.CCSS.AST.nodo)
                        {
                            Source.CCSS.AST.nodo elementArray = (Source.CCSS.AST.nodo)element;
                            switch(quitarComillas(elementArray.texto).toLowerCase())
                            {
                                case "minuscula":                                                
                                        //objeto.setText(objeto.getText().toLowerCase());                                                    
                                    break;
                                case "mayuscula": 
                                        //objeto.setText(objeto.getText().toUpperCase());                                                                                                        
                                    break;
                                case "negrilla":
                                    if(objeto.getFont().getStyle()==2)
                                    {
                                        objeto.setFont(new Font(objeto.getFont().getName(),3,objeto.getFont().getSize()));
                                    }
                                    else
                                    {
                                        objeto.setFont(new Font(objeto.getFont().getName(),1,objeto.getFont().getSize()));
                                    }
                                    break;
                                case "cursiva":
                                    if(objeto.getFont().getSize()==1)
                                    {
                                        objeto.setFont(new Font(objeto.getFont().getName(),3,objeto.getFont().getSize()));
                                    }
                                    else
                                    {
                                        objeto.setFont(new Font(objeto.getFont().getName(),2,objeto.getFont().getSize()));
                                    }
                                    break;
                                    
                            }//Fin switch formato
                        }// Fin verificacion de tipo Source.CCSS. nodo                                
                    }// Fin for de array
                }// Fin verificacion tipo arrayList 
                if(estiloElemento instanceof Source.CCSS.Ejecucion.tipoEstilo)
                {
                    Source.CCSS.Ejecucion.tipoEstilo estilo = (Source.CCSS.Ejecucion.tipoEstilo)estiloElemento;
                    switch(estilo.getNombre().toLowerCase())
                    {
                        case "alineado":
                            String valor ="";
                            if(estilo.getValor() instanceof String){ valor = (String)estilo.getValor();}
                            switch(valor.toLowerCase())
                            {
                                case "izquierda": 
                                    objeto.setAlignmentX(LEFT_ALIGNMENT);
                                    break;
                                case "derecha": 
                                    objeto.setAlignmentX(RIGHT_ALIGNMENT);
                                    break;
                                case "centrado": 
                                    objeto.setAlignmentX(CENTER_ALIGNMENT);
                                    break;                                                
                            }
                            break;// Fin caso alineado                                    
                        case "texto":
                            valor ="";
                            if(estilo.getValor() instanceof String)
                            {
                                valor = (String)estilo.getValor();
                                //objeto.setText(valor);
                            }                                    
                            break;                                    
                        case "letra":
                            valor ="";
                            if(estilo.getValor() instanceof String){ valor = (String)estilo.getValor(); valor= quitarComillas(valor);}                                                                   
                            try 
                            {
                                Font fuente = objeto.getFont();                                                                                
                                objeto.setFont(new Font(valor, fuente.getStyle(), fuente.getSize()));   
                            } 
                            catch (Exception e)
                            {
                            }                               
                            break;  // Fin caso letra
                        case "tamtex":
                            Double tamTex = 0.00;
                            if(estilo.getValor() instanceof Double){ tamTex = (Double)estilo.getValor();}                                                                   
                            try 
                            {
                                Font fuente = objeto.getFont();  
                                if(tamTex==0){tamTex = (double)fuente.getSize();}
                                int tamText = Integer.valueOf(tamTex.intValue());
                                objeto.setFont(new Font(fuente.getName(), fuente.getStyle(), tamText));   
                            } 
                            catch (Exception e){}  
                            break; //Fin caso tamtex
                        case "visible":
                            valor ="";
                            Boolean visibilidad = true;
                            if(estilo.getValor() instanceof Boolean){ visibilidad = (Boolean)estilo.getValor();}   
                            objeto.setVisible(visibilidad);
                            break;//Fin visible 
                        case "fondoelemento":
                            valor ="";
                            if(estilo.getValor() instanceof String)
                            {
                                valor = (String)estilo.getValor();
                                valor = quitarComillas(valor);
                                objeto.setBackground(colorFuente(valor));
                                //valor = (String)estilo.getValor();
                                //objeto.setColorFuente(colorFuente(valor));
                            }
                            break;//Fin colortext  

                        case "borde":
                            valor = "";
                            if(estilo.getValor() instanceof ArrayList)
                            {
                                ArrayList arreglo = (ArrayList)estilo.getValor();
                                String color ="";
                                Boolean borde = true;
                                int grosor = 10;

                                for(Object item : arreglo )
                                {
                                    if(item instanceof String)
                                    {
                                        color = quitarComillas((String)item);
                                    }
                                    if(item instanceof Boolean)
                                    {                                                                                                                                                        
                                         borde = (Boolean)item;                                                                                                       
                                    }
                                    if(item instanceof Double)
                                    {
                                        Double auxiliar = (Double)item;
                                        grosor = auxiliar.intValue();
                                    }
                                }                                            
                                if(!color.equals(""))
                                {
                                    objeto.setBorder(new LineBorder(colorFuente(color),grosor, borde));
                                }                                            
                            }
                            break; // Fin caso borde   
                        case "opaque":
                            valor ="";
                            Boolean opacacidad = true;
                            if(estilo.getValor() instanceof Boolean){ opacacidad = (Boolean)estilo.getValor();}   
                            objeto.setOpaque(!opacacidad);
                            break;//Fin Opacacidad      
                        case "colortexto":                                        
                            valor ="";
                            if(estilo.getValor() instanceof String)
                            {
                                valor = (String)estilo.getValor();
                                //objeto.setColorFuente(colorFuente(valor));
                                objeto.setForeground(colorFuente(valor));
                            }
                            break;//Fin colortext                                          
                    }// Fin switch                                                                                                    
                } // Fin if instancia estilo
            }//Fin for
        }//Fin if !=null

        
    }    
    public void cambiosImagen(Imagen objeto ,Source.CCSS.Ejecucion.nodoLista nodoEstilo )
    {
        if(nodoEstilo!=null)
        {
            for(Object estiloElemento: nodoEstilo.getAtributos())
            {
                if(estiloElemento instanceof ArrayList)
                { 
                    ArrayList arreglo = (ArrayList)estiloElemento;
                    for(Object element: arreglo)
                    {
                        if(element instanceof Source.CCSS.AST.nodo)
                        {
                            Source.CCSS.AST.nodo elementArray = (Source.CCSS.AST.nodo)element;
                            switch(quitarComillas(elementArray.texto).toLowerCase())
                            {
                                case "minuscula":                                                
                                        objeto.setText(objeto.getText().toLowerCase());                                                    
                                    break;
                                case "mayuscula": 
                                        objeto.setText(objeto.getText().toUpperCase());                                                                                                        
                                    break;
                                case "negrilla":
                                    if(objeto.getFont().getStyle()==2)
                                    {
                                        objeto.setFont(new Font(objeto.getFont().getName(),3,objeto.getFont().getSize()));
                                    }
                                    else
                                    {
                                        objeto.setFont(new Font(objeto.getFont().getName(),1,objeto.getFont().getSize()));
                                    }
                                    break;
                                case "cursiva":
                                    if(objeto.getFont().getSize()==1)
                                    {
                                        objeto.setFont(new Font(objeto.getFont().getName(),3,objeto.getFont().getSize()));
                                    }
                                    else
                                    {
                                        objeto.setFont(new Font(objeto.getFont().getName(),2,objeto.getFont().getSize()));
                                    }
                                    break;
                                case "capital-t":
                                    String[] palabras = objeto.getText().split(" ");
                                    String cadena = "";
                                    if(palabras.length>0)
                                    {
                                        for(String palabra: palabras)
                                        {
                                            if(palabra.length()>2)
                                            {
                                                palabra = palabra.substring(0,1).toUpperCase() + palabra.substring(1,palabra.length()) + " ";                                                       
                                                cadena = cadena + palabra;                                                            
                                            }
                                        }
                                    }
                                    objeto.setText(cadena);
                                    break;
                            }//Fin switch formato
                        }// Fin verificacion de tipo Source.CCSS. nodo                                
                    }// Fin for de array
                }// Fin verificacion tipo arrayList 
                if(estiloElemento instanceof Source.CCSS.Ejecucion.tipoEstilo)
                {
                    Source.CCSS.Ejecucion.tipoEstilo estilo = (Source.CCSS.Ejecucion.tipoEstilo)estiloElemento;
                    switch(estilo.getNombre().toLowerCase())
                    {
                        case "alineado":
                            String valor ="";
                            if(estilo.getValor() instanceof String){ valor = (String)estilo.getValor();}
                            switch(valor.toLowerCase())
                            {
                                case "izquierda": 
                                    objeto.setAlignmentX(LEFT_ALIGNMENT);
                                    break;
                                case "derecha": 
                                    objeto.setAlignmentX(RIGHT_ALIGNMENT);
                                    break;
                                case "centrado": 
                                    objeto.setAlignmentX(CENTER_ALIGNMENT);
                                    break;                                                
                            }
                            break;// Fin caso alineado                                    
                        case "texto":
                            valor ="";
                            if(estilo.getValor() instanceof String)
                            {
                                valor = (String)estilo.getValor();
                                objeto.setText(valor);
                            }                                    
                            break;                                    
                        case "letra":
                            valor ="";
                            if(estilo.getValor() instanceof String){ valor = (String)estilo.getValor(); valor= quitarComillas(valor);}                                                                   
                            try 
                            {
                                Font fuente = objeto.getFont();                                                                                
                                objeto.setFont(new Font(valor, fuente.getStyle(), fuente.getSize()));   
                            } 
                            catch (Exception e)
                            {
                            }                               
                            break;  // Fin caso letra
                        case "tamtex":
                            Double tamTex = 0.00;
                            if(estilo.getValor() instanceof Double){ tamTex = (Double)estilo.getValor();}                                                                   
                            try 
                            {
                                Font fuente = objeto.getFont();  
                                if(tamTex==0){tamTex = (double)fuente.getSize();}
                                int tamText = Integer.valueOf(tamTex.intValue());
                                objeto.setFont(new Font(fuente.getName(), fuente.getStyle(), tamText));   
                            } 
                            catch (Exception e){}  
                            break; //Fin caso tamtex
                        case "visible":
                            valor ="";
                            Boolean visibilidad = true;
                            if(estilo.getValor() instanceof Boolean){ visibilidad = (Boolean)estilo.getValor();}   
                            objeto.setVisible(visibilidad);
                            break;//Fin visible 
                        case "fondoelemento":
                            valor ="";
                            if(estilo.getValor() instanceof String)
                            {
                                valor = (String)estilo.getValor();
                                valor = quitarComillas(valor);
                                objeto.setBackground(colorFuente(valor));
                                //valor = (String)estilo.getValor();
                                //objeto.setColorFuente(colorFuente(valor));
                            }
                            break;//Fin colortext  

                        case "borde":
                            valor = "";
                            if(estilo.getValor() instanceof ArrayList)
                            {
                                ArrayList arreglo = (ArrayList)estilo.getValor();
                                String color ="";
                                Boolean borde = true;
                                int grosor = 10;

                                for(Object item : arreglo )
                                {
                                    if(item instanceof String)
                                    {
                                        color = quitarComillas((String)item);
                                    }
                                    if(item instanceof Boolean)
                                    {                                                                                                                                                        
                                         borde = (Boolean)item;                                                                                                       
                                    }
                                    if(item instanceof Double)
                                    {
                                        Double auxiliar = (Double)item;
                                        grosor = auxiliar.intValue();
                                    }
                                }                                            
                                if(!color.equals(""))
                                {
                                    objeto.setBorder(new LineBorder(colorFuente(color),grosor, borde));
                                }                                            
                            }
                            break; // Fin caso borde   
                        case "opaque":
                            valor ="";
                            Boolean opacacidad = true;
                            if(estilo.getValor() instanceof Boolean){ opacacidad = (Boolean)estilo.getValor();}   
                            objeto.setOpaque(!opacacidad);
                            break;//Fin Opacacidad      
                        case "colortexto":                                        
                            valor ="";
                            if(estilo.getValor() instanceof String)
                            {
                                valor = (String)estilo.getValor();
                                //objeto.setColorFuente(colorFuente(valor));
                                objeto.setForeground(colorFuente(valor));
                            }
                            break;//Fin colortext                                          
                    }// Fin switch                                                                                                    
                } // Fin if instancia estilo
            }//Fin for
        }//Fin if !=null

        
    }    
    public void cambiosEnlace(Enlace objeto ,Source.CCSS.Ejecucion.nodoLista nodoEstilo )
    {
        if(nodoEstilo!=null)
        {
            for(Object estiloElemento: nodoEstilo.getAtributos())
            {
                if(estiloElemento instanceof ArrayList)
                { 
                    ArrayList arreglo = (ArrayList)estiloElemento;
                    for(Object element: arreglo)
                    {
                        if(element instanceof Source.CCSS.AST.nodo)
                        {
                            Source.CCSS.AST.nodo elementArray = (Source.CCSS.AST.nodo)element;
                            switch(quitarComillas(elementArray.texto).toLowerCase())
                            {
                                case "minuscula":                                                
                                        objeto.setText(objeto.getText().toLowerCase());                                                    
                                    break;
                                case "mayuscula": 
                                        objeto.setText(objeto.getText().toUpperCase());                                                                                                        
                                    break;
                                case "negrilla":
                                    if(objeto.getFont().getStyle()==2)
                                    {
                                        objeto.setFont(new Font(objeto.getFont().getName(),3,objeto.getFont().getSize()));
                                    }
                                    else
                                    {
                                        objeto.setFont(new Font(objeto.getFont().getName(),1,objeto.getFont().getSize()));
                                    }
                                    break;
                                case "cursiva":
                                    if(objeto.getFont().getSize()==1)
                                    {
                                        objeto.setFont(new Font(objeto.getFont().getName(),3,objeto.getFont().getSize()));
                                    }
                                    else
                                    {
                                        objeto.setFont(new Font(objeto.getFont().getName(),2,objeto.getFont().getSize()));
                                    }
                                    break;
                                case "capital-t":
                                    String[] palabras = objeto.getText().split(" ");
                                    String cadena = "";
                                    if(palabras.length>0)
                                    {
                                        for(String palabra: palabras)
                                        {
                                            if(palabra.length()>2)
                                            {
                                                palabra = palabra.substring(0,1).toUpperCase() + palabra.substring(1,palabra.length()) + " ";                                                       
                                                cadena = cadena + palabra;                                                            
                                            }
                                        }
                                    }
                                    objeto.setText(cadena);
                                    break;
                            }//Fin switch formato
                        }// Fin verificacion de tipo Source.CCSS. nodo                                
                    }// Fin for de array
                }// Fin verificacion tipo arrayList 
                if(estiloElemento instanceof Source.CCSS.Ejecucion.tipoEstilo)
                {
                    Source.CCSS.Ejecucion.tipoEstilo estilo = (Source.CCSS.Ejecucion.tipoEstilo)estiloElemento;
                    switch(estilo.getNombre().toLowerCase())
                    {
                        case "alineado":
                            String valor ="";
                            if(estilo.getValor() instanceof String){ valor = (String)estilo.getValor();}
                            switch(valor.toLowerCase())
                            {
                                case "izquierda": 
                                    objeto.setAlignmentX(LEFT_ALIGNMENT);
                                    break;
                                case "derecha": 
                                    objeto.setAlignmentX(RIGHT_ALIGNMENT);
                                    break;
                                case "centrado": 
                                    objeto.setAlignmentX(CENTER_ALIGNMENT);
                                    break;                                                
                            }
                            break;// Fin caso alineado                                    
                        case "texto":
                            valor ="";
                            if(estilo.getValor() instanceof String)
                            {
                                valor = (String)estilo.getValor();
                                objeto.setText(valor);
                            }                                    
                            break;                                    
                        case "letra":
                            valor ="";
                            if(estilo.getValor() instanceof String){ valor = (String)estilo.getValor(); valor= quitarComillas(valor);}                                                                   
                            try 
                            {
                                Font fuente = objeto.getFont();                                                                                
                                objeto.setFont(new Font(valor, fuente.getStyle(), fuente.getSize()));   
                            } 
                            catch (Exception e)
                            {
                            }                               
                            break;  // Fin caso letra
                        case "tamtex":
                            Double tamTex = 0.00;
                            if(estilo.getValor() instanceof Double){ tamTex = (Double)estilo.getValor();}                                                                   
                            try 
                            {
                                Font fuente = objeto.getFont();  
                                if(tamTex==0){tamTex = (double)fuente.getSize();}
                                int tamText = Integer.valueOf(tamTex.intValue());
                                objeto.setFont(new Font(fuente.getName(), fuente.getStyle(), tamText));   
                            } 
                            catch (Exception e){}  
                            break; //Fin caso tamtex
                        case "visible":
                            valor ="";
                            Boolean visibilidad = true;
                            if(estilo.getValor() instanceof Boolean){ visibilidad = (Boolean)estilo.getValor();}   
                            objeto.setVisible(visibilidad);
                            break;//Fin visible 
                        case "fondoelemento":
                            valor ="";
                            if(estilo.getValor() instanceof String)
                            {
                                valor = (String)estilo.getValor();
                                valor = quitarComillas(valor);
                                objeto.setBackground(colorFuente(valor));
                                //valor = (String)estilo.getValor();
                                //objeto.setColorFuente(colorFuente(valor));
                            }
                            break;//Fin colortext  

                        case "borde":
                            valor = "";
                            if(estilo.getValor() instanceof ArrayList)
                            {
                                ArrayList arreglo = (ArrayList)estilo.getValor();
                                String color ="";
                                Boolean borde = true;
                                int grosor = 10;

                                for(Object item : arreglo )
                                {
                                    if(item instanceof String)
                                    {
                                        color = quitarComillas((String)item);
                                    }
                                    if(item instanceof Boolean)
                                    {                                                                                                                                                        
                                         borde = (Boolean)item;                                                                                                       
                                    }
                                    if(item instanceof Double)
                                    {
                                        Double auxiliar = (Double)item;
                                        grosor = auxiliar.intValue();
                                    }
                                }                                            
                                if(!color.equals(""))
                                {
                                    objeto.setBorder(new LineBorder(colorFuente(color),grosor, borde));
                                }                                            
                            }
                            break; // Fin caso borde   
                        case "opaque":
                            valor ="";
                            Boolean opacacidad = true;
                            if(estilo.getValor() instanceof Boolean){ opacacidad = (Boolean)estilo.getValor();}   
                            objeto.setOpaque(!opacacidad);
                            break;//Fin Opacacidad      
                        case "colortexto":                                        
                            valor ="";
                            if(estilo.getValor() instanceof String)
                            {
                                valor = (String)estilo.getValor();
                                //objeto.setColorFuente(colorFuente(valor));
                                objeto.setForeground(colorFuente(valor));
                            }
                            break;//Fin colortext                                          
                    }// Fin switch                                                                                                    
                } // Fin if instancia estilo
            }//Fin for
        }//Fin if !=null

        
    }    
    public void cambiosCaja(Caja objeto ,Source.CCSS.Ejecucion.nodoLista nodoEstilo )
    {
        if(nodoEstilo!=null)
        {
            for(Object estiloElemento: nodoEstilo.getAtributos())
            {
                if(estiloElemento instanceof ArrayList)
                { 
                    ArrayList arreglo = (ArrayList)estiloElemento;
                    for(Object element: arreglo)
                    {
                        if(element instanceof Source.CCSS.AST.nodo)
                        {
                            Source.CCSS.AST.nodo elementArray = (Source.CCSS.AST.nodo)element;
                            switch(quitarComillas(elementArray.texto).toLowerCase())
                            {
                                case "minuscula":                                                
                                        objeto.setText(objeto.getText().toLowerCase());                                                    
                                    break;
                                case "mayuscula": 
                                        objeto.setText(objeto.getText().toUpperCase());                                                                                                        
                                    break;
                                case "negrilla":
                                    if(objeto.getFont().getStyle()==2)
                                    {
                                        objeto.setFont(new Font(objeto.getFont().getName(),3,objeto.getFont().getSize()));
                                    }
                                    else
                                    {
                                        objeto.setFont(new Font(objeto.getFont().getName(),1,objeto.getFont().getSize()));
                                    }
                                    break;
                                case "cursiva":
                                    if(objeto.getFont().getSize()==1)
                                    {
                                        objeto.setFont(new Font(objeto.getFont().getName(),3,objeto.getFont().getSize()));
                                    }
                                    else
                                    {
                                        objeto.setFont(new Font(objeto.getFont().getName(),2,objeto.getFont().getSize()));
                                    }
                                    break;
                                case "capital-t":
                                    String[] palabras = objeto.getText().split(" ");
                                    String cadena = "";
                                    if(palabras.length>0)
                                    {
                                        for(String palabra: palabras)
                                        {
                                            if(palabra.length()>2)
                                            {
                                                palabra = palabra.substring(0,1).toUpperCase() + palabra.substring(1,palabra.length()) + " ";                                                       
                                                cadena = cadena + palabra;                                                            
                                            }
                                        }
                                    }
                                    objeto.setText(cadena);
                                    break;
                            }//Fin switch formato
                        }// Fin verificacion de tipo Source.CCSS. nodo                                
                    }// Fin for de array
                }// Fin verificacion tipo arrayList 
                if(estiloElemento instanceof Source.CCSS.Ejecucion.tipoEstilo)
                {
                    Source.CCSS.Ejecucion.tipoEstilo estilo = (Source.CCSS.Ejecucion.tipoEstilo)estiloElemento;
                    switch(estilo.getNombre().toLowerCase())
                    {
                        case "alineado":
                            String valor ="";
                            if(estilo.getValor() instanceof String){ valor = (String)estilo.getValor();}
                            switch(valor.toLowerCase())
                            {
                                case "izquierda": 
                                    objeto.setAlignmentX(LEFT_ALIGNMENT);
                                    break;
                                case "derecha": 
                                    objeto.setAlignmentX(RIGHT_ALIGNMENT);
                                    break;
                                case "centrado": 
                                    objeto.setAlignmentX(CENTER_ALIGNMENT);
                                    break;                                                
                            }
                            break;// Fin caso alineado                                    
                        case "texto":
                            valor ="";
                            if(estilo.getValor() instanceof String)
                            {
                                valor = (String)estilo.getValor();
                                objeto.setText(valor);
                            }                                    
                            break;                                    
                        case "letra":
                            valor ="";
                            if(estilo.getValor() instanceof String){ valor = (String)estilo.getValor(); valor= quitarComillas(valor);}                                                                   
                            try 
                            {
                                Font fuente = objeto.getFont();                                                                                
                                objeto.setFont(new Font(valor, fuente.getStyle(), fuente.getSize()));   
                            } 
                            catch (Exception e)
                            {
                            }                               
                            break;  // Fin caso letra
                        case "tamtex":
                            Double tamTex = 0.00;
                            if(estilo.getValor() instanceof Double){ tamTex = (Double)estilo.getValor();}                                                                   
                            try 
                            {
                                Font fuente = objeto.getFont();  
                                if(tamTex==0){tamTex = (double)fuente.getSize();}
                                int tamText = Integer.valueOf(tamTex.intValue());
                                objeto.setFont(new Font(fuente.getName(), fuente.getStyle(), tamText));   
                            } 
                            catch (Exception e){}  
                            break; //Fin caso tamtex
                        case "visible":
                            valor ="";
                            Boolean visibilidad = true;
                            if(estilo.getValor() instanceof Boolean){ visibilidad = (Boolean)estilo.getValor();}   
                            objeto.setVisible(visibilidad);
                            break;//Fin visible 
                        case "fondoelemento":
                            valor ="";
                            if(estilo.getValor() instanceof String)
                            {
                                valor = (String)estilo.getValor();
                                valor = quitarComillas(valor);
                                objeto.setBackground(colorFuente(valor));
                                //valor = (String)estilo.getValor();
                                //objeto.setColorFuente(colorFuente(valor));
                            }
                            break;//Fin colortext  

                        case "borde":
                            valor = "";
                            if(estilo.getValor() instanceof ArrayList)
                            {
                                ArrayList arreglo = (ArrayList)estilo.getValor();
                                String color ="";
                                Boolean borde = true;
                                int grosor = 10;

                                for(Object item : arreglo )
                                {
                                    if(item instanceof String)
                                    {
                                        color = quitarComillas((String)item);
                                    }
                                    if(item instanceof Boolean)
                                    {                                                                                                                                                        
                                         borde = (Boolean)item;                                                                                                       
                                    }
                                    if(item instanceof Double)
                                    {
                                        Double auxiliar = (Double)item;
                                        grosor = auxiliar.intValue();
                                    }
                                }                                            
                                if(!color.equals(""))
                                {
                                    objeto.setBorder(new LineBorder(colorFuente(color),grosor, borde));
                                }                                            
                            }
                            break; // Fin caso borde   
                        case "opaque":
                            valor ="";
                            Boolean opacacidad = true;
                            if(estilo.getValor() instanceof Boolean){ opacacidad = (Boolean)estilo.getValor();}   
                            objeto.setOpaque(!opacacidad);
                            break;//Fin Opacacidad      
                        case "colortexto":                                        
                            valor ="";
                            if(estilo.getValor() instanceof String)
                            {
                                valor = (String)estilo.getValor();
                                //objeto.setColorFuente(colorFuente(valor));
                                objeto.setForeground(colorFuente(valor));
                            }
                            break;//Fin colortext                                          
                    }// Fin switch                                                                                                    
                } // Fin if instancia estilo
            }//Fin for
        }//Fin if !=null

        
    }    
    public void cambiosTexto(Texto objeto ,Source.CCSS.Ejecucion.nodoLista nodoEstilo )
    {
        if(nodoEstilo!=null)
        {
            for(Object estiloElemento: nodoEstilo.getAtributos())
            {
                if(estiloElemento instanceof ArrayList)
                { 
                    ArrayList arreglo = (ArrayList)estiloElemento;
                    for(Object element: arreglo)
                    {
                        if(element instanceof Source.CCSS.AST.nodo)
                        {
                            Source.CCSS.AST.nodo elementArray = (Source.CCSS.AST.nodo)element;
                            switch(quitarComillas(elementArray.texto).toLowerCase())
                            {
                                case "minuscula":                                                
                                        objeto.setText(objeto.getText().toLowerCase());                                                    
                                    break;
                                case "mayuscula": 
                                        objeto.setText(objeto.getText().toUpperCase());                                                                                                        
                                    break;
                                case "negrilla":
                                    if(objeto.getFont().getStyle()==2)
                                    {
                                        objeto.setFont(new Font(objeto.getFont().getName(),3,objeto.getFont().getSize()));
                                    }
                                    else
                                    {
                                        objeto.setFont(new Font(objeto.getFont().getName(),1,objeto.getFont().getSize()));
                                    }
                                    break;
                                case "cursiva":
                                    if(objeto.getFont().getSize()==1)
                                    {
                                        objeto.setFont(new Font(objeto.getFont().getName(),3,objeto.getFont().getSize()));
                                    }
                                    else
                                    {
                                        objeto.setFont(new Font(objeto.getFont().getName(),2,objeto.getFont().getSize()));
                                    }
                                    break;
                                case "capital-t":
                                    String[] palabras = objeto.getText().split(" ");
                                    String cadena = "";
                                    if(palabras.length>0)
                                    {
                                        for(String palabra: palabras)
                                        {
                                            if(palabra.length()>2)
                                            {
                                                palabra = palabra.substring(0,1).toUpperCase() + palabra.substring(1,palabra.length()) + " ";                                                       
                                                cadena = cadena + palabra;                                                            
                                            }
                                        }
                                    }
                                    objeto.setText(cadena);
                                    break;
                            }//Fin switch formato
                        }// Fin verificacion de tipo Source.CCSS. nodo                                
                    }// Fin for de array
                }// Fin verificacion tipo arrayList 
                if(estiloElemento instanceof Source.CCSS.Ejecucion.tipoEstilo)
                {
                    Source.CCSS.Ejecucion.tipoEstilo estilo = (Source.CCSS.Ejecucion.tipoEstilo)estiloElemento;
                    switch(estilo.getNombre().toLowerCase())
                    {
                        case "alineado":
                            String valor ="";
                            if(estilo.getValor() instanceof String){ valor = (String)estilo.getValor();}
                            switch(valor.toLowerCase())
                            {
                                case "izquierda": 
                                    objeto.setAlignmentX(LEFT_ALIGNMENT);
                                    break;
                                case "derecha": 
                                    objeto.setAlignmentX(RIGHT_ALIGNMENT);
                                    break;
                                case "centrado": 
                                    objeto.setAlignmentX(CENTER_ALIGNMENT);
                                    break;                                                
                            }
                            break;// Fin caso alineado                                    
                        case "texto":
                            valor ="";
                            if(estilo.getValor() instanceof String)
                            {
                                valor = (String)estilo.getValor();
                                objeto.setText(valor);
                            }                                    
                            break;                                    
                        case "letra":
                            valor ="";
                            if(estilo.getValor() instanceof String){ valor = (String)estilo.getValor(); valor= quitarComillas(valor);}                                                                   
                            try 
                            {
                                Font fuente = objeto.getFont();                                                                                
                                objeto.setFont(new Font(valor, fuente.getStyle(), fuente.getSize()));   
                            } 
                            catch (Exception e)
                            {
                            }                               
                            break;  // Fin caso letra
                        case "tamtex":
                            Double tamTex = 0.00;
                            if(estilo.getValor() instanceof Double){ tamTex = (Double)estilo.getValor();}                                                                   
                            try 
                            {
                                Font fuente = objeto.getFont();  
                                if(tamTex==0){tamTex = (double)fuente.getSize();}
                                int tamText = Integer.valueOf(tamTex.intValue());
                                objeto.setFont(new Font(fuente.getName(), fuente.getStyle(), tamText));   
                            } 
                            catch (Exception e){}  
                            break; //Fin caso tamtex
                        case "visible":
                            valor ="";
                            Boolean visibilidad = true;
                            if(estilo.getValor() instanceof Boolean){ visibilidad = (Boolean)estilo.getValor();}   
                            objeto.setVisible(visibilidad);
                            break;//Fin visible 
                        case "fondoelemento":
                            valor ="";
                            if(estilo.getValor() instanceof String)
                            {
                                valor = (String)estilo.getValor();
                                valor = quitarComillas(valor);
                                objeto.setBackground(colorFuente(valor));
                                //valor = (String)estilo.getValor();
                                //objeto.setColorFuente(colorFuente(valor));
                            }
                            break;//Fin colortext  

                        case "borde":
                            valor = "";
                            if(estilo.getValor() instanceof ArrayList)
                            {
                                ArrayList arreglo = (ArrayList)estilo.getValor();
                                String color ="";
                                Boolean borde = true;
                                int grosor = 10;

                                for(Object item : arreglo )
                                {
                                    if(item instanceof String)
                                    {
                                        color = quitarComillas((String)item);
                                    }
                                    if(item instanceof Boolean)
                                    {                                                                                                                                                        
                                         borde = (Boolean)item;                                                                                                       
                                    }
                                    if(item instanceof Double)
                                    {
                                        Double auxiliar = (Double)item;
                                        grosor = auxiliar.intValue();
                                    }
                                }                                            
                                if(!color.equals(""))
                                {
                                    objeto.setBorder(new LineBorder(colorFuente(color),grosor, borde));
                                }                                            
                            }
                            break; // Fin caso borde   
                        case "opaque":
                            valor ="";
                            Boolean opacacidad = true;
                            if(estilo.getValor() instanceof Boolean){ opacacidad = (Boolean)estilo.getValor();}   
                            objeto.setOpaque(!opacacidad);
                            break;//Fin Opacacidad      
                        case "colortexto":                                        
                            valor ="";
                            if(estilo.getValor() instanceof String)
                            {
                                valor = (String)estilo.getValor();
                                //objeto.setColorFuente(colorFuente(valor));
                                objeto.setForeground(colorFuente(valor));
                            }
                            break;//Fin colortext                                          
                    }// Fin switch                                                                                                    
                } // Fin if instancia estilo
            }//Fin for
        }//Fin if !=null

        
    }    
    public void cambiosTab(Tab tab ,Source.CCSS.Ejecucion.nodoLista nodoEstilo )
    {
        if(nodoEstilo!=null)
        {
            for(Object estiloElemento: nodoEstilo.getAtributos())
            {
                if(estiloElemento instanceof ArrayList)
                { 
                    ArrayList arreglo = (ArrayList)estiloElemento;
                    for(Object element: arreglo)
                    {
                        if(element instanceof Source.CCSS.AST.nodo)
                        {
                            Source.CCSS.AST.nodo elementArray = (Source.CCSS.AST.nodo)element;
                            switch(quitarComillas(elementArray.texto).toLowerCase())
                            {
                                case "minuscula":                                                
                                        //tab.setText(tab.getText().toLowerCase());                                                    
                                    break;
                                case "mayuscula": 
                                        //tab.setText(tab.getText().toUpperCase());                                                                                                        
                                    break;
                                case "negrilla":
                                    if(tab.getFont().getStyle()==2)
                                    {
                                        tab.setFont(new Font(tab.getFont().getName(),3,tab.getFont().getSize()));
                                    }
                                    else
                                    {
                                        tab.setFont(new Font(tab.getFont().getName(),1,tab.getFont().getSize()));
                                    }
                                    break;
                                case "cursiva":
                                    if(tab.getFont().getSize()==1)
                                    {
                                        tab.setFont(new Font(tab.getFont().getName(),3,tab.getFont().getSize()));
                                    }
                                    else
                                    {
                                        tab.setFont(new Font(tab.getFont().getName(),2,tab.getFont().getSize()));
                                    }
                                    break;                                    
                            }//Fin switch formato
                        }// Fin verificacion de tipo Source.CCSS. nodo                                
                    }// Fin for de array
                }// Fin verificacion tipo arrayList 
                if(estiloElemento instanceof Source.CCSS.Ejecucion.tipoEstilo)
                {
                    Source.CCSS.Ejecucion.tipoEstilo estilo = (Source.CCSS.Ejecucion.tipoEstilo)estiloElemento;
                    switch(estilo.getNombre().toLowerCase())
                    {
                        case "alineado":
                            String valor ="";
                            if(estilo.getValor() instanceof String){ valor = (String)estilo.getValor();}
                            switch(valor.toLowerCase())
                            {
                                case "izquierda": 
                                    tab.setAlignmentX(LEFT_ALIGNMENT);
                                    break;
                                case "derecha": 
                                    tab.setAlignmentX(RIGHT_ALIGNMENT);
                                    break;
                                case "centrado": 
                                    tab.setAlignmentX(CENTER_ALIGNMENT);
                                    break;                                                
                            }
                            break;// Fin caso alineado                                    
                        case "texto":
                            valor ="";
                            if(estilo.getValor() instanceof String)
                            {
                                valor = (String)estilo.getValor();
                                //tab.setText(valor);
                            }                                    
                            break;                                    
                        case "letra":
                            valor ="";
                            if(estilo.getValor() instanceof String){ valor = (String)estilo.getValor(); valor= quitarComillas(valor);}                                                                   
                            try 
                            {
                                Font fuente = tab.getFont();                                                                                
                                tab.setFont(new Font(valor, fuente.getStyle(), fuente.getSize()));   
                            } 
                            catch (Exception e)
                            {
                            }                               
                            break;  // Fin caso letra
                        case "tamtex":
                            Double tamTex = 0.00;
                            if(estilo.getValor() instanceof Double){ tamTex = (Double)estilo.getValor();}                                                                   
                            try 
                            {
                                Font fuente = tab.getFont();  
                                if(tamTex==0){tamTex = (double)fuente.getSize();}
                                int tamText = Integer.valueOf(tamTex.intValue());
                                tab.setFont(new Font(fuente.getName(), fuente.getStyle(), tamText));   
                            } 
                            catch (Exception e){}  
                            break; //Fin caso tamtex
                        case "visible":
                            valor ="";
                            Boolean visibilidad = true;
                            if(estilo.getValor() instanceof Boolean){ visibilidad = (Boolean)estilo.getValor();}   
                            tab.setVisible(visibilidad);
                            break;//Fin visible 
                        case "fondoelemento":
                            valor ="";
                            if(estilo.getValor() instanceof String)
                            {
                                valor = (String)estilo.getValor();
                                valor = quitarComillas(valor);
                                tab.setBackground(colorFuente(valor));
                                //valor = (String)estilo.getValor();
                                //tab.setColorFuente(colorFuente(valor));
                            }
                            break;//Fin colortext  

                        case "borde":
                            valor = "";
                            if(estilo.getValor() instanceof ArrayList)
                            {
                                ArrayList arreglo = (ArrayList)estilo.getValor();
                                String color ="";
                                Boolean borde = true;
                                int grosor = 10;

                                for(Object item : arreglo )
                                {
                                    if(item instanceof String)
                                    {
                                        color = quitarComillas((String)item);
                                    }
                                    if(item instanceof Boolean)
                                    {                                                                                                                                                        
                                         borde = (Boolean)item;                                                                                                       
                                    }
                                    if(item instanceof Double)
                                    {
                                        Double auxiliar = (Double)item;
                                        grosor = auxiliar.intValue();
                                    }
                                }                                            
                                if(!color.equals(""))
                                {
                                    tab.setBorder(new LineBorder(colorFuente(color),grosor, borde));
                                }                                            
                            }
                            break; // Fin caso borde   
                        case "opaque":
                            valor ="";
                            Boolean opacacidad = true;
                            if(estilo.getValor() instanceof Boolean){ opacacidad = (Boolean)estilo.getValor();}   
                            tab.setOpaque(!opacacidad);
                            break;//Fin Opacacidad      
                        case "colortexto":                                        
                            valor ="";
                            if(estilo.getValor() instanceof String)
                            {
                                valor = (String)estilo.getValor();
                                //tab.setColorFuente(colorFuente(valor));
                                tab.setForeground(colorFuente(valor));
                            }
                            break;//Fin colortext                                          
                    }// Fin switch                                                                                                    
                } // Fin if instancia estilo
            }//Fin for
        }//Fin if !=null

        
    }    
    public void cambiosPanel(Panel panel ,Source.CCSS.Ejecucion.nodoLista nodoEstilo )
    {
        if(nodoEstilo!=null)
        {
            for(Object estiloElemento: nodoEstilo.getAtributos())
            {
                if(estiloElemento instanceof ArrayList)
                { 
                    ArrayList arreglo = (ArrayList)estiloElemento;
                    for(Object element: arreglo)
                    {
                        if(element instanceof Source.CCSS.AST.nodo)
                        {
                            Source.CCSS.AST.nodo elementArray = (Source.CCSS.AST.nodo)element;
                            switch(quitarComillas(elementArray.texto).toLowerCase())
                            {
                                case "minuscula":                                                
                                        //panel.setText(panel.getText().toLowerCase());                                                    
                                    break;
                                case "mayuscula": 
                                        //panel.setText(panel.getText().toUpperCase());                                                                                                        
                                    break;
                                case "negrilla":
                                    if(panel.getFont().getStyle()==2)
                                    {
                                        panel.setFont(new Font(panel.getFont().getName(),3,panel.getFont().getSize()));
                                    }
                                    else
                                    {
                                        panel.setFont(new Font(panel.getFont().getName(),1,panel.getFont().getSize()));
                                    }
                                    break;
                                case "cursiva":
                                    if(panel.getFont().getSize()==1)
                                    {
                                        panel.setFont(new Font(panel.getFont().getName(),3,panel.getFont().getSize()));
                                    }
                                    else
                                    {
                                        panel.setFont(new Font(panel.getFont().getName(),2,panel.getFont().getSize()));
                                    }
                                    break;

                            }//Fin switch formato
                        }// Fin verificacion de tipo Source.CCSS. nodo                                
                    }// Fin for de array
                }// Fin verificacion tipo arrayList 
                if(estiloElemento instanceof Source.CCSS.Ejecucion.tipoEstilo)
                {
                    Source.CCSS.Ejecucion.tipoEstilo estilo = (Source.CCSS.Ejecucion.tipoEstilo)estiloElemento;
                    switch(estilo.getNombre().toLowerCase())
                    {
                        case "alineado":
                            String valor ="";
                            if(estilo.getValor() instanceof String){ valor = (String)estilo.getValor();}
                            switch(valor.toLowerCase())
                            {
                                case "izquierda": 
                                    panel.setAlignmentX(LEFT_ALIGNMENT);
                                    break;
                                case "derecha": 
                                    panel.setAlignmentX(RIGHT_ALIGNMENT);
                                    break;
                                case "centrado": 
                                    panel.setAlignmentX(CENTER_ALIGNMENT);
                                    break;                                                
                            }
                            break;// Fin caso alineado                                    
                        case "texto":
                            valor ="";
                            if(estilo.getValor() instanceof String)
                            {
                                valor = (String)estilo.getValor();
                                //panel.setText(valor);
                            }                                    
                            break;                                    
                        case "letra":
                            valor ="";
                            if(estilo.getValor() instanceof String){ valor = (String)estilo.getValor(); valor= quitarComillas(valor);}                                                                   
                            try 
                            {
                                Font fuente = panel.getFont();                                                                                
                                panel.setFont(new Font(valor, fuente.getStyle(), fuente.getSize()));   
                            } 
                            catch (Exception e)
                            {
                            }                               
                            break;  // Fin caso letra
                        case "tamtex":
                            Double tamTex = 0.00;
                            if(estilo.getValor() instanceof Double){ tamTex = (Double)estilo.getValor();}                                                                   
                            try 
                            {
                                Font fuente = panel.getFont();  
                                if(tamTex==0){tamTex = (double)fuente.getSize();}
                                int tamText = Integer.valueOf(tamTex.intValue());
                                panel.setFont(new Font(fuente.getName(), fuente.getStyle(), tamText));   
                            } 
                            catch (Exception e){}  
                            break; //Fin caso tamtex
                        case "visible":
                            valor ="";
                            Boolean visibilidad = true;
                            if(estilo.getValor() instanceof Boolean){ visibilidad = (Boolean)estilo.getValor();}   
                            panel.setVisible(visibilidad);
                            break;//Fin visible 
                        case "fondoelemento":
                            valor ="";
                            if(estilo.getValor() instanceof String)
                            {
                                valor = (String)estilo.getValor();
                                valor = quitarComillas(valor);
                                panel.setBackground(colorFuente(valor));
                                //valor = (String)estilo.getValor();
                                //panel.setColorFuente(colorFuente(valor));
                            }
                            break;//Fin colortext  

                        case "borde":
                            valor = "";
                            if(estilo.getValor() instanceof ArrayList)
                            {
                                ArrayList arreglo = (ArrayList)estilo.getValor();
                                String color ="";
                                Boolean borde = true;
                                int grosor = 10;

                                for(Object item : arreglo )
                                {
                                    if(item instanceof String)
                                    {
                                        color = quitarComillas((String)item);
                                    }
                                    if(item instanceof Boolean)
                                    {                                                                                                                                                        
                                         borde = (Boolean)item;                                                                                                       
                                    }
                                    if(item instanceof Double)
                                    {
                                        Double auxiliar = (Double)item;
                                        grosor = auxiliar.intValue();
                                    }
                                }                                            
                                if(!color.equals(""))
                                {
                                    panel.setBorder(new LineBorder(colorFuente(color),grosor, borde));
                                }                                            
                            }
                            break; // Fin caso borde   
                        case "opaque":
                            valor ="";
                            Boolean opacacidad = true;
                            if(estilo.getValor() instanceof Boolean){ opacacidad = (Boolean)estilo.getValor();}   
                            panel.setOpaque(!opacacidad);
                            break;//Fin Opacacidad      
                        case "colortexto":                                        
                            valor ="";
                            if(estilo.getValor() instanceof String)
                            {
                                valor = (String)estilo.getValor();
                                //panel.setColorFuente(colorFuente(valor));
                                panel.setForeground(colorFuente(valor));
                            }
                            break;//Fin colortext                                          
                    }// Fin switch                                                                                                    
                } // Fin if instancia estilo
            }//Fin for
        }//Fin if !=null

        
    }    
    public void cambiosBoton(Boton boton ,Source.CCSS.Ejecucion.nodoLista nodoEstilo )
    {
        if(nodoEstilo!=null)
        {
            for(Object estiloElemento: nodoEstilo.getAtributos())
            {
                if(estiloElemento instanceof ArrayList)
                { 
                    ArrayList arreglo = (ArrayList)estiloElemento;
                    for(Object element: arreglo)
                    {
                        if(element instanceof Source.CCSS.AST.nodo)
                        {
                            Source.CCSS.AST.nodo elementArray = (Source.CCSS.AST.nodo)element;
                            switch(quitarComillas(elementArray.texto).toLowerCase())
                            {
                                case "minuscula":                                                
                                        boton.setText(boton.getText().toLowerCase());                                                    
                                    break;
                                case "mayuscula": 
                                        boton.setText(boton.getText().toUpperCase());                                                                                                        
                                    break;
                                case "negrilla":
                                    if(boton.getFont().getStyle()==2)
                                    {
                                        boton.setFont(new Font(boton.getFont().getName(),3,boton.getFont().getSize()));
                                    }
                                    else
                                    {
                                        boton.setFont(new Font(boton.getFont().getName(),1,boton.getFont().getSize()));
                                    }
                                    break;
                                case "cursiva":
                                    if(boton.getFont().getSize()==1)
                                    {
                                        boton.setFont(new Font(boton.getFont().getName(),3,boton.getFont().getSize()));
                                    }
                                    else
                                    {
                                        boton.setFont(new Font(boton.getFont().getName(),2,boton.getFont().getSize()));
                                    }
                                    break;
                                case "capital-t":
                                    String[] palabras = boton.getText().split(" ");
                                    String cadena = "";
                                    if(palabras.length>0)
                                    {
                                        for(String palabra: palabras)
                                        {
                                            if(palabra.length()>2)
                                            {
                                                palabra = palabra.substring(0,1).toUpperCase() + palabra.substring(1,palabra.length()) + " ";                                                       
                                                cadena = cadena + palabra;                                                            
                                            }
                                        }
                                    }
                                    boton.setText(cadena);
                                    break;
                            }//Fin switch formato
                        }// Fin verificacion de tipo Source.CCSS. nodo                                
                    }// Fin for de array
                }// Fin verificacion tipo arrayList 
                if(estiloElemento instanceof Source.CCSS.Ejecucion.tipoEstilo)
                {
                    Source.CCSS.Ejecucion.tipoEstilo estilo = (Source.CCSS.Ejecucion.tipoEstilo)estiloElemento;
                    switch(estilo.getNombre().toLowerCase())
                    {
                        case "alineado":
                            String valor ="";
                            if(estilo.getValor() instanceof String){ valor = (String)estilo.getValor();}
                            switch(valor.toLowerCase())
                            {
                                case "izquierda": 
                                    boton.setAlignmentX(LEFT_ALIGNMENT);
                                    break;
                                case "derecha": 
                                    boton.setAlignmentX(RIGHT_ALIGNMENT);
                                    break;
                                case "centrado": 
                                    boton.setAlignmentX(CENTER_ALIGNMENT);
                                    break;                                                
                            }
                            break;// Fin caso alineado                                    
                        case "texto":
                            valor ="";
                            if(estilo.getValor() instanceof String)
                            {
                                valor = (String)estilo.getValor();
                                boton.setText(valor);
                            }                                    
                            break;                                    
                        case "letra":
                            valor ="";
                            if(estilo.getValor() instanceof String){ valor = (String)estilo.getValor(); valor= quitarComillas(valor);}                                                                   
                            try 
                            {
                                Font fuente = boton.getFont();                                                                                
                                boton.setFont(new Font(valor, fuente.getStyle(), fuente.getSize()));   
                            } 
                            catch (Exception e)
                            {
                            }                               
                            break;  // Fin caso letra
                        case "tamtex":
                            Double tamTex = 0.00;
                            if(estilo.getValor() instanceof Double){ tamTex = (Double)estilo.getValor();}                                                                   
                            try 
                            {
                                Font fuente = boton.getFont();  
                                if(tamTex==0){tamTex = (double)fuente.getSize();}
                                int tamText = Integer.valueOf(tamTex.intValue());
                                boton.setFont(new Font(fuente.getName(), fuente.getStyle(), tamText));   
                            } 
                            catch (Exception e){}  
                            break; //Fin caso tamtex
                        case "visible":
                            valor ="";
                            Boolean visibilidad = true;
                            if(estilo.getValor() instanceof Boolean){ visibilidad = (Boolean)estilo.getValor();}   
                            boton.setVisible(visibilidad);
                            break;//Fin visible 
                        case "fondoelemento":
                            valor ="";
                            if(estilo.getValor() instanceof String)
                            {
                                valor = (String)estilo.getValor();
                                valor = quitarComillas(valor);
                                boton.setBackground(colorFuente(valor));
                                //valor = (String)estilo.getValor();
                                //panel.setColorFuente(colorFuente(valor));
                            }
                            break;//Fin colortext  

                        case "borde":
                            valor = "";
                            if(estilo.getValor() instanceof ArrayList)
                            {
                                ArrayList arreglo = (ArrayList)estilo.getValor();
                                String color ="";
                                Boolean borde = true;
                                int grosor = 10;

                                for(Object item : arreglo )
                                {
                                    if(item instanceof String)
                                    {
                                        color = quitarComillas((String)item);
                                    }
                                    if(item instanceof Boolean)
                                    {                                                                                                                                                        
                                         borde = (Boolean)item;                                                                                                       
                                    }
                                    if(item instanceof Double)
                                    {
                                        Double auxiliar = (Double)item;
                                        grosor = auxiliar.intValue();
                                    }
                                }                                            
                                if(!color.equals(""))
                                {
                                    boton.setBorder(new LineBorder(colorFuente(color),grosor, borde));
                                }                                            
                            }
                            break; // Fin caso borde   
                        case "opaque":
                            valor ="";
                            Boolean opacacidad = true;
                            if(estilo.getValor() instanceof Boolean){ opacacidad = (Boolean)estilo.getValor();}   
                            boton.setOpaque(!opacacidad);
                            break;//Fin Opacacidad      
                        case "colortexto":                                        
                            valor ="";
                            if(estilo.getValor() instanceof String)
                            {
                                valor = (String)estilo.getValor();
                                //boton.setColorFuente(colorFuente(valor));
                                boton.setForeground(colorFuente(valor));
                            }
                            break;//Fin colortext                                          
                    }// Fin switch                                                                                                    
                } // Fin if instancia estilo
            }//Fin for
        }//Fin if !=null

        
    }
    
    
    public void aplicarEstiloGrupo(Elemento elemento, Object container)
    {   
        if(container instanceof Panel)
        {
            Panel contenedor = (Panel)container;                        
            //f_b_redireccion
            switch(elemento.getTipo())
            {                        
                case "panel": // ----------------------------------------------------------------PANEL----------------------------------------------------------------------------
                    Panel panel = (Panel)elemento.getValor();
                    Source.CCSS.Ejecucion.nodoLista nodoEstilo = buscarEstilo(panel.getGrupo(),null);               

                    /*Aplicamos los estilos*/                                       
                    if(nodoEstilo!=null)
                    {
                        for(Object estiloElemento: nodoEstilo.getAtributos())
                        {
                            if(estiloElemento instanceof ArrayList)
                            { 
                                ArrayList arreglo = (ArrayList)estiloElemento;
                                for(Object element: arreglo)
                                {
                                    if(element instanceof Source.CCSS.nodo)
                                    {
                                        Source.CCSS.nodo elementArray = (Source.CCSS.nodo)element;
                                        switch(quitarComillas(elementArray.texto).toLowerCase())
                                        {
                                            case "minuscula":
                                                    panel.setEstilo("minuscula");
                                                break;
                                            case "mayuscula": 
                                                    panel.setEstilo("mayuscula");
                                                break;
                                            case "negrilla":
                                                if(panel.getFuente().getStyle()==2)
                                                {
                                                    panel.setFuente(new Font(panel.getFuente().getName(),3,panel.getFuente().getSize()));
                                                }
                                                else
                                                {
                                                    panel.setFuente(new Font(panel.getFuente().getName(),1,panel.getFuente().getSize()));
                                                }
                                                break;
                                            case "cursiva":
                                                if(panel.getFuente().getSize()==1)
                                                {
                                                    panel.setFuente(new Font(panel.getFuente().getName(),3,panel.getFuente().getSize()));
                                                }
                                                else
                                                {
                                                    panel.setFuente(new Font(panel.getFuente().getName(),2,panel.getFuente().getSize()));
                                                }
                                                break;
                                            case "capital-t":
                                                panel.setEstilo("capital-t");
                                                break;
                                        }//Fin switch formato
                                    }// Fin verificacion de tipo Source.CCSS. nodo                                
                                }// Fin for de array
                            }// Fin verificacion tipo arrayList                        
                            if(estiloElemento instanceof Source.CCSS.Ejecucion.tipoEstilo)
                            {
                                Source.CCSS.Ejecucion.tipoEstilo estilo = (Source.CCSS.Ejecucion.tipoEstilo)estiloElemento;
                                switch(estilo.getNombre().toLowerCase())
                                {
                                    case "alineado":
                                        String valor ="";
                                        if(estilo.getValor() instanceof String){ valor = (String)estilo.getValor();}
                                        switch(valor.toLowerCase())
                                        {
                                            case "izquierda":                                        
                                                break;
                                        }
                                        break;// Fin caso alineado                                    
                                    case "texto":
                                        valor ="";
                                        if(estilo.getValor() instanceof String)
                                        {
                                            valor = (String)estilo.getValor();
                                            panel.setTexto(quitarComillas(valor));
                                        }                                    
                                        break; 
                                    case "letra":
                                        valor ="";
                                        if(estilo.getValor() instanceof String){ valor = (String)estilo.getValor(); valor= quitarComillas(valor);}                                                                   
                                        try 
                                        {
                                            Font fuente = panel.getFont();                                                                                
                                            panel.setFont(new Font(valor, fuente.getStyle(), fuente.getSize()));   
                                        } 
                                        catch (Exception e)
                                        {
                                        }                               
                                        break;  // Fin caso letra   
                                    case "tamtex":
                                        Double tamTex = 0.00;
                                        if(estilo.getValor() instanceof Double){ tamTex = (Double)estilo.getValor();}                                                                   
                                        try 
                                        {
                                            Font fuente = panel.getFont();  
                                            if(tamTex==0){tamTex = (double)fuente.getSize();}
                                            int tamText = tamTex.intValue();
                                            panel.setFont(new Font(fuente.getName(), fuente.getStyle(), tamText));   
                                        } 
                                        catch (Exception e){}  
                                        break; //Fin caso tamtex  
                                    case "visible":
                                        valor ="";
                                        Boolean visibilidad = true;
                                        if(estilo.getValor() instanceof Boolean){ visibilidad = (Boolean)estilo.getValor();}   
                                        panel.setVisible(visibilidad);
                                        break;//Fin visible   
                                    case "colortexto":
                                        valor ="";
                                        if(estilo.getValor() instanceof String)
                                        {
                                            valor = (String)estilo.getValor();
                                            panel.setColorFuente(colorFuente(valor));
                                        }
                                        break;//Fin colortexto    
                                    case "fondoelemento":
                                        valor ="";
                                        if(estilo.getValor() instanceof String)
                                        {
                                            valor = (String)estilo.getValor();
                                            valor = quitarComillas(valor);
                                            panel.setBackground(colorFuente(valor));
                                            //valor = (String)estilo.getValor();
                                            //panel.setColorFuente(colorFuente(valor));
                                        }
                                        break;//Fin colortext 
                                    case "borde":
                                        valor = "";
                                        if(estilo.getValor() instanceof ArrayList)
                                        {
                                            ArrayList arreglo = (ArrayList)estilo.getValor();
                                            String color ="";
                                            Boolean borde = true;
                                            int grosor = 10;
                                            
                                            for(Object item : arreglo )
                                            {
                                                if(item instanceof String)
                                                {
                                                    color = quitarComillas((String)item);
                                                }
                                                if(item instanceof Boolean)
                                                {                                                                                                                                                        
                                                    borde = (boolean)item;
                                                }
                                                if(item instanceof Double)
                                                {
                                                    Double auxiliar = (Double)item;
                                                    grosor = auxiliar.intValue();
                                                }
                                            }
                                            
                                            if(!color.equals(""))
                                            {
                                                panel.setBorder(new LineBorder(colorFuente(color),grosor, borde));
                                            }                                            
                                        }                                        
                                        break; // Fin caso borde   
                                    case "opaque":
                                        valor ="";
                                        Boolean opacacidad = true;
                                        if(estilo.getValor() instanceof Boolean){ opacacidad = (Boolean)estilo.getValor();}   
                                        panel.setOpaque(opacacidad);
                                        break;//Fin Opacacidad   
                                    case "autoredimension":
                                        if(estilo.getValor() instanceof ArrayList)
                                        {
                                            ArrayList arreglo = (ArrayList)estilo.getValor();
                                            Object valoRedimension = arreglo.get(0);
                                            Object area =  arreglo.get(1);
                                            int alto = panel.getAlto();
                                            int ancho = panel.getAncho(); 
                                            panel.setAlto(0);
                                            panel.setAncho(0);
                                            if(area instanceof String)
                                            {                                                
                                                if(valoRedimension instanceof Boolean)
                                                {
                                                    if((boolean)valoRedimension)
                                                    {
                                                        calcularTamaño(panel);                                                                                                                 
                                                        switch(quitarComillas((String)area).toLowerCase())
                                                        {
                                                            case "horizontal":
                                                                panel.setAlto(alto);
                                                                panel.setPreferredSize(new java.awt.Dimension(panel.getAncho(),panel.getAlto()));
                                                                break;
                                                            case "vertical":  
                                                                panel.setAncho(ancho);
                                                                panel.setPreferredSize(new java.awt.Dimension(panel.getAncho(),panel.getAlto()));                                                                
                                                                break;
                                                        }                                                        
                                                    }
                                                }                                                
                                            }                                              
                                        }
                                        break;//Fin Opacacidad                                                                                
                                }// Fin switch                                                                                                    
                            } // Fin if instancia estilo
                        }//Fin for
                    }//Fin if !=null
                    break;// ---------------------------------------------------------------FIN PANEL------------------------------------------------------------------- 
                    //----------------------------------------------------------------------AREA TEXTO------------------------------------------------------------------
                    
                    
                    
                    //---------------------------------------------------------------------FIN AREA TEXTO---------------------------------------------------------------                                                                                                                                                                                    
                case "imagen": // ----------------------------------------------------------Imagen----------------------------------------------------------------------
                    Imagen imagen = (Imagen)elemento.getValor();
                    nodoEstilo = buscarEstilo(imagen.getGrupo(),null);               
                    /*Aplicamos los estilos*/                                       
                    if(nodoEstilo!=null)
                    {
                        for(Object estiloElemento: nodoEstilo.getAtributos())
                        {    
                            
                            if(estiloElemento instanceof ArrayList)
                            { 
                                ArrayList arreglo = (ArrayList)estiloElemento;
                                for(Object element: arreglo)
                                {
                                    if(element instanceof Source.CCSS.nodo)
                                    {
                                        Source.CCSS.nodo elementArray = (Source.CCSS.nodo)element;
                                        switch(quitarComillas(elementArray.texto).toLowerCase())
                                        {
                                            case "minuscula":
                                                    //panel.setEstilo("minuscula");
                                                break;
                                            case "mayuscula": 
                                                    //panel.setEstilo("mayuscula");
                                                break;
                                            case "negrilla":
                                                /*if(panel.getFuente().getStyle()==2)
                                                {
                                                    panel.setFuente(new Font(panel.getFuente().getName(),3,panel.getFuente().getSize()));
                                                }
                                                else
                                                {
                                                    panel.setFuente(new Font(panel.getFuente().getName(),1,panel.getFuente().getSize()));
                                                }
                                                break;
                                            case "cursiva":
                                                if(panel.getFuente().getSize()==1)
                                                {
                                                    panel.setFuente(new Font(panel.getFuente().getName(),3,panel.getFuente().getSize()));
                                                }
                                                else
                                                {
                                                    panel.setFuente(new Font(panel.getFuente().getName(),2,panel.getFuente().getSize()));
                                                }*/
                                                break;
                                            case "capital-t":
                                                //panel.setEstilo("capital-t");
                                                break;
                                        }//Fin switch formato
                                    }// Fin verificacion de tipo Source.CCSS. nodo                                
                                }// Fin for de array
                            }// Fin verificacion tipo arrayList                             
                            
                            if(estiloElemento instanceof Source.CCSS.Ejecucion.tipoEstilo)
                            {
                                Source.CCSS.Ejecucion.tipoEstilo estilo = (Source.CCSS.Ejecucion.tipoEstilo)estiloElemento;
                                switch(estilo.getNombre().toLowerCase())
                                {
                                    case "alineado":
                                        String valor ="";
                                        if(estilo.getValor() instanceof String){ valor = (String)estilo.getValor();}
                                        switch(valor.toLowerCase())
                                        {
                                            case "izquierda":                                        
                                                break;
                                        }
                                        break;// Fin caso alineado                                    
                                    case "texto":
                                        valor ="";
                                        if(estilo.getValor() instanceof String)
                                        {
                                            valor = (String)estilo.getValor();
                                            //imagen.setTexto(quitarComillas(valor));
                                        }                                    
                                        break; 
                                    case "letra":
                                        valor ="";
                                        if(estilo.getValor() instanceof String){ valor = (String)estilo.getValor(); valor= quitarComillas(valor);}                                                                   
                                        try 
                                        {
                                            Font fuente = contenedor.getFont();                                                                                
                                            imagen.setFont(new Font(valor, fuente.getStyle(), fuente.getSize()));   
                                        } 
                                        catch (Exception e)
                                        {
                                        }                               
                                        break;  // Fin caso letra   
                                    case "tamtex":
                                        Double tamTex = 0.00;
                                        if(estilo.getValor() instanceof Double){ tamTex = (Double)estilo.getValor();}                                                                   
                                        try 
                                        {
                                            Font fuente = contenedor.getFont();  
                                            if(tamTex==0){tamTex = (double)fuente.getSize();}
                                            int tamText = tamTex.intValue();
                                            imagen.setFont(new Font(fuente.getName(), fuente.getStyle(), tamText));   
                                        } 
                                        catch (Exception e){}  
                                        break; //Fin caso tamtex  
                                    case "visible":
                                        valor ="";
                                        Boolean visibilidad = true;
                                        if(estilo.getValor() instanceof Boolean){ visibilidad = (Boolean)estilo.getValor();}   
                                        imagen.setVisible(visibilidad);
                                        break;//Fin visible   
                                    case "colortext":
                                        valor ="";
                                        if(estilo.getValor() instanceof String)
                                        {
                                            valor = (String)estilo.getValor();
                                            imagen.setForeground(colorFuente(valor));
                                        }
                                        break;//Fin colortext
                                    case "fondo":
                                        valor = "";
                                        if(estilo.getValor() instanceof String)
                                        {
                                            valor = (String)estilo.getValor();
                                            imagen.setBackground(colorFuente(valor));
                                        }
                                        break; // Fin fondo (color de fondo)
                                    case "borde":
                                        valor = "";
                                        if(estilo.getValor() instanceof ArrayList)
                                        {
                                            ArrayList arreglo = (ArrayList)estilo.getValor();
                                            String color ="";
                                            Boolean borde = true;
                                            int grosor = 10;
                                            
                                            for(Object item : arreglo )
                                            {
                                                if(item instanceof String)
                                                {
                                                    color = quitarComillas((String)item);
                                                }
                                                if(item instanceof Boolean)
                                                {                                                                                                                                                        
                                                     borde = (Boolean)item;                                                                                                       
                                                }
                                                if(item instanceof Double)
                                                {
                                                    Double auxiliar = (Double)item;
                                                    grosor = auxiliar.intValue();
                                                }
                                            }                                            
                                            if(!color.equals(""))
                                            {
                                                imagen.setBorder(new LineBorder(colorFuente(color),grosor, borde));
                                            }                                            
                                        }
                                        break; // Fin caso borde  
                                    case "opaque":
                                        valor ="";
                                        Boolean opacacidad = true;
                                        if(estilo.getValor() instanceof Boolean){ opacacidad = (Boolean)estilo.getValor();}   
                                        imagen.setOpaque(opacacidad);
                                        break;//Fin Opacacidad                                       
                                }// Fin switch                                                                                                    
                            } // Fin if instancia estilo
                        }//Fin for
                    }//Fin if !=null
                    break;// Fin caso --------------------------------------------------IMAGEN-----------------------------------------------------------------                 
                case "boton"://----------------------------------------------------------BOTON-----------------------------------------------------------------
                    Boton boton = (Boton)elemento.getValor();
                    nodoEstilo = buscarEstilo(boton.getGrupo(),null);            
                    /*Aplicamos los estilos*/
                    //Object estiloElemento = nodoEstilo.getAtributos().get(aum);
                    if(nodoEstilo!=null)
                    {
                        for(Object estiloElemento: nodoEstilo.getAtributos())
                        {
                            if(estiloElemento instanceof ArrayList)
                            { 
                                ArrayList arreglo = (ArrayList)estiloElemento;
                                for(Object element: arreglo)
                                {
                                    if(element instanceof Source.CCSS.AST.nodo)
                                    {
                                        Source.CCSS.AST.nodo elementArray = (Source.CCSS.AST.nodo)element;
                                        switch(quitarComillas(elementArray.texto).toLowerCase())
                                        {
                                            case "minuscula":                                                
                                                    boton.setText(boton.getText().toLowerCase());                                                    
                                                break;
                                            case "mayuscula": 
                                                    boton.setText(boton.getText().toUpperCase());                                                                                                        
                                                break;
                                            case "negrilla":
                                                if(boton.getFont().getStyle()==2)
                                                {
                                                    boton.setFont(new Font(boton.getFont().getName(),3,boton.getFont().getSize()));
                                                }
                                                else
                                                {
                                                    boton.setFont(new Font(boton.getFont().getName(),1,boton.getFont().getSize()));
                                                }
                                                break;
                                            case "cursiva":
                                                if(boton.getFont().getSize()==1)
                                                {
                                                    boton.setFont(new Font(boton.getFont().getName(),3,boton.getFont().getSize()));
                                                }
                                                else
                                                {
                                                    boton.setFont(new Font(boton.getFont().getName(),2,boton.getFont().getSize()));
                                                }
                                                break;
                                            case "capital-t":
                                                String[] palabras = boton.getText().split(" ");
                                                String cadena = "";
                                                if(palabras.length>0)
                                                {
                                                    for(String palabra: palabras)
                                                    {
                                                        if(palabra.length()>2)
                                                        {
                                                            palabra = palabra.substring(0,1).toUpperCase() + palabra.substring(1,palabra.length()) + " ";                                                       
                                                            cadena = cadena + palabra;                                                            
                                                        }
                                                    }
                                                }
                                                boton.setText(cadena);
                                                break;
                                        }//Fin switch formato
                                    }// Fin verificacion de tipo Source.CCSS. nodo                                
                                }// Fin for de array
                            }// Fin verificacion tipo arrayList 
                            if(estiloElemento instanceof Source.CCSS.Ejecucion.tipoEstilo)
                            {
                                Source.CCSS.Ejecucion.tipoEstilo estilo = (Source.CCSS.Ejecucion.tipoEstilo)estiloElemento;
                                switch(estilo.getNombre().toLowerCase())
                                {
                                    case "alineado":
                                        String valor ="";
                                        if(estilo.getValor() instanceof String){ valor = (String)estilo.getValor();}
                                        switch(valor.toLowerCase())
                                        {
                                            case "izquierda": 
                                                boton.setAlignmentX(LEFT_ALIGNMENT);
                                                break;
                                            case "derecha": 
                                                boton.setAlignmentX(RIGHT_ALIGNMENT);
                                                break;
                                            case "centrado": 
                                                boton.setAlignmentX(CENTER_ALIGNMENT);
                                                break;                                                
                                        }
                                        break;// Fin caso alineado                                    
                                    case "texto":
                                        valor ="";
                                        if(estilo.getValor() instanceof String)
                                        {
                                            valor = (String)estilo.getValor();
                                            boton.setText(valor);
                                        }                                    
                                        break;                                    
                                    case "letra":
                                        valor ="";
                                        if(estilo.getValor() instanceof String){ valor = (String)estilo.getValor(); valor= quitarComillas(valor);}                                                                   
                                        try 
                                        {
                                            Font fuente = boton.getFont();                                                                                
                                            boton.setFont(new Font(valor, fuente.getStyle(), fuente.getSize()));   
                                        } 
                                        catch (Exception e)
                                        {
                                        }                               
                                        break;  // Fin caso letra
                                    case "tamtex":
                                        Double tamTex = 0.00;
                                        if(estilo.getValor() instanceof Double){ tamTex = (Double)estilo.getValor();}                                                                   
                                        try 
                                        {
                                            Font fuente = boton.getFont();  
                                            if(tamTex==0){tamTex = (double)fuente.getSize();}
                                            int tamText = Integer.valueOf(tamTex.intValue());
                                            boton.setFont(new Font(fuente.getName(), fuente.getStyle(), tamText));   
                                        } 
                                        catch (Exception e){}  
                                        break; //Fin caso tamtex
                                    case "visible":
                                        valor ="";
                                        Boolean visibilidad = true;
                                        if(estilo.getValor() instanceof Boolean){ visibilidad = (Boolean)estilo.getValor();}   
                                        boton.setVisible(visibilidad);
                                        break;//Fin visible 
                                    case "fondoelemento":
                                        valor ="";
                                        if(estilo.getValor() instanceof String)
                                        {
                                            valor = (String)estilo.getValor();
                                            valor = quitarComillas(valor);
                                            boton.setBackground(colorFuente(valor));
                                            //valor = (String)estilo.getValor();
                                            //panel.setColorFuente(colorFuente(valor));
                                        }
                                        break;//Fin colortext  
                                        
                                    case "borde":
                                        valor = "";
                                        if(estilo.getValor() instanceof ArrayList)
                                        {
                                            ArrayList arreglo = (ArrayList)estilo.getValor();
                                            String color ="";
                                            Boolean borde = true;
                                            int grosor = 10;
                                            
                                            for(Object item : arreglo )
                                            {
                                                if(item instanceof String)
                                                {
                                                    color = quitarComillas((String)item);
                                                }
                                                if(item instanceof Boolean)
                                                {                                                                                                                                                        
                                                     borde = (Boolean)item;                                                                                                       
                                                }
                                                if(item instanceof Double)
                                                {
                                                    Double auxiliar = (Double)item;
                                                    grosor = auxiliar.intValue();
                                                }
                                            }                                            
                                            if(!color.equals(""))
                                            {
                                                boton.setBorder(new LineBorder(colorFuente(color),grosor, borde));
                                            }                                            
                                        }
                                        break; // Fin caso borde   
                                    case "opaque":
                                        valor ="";
                                        Boolean opacacidad = true;
                                        if(estilo.getValor() instanceof Boolean){ opacacidad = (Boolean)estilo.getValor();}   
                                        boton.setOpaque(!opacacidad);
                                        break;//Fin Opacacidad      
                                    case "colortexto":                                        
                                        valor ="";
                                        if(estilo.getValor() instanceof String)
                                        {
                                            valor = (String)estilo.getValor();
                                            //boton.setColorFuente(colorFuente(valor));
                                            boton.setForeground(colorFuente(valor));
                                        }
                                        break;//Fin colortext                                          
                                }// Fin switch                                                                                                    
                            } // Fin if instancia estilo
                        }//Fin for
                    }//Fin if !=null
                    break;// Fin caso botón------------------------------------

                    
                    
                case "caja"://----------------------------------------------------------caja-----------------------------------------------------------------
                    Caja caja = (Caja)elemento.getValor();
                    nodoEstilo = buscarEstilo(caja.getGrupo(),null);            
                    /*Aplicamos los estilos*/
                    //Object estiloElemento = nodoEstilo.getAtributos().get(aum);
                    if(nodoEstilo!=null)
                    {
                        for(Object estiloElemento: nodoEstilo.getAtributos())
                        {
                            if(estiloElemento instanceof ArrayList)
                            { 
                                ArrayList arreglo = (ArrayList)estiloElemento;
                                for(Object element: arreglo)
                                {
                                    if(element instanceof Source.CCSS.AST.nodo)
                                    {
                                        Source.CCSS.AST.nodo elementArray = (Source.CCSS.AST.nodo)element;
                                        switch(quitarComillas(elementArray.texto).toLowerCase())
                                        {
                                            case "minuscula":                                                
                                                    caja.setText(caja.getText().toLowerCase());                                                    
                                                break;
                                            case "mayuscula": 
                                                    caja.setText(caja.getText().toUpperCase());                                                                                                        
                                                break;
                                            case "negrilla":
                                                if(caja.getFont().getStyle()==2)
                                                {
                                                    caja.setFont(new Font(caja.getFont().getName(),3,caja.getFont().getSize()));
                                                }
                                                else
                                                {
                                                    caja.setFont(new Font(caja.getFont().getName(),1,caja.getFont().getSize()));
                                                }
                                                break;
                                            case "cursiva":
                                                if(caja.getFont().getSize()==1)
                                                {
                                                    caja.setFont(new Font(caja.getFont().getName(),3,caja.getFont().getSize()));
                                                }
                                                else
                                                {
                                                    caja.setFont(new Font(caja.getFont().getName(),2,caja.getFont().getSize()));
                                                }
                                                break;
                                            case "capital-t":
                                                String[] palabras = caja.getText().split(" ");
                                                String cadena = "";
                                                if(palabras.length>0)
                                                {
                                                    for(String palabra: palabras)
                                                    {
                                                        if(palabra.length()>2)
                                                        {
                                                            palabra = palabra.substring(0,1).toUpperCase() + palabra.substring(1,palabra.length()) + " ";                                                       
                                                            cadena = cadena + palabra;                                                            
                                                        }
                                                    }
                                                }
                                                caja.setText(cadena);
                                                break;
                                        }//Fin switch formato
                                    }// Fin verificacion de tipo Source.CCSS. nodo                                
                                }// Fin for de array
                            }// Fin verificacion tipo arrayList 
                            if(estiloElemento instanceof Source.CCSS.Ejecucion.tipoEstilo)
                            {
                                Source.CCSS.Ejecucion.tipoEstilo estilo = (Source.CCSS.Ejecucion.tipoEstilo)estiloElemento;
                                switch(estilo.getNombre().toLowerCase())
                                {
                                    case "alineado":
                                        String valor ="";
                                        if(estilo.getValor() instanceof String){ valor = (String)estilo.getValor();}
                                        switch(valor.toLowerCase())
                                        {
                                            case "izquierda": 
                                                caja.setAlignmentX(LEFT_ALIGNMENT);
                                                break;
                                            case "derecha": 
                                                caja.setAlignmentX(RIGHT_ALIGNMENT);
                                                break;
                                            case "centrado": 
                                                caja.setAlignmentX(CENTER_ALIGNMENT);
                                                break;                                                
                                        }
                                        break;// Fin caso alineado                                    
                                    case "texto":
                                        valor ="";
                                        if(estilo.getValor() instanceof String)
                                        {
                                            valor = (String)estilo.getValor();
                                            caja.setText(valor);
                                        }                                    
                                        break;                                    
                                    case "letra":
                                        valor ="";
                                        if(estilo.getValor() instanceof String){ valor = (String)estilo.getValor(); valor= quitarComillas(valor);}                                                                   
                                        try 
                                        {
                                            Font fuente = caja.getFont();                                                                                
                                            caja.setFont(new Font(valor, fuente.getStyle(), fuente.getSize()));   
                                        } 
                                        catch (Exception e)
                                        {
                                        }                               
                                        break;  // Fin caso letra
                                    case "tamtex":
                                        Double tamTex = 0.00;
                                        if(estilo.getValor() instanceof Double){ tamTex = (Double)estilo.getValor();}                                                                   
                                        try 
                                        {
                                            Font fuente = caja.getFont();  
                                            if(tamTex==0){tamTex = (double)fuente.getSize();}
                                            int tamText = Integer.valueOf(tamTex.intValue());
                                            caja.setFont(new Font(fuente.getName(), fuente.getStyle(), tamText));   
                                        } 
                                        catch (Exception e){}  
                                        break; //Fin caso tamtex
                                    case "visible":
                                        valor ="";
                                        Boolean visibilidad = true;
                                        if(estilo.getValor() instanceof Boolean){ visibilidad = (Boolean)estilo.getValor();}   
                                        caja.setVisible(visibilidad);
                                        break;//Fin visible 
                                    case "fondoelemento":
                                        valor ="";
                                        if(estilo.getValor() instanceof String)
                                        {
                                            valor = (String)estilo.getValor();
                                            valor = quitarComillas(valor);
                                            caja.setBackground(colorFuente(valor));
                                            //valor = (String)estilo.getValor();
                                            //panel.setColorFuente(colorFuente(valor));
                                        }
                                        break;//Fin colortext  
                                        
                                    case "borde":
                                        valor = "";
                                        if(estilo.getValor() instanceof ArrayList)
                                        {
                                            ArrayList arreglo = (ArrayList)estilo.getValor();
                                            String color ="";
                                            Boolean borde = true;
                                            int grosor = 10;
                                            
                                            for(Object item : arreglo )
                                            {
                                                if(item instanceof String)
                                                {
                                                    color = quitarComillas((String)item);
                                                }
                                                if(item instanceof Boolean)
                                                {                                                                                                                                                        
                                                     borde = (Boolean)item;                                                                                                       
                                                }
                                                if(item instanceof Double)
                                                {
                                                    Double auxiliar = (Double)item;
                                                    grosor = auxiliar.intValue();
                                                }
                                            }                                            
                                            if(!color.equals(""))
                                            {
                                                caja.setBorder(new LineBorder(colorFuente(color),grosor, borde));
                                            }                                            
                                        }
                                        break; // Fin caso borde   
                                    case "opaque":
                                        valor ="";
                                        Boolean opacacidad = true;
                                        if(estilo.getValor() instanceof Boolean){ opacacidad = (Boolean)estilo.getValor();}   
                                        caja.setOpaque(!opacacidad);
                                        break;//Fin Opacacidad      
                                    case "colortexto":                                        
                                        valor ="";
                                        if(estilo.getValor() instanceof String)
                                        {
                                            valor = (String)estilo.getValor();
                                            //caja.setColorFuente(colorFuente(valor));
                                            caja.setForeground(colorFuente(valor));
                                        }
                                        break;//Fin colortext                                          
                                }// Fin switch                                                                                                    
                            } // Fin if instancia estilo
                        }//Fin for
                    }//Fin if !=null
                    break;// Fin caso botón------------------------------------                    
                    
                case "area"://----------------------------------------------------------areatexto-----------------------------------------------------------------
                    areaTexto area = (areaTexto)elemento.getValor();
                    nodoEstilo = buscarEstilo(area.getGrupo(),null);            
                    /*Aplicamos los estilos*/
                    //Object estiloElemento = nodoEstilo.getAtributos().get(aum);
                    if(nodoEstilo!=null)
                    {
                        for(Object estiloElemento: nodoEstilo.getAtributos())
                        {
                            if(estiloElemento instanceof ArrayList)
                            { 
                                ArrayList arreglo = (ArrayList)estiloElemento;
                                for(Object element: arreglo)
                                {
                                    if(element instanceof Source.CCSS.AST.nodo)
                                    {
                                        Source.CCSS.AST.nodo elementArray = (Source.CCSS.AST.nodo)element;
                                        switch(quitarComillas(elementArray.texto).toLowerCase())
                                        {
                                            case "minuscula":                                                
                                                    area.setText(area.getText().toLowerCase());                                                    
                                                break;
                                            case "mayuscula": 
                                                    area.setText(area.getText().toUpperCase());                                                                                                        
                                                break;
                                            case "negrilla":
                                                if(area.getFont().getStyle()==2)
                                                {
                                                    area.setFont(new Font(area.getFont().getName(),3,area.getFont().getSize()));
                                                }
                                                else
                                                {
                                                    area.setFont(new Font(area.getFont().getName(),1,area.getFont().getSize()));
                                                }
                                                break;
                                            case "cursiva":
                                                if(area.getFont().getSize()==1)
                                                {
                                                    area.setFont(new Font(area.getFont().getName(),3,area.getFont().getSize()));
                                                }
                                                else
                                                {
                                                    area.setFont(new Font(area.getFont().getName(),2,area.getFont().getSize()));
                                                }
                                                break;
                                            case "capital-t":
                                                String[] palabras = area.getText().split(" ");
                                                String cadena = "";
                                                if(palabras.length>0)
                                                {
                                                    for(String palabra: palabras)
                                                    {
                                                        if(palabra.length()>2)
                                                        {
                                                            palabra = palabra.substring(0,1).toUpperCase() + palabra.substring(1,palabra.length()) + " ";                                                       
                                                            cadena = cadena + palabra;                                                            
                                                        }
                                                    }
                                                }
                                                area.setText(cadena);
                                                break;
                                        }//Fin switch formato
                                    }// Fin verificacion de tipo Source.CCSS. nodo                                
                                }// Fin for de array
                            }// Fin verificacion tipo arrayList 
                            if(estiloElemento instanceof Source.CCSS.Ejecucion.tipoEstilo)
                            {
                                Source.CCSS.Ejecucion.tipoEstilo estilo = (Source.CCSS.Ejecucion.tipoEstilo)estiloElemento;
                                switch(estilo.getNombre().toLowerCase())
                                {
                                    case "alineado":
                                        String valor ="";
                                        if(estilo.getValor() instanceof String){ valor = (String)estilo.getValor();}
                                        switch(valor.toLowerCase())
                                        {
                                            case "izquierda": 
                                                area.setAlignmentX(LEFT_ALIGNMENT);
                                                break;
                                            case "derecha": 
                                                area.setAlignmentX(RIGHT_ALIGNMENT);
                                                break;
                                            case "centrado": 
                                                area.setAlignmentX(CENTER_ALIGNMENT);
                                                break;                                                
                                        }
                                        break;// Fin caso alineado                                    
                                    case "texto":
                                        valor ="";
                                        if(estilo.getValor() instanceof String)
                                        {
                                            valor = (String)estilo.getValor();
                                            area.setText(valor);
                                        }                                    
                                        break;                                    
                                    case "letra":
                                        valor ="";
                                        if(estilo.getValor() instanceof String){ valor = (String)estilo.getValor(); valor= quitarComillas(valor);}                                                                   
                                        try 
                                        {
                                            Font fuente = area.getFont();                                                                                
                                            area.setFont(new Font(valor, fuente.getStyle(), fuente.getSize()));   
                                        } 
                                        catch (Exception e)
                                        {
                                        }                               
                                        break;  // Fin caso letra
                                    case "tamtex":
                                        Double tamTex = 0.00;
                                        if(estilo.getValor() instanceof Double){ tamTex = (Double)estilo.getValor();}                                                                   
                                        try 
                                        {
                                            Font fuente = area.getFont();  
                                            if(tamTex==0){tamTex = (double)fuente.getSize();}
                                            int tamText = Integer.valueOf(tamTex.intValue());
                                            area.setFont(new Font(fuente.getName(), fuente.getStyle(), tamText));   
                                        } 
                                        catch (Exception e){}  
                                        break; //Fin caso tamtex
                                    case "visible":
                                        valor ="";
                                        Boolean visibilidad = true;
                                        if(estilo.getValor() instanceof Boolean){ visibilidad = (Boolean)estilo.getValor();}   
                                        area.setVisible(visibilidad);
                                        break;//Fin visible 
                                    case "fondoelemento":
                                        valor ="";
                                        if(estilo.getValor() instanceof String)
                                        {
                                            valor = (String)estilo.getValor();
                                            valor = quitarComillas(valor);
                                            area.setBackground(colorFuente(valor));
                                            //valor = (String)estilo.getValor();
                                            //panel.setColorFuente(colorFuente(valor));
                                        }
                                        break;//Fin colortext  
                                        
                                    case "borde":
                                        valor = "";
                                        if(estilo.getValor() instanceof ArrayList)
                                        {
                                            ArrayList arreglo = (ArrayList)estilo.getValor();
                                            String color ="";
                                            Boolean borde = true;
                                            int grosor = 10;
                                            
                                            for(Object item : arreglo )
                                            {
                                                if(item instanceof String)
                                                {
                                                    color = quitarComillas((String)item);
                                                }
                                                if(item instanceof Boolean)
                                                {                                                                                                                                                        
                                                     borde = (Boolean)item;                                                                                                       
                                                }
                                                if(item instanceof Double)
                                                {
                                                    Double auxiliar = (Double)item;
                                                    grosor = auxiliar.intValue();
                                                }
                                            }                                            
                                            if(!color.equals(""))
                                            {
                                                area.setBorder(new LineBorder(colorFuente(color),grosor, borde));
                                            }                                            
                                        }
                                        break; // Fin caso borde   
                                    case "opaque":
                                        valor ="";
                                        Boolean opacacidad = true;
                                        if(estilo.getValor() instanceof Boolean){ opacacidad = (Boolean)estilo.getValor();}   
                                        area.setOpaque(!opacacidad);
                                        break;//Fin Opacacidad      
                                    case "colortexto":                                        
                                        valor ="";
                                        if(estilo.getValor() instanceof String)
                                        {
                                            valor = (String)estilo.getValor();
                                            //texto.setColorFuente(colorFuente(valor));
                                            area.setForeground(colorFuente(valor));
                                        }
                                        break;//Fin colortext                                          
                                }// Fin switch                                                                                                    
                            } // Fin if instancia estilo
                        }//Fin for
                    }//Fin if !=null
                    break;// Fin caso areatexto------------------------------------                     
                    
                case "texto"://----------------------------------------------------------texto-----------------------------------------------------------------
                    Texto texto = (Texto)elemento.getValor();
                    nodoEstilo = buscarEstilo(texto.getGrupo(),null);            
                    /*Aplicamos los estilos*/
                    //Object estiloElemento = nodoEstilo.getAtributos().get(aum);
                    if(nodoEstilo!=null)
                    {
                        for(Object estiloElemento: nodoEstilo.getAtributos())
                        {
                            if(estiloElemento instanceof ArrayList)
                            { 
                                ArrayList arreglo = (ArrayList)estiloElemento;
                                for(Object element: arreglo)
                                {
                                    if(element instanceof Source.CCSS.AST.nodo)
                                    {
                                        Source.CCSS.AST.nodo elementArray = (Source.CCSS.AST.nodo)element;
                                        switch(quitarComillas(elementArray.texto).toLowerCase())
                                        {
                                            case "minuscula":                                                
                                                    texto.setText(texto.getText().toLowerCase());                                                    
                                                break;
                                            case "mayuscula": 
                                                    texto.setText(texto.getText().toUpperCase());                                                                                                        
                                                break;
                                            case "negrilla":
                                                if(texto.getFont().getStyle()==2)
                                                {
                                                    texto.setFont(new Font(texto.getFont().getName(),3,texto.getFont().getSize()));
                                                }
                                                else
                                                {
                                                    texto.setFont(new Font(texto.getFont().getName(),1,texto.getFont().getSize()));
                                                }
                                                break;
                                            case "cursiva":
                                                if(texto.getFont().getSize()==1)
                                                {
                                                    texto.setFont(new Font(texto.getFont().getName(),3,texto.getFont().getSize()));
                                                }
                                                else
                                                {
                                                    texto.setFont(new Font(texto.getFont().getName(),2,texto.getFont().getSize()));
                                                }
                                                break;
                                            case "capital-t":
                                                String[] palabras = texto.getText().split(" ");
                                                String cadena = "";
                                                if(palabras.length>0)
                                                {
                                                    for(String palabra: palabras)
                                                    {
                                                        if(palabra.length()>2)
                                                        {
                                                            palabra = palabra.substring(0,1).toUpperCase() + palabra.substring(1,palabra.length()) + " ";                                                       
                                                            cadena = cadena + palabra;                                                            
                                                        }
                                                    }
                                                }
                                                texto.setText(cadena);
                                                break;
                                        }//Fin switch formato
                                    }// Fin verificacion de tipo Source.CCSS. nodo                                
                                }// Fin for de array
                            }// Fin verificacion tipo arrayList 
                            if(estiloElemento instanceof Source.CCSS.Ejecucion.tipoEstilo)
                            {
                                Source.CCSS.Ejecucion.tipoEstilo estilo = (Source.CCSS.Ejecucion.tipoEstilo)estiloElemento;
                                switch(estilo.getNombre().toLowerCase())
                                {
                                    case "alineado":
                                        String valor ="";
                                        if(estilo.getValor() instanceof String){ valor = (String)estilo.getValor();}
                                        switch(valor.toLowerCase())
                                        {
                                            case "izquierda": 
                                                texto.setAlignmentX(LEFT_ALIGNMENT);
                                                break;
                                            case "derecha": 
                                                texto.setAlignmentX(RIGHT_ALIGNMENT);
                                                break;
                                            case "centrado": 
                                                texto.setAlignmentX(CENTER_ALIGNMENT);
                                                break;                                                
                                        }
                                        break;// Fin caso alineado                                    
                                    case "texto":
                                        valor ="";
                                        if(estilo.getValor() instanceof String)
                                        {
                                            valor = (String)estilo.getValor();
                                            texto.setText(valor);
                                        }                                    
                                        break;                                    
                                    case "letra":
                                        valor ="";
                                        if(estilo.getValor() instanceof String){ valor = (String)estilo.getValor(); valor= quitarComillas(valor);}                                                                   
                                        try 
                                        {
                                            Font fuente = texto.getFont();                                                                                
                                            texto.setFont(new Font(valor, fuente.getStyle(), fuente.getSize()));   
                                        } 
                                        catch (Exception e)
                                        {
                                        }                               
                                        break;  // Fin caso letra
                                    case "tamtex":
                                        Double tamTex = 0.00;
                                        if(estilo.getValor() instanceof Double){ tamTex = (Double)estilo.getValor();}                                                                   
                                        try 
                                        {
                                            Font fuente = texto.getFont();  
                                            if(tamTex==0){tamTex = (double)fuente.getSize();}
                                            int tamText = Integer.valueOf(tamTex.intValue());
                                            texto.setFont(new Font(fuente.getName(), fuente.getStyle(), tamText));   
                                        } 
                                        catch (Exception e){}  
                                        break; //Fin caso tamtex
                                    case "visible":
                                        valor ="";
                                        Boolean visibilidad = true;
                                        if(estilo.getValor() instanceof Boolean){ visibilidad = (Boolean)estilo.getValor();}   
                                        texto.setVisible(visibilidad);
                                        break;//Fin visible 
                                    case "fondoelemento":
                                        valor ="";
                                        if(estilo.getValor() instanceof String)
                                        {
                                            valor = (String)estilo.getValor();
                                            valor = quitarComillas(valor);
                                            texto.setBackground(colorFuente(valor));
                                            //valor = (String)estilo.getValor();
                                            //panel.setColorFuente(colorFuente(valor));
                                        }
                                        break;//Fin colortext  
                                        
                                    case "borde":
                                        valor = "";
                                        if(estilo.getValor() instanceof ArrayList)
                                        {
                                            ArrayList arreglo = (ArrayList)estilo.getValor();
                                            String color ="";
                                            Boolean borde = true;
                                            int grosor = 10;
                                            
                                            for(Object item : arreglo )
                                            {
                                                if(item instanceof String)
                                                {
                                                    color = quitarComillas((String)item);
                                                }
                                                if(item instanceof Boolean)
                                                {                                                                                                                                                        
                                                     borde = (Boolean)item;                                                                                                       
                                                }
                                                if(item instanceof Double)
                                                {
                                                    Double auxiliar = (Double)item;
                                                    grosor = auxiliar.intValue();
                                                }
                                            }                                            
                                            if(!color.equals(""))
                                            {
                                                texto.setBorder(new LineBorder(colorFuente(color),grosor, borde));
                                            }                                            
                                        }
                                        break; // Fin caso borde   
                                    case "opaque":
                                        valor ="";
                                        Boolean opacacidad = true;
                                        if(estilo.getValor() instanceof Boolean){ opacacidad = (Boolean)estilo.getValor();}   
                                        texto.setOpaque(!opacacidad);
                                        break;//Fin Opacacidad      
                                    case "colortexto":                                        
                                        valor ="";
                                        if(estilo.getValor() instanceof String)
                                        {
                                            valor = (String)estilo.getValor();
                                            //texto.setColorFuente(colorFuente(valor));
                                            texto.setForeground(colorFuente(valor));
                                        }
                                        break;//Fin colortext                                          
                                }// Fin switch                                                                                                    
                            } // Fin if instancia estilo
                        }//Fin for
                    }//Fin if !=null
                    break;// Fin caso botón------------------------------------                    

                case "enlace"://----------------------------------------------------------enlace-----------------------------------------------------------------
                    Enlace enlace = (Enlace)elemento.getValor();
                    nodoEstilo = buscarEstilo(enlace.getGrupo(),null);            
                    /*Aplicamos los estilos*/
                    //Object estiloElemento = nodoEstilo.getAtributos().get(aum);
                    if(nodoEstilo!=null)
                    {
                        for(Object estiloElemento: nodoEstilo.getAtributos())
                        {
                            if(estiloElemento instanceof ArrayList)
                            { 
                                ArrayList arreglo = (ArrayList)estiloElemento;
                                for(Object element: arreglo)
                                {
                                    if(element instanceof Source.CCSS.AST.nodo)
                                    {
                                        Source.CCSS.AST.nodo elementArray = (Source.CCSS.AST.nodo)element;
                                        switch(quitarComillas(elementArray.texto).toLowerCase())
                                        {
                                            case "minuscula":                                                
                                                    enlace.setText(enlace.getText().toLowerCase());                                                    
                                                break;
                                            case "mayuscula": 
                                                    enlace.setText(enlace.getText().toUpperCase());                                                                                                        
                                                break;
                                            case "negrilla":
                                                if(enlace.getFont().getStyle()==2)
                                                {
                                                    enlace.setFont(new Font(enlace.getFont().getName(),3,enlace.getFont().getSize()));
                                                }
                                                else
                                                {
                                                    enlace.setFont(new Font(enlace.getFont().getName(),1,enlace.getFont().getSize()));
                                                }
                                                break;
                                            case "cursiva":
                                                if(enlace.getFont().getSize()==1)
                                                {
                                                    enlace.setFont(new Font(enlace.getFont().getName(),3,enlace.getFont().getSize()));
                                                }
                                                else
                                                {
                                                    enlace.setFont(new Font(enlace.getFont().getName(),2,enlace.getFont().getSize()));
                                                }
                                                break;
                                            case "capital-t":
                                                String[] palabras = enlace.getText().split(" ");
                                                String cadena = "";
                                                if(palabras.length>0)
                                                {
                                                    for(String palabra: palabras)
                                                    {
                                                        if(palabra.length()>2)
                                                        {
                                                            palabra = palabra.substring(0,1).toUpperCase() + palabra.substring(1,palabra.length()) + " ";                                                       
                                                            cadena = cadena + palabra;                                                            
                                                        }
                                                    }
                                                }
                                                enlace.setText(cadena);
                                                break;
                                        }//Fin switch formato
                                    }// Fin verificacion de tipo Source.CCSS. nodo                                
                                }// Fin for de array
                            }// Fin verificacion tipo arrayList 
                            if(estiloElemento instanceof Source.CCSS.Ejecucion.tipoEstilo)
                            {
                                Source.CCSS.Ejecucion.tipoEstilo estilo = (Source.CCSS.Ejecucion.tipoEstilo)estiloElemento;
                                switch(estilo.getNombre().toLowerCase())
                                {
                                    case "alineado":
                                        String valor ="";
                                        if(estilo.getValor() instanceof String){ valor = (String)estilo.getValor();}
                                        switch(valor.toLowerCase())
                                        {
                                            case "izquierda": 
                                                enlace.setAlignmentX(LEFT_ALIGNMENT);
                                                break;
                                            case "derecha": 
                                                enlace.setAlignmentX(RIGHT_ALIGNMENT);
                                                break;
                                            case "centrado": 
                                                enlace.setAlignmentX(CENTER_ALIGNMENT);
                                                break;                                                
                                        }
                                        break;// Fin caso alineado                                    
                                    case "enlace":
                                        valor ="";
                                        if(estilo.getValor() instanceof String)
                                        {
                                            valor = (String)estilo.getValor();
                                            enlace.setText(valor);
                                        }                                    
                                        break;                                    
                                    case "letra":
                                        valor ="";
                                        if(estilo.getValor() instanceof String){ valor = (String)estilo.getValor(); valor= quitarComillas(valor);}                                                                   
                                        try 
                                        {
                                            Font fuente = enlace.getFont();                                                                                
                                            enlace.setFont(new Font(valor, fuente.getStyle(), fuente.getSize()));   
                                        } 
                                        catch (Exception e)
                                        {
                                        }                               
                                        break;  // Fin caso letra
                                    case "tamtex":
                                        Double tamTex = 0.00;
                                        if(estilo.getValor() instanceof Double){ tamTex = (Double)estilo.getValor();}                                                                   
                                        try 
                                        {
                                            Font fuente = enlace.getFont();  
                                            if(tamTex==0){tamTex = (double)fuente.getSize();}
                                            int tamText = Integer.valueOf(tamTex.intValue());
                                            enlace.setFont(new Font(fuente.getName(), fuente.getStyle(), tamText));   
                                        } 
                                        catch (Exception e){}  
                                        break; //Fin caso tamtex
                                    case "visible":
                                        valor ="";
                                        Boolean visibilidad = true;
                                        if(estilo.getValor() instanceof Boolean){ visibilidad = (Boolean)estilo.getValor();}   
                                        enlace.setVisible(visibilidad);
                                        break;//Fin visible 
                                    case "fondoelemento":
                                        valor ="";
                                        if(estilo.getValor() instanceof String)
                                        {
                                            valor = (String)estilo.getValor();
                                            valor = quitarComillas(valor);
                                            enlace.setBackground(colorFuente(valor));
                                            //valor = (String)estilo.getValor();
                                            //panel.setColorFuente(colorFuente(valor));
                                        }
                                        break;//Fin colortext  
                                        
                                    case "borde":
                                        valor = "";
                                        if(estilo.getValor() instanceof ArrayList)
                                        {
                                            ArrayList arreglo = (ArrayList)estilo.getValor();
                                            String color ="";
                                            Boolean borde = true;
                                            int grosor = 10;
                                            
                                            for(Object item : arreglo )
                                            {
                                                if(item instanceof String)
                                                {
                                                    color = quitarComillas((String)item);
                                                }
                                                if(item instanceof Boolean)
                                                {                                                                                                                                                        
                                                     borde = (Boolean)item;                                                                                                       
                                                }
                                                if(item instanceof Double)
                                                {
                                                    Double auxiliar = (Double)item;
                                                    grosor = auxiliar.intValue();
                                                }
                                            }                                            
                                            if(!color.equals(""))
                                            {
                                                enlace.setBorder(new LineBorder(colorFuente(color),grosor, borde));
                                            }                                            
                                        }
                                        break; // Fin caso borde   
                                    case "opaque":
                                        valor ="";
                                        Boolean opacacidad = true;
                                        if(estilo.getValor() instanceof Boolean){ opacacidad = (Boolean)estilo.getValor();}   
                                        enlace.setOpaque(!opacacidad);
                                        break;//Fin Opacacidad      
                                    case "colorenlace":                                        
                                        valor ="";
                                        if(estilo.getValor() instanceof String)
                                        {
                                            valor = (String)estilo.getValor();
                                            //enlace.setColorFuente(colorFuente(valor));
                                            enlace.setForeground(colorFuente(valor));
                                        }
                                        break;//Fin colortext                                          
                                }// Fin switch                                                                                                    
                            } // Fin if instancia estilo
                        }//Fin for
                    }//Fin if !=null
                    break;// Fin caso botón------------------------------------                    
                    
                case "spinner"://----------------------------------------------------------spinner-----------------------------------------------------------------
                    Spinner spinner = (Spinner)elemento.getValor();
                    nodoEstilo = buscarEstilo(spinner.getGrupo(),null);            
                    /*Aplicamos los estilos*/
                    //Object estiloElemento = nodoEstilo.getAtributos().get(aum);
                    if(nodoEstilo!=null)
                    {
                        for(Object estiloElemento: nodoEstilo.getAtributos())
                        {
                            if(estiloElemento instanceof ArrayList)
                            { 
                                ArrayList arreglo = (ArrayList)estiloElemento;
                                for(Object element: arreglo)
                                {
                                    if(element instanceof Source.CCSS.AST.nodo)
                                    {
                                        Source.CCSS.AST.nodo elementArray = (Source.CCSS.AST.nodo)element;
                                        switch(quitarComillas(elementArray.texto).toLowerCase())
                                        {
                                            case "minuscula":                                                
                                                    //spinner.setText(spinner.getText().toLowerCase());                                                    
                                                break;
                                            case "mayuscula": 
                                                    //spinner.setText(spinner.getText().toUpperCase());                                                                                                        
                                                break;
                                            case "negrilla":
                                                if(spinner.getFont().getStyle()==2)
                                                {
                                                    spinner.setFont(new Font(spinner.getFont().getName(),3,spinner.getFont().getSize()));
                                                }
                                                else
                                                {
                                                    spinner.setFont(new Font(spinner.getFont().getName(),1,spinner.getFont().getSize()));
                                                }
                                                break;
                                            case "cursiva":
                                                if(spinner.getFont().getSize()==1)
                                                {
                                                    spinner.setFont(new Font(spinner.getFont().getName(),3,spinner.getFont().getSize()));
                                                }
                                                else
                                                {
                                                    spinner.setFont(new Font(spinner.getFont().getName(),2,spinner.getFont().getSize()));
                                                }
                                                break;

                                        }//Fin switch formato
                                    }// Fin verificacion de tipo Source.CCSS. nodo                                
                                }// Fin for de array
                            }// Fin verificacion tipo arrayList 
                            if(estiloElemento instanceof Source.CCSS.Ejecucion.tipoEstilo)
                            {
                                Source.CCSS.Ejecucion.tipoEstilo estilo = (Source.CCSS.Ejecucion.tipoEstilo)estiloElemento;
                                switch(estilo.getNombre().toLowerCase())
                                {
                                    case "alineado":
                                        String valor ="";
                                        if(estilo.getValor() instanceof String){ valor = (String)estilo.getValor();}
                                        switch(valor.toLowerCase())
                                        {
                                            case "izquierda": 
                                                spinner.setAlignmentX(LEFT_ALIGNMENT);
                                                break;
                                            case "derecha": 
                                                spinner.setAlignmentX(RIGHT_ALIGNMENT);
                                                break;
                                            case "centrado": 
                                                spinner.setAlignmentX(CENTER_ALIGNMENT);
                                                break;                                                
                                        }
                                        break;// Fin caso alineado                                    
                                    case "texto":
                                        valor ="";
                                        if(estilo.getValor() instanceof String)
                                        {
                                            valor = (String)estilo.getValor();
                                            //spinner.setText(valor);
                                        }                                    
                                        break;                                    
                                    case "letra":
                                        valor ="";
                                        if(estilo.getValor() instanceof String){ valor = (String)estilo.getValor(); valor= quitarComillas(valor);}                                                                   
                                        try 
                                        {
                                            Font fuente = spinner.getFont();                                                                                
                                            spinner.setFont(new Font(valor, fuente.getStyle(), fuente.getSize()));   
                                        } 
                                        catch (Exception e)
                                        {
                                        }                               
                                        break;  // Fin caso letra
                                    case "tamtex":
                                        Double tamTex = 0.00;
                                        if(estilo.getValor() instanceof Double){ tamTex = (Double)estilo.getValor();}                                                                   
                                        try 
                                        {
                                            Font fuente = spinner.getFont();  
                                            if(tamTex==0){tamTex = (double)fuente.getSize();}
                                            int tamText = Integer.valueOf(tamTex.intValue());
                                            spinner.setFont(new Font(fuente.getName(), fuente.getStyle(), tamText));   
                                        } 
                                        catch (Exception e){}  
                                        break; //Fin caso tamtex
                                    case "visible":
                                        valor ="";
                                        Boolean visibilidad = true;
                                        if(estilo.getValor() instanceof Boolean){ visibilidad = (Boolean)estilo.getValor();}   
                                        spinner.setVisible(visibilidad);
                                        break;//Fin visible 
                                    case "fondoelemento":
                                        valor ="";
                                        if(estilo.getValor() instanceof String)
                                        {
                                            valor = (String)estilo.getValor();
                                            valor = quitarComillas(valor);
                                            spinner.setBackground(colorFuente(valor));
                                            //valor = (String)estilo.getValor();
                                            //panel.setColorFuente(colorFuente(valor));
                                        }
                                        break;//Fin colortext  
                                        
                                    case "borde":
                                        valor = "";
                                        if(estilo.getValor() instanceof ArrayList)
                                        {
                                            ArrayList arreglo = (ArrayList)estilo.getValor();
                                            String color ="";
                                            Boolean borde = true;
                                            int grosor = 10;
                                            
                                            for(Object item : arreglo )
                                            {
                                                if(item instanceof String)
                                                {
                                                    color = quitarComillas((String)item);
                                                }
                                                if(item instanceof Boolean)
                                                {                                                                                                                                                        
                                                     borde = (Boolean)item;                                                                                                       
                                                }
                                                if(item instanceof Double)
                                                {
                                                    Double auxiliar = (Double)item;
                                                    grosor = auxiliar.intValue();
                                                }
                                            }                                            
                                            if(!color.equals(""))
                                            {
                                                spinner.setBorder(new LineBorder(colorFuente(color),grosor, borde));
                                            }                                            
                                        }
                                        break; // Fin caso borde   
                                    case "opaque":
                                        valor ="";
                                        Boolean opacacidad = true;
                                        if(estilo.getValor() instanceof Boolean){ opacacidad = (Boolean)estilo.getValor();}   
                                        spinner.setOpaque(!opacacidad);
                                        break;//Fin Opacacidad      
                                    case "colortexto":                                        
                                        valor ="";
                                        if(estilo.getValor() instanceof String)
                                        {
                                            valor = (String)estilo.getValor();
                                            //spinner.setColorFuente(colorFuente(valor));
                                            spinner.setForeground(colorFuente(valor));
                                        }
                                        break;//Fin colortext                                          
                                }// Fin switch                                                                                                    
                            } // Fin if instancia estilo
                        }//Fin for
                    }//Fin if !=null
                    break;// Fin caso spinner------------------------------------
                    
                case "tabla"://----------------------------------------------------------tabla-----------------------------------------------------------------
                    Tab tabla = (Tab)elemento.getValor();
                    nodoEstilo = buscarEstilo(tabla.getGrupo(),null);            
                    /*Aplicamos los estilos*/
                    //Object estiloElemento = nodoEstilo.getAtributos().get(aum);
                    if(nodoEstilo!=null)
                    {
                        for(Object estiloElemento: nodoEstilo.getAtributos())
                        {
                            if(estiloElemento instanceof ArrayList)
                            { 
                                ArrayList arreglo = (ArrayList)estiloElemento;
                                for(Object element: arreglo)
                                {
                                    if(element instanceof Source.CCSS.AST.nodo)
                                    {
                                        Source.CCSS.AST.nodo elementArray = (Source.CCSS.AST.nodo)element;
                                        switch(quitarComillas(elementArray.texto).toLowerCase())
                                        {
                                            case "minuscula":                                                
                                                 //   tabla.setText(tabla.getText().toLowerCase());                                                    
                                                break;
                                            case "mayuscula": 
                                                  //  tabla.setText(tabla.getText().toUpperCase());                                                                                                        
                                                break;
                                            case "negrilla":
                                                if(tabla.getFont().getStyle()==2)
                                                {
                                                    tabla.setFont(new Font(tabla.getFont().getName(),3,tabla.getFont().getSize()));
                                                }
                                                else
                                                {
                                                    tabla.setFont(new Font(tabla.getFont().getName(),1,tabla.getFont().getSize()));
                                                }
                                                break;
                                            case "cursiva":
                                                if(tabla.getFont().getSize()==1)
                                                {
                                                    tabla.setFont(new Font(tabla.getFont().getName(),3,tabla.getFont().getSize()));
                                                }
                                                else
                                                {
                                                    tabla.setFont(new Font(tabla.getFont().getName(),2,tabla.getFont().getSize()));
                                                }
                                                break;
                                            case "capital-t":
                                               /* String[] palabras = tabla.getText().split(" ");
                                                String cadena = "";
                                                if(palabras.length>0)
                                                {
                                                    for(String palabra: palabras)
                                                    {
                                                        if(palabra.length()>2)
                                                        {
                                                            palabra = palabra.substring(0,1).toUpperCase() + palabra.substring(1,palabra.length()) + " ";                                                       
                                                            cadena = cadena + palabra;                                                            
                                                        }
                                                    }
                                                }
                                                tabla.setText(cadena);*/
                                                break;
                                        }//Fin switch formato
                                    }// Fin verificacion de tipo Source.CCSS. nodo                                
                                }// Fin for de array
                            }// Fin verificacion tipo arrayList 
                            if(estiloElemento instanceof Source.CCSS.Ejecucion.tipoEstilo)
                            {
                                Source.CCSS.Ejecucion.tipoEstilo estilo = (Source.CCSS.Ejecucion.tipoEstilo)estiloElemento;
                                switch(estilo.getNombre().toLowerCase())
                                {
                                    case "alineado":
                                        String valor ="";
                                        if(estilo.getValor() instanceof String){ valor = (String)estilo.getValor();}
                                        switch(valor.toLowerCase())
                                        {
                                            case "izquierda": 
                                                tabla.setAlignmentX(LEFT_ALIGNMENT);
                                                break;
                                            case "derecha": 
                                                tabla.setAlignmentX(RIGHT_ALIGNMENT);
                                                break;
                                            case "centrado": 
                                                tabla.setAlignmentX(CENTER_ALIGNMENT);
                                                break;                                                
                                        }
                                        break;// Fin caso alineado                                    
                                    case "texto":
                                        valor ="";
                                        if(estilo.getValor() instanceof String)
                                        {
                                            valor = (String)estilo.getValor();
                                            //tabla.setText(valor);
                                        }                                    
                                        break;                                    
                                    case "letra":
                                        valor ="";
                                        if(estilo.getValor() instanceof String){ valor = (String)estilo.getValor(); valor= quitarComillas(valor);}                                                                   
                                        try 
                                        {
                                            Font fuente = tabla.getFont();                                                                                
                                            tabla.setFont(new Font(valor, fuente.getStyle(), fuente.getSize()));   
                                        } 
                                        catch (Exception e)
                                        {
                                        }                               
                                        break;  // Fin caso letra
                                    case "tamtex":
                                        Double tamTex = 0.00;
                                        if(estilo.getValor() instanceof Double){ tamTex = (Double)estilo.getValor();}                                                                   
                                        try 
                                        {
                                            Font fuente = tabla.getFont();  
                                            if(tamTex==0){tamTex = (double)fuente.getSize();}
                                            int tamText = Integer.valueOf(tamTex.intValue());
                                            tabla.setFont(new Font(fuente.getName(), fuente.getStyle(), tamText));   
                                        } 
                                        catch (Exception e){}  
                                        break; //Fin caso tamtex
                                    case "visible":
                                        valor ="";
                                        Boolean visibilidad = true;
                                        if(estilo.getValor() instanceof Boolean){ visibilidad = (Boolean)estilo.getValor();}   
                                        tabla.setVisible(visibilidad);
                                        break;//Fin visible 
                                    case "fondoelemento":
                                        valor ="";
                                        if(estilo.getValor() instanceof String)
                                        {
                                            valor = (String)estilo.getValor();
                                            valor = quitarComillas(valor);
                                            tabla.setBackground(colorFuente(valor));
                                            //valor = (String)estilo.getValor();
                                            //panel.setColorFuente(colorFuente(valor));
                                        }
                                        break;//Fin colortext  
                                        
                                    case "borde":
                                        valor = "";
                                        if(estilo.getValor() instanceof ArrayList)
                                        {
                                            ArrayList arreglo = (ArrayList)estilo.getValor();
                                            String color ="";
                                            Boolean borde = true;
                                            int grosor = 10;
                                            
                                            for(Object item : arreglo )
                                            {
                                                if(item instanceof String)
                                                {
                                                    color = quitarComillas((String)item);
                                                }
                                                if(item instanceof Boolean)
                                                {                                                                                                                                                        
                                                     borde = (Boolean)item;                                                                                                       
                                                }
                                                if(item instanceof Double)
                                                {
                                                    Double auxiliar = (Double)item;
                                                    grosor = auxiliar.intValue();
                                                }
                                            }                                            
                                            if(!color.equals(""))
                                            {
                                                tabla.setBorder(new LineBorder(colorFuente(color),grosor, borde));
                                            }                                            
                                        }
                                        break; // Fin caso borde   
                                    case "opaque":
                                        valor ="";
                                        Boolean opacacidad = true;
                                        if(estilo.getValor() instanceof Boolean){ opacacidad = (Boolean)estilo.getValor();}   
                                        tabla.setOpaque(!opacacidad);
                                        break;//Fin Opacacidad      
                                    case "colortexto":                                        
                                        valor ="";
                                        if(estilo.getValor() instanceof String)
                                        {
                                            valor = (String)estilo.getValor();
                                            //tabla.setColorFuente(colorFuente(valor));
                                            tabla.setForeground(colorFuente(valor));
                                        }
                                        break;//Fin colortext                                          
                                }// Fin switch                                                                                                    
                            } // Fin if instancia estilo
                        }//Fin for
                    }//Fin if !=null
                    break;// Fin caso botón------------------------------------                    
                    
                    
            }//Fin switch principal.
        }        
    }
    
    
    public void aplicarEstiloId(Elemento elemento, Object container)
    {   
        if(container instanceof Panel)
        {
            Panel contenedor = (Panel)container;                        
            //f_b_redireccion
            switch(elemento.getTipo())
            {                        
                case "panel": // ----------------------------------------------------------------PANEL----------------------------------------------------------------------------
                    Panel panel = (Panel)elemento.getValor();
                    Source.CCSS.Ejecucion.nodoLista nodoEstilo = buscarEstilo(null,panel.getId());               

                    /*Aplicamos los estilos*/                                       
                    if(nodoEstilo!=null)
                    {
                        for(Object estiloElemento: nodoEstilo.getAtributos())
                        {
                            if(estiloElemento instanceof ArrayList)
                            { 
                                ArrayList arreglo = (ArrayList)estiloElemento;
                                for(Object element: arreglo)
                                {
                                    if(element instanceof Source.CCSS.nodo)
                                    {
                                        Source.CCSS.nodo elementArray = (Source.CCSS.nodo)element;
                                        switch(quitarComillas(elementArray.texto).toLowerCase())
                                        {
                                            case "minuscula":
                                                    panel.setEstilo("minuscula");
                                                break;
                                            case "mayuscula": 
                                                    panel.setEstilo("mayuscula");
                                                break;
                                            case "negrilla":
                                                if(panel.getFuente().getStyle()==2)
                                                {
                                                    panel.setFuente(new Font(panel.getFuente().getName(),3,panel.getFuente().getSize()));
                                                }
                                                else
                                                {
                                                    panel.setFuente(new Font(panel.getFuente().getName(),1,panel.getFuente().getSize()));
                                                }
                                                break;
                                            case "cursiva":
                                                if(panel.getFuente().getSize()==1)
                                                {
                                                    panel.setFuente(new Font(panel.getFuente().getName(),3,panel.getFuente().getSize()));
                                                }
                                                else
                                                {
                                                    panel.setFuente(new Font(panel.getFuente().getName(),2,panel.getFuente().getSize()));
                                                }
                                                break;
                                            case "capital-t":
                                                panel.setEstilo("capital-t");
                                                break;
                                        }//Fin switch formato
                                    }// Fin verificacion de tipo Source.CCSS. nodo                                
                                }// Fin for de array
                            }// Fin verificacion tipo arrayList                        
                            if(estiloElemento instanceof Source.CCSS.Ejecucion.tipoEstilo)
                            {
                                Source.CCSS.Ejecucion.tipoEstilo estilo = (Source.CCSS.Ejecucion.tipoEstilo)estiloElemento;
                                switch(estilo.getNombre().toLowerCase())
                                {
                                    case "alineado":
                                        String valor ="";
                                        if(estilo.getValor() instanceof String){ valor = (String)estilo.getValor();}
                                        switch(valor.toLowerCase())
                                        {
                                            case "izquierda":                                        
                                                break;
                                        }
                                        break;// Fin caso alineado                                    
                                    case "texto":
                                        valor ="";
                                        if(estilo.getValor() instanceof String)
                                        {
                                            valor = (String)estilo.getValor();
                                            panel.setTexto(quitarComillas(valor));
                                        }                                    
                                        break; 
                                    case "letra":
                                        valor ="";
                                        if(estilo.getValor() instanceof String){ valor = (String)estilo.getValor(); valor= quitarComillas(valor);}                                                                   
                                        try 
                                        {
                                            Font fuente = panel.getFont();                                                                                
                                            panel.setFont(new Font(valor, fuente.getStyle(), fuente.getSize()));   
                                        } 
                                        catch (Exception e)
                                        {
                                        }                               
                                        break;  // Fin caso letra   
                                    case "tamtex":
                                        Double tamTex = 0.00;
                                        if(estilo.getValor() instanceof Double){ tamTex = (Double)estilo.getValor();}                                                                   
                                        try 
                                        {
                                            Font fuente = panel.getFont();  
                                            if(tamTex==0){tamTex = (double)fuente.getSize();}
                                            int tamText = tamTex.intValue();
                                            panel.setFont(new Font(fuente.getName(), fuente.getStyle(), tamText));   
                                        } 
                                        catch (Exception e){}  
                                        break; //Fin caso tamtex  
                                    case "visible":
                                        valor ="";
                                        Boolean visibilidad = true;
                                        if(estilo.getValor() instanceof Boolean){ visibilidad = (Boolean)estilo.getValor();}   
                                        panel.setVisible(visibilidad);
                                        break;//Fin visible   
                                    case "colortexto":
                                        valor ="";
                                        if(estilo.getValor() instanceof String)
                                        {
                                            valor = (String)estilo.getValor();
                                            panel.setColorFuente(colorFuente(valor));
                                        }
                                        break;//Fin colortexto    
                                    case "fondoelemento":
                                        valor ="";
                                        if(estilo.getValor() instanceof String)
                                        {
                                            valor = (String)estilo.getValor();
                                            valor = quitarComillas(valor);
                                            panel.setBackground(colorFuente(valor));
                                            //valor = (String)estilo.getValor();
                                            //panel.setColorFuente(colorFuente(valor));
                                        }
                                        break;//Fin colortext 
                                    case "borde":
                                        valor = "";
                                        if(estilo.getValor() instanceof ArrayList)
                                        {
                                            ArrayList arreglo = (ArrayList)estilo.getValor();
                                            String color ="";
                                            Boolean borde = true;
                                            int grosor = 10;
                                            
                                            for(Object item : arreglo )
                                            {
                                                if(item instanceof String)
                                                {
                                                    color = quitarComillas((String)item);
                                                }
                                                if(item instanceof Boolean)
                                                {                                                                                                                                                        
                                                    borde = (boolean)item;
                                                }
                                                if(item instanceof Double)
                                                {
                                                    Double auxiliar = (Double)item;
                                                    grosor = auxiliar.intValue();
                                                }
                                            }
                                            
                                            if(!color.equals(""))
                                            {
                                                panel.setBorder(new LineBorder(colorFuente(color),grosor, borde));
                                            }                                            
                                        }                                        
                                        break; // Fin caso borde   
                                    case "opaque":
                                        valor ="";
                                        Boolean opacacidad = true;
                                        if(estilo.getValor() instanceof Boolean){ opacacidad = (Boolean)estilo.getValor();}   
                                        panel.setOpaque(opacacidad);
                                        break;//Fin Opacacidad   
                                    case "autoredimension":
                                        if(estilo.getValor() instanceof ArrayList)
                                        {
                                            ArrayList arreglo = (ArrayList)estilo.getValor();
                                            Object valoRedimension = arreglo.get(0);
                                            Object area =  arreglo.get(1);
                                            int alto = panel.getAlto();
                                            int ancho = panel.getAncho(); 
                                            panel.setAlto(0);
                                            panel.setAncho(0);
                                            if(area instanceof String)
                                            {                                                
                                                if(valoRedimension instanceof Boolean)
                                                {
                                                    if((boolean)valoRedimension)
                                                    {
                                                        calcularTamaño(panel);                                                                                                                 
                                                        switch(quitarComillas((String)area).toLowerCase())
                                                        {
                                                            case "horizontal":
                                                                panel.setAlto(alto);
                                                                panel.setPreferredSize(new java.awt.Dimension(panel.getAncho(),panel.getAlto()));
                                                                break;
                                                            case "vertical":  
                                                                panel.setAncho(ancho);
                                                                panel.setPreferredSize(new java.awt.Dimension(panel.getAncho(),panel.getAlto()));                                                                
                                                                break;
                                                        }                                                        
                                                    }
                                                }                                                
                                            }                                              
                                        }
                                        break;//Fin Opacacidad                                                                                
                                }// Fin switch                                                                                                    
                            } // Fin if instancia estilo
                        }//Fin for
                    }//Fin if !=null
                    break;// ---------------------------------------------------------------FIN PANEL------------------------------------------------------------------- 
                    //----------------------------------------------------------------------AREA TEXTO------------------------------------------------------------------
                    
                    
                    
                    //---------------------------------------------------------------------FIN AREA TEXTO---------------------------------------------------------------                                                                                                                                                                                    
                case "imagen": // ----------------------------------------------------------Imagen----------------------------------------------------------------------
                    Imagen imagen = (Imagen)elemento.getValor();
                    nodoEstilo = buscarEstilo(null, imagen.getId());               
                    /*Aplicamos los estilos*/                                       
                    if(nodoEstilo!=null)
                    {
                        for(Object estiloElemento: nodoEstilo.getAtributos())
                        {    
                            
                            if(estiloElemento instanceof ArrayList)
                            { 
                                ArrayList arreglo = (ArrayList)estiloElemento;
                                for(Object element: arreglo)
                                {
                                    if(element instanceof Source.CCSS.nodo)
                                    {
                                        Source.CCSS.nodo elementArray = (Source.CCSS.nodo)element;
                                        switch(quitarComillas(elementArray.texto).toLowerCase())
                                        {
                                            case "minuscula":
                                                    //panel.setEstilo("minuscula");
                                                break;
                                            case "mayuscula": 
                                                    //panel.setEstilo("mayuscula");
                                                break;
                                            case "negrilla":
                                                /*if(panel.getFuente().getStyle()==2)
                                                {
                                                    panel.setFuente(new Font(panel.getFuente().getName(),3,panel.getFuente().getSize()));
                                                }
                                                else
                                                {
                                                    panel.setFuente(new Font(panel.getFuente().getName(),1,panel.getFuente().getSize()));
                                                }
                                                break;
                                            case "cursiva":
                                                if(panel.getFuente().getSize()==1)
                                                {
                                                    panel.setFuente(new Font(panel.getFuente().getName(),3,panel.getFuente().getSize()));
                                                }
                                                else
                                                {
                                                    panel.setFuente(new Font(panel.getFuente().getName(),2,panel.getFuente().getSize()));
                                                }*/
                                                break;
                                            case "capital-t":
                                                //panel.setEstilo("capital-t");
                                                break;
                                        }//Fin switch formato
                                    }// Fin verificacion de tipo Source.CCSS. nodo                                
                                }// Fin for de array
                            }// Fin verificacion tipo arrayList                             
                            
                            if(estiloElemento instanceof Source.CCSS.Ejecucion.tipoEstilo)
                            {
                                Source.CCSS.Ejecucion.tipoEstilo estilo = (Source.CCSS.Ejecucion.tipoEstilo)estiloElemento;
                                switch(estilo.getNombre().toLowerCase())
                                {
                                    case "alineado":
                                        String valor ="";
                                        if(estilo.getValor() instanceof String){ valor = (String)estilo.getValor();}
                                        switch(valor.toLowerCase())
                                        {
                                            case "izquierda":                                        
                                                break;
                                        }
                                        break;// Fin caso alineado                                    
                                    case "texto":
                                        valor ="";
                                        if(estilo.getValor() instanceof String)
                                        {
                                            valor = (String)estilo.getValor();
                                            //imagen.setTexto(quitarComillas(valor));
                                        }                                    
                                        break; 
                                    case "letra":
                                        valor ="";
                                        if(estilo.getValor() instanceof String){ valor = (String)estilo.getValor(); valor= quitarComillas(valor);}                                                                   
                                        try 
                                        {
                                            Font fuente = contenedor.getFont();                                                                                
                                            imagen.setFont(new Font(valor, fuente.getStyle(), fuente.getSize()));   
                                        } 
                                        catch (Exception e)
                                        {
                                        }                               
                                        break;  // Fin caso letra   
                                    case "tamtex":
                                        Double tamTex = 0.00;
                                        if(estilo.getValor() instanceof Double){ tamTex = (Double)estilo.getValor();}                                                                   
                                        try 
                                        {
                                            Font fuente = contenedor.getFont();  
                                            if(tamTex==0){tamTex = (double)fuente.getSize();}
                                            int tamText = tamTex.intValue();
                                            imagen.setFont(new Font(fuente.getName(), fuente.getStyle(), tamText));   
                                        } 
                                        catch (Exception e){}  
                                        break; //Fin caso tamtex  
                                    case "visible":
                                        valor ="";
                                        Boolean visibilidad = true;
                                        if(estilo.getValor() instanceof Boolean){ visibilidad = (Boolean)estilo.getValor();}   
                                        imagen.setVisible(visibilidad);
                                        break;//Fin visible   
                                    case "colortext":
                                        valor ="";
                                        if(estilo.getValor() instanceof String)
                                        {
                                            valor = (String)estilo.getValor();
                                            imagen.setForeground(colorFuente(valor));
                                        }
                                        break;//Fin colortext
                                    case "fondo":
                                        valor = "";
                                        if(estilo.getValor() instanceof String)
                                        {
                                            valor = (String)estilo.getValor();
                                            imagen.setBackground(colorFuente(valor));
                                        }
                                        break; // Fin fondo (color de fondo)
                                    case "borde":
                                        valor = "";
                                        if(estilo.getValor() instanceof ArrayList)
                                        {
                                            ArrayList arreglo = (ArrayList)estilo.getValor();
                                            String color ="";
                                            Boolean borde = true;
                                            int grosor = 10;
                                            
                                            for(Object item : arreglo )
                                            {
                                                if(item instanceof String)
                                                {
                                                    color = quitarComillas((String)item);
                                                }
                                                if(item instanceof Boolean)
                                                {                                                                                                                                                        
                                                     borde = (Boolean)item;                                                                                                       
                                                }
                                                if(item instanceof Double)
                                                {
                                                    Double auxiliar = (Double)item;
                                                    grosor = auxiliar.intValue();
                                                }
                                            }                                            
                                            if(!color.equals(""))
                                            {
                                                imagen.setBorder(new LineBorder(colorFuente(color),grosor, borde));
                                            }                                            
                                        }
                                        break; // Fin caso borde  
                                    case "opaque":
                                        valor ="";
                                        Boolean opacacidad = true;
                                        if(estilo.getValor() instanceof Boolean){ opacacidad = (Boolean)estilo.getValor();}   
                                        imagen.setOpaque(opacacidad);
                                        break;//Fin Opacacidad                                       
                                }// Fin switch                                                                                                    
                            } // Fin if instancia estilo
                        }//Fin for
                    }//Fin if !=null
                    break;// Fin caso --------------------------------------------------IMAGEN-----------------------------------------------------------------                 
                case "boton"://----------------------------------------------------------BOTON-----------------------------------------------------------------
                    Boton boton = (Boton)elemento.getValor();
                    nodoEstilo = buscarEstilo(null,boton.getId());            
                    /*Aplicamos los estilos*/
                    //Object estiloElemento = nodoEstilo.getAtributos().get(aum);
                    if(nodoEstilo!=null)
                    {
                        for(Object estiloElemento: nodoEstilo.getAtributos())
                        {
                            if(estiloElemento instanceof ArrayList)
                            { 
                                ArrayList arreglo = (ArrayList)estiloElemento;
                                for(Object element: arreglo)
                                {
                                    if(element instanceof Source.CCSS.AST.nodo)
                                    {
                                        Source.CCSS.AST.nodo elementArray = (Source.CCSS.AST.nodo)element;
                                        switch(quitarComillas(elementArray.texto).toLowerCase())
                                        {
                                            case "minuscula":                                                
                                                    boton.setText(boton.getText().toLowerCase());                                                    
                                                break;
                                            case "mayuscula": 
                                                    boton.setText(boton.getText().toUpperCase());                                                                                                        
                                                break;
                                            case "negrilla":
                                                if(boton.getFont().getStyle()==2)
                                                {
                                                    boton.setFont(new Font(boton.getFont().getName(),3,boton.getFont().getSize()));
                                                }
                                                else
                                                {
                                                    boton.setFont(new Font(boton.getFont().getName(),1,boton.getFont().getSize()));
                                                }
                                                break;
                                            case "cursiva":
                                                if(boton.getFont().getSize()==1)
                                                {
                                                    boton.setFont(new Font(boton.getFont().getName(),3,boton.getFont().getSize()));
                                                }
                                                else
                                                {
                                                    boton.setFont(new Font(boton.getFont().getName(),2,boton.getFont().getSize()));
                                                }
                                                break;
                                            case "capital-t":
                                                String[] palabras = boton.getText().split(" ");
                                                String cadena = "";
                                                if(palabras.length>0)
                                                {
                                                    for(String palabra: palabras)
                                                    {
                                                        if(palabra.length()>2)
                                                        {
                                                            palabra = palabra.substring(0,1).toUpperCase() + palabra.substring(1,palabra.length()) + " ";                                                       
                                                            cadena = cadena + palabra;                                                            
                                                        }
                                                    }
                                                }
                                                boton.setText(cadena);
                                                break;
                                        }//Fin switch formato
                                    }// Fin verificacion de tipo Source.CCSS. nodo                                
                                }// Fin for de array
                            }// Fin verificacion tipo arrayList 
                            if(estiloElemento instanceof Source.CCSS.Ejecucion.tipoEstilo)
                            {
                                Source.CCSS.Ejecucion.tipoEstilo estilo = (Source.CCSS.Ejecucion.tipoEstilo)estiloElemento;
                                switch(estilo.getNombre().toLowerCase())
                                {
                                    case "alineado":
                                        String valor ="";
                                        if(estilo.getValor() instanceof String){ valor = (String)estilo.getValor();}
                                        switch(valor.toLowerCase())
                                        {
                                            case "izquierda": 
                                                boton.setAlignmentX(LEFT_ALIGNMENT);
                                                break;
                                            case "derecha": 
                                                boton.setAlignmentX(RIGHT_ALIGNMENT);
                                                break;
                                            case "centrado": 
                                                boton.setAlignmentX(CENTER_ALIGNMENT);
                                                break;                                                
                                        }
                                        break;// Fin caso alineado                                    
                                    case "texto":
                                        valor ="";
                                        if(estilo.getValor() instanceof String)
                                        {
                                            valor = (String)estilo.getValor();
                                            boton.setText(valor);
                                        }                                    
                                        break;                                    
                                    case "letra":
                                        valor ="";
                                        if(estilo.getValor() instanceof String){ valor = (String)estilo.getValor(); valor= quitarComillas(valor);}                                                                   
                                        try 
                                        {
                                            Font fuente = boton.getFont();                                                                                
                                            boton.setFont(new Font(valor, fuente.getStyle(), fuente.getSize()));   
                                        } 
                                        catch (Exception e)
                                        {
                                        }                               
                                        break;  // Fin caso letra
                                    case "tamtex":
                                        Double tamTex = 0.00;
                                        if(estilo.getValor() instanceof Double){ tamTex = (Double)estilo.getValor();}                                                                   
                                        try 
                                        {
                                            Font fuente = boton.getFont();  
                                            if(tamTex==0){tamTex = (double)fuente.getSize();}
                                            int tamText = Integer.valueOf(tamTex.intValue());
                                            boton.setFont(new Font(fuente.getName(), fuente.getStyle(), tamText));   
                                        } 
                                        catch (Exception e){}  
                                        break; //Fin caso tamtex
                                    case "visible":
                                        valor ="";
                                        Boolean visibilidad = true;
                                        if(estilo.getValor() instanceof Boolean){ visibilidad = (Boolean)estilo.getValor();}   
                                        boton.setVisible(visibilidad);
                                        break;//Fin visible 
                                    case "fondoelemento":
                                        valor ="";
                                        if(estilo.getValor() instanceof String)
                                        {
                                            valor = (String)estilo.getValor();
                                            valor = quitarComillas(valor);
                                            boton.setBackground(colorFuente(valor));
                                            //valor = (String)estilo.getValor();
                                            //panel.setColorFuente(colorFuente(valor));
                                        }
                                        break;//Fin colortext  
                                        
                                    case "borde":
                                        valor = "";
                                        if(estilo.getValor() instanceof ArrayList)
                                        {
                                            ArrayList arreglo = (ArrayList)estilo.getValor();
                                            String color ="";
                                            Boolean borde = true;
                                            int grosor = 10;
                                            
                                            for(Object item : arreglo )
                                            {
                                                if(item instanceof String)
                                                {
                                                    color = quitarComillas((String)item);
                                                }
                                                if(item instanceof Boolean)
                                                {                                                                                                                                                        
                                                     borde = (Boolean)item;                                                                                                       
                                                }
                                                if(item instanceof Double)
                                                {
                                                    Double auxiliar = (Double)item;
                                                    grosor = auxiliar.intValue();
                                                }
                                            }                                            
                                            if(!color.equals(""))
                                            {
                                                boton.setBorder(new LineBorder(colorFuente(color),grosor, borde));
                                            }                                            
                                        }
                                        break; // Fin caso borde   
                                    case "opaque":
                                        valor ="";
                                        Boolean opacacidad = true;
                                        if(estilo.getValor() instanceof Boolean){ opacacidad = (Boolean)estilo.getValor();}   
                                        boton.setOpaque(!opacacidad);
                                        break;//Fin Opacacidad      
                                    case "colortexto":                                        
                                        valor ="";
                                        if(estilo.getValor() instanceof String)
                                        {
                                            valor = (String)estilo.getValor();
                                            //boton.setColorFuente(colorFuente(valor));
                                            boton.setForeground(colorFuente(valor));
                                        }
                                        break;//Fin colortext                                          
                                }// Fin switch                                                                                                    
                            } // Fin if instancia estilo
                        }//Fin for
                    }//Fin if !=null
                    break;// Fin caso botón------------------------------------

                    
                    
                case "caja"://----------------------------------------------------------caja-----------------------------------------------------------------
                    Caja caja = (Caja)elemento.getValor();
                    nodoEstilo = buscarEstilo(null,caja.getId());            
                    /*Aplicamos los estilos*/
                    //Object estiloElemento = nodoEstilo.getAtributos().get(aum);
                    if(nodoEstilo!=null)
                    {
                        for(Object estiloElemento: nodoEstilo.getAtributos())
                        {
                            if(estiloElemento instanceof ArrayList)
                            { 
                                ArrayList arreglo = (ArrayList)estiloElemento;
                                for(Object element: arreglo)
                                {
                                    if(element instanceof Source.CCSS.AST.nodo)
                                    {
                                        Source.CCSS.AST.nodo elementArray = (Source.CCSS.AST.nodo)element;
                                        switch(quitarComillas(elementArray.texto).toLowerCase())
                                        {
                                            case "minuscula":                                                
                                                    caja.setText(caja.getText().toLowerCase());                                                    
                                                break;
                                            case "mayuscula": 
                                                    caja.setText(caja.getText().toUpperCase());                                                                                                        
                                                break;
                                            case "negrilla":
                                                if(caja.getFont().getStyle()==2)
                                                {
                                                    caja.setFont(new Font(caja.getFont().getName(),3,caja.getFont().getSize()));
                                                }
                                                else
                                                {
                                                    caja.setFont(new Font(caja.getFont().getName(),1,caja.getFont().getSize()));
                                                }
                                                break;
                                            case "cursiva":
                                                if(caja.getFont().getSize()==1)
                                                {
                                                    caja.setFont(new Font(caja.getFont().getName(),3,caja.getFont().getSize()));
                                                }
                                                else
                                                {
                                                    caja.setFont(new Font(caja.getFont().getName(),2,caja.getFont().getSize()));
                                                }
                                                break;
                                            case "capital-t":
                                                String[] palabras = caja.getText().split(" ");
                                                String cadena = "";
                                                if(palabras.length>0)
                                                {
                                                    for(String palabra: palabras)
                                                    {
                                                        if(palabra.length()>2)
                                                        {
                                                            palabra = palabra.substring(0,1).toUpperCase() + palabra.substring(1,palabra.length()) + " ";                                                       
                                                            cadena = cadena + palabra;                                                            
                                                        }
                                                    }
                                                }
                                                caja.setText(cadena);
                                                break;
                                        }//Fin switch formato
                                    }// Fin verificacion de tipo Source.CCSS. nodo                                
                                }// Fin for de array
                            }// Fin verificacion tipo arrayList 
                            if(estiloElemento instanceof Source.CCSS.Ejecucion.tipoEstilo)
                            {
                                Source.CCSS.Ejecucion.tipoEstilo estilo = (Source.CCSS.Ejecucion.tipoEstilo)estiloElemento;
                                switch(estilo.getNombre().toLowerCase())
                                {
                                    case "alineado":
                                        String valor ="";
                                        if(estilo.getValor() instanceof String){ valor = (String)estilo.getValor();}
                                        switch(valor.toLowerCase())
                                        {
                                            case "izquierda": 
                                                caja.setAlignmentX(LEFT_ALIGNMENT);
                                                break;
                                            case "derecha": 
                                                caja.setAlignmentX(RIGHT_ALIGNMENT);
                                                break;
                                            case "centrado": 
                                                caja.setAlignmentX(CENTER_ALIGNMENT);
                                                break;                                                
                                        }
                                        break;// Fin caso alineado                                    
                                    case "texto":
                                        valor ="";
                                        if(estilo.getValor() instanceof String)
                                        {
                                            valor = (String)estilo.getValor();
                                            caja.setText(valor);
                                        }                                    
                                        break;                                    
                                    case "letra":
                                        valor ="";
                                        if(estilo.getValor() instanceof String){ valor = (String)estilo.getValor(); valor= quitarComillas(valor);}                                                                   
                                        try 
                                        {
                                            Font fuente = caja.getFont();                                                                                
                                            caja.setFont(new Font(valor, fuente.getStyle(), fuente.getSize()));   
                                        } 
                                        catch (Exception e)
                                        {
                                        }                               
                                        break;  // Fin caso letra
                                    case "tamtex":
                                        Double tamTex = 0.00;
                                        if(estilo.getValor() instanceof Double){ tamTex = (Double)estilo.getValor();}                                                                   
                                        try 
                                        {
                                            Font fuente = caja.getFont();  
                                            if(tamTex==0){tamTex = (double)fuente.getSize();}
                                            int tamText = Integer.valueOf(tamTex.intValue());
                                            caja.setFont(new Font(fuente.getName(), fuente.getStyle(), tamText));   
                                        } 
                                        catch (Exception e){}  
                                        break; //Fin caso tamtex
                                    case "visible":
                                        valor ="";
                                        Boolean visibilidad = true;
                                        if(estilo.getValor() instanceof Boolean){ visibilidad = (Boolean)estilo.getValor();}   
                                        caja.setVisible(visibilidad);
                                        break;//Fin visible 
                                    case "fondoelemento":
                                        valor ="";
                                        if(estilo.getValor() instanceof String)
                                        {
                                            valor = (String)estilo.getValor();
                                            valor = quitarComillas(valor);
                                            caja.setBackground(colorFuente(valor));
                                            //valor = (String)estilo.getValor();
                                            //panel.setColorFuente(colorFuente(valor));
                                        }
                                        break;//Fin colortext  
                                        
                                    case "borde":
                                        valor = "";
                                        if(estilo.getValor() instanceof ArrayList)
                                        {
                                            ArrayList arreglo = (ArrayList)estilo.getValor();
                                            String color ="";
                                            Boolean borde = true;
                                            int grosor = 10;
                                            
                                            for(Object item : arreglo )
                                            {
                                                if(item instanceof String)
                                                {
                                                    color = quitarComillas((String)item);
                                                }
                                                if(item instanceof Boolean)
                                                {                                                                                                                                                        
                                                     borde = (Boolean)item;                                                                                                       
                                                }
                                                if(item instanceof Double)
                                                {
                                                    Double auxiliar = (Double)item;
                                                    grosor = auxiliar.intValue();
                                                }
                                            }                                            
                                            if(!color.equals(""))
                                            {
                                                caja.setBorder(new LineBorder(colorFuente(color),grosor, borde));
                                            }                                            
                                        }
                                        break; // Fin caso borde   
                                    case "opaque":
                                        valor ="";
                                        Boolean opacacidad = true;
                                        if(estilo.getValor() instanceof Boolean){ opacacidad = (Boolean)estilo.getValor();}   
                                        caja.setOpaque(!opacacidad);
                                        break;//Fin Opacacidad      
                                    case "colortexto":                                        
                                        valor ="";
                                        if(estilo.getValor() instanceof String)
                                        {
                                            valor = (String)estilo.getValor();
                                            //caja.setColorFuente(colorFuente(valor));
                                            caja.setForeground(colorFuente(valor));
                                        }
                                        break;//Fin colortext                                          
                                }// Fin switch                                                                                                    
                            } // Fin if instancia estilo
                        }//Fin for
                    }//Fin if !=null
                    break;// Fin caso botón------------------------------------                    
                    
                case "area"://----------------------------------------------------------areatexto-----------------------------------------------------------------
                    areaTexto area = (areaTexto)elemento.getValor();
                    nodoEstilo = buscarEstilo(null,area.getId());            
                    /*Aplicamos los estilos*/
                    //Object estiloElemento = nodoEstilo.getAtributos().get(aum);
                    if(nodoEstilo!=null)
                    {
                        for(Object estiloElemento: nodoEstilo.getAtributos())
                        {
                            if(estiloElemento instanceof ArrayList)
                            { 
                                ArrayList arreglo = (ArrayList)estiloElemento;
                                for(Object element: arreglo)
                                {
                                    if(element instanceof Source.CCSS.AST.nodo)
                                    {
                                        Source.CCSS.AST.nodo elementArray = (Source.CCSS.AST.nodo)element;
                                        switch(quitarComillas(elementArray.texto).toLowerCase())
                                        {
                                            case "minuscula":                                                
                                                    area.setText(area.getText().toLowerCase());                                                    
                                                break;
                                            case "mayuscula": 
                                                    area.setText(area.getText().toUpperCase());                                                                                                        
                                                break;
                                            case "negrilla":
                                                if(area.getFont().getStyle()==2)
                                                {
                                                    area.setFont(new Font(area.getFont().getName(),3,area.getFont().getSize()));
                                                }
                                                else
                                                {
                                                    area.setFont(new Font(area.getFont().getName(),1,area.getFont().getSize()));
                                                }
                                                break;
                                            case "cursiva":
                                                if(area.getFont().getSize()==1)
                                                {
                                                    area.setFont(new Font(area.getFont().getName(),3,area.getFont().getSize()));
                                                }
                                                else
                                                {
                                                    area.setFont(new Font(area.getFont().getName(),2,area.getFont().getSize()));
                                                }
                                                break;
                                            case "capital-t":
                                                String[] palabras = area.getText().split(" ");
                                                String cadena = "";
                                                if(palabras.length>0)
                                                {
                                                    for(String palabra: palabras)
                                                    {
                                                        if(palabra.length()>2)
                                                        {
                                                            palabra = palabra.substring(0,1).toUpperCase() + palabra.substring(1,palabra.length()) + " ";                                                       
                                                            cadena = cadena + palabra;                                                            
                                                        }
                                                    }
                                                }
                                                area.setText(cadena);
                                                break;
                                        }//Fin switch formato
                                    }// Fin verificacion de tipo Source.CCSS. nodo                                
                                }// Fin for de array
                            }// Fin verificacion tipo arrayList 
                            if(estiloElemento instanceof Source.CCSS.Ejecucion.tipoEstilo)
                            {
                                Source.CCSS.Ejecucion.tipoEstilo estilo = (Source.CCSS.Ejecucion.tipoEstilo)estiloElemento;
                                switch(estilo.getNombre().toLowerCase())
                                {
                                    case "alineado":
                                        String valor ="";
                                        if(estilo.getValor() instanceof String){ valor = (String)estilo.getValor();}
                                        switch(valor.toLowerCase())
                                        {
                                            case "izquierda": 
                                                area.setAlignmentX(LEFT_ALIGNMENT);
                                                break;
                                            case "derecha": 
                                                area.setAlignmentX(RIGHT_ALIGNMENT);
                                                break;
                                            case "centrado": 
                                                area.setAlignmentX(CENTER_ALIGNMENT);
                                                break;                                                
                                        }
                                        break;// Fin caso alineado                                    
                                    case "texto":
                                        valor ="";
                                        if(estilo.getValor() instanceof String)
                                        {
                                            valor = (String)estilo.getValor();
                                            area.setText(valor);
                                        }                                    
                                        break;                                    
                                    case "letra":
                                        valor ="";
                                        if(estilo.getValor() instanceof String){ valor = (String)estilo.getValor(); valor= quitarComillas(valor);}                                                                   
                                        try 
                                        {
                                            Font fuente = area.getFont();                                                                                
                                            area.setFont(new Font(valor, fuente.getStyle(), fuente.getSize()));   
                                        } 
                                        catch (Exception e)
                                        {
                                        }                               
                                        break;  // Fin caso letra
                                    case "tamtex":
                                        Double tamTex = 0.00;
                                        if(estilo.getValor() instanceof Double){ tamTex = (Double)estilo.getValor();}                                                                   
                                        try 
                                        {
                                            Font fuente = area.getFont();  
                                            if(tamTex==0){tamTex = (double)fuente.getSize();}
                                            int tamText = Integer.valueOf(tamTex.intValue());
                                            area.setFont(new Font(fuente.getName(), fuente.getStyle(), tamText));   
                                        } 
                                        catch (Exception e){}  
                                        break; //Fin caso tamtex
                                    case "visible":
                                        valor ="";
                                        Boolean visibilidad = true;
                                        if(estilo.getValor() instanceof Boolean){ visibilidad = (Boolean)estilo.getValor();}   
                                        area.setVisible(visibilidad);
                                        break;//Fin visible 
                                    case "fondoelemento":
                                        valor ="";
                                        if(estilo.getValor() instanceof String)
                                        {
                                            valor = (String)estilo.getValor();
                                            valor = quitarComillas(valor);
                                            area.setBackground(colorFuente(valor));
                                            //valor = (String)estilo.getValor();
                                            //panel.setColorFuente(colorFuente(valor));
                                        }
                                        break;//Fin colortext  
                                        
                                    case "borde":
                                        valor = "";
                                        if(estilo.getValor() instanceof ArrayList)
                                        {
                                            ArrayList arreglo = (ArrayList)estilo.getValor();
                                            String color ="";
                                            Boolean borde = true;
                                            int grosor = 10;
                                            
                                            for(Object item : arreglo )
                                            {
                                                if(item instanceof String)
                                                {
                                                    color = quitarComillas((String)item);
                                                }
                                                if(item instanceof Boolean)
                                                {                                                                                                                                                        
                                                     borde = (Boolean)item;                                                                                                       
                                                }
                                                if(item instanceof Double)
                                                {
                                                    Double auxiliar = (Double)item;
                                                    grosor = auxiliar.intValue();
                                                }
                                            }                                            
                                            if(!color.equals(""))
                                            {
                                                area.setBorder(new LineBorder(colorFuente(color),grosor, borde));
                                            }                                            
                                        }
                                        break; // Fin caso borde   
                                    case "opaque":
                                        valor ="";
                                        Boolean opacacidad = true;
                                        if(estilo.getValor() instanceof Boolean){ opacacidad = (Boolean)estilo.getValor();}   
                                        area.setOpaque(!opacacidad);
                                        break;//Fin Opacacidad      
                                    case "colortexto":                                        
                                        valor ="";
                                        if(estilo.getValor() instanceof String)
                                        {
                                            valor = (String)estilo.getValor();
                                            //texto.setColorFuente(colorFuente(valor));
                                            area.setForeground(colorFuente(valor));
                                        }
                                        break;//Fin colortext                                          
                                }// Fin switch                                                                                                    
                            } // Fin if instancia estilo
                        }//Fin for
                    }//Fin if !=null
                    break;// Fin caso areatexto------------------------------------                     
                    
                case "texto"://----------------------------------------------------------texto-----------------------------------------------------------------
                    Texto texto = (Texto)elemento.getValor();
                    nodoEstilo = buscarEstilo(null,texto.getId());            
                    /*Aplicamos los estilos*/
                    //Object estiloElemento = nodoEstilo.getAtributos().get(aum);
                    if(nodoEstilo!=null)
                    {
                        for(Object estiloElemento: nodoEstilo.getAtributos())
                        {
                            if(estiloElemento instanceof ArrayList)
                            { 
                                ArrayList arreglo = (ArrayList)estiloElemento;
                                for(Object element: arreglo)
                                {
                                    if(element instanceof Source.CCSS.AST.nodo)
                                    {
                                        Source.CCSS.AST.nodo elementArray = (Source.CCSS.AST.nodo)element;
                                        switch(quitarComillas(elementArray.texto).toLowerCase())
                                        {
                                            case "minuscula":                                                
                                                    texto.setText(texto.getText().toLowerCase());                                                    
                                                break;
                                            case "mayuscula": 
                                                    texto.setText(texto.getText().toUpperCase());                                                                                                        
                                                break;
                                            case "negrilla":
                                                if(texto.getFont().getStyle()==2)
                                                {
                                                    texto.setFont(new Font(texto.getFont().getName(),3,texto.getFont().getSize()));
                                                }
                                                else
                                                {
                                                    texto.setFont(new Font(texto.getFont().getName(),1,texto.getFont().getSize()));
                                                }
                                                break;
                                            case "cursiva":
                                                if(texto.getFont().getSize()==1)
                                                {
                                                    texto.setFont(new Font(texto.getFont().getName(),3,texto.getFont().getSize()));
                                                }
                                                else
                                                {
                                                    texto.setFont(new Font(texto.getFont().getName(),2,texto.getFont().getSize()));
                                                }
                                                break;
                                            case "capital-t":
                                                String[] palabras = texto.getText().split(" ");
                                                String cadena = "";
                                                if(palabras.length>0)
                                                {
                                                    for(String palabra: palabras)
                                                    {
                                                        if(palabra.length()>2)
                                                        {
                                                            palabra = palabra.substring(0,1).toUpperCase() + palabra.substring(1,palabra.length()) + " ";                                                       
                                                            cadena = cadena + palabra;                                                            
                                                        }
                                                    }
                                                }
                                                texto.setText(cadena);
                                                break;
                                        }//Fin switch formato
                                    }// Fin verificacion de tipo Source.CCSS. nodo                                
                                }// Fin for de array
                            }// Fin verificacion tipo arrayList 
                            if(estiloElemento instanceof Source.CCSS.Ejecucion.tipoEstilo)
                            {
                                Source.CCSS.Ejecucion.tipoEstilo estilo = (Source.CCSS.Ejecucion.tipoEstilo)estiloElemento;
                                switch(estilo.getNombre().toLowerCase())
                                {
                                    case "alineado":
                                        String valor ="";
                                        if(estilo.getValor() instanceof String){ valor = (String)estilo.getValor();}
                                        switch(valor.toLowerCase())
                                        {
                                            case "izquierda": 
                                                texto.setAlignmentX(LEFT_ALIGNMENT);
                                                break;
                                            case "derecha": 
                                                texto.setAlignmentX(RIGHT_ALIGNMENT);
                                                break;
                                            case "centrado": 
                                                texto.setAlignmentX(CENTER_ALIGNMENT);
                                                break;                                                
                                        }
                                        break;// Fin caso alineado                                    
                                    case "texto":
                                        valor ="";
                                        if(estilo.getValor() instanceof String)
                                        {
                                            valor = (String)estilo.getValor();
                                            texto.setText(valor);
                                        }                                    
                                        break;                                    
                                    case "letra":
                                        valor ="";
                                        if(estilo.getValor() instanceof String){ valor = (String)estilo.getValor(); valor= quitarComillas(valor);}                                                                   
                                        try 
                                        {
                                            Font fuente = texto.getFont();                                                                                
                                            texto.setFont(new Font(valor, fuente.getStyle(), fuente.getSize()));   
                                        } 
                                        catch (Exception e)
                                        {
                                        }                               
                                        break;  // Fin caso letra
                                    case "tamtex":
                                        Double tamTex = 0.00;
                                        if(estilo.getValor() instanceof Double){ tamTex = (Double)estilo.getValor();}                                                                   
                                        try 
                                        {
                                            Font fuente = texto.getFont();  
                                            if(tamTex==0){tamTex = (double)fuente.getSize();}
                                            int tamText = Integer.valueOf(tamTex.intValue());
                                            texto.setFont(new Font(fuente.getName(), fuente.getStyle(), tamText));   
                                        } 
                                        catch (Exception e){}  
                                        break; //Fin caso tamtex
                                    case "visible":
                                        valor ="";
                                        Boolean visibilidad = true;
                                        if(estilo.getValor() instanceof Boolean){ visibilidad = (Boolean)estilo.getValor();}   
                                        texto.setVisible(visibilidad);
                                        break;//Fin visible 
                                    case "fondoelemento":
                                        valor ="";
                                        if(estilo.getValor() instanceof String)
                                        {
                                            valor = (String)estilo.getValor();
                                            valor = quitarComillas(valor);
                                            texto.setBackground(colorFuente(valor));
                                            //valor = (String)estilo.getValor();
                                            //panel.setColorFuente(colorFuente(valor));
                                        }
                                        break;//Fin colortext  
                                        
                                    case "borde":
                                        valor = "";
                                        if(estilo.getValor() instanceof ArrayList)
                                        {
                                            ArrayList arreglo = (ArrayList)estilo.getValor();
                                            String color ="";
                                            Boolean borde = true;
                                            int grosor = 10;
                                            
                                            for(Object item : arreglo )
                                            {
                                                if(item instanceof String)
                                                {
                                                    color = quitarComillas((String)item);
                                                }
                                                if(item instanceof Boolean)
                                                {                                                                                                                                                        
                                                     borde = (Boolean)item;                                                                                                       
                                                }
                                                if(item instanceof Double)
                                                {
                                                    Double auxiliar = (Double)item;
                                                    grosor = auxiliar.intValue();
                                                }
                                            }                                            
                                            if(!color.equals(""))
                                            {
                                                texto.setBorder(new LineBorder(colorFuente(color),grosor, borde));
                                            }                                            
                                        }
                                        break; // Fin caso borde   
                                    case "opaque":
                                        valor ="";
                                        Boolean opacacidad = true;
                                        if(estilo.getValor() instanceof Boolean){ opacacidad = (Boolean)estilo.getValor();}   
                                        texto.setOpaque(!opacacidad);
                                        break;//Fin Opacacidad      
                                    case "colortexto":                                        
                                        valor ="";
                                        if(estilo.getValor() instanceof String)
                                        {
                                            valor = (String)estilo.getValor();
                                            //texto.setColorFuente(colorFuente(valor));
                                            texto.setForeground(colorFuente(valor));
                                        }
                                        break;//Fin colortext                                          
                                }// Fin switch                                                                                                    
                            } // Fin if instancia estilo
                        }//Fin for
                    }//Fin if !=null
                    break;// Fin caso botón------------------------------------                    

                case "enlace"://----------------------------------------------------------enlace-----------------------------------------------------------------
                    Enlace enlace = (Enlace)elemento.getValor();
                    nodoEstilo = buscarEstilo(null,enlace.getId());            
                    /*Aplicamos los estilos*/
                    //Object estiloElemento = nodoEstilo.getAtributos().get(aum);
                    if(nodoEstilo!=null)
                    {
                        for(Object estiloElemento: nodoEstilo.getAtributos())
                        {
                            if(estiloElemento instanceof ArrayList)
                            { 
                                ArrayList arreglo = (ArrayList)estiloElemento;
                                for(Object element: arreglo)
                                {
                                    if(element instanceof Source.CCSS.AST.nodo)
                                    {
                                        Source.CCSS.AST.nodo elementArray = (Source.CCSS.AST.nodo)element;
                                        switch(quitarComillas(elementArray.texto).toLowerCase())
                                        {
                                            case "minuscula":                                                
                                                    enlace.setText(enlace.getText().toLowerCase());                                                    
                                                break;
                                            case "mayuscula": 
                                                    enlace.setText(enlace.getText().toUpperCase());                                                                                                        
                                                break;
                                            case "negrilla":
                                                if(enlace.getFont().getStyle()==2)
                                                {
                                                    enlace.setFont(new Font(enlace.getFont().getName(),3,enlace.getFont().getSize()));
                                                }
                                                else
                                                {
                                                    enlace.setFont(new Font(enlace.getFont().getName(),1,enlace.getFont().getSize()));
                                                }
                                                break;
                                            case "cursiva":
                                                if(enlace.getFont().getSize()==1)
                                                {
                                                    enlace.setFont(new Font(enlace.getFont().getName(),3,enlace.getFont().getSize()));
                                                }
                                                else
                                                {
                                                    enlace.setFont(new Font(enlace.getFont().getName(),2,enlace.getFont().getSize()));
                                                }
                                                break;
                                            case "capital-t":
                                                String[] palabras = enlace.getText().split(" ");
                                                String cadena = "";
                                                if(palabras.length>0)
                                                {
                                                    for(String palabra: palabras)
                                                    {
                                                        if(palabra.length()>2)
                                                        {
                                                            palabra = palabra.substring(0,1).toUpperCase() + palabra.substring(1,palabra.length()) + " ";                                                       
                                                            cadena = cadena + palabra;                                                            
                                                        }
                                                    }
                                                }
                                                enlace.setText(cadena);
                                                break;
                                        }//Fin switch formato
                                    }// Fin verificacion de tipo Source.CCSS. nodo                                
                                }// Fin for de array
                            }// Fin verificacion tipo arrayList 
                            if(estiloElemento instanceof Source.CCSS.Ejecucion.tipoEstilo)
                            {
                                Source.CCSS.Ejecucion.tipoEstilo estilo = (Source.CCSS.Ejecucion.tipoEstilo)estiloElemento;
                                switch(estilo.getNombre().toLowerCase())
                                {
                                    case "alineado":
                                        String valor ="";
                                        if(estilo.getValor() instanceof String){ valor = (String)estilo.getValor();}
                                        switch(valor.toLowerCase())
                                        {
                                            case "izquierda": 
                                                enlace.setAlignmentX(LEFT_ALIGNMENT);
                                                break;
                                            case "derecha": 
                                                enlace.setAlignmentX(RIGHT_ALIGNMENT);
                                                break;
                                            case "centrado": 
                                                enlace.setAlignmentX(CENTER_ALIGNMENT);
                                                break;                                                
                                        }
                                        break;// Fin caso alineado                                    
                                    case "enlace":
                                        valor ="";
                                        if(estilo.getValor() instanceof String)
                                        {
                                            valor = (String)estilo.getValor();
                                            enlace.setText(valor);
                                        }                                    
                                        break;                                    
                                    case "letra":
                                        valor ="";
                                        if(estilo.getValor() instanceof String){ valor = (String)estilo.getValor(); valor= quitarComillas(valor);}                                                                   
                                        try 
                                        {
                                            Font fuente = enlace.getFont();                                                                                
                                            enlace.setFont(new Font(valor, fuente.getStyle(), fuente.getSize()));   
                                        } 
                                        catch (Exception e)
                                        {
                                        }                               
                                        break;  // Fin caso letra
                                    case "tamtex":
                                        Double tamTex = 0.00;
                                        if(estilo.getValor() instanceof Double){ tamTex = (Double)estilo.getValor();}                                                                   
                                        try 
                                        {
                                            Font fuente = enlace.getFont();  
                                            if(tamTex==0){tamTex = (double)fuente.getSize();}
                                            int tamText = Integer.valueOf(tamTex.intValue());
                                            enlace.setFont(new Font(fuente.getName(), fuente.getStyle(), tamText));   
                                        } 
                                        catch (Exception e){}  
                                        break; //Fin caso tamtex
                                    case "visible":
                                        valor ="";
                                        Boolean visibilidad = true;
                                        if(estilo.getValor() instanceof Boolean){ visibilidad = (Boolean)estilo.getValor();}   
                                        enlace.setVisible(visibilidad);
                                        break;//Fin visible 
                                    case "fondoelemento":
                                        valor ="";
                                        if(estilo.getValor() instanceof String)
                                        {
                                            valor = (String)estilo.getValor();
                                            valor = quitarComillas(valor);
                                            enlace.setBackground(colorFuente(valor));
                                            //valor = (String)estilo.getValor();
                                            //panel.setColorFuente(colorFuente(valor));
                                        }
                                        break;//Fin colortext  
                                        
                                    case "borde":
                                        valor = "";
                                        if(estilo.getValor() instanceof ArrayList)
                                        {
                                            ArrayList arreglo = (ArrayList)estilo.getValor();
                                            String color ="";
                                            Boolean borde = true;
                                            int grosor = 10;
                                            
                                            for(Object item : arreglo )
                                            {
                                                if(item instanceof String)
                                                {
                                                    color = quitarComillas((String)item);
                                                }
                                                if(item instanceof Boolean)
                                                {                                                                                                                                                        
                                                     borde = (Boolean)item;                                                                                                       
                                                }
                                                if(item instanceof Double)
                                                {
                                                    Double auxiliar = (Double)item;
                                                    grosor = auxiliar.intValue();
                                                }
                                            }                                            
                                            if(!color.equals(""))
                                            {
                                                enlace.setBorder(new LineBorder(colorFuente(color),grosor, borde));
                                            }                                            
                                        }
                                        break; // Fin caso borde   
                                    case "opaque":
                                        valor ="";
                                        Boolean opacacidad = true;
                                        if(estilo.getValor() instanceof Boolean){ opacacidad = (Boolean)estilo.getValor();}   
                                        enlace.setOpaque(!opacacidad);
                                        break;//Fin Opacacidad      
                                    case "colorenlace":                                        
                                        valor ="";
                                        if(estilo.getValor() instanceof String)
                                        {
                                            valor = (String)estilo.getValor();
                                            //enlace.setColorFuente(colorFuente(valor));
                                            enlace.setForeground(colorFuente(valor));
                                        }
                                        break;//Fin colortext                                          
                                }// Fin switch                                                                                                    
                            } // Fin if instancia estilo
                        }//Fin for
                    }//Fin if !=null
                    break;// Fin caso botón------------------------------------                    
                    
                case "spinner"://----------------------------------------------------------spinner-----------------------------------------------------------------
                    Spinner spinner = (Spinner)elemento.getValor();
                    nodoEstilo = buscarEstilo(null,spinner.getId());            
                    /*Aplicamos los estilos*/
                    //Object estiloElemento = nodoEstilo.getAtributos().get(aum);
                    if(nodoEstilo!=null)
                    {
                        for(Object estiloElemento: nodoEstilo.getAtributos())
                        {
                            if(estiloElemento instanceof ArrayList)
                            { 
                                ArrayList arreglo = (ArrayList)estiloElemento;
                                for(Object element: arreglo)
                                {
                                    if(element instanceof Source.CCSS.AST.nodo)
                                    {
                                        Source.CCSS.AST.nodo elementArray = (Source.CCSS.AST.nodo)element;
                                        switch(quitarComillas(elementArray.texto).toLowerCase())
                                        {
                                            case "minuscula":                                                
                                                    //spinner.setText(spinner.getText().toLowerCase());                                                    
                                                break;
                                            case "mayuscula": 
                                                    //spinner.setText(spinner.getText().toUpperCase());                                                                                                        
                                                break;
                                            case "negrilla":
                                                if(spinner.getFont().getStyle()==2)
                                                {
                                                    spinner.setFont(new Font(spinner.getFont().getName(),3,spinner.getFont().getSize()));
                                                }
                                                else
                                                {
                                                    spinner.setFont(new Font(spinner.getFont().getName(),1,spinner.getFont().getSize()));
                                                }
                                                break;
                                            case "cursiva":
                                                if(spinner.getFont().getSize()==1)
                                                {
                                                    spinner.setFont(new Font(spinner.getFont().getName(),3,spinner.getFont().getSize()));
                                                }
                                                else
                                                {
                                                    spinner.setFont(new Font(spinner.getFont().getName(),2,spinner.getFont().getSize()));
                                                }
                                                break;

                                        }//Fin switch formato
                                    }// Fin verificacion de tipo Source.CCSS. nodo                                
                                }// Fin for de array
                            }// Fin verificacion tipo arrayList 
                            if(estiloElemento instanceof Source.CCSS.Ejecucion.tipoEstilo)
                            {
                                Source.CCSS.Ejecucion.tipoEstilo estilo = (Source.CCSS.Ejecucion.tipoEstilo)estiloElemento;
                                switch(estilo.getNombre().toLowerCase())
                                {
                                    case "alineado":
                                        String valor ="";
                                        if(estilo.getValor() instanceof String){ valor = (String)estilo.getValor();}
                                        switch(valor.toLowerCase())
                                        {
                                            case "izquierda": 
                                                spinner.setAlignmentX(LEFT_ALIGNMENT);
                                                break;
                                            case "derecha": 
                                                spinner.setAlignmentX(RIGHT_ALIGNMENT);
                                                break;
                                            case "centrado": 
                                                spinner.setAlignmentX(CENTER_ALIGNMENT);
                                                break;                                                
                                        }
                                        break;// Fin caso alineado                                    
                                    case "texto":
                                        valor ="";
                                        if(estilo.getValor() instanceof String)
                                        {
                                            valor = (String)estilo.getValor();
                                            //spinner.setText(valor);
                                        }                                    
                                        break;                                    
                                    case "letra":
                                        valor ="";
                                        if(estilo.getValor() instanceof String){ valor = (String)estilo.getValor(); valor= quitarComillas(valor);}                                                                   
                                        try 
                                        {
                                            Font fuente = spinner.getFont();                                                                                
                                            spinner.setFont(new Font(valor, fuente.getStyle(), fuente.getSize()));   
                                        } 
                                        catch (Exception e)
                                        {
                                        }                               
                                        break;  // Fin caso letra
                                    case "tamtex":
                                        Double tamTex = 0.00;
                                        if(estilo.getValor() instanceof Double){ tamTex = (Double)estilo.getValor();}                                                                   
                                        try 
                                        {
                                            Font fuente = spinner.getFont();  
                                            if(tamTex==0){tamTex = (double)fuente.getSize();}
                                            int tamText = Integer.valueOf(tamTex.intValue());
                                            spinner.setFont(new Font(fuente.getName(), fuente.getStyle(), tamText));   
                                        } 
                                        catch (Exception e){}  
                                        break; //Fin caso tamtex
                                    case "visible":
                                        valor ="";
                                        Boolean visibilidad = true;
                                        if(estilo.getValor() instanceof Boolean){ visibilidad = (Boolean)estilo.getValor();}   
                                        spinner.setVisible(visibilidad);
                                        break;//Fin visible 
                                    case "fondoelemento":
                                        valor ="";
                                        if(estilo.getValor() instanceof String)
                                        {
                                            valor = (String)estilo.getValor();
                                            valor = quitarComillas(valor);
                                            spinner.setBackground(colorFuente(valor));
                                            //valor = (String)estilo.getValor();
                                            //panel.setColorFuente(colorFuente(valor));
                                        }
                                        break;//Fin colortext  
                                        
                                    case "borde":
                                        valor = "";
                                        if(estilo.getValor() instanceof ArrayList)
                                        {
                                            ArrayList arreglo = (ArrayList)estilo.getValor();
                                            String color ="";
                                            Boolean borde = true;
                                            int grosor = 10;
                                            
                                            for(Object item : arreglo )
                                            {
                                                if(item instanceof String)
                                                {
                                                    color = quitarComillas((String)item);
                                                }
                                                if(item instanceof Boolean)
                                                {                                                                                                                                                        
                                                     borde = (Boolean)item;                                                                                                       
                                                }
                                                if(item instanceof Double)
                                                {
                                                    Double auxiliar = (Double)item;
                                                    grosor = auxiliar.intValue();
                                                }
                                            }                                            
                                            if(!color.equals(""))
                                            {
                                                spinner.setBorder(new LineBorder(colorFuente(color),grosor, borde));
                                            }                                            
                                        }
                                        break; // Fin caso borde   
                                    case "opaque":
                                        valor ="";
                                        Boolean opacacidad = true;
                                        if(estilo.getValor() instanceof Boolean){ opacacidad = (Boolean)estilo.getValor();}   
                                        spinner.setOpaque(!opacacidad);
                                        break;//Fin Opacacidad      
                                    case "colortexto":                                        
                                        valor ="";
                                        if(estilo.getValor() instanceof String)
                                        {
                                            valor = (String)estilo.getValor();
                                            //spinner.setColorFuente(colorFuente(valor));
                                            spinner.setForeground(colorFuente(valor));
                                        }
                                        break;//Fin colortext                                          
                                }// Fin switch                                                                                                    
                            } // Fin if instancia estilo
                        }//Fin for
                    }//Fin if !=null
                    break;// Fin caso spinner------------------------------------
                    
                case "tabla"://----------------------------------------------------------tabla-----------------------------------------------------------------
                    Tab tabla = (Tab)elemento.getValor();
                    nodoEstilo = buscarEstilo(null,tabla.getId());            
                    /*Aplicamos los estilos*/
                    //Object estiloElemento = nodoEstilo.getAtributos().get(aum);
                    if(nodoEstilo!=null)
                    {
                        for(Object estiloElemento: nodoEstilo.getAtributos())
                        {
                            if(estiloElemento instanceof ArrayList)
                            { 
                                ArrayList arreglo = (ArrayList)estiloElemento;
                                for(Object element: arreglo)
                                {
                                    if(element instanceof Source.CCSS.AST.nodo)
                                    {
                                        Source.CCSS.AST.nodo elementArray = (Source.CCSS.AST.nodo)element;
                                        switch(quitarComillas(elementArray.texto).toLowerCase())
                                        {
                                            case "minuscula":                                                
                                                 //   tabla.setText(tabla.getText().toLowerCase());                                                    
                                                break;
                                            case "mayuscula": 
                                                  //  tabla.setText(tabla.getText().toUpperCase());                                                                                                        
                                                break;
                                            case "negrilla":
                                                if(tabla.getFont().getStyle()==2)
                                                {
                                                    tabla.setFont(new Font(tabla.getFont().getName(),3,tabla.getFont().getSize()));
                                                }
                                                else
                                                {
                                                    tabla.setFont(new Font(tabla.getFont().getName(),1,tabla.getFont().getSize()));
                                                }
                                                break;
                                            case "cursiva":
                                                if(tabla.getFont().getSize()==1)
                                                {
                                                    tabla.setFont(new Font(tabla.getFont().getName(),3,tabla.getFont().getSize()));
                                                }
                                                else
                                                {
                                                    tabla.setFont(new Font(tabla.getFont().getName(),2,tabla.getFont().getSize()));
                                                }
                                                break;
                                            case "capital-t":
                                               /* String[] palabras = tabla.getText().split(" ");
                                                String cadena = "";
                                                if(palabras.length>0)
                                                {
                                                    for(String palabra: palabras)
                                                    {
                                                        if(palabra.length()>2)
                                                        {
                                                            palabra = palabra.substring(0,1).toUpperCase() + palabra.substring(1,palabra.length()) + " ";                                                       
                                                            cadena = cadena + palabra;                                                            
                                                        }
                                                    }
                                                }
                                                tabla.setText(cadena);*/
                                                break;
                                        }//Fin switch formato
                                    }// Fin verificacion de tipo Source.CCSS. nodo                                
                                }// Fin for de array
                            }// Fin verificacion tipo arrayList 
                            if(estiloElemento instanceof Source.CCSS.Ejecucion.tipoEstilo)
                            {
                                Source.CCSS.Ejecucion.tipoEstilo estilo = (Source.CCSS.Ejecucion.tipoEstilo)estiloElemento;
                                switch(estilo.getNombre().toLowerCase())
                                {
                                    case "alineado":
                                        String valor ="";
                                        if(estilo.getValor() instanceof String){ valor = (String)estilo.getValor();}
                                        switch(valor.toLowerCase())
                                        {
                                            case "izquierda": 
                                                tabla.setAlignmentX(LEFT_ALIGNMENT);
                                                break;
                                            case "derecha": 
                                                tabla.setAlignmentX(RIGHT_ALIGNMENT);
                                                break;
                                            case "centrado": 
                                                tabla.setAlignmentX(CENTER_ALIGNMENT);
                                                break;                                                
                                        }
                                        break;// Fin caso alineado                                    
                                    case "texto":
                                        valor ="";
                                        if(estilo.getValor() instanceof String)
                                        {
                                            valor = (String)estilo.getValor();
                                            //tabla.setText(valor);
                                        }                                    
                                        break;                                    
                                    case "letra":
                                        valor ="";
                                        if(estilo.getValor() instanceof String){ valor = (String)estilo.getValor(); valor= quitarComillas(valor);}                                                                   
                                        try 
                                        {
                                            Font fuente = tabla.getFont();                                                                                
                                            tabla.setFont(new Font(valor, fuente.getStyle(), fuente.getSize()));   
                                        } 
                                        catch (Exception e)
                                        {
                                        }                               
                                        break;  // Fin caso letra
                                    case "tamtex":
                                        Double tamTex = 0.00;
                                        if(estilo.getValor() instanceof Double){ tamTex = (Double)estilo.getValor();}                                                                   
                                        try 
                                        {
                                            Font fuente = tabla.getFont();  
                                            if(tamTex==0){tamTex = (double)fuente.getSize();}
                                            int tamText = Integer.valueOf(tamTex.intValue());
                                            tabla.setFont(new Font(fuente.getName(), fuente.getStyle(), tamText));   
                                        } 
                                        catch (Exception e){}  
                                        break; //Fin caso tamtex
                                    case "visible":
                                        valor ="";
                                        Boolean visibilidad = true;
                                        if(estilo.getValor() instanceof Boolean){ visibilidad = (Boolean)estilo.getValor();}   
                                        tabla.setVisible(visibilidad);
                                        break;//Fin visible 
                                    case "fondoelemento":
                                        valor ="";
                                        if(estilo.getValor() instanceof String)
                                        {
                                            valor = (String)estilo.getValor();
                                            valor = quitarComillas(valor);
                                            tabla.setBackground(colorFuente(valor));
                                            //valor = (String)estilo.getValor();
                                            //panel.setColorFuente(colorFuente(valor));
                                        }
                                        break;//Fin colortext  
                                        
                                    case "borde":
                                        valor = "";
                                        if(estilo.getValor() instanceof ArrayList)
                                        {
                                            ArrayList arreglo = (ArrayList)estilo.getValor();
                                            String color ="";
                                            Boolean borde = true;
                                            int grosor = 10;
                                            
                                            for(Object item : arreglo )
                                            {
                                                if(item instanceof String)
                                                {
                                                    color = quitarComillas((String)item);
                                                }
                                                if(item instanceof Boolean)
                                                {                                                                                                                                                        
                                                     borde = (Boolean)item;                                                                                                       
                                                }
                                                if(item instanceof Double)
                                                {
                                                    Double auxiliar = (Double)item;
                                                    grosor = auxiliar.intValue();
                                                }
                                            }                                            
                                            if(!color.equals(""))
                                            {
                                                tabla.setBorder(new LineBorder(colorFuente(color),grosor, borde));
                                            }                                            
                                        }
                                        break; // Fin caso borde   
                                    case "opaque":
                                        valor ="";
                                        Boolean opacacidad = true;
                                        if(estilo.getValor() instanceof Boolean){ opacacidad = (Boolean)estilo.getValor();}   
                                        tabla.setOpaque(!opacacidad);
                                        break;//Fin Opacacidad      
                                    case "colortexto":                                        
                                        valor ="";
                                        if(estilo.getValor() instanceof String)
                                        {
                                            valor = (String)estilo.getValor();
                                            //tabla.setColorFuente(colorFuente(valor));
                                            tabla.setForeground(colorFuente(valor));
                                        }
                                        break;//Fin colortext                                          
                                }// Fin switch                                                                                                    
                            } // Fin if instancia estilo
                        }//Fin for
                    }//Fin if !=null
                    break;// Fin caso botón------------------------------------                    
                    
                    
            }//Fin switch principal.
        }        
    }    


    
    /*Buscar el grupo de estilo ccss*/
    public Source.CCSS.Ejecucion.nodoLista buscarEstilo(String grupo, String id)
    {
        Source.CCSS.Ejecucion.nodoLista estiloEncon = null;
        for(Source.CCSS.Ejecucion.nodoLista nodo : estilosPagina)
        {    
            if(grupo!=null)
            {
                if(nodo.getIdentificador().equals(grupo))
                {
                    return nodo;
                }                
            }
            if(id!=null)
            {
                if(nodo.getIdentificador().equals(id) )
                {
                    return nodo;                                
                }                
            }            

        }        
        return estiloEncon;
    }
    
    /*Guardar errores semanticos.*/
    public void agregarError(String descripcion, String texto)
    {
        Errores error = new Errores();
        error.setColumna(0);
        error.setLinea(0);
        error.setDescripcion(descripcion);
        error.setTexto(texto);
        error.setTipo("Semantico");        
        erroresSemanticos.add(error);
    }
    
    public boolean existeElemento2(String id, ArrayList<Elemento> elementosLista)
    {
        boolean result=false;
        
  
        for(Elemento item :elementosLista)
        {
           if(item.getNombre().equals(id))
           {
               return true;
           }
           else
           {
               
               if(item.getValor() instanceof Panel)
               {
                   Panel panelInicial = (Panel)item.getValor();
                   
                   ArrayList items = panelInicial.getElementos();
                   for(Object obj : items)
                   {
                       if(obj instanceof Elemento)
                       {
                           Elemento temp = (Elemento) obj;
                           switch(temp.getTipo().toLowerCase())
                           {
                               case "boton":
                                   Boton btn = (Boton)temp.getValor();
                                   if(btn.getId().equals(id)){return true;}
                                   break;
                               case "caja":
                                   Caja cjt = (Caja)temp.getValor();
                                   if(cjt.getId().equals(id)){return true;}
                                   break;  
                               case "cajaopciones":
                                   CajaOpciones cjtO = (CajaOpciones)temp.getValor();
                                   if(cjtO.getId().equals(id)){return true;}
                                   break;  
                               case "enlace":
                                   Enlace enlace = (Enlace)temp.getValor();
                                   if(enlace.getId().equals(id)){return true;}
                                   break;     
                               case "imagen":
                                   Imagen img = (Imagen)temp.getValor();
                                   if(img.getId().equals(id)){return true;}
                                   break;    
                               case "panel":
                                   Panel pnl = (Panel)temp.getValor();
                                   if(pnl.getId().equals(id)){return true;}
                                   else
                                   {
                                       result = false;
                                       if(pnl.getElementos().isEmpty())
                                       {
                                           result =existeElemento2(id,pnl.getElementos());
                                       }                                       
                                   }
                                   break; 
                               case "spinner":
                                   Spinner spn = (Spinner)temp.getValor();
                                   if(spn.getId().equals(id)){return true;}
                                   break;  
                               case "tabla":
                                   Tab tab = (Tab)temp.getValor();
                                   if(tab.getId().equals(id)){return true;}
                                   else
                                   {
                                       result = false;
                                       if(tab.getElementos().isEmpty())
                                       {
                                           result =existeElemento2(id,tab.getElementos());
                                       }
                                   }                                   
                                   break; 
                               case "texto":
                                   Texto txt = (Texto)temp.getValor();
                                   if(txt.getId().equals(id)){return true;}
                                   break;  
                               case "areatexto":
                                   areaTexto txtArea = (areaTexto)temp.getValor();
                                   if(txtArea.getId().equals(id)){return true;}
                                   break;                                     
                           }
                       }                       
                   }
               }
           }
        }                
        return false;        
    }
    
    
    public boolean existeElemento(String id)
    {
        return existeElement(id, panelPrincipal);
    }
    
    public boolean existeElement(String id, Object contenedor)
    {

        Enumeration e = opciones.elements();
        Object valor;

        while( e.hasMoreElements() ){

             valor = e.nextElement();
             if (valor instanceof Opcion)
             {
                 Opcion op = (Opcion)valor;
                 if(op.getId().equals(id))
                 {
                     return true;
                 }
             }
        }

         
        
        
        boolean existe = false;
        if(contenedor instanceof Panel)
        {
            Panel panel = (Panel)contenedor;
            Component[] componentes = panel.getComponents(); 
            if(id.equals("cuerpo")){return true;}
            for(Component comp: componentes)
            {
                if(comp instanceof Panel && existe == false){ Panel pnl = (Panel)comp; if(pnl.getId().equals(id)){existe = true;}else{ existe=(existeElement(id,pnl));}}
                if(comp instanceof Boton && existe == false){ Boton item = (Boton)comp; if(item.getId().equals(id)){existe = true;}}
                if(comp instanceof Caja && existe == false){ Caja item = (Caja)comp; if(item.getId().equals(id)){existe = true;}}
                if(comp instanceof CajaOpciones && existe == false){CajaOpciones item = (CajaOpciones)comp; if(item.getId().equals(id)){existe = true;}}
                if(comp instanceof Enlace && existe == false){ Enlace item = (Enlace)comp; if(item.getId().equals(id)){existe = true;}}
                if(comp instanceof Imagen && existe == false){ Imagen item = (Imagen)comp; if(item.getId()!=null){if(item.getId().equals(id)){existe = true;}}}
                if(comp instanceof Spinner && existe == false){ Spinner item = (Spinner)comp; if(item.getId().equals(id)){existe = true;}}
                if(comp instanceof Tab && existe == false){ Tab item = (Tab)comp;if(item.getId().equals(id)){existe = true;}else{existe=(existeElement(id,item));}}
                if(comp instanceof Texto && existe == false){ Texto item = (Texto)comp; if(item.getId().equals(id)){existe = true;}}
                if(comp instanceof areaTexto && existe == false){areaTexto item = (areaTexto)comp; if(item.getId().equals(id)){existe = true;}}            
            }             
        }
        if(contenedor instanceof Tab)
        {
            Tab panel = (Tab)contenedor;
            Component[] componentes = panel.getComponents(); 
            if(id.equals("cuerpo")){return true;}
            for(Component comp: componentes)
            {
                if(comp instanceof Panel && existe == false){ Panel pnl = (Panel)comp; if(pnl.getId().equals(id)){existe = true;}else{ existe=(existeElement(id,pnl));}}
                if(comp instanceof Boton && existe == false){ Boton item = (Boton)comp; if(item.getId().equals(id)){existe = true;}}
                if(comp instanceof Caja && existe == false){ Caja item = (Caja)comp; if(item.getId().equals(id)){existe = true;}}
                if(comp instanceof CajaOpciones && existe == false){CajaOpciones item = (CajaOpciones)comp; if(item.getId().equals(id)){existe = true;}}
                if(comp instanceof Enlace && existe == false){ Enlace item = (Enlace)comp; if(item.getId().equals(id)){existe = true;}}
                if(comp instanceof Imagen && existe == false){ Imagen item = (Imagen)comp; if(item.getId()!=null){if(item.getId().equals(id)){existe = true;}}}
                if(comp instanceof Spinner && existe == false){ Spinner item = (Spinner)comp; if(item.getId().equals(id)){existe = true;}}
                if(comp instanceof Tab && existe == false){ Tab item = (Tab)comp; if(item.getId().equals(id)){existe = true;}else{ existe=(existeElement(id,item));}}
                if(comp instanceof Texto && existe == false){ Texto item = (Texto)comp; if(item.getId().equals(id)){existe = true;}}
                if(comp instanceof areaTexto && existe == false){areaTexto item = (areaTexto)comp; if(item.getId().equals(id)){existe = true;}}            
            }             
        }        
        //System.out.println(id + "\tResultado "+ existe +"\tPanel " + contenedor.getId());
        return existe;        
    }    

    
    public void modificarAtributo(String id, String atributo, Object valor)
    {
        modificarAtri(id, atributo, valor, panelPrincipal);
    }    
    @SuppressWarnings("empty-statement")
    public void modificarAtri(String id, String atributo, Object valor, Object contenedor)
    {

        Enumeration e = opciones.elements();
        Object val;

        while( e.hasMoreElements() ){

             val = e.nextElement();
             if (val instanceof Opcion)
             {
                 Opcion op = (Opcion)val;
                 if(op.getId().equals(id))
                 {
                     switch(atributo)
                     {
                         case "click":
                             op.setMetodo(valor);                             
                             break;                         
                     }                     
                 }
                 //opciones.remove(op.getCadena());
                 opciones.put( op.getCadena(), op);
             }
        }

        
        Component[] componentes = null ;//;= contenedor.getComponents();
        if(contenedor instanceof Panel ){ componentes = ((Panel)contenedor).getComponents();}
        if(contenedor instanceof Tab ){ componentes = ((Tab)contenedor).getComponents();}
        
        for(Component comp: componentes)
        {
            if(valor instanceof String)
            {
                String id_ = (String)valor;
                if(comp instanceof Panel)
                {
                    Panel pan = (Panel)comp;
                    modificarAtri(id, atributo, valor, pan);
                }
                
                switch(atributo)
                {                    
                    case "id":
                        if(comp instanceof Panel){Panel pnl = (Panel)comp; if(id.equals(pnl.getId())){pnl.setId(id_); actualizarEstilos(pnl.getId(),pnl.getGrupo(),pnl);}else{modificarAtri(id,atributo,valor,pnl);}}
                        if(comp instanceof Boton){Boton btn = (Boton)comp; if(id.equals(btn.getId())){btn.setId(id_);actualizarEstilos(btn.getId(),btn.getGrupo(),btn);}}
                        if(comp instanceof Caja){Caja cjt = (Caja)comp; if(id.equals(cjt.getId())){cjt.setId(id_);actualizarEstilos(cjt.getId(),cjt.getGrupo(),cjt);}}
                        if(comp instanceof CajaOpciones){CajaOpciones cjtO= (CajaOpciones)comp; if(id.equals(cjtO.getId())){cjtO.setId(id_);actualizarEstilos(cjtO.getId(),cjtO.getGrupo(),cjtO);}}
                        if(comp instanceof Enlace){Enlace enl = (Enlace)comp; if(id.equals(enl.getId())){enl.setId(id_);actualizarEstilos(enl.getId(),enl.getGrupo(),enl);}}
                        if(comp instanceof Imagen){Imagen img = (Imagen)comp; if(id.equals(img.getId())){img.setId(id_);actualizarEstilos(img.getId(),img.getGrupo(),img);}}
                        if(comp instanceof Texto){Texto img = (Texto)comp; if(id.equals(img.getId())){img.setId(id_);actualizarEstilos(img.getId(),img.getGrupo(),img);}}
                        if(comp instanceof Spinner){Spinner spn = (Spinner)comp; if(id.equals(spn.getId())){spn.setId(id_);actualizarEstilos(spn.getId(),spn.getGrupo(),spn);}}
                        if(comp instanceof Tab){Tab tab = (Tab)comp; if(id.equals(tab.getId())){tab.setId(id_);}else{modificarAtri(id,atributo,valor,tab);actualizarEstilos(tab.getId(),tab.getGrupo(),tab);}}
                        if(comp instanceof areaTexto){areaTexto areaT = (areaTexto)comp; if(id.equals(areaT.getId())){areaT.setId(id_);actualizarEstilos(areaT.getId(),areaT.getGrupo(),areaT);}}
                        break;
                    case "grupo":
                        if(comp instanceof Panel){Panel pnl = (Panel)comp; if(id.equals(pnl.getId())){pnl.setGrupo(id_); actualizarEstilos(pnl.getId(),pnl.getGrupo(),pnl);}else{modificarAtri(id,atributo,valor,pnl);}}
                        if(comp instanceof Boton){Boton btn = (Boton)comp; if(id.equals(btn.getId())){
                            btn.setGrupo(id_);
                            actualizarEstilos(btn.getId(),btn.getGrupo(),btn);}}
                        if(comp instanceof Caja){Caja cjt = (Caja)comp; if(id.equals(cjt.getId())){cjt.setGrupo(id_);actualizarEstilos(cjt.getId(),cjt.getGrupo(),cjt);}}
                        if(comp instanceof CajaOpciones){CajaOpciones cjtO= (CajaOpciones)comp; if(id.equals(cjtO.getId())){cjtO.setGrupo(id_);actualizarEstilos(cjtO.getId(),cjtO.getGrupo(),cjtO);}}
                        if(comp instanceof Enlace){Enlace enl = (Enlace)comp; if(id.equals(enl.getId())){enl.setGrupo(id_);actualizarEstilos(enl.getId(),enl.getGrupo(),enl);}}
                        if(comp instanceof Texto){Texto enl = (Texto)comp; if(id.equals(enl.getId())){enl.setGrupo(id_);actualizarEstilos(enl.getId(),enl.getGrupo(),enl);}}
                        if(comp instanceof Imagen){Imagen img = (Imagen)comp; if(id.equals(img.getId())){img.setGrupo(id_);actualizarEstilos(img.getId(),img.getGrupo(),img);}}
                        if(comp instanceof Spinner){Spinner spn = (Spinner)comp; if(id.equals(spn.getId())){spn.setGrupo(id_);actualizarEstilos(spn.getId(),spn.getGrupo(),spn);}}
                        if(comp instanceof Tab){Tab tab = (Tab)comp; if(id.equals(tab.getId())){tab.setGrupo(id_);}else{modificarAtri(id,atributo,valor,tab);actualizarEstilos(tab.getId(),tab.getGrupo(),tab);}}
                        if(comp instanceof areaTexto){areaTexto areaT = (areaTexto)comp; if(id.equals(areaT.getId())){areaT.setGrupo(id_);actualizarEstilos(areaT.getId(),areaT.getGrupo(),areaT);}}
                        break;
                    case "alineado":
                        if(comp instanceof Panel){Panel pnl = (Panel)comp; if(id.equals(pnl.getId())){pnl.setAlineado(id_);}else{modificarAtri(id,atributo,valor,pnl);}}
                        if(comp instanceof Boton){Boton btn = (Boton)comp; if(id.equals(btn.getId())){btn.setAlineado(id_);}}
                        if(comp instanceof Caja){Caja cjt = (Caja)comp;if(id.equals(cjt.getId())){cjt.setAlineado(id_);}}
                        if(comp instanceof CajaOpciones){CajaOpciones cjtO= (CajaOpciones)comp; if(id.equals(cjtO.getId())){cjtO.setAlineado(id_);}}
                        if(comp instanceof Enlace){Enlace enl = (Enlace)comp; if(id.equals(enl.getId())){enl.setAlineado(id_);}}
                        if(comp instanceof Imagen){Imagen img = (Imagen)comp; if(id.equals(img.getId())){img.setAlineado(id_);}}
                        if(comp instanceof Spinner){Spinner spn = (Spinner)comp; if(id.equals(spn.getId())){spn.setAlineado(id_);}}
                        if(comp instanceof Tab){Tab tab = (Tab)comp; if(id.equals(tab.getId())){tab.setAlineado(id_);}else{modificarAtri(id,atributo,valor,tab);}}
                        if(comp instanceof areaTexto){areaTexto areaT = (areaTexto)comp; if(id.equals(areaT.getId())){areaT.setAlineado(id_);}}                      
                        break;   
                    case "texto":
                        if(comp instanceof Panel){Panel pnl = (Panel)comp; if(id.equals(pnl.getId())){pnl.setTexto(quitarComillas(id_));}else{modificarAtri(id,atributo,valor,pnl);}}
                        if(comp instanceof Boton){Boton btn = (Boton)comp; if(id.equals(btn.getId())){btn.setText(quitarComillas(id_));}}
                        if(comp instanceof Caja){Caja cjt = (Caja)comp; if(id.equals(cjt.getId())){cjt.setText(quitarComillas(id_));}}
                        if(comp instanceof CajaOpciones){CajaOpciones cjtO= (CajaOpciones)comp; /*if(id.equals(cjtO.getId())){cjtO.setTexto(id_);}*/}
                        if(comp instanceof Enlace){Enlace enl = (Enlace)comp; if(id.equals(enl.getId())){enl.setText(quitarComillas(id_));}}
                        if(comp instanceof Imagen){Imagen img = (Imagen)comp; if(id.equals(img.getId())){img.setText(quitarComillas(id_));}}
                        if(comp instanceof Spinner){Spinner spn = (Spinner)comp; if(esNumero(id_)){spn.setValue(Integer.valueOf(quitarComillas(id_)));}}
                        if(comp instanceof Tab){Tab tab = (Tab)comp; modificarAtri(id,atributo,valor,tab);}
                        if(comp instanceof areaTexto){areaTexto areaT = (areaTexto)comp; areaT.setText(quitarComillas(id_));}                       
                        break; 
                    case "ruta":
                        if(comp instanceof Panel){Panel pnl = (Panel)comp; if(id.equals(pnl.getId())){pnl.setRuta(id_);}else{modificarAtri(id,atributo,valor,pnl);}}
                        if(comp instanceof Boton){Boton btn = (Boton)comp; if(id.equals(btn.getId())){btn.setRuta(id_);}}
                        if(comp instanceof Caja){Caja cjt = (Caja)comp; if(id.equals(cjt.getId())){cjt.setRuta(id_);}}
                        if(comp instanceof CajaOpciones){CajaOpciones cjtO= (CajaOpciones)comp; /*if(id.equals(cjtO.getId())){cjtO.setTexto(id_);}*/}
                        if(comp instanceof Enlace){Enlace enl = (Enlace)comp; if(id.equals(enl.getId())){enl.setRuta(id_);}}
                        if(comp instanceof Imagen){Imagen img = (Imagen)comp; if(id.equals(img.getId())){img.setRuta(id_); setImagen(img);} 
}                        if(comp instanceof Spinner){Spinner spn = (Spinner)comp; if(esNumero(id_)){/*spn.setValue(Integer.valueOf(id_));*/}}
                        if(comp instanceof Tab){Tab tab = (Tab)comp; modificarAtri(id,atributo,valor,tab);}
                        if(comp instanceof areaTexto){areaTexto areaT = (areaTexto)comp; areaT.setRuta(id_);}                       
                        break;                        
                    case "letra":   
                        if(comp instanceof Panel){modificarAtri(id,atributo,valor,comp);}
                        if(comp instanceof Tab){modificarAtri(id,atributo,valor,comp);}
                        if(comp instanceof Boton)
                        {
                            Boton btn = (Boton)comp; 
                            if(id.equals(btn.getId()))
                            {
                                if(esNumero(id_))
                                {
                                    btn.setFont(new Font(btn.getFont().getName(),btn.getFont().getStyle(),Integer.valueOf(id_)));
                                }
                                else
                                {
                                    btn.setFont(new Font(id_,btn.getFont().getStyle(),btn.getFont().getSize()));
                                }
                            }
                        }
                        if(comp instanceof Caja)
                        {
                            Caja cjt = (Caja)comp; 
                            if(cjt.getId().equals(id))
                            {
                                if(esNumero(id_))
                                {
                                    cjt.setFont(new Font(cjt.getFont().getName(),cjt.getFont().getStyle(),Integer.valueOf(id_)));
                                }
                                else
                                {
                                    cjt.setFont(new Font(id_,cjt.getFont().getStyle(),cjt.getFont().getSize()));
                                }
                            }
                        }      
                        if(comp instanceof CajaOpciones)
                        {
                            CajaOpciones cjtO = (CajaOpciones)comp; 
                            if(cjtO.getId().equals(id))
                            {
                                if(esNumero(id_))
                                {
                                    cjtO.setFont(new Font(cjtO.getFont().getName(),cjtO.getFont().getStyle(),Integer.valueOf(id_)));
                                }
                                else
                                {
                                    cjtO.setFont(new Font(id_,cjtO.getFont().getStyle(),cjtO.getFont().getSize()));
                                }
                            }
                        }   
                        if(comp instanceof Enlace)
                        {
                            Enlace enl = (Enlace)comp; 
                            if(enl.getId().equals(id))
                            {
                                if(esNumero(id_))
                                {
                                    enl.setFont(new Font(enl.getFont().getName(),enl.getFont().getStyle(),Integer.valueOf(id_)));
                                }
                                else
                                {
                                    enl.setFont(new Font(id_,enl.getFont().getStyle(),enl.getFont().getSize()));
                                }
                            }
                        }   
                        if(comp instanceof Spinner)
                        {
                            Spinner spn = (Spinner)comp; 
                            if(spn.getId().equals(id))
                            {
                                if(esNumero(id_))
                                {
                                    spn.setFont(new Font(spn.getFont().getName(),spn.getFont().getStyle(),Integer.valueOf(id_)));
                                }
                                else
                                {
                                    spn.setFont(new Font(id_,spn.getFont().getStyle(),spn.getFont().getSize()));
                                }
                            }
                        }   
                        if(comp instanceof areaTexto)
                        {
                            areaTexto areaT = (areaTexto)comp; 
                            if(areaT.getId().equals(id))
                            {
                                if(esNumero(id_))
                                {
                                    areaT.setFont(new Font(areaT.getFont().getName(),areaT.getFont().getStyle(),Integer.valueOf(id_)));
                                }
                                else
                                {
                                    areaT.setFont(new Font(id_,areaT.getFont().getStyle(),areaT.getFont().getSize()));
                                }
                            }
                        }                                                                                              
                        break;  
                    case "fondoelemento":
                        if(comp instanceof Panel){Panel pnl = (Panel)comp; if(id.equals(pnl.getId())){pnl.setBackground(colorFuente(id_));}else{modificarAtri(id,atributo,valor,pnl);}}
                        if(comp instanceof Boton){Boton btn = (Boton)comp; if(id.equals(btn.getId())){btn.setBackground(colorFuente(id_));}}
                        if(comp instanceof Caja){Caja cjt = (Caja)comp; if(id.equals(cjt.getId())){cjt.setBackground(colorFuente(id_));}}
                        if(comp instanceof CajaOpciones){CajaOpciones cjtO= (CajaOpciones)comp; if(id.equals(cjtO.getId())){cjtO.setBackground(colorFuente(id_));}}
                        if(comp instanceof Enlace){Enlace enl = (Enlace)comp;  if(id.equals(enl.getId())){enl.setBackground(colorFuente(id_));}}
                        if(comp instanceof Imagen){Imagen img = (Imagen)comp;  if(id.equals(img.getId())){img.setBackground(colorFuente(id_));}}
                        if(comp instanceof Spinner){Spinner spn = (Spinner)comp; if(id.equals(spn.getId())){spn.setBackground(colorFuente(id_));}}
                        if(comp instanceof Tab){Tab tab = (Tab)comp;  if(id.equals(tab.getId())){tab.setBackground(colorFuente(id_));}else{modificarAtri(id,atributo,valor,tab);}}
                        if(comp instanceof areaTexto){areaTexto areaT = (areaTexto)comp;  if(id.equals(areaT.getId())){areaT.setBackground(colorFuente(id_));}}
                        if(id.equals("cuerpo")){panelPrincipal.setBackground(colorFuente(id_));}
                        break;                        
                    case "visible":
                        if(comp instanceof Panel){Panel pnl = (Panel)comp; if(id.equals(pnl.getId())){if(id_.equals("true")){pnl.setVisible(true);}if(id_.equals("false")){pnl.setVisible(false);}}else{modificarAtri(id,atributo,valor,pnl);} }
                        if(comp instanceof Boton){Boton btn = (Boton)comp;if(id.equals(btn.getId())){ if(id_.equals("true")){btn.setVisible(true);}if(id_.equals("false")){btn.setVisible(false);} }}
                        if(comp instanceof Caja){Caja cjt = (Caja)comp; if(id.equals(cjt.getId())){ if(id_.equals("true")){cjt.setVisible(true);}if(id_.equals("false")){cjt.setVisible(false);} }}
                        if(comp instanceof CajaOpciones){CajaOpciones cjtO= (CajaOpciones)comp; if(id.equals(cjtO.getId())){ if(id_.equals("true")){cjtO.setVisible(true);}if(id_.equals("false")){cjtO.setVisible(false);} }}
                        if(comp instanceof Enlace){Enlace enl = (Enlace)comp; if(id.equals(enl.getId())){ if(id_.equals("true")){enl.setVisible(true);}if(id_.equals("false")){enl.setVisible(false);} }}
                        if(comp instanceof Imagen){Imagen img = (Imagen)comp; if(id.equals(img.getId())){ if(id_.equals("true")){img.setVisible(true);}if(id_.equals("false")){img.setVisible(false);} }}
                        if(comp instanceof Spinner){Spinner spn = (Spinner)comp; if(id.equals(spn.getId())){ if(id_.equals("true")){spn.setVisible(true);}if(id_.equals("false")){spn.setVisible(false);} }}
                        if(comp instanceof Tab){Tab tab = (Tab)comp;if(id.equals(tab.getId())){ if(id_.equals("true")){tab.setVisible(true);}if(id_.equals("false")){tab.setVisible(false);} }else{modificarAtri(id,atributo,valor,tab);}}
                        if(comp instanceof areaTexto){areaTexto areaT = (areaTexto)comp; if(id.equals(areaT.getId())){ if(id_.equals("true")){areaT.setVisible(true);}if(id_.equals("false")){areaT.setVisible(false);} }}
                        break; 
                    case "colortext":
                        if(comp instanceof Panel){Panel pnl = (Panel)comp; if(id.equals(pnl.getId())){pnl.setForeground(colorFuente(id_));}else{modificarAtri(id,atributo,valor,pnl);}}
                        if(comp instanceof Boton){Boton btn = (Boton)comp; if(id.equals(btn.getId())){btn.setForeground(colorFuente(id_));}}
                        if(comp instanceof Caja){Caja cjt = (Caja)comp; if(id.equals(cjt.getId())){cjt.setForeground(colorFuente(id_));}}
                        if(comp instanceof CajaOpciones){CajaOpciones cjtO= (CajaOpciones)comp; if(id.equals(cjtO.getId())){cjtO.setForeground(colorFuente(id_));;}}
                        if(comp instanceof Enlace){Enlace enl = (Enlace)comp; if(id.equals(enl.getId())){enl.setForeground(colorFuente(id_));}}
                        if(comp instanceof Imagen){Imagen img = (Imagen)comp; if(id.equals(img.getId())){img.setForeground(colorFuente(id_));}}
                        if(comp instanceof Spinner){Spinner spn = (Spinner)comp; if(id.equals(spn.getId())){spn.setForeground(colorFuente(id_));}}
                        if(comp instanceof Tab){Tab tab = (Tab)comp; if(id.equals(tab.getId())){tab.setForeground(colorFuente(id_));}else{modificarAtri(id,atributo,valor,tab);}}
                        if(comp instanceof areaTexto){areaTexto areaT = (areaTexto)comp;if(id.equals(areaT.getId())){areaT.setForeground(colorFuente(id_));}}
                        break;  
                    case "opaque":
                        if(comp instanceof Panel){Panel pnl = (Panel)comp; if(id.equals(pnl.getId())){if(id_.equals("true")){pnl.setOpaque(false);}if(id_.equals("false")){pnl.setOpaque(true);} }else{modificarAtri(id,atributo,valor,pnl);}}
                        if(comp instanceof Boton){Boton btn = (Boton)comp; if(id.equals(btn.getId())){if(id_.equals("true")){btn.setOpaque(false);}if(id_.equals("false")){btn.setOpaque(true);} }}
                        if(comp instanceof Caja){Caja cjt = (Caja)comp; if(id_.equals("true")){cjt.setOpaque(false);}if(id_.equals("false")){cjt.setOpaque(true);} }
                        if(comp instanceof CajaOpciones){CajaOpciones pnl= (CajaOpciones)comp; if(id.equals(pnl.getId())){if(id_.equals("true")){pnl.setOpaque(false);}if(id_.equals("false")){pnl.setOpaque(true);} }}
                        if(comp instanceof Enlace){Enlace pnl = (Enlace)comp; if(id.equals(pnl.getId())){if(id_.equals("true")){pnl.setOpaque(false);}if(id_.equals("false")){pnl.setOpaque(true);} }}
                        if(comp instanceof Imagen){Imagen pnl = (Imagen)comp; if(id.equals(pnl.getId())){if(id_.equals("true")){pnl.setOpaque(false);}if(id_.equals("false")){pnl.setOpaque(true);} }}
                        if(comp instanceof Spinner){Spinner pnl = (Spinner)comp; if(id.equals(pnl.getId())){if(id_.equals("true")){pnl.setOpaque(false);}if(id_.equals("false")){pnl.setOpaque(true);} }}
                        if(comp instanceof Tab){Tab pnl = (Tab)comp; if(id.equals(pnl.getId())){if(id_.equals("true")){pnl.setOpaque(false);}if(id_.equals("false")){pnl.setOpaque(true);} }else{modificarAtri(id,atributo,valor,pnl);}}
                        if(comp instanceof areaTexto){areaTexto pnl = (areaTexto)comp; if(id.equals(pnl.getId())){if(id_.equals("true")){pnl.setOpaque(false);}if(id_.equals("false")){pnl.setOpaque(true);} }}
                        break;  
                    case "click":
                        if(comp instanceof Panel){Panel pnl = (Panel)comp; if(id.equals(pnl.getId())){pnl.setMetodo(id_);}else{modificarAtri(id,atributo,valor,pnl);}}
                        if(comp instanceof Boton){Boton btn = (Boton)comp; if(id.equals(btn.getId())){btn.setMetodo(id_);}}
                        if(comp instanceof Caja){Caja cjt = (Caja)comp; if(id.equals(cjt.getId())){/*cjt.setMetodo(id_);}*/}}
                        if(comp instanceof CajaOpciones){CajaOpciones cjtO= (CajaOpciones)comp; if(id.equals(cjtO.getId())){cjtO.setMetodo(id_);}}
                        if(comp instanceof Enlace){Enlace enl = (Enlace)comp; if(id.equals(enl.getId())){enl.setMetodo(id_);}}
                        if(comp instanceof Imagen){Imagen img = (Imagen)comp; if(id.equals(img.getId())){img.setMetodo(id_);}}
                        if(comp instanceof Spinner){Spinner spn = (Spinner)comp; if(id.equals(spn.getId())){spn.setMetodo(id_);}}
                        if(comp instanceof Tab){Tab tab = (Tab)comp; if(id.equals(tab.getId())){tab.setMetodo(id_);}else{modificarAtri(id,atributo,valor,tab);}}
                        if(comp instanceof areaTexto){areaTexto areaT = (areaTexto)comp; if(id.equals(areaT.getId())){/*areaT.setMetodo(id_);*/}}
                        break; 
                    case "listo":
                        if(comp instanceof Panel){Panel pnl = (Panel)comp; if(id.equals(pnl.getId())){pnl.setListo(id_); }else{modificarAtri(id,atributo,valor,pnl);}}
                        if(comp instanceof Boton){Boton btn = (Boton)comp; if(id.equals(btn.getId())){btn.setListo(id_);}}
                        if(comp instanceof Caja){Caja cjt = (Caja)comp; if(id.equals(cjt.getId())){/*cjt.setMetodo(id_);}*/}}
                        if(comp instanceof CajaOpciones){CajaOpciones cjtO= (CajaOpciones)comp; if(id.equals(cjtO.getId())){cjtO.setListo(id_);}}
                        if(comp instanceof Enlace){Enlace enl = (Enlace)comp; if(id.equals(enl.getId())){enl.setListo(id_);}}
                        if(comp instanceof Imagen){Imagen img = (Imagen)comp; if(id.equals(img.getId())){img.setListo(id_);}}
                        if(comp instanceof Spinner){Spinner spn = (Spinner)comp; if(id.equals(spn.getId())){spn.setListo(id_);}}
                        if(comp instanceof Tab){Tab tab = (Tab)comp; if(id.equals(tab.getId())){tab.setListo(id_);}else{modificarAtri(id,atributo,valor,tab);}}
                        if(comp instanceof areaTexto){areaTexto areaT = (areaTexto)comp; if(id.equals(areaT.getId())){/*areaT.setMetodo(id_);*/}}
                        break;    
                    case "modificado":
                        if(comp instanceof Panel){Panel pnl = (Panel)comp; if(id.equals(pnl.getId())){pnl.setModificado(id_); }else{modificarAtri(id,atributo,valor,pnl);}}
                        if(comp instanceof Boton){Boton btn = (Boton)comp; if(id.equals(btn.getId())){btn.setModificado(id_);}}
                        if(comp instanceof Caja){Caja cjt = (Caja)comp; if(id.equals(cjt.getId())){/*cjt.setMetodo(id_);}*/}}
                        if(comp instanceof CajaOpciones){CajaOpciones cjtO= (CajaOpciones)comp; if(id.equals(cjtO.getId())){cjtO.setModificado(id_);}}
                        if(comp instanceof Enlace){Enlace enl = (Enlace)comp; if(id.equals(enl.getId())){enl.setModificado(id_);}}
                        if(comp instanceof Imagen){Imagen img = (Imagen)comp; if(id.equals(img.getId())){img.setModificado(id_);}}
                        if(comp instanceof Spinner){Spinner spn = (Spinner)comp; if(id.equals(spn.getId())){spn.setModificado(id_);}}
                        if(comp instanceof Tab){Tab tab = (Tab)comp; if(id.equals(tab.getId())){tab.setModificado(id_);}else{modificarAtri(id,atributo,valor,tab);}}
                        if(comp instanceof areaTexto){areaTexto areaT = (areaTexto)comp; if(id.equals(areaT.getId())){/*areaT.setMetodo(id_);*/}}
                        break;                         
                }
                
            }
                // Si Valor es String
            
                if(valor instanceof Source.CJS.principal.Nodo)
                {
                    Source.CJS.principal.Nodo metodo_ = (Source.CJS.principal.Nodo)valor;
                    switch(atributo.toLowerCase())
                    {                        
                        case "click":
                            if(comp instanceof Panel){Panel pnl = (Panel)comp; if(id.equals(pnl.getId())){pnl.setMetodo(metodo_);}else{modificarAtri(id,atributo,valor,pnl);}}
                            if(comp instanceof Boton){Boton btn = (Boton)comp; if(id.equals(btn.getId())){btn.setMetodo(metodo_);}}
                            if(comp instanceof Caja){Caja cjt = (Caja)comp; if(id.equals(cjt.getId())){/*cjt.setMetodo(id_);}*/}}
                            if(comp instanceof CajaOpciones){CajaOpciones cjtO= (CajaOpciones)comp; if(id.equals(cjtO.getId())){cjtO.setMetodo(metodo_);}}
                            if(comp instanceof Enlace){Enlace enl = (Enlace)comp; if(id.equals(enl.getId())){enl.setMetodo(metodo_);}}
                            if(comp instanceof Imagen){Imagen img = (Imagen)comp; if(id.equals(img.getId())){img.setMetodo(metodo_);}}
                            if(comp instanceof Spinner){Spinner spn = (Spinner)comp; if(id.equals(spn.getId())){spn.setMetodo(metodo_);}}
                            if(comp instanceof Tab){Tab tab = (Tab)comp; if(id.equals(tab.getId())){tab.setMetodo(metodo_);}else{modificarAtri(id,atributo,valor,tab);}}
                            if(comp instanceof areaTexto){areaTexto areaT = (areaTexto)comp; if(id.equals(areaT.getId())){/*areaT.setMetodo(id_);*/}}
                            break; 
                        case "listo":
                            if(comp instanceof Panel){Panel pnl = (Panel)comp; if(id.equals(pnl.getId())){pnl.setListo(metodo_); }else{modificarAtri(id,atributo,valor,pnl);}}
                            if(comp instanceof Boton){Boton btn = (Boton)comp; if(id.equals(btn.getId())){btn.setListo(metodo_);}}
                            if(comp instanceof Caja){Caja cjt = (Caja)comp; if(id.equals(cjt.getId())){/*cjt.setMetodo(id_);}*/}}
                            if(comp instanceof CajaOpciones){CajaOpciones cjtO= (CajaOpciones)comp; if(id.equals(cjtO.getId())){cjtO.setListo(metodo_);}}
                            if(comp instanceof Enlace){Enlace enl = (Enlace)comp; if(id.equals(enl.getId())){enl.setListo(metodo_);}}
                            if(comp instanceof Imagen){Imagen img = (Imagen)comp; if(id.equals(img.getId())){img.setListo(metodo_);}}
                            if(comp instanceof Spinner){Spinner spn = (Spinner)comp; if(id.equals(spn.getId())){spn.setListo(metodo_);}}
                            if(comp instanceof Tab){Tab tab = (Tab)comp; if(id.equals(tab.getId())){tab.setListo(metodo_);}else{modificarAtri(id,atributo,valor,tab);}}
                            if(comp instanceof areaTexto){areaTexto areaT = (areaTexto)comp; if(id.equals(areaT.getId())){/*areaT.setMetodo(id_);*/}}
                            break;    
                        case "modificado":
                            if(comp instanceof Panel){Panel pnl = (Panel)comp; if(id.equals(pnl.getId())){pnl.setModificado(metodo_); }else{modificarAtri(id,atributo,valor,pnl);}}
                            if(comp instanceof Boton){Boton btn = (Boton)comp; if(id.equals(btn.getId())){btn.setModificado(metodo_);}}
                            if(comp instanceof Caja){Caja cjt = (Caja)comp; if(id.equals(cjt.getId())){/*cjt.setMetodo(id_);}*/}}
                            if(comp instanceof CajaOpciones){CajaOpciones cjtO= (CajaOpciones)comp; if(id.equals(cjtO.getId())){cjtO.setModificado(metodo_);}}
                            if(comp instanceof Enlace){Enlace enl = (Enlace)comp; if(id.equals(enl.getId())){enl.setModificado(metodo_);}}
                            if(comp instanceof Imagen){Imagen img = (Imagen)comp; if(id.equals(img.getId())){img.setModificado(metodo_);}}
                            if(comp instanceof Spinner){Spinner spn = (Spinner)comp; if(id.equals(spn.getId())){spn.setModificado(metodo_);}}
                            if(comp instanceof Tab){Tab tab = (Tab)comp; if(id.equals(tab.getId())){tab.setModificado(metodo_);}else{modificarAtri(id,atributo,valor,tab);}}
                            if(comp instanceof areaTexto){areaTexto areaT = (areaTexto)comp; if(id.equals(areaT.getId())){/*areaT.setMetodo(id_);*/}}
                            break;                            
                    }

                }
            }                                
        this.repaint();
        
    }
    
    
    public boolean modAtributo(String id, ArrayList<Elemento> elementosLista,String atributo, Object val)
    {
        boolean result=false;
        
  
        for(Elemento item :elementosLista)
        {
           if(item.getNombre().equals(id))
           {
               return true;
           }
           else
           {
               if(val instanceof String)
               {
                    String valor = (String)val;
                    if(item.getValor() instanceof ArrayList)
                    {
                        ArrayList items = (ArrayList)item.getValor();
                        for(Object obj : items)
                        {
                            if(obj instanceof Elemento)
                            {
                                Elemento temp = (Elemento) obj;
                                switch(temp.getTipo().toLowerCase())
                                {
                                    case "boton":
                                        Boton btn = (Boton)temp.getValor();
                                        if(btn.getId().equals(id))
                                        {

                                        }
                                        break;
                                    case "caja":
                                        Caja cjt = (Caja)temp.getValor();
                                        if(cjt.getId().equals(id)){return true;}
                                        break;  
                                    case "cajaopciones":
                                        CajaOpciones cjtO = (CajaOpciones)temp.getValor();
                                        if(cjtO.getId().equals(id)){return true;}
                                        break;  
                                    case "enlace":
                                        Enlace enlace = (Enlace)temp.getValor();
                                        if(enlace.getId().equals(id)){return true;}
                                        break;     
                                    case "imagen":
                                        Imagen img = (Imagen)temp.getValor();
                                        if(img.getId().equals(id)){return true;}
                                        break;    
                                    case "panel":
                                        Panel pnl = (Panel)temp.getValor();
                                        if(pnl.getId().equals(id))
                                        {
                                            modificarAtributosPanel(pnl,atributo,valor);
                                        }
                                        else
                                        {
                                            //result = existeElemento(id,pnl.getElementos());
                                        }
                                        break; 
                                    case "spinner":
                                        Spinner spn = (Spinner)temp.getValor();
                                        if(spn.getId().equals(id)){return true;}
                                        break;  
                                    case "tabla":
                                        Tab tab = (Tab)temp.getValor();
                                        if(tab.getId().equals(id)){return true;}
                                        else
                                        {
                                            //result = existeElemento(id,tab.getElementos());
                                        }                                   
                                        break; 
                                    case "texto":
                                        Texto txt = (Texto)temp.getValor();
                                        if(txt.getId().equals(id)){return true;}
                                        break;  
                                    case "areatexto":
                                        areaTexto txtArea = (areaTexto)temp.getValor();
                                        if(txtArea.getId().equals(id)){return true;}
                                        break;                                     
                                }
                            }                       
                        }
                    }
               }
           }
        }        
        return result;
    }    
    
    public void modificarAtributosPanel(Panel panel, String atributo, String valor)
    {
        switch(atributo)
        {
            case "alineado":                                                                                                
                switch(valor)
                {
                    case "izquierda":                                        
                        break;
                }
                break;// Fin caso alineado                                    
            case "texto":
                valor = valor;
                panel.setTexto(quitarComillas(valor));

                break; 
            case "letra":
                valor ="";
                if(valor instanceof String){ valor = valor; valor= quitarComillas(valor);}                                                                   
                try 
                {
                    Font fuente = panel.getFont();                                                                                
                    panel.setFont(new Font(valor, fuente.getStyle(), fuente.getSize()));   
                } 
                catch (Exception e)
                {
                }                               
                break;  // Fin caso letra   
            case "tamtex":
                Double tamTex = 0.00;
                                                                                 
                try 
                {
                    tamTex = Double.valueOf(valor);
                    Font fuente = panel.getFont();  
                    if(tamTex==0){tamTex = (double)fuente.getSize();}
                    int tamText = tamTex.intValue();
                    panel.setFont(new Font(fuente.getName(), fuente.getStyle(), tamText));   
                } 
                catch (Exception e){}  
                break; //Fin caso tamtex  
            case "visible":
                valor ="";
                Boolean visibilidad = true;
                if(valor.equals("true")){visibilidad= true;}   
                if(valor.equals("false")){visibilidad= false;}
                panel.setVisible(visibilidad);
                break;//Fin visible   
            case "colortexto":
                valor ="";
                if(valor instanceof String)
                {
                    valor = valor;
                    panel.setColorFuente(colorFuente(valor));
                }
                break;//Fin colortexto    
            case "fondoelemento":
                valor ="";
                if(valor instanceof String)
                {
                    valor = valor;
                    valor = quitarComillas(valor);
                    panel.setBackground(colorFuente(valor));
                    //valor = valor;
                    //panel.setColorFuente(colorFuente(valor));
                }
                break;//Fin colortext  
            case "opaque":
                valor ="";
                Boolean opacacidad = true;
                if(valor.equals("true")){opacacidad = true;}
                if(valor.equals("false")){opacacidad = false;}                
                panel.setOpaque(opacacidad);
                break;//Fin Opacacidad                                                                                  
        }// Fin switch                            
    }
    
    
    public void ejecutar(Object metodo)
    {
        ejecucion.page = this;
        
        if(metodo!=null)
        {
            if(metodo instanceof String)
            {
                String met = (String)metodo;                        
                if(!met.equals(""))
                {                
                    if(met.length()>4)
                    {                    
                        String met_ = met.substring(0,met.length()-2);                    
                        if(ejecucion!=null){ejecucion.Executemetodo(met_);}
                    }
                }                                            
            }
            if(metodo instanceof Source.CJS.principal.Nodo)
            {
                Source.CJS.principal.Nodo met = (Source.CJS.principal.Nodo) metodo;
                if(ejecucion!=null){ejecucion.callMetodo(met, new Source.CJS.principal.Simbolo(),0);}
            }            
        }
        
    }
    
    public void setImagen(Imagen imagen)
    {        
        //imagen.setBounds(posXAux, posYAux, imagen.getAncho(),imagen.getAlto());
        ImageIcon icono = new ImageIcon(); 
        if(imagen.getRuta()!=null )
        {
            if(!imagen.getRuta().equals(""))
            {
                icono =   new ImageIcon(imagen.getRuta().substring(1,imagen.getRuta().length()-1));
            }   
            if(!imagen.getRuta().substring(0,1).equals("\""))
            {
                icono = new ImageIcon(imagen.getRuta());
            }  
            ImageIcon iconoEscala = new ImageIcon(icono.getImage().getScaledInstance(imagen.getAncho(), imagen.getAlto(), java.awt.Image.SCALE_DEFAULT));                
            imagen.setIcon(iconoEscala);                                         
        }         
    }
    public void mensajeEmergente(String titulo, String mensaje)
    {
        JOptionPane.showMessageDialog(this, mensaje, titulo, HEIGHT);
    }
    
    
    public void agregarSalidaConsola(String path, int linea, int col, String out)
    {
        Salida nueva = new Salida(path, linea, col, out);
        listaConsola.add(nueva);
        //String path, int linea, int col, String out
    }
    
    public void addOpcion(Opcion op)
    {
        if(!opciones.contains(op.getCadena().toLowerCase())){opciones.put(op.getCadena().toLowerCase(), op);}
    }
    
    public void modOpcion(String id, String atributo, Object valor)
    {
        id = id.toLowerCase();
        if(opciones.contains(id))
        {
            Opcion op = opciones.get(id);
            switch(atributo)
            {
                case "click":
                    op.setMetodo(valor);
                    break;
            }
            opciones.remove(id);
            addOpcion(op);
        }
    }
        
    ItemListener changeClick = new ItemListener() 
    { 
        public void itemStateChanged(ItemEvent e)  
        { 
            if(e.getSource() instanceof JComboBox)
            {
                JComboBox combo = (JComboBox)e.getSource();
                if(combo.getSelectedItem().equals(e.getItem())) 
                { 
                    String seleccion = combo.getSelectedItem().toString().toLowerCase();
                    if(opciones.containsKey(seleccion))
                    {
                        //Mensaje("",combo.getSelectedItem().toString());
                        Opcion opcion = opciones.get(seleccion);
                        if(opcion.getMetodo() instanceof String)
                        {
                            String met = (String)opcion.getMetodo();
                            met = met.substring(0, met.length()-2);
                            if(ejecucion!=null){ ejecucion.Executemetodo(met);}
                        }
                        if(opcion.getMetodo() instanceof Source.CJS.principal.Nodo)
                        {
                            Source.CJS.principal.Nodo nodo = (Source.CJS.principal.Nodo)opcion.getMetodo();
                            if(ejecucion!=null){ ejecucion.callMetodo(nodo, new Source.CJS.principal.Simbolo(), 0);}
                        }
                    }
                }                 
            }

        } 
    };
    
    
    public  void agregarSalida(String salida)
    {
        salidas.add(salida);
        
        JTable tablaSalida = new JTable();        
        filasErrores = new DefaultTableModel();        
        filasErrores.addColumn("Archivo");
        filasErrores.addColumn("Línea");
        filasErrores.addColumn("Columna");
        filasErrores.addColumn("Salida");     
        
        
        filasErrores.addRow(new String[]{"Archivo","Linea","Columna","Salida"});
        tablaSalida.setModel(filasErrores);        
        
        for(String item : salidas)
        {
            filasErrores.addRow(new Object[]{this.pathCjs,0,0,item});
        }                
        contenedorSalidas.removeAll();
        contenedorSalidas.add(tablaSalida);
        //System.out.println(temporal);       
        this.repaint();
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Menu;
    private javax.swing.JPanel Panel;
    private javax.swing.JTextArea archivoCHTML;
    private javax.swing.JTabbedPane areaOpciones;
    private javax.swing.JButton botonAdelante;
    private javax.swing.JButton botonAtras;
    private javax.swing.JButton botonCerrar;
    private javax.swing.JButton botonHistorial;
    private javax.swing.JButton botonIr;
    private javax.swing.JButton botonOpciones;
    private javax.swing.JTabbedPane ccss1;
    private javax.swing.JTextArea ccssArea1;
    private javax.swing.JTabbedPane cjs1;
    private javax.swing.JTextArea cjsArea1;
    private javax.swing.JPanel contenedorErrores;
    private javax.swing.JPanel contenedorSalidas;
    private javax.swing.JLabel etiquetaNombre;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JPanel panelContenido;
    private javax.swing.JPanel panelErrores;
    private javax.swing.JPanel panelMenu;
    private javax.swing.JPanel panelOpciones;
    private javax.swing.JPanel scroll;
    private javax.swing.JScrollPane scrollPanel;
    private javax.swing.JTextField textRuta;
    // End of variables declaration//GEN-END:variables
}
