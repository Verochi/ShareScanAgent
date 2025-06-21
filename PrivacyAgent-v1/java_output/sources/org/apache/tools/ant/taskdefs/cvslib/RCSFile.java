package org.apache.tools.ant.taskdefs.cvslib;

/* loaded from: classes25.dex */
class RCSFile {
    public java.lang.String a;
    public java.lang.String b;
    public java.lang.String c;

    public RCSFile(java.lang.String str, java.lang.String str2) {
        this(str, str2, null);
    }

    public RCSFile(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        this.a = str;
        this.b = str2;
        if (str2.equals(str3)) {
            return;
        }
        this.c = str3;
    }

    public java.lang.String a() {
        return this.a;
    }

    public java.lang.String b() {
        return this.c;
    }

    public java.lang.String c() {
        return this.b;
    }
}
