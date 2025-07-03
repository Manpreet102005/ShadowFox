import java.util.*;
public class Calculator {
    public static void main(String[] args) {
        while(true){
            System.out.println();
            System.out.println("Enhanced Console Based Calculator");
            System.out.println("---------------------------------");
            System.out.println("Enter 1: Arithmetic Calculator");
            System.out.println("Enter 2: Scientific Calculator");
            System.out.println("Enter 3: Unit Converter");
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
                    UnitConverter.run();
                    break;
                case 4: return;
                default:
                    System.out.println("\nEnter Valid Choice");
            }
        }
    }
}

class ArithmeticCalculator{
    public static void run(){
        ArrayList<Double> inputs=new ArrayList<Double>();
        System.out.println("Arithmetic Calculator");
        System.out.println("---------------------");
        System.out.println("Enter 1: Addition");
        System.out.println("Enter 2: Subtraction");
        System.out.println("Enter 3: Multiplication");
        System.out.println("Enter 4: Division");
        System.out.println("Enter 5: Back");
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
        double sum=0;
        for(double i :numbers)sum+=i;
        return sum;
    }
    public static double subtraction (ArrayList<Double> numbers){
        double diff=numbers.get(0);
        for(int i=1;i<numbers.size();i++)diff-= numbers.get(i);
        return diff;
    }
    public static double multiplication (ArrayList<Double> numbers){
        double prod=1;
        for(double i :numbers)prod*=i;
        return prod;
    }
    public static double division (ArrayList<Double> numbers){
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
                double base,pow;
                System.out.print("\nEnter base:");
                base=Util.sc.nextDouble();
                System.out.print("\nEnter power:");
                pow=Util.sc.nextDouble();
                System.out.println("\nResult: "+Math.pow(base,pow));
                break;
            case 2:
                System.out.print("Enter number: ");
                double input=Util.sc.nextDouble();
                if(input<0) throw new ArithmeticException("Square root can't be negative.");
                System.out.println("\nSquare Root: "+Math.sqrt(input));
            case 3: return;
            default:
                System.out.println("Enter valid choice");
        }
    }
}

class UnitConverter{
    public static void run(){
        System.out.println("Unit Converter");
        System.out.println("--------------");
        System.out.println("Enter 1: Temperature Converter");
        System.out.println("Enter 2: Currency Converter");
        System.out.println("Enter 3: Back");
        System.out.println("--------------");
        System.out.println("Enter your choice:");
        int choice=Util.sc.nextInt();
        switch(choice){
            case 1:
                TempConverter.run();
                break;
            case 2:
                CurrencyConverter.run();
                break;
            case 3: return;
            default:
                System.out.println("Enter valid choice");
        }
    }
}
class TempConverter{
    public static void run(){
        System.out.println("Temperature Converter");
        System.out.println("---------------------");
        System.out.println("Enter 1: Celsius to Fahrenheit");
        System.out.println("Enter 2: Fahrenheit to Celsius");
        System.out.println("Enter 3: Back");
        System.out.println("---------------------");
        System.out.println("Enter choice");
        int choice= Util.sc.nextInt();
        switch(choice){
            case 1:
                System.out.print("Celsius: ");
                double celsius=Util.sc.nextDouble();
                CtoF(celsius);
                break;
            case 2:
                System.out.print("\nFahrenheit: ");
                double fahrenheit=Util.sc.nextDouble();
                FtoC(fahrenheit);
                break;
            case 3: return;
            default:
                System.out.println("Enter Valid Choice");
        }
    }
    public static void CtoF(double tempC){
        double tempF=(tempC*9/5)+32;
        System.out.println("Fahrenheit: "+tempF);
    }
    public static void FtoC(double tempF){
        double tempC=(5.0/9.0)*(tempF-32);
        System.out.println("Celsius: "+tempC);
    }
}
class CurrencyConverter{
    public static void run() {
        System.out.println("Currency Converter");
        System.out.println("------------------");
        System.out.println("1: Indian Rupees (INR)");
        System.out.println("2: American Dollar (USD)");
        System.out.println("3: Euro (EUR)");
        System.out.println("------------------");
        System.out.println("Enter ANY key to proceed further and '4' to go Back");
        char choice=Util.sc.next().charAt(0);
        if(choice=='4') return;
        else {
            System.out.println("Enter from currency number(from list)");
            int from = Util.sc.nextInt();
            System.out.println("Enter to currency number(from list)");
            int to = Util.sc.nextInt();
            if(from==1){
                System.out.print("Enter amount in INR:");
                double inr=Util.sc.nextDouble();
                if(to==2){
                    double usd=inr*0.012;
                    System.out.println("\nAmount in USD: "+usd);
                }
                if(to==3){
                    double eur=inr*0.0100;
                    System.out.println("Amount in EUR "+eur);
                }
            }
            if(from==2){
                System.out.print("Enter amount in USD:");
                double usd=Util.sc.nextDouble();
                if(to==1){
                    double inr=usd*85.41;
                    System.out.println("\nAmount in INR: "+inr);
                }
                if(to==3){
                    double eur=usd*0.85;
                    System.out.println("Amount in EUR: "+eur);
                }
            }
            if(from==3){
                System.out.print("Enter amount in EUR:");
                double eur=Util.sc.nextDouble();
                if(to==1){
                    double inr=eur*100.43;
                    System.out.println("\nAmount in INR: "+inr);
                }
                if(to==2){
                    double usd=eur*1.18;
                    System.out.println("Amount in USD: "+usd);
                }
            }
        }
    }
}

class Util {
    public static final Scanner sc = new Scanner(System.in);

    public static void takingInputs(ArrayList<Double> inputs) {
        while (true) {
            System.out.print("\nEnter NaN if you are done.");
            System.out.print("\nEnter input: ");
            try {
                double input = Util.sc.nextDouble();
                if (Double.isNaN(input)) break;
                inputs.addLast(input);
            } catch(InputMismatchException e){
                System.out.println("Enter valid choice");
                Util.sc.next();
            }catch(IllegalArgumentException e){
                System.out.println("Enter atleast two inputs");
            }
        }
    }
}