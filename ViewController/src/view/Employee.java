package view;


import SCM_JR_CUST45_Utils.JSFUtils;

import Utils.CommonHelper;

import javax.faces.event.ActionEvent;

import oracle.adf.model.BindingContext;
import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.layout.RichMasonryLayout;
import oracle.adf.view.rich.component.rich.nav.RichButton;
import oracle.adf.view.rich.context.AdfFacesContext;
import oracle.adf.view.rich.event.DialogEvent;
import oracle.adf.view.rich.event.PopupFetchEvent;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

public class Employee {
    private RichPopup bndResTable;
    private RichMasonryLayout masonryLayoutRefresh;
    private RichButton itemPopupBinding;

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

  
    
    
    
    
    String currentBtnValue = "";
    String currentdetBtnValue = "";

    public void setCurrentBtnValue(String currentBtnValue) {
        this.currentBtnValue = currentBtnValue;
    }

    public String getCurrentBtnValue() {
        return currentBtnValue;
    }

    public void setCurrentdetBtnValue(String currentdetBtnValue) {
        this.currentdetBtnValue = currentdetBtnValue;
    }

    public String getCurrentdetBtnValue() {
        return currentdetBtnValue;
    }

    boolean btnAddDis = true;
    boolean btnEditDis = true;
    boolean btnViewDis = false;
    boolean btnDelDis = true;
    boolean btnRollDis = true;
    boolean btnSaveDis = true;

    boolean btnTabAddDis = true;
    boolean btnTabEditDis = true;
    boolean btnTabDelDis = true;
    
    public void disableAll() {
        btnAddDis = true;
        btnEditDis = true;
        btnDelDis = true;
        btnViewDis = false;
        btnRollDis = true;
        btnSaveDis = true;
        btnTabDelDis = true;
        btnTabAddDis = true;
        btnTabEditDis = true;

    }
    
    public void btnEnableDisable() {
        if (currentBtnValue.equals("E") || currentBtnValue.equals("A")) {
            disableAll();
            btnSaveDis = false;
            btnRollDis = false;
            btnViewDis = true;

            btnTabDelDis = false;
            btnTabAddDis = false;
            btnTabEditDis = false;
        } else if (currentBtnValue.equals("V")) {
            disableAll();
            btnRollDis = false;
            btnViewDis = true;

            btnTabDelDis = true;
            btnTabAddDis = true;
            btnTabEditDis = true;
//        } else if (currentBtnValue.equals("C") || currentBtnValue.equals("S")) {
//            btnPermissionMethod();
//            btnViewDis = false;
      }
    }

    public void btnEditActionListener(ActionEvent actionEvent) {
                btnEnableDisable();
                CommonHelper.refreshLayout(masonryLayoutRefresh);
//                CommonHelper.refreshLayout(toolbarBinding);
    }

    public void EditActionListener(ActionEvent actionEvent) {
//        JSFUtils.showPopup(itemPopupBinding, null);
                CommonHelper.refreshLayout(masonryLayoutRefresh);
    //                CommonHelper.refreshLayout(toolbarBinding);
    }

    public void setMasonryLayoutRefresh(RichMasonryLayout masonryLayoutRefresh) {
        this.masonryLayoutRefresh = masonryLayoutRefresh;
    }

    public RichMasonryLayout getMasonryLayoutRefresh() {
        return masonryLayoutRefresh;
    }

    public void setItemPopupBinding(RichButton itemPopupBinding) {
        this.itemPopupBinding = itemPopupBinding;
    }

    public RichButton getItemPopupBinding() {
        return itemPopupBinding;
    }


    public void setBtnAddDis(boolean btnAddDis) {
        this.btnAddDis = btnAddDis;
    }

    public boolean isBtnAddDis() {
        return btnAddDis;
    }

    public void setBtnEditDis(boolean btnEditDis) {
        this.btnEditDis = btnEditDis;
    }

    public boolean isBtnEditDis() {
        return btnEditDis;
    }

    public void setBtnViewDis(boolean btnViewDis) {
        this.btnViewDis = btnViewDis;
    }

    public boolean isBtnViewDis() {
        return btnViewDis;
    }

    public void setBtnDelDis(boolean btnDelDis) {
        this.btnDelDis = btnDelDis;
    }

    public boolean isBtnDelDis() {
        return btnDelDis;
    }

    public void setBtnRollDis(boolean btnRollDis) {
        this.btnRollDis = btnRollDis;
    }

    public boolean isBtnRollDis() {
        return btnRollDis;
    }

    public void setBtnSaveDis(boolean btnSaveDis) {
        this.btnSaveDis = btnSaveDis;
    }

    public boolean isBtnSaveDis() {
        return btnSaveDis;
    }

    public void setBtnTabAddDis(boolean btnTabAddDis) {
        this.btnTabAddDis = btnTabAddDis;
    }

    public boolean isBtnTabAddDis() {
        return btnTabAddDis;
    }

    public void setBtnTabEditDis(boolean btnTabEditDis) {
        this.btnTabEditDis = btnTabEditDis;
    }

    public boolean isBtnTabEditDis() {
        return btnTabEditDis;
    }

    public void setBtnTabDelDis(boolean btnTabDelDis) {
        this.btnTabDelDis = btnTabDelDis;
    }

    public boolean isBtnTabDelDis() {
        return btnTabDelDis;
    }
}
