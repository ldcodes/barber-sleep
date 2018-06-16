package barber;

public class Barber extends Thread{

	private boolean wakeUp = false;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void run() {
		while(true) {
			
			try {
				Solution.custom.acquire();
				Solution.mutex.acquire();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		    Solution.emptyChairs.incrementAndGet();
			Solution.barber.release();
			Solution.mutex.release();
			try {
				this.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Solution.name+" is finish    " +Solution.p());
			
			}
	}
	
	public void cut() {
		
	}
	

}
