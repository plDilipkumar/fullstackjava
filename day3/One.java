public class One {
  public static void main(String[] args) {

    // 1. Variables
    String name = "Dilip";
    int age = 22;
    double percentage = 85.5;
    char grade = 'A';
    boolean pass = true;

    System.out.println("Name: " + name);
    System.out.println("Age: " + age);
    System.out.println("Percentage: " + percentage);
    System.out.println("Grade: " + grade);
    System.out.println("Passed: " + pass);

    // 2. Loop to print name 5 times
    for(int i=1; i<=5; i++){
      System.out.println(name);
    }

    // 3. Check even or odd
    int num = 7;
    if(num % 2 == 0){
      System.out.println(num + " is Even");
    } else {
      System.out.println(num + " is Odd");
    }

    // 4. Switch case
    int day = 4;
    switch(day){
      case 1: System.out.println("Monday"); break;
      case 2: System.out.println("Tuesday"); break;
      case 3: System.out.println("Wednesday"); break;
      case 4: System.out.println("Thursday"); break;
      case 5: System.out.println("Friday"); break;
      default: System.out.println("Invalid day");
    }
  }
}
