package okhttp3.internal.http;

/* loaded from: classes24.dex */
public final class RealResponseBody extends okhttp3.ResponseBody {

    @javax.annotation.Nullable
    public final java.lang.String n;
    public final long t;
    public final okio.BufferedSource u;

    public RealResponseBody(@javax.annotation.Nullable java.lang.String str, long j, okio.BufferedSource bufferedSource) {
        this.n = str;
        this.t = j;
        this.u = bufferedSource;
    }

    @Override // okhttp3.ResponseBody
    public long contentLength() {
        return this.t;
    }

    @Override // okhttp3.ResponseBody
    public okhttp3.MediaType contentType() {
        java.lang.String str = this.n;
        if (str != null) {
            return okhttp3.MediaType.parse(str);
        }
        return null;
    }

    @Override // okhttp3.ResponseBody
    public okio.BufferedSource source() {
        return this.u;
    }
}
