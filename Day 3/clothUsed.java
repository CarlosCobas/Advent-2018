import java.util.*;
import java.io.*;

public class clothUsed {

    public static void main(String[] args) {
        
        final int size = 1000;
        File f = new File(args[0]);
        int [][] clothSquare = new int [size][size]; 

        populateCloth(clothSquare);

        try {
            Scanner input = new Scanner(f);

            while(input.hasNextLine()){
                String line = input.nextLine().trim();
                int indexID = line.indexOf("@");
                int indexPos = line.indexOf(":");

                String _ID = line.substring(1, indexID).trim();
                String position = line.substring(indexID + 1, indexPos).trim();
                String dimention = line.substring(indexPos + 1).trim();

                String[] positionValues = position.split(",");
                String[] dimentionValues = dimention.split("x");

                int id = Integer.parseInt(_ID);

                int top = Integer.parseInt(positionValues[1]);
                int left = Integer.parseInt(positionValues[0]);

                int width = Integer.parseInt(dimentionValues[0]);
                int height = Integer.parseInt(dimentionValues[1]);
                
                int topDist = height + top - 1;
                int leftDist = width + left - 1;

                for(int i = top; i <= topDist; i++){
                    for(int j = left; j <= leftDist; j++){
                        if(clothSquare[i][j] == -1){
                            clothSquare[i][j] = id;
                        }
                        else{
                            clothSquare[i][j] = 0;                            
                        }
                    }
                }

            }
            
            input.close();

            //Buscando la que no solapa
            input = new Scanner(f);
            
            while(input.hasNextLine()){
                String line = input.nextLine().trim();
                int indexID = line.indexOf("@");
                int indexPos = line.indexOf(":");

                String _ID = line.substring(1, indexID).trim();
                String position = line.substring(indexID + 1, indexPos).trim();
                String dimention = line.substring(indexPos + 1).trim();

                String[] positionValues = position.split(",");
                String[] dimentionValues = dimention.split("x");

                int id = Integer.parseInt(_ID);

                int top = Integer.parseInt(positionValues[1]);
                int left = Integer.parseInt(positionValues[0]);

                int width = Integer.parseInt(dimentionValues[0]);
                int height = Integer.parseInt(dimentionValues[1]);
                
                int topDist = height + top - 1;
                int leftDist = width + left - 1;

                boolean solapa = false;

                for(int i = top; i <= topDist; i++){
                    for(int j = left; j <= leftDist; j++){
                        if(clothSquare[i][j] == 0){
                            solapa = true;
                        }
                    }
                }

                if(!solapa){
                    System.out.println("No solapa: " + id);
                }
            }
            
            input.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Cantidad que solapan: " + overlapingSquareInches(clothSquare));
    }

    static private void populateCloth(int [][]_array){

        for(int i = 0; i < _array.length; i++){
            for(int j = 0; j < _array[i].length; j++){
                _array[i][j] = -1;
            }
        }

    }

    static private int overlapingSquareInches(int [][]_array){
        int res = 0;

        for(int i = 0; i < _array.length; i++){
            for(int j = 0; j < _array[i].length; j++){
                if(_array[i][j] == 0){
                    res++;
                }
            }
        }

        return res;
    }

    
}
