import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        MovieDownloaderMachine machine = new MovieDownloaderMachine();
        String input = "";
        Scanner in = new Scanner(System.in);
        while(true){
            input = in.nextLine();
            if (input.length() > 0) {
                machine.triggerEvent(input);
            }
        }
    }
}
