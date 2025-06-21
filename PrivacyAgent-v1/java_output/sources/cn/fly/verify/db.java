package cn.fly.verify;

/* loaded from: classes31.dex */
public class db {
    public int a;
    public java.lang.String b;
    public int c;
    public java.lang.String d;
    public java.lang.String e;
    public java.lang.String f;
    public int g;
    public java.lang.String h;
    public int i;
    public int j;
    public int k;
    public java.lang.String l;
    public java.lang.Object[] m;
    public java.lang.String n;
    public java.lang.String[] o;
    public java.lang.String p;
    public java.lang.Object q;
    public int r;

    /* renamed from: s, reason: collision with root package name */
    public int f70s;

    /* loaded from: classes.dex */
    public static class a {
        public int a;
        public cn.fly.verify.cv b;
        public java.util.List<java.lang.Object> c;
        public boolean d;
        public boolean e;
        public java.util.ArrayList<cn.fly.verify.db> f;
        public java.util.ArrayList<java.lang.Object> g;

        public java.lang.Class<?> a(java.lang.String str) {
            return this.b.b(str);
        }

        public java.lang.Object a() {
            return this.b.a();
        }

        public void a(java.lang.Object obj) {
            this.b.a(obj);
        }

        public void a(java.lang.String str, java.lang.Class<?> cls) {
            this.b.a(str, cls);
        }

        public void a(java.lang.String str, java.lang.Object obj) {
            this.b.b(str, obj);
        }

        public java.lang.Object b(java.lang.String str) {
            return this.b.a(str);
        }

        public void b(java.lang.String str, java.lang.Object obj) {
            this.b.a(str, obj);
        }
    }

    public db() {
    }

    public db(int i) {
        this.a = i;
    }

    private java.lang.Object a(java.lang.Object obj, java.lang.Class<?> cls) throws java.lang.Throwable {
        if (obj instanceof java.io.ByteArrayOutputStream) {
            return a(((java.io.ByteArrayOutputStream) obj).toByteArray(), cls);
        }
        if (obj instanceof byte[]) {
            return a(new java.lang.String((byte[]) obj, "utf-8"), cls);
        }
        if ((obj instanceof java.lang.StringBuffer) || (obj instanceof java.lang.StringBuilder)) {
            return a(obj.toString(), cls);
        }
        if (obj instanceof java.lang.String) {
            return cls.getConstructor(java.lang.String.class).newInstance(obj);
        }
        if (obj.getClass().equals(cls)) {
            return obj;
        }
        throw new java.lang.ClassCastException("Failed to cast " + obj + " to be " + cls.getName() + " at line: " + this.b + "(" + this.c + ")");
    }

