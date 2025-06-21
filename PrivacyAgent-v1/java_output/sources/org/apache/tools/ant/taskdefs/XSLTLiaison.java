package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public interface XSLTLiaison {
    public static final java.lang.String FILE_PROTOCOL_PREFIX = "file://";

    void addParam(java.lang.String str, java.lang.String str2) throws java.lang.Exception;

    void setStylesheet(java.io.File file) throws java.lang.Exception;

    void transform(java.io.File file, java.io.File file2) throws java.lang.Exception;
}
