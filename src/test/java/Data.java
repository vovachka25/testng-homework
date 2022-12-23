import org.testng.annotations.DataProvider;

public class Data {

    @DataProvider(name = "inputs")
    public static Object[][] getDataFromDataProvider(){
        return new Object[][]{
                new Object[]{
                        "Vova","Buligini", "Male", "598471552"
                },
                new Object[]{
                        "Giorgi","Buligini", "Other", "598522452"
                },
                new Object[]{
                        "Nikoloz","Buligini", "Male", "59622455"
                }
        };

    }
}
