import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void httpRequest() throws ExceptionFun {
        throw new ExceptionFun("ERROR",ExceptionFun.HTTPCODE.NOTFOUND);
    }

    public static String readFromFile(File file) {
        StringBuilder sb = new StringBuilder();
        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            bufferedReader.lines().forEach((l) -> {sb.append(l);sb.append('\n');});
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        try {
            httpRequest();
        } catch (ExceptionFun ex) {
            System.out.println(ex.getMessage());
        }
        assert 1 == 0 : "WRONG";
    }
}
