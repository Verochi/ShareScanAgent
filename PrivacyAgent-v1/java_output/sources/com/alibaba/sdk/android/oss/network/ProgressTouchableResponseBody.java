package com.alibaba.sdk.android.oss.network;

/* loaded from: classes.dex */
public class ProgressTouchableResponseBody<T extends com.alibaba.sdk.android.oss.model.OSSRequest> extends okhttp3.ResponseBody {
    private okio.BufferedSource mBufferedSource;
    private com.alibaba.sdk.android.oss.callback.OSSProgressCallback mProgressListener;
    private final okhttp3.ResponseBody mResponseBody;
    private T request;

    /* renamed from: com.alibaba.sdk.android.oss.network.ProgressTouchableResponseBody$1, reason: invalid class name */
    public class AnonymousClass1 extends okio.ForwardingSource {
        private long totalBytesRead;

        public AnonymousClass1(okio.Source source) {
            super(source);
            this.totalBytesRead = 0L;
        }

        @Override // okio.ForwardingSource, okio.Source
        public long read(okio.Buffer buffer, long j) throws java.io.IOException {
            long read = super.read(buffer, j);
            this.totalBytesRead += read != -1 ? read : 0L;
            if (com.alibaba.sdk.android.oss.network.ProgressTouchableResponseBody.this.mProgressListener != null && read != -1 && this.totalBytesRead != 0) {
                com.alibaba.sdk.android.oss.network.ProgressTouchableResponseBody.this.mProgressListener.onProgress(com.alibaba.sdk.android.oss.network.ProgressTouchableResponseBody.this.request, this.totalBytesRead, com.alibaba.sdk.android.oss.network.ProgressTouchableResponseBody.this.mResponseBody.contentLength());
            }
            return read;
        }
    }

    public ProgressTouchableResponseBody(okhttp3.ResponseBody responseBody, com.alibaba.sdk.android.oss.network.ExecutionContext executionContext) {
        this.mResponseBody = responseBody;
        this.mProgressListener = executionContext.getProgressCallback();
        this.request = (T) executionContext.getRequest();
    }

    private okio.Source source(okio.Source source) {
        return new com.alibaba.sdk.android.oss.network.ProgressTouchableResponseBody.AnonymousClass1(source);
    }

    @Override // okhttp3.ResponseBody
    public long contentLength() {
        return this.mResponseBody.contentLength();
    }

    @Override // okhttp3.ResponseBody
    public okhttp3.MediaType contentType() {
        return this.mResponseBody.contentType();
    }

    @Override // okhttp3.ResponseBody
    public okio.BufferedSource source() {
        if (this.mBufferedSource == null) {
            this.mBufferedSource = okio.Okio.buffer(source(this.mResponseBody.source()));
        }
        return this.mBufferedSource;
    }
}
