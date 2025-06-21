package com.huawei.hms.opendevice;

/* loaded from: classes22.dex */
public abstract class c {
    public static final java.lang.String a = "c";
    public static java.util.Map<java.lang.String, java.lang.String> b = new java.util.HashMap();
    public static final java.lang.Object c = new java.lang.Object();

    public static java.lang.String a() {
        return "2A57086C86EF54970C1E6EB37BFC72B1";
    }

    public static java.lang.String a(java.lang.String str) {
        java.lang.String str2 = b.get(str);
        return android.text.TextUtils.isEmpty(str2) ? "" : str2;
    }

    public static void a(java.lang.String str, android.content.Context context) {
        java.lang.String c2 = com.huawei.hms.opendevice.p.c(context.getApplicationContext());
        if (android.text.TextUtils.isEmpty(c2)) {
            return;
        }
        try {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(c2);
            sb.append("/files/s");
            a("s", str, sb.toString());
        } catch (java.io.IOException unused) {
            com.huawei.hms.support.log.HMSLog.e(a, "save keyS IOException.");
        }
    }

    public static void a(java.lang.String str, java.lang.String str2, java.lang.String str3) throws java.io.IOException {
        java.io.OutputStreamWriter outputStreamWriter;
        com.huawei.hms.support.log.HMSLog.i(a, "save local secret key.");
        java.io.BufferedWriter bufferedWriter = null;
        try {
            java.io.File file = new java.io.File(str3);
            com.huawei.hms.opendevice.s.a(file);
            outputStreamWriter = new java.io.OutputStreamWriter(new java.io.FileOutputStream(file), "UTF-8");
            try {
                java.io.BufferedWriter bufferedWriter2 = new java.io.BufferedWriter(outputStreamWriter);
                try {
                    bufferedWriter2.write(str2);
                    bufferedWriter2.flush();
                    b.put(str, str2);
                    com.huawei.hms.utils.IOUtils.closeQuietly((java.io.Writer) outputStreamWriter);
                    com.huawei.hms.utils.IOUtils.closeQuietly((java.io.Writer) bufferedWriter2);
                } catch (java.lang.Throwable th) {
                    th = th;
                    bufferedWriter = bufferedWriter2;
                    com.huawei.hms.utils.IOUtils.closeQuietly((java.io.Writer) outputStreamWriter);
                    com.huawei.hms.utils.IOUtils.closeQuietly((java.io.Writer) bufferedWriter);
                    throw th;
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        } catch (java.lang.Throwable th3) {
            th = th3;
            outputStreamWriter = null;
        }
    }

    public static void a(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, android.content.Context context) {
        java.lang.String c2 = com.huawei.hms.opendevice.p.c(context.getApplicationContext());
        if (android.text.TextUtils.isEmpty(c2)) {
            return;
        }
        try {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(c2);
            sb.append("/files/math/m");
            a(com.anythink.expressad.d.a.b.dH, str, sb.toString());
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            sb2.append(c2);
            sb2.append("/files/panda/p");
            a("p", str2, sb2.toString());
            java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
            sb3.append(c2);
            sb3.append("/files/panda/d");
            a("d", str3, sb3.toString());
            java.lang.StringBuilder sb4 = new java.lang.StringBuilder();
            sb4.append(c2);
            sb4.append("/files/math/t");
            a("t", str4, sb4.toString());
            java.lang.StringBuilder sb5 = new java.lang.StringBuilder();
            sb5.append(c2);
            sb5.append("/files/s");
            a("s", str5, sb5.toString());
        } catch (java.io.IOException unused) {
            com.huawei.hms.support.log.HMSLog.e(a, "save key IOException.");
        }
    }

    public static byte[] a(android.content.Context context) {
        byte[] a2 = com.huawei.hms.opendevice.a.a(context.getString(com.huawei.android.hms.openid.R.string.push_cat_head));
        byte[] a3 = com.huawei.hms.opendevice.a.a(context.getString(com.huawei.android.hms.openid.R.string.push_cat_body));
        return a(a(a(a2, a3), com.huawei.hms.opendevice.a.a(a())));
    }

    public static byte[] a(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        return android.os.Build.VERSION.SDK_INT >= 26 ? com.huawei.secure.android.common.encrypt.utils.BaseKeyUtil.exportRootKey(str, str2, str3, str4, 32, true) : com.huawei.secure.android.common.encrypt.utils.BaseKeyUtil.exportRootKey(str, str2, str3, str4, 32, false);
    }

    public static byte[] a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return new byte[0];
        }
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = (byte) (bArr[i] >> 2);
        }
        return bArr;
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null || bArr.length == 0 || bArr2.length == 0) {
            return new byte[0];
        }
        int length = bArr.length;
        if (length != bArr2.length) {
            return new byte[0];
        }
        byte[] bArr3 = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr3[i] = (byte) (bArr[i] ^ bArr2[i]);
        }
        return bArr3;
    }

    public static java.lang.String b(android.content.Context context) {
        if (!i()) {
            com.huawei.hms.support.log.HMSLog.i(a, "work key is empty, execute init.");
            c(context);
        }
        java.lang.String decryptWorkKey = com.huawei.secure.android.common.encrypt.utils.WorkKeyCryptUtil.decryptWorkKey(f(), b());
        return com.huawei.hms.opendevice.t.a(decryptWorkKey) ? decryptWorkKey : e(context);
    }

    public static byte[] b() {
        return a(d(), e(), c(), g());
    }

    public static java.lang.String c() {
        return a("d");
    }

    public static void c(android.content.Context context) {
        synchronized (c) {
            d(context.getApplicationContext());
            if (i()) {
                com.huawei.hms.support.log.HMSLog.i(a, "The local secret is already in separate file mode.");
                return;
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(com.huawei.hms.opendevice.p.c(context.getApplicationContext()));
            sb.append("/shared_prefs/LocalAvengers.xml");
            java.io.File file = new java.io.File(sb.toString());
            if (file.exists()) {
                com.huawei.secure.android.common.util.IOUtil.deleteSecure(file);
                com.huawei.hms.support.log.HMSLog.i(a, "destroy C, delete file LocalAvengers.xml.");
            }
            byte[] generateSecureRandom = com.huawei.secure.android.common.encrypt.utils.EncryptUtil.generateSecureRandom(32);
            byte[] generateSecureRandom2 = com.huawei.secure.android.common.encrypt.utils.EncryptUtil.generateSecureRandom(32);
            byte[] generateSecureRandom3 = com.huawei.secure.android.common.encrypt.utils.EncryptUtil.generateSecureRandom(32);
            byte[] generateSecureRandom4 = com.huawei.secure.android.common.encrypt.utils.EncryptUtil.generateSecureRandom(32);
            java.lang.String a2 = com.huawei.hms.opendevice.a.a(generateSecureRandom);
            java.lang.String a3 = com.huawei.hms.opendevice.a.a(generateSecureRandom2);
            java.lang.String a4 = com.huawei.hms.opendevice.a.a(generateSecureRandom3);
            java.lang.String a5 = com.huawei.hms.opendevice.a.a(generateSecureRandom4);
            a(a2, a3, a4, a5, com.huawei.secure.android.common.encrypt.utils.WorkKeyCryptUtil.encryptWorkKey(com.huawei.hms.opendevice.a.a(com.huawei.secure.android.common.encrypt.utils.EncryptUtil.generateSecureRandom(32)), a(a2, a3, a4, a5)), context);
            com.huawei.hms.support.log.HMSLog.i(a, "generate D.");
        }
    }

    public static java.lang.String d() {
        return a(com.anythink.expressad.d.a.b.dH);
    }

    public static void d(android.content.Context context) {
        if (i()) {
            com.huawei.hms.support.log.HMSLog.i(a, "secretKeyCache not empty.");
            return;
        }
        b.clear();
        java.lang.String c2 = com.huawei.hms.opendevice.p.c(context);
        if (android.text.TextUtils.isEmpty(c2)) {
            return;
        }
        java.lang.String a2 = com.huawei.hms.opendevice.s.a(c2 + "/files/math/m");
        java.lang.String a3 = com.huawei.hms.opendevice.s.a(c2 + "/files/panda/p");
        java.lang.String a4 = com.huawei.hms.opendevice.s.a(c2 + "/files/panda/d");
        java.lang.String a5 = com.huawei.hms.opendevice.s.a(c2 + "/files/math/t");
        java.lang.String a6 = com.huawei.hms.opendevice.s.a(c2 + "/files/s");
        if (com.huawei.hms.opendevice.t.a(a2, a3, a4, a5, a6)) {
            b.put(com.anythink.expressad.d.a.b.dH, a2);
            b.put("p", a3);
            b.put("d", a4);
            b.put("t", a5);
            b.put("s", a6);
        }
    }

    public static java.lang.String e() {
        return a("p");
    }

    public static synchronized java.lang.String e(android.content.Context context) {
        synchronized (com.huawei.hms.opendevice.c.class) {
            java.lang.String decryptWorkKey = com.huawei.secure.android.common.encrypt.utils.WorkKeyCryptUtil.decryptWorkKey(f(), b());
            if (com.huawei.hms.opendevice.t.a(decryptWorkKey)) {
                com.huawei.hms.support.log.HMSLog.i(a, "keyS has been upgraded, no require operate again.");
                return decryptWorkKey;
            }
            java.lang.String decryptWorkKey2 = com.huawei.secure.android.common.encrypt.utils.WorkKeyCryptUtil.decryptWorkKey(f(), h());
            if (com.huawei.hms.opendevice.t.a(decryptWorkKey2)) {
                com.huawei.hms.support.log.HMSLog.i(a, "keyS is encrypt by RootKeyUtil, upgrade encrypt mode.");
                a(com.huawei.secure.android.common.encrypt.utils.WorkKeyCryptUtil.encryptWorkKey(decryptWorkKey2, b()), context);
                return decryptWorkKey2;
            }
            java.lang.String decryptWorkKey3 = com.huawei.secure.android.common.encrypt.utils.WorkKeyCryptUtil.decryptWorkKey(f(), com.huawei.secure.android.common.encrypt.utils.BaseKeyUtil.exportRootKey(d(), e(), c(), g(), 32, false));
            if (!com.huawei.hms.opendevice.t.a(decryptWorkKey3)) {
                com.huawei.hms.support.log.HMSLog.e(a, "all mode unable to decrypt root key.");
                return "";
            }
            com.huawei.hms.support.log.HMSLog.i(a, "keyS is encrypt by ExportRootKey with sha1, upgrade encrypt mode to sha256.");
            a(com.huawei.secure.android.common.encrypt.utils.WorkKeyCryptUtil.encryptWorkKey(decryptWorkKey3, b()), context);
            return decryptWorkKey3;
        }
    }

    public static java.lang.String f() {
        return a("s");
    }

    public static java.lang.String g() {
        return a("t");
    }

    public static com.huawei.secure.android.common.encrypt.utils.RootKeyUtil h() {
        return com.huawei.secure.android.common.encrypt.utils.RootKeyUtil.newInstance(d(), e(), c(), g());
    }

    public static boolean i() {
        return !android.text.TextUtils.isEmpty(f());
    }
}
