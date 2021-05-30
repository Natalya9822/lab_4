package lab;

import java.util.function.BiFunction;

/**
 * todo Document type MyLambdaDemo
 */
public class MyLambdaDemo {

    private BiFunction<String, String, Boolean> checkIfStringContainsGivenWord = String::contains;
    // or:
    // private BiFunction<String, String, Boolean> checkIfStringContainsGivenWord = (str, word) -> str.contains(word);

    private MyExecutable checkIfStringContainsMoreThanThreeWords = str -> str.split(" ").length > 3;

    public MyExecutable provideCheckIfStringContainsMoreThanProvidedNumberOfWords(int n) {
        return str -> str.split(" ").length > n;
    }
}
