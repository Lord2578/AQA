package task8;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import task2.Task2;

public class Task8Test {
    Task2 task2;

    @BeforeMethod
    void setUp() {
        task2 = new Task2();
    }

    @DataProvider(name = "sumDataProvider")
    public Object[][] sumDataProvider() {
        return new Object[][] {
                {10, 5, 15},
                {20, 30, 50},
                {-10, -5, -15},
                {0, 0, 0}
        };
    }

    @Test(dataProvider = "sumDataProvider")
    public void sumTest(int num1, int num2, int expectedResult) {
        task2.sum(num1, num2);
        int actualSum = task2.sum;
        Assert.assertEquals(actualSum, expectedResult, "Unexpected result for sum");
    }

    @DataProvider(name = "subDataProvider")
    public Object[][] subDataProvider() {
        return new Object[][] {
                {10, 5, 5},
                {20, 30, -10},
                {-10, -5, -5},
                {0, 0, 0}
        };
    }

    @Test(dataProvider = "subDataProvider")
    public void subTest(int num1, int num2, int expectedResult) {
        task2.subs(num1, num2);
        int actualSubs = num1 - num2;
        Assert.assertEquals(actualSubs, expectedResult, "Unexpected result for subs");
    }

    @DataProvider(name = "multiDataProvider")
    public Object[][] multiDataProvider() {
        return new Object[][] {
                {10, 5, 50},
                {20, 30, 600},
                {-10, 5, -50},
                {0, 10, 0}
        };
    }

    @Test(dataProvider = "multiDataProvider")
    public void multiTest(int num1, int num2, int expectedResult) {
        task2.multi(num1, num2);
        int actualMulti = num1 * num2;
        Assert.assertEquals(actualMulti, expectedResult, "Unexpected result for multi");
    }

    @Test
    @Parameters({"num1", "num2", "expectedSum"})
    public void parameterizedSumTest(int num1, int num2, int expectedSum) {
        task2.sum(num1, num2);
        int actualSum = task2.sum;
        Assert.assertEquals(actualSum, expectedSum, "Unexpected result for parameterized sum");
    }
}
