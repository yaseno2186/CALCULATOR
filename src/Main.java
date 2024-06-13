import java.util.Scanner;

public class Main {
    static Scanner inputs = new Scanner(System.in);
    public static void main(String[] args){
    System.out.println("Here is the Calculator: ");
    System.out.println("Enter your first number: ");
    int num1 = inputs.nextInt();
    System.out.println("Enter your second number: ");
    int num2 = inputs.nextInt();
    System.out.println("What you wanna do with this two numbers? ");
    System.out.println("Enter such as in the brackets: ");
    System.out.println("Plus (+)");
    System.out.println("Minus (-)");
    System.out.println("Divide (/)");
    System.out.println("Multiply (*)");
    char magic = inputs.next().charAt(0);
    if(magic == '+'){
        int result = num1 + num2;
        System.out.println(num1+"+"+num2+"="+ result);
    }
    if(magic == '-'){
        int result = num1 - num2;
        System.out.println(num1+"-"+num2+ "="+result);
    }
    if(magic == '/'){
        int result = num1 / num2;
        System.out.println(num1+"/"+num2+ "="+result);
    }
    if(magic == '*') {
        int result = num1 * num2;
        System.out.println(num1 + "*" + num2 + "=" + result);
    }
    else { System.out.println("Are you tryen to kidin with me or wa . Watch out Bro!!");}
        System.out.println("What now ha?");


    }
}