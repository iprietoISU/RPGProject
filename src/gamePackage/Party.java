package gamePackage;
import java.util.LinkedList;

public class Party {
	private GameCharacter[] partyMembers;
	private LinkedList<Item> groupInventory;//Iterate through items during pre- and post- battle turn for calculation
	private int charactersInParty;
	//I was thinking about having a sepereate inventory for active and passive items, but it would just be annoying in the long run
	
	
	public Party() {
		partyMembers = new GameCharacter[3];
		groupInventory = new LinkedList<Item>();
		charactersInParty = 0;
	}
	
	public void addCharacter(GameCharacter chr) {
		if(charactersInParty < 3) {
			partyMembers[charactersInParty] = chr;
			chr.setParty(this);
		}
		
	}
	
	public int getCharactersInParty() {
		return charactersInParty;
	}

	public GameCharacter getCharacter(int id) {
		return partyMembers[id];
	}
	public LinkedList<PassiveItem> getPassiveItems(){
		//TODO
		return null;
	}
	
	public LinkedList<ActiveItem> getActiveItems(){
		//TODO
		return null;
	}
	

}
