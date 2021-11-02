
public class RemoteController implements Controller
{
    private Queue aQueue;

    public void setQueue(Queue pQueue) {
        aQueue = pQueue;
    }

    @Override
    public void next()
    {
        System.out.println("Play_Next_Song.exe");
        this.aQueue.next();
    }
}
