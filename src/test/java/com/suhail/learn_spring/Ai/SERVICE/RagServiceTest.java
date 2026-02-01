package com.suhail.learn_spring.Ai.SERVICE;

//import lombok.var;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RagServiceTest {

@Autowired
    private RagService ragService;
//@Test
//    public void testAskAi(){
////    var response=ragService.askAi("what are Prompt Engineering Patterns");
////    System.out.println(response);
//    ragService.ingestPdfVectorStore();
//}
@Test
    public void testAskAi1(){
    var response=ragService.askAi("what are Prompt Engineering Patterns?");
    System.out.println(response);
}
}
