class Main{
    public initialize(){
        int[10] arr
        int i, x
        x = 0
        arr.each do |i|{
            arr[x] = x
            x = x + 1
        }
        i = 0
        arr.each do |i|{
            print(i)
        }
    }
}
