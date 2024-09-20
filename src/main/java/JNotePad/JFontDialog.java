/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package JNotePad;
import java.awt.Frame;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author DELL
 */
public class JFontDialog extends JDialog{
    private JList lstFont, lstStyle,lstSize;
    
    
    public  JFontDialog(Frame owner,boolean modal){
        super();
        createGUI();
        setSize(610,450);
    }  
    
     private void createGUI() {
         JPanel p = new JPanel();
         p.setLayout(null);
         lstFont = new JList();
         JScrollPane scrollPaneFont = new JScrollPane(lstFont);
         p.add(scrollPaneFont);
         scrollPaneFont.setBounds(5, 30, 200, 300);
         
         
     }
    
    
    
    
    
  
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }

  
    
}
