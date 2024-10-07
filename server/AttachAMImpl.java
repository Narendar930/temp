package xxattach.oracle.apps.per.addatt.server;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

import java.sql.CallableStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.HashMap;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import oracle.apps.fnd.framework.OAApplicationModule;
import oracle.apps.fnd.framework.OAException;
import oracle.apps.fnd.framework.OARow;
import oracle.apps.fnd.framework.OAViewObject;
import oracle.apps.fnd.framework.server.OAApplicationModuleImpl;
import oracle.apps.fnd.framework.server.OADBTransaction;
import oracle.apps.fnd.framework.server.OAViewObjectImpl;
import oracle.apps.fnd.framework.webui.OAPageContext;
import oracle.apps.fnd.framework.webui.OAWebBeanConstants;
import oracle.apps.fnd.framework.webui.beans.OAWebBean;

import oracle.cabo.ui.data.DataObject;

import oracle.cabo.ui.path.Path;

import oracle.jbo.Row;
import oracle.jbo.domain.BlobDomain;

import xxattach.oracle.apps.per.addatt.poplist.server.FileLocationVOImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class AttachAMImpl extends OAApplicationModuleImpl {
    /**This is the default constructor (do not remove)
     */
    public AttachAMImpl() {
    }


    /**Sample main for debugging Business Components code using the tester.
     */
    public static void main(String[] args) {
        launchTester("xxattach.oracle.apps.per.addatt.server", /* package name */
      "AttachAMLocal" /* Configuration Name */);
    }
    
    public Row createRow(OAViewObject viewObject,OADBTransaction oadbTransaction) 
       {
         if(viewObject!=null)  
         {   
         System.out.println(" inside method");
             if (!viewObject.isPreparedForExecution())
             {    
                   viewObject.setMaxFetchSize(0);
             }          
             Row row = viewObject.createRow();
             viewObject.last();
             viewObject.next();
             viewObject.insertRow(row);
             row.setNewRowState(Row.STATUS_INITIALIZED);          
            System.out.println(" row reurn");
             return row;
         }
         return null;
       }
       
    public void deleteRow(OARow row) {
//         OARow row = (OARow)findRowByRef(rowref);
         row.remove();
         getOADBTransaction().commit();
     }
       
    public void deleteFileFromServer(String filePath, String fileName)
     {

       System.out.println("Comming into Delete File");
       System.out.println("File name & Path Before Deleting" + fileName + 
                          filePath);
       File file = new File(filePath);
       System.out.println("File output---->" + file);
       file.delete();
     }
       
    public void downloadFileFromServer(OAPageContext pageContext,
        String file_name_with_path,
        String file_name_with_ext,
        OAWebBean webBean)
        
        {
        HttpServletResponse response =
            (HttpServletResponse)pageContext.getRenderingContext().getServletResponse();
        System.out.println("file_name_with_path - " + file_name_with_path);
        System.out.println("file_name_with_ext - " + file_name_with_ext);
        
        if (((file_name_with_path == null) || 
             ("".equals(file_name_with_path))))
        {
            throw new OAException("File path is invalid.");
        }
        File fileToDownload = null;
        try
        {
            fileToDownload = new File(file_name_with_path);
            fileToDownload = fileToDownload.getAbsoluteFile();
        } catch (Exception e)
        {

            throw
                new OAException("Invalid File Path or file does not exist." + 
                                file_name_with_path);
        }

        System.out.println("fileToDownload - " + fileToDownload);
        System.out.println("fileToDownload - " + fileToDownload.exists());

        if (!fileToDownload.exists())
        {
            // throw new OAException("File does not exist.");

            HashMap param2 = new HashMap();
            String seqno = null;
            OAApplicationModule am = pageContext.getApplicationModule(webBean);
            OAViewObject vo =                 (OAViewObject)am.findViewObject("SSC_AOR_ITT_EOVO1");
            OARow row = (OARow)vo.last();
            // OARow row1 = (OARow)vo.getCurrentRow();

            seqno = row.getAttribute("AwardRefNumber").toString();
            param2.put("awardref", seqno);
            param2.put("msg1", "File does not exist.");

//            pageContext.setForwardURL("OA.jsp?page=/ssc/oracle/apps/po/selfservice/aor/itt/webui/SSC_Aor_IIT_Main_PG", 
//                                      null, 
//                                      OAWebBeanConstants.KEEP_MENU_CONTEXT, 
//                                      null, param2, true, 
//                                      OAWebBeanConstants.ADD_BREAD_CRUMB_NO, 
//                                      (byte)99);
        }

        if (!fileToDownload.canRead())
        {
            throw new OAException("Not Able to read the file.");
        }

        String fileType = getMimeType(file_name_with_ext);
        response.setContentType(fileType);
        response.setContentLength((int)fileToDownload.length());

        response.setHeader("Content-Disposition", 
                           "attachment; filename=\"" + file_name_with_ext + 
                           "\"");

        InputStream in = null;
        ServletOutputStream outs = null;

        try
        {
            outs = response.getOutputStream();
            in = new BufferedInputStream(new FileInputStream(fileToDownload));
            int ch;
            while ((ch = in.read()) != -1)
            {
                outs.write(ch);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        } finally
        {
            try
            {
                outs.flush();
                outs.close();
                if (in != null)
                {
                    in.close();
                }
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }

    /**
     * @param s
     * @return file mime type from its name
     */   
     public String getMimeType(String s) {

        int i = s.lastIndexOf(".");
        if (i > 0 && i < s.length() - 1)
        {
            String s1 = s.substring(i + 1);
            if (s1.equalsIgnoreCase("txt"))
            {
                return "text/plain";
            }
            if (s1.equalsIgnoreCase("xml"))
            {
                return "text/xml";
            }
            if (s1.equalsIgnoreCase("sh"))
            {
                return "application/x-sh";
            }
        }
       return "application/octet-stream";
    }
    
        public String executeSQLquery(String sqlquery) 
            {
                       
                        PreparedStatement preparedstatement = null;
                        ResultSet resultset = null;
                        Connection conn = getOADBTransaction().getJdbcConnection(); 
                        String result = null;
                         try
                        {
                                String query = sqlquery;
                                preparedstatement = conn.prepareStatement(query);
                                resultset = preparedstatement.executeQuery();
                                if(resultset.next())
                                {
                                        result = resultset.getString(1);
                                        resultset.close();
                                        preparedstatement.close(); 
                                }
                        }
                        catch(Exception e)
                        {
                                throw OAException.wrapperException(e);
                        }
                        return result;
               }
    
    public void upLoadFile(OAPageContext pageContext,OAWebBean webBean,String invoiceId, String transNum, String productCode)
    { 
        String filePath = null;

        try
        {        
            OAViewObject fileVO = getFileLocationVO();
            fileVO.executeQuery();            
            filePath = fileVO.first().getAttribute("Location").toString();
        }
        catch(Exception ex)
        {
            throw new OAException(" Unable to retrive file path -->"+ex.getMessage(), OAException.ERROR);
        }
        
        pageContext.writeDiagnostics(this,"Default File Path---->"+filePath,4);
        
        filePath = filePath+"/"+productCode+"/"+invoiceId;
                 
//      filePath = "/u03/R1213DV/apps/apps_st/appl/XX4I/12.0.0/Attachment/"+productCode+"/"+invoiceId;  //Commented by Siva on 14th Feb 18
//        filePath = "F:\\Attachment";
     System.out.println("Default File Path---->"+filePath);

     String fileName = null;
        try
        {
         DataObject fileUploadData =  pageContext.getNamedDataObject("Browse");

        //FileUploading is my MessageFileUpload Bean Id
         if(fileUploadData!=null)
         {
           fileName = (String)fileUploadData.selectValue(null, "UPLOAD_FILE_NAME"); 
          String contentType = (String) fileUploadData.selectValue(null, "UPLOAD_FILE_MIME_TYPE");  
          pageContext.writeDiagnostics(this,"User File Name---->"+fileName,4);
          
         pageContext.writeDiagnostics(this," file path "+filePath+" file name "+fileName,4);
          FileOutputStream output = null;
          InputStream input = null;

          BlobDomain uploadedByteStream = (BlobDomain)fileUploadData.selectValue(null, fileName);
        
        File file = null;
        
        //               if( fileLocation.getValue(pageContext) != null)
        //               {
        //                   pageContext.writeDiagnostics(this," file location "+fileLocation.getValue(pageContext),4);
        //                   if("C DRIVE".equals(fileLocation.getValue(pageContext))) {
        //                       pageContext.writeDiagnostics(this,"File output---->"+file+" file location "+fileLocation.getValue(pageContext),4);
        //                       file = new File(filePath, fileName);
        //                      file = new File (file.toString().replace('/','\\'));
        //                       pageContext.writeDiagnostics(this,"File output os---->"+file,4);
        //                   }
        //                   else {
        //                       file = new File(filePath, fileName);
        //                      pageContext.writeDiagnostics(this,"File output server---->"+file+" file location "+fileLocation.getValue(pageContext),4);
        //                  }
        //               }
           
          
//            file = new File(filePath, fileName); 
//          pageContext.writeDiagnostics(this,"File output 1 ---->"+file,4);
          
         filePath = createDir(pageContext,filePath,fileName).toString();
         
             pageContext.writeDiagnostics(this,"filePath output 1 ---->"+filePath,4);
          
         file = new File (filePath,fileName); 
         
             pageContext.writeDiagnostics(this,"File output 2 ---->"+file,4);
             
             if(file.exists()) 
             {
             
                 pageContext.writeDiagnostics(this,"File output 3 ---->"+file,4);
                 
                 throw new OAException("File is already located.",OAException.ERROR);
             }

          output = new FileOutputStream(file);
          
          String path = file.toString();
          
          pageContext.writeDiagnostics(this," path "+path,4);
          
          pageContext.writeDiagnostics(this,"output----->"+output,4);
          
          input = uploadedByteStream.getInputStream();
            
          pageContext.writeDiagnostics(this,"input---->"+input,4);
          byte abyte0[] = new byte[0x19000];
          int i;
           
          while((i = input.read(abyte0)) > 0)
          output.write(abyte0, 0, i);

          output.close();
          input.close();
          
             int invId = 0;
                                if( pageContext.getParameter("invoiceId") != null) 
                                {
                                    invId = Integer.parseInt(invoiceId) ;
                                }
                       
             CallableStatement insertReq = 
                  getOADBTransaction().createCallableStatement("begin xx4i_file_upload_pkg.insert_data(:1,:2,:3,:4,:5); end;", 
                                                                        OADBTransaction.DEFAULT);
              
              try {
                  insertReq.setInt(1,invId);
                  insertReq.setString(2,path);
                  insertReq.setString(3,fileName);
                  insertReq.setString(4,productCode);
                  insertReq.setString(5,transNum);
                  insertReq.execute();
                  insertReq.close();
              
              }
              catch (Exception e) {
                  throw new OAException("insert procedure error   " + e, 
                                        OAException.ERROR);
              }            
                                
         }
         else
         {
        
                 throw new OAException("Please Select a File to Upload", OAException.ERROR);
         }
        }
     catch(Exception ex)
     {
      throw new OAException(" Attachement insert error -->"+ex.getMessage(), OAException.ERROR);
     }    
    }

    public File createDir(OAPageContext pageContext,String filePath, String fileName){
        
        fileName = getFileName(pageContext,fileName);
        
        String directoryName = filePath;
   
        pageContext.writeDiagnostics(this," directory name "+directoryName,4);

        File directory = new File(directoryName);
        if (! directory.exists()){
        
        
            pageContext.writeDiagnostics(this," create directoy "+directoryName,4);
            directory.mkdirs();
            // If you require it to make the entire directory path including parents,
            // use directory.mkdirs(); here instead.
        }

     return directory;
       
    }
    
    public String getFileName(OAPageContext pageContext,String s)
    {
        String s1 = null;
      int i = s.lastIndexOf(".");
 
 
        pageContext.writeDiagnostics(this," string "+s+" index of . -->"+i+" lenght of string "+s.length(),4); 
        
      if (i > 0 && i < s.length() - 1)

      {
         s1 = s.substring(0,i );
        
        System.out.println(" string s1 "+s1);
      }

    return s1;
    }


    /**Container's getter for FileLocationVO
     */
    public FileLocationVOImpl getFileLocationVO() {
        return (FileLocationVOImpl)findViewObject("FileLocationVO");
    }

    /**Container's getter for AttachVO
     */
    public AttachVOImpl getAttachVO() {
        return (AttachVOImpl)findViewObject("AttachVO");
    }
}
