package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LogicsManagerTest {

    private Logics logic ;
    private int sizeOfGUI = 5 ;
    
    @BeforeEach
    void setUp() {
        logic = new LogicManager(sizeOfGUI);
    }

    @Test
    void testIfKnightAndPawnEverHits()
    {
        //Prima passo la posizione del pawn poi dello knight.
        logic = new LogicManager(sizeOfGUI, new Pair<>(1,2), new Pair<>(0,0));
        assertTrue(logic.hit(1,2));
    }

    @Test
    void testIfKnightsIsNeverSpawnedOnPawn()
    {
        for(int i = 0 ;  i < sizeOfGUI ; i++) //row
        {
            for(int j = 0; j < i ; j++) //columns
            {
                logic = new LogicManager(sizeOfGUI, new Pair<>(i,j) , new Pair<>(i,j));
                assertFalse(logic.hit(i,j));
            }
        }

    }

    @Test
    void testIfHasKnight()
    {
        for(int i = 0 ;  i < sizeOfGUI ; i++) //row
        {
            for(int j = 0; j < i ; j++) //columns
            {
                logic = new LogicManager(sizeOfGUI, new Pair<>(i,j) , new Pair<>(i,j));
                assertTrue(logic.hasKnight(i,j));
            }
        }

    }

    @Test
    void testIfHasPawn()
    {
        for(int i = 0 ;  i < sizeOfGUI ; i++) //row
        {
            for(int j = 0; j < i ; j++) //columns
            {
                logic = new LogicManager(sizeOfGUI, new Pair<>(i,j) , new Pair<>(i,j));
                assertTrue(logic.hasPawn(i,j));
            }
        }

    }
}