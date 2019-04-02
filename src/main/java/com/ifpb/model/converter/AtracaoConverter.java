package com.ifpb.model.converter;

import com.ifpb.model.Atracao;
import com.ifpb.atracao.AtracaoDao;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Amanda
 */
@FacesConverter(value = "atracaoConverter", forClass = Atracao.class)
public class AtracaoConverter implements Converter {
    
    @EJB
    private AtracaoDao dao;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value == null || value.isEmpty()){
            return null;
        }else{
            Long id = Long.parseLong(value);
            Atracao atracao = dao.find(id);
            return atracao;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Atracao atracao = (Atracao) value;
       if(atracao != null){
            return String.valueOf(atracao.getId());
        }else{
            return null;
        }
    }

}
