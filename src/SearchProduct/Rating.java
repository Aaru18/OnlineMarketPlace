package SearchProduct;

import java.util.Scanner;

public class Rating {

	//public static String username ;
	public static String rating;
	Scanner sc = new Scanner(System.in);
	public static void main(String args[]){
		
	}
	public String give_rating(){
		
		//System.out.println("Enter your name");
		//username =sc.nextLine();
		System.out.println("Enter the rating you want to give to the object");
		rating = sc.nextLine();
		return rating;
	    
	}
}
