package org.example.oop.Task;

public class TimeIntervalRunner {

    public static void main(String[] args) {
        TimeInterval timeInterval = new TimeInterval(30, 2, 1);
        System.out.println(timeInterval.totalSeconds());

        TimeInterval timeInterval2 = new TimeInterval(timeInterval.totalSeconds());
        System.out.println(timeInterval2.totalSeconds());
        timeInterval2.print();

        TimeInterval sumIntervals = timeInterval.sum(timeInterval2);
        sumIntervals.print();
    }
}
