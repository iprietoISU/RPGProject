package gamePackage;
/**
 * @author Indelisio
 *
 */
public class GameCharacter { //Maybe make a class
	private String spriteName; //Probably no animations for the time being, except for translations.
	private Party charactersParty;
	private Battle currentBattle;
	private int maxHealth;
	private int health;
	
	private int move1;
	private int move2;
	private int move3;
	private int move4;
	
	public void setParty(Party prty) {
		charactersParty = prty;
	}
	
	public void initBattle(Battle battle) {
		currentBattle = battle;
	}
	
	public void preBattleEffects() {
		
	}
	
	public void postBattleEffects() {
		
	}
	
	public void turn() {
		
	}
	
	public int getHealth() {
		return health;
	}

}
