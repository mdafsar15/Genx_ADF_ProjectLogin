package view;

import oracle.adf.model.BindingContext;
import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.context.AdfFacesContext;
import oracle.adf.view.rich.event.DialogEvent;
import oracle.adf.view.rich.event.PopupFetchEvent;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

public class Employee {
    private RichPopup bndResTable;

    public Employee() {
        super();
    }

    public void onCreateNewEmp(PopupFetchEvent popupFetchEvent) {
        // Add event code here...
        BindingContainer bc = BindingContext.getCurrent().getCurrentBindingsEntry();
        OperationBinding ob = bc.getOperationBinding("CreateInsert");
        ob.execute();
    }

    public void onOkCancelForAddPopup(DialogEvent dialogEvent) {
        // Add event code here...
        if(DialogEvent.Outcome.ok == dialogEvent.getOutcome().ok) {
                    BindingContainer bc = BindingContext.getCurrent().getCurrentBindingsEntry();
                    OperationBinding ob = bc.getOperationBinding("Commit");
                    ob.execute();
                    AdfFacesContext.getCurrentInstance().addPartialTarget(bndResTable);
                }
                else{
                    BindingContainer bc = BindingContext.getCurrent().getCurrentBindingsEntry();
                    OperationBinding ob = bc.getOperationBinding("Rollback");
                    ob.execute();
                }
    }

    public void setBndResTable(RichPopup bndResTable) {
        this.bndResTable = bndResTable;
    }

    public RichPopup getBndResTable() {
        return bndResTable;
    }

    public void clickOnEditUpdate(DialogEvent dialogEvent) {
        // Add event code here...
        if(DialogEvent.Outcome.ok == dialogEvent.getOutcome().ok) {
                    BindingContainer bc = BindingContext.getCurrent().getCurrentBindingsEntry();
                    OperationBinding ob = bc.getOperationBinding("Commit");
                    ob.execute();
                    AdfFacesContext.getCurrentInstance().addPartialTarget(bndResTable);
                }
                else{
                    BindingContainer bc = BindingContext.getCurrent().getCurrentBindingsEntry();
                    OperationBinding ob = bc.getOperationBinding("Rollback");
                    ob.execute();
                }
    }
}
