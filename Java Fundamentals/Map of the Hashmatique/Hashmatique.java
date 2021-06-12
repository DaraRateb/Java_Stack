import java.util.HashMap;
import java.util.Set;
public class Hashmatique {
    public static void main (String[] args){
        HashMap<String, String> trackList = new HashMap<String, String> ();
        trackList.put("Jingle Bells","jingle bells, jingle bells, Jingle all the way.");
        trackList.put("Twinkle","Twinkle twinkle little star. How I wonder what you are");
        trackList.put("Nami","Nami Nami ya zgheree");
        trackList.put("ya Asfoura","teeri teeri ya asfoura");
        String song=trackList.get("Twinkle");
        System.out.println(song);

        Set<String> keys = trackList.keySet();
        for(String key : keys) {
            System.out.println(key + ":" + trackList.get(key));
 
    }
    
}
}