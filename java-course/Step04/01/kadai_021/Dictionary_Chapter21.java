package kadai_021;

import java.util.HashMap;

public class Dictionary_Chapter21 {
	public HashMap<String, String> dictionary = new HashMap<String, String>(){
		{
			put("apple","りんご");
			put("peach","桃");
			put("banana","バナナ");
			put("lemon","レモン");
			put("pear","梨");
			put("kiwi","キウィ");
			put("strawberry","いちご");
			put("grape","ぶどう");
			put("muscat","マスカット");
			put("cherry","さくらんぼ");
		}
	};
	
	// 単語を検索
	public void searchWord(String word) {
		boolean hitFlg = false;
		for(String key:dictionary.keySet()){
			if (word == key) {
				System.out.println(word + "の意味は"+ dictionary.get(word));
				hitFlg = true;
				break;
			}
		}
		
		if(!hitFlg) {
			System.out.println("検索いただいた単語は辞書に存在しておりません");
		}
	}
}
