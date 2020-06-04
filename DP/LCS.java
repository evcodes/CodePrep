// Given two strings, compute the longest common sequence between the strings

/** For example:
 * cars, spar = 2 (ar)
 * micro micko = 4 (mico)
 * elephant etarzant = 4 (eant)
 * red blue = 1 (e)
 * 1    1
 * micro micko = 4 (mico)
 * 
 * a    b       0
 * ac    bc       1
 * 
 * aca    bca       1
 * acf    bcd       1
 * ""  ""
 **/ 


//     a c a
//   0 0 0 0 
// b 0 0 0 0
// c 0 0 1 1
// a 0 1 1 2

public class LCS {

    int max(int x, int y){
        if(x > y){
            return x;
        }else{
            return y;
        }
    }

    int computeLCS(String str1, String str2){
        
        int n = str1.length();
        int m = str2.length();
        int[][] visited = new int[n+1][m+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                if (i == 0 || j == 0) {
                    visited[i][j] = 0;
                }else{
                    if(str1.charAt(i-1) == str2.charAt(j-1)){
                        visited[i][j] = 1 + visited[i-1][j-1];
                    }else{
                        visited[i][j] = max(visited[i][j-1], visited[i-1][j]);
                    }
                }
            }
        }
        return visited[n][m];
    }

    public static void main (String[] args){
        LCS l = new LCS();

        int[] answerArray = new int[] {3,4,4,1,2};
        int[] solutions = new int[5];

        solutions[0] = l.computeLCS("cars","spars");
        solutions[1] = l.computeLCS("micro","micko");
        solutions[2] = l.computeLCS("elephant","etarzant");
        solutions[3] = l.computeLCS("red","blue");
        solutions[4] = l.computeLCS("car","far");
        
        for (int i = 0; i<5; i++){
            if (answerArray[i] != solutions[i]){
                System.out.println(i);
                System.out.println("Failure");
            }
        }        
    }
}