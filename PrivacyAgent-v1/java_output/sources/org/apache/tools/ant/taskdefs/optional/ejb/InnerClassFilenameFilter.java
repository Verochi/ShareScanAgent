package org.apache.tools.ant.taskdefs.optional.ejb;

/* loaded from: classes25.dex */
public class InnerClassFilenameFilter implements java.io.FilenameFilter {
    public java.lang.String a;

    public InnerClassFilenameFilter(java.lang.String str) {
        int lastIndexOf = str.lastIndexOf(".class");
        this.a = str.substring(0, lastIndexOf == -1 ? str.length() - 1 : lastIndexOf);
    }

    @Override // java.io.FilenameFilter
    public boolean accept(java.io.File file, java.lang.String str) {
        if (str.lastIndexOf(".") != str.lastIndexOf(".class")) {
            return false;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(this.a);
        sb.append("$");
        return str.indexOf(sb.toString()) == 0;
    }
}
