package Principal;

import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.WindowConstants;

public class Pagina {

    public static JButton botonPlus = new JButton("+");
    final static JTabbedPane tabEntity = new JTabbedPane();
    public static void main(String[] args) 
    {
        JFrame parent = new JFrame();
        parent.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //tabEntity.addTab("Details", null, new JScrollPane());
        //tabEntity.addTab("Context", null, new JScrollPane());
        tabEntity.addTab("", null, new JScrollPane());

        addButtonToTab(tabEntity);

        parent.add(tabEntity);
        parent.setSize(new Dimension(600, 600));
        parent.setVisible(true);
        
        
        botonPlus.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt) 
            {
                botonPlusActionPerformed(evt);
            }
        });
        
        
        
    }

    public static void addButtonToTab(final JTabbedPane tabEntity) 
    {
        tabEntity.setTabComponentAt(tabEntity.getTabCount() - 1, botonPlus);
    }
    
    private static void botonPlusActionPerformed(java.awt.event.ActionEvent evt)
    {                           
        JScrollPane scroll = new JScrollPane();
        Panel pagina = new Panel();
        scroll.add(pagina);
        tabEntity.addTab("Nuevo", null, pagina);
    }     
    
}