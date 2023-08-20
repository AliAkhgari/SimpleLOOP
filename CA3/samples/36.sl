# Call match

class Sample {
   private int x
   public int y(Sample s2, int[12] arr, bool z = true, int x=2) {
       return x + self.x + s2.x
   }
}

class Main {
    public initialize() {
         Sample s, s2
         int res
         int[10] t
         res = s.y(s2, t)
         res = s.y(s2, t, 1)
         res = s.y(s2, t, !true)
         res = s.y(s2, t, false, t[0])
    }
}
