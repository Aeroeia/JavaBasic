public class T2_MyPaseInt {
    public static void main(String[] args) {
        String str = "1234";
        int n = parseInt(str);
        System.out.println(n+1);
    }
    public static int parseInt(String str){
        if(!str.matches("[1-9]\\d{1,9}")){
            return 0;
        }
        int n = 0;
        for(int i = 0;i<str.length();i++){
            n = n*10+(str.charAt(i)-'0');
        }
        return n;
    }
}

