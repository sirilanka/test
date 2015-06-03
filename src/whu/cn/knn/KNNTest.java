package whu.cn.knn;
//new

import java.util.Arrays;  
//import java.util.IdentityHashMap;  
import java.util.Map;  
import java.util.TreeMap;  

public class KNNTest {  
  public static void main(String[] args) {  
      double[][] group = { { 1.0, 1.1 }, { 1.0, 1.0 }, { 0, 0 }, { 0, 0.1 } };  
      char[] lable = { 'A', 'A', 'B', 'B' };  

      double[] test = { 2, 3 };  

      int k = 3;  

      double[] theDistance = new double[4];  
      for (int i = 0; i < 4; i++) {  
          theDistance[i] = createDistance(test, group[i], 2);  
      }  
        
      int[] count = classify(theDistance, lable, k, 4);  
      if (count[0] > count[1]){  
          System.out.println('A');  
      }else{  
          System.out.println('B');  
      }  
  }  

  public static double createDistance(double[] data, double[] group, int n) {  
      double tmp = 0;  
      for (int i = 0; i < n; i++) {  
          tmp += (data[i] - group[i]) * (data[i] - group[i]);  
      }  
      return Math.sqrt(tmp);  
  }  
    
  public static int[] classify(double[] distance, char[] lable, int k, int n){  
      int[] tmp = new int[2];  
//    Map<Double, Character> map = new IdentityHashMap<Double, Character>();  
      Map<Double, Character> map = new TreeMap<Double, Character>();  
      for (int i = 0; i < n; i++){  
          map.put(distance[i], lable[i]);  
      }  
      Arrays.sort(distance);  
      char c;  
      for (int i = 0; i < k; i++){  
          c = map.get(distance[i]);  
          if (c == 'A'){  
              tmp[0]++;  
          }else{  
              tmp[1]++;  
          }  
      }  
      return tmp;  
  }  

}  
