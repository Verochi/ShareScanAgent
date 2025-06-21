package org.apache.tools.ant.types.spi;

/* loaded from: classes26.dex */
public class Provider extends org.apache.tools.ant.ProjectComponent {
    public java.lang.String n;

    public void check() {
        java.lang.String str = this.n;
        if (str == null) {
            throw new org.apache.tools.ant.BuildException("classname attribute must be set for provider element", getLocation());
        }
        if (str.length() == 0) {
            throw new org.apache.tools.ant.BuildException("Invalid empty classname", getLocation());
        }
    }

    public java.lang.String getClassName() {
        return this.n;
    }

    public void setClassName(java.lang.String str) {
        this.n = str;
    }
}
