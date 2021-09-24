public class Philosopher implements Runnable{
	Chopstick leftChopstick;
	Chopstick rightChopstick;
	Boolean wantsToEat=false;
	int k=5;
	Philosopher(Chopstick left, Chopstick right){
		leftChopstick=left;
		rightChopstick=right;
	}

	void eating(){
		try {
			System.out.println(Thread.currentThread().getName()+"th Philospher is eating");
			// System.out.println("The owner of left chopstick :"+leftChopstick.owner);
			// System.out.println("The owner of right chopstick :"+rightChopstick.owner);
			
			Thread.sleep(10000);
			wantsToEat=false;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	void thinking(){
		try {
			System.out.println(Thread.currentThread().getName()+"th Philospher is thinking");
			Thread.sleep(5000);
			wantsToEat=true;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	void getChopsticks(){
		
		
	}
	@Override
	public void run() {
		while(k-->0){
			thinking();
			while(wantsToEat){
				if(!leftChopstick.islocked){
					synchronized(leftChopstick){
						
					leftChopstick.lock("left");
					if(!rightChopstick.islocked && leftChopstick.owner.equals(Thread.currentThread().getName())){
						synchronized(rightChopstick){
									
						rightChopstick.lock("right");
							if(rightChopstick.owner.equals(Thread.currentThread().getName())){
										eating();
								}
							
							rightChopstick.unlock("right");
							}
						
					}
					leftChopstick.unlock("left");
				}
				}
			}
		}
	}
}
