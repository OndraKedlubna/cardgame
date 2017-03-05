package card;

import java.util.List;

import gameEntity.Player;

/**
 * Rozhraní reperezentující kartu a potřebné metody
 * @author Ondra
 *
 */
public interface ICard {
	
	String doEffect(Player player, List<Player> players);
    
    String showDescription();
    
    String showName();
    
    int goldCost();
    
    int redCost();
    
    int blueCost();
    
    int greenCost();

}
