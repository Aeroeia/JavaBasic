public class Lcs {
    public static void main(String[] args) {
        lcs_subStirng("abcdef".toCharArray(),"eqwabceq".toCharArray());
        lcs_subSequence("abcefgd".toCharArray(),"acfgdeqw".toCharArray());
    }
    //最长公共字串
    public static void lcs_subStirng(char[] s1,char[] s2){
        int[][] dp = new int[s1.length+1][s2.length+1];
        int start = 0;
        int max = 0;
        for(int i = 1;i<=s1.length;i++){
            for(int j = 1;j<=s2.length;j++){
                if(s1[i-1]==s2[j-1]){
                    dp[i][j] = dp[i-1][j-1]+1;
                }
                if(dp[i][j]>max){
                    max = dp[i][j];
                    start = i-max;
                }
            }
        }
        System.out.println(max);
        System.out.println(new String(s1).substring(start,start+max));
    }
    public static void lcs_subSequence(char[] s1,char[] s2){
        int[][] dp = new int[s1.length+1][s2.length+1];
        for(int i = 1;i<=s1.length;i++){
            for(int j = 1;j<=s2.length;j++){
                if(s1[i-1]==s2[j-1]){
                    dp[i][j] = dp[i-1][j-1]+1;
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        int i = s1.length;
        int j = s2.length;
        StringBuilder sb = new StringBuilder();
        while(i>0&&j>0){
            if(s1[i-1]==s2[j-1]){
                sb.append(s1[i-1]);
                i--;
                j--;
            }
            else if(dp[i-1][j]>dp[i][j-1]){
                i--;
            }
            else{
                j--;
            }
        }
        System.out.println(sb.reverse());
    }
}
