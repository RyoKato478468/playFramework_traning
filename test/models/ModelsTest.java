package models;

import org.junit.Test;
import play.Application;
import play.inject.guice.GuiceApplicationBuilder;
import play.test.WithApplication;
import tables.T_User;
import tables.find.SubmitData;
import tables.find.Where;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class ModelsTest extends WithApplication {

    @Override
    protected Application provideApplication() {
        return new GuiceApplicationBuilder().build();
    }

    static UserForm userForm = new UserForm();

    @Test
    public void testSearchId() {
        assertEquals(1, (long)searchList().get(0).id);
        outputStatus("id");
    }

    @Test
    public void testSearchName() {
        assertEquals("firstUser", searchList().get(0).name);
        outputStatus("name");
    }

    @Test
    public void testSearchSchoolYear() {
        assertEquals("2年生", searchList().get(0).schoolYear);
        outputStatus("schoolYear");
    }

    @Test
    public void testSearchHeight() {
        assertEquals("192cm", searchList().get(0).height);
        outputStatus("height");
    }

    @Test
    public void testSearchLikeFood() {
        assertEquals("バナナ", searchList().get(0).likeFood);
        outputStatus("likeFood");
    }

    @Test
    public void testSearchCreatedAt() {
        assertEquals("2020/05/25 14:35:00", searchList().get(0).createdAt);
        outputStatus("createdAt");
    }

    @Test
    public void testSearchUpdatedAt() {
        assertEquals("2020/05/25 14:35:00", searchList().get(0).updatedAt);
        outputStatus("updatedAt");
    }

    @Test
    public void testInsert(){
        SubmitData sub1 = new SubmitData();
        String name = "新規登録テストさん";

        sub1.id = 61;
        sub1.name = name;
        sub1.schoolYear = 30;
        sub1.height = 3000;
        sub1.likeFood = "飯";
        sub1.birthDay = new Date();
        sub1.createdAt = new Date();
        sub1.updatedAt = new Date();

        Where wh = new Where();
        wh.insertOrUpdate(sub1,false);

        List<UserItem> list = userForm.search(name);
        assertEquals(name,list.get(0).name);
    }

    @Test
    public void testUpdate(){
        SubmitData sub2 = new SubmitData();
        String name = "更新テストさん";

        sub2.id = 61;
        sub2.name = name;
        sub2.schoolYear = 30;
        sub2.height = 3000;
        sub2.likeFood = "飯";
        sub2.birthDay = new Date();
        sub2.updatedAt = new Date();

        Where wh = new Where();

        wh.insertOrUpdate(sub2,true);
        System.out.println(sub2.name);

        List<UserItem> list = userForm.search(name);
        assertEquals(name,list.get(0).name);
    }

    List<UserItem> searchList(){
        return userForm.search("firstUser");
    }

    private void outputStatus(String sub){
        System.out.println("------------------");
        System.out.println(sub + "を発見");
        System.out.println("------------------");
    }
}