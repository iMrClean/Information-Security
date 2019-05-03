package ru.bmstu.lab_4.bot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;
import java.util.stream.Collectors;

public class Main {

    private static final String URL = "http://localhost:8080";

    private static final String USERNAME = "user";

    private static final int PASSWORD_LENGTH = 4;

    public static void main(String[] args) throws IOException {
        PasswordGenerator generator = new PasswordGenerator.PasswordGeneratorBuilder()
                .useLower(true)
                .build();
        String password = generator.generate(PASSWORD_LENGTH);
        while (!connect(password)) {
            password = generator.generate(PASSWORD_LENGTH);
        }
    }

    private static boolean connect(String password) throws IOException {
        URL url = new URL(URL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        String authData = Main.USERNAME + ":" + password;
        String basicAuth = "Basic " + new String(Base64.getEncoder().encode(authData.getBytes()));
        connection.setRequestProperty("Authorization", basicAuth);

        try {
            System.out.println("User " + USERNAME + " password " + password);
            InputStream inputStream = connection.getInputStream();
            System.out.println("CurrUser " + USERNAME + " CurrPassword " + password);
            String result = new BufferedReader(new InputStreamReader(inputStream))
                    .lines().collect(Collectors.joining("\n"));
            System.out.println(result);
        } catch (IOException e) {
            return false;
        }
        return true;
    }
}
