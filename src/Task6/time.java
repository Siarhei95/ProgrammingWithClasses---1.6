//Составьте  описание класса для представления времени. Предусмотрте  возможности установки времени и
//изменения его отдельных полей (час, минута, секунда) с проверкой допустимости вводимых значений. В случае
//недопустимых значений полей  поле устанавливается в значение 0. Создать методы изменения времени на
//заданное количество часов, минут и секунд.


package Task6;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
import static java.lang.Integer.parseInt;
import java.util.Calendar;

public class time {
    int Hour;
    int Minute;
    int Second;

    public void SetHour(int hour) {
        Hour = hour;
    }

    public void SetMinute(int minute) {
        Minute = minute;
    }

    public void SetSecond(int second) {
        Second = second;
    }

    public void SetTime(int hour, int minute, int second) {
        SetHour(hour);
        SetMinute(minute);
        SetSecond(second);
    }

    public String ShowTime() {
        return "My time: " + Hour + ":" + Minute + ":" + Second;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String date = sdf.format(calendar.getTime());

        System.out.println("Determine the time!");
        time myTime = new time();
        System.out.println();
        System.out.println("1. Print current time");
        System.out.println("2. Time input and output (optional)");
        System.out.println("0. Exit");
        System.out.print("Choose an option: ");
        int s = scanner.nextInt();
        while (s != 0) {
            if (s != 1 && s != 2 && s != 3 && s != 4) {
                System.out.println("Error");
                continue;
            }

            switch (s) {
                case 1:
                    String current_time_str = date;
                    System.out.println("Current time: " + current_time_str);
                    break;
                case 2:
                    System.out.println("Enter a new time in the format -> hh:mm:ss");
                    String newTime = scanner.next();
                    String[] newTimeArray = newTime.split(":"); // возможен null

                    int hour = parseInt(newTimeArray[0]);
                    int minute = parseInt(newTimeArray[1]);
                    int second = parseInt(newTimeArray[2]);

                    if (hour <= 24 & minute <= 59 & second <= 59) {
                        myTime.SetTime(hour, minute, second);
                        System.out.println("Contributed to the database");
                        System.out.println("Display (yes or no)?");
                        String answer = scanner.next();
                        if (answer.equals("yes")) {
                            System.out.println(myTime.ShowTime());
                        } else {
                            System.out.println("Next time");
                        }
                    } else
                        System.out.println("Such a time does not exist!");
            }
            break;
        }
    }
}