/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.relatorio;

import com.ifpb.model.Relatorio;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public abstract class GeradorDeRelatorio {

    private final List<Relatorio> dados;

    public GeradorDeRelatorio(List<Relatorio> lista) {
        this.dados = lista;
    }

    public abstract String contentType();

    public abstract void relatorioFormat(ServletOutputStream servletOutputStream,
            InputStream reportStream, HashMap parameters, JRDataSource jrds);

    public void relatorioTemplate() throws IOException {

        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();
        InputStream reportStream = facesContext.getExternalContext().getResourceAsStream("/WEB-INF/report/relatorioteste.jasper");

        HashMap parameters = new HashMap();
        JRDataSource jrds = new JRBeanCollectionDataSource(dados);
        try (ServletOutputStream servletOutputStream = response.getOutputStream()) {
            String type = contentType();
            response.setContentType(type);
            facesContext.responseComplete();
            relatorioFormat(servletOutputStream, reportStream, parameters, jrds);
            servletOutputStream.flush();
        }

    }
}
