package Retry;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryTest {
    @Test(retryAnalyzer = Retry.class)
    public void test2()
    {
        Assert.assertEquals(false,true);
    }
}
