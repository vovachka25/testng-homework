public class Factory {

    @org.testng.annotations.Factory
    public Object[] factoryMethod(){
        return  new Object[] {
                new FactoryTest("Vova","Buligini", "Male", "598471552"),
                new FactoryTest("Giorgi","Buligini", "Other", "598522452"),
                new FactoryTest("Nikoloz","Buligini", "Male", "59622455"),
        };


    }
}
