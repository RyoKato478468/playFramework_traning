package controllers;

import org.junit.Test;
import play.Application;
import play.inject.guice.GuiceApplicationBuilder;
import play.mvc.Http;
import play.mvc.Result;
import play.test.Helpers;
import play.test.WithApplication;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
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
        assertEquals(200,result.status());  //200OKを確認
        assertEquals("text/html", result.contentType().get());
        assertEquals("utf-8", result.charset().get());

        //デフォルトデータの確認
        String [] testData = {"1","firstUser","2","192","バナナ"};
        for(String str: testData) {
            assertTrue(contentAsString(result).contains(str));
            System.out.println("値を検出：" + str);
        }
    }

    @Test
    public void testInsert(){
        Http.RequestBuilder request = Helpers.fakeRequest().method(GET)
                .uri("/user/usrEdit?id=0&name=テストデータ&schoolYear=1&height=1&likeFood=テスト&isEdit=false");

        Result result = route(app,request);
        //余裕があれば、DBのデータテスト

        assertEquals(303,result.status());  //303を確認
    }

}
