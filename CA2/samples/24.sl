class Main {
    private Set<int> set
    public initialize() {
        set = Set.new((1,2,3,4))
        set.merge(1,2,6)
        set.delete(1)
        if set.include(6)
            set.merge(77,22)
    }
}


