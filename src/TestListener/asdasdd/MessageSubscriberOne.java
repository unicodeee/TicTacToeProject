package src.TestListener;

public class MessageSubscriberOne implements Observer
{
    @Override
    public void update(boolean m) {
        System.out.println("Winner is " + m);
    }
}
