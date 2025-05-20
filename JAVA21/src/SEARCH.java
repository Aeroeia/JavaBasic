public class SEARCH {
    public static void main(String[] args) {
        int[] arr = {16,5,9,12,21,18,
                32,23,37,26,45,34,
                50,48,61,52,73,66};
        Block b1 = new Block(21,0,5);
        Block b2 = new Block(45,6,11);
        Block b3 = new Block(73,12,17);
        Block[] blockArr = {b1,b2,b3};
        System.out.println(blockSearch(arr,blockArr,32));

    }
    public static boolean blockSearch(int[] arr,Block[] blockArr,int n){
        int index = -1;
        for(int i =0;i<blockArr.length;i++){
            if(n<=blockArr[i].max){
                index = i;
                break;
            }
        }
        if(index==-1)
            return false;
        for(int i = blockArr[index].startIndex;i<=blockArr[index].endIndex;i++){
            if(n==arr[i])
                return true;
        }
        return false;
    }
}
class Block{
    int max;
    int startIndex;
    int endIndex;

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getEndIndex() {
        return endIndex;
    }

    public void setEndIndex(int endIndex) {
        this.endIndex = endIndex;
    }

    public Block(int max, int startIndex, int endIndex) {
        this.max = max;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }
    public Block(){

    }
}
