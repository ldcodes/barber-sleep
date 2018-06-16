package barber;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class Solution {

	//shard data
	public static Semaphore custom = new Semaphore(0);
	public static AtomicInteger emptyChairs =new AtomicInteger(7);
	//public static Mutex count =new Mutex(0);
	public static Semaphore mutex = new Semaphore(1) ;// for chairs
    public static Semaphore barber = new Semaphore(0);
    public static String name;
	
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		Barber b =new Barber();
		b.setDaemon(true);
		b.start();
		//System.out.println("there is "+count+" custom  , emptychair are "+emptyChairs +"   is  barber work "+barber);
		//Thread.sleep(1000);
		int time =0;
		ArrayList<Customer> c =new ArrayList();
		int i = 0;
		while(time<30){
			//if(new Random().nextFloat()>0.5) {
				c.add(new Customer());
				 c.get(i++).start();
			//}			
			//p();
			//System.out.println("there is "+count+" custom  , emptychair are "+emptyChairs +"is  barber work "+barber);
			Thread.sleep(5000);
			time++;
		}
	}

	public static String p() {
		return ("          there is "+custom.availablePermits()+" custom waiting , emptychair are "+emptyChairs .get()+"      free  barber "+barber.availablePermits());
	}
}
