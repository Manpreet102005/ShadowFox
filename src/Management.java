import java.util.*;
public class Management {
     private static ArrayList<String> names=new ArrayList<>();
     private static ArrayList<String> phoneNos=new ArrayList<>();
     private static ArrayList<String> emails=new ArrayList<>();
     public static void mainMenu(){
         while (true) {
             System.out.println("-------------------------");
             System.out.println("Contact Management System");
             System.out.println("-------------------------");
             System.out.println("1: Add Contact");
             System.out.println("2: Update Contact");
             System.out.println("3: Delete Contact");
             System.out.println("4: View Contacts");
             System.out.println("5: Exit");
             System.out.print("Enter your choice: ");
             int choice = Util.sc.nextInt();
             Util.sc.nextLine();
             switch (choice) {
                 case 1:
                     System.out.print("\nEnter Full Name: ");
                     String fullName = Util.sc.nextLine();
                     System.out.print("\nEnter Phone Number: ");
                     String phoneNo = Util.sc.nextLine();
                     if(phoneNo.length()!=10) {
                         System.out.println("Length of phone number should be of 10 digits.");
                         break;
                     }
                     System.out.print("\nEnter Email: ");
                     String email = Util.sc.nextLine();
                     addContact(fullName, phoneNo, email);
                     break;
                 case 2:
                     Update.run();
                     break;
                 case 3:
                     System.out.print("Enter phone number of user you want to delete:");
                     String phone = Util.sc.nextLine();
                     delete(phone);
                     break;
                 case 4:
                     viewContacts();
                     break;
                 case 5:return;
                 default:
                     System.out.println("!! ENTER VALID CHOICE !!");
             }
         }
     }
    public static void main(String [] args){
        mainMenu();
    }
    public static void addContact(String fullName,String phoneNo, String email){
         boolean exists=false;
         for(int i=0;i<names.size();i++) {
             if (phoneNos.get(i).equals(phoneNo)) {
                 exists = true;
                 System.out.println("A user with this phone number already exists.");
                 break;
             } else if (emails.get(i).equals(email)) {
                 exists = true;
                 System.out.println("A user with this email address already exists.");
                 break;
             }
         }
         if(!exists){
             names.add(fullName);
             phoneNos.add(phoneNo);
             emails.add(email);
             System.out.println("Contact added successfully");
         }
    }
static class Update {
    public static void run(){
        System.out.println("----------------");
        System.out.println("Contact Updation");
        System.out.println("----------------");
        System.out.println("1: Update Name");
        System.out.println("2: Update Phone Number");
        System.out.println("3: Update Email");
        System.out.println("4: Back");
        System.out.print("Enter your choice: ");
        int choice=Util.sc.nextInt();
        Util.sc.nextLine();
        System.out.print("\nEnter Phone Number: ");
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
            case 4:
                break;
            default:
                System.out.println("\n!! ENTER VALID CHOICE !!");
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
                for(int j=0;j<phoneNos.size();j++){
                    if(phoneNos.get(j).equals(newPhoneNo)){
                        System.out.println("!! A user with this phone number already exists.");
                        break;
                    }
                }
                if(newPhoneNo.length()!=10){
                    System.out.println("!! Length of phone number should be of 10 digits. !!");
                    break;
                }
                else {
                    phoneNos.set(i, newPhoneNo);
                    System.out.println("\nPhone number updated successfully.");
                    break;
                }
            }
        }
    }

    public static void updateEmail(String phoneNo) {
        for (int i=0;i<phoneNos.size();i++) {
            if (phoneNos.get(i).equals(phoneNo)) {
                System.out.print("Enter new email: ");
                String newEmail = Util.sc.nextLine();
                for(int j=0;j<emails.size();j++){
                    if(phoneNos.get(j).equals(newEmail)){
                        System.out.println("!! A user with this email address already exists.");
                        break;
                    }
                }
                emails.set(i,newEmail);
                System.out.println("\nEmail updated successfully.");
                break;
            }
        }
    }
}
public static void delete(String phoneNo){
    System.out.println("-------------");
    System.out.println("Confirmation");
    System.out.println("-------------");
    System.out.println("1: Confirm");
    System.out.println("2: Back");
    System.out.print("Enter your choice: ");
    int choice=Util.sc.nextInt();
    Util.sc.nextLine();
    switch(choice){
        case 1:
            boolean exists=false;
            int i;
            for(i=0;i<phoneNos.size();i++){
                if(phoneNos.get(i).equals(phoneNo)){
                    exists=true;
                    break;
                }
            }
            if(exists){
                names.remove(i);
                phoneNos.remove(i);
                emails.remove(i);
                System.out.println("Contact deleted successfully.");
            }
            else System.out.println("Contact doesn't exist.");
            break;
        case 2:
            break;
        default:
            System.out.println("!! ENTER VALID CHOICE !!");
    }
}
public static void viewContacts(){
    System.out.printf("%-20s %-20s %-20s%n","Name","Phone Number","Email");
    System.out.printf("%-20s %-20s %-20s%n","------------------","------------------","------------------");
    if(names.size()==0) System.out.printf("%35s%n","No Contacts");

    for(int i=0;i<names.size();i++)System.out.printf("%-20s %-20s %-20s%n",names.get(i),phoneNos.get(i),emails.get(i));
    System.out.println("-".repeat(60));
}
}


