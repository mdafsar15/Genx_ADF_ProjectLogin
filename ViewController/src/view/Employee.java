package view;


import SCM_JR_CUST45_Utils.JSFUtils;

import Utils.CommonHelper;

import javax.faces.event.ActionEvent;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.share.ADFContext;
import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.layout.RichGridCell;
import oracle.adf.view.rich.component.rich.layout.RichMasonryLayout;
import oracle.adf.view.rich.component.rich.layout.RichPanelGroupLayout;
import oracle.adf.view.rich.component.rich.layout.RichPanelSpringboard;
import oracle.adf.view.rich.component.rich.layout.RichToolbar;
import oracle.adf.view.rich.component.rich.nav.RichButton;
import oracle.adf.view.rich.component.rich.output.RichPanelCollection;
import oracle.adf.view.rich.context.AdfFacesContext;
import oracle.adf.view.rich.event.DialogEvent;
import oracle.adf.view.rich.event.PopupFetchEvent;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.ViewObject;

public class Employee {
    private RichPopup bndResTable;
    private RichMasonryLayout masonryLayoutRefresh;
    private RichButton itemPopupBinding;
    private RichToolbar toolBarBinding;
    private RichMasonryLayout masonaryBindingRef;
    private RichGridCell mainPannel;
    private RichPopup mainHeaderPopup;
    private RichMasonryLayout massonryLayoutDept;
    private RichGridCell mainPanelDept;
    private RichToolbar toolBarBindingDept;
    private RichPopup mainHeaderPopupDept;
    private RichPopup popupsuccessDept;
    private RichPopup popupSuccessEmp;
    private RichPanelCollection panelBinding;
    private RichToolbar toolBarDeptBinding;
    private RichPanelSpringboard springBinding;
    private RichPanelGroupLayout panelGroupDeptBinding;
    private RichPopup deletePopup;
    private RichPopup editEmpPopup;
    private RichToolbar toolbarBindingRest;
    private RichMasonryLayout masonaryRestBinding;
    private RichMasonryLayout masonarySoapBinding;


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
                    OperationBinding ob = bc.getOperationBinding("Delete");
                    ob.execute();
//                    AdfFacesContext.getCurrentInstance().addPartialTarget(bndResTable);
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
//
    public void clickOnEditUpdate(DialogEvent dialogEvent) {
        // Add event code here...
        if(DialogEvent.Outcome.ok == dialogEvent.getOutcome().ok) {
                    BindingContainer bc = BindingContext.getCurrent().getCurrentBindingsEntry();
                    OperationBinding ob = bc.getOperationBinding("Delete");
                    ob.execute();
                    AdfFacesContext.getCurrentInstance().addPartialTarget(bndResTable);
                }
                else{
                    BindingContainer bc = BindingContext.getCurrent().getCurrentBindingsEntry();
                    OperationBinding ob = bc.getOperationBinding("Rollback");
                    ob.execute();
                }
    }    
    
    //-----------------------------------Work----------------------------------------------------------
    
    String currentBtnValue = "";
    String currentdetBtnValue = "";

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
    
    //---------------emp--------------//
    
    boolean btnEmpDis = false;
    boolean btnDeptDis = false;
    boolean btnRestSoapDis = false;
    boolean btnHomeDis = false;
    boolean btnRestDis = false;
    boolean btnSoapDis = false;

    
    
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
    
    public void disableRenderedEmpAll(){
        btnEmpDis = true;
       
    }

    public void btnRendered(){
        if(currentBtnValue.equals("N")){
            btnEmpDis=true;
            btnDeptDis = false;
            btnRestSoapDis = false;
            btnHomeDis = false;
        }
    }
    
    public void btnDeptRendered(){
        if(currentBtnValue.equals("M")){
            btnDeptDis = true;
            btnEmpDis = false;
            btnRestSoapDis = false;
            btnHomeDis = false;
        }
    }
    
    public void btnIntegrationRendered(){
        if(currentBtnValue.equals("O")){
            btnRestSoapDis = true;
            btnDeptDis = false;
            btnEmpDis = false;
            btnHomeDis = false;
        }
    }
    
    public void btnHomeRendered(){
        if(currentBtnValue.equals("P")){
            btnHomeDis = true;
            btnRestSoapDis = false;
            btnDeptDis = false;
            btnEmpDis = false;
        }
    }
    
    public void btnRestRendered(){
        if(currentBtnValue.equals("Q")){
            btnRestDis = true;
            btnSoapDis = false;
        }
    }
    
