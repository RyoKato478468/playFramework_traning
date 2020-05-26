package tables.find;

import java.util.*;

import io.ebean.DB;
import io.ebean.Finder;
import tables.*;

public class Where {

    public static Finder<Long, T_User> finder = new Finder<Long, T_User>(T_User.class);

    public static List<T_User> find(String str) {
        if (str != null) {
            return finder.query().where().ilike("name", "%" + str + "%").findList();
        } else {
            return finder.all();
        }
    }

    T_User userInfo = new T_User();

    public static List<T_User> search(String searchWord){
        List<T_User> list = DB.find(T_User.class).where().eq("name",searchWord).findList();

        return list;
    }

    public void insertOrUpdate(SubmitData list,boolean isEdit) {

        this.userInfo.id = list.id;
        this.userInfo.name = list.name;
        this.userInfo.schoolYear = list.schoolYear;
        this.userInfo.height = list.height;
        this.userInfo.likeFood = list.likeFood;
        this.userInfo.birthDay = list.birthDay;
        this.userInfo.updatedAt = new Date();

        if (isEdit) {
            userInfo.update();
        } else {
            this.userInfo.createdAt = new Date();
            userInfo.save();
        }
    }

    public void delete(int id){

        this.userInfo.id = id;
        userInfo.delete();
    }
}
