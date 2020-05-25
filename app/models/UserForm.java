package models;

import javax.inject.Inject;

import io.ebean.*;
import tables.T_User;

import java.util.List;

public class UserForm {

    @Inject
    public static Finder<Long, T_User> finder = new Finder<Long, T_User>(T_User.class);

    public static List<T_User> search(String searchWord) {
        if (searchWord != null) {
            return finder.query().where().ilike("name", "%" + searchWord + "%").findList();
        } else {
            return finder.all();
        }
    }
}