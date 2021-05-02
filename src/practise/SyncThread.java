package practise;

public class SyncThread implements Runnable{

	boolean isLast = false;
	
	
	
	@Override
	public void run() {
		fun();
		if(isLast)
		System.out.println("finished");
	}
	
	public void fun() {
		for(int i=0; i<3; i++) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName());
		}
	}
	
	
	public static void main(String args[]) {
		for(int i = 0; i<3;i++) {
			SyncThread syncThread = new SyncThread();
		boolean isLast = false;
		if(i==2) isLast = true;
		syncThread.isLast = isLast;
		Thread thread = new Thread(syncThread);
		//thread.setName("sha1");
		//Thread thread1 = new Thread(syncThread);
		//thread1.setName("sha2");
		thread.start();
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("shashank");
		//thread1.start();
		}
	}
}
