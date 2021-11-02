
public class VoiceController implements Controller {

    private Queue aQueue;

    public void setQueue(Queue pQueue) {
        aQueue = pQueue;
    }

    @Override
    public void next()
    {
        System.out.println("Alexa, Play Next Song");
        this.aQueue.next();
    }
}