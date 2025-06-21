package cn.fly.verify;

/* loaded from: classes.dex */
public class da {

    public static class a {
        protected java.util.ArrayList<java.lang.Object> a;
        protected java.io.DataInputStream b;
        protected int c;

        private a(java.util.ArrayList<java.lang.Object> arrayList, java.io.DataInputStream dataInputStream, int i) {
            this.a = arrayList;
            this.b = dataInputStream;
            this.c = i;
        }

        public /* synthetic */ a(java.util.ArrayList arrayList, java.io.DataInputStream dataInputStream, int i, cn.fly.verify.da.AnonymousClass1 anonymousClass1) {
            this(arrayList, dataInputStream, i);
        }

        public void a() throws java.lang.Throwable {
            this.b.readShort();
        }

        public void a(cn.fly.verify.db dbVar) throws java.lang.Throwable {
            dbVar.b = (java.lang.String) this.a.get(this.b.readShort());
            dbVar.c = this.b.readShort();
        }

        public <T> T b() throws java.lang.Throwable {
            return (T) this.a.get(this.b.readShort());
        }

        public int c() {
            return this.c;
        }
    }

    public static class b extends cn.fly.verify.da.a {
        private b(java.util.ArrayList<java.lang.Object> arrayList, java.io.DataInputStream dataInputStream, int i) {
            super(arrayList, dataInputStream, i, null);
        }

        public /* synthetic */ b(java.util.ArrayList arrayList, java.io.DataInputStream dataInputStream, int i, cn.fly.verify.da.AnonymousClass1 anonymousClass1) {
            this(arrayList, dataInputStream, i);
        }

        @Override // cn.fly.verify.da.a
        public void a() throws java.lang.Throwable {
            this.b.readInt();
        }

        @Override // cn.fly.verify.da.a
        public void a(cn.fly.verify.db dbVar) throws java.lang.Throwable {
            dbVar.b = (java.lang.String) this.a.get(this.b.readInt());
            dbVar.c = this.b.readInt();
        }

        @Override // cn.fly.verify.da.a
        public <T> T b() throws java.lang.Throwable {
            return (T) this.a.get(this.b.readInt());
        }
    }

    public static class c {
        private cn.fly.verify.da.d a;

        private c(java.lang.Object obj) {
            this.a = new cn.fly.verify.da.d(obj, null);
        }

        public /* synthetic */ c(java.lang.Object obj, cn.fly.verify.da.AnonymousClass1 anonymousClass1) {
            this(obj);
        }

        public cn.fly.verify.da.c a(java.lang.Object obj) {
            this.a.a(obj);
            return this;
        }

        public cn.fly.verify.da.d a(java.lang.String str, java.lang.Class<?> cls) {
            return this.a.a(str, cls);
        }

        public cn.fly.verify.da.d a(java.lang.String str, java.lang.Object obj) {
            return this.a.a(str, obj);
        }

        public void a() throws java.lang.Throwable {
            this.a.a();
        }
    }

    public static class d {
        private java.util.ArrayList<java.lang.Object> a;
        private java.util.ArrayList<java.lang.Object> b;
        private java.util.HashMap<java.lang.String, java.lang.Object> c;
        private java.util.HashMap<java.lang.String, java.lang.Object> d;
        private java.lang.String e;
        private java.util.HashMap<java.lang.Class<?>, java.lang.Class<? extends cn.fly.verify.cw<?>>> f;

        private d(java.lang.Object obj) {
            java.util.ArrayList<java.lang.Object> arrayList = new java.util.ArrayList<>();
            this.a = arrayList;
            arrayList.add(obj);
            this.b = new java.util.ArrayList<>();
            this.c = new java.util.HashMap<>();
            this.d = new java.util.HashMap<>();
            this.f = new java.util.HashMap<>();
            this.c.put("t_map", this.d);
        }

        public /* synthetic */ d(java.lang.Object obj, cn.fly.verify.da.AnonymousClass1 anonymousClass1) {
            this(obj);
        }

