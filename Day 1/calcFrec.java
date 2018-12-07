import java.util.*;

public class calcFrec {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int accFrec = 0;

        while(input.hasNextLine()){
            accFrec += input.nextInt();
        }
        input.close();
        System.out.print(accFrec);
    }
}