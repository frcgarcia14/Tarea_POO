import java.util.*;

public class FixedHook extends PhysicsElement implements SpringAttachable{
   private static int id=0;  // FixedHook identification number
   private final double arist;
   private double pos_t;     // current position at time t
   private ArrayList<Spring> springs;  // ArrayList can grow, arrays cannot. 

   private FixedHook(){   // nobody can create a block without state
     this(0,0);
   }
   public FixedHook(double arista, double position){
      super(id++);
      this.arist = arista;
      pos_t = position;
      springs = new ArrayList<Spring>();
   }
   
   public double getArista() {
      return arist;
   }

   public double getPosition(){
	  return pos_t;
   }
/*   public double getAceleration(Spring Myspring){
	  double aceleration;
	  aceleration = Myspring.getForce(this)/getMass();
	  return (aceleration);
   }
 */  
  
   public String getDescription() {
   // to be coded by you
   // FixedHook_0:x    Spring_0:a_end    b_end    Ball_0:x    Ball_1:x    
	   String Title; //titulo de la tabla de datos.
	   Title = "FixedHook_" + super.getId()+":x";
	   return(Title);
   }
   
   public String getState(){
	   String State;
	   State = String.valueOf(this.getPosition());
	   return (State); 
   }
   
   public void attachSpring (Spring Myspring){
    springs.add(Myspring);
    }
    
       public void computeNextState(double delta_t, MyWorld w){
   } 
   public void updateState(){
   }
   
} 