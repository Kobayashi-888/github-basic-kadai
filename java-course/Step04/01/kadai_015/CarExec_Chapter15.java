package kadai_015;

public class CarExec_Chapter15 {

	public static void main(String[] args) {
		// インスタンス化
		Car_Chapter15 testCar = new Car_Chapter15();
		
		// 速度を変更
		testCar.gearChange(3);
		
		// 速度を表示
		testCar.run();
	}

}
