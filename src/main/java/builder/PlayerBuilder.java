package builder;

import java.util.ArrayList;

import gameEntity.Player;
import gameEntity.RawMaterial;

/**
 * Builder na vytvareni novych hracu
 */
public class PlayerBuilder {
	
	public Player buildPlayer(String name, Player next, boolean start){
        Player p = new Player();
        p.setName(name);
        p.setNextPlayer(next);
        p.setStarter(start);
        p.setHand(new ArrayList<>());
        p.setDeletePack(new ArrayList<>());
        p.setPack(new ArrayList<>());
        p.setPlayerWon(false);
        initRaws(p);
        return p;
    }
    
    private void initRaws(Player p){
        p.setGold(buildRaw("gold", 50, 5, 1));
        p.setBlueMana(buildRaw("BM", 50, 5, 1));
        p.setGreenMana(buildRaw("GM", 50, 5, 1));
        p.setRedMana(buildRaw("RM", 50, 5, 1));
    }
    
    private RawMaterial buildRaw(String name, int max, int am, int grow){
        RawMaterial r = new RawMaterial();
        r.setName(name);
        r.setAmount(am);
        r.setMaxAmount(max);
        r.setGrow(grow);
        return r;
    }
}
