package singleton_pattern_java;

public class Student {

    private String name;
    private static Student[] students;

    private Student(String name){
        this.name = name;
    };

   public static  Student[] getStudents(){
       if(students == null){
           createArrayOfStudents();
       }
       return students;
   }

   private static void  createArrayOfStudents(){
      students = new Student[]{
              new Student("Mihir"),
              new Student("Hari"),
              new Student("Yash"),
              new Student("Aayan"),
              new Student("Suresh"),
              new Student("Shayan"),
              new Student("Azirel")
      };
   }

    public String toString(){
        return "Name: "+name;
    }
}
