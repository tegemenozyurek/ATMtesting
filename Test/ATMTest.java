import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;


import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class ATMTest {

    static ATM atm;
    static Random random;
    @BeforeAll
    static void setUp(){
        atm = new ATM();
        random = new Random();
    }
    @org.junit.jupiter.api.Test
    void deposit() {
        int depositTestValue = atm.deposit(200);
        assertEquals(1200, depositTestValue);
    }
    @RepeatedTest(10)
    @DisplayName("10 times repeated withdraw test")
    void withdraw() {
        int randomNumber = random.nextInt(200) + 1; //Random integer between 1 and 200
        assertEquals(atm.balance - randomNumber, atm.withdraw(randomNumber));
    }

    @ParameterizedTest
    @DisplayName("Balance / x")
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void isDividerOfBalance(int value){
        assertTrue(atm.isDividerOfBalance(value));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void isDividerOfBalance2(int value){
        assertEquals(true, atm.isDividerOfBalance(value));
    }

    @ParameterizedTest
    @CsvSource({ "lebron, 1234", "jordan, 2323", "kobe, 2408", "harden, 1313" })
    void loginCheck(String username, int password) {
        assertTrue(atm.loginCheck(username, password));//Testi sadece kobe geçecek bu doğru bir test uygulaması mı
    }


}