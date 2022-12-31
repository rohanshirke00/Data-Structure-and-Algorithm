import java.util.Scanner;

public class FindEvenNumberOfDigits {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        System.out.print("Enter size of Array : ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.print("Enter " + n + " Elements in an array : ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Even Number of Digits are : " + findNumbers(arr));

    }

    public static int findNumbers(int[] nums) {
        int result = 0;
        for (int num : nums) {
            int digitsCnt = (int) Math.log10(num) + 1;
            if (digitsCnt % 2 == 0) {
                result++;
            }
        }
        return result;
    }
}
