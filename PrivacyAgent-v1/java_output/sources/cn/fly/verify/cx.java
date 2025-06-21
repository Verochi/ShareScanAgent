package cn.fly.verify;

/* loaded from: classes.dex */
public class cx {
    private static final java.util.HashMap<java.lang.String, java.lang.Class<?>> a;
    private final java.util.HashMap<java.lang.String, java.util.HashMap<java.lang.String, java.lang.String[][]>> b = new java.util.HashMap<>();
    private final java.util.HashMap<java.lang.Class<?>, cn.fly.verify.cw<?>> c = new java.util.HashMap<>();

    static {
        java.util.HashMap<java.lang.String, java.lang.Class<?>> hashMap = new java.util.HashMap<>();
        a = hashMap;
        hashMap.put(cn.fly.verify.dt.a("003KdiAei"), java.lang.Integer.TYPE);
        hashMap.put(cn.fly.verify.dt.a("006@dceddgfe^gf"), java.lang.Double.TYPE);
        hashMap.put("long", java.lang.Long.TYPE);
        hashMap.put(cn.fly.verify.dt.a("005$efHgGedOdi"), java.lang.Float.TYPE);
        hashMap.put("boolean", java.lang.Boolean.TYPE);
        hashMap.put("short", java.lang.Short.TYPE);
        hashMap.put("byte", java.lang.Byte.TYPE);
        hashMap.put(cn.fly.verify.dt.a("004chd;dj"), java.lang.Character.TYPE);
        hashMap.put("void", java.lang.Void.TYPE);
    }

    public cx() {
        a(cn.fly.verify.dc.a.class, cn.fly.verify.dc.a.class);
    }

