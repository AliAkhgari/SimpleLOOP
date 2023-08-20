# harder index not int

class Sample {
    public initialize() {
        print(true)
    }
    private int x
    private bool y
}

class Main {
    public initialize() {
        int[12] a
        Set<int> ss
        fptr<int, bool->int> f
        int x, i, j
        bool t
        Sample s
        print(a[f()])
        print(a[f(2,true)])
        print(a[s.x])
        print(a[s.y])
        print(a[t?2:1])
    }
}

