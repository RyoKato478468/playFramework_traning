package models;

import play.data.format.Formats;
import tables.T_User;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UserItem {
    public int id;
    public String name;
    public String schoolYear;
    public String height;
    public String birthDay;
    public String likeFood;

    public String createdAt;
    public String updatedAt;

    public UserItem(T_User user){
        this.id = user.id;
        this.name = user.name;
        this.schoolYear = user.schoolYear + "年生";
        this.height = user.height + "cm";
        this.likeFood = user.likeFood;

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd H:mm:ss");
        this.birthDay = dateFormat.format(user.birthDay);
        this.createdAt = dateFormat.format(user.createdAt);
        this.updatedAt = dateFormat.format(user.updatedAt);
    }
}
