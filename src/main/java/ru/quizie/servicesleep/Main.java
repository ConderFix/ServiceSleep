package ru.quizie.servicesleep;

import ru.quizie.servicesleep.servicesleep.ServiceSleepMethod;
import ru.quizie.servicesleep.servicesleep.ServiceSleepMethodFactory;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        System.out.println("Выбери тип:");
        System.out.println("Типы: L7 || UDP");
        System.out.print("> ");

        final String result = sc.nextLine().trim().toUpperCase();
        final ServiceSleepMethod serviceSleepMethod = ServiceSleepMethodFactory.getMethodServiceSleep(result);

        System.out.println("Аргумент: (" + serviceSleepMethod.nameArg() + ")");
        System.out.print("> ");
        final String parm1 = sc.nextLine().trim();

        System.out.println();
        System.out.println("Выбран тип: " + serviceSleepMethod.name());
        System.out.println("Аргумент ("+ serviceSleepMethod.nameArg() + "): " + parm1);
        System.out.println();
        System.out.println("🚀 Запуск...");
        System.out.println();

        serviceSleepMethod.actions(parm1);
    }

}