package Utils;

import Entity.Station;

public class PointNormalizer {
    private static int windowWidth;
    private static int windowHeight;
    private static int limX;
    private static int limY;

    public static void setWindowDimenson(int width,int height){
        windowWidth=width;
        windowHeight=height;
        limX=windowWidth/2;
        limY=windowHeight/2;
    }

    public static void normalizePoint(Station s) {
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
}
