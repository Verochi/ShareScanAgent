package org.apache.tools.ant;

/* loaded from: classes25.dex */
public class UnsupportedElementException extends org.apache.tools.ant.BuildException {
    private static final long serialVersionUID = 1;
    private final java.lang.String element;

    public UnsupportedElementException(java.lang.String str, java.lang.String str2) {
        super(str);
        this.element = str2;
    }

    public java.lang.String getElement() {
        return this.element;
    }
}
