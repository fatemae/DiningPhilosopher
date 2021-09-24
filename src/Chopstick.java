public class Chopstick {
	String name;
	volatile boolean islocked=false;
	// boolean flag[] = new boolean[5];
	volatile String owner;
	Chopstick(String name){
		this.name=name;
	}

	 void lock(String var){
		// int i = Integer.valueOf(Thread.currentThread().getName())-1;
		islocked=true;
		owner=Thread.currentThread().getName();
		System.out.println(Thread.currentThread().getName()+"th Philospher has "+var+"chopstick ("+this.name+")");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}

	 void unlock(String var){
		islocked=false;
		System.out.println(Thread.currentThread().getName()+"th Philospher released "+var+"chopstick ("+this.name+")");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
