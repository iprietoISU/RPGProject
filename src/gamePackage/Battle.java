package gamePackage;

public class Battle {
	private Party blufor;
	private Party opfor;
	private BattleCharacter currCharacter; //Get java to keep a memory space open, save just that much more time. 
	int u;
	boolean won = false;
	boolean lost = false;
	
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
		lost = true;
		for(u = 0; u < blufor.getCharactersInParty(); u++) {
			if(blufor.getCharacter(u).getHealth() > 0) {
				lost = false;
				return;
			}
		}
		if(lost){
			return;
		}
		
		won = true;
		for(u = 0; u < opfor.getCharactersInParty(); u++) {
			if(opfor.getCharacter(u).getHealth() > 0) {
				won = false;
				break;
			}
		}
	}

	public Party getBlufor() {
		return blufor;
	}


	public Party getOpfor() {
		return opfor;
	}

	public boolean didWin(){
		return won;
	}

	public boolean isOver(){
		return won || lost;
	}

}
