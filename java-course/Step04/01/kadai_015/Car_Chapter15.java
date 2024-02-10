package kadai_015;

public class Car_Chapter15 {
	// filed
	private int gear = 1;
	private int speed = 10;
	
	// コンストラクタ
	public Car_Chapter15() {
	}
	
	// 速度を変更
	public void gearChange(int afterGear) {
		int beforeGear = this.gear;
		
		this.gear = afterGear;
		this.speed = switch(afterGear) {
			case 1 -> 10;
			case 2 -> 20;
			case 3 -> 30;
			case 4 -> 40;
			case 5 -> 50;
			default -> 10;
		};
		
		System.out.println("ギア" + beforeGear + "から" + this.gear + "に切り替えました");
	}
	
	// 速度を表示
	public void run() {
		System.out.println("速度は時速" + this.speed + "kmです");
	}
	
	
}
