import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        EmployeeBook a = new EmployeeBook();
        a.addPerson(new Employee("Petrov Petr Petrovich", 50_000, 1));
        a.addPerson(new Employee("Sergeev Sergei Sergeevich", 1_000, 3));
        a.addPerson(new Employee("Denisov Denis Denisovich", 60_000, 3));
        a.addPerson(new Employee("Abrikosov Dmitriy Borisovich", 100_000, 2));
        a.addPerson(new Employee("Kulikov Stepan Ivanovich", 70_000, 2));


//Вызываем метод для " Получить список всех сотрудников со всеми имеющимися по ним данными
        // (вывести в консоль значения всех полей (toString));"
        a.printFullInfo();
        //Вызываем метод для "Посчитать сумму затрат на ЗП в месяц"
        double totalSalary = a.countSumSalary();
        System.out.println("Сумма затрат на ЗП в месяц = " + totalSalary);
        //Вызываем метод для "Найти сотрудника с минимальной ЗП;"
        Employee personWithMinSalary = a.findPersonWithMinSalary();
        System.out.println("Cотрудник с минимальной ЗП " + personWithMinSalary);
        //Вызываем метод для "Найти сотрудника с максимальной ЗП;"
        Employee personWithMaxSalary = a.findPersonWithMaxSalary();
        System.out.println("Cотрудник с максимальной ЗП " + personWithMaxSalary);
        //Вызываем метод для "Подсчитать среднее значение зарплат (можно использовать для этого метод из пункта b);"
        double middleSalary = a.countMiddleSalary();
        System.out.println("Среднее значение зарплат = " + middleSalary);
        //Вызываем метод для "Распечатать ФИО всех сотрудников (метод ничего)."
        a.printFullName();
        //////////////////////ПОВЫШЕННАЯ СЛОЖНОСТЬ//////////////////
        ///////////////////////////////////////////////////////////
        //Вызываем метод для "Проиндексировать зарплату (вызвать изменение зп у всех сотрудников на величину аргумента в %)"
        double percentForEveryonePerson = 0;//для второго задания (индексация сотрудников)
        a.changeSalaryOnPercent(percentForEveryonePerson);
        // System.out.println("info[4].getSalary() = " + info[4].getSalary());
        //Назначаем номер отдела для отбора сотрудников по отделам
        int numberDepartment = 1;// nomberDepartment может быть от 1 до 5 включительно
        //Вызываем метод для "Получить в качестве параметра номер отдела (1-5) и найти"
        ////Сотрудника с минимальной зп;
        //  Employee personWithMinSalaryInDepartment=Employee.
        Employee personWithMinSalaryInDepartment = a.findMinSalaryInDepartment(numberDepartment);
        System.out.println("Cотрудник в отделе " + numberDepartment + " c минимальной ЗП " + personWithMinSalaryInDepartment);
        //Вызываем метод для "Получить в качестве параметра номер отдела (1-5) и найти"
        ////Сотрудника с максимальной зп;
        Employee personWithMaxSalaryInDepartment = a.findMaxSalaryInDepartment(numberDepartment);
        System.out.println("Cотрудник в отделе " + numberDepartment + " c максимальной ЗП " + personWithMaxSalaryInDepartment);
        //Вызываем метод для "Получить в качестве параметра номер отдела (1-5) и найти"
        ////Сумму затрат на зп по отделу;
        a.countTotalSalaryInDepartment(numberDepartment);
        System.out.println("Сумма затрат на зп по отделу " + numberDepartment + " равна " + a.countTotalSalaryInDepartment(numberDepartment));
        //Вызываем метод для "Получить в качестве параметра номер отдела (1-5) и найти"
        ////Среднюю зп по отделу (учесть, что количество людей в отделе отличается от employees.length);
        a.countMiddleSalaryInDepartment(numberDepartment);
        System.out.println("Средняя зп по отделу " + numberDepartment + " равна " + a.countMiddleSalaryInDepartment(numberDepartment));
        //Вводим процент индексации зарплаты сотрудноков в отделе
        double percentUpSalaryInDepartment = 0;
        //Вызываем метод для "Получить в качестве параметра номер отдела (1-5) и найти"
        ////Проиндексировать зарплату всех сотрудников отдела на процент, который приходит в качестве параметра;
        a.upPercentInDepartment(numberDepartment, percentUpSalaryInDepartment);
        //Вызываем метод для "Получить в качестве параметра номер отдела (1-5) и найти"
        ////Напечатать всех сотрудников отдела (все данные, кроме отдела).
        a.printInfoInDepartment(numberDepartment);
        //Назначаем число для отбора сотрудников по зарплате больше/меньше salaryForSelectionEmployees
        double salaryForSelectionEmployees = 18_000;
        //Вызываем метод для "Получить в качестве параметра число и вывести:
        // Всех сотрудников с зп меньше числа (распечатать id, фио и зп в консоль);"
        a.findPersonsWithSalaryLessSalaryForSelectionEmployees(salaryForSelectionEmployees);
        //Вызываем метод для "Получить в качестве параметра число и вывести:
        //Всех сотрудников с зп больше (или равно) числа (распечатать id, фио и зп в консоль)."
        a.findPersonsWithSalaryMoreSalaryForSelectionEmployees(salaryForSelectionEmployees);
//////////////////////ОЧЕНЬ СЛОЖНО//////////////////
        ///////////////////////////////////////////////////////////
        //Вызываем метод для "Удалить сотрудника (находим сотрудника по id, нуллим его ячейку в массиве);"
        System.out.println();
        int numberDeleteId = 2;
        a.deletePersonForId(numberDeleteId);
        a.printFullInfo();
        //Вызываем метод для "Добавить нового сотрудника. (метод должен найти свободную ячейку в массиве и положить
        // нового сотрудника в нее. Поиск свободных ячеек происходит с начала массива. Если свободных мест для
        // сотрудника нет, то метод должен вернуть false, если для сотрудника нашлось место, то метод должен вернуть true):
        System.out.println("Сотрудник добавился(true) или нет(false): " + a.addPerson(new Employee("A A A", 50_000, 1)));
        //     System.out.println("Ячейка по индексу " + numberDeleteId + " = " + a.info[0]);
        a.printFullInfo();
        //Вызываем метод для "Добавить метод для получения сотрудника по id"
        int numberIdForFindPerson = 2;
        System.out.println("По id = " + numberIdForFindPerson + " находится сотрудник: " + a.findPersonForId(numberIdForFindPerson));

    }
}