package com.alimm.tanx.core.net.okhttp.request;

/* loaded from: classes.dex */
public class MyRequestBody extends okhttp3.RequestBody {
    protected okhttp3.RequestBody tanxc_do;
    protected com.alimm.tanx.core.net.okhttp.request.MyRequestBody.tanxc_do tanxc_for;
    protected com.alimm.tanx.core.net.okhttp.request.MyRequestBody.Listener tanxc_if;

    public interface Listener {
        void onRequestProgress(long j, long j2);
    }

    public final class tanxc_do extends okio.ForwardingSink {
        private long tanxc_if;

        public tanxc_do(okio.Sink sink) {
            super(sink);
            this.tanxc_if = 0L;
        }

        @Override // okio.ForwardingSink, okio.Sink
        public void write(okio.Buffer buffer, long j) throws java.io.IOException {
            super.write(buffer, j);
            long j2 = this.tanxc_if + j;
            this.tanxc_if = j2;
            com.alimm.tanx.core.net.okhttp.request.MyRequestBody myRequestBody = com.alimm.tanx.core.net.okhttp.request.MyRequestBody.this;
            myRequestBody.tanxc_if.onRequestProgress(j2, myRequestBody.contentLength());
        }
    }

    @Override // okhttp3.RequestBody
    public long contentLength() {
        try {
            return this.tanxc_do.contentLength();
        } catch (java.io.IOException e) {
            e.printStackTrace();
            return -1L;
        }
    }

    @Override // okhttp3.RequestBody
    public okhttp3.MediaType contentType() {
        return this.tanxc_do.contentType();
    }

    @Override // okhttp3.RequestBody
    public void writeTo(okio.BufferedSink bufferedSink) throws java.io.IOException {
        com.alimm.tanx.core.net.okhttp.request.MyRequestBody.tanxc_do tanxc_doVar = new com.alimm.tanx.core.net.okhttp.request.MyRequestBody.tanxc_do(bufferedSink);
        this.tanxc_for = tanxc_doVar;
        okio.BufferedSink buffer = okio.Okio.buffer(tanxc_doVar);
        this.tanxc_do.writeTo(buffer);
        buffer.flush();
    }
}
