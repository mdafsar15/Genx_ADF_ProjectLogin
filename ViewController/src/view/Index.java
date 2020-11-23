package view;

import java.util.regex.Pattern;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import java.util.regex.Matcher;
import javax.faces.validator.ValidatorException;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;


public class Index {
    public Index() {
    }

    public void emailValidator(FacesContext facesContext, UIComponent uIComponent, Object object) {
        // Add event code here...
        String email_address = object.toString();
           String email_pattern = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
           
           Pattern patn = Pattern.compile(email_pattern);
           Matcher matcher=patn.matcher(email_address);
           
           String Error_Message = "You have entered an invalid email address. Please try again.";
           
           if(!matcher.matches()){
               throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,Error_Message,null));
           }
    }

    public void mobileValidator(FacesContext facesContext, UIComponent uIComponent, Object object) {
        // Add event code here...
       
        String email_address = object.toString();
           String email_pattern = "^((\\+)?(\\d{2}[-]))?(\\d{10}){1}?$";
           
           Pattern patn = Pattern.compile(email_pattern);
           Matcher matcher=patn.matcher(email_address);
           
           String Error_Message = "You have entered an invalid mobile number. Please try again.";
           
           if(!matcher.matches()){
               throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,Error_Message,null));
           }

    }
}
