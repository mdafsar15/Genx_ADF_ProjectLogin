package view;
import javax.faces.event.ActionEvent;

import oracle.adf.model.BindingContext;

import oracle.adf.view.rich.component.rich.RichPopup;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

public class Popup {
    public Popup() {
    }
    
    private RichPopup p1;

    public void displayPopup(ActionEvent actionEvent) {
        BindingContext bctx = BindingContext.getCurrent();
        BindingContainer bc =bctx.getCurrentBindingsEntry();
        OperationBinding ob = bc.getOperationBinding("CreateInsert");
        ob.execute();
        RichPopup.PopupHints hints = new RichPopup.PopupHints();
        getP1().show(hints);
    }


    public void setP1(RichPopup p1) {
        this.p1 = p1;
    }

    public RichPopup getP1() {
        return p1;
    }
}
