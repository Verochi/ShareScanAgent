package org.apache.tools.ant;

/* loaded from: classes25.dex */
public class ExitException extends java.lang.SecurityException {
    private static final long serialVersionUID = 2772487854280543363L;
    private int status;

    public ExitException(int i) {
        super("ExitException: status " + i);
        this.status = i;
    }

    public ExitException(java.lang.String str, int i) {
        super(str);
        this.status = i;
    }

    public int getStatus() {
        return this.status;
    }
}
