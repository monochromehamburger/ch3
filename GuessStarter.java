import java.util.Random;
import java.util.Scanner;
import java.lang.Math;
public class GuessStarter {

    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("number from 1 to 100 ");
        Random random = new Random();
        int number = random.nextInt(100) + 1;
        int guess=sc.nextInt();
        System.out.println("you're wrong! Unless you guessed "+number+". You were off by "+Math.abs(guess-number)+".");
    }
}
