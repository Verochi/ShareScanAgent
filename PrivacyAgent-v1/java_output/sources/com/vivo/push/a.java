package com.vivo.push;

/* loaded from: classes19.dex */
public final class a {
    private android.os.Bundle a;
    private java.lang.String b;
    private java.lang.String c;

    public a(java.lang.String str, java.lang.String str2, android.os.Bundle bundle) {
        this.b = str;
        this.c = str2;
        this.a = bundle;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x001b, code lost:
    
        if (android.text.TextUtils.isEmpty(r3) == false) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static com.vivo.push.a a(android.content.Intent intent) {
        java.lang.String str;
        if (intent == null) {
            com.vivo.push.util.p.a("BundleWapper", "create error : intent is null");
            return null;
        }
        android.os.Bundle extras = intent.getExtras();
        if (extras != null) {
            str = extras.getString("client_pkgname");
        }
        str = null;
        if (android.text.TextUtils.isEmpty(str)) {
            com.vivo.push.util.p.b("BundleWapper", "create warning: pkgName is null");
        }
        java.lang.String str2 = intent.getPackage();
        if (android.text.TextUtils.isEmpty(str2)) {
            java.lang.String packageName = intent.getComponent() != null ? intent.getComponent().getPackageName() : null;
            if (android.text.TextUtils.isEmpty(packageName)) {
                com.vivo.push.util.p.b("BundleWapper", "create warning: targetPkgName is null");
            }
            str2 = packageName;
        }
        return new com.vivo.push.a(str, str2, extras);
    }

    public final java.lang.String a() {
        return this.b;
    }

    public final java.lang.String a(java.lang.String str) {
        android.os.Bundle bundle = this.a;
        if (bundle == null) {
            return null;
        }
        return bundle.getString(str);
    }

    public final void a(java.lang.String str, int i) {
        if (this.a == null) {
            this.a = new android.os.Bundle();
        }
        this.a.putInt(str, i);
    }

    public final void a(java.lang.String str, long j) {
        if (this.a == null) {
            this.a = new android.os.Bundle();
        }
        this.a.putLong(str, j);
    }

    public final void a(java.lang.String str, java.io.Serializable serializable) {
        if (this.a == null) {
            this.a = new android.os.Bundle();
        }
        this.a.putSerializable(str, serializable);
    }

    public final void a(java.lang.String str, java.lang.String str2) {
        if (this.a == null) {
            this.a = new android.os.Bundle();
        }
        this.a.putString(str, str2);
    }

    public final void a(java.lang.String str, java.util.ArrayList<java.lang.String> arrayList) {
        if (this.a == null) {
            this.a = new android.os.Bundle();
        }
        this.a.putStringArrayList(str, arrayList);
    }

    public final void a(java.lang.String str, boolean z) {
        if (this.a == null) {
            this.a = new android.os.Bundle();
        }
        this.a.putBoolean(str, z);
    }

    public final void a(java.lang.String str, byte[] bArr) {
        if (this.a == null) {
            this.a = new android.os.Bundle();
        }
        this.a.putByteArray(str, bArr);
    }

    public final int b(java.lang.String str, int i) {
        android.os.Bundle bundle = this.a;
        return bundle == null ? i : bundle.getInt(str, i);
    }

    public final long b(java.lang.String str, long j) {
        android.os.Bundle bundle = this.a;
        return bundle == null ? j : bundle.getLong(str, j);
    }

    public final android.os.Bundle b() {
        return this.a;
    }

    public final byte[] b(java.lang.String str) {
        android.os.Bundle bundle = this.a;
        if (bundle == null) {
            return null;
        }
        return bundle.getByteArray(str);
    }

    public final java.util.ArrayList<java.lang.String> c(java.lang.String str) {
        android.os.Bundle bundle = this.a;
        if (bundle == null) {
            return null;
        }
        return bundle.getStringArrayList(str);
    }

    public final java.io.Serializable d(java.lang.String str) {
        android.os.Bundle bundle = this.a;
        if (bundle == null) {
            return null;
        }
        return bundle.getSerializable(str);
    }

    public final boolean e(java.lang.String str) {
        android.os.Bundle bundle = this.a;
        if (bundle == null) {
            return false;
        }
        return bundle.getBoolean(str, false);
    }
}
