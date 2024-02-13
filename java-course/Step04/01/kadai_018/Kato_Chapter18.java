package kadai_018;

public abstract class Kato_Chapter18 {
	public String familyName;
	public String givenName;
	public String address;
	
	public Kato_Chapter18(){
		
	}
	
	public void commonIntroduce() {
		System.out.println("名前は加藤" + familyName + "です");
		System.out.println("住所は東京都中野区〇×です");
	}
	
	abstract public void eachIntroduce();
	
	public void execIntroduce() {
		this.commonIntroduce();
		this.eachIntroduce();
		System.out.println("");
	}

	abstract public void setGivenName();
}
