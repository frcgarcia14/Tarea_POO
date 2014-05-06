import java.util.*;
import java.io.*;

public class MyWorld {
   private PrintStream out;
   
   private ArrayList<PhysicsElement> elements;  // array to hold everything in my world.

   public MyWorld(){
      this(System.out);  // delta_t= 0.1[ms] and refreshPeriod=200 [ms]
   }
   public MyWorld(PrintStream output){
      out = output;
      elements = new ArrayList<PhysicsElement>();     
   }

   public void addElement(PhysicsElement e) {
      elements.add(e);
   }

   public void printStateDescription(){
     String s ="Time\t";
     for (PhysicsElement e:elements)
       s+=e.getDescription() + "\t";
     out.println(s);
   } 

   public void printState(double t){
	   String s = String.valueOf(t);
	   s+="\t";
     for (PhysicsElement e:elements)
     	s+=e.getState() + "\t";
     out.println(s);
     
   }

   public void simulate (double delta_t, double endTime, double samplingTime) {  // simulate passing time
      double t=0;
      printStateDescription();
      printState(t);
      while (t<endTime) {
         for(double nextStop=t+samplingTime; t<nextStop; t+=delta_t) {
           for (PhysicsElement e: elements)   // compute each element next state based on current global state  
              e.computeNextState(delta_t,this); // compute each element next state based on current global state
           for (PhysicsElement e: elements)  // for each element update its state. 
              e.updateState();     // update its state
         }
         printState(t);
      }
   }   

   public Ball findCollidingBall(Ball me) {
	  
	   Ball Collider;
	  
	   for(PhysicsElement e: elements){//verifica si alguna de las otras bolas esta en contacto con la mia
        if(e instanceof Ball){
           Collider = (Ball) e;
           if((Collider.collide(me) && e.getId() != me.getId())  ){
			  return(Collider);
		      }
        }
	   }
	   return (null);	   
   }
   
   public Ball  findCollidingFixedHook(Ball mi){
      FixedHook Coll;
 	   for(PhysicsElement e: elements){//verifica si alguna de las otras bolas esta en contacto con la mia
        if(e instanceof FixedHook){
        Coll = (FixedHook) e;
           boolean choque = Math.abs(mi.getPosition()-Coll.getPosition())<= (mi.getRadius()+Coll.getArista());
           boolean acercan;
              if(mi.getPosition()> Coll.getPosition()) acercan = mi.getSpeed()<0;
              else acercan = mi.getSpeed()>0;
           if(choque && acercan){ 
           return (mi);}
        }
	   }
	   return (null);	   
   }
}
 
