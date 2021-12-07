package workshop10;

public class Main {
	
	private static int DOLLARS=1;
	private static int EUROS=2;
	private static int POUNDS=3;
	

	public static void main(String[] args) throws InterruptedException {
	
		StrangeBank account = new StrangeBank();
		
		Thread mySelf = new mySelf(account, EUROS, DOLLARS, POUNDS);
		Thread myFriend = new myFriend(account, 0);
		mySelf.start();
		myFriend.start();
	 }

}