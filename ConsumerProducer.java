
public class ConsumerProducer {
	private int count;
	public synchronized void consume(){
		while(count ==0){
			try{
				wait();
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		count--;
		System.out.println(count);
	}
	
	private synchronized void produce(){
		count++;
		System.out.println("---"+count);
		notify();
	}

	public static void main(String[] args) {
		ConsumerProducer cp = new ConsumerProducer();
		
		cp.produce();
		cp.consume();
	}

}
