import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;

public class ConsumerTest1 {
    private static <T, U> BiConsumer<T, U> combine(List<BiConsumer<T, U>> consumers) {
        return consumers.stream().reduce((arg1, arg2) -> {}, BiConsumer::andThen);
    }

    List<String> generate(String input) {
        ArrayList<String> output = new ArrayList<>();
        combine(getGenerators()).accept(input, output);
        return output;
    }

    private List<BiConsumer<String, List<String>>> getGenerators() {
        return Arrays.asList(
                this::addFirstDependent,
                this::addSecondIndependent
        );
    }

    private void addFirstDependent(String input, List<String> output) {
        if (input.contains("some string")) {
            output.add("First-Dependent");
        }
    }

    private void addSecondIndependent(String input, List<String> output) {
        output.add("Predefined Output");
    }
}
