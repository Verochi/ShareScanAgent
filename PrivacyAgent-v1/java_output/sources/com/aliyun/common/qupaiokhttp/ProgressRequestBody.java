package com.aliyun.common.qupaiokhttp;

/* loaded from: classes.dex */
class ProgressRequestBody extends okhttp3.RequestBody {
    protected com.aliyun.common.qupaiokhttp.ProgressCallback callback;
    protected com.aliyun.common.qupaiokhttp.ProgressRequestBody.CountingSink countingSink;
    protected okhttp3.RequestBody delegate;
    private long previousTime;

    public final class CountingSink extends okio.ForwardingSink {
        private long bytesWritten;
        long contentLength;

        public CountingSink(okio.Sink sink) {
            super(sink);
            this.bytesWritten = 0L;
            this.contentLength = 0L;
        }

        @Override // okio.ForwardingSink, okio.Sink
        public void write(okio.Buffer buffer, long j) throws java.io.IOException {
            super.write(buffer, j);
            if (this.contentLength == 0) {
                this.contentLength = com.aliyun.common.qupaiokhttp.ProgressRequestBody.this.contentLength();
            }
            this.bytesWritten += j;
            if (com.aliyun.common.qupaiokhttp.ProgressRequestBody.this.callback != null) {
                long currentTimeMillis = (java.lang.System.currentTimeMillis() - com.aliyun.common.qupaiokhttp.ProgressRequestBody.this.previousTime) / 1000;
                if (currentTimeMillis == 0) {
                    currentTimeMillis++;
                }
                long j2 = this.bytesWritten;
                long j3 = j2 / currentTimeMillis;
                long j4 = this.contentLength;
                com.aliyun.common.qupaiokhttp.ProgressRequestBody.this.callback.updateProgress((int) ((100 * j2) / j4), j3, j2 == j4);
            }
        }
    }

    public ProgressRequestBody(okhttp3.RequestBody requestBody, com.aliyun.common.qupaiokhttp.ProgressCallback progressCallback) {
        this.delegate = requestBody;
        this.callback = progressCallback;
    }

    @Override // okhttp3.RequestBody
    public long contentLength() {
        try {
            return this.delegate.contentLength();
        } catch (java.io.IOException e) {
            e.printStackTrace();
            return -1L;
        }
    }

    @Override // okhttp3.RequestBody
    public okhttp3.MediaType contentType() {
        return this.delegate.contentType();
    }

    @Override // okhttp3.RequestBody
    public void writeTo(okio.BufferedSink bufferedSink) throws java.io.IOException {
        this.previousTime = java.lang.System.currentTimeMillis();
        com.aliyun.common.qupaiokhttp.ProgressRequestBody.CountingSink countingSink = new com.aliyun.common.qupaiokhttp.ProgressRequestBody.CountingSink(bufferedSink);
        this.countingSink = countingSink;
        okio.BufferedSink buffer = okio.Okio.buffer(countingSink);
        this.delegate.writeTo(buffer);
        buffer.flush();
    }
}
