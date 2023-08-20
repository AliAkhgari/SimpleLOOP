int total_grade, total_cost;

class Student {
    private int grade, cost
    public initialize(int grade, int cost=100) {
        self.grade = grade
        self.cost = cost
        self.enrollments = Set.new()
        print(self.cost);
    }
    public Set<int> enrollments
    public void enroll(int cid, int cost) {
        enrollments.add(cid)
        self.cost = cost
        self.cost++
    }

}
class Course  {
    private int cid, cost;
    public void set_cid(int _cid) {
        self.cid = _cid
        self.cid++
    }
    public int get_cid() {
            return self.cid
        }
    public void set_cost(int cost) {
        self.cost = self.cost + cost
    }
    public int get_cost() {
            return self.cost
        }
}

class Main {
    public initialize() {
        Course crs
        int i
        Course crs2
               Student[5] students
    crs.set_cid(1)
        crs.set_cost(120)
        students.each do |i|
            students[i].enroll(crs.get_cid(), crs.get_cost())
        if crs.get_cost() < 100 {
            print(1)
        }
        elsif crs.get_cost() == 100 {
            print(2)
        }
        elsif crs.get_cost() > 100 {
            print(3)
        }
        crs2.set_cid(crs.get_cid() == 1?  crs.get_cost() < 100 ? 2 : 3  : 4)
        print(crs2.get_cid())
    }
}


