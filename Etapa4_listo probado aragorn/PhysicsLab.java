import java.util.Scanner;

public class PhysicsLab {
   public static void main(String[] args) {
   
   	   double deltaTime = 0;
	   double endTime = 0;
	   double samplingTime = 0;
      if (args.length != 3 && args.length != 0)  {
        System.out.println("usage: java PhysicsLab <delta_time[s]> <end_time[s]> <sampling_time[s]>");
        System.exit(-1);
      }
      if(args.length == 3){
      deltaTime = Double.parseDouble(args[0]);    // [s]
      endTime = Double.parseDouble(args[1]);      // [s]
      samplingTime = Double.parseDouble(args[2]); // [s]
      }
      else if(args.length == 0){
    	  Scanner s= new Scanner (System.in);
    	  System.out.print("Ingrese delta:");
    	  String st = s.nextLine();
    	  deltaTime = Double.parseDouble(st);
    	  System.out.print("Ingrese tiempo a simular:");
    	  st = s.nextLine();
    	  endTime =  Double.parseDouble(st);
          System.out.print("Ingrese tiempo entre escrituras en la salida del estado del sistema:");
          st = s.nextLine();
    	  samplingTime =  Double.parseDouble(st);
    	  
      }
      MyWorld world = new MyWorld(System.out);
      
      double mass = 1.0;      // 1 [kg] 
      double radius = 0.1;    // 10 [cm] 
      double position = 0;  // 0 [m] 
      double speed = 1;     // 0 [m/s]
      double arista = 0.1;
      
      FixedHook f0 = new FixedHook(0.1,0);
      Ball b0 = new Ball(mass, radius, 1.5, speed);
      Ball b1 = new Ball(mass, radius, 2, 0);
      Spring spring = new Spring(1.0, 1);
      spring.attachEnd2(f0);
      spring.attachEnd1(b0);
      
      world.addElement(spring);
      world.addElement(f0);
      world.addElement(b0);
      world.addElement(b1);
      world.simulate(deltaTime, endTime, samplingTime); // delta time[s], total simulation time [s].
   }
}
