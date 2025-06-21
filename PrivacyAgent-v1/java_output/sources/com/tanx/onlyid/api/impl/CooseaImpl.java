package com.tanx.onlyid.api.impl;

/* loaded from: classes19.dex */
public class CooseaImpl implements com.tanx.onlyid.api.IOAID {
    public final android.content.Context a;
    public final android.app.KeyguardManager b;

    public CooseaImpl(android.content.Context context) {
        this.a = context;
        this.b = (android.app.KeyguardManager) context.getSystemService("keyguard");
    }

    @Override // com.tanx.onlyid.api.IOAID
    public void doGet(com.tanx.onlyid.api.IGetter iGetter) {
        if (this.a == null || iGetter == null) {
            return;
        }
        android.app.KeyguardManager keyguardManager = this.b;
        if (keyguardManager == null) {
            iGetter.oaidError(new com.tanx.onlyid.api.OAIDException("KeyguardManager not found"));
            return;
        }
        try {
            java.lang.Object invoke = keyguardManager.getClass().getDeclaredMethod("obtainOaid", new java.lang.Class[0]).invoke(this.b, new java.lang.Object[0]);
            if (invoke == null) {
                throw new com.tanx.onlyid.api.OAIDException("OAID obtain failed");
            }
            java.lang.String obj = invoke.toString();
            com.tanx.onlyid.api.OAIDLog.print("OAID obtain success: " + obj);
            iGetter.oaidSucc(obj);
        } catch (java.lang.Exception e) {
            com.tanx.onlyid.api.OAIDLog.print(e);
        }
    }

    @Override // com.tanx.onlyid.api.IOAID
    public boolean supported() {
        android.app.KeyguardManager keyguardManager;
        if (this.a == null || (keyguardManager = this.b) == null) {
            return false;
        }
        try {
            java.lang.Object invoke = keyguardManager.getClass().getDeclaredMethod("isSupported", new java.lang.Class[0]).invoke(this.b, new java.lang.Object[0]);
            java.util.Objects.requireNonNull(invoke);
            return ((java.lang.Boolean) invoke).booleanValue();
        } catch (java.lang.Exception e) {
            com.tanx.onlyid.api.OAIDLog.print(e);
            return false;
        }
    }
}
