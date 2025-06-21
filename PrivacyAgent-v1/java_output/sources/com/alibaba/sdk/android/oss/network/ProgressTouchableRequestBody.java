package com.alibaba.sdk.android.oss.network;

/* loaded from: classes.dex */
public class ProgressTouchableRequestBody<T extends com.alibaba.sdk.android.oss.model.OSSRequest> extends okhttp3.RequestBody {
    private static final int SEGMENT_SIZE = 2048;
    private com.alibaba.sdk.android.oss.callback.OSSProgressCallback callback;
    private long contentLength;
    private java.lang.String contentType;
    private java.io.InputStream inputStream;
    private T request;

    public ProgressTouchableRequestBody(java.io.InputStream inputStream, long j, java.lang.String str, com.alibaba.sdk.android.oss.network.ExecutionContext executionContext) {
        this.inputStream = inputStream;
        this.contentType = str;
        this.contentLength = j;
        this.callback = executionContext.getProgressCallback();
        this.request = (T) executionContext.getRequest();
    }

    @Override // okhttp3.RequestBody
    public long contentLength() throws java.io.IOException {
        return this.contentLength;
    }

    @Override // okhttp3.RequestBody
    public okhttp3.MediaType contentType() {
        return okhttp3.MediaType.parse(this.contentType);
    }

    @Override // okhttp3.RequestBody
    public void writeTo(okio.BufferedSink bufferedSink) throws java.io.IOException {
        okio.Source source = okio.Okio.source(this.inputStream);
        long j = 0;
        while (true) {
            long j2 = this.contentLength;
            if (j >= j2) {
                break;
            }
            long read = source.read(bufferedSink.buffer(), java.lang.Math.min(j2 - j, 2048L));
            if (read == -1) {
                break;
            }
            j += read;
            bufferedSink.flush();
            com.alibaba.sdk.android.oss.callback.OSSProgressCallback oSSProgressCallback = this.callback;
            if (oSSProgressCallback != null && j != 0) {
                oSSProgressCallback.onProgress(this.request, j, this.contentLength);
            }
        }
        if (source != null) {
            source.close();
        }
    }
}
