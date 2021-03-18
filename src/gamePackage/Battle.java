package gamePackage;

public class Battle {
	private Party blufor;
	private Party opfor;
	private GameCharacter currCharacter; //Get java to keep a memory space open, save just that much more time. 
	int u;
	boolean wl;
	
	boolean optionConfirmed;
	
	public Battle(Party blu, Party op) {
		blufor = blu;
		opfor = op;
		wl = false;
		optionConfirmed = false;
	}
	
	public void cycle() {
		
	}
	
	private void checkWL() {
		for(u = 0; u < blufor.getCharactersInParty(); u++) {
			if(blufor.getCharacter(u).getHealth() > 0) {
				wl = true;
				break;
			}
		}
		
		if(wl) {
			//Game Over
		}
		
		for(u = 0; u < opfor.getCharactersInParty(); u++) {
			if(opfor.getCharacter(u).getHealth() > 0) {
				wl = true;
				break;
			}
		}
		
		if(wl) {
			//Win!
		}
		
	}
}
