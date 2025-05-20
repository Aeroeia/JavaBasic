import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomFetch {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        list.add(new Person("A",1));
        list.add(new Person("B",2));
        list.add(new Person("C",3));
        for(int i = 0;i<10;i++){
            System.out.println(selected(list));
        }


    }
    private static Person selected(List<Person> list){
        int totalweight = 0;
        int[] weights = new int[list.size()];
        for(int i = 0;i<list.size();i++){
            totalweight+=list.get(i).weight;
            weights[i] = totalweight;
        }
        Random r =  new Random();
        int random = r.nextInt(totalweight)+1;
        System.out.print(random+" ");
        int left = 0;
        int right = weights.length-1;
        while(left<right){
            int mid = (left+right)>>1;
            if(weights[mid]<random){
                left = mid+1;
            }
            else{
                right = mid;
            }
        }
        return list.get(left);
    }
    private static class Person{
        String name;
        int weight;
        Person(String name,int weight){
            this.name = name;
            this.weight = weight;
        }
        Person(){

        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", weight=" + weight +
                    '}';
        }
    }
}