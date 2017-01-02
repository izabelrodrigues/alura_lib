package br.com.alura.alura_lib.factory;

import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;

import br.com.alura.alura_lib.annotation.ScopeMap;
import br.com.alura.alura_lib.annotation.ScopeMap.Scope;

public class JSFFactory {

	@Produces
    @RequestScoped
    public FacesContext getFacesContext(){
        return FacesContext.getCurrentInstance();
    }

    @Produces
    @RequestScoped
    public Flash getFlash(){
        return getExternalContext().getFlash();
    }

    @Produces
    @ScopeMap(Scope.REQUEST)
    public Map<String,Object> getRequestMap(){
        return getExternalContext().getRequestMap();
    }

    @Produces
    @ScopeMap(Scope.SESSION)
    public Map<String, Object> getSessionMap(){
        return getExternalContext().getSessionMap();
    }

    @Produces
    @ScopeMap(Scope.APPLICATION)
    public Map<String,Object> getApplicationMap(){
        return getExternalContext().getApplicationMap();
    }

    private ExternalContext getExternalContext(){
        return getFacesContext().getExternalContext();
    }

}
