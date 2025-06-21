package com.alimm.tanx.core.request;

/* loaded from: classes.dex */
public class TanxPlayerError extends com.alimm.tanx.core.request.TanxError {
    private int extra;
    private int what;

    public TanxPlayerError(java.lang.String str) {
        super(str);
    }

    public TanxPlayerError(java.lang.String str, int i, int i2) {
        this(str);
        this.what = i;
        this.extra = i2;
    }

    public TanxPlayerError(java.lang.String str, java.lang.String str2) {
        super(str, str2);
    }

    @Override // com.alimm.tanx.core.request.TanxError, java.lang.Throwable
    public java.lang.String toString() {
        return "TanxPlayerError : what->" + this.what + "  extra -> " + this.extra + "  message-> " + getMessage();
    }
}
