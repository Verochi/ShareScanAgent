package com.anythink.core.common.n;

/* loaded from: classes12.dex */
public class b {
    private static volatile com.anythink.core.common.n.b b;
    private android.content.Context h;
    private java.io.File i;
    private java.util.concurrent.atomic.AtomicInteger j;
    private final java.lang.String a = "Agent";
    private int c = 5;
    private int d = 10;
    private long e = 1800000;
    private java.lang.String f = "";
    private java.lang.String g = "";
    private boolean k = false;
    private java.lang.String l = "";
    private com.anythink.core.common.h.k m = new com.anythink.core.common.n.b.AnonymousClass1();
    private com.anythink.core.common.h.a.c.a n = new com.anythink.core.common.n.b.AnonymousClass2();
    private java.lang.Object o = new java.lang.Object();

    /* renamed from: com.anythink.core.common.n.b$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.core.common.h.k {
        public AnonymousClass1() {
        }

        @Override // com.anythink.core.common.h.k
        public final void onLoadCanceled(int i) {
            com.anythink.core.common.n.b.this.k = false;
        }

        @Override // com.anythink.core.common.h.k
        public final void onLoadError(int i, java.lang.String str, com.anythink.core.api.AdError adError) {
            com.anythink.core.common.n.b.this.k = false;
        }

        @Override // com.anythink.core.common.h.k
        public final void onLoadFinish(int i, java.lang.Object obj) {
            try {
                com.anythink.core.common.n.b.this.a(((java.lang.Integer) obj).intValue());
                com.anythink.core.common.n.b.this.k = false;
                com.anythink.core.common.o.r.a(com.anythink.core.common.n.b.this.h, com.anythink.core.common.b.h.p, "LOG_SEND_TIME", java.lang.System.currentTimeMillis());
            } catch (java.lang.Throwable unused) {
                com.anythink.core.common.n.b.this.k = false;
            }
        }

        @Override // com.anythink.core.common.h.k
        public final void onLoadStart(int i) {
        }
    }

    /* renamed from: com.anythink.core.common.n.b$2, reason: invalid class name */
    public class AnonymousClass2 implements com.anythink.core.common.h.a.c.a {
        public AnonymousClass2() {
        }

        @Override // com.anythink.core.common.h.a.c.a
        public final void a(java.lang.Object obj) {
            if (obj instanceof com.anythink.core.common.h.a.a) {
                com.anythink.core.common.n.b.this.a(((com.anythink.core.common.h.a.a) obj).b());
                com.anythink.core.common.n.b.this.k = false;
                com.anythink.core.common.o.r.a(com.anythink.core.common.n.b.this.h, com.anythink.core.common.b.h.p, "LOG_SEND_TIME", java.lang.System.currentTimeMillis());
            }
        }

        @Override // com.anythink.core.common.h.a.c.a
        public final void a(java.lang.Throwable th) {
            com.anythink.core.common.n.b.this.k = false;
        }
    }

