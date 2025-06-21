package com.jd.ad.sdk.jad_hs;

/* loaded from: classes23.dex */
public final class jad_an implements java.io.Closeable {
    public final java.io.File jad_an;
    public final java.io.File jad_bo;
    public final java.io.File jad_cp;
    public final java.io.File jad_dq;
    public final int jad_er;
    public long jad_fs;
    public java.io.Writer jad_iv;
    public final int jad_jt;
    public int jad_kx;
    public long jad_hu = 0;
    public final java.util.LinkedHashMap<java.lang.String, com.jd.ad.sdk.jad_hs.jad_an.jad_dq> jad_jw = new java.util.LinkedHashMap<>(0, 0.75f, true);
    public long jad_ly = 0;
    public final java.util.concurrent.ThreadPoolExecutor jad_mz = new java.util.concurrent.ThreadPoolExecutor(0, 1, 60, java.util.concurrent.TimeUnit.SECONDS, new java.util.concurrent.LinkedBlockingQueue(), new com.jd.ad.sdk.jad_hs.jad_an.jad_bo(null));
    public final java.util.concurrent.Callable<java.lang.Void> jad_na = new com.jd.ad.sdk.jad_hs.jad_an.CallableC0380jad_an();

    /* renamed from: com.jd.ad.sdk.jad_hs.jad_an$jad_an, reason: collision with other inner class name */
    public class CallableC0380jad_an implements java.util.concurrent.Callable<java.lang.Void> {
        public CallableC0380jad_an() {
        }

        @Override // java.util.concurrent.Callable
        public java.lang.Void call() {
            synchronized (com.jd.ad.sdk.jad_hs.jad_an.this) {
                com.jd.ad.sdk.jad_hs.jad_an jad_anVar = com.jd.ad.sdk.jad_hs.jad_an.this;
                if (jad_anVar.jad_iv != null) {
                    jad_anVar.jad_jt();
                    if (com.jd.ad.sdk.jad_hs.jad_an.this.jad_cp()) {
                        com.jd.ad.sdk.jad_hs.jad_an.this.jad_fs();
                        com.jd.ad.sdk.jad_hs.jad_an.this.jad_kx = 0;
                    }
                }
            }
            return null;
        }
    }

    public static final class jad_bo implements java.util.concurrent.ThreadFactory {
        public jad_bo() {
        }

        public /* synthetic */ jad_bo(com.jd.ad.sdk.jad_hs.jad_an.CallableC0380jad_an callableC0380jad_an) {
            this();
        }

        @Override // java.util.concurrent.ThreadFactory
        public synchronized java.lang.Thread newThread(java.lang.Runnable runnable) {
            java.lang.Thread thread;
            thread = new java.lang.Thread(runnable, "glide-disk-lru-cache-thread");
            thread.setPriority(1);
            return thread;
        }
    }

    public final class jad_cp {
        public final com.jd.ad.sdk.jad_hs.jad_an.jad_dq jad_an;
        public final boolean[] jad_bo;
        public boolean jad_cp;

        public jad_cp(com.jd.ad.sdk.jad_hs.jad_an.jad_dq jad_dqVar) {
            this.jad_an = jad_dqVar;
            this.jad_bo = jad_dqVar.jad_er ? null : new boolean[com.jd.ad.sdk.jad_hs.jad_an.this.jad_jt];
        }

        public java.io.File jad_an(int i) {
            java.io.File jad_bo;
            synchronized (com.jd.ad.sdk.jad_hs.jad_an.this) {
                com.jd.ad.sdk.jad_hs.jad_an.jad_dq jad_dqVar = this.jad_an;
                if (jad_dqVar.jad_fs != this) {
                    throw new java.lang.IllegalStateException();
                }
                if (!jad_dqVar.jad_er) {
                    this.jad_bo[i] = true;
                }
                jad_bo = jad_dqVar.jad_bo(i);
                com.jd.ad.sdk.jad_hs.jad_an.this.jad_an.mkdirs();
            }
            return jad_bo;
        }

        public void jad_an() {
            com.jd.ad.sdk.jad_hs.jad_an.jad_an(com.jd.ad.sdk.jad_hs.jad_an.this, this, false);
        }
    }

    public final class jad_dq {
        public final java.lang.String jad_an;
        public final long[] jad_bo;
        public java.io.File[] jad_cp;
        public java.io.File[] jad_dq;
        public boolean jad_er;
        public com.jd.ad.sdk.jad_hs.jad_an.jad_cp jad_fs;
        public long jad_jt;

