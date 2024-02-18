package kadai_026;

import java.util.HashMap;
import java.util.Scanner;

public class Jyanken_Chapter26 {
	private HashMap<String, String> handList = new HashMap<String, String>() {
		{
			put("r","グー");
			put("s","チョキ");
			put("p", "パー");
		}
	};
	
	// 自分のじゃんけんの手を入力
	public String getMyChoice() {
		// メッセージ表示
		System.out.println("自分のじゃんけんの手を入力しましょう");
		System.out.println(handList.get("r") + "はrockのrを入力しましょう");
		System.out.println(handList.get("s") + "はscissorsのsを入力しましょう");
		System.out.println(handList.get("p") + "はpaperのpを入力しましょう");
		
		// 入力
		String input = "";
		String hand = "";
		boolean errorFlg = true;
		
		try(Scanner scan = new Scanner(System.in)) {
			input = scan.nextLine();
			
			// チェック
			for(String key: handList.keySet()) {
				if (input.equals(key)) {
					errorFlg = false;
				}
			}
			
			if (errorFlg) {
				System.out.println("正しいじゃんけんの手ではありません。再度入力ください。");
			} else {
				hand = handList.get(input);
			}
		}; 
		
		return hand;
	}
	
	// 対戦相手のじゃんけんの手を選択
	public String getRandom() {
		String[] handArray = {"グー", "パー", "チョキ"};
		int random = (int)Math.floor(Math.random() * 3);
		
		return handArray[random];
	}
	
	// じゃんけんを行う
	public void playGame(String hand, String enemyHand) {
		System.out.println("自分の手は" + hand + ",対戦相手の手は" + enemyHand);
		
		if (hand.equals("グー")) {
			switch(enemyHand) {
				case "グー"   -> System.out.println("あいこです");
				case "チョキ" -> System.out.println("自分の勝ちです");
				case "パー"   -> System.out.println("自分の負けです");
			}
		} else if (hand.equals("チョキ")) {
			switch(enemyHand) {
				case "グー"   -> System.out.println("自分の負けです");
				case "チョキ" -> System.out.println("あいこです");
				case "パー"   -> System.out.println("自分の勝ちです");
			}
		} else if (hand.equals("パー")) {
			switch(enemyHand) {
				case "グー"   -> System.out.println("自分の勝ちです");
				case "チョキ" -> System.out.println("自分の負けです");
				case "パー"   -> System.out.println("あいこです");
			}
		}
	}
}
