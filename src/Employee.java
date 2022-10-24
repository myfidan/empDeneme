public class Employee {
    private String name;
    private double salary;
    private int workHours;
    private int hireYear;

    public Employee(String name, double salary, int workHours, int hireYear) {
        this.name = name;
        this.salary = salary;
        this.workHours = workHours;
        this.hireYear = hireYear;
    }

    //Calculate tax for salary
    public double tax(){
        return salary < 1000 ? 0 : salary * 3 / 100.0;
    }

    public double bonus(){
        return workHours - 40 > 0 ? (workHours-40)*30 : 0;
    }

    public double raiseSalary() throws Exception {
        final int currentYear = 2021;
        final int workingYear = currentYear - hireYear;
        final double currentSalary = salary - tax() + bonus();

        if(workingYear < 10 && workingYear >= 0) return currentSalary * 5 / 100.0;
        else if(workingYear > 9 && workingYear < 20) return currentSalary * 10 / 100.0;
        else if(workingYear > 19) return currentSalary * 15 / 100.0;
        else{ // if workingYear negative, this means hireYear value wrong
            System.out.println("Working year is negative, wrong hireYear");
            throw new Exception("Invalid hire year");
        }
    }

    @Override
    public String toString() {

        try {
            return
                    "Adı : " + name  +
                    "\nMaaşı : " + salary +
                    "\nÇalışma Saati : " + workHours +
                    "\nBaşlangıç Yılı : " + hireYear +
                    "\nVergi : " + tax() +
                    "\nBonus : " + bonus() +
                    "\nMaaş Artışı : " + raiseSalary() +
                    "\nVergi ve Bonuslar ile birlikte maaş : " + (bonus()+salary-tax()) +
                    "\nToplam maaş : " + (bonus()+salary+raiseSalary());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
