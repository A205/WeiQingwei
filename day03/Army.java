package day03;
import day03.Weapon;

public class Army{
	
	Weapon[] W;
	int count=0;
	Army(int maxNum){
		W = new Weapon[maxNum];
	}
	void addWeapon(Weapon wa){
		this.W[count] = wa;
		count++;
	}	
	public void attack() {
		for(int i=0;i<W.length;i++){
			System.out.println(W[i]+"¹¥»÷");		
		}
	}
	public void move() {
		for(int i=0;i<W.length;i++){
			System.out.println(W[i]+"ÒÆ¶¯");
		}
	}		
}
