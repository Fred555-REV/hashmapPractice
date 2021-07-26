package challenges.practice;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        int[] arr = {2, 2, 1, 1, 1, 2, 2};
        int[] nums = {5, 5, 5, 2, 2, 2, 5, 5, 5};
        int[] numArr = {3, 2, 3};
        System.out.println(majorityElement(arr));
        System.out.println(majorityElement(nums));
        System.out.println(majorityElement(numArr));

        Scanner in = new Scanner(System.in);
        System.out.println("Enter amount of names to put in phone book.");
        int n = in.nextInt();
//        in.nextLine();
        Map<String, Integer> phoneBook = new HashMap<String, Integer>();
        for (int i = 0; i < n; i++) {
            System.out.println("Enter name");
            String name = in.next();
            System.out.println("Enter phone number");
            int phone = in.nextInt();
            phoneBook.put(name, phone);
        }
        System.out.println("Enter names to check in phone book. Enter EXIT to exit");
        while (in.hasNext()) {
            String s = in.next();
            // Write code here
//            System.out.println();
            if (s.equals("EXIT")) {
                break;
            }
            if (phoneBook.get(s) != null) {
                System.out.println(s + "'s phone number is " + phoneBook.get(s));
            } else {
                System.out.println("Not found");
            }
        }
        in.close();
    }

    public static int majorityElement(int[] arr) {
        HashMap<Integer, Integer> numFreq = new HashMap();
        int majority = 0;
        for (int num : arr) {
            if (numFreq.containsKey(num)) {
                int count = numFreq.get(num);
                count++;
                numFreq.put(num, count);
            } else {
                numFreq.put(num, 1);
            }
            if (numFreq.get(num) > (arr.length / 2)) {
                majority = num;
            }
        }
        return majority;
    }
}
