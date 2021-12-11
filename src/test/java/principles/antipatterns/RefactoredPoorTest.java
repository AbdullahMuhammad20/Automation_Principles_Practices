package principles.antipatterns;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RefactoredPoorTest
{
    @DataProvider
    public static Object[][] invalidFromToInput()
    {
        return new Object[][]
                {
                        // invalid from
                        {null,""},
                        {"","Alex"},
                        {" ","Alex"},

                        // invalid to
                        {"Alex",null},
                        {"Alex",""},
                        {"Alex"," "},
                };
    }

    @Test(dataProvider = "invalidFromToInput")
    void searchRejectsInvalidDestination(String from, String to)
    {
      //  Assert.assertThrows(IllegalAccessException.class,() -> searchService.search(from,to,"15-10-2020",10) );
    }

    @DataProvider
    public static Object[][] invalidDateInput()
    {
        return new Object[][]
                {
                        {"15/10-2020"},
                        {"15-10/2020"},
                        {"15102020"},
                        {"15-1-2020"},
                        {"15-1-20"}
                };
    }

    @Test(dataProvider = "invalidDateInput")
    void searchRejectsInvalidDateFormat(String date)
    {
        //Assert.assertThrows(IllegalAccessException.class,() -> searchService.search("Cairo","Alex",date,10) );
    }

    @DataProvider
    public static Object[][] emptyStringInput()
    {
        return new Object[][]
                {
                        {""},
                        {" "}
                };
    }

    @Test(dataProvider = "emptyStringInput")
    void searchRejectsEmptyDate(String date)
    {
       // Assert.assertThrows(IllegalAccessException.class,()-> searchService.search("Cairo","Alex",date,10));
    }

    @DataProvider
    public static Object[][] invalidPassengerNum()
    {
        return new Object[][]
                {
                        {0},{8}
                };
    }

    @Test(dataProvider = "invalidPassengerNum")
    void searchRejectsPassengerNumOutOfRange(int passengerNum)
    {
        // Assert.assertThrows(IllegalAccessException.class,()-> searchService.search("Cairo","Alex","10-10-2020",passengerNum));
    }

}
