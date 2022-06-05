package Sort;

import java.util.*;

public class 성적이낮은순서로학생출력하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n= sc.nextInt();
        List<Student> list = new ArrayList<>();
        for(int i=0; i<n;i++){
            String name = sc.next();
            int score = sc.nextInt();
            list.add(new Student(name,score));
        }

        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
               if(o1.score<o2.score) return -1;

               return 1;
            }
        });

        for(Student s : list){
            System.out.print(s.name + " ");
        }
    }
}
class Student{
    String name;
    int score;

    public Student(String name, int score){
        this.name = name;
        this.score = score;
    }

    public String getName(){
        return this.name;
    }

    public int getScore(){
        return this.score;
    }
}
