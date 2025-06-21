package com.qq.e.comm.managers.plugin;

/* loaded from: classes19.dex */
class c {
    private static final byte[] c = {82, org.apache.tools.tar.TarConstants.LF_GNUTYPE_SPARSE, 65, 47, 69, 67, 66, 47, 80, org.apache.tools.tar.TarConstants.LF_GNUTYPE_LONGLINK, 67, org.apache.tools.tar.TarConstants.LF_GNUTYPE_SPARSE, org.apache.tools.tar.TarConstants.LF_LINK, 80, 97, 100, 100, 105, 110, org.apache.tools.tar.TarConstants.LF_PAX_GLOBAL_EXTENDED_HEADER};
    private java.security.PublicKey a;
    private final boolean b;

    public static final class b {
        public static final com.qq.e.comm.managers.plugin.c a = new com.qq.e.comm.managers.plugin.c(null);
    }

    private c() {
        boolean z;
        try {
            this.a = a("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDKta2b5Vw5YkWHCAj4rJCwS227\r/35FZ29e4I6pS2B8zSq2RgBpXUuMg7oZF1Qt3x0iyg8PeyblyNeCRB6gIMehFThe\r1Y7m1FaQyaZp+CJYOTLM4/THKp9UndrEgJ/5a83vP1375YCV2lMvWARrNlBep4RN\rnESUJhQz58Gr/F39TwIDAQAB");
            z = true;
        } catch (java.lang.Throwable unused) {
            z = false;
        }
        this.b = z;
    }

    public /* synthetic */ c(com.qq.e.comm.managers.plugin.c.a aVar) {
        this();
    }

    private java.security.PublicKey a(java.lang.String str) throws java.lang.Exception {
        try {
            return java.security.KeyFactory.getInstance(com.alipay.sdk.m.n.d.a).generatePublic(new java.security.spec.X509EncodedKeySpec(android.util.Base64.decode(str, 0)));
        } catch (java.lang.NullPointerException unused) {
            throw new java.lang.Exception("公钥数据为空");
        } catch (java.security.NoSuchAlgorithmException unused2) {
            throw new java.lang.Exception("无此算法");
        } catch (java.security.spec.InvalidKeySpecException unused3) {
            throw new java.lang.Exception("公钥非法");
        }
    }

    public boolean a(java.lang.String str, java.io.File file) {
        java.lang.String str2;
        if (file == null || !file.exists()) {
            return false;
        }
        if (file.exists()) {
            java.io.FileInputStream fileInputStream = null;
            try {
                java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("MD5");
                java.io.FileInputStream fileInputStream2 = new java.io.FileInputStream(file);
                try {
                    byte[] bArr = new byte[16384];
                    while (true) {
                        int read = fileInputStream2.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        messageDigest.update(bArr, 0, read);
                    }
                    str2 = com.qq.e.comm.managers.plugin.d.a(messageDigest.digest());
                    try {
                        fileInputStream2.close();
                    } catch (java.lang.Exception unused) {
                    }
                } catch (java.lang.Exception unused2) {
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (java.lang.Exception unused3) {
                        }
                    }
                    str2 = "";
                    return a(str, str2);
                } catch (java.lang.Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (java.lang.Exception unused4) {
                        }
                    }
                    throw th;
                }
            } catch (java.lang.Exception unused5) {
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
            return a(str, str2);
        }
        str2 = "";
        return a(str, str2);
    }

    public boolean a(java.lang.String str, java.lang.String str2) {
        java.lang.String str3;
        if (android.text.TextUtils.isEmpty(str2)) {
            return false;
        }
        if (!this.b) {
            return true;
        }
        if (this.a != null) {
            byte[] decode = android.util.Base64.decode(str, 0);
            try {
                javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance(new java.lang.String(c, "UTF-8"));
                cipher.init(2, this.a);
                str3 = new java.lang.String(cipher.doFinal(decode), "UTF-8").trim();
            } catch (java.lang.Throwable unused) {
                com.qq.e.comm.util.GDTLogger.d("ErrorWhileVerifySigNature");
            }
            boolean equals = str2.equals(str3);
            com.qq.e.comm.util.GDTLogger.d("Verify Result" + equals + "src=" + str2 + " & target=" + str3);
            return equals;
        }
        str3 = null;
        boolean equals2 = str2.equals(str3);
        com.qq.e.comm.util.GDTLogger.d("Verify Result" + equals2 + "src=" + str2 + " & target=" + str3);
        return equals2;
    }
}
