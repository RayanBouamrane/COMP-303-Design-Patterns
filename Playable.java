
import java.util.ArrayList;

/*
 * An interface representing an Object that can be played
 * Playable means it can be added to the Queue, and can be represented as
 * a list, a necessary condition to be added to the Queue
 * examples of playable objects are songs and playlists

 */
public interface Playable
{
    void play();
    ArrayList<Song> returnAsList();
}