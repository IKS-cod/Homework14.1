import java.util.Objects;

public class Employee {
    private String fullName;
    private double salary;
    private int department;
    private int id;
    private static int counter = 1;
    private final int countDepartment = 5;
    private static char[] m = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '-', '.', ',', '_', '!', '?', '@', '$', '/',
            '=', '[', ']', '{', '}', '(', ')', '&', '^', '%', '#', ';', '>', '<', '"', '№'};

    //Создал конструктор класса Employee
    public Employee(String fullName, double salary, int department) {
        this.fullName = fullName;
        this.salary = salary;
        this.department = department;
        id = counter++;
        checkErrorDepartment(department, countDepartment);
        checkErrorSalary(salary);
        checkErrorFullName(fullName, m);
    }

    public static void checkErrorDepartment(int department, int countDepartment) {
        if (department < 1 || department > countDepartment) {
            throw new RuntimeException("Поле department заполнено не корректно");
        }
    }

    public static void checkErrorSalary(double salary) {
        if (salary <= 0) {
            throw new RuntimeException("Поле salary заполнено не корректно");
        }
    }

    public static void checkErrorFullName(String fullName, char[] m) {
        char[] c = fullName.toCharArray();
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < m.length; j++) {
                if (c[i] == m[j]) {
                    throw new RuntimeException("Поле fullName заполнено не корректно");
                }
            }
        }
    }

    //Создал геттер id
    public int getId() {
        return this.id;
    }

    //Создал геттер fullName
    public String getFullName() {
        return this.fullName;
    }

    //Создал сеттер salary
    public void setSalary(double salary) {
        this.salary = salary;
    }

    //Создал геттер salary
    public double getSalary() {
        return this.salary;
    }

    //Создал сеттер department
    public void setDepartment(int department) {
        this.department = department;
    }

    //Создал геттер department
    public int getDepartment() {
        return this.department;
    }

    @Override
    public String toString() {
        return "id =" + id + ", ФИО =" + fullName + ", зарплата =" + salary + ", отдел =" + department + ";";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
