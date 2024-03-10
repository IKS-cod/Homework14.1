import java.util.Arrays;

public class EmployeeBook {
    private Employee[] info = new Employee[10];

    //Создал метод "Распечатать ФИО всех сотрудников (метод ничего)."
    public void printFullInfo() {
        for (int i = 0; i < info.length; i++) {
            if (info[i] != null) {
                System.out.println(info[i].toString());
            }
        }

    }

    //Создал метод "Посчитать сумму затрат на ЗП в месяц"
    public double countSumSalary() {
        double totalSalary = 0;
        for (int i = 0; i < info.length; i++) {
            if (info[i] != null) {
                totalSalary = info[i].getSalary() + totalSalary;
            }
        }
        return totalSalary;
    }

    //Создал метод "Найти сотрудника с минимальной ЗП;"
    public Employee findPersonWithMinSalary() {
        double minSalary = Double.MAX_VALUE;
        int i = 0;
        for (int index = 0; index < info.length; index++) {
            if (info[index] != null && minSalary > info[index].getSalary()) {
                minSalary = info[index].getSalary();
                i = index;

            }
        }
        return info[i];
    }

    //Создал метод "Найти сотрудника с максимальной ЗП;"
    public Employee findPersonWithMaxSalary() {
        double maxSalary = Double.MIN_VALUE;
        int i = 0;
        for (int index = 0; index < info.length; index++) {
            if (info[index] != null && maxSalary < info[index].getSalary()) {
                maxSalary = info[index].getSalary();
                i = index;
            }
        }
        return info[i];
    }

    //Создал метод "Подсчитать среднее значение зарплат (можно использовать для этого метод из пункта b);"
    public double countMiddleSalary() {
        int count = 0;
        double totalSalary = 0;
        for (int i = 0; i < info.length; i++) {
            if (info[i] != null) {
                count += 1;
                totalSalary = info[i].getSalary() + totalSalary;
            }
        }
        if (count != 0) {
            double middleSalary = totalSalary / count;
            return middleSalary;
        } else {
            return count;
        }
    }

    //Создал метод "Распечатать ФИО всех сотрудников (метод ничего)."
    public void printFullName() {
        for (int i = 0; i < info.length; i++) {
            if (info[i] != null) {
                System.out.println(info[i].getFullName());
            }
        }
    }

    //Создал метод "Проиндексировать зарплату (вызвать изменение зп у всех сотрудников на величину аргумента в %)"
    public void changeSalaryOnPercent(double percentForEveryonePerson) {
        for (int i = 0; i < info.length; i++) {
            if (info[i] != null) {
                info[i].setSalary(info[i].getSalary() * (1 + percentForEveryonePerson / 100));
            }
        }
    }

    //Создал метод "Получить в качестве параметра номер отдела (1-5) и найти"
    //Сотрудника с минимальной зп;
    public Employee findMinSalaryInDepartment(int numberDepartment) {
        double minSalary = Double.MAX_VALUE;
        int i = 0;
        for (int index = 0; index < info.length; index++) {
            if (info[index] != null && info[index].getDepartment() == numberDepartment && minSalary > info[index].getSalary()) {
                minSalary = info[index].getSalary();
                i = index;
            }
        }
        return info[i];
    }

    //Создал метод "Получить в качестве параметра номер отдела (1-5) и найти"
    //Сотрудника с максимальной зп;
    public Employee findMaxSalaryInDepartment(int numberDepartment) {
        double maxSalary = Double.MIN_VALUE;
        int i = 0;
        for (int index = 0; index < info.length; index++) {
            if (info[index] != null && info[index].getDepartment() == numberDepartment && maxSalary < info[index].getSalary()) {
                maxSalary = info[index].getSalary();
                i = index;
            }
        }
        return info[i];
    }

    //Создал метод "Получить в качестве параметра номер отдела (1-5) и найти"
    //Сумму затрат на зп по отделу;
    public double countTotalSalaryInDepartment(int numberDepartment) {
        double sumSalary = 0;
        for (int i = 0; i < info.length; i++) {
            if (info[i] != null && info[i].getDepartment() == numberDepartment) {
                sumSalary = sumSalary + info[i].getSalary();
            }
        }
        return sumSalary;
    }