        public jad_dq(java.lang.String str) {
            this.jad_an = str;
            this.jad_bo = new long[com.jd.ad.sdk.jad_hs.jad_an.this.jad_jt];
            this.jad_cp = new java.io.File[com.jd.ad.sdk.jad_hs.jad_an.this.jad_jt];
            this.jad_dq = new java.io.File[com.jd.ad.sdk.jad_hs.jad_an.this.jad_jt];
            java.lang.StringBuilder sb = new java.lang.StringBuilder(str);
            sb.append('.');
            int length = sb.length();
            for (int i = 0; i < com.jd.ad.sdk.jad_hs.jad_an.this.jad_jt; i++) {
                sb.append(i);
                this.jad_cp[i] = new java.io.File(com.jd.ad.sdk.jad_hs.jad_an.this.jad_an, sb.toString());
                sb.append(com.baidu.mobads.sdk.internal.al.k);
                this.jad_dq[i] = new java.io.File(com.jd.ad.sdk.jad_hs.jad_an.this.jad_an, sb.toString());
                sb.setLength(length);
            }
        }

        public java.io.File jad_an(int i) {
            return this.jad_cp[i];
        }

        public java.lang.String jad_an() {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            for (long j : this.jad_bo) {
                sb.append(' ');
                sb.append(j);
            }
            return sb.toString();
        }

        public java.io.File jad_bo(int i) {
            return this.jad_dq[i];
        }
    }

    public final class jad_er {
        public final java.io.File[] jad_an;

        public jad_er(com.jd.ad.sdk.jad_hs.jad_an jad_anVar, java.lang.String str, long j, java.io.File[] fileArr, long[] jArr) {
            this.jad_an = fileArr;
        }

        public java.io.File jad_an(int i) {
            return this.jad_an[i];
        }
    }

    public jad_an(java.io.File file, int i, int i2, long j) {
        this.jad_an = file;
        this.jad_er = i;
        this.jad_bo = new java.io.File(file, "journal");
        this.jad_cp = new java.io.File(file, "journal.tmp");
        this.jad_dq = new java.io.File(file, "journal.bkp");
        this.jad_jt = i2;
        this.jad_fs = j;
    }

    public static void jad_an(com.jd.ad.sdk.jad_hs.jad_an jad_anVar, com.jd.ad.sdk.jad_hs.jad_an.jad_cp jad_cpVar, boolean z) {
        synchronized (jad_anVar) {
            com.jd.ad.sdk.jad_hs.jad_an.jad_dq jad_dqVar = jad_cpVar.jad_an;
            if (jad_dqVar.jad_fs != jad_cpVar) {
                throw new java.lang.IllegalStateException();
            }
            if (z && !jad_dqVar.jad_er) {
                for (int i = 0; i < jad_anVar.jad_jt; i++) {
                    if (!jad_cpVar.jad_bo[i]) {
                        jad_cpVar.jad_an();
                        throw new java.lang.IllegalStateException("Newly created entry didn't create value for index " + i);
                    }
                    if (!jad_dqVar.jad_bo(i).exists()) {
                        jad_cpVar.jad_an();
                        return;
                    }
                }
            }
            for (int i2 = 0; i2 < jad_anVar.jad_jt; i2++) {
                java.io.File jad_bo2 = jad_dqVar.jad_bo(i2);
                if (!z) {
                    jad_an(jad_bo2);
                } else if (jad_bo2.exists()) {
                    java.io.File jad_an = jad_dqVar.jad_an(i2);
                    jad_bo2.renameTo(jad_an);
                    long j = jad_dqVar.jad_bo[i2];
                    long length = jad_an.length();
                    jad_dqVar.jad_bo[i2] = length;
                    jad_anVar.jad_hu = (jad_anVar.jad_hu - j) + length;
                }
            }
            jad_anVar.jad_kx++;
            jad_dqVar.jad_fs = null;
            if (jad_dqVar.jad_er || z) {
                jad_dqVar.jad_er = true;
                jad_anVar.jad_iv.append((java.lang.CharSequence) "CLEAN");
                jad_anVar.jad_iv.append(' ');
                jad_anVar.jad_iv.append((java.lang.CharSequence) jad_dqVar.jad_an);
                jad_anVar.jad_iv.append((java.lang.CharSequence) jad_dqVar.jad_an());
                jad_anVar.jad_iv.append('\n');
                if (z) {
                    long j2 = jad_anVar.jad_ly;
                    jad_anVar.jad_ly = 1 + j2;
                    jad_dqVar.jad_jt = j2;
                }
            } else {
                jad_anVar.jad_jw.remove(jad_dqVar.jad_an);
                jad_anVar.jad_iv.append((java.lang.CharSequence) "REMOVE");
                jad_anVar.jad_iv.append(' ');
                jad_anVar.jad_iv.append((java.lang.CharSequence) jad_dqVar.jad_an);
                jad_anVar.jad_iv.append('\n');
            }
            jad_bo(jad_anVar.jad_iv);
            if (jad_anVar.jad_hu > jad_anVar.jad_fs || jad_anVar.jad_cp()) {
                jad_anVar.jad_mz.submit(jad_anVar.jad_na);
            }
        }
    }

