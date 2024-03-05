import java.util.Arrays;

public class Main {
    private static class EmployeeBook {
        private static Employee[] info = new Employee[10];{
            EmployeeBook.info[0] = new Employee("Ivanov Ivan Ivanovich", 20_000, 1);
            EmployeeBook.info[1] = new Employee("Petrov Petr Petrovich", 50_000, 1);
            EmployeeBook.info[2] = new Employee("Sergeev Sergei Sergeevich", 1_000, 3);
            EmployeeBook.info[3] = new Employee("Denisov Denis Denisovich", 60_000, 3);
            EmployeeBook.info[4] = new Employee("Abrikosov Dmitriy Borisovich", 100_000, 2);
            EmployeeBook.info[5] = new Employee("Kulikov Stepan Ivanovich", 70_000, 2);
            EmployeeBook.info[6] = new Employee("Sidorov Mihail Mihailovich", 30_000, 1);
            EmployeeBook.info[7] = new Employee("Plahov Oleg Olegovich", 90_000, 4);
            EmployeeBook.info[8] = new Employee("Mironov Nikita Aleksandrovich", 150_000, 1);
            EmployeeBook.info[9] = new Employee("Sundukov Aleksei Evgenevich", 5_000, 1);
        }
        private static int countDep;

        //Создал метод "Посчитать сумму затрат на ЗП в месяц"
        public double countSumSalary(Employee[] info) {
            double totalSalary = 0;
            for (int i = 0; i < info.length; i++) {
                if (info[i] != null) {
                    totalSalary = info[i].getSalary() + totalSalary;
                }
            }
            return totalSalary;
        }

