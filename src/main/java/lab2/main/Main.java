package lab2.main;

import lab2.adapter.OutputStreamAdapter;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        OutputStreamAdapter adapter = new OutputStreamAdapter("file.txt");
        adapter.write("weg", "Q3t23", "vfdn");

        Arrays.stream(adapter.read()).forEach(System.out::println);
    }

}
