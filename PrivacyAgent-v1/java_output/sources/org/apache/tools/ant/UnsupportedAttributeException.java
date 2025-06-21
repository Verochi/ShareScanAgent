package org.apache.tools.ant;

/* loaded from: classes25.dex */
public class UnsupportedAttributeException extends org.apache.tools.ant.BuildException {
    private static final long serialVersionUID = 1;
    private final java.lang.String attribute;

    public UnsupportedAttributeException(java.lang.String str, java.lang.String str2) {
        super(str);
        this.attribute = str2;
    }

    public java.lang.String getAttribute() {
        return this.attribute;
    }
}
