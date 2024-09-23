/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package JNotePad;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GraphicsEnvironment;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author DELL
 */
public class JFontDialog extends JDialog{
    private JList lstFont, lstStyle,lstSize;
    private JButton btOK,btCancel;
    private int[] fontStyle = {Font.PLAIN,Font.ITALIC,Font.BOLD + Font.ITALIC};
    private JLabel lbPreView;
    JTextArea txtEditor;
    private Font font;
    
    private JNotePad parent;
    public  JFontDialog(Frame owner,boolean modal){
        super(owner,modal);
        setTitle("Font");
        parent = (JNotePad)owner;
        createGUI();
        processEvent();
        setSize(610,450);
    }  
    
     private void createGUI() {
         JPanel p = new JPanel();
         p.setLayout(null);
         lstFont = new JList();
         JScrollPane scrollPaneFont = new JScrollPane(lstFont);
         p.add(scrollPaneFont);
         scrollPaneFont.setBounds(5, 30, 200, 300);
         
         Font[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAllFonts();
         DefaultListModel<String> modelFont = new  DefaultListModel<>();
         for( Font f : fonts){
             modelFont.addElement(f.getName());
             
             
         }
         lstFont.setModel(modelFont);
         
         
         
         //Tạo Style
         lstStyle = new JList(new Object[]{"Regular","Italic","Bold","Bold Italic"});
         JScrollPane scrollPaneStyle = new JScrollPane(lstStyle);
         p.add(scrollPaneStyle);
         scrollPaneStyle.setBounds(210, 30, 200, 250);
         lstStyle.setSelectedIndex(0);
         //Tạo Size
         lstSize = new JList(new Object[]{"8","9","10","11","12","14","16","36","48","72"});
         JScrollPane scrollPaneSize = new JScrollPane(lstSize);
         p.add(scrollPaneSize);
         scrollPaneSize.setBounds(420, 30, 200, 250);
         lstSize.setSelectedIndex(1);
         //Tạo Jbutton
         p.add(btOK = new JButton("OK File"));
         p.add(btCancel = new JButton("Cancel"));
         
         btOK.setBounds(300, 350, 100, 40);
         btCancel.setBounds(410, 350, 100, 40);
         
         p.add(lbPreView = new JLabel("AbBbYyZz"));
         lbPreView.setFont(new Font("Arial",fontStyle[0], 20));
         preViewFont();
         lbPreView.setBounds(400, 250, 200, 100);
         
         add(p);
         
     }
    
    
    
    
    
  
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFontDialog dlg = new JFontDialog(null, true);
        dlg.setLocationRelativeTo(null);
        dlg.setVisible(true);
    }

    private void processEvent() {
       lstSize.addListSelectionListener(new ListSelectionListener() {
           @Override
           public void valueChanged(ListSelectionEvent e) {
              preViewFont();
           }
           
       });
       lstFont.addListSelectionListener((e) ->{
           preViewFont();
       });
       lstStyle.addListSelectionListener((e) ->{
           preViewFont();
       });
        btOK.addActionListener((e) -> {
            parent.txtEditor.setFont(font);
            this.dispose();
            
        });
          
       

    }

    private void preViewFont() {
        String fontname = (String) lstFont.getSelectedValue();
        int style = fontStyle[lstStyle.getSelectedIndex()];
        int size = Integer.parseInt(lstSize.getSelectedValue().toString());
        lbPreView.setFont(font = new Font(fontname, style, size));
        
        
    }
    
    
}
