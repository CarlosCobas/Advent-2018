import java.util.*;
import java.io.File;

public class oneCharDiff {

    public static void main(String[] args) {
        
        File f = new File("input.txt");
        ArrayList<String> res = new ArrayList<String>();

        try {
            Scanner input = new Scanner(f);

            while(input.hasNextLine()){
                String crrntWord = input.nextLine().trim();

                Scanner wrdCrwl = new Scanner(f);

                while(wrdCrwl.hasNextLine()){
                    String cmpWord = wrdCrwl.nextLine().trim();
                    int diff = 0;
                    int index = -1;

                    for(int i = 0; i < crrntWord.length(); i++ ){
                        if(crrntWord.charAt(i) != cmpWord.charAt(i)){
                            diff++;
                            index = i;
                        }
                    }

                    if(diff == 1){

                        String curatedWord = crrntWord.substring(0, index) + "" + crrntWord.substring(index+1);

                        if(res.size() != 0){
                            if(res.indexOf(curatedWord) == -1){
                                res.add(curatedWord);
                            }
                        }
                        else{
                            res.add(crrntWord);
                            res.add(cmpWord);
                            res.add(curatedWord);
                        }
                    }
                }

                wrdCrwl.close();
            }
            input.close();

            for(int i = 0; i < res.size(); i++){
                System.out.println(res.get(i));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}