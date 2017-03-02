package card;

import java.util.List;

import gameEntity.Player;

/**
 * Rozhraní reperezentující kartu a potřebné metody
 * @author Ondra
 *
 */
public interface ICard {
	
public String doEffect(Player player, List<Player> players);
    
    public String showDescription();
    
    public String showName();
    
    public int goldCost();
    
    public int redCost();
    
    public int blueCost();
    
    public int greenCost();

}
