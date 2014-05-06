public class Spring extends PhysicsElement {
   private static int id=0;  // Spring identification
   protected final double restLength;
   private final double stiffness;
   protected Ball a_end, b_end;
   
   
   private Spring(){   // nobody can create a block without state
      this(0,0);
   }
   public Spring(double restLength, double stiffness){
      super(id++);
      this.restLength = restLength;
      this.stiffness = stiffness;
      a_end = b_end = null;
   }
   public void attachEnd (Ball sa) {  // note: we attach a spring to a ball, 
      if(a_end==null){                             //       not the other way around.
         a_end = sa;
         sa.attachSpring(this);
      	 return;
      }
      // to be completed by you
      if(b_end==null){  //
     	 b_end = sa;   //
      	 sa.attachSpring(this);
      	 return;
      }
   }
   public double getAendPosition() {
      if (a_end != null) // obtiene la posicion de la bola a en su union con el resrote
         return a_end.getPosition();
      if (b_end != null) //sino obtiene la posicon de la bola a porque no ha sido ingresada
         return b_end.getPosition()-this.restLength; //entonces la posicion del resorte es la posicon de la bola b menos el largo natural
      return 0;
   }
   
   public double getBendPosition() {  //idem a getAendPosition
    // to be coded by you
	   if (b_end != null)
	         return b_end.getPosition();
	   if (a_end != null)
	         return a_end.getPosition()-this.restLength;
	   return 0;
   }
   
   public double getForce(Ball ball) {
      double force = 0;
      if ((a_end == null) || (b_end == null))
         return force;  //si hay solo una bola entonces la fuerza es cero
      if ((ball != a_end) && (ball != b_end))
         return force; //si la bola no es ni la que esta unida en a_end o en b_end entonces el resorte no le esta aplciando una fuerza
      // to be completed by you
      if((ball == a_end)){ //si la bola es a entonces la fuerza que se le aplica es k*getAendPosition
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
      if((ball == b_end)){
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
/*	   if(a_end != null){
		   a_end.aceleration_tPlusDelta = a_end.getAceleration(this);
		   a_end.speed_tPlusDelta = a_end.getSpeed() + (3 * a_end.aceleration_tPlusDelta - a_end.aceleration)* delta_t;
		   a_end.pos_tPlusDelta = a_end.getPosition() + (a_end.getSpeed()* delta_t) + ((4 * a_end.aceleration_tPlusDelta - a_end.aceleration) / 6)* (delta_t*delta_t);
	   }
	 */  
   } 
   public void updateState(){
	/*   if(a_end != null){
	   a_end.aceleration = a_end.aceleration_tPlusDelta;
	   a_end.speed_t = a_end.speed_tPlusDelta;
	   a_end.pos_t = a_end.pos_tPlusDelta;
	   }
	   if(b_end != null){
	   b_end.aceleration = b_end.aceleration_tPlusDelta;
	   b_end.speed_t = b_end.speed_tPlusDelta;
	   b_end.pos_t = b_end.pos_tPlusDelta;
	   }
   */}

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
