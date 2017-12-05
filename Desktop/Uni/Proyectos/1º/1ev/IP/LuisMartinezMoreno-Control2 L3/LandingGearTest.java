

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class LandingGearTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class LandingGearTest
{
    /**
     * Prubeas para el constructor sin parametros
     * 
     */
    @Test
    public void testConstructorWithoutParams()
    {
        LandingGear landingGear1=new LandingGear();
        assertEquals(LandingGear.DEFAULT_LEVER, landingGear1.getLever());
        
        assertNotNull(landingGear1.getLeft());
        assertNotNull(landingGear1.getNose());
        assertNotNull(landingGear1.getRight());
        
//         assertEsquals(WheelStrut.MAX_PRESSURE, landingGear1.getNose().getLeft().getPressure);
//         assertEsquals(WheelStrut.MAX_PRESSURE, landingGear1.getNose().getLeft().getMaxPressure);
    }
}
