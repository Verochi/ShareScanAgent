package com.bytedance.pangle.g;

@androidx.annotation.RequiresApi(api = 21)
/* loaded from: classes12.dex */
public final class c {

    public static class a extends java.lang.Exception {
    }

    public static class b {
        public final java.util.List<java.security.cert.X509Certificate> a;
        public final java.util.List<java.lang.Integer> b;

        public b(java.util.List<java.security.cert.X509Certificate> list, java.util.List<java.lang.Integer> list2) {
            this.a = list;
            this.b = list2;
        }
    }

    /* renamed from: com.bytedance.pangle.g.c$c, reason: collision with other inner class name */
    public static class C0269c {
        public final java.security.cert.X509Certificate[] a;
        public final com.bytedance.pangle.g.c.b b;
        public byte[] c;

        public C0269c(java.security.cert.X509Certificate[] x509CertificateArr, com.bytedance.pangle.g.c.b bVar) {
            this.a = x509CertificateArr;
            this.b = bVar;
        }
    }

    private static com.bytedance.pangle.g.c.b a(java.nio.ByteBuffer byteBuffer, java.security.cert.CertificateFactory certificateFactory) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        int i = 0;
        try {
            byteBuffer.getInt();
            java.util.HashSet hashSet = new java.util.HashSet();
            int i2 = -1;
            com.bytedance.pangle.g.p pVar = null;
            while (byteBuffer.hasRemaining()) {
                i++;
                java.nio.ByteBuffer a2 = com.bytedance.pangle.g.f.a(byteBuffer);
                java.nio.ByteBuffer a3 = com.bytedance.pangle.g.f.a(a2);
                int i3 = a2.getInt();
                int i4 = a2.getInt();
                byte[] b2 = com.bytedance.pangle.g.f.b(a2);
                if (pVar != null) {
                    android.util.Pair<java.lang.String, ? extends java.security.spec.AlgorithmParameterSpec> d = com.bytedance.pangle.g.f.d(i2);
                    java.security.PublicKey publicKey = pVar.getPublicKey();
                    java.security.Signature signature = java.security.Signature.getInstance((java.lang.String) d.first);
                    signature.initVerify(publicKey);
                    java.lang.Object obj = d.second;
                    if (obj != null) {
                        signature.setParameter((java.security.spec.AlgorithmParameterSpec) obj);
                    }
                    signature.update(a3);
                    if (!signature.verify(b2)) {
                        throw new java.lang.SecurityException("Unable to verify signature of certificate #" + i + " using " + ((java.lang.String) d.first) + " when verifying Proof-of-rotation record");
                    }
                }
                a3.rewind();
                byte[] b3 = com.bytedance.pangle.g.f.b(a3);
                int i5 = a3.getInt();
                if (pVar != null && i2 != i5) {
                    throw new java.lang.SecurityException("Signing algorithm ID mismatch for certificate #" + i + " when verifying Proof-of-rotation record");
                }
                pVar = new com.bytedance.pangle.g.p((java.security.cert.X509Certificate) certificateFactory.generateCertificate(new java.io.ByteArrayInputStream(b3)), b3);
                if (hashSet.contains(pVar)) {
                    throw new java.lang.SecurityException("Encountered duplicate entries in Proof-of-rotation record at certificate #" + i + ".  All signing certificates should be unique");
                }
                hashSet.add(pVar);
                arrayList.add(pVar);
                arrayList2.add(java.lang.Integer.valueOf(i3));
                i2 = i4;
            }
            return new com.bytedance.pangle.g.c.b(arrayList, arrayList2);
        } catch (java.io.IOException e) {
            e = e;
            throw new java.io.IOException("Failed to parse Proof-of-rotation record", e);
        } catch (java.nio.BufferUnderflowException e2) {
            e = e2;
            throw new java.io.IOException("Failed to parse Proof-of-rotation record", e);
        } catch (java.security.InvalidAlgorithmParameterException e3) {
            e = e3;
            throw new java.lang.SecurityException("Failed to verify signature over signed data for certificate #0 when verifying Proof-of-rotation record", e);
        } catch (java.security.InvalidKeyException e4) {
            e = e4;
            throw new java.lang.SecurityException("Failed to verify signature over signed data for certificate #0 when verifying Proof-of-rotation record", e);
        } catch (java.security.NoSuchAlgorithmException e5) {
            e = e5;
            throw new java.lang.SecurityException("Failed to verify signature over signed data for certificate #0 when verifying Proof-of-rotation record", e);
        } catch (java.security.SignatureException e6) {
            e = e6;
            throw new java.lang.SecurityException("Failed to verify signature over signed data for certificate #0 when verifying Proof-of-rotation record", e);
        } catch (java.security.cert.CertificateException e7) {
            throw new java.lang.SecurityException("Failed to decode certificate #0 when verifying Proof-of-rotation record", e7);
        }
    }

    public static com.bytedance.pangle.g.c.C0269c a(java.io.RandomAccessFile randomAccessFile, com.bytedance.pangle.g.m mVar) {
        android.util.ArrayMap arrayMap = new android.util.ArrayMap();
        try {
            java.security.cert.CertificateFactory certificateFactory = java.security.cert.CertificateFactory.getInstance("X.509");
            try {
                java.nio.ByteBuffer a2 = com.bytedance.pangle.g.f.a(mVar.a);
                int i = 0;
                com.bytedance.pangle.g.c.C0269c c0269c = null;
                while (a2.hasRemaining()) {
                    try {
                        c0269c = a(com.bytedance.pangle.g.f.a(a2), arrayMap, certificateFactory);
                        i++;
                    } catch (com.bytedance.pangle.g.c.a unused) {
                    } catch (java.io.IOException e) {
                        e = e;
                        throw new java.lang.SecurityException("Failed to parse/verify signer #" + i + " block", e);
                    } catch (java.lang.SecurityException e2) {
                        e = e2;
                        throw new java.lang.SecurityException("Failed to parse/verify signer #" + i + " block", e);
                    } catch (java.nio.BufferUnderflowException e3) {
                        e = e3;
                        throw new java.lang.SecurityException("Failed to parse/verify signer #" + i + " block", e);
                    }
                }
                if (i <= 0 || c0269c == null) {
                    throw new java.lang.SecurityException("No signers found");
                }
                if (i != 1) {
                    throw new java.lang.SecurityException("APK Signature Scheme V3 only supports one signer: multiple signers found.");
                }
                if (arrayMap.isEmpty()) {
                    throw new java.lang.SecurityException("No content digests found");
                }
                com.bytedance.pangle.g.f.a(arrayMap, randomAccessFile, mVar);
                if (arrayMap.containsKey(3)) {
                    c0269c.c = com.bytedance.pangle.g.f.a((byte[]) arrayMap.get(3), randomAccessFile.length(), mVar);
                }
                return c0269c;
            } catch (java.io.IOException e4) {
                throw new java.lang.SecurityException("Failed to read list of signers", e4);
            }
        } catch (java.security.cert.CertificateException e5) {
            throw new java.lang.RuntimeException("Failed to obtain X.509 CertificateFactory", e5);
        }
    }

    private static com.bytedance.pangle.g.c.C0269c a(java.nio.ByteBuffer byteBuffer, java.util.List<java.security.cert.X509Certificate> list, java.security.cert.CertificateFactory certificateFactory) {
        java.security.cert.X509Certificate[] x509CertificateArr = (java.security.cert.X509Certificate[]) list.toArray(new java.security.cert.X509Certificate[list.size()]);
        com.bytedance.pangle.g.c.b bVar = null;
        while (byteBuffer.hasRemaining()) {
            java.nio.ByteBuffer a2 = com.bytedance.pangle.g.f.a(byteBuffer);
            if (a2.remaining() < 4) {
                throw new java.io.IOException("Remaining buffer too short to contain additional attribute ID. Remaining: " + a2.remaining());
            }
            if (a2.getInt() == 1000370060) {
                if (bVar != null) {
                    throw new java.lang.SecurityException("Encountered multiple Proof-of-rotation records when verifying APK Signature Scheme v3 signature");
                }
                bVar = a(a2, certificateFactory);
                try {
                    if (bVar.a.size() > 0) {
                        if (!java.util.Arrays.equals(bVar.a.get(r1.size() - 1).getEncoded(), x509CertificateArr[0].getEncoded())) {
                            throw new java.lang.SecurityException("Terminal certificate in Proof-of-rotation record does not match APK signing certificate");
                        }
                    } else {
                        continue;
                    }
                } catch (java.security.cert.CertificateEncodingException e) {
                    throw new java.lang.SecurityException("Failed to encode certificate when comparing Proof-of-rotation record and signing certificate", e);
                }
            }
        }
        return new com.bytedance.pangle.g.c.C0269c(x509CertificateArr, bVar);
    }

    private static com.bytedance.pangle.g.c.C0269c a(java.nio.ByteBuffer byteBuffer, java.util.Map<java.lang.Integer, byte[]> map, java.security.cert.CertificateFactory certificateFactory) {
        java.nio.ByteBuffer a2 = com.bytedance.pangle.g.f.a(byteBuffer);
        int i = byteBuffer.getInt();
        int i2 = byteBuffer.getInt();
        java.nio.ByteBuffer a3 = com.bytedance.pangle.g.f.a(byteBuffer);
        byte[] b2 = com.bytedance.pangle.g.f.b(byteBuffer);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        int i3 = -1;
        int i4 = 0;
        byte[] bArr = null;
        while (true) {
            int i5 = 8;
            boolean z = true;
            if (!a3.hasRemaining()) {
                if (i3 == -1) {
                    if (i4 == 0) {
                        throw new java.lang.SecurityException("No signatures found");
                    }
                    throw new java.lang.SecurityException("No supported signatures found");
                }
                java.lang.String c = com.bytedance.pangle.g.f.c(i3);
                android.util.Pair<java.lang.String, ? extends java.security.spec.AlgorithmParameterSpec> d = com.bytedance.pangle.g.f.d(i3);
                java.lang.String str = (java.lang.String) d.first;
                java.security.spec.AlgorithmParameterSpec algorithmParameterSpec = (java.security.spec.AlgorithmParameterSpec) d.second;
                try {
                    java.security.PublicKey generatePublic = java.security.KeyFactory.getInstance(c).generatePublic(new java.security.spec.X509EncodedKeySpec(b2));
                    java.security.Signature signature = java.security.Signature.getInstance(str);
                    signature.initVerify(generatePublic);
                    if (algorithmParameterSpec != null) {
                        signature.setParameter(algorithmParameterSpec);
                    }
                    signature.update(a2);
                    if (!signature.verify(bArr)) {
                        throw new java.lang.SecurityException(str + " signature did not verify");
                    }
                    a2.clear();
                    java.nio.ByteBuffer a4 = com.bytedance.pangle.g.f.a(a2);
                    java.util.ArrayList arrayList2 = new java.util.ArrayList();
                    byte[] bArr2 = null;
                    int i6 = 0;
                    while (a4.hasRemaining()) {
                        i6++;
                        try {
                            java.nio.ByteBuffer a5 = com.bytedance.pangle.g.f.a(a4);
                            if (a5.remaining() < i5) {
                                throw new java.io.IOException("Record too short");
                            }
                            int i7 = a5.getInt();
                            arrayList2.add(java.lang.Integer.valueOf(i7));
                            if (i7 == i3) {
                                bArr2 = com.bytedance.pangle.g.f.b(a5);
                            }
                            i5 = 8;
                        } catch (java.io.IOException | java.nio.BufferUnderflowException e) {
                            throw new java.io.IOException("Failed to parse digest record #".concat(java.lang.String.valueOf(i6)), e);
                        }
                    }
                    if (!arrayList.equals(arrayList2)) {
                        throw new java.lang.SecurityException("Signature algorithms don't match between digests and signatures records");
                    }
                    int a6 = com.bytedance.pangle.g.f.a(i3);
                    byte[] put = map.put(java.lang.Integer.valueOf(a6), bArr2);
                    if (put != null && !java.security.MessageDigest.isEqual(put, bArr2)) {
                        throw new java.lang.SecurityException(com.bytedance.pangle.g.f.b(a6) + " contents digest does not match the digest specified by a preceding signer");
                    }
                    java.nio.ByteBuffer a7 = com.bytedance.pangle.g.f.a(a2);
                    java.util.ArrayList arrayList3 = new java.util.ArrayList();
                    int i8 = 0;
                    while (a7.hasRemaining()) {
                        i8++;
                        byte[] b3 = com.bytedance.pangle.g.f.b(a7);
                        try {
                            arrayList3.add(new com.bytedance.pangle.g.p((java.security.cert.X509Certificate) certificateFactory.generateCertificate(new java.io.ByteArrayInputStream(b3)), b3));
                        } catch (java.security.cert.CertificateException e2) {
                            throw new java.lang.SecurityException("Failed to decode certificate #".concat(java.lang.String.valueOf(i8)), e2);
                        }
                    }
                    if (arrayList3.isEmpty()) {
                        throw new java.lang.SecurityException("No certificates listed");
                    }
                    if (!java.util.Arrays.equals(b2, ((java.security.cert.X509Certificate) arrayList3.get(0)).getPublicKey().getEncoded())) {
                        throw new java.lang.SecurityException("Public key mismatch between certificate and signature record");
                    }
                    if (a2.getInt() != i) {
                        throw new java.lang.SecurityException("minSdkVersion mismatch between signed and unsigned in v3 signer block.");
                    }
                    if (a2.getInt() == i2) {
                        return a(com.bytedance.pangle.g.f.a(a2), arrayList3, certificateFactory);
                    }
                    throw new java.lang.SecurityException("maxSdkVersion mismatch between signed and unsigned in v3 signer block.");
                } catch (java.security.InvalidAlgorithmParameterException | java.security.InvalidKeyException | java.security.NoSuchAlgorithmException | java.security.SignatureException | java.security.spec.InvalidKeySpecException e3) {
                    throw new java.lang.SecurityException(org.apache.tools.ant.taskdefs.VerifyJar.ERROR_NO_VERIFY + str + " signature", e3);
                }
            }
            i4++;
            try {
                java.nio.ByteBuffer a8 = com.bytedance.pangle.g.f.a(a3);
                if (a8.remaining() < 8) {
                    throw new java.lang.SecurityException("Signature record too short");
                }
                int i9 = a8.getInt();
                arrayList.add(java.lang.Integer.valueOf(i9));
                if (i9 != 513 && i9 != 514 && i9 != 769 && i9 != 1057 && i9 != 1059 && i9 != 1061) {
                    switch (i9) {
                        case 257:
                        case 258:
                        case 259:
                        case 260:
                            break;
                        default:
                            z = false;
                            break;
                    }
                }
                if (z && (i3 == -1 || com.bytedance.pangle.g.f.a(i9, i3) > 0)) {
                    bArr = com.bytedance.pangle.g.f.b(a8);
                    i3 = i9;
                }
            } catch (java.io.IOException | java.nio.BufferUnderflowException e4) {
                throw new java.lang.SecurityException("Failed to parse signature record #".concat(java.lang.String.valueOf(i4)), e4);
            }
        }
    }
}
