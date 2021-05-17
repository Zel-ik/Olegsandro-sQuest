package Quest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.*;
import java.util.concurrent.Callable;

public class ConsoleInputAnswer implements Callable<String>{

    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public String call() throws IOException{
        String input;
        do {
            try {
                while (!bufferedReader.ready()) {
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return null;
                    }
                }
                input = bufferedReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }while("".equals(input));
        return input;
    }
}