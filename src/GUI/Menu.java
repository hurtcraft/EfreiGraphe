package GUI;

import javax.swing.JButton;
import javax.swing.JPanel;

import Entity.Graphe;
import Entity.Station;
import Utils.MetroDataGetter;
import Utils.Prim;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
public class Menu extends JPanel{
    public static final int menuWidth=200;
    public static final int height=950;
    public JButton btnPrim;
    
    public Menu(Dimension dimension,MetroMap map){
        setBackground(Color.BLUE);
        setSize(dimension);
        setLayout(new FlowLayout(FlowLayout.RIGHT));
        Map<Integer,Station> mapOfStation=MetroDataGetter.getMapOfStation();   

        this.btnPrim=new JButton("prim");
        this.btnPrim.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e){
                // MetroMap.drawPrim(MetroDataGetter.getGraphe());
                // System.out.println(MetroDataGetter.getGraphe());
                // Graphe g=Prim.execute(MetroDataGetter.getGraphe());
                // System.out.println(g.getGraphe());

                // for (Integer i : g.getSommets()) {
                //     System.out.println(mapOfStation.get(i));
                // }
                // System.out.println("###################################################");

                // System.out.println(g);                
            }
        });
        this.add(this.btnPrim);
    }

     
    
}
