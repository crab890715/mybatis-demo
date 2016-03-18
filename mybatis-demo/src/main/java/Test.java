import java.util.HashMap;
import java.util.Map;


public class Test {
	public static Map<String, Object> map = new HashMap<String,Object>();
	public static void main(String[] args) {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				Object o = new Object();
				map.put("a", o);
				System.err.println("进入阻塞");
				try {
					o.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.err.println("释放阻塞");
			}
		}).start();
	}
}