    //Создал метод "Получить в качестве параметра номер отдела (1-5) и найти"
    //Среднюю зп по отделу (учесть, что количество людей в отделе отличается от employees.length);
    public double countMiddleSalaryInDepartment(int numberDepartment) {
        double sumSalary = 0;
        int count = 0;
        for (int i = 0; i < info.length; i++) {
            if (info[i] != null && info[i].getDepartment() == numberDepartment) {
                count += 1;
                sumSalary = sumSalary + info[i].getSalary();
            }
        }
        if (count != 0) {
            double middleSalary = sumSalary / count;
            return middleSalary;
        } else {
            return count;
        }
    }

    //Создал метод "Получить в качестве параметра номер отдела (1-5) и найти"
    //Проиндексировать зарплату всех сотрудников отдела на процент, который приходит в качестве параметра;
    public void upPercentInDepartment(int numberDepartment, double percentUpSalaryInDepartment) {
        for (int i = 0; i < info.length; i++) {
            if (info[i] != null && info[i].getDepartment() == numberDepartment) {
                info[i].setSalary(info[i].getSalary() * (1 + percentUpSalaryInDepartment / 100));
            }
        }
    }

    //Создал метод "Получить в качестве параметра номер отдела (1-5) и найти"
    //Напечатать всех сотрудников отдела (все данные, кроме отдела).
    public void printInfoInDepartment(int numberDepartment) {
        for (int i = 0; i < info.length; i++) {
            if (info[i] != null && info[i].getDepartment() == numberDepartment) {
                info[i].printInfo();
            }
        }
    }

    //Создал метод "Получить в качестве параметра число и вывести:
    // Всех сотрудников с зп меньше числа (распечатать id, фио и зп в консоль);"
    public void findPersonsWithSalaryLessSalaryForSelectionEmployees(
            double salaryForSelectionEmployees) {
        System.out.println("Сотрудники с зарплатой <" + salaryForSelectionEmployees + " :");
        for (int i = 0; i < info.length; i++) {
            if (info[i] != null && info[i].getSalary() < salaryForSelectionEmployees) {
                info[i].printInfo();
            }
        }
    }

    //Создал метод "Получить в качестве параметра число и вывести:
    //Всех сотрудников с зп больше (или равно) числа (распечатать id, фио и зп в консоль)."
    public void findPersonsWithSalaryMoreSalaryForSelectionEmployees(
            double salaryForSelectionEmployees) {
        System.out.println("Сотрудники с зарплатой >=" + salaryForSelectionEmployees + " :");
        for (int i = 0; i < info.length; i++) {
            if (info[i] != null && info[i].getSalary() >= salaryForSelectionEmployees) {
                info[i].printInfo();
            }
        }
    }

    //Создал метод " Добавить нового сотрудника. (метод должен найти свободную ячейку в массиве и положить нового
    // сотрудника в нее. Поиск свободных ячеек происходит с начала массива. Если свободных мест для сотрудника нет,
    // то метод должен вернуть false, если для сотрудника нашлось место, то метод должен вернуть true)"
    public boolean addPerson(Employee newEmployee) {
        boolean added = false;
        for (int i = 0; i < info.length; i++) {
            if (info[i] == null) {
                info[i] = newEmployee;
                added = true;
                break;
            }
        }
        return added;
    }

    //Создал метод "Удалить сотрудника (находим сотрудника по id, нуллим его ячейку в массиве);"
    public void deletePersonForId(int numberDeleteId) {
        for (int i = 0; i < info.length; i++) {
            if (info[i].getId() == numberDeleteId) {
                info[i] = null;
                break;
            }
        }
    }

    //Создал метод "Добавить метод для получения сотрудника по id"
       public Employee findPersonForId(int numberIdForFindPerson) {
        Employee newEmployee=null;
        for (int index = 0; index < info.length; index++) {
            if (info[index] != null && info[index].getId() == numberIdForFindPerson) {
              newEmployee=info[index];
                break;
            }
        }
        return newEmployee;
    }


}
