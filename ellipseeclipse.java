import java.util.Scanner;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
public class ellipseeclipse {
   public static void main(String[] args) {
      try (Scanner sc = new Scanner(System.in)) {
         int x1 = sc.nextInt();
         int y1 = sc.nextInt();
         int x2 = sc.nextInt();
         int y2 = sc.nextInt();
         int a = sc.nextInt();
         
         // the equation of the ellipse:
         // sqrt((x-x1)^2 + (y-y1)^2) + sqrr((x-x2)^2 + (y-y1)^2) = a
         
         // the x and y coords of the midpoint between the foci 
         double xmid = (double) (x1+x2)/2.0; 
         double ymid = (double) (y1+y2)/2.0;
         
         // derived from noticing that the min/max x bounds are the same as the x coordinates
         // of the points on the circle with radius a/2 centered at (xmid, ymid) with y coords of
         // either y1 or y2. And similarly for the y bounds, the y coords of points on the circle
         // who's x coord is either x1 or x2. That is:
         // solving for x in (x - xmid)^2 + ([y1 or y2] - ymid) = (a/2)^2
         // and solving for y in ([x1 or x2] - xmid)^2 + (y - ymid)^2 = (a/2)^2
         // both of which have two solutions, one being the min bound, and one being the max
         double halfWidth = sqrt((a*a)/4.0 - pow(y1-ymid, 2));
         double halfHeight = sqrt((a*a)/4.0 - pow(x1-xmid, 2));

         double xlow = xmid - halfWidth;
         double xhigh = xmid + halfWidth;
         double ylow = ymid - halfHeight;
         double yhigh = ymid + halfHeight;
         
         System.out.printf("%f %f %f %f\n", xlow, ylow, xhigh, yhigh);
      }
   }
}
