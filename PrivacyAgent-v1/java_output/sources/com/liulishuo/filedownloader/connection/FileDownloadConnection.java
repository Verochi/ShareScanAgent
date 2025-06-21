package com.liulishuo.filedownloader.connection;

/* loaded from: classes23.dex */
public interface FileDownloadConnection {
    public static final int NO_RESPONSE_CODE = 0;
    public static final int RESPONSE_CODE_FROM_OFFSET = 1;

    void addHeader(java.lang.String str, java.lang.String str2);

    boolean dispatchAddResumeOffset(java.lang.String str, long j);

    void ending();

    void execute() throws java.io.IOException;

    java.io.InputStream getInputStream() throws java.io.IOException;

    java.util.Map<java.lang.String, java.util.List<java.lang.String>> getRequestHeaderFields();

    int getResponseCode() throws java.io.IOException;

    java.lang.String getResponseHeaderField(java.lang.String str);

    java.util.Map<java.lang.String, java.util.List<java.lang.String>> getResponseHeaderFields();

    boolean setRequestMethod(java.lang.String str) throws java.net.ProtocolException;
}
