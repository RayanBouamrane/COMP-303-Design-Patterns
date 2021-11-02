
import java.util.ArrayList;

public class Song implements Playable{
    private final String aName;
    private final String aArtist;
    private final int aLength;

    public Song(String pName, String pArtist, int pLength) {
        assert pName!=null && pArtist!=null && pLength >0;
        aName = pName;
        aArtist = pArtist;
        aLength = pLength;
    }

    public String getName() {
        return aName;
    }

    public String getArtist() {
        return aArtist;
    }

    public int getLength() {
        return aLength;
    }

    @Override
    public void play()
    {
        System.out.println("Playing " + aName + " by " + aArtist);
    }

    @Override
    public ArrayList<Song> returnAsList()
    {
        ArrayList<Song> s = new ArrayList<>();
        s.add(this);
        return s;
    }
}
