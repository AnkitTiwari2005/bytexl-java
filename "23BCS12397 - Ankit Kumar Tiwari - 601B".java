// Ankit Kumar Tiwari - 23BCS12397
import java.io.*;
import java.util.*;

class PartA {
    public static void main(String[] args) {
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
}

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

class PartB {
    public static void main(String[] args) {
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

class PartC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1. Add Employee\n2. Display Employees\n3. Exit");
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
