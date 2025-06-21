package com.baidu.mobads.sdk.internal;

/* loaded from: classes.dex */
public class bs extends java.io.File {
    public static final java.lang.String a = "LocalApkFile";
    private static final long b = 6916965592955692235L;
    private static java.lang.ClassLoader h;
    private com.baidu.mobads.sdk.internal.bx c;
    private java.lang.Class<?> d;
    private android.content.Context e;
    private java.security.PublicKey f;
    private com.baidu.mobads.sdk.internal.bt g;

    public class a implements java.io.FilenameFilter {
        public a() {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(java.io.File file, java.lang.String str) {
            return true;
        }
    }

    public bs(java.lang.String str, android.content.Context context) {
        this(str, context, null);
    }

    public bs(java.lang.String str, android.content.Context context, com.baidu.mobads.sdk.internal.bx bxVar) {
        super(str);
        this.d = null;
        this.e = null;
        this.g = com.baidu.mobads.sdk.internal.bt.a();
        this.e = context;
        this.c = bxVar;
        if (bxVar != null) {
            try {
                this.f = c("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDBcp8gg3O7bjdnz+pSxg+JH/mbcKfm7dEjcRqVNAFwG7bTpLwDQh40bZJzrcBKQWbD6kArR6TPuQUCMQ09/y55Vk1P2Kq7vJGGisFpjlqv2qlg8drLdhXkLQUt/SeZVJgT+CNxVbuzxAF61EEf8M0MHi1I2dm6n6lOA6fomiCD9wIDAQAB");
            } catch (java.lang.Exception unused) {
                this.f = null;
            }
        }
    }

