import java.util.*;
import java.io.File;

public class firstRepeatedFrec {

    public static void main(String[] args) {

        File f = new File("input.txt");

        try {
            Scanner input;
            int accFrec = 0;
            ArrayList<Integer> frecList = new ArrayList<Integer>();
            boolean foundDuplicate = false;
            int repeated = -1;

            while(!foundDuplicate){
                input = new Scanner(f);
                while(input.hasNextLine()){
                    accFrec += input.nextInt();

                    if(frecList.size() != 0){
                        if(frecList.indexOf(accFrec) == -1){
                            frecList.add(accFrec);
                        }
                        else{
                            repeated = accFrec;
                            foundDuplicate = true;
                            break;
                        }
                    }
                    else{
                        frecList.add(accFrec);
                    }
                }
                input.close();
            }
            
            System.out.print(repeated);
        } catch (Exception e) {
            System.out.println("Algo fue mal");
        }
    }
}