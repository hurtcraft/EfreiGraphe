package Builder;

import java.util.Arrays;
import java.util.List;

import Entity.Arete;
import Entity.MetroComponent;
import Entity.Station;

public class MetroComponentFactory {
    

    public static MetroComponent createMetroComponent(String data){
        try{
            String splittedData[]=getSplittedData(data, ";");
            String metroComponentType=splittedData[0];
            if(metroComponentType.equals("V")) {
                return createStation(splittedData);
            }
            return createArete(splittedData);
        
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        

    }


    public static Station createStation(String data[]){
        try {
            
            int numStation=Integer.parseInt(data[1]);
            String nomStation=data[2]; 
            String numLigne=data[3];
            boolean isTerminus=Boolean.parseBoolean(data[4].toLowerCase());
            int nbBranchement=Integer.parseInt(data[5]);
            int x=Integer.parseInt(data[6]);
            int y=Integer.parseInt(data[7]);

            return new Station(numStation, nomStation, numLigne, isTerminus, nbBranchement,x,y);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Arete createArete(String data[]){
        try {
            int numStation1=Integer.parseInt(data[1].trim());
            int numStation2=Integer.parseInt(data[2].trim());
            int tempsTrajet=Integer.parseInt(data[3].trim());            
            return new Arete(numStation1,numStation2,tempsTrajet);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String[] getSplittedData(String data,String delimiters){
        String []splittedData=data.split(delimiters);
        return splittedData;
    }


    

}
