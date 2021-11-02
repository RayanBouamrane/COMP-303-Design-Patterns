
import org.junit.Assert;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class ShufflerTester
{
    static final Song MONEY = new Song("Money", "Pink Floyd", 400);
    static final Song TIME = new Song("Time", "Pink Floyd", 450);
    static final Song YESTERDAY = new Song("Yesterday", "The Beatles", 150);
    static final Song SOMETHING = new Song("Something", "The Beatles", 180);

    MusicPlayer iPod = new MusicPlayer();
    Playlist all = new Playlist();
    Queue que = new Queue();

    Queue.createShuffledPlayOrder Shuffler;
    ArrayList<Song> trackerList;

    @BeforeEach
    public void initialize()
    {
        que.add(MONEY);
        que.add(TIME);
        que.add(YESTERDAY);
        que.add(SOMETHING);

        all.add(MONEY);
        all.add(TIME);
        all.add(YESTERDAY);
        all.add(SOMETHING);

        try
        {
            Shuffler = que.new createShuffledPlayOrder();
            Shuffler.reset();
            Field trackerField = Queue.createShuffledPlayOrder.class.getDeclaredField("tracker");
            trackerField.setAccessible(true);
            trackerList = (ArrayList<Song>) trackerField.get(Shuffler);
        } catch (ReflectiveOperationException ignored) {}

    }

    @Test
    public void shuffledPlayTrackerNext()
    {
        trackerList.set(0, MONEY);
        trackerList.set(1, TIME);
        Assert.assertEquals(0, Shuffler.getNext());
        Assert.assertEquals(1, Shuffler.getNext());
    }

    @Test
    public void shuffledPlayTrackerHasNext()
    {
        Assert.assertTrue(Shuffler.hasNext());
        for (int i = 0; i < 4; i++) { Shuffler.getNext(); }
        Assert.assertFalse(Shuffler.hasNext());

    }

    @Test
    public void shuffledPlayTrackerTester()
    {
        Assert.assertTrue(trackerList.containsAll(all.aPlaylists));
    }

}
