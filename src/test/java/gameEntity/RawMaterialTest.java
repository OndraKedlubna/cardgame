package gameEntity;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class RawMaterialTest {
private static RawMaterial testInstance;
    
    @Before
    public void setUp() {
        testInstance = new RawMaterial();
        testInstance.setName("gold");
        testInstance.setAmount(5);
        testInstance.setGrow(3);
        testInstance.setMaxAmount(15);
    }
    
    @Test
    public void checkIncrease() {
        testInstance.increase();
        assertEquals(8, testInstance.getAmount());
    }
    
    @Test
    public void checkIncreaseParameter(){
        testInstance.increase(5);
        assertEquals(10, testInstance.getAmount());
        testInstance.increase(7);
        assertEquals(15, testInstance.getAmount());
    }
    
    @Test
    public void checkDecrease(){
        testInstance.decrease(2);
        assertEquals(3, testInstance.getAmount());
    }
    
    @Test
    public void checkIncreaseMax(){
        testInstance.increaseMax(2);
        assertEquals(17, testInstance.getMaxAmount());
    }
    
    @Test
    public void checkIncreaseGrow(){
        testInstance.increaseGrow(1);
        assertEquals(4, testInstance.getGrow());
    }
    
    @Test
    public void checkDecreaseGrow(){
        testInstance.decreaseGrow(1);
        assertEquals(2, testInstance.getGrow());
        testInstance.decreaseGrow(2);
        assertEquals(1, testInstance.getGrow());
    }
    
    @Test
    public void checkToString(){
        System.out.println(testInstance);
        assertEquals(testInstance.toString(),
                "RawMaterial{name=gold, maxAmount=15, amount=5, grow=3}");
    }
}
