package com.bytedance.pangle.g;

@androidx.annotation.RequiresApi(api = 21)
/* loaded from: classes12.dex */
public final class d {
    public static com.bytedance.pangle.g.o a(java.lang.String str) {
        int[] iArr;
        java.io.RandomAccessFile randomAccessFile = null;
        android.content.pm.Signature[] signatureArr = null;
        try {
            try {
                java.io.RandomAccessFile randomAccessFile2 = new java.io.RandomAccessFile(str, "r");
                try {
                    try {
                        com.bytedance.pangle.g.f.a(str, randomAccessFile2, -262969152, 1896449818);
                        try {
                            try {
                                try {
                                    com.bytedance.pangle.g.m mVar = com.bytedance.pangle.g.f.a.get(str).get(-262969152);
                                    if (mVar == null) {
                                        throw new com.bytedance.pangle.g.n("findVerifiedSigner, No APK Signature Scheme v3 signature in package");
                                    }
                                    com.bytedance.pangle.g.c.C0269c a = com.bytedance.pangle.g.c.a(randomAccessFile2, mVar);
                                    android.content.pm.Signature[] a2 = a(new java.security.cert.Certificate[][]{a.a});
                                    com.bytedance.pangle.g.c.b bVar = a.b;
                                    if (bVar != null) {
                                        int size = bVar.a.size();
                                        android.content.pm.Signature[] signatureArr2 = new android.content.pm.Signature[size];
                                        iArr = new int[a.b.b.size()];
                                        for (int i = 0; i < size; i++) {
                                            signatureArr2[i] = new android.content.pm.Signature(a.b.a.get(i).getEncoded());
                                            iArr[i] = a.b.b.get(i).intValue();
                                        }
                                        signatureArr = signatureArr2;
                                    } else {
                                        iArr = null;
                                    }
                                    com.bytedance.pangle.g.o oVar = new com.bytedance.pangle.g.o(a2, 3, signatureArr, iArr);
                                    try {
                                        randomAccessFile2.close();
                                    } catch (java.lang.Exception unused) {
                                    }
                                    return oVar;
                                } catch (java.lang.Exception e) {
                                    throw new com.bytedance.pangle.g.q(4, "Failed to collect certificates from " + str + " using APK Signature Scheme v2", e);
                                }
                            } catch (com.bytedance.pangle.g.n unused2) {
                                com.bytedance.pangle.g.o a3 = com.bytedance.pangle.g.a.a(str);
                                try {
                                    randomAccessFile2.close();
                                } catch (java.lang.Exception unused3) {
                                }
                                return a3;
                            }
                        } catch (com.bytedance.pangle.g.n unused4) {
                            com.bytedance.pangle.g.m mVar2 = com.bytedance.pangle.g.f.a.get(str).get(1896449818);
                            if (mVar2 == null) {
                                throw new com.bytedance.pangle.g.n("findVerifiedSigner, No APK Signature Scheme v2 signature in package");
                            }
                            com.bytedance.pangle.g.o oVar2 = new com.bytedance.pangle.g.o(a(com.bytedance.pangle.g.b.a(randomAccessFile2, mVar2).a));
                            try {
                                randomAccessFile2.close();
                            } catch (java.lang.Exception unused5) {
                            }
                            return oVar2;
                        } catch (java.lang.Exception e2) {
                            throw new com.bytedance.pangle.g.q(4, "Failed to collect certificates from " + str + " using APK Signature Scheme v3", e2);
                        }
                    } catch (java.lang.Throwable th) {
                        th = th;
                        randomAccessFile = randomAccessFile2;
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (java.lang.Exception unused6) {
                            }
                        }
                        throw th;
                    }
                } catch (java.lang.Exception e3) {
                    throw new com.bytedance.pangle.g.q(4, "Failed to collect certificates from " + str + " when findSignatureInfo at once", e3);
                }
            } catch (java.lang.Exception unused7) {
                throw new com.bytedance.pangle.g.q(6, "failed to read apk file, minSignatureSchemeVersion : 1, apkPath : ".concat(java.lang.String.valueOf(str)));
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    public static android.content.pm.Signature[] a(java.security.cert.Certificate[][] certificateArr) {
        android.content.pm.Signature[] signatureArr = new android.content.pm.Signature[certificateArr.length];
        for (int i = 0; i < certificateArr.length; i++) {
            if (android.os.Build.VERSION.SDK_INT <= 28) {
                java.lang.reflect.Constructor a = com.bytedance.pangle.b.b.a.a((java.lang.Class<?>) android.content.pm.Signature.class, (java.lang.Class<?>[]) new java.lang.Class[]{java.security.cert.Certificate[].class});
                if (a != null) {
                    a.setAccessible(true);
                }
                if (a != null && a.isAccessible()) {
                    try {
                        signatureArr[i] = (android.content.pm.Signature) a.newInstance(certificateArr[i]);
                    } catch (java.lang.IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (java.lang.InstantiationException e2) {
                        e2.printStackTrace();
                    } catch (java.lang.reflect.InvocationTargetException e3) {
                        e3.printStackTrace();
                    }
                }
            } else {
                signatureArr[i] = new android.content.pm.Signature(certificateArr[i][0].getEncoded());
            }
        }
        return signatureArr;
    }
}
