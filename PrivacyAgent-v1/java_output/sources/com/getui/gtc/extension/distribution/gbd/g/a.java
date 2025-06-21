package com.getui.gtc.extension.distribution.gbd.g;

/* loaded from: classes22.dex */
public final class a implements java.lang.Runnable {
    private static final java.lang.String b = "GBD_AsyncHttpTask";
    public com.getui.gtc.extension.distribution.gbd.g.d a;
    private java.net.HttpURLConnection c;
    private boolean d = false;
    private javax.crypto.spec.SecretKeySpec e;

    public a(com.getui.gtc.extension.distribution.gbd.g.d dVar) {
        this.a = dVar;
        byte[] bArr = new byte[16];
        new java.security.SecureRandom().nextBytes(bArr);
        this.e = new javax.crypto.spec.SecretKeySpec(bArr, "AES/CFB/NoPadding");
    }

    private void a() {
        java.net.HttpURLConnection httpURLConnection = this.c;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
                this.c = null;
            } catch (java.lang.Throwable th) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(th);
                com.getui.gtc.extension.distribution.gbd.n.j.b(b, th.toString());
            }
        }
    }

    private void a(java.net.HttpURLConnection httpURLConnection) {
        if (httpURLConnection == null) {
            return;
        }
        try {
            httpURLConnection.addRequestProperty("GT_C_T", "1");
            httpURLConnection.addRequestProperty("GT_C_K", com.getui.gtc.extension.distribution.gbd.d.d.e);
            byte[] bArr = new byte[16];
            new java.security.SecureRandom().nextBytes(bArr);
            java.security.PublicKey generatePublic = java.security.KeyFactory.getInstance(com.alipay.sdk.m.n.d.a).generatePublic(new java.security.spec.X509EncodedKeySpec(android.util.Base64.decode(com.getui.gtc.extension.distribution.gbd.d.d.d, 0)));
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("RSA/NONE/OAEPWithSHA1AndMGF1Padding");
            cipher.init(1, generatePublic);
            byte[] doFinal = cipher.doFinal(this.e.getEncoded());
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
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
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
            com.getui.gtc.extension.distribution.gbd.g.d dVar = this.a;
            if (!dVar.l) {
                return dVar.o ? com.getui.gtc.extension.distribution.gbd.n.ad.b(com.getui.gtc.extension.distribution.gbd.n.e.a(bArr)) : bArr;
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
                cipher.init(2, this.e, ivParameterSpec);
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
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
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
        java.lang.Object obj;
        try {
            try {
                java.net.URL url = new java.net.URL(this.a.e);
                android.util.Pair<android.net.Network, android.net.ConnectivityManager.NetworkCallback> pair = this.a.j;
                this.c = (pair == null || (obj = pair.first) == null) ? (java.net.HttpURLConnection) url.openConnection() : (java.net.HttpURLConnection) ((android.net.Network) obj).openConnection(url);
                this.c.setConnectTimeout(this.a.p);
                this.c.setReadTimeout(this.a.q);
                this.c.setDoInput(this.a.f332s);
                this.c.setDoOutput(this.a.r);
                this.c.setRequestMethod("POST");
                this.c.setUseCaches(this.a.t);
                this.c.setInstanceFollowRedirects(this.a.u);
                for (java.lang.String str : this.a.v.keySet()) {
                    this.c.setRequestProperty(str, this.a.v.get(str));
                }
                com.getui.gtc.extension.distribution.gbd.g.d dVar = this.a;
                bArr = dVar.f;
                if (dVar.l) {
                    bArr = a(bArr);
                } else if (dVar.n) {
                    bArr = com.getui.gtc.extension.distribution.gbd.n.ad.a(bArr);
                }
            } catch (java.lang.Throwable th) {
                th = th;
                inputStream = null;
                dataOutputStream = null;
                byteArrayOutputStream = null;
            }
        } catch (java.lang.Throwable th2) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th2);
        }
        if (bArr == null) {
            a();
            try {
                com.getui.gtc.extension.distribution.gbd.g.d dVar2 = this.a;
                android.util.Pair<android.net.Network, android.net.ConnectivityManager.NetworkCallback> pair2 = dVar2.j;
                if (pair2 != null && dVar2.k != null && pair2.first != null) {
                    com.getui.gtc.extension.distribution.gbd.n.j.a(b, "unregister net callback");
                    com.getui.gtc.extension.distribution.gbd.g.d dVar3 = this.a;
                    dVar3.k.unregisterNetworkCallback((android.net.ConnectivityManager.NetworkCallback) dVar3.j.second);
                }
            } catch (java.lang.Throwable th3) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(th3);
            }
            return null;
        }
        this.c.connect();
        java.io.DataOutputStream dataOutputStream3 = new java.io.DataOutputStream(this.c.getOutputStream());
        try {
            dataOutputStream3.write(bArr, 0, bArr.length);
            dataOutputStream3.flush();
            if (this.c.getResponseCode() == 200) {
                if (this.c.getHeaderFields() != null) {
                    map.putAll(this.c.getHeaderFields());
                }
                inputStream2 = this.c.getInputStream();
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
                            byte[] a = a(this.c, byteArrayOutputStream2.toByteArray());
                            try {
                                dataOutputStream3.close();
                            } catch (java.lang.Throwable th4) {
                                com.getui.gtc.extension.distribution.gbd.n.j.a(th4);
                            }
                            try {
                                inputStream2.close();
                            } catch (java.lang.Throwable th5) {
                                com.getui.gtc.extension.distribution.gbd.n.j.a(th5);
                            }
                            try {
                                byteArrayOutputStream2.close();
                            } catch (java.lang.Throwable th6) {
                                com.getui.gtc.extension.distribution.gbd.n.j.a(th6);
                            }
                            a();
                            try {
                                com.getui.gtc.extension.distribution.gbd.g.d dVar4 = this.a;
                                android.util.Pair<android.net.Network, android.net.ConnectivityManager.NetworkCallback> pair3 = dVar4.j;
                                if (pair3 != null && dVar4.k != null && pair3.first != null) {
                                    com.getui.gtc.extension.distribution.gbd.n.j.a(b, "unregister net callback");
                                    com.getui.gtc.extension.distribution.gbd.g.d dVar5 = this.a;
                                    dVar5.k.unregisterNetworkCallback((android.net.ConnectivityManager.NetworkCallback) dVar5.j.second);
                                }
                            } catch (java.lang.Throwable th7) {
                                com.getui.gtc.extension.distribution.gbd.n.j.a(th7);
                            }
                            return a;
                        }
                    } catch (java.lang.Throwable th8) {
                        dataOutputStream2 = dataOutputStream3;
                        inputStream = inputStream2;
                        th = th8;
                        byteArrayOutputStream = byteArrayOutputStream2;
                        dataOutputStream = dataOutputStream2;
                        try {
                            com.getui.gtc.extension.distribution.gbd.g.d dVar6 = this.a;
                            if (dVar6 != null) {
                                dVar6.a(th);
                            }
                            com.getui.gtc.extension.distribution.gbd.n.j.b(b, th.toString());
                            if (dataOutputStream != null) {
                                try {
                                    dataOutputStream.close();
                                } catch (java.lang.Throwable th9) {
                                    com.getui.gtc.extension.distribution.gbd.n.j.a(th9);
                                }
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (java.lang.Throwable th10) {
                                    com.getui.gtc.extension.distribution.gbd.n.j.a(th10);
                                }
                            }
                            if (byteArrayOutputStream != null) {
                                try {
                                    byteArrayOutputStream.close();
                                } catch (java.lang.Throwable th11) {
                                    com.getui.gtc.extension.distribution.gbd.n.j.a(th11);
                                }
                            }
                            a();
                            com.getui.gtc.extension.distribution.gbd.g.d dVar7 = this.a;
                            android.util.Pair<android.net.Network, android.net.ConnectivityManager.NetworkCallback> pair4 = dVar7.j;
                            if (pair4 != null && dVar7.k != null && pair4.first != null) {
                                com.getui.gtc.extension.distribution.gbd.n.j.a(b, "unregister net callback");
                                com.getui.gtc.extension.distribution.gbd.g.d dVar8 = this.a;
                                dVar8.k.unregisterNetworkCallback((android.net.ConnectivityManager.NetworkCallback) dVar8.j.second);
                            }
                            return null;
                        } finally {
                        }
                    }
                } catch (java.lang.Throwable th12) {
                    byteArrayOutputStream = null;
                    dataOutputStream2 = dataOutputStream3;
                    inputStream = inputStream2;
                    th = th12;
                }
            } else {
                com.getui.gtc.extension.distribution.gbd.g.d dVar9 = this.a;
                if (dVar9 != null) {
                    dVar9.a(this.c.getResponseCode());
                }
                inputStream2 = null;
                byteArrayOutputStream2 = null;
            }
            try {
                dataOutputStream3.close();
            } catch (java.lang.Throwable th13) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(th13);
            }
            if (inputStream2 != null) {
                try {
                    inputStream2.close();
                } catch (java.lang.Throwable th14) {
                    com.getui.gtc.extension.distribution.gbd.n.j.a(th14);
                }
            }
            if (byteArrayOutputStream2 != null) {
                try {
                    byteArrayOutputStream2.close();
                } catch (java.lang.Throwable th15) {
                    com.getui.gtc.extension.distribution.gbd.n.j.a(th15);
                }
            }
            a();
            com.getui.gtc.extension.distribution.gbd.g.d dVar10 = this.a;
            android.util.Pair<android.net.Network, android.net.ConnectivityManager.NetworkCallback> pair5 = dVar10.j;
            if (pair5 != null && dVar10.k != null && pair5.first != null) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(b, "unregister net callback");
                com.getui.gtc.extension.distribution.gbd.g.d dVar11 = this.a;
                dVar11.k.unregisterNetworkCallback((android.net.ConnectivityManager.NetworkCallback) dVar11.j.second);
            }
        } catch (java.lang.Throwable th16) {
            th = th16;
            byteArrayOutputStream = null;
            dataOutputStream = dataOutputStream3;
            inputStream = null;
        }
        return null;
    }

    private byte[] a(byte[] bArr) {
        try {
            byte[] a = com.getui.gtc.extension.distribution.gbd.n.n.a(bArr);
            byte[] bArr2 = new byte[0];
            if (a == null) {
                a = bArr2;
            }
            java.lang.String valueOf = java.lang.String.valueOf(java.lang.System.currentTimeMillis());
            byte[] bArr3 = new byte[16];
            new java.security.SecureRandom().nextBytes(bArr3);
            java.security.PublicKey generatePublic = java.security.KeyFactory.getInstance(com.alipay.sdk.m.n.d.a).generatePublic(new java.security.spec.X509EncodedKeySpec(android.util.Base64.decode(com.getui.gtc.extension.distribution.gbd.d.d.d, 0)));
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("RSA/NONE/OAEPWithSHA1AndMGF1Padding");
            cipher.init(1, generatePublic);
            byte[] doFinal = cipher.doFinal(this.e.getEncoded());
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
            cipher2.init(1, this.e, ivParameterSpec);
            byte[] doFinal2 = cipher2.doFinal(a);
            this.c.addRequestProperty("GT_T", valueOf);
            this.c.addRequestProperty("GT_C_T", "1");
            this.c.addRequestProperty("GT_C_K", com.getui.gtc.extension.distribution.gbd.d.d.e);
            this.c.addRequestProperty("GT_C_V", encodeToString);
            this.c.addRequestProperty("GT_C_S", encodeToString2);
            return doFinal2;
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            return null;
        }
    }

    private byte[] b(java.util.Map<java.lang.String, java.util.List<java.lang.String>> map) {
        java.io.InputStream inputStream;
        java.io.ByteArrayOutputStream byteArrayOutputStream;
        java.net.HttpURLConnection httpURLConnection;
        try {
            java.net.URL url = new java.net.URL(this.a.e);
            android.net.Network network = this.a.i;
            this.c = network == null ? (java.net.HttpURLConnection) url.openConnection() : (java.net.HttpURLConnection) network.openConnection(url);
            this.c.setConnectTimeout(this.a.p);
            this.c.setReadTimeout(this.a.q);
            this.c.setDoInput(this.a.f332s);
            this.c.setRequestMethod("GET");
            this.c.setUseCaches(this.a.t);
            this.c.setInstanceFollowRedirects(this.a.u);
            if (!android.text.TextUtils.isEmpty(this.a.w)) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(b, this.a.x + " dl with etag = " + this.a.w);
                this.c.addRequestProperty("If-None-Match", this.a.w);
            }
            for (java.lang.String str : this.a.v.keySet()) {
                this.c.setRequestProperty(str, this.a.v.get(str));
            }
            if (this.a.l && (httpURLConnection = this.c) != null) {
                try {
                    httpURLConnection.addRequestProperty("GT_C_T", "1");
                    httpURLConnection.addRequestProperty("GT_C_K", com.getui.gtc.extension.distribution.gbd.d.d.e);
                    byte[] bArr = new byte[16];
                    new java.security.SecureRandom().nextBytes(bArr);
                    java.security.PublicKey generatePublic = java.security.KeyFactory.getInstance(com.alipay.sdk.m.n.d.a).generatePublic(new java.security.spec.X509EncodedKeySpec(android.util.Base64.decode(com.getui.gtc.extension.distribution.gbd.d.d.d, 0)));
                    javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("RSA/NONE/OAEPWithSHA1AndMGF1Padding");
                    cipher.init(1, generatePublic);
                    byte[] doFinal = cipher.doFinal(this.e.getEncoded());
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
                    com.getui.gtc.extension.distribution.gbd.n.j.a(th);
                }
            }
            inputStream = this.c.getInputStream();
            try {
                byteArrayOutputStream = new java.io.ByteArrayOutputStream();
                try {
                    if (this.c.getResponseCode() == 200) {
                        if (this.c.getHeaderFields() != null) {
                            map.putAll(this.c.getHeaderFields());
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
                            byte[] a = a(this.c, byteArrayOutputStream.toByteArray());
                            try {
                                inputStream.close();
                            } catch (java.lang.Throwable th2) {
                                com.getui.gtc.extension.distribution.gbd.n.j.a(th2);
                            }
                            try {
                                byteArrayOutputStream.close();
                            } catch (java.lang.Throwable th3) {
                                com.getui.gtc.extension.distribution.gbd.n.j.a(th3);
                            }
                            a();
                            return a;
                        }
                    } else {
                        com.getui.gtc.extension.distribution.gbd.g.d dVar = this.a;
                        if (dVar != null) {
                            dVar.a(this.c.getResponseCode());
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (java.lang.Throwable th4) {
                            com.getui.gtc.extension.distribution.gbd.n.j.a(th4);
                        }
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (java.lang.Throwable th5) {
                        th = th5;
                        com.getui.gtc.extension.distribution.gbd.n.j.a(th);
                        a();
                        return null;
                    }
                } catch (java.lang.Throwable th6) {
                    th = th6;
                    try {
                        com.getui.gtc.extension.distribution.gbd.g.d dVar2 = this.a;
                        if (dVar2 != null) {
                            dVar2.a(th);
                        }
                        com.getui.gtc.extension.distribution.gbd.n.j.a(th);
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (java.lang.Throwable th7) {
                                com.getui.gtc.extension.distribution.gbd.n.j.a(th7);
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (java.lang.Throwable th8) {
                                th = th8;
                                com.getui.gtc.extension.distribution.gbd.n.j.a(th);
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
                                com.getui.gtc.extension.distribution.gbd.n.j.a(th10);
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (java.lang.Throwable th11) {
                                com.getui.gtc.extension.distribution.gbd.n.j.a(th11);
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
            if (this.d) {
                return;
            }
            this.d = false;
            com.getui.gtc.extension.distribution.gbd.g.d dVar = this.a;
            if (dVar == null) {
                return;
            }
            byte[] bArr = dVar.f;
            if (bArr != null && bArr.length > com.getui.gtc.extension.distribution.gbd.d.d.bQ * 1024) {
                com.getui.gtc.extension.distribution.gbd.n.j.b(b, "http data size (" + this.a.f.length + ") > max size (" + (com.getui.gtc.extension.distribution.gbd.d.d.bQ * 1024) + ")");
                this.a.a(new java.lang.Exception("HttpPlugin length over max size."));
                return;
            }
            if (android.text.TextUtils.isEmpty(dVar.e)) {
                return;
            }
            com.getui.gtc.extension.distribution.gbd.n.j.a(b, "-----------" + this.a.e + "-----------");
            java.util.HashMap hashMap = new java.util.HashMap();
            byte[] b2 = this.a.f == null ? b(hashMap) : a(hashMap);
            if (b2 != null) {
                this.a.a(hashMap, b2);
            }
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
        }
    }
}
