package cn.fly.verify;

/* loaded from: classes.dex */
public class ee {
    private static final java.lang.Object a = new java.lang.Object();
    private static final java.lang.Object b = new java.lang.Object();
    private volatile java.util.HashSet<java.lang.String> c = new java.util.HashSet<>();
    private java.io.File d;
    private int e;
    private java.lang.String f;

    /* renamed from: cn.fly.verify.ee$1, reason: invalid class name */
    public class AnonymousClass1 implements java.io.FilenameFilter {
        public AnonymousClass1() {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(java.io.File file, java.lang.String str) {
            return !android.text.TextUtils.isEmpty(str) && str.startsWith(cn.fly.verify.ee.this.f);
        }
    }

    /* renamed from: cn.fly.verify.ee$2, reason: invalid class name */
    public class AnonymousClass2 implements cn.fly.verify.fh.a {
        final /* synthetic */ java.io.File[] a;
        final /* synthetic */ cn.fly.verify.ee.a b;

        public AnonymousClass2(java.io.File[] fileArr, cn.fly.verify.ee.a aVar) {
            this.a = fileArr;
            this.b = aVar;
        }

        @Override // cn.fly.verify.fh.a
        public void a(cn.fly.verify.fh.b bVar) {
            java.io.BufferedReader bufferedReader;
            for (java.io.File file : this.a) {
                java.lang.String name = file.getName();
                if (!cn.fly.verify.ee.this.b(name)) {
                    java.io.FileReader fileReader = null;
                    try {
                        java.io.FileReader fileReader2 = new java.io.FileReader(file);
                        try {
                            bufferedReader = new java.io.BufferedReader(fileReader2);
                            while (true) {
                                try {
                                    java.lang.String readLine = bufferedReader.readLine();
                                    if (readLine == null) {
                                        break;
                                    } else {
                                        this.b.a(new java.lang.String(android.util.Base64.decode(readLine, 2), "utf-8"));
                                    }
                                } catch (java.lang.Throwable th) {
                                    th = th;
                                    fileReader = fileReader2;
                                    try {
                                        cn.fly.verify.ed.a().a(th);
                                        cn.fly.verify.dw.a(bufferedReader, fileReader);
                                        cn.fly.verify.ee.this.c(name);
                                    } catch (java.lang.Throwable th2) {
                                        cn.fly.verify.dw.a(bufferedReader, fileReader);
                                        cn.fly.verify.ee.this.c(name);
                                        throw th2;
                                    }
                                }
                            }
                            if (this.b.a(bVar)) {
                                cn.fly.verify.ed.a().a("[LGSM] D l", new java.lang.Object[0]);
                                file.delete();
                            }
                            cn.fly.verify.dw.a(bufferedReader, fileReader2);
                        } catch (java.lang.Throwable th3) {
                            th = th3;
                            bufferedReader = null;
                        }
                    } catch (java.lang.Throwable th4) {
                        th = th4;
                        bufferedReader = null;
                    }
                    cn.fly.verify.ee.this.c(name);
                }
            }
        }
    }

    /* renamed from: cn.fly.verify.ee$3, reason: invalid class name */
    public class AnonymousClass3 implements java.io.FilenameFilter {
        public AnonymousClass3() {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(java.io.File file, java.lang.String str) {
            return !android.text.TextUtils.isEmpty(str) && str.startsWith(cn.fly.verify.ee.this.f);
        }
    }

    public interface a {
        void a(java.lang.String str);

        boolean a(cn.fly.verify.fh.b bVar);
    }

    public ee(java.lang.String str, java.lang.String str2, int i) {
        this.e = i;
        if (str2 == null) {
            str2 = com.igexin.push.core.b.m;
        } else if (android.text.TextUtils.isDigitsOnly(str2)) {
            str2 = str + str2;
        }
        this.f = str2;
        java.io.File b2 = cn.fly.verify.fq.b(cn.fly.verify.ax.f(), str);
        this.d = b2;
        if (b2.isDirectory()) {
            return;
        }
        this.d.mkdirs();
    }

