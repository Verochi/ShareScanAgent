package cn.fly.verify;

/* loaded from: classes.dex */
public class j {
    private static cn.fly.verify.j a;
    private final cn.fly.verify.av b;
    private final cn.fly.verify.fl c = new cn.fly.verify.fl();
    private final cn.fly.verify.fc d;

    public static class a<T> {
        public void a(cn.fly.verify.common.exception.VerifyException verifyException) {
        }

        public void a(T t) {
        }
    }

    private j(boolean z) {
        java.lang.String str;
        java.lang.String str2;
        if (z) {
            str = "97ef82c15a0d8f056f3eabe8e06adc47dccef8b3bc45824ebf1b0e4d04ad696ce390a719f23bfd726a709fccfbd8074cecf1cddfc5989a9c1d99ccd829d8991b";
            str2 = "1eac6c0206e34ff3d7cc558d05f657a99dc01bd75f44a72cd86a875ff8fa97e3b024627a68374ab90eddee7f182b9dcee2f64f97113e7473673e6b293d416220d725a60552c679bc37d1826982e0b9ef000c8d202126d665acf3698c1eae656eb0d06b6c0b923ff0f4194aa46634634c39c854bd75086b66eff132dc308746d3";
        } else {
            str = "d008219b14c84872559aaf9e69d1348175289c186912da64b2393bab376bb0d6b471220cb29cbc9875b148b593eb9d7c4c359549a1aff22f6de9d18d22f0b6cb";
            str2 = "1f228b2b8fbb7317674db20bab1d4b0f0ddb3e1f3a93177f1821c026ffd7c6b782be720a308ab69bf6c631c3c0c4d68bf9d92ddaaf712a032d591ba1c296df13332a23e37b281e5fd9b93ab016dd3efc5de45e264ed692ac63ac40013f507cd272b7aeeb85be9fe2f31f11b8c55d904b5331932c70c7cf3f2b05cb802f6b89a7";
        }
        this.b = new cn.fly.verify.av(1024, str, str2);
        this.d = new cn.fly.verify.fc();
    }

