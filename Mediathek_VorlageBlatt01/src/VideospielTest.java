import static org.junit.Assert.*;

import org.junit.Test;

public class VideospielTest {

    private static final String KOMMENTAR = "Kommentar";
    private static final String TITEL = "Titel";
    private static final String BEZEICHNUNG = "Videospiel";
    private static final String SYSTEM = "WII U";
    private Videospiel _spiel1;
    private Videospiel _spiel2;

    public VideospielTest()
    {
        _spiel1 = getMedium();
        _spiel2 = getMedium();
    }

    @Test
    public void testGetMedienBezeichnung()
    {
        String videospielBezeichnung = BEZEICHNUNG;
        assertEquals(videospielBezeichnung, _spiel1.getMedienBezeichnung());
    }

    @Test
    public void testKonstruktor()
    {
        assertEquals(TITEL, _spiel1.getTitel());
        assertEquals(KOMMENTAR, _spiel1.getKommentar());
        assertEquals(SYSTEM, _spiel1.getSpielsystem());
    }
    

    @Test
    /*
     * Von ein und der selben Spiel kann es mehrere Exemplare geben, die von
     * unterschiedlichen Personen ausgeliehen werden können.
     */
    public void testEquals()
    {
        assertFalse("Mehrere Exemplare der gleichen Videospiel sind ungleich",
                _spiel1.equals(_spiel2));
        assertTrue("Mehrere Exemplare der selben Videospiel sind gleich",
                _spiel1.equals(_spiel1));
    }

    protected Videospiel getMedium()
    {
        return new Videospiel(TITEL, KOMMENTAR, SYSTEM);
    }
}
