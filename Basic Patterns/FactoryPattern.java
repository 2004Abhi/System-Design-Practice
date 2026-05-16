import java.util.*;

public class FactoryPattern {
    interface DeliveryVehicle{
      public void deliver();
    }
    
    class AirplaneDelivery implements DeliveryVehicle{
      @Override
      public void deliver(){
        System.out.println("Delivered using airplane");
      }
    }
    
    class TruckDelivery implements DeliveryVehicle{
      @Override
      public void deliver(){
        System.out.println("Delivered using Truck");
      }
    }
    
    class DeliveryFactory{
      public DeliveryVehicle createDeliveryVehicle(String s){
        if(s.equals("Truck")){
          return new TruckDelivery();
        }else if(s.equals("Airplane")){
          return new AirplaneDelivery();
        }
        throw new IllegalArgumentException("Not a valid delivery Method");
      }
    }
    public  void main(String[] args) {
      try{
        DeliveryVehicle vehicle=new DeliveryFactory().createDeliveryVehicle("Tempo");
        vehicle.deliver();
      }catch(IllegalArgumentException ex){
        System.out.println(ex.getMessage());
      }
      return;
    }
}