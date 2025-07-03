import java.util.*;
public class Calculator {
    public static void main(String[] args) {
        while(true){
            System.out.println();
            System.out.println("Enhanced Console Based Calculator");
            System.out.println("---------------------------------");
            System.out.println("Enter 1: Arithmetic Calculator");
            System.out.println("Enter 2: Scientific Calculator");
            System.out.println("Enter 3: Unit Conversion ");
            System.out.println("Enter 4: Exit ");
            System.out.println("---------------------------------");
            System.out.print("Enter your choice:");
            int choice=Util.sc.nextInt();
            switch(choice){
                case 1:
                    ArithmeticCalculator.run();
                    break;
                case 2:
                    ScientificCalculator.run();
                    break;
                case 3:

                    break;
                case 4: return;
                default:
                    System.out.println();
                    System.out.println("Enter Valid Choice");
            }
        }
    }
}

class ArithmeticCalculator{
    public static void run(){
        ArrayList<Double> inputs=new ArrayList<Double>();
        System.out.println("Arithmetic Calculator");
        System.out.println("---------------------");
        System.out.println("Press 1: Addition");
        System.out.println("Press 2: Subtraction");
        System.out.println("Press 3: Multiplication");
        System.out.println("Press 4: Division");
        System.out.println("Press 5: Back");
        System.out.println("---------------------");
        System.out.print("Enter choice:");
        int choice=Util.sc.nextInt();
        switch(choice){
            case 1:
                Util.takingInputs(inputs);
                System.out.println("Result: "+addition(inputs));
                inputs.clear();
                break;
            case 2:
                Util.takingInputs(inputs);
                System.out.println("Result: "+subtraction(inputs));
                inputs.clear();
                break;
            case 3:
                Util.takingInputs(inputs);
                System.out.println("Result: "+multiplication(inputs));
                inputs.clear();
                break;
            case 4:
                Util.takingInputs(inputs);
                System.out.println("Result: "+division(inputs));
                inputs.clear();
                break;
            case 5: return;
            default:
                System.out.println("Enter valid choice");
        }
    }
    public static double addition (ArrayList<Double> numbers){
        if(numbers.size()<=1){
            throw new IllegalArgumentException("Atleast two numbers are required.");
        }
        double sum=0;
        for(double i :numbers)sum+=i;
        return sum;
    }
    public static double subtraction (ArrayList<Double> numbers){
        if(numbers.size()<=1){
            throw new IllegalArgumentException("Atleast two numbers are required.");
        }
        double diff=numbers.get(0);
        for(int i=1;i<numbers.size();i++)diff-= numbers.get(i);
        return diff;
    }
    public static double multiplication (ArrayList<Double> numbers){
        if(numbers.size()<=1){
            throw new IllegalArgumentException("Atleast two numbers are required.");
        }
        double prod=1;
        for(double i :numbers)prod*=i;
        return prod;
    }
    public static double division (ArrayList<Double> numbers){
        if(numbers.size()<=1){
            throw new IllegalArgumentException("Atleast two numbers are required.");
        }
        double quotient=numbers.get(0);
        for(int i=1;i<numbers.size();i++) {
            if(numbers.get(i)==0){
                throw new ArithmeticException("Number can't be divided by 0.");
            }
            quotient/= numbers.get(i);
        }
        return quotient;
    }
}

class ScientificCalculator{
    public static void run(){
        System.out.println("Scientific Calculator");
        System.out.println("---------------------");
        System.out.println("Enter 1: Exponent");
        System.out.println("Enter 2: Square Root");
        System.out.println("Enter 3: Back");
        System.out.println("---------------------");
        System.out.print("Enter your choice:");
        int choice=Util.sc.nextInt();
        switch (choice){
            case 1:
                int base,pow;
                System.out.print("\nEnter base:");
                base=Util.sc.nextByte();
                System.out.print("\nEnter power:");
                pow=Util.sc.nextByte();
                System.out.println("\nResult: "+Math.pow(base,pow));
                break;
            case 2:
                System.out.print("Enter number: ");
                double input=Util.sc.nextDouble();
                if(input<0) throw new ArithmeticException("Square root can't be negative.");
                System.out.println("\nResult: "+Math.sqrt(input));
            case 3: return;
            default:
                System.out.println("Enter valid choice");
        }
    }
}

class UnitConversion{}

class Util{
    public static final Scanner sc=new Scanner(System.in);
    public  static void takingInputs(ArrayList<Double> inputs){
        while(true){
            System.out.print("\nEnter NaN if you are done.");
            System.out.print("\nEnter input: ");
            double input=Util.sc.nextDouble();
            if(Double.isNaN(input)) break;
            inputs.addLast(input);
        }
    }
}