    private java.io.File a(boolean z) {
        java.io.File file;
        java.io.File[] listFiles = this.d.listFiles();
        int i = 5;
        int i2 = 3;
        char c = 2;
        if (listFiles == null || listFiles.length <= 0) {
            file = new java.io.File(this.d, a(this.f, "_", 1, "_", 0));
        } else {
            int length = listFiles.length;
            int i3 = 0;
            int i4 = 1;
            while (i3 < length) {
                java.io.File file2 = listFiles[i3];
                java.lang.String name = file2.getName();
                if (name.startsWith(this.f)) {
                    java.lang.String[] split = name.split("_");
                    if (!z && split.length == i2) {
                        try {
                            int parseInt = java.lang.Integer.parseInt(split[c]);
                            if (parseInt < this.e && !b(name)) {
                                java.io.File file3 = this.d;
                                java.lang.Object[] objArr = new java.lang.Object[i];
                                objArr[0] = this.f;
                                objArr[1] = "_";
                                objArr[2] = java.lang.Integer.valueOf(i4);
                                objArr[3] = "_";
                                objArr[4] = java.lang.Integer.valueOf(parseInt + 1);
                                java.io.File file4 = new java.io.File(file3, a(objArr));
                                return file2.renameTo(file4) ? file4 : file2;
                            }
                        } catch (java.lang.Throwable th) {
                            cn.fly.verify.ed.a().a(th);
                        }
                    }
                    if (split.length > 1) {
                        try {
                            if (java.lang.Integer.parseInt(split[1]) == i4) {
                                i4++;
                            }
                        } catch (java.lang.Throwable th2) {
                            cn.fly.verify.ed.a().a(th2);
                        }
                    }
                }
                i3++;
                i = 5;
                i2 = 3;
                c = 2;
            }
            file = new java.io.File(this.d, a(this.f, "_", java.lang.Integer.valueOf(i4), "_", 0));
        }
        try {
            file.createNewFile();
        } catch (java.lang.Throwable unused) {
        }
        return file;
    }

    private static java.lang.String a(java.lang.Object... objArr) {
        if (objArr == null || objArr.length == 0) {
            return null;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (java.lang.Object obj : objArr) {
            sb.append(obj);
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(java.lang.String str) {
        synchronized (this.c) {
            if (this.c.contains(str)) {
                return true;
            }
            this.c.add(str);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(java.lang.String str) {
        synchronized (this.c) {
            this.c.remove(str);
        }
    }

    public void a(long j) {
        synchronized (b) {
            java.io.File[] listFiles = this.d.listFiles(new cn.fly.verify.ee.AnonymousClass3());
            if (listFiles != null && listFiles.length > 0) {
                long j2 = 0;
                for (java.io.File file : listFiles) {
                    j2 += file.length();
                }
                if (j2 >= j) {
                    for (java.io.File file2 : listFiles) {
                        file2.delete();
                    }
                }
            }
        }
    }

    public void a(cn.fly.verify.ee.a aVar) {
        if (aVar == null) {
            return;
        }
        synchronized (b) {
            java.io.File[] listFiles = this.d.listFiles(new cn.fly.verify.ee.AnonymousClass1());
            if (listFiles != null && listFiles.length > 0) {
                cn.fly.verify.fh.a(cn.fly.verify.ax.g()).g().i().h().B().a(new cn.fly.verify.ee.AnonymousClass2(listFiles, aVar));
            }
        }
    }

    public void a(java.lang.String str) throws java.lang.Throwable {
        a(str, false);
    }

    public void a(java.lang.String str, boolean z) throws java.lang.Throwable {
        java.io.FileWriter fileWriter;
        java.lang.String name;
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        java.lang.String encodeToString = android.util.Base64.encodeToString(str.getBytes("utf-8"), 2);
        if (android.text.TextUtils.isEmpty(encodeToString)) {
            return;
        }
        synchronized (a) {
            java.io.File a2 = a(z);
            java.io.BufferedWriter bufferedWriter = null;
            try {
                fileWriter = new java.io.FileWriter(a2, true);
                try {
                    java.io.BufferedWriter bufferedWriter2 = new java.io.BufferedWriter(fileWriter);
                    try {
                        bufferedWriter2.newLine();
                        bufferedWriter2.write(encodeToString);
                        cn.fly.verify.dw.a(bufferedWriter2, fileWriter);
                        name = a2.getName();
                    } catch (java.lang.Throwable th) {
                        th = th;
                        bufferedWriter = bufferedWriter2;
                        try {
                            cn.fly.verify.ed.a().a(th);
                            cn.fly.verify.dw.a(bufferedWriter, fileWriter);
                            name = a2.getName();
                            c(name);
                        } catch (java.lang.Throwable th2) {
                            cn.fly.verify.dw.a(bufferedWriter, fileWriter);
                            c(a2.getName());
                            throw th2;
                        }
                    }
                } catch (java.lang.Throwable th3) {
                    th = th3;
                }
            } catch (java.lang.Throwable th4) {
                th = th4;
                fileWriter = null;
            }
            c(name);
        }
    }
}
