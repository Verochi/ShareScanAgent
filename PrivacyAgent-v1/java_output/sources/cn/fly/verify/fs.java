package cn.fly.verify;

/* loaded from: classes.dex */
public class fs {
    public static final java.lang.String a = cn.fly.verify.ds.b("005 ekccccdi@i");
    private android.content.Context b;
    private volatile cn.fly.verify.fs.a c;

    public static final class a {
        private static android.os.Handler c;
        private java.io.File a;
        private java.util.HashMap<java.lang.String, java.lang.Object> b;

        /* renamed from: cn.fly.verify.fs$a$1, reason: invalid class name */
        public class AnonymousClass1 implements android.os.Handler.Callback {
            @Override // android.os.Handler.Callback
            public boolean handleMessage(android.os.Message message) {
                java.io.FileOutputStream fileOutputStream;
                java.lang.Throwable th;
                java.io.OutputStreamWriter outputStreamWriter;
                try {
                    android.os.Bundle data = message.getData();
                    java.lang.String string = data.getString(cn.fly.verify.ds.b("0043gfegdc;d"));
                    fileOutputStream = new java.io.FileOutputStream(data.getString(cn.fly.verify.ds.b("004;dech:fe")));
                    try {
                        outputStreamWriter = new java.io.OutputStreamWriter(fileOutputStream, "utf-8");
                        try {
                            outputStreamWriter.append((java.lang.CharSequence) string);
                            outputStreamWriter.flush();
                            cn.fly.verify.dw.a(outputStreamWriter, fileOutputStream);
                        } catch (java.lang.Throwable th2) {
                            th = th2;
                            try {
                                cn.fly.verify.ed.a().b(th);
                                cn.fly.verify.dw.a(outputStreamWriter, fileOutputStream);
                                return false;
                            } catch (java.lang.Throwable th3) {
                                cn.fly.verify.dw.a(outputStreamWriter, fileOutputStream);
                                throw th3;
                            }
                        }
                    } catch (java.lang.Throwable th4) {
                        th = th4;
                        outputStreamWriter = null;
                    }
                } catch (java.lang.Throwable th5) {
                    fileOutputStream = null;
                    th = th5;
                    outputStreamWriter = null;
                }
                return false;
            }
        }

        static {
            java.lang.String str;
            if (android.text.TextUtils.isEmpty("M-")) {
                str = null;
            } else {
                str = cn.fly.verify.ea.a + cn.fly.verify.ds.b("002Gdifk");
            }
            c = cn.fly.verify.ec.a(str, new cn.fly.verify.fs.a.AnonymousClass1());
        }

        public a(android.content.Context context, java.lang.String str) {
            this(context, str, cn.fly.verify.fs.a);
        }

        public a(android.content.Context context, java.lang.String str, java.lang.String str2) {
            this.b = new java.util.HashMap<>();
            if (context != null) {
                try {
                    java.io.File file = new java.io.File(new java.io.File(context.getFilesDir(), str2), str);
                    this.a = file;
                    if (!file.getParentFile().exists()) {
                        this.a.getParentFile().mkdirs();
                    }
                    if (!this.a.exists()) {
                        this.a.createNewFile();
                    }
                } catch (java.lang.Throwable th) {
                    cn.fly.verify.ed.a().a(th);
                    return;
                }
            }
            b();
        }

        private void a(java.lang.String str, java.lang.Object obj) {
            synchronized (this.b) {
                this.b.put(str, obj);
                if (c != null && this.a != null) {
                    android.os.Message message = new android.os.Message();
                    android.os.Bundle bundle = new android.os.Bundle();
                    bundle.putString(cn.fly.verify.ds.b("004!gfegdc<d"), cn.fly.verify.fm.a((java.util.HashMap) this.b));
                    bundle.putString(cn.fly.verify.ds.b("0044dech-fe"), this.a.getAbsolutePath());
                    message.setData(bundle);
                    message.what = 1;
                    c.sendMessage(message);
                }
            }
        }

        private java.lang.Object b(java.lang.String str) {
            java.lang.Object obj;
            synchronized (this.b) {
                obj = this.b.get(str);
            }
            return obj;
        }