        /* JADX WARN: Code restructure failed: missing block: B:40:0x0013, code lost:
        
            r0 = new java.io.StringWriter();
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x0018, code lost:
        
            r1 = new java.io.PrintWriter(r0);
            r5.printStackTrace(r1);
            r1.flush();
            r1.close();
            r5 = r0.toString();
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x002a, code lost:
        
            r0.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x002e, code lost:
        
            r5 = th;
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x002f, code lost:
        
            r2 = r0;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private java.lang.String a(java.lang.Throwable th) {
            java.lang.String stringWriter;
            if (th == null) {
                return "";
            }
            java.lang.Throwable th2 = th;
            while (true) {
                java.io.StringWriter stringWriter2 = null;
                if (th2 == null) {
                    break;
                }
                try {
                    if (th2 instanceof java.net.UnknownHostException) {
                        return "";
                    }
                    th2 = th2.getCause();
                } catch (java.lang.Throwable th3) {
                    th = th3;
                }
                th = th3;
                try {
                    if (th instanceof java.lang.OutOfMemoryError) {
                        java.lang.String a = cn.fly.verify.ba.a("023=ggBhkRglQkfe,fngmflEfeh?glBkSflfkOgBggkhgfgffh");
                        if (stringWriter2 != null) {
                            try {
                                stringWriter2.close();
                            } catch (java.lang.Throwable unused) {
                            }
                        }
                        return a;
                    }
                    java.lang.String message = th.getMessage();
                    if (stringWriter2 != null) {
                        try {
                            stringWriter2.close();
                        } catch (java.lang.Throwable unused2) {
                        }
                    }
                    return message;
                } catch (java.lang.Throwable th4) {
                    if (stringWriter2 != null) {
                        try {
                            stringWriter2.close();
                        } catch (java.lang.Throwable unused3) {
                        }
                    }
                    throw th4;
                }
            }
            return stringWriter;
        }

        private java.lang.String a(byte[] bArr, java.lang.String str) {
            if (bArr == null) {
                return str;
            }
            try {
                byte[] bytes = str.getBytes("UTF-8");
                javax.crypto.spec.SecretKeySpec secretKeySpec = new javax.crypto.spec.SecretKeySpec(bArr, cn.fly.verify.ba.a("003Cgnijgl"));
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append(cn.fly.verify.ba.a("003Vgnijgl"));
                sb.append(cn.fly.verify.ba.a("003nHijim"));
                sb.append(cn.fly.verify.ba.a("0082hk?nUinkeimglklin"));
                sb.append(cn.fly.verify.ba.a("006f1fefefk^g9gg"));
                java.security.Provider provider = java.security.Security.getProvider(cn.fly.verify.ba.a("002Jhkim"));
                javax.crypto.Cipher cipher = provider != null ? javax.crypto.Cipher.getInstance(sb.toString(), provider) : javax.crypto.Cipher.getInstance(sb.toString(), cn.fly.verify.ba.a("0021hkim"));
                cipher.init(1, secretKeySpec);
                byte[] bArr2 = new byte[cipher.getOutputSize(bytes.length)];
                cipher.doFinal(bArr2, cipher.update(bytes, 0, bytes.length, bArr2, 0));
                return new java.math.BigInteger(1, bArr2).toString(16);
            } catch (java.lang.Throwable unused) {
                return "";
            }
        }

        /* JADX WARN: Can't wrap try/catch for region: R(10:6|(2:7|8)|(21:(24:12|13|14|15|26|27|(1:29)|30|31|(1:33)|34|35|(1:37)|38|39|(1:41)|42|43|(1:45)|46|47|(9:49|50|51|53|54|55|(3:57|58|59)|68|69)(3:132|(1:134)|135)|70|(4:72|(1:74)(1:124)|75|(4:(3:78|(2:80|81)(1:83)|82)|84|85|(8:87|88|89|(7:98|99|101|102|103|104|105)|91|92|93|94)(2:120|121))(2:122|123))(2:125|126))|26|27|(0)|30|31|(0)|34|35|(0)|38|39|(0)|42|43|(0)|46|47|(0)(0)|70|(0)(0))|141|142|143|144|13|14|15) */
        /* JADX WARN: Code restructure failed: missing block: B:139:0x01e2, code lost:
        
            r0 = th;
         */
        /* JADX WARN: Code restructure failed: missing block: B:140:0x01e3, code lost:
        
            r7 = r6;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x01e5, code lost:
        
            r0 = th;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x01ec, code lost:
        
            r2.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x01f0, code lost:
        
            r7.close();
         */
        /* JADX WARN: Removed duplicated region for block: B:125:0x01d7 A[Catch: all -> 0x01df, TryCatch #12 {all -> 0x01df, blocks: (B:27:0x0033, B:29:0x0043, B:31:0x0051, B:33:0x0058, B:35:0x0066, B:37:0x006d, B:39:0x007b, B:41:0x0082, B:43:0x0090, B:45:0x0097, B:47:0x00a5, B:49:0x00ab, B:69:0x00da, B:70:0x00fb, B:72:0x0103, B:74:0x011a, B:75:0x012d, B:78:0x013f, B:80:0x014c, B:82:0x014f, B:85:0x015a, B:87:0x0162, B:120:0x01c7, B:121:0x01ce, B:122:0x01cf, B:123:0x01d6, B:124:0x0124, B:125:0x01d7, B:126:0x01de, B:65:0x00e6, B:66:0x00ed, B:67:0x00ea, B:134:0x00f1), top: B:26:0x0033 }] */
        /* JADX WARN: Removed duplicated region for block: B:132:0x00ee  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x01ec A[Catch: all -> 0x01f3, TRY_ENTER, TryCatch #7 {all -> 0x01f3, blocks: (B:20:0x01ec, B:24:0x01f0), top: B:18:0x01ea }] */
        /* JADX WARN: Removed duplicated region for block: B:24:0x01f0 A[Catch: all -> 0x01f3, TRY_LEAVE, TryCatch #7 {all -> 0x01f3, blocks: (B:20:0x01ec, B:24:0x01f0), top: B:18:0x01ea }] */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0043 A[Catch: all -> 0x01df, LOOP:0: B:28:0x0041->B:29:0x0043, LOOP_END, TryCatch #12 {all -> 0x01df, blocks: (B:27:0x0033, B:29:0x0043, B:31:0x0051, B:33:0x0058, B:35:0x0066, B:37:0x006d, B:39:0x007b, B:41:0x0082, B:43:0x0090, B:45:0x0097, B:47:0x00a5, B:49:0x00ab, B:69:0x00da, B:70:0x00fb, B:72:0x0103, B:74:0x011a, B:75:0x012d, B:78:0x013f, B:80:0x014c, B:82:0x014f, B:85:0x015a, B:87:0x0162, B:120:0x01c7, B:121:0x01ce, B:122:0x01cf, B:123:0x01d6, B:124:0x0124, B:125:0x01d7, B:126:0x01de, B:65:0x00e6, B:66:0x00ed, B:67:0x00ea, B:134:0x00f1), top: B:26:0x0033 }] */
        /* JADX WARN: Removed duplicated region for block: B:33:0x0058 A[Catch: all -> 0x01df, LOOP:1: B:32:0x0056->B:33:0x0058, LOOP_END, TryCatch #12 {all -> 0x01df, blocks: (B:27:0x0033, B:29:0x0043, B:31:0x0051, B:33:0x0058, B:35:0x0066, B:37:0x006d, B:39:0x007b, B:41:0x0082, B:43:0x0090, B:45:0x0097, B:47:0x00a5, B:49:0x00ab, B:69:0x00da, B:70:0x00fb, B:72:0x0103, B:74:0x011a, B:75:0x012d, B:78:0x013f, B:80:0x014c, B:82:0x014f, B:85:0x015a, B:87:0x0162, B:120:0x01c7, B:121:0x01ce, B:122:0x01cf, B:123:0x01d6, B:124:0x0124, B:125:0x01d7, B:126:0x01de, B:65:0x00e6, B:66:0x00ed, B:67:0x00ea, B:134:0x00f1), top: B:26:0x0033 }] */
        /* JADX WARN: Removed duplicated region for block: B:37:0x006d A[Catch: all -> 0x01df, LOOP:2: B:36:0x006b->B:37:0x006d, LOOP_END, TryCatch #12 {all -> 0x01df, blocks: (B:27:0x0033, B:29:0x0043, B:31:0x0051, B:33:0x0058, B:35:0x0066, B:37:0x006d, B:39:0x007b, B:41:0x0082, B:43:0x0090, B:45:0x0097, B:47:0x00a5, B:49:0x00ab, B:69:0x00da, B:70:0x00fb, B:72:0x0103, B:74:0x011a, B:75:0x012d, B:78:0x013f, B:80:0x014c, B:82:0x014f, B:85:0x015a, B:87:0x0162, B:120:0x01c7, B:121:0x01ce, B:122:0x01cf, B:123:0x01d6, B:124:0x0124, B:125:0x01d7, B:126:0x01de, B:65:0x00e6, B:66:0x00ed, B:67:0x00ea, B:134:0x00f1), top: B:26:0x0033 }] */
        /* JADX WARN: Removed duplicated region for block: B:41:0x0082 A[Catch: all -> 0x01df, LOOP:3: B:40:0x0080->B:41:0x0082, LOOP_END, TryCatch #12 {all -> 0x01df, blocks: (B:27:0x0033, B:29:0x0043, B:31:0x0051, B:33:0x0058, B:35:0x0066, B:37:0x006d, B:39:0x007b, B:41:0x0082, B:43:0x0090, B:45:0x0097, B:47:0x00a5, B:49:0x00ab, B:69:0x00da, B:70:0x00fb, B:72:0x0103, B:74:0x011a, B:75:0x012d, B:78:0x013f, B:80:0x014c, B:82:0x014f, B:85:0x015a, B:87:0x0162, B:120:0x01c7, B:121:0x01ce, B:122:0x01cf, B:123:0x01d6, B:124:0x0124, B:125:0x01d7, B:126:0x01de, B:65:0x00e6, B:66:0x00ed, B:67:0x00ea, B:134:0x00f1), top: B:26:0x0033 }] */
        /* JADX WARN: Removed duplicated region for block: B:45:0x0097 A[Catch: all -> 0x01df, LOOP:4: B:44:0x0095->B:45:0x0097, LOOP_END, TryCatch #12 {all -> 0x01df, blocks: (B:27:0x0033, B:29:0x0043, B:31:0x0051, B:33:0x0058, B:35:0x0066, B:37:0x006d, B:39:0x007b, B:41:0x0082, B:43:0x0090, B:45:0x0097, B:47:0x00a5, B:49:0x00ab, B:69:0x00da, B:70:0x00fb, B:72:0x0103, B:74:0x011a, B:75:0x012d, B:78:0x013f, B:80:0x014c, B:82:0x014f, B:85:0x015a, B:87:0x0162, B:120:0x01c7, B:121:0x01ce, B:122:0x01cf, B:123:0x01d6, B:124:0x0124, B:125:0x01d7, B:126:0x01de, B:65:0x00e6, B:66:0x00ed, B:67:0x00ea, B:134:0x00f1), top: B:26:0x0033 }] */
        /* JADX WARN: Removed duplicated region for block: B:49:0x00ab A[Catch: all -> 0x01df, TRY_LEAVE, TryCatch #12 {all -> 0x01df, blocks: (B:27:0x0033, B:29:0x0043, B:31:0x0051, B:33:0x0058, B:35:0x0066, B:37:0x006d, B:39:0x007b, B:41:0x0082, B:43:0x0090, B:45:0x0097, B:47:0x00a5, B:49:0x00ab, B:69:0x00da, B:70:0x00fb, B:72:0x0103, B:74:0x011a, B:75:0x012d, B:78:0x013f, B:80:0x014c, B:82:0x014f, B:85:0x015a, B:87:0x0162, B:120:0x01c7, B:121:0x01ce, B:122:0x01cf, B:123:0x01d6, B:124:0x0124, B:125:0x01d7, B:126:0x01de, B:65:0x00e6, B:66:0x00ed, B:67:0x00ea, B:134:0x00f1), top: B:26:0x0033 }] */
        /* JADX WARN: Removed duplicated region for block: B:72:0x0103 A[Catch: all -> 0x01df, TryCatch #12 {all -> 0x01df, blocks: (B:27:0x0033, B:29:0x0043, B:31:0x0051, B:33:0x0058, B:35:0x0066, B:37:0x006d, B:39:0x007b, B:41:0x0082, B:43:0x0090, B:45:0x0097, B:47:0x00a5, B:49:0x00ab, B:69:0x00da, B:70:0x00fb, B:72:0x0103, B:74:0x011a, B:75:0x012d, B:78:0x013f, B:80:0x014c, B:82:0x014f, B:85:0x015a, B:87:0x0162, B:120:0x01c7, B:121:0x01ce, B:122:0x01cf, B:123:0x01d6, B:124:0x0124, B:125:0x01d7, B:126:0x01de, B:65:0x00e6, B:66:0x00ed, B:67:0x00ea, B:134:0x00f1), top: B:26:0x0033 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private void a(java.io.InputStream inputStream, java.util.ArrayList<cn.fly.verify.db> arrayList, cn.fly.verify.cx cxVar) throws java.lang.Throwable {
            java.io.InputStream inputStream2;
            long currentTimeMillis;
            int read;
            java.io.InputStream gZIPInputStream;
            java.io.DataInputStream dataInputStream;
            int readInt;
            int i;
            int readInt2;
            int i2;
            int readInt3;
            int i3;
            int readInt4;
            int i4;
            int readInt5;
            int i5;
            java.io.ByteArrayInputStream byteArrayInputStream;
            java.io.ByteArrayInputStream byteArrayInputStream2;
            if (inputStream.read() != 70) {
                inputStream.close();
                return;
            }
            java.io.DataInputStream dataInputStream2 = null;
            try {
                currentTimeMillis = java.lang.System.currentTimeMillis();
                read = inputStream.read();
            } catch (java.lang.Throwable th) {
                th = th;
                inputStream2 = inputStream;
            }
            try {
                if (read != 1 && read != 2) {
                    gZIPInputStream = inputStream;
                    inputStream2 = new java.io.BufferedInputStream(gZIPInputStream, 4096);
                    dataInputStream = new java.io.DataInputStream(inputStream2);
                    java.util.ArrayList arrayList2 = new java.util.ArrayList();
                    arrayList2.add(null);
                    readInt = dataInputStream.readInt();
                    for (i = 0; i < readInt; i++) {
                        arrayList2.add(java.lang.Integer.valueOf(dataInputStream.readInt()));
                    }
                    readInt2 = dataInputStream.readInt();
                    for (i2 = 0; i2 < readInt2; i2++) {
                        arrayList2.add(java.lang.Long.valueOf(dataInputStream.readLong()));
                    }
                    readInt3 = dataInputStream.readInt();
                    for (i3 = 0; i3 < readInt3; i3++) {
                        arrayList2.add(java.lang.Float.valueOf(dataInputStream.readFloat()));
                    }
                    readInt4 = dataInputStream.readInt();
                    for (i4 = 0; i4 < readInt4; i4++) {
                        arrayList2.add(java.lang.Double.valueOf(dataInputStream.readDouble()));
                    }
                    readInt5 = dataInputStream.readInt();
                    for (i5 = 0; i5 < readInt5; i5++) {
                        arrayList2.add(java.lang.Boolean.valueOf(dataInputStream.readBoolean()));
                    }
                    int readInt6 = dataInputStream.readInt();
                    if (read != 2) {
                        byte[] bArr = new byte[dataInputStream.readInt()];
                        dataInputStream.readFully(bArr);
                        try {
                            byteArrayInputStream2 = new java.io.ByteArrayInputStream(bArr);
                            try {
                                java.io.DataInputStream dataInputStream3 = new java.io.DataInputStream(new java.io.BufferedInputStream(new java.util.zip.GZIPInputStream(byteArrayInputStream2), 2048));
                                for (int i6 = 0; i6 < readInt6; i6++) {
                                    try {
                                        arrayList2.add(dataInputStream3.readUTF());
                                    } catch (java.lang.Throwable th2) {
                                        th = th2;
                                        dataInputStream2 = dataInputStream3;
                                        if (dataInputStream2 != null) {
                                            dataInputStream2.close();
                                        } else if (byteArrayInputStream2 != null) {
                                            byteArrayInputStream2.close();
                                        }
                                        throw th;
                                    }
                                }
                                dataInputStream3.close();
                            } catch (java.lang.Throwable th3) {
                                th = th3;
                            }
                        } catch (java.lang.Throwable th4) {
                            th = th4;
                            byteArrayInputStream2 = null;
                        }
                    } else {
                        for (int i7 = 0; i7 < readInt6; i7++) {
                            arrayList2.add(dataInputStream.readUTF());
                        }
                    }
                    if (dataInputStream.readByte() == 15) {
                        throw new java.lang.RuntimeException("data has offset in pos 1");
                    }
                    long currentTimeMillis2 = java.lang.System.currentTimeMillis();
                    this.d.put("lc_t", java.lang.Long.valueOf(currentTimeMillis2 - currentTimeMillis));
                    cn.fly.verify.da.a bVar = dataInputStream.readBoolean() ? new cn.fly.verify.da.b(arrayList2, dataInputStream, arrayList.size(), null) : new cn.fly.verify.da.a(arrayList2, dataInputStream, arrayList.size(), null);
                    int readInt7 = dataInputStream.readInt();
                    boolean readBoolean = dataInputStream.readBoolean();
                    if (dataInputStream.readByte() != 25) {
                        throw new java.lang.RuntimeException("data has offset in pos 2");
                    }
                    for (int i8 = 0; i8 < readInt7; i8++) {
                        cn.fly.verify.db dbVar = new cn.fly.verify.db();
                        dbVar.a = dataInputStream.readByte();
                        if (readBoolean) {
                            bVar.a(dbVar);
                        }
                        dbVar.a(bVar);
                        arrayList.add(dbVar);
                    }
                    if (dataInputStream.readByte() != 39) {
                        throw new java.lang.RuntimeException("data has offset in pos 3");
                    }
                    long currentTimeMillis3 = java.lang.System.currentTimeMillis();
                    this.d.put("lcmd_t", java.lang.Long.valueOf(currentTimeMillis3 - currentTimeMillis2));
                    try {
                        byte[] bArr2 = new byte[dataInputStream.readInt()];
                        dataInputStream.readFully(bArr2);
                        if (read == 2) {
                            try {
                                byteArrayInputStream = new java.io.ByteArrayInputStream(bArr2);
                                try {
                                    java.io.DataInputStream dataInputStream4 = new java.io.DataInputStream(new java.util.zip.GZIPInputStream(byteArrayInputStream));
                                    try {
                                        byte[] bArr3 = new byte[dataInputStream4.readInt()];
                                        dataInputStream4.readFully(bArr3);
                                        dataInputStream4.close();
                                        bArr2 = bArr3;
                                    } catch (java.lang.Throwable th5) {
                                        th = th5;
                                        dataInputStream2 = dataInputStream4;
                                        if (dataInputStream2 != null) {
                                            dataInputStream2.close();
                                        } else if (byteArrayInputStream != null) {
                                            byteArrayInputStream.close();
                                        }
                                        throw th;
                                    }
                                } catch (java.lang.Throwable th6) {
                                    th = th6;
                                }
                            } catch (java.lang.Throwable th7) {
                                th = th7;
                                byteArrayInputStream = null;
                            }
                        }
                        cxVar.a(bArr2);
                        this.d.put("mreg_t", java.lang.Long.valueOf(java.lang.System.currentTimeMillis() - currentTimeMillis3));
                    } catch (java.lang.Throwable unused) {
                    }
                    try {
                        dataInputStream.close();
                        return;
                    } catch (java.lang.Throwable unused2) {
                        return;
                    }
                }
                java.util.ArrayList arrayList22 = new java.util.ArrayList();
                arrayList22.add(null);
                readInt = dataInputStream.readInt();
                while (i < readInt) {
                }
                readInt2 = dataInputStream.readInt();
                while (i2 < readInt2) {
                }
                readInt3 = dataInputStream.readInt();
                while (i3 < readInt3) {
                }
                readInt4 = dataInputStream.readInt();
                while (i4 < readInt4) {
                }
                readInt5 = dataInputStream.readInt();
                while (i5 < readInt5) {
                }
                int readInt62 = dataInputStream.readInt();
                if (read != 2) {
                }
                if (dataInputStream.readByte() == 15) {
                }
            } catch (java.lang.Throwable th8) {
                th = th8;
                dataInputStream2 = dataInputStream;
                try {
                    if (dataInputStream2 == null) {
                    }
                } catch (java.lang.Throwable unused3) {
                }
                throw th;
            }
            inputStream2 = inputStream;
            gZIPInputStream = new java.util.zip.GZIPInputStream(inputStream2);
            inputStream2 = new java.io.BufferedInputStream(gZIPInputStream, 4096);
            dataInputStream = new java.io.DataInputStream(inputStream2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(java.lang.Object obj) {
            this.a.add(obj);
        }

        public <T> cn.fly.verify.da.d a(java.lang.Class<T> cls, java.lang.Class<? extends cn.fly.verify.cw<T>> cls2) {
            this.f.put(cls, cls2);
            return this;
        }

        public cn.fly.verify.da.d a(java.lang.String str) {
            this.e = str;
            return this;
        }

        public cn.fly.verify.da.d a(java.lang.String str, java.lang.Class<?> cls) {
            cn.fly.verify.cz.a.put(str, cls);
            return this;
        }

        public cn.fly.verify.da.d a(java.lang.String str, java.lang.Object obj) {
            this.c.put(str, obj);
            return this;
        }

        public void a() throws java.lang.Throwable {
            byte[] bArr;
            java.io.InputStream byteArrayInputStream;
            java.util.ArrayList<cn.fly.verify.db> arrayList = new java.util.ArrayList<>();
            java.lang.String str = this.e;
            if (str != null) {
                bArr = str.getBytes("UTF-8");
                java.lang.System.arraycopy(bArr, 0, new byte[16], 0, java.lang.Math.min(bArr.length, 16));
            } else {
                bArr = null;
            }
            try {
                cn.fly.verify.cx cxVar = new cn.fly.verify.cx();
                java.util.Iterator<java.lang.Object> it = this.a.iterator();
                while (it.hasNext()) {
                    java.lang.Object next = it.next();
                    if (next instanceof java.lang.String) {
                        byteArrayInputStream = new java.io.FileInputStream((java.lang.String) next);
                    } else {
                        if (!(next instanceof byte[])) {
                            throw new java.lang.ClassCastException("program is not string or byte array");
                        }
                        byteArrayInputStream = new java.io.ByteArrayInputStream((byte[]) next);
                    }
                    long currentTimeMillis = java.lang.System.currentTimeMillis();
                    a(byteArrayInputStream, arrayList, cxVar);
                    this.d.put("l_t", java.lang.Long.valueOf(java.lang.System.currentTimeMillis() - currentTimeMillis));
                }
                for (java.util.Map.Entry<java.lang.Class<?>, java.lang.Class<? extends cn.fly.verify.cw<?>>> entry : this.f.entrySet()) {
                    cxVar.a(entry.getKey(), entry.getValue());
                }
                new cn.fly.verify.cz(arrayList, this.b).a(this.c, cxVar);
            } catch (java.lang.Throwable th) {
                th = th;
                if (bArr == null) {
                    throw th;
                }
                java.lang.String cls = th.getMessage() == null ? th.getClass().toString() : th.getMessage();
                if (th instanceof cn.fly.verify.cy) {
                    th = th.getCause();
                }
                throw new cn.fly.verify.cy(a(bArr, cls + " " + a(th)), th);
            }
        }
    }

    private da() {
    }

    public static int a() {
        return 70;
    }

    private static cn.fly.verify.da.c a(java.lang.Object[] objArr) {
        if (objArr.length == 0) {
            return null;
        }
        cn.fly.verify.da.c cVar = new cn.fly.verify.da.c(objArr[0], null);
        for (int i = 1; i < objArr.length; i++) {
            cVar.a(objArr[i]);
        }
        return cVar;
    }

    public static cn.fly.verify.da.c a(java.lang.String... strArr) {
        return a((java.lang.Object[]) strArr);
    }

    public static cn.fly.verify.da.c a(byte[]... bArr) {
        return a((java.lang.Object[]) bArr);
    }
}
