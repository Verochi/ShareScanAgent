package com.igexin.push.core.d;

/* loaded from: classes31.dex */
public final class d {
    public static final java.lang.String a = "grp.prop";
    public static final java.lang.String b = "itmp";
    public static final java.lang.String c = "itop";
    public static final java.lang.String d = "c";
    public static final java.lang.String e = "i";
    public static final java.lang.String f = "p";
    public static final java.lang.String g = "s";
    public static final java.lang.String h = "t145gt";
    public static final java.lang.String i = "t145main";
    private static final java.lang.String j = "RpConfig";
    private static final com.igexin.push.core.d.d k = new com.igexin.push.core.d.d();
    private final java.lang.String l;
    private long m;
    private final java.util.Map<java.lang.String, java.lang.String> n = new java.util.HashMap();

    /* renamed from: com.igexin.push.core.d.d$1, reason: invalid class name */
    /* loaded from: classes23.dex */
    public class AnonymousClass1 extends com.igexin.push.core.g.a<java.io.RandomAccessFile> {
        public AnonymousClass1() {
        }

        private void a() {
            com.igexin.push.core.d.d.this.b();
        }

        @Override // com.igexin.push.core.g.a
        public final /* bridge */ /* synthetic */ void a(java.io.RandomAccessFile randomAccessFile) {
            com.igexin.push.core.d.d.this.b();
        }
    }

    /* renamed from: com.igexin.push.core.d.d$2, reason: invalid class name */
    /* loaded from: classes23.dex */
    public class AnonymousClass2 extends com.igexin.push.core.g.a<java.io.RandomAccessFile> {
        final /* synthetic */ java.lang.Object a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass2(java.lang.Object obj, java.lang.String str) {
            this.a = obj;
            this.b = str;
        }

        /* renamed from: a, reason: avoid collision after fix types in other method */
        private void a2(java.io.RandomAccessFile randomAccessFile) {
            java.lang.String jSONArray;
            if (com.igexin.push.core.d.d.this.b()) {
                com.igexin.push.core.d.d.this.a(randomAccessFile);
            }
            java.lang.Object obj = this.a;
            if (obj instanceof java.util.List) {
                try {
                    jSONArray = new org.json.JSONArray((java.util.Collection) this.a).toString();
                } catch (java.lang.Throwable th) {
                    com.igexin.c.a.c.a.a(th);
                    return;
                }
            } else {
                jSONArray = java.lang.String.valueOf(obj);
            }
            com.igexin.push.core.d.d.this.n.put(this.b, jSONArray);
            try {
                randomAccessFile.setLength(0L);
                for (java.util.Map.Entry entry : com.igexin.push.core.d.d.this.n.entrySet()) {
                    randomAccessFile.writeBytes(((java.lang.String) entry.getKey()) + com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER + ((java.lang.String) entry.getValue()));
                    randomAccessFile.writeBytes("\n");
                }
            } catch (java.io.IOException e) {
                com.igexin.c.a.c.a.a(e);
            }
        }

        @Override // com.igexin.push.core.g.a
        public final /* synthetic */ void a(java.io.RandomAccessFile randomAccessFile) {
            java.lang.String jSONArray;
            java.io.RandomAccessFile randomAccessFile2 = randomAccessFile;
            if (com.igexin.push.core.d.d.this.b()) {
                com.igexin.push.core.d.d.this.a(randomAccessFile2);
            }
            java.lang.Object obj = this.a;
            if (obj instanceof java.util.List) {
                try {
                    jSONArray = new org.json.JSONArray((java.util.Collection) this.a).toString();
                } catch (java.lang.Throwable th) {
                    com.igexin.c.a.c.a.a(th);
                    return;
                }
            } else {
                jSONArray = java.lang.String.valueOf(obj);
            }
            com.igexin.push.core.d.d.this.n.put(this.b, jSONArray);
            try {
                randomAccessFile2.setLength(0L);
                for (java.util.Map.Entry entry : com.igexin.push.core.d.d.this.n.entrySet()) {
                    randomAccessFile2.writeBytes(((java.lang.String) entry.getKey()) + com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER + ((java.lang.String) entry.getValue()));
                    randomAccessFile2.writeBytes("\n");
                }
            } catch (java.io.IOException e) {
                com.igexin.c.a.c.a.a(e);
            }
        }
    }