    /* renamed from: com.anythink.core.common.n.b$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        public AnonymousClass3() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:61:0x0120, code lost:
        
            if (r2 == null) goto L77;
         */
        /* JADX WARN: Code restructure failed: missing block: B:64:0x0136, code lost:
        
            if (r2 == null) goto L77;
         */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void run() {
            java.io.BufferedReader bufferedReader;
            java.io.BufferedReader bufferedReader2;
            java.util.ArrayList arrayList;
            int i;
            java.io.BufferedReader bufferedReader3;
            java.lang.String readLine;
            synchronized (this) {
                if (com.anythink.core.common.n.b.this.h == null) {
                    return;
                }
                if ((java.lang.System.currentTimeMillis() - com.anythink.core.common.o.r.a(com.anythink.core.common.n.b.this.h, com.anythink.core.common.b.h.p, "LOG_SEND_TIME", (java.lang.Long) 0L).longValue() > com.anythink.core.common.n.b.this.e || (com.anythink.core.common.n.b.this.j != null && com.anythink.core.common.n.b.this.j.get() >= com.anythink.core.common.n.b.this.c)) && !com.anythink.core.common.n.b.this.k && com.anythink.core.common.n.b.this.j != null && com.anythink.core.common.n.b.this.j.get() > 0) {
                    com.anythink.core.common.n.b.this.k = true;
                    java.io.BufferedReader bufferedReader4 = null;
                    java.io.BufferedReader bufferedReader5 = null;
                    java.io.BufferedReader bufferedReader6 = null;
                    java.io.BufferedReader bufferedReader7 = null;
                    try {
                        try {
                            bufferedReader2 = new java.io.BufferedReader(new java.io.FileReader(com.anythink.core.common.n.b.this.i));
                        } catch (java.lang.Throwable th) {
                            th = th;
                        }
                        try {
                            try {
                                arrayList = new java.util.ArrayList();
                                i = 0;
                                while (i < com.anythink.core.common.n.b.this.d && (readLine = bufferedReader2.readLine()) != null) {
                                    arrayList.add(readLine);
                                    i++;
                                }
                                bufferedReader2.close();
                            } catch (java.lang.OutOfMemoryError | java.lang.StackOverflowError unused) {
                                bufferedReader5 = bufferedReader2;
                                com.anythink.core.common.n.b.this.k = false;
                                java.lang.System.gc();
                                bufferedReader4 = bufferedReader5;
                                if (bufferedReader5 != null) {
                                    bufferedReader = bufferedReader5;
                                    bufferedReader.close();
                                    bufferedReader4 = bufferedReader;
                                }
                            }
                        } catch (java.lang.Error unused2) {
                            bufferedReader6 = bufferedReader2;
                            com.anythink.core.common.n.b.this.k = false;
                            bufferedReader4 = bufferedReader6;
                            bufferedReader = bufferedReader6;
                        } catch (java.lang.Exception unused3) {
                            bufferedReader7 = bufferedReader2;
                            com.anythink.core.common.n.b.this.k = false;
                            bufferedReader4 = bufferedReader7;
                            bufferedReader = bufferedReader7;
                        } catch (java.lang.Throwable th2) {
                            th = th2;
                            bufferedReader4 = bufferedReader2;
                            if (bufferedReader4 != null) {
                                try {
                                    bufferedReader4.close();
                                } catch (java.lang.Exception unused4) {
                                }
                            }
                            throw th;
                        }
                    } catch (java.lang.OutOfMemoryError | java.lang.StackOverflowError unused5) {
                    } catch (java.lang.Error unused6) {
                    } catch (java.lang.Exception unused7) {
                    }
                    if (i == 0) {
                        com.anythink.core.common.n.b.this.k = false;
                        try {
                            bufferedReader2.close();
                        } catch (java.lang.Exception unused8) {
                        }
                        return;
                    }
                    com.anythink.core.d.a b = com.anythink.core.d.b.a(com.anythink.core.common.b.o.a().f()).b(com.anythink.core.common.b.o.a().o());
                    if (b == null) {
                        com.anythink.core.common.h.b bVar = new com.anythink.core.common.h.b(com.anythink.core.common.n.b.this.h, 0, arrayList);
                        com.anythink.core.common.h.k kVar = com.anythink.core.common.n.b.this.m;
                        bVar.a(0, kVar);
                        bufferedReader3 = kVar;
                    } else if (b.C() != 1) {
                        com.anythink.core.common.h.b bVar2 = new com.anythink.core.common.h.b(com.anythink.core.common.n.b.this.h, b.C(), arrayList);
                        com.anythink.core.common.h.k kVar2 = com.anythink.core.common.n.b.this.m;
                        bVar2.a(0, kVar2);
                        bufferedReader3 = kVar2;
                    } else {
                        com.anythink.core.common.h.a.a aVar = new com.anythink.core.common.h.a.a(arrayList);
                        java.lang.String B = b.B();
                        aVar.a(1, B);
                        aVar.a(com.anythink.core.common.n.b.this.n);
                        bufferedReader3 = B;
                    }
                    bufferedReader2.close();
                    bufferedReader4 = bufferedReader3;
                }
            }
        }
    }

    private b() {
    }

    public static com.anythink.core.common.n.b a() {
        if (b == null) {
            synchronized (com.anythink.core.common.n.b.class) {
                if (b == null) {
                    b = new com.anythink.core.common.n.b();
                }
            }
        }
        return b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(int i) {
        java.io.File file;
        java.io.BufferedReader bufferedReader;
        java.io.BufferedReader bufferedReader2 = null;
        try {
            file = new java.io.File(this.g);
            if (!file.exists()) {
                file.createNewFile();
            }
            bufferedReader = new java.io.BufferedReader(new java.io.FileReader(this.i));
        } catch (java.lang.Exception unused) {
        } catch (java.lang.OutOfMemoryError | java.lang.StackOverflowError unused2) {
        } catch (java.lang.Error unused3) {
        } catch (java.lang.Throwable unused4) {
        }
        try {
            java.io.FileWriter fileWriter = new java.io.FileWriter(file);
            int i2 = 0;
            int i3 = 0;
            while (true) {
                java.lang.String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                i3++;
                if (i3 > i) {
                    fileWriter.append((java.lang.CharSequence) readLine);
                    fileWriter.append((java.lang.CharSequence) "\n");
                }
            }
            fileWriter.flush();
            fileWriter.close();
            bufferedReader.close();
            java.util.concurrent.atomic.AtomicInteger atomicInteger = this.j;
            if (atomicInteger.get() - i >= 0) {
                i2 = this.j.get() - i;
            }
            atomicInteger.set(i2);
            this.i.delete();
            file.renameTo(this.i);
            try {
                bufferedReader.close();
            } catch (java.io.IOException unused5) {
            }
        } catch (java.lang.Error unused6) {
            bufferedReader2 = bufferedReader;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (java.io.IOException unused7) {
                }
            }
        } catch (java.lang.Exception unused8) {
            bufferedReader2 = bufferedReader;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (java.io.IOException unused9) {
                }
            }
        } catch (java.lang.OutOfMemoryError | java.lang.StackOverflowError unused10) {
            bufferedReader2 = bufferedReader;
            try {
                java.lang.System.gc();
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (java.io.IOException unused11) {
                    }
                }
            } catch (java.lang.Throwable th) {
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (java.io.IOException unused12) {
                    }
                }
                throw th;
            }
        } catch (java.lang.Throwable unused13) {
            bufferedReader2 = bufferedReader;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (java.io.IOException unused14) {
                }
            }
        }
    }

    private synchronized void a(boolean z) {
        java.lang.String readLine;
        java.util.concurrent.atomic.AtomicInteger atomicInteger;
        if (this.h == null) {
            return;
        }
        if (this.k || (!z && ((atomicInteger = this.j) == null || atomicInteger.get() < this.c))) {
            return;
        }
        this.k = true;
        java.io.BufferedReader bufferedReader = null;
        try {
            try {
                java.io.BufferedReader bufferedReader2 = new java.io.BufferedReader(new java.io.FileReader(this.i));
                try {
                    java.util.ArrayList arrayList = new java.util.ArrayList();
                    for (int i = 0; i < this.d && (readLine = bufferedReader2.readLine()) != null; i++) {
                        arrayList.add(readLine);
                    }
                    com.anythink.core.d.a b2 = com.anythink.core.d.b.a(com.anythink.core.common.b.o.a().f()).b(com.anythink.core.common.b.o.a().o());
                    if (b2 == null) {
                        new com.anythink.core.common.h.b(this.h, 0, arrayList).a(0, this.m);
                    } else if (b2.C() != 1) {
                        new com.anythink.core.common.h.b(this.h, b2.C(), arrayList).a(0, this.m);
                    } else {
                        com.anythink.core.common.h.a.a aVar = new com.anythink.core.common.h.a.a(arrayList);
                        aVar.a(1, b2.B());
                        aVar.a(this.n);
                    }
                    try {
                        bufferedReader2.close();
                    } catch (java.lang.Exception unused) {
                    }
                } catch (java.lang.Exception unused2) {
                    bufferedReader = bufferedReader2;
                    this.k = false;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (java.lang.Exception unused3) {
                        }
                    }
                } catch (java.lang.OutOfMemoryError | java.lang.StackOverflowError unused4) {
                    bufferedReader = bufferedReader2;
                    this.k = false;
                    java.lang.System.gc();
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (java.lang.Exception unused5) {
                        }
                    }
                } catch (java.lang.Throwable unused6) {
                    bufferedReader = bufferedReader2;
                    this.k = false;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (java.lang.Exception unused7) {
                        }
                    }
                }
            } catch (java.lang.Throwable th) {
                if (0 != 0) {
                    try {
                        bufferedReader.close();
                    } catch (java.lang.Exception unused8) {
                    }
                }
                throw th;
            }
        } catch (java.lang.Exception unused9) {
        } catch (java.lang.OutOfMemoryError | java.lang.StackOverflowError unused10) {
        } catch (java.lang.Throwable unused11) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00ea A[Catch: all -> 0x0132, Error -> 0x0134, OutOfMemoryError | StackOverflowError -> 0x013e, OutOfMemoryError | StackOverflowError -> 0x013e, Exception -> 0x0157, TryCatch #3 {OutOfMemoryError | StackOverflowError -> 0x013e, blocks: (B:11:0x001c, B:13:0x007a, B:15:0x008d, B:16:0x0096, B:18:0x009e, B:28:0x00cf, B:28:0x00cf, B:30:0x00e6, B:30:0x00e6, B:32:0x00ea, B:32:0x00ea, B:33:0x00f1, B:33:0x00f1, B:35:0x0103, B:35:0x0103, B:36:0x010a, B:36:0x010a, B:38:0x011a, B:38:0x011a, B:39:0x0121, B:39:0x0121, B:47:0x011f, B:47:0x011f, B:48:0x0108, B:48:0x0108, B:58:0x00dd, B:58:0x00dd, B:56:0x00e0, B:56:0x00e0, B:53:0x00e3, B:53:0x00e3), top: B:10:0x001c, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0103 A[Catch: all -> 0x0132, Error -> 0x0134, OutOfMemoryError | StackOverflowError -> 0x013e, OutOfMemoryError | StackOverflowError -> 0x013e, Exception -> 0x0157, TryCatch #3 {OutOfMemoryError | StackOverflowError -> 0x013e, blocks: (B:11:0x001c, B:13:0x007a, B:15:0x008d, B:16:0x0096, B:18:0x009e, B:28:0x00cf, B:28:0x00cf, B:30:0x00e6, B:30:0x00e6, B:32:0x00ea, B:32:0x00ea, B:33:0x00f1, B:33:0x00f1, B:35:0x0103, B:35:0x0103, B:36:0x010a, B:36:0x010a, B:38:0x011a, B:38:0x011a, B:39:0x0121, B:39:0x0121, B:47:0x011f, B:47:0x011f, B:48:0x0108, B:48:0x0108, B:58:0x00dd, B:58:0x00dd, B:56:0x00e0, B:56:0x00e0, B:53:0x00e3, B:53:0x00e3), top: B:10:0x001c, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x011a A[Catch: all -> 0x0132, Error -> 0x0134, OutOfMemoryError | StackOverflowError -> 0x013e, OutOfMemoryError | StackOverflowError -> 0x013e, Exception -> 0x0157, TryCatch #3 {OutOfMemoryError | StackOverflowError -> 0x013e, blocks: (B:11:0x001c, B:13:0x007a, B:15:0x008d, B:16:0x0096, B:18:0x009e, B:28:0x00cf, B:28:0x00cf, B:30:0x00e6, B:30:0x00e6, B:32:0x00ea, B:32:0x00ea, B:33:0x00f1, B:33:0x00f1, B:35:0x0103, B:35:0x0103, B:36:0x010a, B:36:0x010a, B:38:0x011a, B:38:0x011a, B:39:0x0121, B:39:0x0121, B:47:0x011f, B:47:0x011f, B:48:0x0108, B:48:0x0108, B:58:0x00dd, B:58:0x00dd, B:56:0x00e0, B:56:0x00e0, B:53:0x00e3, B:53:0x00e3), top: B:10:0x001c, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x012a A[Catch: all -> 0x0165, TryCatch #4 {, blocks: (B:4:0x0003, B:8:0x000b, B:40:0x0126, B:42:0x012a, B:43:0x012f, B:44:0x0161, B:68:0x014b, B:70:0x014f, B:71:0x0156, B:79:0x0134, B:81:0x0138, B:73:0x0141, B:75:0x0145, B:76:0x0157, B:78:0x015b, B:82:0x0163, B:11:0x001c, B:13:0x007a, B:15:0x008d, B:16:0x0096, B:18:0x009e, B:28:0x00cf, B:30:0x00e6, B:32:0x00ea, B:33:0x00f1, B:35:0x0103, B:36:0x010a, B:38:0x011a, B:39:0x0121, B:47:0x011f, B:48:0x0108, B:58:0x00dd, B:56:0x00e0, B:53:0x00e3, B:72:0x013e), top: B:3:0x0003, inners: #0, #6, #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x011f A[Catch: all -> 0x0132, Error -> 0x0134, OutOfMemoryError | StackOverflowError -> 0x013e, OutOfMemoryError | StackOverflowError -> 0x013e, Exception -> 0x0157, TryCatch #3 {OutOfMemoryError | StackOverflowError -> 0x013e, blocks: (B:11:0x001c, B:13:0x007a, B:15:0x008d, B:16:0x0096, B:18:0x009e, B:28:0x00cf, B:28:0x00cf, B:30:0x00e6, B:30:0x00e6, B:32:0x00ea, B:32:0x00ea, B:33:0x00f1, B:33:0x00f1, B:35:0x0103, B:35:0x0103, B:36:0x010a, B:36:0x010a, B:38:0x011a, B:38:0x011a, B:39:0x0121, B:39:0x0121, B:47:0x011f, B:47:0x011f, B:48:0x0108, B:48:0x0108, B:58:0x00dd, B:58:0x00dd, B:56:0x00e0, B:56:0x00e0, B:53:0x00e3, B:53:0x00e3), top: B:10:0x001c, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0108 A[Catch: all -> 0x0132, Error -> 0x0134, OutOfMemoryError | StackOverflowError -> 0x013e, OutOfMemoryError | StackOverflowError -> 0x013e, Exception -> 0x0157, TryCatch #3 {OutOfMemoryError | StackOverflowError -> 0x013e, blocks: (B:11:0x001c, B:13:0x007a, B:15:0x008d, B:16:0x0096, B:18:0x009e, B:28:0x00cf, B:28:0x00cf, B:30:0x00e6, B:30:0x00e6, B:32:0x00ea, B:32:0x00ea, B:33:0x00f1, B:33:0x00f1, B:35:0x0103, B:35:0x0103, B:36:0x010a, B:36:0x010a, B:38:0x011a, B:38:0x011a, B:39:0x0121, B:39:0x0121, B:47:0x011f, B:47:0x011f, B:48:0x0108, B:48:0x0108, B:58:0x00dd, B:58:0x00dd, B:56:0x00e0, B:56:0x00e0, B:53:0x00e3, B:53:0x00e3), top: B:10:0x001c, outer: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(android.content.Context context) {
        java.util.concurrent.atomic.AtomicInteger atomicInteger;
        java.io.LineNumberReader lineNumberReader;
        java.lang.Throwable th;
        synchronized (this.o) {
            if (this.h == null && context != null) {
                this.l = com.anythink.core.common.b.o.a().o();
                this.h = context.getApplicationContext();
                try {
                    try {
                        try {
                            try {
                                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                                sb.append(this.h.getApplicationContext().getFilesDir().getAbsolutePath());
                                java.lang.String str = java.io.File.separator;
                                sb.append(str);
                                sb.append("log");
                                sb.append(str);
                                sb.append("anythink_agent_log");
                                this.f = sb.toString();
                                this.g = this.h.getApplicationContext().getFilesDir().getAbsolutePath() + str + "log" + str + "anythink_temp_log";
                                if (this.i == null) {
                                    java.io.File file = new java.io.File(this.f);
                                    this.i = file;
                                    if (!file.getParentFile().exists()) {
                                        this.i.getParentFile().mkdirs();
                                    }
                                    if (!this.i.exists()) {
                                        this.i.createNewFile();
                                    }
                                }
                                java.io.LineNumberReader lineNumberReader2 = null;
                                try {
                                    try {
                                        lineNumberReader = new java.io.LineNumberReader(new java.io.FileReader(this.i));
                                    } catch (java.io.IOException unused) {
                                    }
                                    try {
                                        lineNumberReader.skip(Long.MAX_VALUE);
                                        int lineNumber = lineNumberReader.getLineNumber();
                                        if (this.j == null) {
                                            this.j = new java.util.concurrent.atomic.AtomicInteger(lineNumber);
                                        }
                                        lineNumberReader.close();
                                        this.j.get();
                                        lineNumberReader.close();
                                    } catch (java.lang.Exception unused2) {
                                        lineNumberReader2 = lineNumberReader;
                                        if (lineNumberReader2 != null) {
                                            lineNumberReader2.close();
                                        }
                                        if (this.j == null) {
                                        }
                                        com.anythink.core.d.a b2 = com.anythink.core.d.b.a(this.h).b(this.l);
                                        if (b2.an() == 0) {
                                        }
                                        this.c = r2;
                                        this.d = r2 * 2;
                                        this.e = b2.ap() == 0 ? b2.ap() : this.e;
                                        b();
                                        if (this.j == null) {
                                        }
                                    } catch (java.lang.Throwable th2) {
                                        th = th2;
                                        if (lineNumberReader != null) {
                                            try {
                                                lineNumberReader.close();
                                            } catch (java.io.IOException unused3) {
                                            }
                                        }
                                        throw th;
                                    }
                                } catch (java.lang.Exception unused4) {
                                } catch (java.lang.Throwable th3) {
                                    lineNumberReader = null;
                                    th = th3;
                                }
                                if (this.j == null) {
                                    this.j = new java.util.concurrent.atomic.AtomicInteger(0);
                                }
                                com.anythink.core.d.a b22 = com.anythink.core.d.b.a(this.h).b(this.l);
                                int an = b22.an() == 0 ? b22.an() : this.c;
                                this.c = an;
                                this.d = an * 2;
                                this.e = b22.ap() == 0 ? b22.ap() : this.e;
                                b();
                            } catch (java.lang.Throwable th4) {
                                if (this.j == null) {
                                    this.j = new java.util.concurrent.atomic.AtomicInteger(0);
                                }
                                throw th4;
                            }
                        } catch (java.lang.OutOfMemoryError | java.lang.StackOverflowError unused5) {
                            java.lang.System.gc();
                            if (this.j == null) {
                                atomicInteger = new java.util.concurrent.atomic.AtomicInteger(0);
                            }
                        }
                    } catch (java.lang.Exception unused6) {
                        if (this.j == null) {
                            atomicInteger = new java.util.concurrent.atomic.AtomicInteger(0);
                        }
                    }
                } catch (java.lang.Error unused7) {
                    if (this.j == null) {
                        atomicInteger = new java.util.concurrent.atomic.AtomicInteger(0);
                    }
                }
                if (this.j == null) {
                    atomicInteger = new java.util.concurrent.atomic.AtomicInteger(0);
                    this.j = atomicInteger;
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x0081, code lost:
    
        if (r0 == null) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0078, code lost:
    
        if (r0 == null) goto L42;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized void a(com.anythink.core.common.f.k kVar, boolean z) {
        java.lang.String jSONObject;
        java.io.FileWriter fileWriter;
        if (this.i == null || this.j == null) {
            a(com.anythink.core.common.b.o.a().f());
        }
        if (this.i != null && this.j != null) {
            com.anythink.core.d.a b2 = com.anythink.core.d.b.a(this.h).b(this.l);
            if (b2 != null) {
                int an = b2.an() != 0 ? b2.an() : this.c;
                this.c = an;
                this.d = an * 2;
                this.e = b2.ap();
            }
            java.io.FileWriter fileWriter2 = null;
            try {
                try {
                    try {
                        jSONObject = kVar.a().toString();
                        fileWriter = new java.io.FileWriter(this.i, true);
                    } catch (java.lang.Throwable th) {
                        th = th;
                    }
                } catch (java.lang.Exception unused) {
                } catch (java.lang.OutOfMemoryError | java.lang.StackOverflowError unused2) {
                } catch (java.lang.Error unused3) {
                }
            } catch (java.io.IOException unused4) {
            }
            try {
                fileWriter.append((java.lang.CharSequence) jSONObject);
                fileWriter.append((java.lang.CharSequence) "\n");
                fileWriter.flush();
                fileWriter.close();
                this.j.incrementAndGet();
                fileWriter.close();
            } catch (java.lang.Exception unused5) {
                fileWriter2 = fileWriter;
                if (fileWriter2 != null) {
                    fileWriter2.close();
                }
                a(z);
            } catch (java.lang.OutOfMemoryError | java.lang.StackOverflowError unused6) {
                fileWriter2 = fileWriter;
                java.lang.System.gc();
            } catch (java.lang.Error unused7) {
                fileWriter2 = fileWriter;
            } catch (java.lang.Throwable th2) {
                th = th2;
                fileWriter2 = fileWriter;
                if (fileWriter2 != null) {
                    try {
                        fileWriter2.close();
                    } catch (java.io.IOException unused8) {
                    }
                }
                throw th;
            }
            a(z);
        }
    }

    public final void b() {
        com.anythink.core.common.o.b.b.a().a((java.lang.Runnable) new com.anythink.core.common.n.b.AnonymousClass3(), 13, true);
    }
}
