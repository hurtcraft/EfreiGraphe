package GUI;
import javax.swing.*;

import Entity.Point;
import Entity.SelectedStation;
import Entity.Station;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Entity.Point;

public class GUIPoint extends JButton {
    private static int pointSize=10;
    private int x;
    private int y;
    private Station station;
    private static int Xoffset=0;
    private static int Yoffset=-70;
    private static int windowWidth;
    private static int windowHeight;
    private static int limX;
    private static int limY;
    private StationClickListener listener;
    private boolean isClicked;
    public static void setWindowDimenson(int width,int height){
        windowWidth=width;
        windowHeight=height;
        limX=windowWidth/2;
        limY=windowHeight/2;
    }

    public GUIPoint(Station s){
        normalizePoint(s);
        this.x=s.getX();
        this.y=s.getY();
        this.station=s;
        isClicked=false;
        setContentAreaFilled(false);
        setBorderPainted(false); 
        setFocusPainted(false); 
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (listener != null) {
                    listener.onStationClick(station);
                }
            }
        });
        setBounds(x+Xoffset, y+Yoffset, pointSize, pointSize); 
    }
    public Station getStation(){
        return station;
    }
    public void setStationClickListener(StationClickListener listener) {
        this.listener = listener;
    }
    public void setIsClicked(boolean b){
        this.isClicked=b;
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(isClicked){
            g.setColor(Color.red);
        }
        else{
            g.setColor(Color.black);

        }
        g.fillOval(0, 0, pointSize, pointSize); 

    }

    private static void normalizePoint(Station s) {
        normalizePointBasDroite(s);
        normalizePointBasGauche(s);
        normalizePointHautGauche(s);
        normalizePointHautDroite(s);
    }

    private static void normalizePointHautGauche(Station s){
        int x=s.getX();
        int y=s.getY();
        if(x<limX && y<limY){
            return;
        }
        
    }
    private static void normalizePointHautDroite(Station s){
        int x=s.getX();
        int y=s.getY();
        if(x<limX && y>limY){
            s.setX(x);
            s.setY(y+18);
        }        
    }



    private static void normalizePointBasGauche(Station s){
        int x=s.getX();
        int y=s.getY();
        if(x>limX && y<limY){

            s.setX(x+8);
            s.setY(y+2);

        }

    }
    private static void normalizePointBasDroite(Station s){
        int x=s.getX();
        int y=s.getY();
        if(x>limX && y>limY){
            s.setX(x+8);
            s.setY(y+15);
        }

        

    }

    @Override
    public String toString() {
        return "GUIPoint [station=" + station + "]";
    }
}
