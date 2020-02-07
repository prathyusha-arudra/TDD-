public class ArmstrongNumber{

    private static FileInput fi=new FileInput();

    ArmstrongNumber() throws Exception{};

    public void setReadObject(FileInput file){
        fi=file;
    }


    public static boolean checkArmstrongNumber() throws Exception{
        int number = fi.FileInput("test.txt");
        System.out.println(number);
        int num= number;
        int temp, total = 0;
        while (number != 0) {
            temp = number % 10;
            total = total + (temp * temp * temp);
            System.out.println(total);
            number /= 10;
        }
        System.out.println(total==num);
        return total==num;
    }
}
