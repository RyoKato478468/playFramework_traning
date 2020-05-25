package controllers;

import org.junit.Test;
import play.Application;
import play.inject.guice.GuiceApplicationBuilder;
import play.mvc.Http;
import play.mvc.Result;
import play.test.Helpers;
import play.test.WithApplication;
import tables.T_User;

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
        String [] testData = {"1","firstUser","2","192","バナナ"};
        for(String str: testData) {
            assertTrue(contentAsString(result).contains(str));
            System.out.println("値を検出：" + str);
        }
    }

    @Test
    public void testSearch() {
        Http.RequestBuilder request = Helpers.fakeRequest(routes.Application.search("firstUser"));

        Result result = route(app,request);
        checkResult(result);

        //firstは表示ok、secondは表示されてはいけない
        assertTrue(contentAsString(result).contains("firstUser"));
        assertFalse(contentAsString(result).contains("secondUser"));
    }

    void checkResult(Result result){
        assertEquals(200,result.status());  //200OKを確認
        assertEquals("text/html", result.contentType().get());
        assertEquals("utf-8", result.charset().get());
    }

    @Test
    public void testInsert(){
        Http.RequestBuilder request = Helpers.fakeRequest().method(GET)
                .uri("/user/usrEdit?id=0&name=テストデータ&schoolYear=1&height=1&likeFood=テスト&isEdit=false");

        Result result = route(app,request);
        assertEquals(303,result.status());  //303を確認
    }

    @Test
    public void testUpdate(){
        Http.RequestBuilder request = Helpers.fakeRequest().method(GET)
                .uri("/user/usrEdit?id=1&name=テストデータ&schoolYear=1&height=1&likeFood=テスト&isEdit=false");

        Result result = route(app,request);
        assertEquals(303,result.status());  //303を確認
    }

    @Test
    public void testDelete() {
        Http.RequestBuilder request = Helpers.fakeRequest().method(GET)
                .uri("/user/delete?id=1");

        Result result = route(app,request);
        assertEquals(303,result.status());  //303を確認
    }
}
