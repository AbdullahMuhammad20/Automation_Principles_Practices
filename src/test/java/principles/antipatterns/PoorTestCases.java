package principles.antipatterns;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PoorTestCases
{

    public static Object invalidInput()
    {
        return new Object[][]
                {
                        // invalid from
                        {null, "Atlanta","15-10-2019", 1},
                        {"", "Atlanta","15-10-2019", 1},
                        {" ", "Atlanta","15-10-2019", 1},
                        // invalid to
                        {"Cairo", null,"15-10-2019", 1},
                        {"Cairo", "","15-10-2019", 1},
                        {"Cairo", " ","15-10-2019", 1},
                        {"", "Atlanta","15-10-2019", 1},
                        // invalid date
                        {"Alex", "Atlanta","", 1},
                        {"Alex", "Atlanta"," ", 1},
                        {"Alex", "Atlanta","15/10-2020", 1},
                        {"Alex", "Atlanta","15-10/2020", 1},
                        {"Alex", "Atlanta","15102020", 1},
                        {"Alex", "Atlanta","15-1-2020", 1},
                        {"Alex", "Atlanta","15-10-20", 1},
                        // invalid passenger num
                        {"Giza", "Atlanta","15-10-2019", 0},
                        {"Cairo", "Atlanta","15-10-2019", 8},
                };
    }

    @Test (dataProvider = "invalidInput")
    void searchFails (String from, String to, String date,int passengerNum)
    {
       //Assert.assertThrows(IllegalAccessException.class,() -> searchService.search(from, to,date,passengerNum));
    }

}
