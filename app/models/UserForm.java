package models;

import javax.inject.Inject;
import io.ebean.*;
import tables.T_User;

import java.util.List;
import java.util.stream.Collectors;

public class UserForm {

    @Inject
    public static Finder<Long, T_User> finder = new Finder<Long, T_User>(T_User.class);

    public static List<UserItem> search(String searchWord) {
        List<T_User> list;

        if (searchWord != null) {
            list = finder.query().where().ilike("name", "%" + searchWord + "%").findList();
        } else {
            list = finder.all();
        }
        return list.stream().map(UserItem::new).collect(Collectors.toList());
    }
}