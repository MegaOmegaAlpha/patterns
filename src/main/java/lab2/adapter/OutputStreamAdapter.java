package lab2.adapter;

import java.io.*;

public class OutputStreamAdapter {

    private File file;

    public OutputStreamAdapter(String fileName) {
        file = new File(fileName);
    }

    public void write(String... strings) {
        try (OutputStream outputStream = new FileOutputStream(file)) {
            outputStream.write(strings.length);
            for (String string : strings) {
                byte[] wordByte = string.getBytes();
                outputStream.write(wordByte.length);
                outputStream.write(wordByte);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String[] read() {
        try (InputStream inputStream = new FileInputStream(file)) {
            int wordsNumber = inputStream.read();
            String[] result = new String[wordsNumber];
            for (int i = 0; i < result.length; i++) {
                int wordLength = inputStream.read();
                byte[] word = new byte[wordLength];
                inputStream.read(word);
                result[i] = new String(word);
            }
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
