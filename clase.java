package Principal;

import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author erick
 */
public class Pagina1 extends JPanel
{
    public String path;
    public String titulo;
    public ArrayList<String> listaCcss = new ArrayList();
    public ArrayList<String> listaCjs = new ArrayList();
    
    public Pagina1()
    {
	this.listaCcss.add("C:\\Users\\erick\\Documents\\NetBeansProjects\\USAC-WEB\\archivo.cjs");
	this.listaCcss.add("C:\\Users\\erick\\Documents\\NetBeansProjects\\USAC-WEB\\archivo.cjs");
	this.listaCcss.add("C:\\Users\\erick\\Documents\\NetBeansProjects\\USAC-WEB\\archivo.cjs");
	this.listaCjs.add("C:\\Users\\erick\\Documents\\NetBeansProjects\\USAC-WEB\\archivo.ccss");
	 this.titulo= " Página de prueba 3, Usac 2018 asdfasfasfda    XD<"
	}
}