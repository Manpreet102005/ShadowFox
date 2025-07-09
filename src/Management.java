import java.util.*;
public class Management {
     private static ArrayList<String> names=new ArrayList<>();
     private static ArrayList<String> phoneNos=new ArrayList<>();
     private static ArrayList<String> emails=new ArrayList<>();

    public static void main(String [] args){
        while (true) {
            System.out.println();
            System.out.println("Contact Management System");
            System.out.println("-------------------------");
            System.out.println("1. Add Contact");
            System.out.println("2. Update Contact");
            System.out.println("3. Delete Contact");
            System.out.println("4. View Contacts");
            System.out.print("Enter your choice: ");
            int choice = Util.sc.nextInt();
            Util.sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("\nEnter Full Name: ");
                    String fullName = Util.sc.nextLine();
                    System.out.print("\nEnter Phone Number: ");
                    String phoneNo = Util.sc.nextLine();
                    System.out.print("\nEnter Email: ");
                    String email = Util.sc.nextLine();
                    addContact(fullName, phoneNo, email);
                    break;
                case 2:
                    Update.run();
                    break;
                case 3:
                    String name = Util.sc.nextLine();
                    delete(name);
                    break;
                case 4:
                    viewContacts();
                    break;
                default:
                    System.out.println("Enter valid choice");
            }
        }
    }
public static void addContact(String fullName,String phoneNo, String email){
        names.add(fullName);
        phoneNos.add(phoneNo);
        emails.add(email);
        System.out.println("Contact added successfully");
}
static class Update {
    public static void run(){
        System.out.println("Contact Updation");
        System.out.println("Enter 1: Update Name");
        System.out.println("Enter 2: Update Phone Number");
        System.out.println("Enter 3: Update Email");
        System.out.print("Enter your choice: ");
        int choice=Util.sc.nextInt();
        Util.sc.nextLine();
        System.out.println("Enter Phone Number: ");
        String phoneNo=Util.sc.nextLine();
        switch(choice){
            case 1:
                updateName(phoneNo);
                break;
            case 2:
                updatePhoneNo(phoneNo);
                break;
            case 3:
                updateEmail(phoneNo);
                break;
            default:
                System.out.println("Enter valid choice.");
        }
    }
    public static void updateName(String phoneNo) {
        for (int i=0;i<phoneNos.size();i++) {
            if (phoneNos.get(i).equals(phoneNo)) {
                System.out.print("Enter new full name: ");
                String newFullName = Util.sc.nextLine();
                names.set(i,newFullName);
                System.out.println("\nName updated successfully.");
                break;
            }
        }
    }

    public static void updatePhoneNo(String phoneNo) {
        for (int i=0;i<phoneNos.size();i++) {
            if (phoneNos.get(i).equals(phoneNo)) {
                System.out.print("Enter new phone number: ");
                String newPhoneNo=Util.sc.nextLine();
                phoneNos.set(i,newPhoneNo);
                System.out.println("\nPhone number updated successfully.");
                break;
            }
        }
    }

    public static void updateEmail(String phoneNo) {
        for (int i=0;i<phoneNos.size();i++) {
            if (phoneNos.get(i).equals(phoneNo)) {
                System.out.print("Enter new email: ");
                String newEmail = Util.sc.nextLine();
                emails.set(i,newEmail);
                System.out.println("\nEmail updated successfully.");
                break;
            }
        }
    }
}
public static void delete(String phoneNo){
        for(int i=0;i<names.size();i++){
            if(names.get(i).equals(phoneNo)){
                names.remove(i);
                phoneNos.remove(i);
                emails.remove(i);
                System.out.println("Contact deleted successfully.");
                break;
            }
        }
}
public static void viewContacts(){
    System.out.println("Full Name\t\tPhone Number\t\tEmail");
    System.out.println("---------\t\t------------\t\t-----");
    for(int i=0;i<names.size();i++){
        System.out.println(names.get(i)+"\t\t"+phoneNos.get(i)+"\t\t"+emails.get(i));
    }
}

}


