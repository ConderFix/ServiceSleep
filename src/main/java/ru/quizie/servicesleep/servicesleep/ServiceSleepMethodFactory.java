package ru.quizie.servicesleep.servicesleep;

import ru.quizie.servicesleep.servicesleep.impls.Layer7Method;
import ru.quizie.servicesleep.servicesleep.impls.UDPMethod;

public class ServiceSleepMethodFactory {
    public static ServiceSleepMethod getMethodServiceSleep(String typeServiceSleep) {
        return switch (typeServiceSleep.toUpperCase()) {
            case "L7" -> new Layer7Method();
            case "UDP" -> new UDPMethod();
            default -> throw new IllegalStateException("Unknown method service sleep: " + typeServiceSleep.toUpperCase());
        };
    }
}
