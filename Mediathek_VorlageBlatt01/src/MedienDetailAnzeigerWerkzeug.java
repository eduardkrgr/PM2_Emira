import java.util.List;

import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * Ein MedienDetailAnzeigerWerkzeug ist ein Werkzeug um die Details von Medien
 * anzuzeigen.
 * 
 * @author SE2-Team, PM2-Team
 * @version SoSe 2017
 */
class MedienDetailAnzeigerWerkzeug
{
    private MedienDetailAnzeigerUI _ui;

    /**
     * Initialisiert ein neues MedienDetailAnzeigerWerkzeug.
     */
    public MedienDetailAnzeigerWerkzeug()
    {
        _ui = new MedienDetailAnzeigerUI();
    }

    /**
     * Setzt die Liste der Medien deren Details angezeigt werden sollen.
     * 
     * @param medien Eine Liste von Medien.
     * 
     * @require (medien != null)
     */
    public void setMedien(List<Medium> medien)
    {
        assert medien != null : "Vorbedingung verletzt: (medien != null)";
        String text = "";
        for(Medium medium :medien)
        {
        	text = text + medium.getFormatiertenString()+"\n\n";
        }
        JTextArea selectedMedienTextArea = _ui.getMedienAnzeigerTextArea();
        selectedMedienTextArea.setText(text);
    }
    
    /**
     * Setzt die Liste der Medien deren Details angezeigt werden sollen.
     * 
     * @param medien Eine Liste von Medien.
     * 
     * @require (medien != null)
     */
//    public void setMedien(List<Medium> medien)
//    {
//        assert medien != null : "Vorbedingung verletzt: (medien != null)";
//        String text = "";
//        for(Medium medium :medien)
//        {
//        	if(medium instanceof CD)
//        	{
//        		CD cd = (CD)medium;
//        		text = "Typ: " + cd.getMedienBezeichnung() + " Titel: " + cd.getTitel()+ " Kommentar: " + cd.getKommentar()+ " Interpret: " + cd.getInterpret()+ " Dauer: " + cd.getSpiellaenge();
//            }
//        	else if(medium instanceof DVD)
//        	{
//        		DVD dvd = (DVD)medium;
//        		text = "Typ: " + dvd.getMedienBezeichnung() + " Titel: " + dvd.getTitel() + " Kommentar: " + dvd.getKommentar() + " Regisseur: " + dvd.getRegisseur() + " Laufzeit: " + dvd.getLaufzeit();
//            }
//        	else if(medium instanceof Videospiel)
//        	{
//        		Videospiel spiel = (Videospiel)medium;
//        		text = "Typ: " + spiel.getMedienBezeichnung() + " Titel: " + spiel.getTitel() +" Kommentar: " + spiel.getKommentar() + " System: " + spiel.getSpielsystem();
//            }	
//        }
//        JTextArea selectedMedienTextArea = _ui.getMedienAnzeigerTextArea();
//        selectedMedienTextArea.setText(text);
//    }

    /**
     * Gibt das Panel dieses Subwerkzeugs zurück.
     * 
     * @ensure result != null
     */
    public JPanel getUIPanel()
    {
        return _ui.getUIPanel();
    }
}
