package workshop10;

public class mySelf extends Thread{
 
	
	private StrangeBank deposit;
	private int euro, dollor, pound;

	
	public mySelf(StrangeBank x, int euro, int dollor, int pound) {
		
		super();
		this.deposit = x;
		this.euro=euro;
		this.dollor= dollor;
		this.pound=pound;
	}
	
	public synchronized void run() {
		
		while(true) {
			
			try {
				Thread.sleep( (int) ( Math.random() * 1500 ) );
			} catch(InterruptedException e) {
				System.out.println(e.toString());
			}
			
			if(euro > 0) { 
			deposit.fundAccount(euro , "euro");
			euro--;
			
			} else if(dollor > 0) { 
				deposit.fundAccount(dollor , "dollor");
				dollor--;
			
			} else if(pound > 0) { 
				deposit.fundAccount(pound , "pound");
				pound--;
			
			} else {
				return;
			}
		}
	}
}
