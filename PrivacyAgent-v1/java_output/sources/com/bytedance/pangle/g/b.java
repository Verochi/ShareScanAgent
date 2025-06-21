package com.bytedance.pangle.g;

@androidx.annotation.RequiresApi(api = 21)
/* loaded from: classes12.dex */
public final class b {

    public static class a {
        public final java.security.cert.X509Certificate[][] a;
        public final byte[] b;

        public a(java.security.cert.X509Certificate[][] x509CertificateArr, byte[] bArr) {
            this.a = x509CertificateArr;
            this.b = bArr;
        }
    }

    public static com.bytedance.pangle.g.b.a a(java.io.RandomAccessFile randomAccessFile, com.bytedance.pangle.g.m mVar) {
        android.util.ArrayMap arrayMap = new android.util.ArrayMap();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        try {
            java.security.cert.CertificateFactory certificateFactory = java.security.cert.CertificateFactory.getInstance("X.509");
            try {
                java.nio.ByteBuffer a2 = com.bytedance.pangle.g.f.a(mVar.a);
                int i = 0;
                while (a2.hasRemaining()) {
                    i++;
                    try {
                        arrayList.add(a(com.bytedance.pangle.g.f.a(a2), arrayMap, certificateFactory));
                    } catch (java.io.IOException | java.lang.SecurityException | java.nio.BufferUnderflowException e) {
                        throw new java.lang.SecurityException("Failed to parse/verify signer #" + i + " block", e);
                    }
                }
                if (i <= 0) {
                    throw new java.lang.SecurityException("No signers found");
                }
                if (arrayMap.isEmpty()) {
                    throw new java.lang.SecurityException("No content digests found");
                }
                com.bytedance.pangle.g.f.a(arrayMap, randomAccessFile, mVar);
                return new com.bytedance.pangle.g.b.a((java.security.cert.X509Certificate[][]) arrayList.toArray(new java.security.cert.X509Certificate[arrayList.size()][]), arrayMap.containsKey(3) ? com.bytedance.pangle.g.f.a((byte[]) arrayMap.get(3), randomAccessFile.length(), mVar) : null);
            } catch (java.io.IOException e2) {
                throw new java.lang.SecurityException("Failed to read list of signers", e2);
            }
        } catch (java.security.cert.CertificateException e3) {
            throw new java.lang.RuntimeException("Failed to obtain X.509 CertificateFactory", e3);
        }
    }

    private static void a(java.nio.ByteBuffer byteBuffer) {
        while (byteBuffer.hasRemaining()) {
            java.nio.ByteBuffer a2 = com.bytedance.pangle.g.f.a(byteBuffer);
            if (a2.remaining() < 4) {
                throw new java.io.IOException("Remaining buffer too short to contain additional attribute ID. Remaining: " + a2.remaining());
            }
            if (a2.getInt() == -1091571699) {
                if (a2.remaining() < 4) {
                    throw new java.io.IOException("V2 Signature Scheme Stripping Protection Attribute  value too small. Expected 4 bytes, but found " + a2.remaining());
                }
                if (a2.getInt() == 3) {
                    throw new java.lang.SecurityException("V2 signature indicates APK is signed using APK Signature Scheme v3, but none was found. Signature stripped?");
                }
            }
        }
    }

