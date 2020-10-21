package Utils;

import SCM_JR_CUST45_Utils.JSFUtils;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.MethodExpression;
import javax.el.ValueExpression;

import javax.faces.application.FacesMessage;
import javax.faces.application.NavigationHandler;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCDataControl;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.ApplicationModule;

import org.apache.myfaces.trinidad.render.ExtendedRenderKitService;
import org.apache.myfaces.trinidad.util.Service;

public class CommonHelper {
    public CommonHelper() {
        super();
    }
    
    public static String getMainBundleProperty(String key) {
        return getLocProperty("com.penfax.view.PenfaxViewControllerBundle", key);
    }

    public static String getLocProperty(String resBundleName, String key) {
        FacesContext context = FacesContext.getCurrentInstance();
        Locale locale = context.getViewRoot().getLocale();
        ResourceBundle bundle = ResourceBundle.getBundle(resBundleName, locale);

        String propValue = bundle.getString(key);

        return propValue;
    }

    public static ApplicationModule getApplicationModule(String appModuleName) {
        ApplicationModule am = null;
        BindingContext ctx = BindingContext.getCurrent();
        if (ctx != null) {
            DCDataControl dc = ctx.findDataControl(appModuleName + "DataControl");
            if (dc != null) {
                am = dc.getApplicationModule();
            }
        }
        return am;
    }

    // invokes popup aligned with button

    public static void invokePopup(RichPopup popup, UIComponent parent) {
        RichPopup.PopupHints hints = new RichPopup.PopupHints();
        //hints.add(RichPopup.PopupHints.HintTypes.HINT_ALIGN_ID, parent);
        //hints.add(RichPopup.PopupHints.HintTypes.HINT_ALIGN, RichPopup.PopupHints.AlignTypes.ALIGN_AFTER_START);

        popup.show(hints);
    }

    public static void invokePopup(RichPopup popup) {
        RichPopup.PopupHints hints = new RichPopup.PopupHints();
        popup.show(hints);
    }

    public static void invokePopup(String popupId) {
        invokePopup(popupId, null, null);
    }

    public static void invokePopup(String popupId, String align, String alignId) {
        if (popupId != null) {
            ExtendedRenderKitService service =
                Service.getRenderKitService(FacesContext.getCurrentInstance(), ExtendedRenderKitService.class);

            StringBuffer showPopup = new StringBuffer();
            showPopup.append("var hints = new Object();");
            //Add hints only if specified - see javadoc for AdfRichPopup js for details on valid values and behavior
            if (align != null && alignId != null) {
                showPopup.append("hints[AdfRichPopup.HINT_ALIGN] = " + align + ";");
                showPopup.append("hints[AdfRichPopup.HINT_ALIGN_ID] ='" + alignId + "';");
            }
            showPopup.append("var popupObj=AdfPage.PAGE.findComponent('" + popupId + "'); popupObj.show(hints);");
            service.addScript(FacesContext.getCurrentInstance(), showPopup.toString());
        }
    }

    public static void hidePopup(String popupId) {
        if (popupId != null) {
            ExtendedRenderKitService service =
                Service.getRenderKitService(FacesContext.getCurrentInstance(), ExtendedRenderKitService.class);

            String hidePopup = "var popupObj=AdfPage.PAGE.findComponent('" + popupId + "'); popupObj.hide();";
            service.addScript(FacesContext.getCurrentInstance(), hidePopup);
        }

    }

    /* 
     *
     *  This method displays error message to end user
     */
    /*
    * This method displays error message to end user
    */
    public static void addErrorFacesMessage(String compID, String title, String msg) {
        FacesContext.getCurrentInstance().addMessage(compID, new FacesMessage(FacesMessage.SEVERITY_ERROR, title, msg));
    }

