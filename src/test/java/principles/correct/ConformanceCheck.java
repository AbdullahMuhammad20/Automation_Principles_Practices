package principles.correct;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ConformanceCheck
{

    // Conformance testing on names
    @DataProvider
    Object[][] nameProvider()
    {
        return new Object[][]
                {
                        {"John Smith"},
                        {"Jose de la Torres"},
                        {"Chris O'Reilly"}
                };
    }
    @Test(dataProvider = "nameProvider")
    public void verifyX(String s)
    {
        // Here you need to pass all names come from provider to the function that will handle it
        //parseName(s);
    }
}
