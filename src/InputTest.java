import util.Input;

public class InputTest {
    public static void main(String[] args) {
        Input input = new Input();

//        int myInt = input.getInt(1,10);
//        System.out.println(myInt);

//        double myDouble = input.getDouble(1,100,"Yeller");
//        System.out.println(myDouble);

        String myString = input.getString();
        System.out.println(myString);
    }
}
