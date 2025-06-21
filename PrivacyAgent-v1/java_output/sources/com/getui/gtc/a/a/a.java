package com.getui.gtc.a.a;

/* loaded from: classes22.dex */
public final class a implements java.lang.Runnable {
    public com.getui.gtc.a.a.d a;
    private java.net.HttpURLConnection b;
    private boolean c = false;
    private javax.crypto.spec.SecretKeySpec d;

    public a(com.getui.gtc.a.a.d dVar) {
        this.a = dVar;
        byte[] bArr = new byte[16];
        new java.security.SecureRandom().nextBytes(bArr);
        this.d = new javax.crypto.spec.SecretKeySpec(bArr, "AES/CFB/NoPadding");
    }

    private void a() {
        java.net.HttpURLConnection httpURLConnection = this.b;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
                this.b = null;
            } catch (java.lang.Throwable th) {
                com.getui.gtc.h.c.a.c(th);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x00a6, code lost:
    
        throw new java.lang.SecurityException("sdk config response error, error code is ".concat(r0));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private byte[] a(java.net.HttpURLConnection httpURLConnection, byte[] bArr) {
        try {
            com.getui.gtc.a.a.d dVar = this.a;
            if (!dVar.d) {
                return dVar.g ? com.getui.gtc.a.a.f.b(com.getui.gtc.a.a.b.a(bArr)) : bArr;
            }
            java.lang.String headerField = httpURLConnection.getHeaderField("GT_ERR");
            if (headerField != null && "0".equals(headerField)) {
                java.lang.String headerField2 = httpURLConnection.getHeaderField("GT_T");
                if (headerField2 == null) {
                    throw new java.lang.SecurityException("sdk config response error, GT_T header not found");
                }
                byte[] bytes = headerField2.getBytes();
                java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("MD5");
                messageDigest.update(bytes);
                javax.crypto.spec.IvParameterSpec ivParameterSpec = new javax.crypto.spec.IvParameterSpec(messageDigest.digest());
                java.lang.String headerField3 = httpURLConnection.getHeaderField("GT_C_S");
                if (headerField3 == null) {
                    throw new java.lang.SecurityException("sdk config response error, GT_C_S header not found");
                }
                byte[] decode = android.util.Base64.decode(headerField3, 2);
                javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("AES/CFB/NoPadding");
                cipher.init(2, this.d, ivParameterSpec);
                byte[] doFinal = cipher.doFinal(bArr);
                byte[] bArr2 = new byte[doFinal.length + bytes.length];
                java.lang.System.arraycopy(bytes, 0, bArr2, 0, bytes.length);
                java.lang.System.arraycopy(doFinal, 0, bArr2, bytes.length, doFinal.length);
                java.security.MessageDigest messageDigest2 = java.security.MessageDigest.getInstance("SHA1");
                messageDigest2.update(bArr2);
                if (java.util.Arrays.equals(messageDigest2.digest(), decode)) {
                    return doFinal;
                }
                throw new java.lang.SecurityException("sdk config response error, response body sign check failed");
            }
            throw new java.lang.SecurityException("sdk config response error, GT_ERR header not found");
        } catch (java.lang.Throwable th) {
            com.getui.gtc.h.c.a.c(th);
            return null;
        }
    }

    private byte[] a(java.util.Map<java.lang.String, java.util.List<java.lang.String>> map) {
        java.io.InputStream inputStream;
        java.io.DataOutputStream dataOutputStream;
        java.io.ByteArrayOutputStream byteArrayOutputStream;
        byte[] bArr;
        java.io.InputStream inputStream2;
        java.io.ByteArrayOutputStream byteArrayOutputStream2;
        java.io.DataOutputStream dataOutputStream2;
        try {
            java.net.HttpURLConnection httpURLConnection = (java.net.HttpURLConnection) new java.net.URL(this.a.a).openConnection();
            this.b = httpURLConnection;
            httpURLConnection.setConnectTimeout(this.a.h);
            this.b.setReadTimeout(this.a.i);
            this.b.setDoInput(this.a.k);
            this.b.setDoOutput(this.a.j);
            this.b.setRequestMethod("POST");
            this.b.setUseCaches(this.a.l);
            this.b.setInstanceFollowRedirects(this.a.m);
            for (java.lang.String str : this.a.n.keySet()) {
                this.b.setRequestProperty(str, this.a.n.get(str));
            }
            com.getui.gtc.a.a.d dVar = this.a;
            bArr = dVar.b;
            if (dVar.d) {
                bArr = a(bArr);
            } else if (dVar.f) {
                bArr = com.getui.gtc.a.a.f.a(bArr);
            }
        } catch (java.lang.Throwable th) {
            th = th;
            inputStream = null;
            dataOutputStream = null;
            byteArrayOutputStream = null;
        }
        if (bArr == null) {
            a();
            return null;
        }
        this.b.connect();
        java.io.DataOutputStream dataOutputStream3 = new java.io.DataOutputStream(this.b.getOutputStream());
        try {
            dataOutputStream3.write(bArr, 0, bArr.length);
            dataOutputStream3.flush();
            if (this.b.getResponseCode() == 200) {
                if (this.b.getHeaderFields() != null) {
                    map.putAll(this.b.getHeaderFields());
                }
                inputStream2 = this.b.getInputStream();
                try {
                    byteArrayOutputStream2 = new java.io.ByteArrayOutputStream();
                    try {
                        byte[] bArr2 = new byte[1024];
                        while (true) {
                            int read = inputStream2.read(bArr2);
                            if (read == -1) {
                                break;
                            }
                            byteArrayOutputStream2.write(bArr2, 0, read);
                        }
                        if (byteArrayOutputStream2.toByteArray() != null) {
                            byte[] a = a(this.b, byteArrayOutputStream2.toByteArray());
                            try {
                                dataOutputStream3.close();
                            } catch (java.lang.Throwable th2) {
                                com.getui.gtc.h.c.a.c(th2);
                            }
                            try {
                                inputStream2.close();
                            } catch (java.lang.Throwable th3) {
                                com.getui.gtc.h.c.a.c(th3);
                            }
                            try {
                                byteArrayOutputStream2.close();
                            } catch (java.lang.Throwable th4) {
                                com.getui.gtc.h.c.a.c(th4);
                            }
                            a();
                            return a;
                        }
                    } catch (java.lang.Throwable th5) {
                        dataOutputStream2 = dataOutputStream3;
                        inputStream = inputStream2;
                        th = th5;
                        byteArrayOutputStream = byteArrayOutputStream2;
                        dataOutputStream = dataOutputStream2;
                        try {
                            com.getui.gtc.a.a.d dVar2 = this.a;
                            if (dVar2 != null) {
                                dVar2.a();
                            }
                            com.getui.gtc.h.c.a.d(th.toString());
                            if (dataOutputStream != null) {
                                try {
                                    dataOutputStream.close();
                                } catch (java.lang.Throwable th6) {
                                    com.getui.gtc.h.c.a.c(th6);
                                }
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (java.lang.Throwable th7) {
                                    com.getui.gtc.h.c.a.c(th7);
                                }
                            }
                            if (byteArrayOutputStream != null) {
                                try {
                                    byteArrayOutputStream.close();
                                } catch (java.lang.Throwable th8) {
                                    th = th8;
                                    com.getui.gtc.h.c.a.c(th);
                                    a();
                                    return null;
                                }
                            }
                            a();
                            return null;
                        } catch (java.lang.Throwable th9) {
                            if (dataOutputStream != null) {
                                try {
                                    dataOutputStream.close();
                                } catch (java.lang.Throwable th10) {
                                    com.getui.gtc.h.c.a.c(th10);
                                }
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (java.lang.Throwable th11) {
                                    com.getui.gtc.h.c.a.c(th11);
                                }
                            }
                            if (byteArrayOutputStream != null) {
                                try {
                                    byteArrayOutputStream.close();
                                } catch (java.lang.Throwable th12) {
                                    com.getui.gtc.h.c.a.c(th12);
                                }
                            }
                            a();
                            throw th9;
                        }
                    }
                } catch (java.lang.Throwable th13) {
                    byteArrayOutputStream = null;
                    dataOutputStream2 = dataOutputStream3;
                    inputStream = inputStream2;
                    th = th13;
                }
            } else {
                com.getui.gtc.a.a.d dVar3 = this.a;
                if (dVar3 != null) {
                    this.b.getResponseCode();
                    dVar3.b();
                }
                inputStream2 = null;
                byteArrayOutputStream2 = null;
            }
            try {
                dataOutputStream3.close();
            } catch (java.lang.Throwable th14) {
                com.getui.gtc.h.c.a.c(th14);
            }
            if (inputStream2 != null) {
                try {
                    inputStream2.close();
                } catch (java.lang.Throwable th15) {
                    com.getui.gtc.h.c.a.c(th15);
                }
            }
            if (byteArrayOutputStream2 != null) {
                try {
                    byteArrayOutputStream2.close();
                } catch (java.lang.Throwable th16) {
                    th = th16;
                    com.getui.gtc.h.c.a.c(th);
                    a();
                    return null;
                }
            }
        } catch (java.lang.Throwable th17) {
            th = th17;
            byteArrayOutputStream = null;
            dataOutputStream = dataOutputStream3;
            inputStream = null;
        }
        a();
        return null;
    }

    private byte[] a(byte[] bArr) {
        try {
            byte[] a = com.getui.gtc.a.a.e.a(bArr);
            byte[] bArr2 = new byte[0];
            if (a == null) {
                a = bArr2;
            }
            java.lang.String valueOf = java.lang.String.valueOf(java.lang.System.currentTimeMillis());
            byte[] bArr3 = new byte[16];
            new java.security.SecureRandom().nextBytes(bArr3);
            java.security.PublicKey generatePublic = java.security.KeyFactory.getInstance(com.alipay.sdk.m.n.d.a).generatePublic(new java.security.spec.X509EncodedKeySpec(android.util.Base64.decode("MHwwDQYJKoZIhvcNAQEBBQADawAwaAJhAJp1rROuvBF7sBSnvLaesj2iFhMcY8aXyLvpnNLKs2wjL3JmEnyr++SlVa35liUlzi83tnAFkn3A9GB7pHBNzawyUkBh8WUhq5bnFIkk2RaDa6+5MpG84DEv52p7RR+aWwIDAQAB", 0)));
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("RSA/NONE/OAEPWithSHA1AndMGF1Padding");
            cipher.init(1, generatePublic);
            byte[] doFinal = cipher.doFinal(this.d.getEncoded());
            byte[] bArr4 = new byte[doFinal.length + 16];
            java.lang.System.arraycopy(bArr3, 0, bArr4, 0, 16);
            java.lang.System.arraycopy(doFinal, 0, bArr4, 16, doFinal.length);
            java.lang.String encodeToString = android.util.Base64.encodeToString(bArr4, 2);
            byte[] bytes = valueOf.getBytes();
            byte[] bArr5 = new byte[bytes.length + a.length];
            java.lang.System.arraycopy(bytes, 0, bArr5, 0, bytes.length);
            java.lang.System.arraycopy(a, 0, bArr5, bytes.length, a.length);
            java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("SHA1");
            messageDigest.update(bArr5);
            java.lang.String encodeToString2 = android.util.Base64.encodeToString(messageDigest.digest(), 2);
            java.security.MessageDigest messageDigest2 = java.security.MessageDigest.getInstance("MD5");
            messageDigest2.update(encodeToString2.getBytes());
            javax.crypto.spec.IvParameterSpec ivParameterSpec = new javax.crypto.spec.IvParameterSpec(messageDigest2.digest());
            javax.crypto.Cipher cipher2 = javax.crypto.Cipher.getInstance("AES/CFB/NoPadding");
            cipher2.init(1, this.d, ivParameterSpec);
            byte[] doFinal2 = cipher2.doFinal(a);
            this.b.addRequestProperty("GT_T", valueOf);
            this.b.addRequestProperty("GT_C_T", "1");
            this.b.addRequestProperty("GT_C_K", "69d747c4b9f641baf4004be4297e9f3b");
            this.b.addRequestProperty("GT_C_V", encodeToString);
            this.b.addRequestProperty("GT_C_S", encodeToString2);
            return doFinal2;
        } catch (java.lang.Throwable th) {
            com.getui.gtc.h.c.a.c(th);
            return null;
        }
    }

    @android.annotation.TargetApi(21)
    private byte[] b(java.util.Map<java.lang.String, java.util.List<java.lang.String>> map) {
        java.io.InputStream inputStream;
        java.io.ByteArrayOutputStream byteArrayOutputStream;
        java.net.HttpURLConnection httpURLConnection;
        try {
            java.net.URL url = new java.net.URL(this.a.a);
            android.net.Network network = this.a.c;
            this.b = network == null ? (java.net.HttpURLConnection) url.openConnection() : (java.net.HttpURLConnection) network.openConnection(url);
            this.b.setConnectTimeout(this.a.h);
            this.b.setReadTimeout(this.a.i);
            this.b.setDoInput(this.a.k);
            this.b.setRequestMethod("GET");
            this.b.setUseCaches(this.a.l);
            this.b.setInstanceFollowRedirects(this.a.m);
            for (java.lang.String str : this.a.n.keySet()) {
                this.b.setRequestProperty(str, this.a.n.get(str));
            }
            if (this.a.d && (httpURLConnection = this.b) != null) {
                try {
                    httpURLConnection.addRequestProperty("GT_C_T", "1");
                    httpURLConnection.addRequestProperty("GT_C_K", "69d747c4b9f641baf4004be4297e9f3b");
                    byte[] bArr = new byte[16];
                    new java.security.SecureRandom().nextBytes(bArr);
                    java.security.PublicKey generatePublic = java.security.KeyFactory.getInstance(com.alipay.sdk.m.n.d.a).generatePublic(new java.security.spec.X509EncodedKeySpec(android.util.Base64.decode("MHwwDQYJKoZIhvcNAQEBBQADawAwaAJhAJp1rROuvBF7sBSnvLaesj2iFhMcY8aXyLvpnNLKs2wjL3JmEnyr++SlVa35liUlzi83tnAFkn3A9GB7pHBNzawyUkBh8WUhq5bnFIkk2RaDa6+5MpG84DEv52p7RR+aWwIDAQAB", 0)));
                    javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("RSA/NONE/OAEPWithSHA1AndMGF1Padding");
                    cipher.init(1, generatePublic);
                    byte[] doFinal = cipher.doFinal(this.d.getEncoded());
                    byte[] bArr2 = new byte[doFinal.length + 16];
                    java.lang.System.arraycopy(bArr, 0, bArr2, 0, 16);
                    java.lang.System.arraycopy(doFinal, 0, bArr2, 16, doFinal.length);
                    httpURLConnection.addRequestProperty("GT_C_V", android.util.Base64.encodeToString(bArr2, 2));
                    java.lang.String valueOf = java.lang.String.valueOf(java.lang.System.currentTimeMillis());
                    httpURLConnection.addRequestProperty("GT_T", valueOf);
                    byte[] bytes = valueOf.getBytes();
                    byte[] bArr3 = new byte[bytes.length + 0];
                    java.lang.System.arraycopy(bytes, 0, bArr3, 0, bytes.length);
                    java.lang.System.arraycopy(new byte[0], 0, bArr3, bytes.length, 0);
                    java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("SHA1");
                    messageDigest.update(bArr3);
                    httpURLConnection.addRequestProperty("GT_C_S", android.util.Base64.encodeToString(messageDigest.digest(), 2));
                } catch (java.lang.Throwable th) {
                    com.getui.gtc.h.c.a.c(th);
                }
            }
            inputStream = this.b.getInputStream();
            try {
                byteArrayOutputStream = new java.io.ByteArrayOutputStream();
                try {
                    if (this.b.getResponseCode() == 200) {
                        if (this.b.getHeaderFields() != null) {
                            map.putAll(this.b.getHeaderFields());
                        }
                        byte[] bArr4 = new byte[1024];
                        while (true) {
                            int read = inputStream.read(bArr4);
                            if (read == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr4, 0, read);
                        }
                        if (byteArrayOutputStream.toByteArray() != null) {
                            byte[] a = a(this.b, byteArrayOutputStream.toByteArray());
                            try {
                                inputStream.close();
                            } catch (java.lang.Throwable th2) {
                                com.getui.gtc.h.c.a.c(th2);
                            }
                            try {
                                byteArrayOutputStream.close();
                            } catch (java.lang.Throwable th3) {
                                com.getui.gtc.h.c.a.c(th3);
                            }
                            a();
                            return a;
                        }
                    } else {
                        com.getui.gtc.a.a.d dVar = this.a;
                        if (dVar != null) {
                            this.b.getResponseCode();
                            dVar.b();
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (java.lang.Throwable th4) {
                            com.getui.gtc.h.c.a.c(th4);
                        }
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (java.lang.Throwable th5) {
                        th = th5;
                        com.getui.gtc.h.c.a.c(th);
                        a();
                        return null;
                    }
                } catch (java.lang.Throwable th6) {
                    th = th6;
                    try {
                        com.getui.gtc.a.a.d dVar2 = this.a;
                        if (dVar2 != null) {
                            dVar2.a();
                        }
                        com.getui.gtc.h.c.a.c(th);
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (java.lang.Throwable th7) {
                                com.getui.gtc.h.c.a.c(th7);
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (java.lang.Throwable th8) {
                                th = th8;
                                com.getui.gtc.h.c.a.c(th);
                                a();
                                return null;
                            }
                        }
                        a();
                        return null;
                    } catch (java.lang.Throwable th9) {
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (java.lang.Throwable th10) {
                                com.getui.gtc.h.c.a.c(th10);
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (java.lang.Throwable th11) {
                                com.getui.gtc.h.c.a.c(th11);
                            }
                        }
                        a();
                        throw th9;
                    }
                }
            } catch (java.lang.Throwable th12) {
                th = th12;
                byteArrayOutputStream = null;
            }
        } catch (java.lang.Throwable th13) {
            th = th13;
            inputStream = null;
            byteArrayOutputStream = null;
        }
        a();
        return null;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            android.os.Process.setThreadPriority(10);
            if (this.c) {
                return;
            }
            this.c = false;
            com.getui.gtc.a.a.d dVar = this.a;
            if (dVar == null || android.text.TextUtils.isEmpty(dVar.a)) {
                return;
            }
            java.util.HashMap hashMap = new java.util.HashMap();
            byte[] b = this.a.b == null ? b(hashMap) : a(hashMap);
            if (b != null) {
                this.a.a(hashMap, b);
            }
        } catch (java.lang.Throwable th) {
            com.getui.gtc.h.c.a.c(th);
        }
    }
}