    /* renamed from: com.igexin.push.core.d.d$3, reason: invalid class name */
    /* loaded from: classes23.dex */
    public class AnonymousClass3 extends com.igexin.push.core.g.a<java.io.RandomAccessFile> {
        public AnonymousClass3() {
        }

        private void a() {
            com.igexin.push.core.d.d.this.b();
        }

        @Override // com.igexin.push.core.g.a
        public final /* bridge */ /* synthetic */ void a(java.io.RandomAccessFile randomAccessFile) {
            com.igexin.push.core.d.d.this.b();
        }
    }

    /* renamed from: com.igexin.push.core.d.d$4, reason: invalid class name */
    /* loaded from: classes23.dex */
    public class AnonymousClass4 extends com.igexin.push.core.g.a<java.io.RandomAccessFile> {
        final /* synthetic */ java.lang.String a;

        public AnonymousClass4(java.lang.String str) {
            this.a = str;
        }

        /* renamed from: a, reason: avoid collision after fix types in other method */
        private void a2(java.io.RandomAccessFile randomAccessFile) {
            if (com.igexin.push.core.d.d.this.b()) {
                com.igexin.push.core.d.d.this.a(randomAccessFile);
            }
            com.igexin.push.core.d.d.this.n.remove(this.a);
            try {
                randomAccessFile.setLength(0L);
                for (java.util.Map.Entry entry : com.igexin.push.core.d.d.this.n.entrySet()) {
                    randomAccessFile.writeBytes(((java.lang.String) entry.getKey()) + com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER + ((java.lang.String) entry.getValue()));
                    randomAccessFile.writeBytes("\n");
                }
            } catch (java.io.IOException e) {
                com.igexin.c.a.c.a.a(e);
            }
        }

        @Override // com.igexin.push.core.g.a
        public final /* synthetic */ void a(java.io.RandomAccessFile randomAccessFile) {
            java.io.RandomAccessFile randomAccessFile2 = randomAccessFile;
            if (com.igexin.push.core.d.d.this.b()) {
                com.igexin.push.core.d.d.this.a(randomAccessFile2);
            }
            com.igexin.push.core.d.d.this.n.remove(this.a);
            try {
                randomAccessFile2.setLength(0L);
                for (java.util.Map.Entry entry : com.igexin.push.core.d.d.this.n.entrySet()) {
                    randomAccessFile2.writeBytes(((java.lang.String) entry.getKey()) + com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER + ((java.lang.String) entry.getValue()));
                    randomAccessFile2.writeBytes("\n");
                }
            } catch (java.io.IOException e) {
                com.igexin.c.a.c.a.a(e);
            }
        }
    }

    /* renamed from: com.igexin.push.core.d.d$5, reason: invalid class name */
    /* loaded from: classes23.dex */
    public class AnonymousClass5 extends com.igexin.push.core.g.a<java.io.RandomAccessFile> {
        public AnonymousClass5() {
        }

        /* renamed from: a, reason: avoid collision after fix types in other method */
        private void a2(java.io.RandomAccessFile randomAccessFile) {
            com.igexin.push.core.d.d.this.a(randomAccessFile);
        }

        @Override // com.igexin.push.core.g.a
        public final /* bridge */ /* synthetic */ void a(java.io.RandomAccessFile randomAccessFile) {
            com.igexin.push.core.d.d.this.a(randomAccessFile);
        }
    }

    private d() {
        java.lang.String str = com.igexin.push.core.ServiceManager.b.getFilesDir().getAbsolutePath() + "/grp.prop";
        this.l = str;
        try {
            java.io.File file = new java.io.File(str);
            if (file.exists()) {
                return;
            }
            file.createNewFile();
        } catch (java.io.IOException e2) {
            com.igexin.c.a.c.a.a(e2);
        }
    }

    private int a(java.lang.String str, int... iArr) {
        try {
            return java.lang.Integer.parseInt(a(str));
        } catch (java.lang.NumberFormatException e2) {
            com.igexin.c.a.c.a.a(e2);
            if (iArr == null || iArr.length != 1) {
                return -1;
            }
            return iArr[0];
        }
    }

