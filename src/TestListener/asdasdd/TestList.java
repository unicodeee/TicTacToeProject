package src.TestListener;



public class TestList
{
    public static void main(String[] args)
    {
        MessageSubscriberOne s1 = new MessageSubscriberOne();
        MessagePublisher p = new MessagePublisher();

        p.attach(s1);
        p.notifyUpdate(true);   //s1 and s2 will receive the update

        p.notifyUpdate(false); //s2 and s3 will receive the update
    }
}