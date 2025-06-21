package com.tanx.onlyid.api.impl;

/* loaded from: classes19.dex */
class XiaomiImpl implements com.tanx.onlyid.api.IOAID {
    public final android.content.Context a;
    public java.lang.Class<?> b;
    public java.lang.Object c;

    @android.annotation.SuppressLint({"PrivateApi"})
    public XiaomiImpl(android.content.Context context) {
        this.a = context;
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("com.android.id.impl.IdProviderImpl");
            this.b = cls;
            this.c = cls.newInstance();
        } catch (java.lang.Exception e) {
            com.tanx.onlyid.api.OAIDLog.print(e);
        }
    }

    public final java.lang.String a() throws java.lang.NoSuchMethodException, java.lang.reflect.InvocationTargetException, java.lang.IllegalAccessException {
        return (java.lang.String) this.b.getMethod("getOAID", android.content.Context.class).invoke(this.c, this.a);
    }

    @Override // com.tanx.onlyid.api.IOAID
    public void doGet(com.tanx.onlyid.api.IGetter iGetter) {
        if (this.a == null || iGetter == null) {
            return;
        }
        if (this.b == null || this.c == null) {
            iGetter.oaidError(new com.tanx.onlyid.api.OAIDException("Xiaomi IdProvider not exists"));
            return;
        }
        try {
            java.lang.String a = a();
            if (a == null || a.length() == 0) {
                throw new com.tanx.onlyid.api.OAIDException("OAID query failed");
            }
            com.tanx.onlyid.api.OAIDLog.print("OAID query success: " + a);
            iGetter.oaidSucc(a);
        } catch (java.lang.Exception e) {
            com.tanx.onlyid.api.OAIDLog.print(e);
            iGetter.oaidError(e);
        }
    }

    @Override // com.tanx.onlyid.api.IOAID
    public boolean supported() {
        return this.c != null;
    }
}
