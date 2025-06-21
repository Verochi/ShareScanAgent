package com.bytedance.pangle.g;

/* loaded from: classes12.dex */
final class o {
    public static final com.bytedance.pangle.g.o a = new com.bytedance.pangle.g.o(null, 0, null, null, null);

    @androidx.annotation.Nullable
    public final android.content.pm.Signature[] b;
    public final int c;

    @androidx.annotation.Nullable
    public final android.util.ArraySet<java.security.PublicKey> d;

    @androidx.annotation.Nullable
    public final android.content.pm.Signature[] e;

    @androidx.annotation.Nullable
    public final int[] f;

    public o(android.content.pm.Signature[] signatureArr) {
        this(signatureArr, 2, null, null);
    }

    public o(android.content.pm.Signature[] signatureArr, int i, android.util.ArraySet<java.security.PublicKey> arraySet, android.content.pm.Signature[] signatureArr2, int[] iArr) {
        this.b = signatureArr;
        this.c = i;
        this.d = arraySet;
        this.e = signatureArr2;
        this.f = iArr;
    }

    public o(android.content.pm.Signature[] signatureArr, int i, android.content.pm.Signature[] signatureArr2, int[] iArr) {
        this(signatureArr, i, a(signatureArr), signatureArr2, iArr);
    }

    private static android.util.ArraySet<java.security.PublicKey> a(android.content.pm.Signature[] signatureArr) {
        java.lang.reflect.Method method;
        android.util.ArraySet<java.security.PublicKey> arraySet = new android.util.ArraySet<>(signatureArr.length);
        for (android.content.pm.Signature signature : signatureArr) {
            try {
                method = android.content.pm.Signature.class.getMethod("getPublicKey", new java.lang.Class[0]);
            } catch (java.lang.NoSuchMethodException e) {
                e.printStackTrace();
                method = null;
            }
            if (method != null && method.isAccessible()) {
                try {
                    arraySet.add((java.security.PublicKey) method.invoke(signature, new java.lang.Object[0]));
                } catch (java.lang.IllegalAccessException e2) {
                    e2.printStackTrace();
                } catch (java.lang.reflect.InvocationTargetException e3) {
                    e3.printStackTrace();
                } catch (java.lang.Exception e4) {
                    e4.printStackTrace();
                }
            }
        }
        return arraySet;
    }

    public static boolean a(byte[] bArr, byte[] bArr2) {
        if (bArr.length != bArr2.length) {
            return false;
        }
        for (int i = 0; i < bArr.length; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean a(android.content.pm.Signature[] signatureArr, android.content.pm.Signature[] signatureArr2) {
        return signatureArr.length == signatureArr2.length && com.bytedance.pangle.util.d.a((java.lang.Object[]) signatureArr, (java.lang.Object[]) signatureArr2) && com.bytedance.pangle.util.d.a((java.lang.Object[]) signatureArr2, (java.lang.Object[]) signatureArr);
    }

    public final boolean equals(java.lang.Object obj) {
        boolean equals;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof com.bytedance.pangle.g.o)) {
            return false;
        }
        com.bytedance.pangle.g.o oVar = (com.bytedance.pangle.g.o) obj;
        if (this.c != oVar.c || !a(this.b, oVar.b)) {
            return false;
        }
        android.util.ArraySet<java.security.PublicKey> arraySet = this.d;
        if (arraySet != null) {
            equals = arraySet.equals(oVar.d);
            if (!equals) {
                return false;
            }
        } else if (oVar.d != null) {
            return false;
        }
        return java.util.Arrays.equals(this.e, oVar.e) && java.util.Arrays.equals(this.f, oVar.f);
    }

    public final int hashCode() {
        int hashCode = ((java.util.Arrays.hashCode(this.b) * 31) + this.c) * 31;
        android.util.ArraySet<java.security.PublicKey> arraySet = this.d;
        return ((((hashCode + (arraySet != null ? arraySet.hashCode() : 0)) * 31) + java.util.Arrays.hashCode(this.e)) * 31) + java.util.Arrays.hashCode(this.f);
    }
}
