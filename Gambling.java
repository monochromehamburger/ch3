import java.util.*;
import java.lang.Thread;
import java.lang.Math;
import java.util.Random;
class Gambling{
	public static int money=100;
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Loading...");
		try{
			for(int i=0;i<20;i++){
				System.out.print("-");
				Thread.sleep(60);
				System.out.print("\r\033[2k");
				System.out.flush();
				System.out.print("\\");
				Thread.sleep(60);
				System.out.print("\r\033[2k");
				System.out.flush();
				System.out.print("|");
				Thread.sleep(60);
				System.out.print("\r\033[2k");
				System.out.flush();
				System.out.print("/");
				Thread.sleep(60);
				System.out.print("\r\033[2k");
				System.out.flush();
			}
		}
		catch (Exception e) {
            System.out.println(e);
        }
		System.out.println();
		System.out.println();
		System.out.println("Gambling. You have $"+money+". Pick an option:");
		System.out.println("1: Buy Upgrades");
		System.out.println("2: Blackjack");
		System.out.println("3: Guess the Number");
		int choice=0;
		while(true){
			String input=sc.nextLine();
			if(input.length()>0 && (input.charAt(0)=='1' || input.charAt(0)=='2' || input.charAt(0)=='3')){
				choice=Integer.parseInt(input.substring(0,1));
				break;
			}
			System.out.println("Pick a valid option");
		}
		System.out.println(choice);
		switch(choice){
			case 1:
				//BuyUpgrades();
				break;
			case 2:
				//Blackjack();
				break;
			case 3:
				GuessNumber();
				break;
		}
	}
	public static void GuessNumber(){
		System.out.println("Guess my number from 0 to 100.");
		int choice=0;
		Scanner sc = new Scanner(System.in);
		int bet=0;
		
		while(true){
			int input=sc.nextInt();
			if(input>=0){
				if(input>money){
					System.out.println("You are too broke.");
				}
				else{
					bet=input;
					break;
				}
			}
			System.out.println("Pick a valid number");
		}
		
		while(true){
			int input=sc.nextInt();
			if(input>=0 && input<=100){
				choice=input;
				break;
			}
			System.out.println("Pick a valid number");
		}
		Random random = new Random();
		int randomNum=random.nextInt(100)+1;
		int difference=Math.abs(randomNum-choice);
		System.out.println("The number was "+randomNum+". You were off by "+difference+".");
		long multiplier=Math.round(4/Math.pow(difference,0.4)*100)/100;
		System.out.println("You earned $"+bet*multiplier+" Back. Always Gamble.");
		
	}
}
