package kadai_026;

public class JyankenExec_Chapter26 {

	public static void main(String[] args) {
		Jyanken_Chapter26 game = new Jyanken_Chapter26();
		
		// 自分の手を入力
		String hand = game.getMyChoice();
		
		// 正常な手が選ばれなかった場合は処理終了
		if (hand.equals("")) {
			System.exit(0);
		}
		
		// 相手の手を入力
		String enemyHand = game.getRandom();
		
		// じゃんけんを行う
		game.playGame(hand, enemyHand);
		

	}

}
