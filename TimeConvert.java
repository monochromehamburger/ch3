import java.util.Scanner;
class TimeConvert{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter an amount of seconds: ");
		int time = sc.nextInt();
		System.out.printf(time+ " seconds = "+(time/3600)+" hours, "+((time%3600)/60)+" minutes, "+(time%60)+" seconds.");
	}
}
