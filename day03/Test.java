/**
 * 
 */
package day03;

/**
 * @author Will_Fine
 *
 * 2015-7-8
 */
public class Test {
	static Weapon W1  = new Tank() ;
	Weapon x;
 
	public static void main(String[] args) {
		Army A = new Army(5);
	    A.addWeapon(W1);
		A.attack();
		A.move();
	}

}
