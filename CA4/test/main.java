import java.util.Scanner;
class SimpleCalculator {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        int result = 0;
        System.out.println("Enter the operation(+, -):");
        String operator = myObj.nextLine();
        System.out.println("Enter number1:");
        int operand1 = myObj.nextInt();
        System.out.println("Enter number2:");
        int operand2 = myObj.nextInt();
        switch (operator) {
            case "+":
                result = operand1 + operand2;
                break;
            case "-":
                result = operand1 - operand2;
                break;
        }
        System.out.println("Result is:" + result);
        myObj.close();
    }
}

