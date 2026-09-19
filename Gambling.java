import java.util.*;
class Gambling{
	public static int money=100;
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args){
		// System.out.println("Loading...");
		// try{
		// 	for(int i=0;i<20;i++){
		// 		System.out.print("-");
		// 		Thread.sleep(60);
		// 		System.out.print("\r\033[2k");
		// 		System.out.flush();
		// 		System.out.print("\\");
		// 		Thread.sleep(60);
		// 		System.out.print("\r\033[2k");
		// 		System.out.flush();
		// 		System.out.print("|");
		// 		Thread.sleep(60);
		// 		System.out.print("\r\033[2k");
		// 		System.out.flush();
		// 		System.out.print("/");
		// 		Thread.sleep(60);
		// 		System.out.print("\r\033[2k");
		// 		System.out.flush();
		// 	}
		// }
		// catch (Exception e) {
        //     System.out.println(e);
        // }
		System.out.println();
        while(true){
            System.out.println();
            System.out.println("Gambling. You have $"+money+". Pick an option:");
            System.out.println("1: Lootboxes");
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
            switch(choice){
                case 1:
                    LootBoxes();
                    break;
                case 2:
                    //Blackjack();
                    break;
                case 3:
                    GuessNumber();
                    break;
            }
        }
	}
	public static void GuessNumber(){
		System.out.println("How much would you like to bet?");
		int choice=0;
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
        sc.nextLine();
        money-=bet;
		System.out.println("Guess my number from 0 to 100. Guesses closer to the actual number reward more payout. Guessing farther from 50 also increases payout.");
		
		while(true){
			int input=sc.nextInt();
			if(input>=0 && input<=100){
				choice=input;
				break;
			}
			System.out.println("Pick a valid number");
		}
        sc.nextLine();
        bet+=Math.round(bet*(Math.abs(choice-50)/40.0-0.35));
		Random random = new Random();
		int randomNum=random.nextInt(101);
		int difference=Math.abs(randomNum-choice);
        System.out.println("Your guess was: "+choice);
        try{
			for(int i=0;i<choice;i++){
				System.out.print("=");
				Thread.sleep(30);
			}
		}
		catch (Exception e) {
            System.out.println(e);
        }
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println();
        System.out.println("The actual number was... ");
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println(e);
        }
        try{
			for(int i=0;i<randomNum;i++){
				System.out.print("=");
				Thread.sleep(60);
			}
		}
		catch (Exception e) {
            System.out.println(e);
        }
        System.out.println();



		System.out.println(randomNum+"! You were off by "+difference+".");
		double multiplier=Math.round(Math.pow(15.0, 1.0-difference/20.0)*100.0)/100.0;
        //System.out.println(bet+" "+multiplier);
        money+=Math.round(bet*multiplier);
		System.out.println("You earned $"+Math.round(bet*multiplier)+" Back. Always Gamble.");
	}
    public static void LootBoxes(){
        System.out.println();
        System.out.println("Choose a lootbox:");
        System.out.println("1: Money box: Small - 50");
        System.out.println("2: Money box: Medium - 200");
        System.out.println("3: Money box: Large - 500");
        System.out.println("4: Special Box - 250");
        System.out.println("5 - Back");
        int[] costs={50, 200, 500, 250};
        int choice=0;
        while(true){
            String input=sc.nextLine();
            if(input.length()>0 && (input.charAt(0)=='1' || input.charAt(0)=='2' || input.charAt(0)=='3' || input.charAt(0)=='4')){
                choice=Integer.parseInt(input.substring(0,1));
                if(costs[choice-1]>money){
                    System.out.println("Too Broke, try another");
                }
                else{
                    money-=costs[choice-1];
                    break;
                } 
            }
            else if(input.length()>0 && input.charAt(0)=='5'){
                return;
            }
            else System.out.println("Pick a valid option");
        }
        String text="";
        String[] smallBoxPayoutTexts={"$0", "$5", "$10", "$25", "$50", "$100", "$200", "\u001B[33m$500\u001B[0m"};
        int[] smallBoxPayouts={0, 5, 10, 25, 50, 100, 200, 500};
        double[] smallBoxProbabilities={0.2,0.15,0.15,0.15,0.15,0.11,0.06,0.03};
        Queue<Integer> payouts=new LinkedList<>();
        int spinTimer=(int)(Math.random()*80);
        System.out.println("v Your reward");
        payouts.add(0);
        while(text.length()<100){
            double randomNum=Math.random();
            int index=0;
            while(randomNum-smallBoxProbabilities[index]>0){
                randomNum-=smallBoxProbabilities[index];
                index++;
            }
            payouts.add(index);
            text+=" ";
            text+=smallBoxPayoutTexts[index];
            text+=" ";
        }
        try{
			for(int i=spinTimer;i<160;i++){
				Thread.sleep((int)Math.max(60, Math.pow(2, (i-75)/10)));
                if(i>150){
				    Thread.sleep((int)Math.max(60, Math.pow(2, (i-75)/10)));
                }
                if(i>155){
				    Thread.sleep((int)Math.max(60, Math.pow(2, (i-75)/10)));
                }
                text=text.substring(1,text.length());
                while(text.charAt(0)!='$'){
                    text=text.substring(1,text.length());
                }
                double randomNum=Math.random();
                int index=0;
                while(randomNum-smallBoxProbabilities[index]>0){
                    randomNum-=smallBoxProbabilities[index];
                    index++;
                }
                payouts.add(index);
                payouts.poll();
                text+=" ";
                text+=smallBoxPayoutTexts[index];
                text+=" ";
				System.out.print("\r\033[2k");
				System.out.flush();
				System.out.print(text);
			}
            Thread.sleep(2000);
		}
		catch (Exception e) {
            System.out.println(e);
        }
        System.out.println();
        System.out.println("You received $"+smallBoxPayouts[payouts.peek()]+"!");
        money+=smallBoxPayouts[payouts.peek()];

    }
}