    public static java.lang.ClassLoader a(android.content.Context context) {
        java.lang.ClassLoader classLoader = h;
        return classLoader != null ? classLoader : com.baidu.mobads.sdk.internal.au.a(context.getApplicationContext());
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x009d A[Catch: Exception -> 0x0099, TRY_LEAVE, TryCatch #5 {Exception -> 0x0099, blocks: (B:55:0x0095, B:48:0x009d), top: B:54:0x0095 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0095 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private java.lang.String a(java.io.File file) {
        java.security.DigestInputStream digestInputStream;
        java.io.FileInputStream fileInputStream = null;
        try {
            java.io.FileInputStream fileInputStream2 = new java.io.FileInputStream(file);
            try {
                java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("MD5");
                digestInputStream = new java.security.DigestInputStream(fileInputStream2, messageDigest);
                try {
                    while (digestInputStream.read(new byte[4096]) != -1) {
                    }
                    java.lang.String str = "";
                    for (byte b2 : messageDigest.digest()) {
                        str = str + java.lang.Integer.toString((b2 & 255) + 256, 16).substring(1);
                    }
                    try {
                        fileInputStream2.close();
                        digestInputStream.close();
                    } catch (java.lang.Exception e) {
                        this.g.a(a, e.getMessage());
                    }
                    return str;
                } catch (java.lang.Exception e2) {
                    e = e2;
                    fileInputStream = fileInputStream2;
                    try {
                        this.g.a(a, e.getMessage());
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (java.lang.Exception e3) {
                                this.g.a(a, e3.getMessage());
                                return "";
                            }
                        }
                        if (digestInputStream == null) {
                            return "";
                        }
                        digestInputStream.close();
                        return "";
                    } catch (java.lang.Throwable th) {
                        th = th;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (java.lang.Exception e4) {
                                this.g.a(a, e4.getMessage());
                                throw th;
                            }
                        }
                        if (digestInputStream != null) {
                            digestInputStream.close();
                        }
                        throw th;
                    }
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                    }
                    if (digestInputStream != null) {
                    }
                    throw th;
                }
            } catch (java.lang.Exception e5) {
                e = e5;
                digestInputStream = null;
            } catch (java.lang.Throwable th3) {
                th = th3;
                digestInputStream = null;
            }
        } catch (java.lang.Exception e6) {
            e = e6;
            digestInputStream = null;
        } catch (java.lang.Throwable th4) {
            th = th4;
            digestInputStream = null;
        }
    }

    @android.annotation.TargetApi(14)
    private java.lang.Class<?> b(java.io.File file) {
        java.lang.Class<?> cls;
        this.g.a(a, "Android version:" + com.baidu.mobads.sdk.internal.bm.a(this.e).c());
        java.lang.Class<?> cls2 = null;
        try {
            synchronized (com.baidu.mobads.sdk.internal.bz.class) {
                java.lang.String absolutePath = file.getAbsolutePath();
                java.lang.ClassLoader classLoader = getClass().getClassLoader();
                java.lang.String absolutePath2 = this.e.getFilesDir().getAbsolutePath();
                java.lang.String str = com.baidu.mobads.sdk.internal.z.aN;
                h = com.baidu.mobads.sdk.internal.an.a(absolutePath, absolutePath2, (java.lang.String) null, classLoader);
                this.g.a(a, "dexPath=" + absolutePath + ", cl=" + classLoader + ", dir=" + absolutePath2 + ", len=" + file.length() + ", list=" + file.list());
                cls = java.lang.Class.forName(str, true, h);
            }
            cls2 = cls;
        } catch (java.lang.Exception e) {
            this.g.a(a, e.getMessage());
        }
        this.g.a(a, "jar.path=" + file.getAbsolutePath() + ", clz=" + cls2);
        return cls2;
    }

    private java.lang.String b(java.lang.String str) {
        if (this.f == null) {
            return null;
        }
        byte[] decode = android.util.Base64.decode(str, 0);
        try {
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(2, this.f);
            return new java.lang.String(cipher.doFinal(decode), "UTF-8").trim();
        } catch (java.lang.Exception e) {
            this.g.c("ErrorWhileVerifySigNature", e);
            return null;
        }
    }

    private static java.security.PublicKey c(java.lang.String str) {
        try {
            return java.security.KeyFactory.getInstance(com.alipay.sdk.m.n.d.a).generatePublic(new java.security.spec.X509EncodedKeySpec(android.util.Base64.decode(str, 0)));
        } catch (java.lang.NullPointerException unused) {
            throw new java.lang.Exception("NullPointerException");
        } catch (java.security.NoSuchAlgorithmException unused2) {
            throw new java.lang.Exception("NoSuchAlgorithmException");
        } catch (java.security.spec.InvalidKeySpecException unused3) {
            throw new java.lang.Exception("InvalidKeySpecException");
        }
    }

    private void d() {
        java.io.File[] listFiles = this.e.getFilesDir().listFiles(new com.baidu.mobads.sdk.internal.bs.a());
        for (int i = 0; listFiles != null && i < listFiles.length; i++) {
            if (listFiles[i].getAbsolutePath().contains("__xadsdk__remote__final__")) {
                this.g.a(a, "clearDexCacheFiles-->" + i + "--" + listFiles[i].getAbsolutePath());
                listFiles[i].delete();
            }
        }
    }

    public void a() {
        if (this.c == null) {
            this.g.a(a, "built-in apk, no need to check");
            return;
        }
        java.lang.String a2 = a(new java.io.File(getAbsolutePath()));
        java.lang.String b2 = b(this.c.d());
        if (a2.equalsIgnoreCase(b2)) {
            return;
        }
        throw new com.baidu.mobads.sdk.internal.bz.a("doCheckApkIntegrity failed, md5sum: " + a2 + ", checksum in json info: " + b2);
    }

    public void a(java.lang.String str) {
        renameTo(new java.io.File(str));
    }

    public java.lang.Class<?> b() {
        if (this.d == null) {
            java.io.File file = new java.io.File(getAbsolutePath());
            try {
                this.d = b(file);
            } catch (java.lang.Exception unused) {
                file.delete();
            }
        }
        return this.d;
    }

    public double c() {
        com.baidu.mobads.sdk.internal.bx bxVar = this.c;
        if (bxVar == null) {
            return 0.0d;
        }
        return bxVar.b();
    }
}
