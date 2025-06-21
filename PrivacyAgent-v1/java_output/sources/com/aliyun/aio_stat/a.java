package com.aliyun.aio_stat;

/* loaded from: classes.dex */
public class a {
    private float a;
    private int b;

    /* renamed from: com.aliyun.aio_stat.a$a, reason: collision with other inner class name */
    public class RunnableC0051a implements java.lang.Runnable {
        public RunnableC0051a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.aliyun.aio_stat.a.this.f();
        }
    }

    public class b implements java.io.FileFilter {
        @Override // java.io.FileFilter
        public boolean accept(java.io.File file) {
            return java.util.regex.Pattern.matches("cpu[0-9]", file.getName());
        }
    }

    public class c implements com.aliyun.aio_stat.a.f {
        int a = -1;

        public c() {
        }

        @Override // com.aliyun.aio_stat.a.f
        public void a(java.lang.String str) {
            java.util.LinkedList b;
            if (!str.contains(android.os.Process.myPid() + "") || (b = com.aliyun.aio_stat.a.b(str.split(" "))) == null) {
                return;
            }
            if (this.a < 0) {
                int i = 0;
                while (true) {
                    if (i >= b.size()) {
                        break;
                    }
                    if (((java.lang.String) b.get(i)).contains("%")) {
                        this.a = i;
                        break;
                    }
                    i++;
                }
            }
            int i2 = this.a;
            if (i2 >= 0) {
                java.lang.String str2 = (java.lang.String) b.get(i2);
                if (str2.contains("%")) {
                    str2 = str2.substring(0, str2.indexOf("%"));
                }
                try {
                    com.aliyun.aio_stat.a.this.a = java.lang.Float.parseFloat(str2);
                } catch (java.lang.Exception unused) {
                }
            }
        }
    }

    public class d implements com.aliyun.aio_stat.a.f {
        public d() {
        }

        @Override // com.aliyun.aio_stat.a.f
        public void a(java.lang.String str) {
            try {
                float parseFloat = java.lang.Float.parseFloat(str);
                if (com.aliyun.aio_stat.a.this.b <= 0) {
                    com.aliyun.aio_stat.a.this.b = com.aliyun.aio_stat.a.a();
                }
                com.aliyun.aio_stat.a.this.a = (parseFloat * 1.0f) / r0.b;
            } catch (java.lang.Exception unused) {
            }
        }
    }

    public static class e {
        private static com.aliyun.aio_stat.a a = new com.aliyun.aio_stat.a(null);
    }

    public interface f {
        void a(java.lang.String str);
    }

    private a() {
        this.b = 0;
        new java.lang.Thread(new com.aliyun.aio_stat.a.RunnableC0051a()).start();
    }

    public /* synthetic */ a(com.aliyun.aio_stat.a.RunnableC0051a runnableC0051a) {
        this();
    }

    public static int a() {
        try {
            return new java.io.File("/sys/devices/system/cpu/").listFiles(new com.aliyun.aio_stat.a.b()).length;
        } catch (java.lang.Exception unused) {
            return 1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0056 A[Catch: all -> 0x0061, TRY_ENTER, TryCatch #1 {all -> 0x0061, blocks: (B:18:0x0023, B:19:0x0029, B:27:0x0056, B:29:0x005b), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x005b A[Catch: all -> 0x0061, TRY_LEAVE, TryCatch #1 {all -> 0x0061, blocks: (B:18:0x0023, B:19:0x0029, B:27:0x0056, B:29:0x005b), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0061 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0048 A[Catch: all -> 0x0050, TryCatch #0 {all -> 0x0050, blocks: (B:43:0x0043, B:36:0x0048, B:38:0x004d), top: B:42:0x0043 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x004d A[Catch: all -> 0x0050, TRY_LEAVE, TryCatch #0 {all -> 0x0050, blocks: (B:43:0x0043, B:36:0x0048, B:38:0x004d), top: B:42:0x0043 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0043 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(java.lang.String str, com.aliyun.aio_stat.a.f fVar) {
        java.lang.Throwable th;
        java.lang.Process process;
        java.io.BufferedReader bufferedReader;
        java.io.InputStreamReader inputStreamReader = null;
        try {
            try {
                process = java.lang.Runtime.getRuntime().exec(str);
                try {
                    java.io.InputStreamReader inputStreamReader2 = new java.io.InputStreamReader(process.getInputStream());
                    try {
                        bufferedReader = new java.io.BufferedReader(inputStreamReader2);
                        while (true) {
                            try {
                                java.lang.String readLine = bufferedReader.readLine();
                                if (readLine == null) {
                                    break;
                                } else if (fVar != null) {
                                    fVar.a(readLine);
                                }
                            } catch (java.lang.Exception unused) {
                                inputStreamReader = inputStreamReader2;
                                if (inputStreamReader != null) {
                                    inputStreamReader.close();
                                }
                                if (bufferedReader != null) {
                                    bufferedReader.close();
                                }
                                if (process == null) {
                                    return;
                                }
                                process.destroy();
                            } catch (java.lang.Throwable th2) {
                                th = th2;
                                inputStreamReader = inputStreamReader2;
                                if (inputStreamReader != null) {
                                    try {
                                        inputStreamReader.close();
                                    } catch (java.lang.Throwable unused2) {
                                        throw th;
                                    }
                                }
                                if (bufferedReader != null) {
                                    bufferedReader.close();
                                }
                                if (process != null) {
                                    process.destroy();
                                }
                                throw th;
                            }
                        }
                        inputStreamReader2.close();
                        bufferedReader.close();
                    } catch (java.lang.Exception unused3) {
                        bufferedReader = null;
                    } catch (java.lang.Throwable th3) {
                        th = th3;
                        bufferedReader = null;
                    }
                } catch (java.lang.Exception unused4) {
                    bufferedReader = null;
                    if (inputStreamReader != null) {
                    }
                    if (bufferedReader != null) {
                    }
                    if (process == null) {
                    }
                    process.destroy();
                } catch (java.lang.Throwable th4) {
                    th = th4;
                    bufferedReader = null;
                    if (inputStreamReader != null) {
                    }
                    if (bufferedReader != null) {
                    }
                    if (process != null) {
                    }
                    throw th;
                }
            } catch (java.lang.Throwable unused5) {
                return;
            }
        } catch (java.lang.Exception unused6) {
            process = null;
        } catch (java.lang.Throwable th5) {
            th = th5;
            process = null;
        }
        process.destroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static java.util.LinkedList<java.lang.String> b(java.lang.String[] strArr) {
        if (strArr == null) {
            return null;
        }
        java.util.LinkedList<java.lang.String> linkedList = new java.util.LinkedList<>();
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            if (!strArr[i].trim().equals("")) {
                linkedList.add(strArr[i]);
            }
        }
        return linkedList;
    }

    private void b() {
        a("top -p " + android.os.Process.myPid() + " -o %CPU", new com.aliyun.aio_stat.a.d());
    }

    private void c() {
        a(com.sensorsdata.sf.ui.view.UIProperty.top, new com.aliyun.aio_stat.a.c());
    }

    public static com.aliyun.aio_stat.a d() {
        return com.aliyun.aio_stat.a.e.a;
    }

    public float e() {
        return this.a;
    }

    public void f() {
        if (android.os.Build.VERSION.SDK_INT > 25) {
            b();
        } else {
            c();
        }
    }
}
