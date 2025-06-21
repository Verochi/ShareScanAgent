package com.zx.a.I8b7;

/* loaded from: classes19.dex */
public class p3 implements com.zx.module.base.Listener {
    public final /* synthetic */ com.zx.module.base.Listener a;
    public final /* synthetic */ com.zx.a.I8b7.t3 b;

    public p3(com.zx.a.I8b7.t3 t3Var, com.zx.module.base.Listener listener) {
        this.b = t3Var;
        this.a = listener;
    }

    @Override // com.zx.module.base.Listener
    public void onMessage(java.lang.String str, java.lang.String str2) {
        if (str.equals("zxid") || str.equals("MESSAGE_ON_ZXID_RECEIVED")) {
            this.b.a.set(false);
        }
        this.a.onMessage(str, str2);
    }
}
