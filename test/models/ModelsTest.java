package models;

import org.h2.engine.User;
import org.junit.Test;
import play.Application;
import play.inject.guice.GuiceApplicationBuilder;
import play.mvc.Http;
import play.mvc.Result;
import play.test.Helpers;
import play.test.WithApplication;
import tables.T_User;
import tables.find.SubmitData;
import tables.find.Where;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static play.test.Helpers.*;

public class ModelsTest {

    /*
    public void testNewUser(){
        SubmitData submitData = new SubmitData();

        Where wh = new Where();
        wh.insertOrUpdate(submitData,false);

        assertEquals();
    }*/

    @Test
    public void testName(){
        SubmitData submitData = new SubmitData();
        submitData.id = 1;
    }

    @Test
    public void searchTest(){
        //List<T_User> list = models.UserForm.search("firstUser");

        UserForm uf = new UserForm();
        List<UserItem> t_user = uf.search("firstUser");
        System.out.println("---------------------------------");
        System.out.println(t_user);
    }
}
