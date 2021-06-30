//Christine Baca


import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ClosestPair {
    public double closestPairDistance(List<String> fileData) {
/*
 0) Get and sort the array
 */
        
        ArrayList<Point2D.Double> list = new ArrayList();
        double delta = 0;
        double median;
        
        //Transfer file data
        String temp[];
        for (String line : fileData) {
            Point2D.Double d = new Point2D.Double();
            temp = line.split(" ", 0);
            //   System.out.print("| Line Numbers : " + temp.length);
            assert (temp.length == 2);
            double x = Double.valueOf(temp[0]);
            double y = Double.valueOf(temp[1]);
            //   System.out.print("  Coordinates : " + x + ", " + y);
            d.setLocation(x, y);
            list.add(d);
        }
        
        
        //sort x coordinates
        list.sort(Comparator.comparing(Point2D.Double::getX));
        
/*
 1) Find the middle point in the sorted array, we can take P[n/2] as middle point.
 */
        int median_index = list.get(list.size() / 2);

/*
 2) Divide the given array in two halves. The first subarray contains points from P[0] to P[n/2]. The second subarray contains points from P[n/2+1] to P[n-1].
  */
        ArrayList<Point2D.Double> list_half_1 = new ArrayList();
        ArrayList<Point2D.Double> list_half_2 = new ArrayList();
        
        for(int i = 0; i < list.size(); i++)
        {
            if(i <= median_index)
                list_half_1.add(list.get(i));
            else
                list_half_2.add(list.get(i));
            
        }
/*
  3) Recursively find the smallest distances in both subarrays. Let the distances be dl and dr. Find the minimum of dl and dr. Let the minimum be d.
  */
        double dl = find_closest_distance(list_half_1, 0, list_half_1.size());
        double dr = find_closest_distance(list_half_2, 0, list_half_2.size());
        double d = Math.min(dl,dr);
 
 /*
 4) From above 3 steps, we have an upper bound d of minimum distance. Now we need to consider the pairs such that one point in pair is from left half and other is from right half. Consider the vertical line passing through passing through P[n/2] and find all points whose x coordinate is closer than d to the middle vertical line. Build an array strip[] of all such points.
  */
        ArrayList<Point2D.Double> list_strip = new ArrayList();
        for(Point2D.Double p : list)
        {
            if(dist(p,list.get(median_index)) < d)
            {
                list_strip.add(p);
            }
        }
        
        list_strip.sort(Comparator.comparing(Point2D.Double::getY));
        return Math.min(d, strip_closest_distance(list_strip, list_strip.size(), d))
        


    }
    
    //HELPERS
    double find_closest_distance(ArrayList<Point2D.Double> list,int start, int end){
        if(n <= 3)
            return brute_force(list, n);
        int middle_index = n/2;
        Point2D.Double middle_value = list.get(middle_index);
        double dl = find_closest_distance(list, start, middle_index);
        double dr = find_closest_distance(list, start + middle_index, n - middle_index);
    }
    
    double brute_force(ArrayList<Point2D.Double> list, int n){
        double min_value = Double.POSITIVE_INFINITY();
        for(int i = 0; i < n; i++)
        {
            for(int j = i + 1; j < n; j++)
            {
                if(dist(list.get(i), list.get(j)) < min)
                    min = dist(list.get(i), list.get(j));
            }
        }
        
    }
    double distance(int index_1, int index_2)
                   {
                       return ...
                   }
    double strip_closest_distance(ArrayList<Point2D.Double> list, int size, double d)
    {
        double min = d;
        
        for(int i = 0; i < size; i++)
        {
            for(int j  = i + 1;
                (i < size) && ((list.get(j).getY() - strip.get(i).getY()) < min);
                j++)
            {
                if(dist(strip.get(i), list.get(j)) < min)
                    min = dist(strip.get(i), list.get(j));
                
            }
        }
        return min;
    }
    
}
                   
