# Void has ret

class Sample {
    private int x
    private bool y
}

class Main {
    public initialize() {
        int[12] a
        Set<int> ss, ss2
        fptr<int, bool->int> f
        int x, i, j
        bool t
        Sample s
        ss = Set.new()
        t = ss.include(x)
    }

    private void ch() {
        int x
        if x == 5 && !false {
            return 2
        }
    }
}
