import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

public class ConcatenationInLoops {
    public static void main(String[] args) {
        try {

            Random r = new Random(123);
            long start = System.currentTimeMillis();

            String s = "";
            for (int i = 0; i < 65536; i++) {
                s += r.nextInt(2);
            }
            System.out.println((System.currentTimeMillis() - start) + " ms");

            r = new Random(123);
            start = System.currentTimeMillis();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 65536; i++) {
                sb.append(r.nextInt(2));
            }
            s = sb.toString();
            System.out.println((System.currentTimeMillis() - start) + " ms");

            String filename = "test.exe";
            long startTime, endTime;

            byte[] inputBytes = Files.readAllBytes(Paths.get(filename));
            startTime = System.currentTimeMillis();

            StringBuilder outputBuilder = new StringBuilder();
            for (byte b : inputBytes) {
                outputBuilder.append((char) b);
            }
            String outputString = outputBuilder.toString();

            endTime = System.currentTimeMillis();
            System.out.println((endTime - startTime) + " ms");

        } catch (Exception e) {

            System.err.println(e.getMessage());
        }
    }
}
