public class KMP {
    public static void main(String[] args) {
        String text = "aabaabaafa";
        String pattern = "aabaaf";
        int[] next = new int[pattern.length()];
        getNext(next,pattern);
        int j = 0;
        for(int i = 0;i<text.length();i++) {
            while (j > 0 && text.charAt(i) != pattern.charAt(j)) {
                j = next[j - 1];
            }
            if (text.charAt(i) == pattern.charAt(j)) {
                j++;
            }
            if (j == pattern.length()) {
                System.out.println(i - j + 1);
                break;
            }
        }

    }
    public static void getNext(int[] next,String pattern){
        next[0] = 0;
        int j = 0;
        for(int i = 1;i<pattern.length();i++){
            while(j>0&&pattern.charAt(j)!=pattern.charAt(i)){
                j = next[j-1];
            }
            if(pattern.charAt(j)==pattern.charAt(i)){
                j++;
            }
            next[i] = j;
        }
    }
}