    private static java.security.cert.X509Certificate[] a(java.nio.ByteBuffer byteBuffer, java.util.Map<java.lang.Integer, byte[]> map, java.security.cert.CertificateFactory certificateFactory) {
        java.nio.ByteBuffer a2 = com.bytedance.pangle.g.f.a(byteBuffer);
        java.nio.ByteBuffer a3 = com.bytedance.pangle.g.f.a(byteBuffer);
        byte[] b = com.bytedance.pangle.g.f.b(byteBuffer);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        byte[] bArr = null;
        byte[] bArr2 = null;
        int i = -1;
        int i2 = 0;
        while (true) {
            boolean z = true;
            if (!a3.hasRemaining()) {
                if (i == -1) {
                    if (i2 == 0) {
                        throw new java.lang.SecurityException("No signatures found");
                    }
                    throw new java.lang.SecurityException("No supported signatures found");
                }
                java.lang.String c = com.bytedance.pangle.g.f.c(i);
                android.util.Pair<java.lang.String, ? extends java.security.spec.AlgorithmParameterSpec> d = com.bytedance.pangle.g.f.d(i);
                java.lang.String str = (java.lang.String) d.first;
                java.security.spec.AlgorithmParameterSpec algorithmParameterSpec = (java.security.spec.AlgorithmParameterSpec) d.second;
                try {
                    java.security.PublicKey generatePublic = java.security.KeyFactory.getInstance(c).generatePublic(new java.security.spec.X509EncodedKeySpec(b));
                    java.security.Signature signature = java.security.Signature.getInstance(str);
                    signature.initVerify(generatePublic);
                    if (algorithmParameterSpec != null) {
                        signature.setParameter(algorithmParameterSpec);
                    }
                    signature.update(a2);
                    if (!signature.verify(bArr2)) {
                        throw new java.lang.SecurityException(str + " signature did not verify");
                    }
                    a2.clear();
                    java.nio.ByteBuffer a4 = com.bytedance.pangle.g.f.a(a2);
                    java.util.ArrayList arrayList2 = new java.util.ArrayList();
                    int i3 = 0;
                    while (a4.hasRemaining()) {
                        i3++;
                        try {
                            java.nio.ByteBuffer a5 = com.bytedance.pangle.g.f.a(a4);
                            if (a5.remaining() < 8) {
                                throw new java.io.IOException("Record too short");
                            }
                            int i4 = a5.getInt();
                            arrayList2.add(java.lang.Integer.valueOf(i4));
                            if (i4 == i) {
                                bArr = com.bytedance.pangle.g.f.b(a5);
                            }
                        } catch (java.io.IOException | java.nio.BufferUnderflowException e) {
                            throw new java.io.IOException("Failed to parse digest record #".concat(java.lang.String.valueOf(i3)), e);
                        }
                    }
                    if (!arrayList.equals(arrayList2)) {
                        throw new java.lang.SecurityException("Signature algorithms don't match between digests and signatures records");
                    }
                    int a6 = com.bytedance.pangle.g.f.a(i);
                    byte[] put = map.put(java.lang.Integer.valueOf(a6), bArr);
                    if (put != null && !java.security.MessageDigest.isEqual(put, bArr)) {
                        throw new java.lang.SecurityException(com.bytedance.pangle.g.f.b(a6) + " contents digest does not match the digest specified by a preceding signer");
                    }
                    java.nio.ByteBuffer a7 = com.bytedance.pangle.g.f.a(a2);
                    java.util.ArrayList arrayList3 = new java.util.ArrayList();
                    int i5 = 0;
                    while (a7.hasRemaining()) {
                        i5++;
                        byte[] b2 = com.bytedance.pangle.g.f.b(a7);
                        try {
                            arrayList3.add(new com.bytedance.pangle.g.p((java.security.cert.X509Certificate) certificateFactory.generateCertificate(new java.io.ByteArrayInputStream(b2)), b2));
                        } catch (java.security.cert.CertificateException e2) {
                            throw new java.lang.SecurityException("Failed to decode certificate #".concat(java.lang.String.valueOf(i5)), e2);
                        }
                    }
                    if (arrayList3.isEmpty()) {
                        throw new java.lang.SecurityException("No certificates listed");
                    }
                    if (!java.util.Arrays.equals(b, ((java.security.cert.X509Certificate) arrayList3.get(0)).getPublicKey().getEncoded())) {
                        throw new java.lang.SecurityException("Public key mismatch between certificate and signature record");
                    }
                    a(com.bytedance.pangle.g.f.a(a2));
                    return (java.security.cert.X509Certificate[]) arrayList3.toArray(new java.security.cert.X509Certificate[arrayList3.size()]);
                } catch (java.security.InvalidAlgorithmParameterException | java.security.InvalidKeyException | java.security.NoSuchAlgorithmException | java.security.SignatureException | java.security.spec.InvalidKeySpecException e3) {
                    throw new java.lang.SecurityException(org.apache.tools.ant.taskdefs.VerifyJar.ERROR_NO_VERIFY + str + " signature", e3);
                }
            }
            i2++;
            try {
                java.nio.ByteBuffer a8 = com.bytedance.pangle.g.f.a(a3);
                if (a8.remaining() < 8) {
                    throw new java.lang.SecurityException("Signature record too short");
                }
                int i6 = a8.getInt();
                arrayList.add(java.lang.Integer.valueOf(i6));
                if (i6 != 513 && i6 != 514 && i6 != 769 && i6 != 1057 && i6 != 1059 && i6 != 1061) {
                    switch (i6) {
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
                if (z && (i == -1 || com.bytedance.pangle.g.f.a(i6, i) > 0)) {
                    bArr2 = com.bytedance.pangle.g.f.b(a8);
                    i = i6;
                }
            } catch (java.io.IOException | java.nio.BufferUnderflowException e4) {
                throw new java.lang.SecurityException("Failed to parse signature record #".concat(java.lang.String.valueOf(i2)), e4);
            }
        }
    }
}
