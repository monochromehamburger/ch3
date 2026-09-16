import java.util.Scanner;
class Convert{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a temperature in Celsius: ");
		double temperature = sc.nextDouble();
		System.out.printf("%.1f C = %.1f F", temperature, (temperature*1.8+32));
	}
}
