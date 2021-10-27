package smith.tuka;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        // write your code here
        List<String> lines;
        try {
            lines = Files.readAllLines(Paths.get(Objects.requireNonNull(Main.class.getClassLoader().getResource("smith/tuka/links.json")).getPath()));
            lines.forEach(x -> {
                System.out.println(x);
                System.out.println();
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
