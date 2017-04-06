import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
//Die in den Testfällen verwendeten assert-Anweisungen werden über
//einen sogenannten statischen Import bereitgestellt, zum Beispiel:
//import static org.junit.Assert.assertEquals;
//
// Um die Annotation @Test verwenden zu können, muss diese importiert
// werden: import org.junit.Test;

/**
 * Diese Klasse testet die Implementation des VerleihService.
 */
public class VerleihServiceImplTest
{
    private Kunde _homer;
    private Kunde _roger;
    private Kunde _brian;
    private KundenstammService _kundenstamm;

    private Medium _abbey;
    private Medium _bad;
    private Medium _shape;
    private MedienbestandService _medienbestand;

    private VerleihServiceImpl _verleihService;

    public VerleihServiceImplTest()
    {
        setUpKunden();
        setUpMedien();
        setUpVerleihService();
    }

    @Test
    // Alle Testmethoden erhalten die Annotation @Test. Dafür müssen diese nicht
    // mehr mit test im Namen beginnen. Dies wird jedoch aus Gewohnheit
    // oft weiter verwendet.
    public void testKundenstamm()
    {
        assertTrue(_verleihService.kundeImBestand(_homer));
        assertTrue(_verleihService.kundeImBestand(_roger));
        assertTrue(_verleihService.kundeImBestand(_brian));

        Kunde marge = new Kunde(Kundennummer.get(123459), "Marge", "Bouvier");
        assertFalse(_verleihService.kundeImBestand(marge));
    }

    @Test
    public void testAmAnfangIstNichtsVerliehen()
    {
        assertTrue(_verleihService.sindAlleNichtVerliehen(_medienbestand
                .getMedien()));
        for (Kunde kunde : _kundenstamm.getKunden())
        {
            assertTrue(_verleihService.istVerleihenMoeglich(kunde,
                    _medienbestand.getMedien()));
        }
    }

    @Test
    public void testVeleiheAn()
    {
    	List<Medium> medien = new ArrayList<Medium>();
    	medien.add(_abbey);
    	medien.add(_bad);
    	medien.add(_shape);
    	_verleihService.verleiheAn(_brian, medien, Datum.heute());

    	assertEquals(_verleihService.getAusgelieheneMedienFuer(_brian).size(),3);
    	assertEquals(_verleihService.getAusgelieheneMedienFuer(_homer).size(),0);
    	assertEquals(_verleihService.getAusgelieheneMedienFuer(_roger).size(),0);
    	assertEquals(_verleihService.getEntleiherFuer(_abbey), _brian);
    	assertEquals(_verleihService.getEntleiherFuer(_bad), _brian);
    	assertEquals(_verleihService.getEntleiherFuer(_shape), _brian);
    	assertTrue(_verleihService.istVerliehen(_abbey));
    	assertTrue(_verleihService.istVerliehen(_bad));
    	assertTrue(_verleihService.istVerliehen(_shape));
    }

    @Test
    public void testNimmZurueck()
    {
    	List<Medium> medien = new ArrayList<Medium>();
    	medien.add(_abbey);
    	medien.add(_bad);
    	medien.add(_shape);
    	_verleihService.verleiheAn(_brian, medien, Datum.heute());
    	_verleihService.nimmZurueck(medien, Datum.heute());

    	assertEquals(_verleihService.getAusgelieheneMedienFuer(_brian).size(),0);
    	assertFalse(_verleihService.istVerliehen(_abbey));
    	assertFalse(_verleihService.istVerliehen(_bad));
    	assertFalse(_verleihService.istVerliehen(_shape));
    }

    @Test
    public void testNochEinTestFall3()
    {
    }

    private void setUpKunden()
    {
        _homer = new Kunde(Kundennummer.get(123456), "Homer", "Simpson");
        _roger = new Kunde(Kundennummer.get(123457), "Roger", "Smith");
        _brian = new Kunde(Kundennummer.get(123458), "Brian", "Griffin");

        List<Kunde> testkunden = new ArrayList<Kunde>();
        testkunden.add(_homer);
        testkunden.add(_roger);
        testkunden.add(_brian);
        _kundenstamm = new KundenstammServiceImpl(testkunden);
    }

    private void setUpMedien()
    {
        _abbey = new CD("Abbey Road", "Meisterwerk", "Beatles", 44);
        _bad = new CD("Bad", "not as bad as the title might suggest",
                "Michael Jackson", 48);
        _shape = new CD("The Colour And The Shape", "bestes Album der Gruppe",
                "Foo Fighters", 46);

        List<Medium> _medien = new ArrayList<Medium>();
        _medien.add(_abbey);
        _medien.add(_bad);
        _medien.add(_shape);
        _medienbestand = new MedienbestandServiceImpl(_medien);
    }

    private void setUpVerleihService()
    {
        _verleihService = new VerleihServiceImpl(_kundenstamm, _medienbestand,
                new ArrayList<Verleihkarte>());
    }
}
