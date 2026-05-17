import java.util.*;

interface IPublisher{
  public void subscribe(ISubscriber s);
  public void unsubscribe(ISubscriber s);
  public void publish();
}

interface ISubscriber{
  public void update();
}

class MyYoutubeChannel implements IPublisher{
  List<ISubscriber> subscribers=new ArrayList<>();
  
  @Override
  public void subscribe(ISubscriber s){
    subscribers.add(s);
  }
  
  @Override
  public void unsubscribe(ISubscriber s){
    subscribers.remove(s);
  }
  
  @Override
  public void publish(){
    subscribers.stream()
                .forEach(item->item.update());
  }
}

class Subscriber implements ISubscriber{
  String userName;
  public Subscriber(String userName){
    this.userName=userName;
  }
  
  @Override
  public void update(){
    System.out.printf("%s recieved update %n", userName);
  }
}

public class ObserverPattern {
    
    public  void main(String[] args) {
      ISubscriber s1=new Subscriber("Aliex");
      ISubscriber s2=new Subscriber("Alice");
      MyYoutubeChannel ch1=new MyYoutubeChannel();
      ch1.subscribe(s1);
      ch1.subscribe(s2);
      ch1.publish();
    }
}