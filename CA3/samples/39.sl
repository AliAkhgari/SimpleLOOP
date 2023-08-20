# call match initialize

class Sample {
    private int x1, x2, x3
    private bool b1, b2

    public initialize(int x1, int x2, int x3, bool b1 = true, bool b2 = false) {
        self.x2 = x1 + x2*x3
        self.b1 = b1 || b2
    }
}

class Main {
    public initialize() {
        Sample s, s2
        int[12] arr
        Set<int> set
        s = Sample.new()
        s = Sample.new(12, true)
        s = Sample.new(s2.x1, s2.x2, s2.x3)
        s = Sample.new(s2.x1, s2.x2, s2.x3, set.include(s2.x1))
        s = Sample.new(arr[0], arr[1])
        s = Sample.new(arr, 1, 2)
    }
}

