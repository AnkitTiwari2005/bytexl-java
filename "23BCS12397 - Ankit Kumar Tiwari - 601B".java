// Ankit Kumar Tiwari - 23BCS12397
import java.io.*;
import java.util.*;

class Student implements Serializable {
    int studentID;
    String name;
    String grade;
    Student(int studentID, String name, String grade) {
        this.studentID = studentID;
        this.name = name;
        this.grade = grade;
    }
}

class Employee {
    int id;
    String name;
    String designation;
    double salary;
    Employee(int id, String name, String designation, double salary) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        this.salary = salary;
    }
    @Override
    public String toString() {
        return id + " " + name + " " + designation + " " + salary;
    }
}

public class Main12397 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== MAIN MENU ===");
            System.out.println("1. Sum of Integers (Autoboxing)");
            System.out.println("2. Serialize & Deserialize Student");
            System.out.println("3. Employee Management System");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    partA();
                    break;
                case 2:
                    partB();
                    break;
                case 3:
                    partC();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    static void partA() {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();
        System.out.println("Enter integers (type 'end' to stop):");
        while (true) {
            String input = sc.next();
            if (input.equalsIgnoreCase("end")) break;
            Integer num = Integer.parseInt(input);
            numbers.add(num);
        }
        int sum = 0;
        for (Integer i : numbers) sum += i;
        System.out.println("Sum: " + sum);
    }

    static void partB() {
        try {
            Student s = new Student(101, "Ankit", "A");
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("student.dat"));
            oos.writeObject(s);
            oos.close();
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("student.dat"));
            Student st = (Student) ois.readObject();
            ois.close();
            System.out.println("ID: " + st.studentID + " Name: " + st.name + " Grade: " + st.grade);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void partC() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n-- Employee Management --");
            System.out.println("1. Add Employee\n2. Display Employees\n3. Back to Main Menu");
            int choice = sc.nextInt();
            if (choice == 1) {
                System.out.print("Enter ID: ");
                int id = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter Name: ");
                String name = sc.nextLine();
                System.out.print("Enter Designation: ");
                String des = sc.nextLine();
                System.out.print("Enter Salary: ");
                double sal = sc.nextDouble();
                Employee e = new Employee(id, name, des, sal);
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter("employees.txt", true));
                    bw.write(e.toString());
                    bw.newLine();
                    bw.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            } else if (choice == 2) {
                try {
                    BufferedReader br = new BufferedReader(new FileReader("employees.txt"));
                    String line;
                    while ((line = br.readLine()) != null) System.out.println(line);
                    br.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            } else if (choice == 3) {
                break;
            } else {
                System.out.println("Invalid choice");
            }
        }
    }
}
// Ankit Kumar Tiwari - 23BCS12397
