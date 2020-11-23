package tests;

import org.junit.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

/* Если честно, я практически ничего не понял, делал по шаблону:
 https://fooobar.com/questions/631099/difference-between-before-beforeclass-beforeeach-and-beforeall
 Но вроде скомпилировалось, хотя совсем не понял что к чему... Буду разбираться дальше :D */

public class BaseClass {
        public String initializeData(){
            return "Initialize";
        }

        public String processDate(){
            return "Process";
        }


    public class FirstTest {

        private BaseClass baseClass;

        @BeforeAll
        public void beforeClassFunction(){
            System.out.println("Before Class");
        }

        @BeforeEach
        public void beforeFunction(){
            baseClass=new BaseClass();
            System.out.println("Before Function");
        }

        @AfterEach
        public void afterFunction(){
            System.out.println("After Function");
        }

        @AfterAll
        public void afterClassFunction(){
            System.out.println("After Class");
        }

        @Test
        public void initializeTest(){
            Assert.assertEquals("Initailization check", "Initialize", baseClass.initializeData() );
        }

        @Test
        public void processTest(){
            Assert.assertEquals("Process check", "Process", baseClass.processDate() );
        }

    }

}