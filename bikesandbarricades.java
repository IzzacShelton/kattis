import java.io.IOException;
import java.util.*;
public class bikesandbarricades {
   public static void main(String[] args) throws IOException {
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      double minIntercept = 1000; 
      for (int i=0; i<n; i++) {
         double intercept = yIntercept(sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt());
         if (intercept >= 0) {
            minIntercept = Math.min(minIntercept, intercept);
         }
      }
      
      System.out.println(minIntercept>100 ? -1.0 : minIntercept);
      sc.close();
   }

   public static double yIntercept(int x1, int y1, int x2, int y2) {
      // check if the endpoints cross the y axis and are not under the x axis
      if (Math.min(x1, x2) <= 0 && Math.max(x1, x2) >= 0 && !(y1 < 0 && y2 < 0) ) {
         // since we know the line segment does pass through the y axis, we can use the equation of a line to find the y intercept, i.e. where x=0
         // y - y1 = m*((x=0)-x1) -> y = -m*x1 + y1
         double m = (double)(y2-y1)/(x2-x1);
         return -m*x1+y1; 
      }
      // otherwise return -1 indicating there is no positive y intercept
      return -1;
   }
}
