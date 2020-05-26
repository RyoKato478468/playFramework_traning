package controllers;

import org.junit.Test;
import play.Application;
import play.inject.guice.GuiceApplicationBuilder;
import play.mvc.Http;
import play.mvc.Result;
import play.test.Helpers;
import play.test.WithApplication;

import static org.junit.Assert.*;
import static play.test.Helpers.*;

public class ControllerTest extends WithApplication {
    
    @Override
    protected Application provideApplication() {
        return new GuiceApplicationBuilder().build();
    }

    @Test
    public void testIndex() {
        Http.RequestBuilder request = Helpers.fakeRequest(routes.Application.index());

        Result result = route(app,request);
        checkResult(result);

        //デフォルトデータの確認
        String [] testData = {"1","firstUser","2","192","バナナ","1999/05/25 14:35:00"};
        for(String str: testData) {
            assertTrue(contentAsString(result).contains(str));
            System.out.println("値を検出：" + str);
        }
        outputStatus(result.status(),"一覧表示");
    }

    @Test
    public void testSearch() {
        Http.RequestBuilder request = Helpers.fakeRequest(routes.Application.search("firstUser"));

        Result result = route(app,request);
        checkResult(result);

        //firstは表示ok、secondは表示されてはいけない
        assertTrue(contentAsString(result).contains("firstUser"));
        assertFalse(contentAsString(result).contains("secondUser"));
        outputStatus(result.status(),"検索");

    }

    void checkResult(Result result){
        assertEquals(200,result.status());  //200OKを確認
        assertEquals("text/html", result.contentType().get());
        assertEquals("utf-8", result.charset().get());
    }

    @Test
    public void testInsert(){
        checkRequest("/user/usrEdit?id=5&name=a&schoolYear=2&height=2&likeFood=aaa&birthDay=1999-05-25+14%3A35%3A00&isEdit=false","新規登録");
    }

    @Test
    public void testUpdate(){
        checkRequest("/user/usrEdit?id=2&name=update&schoolYear=3&height=300&likeFood=%E6%9B%B4%E6%96%B0&birthDay=1999-05-25+14%3A35%3A00&isEdit=true","更新");
    }
    @Test
    public void testDelete() {
        checkRequest("/user/delete?id=2","削除");
    }

    void checkRequest(String url,String processMsg){
        Http.RequestBuilder request = Helpers.fakeRequest().method(GET)
                .uri(url);

        Result result = route(app,request);
        assertEquals(303,result.status());  //303を確認
        outputStatus(result.status(),processMsg);
    }

    private void outputStatus(int resultStatus,String processMsg) {

        System.out.println("\n----------------------------------");
        System.out.println("HTTPステータス：" + resultStatus);
        System.out.println(processMsg + "操作：OK");
        System.out.println("----------------------------------\n");
    }

}
