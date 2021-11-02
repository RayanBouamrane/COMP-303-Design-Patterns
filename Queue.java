
import java.util.*;

/**
 * A class representing the Queue in the Music Player App.
 * It contains a list of songs that the Music Player can play
 * using different playing strategy.
 * It can contain repeated songs.
 */
public class Queue
{
    private List<Song> aSongElements = new ArrayList<>();

    //default PlayOrder is ordered play
    private PlayOrder aPrototype = new createOrderedPlayOrder();

    public class createOrderedPlayOrder implements PlayOrder
    {
        private int cursor = -1;

        @Override
        public int getNext()
        {
            cursor++;
            return cursor;
        }

        @Override
        public boolean hasNext() { return cursor < aSongElements.size() - 1; }

        @Override
        public void reset() { cursor = -1; }

    }

    public class createShuffledPlayOrder implements PlayOrder
    {
        private boolean trackerInitialized = false;
        private ArrayList<Song> tracker;
        private int cursor;

        private void initializeTracker()
        {
            cursor = -1;
            tracker = new ArrayList<>();
            tracker.addAll(aSongElements);
            trackerInitialized = true;
            Collections.shuffle(tracker);
        }

        @Override
        public int getNext()
        {
            cursor++;
            return aSongElements.indexOf(tracker.get(cursor));
        }

        @Override
        public boolean hasNext()
        {
            if (!trackerInitialized) { initializeTracker(); }
            return cursor < aSongElements.size() - 1;
        }

        @Override
        public void reset() { initializeTracker(); }
    }

    public void setPrototype(PlayOrder pPlayOrder)
    {
        aPrototype = pPlayOrder;
    }

    public void notifyQueue()
    {
        aPrototype.reset();
    }

    /**
     * Obtain the number of songs in the queue
     *
     * @return the number of songs in the queue
     */
    public int size()
    {
        return aSongElements.size();
    }

    /**
     * Obtain the song using its index in the queue.
     *
     * @param index the position of the song in the queue
     * @return the song in the queue at the position of the input index
     * @pre index >=0 && index < aSongElements.size()
     */
    public Song get(int index)
    {
        assert index >= 0 && index < aSongElements.size();
        return aSongElements.get(index);
    }

    /**
     * Add a single song to the queue.
     *
     * @param pItem the Song to be added to the queue
     * @pre pItem!=null
     */
    public void add(Song pItem)
    {
        assert pItem != null;
        aSongElements.add(pItem);
    }

    /**
     * Add a single song from the queue if it can be found.
     * If it appears more than once in the queue, the first occurrence will be removed.
     *
     * @param pItem the Song to be removed to the queue if presented
     * @pre pItem!=null
     */
    public void remove(Song pItem)
    {
        assert pItem != null;
        aSongElements.remove(pItem);
    }

    public void next()
    {
        if (aPrototype.hasNext())
        {
            aSongElements.get(aPrototype.getNext()).play();
        }
    }
}
