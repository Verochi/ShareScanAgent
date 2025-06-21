package cn.fly.verify;

/* loaded from: classes.dex */
public final class fb {
    public static final java.lang.String a = cn.fly.verify.dt.a("004Adcdgdidc");
    private static final java.util.concurrent.ThreadPoolExecutor b = new java.util.concurrent.ThreadPoolExecutor(3, 20, 60, java.util.concurrent.TimeUnit.SECONDS, new java.util.concurrent.LinkedBlockingDeque());
    private java.math.BigInteger c;
    private java.math.BigInteger d;
    private cn.fly.verify.fn e;
    private cn.fly.verify.fc f;
    private cn.fly.verify.fc.a g;
    private java.util.concurrent.ThreadPoolExecutor h;

    /* renamed from: cn.fly.verify.fb$1, reason: invalid class name */
    public class AnonymousClass1 implements cn.fly.verify.ez {
        final /* synthetic */ boolean a;
        final /* synthetic */ java.lang.String[] b;
        final /* synthetic */ byte[] c;

        public AnonymousClass1(boolean z, java.lang.String[] strArr, byte[] bArr) {
            this.a = z;
            this.b = strArr;
            this.c = bArr;
        }

        @Override // cn.fly.verify.ez
        public void a(cn.fly.verify.ex exVar) throws java.lang.Throwable {
            java.io.InputStream inputStream;
            java.io.ByteArrayOutputStream byteArrayOutputStream;
            int a = exVar.a();
            java.io.ByteArrayOutputStream byteArrayOutputStream2 = null;
            try {
                inputStream = a == 200 ? exVar.b() : exVar.c();
                try {
                    byteArrayOutputStream = new java.io.ByteArrayOutputStream();
                } catch (java.lang.Throwable th) {
                    th = th;
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
                inputStream = null;
            }
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    } else {
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                if (a != 200) {
                    java.util.HashMap a2 = cn.fly.verify.fm.a(new java.lang.String(byteArray, "utf-8"));
                    a2.put(cn.fly.verify.dt.a("010hiij5ej-idi3dgfh"), java.lang.Integer.valueOf(a));
                    throw new cn.fly.verify.fb.a(cn.fly.verify.fm.a(a2));
                }
                if (this.a) {
                    long a3 = cn.fly.verify.fb.this.a(exVar);
                    if (a3 == -1 || a3 != byteArray.length) {
                        java.util.HashMap hashMap = new java.util.HashMap();
                        hashMap.put(cn.fly.verify.dt.a("010hiij5ej=idiGdgfh"), java.lang.Integer.valueOf(a));
                        hashMap.put(cn.fly.verify.dt.a("006CfhIidi dgfh"), -2);
                        hashMap.put(cn.fly.verify.dt.a("005fQdjdjeddj"), "Illegal content length");
                        throw new cn.fly.verify.fb.a(cn.fly.verify.fm.a(hashMap));
                    }
                    this.b[0] = cn.fly.verify.fb.this.a(this.c, byteArray);
                } else {
                    this.b[0] = new java.lang.String(byteArray, "utf-8");
                }
                cn.fly.verify.dw.a(byteArrayOutputStream, inputStream);
            } catch (java.lang.Throwable th3) {
                th = th3;
                byteArrayOutputStream2 = byteArrayOutputStream;
                cn.fly.verify.dw.a(byteArrayOutputStream2, inputStream);
                throw th;
            }
        }
    }

    public static class a extends java.lang.Exception {
        public a(java.lang.String str) {
            super(str);
        }
    }

    public fb(int i, java.lang.String str, java.lang.String str2) {
        this(i, str, str2, null);
    }

