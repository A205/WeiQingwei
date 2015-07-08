//package day02;

import java.awt.print.Printable;
import java.util.Scanner;

import javax.sound.sampled.Line;

public class DemoPrintStar {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter Number of Line.");
		int maxLine = scanner.nextInt();
		scanner.close();
		//int maxLine = 10;
		//第一种
		System.out.println("First style:");
		for(int i=1;i<maxLine;i++)
		{
			for(int j=1;j<=i;j++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
		//第二种
		System.out.println("Second style:");
		for(int i=1;i<maxLine;i++)
		{
			for(int j = 1;j<maxLine-i;j++)
			{
				System.out.print(" ");
			}
			for(int j=1;j<=i*2-1;j++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
