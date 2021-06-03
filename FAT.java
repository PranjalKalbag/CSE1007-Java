import java.io.*;
import java.util.*;
class Donor implements Serializable
{
    private static final long serialVersionUID = 1L;
    int age;
    String name;
    String contact;
    String address;
    String date;
    String type;
    public Donor(int a, String b, String c, String d, String e, String f)
    {
        age = a;
        name = b;
        contact = c;
        address = d;
        date = e;
        type = f;
    }
}
public class FAT
{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=0;
        //Object Serialization
        try{
            System.out.println("Enter number of users: ");
            n = in.nextInt();
            in.nextLine();
            Donor donor[] = new Donor[n];
            FileOutputStream fos = new FileOutputStream("file.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for(int i = 0;i<n;i++){
                System.out.println("Enter Name: ");
                String name = in.nextLine();
                in.nextLine();
                System.out.println("Enter Age: ");
                int age = in.nextInt();
                in.nextLine();
                System.out.println("Enter Contact: ");
                String contact = in.nextLine();
                in.nextLine();
                System.out.println("Enter Address: ");
                String address = in.nextLine();
                in.nextLine();
                System.out.println("Enter date of Last Donation in DD-MM-YYYY format: ");
                String date = in.nextLine();
                in.nextLine();
                System.out.println("Enter Blood Type: ");
                String type = in.nextLine();
                in.nextLine();
                donor[i] = new Donor(age, name, contact, address, date, type);
            }
            for(int i=0;i<n;i++)
            {
                oos.writeObject(donor[i]);
                oos.flush();
            }

            oos.close();
        }
        catch(Exception e)
        {
            System.out.println("Exception caught");
            System.out.println(e);
        }

        //Object Deserialization
        try{
            FileInputStream fis = new FileInputStream("file.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            System.out.println("Valid Donors are:");
            for(int i = 0;i<n;i++)
            {
                Donor d2 = (Donor)ois.readObject();
                if(d2.type.equalsIgnoreCase("A+ve"))
                {
                    if((3-Integer.valueOf(d2.date.substring(0,2))>=0 && 6-Integer.valueOf(d2.date.substring(3,5))==5) || (Integer.valueOf(d2.date.substring(3,5))-6>0 && Integer.valueOf(d2.date.substring(6))-2021<0))
                    {    
                        System.out.println("Name: "+d2.name);
                        System.out.println("Age: "+d2.age);
                        System.out.println("Contact: "+d2.contact);
                        System.out.println("Address: "+d2.address);
                        System.out.println("Date: "+d2.date);
                        System.out.println("Blood Type: "+d2.type);
                    }
                }
            }
            
            
            ois.close();
        }
        catch(Exception e)
        {
            System.out.println("Exception caught");
            System.out.println(e);
        }
        in.close();

    }
    

    
}