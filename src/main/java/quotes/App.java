package quotes;


import com.google.gson.Gson;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class App {

    public static void main(String[] args) {

        Gson gson = new Gson();
        System.out.println(getRandomQuote());;
    }

    public static String getRandomQuote() {
        Gson gson = new Gson();
        int randomNumber = (int)(Math.random()*(138 + 1 ));
        String result = "";
        String jsonPath = "src/main/resources/recentquotes.json";

        try {
            Scanner scanner = new Scanner(new File(jsonPath));
            String firstLine ="";

            while(scanner.hasNext()) {
                firstLine += scanner.nextLine();
            }
            Quote[] quoteArray = gson.fromJson(firstLine, Quote[].class);

            result = String.format("Here is a quote for you: %s by %s.", quoteArray[randomNumber].text, quoteArray[randomNumber].author);
//            System.out.println("Quotes: " + quoteArray[randomNumber].text);
//            System.out.println("Author: " + quoteArray[randomNumber].author);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return result;
        }

    }
