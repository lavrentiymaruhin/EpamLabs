package framework;

import org.testng.annotations.Test;

public abstract class BaseTest extends BaseEntity{

    public abstract void runTest() throws InterruptedException;

    @Test
    public void xTest() throws Throwable {
        Class<? extends BaseTest> currentClass = this.getClass();

        try {
            runTest();
        } catch (Throwable e) {

            throw e;
        }

    }

}
