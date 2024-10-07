/*===========================================================================+
 |   Copyright (c) 2001, 2005 Oracle Corporation, Redwood Shores, CA, USA    |
 |                         All rights reserved.                              |
 +===========================================================================+
 |  HISTORY                                                                  |
 +===========================================================================*/
package xxattach.oracle.apps.per.addatt.webui;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import java.io.InputStream;

import java.io.Serializable;

import java.sql.CallableStatement;

import oracle.apps.fnd.common.VersionInfo;
import oracle.apps.fnd.framework.OAApplicationModule;
import oracle.apps.fnd.framework.OAException;
import oracle.apps.fnd.framework.OARow;
import oracle.apps.fnd.framework.OAViewObject;
import oracle.apps.fnd.framework.server.OADBTransaction;
import oracle.apps.fnd.framework.webui.OAControllerImpl;
import oracle.apps.fnd.framework.webui.OAPageContext;
import oracle.apps.fnd.framework.webui.OAWebBeanConstants;
import oracle.apps.fnd.framework.webui.beans.OAWebBean;

import oracle.apps.fnd.framework.webui.beans.form.OAFormValueBean;

import oracle.apps.fnd.framework.webui.beans.message.OAMessageLovInputBean;

import oracle.cabo.ui.data.DataObject;

import oracle.jbo.Row;
import oracle.jbo.domain.BlobDomain;

import xxattach.oracle.apps.per.addatt.server.AttachAMImpl;

/**
 * Controller for ...
 */
public class AttachCO extends OAControllerImpl
{
  public static final String RCS_ID="$Header$";
  public static final boolean RCS_ID_RECORDED =
        VersionInfo.recordClassVersion(RCS_ID, "%packagename%");
        
    String invoiceId = null;
    //String appId     = null;
    String productCode = null;
    String transNum = null;

  /**
   * Layout and page setup logic for a region.
   * @param pageContext the current OA page context
   * @param webBean the web bean corresponding to the region
   */
  public void processRequest(OAPageContext pageContext, OAWebBean webBean)
  {
    super.processRequest(pageContext, webBean);
      AttachAMImpl attachAM =(AttachAMImpl)pageContext.getApplicationModule(webBean);
      OAViewObject attachVO = (OAViewObject)attachAM.findViewObject("AttachVO");
      
      if( pageContext.getParameter("invoiceId") != null) 
      {
      
          String param =pageContext.getParameter("invoiceId");
          String[] paramList = param.split(",");
          
          invoiceId = paramList[0];
          productCode = paramList[1];
          transNum = paramList[2];
              
      //productCode =  attachAM.executeSQLquery("select PRODUCT_CODE from FND_APPLICATION where APPLICATION_ID = "+appId);
        
        pageContext.writeDiagnostics(this," invoice id -->"+invoiceId+"  transNum --> "+ transNum+" product code "+productCode,4);
              
          attachVO.setWhereClause(null);
          attachVO.setWhereClauseParams(null);
          attachVO.setWhereClause("invoice_id = "+invoiceId+" and category = '"+productCode+"'");
          attachVO.executeQuery();
      }
      else
      {
          attachVO.executeQuery();
      }
      
      
      attachVO.reset();
     int i = 0;
      while (attachVO.hasNext()) {
          OARow row2 = (OARow)attachVO.next();
          i++;
          row2.setAttribute("Sno",i);
      }
      

    
  }

  /**
   * Procedure to handle form submissions for form elements in
   * a region.
   * @param pageContext the current OA page context
   * @param webBean the web bean corresponding to the region
   */
  public void processFormRequest(OAPageContext pageContext, OAWebBean webBean)
  {
    super.processFormRequest(pageContext, webBean);
    
      AttachAMImpl attachAM =(AttachAMImpl)pageContext.getApplicationModule(webBean);
      OAViewObject attachVO = (OAViewObject)attachAM.findViewObject("AttachVO");
      
           
      
      String eventSrc = 
                  pageContext.getParameter(OAWebBeanConstants.EVENT_SOURCE_ROW_REFERENCE);
              Row rowRef = attachAM.findRowByRef(eventSrc);

      String filePath = null;
      String fileName = null;
      
          
      if (pageContext.getParameter("Upload") != null)
   {        
         
       attachAM.upLoadFile(pageContext,webBean,invoiceId,transNum,productCode);       
                
                   if( pageContext.getParameter("invoiceId") != null) 
                   {
                      
                       attachVO.setWhereClause(null);
                       attachVO.setWhereClauseParams(null);
                       attachVO.setWhereClause("invoice_id = "+invoiceId+" and category = '"+productCode+"'");
                       attachVO.executeQuery();
                   }
                   else
                   {
                       attachVO.executeQuery();
                   }

                        attachVO.reset();
                        int i = 0;
                        while (attachVO.hasNext()) 
                         {
                            OARow row2 = (OARow)attachVO.next();
                            i++;
                            row2.setAttribute("Sno",i);
                         }                                  
   }
         
    if("download".equals(pageContext.getParameter(EVENT_PARAM))) 
    {
      
      filePath = rowRef.getAttribute("FilePath").toString();
      fileName = rowRef.getAttribute("Filename").toString();
      
      pageContext.writeDiagnostics(this," file path "+filePath+" file name  "+fileName,4);
      
      attachAM.downloadFileFromServer(pageContext,filePath,fileName,webBean);
    }
    
    if("selectAll".equals(pageContext.getParameter(EVENT_PARAM)))
    {
   
        attachVO.reset();
        while(attachVO.hasNext())
        {
          OARow row = (OARow)attachVO.next();
          row.setAttribute("DeleteFlag","Y");
        }
    }
    
      if("save".equals(pageContext.getParameter(EVENT_PARAM)))
      {
      
         attachAM.getOADBTransaction().commit();
      }
    
        if("delete".equals(pageContext.getParameter(EVENT_PARAM)))
        {
        
        
            attachVO.reset();
            while(attachVO.hasNext())
            {
              OARow row = (OARow)attachVO.next();
                if("Y".equals(row.getAttribute("DeleteFlag"))) 
                {
                
                    filePath = row.getAttribute("FilePath").toString();
                    fileName = row.getAttribute("Filename").toString();
                    
                   pageContext.writeDiagnostics(this," delete record",4);
                   attachAM.deleteRow(row);
                   attachAM.deleteFileFromServer(filePath,fileName);
                }
            }
            attachVO.reset();
           int i = 0;
            while (attachVO.hasNext()) {
                OARow row2 = (OARow)attachVO.next();
                i++;
                row2.setAttribute("Sno",i);
            }
          
        }
      
  }

}