    private java.lang.Object a(java.lang.Object obj, java.lang.Object obj2, java.lang.Class<?> cls, java.lang.Class<?> cls2) throws java.lang.Throwable {
        if (obj == null || obj2.equals(obj)) {
            return null;
        }
        if (obj.getClass().equals(cls)) {
            java.util.HashMap hashMap = new java.util.HashMap();
            a((java.util.Map) hashMap, obj, cls, cls2);
            return hashMap;
        }
        if (!obj.getClass().equals(cls2)) {
            return obj;
        }
        java.lang.reflect.Field declaredField = cls2.getDeclaredField("values");
        declaredField.setAccessible(true);
        java.util.List list = (java.util.List) declaredField.get(obj);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(a(it.next(), obj2, cls, cls2));
        }
        return arrayList;
    }

    private java.lang.String a(java.io.InputStream inputStream) throws java.lang.Throwable {
        if (inputStream == null) {
            return null;
        }
        byte[] bArr = new byte[1024];
        java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance(cn.fly.verify.dt.a("003=hcfkhi"));
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return a(messageDigest.digest());
            }
            messageDigest.update(bArr, 0, read);
        }
    }

    private java.lang.String a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        for (byte b : bArr) {
            stringBuffer.append(java.lang.String.format("%02x", java.lang.Byte.valueOf(b)));
        }
        return stringBuffer.toString();
    }

    private void a(java.util.Map map, java.lang.Object obj, java.lang.Class<?> cls, java.lang.Class<?> cls2) throws java.lang.Throwable {
        java.lang.reflect.Field declaredField = cls.getDeclaredField("nameValuePairs");
        declaredField.setAccessible(true);
        java.util.Map map2 = (java.util.Map) declaredField.get(obj);
        java.lang.reflect.Field declaredField2 = cls.getDeclaredField("NULL");
        declaredField2.setAccessible(true);
        java.lang.Object obj2 = declaredField2.get(null);
        for (java.util.Map.Entry entry : map2.entrySet()) {
            map.put(entry.getKey(), a(entry.getValue(), obj2, cls, cls2));
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void a(cn.fly.verify.da.a aVar) throws java.lang.Throwable {
        int i = 0;
        switch (this.a) {
            case 1:
                this.h = (java.lang.String) aVar.b();
                aVar.a();
                break;
            case 2:
                this.q = aVar.b();
                break;
            case 3:
            case 9:
            case 19:
                this.h = (java.lang.String) aVar.b();
                break;
            case 4:
            case 5:
                this.k = ((java.lang.Integer) aVar.b()).intValue();
                break;
            case 6:
                this.f70s = ((java.lang.Integer) aVar.b()).intValue();
                break;
            case 7:
                this.r = ((java.lang.Integer) aVar.b()).intValue();
                break;
            case 10:
            case 35:
                this.d = (java.lang.String) aVar.b();
                this.e = (java.lang.String) aVar.b();
                break;
            case 11:
            case 24:
                this.l = (java.lang.String) aVar.b();
                break;
            case 12:
                this.p = (java.lang.String) aVar.b();
                this.i = ((java.lang.Integer) aVar.b()).intValue();
                break;
            case 13:
            case 26:
                this.n = (java.lang.String) aVar.b();
                this.l = (java.lang.String) aVar.b();
                break;
            case 14:
                this.n = (java.lang.String) aVar.b();
                this.p = (java.lang.String) aVar.b();
                this.i = ((java.lang.Integer) aVar.b()).intValue();
                break;
            case 16:
            case 32:
                this.i = ((java.lang.Integer) aVar.b()).intValue();
                break;
            case 17:
            case 27:
                this.n = (java.lang.String) aVar.b();
                break;
            case 18:
                this.n = (java.lang.String) aVar.b();
                this.i = ((java.lang.Integer) aVar.b()).intValue();
                break;
            case 20:
                this.f = (java.lang.String) aVar.b();
                break;
            case 21:
            case 22:
                this.f = (java.lang.String) aVar.b();
                int intValue = ((java.lang.Integer) aVar.b()).intValue();
                this.g = intValue;
                this.g = intValue + aVar.c();
                break;
            case 29:
                this.h = (java.lang.String) aVar.b();
                this.i = ((java.lang.Integer) aVar.b()).intValue();
                int intValue2 = ((java.lang.Integer) aVar.b()).intValue();
                this.j = intValue2;
                this.j = intValue2 + aVar.c();
                break;
            case 31:
                this.h = (java.lang.String) aVar.b();
                this.i = ((java.lang.Integer) aVar.b()).intValue();
                break;
            case 36:
                int intValue3 = ((java.lang.Integer) aVar.b()).intValue();
                this.o = new java.lang.String[intValue3];
                while (i < intValue3) {
                    this.o[i] = (java.lang.String) aVar.b();
                    aVar.a();
                    i++;
                }
                break;
            case 37:
                int intValue4 = ((java.lang.Integer) aVar.b()).intValue();
                this.m = new java.lang.Object[intValue4];
                while (i < intValue4) {
                    this.m[i] = aVar.b();
                    i++;
                }
                break;
            case 38:
                int intValue5 = ((java.lang.Integer) aVar.b()).intValue();
                this.o = new java.lang.String[intValue5];
                while (i < intValue5) {
                    this.o[i] = (java.lang.String) aVar.b();
                    i++;
                }
                break;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:525:0x0abe, code lost:
    
        if (java.lang.Double.valueOf(r2.toString()).doubleValue() == 0.0d) goto L593;
     */
    /* JADX WARN: Code restructure failed: missing block: B:527:0x0c6c, code lost:
    
        r8 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:532:0x0ade, code lost:
    
        if ((r2 instanceof java.lang.Boolean) != false) goto L620;
     */
    /* JADX WARN: Code restructure failed: missing block: B:533:0x0c9a, code lost:
    
        r2 = java.lang.Boolean.TRUE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:605:0x0c74, code lost:
    
        if (r3 == null) goto L609;
     */
    /* JADX WARN: Code restructure failed: missing block: B:611:0x0c8d, code lost:
    
        if (((java.lang.Number) r2).doubleValue() != ((java.lang.Number) r3).doubleValue()) goto L593;
     */
    /* JADX WARN: Code restructure failed: missing block: B:614:0x0c98, code lost:
    
        if (r3 == null) goto L608;
     */
    /* JADX WARN: Code restructure failed: missing block: B:620:0x0cb6, code lost:
    
        if (((java.lang.Number) r2).doubleValue() == ((java.lang.Number) r3).doubleValue()) goto L593;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:436:0x093a  */
    /* JADX WARN: Removed duplicated region for block: B:443:0x0966 A[LOOP:13: B:441:0x095f->B:443:0x0966, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:444:0x096a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:450:0x0953  */
    /* JADX WARN: Type inference failed for: r2v106, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v174, types: [java.lang.Double] */
    /* JADX WARN: Type inference failed for: r2v176, types: [java.lang.Float] */
    /* JADX WARN: Type inference failed for: r2v177, types: [java.lang.Long] */
    /* JADX WARN: Type inference failed for: r2v179, types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v200, types: [java.lang.Boolean] */
    /* JADX WARN: Type inference failed for: r2v208, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r2v209, types: [java.util.HashMap] */
    /* JADX WARN: Type inference failed for: r2v210 */
    /* JADX WARN: Type inference failed for: r2v216, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v217, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v219, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v221, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v222, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r2v224, types: [java.lang.Class] */
    /* JADX WARN: Type inference failed for: r2v258, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v271, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v28, types: [java.lang.Boolean] */
    /* JADX WARN: Type inference failed for: r2v289 */
    /* JADX WARN: Type inference failed for: r2v29, types: [java.lang.Boolean] */
    /* JADX WARN: Type inference failed for: r2v290 */
    /* JADX WARN: Type inference failed for: r2v30, types: [java.lang.Boolean] */
    /* JADX WARN: Type inference failed for: r2v32, types: [java.lang.Double] */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v42, types: [java.lang.Long] */
    /* JADX WARN: Type inference failed for: r2v46, types: [java.lang.Short] */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v63, types: [java.lang.Character] */
    /* JADX WARN: Type inference failed for: r2v71, types: [java.lang.Byte] */
    /* JADX WARN: Type inference failed for: r2v72, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v85, types: [java.lang.Long] */
    /* JADX WARN: Type inference failed for: r2v86, types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r2v89, types: [java.lang.Double] */
    /* JADX WARN: Type inference failed for: r2v90, types: [java.lang.Float] */
    /* JADX WARN: Type inference failed for: r2v91, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v92 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(cn.fly.verify.db.a aVar) throws java.lang.Throwable {
        java.lang.Object obj;
        boolean equals;
        boolean equals2;
        float floatValue;
        int intValue;
        int floatValue2;
        char longValue;
        java.lang.Object bigDecimal;
        java.io.InputStream byteArrayInputStream;
        boolean z;
        java.io.OutputStream outputStream;
        byte[] bArr;
        int read;
        double doubleValue;
        long longValue2;
        int intValue2;
        int intValue3;
        int intValue4;
        int intValue5;
        int intValue6;
        int intValue7;
        int intValue8;
        int intValue9;
        int intValue10;
        int intValue11;
        java.lang.Object obj2;
        int length;
        int intValue12;
        java.lang.String str;
        java.lang.Class<?> cls;
        java.lang.Object b;
        java.util.LinkedList<java.lang.Object> b2;
        cn.fly.verify.cv b3;
        int i = 0;
        r8 = false;
        r8 = false;
        r8 = false;
        r8 = false;
        r8 = false;
        r8 = false;
        r8 = false;
        r8 = false;
        r8 = false;
        r8 = false;
        boolean z2 = false;
        int i2 = 0;
        try {
            switch (this.a) {
                case 1:
                    aVar.b(this.h, aVar.a());
                    return;
                case 2:
                    obj = this.q;
                    aVar.a(obj);
                    return;
                case 3:
                    obj = aVar.b(this.h);
                    aVar.a(obj);
                    return;
                case 4:
                    obj = aVar.a();
                    java.lang.Object a2 = aVar.a();
                    switch (this.k) {
                        case 12:
                            if (obj != 0) {
                                if (!(obj instanceof java.lang.Number) || !(a2 instanceof java.lang.Number)) {
                                    equals = obj.equals(a2);
                                    obj = java.lang.Boolean.valueOf(equals);
                                    aVar.a(obj);
                                    return;
                                }
                                break;
                            }
                            break;
                        case 13:
                            if (obj != 0) {
                                if (!(obj instanceof java.lang.Number) || !(a2 instanceof java.lang.Number)) {
                                    equals2 = obj.equals(a2);
                                    equals = !equals2;
                                    obj = java.lang.Boolean.valueOf(equals);
                                    aVar.a(obj);
                                    return;
                                }
                                break;
                            }
                            break;
                        case 14:
                            if (obj instanceof java.lang.Number) {
                                break;
                            }
                            obj = java.lang.Boolean.valueOf(z2);
                            aVar.a(obj);
                            return;
                        case 15:
                            if (obj instanceof java.lang.Number) {
                                break;
                            }
                            obj = java.lang.Boolean.valueOf(z2);
                            aVar.a(obj);
                            return;
                        case 16:
                            if (obj instanceof java.lang.Number) {
                                break;
                            }
                            obj = java.lang.Boolean.valueOf(z2);
                            aVar.a(obj);
                            return;
                        case 17:
                            if (obj instanceof java.lang.Number) {
                                break;
                            }
                            obj = java.lang.Boolean.valueOf(z2);
                            aVar.a(obj);
                            return;
                        case 18:
                            if (java.lang.String.class.equals(a2)) {
                                obj = obj == 0 ? 0 : java.lang.String.valueOf((java.lang.Object) obj);
                            } else if (java.lang.Number.class.equals(a2)) {
                                java.lang.String valueOf = java.lang.String.valueOf((java.lang.Object) obj);
                                if (valueOf.contains(".")) {
                                    try {
                                        try {
                                            obj = java.lang.Float.valueOf(java.lang.Float.parseFloat(valueOf));
                                        } catch (java.lang.Throwable unused) {
                                            obj = java.lang.Double.valueOf(java.lang.Double.parseDouble(valueOf));
                                        }
                                    } catch (java.lang.Throwable unused2) {
                                        obj2 = new java.math.BigDecimal(valueOf);
                                        break;
                                    }
                                } else {
                                    try {
                                        try {
                                            obj = java.lang.Integer.valueOf(java.lang.Integer.parseInt(valueOf));
                                        } catch (java.lang.Throwable unused3) {
                                            obj2 = new java.math.BigInteger(valueOf);
                                            break;
                                        }
                                    } catch (java.lang.Throwable unused4) {
                                        obj = java.lang.Long.valueOf(java.lang.Long.parseLong(valueOf));
                                    }
                                }
                            } else if (java.lang.Double.class.equals(a2) || java.lang.Double.TYPE.equals(a2)) {
                                obj = java.lang.Double.valueOf(java.lang.String.valueOf((java.lang.Object) obj));
                            } else if (java.lang.Float.class.equals(a2) || java.lang.Float.TYPE.equals(a2)) {
                                floatValue = java.lang.Double.valueOf(java.lang.String.valueOf((java.lang.Object) obj)).floatValue();
                                obj = java.lang.Float.valueOf(floatValue);
                            } else if (java.lang.Integer.class.equals(a2) || java.lang.Integer.TYPE.equals(a2)) {
                                intValue = java.lang.Double.valueOf(java.lang.String.valueOf((java.lang.Object) obj)).intValue();
                                obj = java.lang.Integer.valueOf(intValue);
                            } else if (java.lang.Long.class.equals(a2) || java.lang.Long.TYPE.equals(a2)) {
                                obj = java.lang.Long.valueOf(java.lang.Double.valueOf(java.lang.String.valueOf((java.lang.Object) obj)).longValue());
                            } else if (java.lang.Short.class.equals(a2) || java.lang.Short.TYPE.equals(a2)) {
                                obj = java.lang.Short.valueOf(java.lang.Double.valueOf(java.lang.String.valueOf((java.lang.Object) obj)).shortValue());
                            } else if (java.lang.Character.class.equals(a2) || java.lang.Character.TYPE.equals(a2)) {
                                if (obj instanceof java.lang.Integer) {
                                    floatValue2 = ((java.lang.Integer) obj).intValue();
                                } else if (obj instanceof java.lang.Long) {
                                    longValue = (char) ((java.lang.Long) obj).longValue();
                                    obj = java.lang.Character.valueOf(longValue);
                                } else if (obj instanceof java.lang.Short) {
                                    floatValue2 = ((java.lang.Short) obj).shortValue();
                                } else if (obj instanceof java.lang.Byte) {
                                    floatValue2 = ((java.lang.Byte) obj).byteValue();
                                } else if (obj instanceof java.lang.Double) {
                                    floatValue2 = (int) ((java.lang.Double) obj).doubleValue();
                                } else {
                                    if (!(obj instanceof java.lang.Float)) {
                                        throw new java.lang.RuntimeException("Bad operator at line: " + this.b + "(" + this.c + ")");
                                    }
                                    floatValue2 = (int) ((java.lang.Float) obj).floatValue();
                                }
                                longValue = (char) floatValue2;
                                obj = java.lang.Character.valueOf(longValue);
                            } else if (java.lang.Byte.class.equals(a2) || java.lang.Byte.TYPE.equals(a2)) {
                                obj = java.lang.Byte.valueOf(java.lang.Double.valueOf(java.lang.String.valueOf((java.lang.Object) obj)).byteValue());
                            } else {
                                if (!java.lang.Boolean.class.equals(a2)) {
                                    if (java.math.BigInteger.class.equals(a2)) {
                                        bigDecimal = new java.math.BigInteger(java.lang.String.valueOf((java.lang.Object) obj));
                                    } else if (java.math.BigDecimal.class.equals(a2)) {
                                        bigDecimal = new java.math.BigDecimal(java.lang.String.valueOf((java.lang.Object) obj));
                                    } else {
                                        obj = ((java.lang.Class) a2).cast(obj);
                                    }
                                    aVar.a(bigDecimal);
                                    return;
                                }
                                if (obj != 0) {
                                    if (obj instanceof java.lang.Number) {
                                        break;
                                    } else if (!(obj instanceof java.lang.String)) {
                                        break;
                                    } else {
                                        equals = ((java.lang.String) obj).trim().toLowerCase().equals(cn.fly.verify.dt.a("004iCdjdg,f"));
                                        obj = java.lang.Boolean.valueOf(equals);
                                    }
                                }
                                obj = java.lang.Boolean.FALSE;
                            }
                            aVar.a(obj);
                            return;
                        case 19:
                            equals = ((java.lang.Class) a2).isInstance(obj);
                            obj = java.lang.Boolean.valueOf(equals);
                            aVar.a(obj);
                            return;
                        case 20:
                            if (obj instanceof java.util.Collection) {
                                java.util.Collection collection = (java.util.Collection) obj;
                                if (a2 instanceof java.util.Collection) {
                                    collection.addAll((java.util.Collection) a2);
                                    return;
                                } else {
                                    collection.add(a2);
                                    return;
                                }
                            }
                            if ((obj instanceof java.util.Map) && (a2 instanceof java.util.Map)) {
                                ((java.util.Map) obj).putAll((java.util.Map) a2);
                                return;
                            }
                            if (a2 instanceof java.lang.String) {
                                byteArrayInputStream = new java.io.ByteArrayInputStream(((java.lang.String) a2).getBytes("utf-8"));
                            } else if (a2 instanceof byte[]) {
                                byteArrayInputStream = new java.io.ByteArrayInputStream((byte[]) a2);
                            } else if (a2 instanceof java.io.File) {
                                byteArrayInputStream = new java.io.FileInputStream((java.io.File) a2);
                            } else if (a2 instanceof java.io.InputStream) {
                                byteArrayInputStream = (java.io.InputStream) a2;
                                z = false;
                                if (!(obj instanceof java.io.File)) {
                                    java.io.File file = (java.io.File) obj;
                                    if (!file.getParentFile().exists()) {
                                        file.getParentFile().mkdirs();
                                    }
                                    outputStream = new java.io.FileOutputStream(file, true);
                                } else {
                                    if (!(obj instanceof java.io.OutputStream)) {
                                        throw new java.lang.RuntimeException("Bad operator at line: " + this.b + "(" + this.c + ")");
                                    }
                                    outputStream = (java.io.OutputStream) obj;
                                    z = false;
                                }
                                bArr = new byte[1024];
                                while (true) {
                                    read = byteArrayInputStream.read(bArr);
                                    if (read != -1) {
                                        outputStream.flush();
                                        if (z) {
                                            byteArrayInputStream.close();
                                        }
                                        outputStream.close();
                                        return;
                                    }
                                    outputStream.write(bArr, 0, read);
                                }
                            } else {
                                if (!(a2 instanceof java.io.Serializable)) {
                                    throw new java.lang.RuntimeException("Bad operator at line: " + this.b + "(" + this.c + ")");
                                }
                                java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
                                java.io.ObjectOutputStream objectOutputStream = new java.io.ObjectOutputStream(byteArrayOutputStream);
                                objectOutputStream.writeObject(a2);
                                objectOutputStream.flush();
                                objectOutputStream.close();
                                byteArrayInputStream = new java.io.ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                            }
                            z = true;
                            if (!(obj instanceof java.io.File)) {
                            }
                            bArr = new byte[1024];
                            while (true) {
                                read = byteArrayInputStream.read(bArr);
                                if (read != -1) {
                                }
                                outputStream.write(bArr, 0, read);
                            }
                            break;
                        case 21:
                            java.lang.Object obj3 = obj;
                            if (obj == 0) {
                                obj3 = com.igexin.push.core.b.m;
                            }
                            if (a2 == null) {
                                a2 = com.igexin.push.core.b.m;
                            }
                            if (!(obj3 instanceof java.lang.Number) || !(a2 instanceof java.lang.Number)) {
                                obj = java.lang.String.valueOf(obj3) + java.lang.String.valueOf(a2);
                                aVar.a(obj);
                                return;
                            }
                            if ((obj3 instanceof java.lang.Double) || (a2 instanceof java.lang.Double)) {
                                doubleValue = ((java.lang.Number) obj3).doubleValue() + ((java.lang.Number) a2).doubleValue();
                                obj = java.lang.Double.valueOf(doubleValue);
                                aVar.a(obj);
                                return;
                            }
                            if ((obj3 instanceof java.lang.Float) || (a2 instanceof java.lang.Float)) {
                                floatValue = ((java.lang.Number) obj3).floatValue() + ((java.lang.Number) a2).floatValue();
                                obj = java.lang.Float.valueOf(floatValue);
                                aVar.a(obj);
                                return;
                            }
                            if ((obj3 instanceof java.lang.Long) || (a2 instanceof java.lang.Long)) {
                                longValue2 = ((java.lang.Number) obj3).longValue() + ((java.lang.Number) a2).longValue();
                                obj = java.lang.Long.valueOf(longValue2);
                                aVar.a(obj);
                                return;
                            }
                            if ((obj3 instanceof java.lang.Integer) || (a2 instanceof java.lang.Integer)) {
                                intValue2 = ((java.lang.Number) obj3).intValue();
                                intValue3 = ((java.lang.Number) a2).intValue();
                            } else if ((obj3 instanceof java.lang.Short) || (a2 instanceof java.lang.Short)) {
                                intValue2 = ((java.lang.Number) obj3).shortValue();
                                intValue3 = ((java.lang.Number) a2).shortValue();
                            } else {
                                intValue2 = ((java.lang.Number) obj3).byteValue();
                                intValue3 = ((java.lang.Number) a2).byteValue();
                            }
                            intValue = intValue2 + intValue3;
                            obj = java.lang.Integer.valueOf(intValue);
                            aVar.a(obj);
                            return;
                        case 22:
                            if (!(obj instanceof java.lang.Number) || !(a2 instanceof java.lang.Number)) {
                                throw new java.lang.RuntimeException("Bad operator at line: " + this.b + "(" + this.c + ")");
                            }
                            if ((obj instanceof java.lang.Double) || (a2 instanceof java.lang.Double)) {
                                doubleValue = ((java.lang.Number) obj).doubleValue() - ((java.lang.Number) a2).doubleValue();
                                obj = java.lang.Double.valueOf(doubleValue);
                                aVar.a(obj);
                                return;
                            }
                            if ((obj instanceof java.lang.Float) || (a2 instanceof java.lang.Float)) {
                                floatValue = ((java.lang.Number) obj).floatValue() - ((java.lang.Number) a2).floatValue();
                                obj = java.lang.Float.valueOf(floatValue);
                                aVar.a(obj);
                                return;
                            }
                            if ((obj instanceof java.lang.Long) || (a2 instanceof java.lang.Long)) {
                                longValue2 = ((java.lang.Number) obj).longValue() - ((java.lang.Number) a2).longValue();
                                obj = java.lang.Long.valueOf(longValue2);
                                aVar.a(obj);
                                return;
                            }
                            if ((obj instanceof java.lang.Integer) || (a2 instanceof java.lang.Integer)) {
                                intValue4 = ((java.lang.Number) obj).intValue();
                                intValue5 = ((java.lang.Number) a2).intValue();
                            } else if ((obj instanceof java.lang.Short) || (a2 instanceof java.lang.Short)) {
                                intValue4 = ((java.lang.Number) obj).shortValue();
                                intValue5 = ((java.lang.Number) a2).shortValue();
                            } else {
                                intValue4 = ((java.lang.Number) obj).byteValue();
                                intValue5 = ((java.lang.Number) a2).byteValue();
                            }
                            intValue = intValue4 - intValue5;
                            obj = java.lang.Integer.valueOf(intValue);
                            aVar.a(obj);
                            return;
                        case 23:
                            if (!(obj instanceof java.lang.Number) || !(a2 instanceof java.lang.Number)) {
                                throw new java.lang.RuntimeException("Bad operator at line: " + this.b + "(" + this.c + ")");
                            }
                            if ((obj instanceof java.lang.Double) || (a2 instanceof java.lang.Double)) {
                                doubleValue = ((java.lang.Number) obj).doubleValue() * ((java.lang.Number) a2).doubleValue();
                                obj = java.lang.Double.valueOf(doubleValue);
                                aVar.a(obj);
                                return;
                            }
                            if ((obj instanceof java.lang.Float) || (a2 instanceof java.lang.Float)) {
                                floatValue = ((java.lang.Number) obj).floatValue() * ((java.lang.Number) a2).floatValue();
                                obj = java.lang.Float.valueOf(floatValue);
                                aVar.a(obj);
                                return;
                            }
                            if ((obj instanceof java.lang.Long) || (a2 instanceof java.lang.Long)) {
                                longValue2 = ((java.lang.Number) obj).longValue() * ((java.lang.Number) a2).longValue();
                                obj = java.lang.Long.valueOf(longValue2);
                                aVar.a(obj);
                                return;
                            }
                            if ((obj instanceof java.lang.Integer) || (a2 instanceof java.lang.Integer)) {
                                intValue6 = ((java.lang.Number) obj).intValue();
                                intValue7 = ((java.lang.Number) a2).intValue();
                            } else if ((obj instanceof java.lang.Short) || (a2 instanceof java.lang.Short)) {
                                intValue6 = ((java.lang.Number) obj).shortValue();
                                intValue7 = ((java.lang.Number) a2).shortValue();
                            } else {
                                intValue6 = ((java.lang.Number) obj).byteValue();
                                intValue7 = ((java.lang.Number) a2).byteValue();
                            }
                            intValue = intValue6 * intValue7;
                            obj = java.lang.Integer.valueOf(intValue);
                            aVar.a(obj);
                            return;
                        case 24:
                            if (!(obj instanceof java.lang.Number) || !(a2 instanceof java.lang.Number)) {
                                throw new java.lang.RuntimeException("Bad operator at line: " + this.b + "(" + this.c + ")");
                            }
                            if ((obj instanceof java.lang.Double) || (a2 instanceof java.lang.Double)) {
                                doubleValue = ((java.lang.Number) obj).doubleValue() / ((java.lang.Number) a2).doubleValue();
                                obj = java.lang.Double.valueOf(doubleValue);
                                aVar.a(obj);
                                return;
                            }
                            if ((obj instanceof java.lang.Float) || (a2 instanceof java.lang.Float)) {
                                floatValue = ((java.lang.Number) obj).floatValue() / ((java.lang.Number) a2).floatValue();
                                obj = java.lang.Float.valueOf(floatValue);
                                aVar.a(obj);
                                return;
                            }
                            if ((obj instanceof java.lang.Long) || (a2 instanceof java.lang.Long)) {
                                longValue2 = ((java.lang.Number) obj).longValue() / ((java.lang.Number) a2).longValue();
                                obj = java.lang.Long.valueOf(longValue2);
                                aVar.a(obj);
                                return;
                            }
                            if ((obj instanceof java.lang.Integer) || (a2 instanceof java.lang.Integer)) {
                                intValue8 = ((java.lang.Number) obj).intValue();
                                intValue9 = ((java.lang.Number) a2).intValue();
                            } else if ((obj instanceof java.lang.Short) || (a2 instanceof java.lang.Short)) {
                                intValue8 = ((java.lang.Number) obj).shortValue();
                                intValue9 = ((java.lang.Number) a2).shortValue();
                            } else {
                                intValue8 = ((java.lang.Number) obj).byteValue();
                                intValue9 = ((java.lang.Number) a2).byteValue();
                            }
                            intValue = intValue8 / intValue9;
                            obj = java.lang.Integer.valueOf(intValue);
                            aVar.a(obj);
                            return;
                        case 25:
                            if (!(obj instanceof java.lang.Number) || !(a2 instanceof java.lang.Number)) {
                                throw new java.lang.RuntimeException("Bad operator at line: " + this.b + "(" + this.c + ")");
                            }
                            if ((obj instanceof java.lang.Double) || (a2 instanceof java.lang.Double)) {
                                doubleValue = ((java.lang.Number) obj).doubleValue() % ((java.lang.Number) a2).doubleValue();
                                obj = java.lang.Double.valueOf(doubleValue);
                                aVar.a(obj);
                                return;
                            }
                            if ((obj instanceof java.lang.Float) || (a2 instanceof java.lang.Float)) {
                                floatValue = ((java.lang.Number) obj).floatValue() % ((java.lang.Number) a2).floatValue();
                                obj = java.lang.Float.valueOf(floatValue);
                                aVar.a(obj);
                                return;
                            }
                            if ((obj instanceof java.lang.Long) || (a2 instanceof java.lang.Long)) {
                                longValue2 = ((java.lang.Number) obj).longValue() % ((java.lang.Number) a2).longValue();
                                obj = java.lang.Long.valueOf(longValue2);
                                aVar.a(obj);
                                return;
                            }
                            if ((obj instanceof java.lang.Integer) || (a2 instanceof java.lang.Integer)) {
                                intValue10 = ((java.lang.Number) obj).intValue();
                                intValue11 = ((java.lang.Number) a2).intValue();
                            } else if ((obj instanceof java.lang.Short) || (a2 instanceof java.lang.Short)) {
                                intValue10 = ((java.lang.Number) obj).shortValue();
                                intValue11 = ((java.lang.Number) a2).shortValue();
                            } else {
                                intValue10 = ((java.lang.Number) obj).byteValue();
                                intValue11 = ((java.lang.Number) a2).byteValue();
                            }
                            intValue = intValue10 % intValue11;
                            obj = java.lang.Integer.valueOf(intValue);
                            aVar.a(obj);
                            return;
                        default:
                            throw new java.lang.RuntimeException("Bad operator at line: " + this.b + "(" + this.c + ")");
                    }
                case 5:
                    java.lang.Object a3 = aVar.a();
                    if (this.k == 26) {
                        equals2 = ((java.lang.Boolean) a3).booleanValue();
                        equals = !equals2;
                        obj = java.lang.Boolean.valueOf(equals);
                        aVar.a(obj);
                        return;
                    }
                    throw new java.lang.RuntimeException("Bad operator at line: " + this.b + "(" + this.c + ")");
                case 6:
                    obj = new java.util.ArrayList();
                    if (this.f70s == 1) {
                        java.lang.Object a4 = aVar.a();
                        if (a4 == null || !a4.getClass().isArray()) {
                            obj.add(a4);
                        } else {
                            int length2 = java.lang.reflect.Array.getLength(a4);
                            for (int i3 = 0; i3 < length2; i3++) {
                                obj.add(java.lang.reflect.Array.get(a4, i3));
                            }
                        }
                    } else {
                        for (int i4 = 0; i4 < this.f70s; i4++) {
                            obj.add(aVar.a());
                        }
                    }
                    aVar.a(obj);
                    return;
                case 7:
                    obj = new java.util.HashMap();
                    for (int i5 = 0; i5 < this.r; i5++) {
                        obj.put(aVar.a(), aVar.a());
                    }
                    aVar.a(obj);
                    return;
                case 8:
                    java.lang.Object a5 = aVar.a();
                    java.lang.Object a6 = aVar.a();
                    if (a5 instanceof java.util.List) {
                        java.util.List list = (java.util.List) a5;
                        if (a6 instanceof cn.fly.verify.dd) {
                            java.lang.Number[] b4 = ((cn.fly.verify.dd) a6).b();
                            int intValue13 = b4[0].intValue();
                            if (intValue13 < 0) {
                                intValue13 += list.size();
                            }
                            int intValue14 = b4[1].intValue();
                            if (intValue14 < 0) {
                                intValue14 += list.size();
                            }
                            obj = list.subList(intValue13, intValue14);
                        } else {
                            int intValue15 = ((java.lang.Integer) a6).intValue();
                            if (intValue15 < 0) {
                                intValue15 += list.size();
                            }
                            obj = list.get(intValue15);
                        }
                    } else if (a5 instanceof java.util.Map) {
                        obj = ((java.util.Map) a5).get(a6);
                    } else if (!a5.getClass().isArray()) {
                        if (!(a5 instanceof java.lang.String)) {
                            throw new java.lang.IllegalArgumentException(a5.getClass().getName() + " is not entry");
                        }
                        java.lang.String str2 = (java.lang.String) a5;
                        if (a6 instanceof cn.fly.verify.dd) {
                            java.lang.Number[] b5 = ((cn.fly.verify.dd) a6).b();
                            intValue12 = b5[0].intValue();
                            length = b5[1].intValue();
                        } else {
                            length = str2.length();
                            intValue12 = ((java.lang.Integer) a6).intValue();
                        }
                        if (intValue12 < 0) {
                            intValue12 += str2.length();
                        }
                        if (length < 0) {
                            length += str2.length();
                        }
                        obj = str2.substring(intValue12, length);
                    } else if (a6 instanceof cn.fly.verify.dd) {
                        int length3 = java.lang.reflect.Array.getLength(a5);
                        java.lang.Number[] b6 = ((cn.fly.verify.dd) a6).b();
                        int intValue16 = b6[0].intValue();
                        if (intValue16 < 0) {
                            intValue16 += length3;
                        }
                        int intValue17 = b6[1].intValue();
                        if (intValue17 < 0) {
                            intValue17 += length3;
                        }
                        int i6 = intValue17 - intValue16;
                        java.lang.Object newInstance = java.lang.reflect.Array.newInstance(a5.getClass().getComponentType(), i6);
                        java.lang.System.arraycopy(a5, intValue16, newInstance, 0, i6);
                        obj2 = newInstance;
                        obj = obj2;
                    } else {
                        int intValue18 = ((java.lang.Integer) a6).intValue();
                        if (intValue18 < 0) {
                            intValue18 += java.lang.reflect.Array.getLength(a5);
                        }
                        obj = java.lang.reflect.Array.get(a5, intValue18);
                    }
                    aVar.a(obj);
                    return;
                case 9:
                    obj = aVar.a(this.h);
                    aVar.a(obj);
                    return;
                case 10:
                    str = this.e;
                    cls = java.lang.Class.forName(this.d);
                    aVar.a(str, cls);
                    return;
                case 11:
                    a(aVar.a(), aVar.b);
                    return;
                case 12:
                    java.lang.Object a7 = aVar.a();
                    java.lang.Object[] objArr = new java.lang.Object[this.i];
                    for (int i7 = 0; i7 < this.i; i7++) {
                        objArr[i7] = aVar.a();
                    }
                    a(a7, objArr, aVar.b);
                    return;
                case 13:
                    a(aVar.a(this.n), aVar.b);
                    return;
                case 14:
                    java.lang.Class<?> a8 = aVar.a(this.n);
                    java.lang.Object[] objArr2 = new java.lang.Object[this.i];
                    for (int i8 = 0; i8 < this.i; i8++) {
                        objArr2[i8] = aVar.a();
                    }
                    a(a8, objArr2, aVar.b);
                    return;
                case 15:
                    java.lang.Object a9 = aVar.a();
                    cn.fly.verify.db dbVar = new cn.fly.verify.db(11);
                    dbVar.b = this.b;
                    dbVar.c = this.c;
                    dbVar.l = (java.lang.String) aVar.a();
                    dbVar.a(a9, aVar.b);
                    return;
                case 16:
                    java.lang.Object a10 = aVar.a();
                    cn.fly.verify.db dbVar2 = new cn.fly.verify.db(12);
                    dbVar2.b = this.b;
                    dbVar2.c = this.c;
                    dbVar2.p = (java.lang.String) aVar.a();
                    dbVar2.i = this.i;
                    java.lang.Object[] objArr3 = new java.lang.Object[this.i];
                    for (int i9 = 0; i9 < this.i; i9++) {
                        objArr3[i9] = aVar.a();
                    }
                    dbVar2.a(a10, objArr3, aVar.b);
                    return;
                case 17:
                    java.lang.Class<?> a11 = aVar.a(this.n);
                    cn.fly.verify.db dbVar3 = new cn.fly.verify.db(13);
                    dbVar3.b = this.b;
                    dbVar3.c = this.c;
                    dbVar3.l = (java.lang.String) aVar.a();
                    dbVar3.a(a11, aVar.b);
                    return;
                case 18:
                    java.lang.Class<?> a12 = aVar.a(this.n);
                    cn.fly.verify.db dbVar4 = new cn.fly.verify.db(14);
                    dbVar4.b = this.b;
                    dbVar4.c = this.c;
                    dbVar4.n = this.n;
                    dbVar4.p = (java.lang.String) aVar.a();
                    dbVar4.i = this.i;
                    java.lang.Object[] objArr4 = new java.lang.Object[this.i];
                    for (int i10 = 0; i10 < this.i; i10++) {
                        objArr4[i10] = aVar.a();
                    }
                    dbVar4.a(a12, objArr4, aVar.b);
                    return;
                case 19:
                    aVar.a(this.h, aVar.a());
                    return;
                case 20:
                default:
                    return;
                case 21:
                    if (((java.lang.Boolean) aVar.a()).booleanValue()) {
                        return;
                    }
                    aVar.a = this.g;
                    return;
                case 22:
                    aVar.a = this.g;
                    return;
                case 23:
                    java.lang.Object a13 = aVar.a();
                    java.lang.Object a14 = aVar.a();
                    java.lang.Object a15 = aVar.a();
                    if (a13 instanceof java.util.List) {
                        java.util.List list2 = (java.util.List) a13;
                        int intValue19 = ((java.lang.Integer) a14).intValue();
                        if (intValue19 < 0) {
                            intValue19 += list2.size();
                        }
                        list2.set(intValue19, a15);
                        return;
                    }
                    if (a13 instanceof java.util.Map) {
                        ((java.util.Map) a13).put(a14, a15);
                        return;
                    }
                    if (!a13.getClass().isArray()) {
                        throw new java.lang.IllegalArgumentException(a13.getClass().getName() + " is not entry");
                    }
                    int intValue20 = ((java.lang.Integer) a14).intValue();
                    if (intValue20 < 0) {
                        intValue20 += java.lang.reflect.Array.getLength(a13);
                    }
                    java.lang.reflect.Array.set(a13, intValue20, a15);
                    return;
                case 24:
                    b(aVar.a(), aVar.b);
                    return;
                case 25:
                    java.lang.Object a16 = aVar.a();
                    cn.fly.verify.db dbVar5 = new cn.fly.verify.db(24);
                    dbVar5.b = this.b;
                    dbVar5.c = this.c;
                    dbVar5.l = (java.lang.String) aVar.a();
                    dbVar5.b(a16, aVar.b);
                    return;
                case 26:
                    b(aVar.a(this.n), aVar.b);
                    return;
                case 27:
                    java.lang.Class<?> a17 = aVar.a(this.n);
                    cn.fly.verify.db dbVar6 = new cn.fly.verify.db(26);
                    dbVar6.b = this.b;
                    dbVar6.c = this.c;
                    dbVar6.l = (java.lang.String) aVar.a();
                    dbVar6.b(a17, aVar.b);
                    return;
                case 28:
                    java.util.List<java.lang.Object> list3 = aVar.c;
                    if (list3 != null) {
                        list3.add(aVar.a());
                    }
                    aVar.d = true;
                    aVar.e = true;
                    return;
                case 29:
                    int i11 = aVar.a;
                    int i12 = this.j;
                    if (i12 > 0) {
                        aVar.a = i12;
                    } else {
                        int i13 = i11 + 1;
                        int i14 = 1;
                        i12 = i11;
                        while (i14 > 0) {
                            int i15 = aVar.f.get(i13).a;
                            if (i15 == 29) {
                                i14++;
                            } else if (i15 == 30) {
                                i14--;
                            }
                            if (i14 == 0) {
                                aVar.a = i13;
                                i12 = i13;
                            }
                            i13++;
                        }
                    }
                    int i16 = i11 + 1;
                    obj = i16 == i12 ? cn.fly.verify.dc.a(this.h, this.i, aVar.f, aVar.g, i16, i12, aVar.b) : new cn.fly.verify.dc(this.h, this.i, aVar.f, aVar.g, i16, i12, aVar.b);
                    java.lang.String str3 = this.h;
                    if (str3 != null) {
                        aVar.b(str3, obj);
                        return;
                    }
                    aVar.a(obj);
                    return;
                case 30:
                    aVar.e = true;
                    return;
                case 31:
                    b = aVar.b(this.h);
                    if (!(b instanceof cn.fly.verify.dc)) {
                        if (!(b instanceof java.lang.reflect.Method)) {
                            throw new java.lang.NoSuchMethodException(this.h + " at line: " + this.b + "(" + this.c + ")");
                        }
                        aVar.b.a((java.lang.reflect.Method) b, this.i);
                        return;
                    }
                    cn.fly.verify.dc dcVar = (cn.fly.verify.dc) b;
                    java.lang.Object[] objArr5 = new java.lang.Object[this.i];
                    for (int i17 = 0; i17 < this.i; i17++) {
                        objArr5[i17] = aVar.a();
                    }
                    b2 = dcVar.b(objArr5);
                    if (b2.size() <= 0) {
                        return;
                    }
                    obj = b2.get(0);
                    aVar.a(obj);
                    return;
                case 32:
                    b = aVar.a();
                    if (!(b instanceof cn.fly.verify.dc)) {
                        if (!(b instanceof java.lang.reflect.Method)) {
                            throw new java.lang.RuntimeException("at line: " + this.b + "(" + this.c + ")");
                        }
                        aVar.b.a((java.lang.reflect.Method) b, this.i);
                        return;
                    }
                    cn.fly.verify.dc dcVar2 = (cn.fly.verify.dc) b;
                    java.lang.Object[] objArr6 = new java.lang.Object[this.i];
                    for (int i18 = 0; i18 < this.i; i18++) {
                        objArr6[i18] = aVar.a();
                    }
                    b2 = dcVar2.b(objArr6);
                    if (b2.size() <= 0) {
                        return;
                    }
                    obj = b2.get(0);
                    aVar.a(obj);
                    return;
                case 33:
                    b3 = aVar.b.b();
                    aVar.b = b3;
                    return;
                case 34:
                    b3 = aVar.b.c();
                    aVar.b = b3;
                    return;
                case 35:
                    str = this.e;
                    cls = aVar.a(this.d);
                    aVar.a(str, cls);
                    return;
                case 36:
                    while (true) {
                        java.lang.String[] strArr = this.o;
                        if (i2 >= strArr.length) {
                            return;
                        }
                        aVar.b(strArr[i2], aVar.a());
                        i2++;
                    }
                case 37:
                    while (true) {
                        java.lang.Object[] objArr7 = this.m;
                        if (i >= objArr7.length) {
                            return;
                        }
                        aVar.a(objArr7[i]);
                        i++;
                    }
                case 38:
                    for (java.lang.String str4 : this.o) {
                        aVar.a(aVar.b(str4));
                    }
                    return;
            }
        } catch (java.lang.Throwable unused5) {
        }
    }

    public void a(java.lang.Class<?> cls, cn.fly.verify.cv cvVar) throws java.lang.Throwable {
        java.lang.reflect.Field field;
        while (true) {
            if (cls == null) {
                cn.fly.verify.db dbVar = new cn.fly.verify.db(14);
                dbVar.b = this.b;
                dbVar.c = this.c;
                dbVar.n = this.n;
                dbVar.p = cn.fly.verify.dt.a("003QeeNfi") + java.lang.Character.toUpperCase(this.l.charAt(0)) + this.l.substring(1);
                dbVar.i = 1;
                dbVar.a(cls, new java.lang.Object[0], cvVar);
                return;
            }
            if ("class".equals(this.l)) {
                cvVar.a(cls);
                return;
            }
            if (cls.equals(cn.fly.verify.da.class) && cn.fly.verify.dt.a("007Mdd7f(djfhdied9e").equals(this.l)) {
                cvVar.a((java.lang.Object) 70);
                return;
            }
            if (cls.isEnum()) {
                java.lang.Object[] enumConstants = cls.getEnumConstants();
                if (enumConstants != null) {
                    for (java.lang.Object obj : enumConstants) {
                        if (((java.lang.Enum) obj).name().equals(this.l)) {
                            cvVar.a(obj);
                            return;
                        }
                    }
                } else {
                    continue;
                }
            } else {
                try {
                    field = cls.getDeclaredField(this.l);
                } catch (java.lang.Throwable unused) {
                    field = null;
                }
                if (field != null && java.lang.reflect.Modifier.isStatic(field.getModifiers())) {
                    field.setAccessible(true);
                    cvVar.a(field.get(null));
                    return;
                }
                cls = cls.getSuperclass();
            }
        }
    }

    public void a(java.lang.Class<?> cls, java.lang.Object[] objArr, cn.fly.verify.cv cvVar) throws java.lang.Throwable {
        java.lang.Class<?>[] parameterTypes;
        boolean[] zArr;
        boolean[] a2;
        java.lang.Object obj;
        java.lang.Class<?> cls2 = cls;
        if ("new".equals(this.p)) {
            if (java.util.List.class.isAssignableFrom(cls2) && objArr.length == 1 && (obj = objArr[0]) != null && obj.getClass().isArray()) {
                int length = java.lang.reflect.Array.getLength(objArr[0]);
                java.util.List arrayList = cls2.equals(java.util.List.class) ? new java.util.ArrayList(length) : (java.util.List) cls.newInstance();
                for (int i = 0; i < length; i++) {
                    arrayList.add(java.lang.reflect.Array.get(objArr[0], i));
                }
                cvVar.a(arrayList);
                return;
            }
            if (java.util.Map.class.isAssignableFrom(cls2) && objArr.length == 1 && objArr[0] != null) {
                java.util.Map hashMap = cls2.equals(java.util.Map.class) ? new java.util.HashMap() : (java.util.Map) cls.newInstance();
                java.lang.Object obj2 = objArr[0];
                if (obj2 instanceof java.util.Map) {
                    hashMap.putAll((java.util.Map) obj2);
                } else {
                    java.lang.Class<?> cls3 = java.lang.Class.forName("org.json.JSONObject");
                    a(hashMap, a(objArr[0], cls3), cls3, java.lang.Class.forName("org.json.JSONArray"));
                }
                cvVar.a(hashMap);
                return;
            }
            if (cls2.equals(cn.fly.verify.dd.class)) {
                if (objArr.length == 2) {
                    cvVar.a(new cn.fly.verify.dd((java.lang.Number) objArr[0], (java.lang.Number) objArr[1], null));
                    return;
                }
                if (objArr.length == 3) {
                    cvVar.a(new cn.fly.verify.dd((java.lang.Number) objArr[0], (java.lang.Number) objArr[1], (java.lang.Number) objArr[2]));
                    return;
                }
                throw new java.lang.NoSuchMethodException("method name: new at line: " + this.b + "(" + this.c + ")");
            }
            boolean[][] zArr2 = new boolean[2][];
            java.lang.reflect.Constructor a3 = cvVar.g().a(cls2, objArr, zArr2);
            if (a3 != null) {
                java.lang.Object[] a4 = !zArr2[1][0] ? cvVar.g().a(cvVar, a3.getParameterTypes(), objArr, zArr2[0]) : objArr;
                a3.setAccessible(true);
                cvVar.a(a3.newInstance(a4));
                return;
            }
            for (java.lang.reflect.Constructor<?> constructor : cls.getDeclaredConstructors()) {
                java.lang.Class<?>[] parameterTypes2 = constructor.getParameterTypes();
                boolean[] zArr3 = new boolean[1];
                boolean[] a5 = cvVar.g().a(parameterTypes2, objArr, zArr3);
                if (a5 != null) {
                    java.lang.Object[] a6 = !zArr3[0] ? cvVar.g().a(cvVar, parameterTypes2, objArr, a5) : objArr;
                    constructor.setAccessible(true);
                    cvVar.a(constructor.newInstance(a6));
                    return;
                }
            }
            throw new java.lang.NoSuchMethodException("method name: new at line: " + this.b + "(" + this.c + ")");
        }
        if ("fromJson".equals(this.p) && java.util.Map.class.isAssignableFrom(cls2) && objArr.length == 1 && objArr[0] != null) {
            this.p = "new";
            a(cls, objArr, cvVar);
            return;
        }
        if (cls2.equals(java.lang.reflect.Array.class)) {
            if (this.p.equals(cn.fly.verify.dt.a("011ef<ffei^eHfh-idecf")) && objArr.length == 2) {
                java.lang.Object obj3 = objArr[1];
                if (obj3 instanceof java.lang.Integer) {
                    cvVar.a(java.lang.reflect.Array.newInstance((java.lang.Class<?>) objArr[0], ((java.lang.Integer) obj3).intValue()));
                    return;
                }
            }
            if (com.sensorsdata.sf.ui.view.UIProperty.action_type_copy.equals(this.p)) {
                int i2 = this.i;
                if (i2 == 5) {
                    java.lang.System.arraycopy(objArr[0], java.lang.Integer.parseInt(java.lang.String.valueOf(objArr[1])), objArr[2], java.lang.Integer.parseInt(java.lang.String.valueOf(objArr[3])), java.lang.Integer.parseInt(java.lang.String.valueOf(objArr[44])));
                    return;
                }
                if (i2 == 2) {
                    java.lang.Object obj4 = objArr[0];
                    java.lang.System.arraycopy(obj4, 0, objArr[1], 0, java.lang.Math.min(java.lang.reflect.Array.getLength(obj4), java.lang.reflect.Array.getLength(objArr[1])));
                    return;
                }
                throw new java.lang.NoSuchMethodException("method name: copy at line: " + this.b + "(" + this.c + ")");
            }
        } else if ("quit".equals(this.p) && cls2.equals(cn.fly.verify.da.class)) {
            cvVar.e();
            return;
        }
        if (cvVar.g().a((java.lang.Object) null, cls, this.p, objArr, cvVar)) {
            return;
        }
        for (java.lang.Class<?> cls4 = cls2; cls4 != null; cls4 = cls4.getSuperclass()) {
            boolean[][] zArr4 = new boolean[2][];
            java.lang.reflect.Method a7 = cvVar.g().a(cls4, this.p, true, objArr, zArr4);
            if (a7 != null) {
                java.lang.Object[] a8 = !zArr4[1][0] ? cvVar.g().a(cvVar, a7.getParameterTypes(), objArr, zArr4[0]) : objArr;
                a7.setAccessible(true);
                if (a7.getReturnType() == java.lang.Void.TYPE) {
                    a7.invoke(null, a8);
                    return;
                } else {
                    cvVar.a(a7.invoke(null, a8));
                    return;
                }
            }
        }
        while (cls2 != null) {
            for (java.lang.reflect.Method method : cls2.getDeclaredMethods()) {
                if (method.getName().equals(this.p) && java.lang.reflect.Modifier.isStatic(method.getModifiers()) && (a2 = cvVar.g().a((parameterTypes = method.getParameterTypes()), objArr, (zArr = new boolean[1]))) != null) {
                    java.lang.Object[] a9 = !zArr[0] ? cvVar.g().a(cvVar, parameterTypes, objArr, a2) : objArr;
                    method.setAccessible(true);
                    if (method.getReturnType() == java.lang.Void.TYPE) {
                        method.invoke(null, a9);
                        return;
                    } else {
                        cvVar.a(method.invoke(null, a9));
                        return;
                    }
                }
            }
            cls2 = cls2.getSuperclass();
        }
        throw new java.lang.NoSuchMethodException("method name: " + this.p + " at line: " + this.b + "(" + this.c + ")");
    }

    public void a(java.lang.Object obj, cn.fly.verify.cv cvVar) throws java.lang.Throwable {
        java.lang.reflect.Field field;
        if (obj instanceof java.util.Map) {
            cvVar.a(((java.util.Map) obj).get(this.l));
            return;
        }
        if (cn.fly.verify.dt.a("006gfe<ee$ih").equals(this.l) && obj.getClass().isArray()) {
            cvVar.a(java.lang.Integer.valueOf(java.lang.reflect.Array.getLength(obj)));
            return;
        }
        for (java.lang.Class<?> cls = obj.getClass(); cls != null; cls = cls.getSuperclass()) {
            try {
                field = cls.getDeclaredField(this.l);
            } catch (java.lang.Throwable unused) {
                field = null;
            }
            if (field != null && !java.lang.reflect.Modifier.isStatic(field.getModifiers())) {
                field.setAccessible(true);
                cvVar.a(field.get(obj));
                return;
            }
        }
        cn.fly.verify.db dbVar = new cn.fly.verify.db(12);
        dbVar.b = this.b;
        dbVar.c = this.c;
        dbVar.p = cn.fly.verify.dt.a("003EeeDfi") + java.lang.Character.toUpperCase(this.l.charAt(0)) + this.l.substring(1);
        dbVar.i = 0;
        dbVar.a(obj, new java.lang.Object[0], cvVar);
    }

    public void a(java.lang.Object obj, java.lang.Object[] objArr, cn.fly.verify.cv cvVar) throws java.lang.Throwable {
        byte[] bArr;
        java.lang.String[] strArr;
        java.lang.Object obj2;
        cn.fly.verify.dc dcVar;
        java.lang.String str;
        java.lang.Object obj3;
        java.lang.Class<?>[] parameterTypes;
        boolean[] zArr;
        boolean[] a2;
        java.lang.Object obj4;
        java.lang.Class<?>[] clsArr;
        java.lang.Object[] objArr2 = objArr;
        int i = 0;
        if (obj instanceof java.util.Map) {
            java.util.Map map = (java.util.Map) obj;
            java.lang.Object obj5 = map.get(this.p);
            if (obj5 != null) {
                if (obj5 instanceof cn.fly.verify.dc) {
                    java.util.LinkedList<java.lang.Object> b = ((cn.fly.verify.dc) obj5).b(objArr2);
                    if (b.size() > 0) {
                        cvVar.a(b.get(0));
                        return;
                    }
                    return;
                }
                if (obj5 instanceof java.lang.reflect.Method) {
                    cvVar.a((java.lang.reflect.Method) obj5, objArr2);
                    return;
                }
            } else {
                if ((cn.fly.verify.dt.a("005jBdjedecdk").equals(this.p) || cn.fly.verify.dt.a("011Hdg@e0fh7d efXf8gldjedecdk").equals(this.p)) && objArr2.length == 1 && (obj4 = objArr2[0]) != null) {
                    if (obj4 instanceof java.lang.Class) {
                        clsArr = new java.lang.Class[]{(java.lang.Class) obj4};
                    } else {
                        if (!(obj4 instanceof java.util.List)) {
                            throw new java.lang.NoSuchMethodException("method name: " + this.p + " at line: " + this.b + "(" + this.c + ")");
                        }
                        java.util.List list = (java.util.List) obj4;
                        clsArr = (java.lang.Class[]) list.toArray(new java.lang.Class[list.size()]);
                    }
                    cvVar.a(cvVar.a(obj, cn.fly.verify.dt.a("005j*djedecdk").equals(this.p), clsArr));
                    return;
                }
                if ("iterator".equals(this.p) && objArr2.length == 0) {
                    cvVar.a(map.entrySet().iterator());
                    return;
                } else if ("toJson".equals(this.p) && objArr2.length == 0) {
                    cvVar.a(java.lang.Class.forName("org.json.JSONObject").getDeclaredConstructor(java.util.Map.class).newInstance(obj));
                    return;
                }
            }
        } else if (obj instanceof cn.fly.verify.dc) {
            cn.fly.verify.dc dcVar2 = (cn.fly.verify.dc) obj;
            if (cn.fly.verify.dt.a("004ifJfh-i").equals(this.p)) {
                cvVar.a(dcVar2.a(objArr2));
                return;
            } else if (cn.fly.verify.dt.a("008c,dgdjdjdkdiIeZee").equals(this.p)) {
                cvVar.a(dcVar2.a(cvVar, this.b, this.c));
                return;
            }
        } else if (obj instanceof java.lang.reflect.Method) {
            if (cn.fly.verify.dt.a("004if@fhDi").equals(this.p)) {
                cn.fly.verify.dc.a aVar = new cn.fly.verify.dc.a();
                cn.fly.verify.cv b2 = cvVar.b();
                try {
                    b2.a((java.lang.reflect.Method) obj, objArr2);
                    aVar.b = b2.a();
                } catch (java.lang.Throwable th) {
                    aVar.a = th;
                }
                cvVar.a(aVar);
                return;
            }
            if (cn.fly.verify.dt.a("013Ofh%fi'el=ccfZfhfhdifeWgf").equals(this.p) && objArr2.length == 1) {
                ((java.lang.reflect.Method) obj).setAccessible(((java.lang.Boolean) objArr2[0]).booleanValue());
                return;
            }
        } else if (obj instanceof java.util.Collection) {
            java.util.Collection collection = (java.util.Collection) obj;
            int size = collection.size();
            if ("toArray".equals(this.p) && objArr2.length == 1 && (obj3 = objArr2[0]) != null && (obj3 instanceof java.lang.Class)) {
                java.lang.Object newInstance = java.lang.reflect.Array.newInstance((java.lang.Class<?>) obj3, size);
                java.util.Iterator it = collection.iterator();
                while (it.hasNext()) {
                    java.lang.reflect.Array.set(newInstance, i, it.next());
                    i++;
                }
                cvVar.a(newInstance);
                return;
            }
        } else if (obj.getClass().isArray()) {
            if ("iterator".equals(this.p) && objArr2.length == 0) {
                java.util.ArrayList arrayList = new java.util.ArrayList();
                int length = java.lang.reflect.Array.getLength(obj);
                while (i < length) {
                    arrayList.add(java.lang.reflect.Array.get(obj, i));
                    i++;
                }
                cvVar.a(arrayList.iterator());
                return;
            }
            if ("toList".equals(this.p) && objArr2.length == 0) {
                java.util.ArrayList arrayList2 = new java.util.ArrayList();
                int length2 = java.lang.reflect.Array.getLength(obj);
                while (i < length2) {
                    arrayList2.add(java.lang.reflect.Array.get(obj, i));
                    i++;
                }
                cvVar.a(arrayList2);
                return;
            }
            if (obj.getClass().getComponentType() == java.lang.Byte.TYPE) {
                if (cn.fly.verify.dt.a("003'dfdchi").equals(this.p) && objArr2.length == 0) {
                    byte[] bArr2 = (byte[]) obj;
                    java.io.ByteArrayInputStream byteArrayInputStream = new java.io.ByteArrayInputStream(bArr2, 0, bArr2.length);
                    java.lang.Object a3 = a(byteArrayInputStream);
                    byteArrayInputStream.close();
                    cvVar.a(a3);
                    return;
                }
                if ("hex".equals(this.p) && objArr2.length == 0) {
                    cvVar.a(a((byte[]) obj));
                    return;
                } else if ("sha".equals(this.p) && objArr2.length == 1) {
                    java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance((java.lang.String) objArr2[0]);
                    messageDigest.update((byte[]) obj);
                    cvVar.a(messageDigest.digest());
                    return;
                }
            }
        } else if (java.util.Iterator.class.isAssignableFrom(obj.getClass())) {
            if ("hasNext".equals(this.p)) {
                cvVar.a(java.lang.Boolean.valueOf(((java.util.Iterator) obj).hasNext()));
                return;
            } else if ("next".equals(this.p)) {
                cvVar.a(((java.util.Iterator) obj).next());
                return;
            } else if ("remove".equals(this.p)) {
                ((java.util.Iterator) obj).remove();
                return;
            }
        } else if (obj instanceof cn.fly.verify.dd.a) {
            if ("hasNext".equals(this.p) && objArr2.length == 0) {
                cvVar.a(java.lang.Boolean.valueOf(((cn.fly.verify.dd.a) obj).a()));
                return;
            } else if ("next".equals(this.p) && objArr2.length == 0) {
                cvVar.a(((cn.fly.verify.dd.a) obj).b());
                return;
            }
        } else if (obj instanceof cn.fly.verify.dd) {
            if ("iterator".equals(this.p) && objArr2.length == 0) {
                cvVar.a(((cn.fly.verify.dd) obj).a());
                return;
            }
            if ("isInRange".equals(this.p) && objArr2.length == 1) {
                cvVar.a(java.lang.Boolean.valueOf(((cn.fly.verify.dd) obj).a((java.lang.Number) objArr2[0])));
                return;
            }
            if ("contains".equals(this.p) && objArr2.length == 1) {
                cvVar.a(java.lang.Boolean.valueOf(((cn.fly.verify.dd) obj).b((java.lang.Number) objArr2[0])));
                return;
            } else if ("boundary".equals(this.p) && objArr2.length == 0) {
                cvVar.a(((cn.fly.verify.dd) obj).b());
                return;
            }
        } else if (obj instanceof java.lang.String) {
            if ("getBytes".equals(this.p)) {
                if (objArr2.length == 0) {
                    cvVar.a(((java.lang.String) obj).getBytes());
                    return;
                } else if (objArr2.length == 1) {
                    java.lang.Object obj6 = objArr2[0];
                    if (obj6 instanceof java.lang.String) {
                        cvVar.a(((java.lang.String) obj).getBytes((java.lang.String) obj6));
                        return;
                    }
                }
            } else if ("input".equals(this.p)) {
                if (objArr2.length == 0) {
                    cvVar.a(new java.io.FileInputStream((java.lang.String) obj));
                    return;
                } else if (objArr2.length == 1 && (objArr2[0] instanceof cn.fly.verify.dc)) {
                    java.io.FileInputStream fileInputStream = new java.io.FileInputStream((java.lang.String) obj);
                    ((cn.fly.verify.dc) objArr2[0]).b(fileInputStream);
                    fileInputStream.close();
                    return;
                }
            } else if (!"output".equals(this.p)) {
                java.io.File file = null;
                java.lang.String valueOf = null;
                java.lang.String valueOf2 = null;
                java.io.FileInputStream fileInputStream2 = null;
                r3 = null;
                java.util.Collection collection2 = null;
                file = null;
                if (cn.fly.verify.dt.a("012WdjKfdYdcfldjeddffldiXgf").equals(this.p)) {
                    if (objArr2.length == 0) {
                        valueOf = "utf-8";
                    } else if (objArr2.length == 1) {
                        valueOf = java.lang.String.valueOf(objArr2[0]);
                    }
                    if (valueOf != null) {
                        java.io.FileInputStream fileInputStream3 = new java.io.FileInputStream((java.lang.String) obj);
                        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
                        byte[] bArr3 = new byte[4096];
                        while (true) {
                            int read = fileInputStream3.read(bArr3);
                            if (read == -1) {
                                fileInputStream3.close();
                                byteArrayOutputStream.flush();
                                byteArrayOutputStream.close();
                                cvVar.a(new java.lang.String(byteArrayOutputStream.toByteArray(), valueOf));
                                return;
                            }
                            byteArrayOutputStream.write(bArr3, 0, read);
                        }
                    }
                } else if (cn.fly.verify.dt.a("011Cffdjdi ifHekedfldiPgf").equals(this.p)) {
                    if (objArr2.length == 1) {
                        valueOf2 = java.lang.String.valueOf(objArr2[0]);
                        str = "utf-8";
                    } else if (objArr2.length == 2) {
                        valueOf2 = java.lang.String.valueOf(objArr2[0]);
                        str = java.lang.String.valueOf(objArr2[1]);
                    } else {
                        str = null;
                    }
                    if (valueOf2 != null) {
                        java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(valueOf2);
                        fileOutputStream.write(((java.lang.String) obj).getBytes(str));
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        return;
                    }
                } else if (cn.fly.verify.dt.a("0097dj fd[dcfcdiDefPfh").equals(this.p)) {
                    java.lang.String str2 = "utf-8";
                    if (objArr2.length == 0) {
                        dcVar = null;
                        fileInputStream2 = new java.io.FileInputStream((java.lang.String) obj);
                    } else if (objArr2.length == 1) {
                        java.lang.Object obj7 = objArr2[0];
                        if (obj7 instanceof java.lang.String) {
                            fileInputStream2 = new java.io.FileInputStream((java.lang.String) obj);
                            str2 = (java.lang.String) objArr2[0];
                            dcVar = null;
                        } else {
                            if (obj7 instanceof cn.fly.verify.dc) {
                                fileInputStream2 = new java.io.FileInputStream((java.lang.String) obj);
                                obj2 = objArr2[0];
                                dcVar = (cn.fly.verify.dc) obj2;
                            }
                            dcVar = null;
                        }
                    } else {
                        if (objArr2.length == 2 && (objArr2[0] instanceof java.lang.String) && (objArr2[1] instanceof cn.fly.verify.dc)) {
                            fileInputStream2 = new java.io.FileInputStream((java.lang.String) obj);
                            str2 = (java.lang.String) objArr2[0];
                            obj2 = objArr2[1];
                            dcVar = (cn.fly.verify.dc) obj2;
                        }
                        dcVar = null;
                    }
                    if (fileInputStream2 != null) {
                        java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(fileInputStream2, str2));
                        java.lang.String readLine = bufferedReader.readLine();
                        if (dcVar == null) {
                            java.util.ArrayList arrayList3 = new java.util.ArrayList();
                            while (readLine != null) {
                                arrayList3.add(readLine);
                                readLine = bufferedReader.readLine();
                            }
                            cvVar.a(arrayList3);
                        } else {
                            while (readLine != null) {
                                dcVar.b(readLine);
                                readLine = bufferedReader.readLine();
                            }
                        }
                        bufferedReader.close();
                        return;
                    }
                } else if (cn.fly.verify.dt.a("010Yffdjdi,if!fcdi>efRfh").equals(this.p)) {
                    java.lang.String str3 = "utf-8";
                    if (objArr2.length >= 1) {
                        if (objArr2.length == 2) {
                            java.lang.Object obj8 = objArr2[1];
                            if (obj8 instanceof java.lang.String) {
                                str3 = (java.lang.String) obj8;
                            }
                        }
                        java.lang.Object obj9 = objArr2[0];
                        if (obj9 instanceof java.lang.String) {
                            collection2 = new java.util.ArrayList();
                            collection2.add(objArr2[0]);
                        } else if (obj9 instanceof java.util.Collection) {
                            collection2 = (java.util.Collection) obj9;
                        } else if (obj9.getClass().isArray()) {
                            collection2 = new java.util.ArrayList();
                            int length3 = java.lang.reflect.Array.getLength(objArr2[0]);
                            for (int i2 = 0; i2 < length3; i2++) {
                                collection2.add(java.lang.reflect.Array.get(objArr2[0], i2));
                            }
                        }
                    }
                    if (collection2 != null) {
                        java.io.FileOutputStream fileOutputStream2 = new java.io.FileOutputStream((java.lang.String) obj);
                        java.util.Iterator it2 = collection2.iterator();
                        while (it2.hasNext()) {
                            fileOutputStream2.write((it2.next() + "\r\n").getBytes(str3));
                        }
                        fileOutputStream2.flush();
                        fileOutputStream2.close();
                        return;
                    }
                } else if (cn.fly.verify.dt.a("004f]ec2fc").equals(this.p)) {
                    if (objArr2.length == 0) {
                        cvVar.a(java.lang.Runtime.getRuntime().exec((java.lang.String) obj));
                        return;
                    }
                    if (objArr2.length == 1 || objArr2.length == 2) {
                        java.lang.Object obj10 = objArr2[0];
                        if (obj10 instanceof java.lang.String[]) {
                            strArr = (java.lang.String[]) obj10;
                        } else if (obj10 instanceof java.util.List) {
                            java.util.List list2 = (java.util.List) obj10;
                            int size2 = list2.size();
                            java.lang.String[] strArr2 = new java.lang.String[size2];
                            for (int i3 = 0; i3 < size2; i3++) {
                                java.lang.Object obj11 = list2.get(i3);
                                strArr2[i3] = obj11 == null ? null : java.lang.String.valueOf(obj11);
                            }
                            strArr = strArr2;
                        } else {
                            strArr = null;
                        }
                        if (objArr2.length == 2) {
                            java.lang.Object obj12 = objArr2[1];
                            if (obj12 instanceof java.io.File) {
                                file = (java.io.File) obj12;
                            }
                        }
                        if (strArr != null) {
                            cvVar.a(java.lang.Runtime.getRuntime().exec((java.lang.String) obj, strArr, file));
                            return;
                        }
                    }
                } else if (cn.fly.verify.dt.a("007^efdjeddffj%f,ec").equals(this.p) && objArr2.length == 0) {
                    java.lang.String str4 = (java.lang.String) obj;
                    int length4 = str4.length();
                    if (length4 % 2 == 1) {
                        length4++;
                        bArr = new byte[length4 / 2];
                        str4 = "0" + str4;
                    } else {
                        bArr = new byte[length4 / 2];
                    }
                    int i4 = 0;
                    while (i < length4) {
                        int i5 = i + 2;
                        bArr[i4] = (byte) java.lang.Integer.parseInt(str4.substring(i, i5), 16);
                        i4++;
                        i = i5;
                    }
                    cvVar.a(bArr);
                    return;
                }
            } else if (objArr2.length == 0) {
                cvVar.a(new java.io.FileOutputStream((java.lang.String) obj));
                return;
            } else if (objArr2.length == 1 && (objArr2[0] instanceof cn.fly.verify.dc)) {
                java.io.FileOutputStream fileOutputStream3 = new java.io.FileOutputStream((java.lang.String) obj);
                ((cn.fly.verify.dc) objArr2[0]).b(fileOutputStream3);
                fileOutputStream3.flush();
                fileOutputStream3.close();
                return;
            }
        } else if (obj instanceof java.io.InputStream) {
            if (cn.fly.verify.dt.a("017i!edfk@didZei4ej6dg1i3ejOiRdjQfd(df").equals(this.p) && objArr2.length == 0) {
                cvVar.a(new java.io.DataInputStream((java.io.InputStream) obj));
                return;
            }
            if (cn.fly.verify.dt.a("021i3edfidgefef[f5djDf.dceiYejKdgHi.ejFiNdj=fdWdf").equals(this.p) && objArr2.length == 0) {
                cvVar.a(new java.io.BufferedInputStream((java.io.InputStream) obj));
                return;
            }
            if (cn.fly.verify.dt.a("017iBedidileigleiXejUdg!i)ejDiFdjFfd1df").equals(this.p) && objArr2.length == 0) {
                cvVar.a(new java.util.zip.GZIPInputStream((java.io.InputStream) obj));
                return;
            } else if (cn.fly.verify.dt.a("019iYedggfehg2fci'ei4ejOdg%i(ej3iZdj^fdEdf").equals(this.p) && objArr2.length == 0) {
                cvVar.a(new java.io.ObjectInputStream((java.io.InputStream) obj));
                return;
            } else if (cn.fly.verify.dt.a("003'dfdchi").equals(this.p) && objArr2.length == 0) {
                a((java.io.InputStream) obj);
            }
        } else if (obj instanceof java.io.OutputStream) {
            if (cn.fly.verify.dt.a("018i@edfk%didIggdg=ij@dg)iYej6iUdj(fd:df").equals(this.p) && objArr2.length == 0) {
                cvVar.a(new java.io.DataOutputStream((java.io.OutputStream) obj));
                return;
            }
            if (cn.fly.verify.dt.a("022i,edfidgefefHfIdj!fPdcggdg:ij1dgIiEejCiDdjJfdWdf").equals(this.p) && objArr2.length == 0) {
                cvVar.a(new java.io.BufferedOutputStream((java.io.OutputStream) obj));
                return;
            }
            if (cn.fly.verify.dt.a("018iKedidileiglggdgCij8dgGi,ejNi)dj0fd)df").equals(this.p) && objArr2.length == 0) {
                cvVar.a(new java.util.zip.GZIPOutputStream((java.io.OutputStream) obj));
                return;
            } else if (cn.fly.verify.dt.a("020iSedggfehgJfci3ggdgJij[dg9iMej-iSdj^fd%df").equals(this.p) && objArr2.length == 0) {
                cvVar.a(new java.io.ObjectOutputStream((java.io.OutputStream) obj));
                return;
            }
        } else if (obj instanceof java.lang.Class) {
            if (cn.fly.verify.dt.a("006YdidfCj<eddj3i").equals(this.p)) {
                if (objArr2.length == 0) {
                    java.lang.Class<?> cls = (java.lang.Class) obj;
                    cvVar.a(cls.getSimpleName(), cls);
                    return;
                } else if (objArr2.length == 1) {
                    java.lang.Object obj13 = objArr2[0];
                    if (obj13 instanceof java.lang.String) {
                        cvVar.a((java.lang.String) obj13, (java.lang.Class<?>) obj);
                        return;
                    }
                }
            }
        } else if (obj instanceof java.lang.Throwable) {
            if (cn.fly.verify.dt.a("005ih;djedff").equals(this.p) && objArr2.length == 0) {
                throw ((java.lang.Throwable) obj);
            }
        } else if (java.lang.reflect.AccessibleObject.class.isAssignableFrom(obj.getClass()) && cn.fly.verify.dt.a("013Pfh1fi0elVccf3fhfhdife7gf").equals(this.p) && objArr2.length == 1) {
            ((java.lang.reflect.AccessibleObject) obj).setAccessible(((java.lang.Boolean) objArr2[0]).booleanValue());
            return;
        }
        if (cn.fly.verify.dt.a("004g'ed]c(dl").equals(this.p) && objArr2.length > 0 && (objArr2[0] instanceof cn.fly.verify.dc)) {
            synchronized (obj) {
                cn.fly.verify.dc dcVar3 = (cn.fly.verify.dc) objArr2[0];
                int length5 = objArr2.length - 1;
                java.lang.Object[] objArr3 = new java.lang.Object[length5];
                if (objArr2.length > 1) {
                    java.lang.System.arraycopy(objArr2, 1, objArr3, 0, length5);
                }
                java.util.LinkedList<java.lang.Object> b3 = dcVar3.b(objArr3);
                if (!b3.isEmpty()) {
                    cvVar.a(b3.get(0));
                }
            }
            return;
        }
        java.lang.Class<?> cls2 = obj.getClass();
        if (cvVar.g().a(obj, cls2, this.p, objArr, cvVar)) {
            return;
        }
        for (java.lang.Class<?> cls3 = cls2; cls3 != null; cls3 = cls3.getSuperclass()) {
            boolean[][] zArr2 = new boolean[2][];
            java.lang.reflect.Method a4 = cvVar.g().a(cls3, this.p, false, objArr, zArr2);
            if (a4 != null) {
                if (!zArr2[1][0]) {
                    objArr2 = cvVar.g().a(cvVar, a4.getParameterTypes(), objArr2, zArr2[0]);
                }
                a4.setAccessible(true);
                if (a4.getReturnType() == java.lang.Void.TYPE) {
                    a4.invoke(obj, objArr2);
                    return;
                } else {
                    cvVar.a(a4.invoke(obj, objArr2));
                    return;
                }
            }
        }
        while (cls2 != null) {
            for (java.lang.reflect.Method method : cls2.getDeclaredMethods()) {
                if (method.getName().equals(this.p) && !java.lang.reflect.Modifier.isStatic(method.getModifiers()) && (a2 = cvVar.g().a((parameterTypes = method.getParameterTypes()), objArr2, (zArr = new boolean[1]))) != null) {
                    if (!zArr[0]) {
                        objArr2 = cvVar.g().a(cvVar, parameterTypes, objArr2, a2);
                    }
                    method.setAccessible(true);
                    if (method.getReturnType() == java.lang.Void.TYPE) {
                        method.invoke(obj, objArr2);
                        return;
                    } else {
                        cvVar.a(method.invoke(obj, objArr2));
                        return;
                    }
                }
            }
            cls2 = cls2.getSuperclass();
        }
        throw new java.lang.NoSuchMethodException("method name: " + this.p + " at line: " + this.b + "(" + this.c + ")");
    }

    public void b(java.lang.Class<?> cls, cn.fly.verify.cv cvVar) throws java.lang.Throwable {
        java.lang.reflect.Field field;
        java.lang.Object a2 = cvVar.a();
        while (cls != null) {
            try {
                field = cls.getDeclaredField(this.l);
            } catch (java.lang.Throwable unused) {
                field = null;
            }
            if (field != null && java.lang.reflect.Modifier.isStatic(field.getModifiers())) {
                field.setAccessible(true);
                field.set(null, a2);
                return;
            }
            cls = cls.getSuperclass();
        }
        cn.fly.verify.db dbVar = new cn.fly.verify.db(14);
        dbVar.b = this.b;
        dbVar.c = this.c;
        dbVar.n = this.n;
        dbVar.p = "set" + java.lang.Character.toUpperCase(this.l.charAt(0)) + this.l.substring(1);
        dbVar.i = 1;
        dbVar.a(cls, new java.lang.Object[]{a2}, cvVar);
    }

    public void b(java.lang.Object obj, cn.fly.verify.cv cvVar) throws java.lang.Throwable {
        java.lang.reflect.Field field;
        java.lang.Object a2 = cvVar.a();
        if (obj instanceof java.util.Map) {
            ((java.util.Map) obj).put(this.l, a2);
            return;
        }
        for (java.lang.Class<?> cls = obj.getClass(); cls != null; cls = cls.getSuperclass()) {
            try {
                field = cls.getDeclaredField(this.l);
            } catch (java.lang.Throwable unused) {
                field = null;
            }
            if (field != null && !java.lang.reflect.Modifier.isStatic(field.getModifiers())) {
                field.setAccessible(true);
                field.set(obj, a2);
                return;
            }
        }
        cn.fly.verify.db dbVar = new cn.fly.verify.db(12);
        dbVar.b = this.b;
        dbVar.c = this.c;
        dbVar.p = "set" + java.lang.Character.toUpperCase(this.l.charAt(0)) + this.l.substring(1);
        dbVar.i = 1;
        dbVar.a(obj, new java.lang.Object[]{a2}, cvVar);
    }
}
