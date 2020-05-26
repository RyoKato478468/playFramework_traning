package models;

import play.data.format.Formats;
import tables.T_User;

import java.util.Date;

public class UserItem {
    public int id;
    public String name;
    public String schoolYear;
    public String height;
    public String likeFood;

    @Formats.DateTime(pattern = "yyyy/MM/dd HH:mm:SS")
    public Date createdAt;

    @Formats.DateTime(pattern = "yyyy/MM/dd HH:mm:SS")
    public Date updatedAt;

    public UserItem(T_User user){
        this.id = user.id;
        this.name = user.name;
        this.schoolYear = user.schoolYear + "年生";
        this.height = user.height + "cm";
        this.likeFood = user.likeFood;
        this.createdAt = user.createdAt;
        this.updatedAt = user.updatedAt;
    }

}