    public static cn.fly.verify.j a(boolean z) {
        if (a == null) {
            synchronized (cn.fly.verify.j.class) {
                if (a == null) {
                    a = new cn.fly.verify.j(z);
                }
            }
        }
        return a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0082, code lost:
    
        if (r11 == null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0084, code lost:
    
        return r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0090, code lost:
    
        throw new cn.fly.verify.common.exception.VerifyException(cn.fly.verify.common.exception.VerifyErr.C_Init_Server_Error.getCode(), r4);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public java.util.HashMap a(java.lang.String str, cn.fly.verify.e eVar) throws cn.fly.verify.common.exception.VerifyException {
        java.util.HashMap hashMap;
        if (cn.fly.verify.ax.h()) {
            throw new cn.fly.verify.common.exception.VerifyException(cn.fly.verify.common.exception.VerifyErr.C_PRIVACY_NOT_ACCEPTED_ERROR);
        }
        try {
            java.util.HashMap<java.lang.String, java.lang.String> hashMap2 = new java.util.HashMap<>();
            hashMap2.put("appkey", cn.fly.verify.ax.d());
            cn.fly.verify.fc.a aVar = new cn.fly.verify.fc.a();
            aVar.b = 3000;
            aVar.a = 5000;
            java.lang.String a2 = this.d.a(str, (java.util.HashMap<java.lang.String, java.lang.Object>) null, hashMap2, aVar);
            long uptimeMillis = android.os.SystemClock.uptimeMillis();
            boolean z = false;
            byte[] decode = android.util.Base64.decode(a2, 0);
            java.lang.String g = cn.fly.verify.aq.g();
            if (android.text.TextUtils.isEmpty(g)) {
                g = cn.fly.verify.ai.a().i();
            }
            org.json.JSONObject jSONObject = new org.json.JSONObject(cn.fly.verify.fi.a(g, decode));
            boolean z2 = true;
            try {
                hashMap = this.c.a(jSONObject.optString("res"));
            } catch (java.lang.Throwable unused) {
                hashMap = null;
                z = true;
            }
            int optInt = jSONObject.optInt("status");
            java.lang.String optString = jSONObject.optString("error");
            if (eVar != null) {
                eVar.a((java.lang.String) null, (java.lang.String) null, "config_decode", java.lang.String.valueOf(android.os.SystemClock.uptimeMillis() - uptimeMillis));
            }
            if (optInt == 200 && !z) {
                z2 = z;
            }
            throw new cn.fly.verify.common.exception.VerifyException(cn.fly.verify.common.exception.VerifyErr.C_Init_Server_Error.getCode(), optString);
        } catch (java.lang.Throwable th) {
            cn.fly.verify.f.a().c("[FlyVerify] ==>%s", "cdn init error: " + cn.fly.verify.as.a(th));
            if (th instanceof cn.fly.verify.common.exception.VerifyException) {
                throw th;
            }
            throw new cn.fly.verify.common.exception.VerifyException(cn.fly.verify.common.exception.VerifyErr.C_INIT_UNEXPECTED_ERROR.getCode(), cn.fly.verify.as.a(th));
        }
    }

    public java.util.HashMap<java.lang.String, java.lang.Object> a(java.util.HashMap<java.lang.String, java.lang.Object> hashMap, java.lang.String str) throws java.lang.Throwable {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap2 = new java.util.HashMap<>();
        hashMap2.put("appkey", cn.fly.verify.ax.d());
        return (java.util.HashMap) this.b.a(hashMap2, hashMap, str, false);
    }

    public void a(java.util.HashMap<java.lang.String, java.lang.Object> hashMap, java.lang.String str, cn.fly.verify.j.a<java.util.HashMap> aVar) {
        a(hashMap, str, false, aVar);
    }

    public void a(java.util.HashMap<java.lang.String, java.lang.Object> hashMap, java.lang.String str, boolean z, cn.fly.verify.j.a<java.util.HashMap> aVar) {
        cn.fly.verify.common.exception.VerifyException verifyException;
        if (cn.fly.verify.ax.h()) {
            return;
        }
        try {
            java.util.HashMap<java.lang.String, java.lang.String> hashMap2 = new java.util.HashMap<>();
            hashMap2.put("appkey", cn.fly.verify.ax.d());
            java.util.HashMap hashMap3 = (java.util.HashMap) this.b.a(hashMap2, hashMap, str, false);
            if (z) {
                if (hashMap3 != null && !hashMap3.isEmpty()) {
                    verifyException = new cn.fly.verify.common.exception.VerifyException(cn.fly.verify.common.exception.VerifyErr.C_RESPONSE_DATA_ABNORMAL);
                    aVar.a(verifyException);
                    return;
                }
                aVar.a((cn.fly.verify.j.a<java.util.HashMap>) hashMap3);
            }
            if (hashMap3 == null || hashMap3.isEmpty()) {
                verifyException = new cn.fly.verify.common.exception.VerifyException(cn.fly.verify.common.exception.VerifyErr.C_RESPONSE_DATA_ABNORMAL);
                aVar.a(verifyException);
                return;
            }
            aVar.a((cn.fly.verify.j.a<java.util.HashMap>) hashMap3);
        } catch (java.lang.Throwable th) {
            cn.fly.verify.f.a().b("[FlyVerify] ==>%s", "url:" + str + "request error:" + th.getMessage());
            aVar.a(new cn.fly.verify.common.exception.VerifyException(cn.fly.verify.common.exception.VerifyErr.C_RESPONSE_DATA_ABNORMAL.getCode(), cn.fly.verify.as.a(th)));
        }
    }

    public java.util.HashMap b(java.util.HashMap<java.lang.String, java.lang.Object> hashMap, java.lang.String str) throws cn.fly.verify.common.exception.VerifyException {
        if (cn.fly.verify.ax.h()) {
            throw new cn.fly.verify.common.exception.VerifyException(cn.fly.verify.common.exception.VerifyErr.C_PRIVACY_NOT_ACCEPTED_ERROR);
        }
        try {
            java.util.HashMap<java.lang.String, java.lang.String> hashMap2 = new java.util.HashMap<>();
            hashMap2.put("appkey", cn.fly.verify.ax.d());
            return (java.util.HashMap) this.b.a(hashMap2, hashMap, str, false);
        } catch (java.lang.Throwable th) {
            throw new cn.fly.verify.common.exception.VerifyException(cn.fly.verify.common.exception.VerifyErr.C_Init_Server_Error.getCode(), cn.fly.verify.as.a(th));
        }
    }
}
