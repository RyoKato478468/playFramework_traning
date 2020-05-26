package tables;

import io.ebean.annotation.*;
import play.data.format.Formats;

import javax.persistence.*;
import javax.persistence.Version;

import java.util.Date;

@Entity
public class T_User extends BaseTable{

    @Id
    @NotNull
    public int id;

    @NotNull
    public String name;
    public int schoolYear;
    public int height;
    public String likeFood;
    @Formats.DateTime(pattern = "yyyy/MM/dd HH:mm:SS")
    public Date birthDay;

    @CreatedTimestamp
    @Formats.DateTime(pattern = "yyyy/MM/dd HH:mm:SS")
    public Date createdAt;

    @Version
    @Formats.DateTime(pattern = "yyyy/MM/dd HH:mm:SS")
    public Date updatedAt;
}