    public static com.igexin.push.core.d.d a() {
        return k;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(java.io.RandomAccessFile randomAccessFile) {
        int i2;
        try {
            this.n.clear();
            while (true) {
                java.lang.String readLine = randomAccessFile.readLine();
                if (readLine == null) {
                    return true;
                }
                int indexOf = readLine.indexOf(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER);
                if (indexOf >= 0 && (i2 = indexOf + 1) != readLine.length()) {
                    this.n.put(readLine.substring(0, indexOf), readLine.substring(i2));
                }
            }
        } catch (java.lang.Exception e2) {
            com.igexin.c.a.c.a.a(e2);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b() {
        long lastModified = new java.io.File(this.l).lastModified();
        boolean z = this.m != lastModified;
        this.m = lastModified;
        return z;
    }

    private void c(java.lang.String str) {
        a(new com.igexin.push.core.d.d.AnonymousClass4(str).a((com.igexin.push.core.g.a) new com.igexin.push.core.d.d.AnonymousClass3()));
    }

    public final long a(java.lang.String str, long... jArr) {
        try {
            return java.lang.Long.parseLong(a(str));
        } catch (java.lang.NumberFormatException e2) {
            com.igexin.c.a.c.a.a(e2);
            if (jArr.length == 1) {
                return jArr[0];
            }
            return 0L;
        }
    }

    public final java.lang.String a(java.lang.String str) {
        if (b()) {
            a(new com.igexin.push.core.d.d.AnonymousClass5());
        }
        return this.n.get(str);
    }

    public final java.util.ArrayList<java.lang.String> a(java.lang.String str, java.util.ArrayList<java.lang.String> arrayList) {
        java.lang.String a2 = a(str);
        try {
            if (android.text.TextUtils.isEmpty(a2)) {
                return arrayList;
            }
            java.util.ArrayList<java.lang.String> arrayList2 = new java.util.ArrayList<>();
            org.json.JSONArray jSONArray = new org.json.JSONArray(a2);
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                java.lang.String optString = jSONArray.optString(i2);
                if (!android.text.TextUtils.isEmpty(optString)) {
                    arrayList2.add(optString);
                }
            }
            return arrayList2;
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return arrayList;
        }
    }

    public final void a(com.igexin.push.core.g.a<java.io.RandomAccessFile> aVar) {
        java.io.RandomAccessFile randomAccessFile;
        java.nio.channels.FileLock fileLock = null;
        try {
            randomAccessFile = new java.io.RandomAccessFile(new java.io.File(this.l), "rw");
            try {
                try {
                    fileLock = randomAccessFile.getChannel().lock();
                    if (fileLock.isValid()) {
                        aVar.a((com.igexin.push.core.g.a<java.io.RandomAccessFile>) randomAccessFile);
                    }
                    if (fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (java.io.IOException unused) {
                        }
                    }
                    com.getui.gtc.base.util.io.IOUtils.safeClose(randomAccessFile);
                } catch (java.lang.Exception e2) {
                    e = e2;
                    com.igexin.c.a.c.a.a(e);
                    com.igexin.c.a.c.a.a("RpConfig| getProcessLock err：" + e.toString(), new java.lang.Object[0]);
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (java.io.IOException unused2) {
                        }
                    }
                    com.getui.gtc.base.util.io.IOUtils.safeClose(randomAccessFile);
                }
            } catch (java.lang.Throwable th) {
                th = th;
                if (fileLock != null && fileLock.isValid()) {
                    try {
                        fileLock.release();
                    } catch (java.io.IOException unused3) {
                    }
                }
                com.getui.gtc.base.util.io.IOUtils.safeClose(randomAccessFile);
                throw th;
            }
        } catch (java.lang.Exception e3) {
            e = e3;
            randomAccessFile = null;
        } catch (java.lang.Throwable th2) {
            th = th2;
            randomAccessFile = null;
            if (fileLock != null) {
                fileLock.release();
            }
            com.getui.gtc.base.util.io.IOUtils.safeClose(randomAccessFile);
            throw th;
        }
    }

    public final void a(java.lang.String str, java.lang.Object obj) {
        a(new com.igexin.push.core.d.d.AnonymousClass2(obj, str).a((com.igexin.push.core.g.a) new com.igexin.push.core.d.d.AnonymousClass1()));
    }

    public final boolean b(java.lang.String str) {
        return java.lang.Boolean.parseBoolean(a(str));
    }
}
