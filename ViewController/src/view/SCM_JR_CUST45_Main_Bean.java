package view;

import SCM_JR_CUST45_Utils.ADFUtils;
import SCM_JR_CUST45_Utils.CommonHelper;

import SCM_JR_CUST45_Utils.JSFUtils;

import javax.faces.event.ActionEvent;

import oracle.adf.controller.ControllerContext;
import oracle.adf.controller.ViewPortContext;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.share.ADFContext;
import oracle.adf.view.rich.component.rich.RichDialog;
import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.layout.RichMasonryLayout;
import oracle.adf.view.rich.component.rich.layout.RichToolbar;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.adf.view.rich.event.DialogEvent;
import oracle.adf.view.rich.event.PopupCanceledEvent;

import oracle.binding.OperationBinding;

import oracle.jbo.Row;
import oracle.jbo.ViewObject;

public class SCM_JR_CUST45_Main_Bean {

    private RichDialog mdM0110PopupBinding;
    private RichPopup itemPopupBinding;
    private RichMasonryLayout masonryLayoutBinding;
    private RichToolbar toolbarBinding;
    private RichPopup variant_PopupBinding;

    public SCM_JR_CUST45_Main_Bean() {
        super();
    }

    private String regionReturn = null;

    public void setRegionReturn(String regionReturn) {
        this.regionReturn = regionReturn;
    }

    public String getRegionReturn() {
        return regionReturn;
    }


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


    public void btnPermissionMethod() {
        disableAll();

        //        AdfFacesContext.getCurrentInstance().getPageFlowScope().put("iBtnAdd", "Y"); //remove before merging
        //        AdfFacesContext.getCurrentInstance().getPageFlowScope().put("iBtnEdit", "Y"); //remove before merging
        //        AdfFacesContext.getCurrentInstance().getPageFlowScope().put("iBtnDel", "Y"); //remove before merging
        //        AdfFacesContext.getCurrentInstance().getPageFlowScope().put("iBgCode", "3"); //remove before merging
        //        AdfFacesContext.getCurrentInstance().getPageFlowScope().put("iOrgCode", "5"); //remove before merging
        //        AdfFacesContext.getCurrentInstance().getPageFlowScope().put("iUsrCode", "1"); //remove before merging
        //        AdfFacesContext.getCurrentInstance().getPageFlowScope().put("iFsPath", "D:\\documents");
        //        AdfFacesContext.getCurrentInstance().getPageFlowScope().put("iUsrRepf", "Resource.xml");
        //        AdfFacesContext.getCurrentInstance().getPageFlowScope().put("iTopLabel",
        //                                                                    "FusionApps | goERP | CRM | Master Data | Opportunity Management"); //remove before merging
        btnAddDis = (ADFContext.getCurrent()
                               .getPageFlowScope()
                               .get("iBtnAdd")
                               .equals("Y") ? false : true);
        btnEditDis = (ADFContext.getCurrent()
                                .getPageFlowScope()
                                .get("iBtnEdit")
                                .equals("Y") ? false : true);
        btnDelDis = (ADFContext.getCurrent()
                               .getPageFlowScope()
                               .get("iBtnDel")
                               .equals("Y") ? false : true);
        regionReturn = ADFContext.getCurrent()
                                 .getPageFlowScope()
                                 .get("iRegionView") == null ? "GridView" : ADFContext.getCurrent()
                                                                                      .getPageFlowScope()
                                                                                      .get("iRegionView")
                                                                                      .toString();

        //  System.out.println("btnAddDis " + btnAddDis);
        //  System.out.println("btnEditDis " + btnEditDis);
        //  System.out.println("btnDelDis " + btnDelDis);
    }


    public void controllerExceptionHandler() {
        ControllerContext context = ControllerContext.getInstance();
        ViewPortContext currentRootViewPort = context.getCurrentRootViewPort();

        if (currentRootViewPort.isExceptionPresent()) {
            currentRootViewPort.clearException();
        }
    }

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

