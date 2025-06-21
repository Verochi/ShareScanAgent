package org.apache.tools.ant.taskdefs.cvslib;

/* loaded from: classes25.dex */
public class CVSEntry {
    public java.util.Date a;
    public java.lang.String b;
    public final java.lang.String c;
    public final java.util.Vector d = new java.util.Vector();

    public CVSEntry(java.util.Date date, java.lang.String str, java.lang.String str2) {
        this.a = date;
        this.b = str;
        this.c = str2;
    }

    public void addFile(java.lang.String str, java.lang.String str2) {
        this.d.addElement(new org.apache.tools.ant.taskdefs.cvslib.RCSFile(str, str2));
    }

    public void addFile(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        this.d.addElement(new org.apache.tools.ant.taskdefs.cvslib.RCSFile(str, str2, str3));
    }

    public java.lang.String getAuthor() {
        return this.b;
    }

    public java.lang.String getComment() {
        return this.c;
    }

    public java.util.Date getDate() {
        return this.a;
    }

    public java.util.Vector getFiles() {
        return this.d;
    }

    public void setAuthor(java.lang.String str) {
        this.b = str;
    }

    public java.lang.String toString() {
        return getAuthor() + "\n" + getDate() + "\n" + getFiles() + "\n" + getComment();
    }
}
