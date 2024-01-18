import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Lowercase {
    public static String lowerCase(String str) {
        return str == null ? null : str.toLowerCase();
    }

    public static class LowerCaseTest {

        @Test
        public void testLowerCase() {
            // 测试空字符串
            String input1 = "";
            String expectedOutput1 = "";
            String result1 = Lowercase.lowerCase(input1);
            assertEquals(expectedOutput1, result1);

            // 测试小写字符串
            String input2 = "software testing";
            String expectedOutput2 = "software testing";
            String result2 = Lowercase.lowerCase(input2);
            assertEquals(expectedOutput2, result2);

            // 测试大写字符串
            String input3 = "SOFTWARE TESTING";
            String expectedOutput3 = "software testing";
            String result3 = Lowercase.lowerCase(input3);
            assertEquals(expectedOutput3, result3);

            // 测试非字母字符串
            String input4 = "*?<>";
            String expectedOutput4 = "*?<>";
            String result4 = Lowercase.lowerCase(input4);
            assertEquals(expectedOutput4, result4);
        }
    }
}