        private void b() {
            java.io.InputStreamReader inputStreamReader;
            java.io.BufferedReader bufferedReader;
            java.lang.Throwable th;
            java.io.FileInputStream fileInputStream;
            synchronized (this.b) {
                java.io.File file = this.a;
                if (file != null && file.exists()) {
                    try {
                        fileInputStream = new java.io.FileInputStream(this.a);
                        try {
                            inputStreamReader = new java.io.InputStreamReader(fileInputStream, "utf-8");
                            try {
                                bufferedReader = new java.io.BufferedReader(inputStreamReader);
                                try {
                                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                                    while (true) {
                                        java.lang.String readLine = bufferedReader.readLine();
                                        if (readLine == null) {
                                            break;
                                        }
                                        if (sb.length() > 0) {
                                            sb.append("\n");
                                        }
                                        sb.append(readLine);
                                    }
                                    this.b = cn.fly.verify.fm.a(sb.toString());
                                    cn.fly.verify.dw.a(bufferedReader, inputStreamReader, fileInputStream);
                                } catch (java.lang.Throwable th2) {
                                    th = th2;
                                    try {
                                        cn.fly.verify.ed.a().b(th);
                                        cn.fly.verify.dw.a(bufferedReader, inputStreamReader, fileInputStream);
                                    } catch (java.lang.Throwable th3) {
                                        cn.fly.verify.dw.a(bufferedReader, inputStreamReader, fileInputStream);
                                        throw th3;
                                    }
                                }
                            } catch (java.lang.Throwable th4) {
                                bufferedReader = null;
                                th = th4;
                            }
                        } catch (java.lang.Throwable th5) {
                            bufferedReader = null;
                            th = th5;
                            inputStreamReader = null;
                        }
                    } catch (java.lang.Throwable th6) {
                        inputStreamReader = null;
                        bufferedReader = null;
                        th = th6;
                        fileInputStream = null;
                    }
                }
            }
        }

        public int a(java.lang.String str, int i) {
            java.lang.Object b = b(str);
            return b != null ? ((java.lang.Number) b).intValue() : i;
        }

        public long a(java.lang.String str, long j) {
            java.lang.Object b = b(str);
            return b != null ? ((java.lang.Number) b).longValue() : j;
        }

        public java.lang.String a(java.lang.String str, java.lang.String str2) {
            java.lang.Object b = b(str);
            return b != null ? (java.lang.String) b : str2;
        }

        public java.util.HashMap<java.lang.String, java.lang.Object> a() {
            java.util.HashMap<java.lang.String, java.lang.Object> hashMap;
            synchronized (this.b) {
                hashMap = new java.util.HashMap<>();
                hashMap.putAll(this.b);
            }
            return hashMap;
        }

        public void a(java.lang.String str) {
            a(str, (java.lang.Object) null);
        }

        public void a(java.lang.String str, byte b) {
            a(str, java.lang.Byte.valueOf(b));
        }

        public void a(java.util.HashMap<java.lang.String, java.lang.Object> hashMap) {
            synchronized (this.b) {
                this.b.putAll(hashMap);
            }
            if (c == null || this.a == null) {
                return;
            }
            android.os.Message message = new android.os.Message();
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putString(cn.fly.verify.ds.b("004WgfegdcQd"), cn.fly.verify.fm.a((java.util.HashMap) this.b));
            bundle.putString(cn.fly.verify.ds.b("004Mdech1fe"), this.a.getAbsolutePath());
            message.setData(bundle);
            message.what = 1;
            c.sendMessage(message);
        }

        public boolean a(java.lang.String str, boolean z) {
            java.lang.Object b = b(str);
            return b != null ? ((java.lang.Number) b).byteValue() == 1 : z;
        }

        public void b(java.lang.String str, int i) {
            a(str, java.lang.Integer.valueOf(i));
        }

        public void b(java.lang.String str, long j) {
            a(str, java.lang.Long.valueOf(j));
        }

        public void b(java.lang.String str, java.lang.String str2) {
            a(str, (java.lang.Object) str2);
        }

        public void b(java.lang.String str, boolean z) {
            a(str, z ? (byte) 1 : (byte) 0);
        }
    }

    public fs(android.content.Context context) {
        if (context != null) {
            this.b = context.getApplicationContext();
        }
    }

    public long a(java.lang.String str, long j) {
        return this.c != null ? this.c.a(str, j) : j;
    }

    public java.lang.String a(java.lang.String str) {
        return this.c != null ? this.c.a(str, "") : "";
    }

    public java.util.HashMap<java.lang.String, java.lang.Object> a() {
        return this.c != null ? this.c.a() : new java.util.HashMap<>();
    }

