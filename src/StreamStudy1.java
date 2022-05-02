import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamStudy1 {

    public static void main(String[] args) {

        List<Product> productList =
                Arrays.asList(new Product(23, "potatoes"),
                        new Product(14, "orange"),
                        new Product(13, "lemon"),
                        new Product(23, "bread"),
                        new Product(13, "sugar"));

        List<String> collect = productList.stream().map(Product::getNameToUpperCase).collect(Collectors.toList());

        System.out.println(collect);

    }
}
