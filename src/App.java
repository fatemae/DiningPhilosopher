import java.util.concurrent.Semaphore;

public class App {
    public static void main(String[] args) throws Exception {
        int size=5;
        Philosopher[] philosopher = new Philosopher[size];
        Chopstick[] chopsticks = new Chopstick[size];
        for(int i=0;i<size;i++){
            chopsticks[i]=new Chopstick(String.valueOf(i+1));
        }
        for(int i=0;i<size;i++){
            Chopstick leftChopstick=chopsticks[i];
            Chopstick righChopstick=chopsticks[(i+1)%size];
            philosopher[i]=new Philosopher(leftChopstick,righChopstick);
            Thread thread = new Thread(philosopher[i], String.valueOf(i+1));
            thread.start();
        }
        
    }
}
