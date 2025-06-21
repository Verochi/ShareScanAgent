package org.json.alipay;

/* loaded from: classes26.dex */
public class JSONException extends java.lang.Exception {
    public java.lang.Throwable cause;

    public JSONException(java.lang.String str) {
        super(str);
    }

    public JSONException(java.lang.Throwable th) {
        super(th.getMessage());
        this.cause = th;
    }

    @Override // java.lang.Throwable
    public java.lang.Throwable getCause() {
        return this.cause;
    }
}
