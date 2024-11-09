package GUI;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Utils.MetroDataGetter;
import Utils.Prim;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Menu extends JPanel{
    public static final int menuWidth=200;
    public static final int height=950;
    private JButton primBtn;
    private boolean toogle=false;
    public Menu(Dimension dimension, MetroMap map){
        setBackground(Color.BLUE);
        setSize(dimension);
        setLayout(new FlowLayout(FlowLayout.RIGHT)); // Aligne le contenu à droite
        primBtn=new JButton("prim");
        primBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Affiche un message quand le bouton est cliqué
                toogle=!toogle;
                map.drawPrim(toogle);
            }

           
        });
        add(primBtn);
    }
    
}
