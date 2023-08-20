# Use void ret

class Sample {
   private int x
   public void y(int x) {
      print(x)
   }
}

class Main {
    public initialize() {
         Sample s
         fptr <int -> void> f
         print(s.y(s.x))
    }
}
