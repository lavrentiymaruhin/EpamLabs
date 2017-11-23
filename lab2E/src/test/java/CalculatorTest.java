import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorTest {
    public static Calculator calculator;

    @BeforeClass
    public void init(){
        calculator = new Calculator();
    }

    @DataProvider(name = "TestSub")
    public static Object[][] testSub(){
        return new Object[][]{
                {-9.0,'-',11.0,-20.0},
                {-21.0,'-',-1.0,-20.0},
                {5.0,'-',0.0,5.0},
                {13.0,'-',14.0,-1.0},
                {Double.MAX_VALUE,'-',3.0,Double.MAX_VALUE}
        };
    }

    @Test(dataProvider = "TestSub")
    public void subTest(double first,char sign, double last, double expected){
        double current = calculator.operation(first,sign,last);
        Assert.assertEquals(current,expected);
    }

    @DataProvider(name = "TestSum")
    public static Object[][] testSum(){
        return new Object[][]{
                {2.0,'+',6.0,8.0},
                {-2.0,'+',9.0,7.0},
                {-2.0,'+',-3.0,-5.0},
                {4.0,'+',0.0,4.0},
                {Double.MAX_VALUE,'+',4.0,Double.MAX_VALUE}
        };
    }

    @Test(dataProvider = "TestSum")
    public void sumTest(double first,char sign, double last, double expected){
        double current = calculator.operation(first,sign,last);
        Assert.assertEquals(current,expected);
    }

    @DataProvider(name = "TestMult")
    public static Object[][] testMult(){
        return new Object[][]{
                {7.0,'*',6.0,42.0},
                {-8.0,'*',3.0,-24.0},
                {-21.0,'*',-4.0,84.0},
                {15.0,'*',0.0,0.0},
                {Double.MAX_VALUE,'*',13.0,Double.POSITIVE_INFINITY},
        };
    }

    @Test(dataProvider = "TestMult")
    public void multTest(double first,char sign, double last, double expected){
        double current = calculator.operation(first,sign,last);
        Assert.assertEquals(current,expected);
    }

    @DataProvider(name = "TestDiv")
    public static Object[][] testDiv(){
        return new Object[][]{
                {8.0,'/',2.0,4.0},
                {-4.0,'/',2.0,-2.0},
                {-16.0,'/',-4.0,4.0},
                {12.0,'/',0.0, Double.POSITIVE_INFINITY},
                {Double.MAX_VALUE,'/',6.0 ,Double.MAX_VALUE/6.0}
        };
    }

    @Test(dataProvider = "TestDiv")
    public void divTest(double first,char sign, double last, double expected){
        double current = calculator.operation(first,sign,last);
        Assert.assertEquals(current,expected);
    }
}