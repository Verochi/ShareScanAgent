package org.apache.tools.ant.util.facade;

/* loaded from: classes26.dex */
public class ImplementationSpecificArgument extends org.apache.tools.ant.types.Commandline.Argument {
    public java.lang.String v;

    public final java.lang.String[] getParts(java.lang.String str) {
        java.lang.String str2 = this.v;
        return (str2 == null || str2.equals(str)) ? super.getParts() : new java.lang.String[0];
    }

    public void setImplementation(java.lang.String str) {
        this.v = str;
    }
}