    public static void addInfoMessage(String compID, String msg) {
        FacesContext.getCurrentInstance().addMessage(compID, new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg));
    }

    public static void addWarnsMessage(String compID, String msg) {
        FacesContext.getCurrentInstance().addMessage(compID, new FacesMessage(FacesMessage.SEVERITY_WARN, msg, msg));
    }
    /*
    * method will provide the values
    *  @param  ViewObject
    *   @param whereClause
    *    @param parameters for whereClause
    * */


    public static Object evaluateEL(String el) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ELContext elContext = facesContext.getELContext();
        ExpressionFactory expressionFactory = facesContext.getApplication().getExpressionFactory();
        ValueExpression exp = expressionFactory.createValueExpression(elContext, el, Object.class);

        return exp.getValue(elContext);
    }


    public static Object invokeMethodExpression(String expr, Class returnType, Class[] argTypes, Object[] args) {
        FacesContext fc = FacesContext.getCurrentInstance();
        ELContext elctx = fc.getELContext();
        ExpressionFactory elFactory = fc.getApplication().getExpressionFactory();
        MethodExpression methodExpr = elFactory.createMethodExpression(elctx, expr, returnType, argTypes);
        return methodExpr.invoke(elctx, args);
    }

    public static Object invokeMethodExpression(String expr, Class returnType, Class argType, Object argument) {
        return invokeMethodExpression(expr, returnType, new Class[] { argType }, new Object[] { argument });
    }


    /* 
    * This method finds the operationBinding for method opr(String).
    * If no operationBinding is found it adds Error OPER_BINDING_NOT_FOUND to PenfaxResult .
    * Why Class as input param : This method return Object, returned by method Executed. In case method execution fails, reported
    * error must provide information which class tried executing opr method.
    * If operationBinding is present, it is executed. If there are any errors in execution,
    *     erros are added to PenfaxResult and further processResult method is called to display error.
    *
    * @param opr
    * @param className
    * @return
    */


    /* 
     * Sets a value into an EL object. Provides similar functionality to
     * the <af:setActionListener> tag, except the from is
     * not an EL. You can get similar behavior by using the following...
     * setEL(to, evaluateEL(from))
     *
     * @param el EL object to assign a value
     * @param val Value to assign
     */
    
    public static void setEL(String el, Object val) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ELContext elContext = facesContext.getELContext();
        ExpressionFactory expressionFactory = facesContext.getApplication().getExpressionFactory();
        ValueExpression exp = expressionFactory.createValueExpression(elContext, el, Object.class);

        exp.setValue(elContext, val);
    }

    public static void navigation(String navigation) {
        NavigationHandler nvHndlr = FacesContext.getCurrentInstance().getApplication().getNavigationHandler();
        nvHndlr.handleNavigation(FacesContext.getCurrentInstance(), null, navigation);
    }

    /**
     * Find an iterator binding in the current binding container by name.
     * 
     * @param name iterator binding name
     * @return iterator binding
     */
    public static DCIteratorBinding findIterator(String name) {
        DCIteratorBinding iter = 
            getDCBindingContainer().findIteratorBinding(name);
        if (iter == null) {
            throw new RuntimeException("Iterator '" + name + "' not found");
        }
        return iter;
    }
        
    /**
     * Find an operation binding in the current binding container by name.
     * 
     * @param name operation binding name
     * @return operation binding
     */
    public static OperationBinding findOperation(String name) {
        OperationBinding op = 
            getDCBindingContainer().getOperationBinding(name);
        if (op == null) {
            throw new RuntimeException("Operation '" + name + "' not found");
        }
        return op;
    }
    
    /**
     * Return the Binding Container as a DCBindingContainer.
     * @return current binding container as a DCBindingContainer
     */
    public static DCBindingContainer getDCBindingContainer() {
        return (DCBindingContainer)getBindingContainer();
    }

    /**
     * Return the current page's binding container.
     * @return the current page's binding container
     */
    public static BindingContainer getBindingContainer() {
        return (BindingContainer)JSFUtils.resolveExpression("#{bindings}");
    }
    
    
    public static void refreshLayout(javax.faces.component.UIComponent vBinding){
            AdfFacesContext.getCurrentInstance().addPartialTarget(vBinding);
        }
}
