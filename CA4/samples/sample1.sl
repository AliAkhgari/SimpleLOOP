class Test {
    public bool match_result(int x, int y, Sample s) {
        return (x+y) == s.get_xy_sum()
    }
}

class Sample {
    private int x, y
    public initialize(int x, int y, int uu) {
        self.x = x
        self.y = y
        print(x+y)
        print(uu)
    }
    public int get_xy_sum() {
        return self.x+self.y
    }
}

class Main {
    public int func(int i){
        return 1
    }

    public void f(int i, int j){
        int[10] a
        int[10] b
        int[10] c
        int h
        a[b[i+j] * 2] = c[self.func(i)]

    }
    public initialize() {
        self.f(1, 1)

    }
}


