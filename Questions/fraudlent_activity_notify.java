// Fraudlent Activity Transactions
// https://www.hackerrank.com/challenges/fraudulent-activity-notifications/problem

import java.util.*;

class Result {

    private static double getMedian(int[] count, int d) {
        int sum = 0;
        int median1 = -1, median2 = -1;

        for (int i = 0; i < count.length; i++) {
            sum += count[i];

            if (median1 == -1 && sum >= d / 2) {
                median1 = i;
            }
            if (median2 == -1 && sum >= (d / 2) + 1) {
                median2 = i;
                break;
            }
        }

        return (d % 2 == 0) ? (median1 + median2) / 2.0 : median2;
    }

    public static int activityNotifications(List<Integer> expenditure, int d) {
        int notifications = 0;
        int[] count = new int[201];

        for (int i = 0; i < d; i++) {
            count[expenditure.get(i)]++;
        }

        for (int i = d; i < expenditure.size(); i++) {
            double median = getMedian(count, d);

            if (expenditure.get(i) >= 2 * median) {
                notifications++;
            }

            count[expenditure.get(i - d)]--;
            count[expenditure.get(i)]++;
        }

        return notifications;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int d = scanner.nextInt();
        List<Integer> expenditure = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            expenditure.add(scanner.nextInt());
        }

        System.out.println(activityNotifications(expenditure, d));
    }
}















