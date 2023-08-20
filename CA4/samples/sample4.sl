int id
class Employee {
    private int salary, exp, bonus;
    public initialize(int exp, int bonus, int salary) {
        self.exp = exp;
        self.bonus = bonus
        self.salary = salary

    }
    public int get_salary(int[12] months)
    {
        int idx, i, sum
        int[21] emps
        months.each do |idx| {
            (1-1..30).each do |i|
                sum = sum + self.salary
            print(sum < 1200 ? 1200 : (sum+self.bonus))
        }


        print(1)
        emps.each do |i| {
             print(1)
        }

        return sum
    }

}

class Main {
    public initialize() {
        int i
        Employee emp
        emp = Employee.new(10, 10 , 10)
    }
}
