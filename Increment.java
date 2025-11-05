import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

public class Increment {
    public static void main(String[] args) throws IOException {
        List<List<Integer>> data = new ArrayList<>();
        List<String> ttttt = Files.readAllLines(Path.of("dd.txt"));

        for (String ln : ttttt) {
            String[] parts = ln.trim().split(" ");
            List<Integer> nums = new ArrayList<>();
            for (String u : parts) {
                nums.add(Integer.parseInt(u));
            }
            data.add(nums);
        }

        int result = incdec(data);
        System.out.println(result);
    }

    private static Integer incdec(List<List<Integer>> rr) {
        int tt = 0;

        for (List<Integer> r : rr) {
            boolean safe = true;
            boolean inc = r.get(1) > r.get(0);

            for (int i = 0; i < r.size() - 1; i++) {
                int act = r.get(i);
                int suv = r.get(i + 1);
                int diff = suv - act;

                if (diff == 0 || (inc && diff < 0) || (!inc && diff > 0) || Math.abs(diff) > 3) {
                    safe = false;
                    break;
                } else {
                    safe = true;
                }
            }

            if (safe) {
                tt += 1;
            }
        }

        return tt;
    }
}
