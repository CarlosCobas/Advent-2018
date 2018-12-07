import java.util.Scanner;
import java.io.File;

public class rudChecksum {

    public static void main(String[] args) {

        String line;
        File f = new File("input.txt");
        int rptdTwice = 0;
        int rptdThrice = 0;


        try {
            Scanner input = new Scanner(f);

            while(input.hasNextLine()){
                boolean alreadyTwice = false;
                boolean alreadyThrice = false;
                line = input.nextLine().trim();
                
                for(int i = 0; i < line.length(); i++){
                    int count = 0;

                    for(int j = 0; j < line.length(); j++){
                        if(line.charAt(i) == line.charAt(j)){
                            count++;
                        }
                    }

                    if(count == 2 && !alreadyTwice){
                        alreadyTwice = true;
                        rptdTwice ++;
                    }
                    else if(count == 3 && !alreadyThrice){
                        alreadyThrice = true;
                        rptdThrice ++;
                    }
                }
            }

            input.close();

            int checksum = rptdTwice * rptdThrice;
            System.out.println("Checksum: " + checksum);

        } catch (Exception e) {
            System.out.println("Something went wrong");
        }
    }
}