    public void btnSoapRendered(){
        if(currentBtnValue.equals("R")){
            btnSoapDis = true;
            btnRestDis = false;
        }
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
    
    

    public void addActionListener(ActionEvent actionEvent) {
        // Add event code here...
        btnEnableDisable();
        JSFUtils.showPopup(mainHeaderPopup, null);
        CommonHelper.refreshLayout(masonaryBindingRef);
        CommonHelper.refreshLayout(toolBarBinding);
//        CommonHelper.refreshLayout(mainPannel);
    }
    
    public void btnEditActionListener(ActionEvent actionEvent) {
                    btnEnableDisable();
                    CommonHelper.refreshLayout(masonaryBindingRef);
                    CommonHelper.refreshLayout(toolBarBinding);
//            CommonHelper.refreshLayout(mainPannel);
        }

        public void EditActionListener(ActionEvent actionEvent) {
            JSFUtils.showPopup(editEmpPopup, null);
                    CommonHelper.refreshLayout(masonaryBindingRef);
                        CommonHelper.refreshLayout(toolBarBinding);
//            CommonHelper.refreshLayout(mainPannel);
        }

    public void save(ActionEvent actionEvent) {
        // Add event code here...
        btnEnableDisable();
//        JSFUtils.showPopup(popupSuccessEmp, null);
        CommonHelper.findOperation("Commit").execute();
        CommonHelper.refreshLayout(masonaryBindingRef);
        CommonHelper.refreshLayout(toolBarBinding);
//        CommonHelper.refreshLayout(mainPannel);
    }

    public void cancel(ActionEvent actionEvent) {
      
      btnEnableDisable();
        CommonHelper.findOperation("Rollback").execute();
        CommonHelper.refreshLayout(masonaryBindingRef);
        CommonHelper.refreshLayout(toolBarBinding);
//        CommonHelper.refreshLayout(    mainPannel);

    }
    
    public void delete(ActionEvent actionEvent) {
      
      btnEnableDisable();
       JSFUtils.showPopup(deletePopup, null);
//        CommonHelper.findOperation("Delete").execute();
        CommonHelper.refreshLayout(masonaryBindingRef);
        CommonHelper.refreshLayout(toolBarBinding);
    //        CommonHelper.refreshLayout(    mainPannel);

    }
    public void deleteNew(ActionEvent actionEvent) {
      
      btnEnableDisable();
//       JSFUtils.showPopup(deletePopup, null);
            CommonHelper.findOperation("Delete").execute();
        CommonHelper.refreshLayout(masonaryBindingRef);
        CommonHelper.refreshLayout(toolBarBinding);
    //        CommonHelper.refreshLayout(    mainPannel);

    }

//-----------Department-------------
    
    
    
        public void createDept(ActionEvent actionEvent) {
        // Add event code here...
        btnEnableDisable();
        JSFUtils.showPopup(mainHeaderPopupDept, null);
        CommonHelper.refreshLayout(massonryLayoutDept);
        CommonHelper.refreshLayout(toolBarBindingDept);
//        CommonHelper.refreshLayout(mainPannel);
        
    }

    public void editDept(ActionEvent actionEvent) {
        // Add event code here...
        btnEnableDisable();
        CommonHelper.refreshLayout(massonryLayoutDept);
        CommonHelper.refreshLayout(toolBarBindingDept);
    
    }

    public void saveDept(ActionEvent actionEvent) {
        // Add event code here...
        btnEnableDisable();
//        JSFUtils.showPopup(popupsuccessDept, null);
        CommonHelper.findOperation("Commit").execute();
        CommonHelper.refreshLayout(massonryLayoutDept);
        CommonHelper.refreshLayout(toolBarBindingDept);
//        CommonHelper.refreshLayout(mainPannel);
    }

    public void cancelDept(ActionEvent actionEvent) {
        // Add event code here...
        btnEnableDisable();
          CommonHelper.findOperation("Rollback").execute();
          CommonHelper.refreshLayout(massonryLayoutDept);
          CommonHelper.refreshLayout(toolBarBindingDept);
//        CommonHelper.refreshLayout(mainPannel);
    }
    
    
    public void setToolBarBinding(RichToolbar toolBarBinding) {
        this.toolBarBinding = toolBarBinding;
    }

    public RichToolbar getToolBarBinding() {
        return toolBarBinding;
    }

    public void setMasonaryBindingRef(RichMasonryLayout masonaryBindingRef) {
        this.masonaryBindingRef = masonaryBindingRef;
    }

    public RichMasonryLayout getMasonaryBindingRef() {
        return masonaryBindingRef;
    }

    public void firstEmpMethod(ActionEvent actionEvent) {
        // Add event code here...
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
//        btnEnableDisable();

//        CommonHelper.refreshLayout(masonaryBindingRef);
//            CommonHelper.refreshLayout(toolBarBinding);
    }



    public void empRef(ActionEvent actionEvent) {
        // Add event code here...
        btnRendered();
        CommonHelper.refreshLayout(massonryLayoutDept);
    //        CommonHelper.refreshLayout(toolBarBindingDept);
    }
    
    
    public void deptRef(ActionEvent actionEvent) {
        // Add event code here...
        btnDeptRendered();
        CommonHelper.refreshLayout(massonryLayoutDept);
    }
    
    public void restSoapRef(ActionEvent actionEvent) {
        // Add event code here...
        btnIntegrationRendered();
        CommonHelper.refreshLayout(massonryLayoutDept);
    }
    
    public void homeRef(ActionEvent actionEvent) {
        // Add event code here...
        btnHomeRendered();
        CommonHelper.refreshLayout(massonryLayoutDept);
    }
    
    public void RestRef(ActionEvent actionEvent) {
        // Add event code here...
        btnRestRendered();
        CommonHelper.refreshLayout(masonaryRestBinding);
    }
    
    public void SoapRef(ActionEvent actionEvent) {
        // Add event code here...
        btnSoapRendered();
        CommonHelper.refreshLayout(masonaryRestBinding);
    }

    
    
    
    
    
    
    
    
    
    public void setMainPannel(RichGridCell mainPannel) {
        this.mainPannel = mainPannel;
    }

    public RichGridCell getMainPannel() {
        return mainPannel;
    }

    public void setMainHeaderPopup(RichPopup mainHeaderPopup) {
        this.mainHeaderPopup = mainHeaderPopup;
    }

    public RichPopup getMainHeaderPopup() {
        return mainHeaderPopup;
    }

    public void setMassonryLayoutDept(RichMasonryLayout massonryLayoutDept) {
        this.massonryLayoutDept = massonryLayoutDept;
    }

    public RichMasonryLayout getMassonryLayoutDept() {
        return massonryLayoutDept;
    }

    public void setMainPanelDept(RichGridCell mainPanelDept) {
        this.mainPanelDept = mainPanelDept;
    }

    public RichGridCell getMainPanelDept() {
        return mainPanelDept;
    }

    public void setToolBarBindingDept(RichToolbar toolBarBindingDept) {
        this.toolBarBindingDept = toolBarBindingDept;
    }

    public RichToolbar getToolBarBindingDept() {
        return toolBarBindingDept;
    }

    public void setMainHeaderPopupDept(RichPopup mainHeaderPopupDept) {
        this.mainHeaderPopupDept = mainHeaderPopupDept;
    }

    public RichPopup getMainHeaderPopupDept() {
        return mainHeaderPopupDept;
    }


    public void setPopupsuccessDept(RichPopup popupsuccessDept) {
        this.popupsuccessDept = popupsuccessDept;
    }

    public RichPopup getPopupsuccessDept() {
        return popupsuccessDept;
    }

    public void setPopupSuccessEmp(RichPopup popupSuccessEmp) {
        this.popupSuccessEmp = popupSuccessEmp;
    }

    public RichPopup getPopupSuccessEmp() {
        return popupSuccessEmp;
    }

    public void setPanelBinding(RichPanelCollection panelBinding) {
        this.panelBinding = panelBinding;
    }

    public RichPanelCollection getPanelBinding() {
        return panelBinding;
    }

    public void setToolBarDeptBinding(RichToolbar toolBarDeptBinding) {
        this.toolBarDeptBinding = toolBarDeptBinding;
    }

    public RichToolbar getToolBarDeptBinding() {
        return toolBarDeptBinding;
    }

    public void editDeptDetailsButton(ActionEvent actionEvent) {
        // Add event code here...
        btnEnableDisable();
        CommonHelper.refreshLayout(panelBinding);
        CommonHelper.refreshLayout(springBinding);
        CommonHelper.refreshLayout(toolBarDeptBinding);
    }

    public void setSpringBinding(RichPanelSpringboard springBinding) {
        this.springBinding = springBinding;
    }

    public RichPanelSpringboard getSpringBinding() {
        return springBinding;
    }

    public void setPanelGroupDeptBinding(RichPanelGroupLayout panelGroupDeptBinding) {
        this.panelGroupDeptBinding = panelGroupDeptBinding;
    }

    public RichPanelGroupLayout getPanelGroupDeptBinding() {
        return panelGroupDeptBinding;
    }

    public void setDeletePopup(RichPopup deletePopup) {
        this.deletePopup = deletePopup;
    }

    public RichPopup getDeletePopup() {
        return deletePopup;
    }

    public void onCreateEmpPopup(PopupFetchEvent popupFetchEvent) {
        // Add event code here...
        BindingContainer bc = BindingContext.getCurrent().getCurrentBindingsEntry();
        OperationBinding ob = bc.getOperationBinding("CreateInsert");
        ob.execute();
    }

    public void setEditEmpPopup(RichPopup editEmpPopup) {
        this.editEmpPopup = editEmpPopup;
    }

    public RichPopup getEditEmpPopup() {
        return editEmpPopup;
    }
    
  

    public void setBtnTabDelDis(boolean btnTabDelDis) {
        this.btnTabDelDis = btnTabDelDis;
    }

    public boolean isBtnTabDelDis() {
        return btnTabDelDis;
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

    public void setBtnViewDis(boolean btnViewDis) {
        this.btnViewDis = btnViewDis;
    }

    public boolean isBtnViewDis() {
        return btnViewDis;
    }

    public void setBtnRollDis(boolean btnRollDis) {
        this.btnRollDis = btnRollDis;
    }

    public boolean getBtnRollDis() {
        return btnRollDis;
    }

    public void setBtnSaveDis(boolean btnSaveDis) {
        this.btnSaveDis = btnSaveDis;
    }

    public boolean getBtnSaveDis() {
        return btnSaveDis;
    }

    public void setBtnAddDis(boolean btnAddDis) {
        this.btnAddDis = btnAddDis;
    }

    public boolean getBtnAddDis() {
        return btnAddDis;
    }

    public void setBtnEditDis(boolean btnEditDis) {
        this.btnEditDis = btnEditDis;
    }

    public boolean getBtnEditDis() {
        return btnEditDis;
    }

    public void setBtnDelDis(boolean btnDelDis) {
        this.btnDelDis = btnDelDis;
    }

    public boolean getBtnDelDis() {
        return btnDelDis;
    }

    public void setCurrentBtnValue(String currentBtnValue) {
        this.currentBtnValue = currentBtnValue;
    }

    public String getCurrentBtnValue() {
        return currentBtnValue;
    }

    public void setBtnEmpDis(boolean btnEmpDis) {
        this.btnEmpDis = btnEmpDis;
    }

    public boolean isBtnEmpDis() {
        return btnEmpDis;
    }

   


    public void setBtnDeptDis(boolean btnDeptDis) {
        this.btnDeptDis = btnDeptDis;
    }

    public boolean isBtnDeptDis() {
        return btnDeptDis;
    }

    public void setBtnRestSoapDis(boolean btnRestSoapDis) {
        this.btnRestSoapDis = btnRestSoapDis;
    }

    public boolean isBtnRestSoapDis() {
        return btnRestSoapDis;
    }

    public void setBtnHomeDis(boolean btnHomeDis) {
        this.btnHomeDis = btnHomeDis;
    }

    public boolean isBtnHomeDis() {
        return btnHomeDis;
    }

    public void setBtnRestDis(boolean btnRestDis) {
        this.btnRestDis = btnRestDis;
    }

    public boolean isBtnRestDis() {
        return btnRestDis;
    }

    public void setToolbarBindingRest(RichToolbar toolbarBindingRest) {
        this.toolbarBindingRest = toolbarBindingRest;
    }

    public RichToolbar getToolbarBindingRest() {
        return toolbarBindingRest;
    }

    public void setBtnSoapDis(boolean btnSoapDis) {
        this.btnSoapDis = btnSoapDis;
    }

    public boolean isBtnSoapDis() {
        return btnSoapDis;
    }


    public void setMasonaryRestBinding(RichMasonryLayout masonaryRestBinding) {
        this.masonaryRestBinding = masonaryRestBinding;
    }

    public RichMasonryLayout getMasonaryRestBinding() {
        return masonaryRestBinding;
    }

    public void setMasonarySoapBinding(RichMasonryLayout masonarySoapBinding) {
        this.masonarySoapBinding = masonarySoapBinding;
    }

    public RichMasonryLayout getMasonarySoapBinding() {
        return masonarySoapBinding;
    }
}
