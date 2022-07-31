package deeplearning.jpa.junit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

public class AssumeExamples {

    @Test
    public void testAssumeTrue() {
        boolean a =true;
        assumeTrue(a);
        System.out.println("Assumed true");
    }

    @Test
    public void testAssumeTrueFail() {
        boolean a =false;
        assumeTrue(a);
        System.out.println("Assumed true fail");
    }

    @Test
    public void testAssumingThat() {
        assumingThat(true,
                () -> {
                    assumeTrue(true);
                    System.out.println("Assuming that");
                });
    }
}
