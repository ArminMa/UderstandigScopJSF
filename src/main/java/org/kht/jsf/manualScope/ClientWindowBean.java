package org.kht.jsf.manualScope;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.lifecycle.ClientWindow;

@ManagedBean(name = "clientWindowBean")
@RequestScoped
public class ClientWindowBean {

    private static String index = "index.xhtml";
    private static String secondPage = "secondPage";

    private static FacesContext facesContext;
    private static ExternalContext externalContext;
    private static ClientWindow clientWindow;


    public void getWindowID(){
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        ClientWindow clientWindow = externalContext.getClientWindow();

        if (clientWindow != null){
            System.out.println("client window id: " + clientWindow.getId());
        } else {
            System.out.println("client window cannot be determined!");
        }
    }

    public String enableClientWindow(){
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        ClientWindow clientWindow = externalContext.getClientWindow();
        clientWindow.enableClientWindowRenderMode(facesContext);
        return "index?faces-redirect=true";
    }

    public String redirect(int goTo){

        if(goTo ==0){
            defaultCall();
            clientWindow.enableClientWindowRenderMode(facesContext);
            return facesContext.getExternalContext().getApplicationContextPath();
        }

        if(goTo ==1){
            defaultCall();
            clientWindow.enableClientWindowRenderMode(facesContext);
            clientWindow.getQueryURLParameters(facesContext);
            return facesContext.getExternalContext().getApplicationContextPath();
        }


        return null;
    }

    public String disableClientWindow(){
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        ClientWindow clientWindow = externalContext.getClientWindow();
        clientWindow.disableClientWindowRenderMode(facesContext);
        return "index?faces-redirect=true";
    }

    private void defaultCall(){
        facesContext = FacesContext.getCurrentInstance();
        externalContext = facesContext.getExternalContext();
        clientWindow = externalContext.getClientWindow();
    }

}