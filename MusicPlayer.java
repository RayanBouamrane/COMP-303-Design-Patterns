
import java.util.*;

/**
 * A class representing a Music Player App.
 * It contains a pool of songs that allow the user to traverse and add to the queue to play.
 */
public class MusicPlayer implements Iterable<Song>
{
    private Map<String, Song> aItems = new LinkedHashMap<>(); // Make sure a predictable iteration order.
    private Queue aQueue = new Queue(); //

    private List<Playable> aPlaylists = new ArrayList<>();

    public void addPlaylist(Playable pPlayable)
    {
        assert pPlayable != null;
        aPlaylists.add(pPlayable);
    }

    public MusicPlayer() {}

    /**
     * Add a single song to the music pool if a song with the same name is not already in the pool.
     *
     * @param pItem the song to be added in the pool
     * @pre pItem !=null
     */

    public void addItem(Song pItem)
    {
        assert pItem != null;
        aItems.putIfAbsent(pItem.getName(), pItem);
    }

    /**
     * Add a single song to the queue if that song can be found in the music pool.
     *
     * @param pItemName the name of the song
     * @pre pItemName !=null
     */
    public void addItemToQueue(String pItemName)
    {
        assert pItemName != null;
        if (aItems.containsKey(pItemName))
        { aQueue.add(aItems.get(pItemName)); }
        aQueue.notifyQueue();
    }

    /**
     * Add all songs in a playable object to the queue
     *
     * @param pPlayable the playable object
     * @pre pItemName !=null
     */
    public void addItemToQueue(Playable pPlayable)
    {
        assert pPlayable != null;
        ArrayList<Song> p = pPlayable.returnAsList();
        for (Song element : p)
        {
            if (aItems.containsKey(element.getName()))
            {
                aQueue.add(element);
            }
        }
        aQueue.notifyQueue();
    }

    /**
     * Obtain the number of songs in the queue
     *
     * @return the number of songs in the queue
     */
    public int getQueueSize()
    {
        return aQueue.size();
    }

    public void playQueue() { aQueue.next(); }

    public void setPrototype(PlayOrder pPlayOrder)
    {
        aQueue.setPrototype(pPlayOrder);
    }

    public Queue.createShuffledPlayOrder createShuffledPlayOrder() { return aQueue.new createShuffledPlayOrder(); }
    public Queue.createOrderedPlayOrder createOrderedPlayOrder() { return aQueue.new createOrderedPlayOrder(); }

    @Override
    public Iterator<Song> iterator()
    {
        return aItems.values().iterator();
    }

    public VoiceController createVoiceController()
    {
        VoiceController v = new VoiceController();
        v.setQueue(aQueue);
        return v;
    }

    public RemoteController createRemoteController()
    {
        RemoteController r = new RemoteController();
        r.setQueue(aQueue);
        return r;
    }
}
