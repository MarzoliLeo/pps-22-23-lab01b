package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LogicsImplTest {

    private LogicsImpl logic ;
    private int sizeOfGUI = 5 ;

    private boolean alwaysvalid;
    
    @BeforeEach
    void setUp() {
        logic = new LogicsImpl(sizeOfGUI);
    }

    @Test
    void testIfKnightAndPawnEverHits()
    {
        logic = new LogicsImpl(sizeOfGUI);
        logic.setKnight(new Pair<>(0,0));
        logic.setPawn(new Pair<>(1,2));
        assertTrue(logic.hit(1,2));
    }

    @Test
    void testIfKnightsIsNeverSpawnedOnPawn()
    {
        for(int i = 0 ;  i < sizeOfGUI ; i++) //row
        {
            for(int j = 0; j < i ; j++) //columns
            {
                logic = new LogicsImpl(sizeOfGUI, new Pair<>(i,j));
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
                logic = new LogicsImpl(sizeOfGUI, new Pair<>(i,j));
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
                logic = new LogicsImpl(sizeOfGUI, new Pair<>(i,j));
                assertTrue(logic.hasPawn(i,j));
            }
        }

    }
}