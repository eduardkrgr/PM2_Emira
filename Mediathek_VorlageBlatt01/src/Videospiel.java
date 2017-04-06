/**
 * Ein {@link Videospiel} ist ein Medium. Zusätzlich zu den Eigenschaften eines
 * {@link Medium}s erfasst sie Informationen zum System auf dem das Spiel lauffähig ist.
 * 
 * @author Emira Zorgati
 * @version SoSe 2017
 * 
 */
public class Videospiel implements Medium 
{
	private String _system;
	private String _titel;
	private String _kommentar;
	public Videospiel(String titel, String kommentar, String system)
	{
		_titel = titel;
		_kommentar = kommentar;
		_system = system;
	}
	/**
     * Gibt den Kommentar zu diesem Medium zurück.
     * 
     * @return Den Kommentar zu diesem Medium.
     * 
     * @ensure result != null
     */
	
    public String getKommentar()
    {
    	return _kommentar;
    }
    /**
     * Gibt die Bezeichnung für die Medienart zurück.
     * 
     * @return Die Bezeichnung für die Medienart.
     * 
     * @ensure result != null
     */
    public String getMedienBezeichnung()
    {
    	return "Videospiel";
    }

    /**
     * Gibt den Titel des Mediums zurück.
     * 
     * @return Den Titel des Mediums
     * 
     * @ensure result != null
     */
    public String getTitel()
    {
    	return _titel;
    }
    
    /**
     * Gibt das System, auf dem das Medium lauffähig ist, zurück.
     * 
     * @return Das System des Mediums
     * 
     * @ensure result != null
     */
    public String getSpielsystem()
    {
    	return _system;
    }
    
    @Override
    public String getFormatiertenString()
    {
    	return "Typ: " + getMedienBezeichnung() + "\nTitel: " + _titel +"\nKommentar: " + _kommentar + "\nSystem: " + _system;
    }
}
