package dom_su.combat;
import dom_su.actor.Enemy;
import dom_su.actor.Player;

//handles the combat system
public class Combat {
	
	private Player p;
	private Enemy e;
	
	private boolean playersTurn;
	
	public Combat(Player player, Enemy enemy) {
		p = player;
		e = enemy;
		
		playersTurn = true;
	}
	
	public void simPlay(Item item) {
		if(playersTurn) {
			
			AttackItem playerItem = ((AttackItem) item);
			int initDamage = playerItem.getStrikeDamage(e);
			e.getDefense().defend(initDamage, e);
			if(p.getNumActionPoints() < Knife.COST)
				playersTurn = !playersTurn;
		} else {
			DefendItem playerItem = ((DefendItem) item);
			int initDamage = e.getWeapon().getStrikeDamage(p);
			p.getDefense().defend(initDamage, p);
			if(e.getNumActionPoints() < Knife.COST)
				playersTurn = !playersTurn;
		}
		
		
	}
	

}
