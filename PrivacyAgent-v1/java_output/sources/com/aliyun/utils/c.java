package com.aliyun.utils;

/* loaded from: classes12.dex */
public class c {
    private static java.lang.String a = "c";
    private int b;

    public class a implements java.lang.Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.aliyun.utils.c.this.f();
        }
    }

    public class b implements java.io.FileFilter {
        @Override // java.io.FileFilter
        public boolean accept(java.io.File file) {
            return java.util.regex.Pattern.matches("cpu[0-9]", file.getName());
        }
    }

    /* renamed from: com.aliyun.utils.c$c, reason: collision with other inner class name */
    public class C0113c implements com.aliyun.utils.c.e {
        int a = -1;

        public C0113c() {
        }

        @Override // com.aliyun.utils.c.e
        public void a(java.lang.String str) {
            java.util.LinkedList b;
            if (!str.contains(android.os.Process.myPid() + "") || (b = com.aliyun.utils.c.b(str.split(" "))) == null) {
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
            if (i2 < 0) {
                com.cicada.player.utils.Logger.v(com.aliyun.utils.c.a, "getCpuUsageBefore26 unknow ");
                return;
            }
            java.lang.String str2 = (java.lang.String) b.get(i2);
            if (str2.contains("%")) {
                str2 = str2.substring(0, str2.indexOf("%"));
            }
            try {
                com.aliyun.utils.c.this.b = (int) java.lang.Float.parseFloat(str2);
                com.cicada.player.utils.Logger.v(com.aliyun.utils.c.a, "getCpuUsageBefore26 mMyPidPercent update " + com.aliyun.utils.c.this.b);
            } catch (java.lang.Exception unused) {
            }
        }
    }

    public class d implements com.aliyun.utils.c.e {
        public d() {
        }

        @Override // com.aliyun.utils.c.e
        public void a(java.lang.String str) {
            try {
                com.aliyun.utils.c.this.b = (int) (java.lang.Float.parseFloat(str) / com.aliyun.utils.c.b());
                com.cicada.player.utils.Logger.v(com.aliyun.utils.c.a, "getCpuUsageAfter25 mMyPidPercent update " + com.aliyun.utils.c.this.b);
            } catch (java.lang.Exception unused) {
            }
        }
    }

    public interface e {
        void a(java.lang.String str);
    }

    public c() {
        new java.lang.Thread(new com.aliyun.utils.c.a()).start();
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
    private void a(java.lang.String str, com.aliyun.utils.c.e eVar) {
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
                                } else if (eVar != null) {
                                    eVar.a(readLine);
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

    public static int b() {
        try {
            return new java.io.File("/sys/devices/system/cpu/").listFiles(new com.aliyun.utils.c.b()).length;
        } catch (java.lang.Exception unused) {
            return 1;
        }
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

    private void c() {
        a("top -p " + android.os.Process.myPid() + " -o %CPU", new com.aliyun.utils.c.d());
    }

    private void d() {
        a(com.sensorsdata.sf.ui.view.UIProperty.top, new com.aliyun.utils.c.C0113c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (android.os.Build.VERSION.SDK_INT > 25) {
            c();
        } else {
            d();
        }
    }

    public int e() {
        com.cicada.player.utils.Logger.d(a, "getMyPicCpuPercent = " + this.b);
        return this.b;
    }
}