    private java.lang.Class<?> a(java.lang.String str) {
        java.lang.Class<?> cls = a.get(str);
        if (cls != null) {
            return cls;
        }
        try {
            return java.lang.Class.forName(str);
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    private boolean b(java.lang.Class<?> cls, java.lang.Class<?> cls2) {
        return (cls == java.lang.Byte.TYPE && cls2 == java.lang.Byte.class) || (cls == java.lang.Short.TYPE && (cls2 == java.lang.Short.class || cls2 == java.lang.Byte.class || cls2 == java.lang.Character.class)) || ((cls == java.lang.Character.TYPE && (cls2 == java.lang.Character.class || cls2 == java.lang.Short.class || cls2 == java.lang.Byte.class)) || ((cls == java.lang.Integer.TYPE && (cls2 == java.lang.Integer.class || cls2 == java.lang.Short.class || cls2 == java.lang.Byte.class || cls2 == java.lang.Character.class)) || ((cls == java.lang.Long.TYPE && (cls2 == java.lang.Long.class || cls2 == java.lang.Integer.class || cls2 == java.lang.Short.class || cls2 == java.lang.Byte.class || cls2 == java.lang.Character.class)) || ((cls == java.lang.Float.TYPE && (cls2 == java.lang.Float.class || cls2 == java.lang.Long.class || cls2 == java.lang.Integer.class || cls2 == java.lang.Short.class || cls2 == java.lang.Byte.class || cls2 == java.lang.Character.class)) || ((cls == java.lang.Double.TYPE && (cls2 == java.lang.Double.class || cls2 == java.lang.Float.class || cls2 == java.lang.Long.class || cls2 == java.lang.Integer.class || cls2 == java.lang.Short.class || cls2 == java.lang.Byte.class || cls2 == java.lang.Character.class)) || (cls == java.lang.Boolean.TYPE && cls2 == java.lang.Boolean.class))))));
    }

    /*  JADX ERROR: NoSuchElementException in pass: ReplaceNewArray
        java.util.NoSuchElementException
        	at java.base/java.util.TreeMap.key(TreeMap.java:1640)
        	at java.base/java.util.TreeMap.lastKey(TreeMap.java:310)
        	at jadx.core.dex.visitors.ReplaceNewArray.processNewArray(ReplaceNewArray.java:171)
        	at jadx.core.dex.visitors.ReplaceNewArray.processInsn(ReplaceNewArray.java:72)
        	at jadx.core.dex.visitors.ReplaceNewArray.visit(ReplaceNewArray.java:53)
        */
    public java.lang.reflect.Constructor a(java.lang.Class<?> r12, java.lang.Object[] r13, boolean[][] r14) throws java.lang.Throwable {
        /*
            r11 = this;
            java.util.HashMap<java.lang.String, java.util.HashMap<java.lang.String, java.lang.String[][]>> r0 = r11.b
            java.lang.String r1 = r12.getName()
            java.lang.Object r0 = r0.get(r1)
            java.util.HashMap r0 = (java.util.HashMap) r0
            if (r0 == 0) goto L52
            java.lang.String r1 = "<init>"
            java.lang.Object r0 = r0.get(r1)
            java.lang.String[][] r0 = (java.lang.String[][]) r0
            if (r0 == 0) goto L52
            int r1 = r0.length
            r2 = 0
            r3 = 0
        L1b:
            if (r3 >= r1) goto L52
            r4 = r0[r3]
            int r5 = r4.length
            r6 = 1
            int r5 = r5 - r6
            int r7 = r13.length
            if (r5 != r7) goto L4f
            int r5 = r13.length
            java.lang.Class[] r7 = new java.lang.Class[r5]
            r8 = 0
        L29:
            if (r8 >= r5) goto L3b
            int r9 = r8 + 1
            r10 = r4[r9]
            java.lang.Class r10 = r11.a(r10)
            r7[r8] = r10
            if (r10 != 0) goto L39
            r4 = 1
            goto L3c
        L39:
            r8 = r9
            goto L29
        L3b:
            r4 = 0
        L3c:
            if (r4 != 0) goto L4f
            boolean[] r4 = new boolean[r6]
            boolean[] r5 = r11.a(r7, r13, r4)
            if (r5 == 0) goto L4f
            r14[r2] = r5
            r14[r6] = r4
            java.lang.reflect.Constructor r12 = r12.getDeclaredConstructor(r7)
            return r12
        L4f:
            int r3 = r3 + 1
            goto L1b
        L52:
            r12 = 0
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.fly.verify.cx.a(java.lang.Class, java.lang.Object[], boolean[][]):java.lang.reflect.Constructor");
    }

    /*  JADX ERROR: NoSuchElementException in pass: ReplaceNewArray
        java.util.NoSuchElementException
        	at java.base/java.util.TreeMap.key(TreeMap.java:1640)
        	at java.base/java.util.TreeMap.lastKey(TreeMap.java:310)
        	at jadx.core.dex.visitors.ReplaceNewArray.processNewArray(ReplaceNewArray.java:171)
        	at jadx.core.dex.visitors.ReplaceNewArray.processInsn(ReplaceNewArray.java:72)
        	at jadx.core.dex.visitors.ReplaceNewArray.visit(ReplaceNewArray.java:53)
        */
    public java.lang.reflect.Method a(java.lang.Class<?> r16, java.lang.String r17, boolean r18, java.lang.Object[] r19, boolean[][] r20) throws java.lang.Throwable {
        /*
            r15 = this;
            r0 = r15
            r1 = r17
            r2 = r19
            java.util.HashMap<java.lang.String, java.util.HashMap<java.lang.String, java.lang.String[][]>> r3 = r0.b
            java.lang.String r4 = r16.getName()
            java.lang.Object r3 = r3.get(r4)
            java.util.HashMap r3 = (java.util.HashMap) r3
            if (r3 == 0) goto L6b
            java.lang.Object r3 = r3.get(r1)
            java.lang.String[][] r3 = (java.lang.String[][]) r3
            if (r3 == 0) goto L6b
            int r4 = r3.length
            r5 = 0
            r6 = 0
        L1e:
            if (r6 >= r4) goto L6b
            r7 = r3[r6]
            r8 = r7[r5]
            r9 = 1
            if (r8 == 0) goto L2b
            r8 = r18
            r10 = 1
            goto L2e
        L2b:
            r8 = r18
            r10 = 0
        L2e:
            if (r8 != r10) goto L32
            r10 = 1
            goto L33
        L32:
            r10 = 0
        L33:
            if (r10 == 0) goto L66
            int r10 = r7.length
            int r10 = r10 - r9
            int r11 = r2.length
            if (r10 != r11) goto L66
            int r10 = r2.length
            java.lang.Class[] r11 = new java.lang.Class[r10]
            r12 = 0
        L3e:
            if (r12 >= r10) goto L50
            int r13 = r12 + 1
            r14 = r7[r13]
            java.lang.Class r14 = r15.a(r14)
            r11[r12] = r14
            if (r14 != 0) goto L4e
            r7 = 1
            goto L51
        L4e:
            r12 = r13
            goto L3e
        L50:
            r7 = 0
        L51:
            if (r7 != 0) goto L66
            boolean[] r7 = new boolean[r9]
            boolean[] r10 = r15.a(r11, r2, r7)
            if (r10 == 0) goto L66
            r20[r5] = r10
            r20[r9] = r7
            r7 = r16
            java.lang.reflect.Method r1 = r7.getDeclaredMethod(r1, r11)
            return r1
        L66:
            r7 = r16
            int r6 = r6 + 1
            goto L1e
        L6b:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.fly.verify.cx.a(java.lang.Class, java.lang.String, boolean, java.lang.Object[], boolean[][]):java.lang.reflect.Method");
    }

    public void a(java.lang.Class<?> cls, java.lang.Class<? extends cn.fly.verify.cw<?>> cls2) {
        try {
            cn.fly.verify.cw<?> newInstance = cls2.getDeclaredConstructor(new java.lang.Class[0]).newInstance(new java.lang.Object[0]);
            if (this.c.get(cls) == null) {
                this.c.put(cls, newInstance);
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public void a(byte[] bArr) throws java.lang.Throwable {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.ByteArrayInputStream(bArr), "utf-8"));
        try {
            try {
                java.util.HashMap<java.lang.String, java.lang.String[][]> hashMap = null;
                for (java.lang.String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                    java.lang.String substring = readLine.substring(0, 2);
                    java.lang.String substring2 = readLine.substring(2);
                    if (":P".equals(substring)) {
                        arrayList.addAll(java.util.Arrays.asList(substring2.split("#")));
                    } else if (":C".equals(substring)) {
                        java.lang.String str = (java.lang.String) arrayList.get(java.lang.Integer.parseInt(substring2));
                        hashMap = this.b.get(str);
                        if (hashMap == null) {
                            hashMap = new java.util.HashMap<>();
                            this.b.put(str, hashMap);
                        }
                    } else {
                        java.lang.String[] split = substring2.split("#");
                        java.lang.String str2 = (java.lang.String) arrayList.get(java.lang.Integer.parseInt(split[0]));
                        java.lang.String[][] strArr = new java.lang.String[java.lang.Integer.parseInt(split[1])][];
                        for (int i = 2; i < split.length; i++) {
                            java.lang.String str3 = split[i].startsWith("+") ? "+" : null;
                            if (split[i].length() > 1) {
                                java.lang.String[] split2 = split[i].substring(1).split(",");
                                java.lang.String[] strArr2 = new java.lang.String[split2.length + 1];
                                strArr2[0] = str3;
                                int i2 = 0;
                                while (i2 < split2.length) {
                                    int i3 = i2 + 1;
                                    strArr2[i3] = (java.lang.String) arrayList.get(java.lang.Integer.parseInt(split2[i2]));
                                    i2 = i3;
                                }
                                strArr[i - 2] = strArr2;
                            } else {
                                strArr[i - 2] = new java.lang.String[]{str3};
                            }
                        }
                        hashMap.put(str2, strArr);
                    }
                }
            } finally {
                bufferedReader.close();
            }
        } catch (java.lang.Throwable unused) {
            this.b.clear();
        }
    }

    public boolean a(java.lang.Object obj, java.lang.Class<?> cls, java.lang.String str, java.lang.Object[] objArr, cn.fly.verify.cv cvVar) throws java.lang.Throwable {
        cn.fly.verify.cw<?> cwVar = null;
        for (java.lang.Class<?> cls2 = cls; cwVar == null && cls2 != null && cls2 != java.lang.Object.class; cls2 = cls2.getSuperclass()) {
            cwVar = this.c.get(cls2);
        }
        if (cwVar == null) {
            return false;
        }
        boolean[] zArr = new boolean[1];
        java.lang.Object[] objArr2 = new java.lang.Object[1];
        java.lang.Throwable[] thArr = new java.lang.Throwable[1];
        boolean a2 = cwVar.a(obj, cls, str, objArr, zArr, objArr2, thArr);
        if (a2) {
            java.lang.Throwable th = thArr[0];
            if (th != null) {
                throw th;
            }
            if (!zArr[0]) {
                cvVar.a(objArr2[0]);
            }
        }
        return a2;
    }

    public java.lang.Object[] a(cn.fly.verify.cv cvVar, java.lang.Class<?>[] clsArr, java.lang.Object[] objArr, boolean[] zArr) {
        java.lang.Object[] objArr2 = new java.lang.Object[zArr.length];
        for (int i = 0; i < zArr.length; i++) {
            java.lang.Object obj = objArr[i];
            if (obj != null) {
                if (zArr[i]) {
                    objArr2[i] = cvVar.a(obj, true, clsArr[i]);
                } else {
                    objArr2[i] = obj;
                }
            }
        }
        return objArr2;
    }

    public boolean[] a(java.lang.Class<?>[] clsArr, java.lang.Object[] objArr, boolean[] zArr) {
        zArr[0] = true;
        if (clsArr.length != objArr.length) {
            return null;
        }
        boolean[] zArr2 = new boolean[clsArr.length];
        for (int i = 0; i < objArr.length; i++) {
            java.lang.Object obj = objArr[i];
            if (obj != null) {
                java.lang.Class<?> cls = clsArr[i];
                if (cls.isInterface() && (obj instanceof cn.fly.verify.dc)) {
                    zArr2[i] = true;
                    zArr[0] = false;
                } else {
                    java.lang.Class<?> cls2 = obj.getClass();
                    if (!b(cls, cls2) && !cls.isAssignableFrom(cls2)) {
                        return null;
                    }
                    zArr2[i] = false;
                }
            }
        }
        return zArr2;
    }
}
