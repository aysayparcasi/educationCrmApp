/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.educationCrm.scope;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import javax.faces.context.FacesContext;
import java.util.Map;

/**
 * Kullanici scopelarindan olan view scope spring boot da default olmadığı için
 * manuel scope sınıfı yazılmıştır.
 *
 * @author USER
 */
public class ViewScope implements Scope {

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {

        FacesContext facesContext = FacesContext.getCurrentInstance();
        Map<String, Object> viewMap = facesContext.getViewRoot().getViewMap();
        Object viewScopedBean = viewMap.get(name);

        if (viewScopedBean == null) {
            viewScopedBean = objectFactory.getObject();
            viewMap.put(name, viewScopedBean);
        }

        return viewScopedBean;
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {
        // Unsupported feature
    }

    @Override
    public Object remove(String name) {

        FacesContext facesContext = FacesContext.getCurrentInstance();
        Map<String, Object> viewMap = facesContext.getViewRoot().getViewMap();

        return viewMap.remove(name);
    }

    @Override
    public Object resolveContextualObject(String key) {

        // Unsupported feature
        return null;
    }

    @Override
    public String getConversationId() {

        // Unsupported feature
        return null;
    }

}
