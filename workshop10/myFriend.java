package workshop10;

public class myFriend extends Thread{
	 
	  private StrangeBank withdraw;
	  private int amount;
	 
	  public myFriend(StrangeBank x, int amount) {
	
		  super();
		withdraw = x;
		this.amount = amount;
		
	}
	public void run() {
		
		int val;
		
		do {
		
			try {
				Thread.sleep( (int) ( Math.random() * 3000 ) );
			
			} catch(InterruptedException e) {
				System.out.println(e.toString());
			}
			
			val = withdraw.withdrawAccount();
		} while (val != amount);
	
	}
		
	}