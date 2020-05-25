package models;

import javax.inject.Inject;

import play.data.*;
import play.mvc.*;
import tables.find.*;

public class UserForm {

    @Inject
    public FormFactory formFactory;

    public Form<SubmitData> submitDataForm;
    public SubmitData submitData;

    public UserForm(Http.Request request){
        this.submitDataForm = formFactory.form(SubmitData.class).bindFromRequest(request);
        this.submitData = submitDataForm.get();
    }
}