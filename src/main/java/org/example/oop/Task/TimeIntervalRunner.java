package org.example.oop.Task;

public class TimeIntervalRunner {

    public static void main(String[] args) {
        int a = 2;
        int b = 1;
        int c = a + b;

        TimeInterval timeInterval = new TimeInterval(30, 2, 1);
        System.out.println(timeInterval.totalSeconds());

//        TimeInterval timeInterval = createTimeInterval();

        TimeInterval timeInterval2 = new TimeInterval(timeInterval.totalSeconds());
        System.out.println(timeInterval2.totalSeconds());
        timeInterval2.print();

        TimeInterval sumIntervals = timeInterval.sum(timeInterval2);
        sumIntervals.print();

        TimeInterval plus = new TimeInterval(30, 2, 1);
        System.out.println(plus.plus(3, 2));

    }

//    private static TimeInterval createTimeInterval() {
//        TimeInterval timeInterval = new TimeInterval(30, 2, 1);
//        System.out.println(timeInterval.totalSeconds());
//        return timeInterval;
//    }
}
