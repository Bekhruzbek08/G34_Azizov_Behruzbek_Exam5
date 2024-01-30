package org.example;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main{

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException, InterruptedException {

        // User Registration
        System.out.println("User Registration");
        System.out.println("Enter your name: ");
        String name = scanner.nextLine();

        System.out.println("Enter your surname: ");
        String surname = scanner.nextLine();

        System.out.println("Enter your email: ");
        String email = scanner.nextLine();

        // Email Verification
        String verificationCode = generateVerificationCode();
        System.out.println("Verification code sent to your email. Enter the code to complete registration: ");
        String enteredCode = scanner.nextLine();

        while (!enteredCode.equals(verificationCode)) {
            System.out.println("Incorrect code. Please enter the correct verification code: ");
            enteredCode = scanner.nextLine();
        }

        System.out.println("Successfully registered!");

        // Fetching information from DateApi
        System.out.println("Enter the month ");
        Integer month = scanner.nextInt();

        System.out.println("Enter the day ");
        Integer day = scanner.nextInt();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://numbersapi.p.rapidapi.com/%s/%s/date?fragment=true&json=true".formatted(month, day)))
                .header("X-RapidAPI-Key", "af9116a428msh4b750dd4631aa07p138e80jsna48c4dd95f88")
                .header("X-RapidAPI-Host", "numbersapi.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();

        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        // Displaying DateApi information
        System.out.println(response.body());
        Gson gson = new Gson();
        Api apiData = gson.fromJson(response.body(), Api.class);
        System.out.println("DateApi Information: " + apiData);
    }

    private static String generateVerificationCode() {

        return "1234";
    }
}
