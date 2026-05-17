import java.util.*;

interface PaymentStrategy{
  public void makePayment(int amount);
}

class UpiPaymentStrategy implements PaymentStrategy{
  
  @Override
  public void makePayment(int amount){
    System.out.printf("Amount %d got debited using upi \n", amount);
  }
}

class CardPaymentStrategy implements PaymentStrategy{
  @Override
  public void makePayment(int amount){
    System.out.printf("Amount %d got debited using card \n", amount);
  }
}

class PaymentHandler{
  PaymentStrategy strategy;
  public PaymentHandler(PaymentStrategy strategy){
    this.strategy=strategy;
  }
  public void makePayment(int amount){
    strategy.makePayment(amount);
  }
}
public class StrategyPattern {
    
    public  void main(String[] args) {
      PaymentHandler handler1=new PaymentHandler(new CardPaymentStrategy());
      PaymentHandler handler2=new PaymentHandler(new UpiPaymentStrategy());
      handler1.makePayment(100);
      handler2.makePayment(100_000);
    }
}