        //Создал метод "Найти сотрудника с минимальной ЗП;"
        public Employee findPersonWithMinSalary(Employee[] info) {
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
        public Employee findPersonWithMaxSalary(Employee[] info) {
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
        public double countMiddleSalary(Employee[] info) {
            int count = 0;
            for (int i = 0; i < info.length; i++) {
                if (info[i] != null) {
                    count += 1;
                }
            }
            if (count != 0) {
                double middleSalary = countSumSalary(info) / count;
                return middleSalary;
            } else {
                return count;
            }
        }

        //Создал метод "Распечатать ФИО всех сотрудников (метод ничего)."
        public void printFullName(Employee[] info) {
            for (int i = 0; i < info.length; i++) {
                if (info[i] != null) {
                    System.out.println(info[i].getFullName());
                }
            }
        }

        //Создал метод "Проиндексировать зарплату (вызвать изменение зп у всех сотрудников на величину аргумента в %)"
        public void changeSalaryOnPercent(Employee[] info, double percentForEveryonePerson) {
            for (int i = 0; i < info.length; i++) {
                if (info[i] != null) {
                    info[i].setSalary(info[i].getSalary() * (1 + percentForEveryonePerson / 100));
                }
            }
        }

        //Создал метод "Получить в качестве параметра номер отдела (1-5) и найти"
        //Сотрудника с минимальной зп;
        public Employee findMinSalaryInDepartment(Employee[] info, int numberDepartment) {
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
        public Employee findMaxSalaryInDepartment(Employee[] info, int numberDepartment) {
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
        public double countTotalSalaryInDepartment(Employee[] info, int numberDepartment) {
            double sumSalary = 0;
            countDep = 0;
            for (int i = 0; i < info.length; i++) {
                if (info[i] != null && info[i].getDepartment() == numberDepartment) {
                    sumSalary = sumSalary + info[i].getSalary();
                    countDep += 1;
                }
            }
            return sumSalary;
        }

        //Создал метод "Получить в качестве параметра номер отдела (1-5) и найти"
        //Среднюю зп по отделу (учесть, что количество людей в отделе отличается от employees.length);
        public double countMiddleSalaryInDepartment(Employee[] info, int numberDepartment) {
            double middleSalary;
            if (countDep != 0) {
                middleSalary = countTotalSalaryInDepartment(info, numberDepartment) / countDep;
                return middleSalary;
            } else {
                return countDep;
            }
        }

        //Создал метод "Получить в качестве параметра номер отдела (1-5) и найти"
        //Проиндексировать зарплату всех сотрудников отдела на процент, который приходит в качестве параметра;
        public void upPercentInDepartment(Employee[] info, int numberDepartment, double percentUpSalaryInDepartment) {
            for (int i = 0; i < info.length; i++) {
                if (info[i] != null && info[i].getDepartment() == numberDepartment) {
                    info[i].setSalary(info[i].getSalary() * (1 + percentUpSalaryInDepartment / 100));
                }
            }
        }

        //Создал метод "Получить в качестве параметра номер отдела (1-5) и найти"
        //Напечатать всех сотрудников отдела (все данные, кроме отдела).
        public void printInfoInDepartment(Employee[] info, int numberDepartment) {
            for (int i = 0; i < info.length; i++) {
                if (info[i] != null && info[i].getDepartment() == numberDepartment) {
                    printInfo(info, i);
                }
            }
        }

        //Создал метод "Получить в качестве параметра число и вывести:
        // Всех сотрудников с зп меньше числа (распечатать id, фио и зп в консоль);"
        public void findPersonsWithSalaryLessSalaryForSelectionEmployees(Employee[] info,
                                                                         double salaryForSelectionEmployees) {
            System.out.println("Сотрудники с зарплатой <" + salaryForSelectionEmployees + " :");
            for (int i = 0; i < info.length; i++) {
                if (info[i] != null && info[i].getSalary() < salaryForSelectionEmployees) {
                    printInfo(info, i);
                }
            }
        }

        //Создал метод "Получить в качестве параметра число и вывести:
        //Всех сотрудников с зп больше (или равно) числа (распечатать id, фио и зп в консоль)."
        public void findPersonsWithSalaryMoreSalaryForSelectionEmployees(Employee[] info,
                                                                         double salaryForSelectionEmployees) {
            System.out.println("Сотрудники с зарплатой >=" + salaryForSelectionEmployees + " :");
            for (int i = 0; i < info.length; i++) {
                if (info[i] != null && info[i].getSalary() >= salaryForSelectionEmployees) {
                    printInfo(info, i);
                }
            }
        }

        //Хотел создать метод вывода информации
        public void printInfo(Employee[] info, int i) {
            System.out.print("id " + info[i].getId() + ", ");
            System.out.print("ФИО " + info[i].getFullName() + ", ");
            System.out.print("зарплата " + info[i].getSalary());
            System.out.println();
        }

        //Создал метод " Добавить нового сотрудника. (метод должен найти свободную ячейку в массиве и положить нового
        // сотрудника в нее. Поиск свободных ячеек происходит с начала массива. Если свободных мест для сотрудника нет,
        // то метод должен вернуть false, если для сотрудника нашлось место, то метод должен вернуть true)"
        public String addPerson(Employee[] info, String fullName, double salary, int department) {
            String text = "xxx";
            for (int i = 0; i < info.length; i++) {
                if (info[i] == null) {
                    info[i] = new Employee(fullName, salary, department);
                    text = "true";
                    break;
                } else {
                    text = "false";
                }
            }
            return text;
        }

        //Создал метод "Удалить сотрудника (находим сотрудника по id, нуллим его ячейку в массиве);"
        public void deletePersonForId(Employee[] info, int numberDeleteId) {
            for (int i = 0; i < info.length; i++) {
                if (info[i].getId() == numberDeleteId) {
                    info[i] = null;
                }
            }
        }

        //Создал метод "Добавить метод для получения сотрудника по id"
        public Employee findPersonForId(Employee[] info, int numberIdForFindPerson) {
            int i = 0;
            for (int index = 0; index < info.length; index++) {
                if (info[index] != null && info[index].getId() == numberIdForFindPerson) {
                    i = index;
                }
            }
            return info[i];
        }
    }

    public static void main(String[] args) {
        EmployeeBook a = new EmployeeBook();


//Вызываем метод для " Получить список всех сотрудников со всеми имеющимися по ним данными
        // (вывести в консоль значения всех полей (toString));"
        System.out.println(Arrays.toString(EmployeeBook.info));
        //Вызываем метод для "Посчитать сумму затрат на ЗП в месяц"
        double totalSalary = a.countSumSalary(EmployeeBook.info);
        System.out.println("Сумма затрат на ЗП в месяц = " + totalSalary);
        //Вызываем метод для "Найти сотрудника с минимальной ЗП;"
        Employee personWithMinSalary = a.findPersonWithMinSalary(EmployeeBook.info);
        System.out.println("Cотрудник с минимальной ЗП " + personWithMinSalary);
        //Вызываем метод для "Найти сотрудника с максимальной ЗП;"
        Employee personWithMaxSalary = a.findPersonWithMaxSalary(EmployeeBook.info);
        System.out.println("Cотрудник с максимальной ЗП " + personWithMaxSalary);
        //Вызываем метод для "Подсчитать среднее значение зарплат (можно использовать для этого метод из пункта b);"
        double middleSalary = a.countMiddleSalary(EmployeeBook.info);
        System.out.println("Среднее значение зарплат = " + middleSalary);
        //Вызываем метод для "Распечатать ФИО всех сотрудников (метод ничего)."
        a.printFullName(EmployeeBook.info);
        //////////////////////ПОВЫШЕННАЯ СЛОЖНОСТЬ//////////////////
        ///////////////////////////////////////////////////////////
        //Вызываем метод для "Проиндексировать зарплату (вызвать изменение зп у всех сотрудников на величину аргумента в %)"
        double percentForEveryonePerson = 0;//для второго задания (индексация сотрудников)
        a.changeSalaryOnPercent(EmployeeBook.info, percentForEveryonePerson);
        // System.out.println("info[4].getSalary() = " + info[4].getSalary());
        //Назначаем номер отдела для отбора сотрудников по отделам
        int numberDepartment = 1;// nomberDepartment может быть от 1 до 5 включительно
        //Вызываем метод для "Получить в качестве параметра номер отдела (1-5) и найти"
        ////Сотрудника с минимальной зп;
        //  Employee personWithMinSalaryInDepartment=Employee.
        Employee personWithMinSalaryInDepartment = a.findMinSalaryInDepartment(EmployeeBook.info, numberDepartment);
        System.out.println("Cотрудник в отделе " + numberDepartment + " c минимальной ЗП " + personWithMinSalaryInDepartment);
        //Вызываем метод для "Получить в качестве параметра номер отдела (1-5) и найти"
        ////Сотрудника с максимальной зп;
        Employee personWithMaxSalaryInDepartment = a.findMaxSalaryInDepartment(EmployeeBook.info, numberDepartment);
        System.out.println("Cотрудник в отделе " + numberDepartment + " c максимальной ЗП " + personWithMaxSalaryInDepartment);
        //Вызываем метод для "Получить в качестве параметра номер отдела (1-5) и найти"
        ////Сумму затрат на зп по отделу;
        a.countTotalSalaryInDepartment(EmployeeBook.info, numberDepartment);
        System.out.println("Сумма затрат на зп по отделу " + numberDepartment + " равна " + a.countTotalSalaryInDepartment(EmployeeBook.info, numberDepartment));
        //Вызываем метод для "Получить в качестве параметра номер отдела (1-5) и найти"
        ////Среднюю зп по отделу (учесть, что количество людей в отделе отличается от employees.length);
        a.countMiddleSalaryInDepartment(EmployeeBook.info, numberDepartment);
        System.out.println("Средняя зп по отделу " + numberDepartment + " равна " + a.countMiddleSalaryInDepartment(EmployeeBook.info, numberDepartment));
        //Вводим процент индексации зарплаты сотрудноков в отделе
        double percentUpSalaryInDepartment = 0;
        //Вызываем метод для "Получить в качестве параметра номер отдела (1-5) и найти"
        ////Проиндексировать зарплату всех сотрудников отдела на процент, который приходит в качестве параметра;
        a.upPercentInDepartment(EmployeeBook.info, numberDepartment, percentUpSalaryInDepartment);
        //Вызываем метод для "Получить в качестве параметра номер отдела (1-5) и найти"
        ////Напечатать всех сотрудников отдела (все данные, кроме отдела).
        a.printInfoInDepartment(EmployeeBook.info, numberDepartment);
        //Назначаем число для отбора сотрудников по зарплате больше/меньше salaryForSelectionEmployees
        double salaryForSelectionEmployees = 18_000;
        //Вызываем метод для "Получить в качестве параметра число и вывести:
        // Всех сотрудников с зп меньше числа (распечатать id, фио и зп в консоль);"
        a.findPersonsWithSalaryLessSalaryForSelectionEmployees(EmployeeBook.info, salaryForSelectionEmployees);
        //Вызываем метод для "Получить в качестве параметра число и вывести:
        //Всех сотрудников с зп больше (или равно) числа (распечатать id, фио и зп в консоль)."
        a.findPersonsWithSalaryMoreSalaryForSelectionEmployees(EmployeeBook.info, salaryForSelectionEmployees);
//////////////////////ОЧЕНЬ СЛОЖНО//////////////////
        ///////////////////////////////////////////////////////////
        //Вызываем метод для "Удалить сотрудника (находим сотрудника по id, нуллим его ячейку в массиве);"
        int numberDeleteId = 1;
        a.deletePersonForId(EmployeeBook.info, numberDeleteId);
        System.out.println("Ячейка по индексу " + numberDeleteId + " = " + EmployeeBook.info[0]);
        //Вызываем метод для "Добавить нового сотрудника. (метод должен найти свободную ячейку в массиве и положить
        // нового сотрудника в нее. Поиск свободных ячеек происходит с начала массива. Если свободных мест для
        // сотрудника нет, то метод должен вернуть false, если для сотрудника нашлось место, то метод должен вернуть true):
        System.out.println("Сотрудник добавился(true) или нет(false): " + a.addPerson(EmployeeBook.info, "Sidorov Stepan Olegovich", 17_000, 2));
        System.out.println("Ячейка по индексу " + numberDeleteId + " = " + EmployeeBook.info[0]);

        //Вызываем метод для "Добавить метод для получения сотрудника по id"
        int numberIdForFindPerson = 3;
        System.out.println("По id = " + numberIdForFindPerson + " находится сотрудник: " + a.findPersonForId(EmployeeBook.info, numberIdForFindPerson));

    }
}