
import java.util.ArrayList;
import java.util.List;

public class Playlist implements Playable
{
    public List<Playable> aPlaylists = new ArrayList<>();

    //Add a playable Object aPlaylists, checks if doing so would result in a circular reference

    public void add(Playable pPlayable)
    {
        assert pPlayable != null;

        if (contains(pPlayable))
        { throw new IllegalArgumentException("Cannot have circular reference"); }
        else
        { aPlaylists.add(pPlayable); }
    }

    @Override
    public void play()
    {
        for (Playable p : aPlaylists)
        {
            p.play();
        }
    }

    @Override
    public ArrayList<Song> returnAsList()
    {
        ArrayList<Song> flattened = new ArrayList<>();
        for (Playable element : aPlaylists)
        {
            flattened.addAll(element.returnAsList());
        }
        return flattened;
    }

    public boolean contains(Playable pPlayable)
    {
        if (this == pPlayable) { return true; }
        if (this.getClass() != pPlayable.getClass()) { return false; }

        Playlist pPlayableAsPlaylist = (Playlist) pPlayable;

        for (Playable element : pPlayableAsPlaylist.aPlaylists)
        {
            if (this.contains(element))
            { return true; }
        }
        return false;
    }

}
