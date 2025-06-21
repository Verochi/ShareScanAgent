package org.apache.tools.ant.taskdefs.cvslib;

/* loaded from: classes25.dex */
public class CvsTagEntry {
    public java.lang.String a;
    public java.lang.String b;
    public java.lang.String c;

    public CvsTagEntry(java.lang.String str) {
        this(str, null, null);
    }

    public CvsTagEntry(java.lang.String str, java.lang.String str2) {
        this(str, str2, null);
    }

    public CvsTagEntry(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        this.a = str;
        this.c = str2;
        this.b = str3;
    }

    public java.lang.String getFile() {
        return this.a;
    }

    public java.lang.String getPreviousRevision() {
        return this.b;
    }

    public java.lang.String getRevision() {
        return this.c;
    }

    public java.lang.String toString() {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        stringBuffer.append(this.a);
        if (this.c == null) {
            stringBuffer.append(" was removed");
            if (this.b != null) {
                stringBuffer.append("; previous revision was ");
                stringBuffer.append(this.b);
            }
        } else if (this.b == null) {
            stringBuffer.append(" is new; current revision is ");
            stringBuffer.append(this.c);
        } else {
            stringBuffer.append(" has changed from ");
            stringBuffer.append(this.b);
            stringBuffer.append(" to ");
            stringBuffer.append(this.c);
        }
        return stringBuffer.toString();
    }
}
