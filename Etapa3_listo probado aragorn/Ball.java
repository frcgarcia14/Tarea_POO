import java.util.*;

public class Ball extends PhysicsElement implements SpringAttachable{ //se agrega implements para los metodos de la interfaz
   private static int id=0;  // Ball identification number
   private final double mass;
   private final double radius;
   private double pos_t;     // current position at time t
   private double pos_tPlusDelta;  // next position in delta time in future
   private double speed_t;   // speed at time t
   private double speed_tPlusDelta;   // speed in delta time in future
   private double a_t;    // acceleration at time t
   private double a_tMinusDelta;  // acceleration delta time ago;
   private ArrayList<Spring> springs;  // ArrayList can grow, arrays cannot. 

   private Ball(){   // nobody can create a block without state
     this(1.0,0.1,0,0);
   }
   public Ball(double mass, double radius, double position, double speed){
      super(id++);
      this.mass = mass;
      this.radius = radius;
      pos_t = position;
      speed_t = speed;
      springs = new ArrayList<Spring>();
   }
   public double getRadius() {
      return radius;
   }
   public double getSpeed() {
      return speed_t;
   }
   private double getNetForce() {
    // to be coded by you
    double NetForce=0;

    for(Spring Myspring: springs){ // calculamos la fuerza neta que se produce en la bola sumando todas las fuerzas que actuan sobre ella
         NetForce += Myspring.getForce(this);
         } 
    
    return NetForce;
   }

   public double getMass(){
	  return mass;
   }
   public double getPosition(){
	  return pos_t;
   }

  public void computeNextState(double delta_t, MyWorld world) {
     Ball b;  // Assumption: on collision we only change speed.   
     if ((b=world.findCollidingBall(this))!= null){ /* elastic collision */
        speed_tPlusDelta=(speed_t*(mass-b.getMass())+2*b.getMass()*b.getSpeed())/(mass+b.getMass());
        pos_tPlusDelta = pos_t;
        a_t= getNetForce()/mass;
        }
     else if ((b=world.findCollidingFixedHook(this))!=null){ //detecta colision con fixedhook
        speed_tPlusDelta= -speed_t; //choque elastico en donde solo cambia el sentido de la velocidad
        pos_tPlusDelta = pos_t;
        a_t = getNetForce()/mass;   
     } else {
         // to be coded by you
         a_tMinusDelta = a_t;
         a_t= getNetForce()/mass;
         speed_tPlusDelta=speed_t+0.5*(3*a_t-a_tMinusDelta)*delta_t;
         pos_tPlusDelta = pos_t+speed_t*delta_t+0.1666667*(4*a_t-a_tMinusDelta)*delta_t*delta_t;                 
     }
   }
   public boolean collide(Ball b) {
      //a cada bola le pregunto a traves de su metodo collide si esta colisionando
	   // con alguna otra bola que le paso como argumento Ball b
      boolean estanCerca = Math.abs(this.pos_t - b.pos_t) <= (this.radius + b.radius);
      boolean seAcercan;
      if (getPosition() < b.getPosition())
            seAcercan = (b.getSpeed()-getSpeed()) <0;
       else
            seAcercan = (b.getSpeed()-getSpeed()) > 0;
       return estanCerca && seAcercan;
/*      
	   if ( ){ //es la distancia entre las bolas igual a la suma de los radios? Math.abs(this.pos_t - b.pos_t) <= (this.radius + b.radius)
		   // si es asi entonces las bolas estan chocando
		   return true;// entonces retorna verdadero.
	   }
	   else return false;
*/
    }
   public void updateState(){
     pos_t = pos_tPlusDelta;
     speed_t = speed_tPlusDelta;
   }
   
   public String getDescription() {
   // to be coded by you
   // FixedHook_0:x    Spring_0:a_end    b_end    Ball_0:x    Ball_1:x    
	   String Title; //titulo de la tabla de datos.
	   Title = "Ball_" + super.getId() + ":x";
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
   
}
