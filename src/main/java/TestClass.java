public class TestClass {

    @BeforeSuit
    public void beforeSuit() {
        System.out.println("Before suit method");
    }

    @AfterSuit
    public void afterSuit(){
        System.out.println("After suit method");
    }

    @Test(priority = 8)
    public void testOne(){
        System.out.println("Test 1 with priority 8");
    }

    @Test(priority = 6)
    public void testTwo(){
        System.out.println("Test 2 with priority 6");
    }

    @Test
    public void testThree(){
        System.out.println("Test 3 with default priority");
    }

    @Test(priority = 5)
    public void testFour(){
        System.out.println("Test 4 with priority 5");
    }

    @Test(priority = 2)
    public void testFive(){
        System.out.println("Test 5 with priority 2");
    }

    //Для проверки на RuntimeException
//    @BeforeSuit
//    public void before1Suit() {
//        System.out.println("Before suit method");
//    }

//    @AfterSuit
//    public void after1Suit(){
//        System.out.println("After suit method");
//    }


}
