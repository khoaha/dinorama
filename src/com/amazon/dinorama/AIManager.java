package com.amazon.dinorama;

public class AIManager {

	protected Player player;
	protected Player enemy;
	
	protected final int target = 40;
	protected final int threshold = 80;
	protected int counter = 0;
	
	public AIManager(Player player, Player enemy) {
		this.player = player;
		this.enemy = enemy;
	}
	
	public void update() {/* dummy */}
	
//	public void update() {
//		int dist = Math.abs(player.originX - enemy.originX);
////		System.err.println("updating AI: "+dist+", "+enemy.currentState);
//		// move towards player
//		if (player.originX < enemy.originX) {
//			// randomly attack
////			if (Math.random() < 1 - dist/1280) {
////				if (Math.random() < .5) {
////					if (enemy.currentState != PlayerState.LOWATTACK)
////						enemy.attackLow();
////				} else if (enemy.currentState != PlayerState.HIGHATTACK)
////					enemy.attackHigh();
//			/*} else*/ if (enemy.currentState != PlayerState.MOVELEFT)
//				enemy.moveLeft();
//		} else {
//			// randomly attack
////			if (Math.random() < 1 - dist/1280) {
////				if (Math.random() < .5) {
////					if (enemy.currentState != PlayerState.LOWATTACK)
////						enemy.attackLow();
////				} else if (enemy.currentState != PlayerState.HIGHATTACK)
////					enemy.attackHigh();
//			/*} else*/ if (enemy.currentState != PlayerState.MOVERIGHT)
//				enemy.moveRight();
//		}
//	}
	
}
