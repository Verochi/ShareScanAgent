package com.tanx.onlyid.api;

/* loaded from: classes19.dex */
public final class DeviceIdManager {
    public static volatile com.tanx.onlyid.api.DeviceIdManager b;
    public static volatile boolean c;
    public static volatile java.lang.String d;
    public static volatile java.lang.String e;
    public static volatile java.lang.String f;
    public static volatile java.lang.String g;
    public static volatile java.lang.String h;
    public static volatile java.lang.String i;
    public static volatile java.lang.String j;
    public android.app.Application a;

    /* renamed from: com.tanx.onlyid.api.DeviceIdManager$1, reason: invalid class name */
    public class AnonymousClass1 implements com.tanx.onlyid.api.IGetter {
        public final /* synthetic */ com.tanx.onlyid.api.IGetter a;

        public AnonymousClass1(com.tanx.onlyid.api.IGetter iGetter) {
            this.a = iGetter;
        }

        @Override // com.tanx.onlyid.api.IGetter
        public void oaidError(java.lang.Exception exc) {
            java.lang.String unused = com.tanx.onlyid.api.DeviceIdManager.f = "";
            com.tanx.onlyid.api.IGetter iGetter = this.a;
            if (iGetter != null) {
                iGetter.oaidError(exc);
            }
        }

        @Override // com.tanx.onlyid.api.IGetter
        public void oaidSucc(java.lang.String str) {
            java.lang.String unused = com.tanx.onlyid.api.DeviceIdManager.f = str;
            com.tanx.onlyid.api.IGetter iGetter = this.a;
            if (iGetter != null) {
                iGetter.oaidSucc(com.tanx.onlyid.api.DeviceIdManager.f);
            }
        }
    }

    public static com.tanx.onlyid.api.DeviceIdManager getInstance() {
        if (b == null) {
            synchronized (com.tanx.onlyid.api.DeviceIdManager.class) {
                if (b == null) {
                    b = new com.tanx.onlyid.api.DeviceIdManager();
                }
            }
        }
        return b;
    }

    public java.lang.String getAndroidID(android.content.Context context) {
        if (g == null) {
            g = com.tanx.onlyid.api.IdStorageManager.getInstance(this.a).getString(com.tanx.onlyid.api.IdStorageManager.KEY_ANDROID_ID);
            if (android.text.TextUtils.isEmpty(g)) {
                g = com.tanx.onlyid.api.DeviceID.getAndroidID(context);
                com.tanx.onlyid.api.IdStorageManager.getInstance(this.a).putId(com.tanx.onlyid.api.IdStorageManager.KEY_ANDROID_ID, g);
            }
        }
        if (g == null) {
            g = "";
        }
        return g;
    }

    public java.lang.String getClientId() {
        if (android.text.TextUtils.isEmpty(d)) {
            d = com.tanx.onlyid.api.IdStorageManager.getInstance(this.a).getString(com.tanx.onlyid.api.IdStorageManager.KEY_CLIENT_ID);
            if (android.text.TextUtils.isEmpty(d)) {
                d = com.tanx.onlyid.api.DeviceID.getClientIdMD5();
                com.tanx.onlyid.api.IdStorageManager.getInstance(this.a).putId(com.tanx.onlyid.api.IdStorageManager.KEY_CLIENT_ID, d);
            }
        }
        if (d == null) {
            d = "";
        }
        return d;
    }

    public java.lang.String getGUID(android.content.Context context) {
        if (j == null) {
            j = com.tanx.onlyid.api.DeviceID.getGUID(context);
            if (j == null) {
                j = "";
            }
        }
        return j;
    }

    public java.lang.String getIMEI(android.content.Context context) {
        return getIMEI(context, false);
    }

    public java.lang.String getIMEI(android.content.Context context, boolean z) {
        if (android.text.TextUtils.isEmpty(e)) {
            e = com.tanx.onlyid.api.IdStorageManager.getInstance(this.a).getString(com.tanx.onlyid.api.IdStorageManager.KEY_IMEI);
            if (android.text.TextUtils.isEmpty(e) && !z) {
                e = com.tanx.onlyid.api.DeviceID.getUniqueID(context);
                com.tanx.onlyid.api.IdStorageManager.getInstance(this.a).putId(com.tanx.onlyid.api.IdStorageManager.KEY_IMEI, e);
            }
        }
        if (e == null) {
            e = "";
        }
        return e;
    }

    public java.lang.String getOAID(android.content.Context context) {
        return getOAID(context, false);
    }

    public java.lang.String getOAID(android.content.Context context, boolean z) {
        return getOAID(context, z, null);
    }

    public java.lang.String getOAID(android.content.Context context, boolean z, com.tanx.onlyid.api.IGetter iGetter) {
        if (android.text.TextUtils.isEmpty(f)) {
            f = com.tanx.onlyid.api.DeviceID.getOAID();
            if (android.text.TextUtils.isEmpty(f)) {
                f = com.tanx.onlyid.api.IdStorageManager.getInstance(this.a).getString(com.tanx.onlyid.api.IdStorageManager.KEY_OAID);
            }
            if (android.text.TextUtils.isEmpty(f) && !z) {
                com.tanx.onlyid.api.DeviceID.getOAID(context, new com.tanx.onlyid.api.DeviceIdManager.AnonymousClass1(iGetter));
            }
        }
        if (f == null) {
            f = "";
        }
        if (iGetter != null) {
            iGetter.oaidSucc(f);
        }
        return f;
    }

    public java.lang.String getPseudoID() {
        if (i == null) {
            i = com.tanx.onlyid.api.IdStorageManager.getInstance(this.a).getString(com.tanx.onlyid.api.IdStorageManager.KEY_PSEUDO_ID);
            if (android.text.TextUtils.isEmpty(i)) {
                i = com.tanx.onlyid.api.DeviceID.getPseudoID();
                com.tanx.onlyid.api.IdStorageManager.getInstance(this.a).putId(com.tanx.onlyid.api.IdStorageManager.KEY_PSEUDO_ID, i);
            }
        }
        if (i == null) {
            i = "";
        }
        return i;
    }

    public java.lang.String getWidevineID() {
        if (h == null) {
            h = com.tanx.onlyid.api.IdStorageManager.getInstance(this.a).getString(com.tanx.onlyid.api.IdStorageManager.KEY_WIDEVINE_ID);
            if (android.text.TextUtils.isEmpty(h)) {
                h = com.tanx.onlyid.api.DeviceID.getWidevineID();
                com.tanx.onlyid.api.IdStorageManager.getInstance(this.a).putId(com.tanx.onlyid.api.IdStorageManager.KEY_WIDEVINE_ID, h);
            }
        }
        if (h == null) {
            h = "";
        }
        return h;
    }

    public void init(android.app.Application application) {
        init(application, false);
    }

    public void init(android.app.Application application, boolean z) {
        this.a = application;
        if (c) {
            return;
        }
        com.tanx.onlyid.api.DeviceID.init(application);
        c = true;
        com.tanx.onlyid.api.OAIDLog.enable(z);
    }
}
