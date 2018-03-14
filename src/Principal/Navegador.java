package Principal;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.WindowConstants;

public class Navegador implements ActionListener{

    public static JButton botonAgregar = new JButton("+");
    final static JTabbedPane contenedorPaginas = new JTabbedPane();

    public static void main(String[] args) 
    {
        JFrame ventana = new JFrame();
        ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        contenedorPaginas.addTab("", null, new JScrollPane());

        addButtonToTab(contenedorPaginas);

        ventana.add(contenedorPaginas);
        ventana.setSize(new Dimension(600, 600));
        ventana.setVisible(true);
        
        
        botonAgregar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt) 
            {
                botonPlusActionPerformed(evt);
            }
        });
        
        
        
    }

    public static void addButtonToTab(final JTabbedPane tabEntity) 
    {
        tabEntity.setTabComponentAt(tabEntity.getTabCount() - 1, botonAgregar);
    }
    
    private static void botonPlusActionPerformed(java.awt.event.ActionEvent evt)
    {                           
        JScrollPane scroll = new JScrollPane();
        Pagina pagina = new Pagina();
        scroll.add(pagina);
        contenedorPaginas.addTab("Nuevo", null, pagina);
    }     

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}