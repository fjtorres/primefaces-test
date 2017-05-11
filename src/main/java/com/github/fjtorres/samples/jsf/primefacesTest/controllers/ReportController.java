package com.github.fjtorres.samples.jsf.primefacesTest.controllers;

import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import com.github.fjtorres.samples.jsf.primefacesTest.events.CustomEventPublisher;
import com.github.fjtorres.samples.jsf.primefacesTest.events.EndEvent;
import com.github.fjtorres.samples.jsf.primefacesTest.events.StartEvent;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

@ManagedBean
@ViewScoped
public class ReportController {

   private List<String> reports;

   private String selectedReport;
   
   @ManagedProperty("#{customEventPublisher}")
   private CustomEventPublisher eventPublisher;
   
   public void loadReports() {
      reports = new ArrayList<>();
      reports.add("TEST");
   }

   public void executeReport() throws Exception {

      eventPublisher.publish(new StartEvent(this));
      
      ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();

      ServletContext context = (ServletContext) ec.getContext();

      OutputStream output = ec.getResponseOutputStream();

      String imagesPath = context.getResource("resources/images").toString();

      Path reportsPath = Paths.get(context.getResource("WEB-INF/reports").toURI());

      JasperReport jasperReport = JasperCompileManager.compileReport(reportsPath.resolve("test.jrxml").toAbsolutePath().toString());

      // Parameters for report
      Map<String, Object> parameters = new HashMap<String, Object>();

      // Report datasource
      JRDataSource dataSource = new JREmptyDataSource();

      // Generate report
      JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

      ec.responseReset();
      ec.setResponseContentType("application/pdf");
      ec.setResponseHeader("Content-Disposition", "attachment; filename=\"test.pdf\"");
      
      JasperExportManager.exportReportToPdfStream(jasperPrint, output);

      FacesContext.getCurrentInstance().responseComplete(); 
      
      eventPublisher.publish(new EndEvent(this));
   }

   public List<String> getReports() {
      return reports;
   }

   public void setReports(List<String> pReports) {
      reports = pReports;
   }

   public String getSelectedReport() {
      return selectedReport;
   }

   public void setSelectedReport(String pSelectedReport) {
      selectedReport = pSelectedReport;
   }

   public CustomEventPublisher getEventPublisher() {
      return eventPublisher;
   }

   public void setEventPublisher(CustomEventPublisher pEventPublisher) {
      eventPublisher = pEventPublisher;
   }

}
