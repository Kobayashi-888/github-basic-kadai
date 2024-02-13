package kadai_018;

import java.util.ArrayList;
import java.util.List;

public class KatoExec_Chapter18 {

	public static void main(String[] args) {
		List<Kato_Chapter18> katoList = new ArrayList<Kato_Chapter18>();
		
		katoList.add(new KatoTaro_Chapter18());
		katoList.add(new KatoIchiro_Chapter18());
		katoList.add(new KatoHanako_Chapter18());
		
		for(Kato_Chapter18 kato : katoList) {
			kato.setGivenName();
			kato.execIntroduce();
		}
	}

}
