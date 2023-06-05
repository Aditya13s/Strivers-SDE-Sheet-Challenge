import java.util.* ;
import java.io.*; 

public class Solution {
	public static ArrayList<ArrayList<Long>> printPascal(int n) {
        
        ArrayList<ArrayList<Long>> ans = new ArrayList<>();
        for(int i=0; i<n; i++){
            ArrayList<Long> res = new ArrayList<>();
            if(i == 0) {
                res.add((long)1);
                ans.add(res);
            } else if(i == 1) {
                res.add((long)1);
                res.add((long)1);
                ans.add(res);
            } else {
                res.add((long)1);
                for(int j=1; j<i; j++) {
                    
                    res.add((long) ans.get(i-1).get(j-1) + (long) ans.get(i-1).get(j));
                }
                res.add((long)1);

                ans.add
            }
        }

        return ans;
	}
}
