package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public interface ExecuteStreamHandler {
    void setProcessErrorStream(java.io.InputStream inputStream) throws java.io.IOException;

    void setProcessInputStream(java.io.OutputStream outputStream) throws java.io.IOException;

    void setProcessOutputStream(java.io.InputStream inputStream) throws java.io.IOException;

    void start() throws java.io.IOException;

    void stop();
}
