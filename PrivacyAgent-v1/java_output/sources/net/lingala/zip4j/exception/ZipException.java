package net.lingala.zip4j.exception;

/* loaded from: classes23.dex */
public class ZipException extends java.lang.Exception {
    private static final long serialVersionUID = 1;
    private int code;

    public ZipException() {
        this.code = -1;
    }

    public ZipException(java.lang.String str) {
        super(str);
        this.code = -1;
    }

    public ZipException(java.lang.String str, int i) {
        super(str);
        this.code = i;
    }

    public ZipException(java.lang.String str, java.lang.Throwable th) {
        super(str, th);
        this.code = -1;
    }

    public ZipException(java.lang.String str, java.lang.Throwable th, int i) {
        super(str, th);
        this.code = i;
    }

    public ZipException(java.lang.Throwable th) {
        super(th);
        this.code = -1;
    }

    public ZipException(java.lang.Throwable th, int i) {
        super(th);
        this.code = i;
    }

    public int getCode() {
        return this.code;
    }
}
