# Set

class Main {
    private Set<int> i

    public initialize() {
        Set<int> x
        int y, z
        bool t
        x = self.i
        x = self.i[1]
        x[1] = self.i
        x[1] = self.i[1]
        x = y
        x[0] = y
        x[0] = t
        self.i[0] = t
        x[t] = 12
        x[y] = self.i[z]
        x[z+y] = self.i[-1]
    }

    private bool set_test() {
        bool x
        x = !false
        i = Set.new((12,2*3,-1))
        i.add(x)
        i.add(2+123)
        i.merge(x,21,i)
        i.merge(2,21,12)
        return self.i.include(12)
    }
}
