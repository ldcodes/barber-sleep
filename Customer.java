package barber;

public class Customer extends Thread{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void run() {
		
		//System.out.println(this.getName()+" is new " +Solution.p());
		
	   try {
		Solution.mutex.acquire();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   System.out.println(this.getName()+" is coming in barber " +Solution.p());
	  
	   if(Solution.emptyChairs.get()> 0) {
			
			Solution.emptyChairs.decrementAndGet();		
			Solution.custom.release();
			Solution.mutex.release();
			System.out.println(this.getName()+" is sit down  " +Solution.p());			
		
			try {
				Solution.barber.acquire();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			};	
			Solution.name = this.getName();
			System.out.println(this.getName()+" is cuting     " +Solution.p());			
		    
		}else {
			Solution.mutex.release();
			System.out.println(this.getName()+" go for no seat "+Solution.p());
		}
	}
	
	
	
}
