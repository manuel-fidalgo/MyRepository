

public class DomoticaCocina {

	public static void domoticaCocina(String[] args) throws Exception {
		//Runtime.getRuntime().exec("epiphany https://www.youtube.com/watch?v=IO8nPGljnOs&list=PLkbIYEqD5xixqKNTK2mfFhEfOrCYw46oc");
		SerialTest main = new SerialTest();
		main.initialize();
		Thread t=new Thread() {
			public void run() {
				//the following line will keep this app alive for 1000 seconds,
				//waiting for events to occur and responding to them (printing incoming messages to console).
				try {Thread.sleep(1000000);} catch (InterruptedException ie) {
					// Here goes what it does when it receives the signal
				}
			}
		};
		t.start();
		System.out.println("Started");
	}
}
