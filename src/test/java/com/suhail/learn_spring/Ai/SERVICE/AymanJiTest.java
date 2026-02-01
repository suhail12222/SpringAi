package com.suhail.learn_spring.Ai.SERVICE;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class AymanJiTest {
    @Autowired
    private AymanJi aymanJi;
//@Test
//    public void getNames( ){
//    String promtp="islamic";
//    String result=aymanJi.getReligionNames(promtp);
//    System.out.println(result);
//}
@Test
    public void getDua(){
    String prompt="jinaza";
    String result=aymanJi.getDuaRelated(prompt);
    System.out.println(result);
}
}