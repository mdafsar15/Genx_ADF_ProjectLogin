package view;

import SCM_JR_CUST45_Utils.JSFUtils;

import Utils.CommonHelper;

import javax.faces.event.ActionEvent;

import oracle.adf.model.BindingContext;
import oracle.adf.share.ADFContext;
import oracle.adf.view.rich.component.rich.RichDialog;
import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.layout.RichGridCell;
import oracle.adf.view.rich.component.rich.layout.RichMasonryLayout;
import oracle.adf.view.rich.component.rich.layout.RichToolbar;
import oracle.adf.view.rich.context.AdfFacesContext;
import oracle.adf.view.rich.event.DialogEvent;
import oracle.adf.view.rich.event.PopupFetchEvent;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

public class Department {
    private RichPopup bndResTable;
    private RichMasonryLayout masonryLayoutRefreshDep;
    private RichToolbar toolbarBinding;
    private RichDialog popupListenerBinding;
    private RichPopup mainHeaderPopup;
    private RichGridCell mainHeaderBinding;

    public Department() {
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

    public void onOkCancelForEditPopup(DialogEvent dialogEvent) {
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

//    public void btnEditActionListener(ActionEvent actionEvent) {
//        // Add event code here...
//    }
//        boolean btnAddDis = true;
    
        String currentBtnValue = "";
    String currentdetBtnValue = "";
    private String regionReturn = null;
    
     boolean btnAddDis = true;
    boolean btnEditDis = true;
    boolean btnViewDis = false;
    boolean btnDelDis = true;
    boolean btnRollDis = true;
    boolean btnSaveDis = true;

    boolean btnTabAddDis = true;
    boolean btnTabEditDis = true;
    boolean btnTabDelDis = true;
    boolean btnRollDisiable=true;
    
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
        btnRollDisiable=true;

    }
  
    
    public void btnPermissionMethod() {
        disableAll();
                                                       
        btnAddDis = (ADFContext.getCurrent().getPageFlowScope().get("iBtnAdd").equals("Y") ? false : true);
        btnEditDis = (ADFContext.getCurrent().getPageFlowScope().get("iBtnEdit").equals("Y") ? false : true);
        btnDelDis = (ADFContext.getCurrent().getPageFlowScope().get("iBtnDel").equals("Y") ? false : true);
        regionReturn =
            ADFContext.getCurrent().getPageFlowScope().get("iRegionView") == null ? "GridView" :
            ADFContext.getCurrent().getPageFlowScope().get("iRegionView").toString();
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
        } else if (currentBtnValue.equals("C") || currentBtnValue.equals("S")) {
    //            btnPermissionMethod();
            disableAll();
    //
    AdfFacesContext.getCurrentInstance().getPageFlowScope().put("iBtnAdd", "Y"); //remove before merging
                AdfFacesContext.getCurrentInstance().getPageFlowScope().put("iBtnEdit", "Y");
                
        btnAddDis = (ADFContext.getCurrent()
                               .getPageFlowScope()
                               .get("iBtnAdd")
                               .equals("Y") ? false : true);
        btnEditDis = (ADFContext.getCurrent()
                                .getPageFlowScope()
                                .get("iBtnEdit")
                                .equals("Y") ? false : true);
            btnViewDis = false;
            
        }
    }
    
    public void btnEditActionListener(ActionEvent actionEvent) {
                btnEnableDisable();
                CommonHelper.refreshLayout(masonryLayoutRefreshDep);
                CommonHelper.refreshLayout(toolbarBinding);
    }

    public void EditActionListener(ActionEvent actionEvent) {
    //        JSFUtils.showPopup(itemPopupBinding, null);
                CommonHelper.refreshLayout(masonryLayoutRefreshDep);
                CommonHelper.refreshLayout(toolbarBinding);
    }
    
    public void btnCanActionListener(ActionEvent actionEvent) {
            btnEnableDisable();
            CommonHelper.findOperation("Rollback").execute();
            CommonHelper.refreshLayout(masonryLayoutRefreshDep);
            CommonHelper.refreshLayout(toolbarBinding);
        }
    
    public void btnSaveActionListener(ActionEvent actionEvent) {
        btnEnableDisable();
        CommonHelper.findOperation("Commit").execute();
        CommonHelper.refreshLayout(masonryLayoutRefreshDep);
        CommonHelper.refreshLayout(toolbarBinding);
        
    }
    //---------------------------------
    
    public void createDept(ActionEvent actionEvent) {
        // Add event code here...
        btnEnableDisable();
        JSFUtils.showPopup(mainHeaderPopup, null);
        CommonHelper.refreshLayout(masonryLayoutRefreshDep);
        CommonHelper.refreshLayout(toolbarBinding);
    }

    public void editDept(ActionEvent actionEvent) {
        // Add event code here...
        btnEnableDisable();
        CommonHelper.refreshLayout(masonryLayoutRefreshDep);
        CommonHelper.refreshLayout(toolbarBinding);
    }

    public void saveDept(ActionEvent actionEvent) {
        // Add event code here...
        btnEnableDisable();
        CommonHelper.findOperation("Commit").execute();
        CommonHelper.refreshLayout(masonryLayoutRefreshDep);
        CommonHelper.refreshLayout(toolbarBinding);
    }

    public void cancelDept(ActionEvent actionEvent) {
        // Add event code here...
        btnEnableDisable();
          CommonHelper.findOperation("Rollback").execute();
          CommonHelper.refreshLayout(masonryLayoutRefreshDep);
          CommonHelper.refreshLayout(toolbarBinding);
              CommonHelper.refreshLayout(    mainHeaderBinding);
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

    public void setMasonryLayoutRefreshDep(RichMasonryLayout masonryLayoutRefreshDep) {
        this.masonryLayoutRefreshDep = masonryLayoutRefreshDep;
    }

    public RichMasonryLayout getMasonryLayoutRefreshDep() {
        return masonryLayoutRefreshDep;
    }

  

    public void setToolbarBinding(RichToolbar toolbarBinding) {
        this.toolbarBinding = toolbarBinding;
    }

    public RichToolbar getToolbarBinding() {
        return toolbarBinding;
    }


    public void setBtnAddDis(boolean btnAddDis) {
        this.btnAddDis = btnAddDis;
    }

    public boolean isBtnAddDis() {
        return btnAddDis;
    }

    public void setRegionReturn(String regionReturn) {
        this.regionReturn = regionReturn;
    }

    public String getRegionReturn() {
        return regionReturn;
    }

    public void setBtnRollDisiable(boolean btnRollDisiable) {
        this.btnRollDisiable = btnRollDisiable;
    }

    public boolean isBtnRollDisiable() {
        return btnRollDisiable;
    }
    //-----------------------------------------------------------------------------------------------------------------------------------------------------


    

    public void setPopupListenerBinding(RichDialog popupListenerBinding) {
        this.popupListenerBinding = popupListenerBinding;
    }

    public RichDialog getPopupListenerBinding() {
        return popupListenerBinding;
    }

    public void setMainHeaderPopup(RichPopup mainHeaderPopup) {
        this.mainHeaderPopup = mainHeaderPopup;
    }

    public RichPopup getMainHeaderPopup() {
        return mainHeaderPopup;
    }

    public void setMainHeaderBinding(RichGridCell mainHeaderBinding) {
        this.mainHeaderBinding = mainHeaderBinding;
    }

    public RichGridCell getMainHeaderBinding() {
        return mainHeaderBinding;
    }
}