    public static void jad_an(java.io.File file) {
        if (file.exists() && !file.delete()) {
            throw new java.io.IOException();
        }
    }

    public static void jad_an(java.io.File file, java.io.File file2, boolean z) {
        if (z) {
            jad_an(file2);
        }
        if (!file.renameTo(file2)) {
            throw new java.io.IOException();
        }
    }

    @android.annotation.TargetApi(26)
    public static void jad_an(java.io.Writer writer) {
        android.os.StrictMode.ThreadPolicy.Builder permitUnbufferedIo;
        if (android.os.Build.VERSION.SDK_INT < 26) {
            writer.close();
            return;
        }
        android.os.StrictMode.ThreadPolicy threadPolicy = android.os.StrictMode.getThreadPolicy();
        permitUnbufferedIo = new android.os.StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo();
        android.os.StrictMode.setThreadPolicy(permitUnbufferedIo.build());
        try {
            writer.close();
        } finally {
            android.os.StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    @android.annotation.TargetApi(26)
    public static void jad_bo(java.io.Writer writer) {
        android.os.StrictMode.ThreadPolicy.Builder permitUnbufferedIo;
        if (android.os.Build.VERSION.SDK_INT < 26) {
            writer.flush();
            return;
        }
        android.os.StrictMode.ThreadPolicy threadPolicy = android.os.StrictMode.getThreadPolicy();
        permitUnbufferedIo = new android.os.StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo();
        android.os.StrictMode.setThreadPolicy(permitUnbufferedIo.build());
        try {
            writer.flush();
        } finally {
            android.os.StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        if (this.jad_iv == null) {
            return;
        }
        java.util.Iterator it = new java.util.ArrayList(this.jad_jw.values()).iterator();
        while (it.hasNext()) {
            com.jd.ad.sdk.jad_hs.jad_an.jad_cp jad_cpVar = ((com.jd.ad.sdk.jad_hs.jad_an.jad_dq) it.next()).jad_fs;
            if (jad_cpVar != null) {
                jad_cpVar.jad_an();
            }
        }
        jad_jt();
        jad_an(this.jad_iv);
        this.jad_iv = null;
    }

    public com.jd.ad.sdk.jad_hs.jad_an.jad_cp jad_an(java.lang.String str) {
        synchronized (this) {
            jad_bo();
            com.jd.ad.sdk.jad_hs.jad_an.jad_dq jad_dqVar = this.jad_jw.get(str);
            if (jad_dqVar == null) {
                jad_dqVar = new com.jd.ad.sdk.jad_hs.jad_an.jad_dq(str);
                this.jad_jw.put(str, jad_dqVar);
            } else if (jad_dqVar.jad_fs != null) {
                return null;
            }
            com.jd.ad.sdk.jad_hs.jad_an.jad_cp jad_cpVar = new com.jd.ad.sdk.jad_hs.jad_an.jad_cp(jad_dqVar);
            jad_dqVar.jad_fs = jad_cpVar;
            this.jad_iv.append((java.lang.CharSequence) "DIRTY");
            this.jad_iv.append(' ');
            this.jad_iv.append((java.lang.CharSequence) str);
            this.jad_iv.append('\n');
            jad_bo(this.jad_iv);
            return jad_cpVar;
        }
    }

    public synchronized com.jd.ad.sdk.jad_hs.jad_an.jad_er jad_bo(java.lang.String str) {
        jad_bo();
        com.jd.ad.sdk.jad_hs.jad_an.jad_dq jad_dqVar = this.jad_jw.get(str);
        if (jad_dqVar == null) {
            return null;
        }
        if (!jad_dqVar.jad_er) {
            return null;
        }
        for (java.io.File file : jad_dqVar.jad_cp) {
            if (!file.exists()) {
                return null;
            }
        }
        this.jad_kx++;
        this.jad_iv.append((java.lang.CharSequence) "READ");
        this.jad_iv.append(' ');
        this.jad_iv.append((java.lang.CharSequence) str);
        this.jad_iv.append('\n');
        if (jad_cp()) {
            this.jad_mz.submit(this.jad_na);
        }
        return new com.jd.ad.sdk.jad_hs.jad_an.jad_er(this, str, jad_dqVar.jad_jt, jad_dqVar.jad_cp, jad_dqVar.jad_bo);
    }

    public final void jad_bo() {
        if (this.jad_iv == null) {
            throw new java.lang.IllegalStateException("cache is closed");
        }
    }

    public final void jad_cp(java.lang.String str) {
        java.lang.String substring;
        int indexOf = str.indexOf(32);
        if (indexOf == -1) {
            throw new java.io.IOException("unexpected journal line: " + str);
        }
        int i = indexOf + 1;
        int indexOf2 = str.indexOf(32, i);
        if (indexOf2 == -1) {
            substring = str.substring(i);
            if (indexOf == 6 && str.startsWith("REMOVE")) {
                this.jad_jw.remove(substring);
                return;
            }
        } else {
            substring = str.substring(i, indexOf2);
        }
        com.jd.ad.sdk.jad_hs.jad_an.jad_dq jad_dqVar = this.jad_jw.get(substring);
        if (jad_dqVar == null) {
            jad_dqVar = new com.jd.ad.sdk.jad_hs.jad_an.jad_dq(substring);
            this.jad_jw.put(substring, jad_dqVar);
        }
        if (indexOf2 == -1 || indexOf != 5 || !str.startsWith("CLEAN")) {
            if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                jad_dqVar.jad_fs = new com.jd.ad.sdk.jad_hs.jad_an.jad_cp(jad_dqVar);
                return;
            }
            if (indexOf2 == -1 && indexOf == 4 && str.startsWith("READ")) {
                return;
            }
            throw new java.io.IOException("unexpected journal line: " + str);
        }
        java.lang.String[] split = str.substring(indexOf2 + 1).split(" ");
        jad_dqVar.jad_er = true;
        jad_dqVar.jad_fs = null;
        if (split.length != com.jd.ad.sdk.jad_hs.jad_an.this.jad_jt) {
            java.lang.StringBuilder jad_an = com.jd.ad.sdk.jad_gr.jad_ly.jad_an("unexpected journal line: ");
            jad_an.append(java.util.Arrays.toString(split));
            throw new java.io.IOException(jad_an.toString());
        }
        for (int i2 = 0; i2 < split.length; i2++) {
            try {
                jad_dqVar.jad_bo[i2] = java.lang.Long.parseLong(split[i2]);
            } catch (java.lang.NumberFormatException unused) {
                java.lang.StringBuilder jad_an2 = com.jd.ad.sdk.jad_gr.jad_ly.jad_an("unexpected journal line: ");
                jad_an2.append(java.util.Arrays.toString(split));
                throw new java.io.IOException(jad_an2.toString());
            }
        }
    }

    public final boolean jad_cp() {
        int i = this.jad_kx;
        return i >= 2000 && i >= this.jad_jw.size();
    }

    public final void jad_dq() {
        jad_an(this.jad_cp);
        java.util.Iterator<com.jd.ad.sdk.jad_hs.jad_an.jad_dq> it = this.jad_jw.values().iterator();
        while (it.hasNext()) {
            com.jd.ad.sdk.jad_hs.jad_an.jad_dq next = it.next();
            int i = 0;
            if (next.jad_fs == null) {
                while (i < this.jad_jt) {
                    this.jad_hu += next.jad_bo[i];
                    i++;
                }
            } else {
                next.jad_fs = null;
                while (i < this.jad_jt) {
                    jad_an(next.jad_an(i));
                    jad_an(next.jad_bo(i));
                    i++;
                }
                it.remove();
            }
        }
    }

    public final void jad_er() {
        com.jd.ad.sdk.jad_hs.jad_bo jad_boVar = new com.jd.ad.sdk.jad_hs.jad_bo(new java.io.FileInputStream(this.jad_bo), 8192, com.jd.ad.sdk.jad_hs.jad_cp.jad_an);
        try {
            java.lang.String jad_cp2 = jad_boVar.jad_cp();
            java.lang.String jad_cp3 = jad_boVar.jad_cp();
            java.lang.String jad_cp4 = jad_boVar.jad_cp();
            java.lang.String jad_cp5 = jad_boVar.jad_cp();
            java.lang.String jad_cp6 = jad_boVar.jad_cp();
            if (!"libcore.io.DiskLruCache".equals(jad_cp2) || !"1".equals(jad_cp3) || !java.lang.Integer.toString(this.jad_er).equals(jad_cp4) || !java.lang.Integer.toString(this.jad_jt).equals(jad_cp5) || !"".equals(jad_cp6)) {
                throw new java.io.IOException("unexpected journal header: [" + jad_cp2 + ", " + jad_cp3 + ", " + jad_cp5 + ", " + jad_cp6 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    jad_cp(jad_boVar.jad_cp());
                    i++;
                } catch (java.io.EOFException unused) {
                    this.jad_kx = i - this.jad_jw.size();
                    if (jad_boVar.jad_er == -1) {
                        jad_fs();
                    } else {
                        this.jad_iv = new java.io.BufferedWriter(new java.io.OutputStreamWriter(new java.io.FileOutputStream(this.jad_bo, true), com.jd.ad.sdk.jad_hs.jad_cp.jad_an));
                    }
                    try {
                        jad_boVar.close();
                        return;
                    } catch (java.lang.RuntimeException e) {
                        throw e;
                    } catch (java.lang.Exception unused2) {
                        return;
                    }
                }
            }
        } catch (java.lang.Throwable th) {
            try {
                jad_boVar.close();
            } catch (java.lang.RuntimeException e2) {
                throw e2;
            } catch (java.lang.Exception unused3) {
            }
            throw th;
        }
    }

    public final synchronized void jad_fs() {
        java.lang.StringBuilder sb;
        java.io.Writer writer = this.jad_iv;
        if (writer != null) {
            jad_an(writer);
        }
        java.io.BufferedWriter bufferedWriter = new java.io.BufferedWriter(new java.io.OutputStreamWriter(new java.io.FileOutputStream(this.jad_cp), com.jd.ad.sdk.jad_hs.jad_cp.jad_an));
        try {
            bufferedWriter.write("libcore.io.DiskLruCache");
            bufferedWriter.write("\n");
            bufferedWriter.write("1");
            bufferedWriter.write("\n");
            bufferedWriter.write(java.lang.Integer.toString(this.jad_er));
            bufferedWriter.write("\n");
            bufferedWriter.write(java.lang.Integer.toString(this.jad_jt));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (com.jd.ad.sdk.jad_hs.jad_an.jad_dq jad_dqVar : this.jad_jw.values()) {
                if (jad_dqVar.jad_fs != null) {
                    sb = new java.lang.StringBuilder();
                    sb.append("DIRTY ");
                    sb.append(jad_dqVar.jad_an);
                    sb.append('\n');
                } else {
                    sb = new java.lang.StringBuilder();
                    sb.append("CLEAN ");
                    sb.append(jad_dqVar.jad_an);
                    sb.append(jad_dqVar.jad_an());
                    sb.append('\n');
                }
                bufferedWriter.write(sb.toString());
            }
            jad_an(bufferedWriter);
            if (this.jad_bo.exists()) {
                jad_an(this.jad_bo, this.jad_dq, true);
            }
            jad_an(this.jad_cp, this.jad_bo, false);
            this.jad_dq.delete();
            this.jad_iv = new java.io.BufferedWriter(new java.io.OutputStreamWriter(new java.io.FileOutputStream(this.jad_bo, true), com.jd.ad.sdk.jad_hs.jad_cp.jad_an));
        } catch (java.lang.Throwable th) {
            jad_an(bufferedWriter);
            throw th;
        }
    }

    public final void jad_jt() {
        while (this.jad_hu > this.jad_fs) {
            java.lang.String key = this.jad_jw.entrySet().iterator().next().getKey();
            synchronized (this) {
                jad_bo();
                com.jd.ad.sdk.jad_hs.jad_an.jad_dq jad_dqVar = this.jad_jw.get(key);
                if (jad_dqVar != null && jad_dqVar.jad_fs == null) {
                    for (int i = 0; i < this.jad_jt; i++) {
                        java.io.File jad_an = jad_dqVar.jad_an(i);
                        if (jad_an.exists() && !jad_an.delete()) {
                            throw new java.io.IOException("failed to delete " + jad_an);
                        }
                        long j = this.jad_hu;
                        long[] jArr = jad_dqVar.jad_bo;
                        this.jad_hu = j - jArr[i];
                        jArr[i] = 0;
                    }
                    this.jad_kx++;
                    this.jad_iv.append((java.lang.CharSequence) "REMOVE");
                    this.jad_iv.append(' ');
                    this.jad_iv.append((java.lang.CharSequence) key);
                    this.jad_iv.append('\n');
                    this.jad_jw.remove(key);
                    if (jad_cp()) {
                        this.jad_mz.submit(this.jad_na);
                    }
                }
            }
        }
    }
}
