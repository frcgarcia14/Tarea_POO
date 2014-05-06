import java.util.*;

public class Ball extends PhysicsElement {
   private static int id=0;  // Ball identification number
   private final double mass;
   private final double radius;
   private double pos_t;     // current position at time t
   private double pos_tPlusDelta;  // next position in delta time in future
   private double speed_t;   // speed at time t
   private double speed_tPlusDelta;   // speed in delta time in future
   
   private Ball(){   // nobody can create a block without state
     this(1.0,0.1,0,0);
   }
   public Ball(double mass, double radius, double position, double speed){
      super(id++);
      this.mass = mass;
      this.radius = radius;
      pos_t = position;
      speed_t = speed;
   }
   public double getRadius() { //metodos para obtener datos de la bola desde otros objetos
      return radius;
   }
   public double getSpeed() {
      return speed_t;
   }
   public double getMass(){
	  return mass;
   }
   public double getPosition(){
	  return pos_t;
   }
   
   public void computeNextState(double delta_t, MyWorld world) { //calcula los datos del siguiente estado
     Ball b;  // Assumption: on collision we only change speed.   
     if ((b=world.findCollidingBall(this))!= null){ /* elastic collision */ //si encuentra a otra bola colisionando conmigo realiza esta accion
        speed_tPlusDelta = (speed_t*(mass-b.getMass())+2*b.getMass()*b.getSpeed())/(mass+b.getMass());
        pos_tPlusDelta = pos_t;
     } else {
        speed_tPlusDelta = speed_t;
        pos_tPlusDelta = pos_t + speed_t*delta_t;
     }
   }
   public boolean collide(Ball b) {
      //a cada bola le pregunto a traves de su metodo collide si esta colisionando
	   // con alguna otra bola que le paso como argumento Ball b
      boolean estanCerca = Math.abs(this.pos_t - b.pos_t) <= (this.radius + b.radius); //vemos si las bolas se estan tocando
      boolean seAcercan;
      if (getPosition() < b.getPosition()) //dependiente de las posiciones y de las velocidades de las bolas se acercan se indica si colisionan o no
            seAcercan = (b.getSpeed()-getSpeed()) <0;
       else
            seAcercan = (b.getSpeed()-getSpeed()) > 0;
       return estanCerca && seAcercan;
    }
    
   public void updateState(){ //actualiza el estado
     pos_t = pos_tPlusDelta;
     speed_t = speed_tPlusDelta;
   }
   
   public String getDescription() {
   // to be coded by you
   // FixedHook_0:x    Spring_0:a_end    b_end    Ball_0:x    Ball_1:x   
   // obtenemos la descripcion de la bola 
	   String Title; //titulo de la tabla de datos.
	   Title = "Ball_" + super.getId() + ":x";
	   return(Title);
   }
   public String getState(){
	   String State;
	   State = String.valueOf(this.getPosition());
	   return (State);
	   
   }

}
