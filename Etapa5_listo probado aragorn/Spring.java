public class Spring extends PhysicsElement {
   private static int id=0;  // Spring identification
   protected final double restLength;
   private final double stiffness;
   protected Ball a_end1, b_end1;
   protected FixedHook a_end2, b_end2;
   
   
   private Spring(){   // nobody can create a block without state
      this(0,0);
   }
   public Spring(double restLength, double stiffness){
      super(id++);
      this.restLength = restLength;
      this.stiffness = stiffness;
      a_end1 = b_end1 = null;
      a_end2 = b_end2 = null;
   }
   public void attachEnd1 (Ball as) {  // note: we attach a spring to a ball, 
      if(a_end1==null && a_end2 == null){                             //       not the other way around.
         a_end1 = as;
         as.attachSpring(this);
      	 return;
      }
      // to be completed by you
      if(b_end1==null && b_end2 == null){  //
     	 b_end1 = as;   //
       as.attachSpring(this);
      	 return;
      }
   }
   
   public void attachEnd2 (FixedHook qw) {  // note: we attach a spring to a ball, 
      if(a_end2==null && a_end1 == null){                             //       not the other way around.
         a_end2 = qw;
         qw.attachSpring(this);
      	 return;
      }
      // to be completed by you
      if(b_end2==null && b_end1 == null){  //
     	 b_end2 = qw;   //
       qw.attachSpring(this);
      	 return;
      }
   }
   
   public double getAendPosition() {
      if (a_end1 != null && a_end2 == null) // obtiene la posicion de la bola a en su union con el resrote
         return a_end1.getPosition();
      else if (a_end1 == null && a_end2 != null)
         return a_end2.getPosition();   
      if (b_end1 != null && b_end2 == null) //sino obtiene la posicon de la bola a porque no ha sido ingresada
         return b_end1.getPosition()-this.restLength; //entonces la posicion del resorte es la posicon de la bola b menos el largo natural
      else if (b_end1 == null && b_end2 != null)
         return b_end2.getPosition()-this.restLength;
      return 0;
   }
   
   public double getBendPosition() {  //idem a getAendPosition
    // to be coded by you
      if (b_end1 != null && b_end2 == null) // obtiene la posicion de la bola a en su union con el resrote
         return b_end1.getPosition();
      else if (b_end1 == null && b_end2 != null)
         return b_end2.getPosition();   
      if (a_end1 != null && a_end2 == null) //sino obtiene la posicon de la bola a porque no ha sido ingresada
         return a_end1.getPosition()-this.restLength; //entonces la posicion del resorte es la posicon de la bola b menos el largo natural
      else if (a_end1 == null && a_end2 != null)
         return a_end2.getPosition()-this.restLength;
	   return 0;
   }
   
   public double getForce(Ball ball) {
      double force = 0;
      if ((a_end1 == null && a_end2 == null) || (b_end1 == null && b_end2 == null))
         return force;  //si hay solo una bola entonces la fuerza es cero
      if ((ball != a_end1) && (ball != b_end1))
         return force; //si la bola no es ni la que esta unida en a_end o en b_end entonces el resorte no le esta aplciando una fuerza
      // to be completed by you
      if((ball == a_end1)){ //si la bola es a entonces la fuerza que se le aplica es k*getAendPosition ?
         //pondria: -stiffness * Math.abs((getBendPosition()-getAendPosition())-restLeng)
         if(getAendPosition()<getBendPosition()){
        // String fuerzabola1;
            force = this.stiffness*(getBendPosition()-getAendPosition()-this.restLength);
       //  fuerzabola1 = String.valueOf(force);
       //  System.out.println("fuerzabola1: "+fuerzabola1);   
            return force;
         }
         else{
            force = -this.stiffness*(getAendPosition()-getBendPosition()-this.restLength);
            return force;
        }
      }
      if((ball == b_end1)){
    	  if(getAendPosition()<getBendPosition()){
           // String fuerzabola2;
            force = -this.stiffness*(getBendPosition()-getAendPosition()-this.restLength);
           // fuerzabola2 = String.valueOf(force);
        // System.out.println("fuerzabola2: "+fuerzabola2); 
            return force;
         }
         else{
            force = this.stiffness*(getAendPosition()-getBendPosition()-this.restLength);
            return force;
         }
      }
      return force;
   }
   
   public void computeNextState(double delta_t, MyWorld w){
   } 
   public void updateState(){
   }

   public String getDescription() {
      return "Spring_"+ getId()+":a_end\tb_end";
   }
   public String getState() {
     //  to be coded by you
	 String State;
    State = String.valueOf(this.restLength)+"\t"+String.valueOf(Math.abs(this.getAendPosition()-this.getBendPosition()));
	 return (State);
   }
}
