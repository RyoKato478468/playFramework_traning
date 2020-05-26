package controllers;

import models.UserForm;
import models.UserItem;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.*;
import tables.T_User;
import tables.find.*;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

@Singleton
public class Application extends Controller{

    @Inject
    FormFactory formFactory;

    public Result index(Http.Request request) {
        Form<SubmitData> submitDataForm= formFactory.form(SubmitData.class).bindFromRequest(request);
        SubmitData submitData = submitDataForm.get();

        List<UserItem> items = UserForm.search(submitData.name);

        return ok(views.html.index.render(items));
    }

    public Result search(String searchWord){
        return ok(views.html.index.render(UserForm.search(searchWord)));
    }
}
