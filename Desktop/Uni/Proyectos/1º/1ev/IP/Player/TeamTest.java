
import java.util.ArrayList;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class TeamTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class TeamTest
{
    @Test
    public void testTeamWithParam()
    {
        Team team1=new Team("a");
        assertEquals(10,team1.size());
        Team team1;
        for(int i=0;i<team1.size();i++)
        {
            this().team1=team1.add(i);
            assertEquals(Team.size(),team1.size());
        }
        try{
        team1=team1.add(null);
        fail();
    }
    catch(RuntimeException e)
    {
        assertEquals("Jugador null",e.getMessage());
    }
    
}

@Test
public void seekPlayerTest()
{
    Team team1=new Team("a");
    assertEquals(team1.get(5),Player.getNumber(5));
    Team team1;
    for(int i=0;i<team1.size();i++)
    {
        this().team1=team1.get(i);
        assertEquals(team.get(i),team1.get(i));
    }
    try{
        team1=team1.get(null);
        fail();
    }
    catch (RuntimeException e)
    {
        assertEquals("No hay ningun jugador null",e.getMessage());
    }


}
}

