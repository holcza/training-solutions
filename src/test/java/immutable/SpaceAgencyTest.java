package immutable;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SpaceAgencyTest {

    @Test
    public void registerSatelliteTest() throws IllegalArgumentException
    {
        SpaceAgency spaceAgency=new SpaceAgency();
        Exception ex = assertThrows(IllegalArgumentException.class, () -> spaceAgency.registerSatellite(null));
        assertEquals("no satelite was given",ex.getMessage());
    }

    @Test
    public void registerSatelliteTest2()
    {
        SpaceAgency spaceAgency=new SpaceAgency();
        spaceAgency.registerSatellite(new Satellite("222",new CelestialCoordinates(3,4,5)));
        assertEquals("222",spaceAgency.satellites.get(0).getRegisterIdent());
    }

    @Test
    public void findSatelliteByRegisterIdentTest() throws IllegalArgumentException
    {
        SpaceAgency spaceAgency=new SpaceAgency();
        Exception ex = assertThrows(IllegalArgumentException.class, () -> spaceAgency.findSatelliteByRegisterIdent("    "));
        assertEquals("no registerID was given",ex.getMessage());
    }

    @Test
    public void findSatelliteByRegisterIdentTest2() throws IllegalArgumentException
    {
        SpaceAgency spaceAgency=new SpaceAgency();
        Exception ex = assertThrows(IllegalArgumentException.class, () -> spaceAgency.findSatelliteByRegisterIdent("123"));
        assertEquals("no satellite wa find",ex.getMessage());
    }

    @Test
    public void findSatelliteByRegisterIdentTest3()
    {
        SpaceAgency spaceAgency=new SpaceAgency();
        spaceAgency.registerSatellite(new Satellite("222",new CelestialCoordinates(3,4,5)));
        assertEquals("222",spaceAgency.findSatelliteByRegisterIdent("222").getRegisterIdent());
    }
}
