package cn.fly.verify;

/* loaded from: classes.dex */
public class cu implements cn.fly.verify.cw<cn.fly.verify.cu> {
    public static void a(java.io.Closeable... closeableArr) {
        for (java.io.Closeable closeable : closeableArr) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (java.lang.Throwable unused) {
                }
            }
        }
    }

    private byte[] a(byte[] bArr, int i) throws java.lang.Throwable {
        if (bArr.length > i - 1) {
            throw new java.lang.Throwable("Message too large");
        }
        byte[] bArr2 = new byte[i];
        bArr2[0] = 1;
        int length = bArr.length;
        bArr2[1] = (byte) (length >> 24);
        bArr2[2] = (byte) (length >> 16);
        bArr2[3] = (byte) (length >> 8);
        bArr2[4] = (byte) length;
        java.lang.System.arraycopy(bArr, 0, bArr2, i - length, length);
        return bArr2;
    }

    private byte[] a(byte[] bArr, int i, int i2, java.math.BigInteger bigInteger, java.math.BigInteger bigInteger2, int i3) throws java.lang.Throwable {
        if (bArr.length != i2 || i != 0) {
            byte[] bArr2 = new byte[i2];
            java.lang.System.arraycopy(bArr, i, bArr2, 0, i2);
            bArr = bArr2;
        }
        java.math.BigInteger bigInteger3 = new java.math.BigInteger(a(bArr, i3));
        if (bigInteger3.compareTo(bigInteger2) <= 0) {
            return bigInteger3.modPow(bigInteger, bigInteger2).toByteArray();
        }
        throw new java.lang.Throwable("the message must be smaller than the modulue");
    }

    public java.lang.String a(java.io.InputStream inputStream) {
        byte[] bArr = null;
        if (inputStream == null) {
            return null;
        }
        try {
            byte[] bArr2 = new byte[1024];
            java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance(cn.fly.verify.dt.a("003Vhcfkhi"));
            while (true) {
                int read = inputStream.read(bArr2);
                if (read == -1) {
                    break;
                }
                messageDigest.update(bArr2, 0, read);
            }
            bArr = messageDigest.digest();
        } catch (java.lang.Throwable unused) {
        }
        return b(bArr);
    }

    public java.lang.String a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            java.io.ByteArrayInputStream byteArrayInputStream = new java.io.ByteArrayInputStream(bArr, 0, bArr.length);
            java.lang.String a = a(byteArrayInputStream);
            byteArrayInputStream.close();
            return a;
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    public java.util.ArrayList<java.util.HashMap<java.lang.String, java.lang.String>> a(java.util.ArrayList<java.util.HashMap<java.lang.String, java.lang.String>> arrayList, java.util.ArrayList<java.util.HashMap<java.lang.String, java.lang.String>> arrayList2, java.lang.String str) {
        boolean z;
        java.util.ArrayList<java.util.HashMap<java.lang.String, java.lang.String>> arrayList3 = new java.util.ArrayList<>();
        java.util.Iterator<java.util.HashMap<java.lang.String, java.lang.String>> it = arrayList.iterator();
        while (it.hasNext()) {
            java.util.HashMap<java.lang.String, java.lang.String> next = it.next();
            java.lang.String str2 = next.get(str);
            if (!android.text.TextUtils.isEmpty(str2)) {
                java.util.Iterator<java.util.HashMap<java.lang.String, java.lang.String>> it2 = arrayList2.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        z = false;
                        break;
                    }
                    if (str2.equals(it2.next().get(str))) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    arrayList3.add(next);
                }
            }
        }
        return arrayList3;
    }

    @Override // cn.fly.verify.cw
    public boolean a(cn.fly.verify.cu cuVar, java.lang.Class<cn.fly.verify.cu> cls, java.lang.String str, java.lang.Object[] objArr, boolean[] zArr, java.lang.Object[] objArr2, java.lang.Throwable[] thArr) {
        if ("bm5".equals(str) && objArr.length == 1) {
            objArr2[0] = cuVar.a((byte[]) objArr[0]);
            return true;
        }
        if ("sm5".equals(str)) {
            objArr2[0] = cuVar.a((java.io.InputStream) objArr[0]);
            return true;
        }
        if ("thx".equals(str)) {
            objArr2[0] = cuVar.b((byte[]) objArr[0]);
            return true;
        }
        if ("fnil".equals(str) && objArr.length == 3) {
            objArr2[0] = cuVar.a((java.util.ArrayList) objArr[0], (java.util.ArrayList) objArr[1], (java.lang.String) objArr[2]);
            return true;
        }
        if ("aesen".equals(str) && objArr.length == 4) {
            try {
                objArr2[0] = a((java.lang.String) objArr[0], (java.lang.String) objArr[1], (byte[]) objArr[2], (byte[]) objArr[3]);
            } catch (java.lang.Throwable th) {
                objArr2[0] = null;
                thArr[0] = th;
            }
            return true;
        }
        if (cn.fly.verify.dt.a("005dfQfhdcVf").equals(str) && objArr.length == 4) {
            try {
                objArr2[0] = b((java.lang.String) objArr[0], (java.lang.String) objArr[1], (byte[]) objArr[2], (byte[]) objArr[3]);
            } catch (java.lang.Throwable th2) {
                objArr2[0] = null;
                thArr[0] = th2;
            }
            return true;
        }
        if (cn.fly.verify.dt.a("006dfEfhdcffOj").equals(str) && objArr.length == 4) {
            try {
                objArr2[0] = c((java.lang.String) objArr[0], (java.lang.String) objArr[1], (byte[]) objArr[2], (byte[]) objArr[3]);
            } catch (java.lang.Throwable th3) {
                objArr2[0] = null;
                thArr[0] = th3;
            }
            return true;
        }
        if ("enc".equals(str) && objArr.length == 4) {
            try {
                objArr2[0] = a(((java.lang.Integer) objArr[0]).intValue(), (byte[]) objArr[1], (java.math.BigInteger) objArr[2], (java.math.BigInteger) objArr[3]);
            } catch (java.lang.Throwable th4) {
                objArr2[0] = null;
                thArr[0] = th4;
            }
            return true;
        }
        if (!"d".equals(str)) {
            return false;
        }
        if (objArr.length == 1 && (objArr[0] instanceof java.lang.String)) {
            cn.fly.verify.ed.a().a("%s", "[sasa] " + objArr[0]);
        } else if (objArr.length == 1 && (objArr[0] instanceof java.lang.Throwable)) {
            cn.fly.verify.ed.a().a((java.lang.Throwable) objArr[0], "%s", "[sasa]");
        }
        return true;
    }

    public byte[] a(int i, byte[] bArr, java.math.BigInteger bigInteger, java.math.BigInteger bigInteger2) throws java.lang.Throwable {
        int i2 = i / 8;
        int i3 = i2 - 11;
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        java.io.DataOutputStream dataOutputStream = null;
        try {
            java.io.DataOutputStream dataOutputStream2 = new java.io.DataOutputStream(byteArrayOutputStream);
            int i4 = 0;
            while (bArr.length > i4) {
                try {
                    int min = java.lang.Math.min(bArr.length - i4, i3);
                    byte[] a = a(bArr, i4, min, bigInteger, bigInteger2, i2);
                    dataOutputStream2.writeInt(a.length);
                    dataOutputStream2.write(a);
                    i4 += min;
                } catch (java.lang.Throwable th) {
                    th = th;
                    dataOutputStream = dataOutputStream2;
                    a(dataOutputStream);
                    throw th;
                }
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            a(dataOutputStream2);
            return byteArray;
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    public byte[] a(java.lang.String str, java.lang.String str2, byte[] bArr, byte[] bArr2) throws java.lang.Throwable {
        if (bArr == null || bArr2 == null) {
            return null;
        }
        byte[] bArr3 = new byte[16];
        java.lang.System.arraycopy(bArr, 0, bArr3, 0, java.lang.Math.min(bArr.length, 16));
        javax.crypto.spec.SecretKeySpec secretKeySpec = new javax.crypto.spec.SecretKeySpec(bArr3, cn.fly.verify.dt.a("0037elghej"));
        javax.crypto.Cipher b = cn.fly.verify.fi.b(str, str2);
        b.init(1, secretKeySpec);
        byte[] bArr4 = new byte[b.getOutputSize(bArr2.length)];
        b.doFinal(bArr4, b.update(bArr2, 0, bArr2.length, bArr4, 0));
        return bArr4;
    }

    public java.lang.String b(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        for (byte b : bArr) {
            stringBuffer.append(java.lang.String.format("%02x", java.lang.Byte.valueOf(b)));
        }
        return stringBuffer.toString();
    }

    public byte[] b(java.lang.String str, java.lang.String str2, byte[] bArr, byte[] bArr2) throws java.lang.Throwable {
        if (bArr == null || bArr2 == null) {
            return null;
        }
        byte[] bArr3 = new byte[16];
        java.lang.System.arraycopy(bArr, 0, bArr3, 0, java.lang.Math.min(bArr.length, 16));
        javax.crypto.spec.SecretKeySpec secretKeySpec = new javax.crypto.spec.SecretKeySpec(bArr3, cn.fly.verify.dt.a("003Felghej"));
        javax.crypto.Cipher b = cn.fly.verify.fi.b(str, str2);
        b.init(2, secretKeySpec);
        byte[] bArr4 = new byte[b.getOutputSize(bArr2.length)];
        b.doFinal(bArr4, b.update(bArr2, 0, bArr2.length, bArr4, 0));
        return bArr4;
    }

    public byte[] c(java.lang.String str, java.lang.String str2, byte[] bArr, byte[] bArr2) throws java.lang.Throwable {
        if (bArr == null || bArr2 == null) {
            return null;
        }
        byte[] bArr3 = new byte[16];
        java.lang.System.arraycopy(bArr, 0, bArr3, 0, java.lang.Math.min(bArr.length, 16));
        javax.crypto.spec.SecretKeySpec secretKeySpec = new javax.crypto.spec.SecretKeySpec(bArr3, cn.fly.verify.dt.a("003Kelghej"));
        javax.crypto.Cipher b = cn.fly.verify.fi.b(str, str2);
        b.init(2, secretKeySpec);
        return b.doFinal(bArr2);
    }
}
