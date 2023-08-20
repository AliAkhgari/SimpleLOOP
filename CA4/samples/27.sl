class Fib{
	public int fib(int num){
		if (num < 3)
			return 1
		return self.fib(num - 1) + self.fib(num - 2)
	}
}

class Main{
	public initialize(){
		Fib f
		f = Fib.new()
		print(f.fib(9))
	}

}