    public void a(java.lang.String str, int i) {
        this.c = new cn.fly.verify.fs.a(this.b, str + "_" + i);
    }

    public void a(java.lang.String str, java.lang.Boolean bool) {
        if (this.c != null) {
            this.c.b(str, bool.booleanValue());
        }
    }

    public void a(java.lang.String str, java.lang.Integer num) {
        if (this.c != null) {
            this.c.b(str, num.intValue());
        }
    }

    public void a(java.lang.String str, java.lang.Long l) {
        if (this.c != null) {
            this.c.b(str, l.longValue());
        }
    }

    public void a(java.lang.String str, java.lang.Object obj) {
        java.io.ObjectOutputStream objectOutputStream;
        if (obj == null) {
            return;
        }
        java.io.ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            java.io.ByteArrayOutputStream byteArrayOutputStream2 = new java.io.ByteArrayOutputStream();
            try {
                objectOutputStream = new java.io.ObjectOutputStream(byteArrayOutputStream2);
                try {
                    objectOutputStream.writeObject(obj);
                    objectOutputStream.flush();
                    a(str, android.util.Base64.encodeToString(byteArrayOutputStream2.toByteArray(), 2));
                    cn.fly.verify.dw.a(objectOutputStream, byteArrayOutputStream2);
                } catch (java.lang.Throwable th) {
                    th = th;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    try {
                        cn.fly.verify.ed.a().b(th);
                        cn.fly.verify.dw.a(objectOutputStream, byteArrayOutputStream);
                    } catch (java.lang.Throwable th2) {
                        cn.fly.verify.dw.a(objectOutputStream, byteArrayOutputStream);
                        throw th2;
                    }
                }
            } catch (java.lang.Throwable th3) {
                th = th3;
                objectOutputStream = null;
            }
        } catch (java.lang.Throwable th4) {
            th = th4;
            objectOutputStream = null;
        }
    }

    public void a(java.lang.String str, java.lang.String str2) {
        if (this.c != null) {
            this.c.b(str, str2);
        }
    }

    public void a(java.lang.String str, java.lang.String str2, int i) {
        this.c = new cn.fly.verify.fs.a(this.b, str2 + "_" + i, str);
    }

    public void a(java.util.HashMap<java.lang.String, java.lang.Object> hashMap) {
        if (this.c != null) {
            this.c.a(hashMap);
        }
    }

    public boolean a(java.lang.String str, boolean z) {
        return this.c != null ? this.c.a(str, z) : z;
    }

    public int b(java.lang.String str, int i) {
        return this.c != null ? this.c.a(str, i) : i;
    }

    public java.lang.String b(java.lang.String str, java.lang.String str2) {
        return this.c != null ? this.c.a(str, str2) : str2;
    }

    public boolean b(java.lang.String str) {
        if (this.c != null) {
            return this.c.a(str, false);
        }
        return false;
    }

    public int c(java.lang.String str) {
        if (this.c != null) {
            return this.c.a(str, 0);
        }
        return 0;
    }

    public java.lang.Object d(java.lang.String str) {
        java.io.ObjectInputStream objectInputStream;
        java.io.ByteArrayInputStream byteArrayInputStream;
        try {
            java.lang.String a2 = a(str);
            if (android.text.TextUtils.isEmpty(a2)) {
                return null;
            }
            try {
                byteArrayInputStream = new java.io.ByteArrayInputStream(android.util.Base64.decode(a2, 2));
                try {
                    objectInputStream = new java.io.ObjectInputStream(byteArrayInputStream);
                } catch (java.lang.Throwable th) {
                    th = th;
                    objectInputStream = null;
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
                objectInputStream = null;
                byteArrayInputStream = null;
            }
            try {
                java.lang.Object readObject = objectInputStream.readObject();
                objectInputStream.close();
                cn.fly.verify.dw.a(objectInputStream, byteArrayInputStream);
                return readObject;
            } catch (java.lang.Throwable th3) {
                th = th3;
                cn.fly.verify.dw.a(objectInputStream, byteArrayInputStream);
                throw th;
            }
        } catch (java.lang.Throwable th4) {
            cn.fly.verify.ed.a().b(th4);
            return null;
        }
    }

    public void e(java.lang.String str) {
        if (this.c != null) {
            this.c.a(str);
        }
    }
}
