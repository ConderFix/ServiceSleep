package ru.quizie.servicesleep.servicesleep.impls;

import ru.quizie.servicesleep.servicesleep.ServiceSleepMethod;

public class UDPMethod implements ServiceSleepMethod {

    @Override
    public String name() {
        return "UDP";
    }

    @Override
    public String nameArg() {
        return "IP";
    }

    @Override
    public void actions(String parm1) {
        // TODO: UPD method
    }
}
