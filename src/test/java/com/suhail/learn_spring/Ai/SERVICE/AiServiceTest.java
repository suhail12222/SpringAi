package com.suhail.learn_spring.Ai.SERVICE;

//import lombok.var;
//import lombok.experimental.var;
import org.junit.jupiter.api.Test;
import org.springframework.ai.document.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FilterOutputStream;
import java.util.List;

@SpringBootTest
//@RequiredArgsConstructor
class AiServiceTest {
@Autowired
    private   AiService aiService;

//    AiServiceTest(AiService aiService) {
//        this.aiService = aiService;
//    }

//    @Test
//    public void embeddedText(){
//
//float[]embed=aiService.getEmbedding("this is a big text here");
//        System.out.println(embed.length);
//for (float e:embed){
//    System.out.println(e+" ");
//}
//    }

//    @Test
//    public void testStoreData(){
//        aiService.ingestDataToVectorStore("this is suhail");
//    }
    @Test
    public void testStoreData(){
        aiService.ingestDataVectorStore();
    }
//
//    @Test
//    public void getDummyJokess(){
//        String jokes=aiService.getDummyJoke("dogs");
//        System.out.println(jokes);
//    }

//    AiServiceTest(AiService aiService) {
//        this.aiService = aiService;
//    }
//
//@Test
//    public void getJokess(){
//        String jokes=aiService.getDummyJoke("programmers");
//    System.out.println(jokes);
//}
//
//
//    @Test
//    void getInfo() {
//        String topic=aiService.getInfo("oil");
//        System.out.println(topic);
//    }
//    @Test
//    void getInfo1(){
//        String topic=aiService.getInfo("MotherFucker");
//        System.out.println(topic);
//    }















@Test
    public void similarityTest(){
//      List<Document>
          var    docs=  aiService.similaritySearch("A team travels through a wormhole in space to save humanity");
  for (var res:docs) {


      System.out.println(res);
  }
}





}