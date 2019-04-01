package com.ifpb.br.relatorio;

import com.ifpb.model.Relatorio;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletOutputStream;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;

public class RelatorioPDF extends GeradorDeRelatorio {

    public RelatorioPDF(List<Relatorio> lista) {
        super(lista);
    }

    @Override
    public String contentType() {
        return "application/pdf";
    }

    @Override
    public void relatorioFormat(ServletOutputStream servletOutputStream,
            InputStream reportStream, HashMap parameters, JRDataSource jrds) {
        try {
            JasperRunManager.runReportToPdfStream(reportStream, servletOutputStream, parameters, jrds);

        } catch (JRException ex) {
            Logger.getLogger(RelatorioPDF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
