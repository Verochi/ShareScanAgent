package com.igexin.base.api;

/* loaded from: classes22.dex */
public class SharedPreferencesManager implements com.igexin.base.b.a {
    private static android.content.Context mContext;
    private static final java.util.Map<java.lang.String, com.igexin.base.api.SharedPreferencesManager> spMap = new java.util.concurrent.ConcurrentHashMap();
    private com.igexin.base.b.a mBase;

    private SharedPreferencesManager(java.lang.String str) {
        checkContext();
        this.mBase = new com.igexin.base.b.b(mContext, str);
    }

    private void checkContext() {
        if (mContext == null) {
            android.content.Context findAppContext = com.igexin.base.util.InvokeUtil.findAppContext();
            mContext = findAppContext;
            findAppContext.getClass();
        }
    }

    public static com.igexin.base.api.SharedPreferencesManager get(java.lang.String str) {
        java.util.Map<java.lang.String, com.igexin.base.api.SharedPreferencesManager> map = spMap;
        if (map.get(str) == null) {
            map.put(str, new com.igexin.base.api.SharedPreferencesManager(str));
        }
        return map.get(str);
    }

    public static void init(android.content.Context context) {
        mContext = context.getApplicationContext();
    }

    @Override // com.igexin.base.b.a
    public java.lang.Object getParam(java.lang.String str, java.lang.Object obj) {
        return this.mBase.getParam(str, obj);
    }

    @Override // com.igexin.base.b.a
    public boolean remove(java.lang.String str) {
        return this.mBase.remove(str);
    }

    @Override // com.igexin.base.b.a
    public boolean saveParam(java.lang.String str, java.lang.Object obj) {
        return this.mBase.saveParam(str, obj);
    }
}