    public fb(int i, java.lang.String str, java.lang.String str2, cn.fly.verify.fc.a aVar) {
        this.e = new cn.fly.verify.fn(i);
        this.c = new java.math.BigInteger(str, 16);
        this.d = new java.math.BigInteger(str2, 16);
        this.f = new cn.fly.verify.fc();
        if (aVar != null) {
            this.g = aVar;
        } else {
            cn.fly.verify.fc.a aVar2 = new cn.fly.verify.fc.a();
            this.g = aVar2;
            aVar2.a = 30000;
            aVar2.b = 5000;
        }
        this.h = b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long a(cn.fly.verify.ex exVar) throws java.lang.Throwable {
        java.util.List<java.lang.String> a2 = a(exVar, cn.fly.verify.dt.a("014Ggked>eifei$hkfcOfeKee7ih"));
        if (a2 == null || a2.size() <= 0) {
            return -1L;
        }
        return java.lang.Long.parseLong(a2.get(0));
    }

    private cn.fly.verify.ez a(byte[] bArr, java.lang.String[] strArr, boolean z) {
        return new cn.fly.verify.fb.AnonymousClass1(z, strArr, bArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <T> T a(boolean z, java.util.HashMap<java.lang.String, java.lang.String> hashMap, java.lang.String str, java.lang.String str2, boolean z2, boolean z3, boolean z4) throws java.lang.Throwable {
        byte[] c = cn.fly.verify.dw.c();
        byte[] a2 = a(c, str, z2);
        java.lang.String[] strArr = new java.lang.String[1];
        cn.fly.verify.ez a3 = a(c, strArr, z4);
        if (z3) {
            java.lang.String encodeToString = android.util.Base64.encodeToString(a2, 2);
            java.util.HashMap<java.lang.String, java.lang.String> a4 = a(z, hashMap, str, encodeToString.getBytes("utf-8").length);
            cn.fly.verify.ff ffVar = new cn.fly.verify.ff();
            ffVar.a(encodeToString);
            cn.fly.verify.ed.a().a(">>>  request(" + str2 + "): " + str + "\nheader = " + a4.toString(), new java.lang.Object[0]);
            this.f.a(str2, a4, ffVar, -1, a3, this.g);
        } else {
            java.util.HashMap<java.lang.String, java.lang.String> a5 = a(z, hashMap, str, -1);
            cn.fly.verify.ed.a().a(">>>  request(" + str2 + "): " + str + "\nheader = " + a5.toString(), new java.lang.Object[0]);
            this.f.a(str2, a2, a5, -1, a3, this.g);
        }
        if (strArr[0] == 0) {
            return null;
        }
        cn.fly.verify.ed.a().a(">>> response(" + str2 + "): " + strArr[0], new java.lang.Object[0]);
        return z4 ? (T) b(strArr[0]) : (T) strArr[0];
    }

    public static java.lang.String a(java.lang.String str) {
        return cn.fly.verify.dw.b(str);
    }

    private java.lang.String a(java.util.HashMap<java.lang.String, java.lang.Object> hashMap) {
        if (hashMap == null) {
            return "{}";
        }
        java.lang.String a2 = cn.fly.verify.fm.a((java.util.HashMap) hashMap);
        return a2.length() == 0 ? "{}" : a2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.lang.String a(byte[] bArr, byte[] bArr2) throws java.lang.Throwable {
        return new java.lang.String(cn.fly.verify.fi.b(bArr, android.util.Base64.decode(bArr2, 2)), "utf-8");
    }

    public static java.util.HashMap<java.lang.String, java.lang.String> a() throws java.lang.Throwable {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put(cn.fly.verify.dt.a("003ZdlIfHdk"), cn.fly.verify.dv.a());
        hashMap.put(cn.fly.verify.dt.a("013'egfh$f-djhkeidc(fei<di iGdk"), cn.fly.verify.bk.c());
        hashMap.put(cn.fly.verify.dt.a("004+dfeddidc"), cn.fly.verify.eh.a(cn.fly.verify.ax.g()).d().ai());
        return hashMap;
    }

    private java.util.HashMap<java.lang.String, java.lang.String> a(java.lang.String str, int i) throws java.lang.Throwable {
        java.util.HashMap<java.lang.String, java.lang.String> a2 = a();
        a2.put(cn.fly.verify.dt.a("004@fhdiee9e"), cn.fly.verify.fi.b(str + cn.fly.verify.ax.e()));
        a2.put(cn.fly.verify.dt.a("014 gkedReifei^hkfc%feRee(ih"), java.lang.String.valueOf(i));
        return a2;
    }

    private java.util.HashMap<java.lang.String, java.lang.String> a(boolean z, java.util.HashMap<java.lang.String, java.lang.String> hashMap, java.lang.String str, int i) throws java.lang.Throwable {
        java.util.HashMap<java.lang.String, java.lang.String> a2 = z ? i > 0 ? a(str, i) : a() : null;
        if (a2 == null) {
            a2 = new java.util.HashMap<>();
        }
        if (hashMap != null) {
            a2.putAll(hashMap);
        }
        return a2;
    }

    private java.util.List<java.lang.String> a(cn.fly.verify.ex exVar, java.lang.String str) throws java.lang.Throwable {
        java.util.Map<java.lang.String, java.util.List<java.lang.String>> d = exVar.d();
        if (d == null || d.isEmpty()) {
            return null;
        }
        for (java.lang.String str2 : d.keySet()) {
            if (str2 != null && str2.equals(str)) {
                return d.get(str2);
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private byte[] a(byte[] bArr, java.lang.String str, boolean z) throws java.lang.Throwable {
        byte[] bytes;
        java.io.ByteArrayOutputStream byteArrayOutputStream;
        java.io.ByteArrayOutputStream byteArrayOutputStream2;
        java.util.zip.GZIPOutputStream gZIPOutputStream;
        java.io.DataOutputStream dataOutputStream = null;
        if (z) {
            try {
                byteArrayOutputStream2 = new java.io.ByteArrayOutputStream();
                try {
                    gZIPOutputStream = new java.util.zip.GZIPOutputStream(byteArrayOutputStream2);
                    try {
                        java.io.BufferedOutputStream bufferedOutputStream = new java.io.BufferedOutputStream(gZIPOutputStream);
                        try {
                            bufferedOutputStream.write(str.getBytes("utf-8"));
                            bufferedOutputStream.flush();
                            cn.fly.verify.dw.a(bufferedOutputStream, gZIPOutputStream, byteArrayOutputStream2);
                            bytes = byteArrayOutputStream2.toByteArray();
                        } catch (java.lang.Throwable th) {
                            th = th;
                            dataOutputStream = bufferedOutputStream;
                            cn.fly.verify.dw.a(dataOutputStream, gZIPOutputStream, byteArrayOutputStream2);
                            throw th;
                        }
                    } catch (java.lang.Throwable th2) {
                        th = th2;
                    }
                } catch (java.lang.Throwable th3) {
                    th = th3;
                    gZIPOutputStream = null;
                }
            } catch (java.lang.Throwable th4) {
                th = th4;
                byteArrayOutputStream2 = null;
                gZIPOutputStream = null;
            }
        } else {
            bytes = str.getBytes("utf-8");
        }
        try {
            byteArrayOutputStream = new java.io.ByteArrayOutputStream();
            try {
                java.io.DataOutputStream dataOutputStream2 = new java.io.DataOutputStream(byteArrayOutputStream);
                try {
                    byte[] a2 = this.e.a(bArr, this.c, this.d);
                    dataOutputStream2.writeInt(a2.length);
                    dataOutputStream2.write(a2);
                    byte[] a3 = cn.fly.verify.fi.a(bArr, bytes);
                    dataOutputStream2.writeInt(a3.length);
                    dataOutputStream2.write(a3);
                    dataOutputStream2.flush();
                    cn.fly.verify.dw.a(dataOutputStream2, byteArrayOutputStream);
                    return byteArrayOutputStream.toByteArray();
                } catch (java.lang.Throwable th5) {
                    th = th5;
                    dataOutputStream = dataOutputStream2;
                    cn.fly.verify.dw.a(dataOutputStream, byteArrayOutputStream);
                    throw th;
                }
            } catch (java.lang.Throwable th6) {
                th = th6;
            }
        } catch (java.lang.Throwable th7) {
            th = th7;
            byteArrayOutputStream = null;
        }
    }

    private java.lang.Object b(java.lang.String str) throws java.lang.Throwable {
        if (str == null) {
            java.util.HashMap hashMap = new java.util.HashMap();
            hashMap.put(cn.fly.verify.dt.a("006*fh+idi>dgfh"), -1);
            hashMap.put(cn.fly.verify.dt.a("005f3djdjeddj"), "RS is empty");
            throw new cn.fly.verify.fb.a(cn.fly.verify.fm.a(hashMap));
        }
        java.util.HashMap a2 = cn.fly.verify.fm.a(str.trim());
        if (!a2.isEmpty()) {
            java.lang.Object obj = a2.get(cn.fly.verify.dt.a("003DdjIfDfh"));
            return obj == null ? a2.get(cn.fly.verify.dt.a("0046dcBdid")) : obj;
        }
        java.util.HashMap hashMap2 = new java.util.HashMap();
        hashMap2.put(cn.fly.verify.dt.a("0063fhYidi3dgfh"), -1);
        hashMap2.put(cn.fly.verify.dt.a("005fKdjdjeddj"), "RS is empty");
        throw new cn.fly.verify.fb.a(cn.fly.verify.fm.a(hashMap2));
    }

    public <T> T a(java.util.HashMap<java.lang.String, java.lang.Object> hashMap, java.lang.String str, boolean z) throws java.lang.Throwable {
        return (T) a((java.util.HashMap<java.lang.String, java.lang.String>) null, hashMap, str, z);
    }

    public <T> T a(java.util.HashMap<java.lang.String, java.lang.String> hashMap, java.util.HashMap<java.lang.String, java.lang.Object> hashMap2, java.lang.String str, boolean z) throws java.lang.Throwable {
        return (T) a(true, hashMap, hashMap2, str, z);
    }

    public <T> T a(boolean z, java.util.HashMap<java.lang.String, java.lang.String> hashMap, java.util.HashMap<java.lang.String, java.lang.Object> hashMap2, java.lang.String str, boolean z2) throws java.lang.Throwable {
        return (T) a(z, hashMap, a(hashMap2), str, z2, true, true);
    }

    public <T> T b(boolean z, java.util.HashMap<java.lang.String, java.lang.String> hashMap, java.util.HashMap<java.lang.String, java.lang.Object> hashMap2, java.lang.String str, boolean z2) throws java.lang.Throwable {
        return (T) a(z, hashMap, a(hashMap2), str, true, false, z2);
    }
}