    public void initialStage() {
        DCIteratorBinding voIterator = CommonHelper.findIterator("Crm0301EOView1Iterator");
        ViewObject object = voIterator.getViewObject();
        //object.setNamedWhereClauseParam("vTrnCode", -1);
        voIterator.executeQuery();
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
            btnPermissionMethod();
            btnViewDis = false;
        }
    }

    public void btnAddActionListener(ActionEvent actionEvent) {
        btnEnableDisable();
        OperationBinding op = CommonHelper.findOperation("CreateWithParams0301");
        op.getParamsMap().put("BgCode", ADFContext.getCurrent()
                                                  .getPageFlowScope()
                                                  .get("iBgCode")
                                                  .toString());
        op.getParamsMap().put("OrgCode", ADFContext.getCurrent()
                                                   .getPageFlowScope()
                                                   .get("iOrgCode")
                                                   .toString());
        op.getParamsMap().put("TrnDate", "");
        op.getParamsMap().put("FldStat", "");
        op.execute();
    }

    public void btnViewActionListener(ActionEvent actionEvent) {
        btnEnableDisable();
    }

    public void btnEditActionListener(ActionEvent actionEvent) {
        btnEnableDisable();
        //        checkValueInHederTable("EmployeesVO1Iterator", masonryLayoutBinding);
        CommonHelper.refreshLayout(masonryLayoutBinding);
        CommonHelper.refreshLayout(toolbarBinding);
    }

    public void btnCanActionListener(ActionEvent actionEvent) {
        btnEnableDisable();
        CommonHelper.findOperation("Rollback").execute();
        CommonHelper.refreshLayout(masonryLayoutBinding);
        CommonHelper.refreshLayout(toolbarBinding);
    }

    public void btnSaveActionListener(ActionEvent actionEvent) {
        btnEnableDisable();
        CommonHelper.findOperation("Commit").execute();
        CommonHelper.refreshLayout(masonryLayoutBinding);
        CommonHelper.refreshLayout(toolbarBinding);
    }

    public void btnExitActionListener(ActionEvent actionEvent) {
        OperationBinding op = CommonHelper.findOperation("Rollback");
        op.execute();
        String actionName = "gotoParent";
        CommonHelper.navigation(actionName);
        CommonHelper.refreshLayout(masonryLayoutBinding);
        CommonHelper.refreshLayout(toolbarBinding);
    }

    public void MDM0110AddActionListener(ActionEvent actionEvent) {
        // Add event code here...
        OperationBinding op = CommonHelper.findOperation("CreateInsertMdm0111");
        op.execute();
        JSFUtils.showPopup(itemPopupBinding, null);
        CommonHelper.refreshLayout(masonryLayoutBinding);
        CommonHelper.refreshLayout(toolbarBinding);
    }

    public void Mdm0110EditActionListener(ActionEvent actionEvent) {
        // Add event code here...
        JSFUtils.showPopup(itemPopupBinding, null);
        CommonHelper.refreshLayout(masonryLayoutBinding);
        CommonHelper.refreshLayout(toolbarBinding);
    }

    public void setMdM0110PopupBinding(RichDialog mdM0110PopupBinding) {
        this.mdM0110PopupBinding = mdM0110PopupBinding;
    }

    public RichDialog getMdM0110PopupBinding() {
        return mdM0110PopupBinding;
    }

    public void setItemPopupBinding(RichPopup itemPopupBinding) {
        this.itemPopupBinding = itemPopupBinding;
    }

    public RichPopup getItemPopupBinding() {
        return itemPopupBinding;
    }

    public void ItemPopupCancelListener(PopupCanceledEvent popupCanceledEvent) {
        // Add event code here...
        if (currentdetBtnValue.equals("A")) {
            CommonHelper.findIterator("Mdm0111EoView2Iterator")
                        .getCurrentRow()
                        .remove();
            btnEnableDisable();
        }
        CommonHelper.refreshLayout(masonryLayoutBinding);
        CommonHelper.refreshLayout(toolbarBinding);
    }

    public void setMasonryLayoutBinding(RichMasonryLayout masonryLayoutBinding) {
        this.masonryLayoutBinding = masonryLayoutBinding;
    }

    public RichMasonryLayout getMasonryLayoutBinding() {
        return masonryLayoutBinding;
    }

    public void setToolbarBinding(RichToolbar toolbarBinding) {
        this.toolbarBinding = toolbarBinding;
    }

    public RichToolbar getToolbarBinding() {
        return toolbarBinding;
    }

    public void Variant_AddActionListener(ActionEvent actionEvent) {
        // Add event code here...
        OperationBinding op = CommonHelper.findOperation("CreateInsertMDM0112");
        op.execute();
        JSFUtils.showPopup(variant_PopupBinding, null);
        CommonHelper.refreshLayout(masonryLayoutBinding);
        CommonHelper.refreshLayout(toolbarBinding);
    }

    public void VariantEditActionListener(ActionEvent actionEvent) {
        // Add event code here...
        JSFUtils.showPopup(variant_PopupBinding, null);
        CommonHelper.refreshLayout(masonryLayoutBinding);
        CommonHelper.refreshLayout(toolbarBinding);
    }

    public void Variant_PopupCancelListener(PopupCanceledEvent popupCanceledEvent) {
        // Add event code here...
        if (currentdetBtnValue.equals("A")) {
            CommonHelper.findIterator("Mdm0112EoView3Iterator")
                        .getCurrentRow()
                        .remove();
            btnEnableDisable();
        }
        CommonHelper.refreshLayout(masonryLayoutBinding);
        CommonHelper.refreshLayout(toolbarBinding);
    }

    public void setVariant_PopupBinding(RichPopup variant_PopupBinding) {
        this.variant_PopupBinding = variant_PopupBinding;
    }

    public RichPopup getVariant_PopupBinding() {
        return variant_PopupBinding;
    }

    public boolean checkValueInHederTable(String string, javax.faces.component.UIComponent vUiComponent) {
        Row selectedRow = (Row) ADFUtils.evaluateEL("#{bindings." + string + ".currentRow}");
        if (selectedRow == null) {
            DCIteratorBinding voIterator = CommonHelper.findIterator(string);
            voIterator.executeQuery();
            Row selectedRow1 = (Row) ADFUtils.evaluateEL("#{bindings." + string + ".currentRow}");
            if (selectedRow1 == null) {
                currentBtnValue = "C";
                CommonHelper.refreshLayout(vUiComponent);
                JSFUtils.addFacesErrorMessage("No Data Found", "INFO");
                btnEnableDisable();
                return false;
            } else {
                return true;
            }
        } else {
            return true;
        }
    }

    public void Item_DialogListener(DialogEvent dialogEvent) {
        // Add event code here...
        if (dialogEvent.getOutcome()
                       .toString()
                       .equals("ok")) {
            OperationBinding binding1 = CommonHelper.findOperation("Executemdm0111");
            binding1.execute();
        }
        CommonHelper.refreshLayout(masonryLayoutBinding);
        CommonHelper.refreshLayout(toolbarBinding);
    }
}

