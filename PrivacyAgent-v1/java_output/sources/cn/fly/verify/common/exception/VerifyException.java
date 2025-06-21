package cn.fly.verify.common.exception;

/* loaded from: classes.dex */
public class VerifyException extends java.lang.Exception {
    protected int code;
    private java.lang.String extraDesc;
    private java.lang.String message;
    private java.lang.String operatorCode;
    private java.lang.String serialId;

    public VerifyException(int i, java.lang.String str) {
        super(str);
        this.message = str;
        this.code = i;
    }

    @java.lang.Deprecated
    public VerifyException(int i, java.lang.String str, java.lang.Throwable th) {
        super(str, th);
        this.message = str;
        this.code = i;
    }

    public VerifyException(cn.fly.verify.common.exception.VerifyErr verifyErr) {
        super(verifyErr.getMessage());
        this.message = verifyErr.getMessage();
        this.code = verifyErr.getCode();
    }

    @java.lang.Deprecated
    public VerifyException(cn.fly.verify.common.exception.VerifyErr verifyErr, java.lang.Throwable th) {
        super(verifyErr.getMessage(), th);
        this.message = verifyErr.getMessage();
        this.code = verifyErr.getCode();
    }

    @java.lang.Deprecated
    public VerifyException(java.lang.Throwable th) {
        super(th);
    }

    public int getCode() {
        return this.code;
    }

    public java.lang.String getExtraDesc() {
        return this.extraDesc;
    }

    public java.lang.String getOperatorCode() {
        return this.operatorCode;
    }

    public java.lang.String getSerialId() {
        return this.serialId;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public void setExtraDesc(java.lang.String str) {
        this.extraDesc = str;
        setMessage(this.message + ": " + str);
    }

    public void setMessage(java.lang.String str) {
        this.message = str;
        try {
            cn.fly.verify.fp.b(this, "detailMessage", str);
        } catch (java.lang.Throwable unused) {
        }
    }

    public void setOperatorCode(java.lang.String str) {
        this.operatorCode = str;
    }

    public void setSerialId(java.lang.String str) {
        this.serialId = str;
    }

    @Override // java.lang.Throwable
    public java.lang.String toString() {
        return "{\"code\": " + this.code + ", \"message\": \"" + getMessage() + ", \"operatorCode\": \"" + this.operatorCode + "\", \"serialId\":\"" + this.serialId + "\"}";
    }
}
