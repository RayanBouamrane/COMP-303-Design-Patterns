
import java.util.ArrayList;

/**
 * Class representing the client code of the MusicPlayer app.
 */

public class HomeEntertainmentSystem
{

    static final Song MONEY = new Song("Money", "Pink Floyd", 400);
    static final Song TIME = new Song("Time", "Pink Floyd", 450);
    static final Song YESTERDAY = new Song("Yesterday", "The Beatles", 150);
    static final Song SOMETHING = new Song("Something", "The Beatles", 180);

    public static void main(String[] args)
    {
        MusicPlayer iPod = new MusicPlayer();
        iPod.addItem(MONEY);
        iPod.addItem(TIME);
        iPod.addItem(YESTERDAY);
        iPod.addItem(SOMETHING);

        Playlist all = new Playlist();
        all.add(MONEY);
        all.add(TIME);
        all.add(YESTERDAY);
        all.add(SOMETHING);

//        all.add(all);  this code throws a Circular reference exception

        iPod.addPlaylist(all);
        iPod.playQueue();
        iPod.playQueue();
        iPod.playQueue();
        iPod.playQueue();

        PlayOrder shuffle = iPod.createOrderedPlayOrder();

        iPod.setPrototype(shuffle);

        iPod.addItemToQueue(all);
        iPod.playQueue();
        iPod.addItemToQueue(MONEY);
        iPod.playQueue();
        iPod.playQueue();
        iPod.playQueue();
        iPod.playQueue();
        iPod.playQueue();


        VoiceController voice = iPod.createVoiceController();
        voice.next();
        voice.next();

        RemoteController remote = iPod.createRemoteController();
        remote.next();
        remote.next();

    }
}
