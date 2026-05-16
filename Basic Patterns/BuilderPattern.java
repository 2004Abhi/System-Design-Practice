import java.util.*;



class Employee{
      String fullName;
      String dob;
      String bloodGroup;
      String parentName;
      String relationType;
      public static class EmployeeBuilder{
         Employee e=new Employee();
         
         public Employee build(){
           return e;
         }
         public EmployeeBuilder fullName(String s){
           e.fullName=s;
           return this;
         }
         public EmployeeBuilder dob(String s){
           e.dob=s;
           return this;
         }
         
         public EmployeeBuilder bloodGroup(String s){
           e.bloodGroup=s;
           return this;
         }
         public EmployeeBuilder parentName(String s){
           e.parentName=s;
           return this;
         }
         public EmployeeBuilder relationType(String s){
           e.relationType=s;
           return this;
         }
      }
      
      public static EmployeeBuilder builder(){
        return new EmployeeBuilder();
      }
      private Employee(){
        this.fullName="Alex";
      }
      
      public String getName(){
        return fullName;
      }
    }
public class BuilderPattern {
    
    public  void main(String[] args) {
      // Employee e=new Employee();
      // System.out.println(e.getName());
      
      // Employee e=new Employee.EmployeeBuilder().build();
      // System.out.println(e.getName());
      
      // Employee e=new Employee.EmployeeBuilder().fullName("Arayan").build();
      // System.out.println(e.getName());
      
      Employee e=Employee.builder().fullName("Ajay").build();
      System.out.println(e.getName());
    }
}