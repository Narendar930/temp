package xxattach.oracle.apps.per.addatt.server;

import oracle.apps.fnd.framework.server.OAViewRowImpl;

import oracle.jbo.domain.Date;
import oracle.jbo.domain.Number;
import oracle.jbo.domain.RowID;
import oracle.jbo.server.AttributeDefImpl;

import xxattach.oracle.apps.per.addatt.schema.server.AttachEOImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class AttachVORowImpl extends OAViewRowImpl {
    public static final int UPLOADID = 0;
    public static final int INVOICEID = 1;
    public static final int FILEPATH = 2;
    public static final int FILEDESC = 3;
    public static final int FILENAME = 4;
    public static final int CATEGORY = 5;
    public static final int ATTRIBUTECATEGORY = 6;
    public static final int ATTRIBUTE1 = 7;
    public static final int ATTRIBUTE2 = 8;
    public static final int ATTRIBUTE3 = 9;
    public static final int ATTRIBUTE4 = 10;
    public static final int ATTRIBUTE5 = 11;
    public static final int ATTRIBUTE6 = 12;
    public static final int ATTRIBUTE7 = 13;
    public static final int ATTRIBUTE8 = 14;
    public static final int ATTRIBUTE9 = 15;
    public static final int ATTRIBUTE10 = 16;
    public static final int CREATEDBY = 17;
    public static final int CREATIONDATE = 18;
    public static final int LASTUPDATEDBY = 19;
    public static final int LASTUPDATEDATE = 20;
    public static final int LASTUPDATELOGIN = 21;
    public static final int ROWID = 22;
    public static final int TRANSACTIONNUM = 23;
    public static final int SNO = 24;
    public static final int DELETEFLAG = 25;

    /**This is the default constructor (do not remove)
     */
    public AttachVORowImpl() {
    }

    /**Gets AttachEO entity object.
     */
    public AttachEOImpl getAttachEO() {
        return (AttachEOImpl)getEntity(0);
    }

    /**Gets the attribute value for UPLOAD_ID using the alias name UploadId
     */
    public Number getUploadId() {
        return (Number) getAttributeInternal(UPLOADID);
    }

    /**Sets <code>value</code> as attribute value for UPLOAD_ID using the alias name UploadId
     */
    public void setUploadId(Number value) {
        setAttributeInternal(UPLOADID, value);
    }

    /**Gets the attribute value for INVOICE_ID using the alias name InvoiceId
     */
    public Number getInvoiceId() {
        return (Number) getAttributeInternal(INVOICEID);
    }

    /**Sets <code>value</code> as attribute value for INVOICE_ID using the alias name InvoiceId
     */
    public void setInvoiceId(Number value) {
        setAttributeInternal(INVOICEID, value);
    }

    /**Gets the attribute value for FILE_PATH using the alias name FilePath
     */
    public String getFilePath() {
        return (String) getAttributeInternal(FILEPATH);
    }

    /**Sets <code>value</code> as attribute value for FILE_PATH using the alias name FilePath
     */
    public void setFilePath(String value) {
        setAttributeInternal(FILEPATH, value);
    }

    /**Gets the attribute value for FILE_DESC using the alias name FileDesc
     */
    public String getFileDesc() {
        return (String) getAttributeInternal(FILEDESC);
    }

    /**Sets <code>value</code> as attribute value for FILE_DESC using the alias name FileDesc
     */
    public void setFileDesc(String value) {
        setAttributeInternal(FILEDESC, value);
    }

    /**Gets the attribute value for FILENAME using the alias name Filename
     */
    public String getFilename() {
        return (String) getAttributeInternal(FILENAME);
    }

    /**Sets <code>value</code> as attribute value for FILENAME using the alias name Filename
     */
    public void setFilename(String value) {
        setAttributeInternal(FILENAME, value);
    }

    /**Gets the attribute value for CATEGORY using the alias name Category
     */
    public String getCategory() {
        return (String) getAttributeInternal(CATEGORY);
    }

    /**Sets <code>value</code> as attribute value for CATEGORY using the alias name Category
     */
    public void setCategory(String value) {
        setAttributeInternal(CATEGORY, value);
    }

    /**Gets the attribute value for ATTRIBUTE_CATEGORY using the alias name AttributeCategory
     */
    public String getAttributeCategory() {
        return (String) getAttributeInternal(ATTRIBUTECATEGORY);
    }

    /**Sets <code>value</code> as attribute value for ATTRIBUTE_CATEGORY using the alias name AttributeCategory
     */
    public void setAttributeCategory(String value) {
        setAttributeInternal(ATTRIBUTECATEGORY, value);
    }

    /**Gets the attribute value for ATTRIBUTE1 using the alias name Attribute1
     */
    public String getAttribute1() {
        return (String) getAttributeInternal(ATTRIBUTE1);
    }

    /**Sets <code>value</code> as attribute value for ATTRIBUTE1 using the alias name Attribute1
     */
    public void setAttribute1(String value) {
        setAttributeInternal(ATTRIBUTE1, value);
    }

    /**Gets the attribute value for ATTRIBUTE2 using the alias name Attribute2
     */
    public String getAttribute2() {
        return (String) getAttributeInternal(ATTRIBUTE2);
    }

    /**Sets <code>value</code> as attribute value for ATTRIBUTE2 using the alias name Attribute2
     */
    public void setAttribute2(String value) {
        setAttributeInternal(ATTRIBUTE2, value);
    }

    /**Gets the attribute value for ATTRIBUTE3 using the alias name Attribute3
     */
    public String getAttribute3() {
        return (String) getAttributeInternal(ATTRIBUTE3);
    }

    /**Sets <code>value</code> as attribute value for ATTRIBUTE3 using the alias name Attribute3
     */
    public void setAttribute3(String value) {
        setAttributeInternal(ATTRIBUTE3, value);
    }

    /**Gets the attribute value for ATTRIBUTE4 using the alias name Attribute4
     */
    public String getAttribute4() {
        return (String) getAttributeInternal(ATTRIBUTE4);
    }

    /**Sets <code>value</code> as attribute value for ATTRIBUTE4 using the alias name Attribute4
     */
    public void setAttribute4(String value) {
        setAttributeInternal(ATTRIBUTE4, value);
    }

    /**Gets the attribute value for ATTRIBUTE5 using the alias name Attribute5
     */
    public String getAttribute5() {
        return (String) getAttributeInternal(ATTRIBUTE5);
    }

    /**Sets <code>value</code> as attribute value for ATTRIBUTE5 using the alias name Attribute5
     */
    public void setAttribute5(String value) {
        setAttributeInternal(ATTRIBUTE5, value);
    }

    /**Gets the attribute value for ATTRIBUTE6 using the alias name Attribute6
     */
    public String getAttribute6() {
        return (String) getAttributeInternal(ATTRIBUTE6);
    }

    /**Sets <code>value</code> as attribute value for ATTRIBUTE6 using the alias name Attribute6
     */
    public void setAttribute6(String value) {
        setAttributeInternal(ATTRIBUTE6, value);
    }

    /**Gets the attribute value for ATTRIBUTE7 using the alias name Attribute7
     */
    public String getAttribute7() {
        return (String) getAttributeInternal(ATTRIBUTE7);
    }

    /**Sets <code>value</code> as attribute value for ATTRIBUTE7 using the alias name Attribute7
     */
    public void setAttribute7(String value) {
        setAttributeInternal(ATTRIBUTE7, value);
    }

    /**Gets the attribute value for ATTRIBUTE8 using the alias name Attribute8
     */
    public String getAttribute8() {
        return (String) getAttributeInternal(ATTRIBUTE8);
    }

    /**Sets <code>value</code> as attribute value for ATTRIBUTE8 using the alias name Attribute8
     */
    public void setAttribute8(String value) {
        setAttributeInternal(ATTRIBUTE8, value);
    }

    /**Gets the attribute value for ATTRIBUTE9 using the alias name Attribute9
     */
    public String getAttribute9() {
        return (String) getAttributeInternal(ATTRIBUTE9);
    }

    /**Sets <code>value</code> as attribute value for ATTRIBUTE9 using the alias name Attribute9
     */
    public void setAttribute9(String value) {
        setAttributeInternal(ATTRIBUTE9, value);
    }

    /**Gets the attribute value for ATTRIBUTE10 using the alias name Attribute10
     */
    public String getAttribute10() {
        return (String) getAttributeInternal(ATTRIBUTE10);
    }

    /**Sets <code>value</code> as attribute value for ATTRIBUTE10 using the alias name Attribute10
     */
    public void setAttribute10(String value) {
        setAttributeInternal(ATTRIBUTE10, value);
    }

    /**Gets the attribute value for CREATED_BY using the alias name CreatedBy
     */
    public Number getCreatedBy() {
        return (Number) getAttributeInternal(CREATEDBY);
    }

    /**Sets <code>value</code> as attribute value for CREATED_BY using the alias name CreatedBy
     */
    public void setCreatedBy(Number value) {
        setAttributeInternal(CREATEDBY, value);
    }

    /**Gets the attribute value for CREATION_DATE using the alias name CreationDate
     */
    public Date getCreationDate() {
        return (Date) getAttributeInternal(CREATIONDATE);
    }

    /**Sets <code>value</code> as attribute value for CREATION_DATE using the alias name CreationDate
     */
    public void setCreationDate(Date value) {
        setAttributeInternal(CREATIONDATE, value);
    }

    /**Gets the attribute value for LAST_UPDATED_BY using the alias name LastUpdatedBy
     */
    public Number getLastUpdatedBy() {
        return (Number) getAttributeInternal(LASTUPDATEDBY);
    }

    /**Sets <code>value</code> as attribute value for LAST_UPDATED_BY using the alias name LastUpdatedBy
     */
    public void setLastUpdatedBy(Number value) {
        setAttributeInternal(LASTUPDATEDBY, value);
    }

    /**Gets the attribute value for LAST_UPDATE_DATE using the alias name LastUpdateDate
     */
    public Date getLastUpdateDate() {
        return (Date) getAttributeInternal(LASTUPDATEDATE);
    }

    /**Sets <code>value</code> as attribute value for LAST_UPDATE_DATE using the alias name LastUpdateDate
     */
    public void setLastUpdateDate(Date value) {
        setAttributeInternal(LASTUPDATEDATE, value);
    }

    /**Gets the attribute value for LAST_UPDATE_LOGIN using the alias name LastUpdateLogin
     */
    public Number getLastUpdateLogin() {
        return (Number) getAttributeInternal(LASTUPDATELOGIN);
    }

    /**Sets <code>value</code> as attribute value for LAST_UPDATE_LOGIN using the alias name LastUpdateLogin
     */
    public void setLastUpdateLogin(Number value) {
        setAttributeInternal(LASTUPDATELOGIN, value);
    }

    /**Gets the attribute value for ROWID using the alias name RowID
     */
    public RowID getRowID() {
        return (RowID) getAttributeInternal(ROWID);
    }

    /**Gets the attribute value for TRANSACTION_NUM using the alias name TransactionNum
     */
    public String getTransactionNum() {
        return (String) getAttributeInternal(TRANSACTIONNUM);
    }

    /**Sets <code>value</code> as attribute value for TRANSACTION_NUM using the alias name TransactionNum
     */
    public void setTransactionNum(String value) {
        setAttributeInternal(TRANSACTIONNUM, value);
    }

    /**Gets the attribute value for the calculated attribute Sno
     */
    public String getSno() {
        return (String) getAttributeInternal(SNO);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute Sno
     */
    public void setSno(String value) {
        setAttributeInternal(SNO, value);
    }

    /**Gets the attribute value for the calculated attribute DeleteFlag
     */
    public String getDeleteFlag() {
        return (String) getAttributeInternal(DELETEFLAG);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute DeleteFlag
     */
    public void setDeleteFlag(String value) {
        setAttributeInternal(DELETEFLAG, value);
    }

    /**getAttrInvokeAccessor: generated method. Do not modify.
     */
    protected Object getAttrInvokeAccessor(int index, 
                                           AttributeDefImpl attrDef) throws Exception {
        switch (index) {
        case UPLOADID:
            return getUploadId();
        case INVOICEID:
            return getInvoiceId();
        case FILEPATH:
            return getFilePath();
        case FILEDESC:
            return getFileDesc();
        case FILENAME:
            return getFilename();
        case CATEGORY:
            return getCategory();
        case ATTRIBUTECATEGORY:
            return getAttributeCategory();
        case ATTRIBUTE1:
            return getAttribute1();
        case ATTRIBUTE2:
            return getAttribute2();
        case ATTRIBUTE3:
            return getAttribute3();
        case ATTRIBUTE4:
            return getAttribute4();
        case ATTRIBUTE5:
            return getAttribute5();
        case ATTRIBUTE6:
            return getAttribute6();
        case ATTRIBUTE7:
            return getAttribute7();
        case ATTRIBUTE8:
            return getAttribute8();
        case ATTRIBUTE9:
            return getAttribute9();
        case ATTRIBUTE10:
            return getAttribute10();
        case CREATEDBY:
            return getCreatedBy();
        case CREATIONDATE:
            return getCreationDate();
        case LASTUPDATEDBY:
            return getLastUpdatedBy();
        case LASTUPDATEDATE:
            return getLastUpdateDate();
        case LASTUPDATELOGIN:
            return getLastUpdateLogin();
        case ROWID:
            return getRowID();
        case TRANSACTIONNUM:
            return getTransactionNum();
        case SNO:
            return getSno();
        case DELETEFLAG:
            return getDeleteFlag();
        default:
            return super.getAttrInvokeAccessor(index, attrDef);
        }
    }

    /**setAttrInvokeAccessor: generated method. Do not modify.
     */
    protected void setAttrInvokeAccessor(int index, Object value, 
                                         AttributeDefImpl attrDef) throws Exception {
        switch (index) {
        case UPLOADID:
            setUploadId((Number)value);
            return;
        case INVOICEID:
            setInvoiceId((Number)value);
            return;
        case FILEPATH:
            setFilePath((String)value);
            return;
        case FILEDESC:
            setFileDesc((String)value);
            return;
        case FILENAME:
            setFilename((String)value);
            return;
        case CATEGORY:
            setCategory((String)value);
            return;
        case ATTRIBUTECATEGORY:
            setAttributeCategory((String)value);
            return;
        case ATTRIBUTE1:
            setAttribute1((String)value);
            return;
        case ATTRIBUTE2:
            setAttribute2((String)value);
            return;
        case ATTRIBUTE3:
            setAttribute3((String)value);
            return;
        case ATTRIBUTE4:
            setAttribute4((String)value);
            return;
        case ATTRIBUTE5:
            setAttribute5((String)value);
            return;
        case ATTRIBUTE6:
            setAttribute6((String)value);
            return;
        case ATTRIBUTE7:
            setAttribute7((String)value);
            return;
        case ATTRIBUTE8:
            setAttribute8((String)value);
            return;
        case ATTRIBUTE9:
            setAttribute9((String)value);
            return;
        case ATTRIBUTE10:
            setAttribute10((String)value);
            return;
        case CREATEDBY:
            setCreatedBy((Number)value);
            return;
        case CREATIONDATE:
            setCreationDate((Date)value);
            return;
        case LASTUPDATEDBY:
            setLastUpdatedBy((Number)value);
            return;
        case LASTUPDATEDATE:
            setLastUpdateDate((Date)value);
            return;
        case LASTUPDATELOGIN:
            setLastUpdateLogin((Number)value);
            return;
        case TRANSACTIONNUM:
            setTransactionNum((String)value);
            return;
        case SNO:
            setSno((String)value);
            return;
        case DELETEFLAG:
            setDeleteFlag((String)value);
            return;
        default:
            super.setAttrInvokeAccessor(index, value, attrDef);
            return;
        }
    }
}
