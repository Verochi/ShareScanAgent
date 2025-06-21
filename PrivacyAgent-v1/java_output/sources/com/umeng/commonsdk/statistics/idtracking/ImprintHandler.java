package com.umeng.commonsdk.statistics.idtracking;

/* loaded from: classes19.dex */
public class ImprintHandler implements com.umeng.commonsdk.utils.FileLockCallback {
    private static final java.lang.String a = "ImprintHandler";
    private static android.content.Context k = null;
    private static com.umeng.commonsdk.utils.FileLockUtil l = null;
    private static final int m = 0;
    private static final int n = 1;
    private com.umeng.commonsdk.statistics.internal.d e;
    private com.umeng.commonsdk.statistics.idtracking.ImprintHandler.a h = new com.umeng.commonsdk.statistics.idtracking.ImprintHandler.a();
    private com.umeng.commonsdk.statistics.proto.d i = null;
    private static java.lang.Object b = new java.lang.Object();
    private static final java.lang.String c = com.umeng.analytics.pro.ay.b().b(com.umeng.analytics.pro.ay.c);
    private static final byte[] d = "pbl0".getBytes();
    private static java.util.Map<java.lang.String, java.util.ArrayList<com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback>> f = new java.util.HashMap();
    private static java.lang.Object g = new java.lang.Object();
    private static com.umeng.commonsdk.statistics.idtracking.ImprintHandler j = null;
    private static java.util.Map<java.lang.String, com.umeng.commonsdk.statistics.internal.UMImprintPreProcessCallback> o = new java.util.HashMap();
    private static java.lang.Object p = new java.lang.Object();

    public static class a {
        private java.util.Map<java.lang.String, java.lang.String> a = new java.util.HashMap();

        public a() {
        }

        public a(com.umeng.commonsdk.statistics.proto.d dVar) {
            a(dVar);
        }

        private synchronized void b(com.umeng.commonsdk.statistics.proto.d dVar) {
            com.umeng.commonsdk.statistics.proto.e eVar;
            if (dVar != null) {
                if (dVar.e()) {
                    java.util.Map<java.lang.String, com.umeng.commonsdk.statistics.proto.e> c = dVar.c();
                    for (java.lang.String str : c.keySet()) {
                        if (!android.text.TextUtils.isEmpty(str) && (eVar = c.get(str)) != null) {
                            java.lang.String b = eVar.b();
                            if (!android.text.TextUtils.isEmpty(b)) {
                                this.a.put(str, b);
                                if (com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG) {
                                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                                    sb.append("imKey is ");
                                    sb.append(str);
                                    sb.append(", imValue is ");
                                    sb.append(b);
                                }
                            }
                        }
                    }
                }
            }
        }

        public synchronized java.lang.String a(java.lang.String str, java.lang.String str2) {
            if (!android.text.TextUtils.isEmpty(str) && this.a.size() > 0) {
                java.lang.String str3 = this.a.get(str);
                return !android.text.TextUtils.isEmpty(str3) ? str3 : str2;
            }
            return str2;
        }

        public void a(com.umeng.commonsdk.statistics.proto.d dVar) {
            if (dVar == null) {
                return;
            }
            b(dVar);
        }

        public synchronized void a(java.lang.String str) {
            java.util.Map<java.lang.String, java.lang.String> map = this.a;
            if (map != null && map.size() > 0 && !android.text.TextUtils.isEmpty(str) && this.a.containsKey(str)) {
                this.a.remove(str);
            }
        }
    }

    private ImprintHandler(android.content.Context context) {
        k = context.getApplicationContext();
    }

    private com.umeng.commonsdk.statistics.proto.d a(com.umeng.commonsdk.statistics.proto.d dVar, com.umeng.commonsdk.statistics.proto.d dVar2, java.util.Map<java.lang.String, java.lang.String> map) {
        com.umeng.commonsdk.statistics.internal.UMImprintPreProcessCallback uMImprintPreProcessCallback;
        java.util.ArrayList<com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback> arrayList;
        if (dVar2 == null) {
            return dVar;
        }
        java.util.Map<java.lang.String, com.umeng.commonsdk.statistics.proto.e> c2 = dVar.c();
        for (java.util.Map.Entry<java.lang.String, com.umeng.commonsdk.statistics.proto.e> entry : dVar2.c().entrySet()) {
            int i = 0;
            if (entry.getValue().d()) {
                java.lang.String key = entry.getKey();
                java.lang.String str = entry.getValue().a;
                synchronized (p) {
                    if (!android.text.TextUtils.isEmpty(key) && o.containsKey(key) && (uMImprintPreProcessCallback = o.get(key)) != null && uMImprintPreProcessCallback.onPreProcessImprintKey(key, str)) {
                        i = 1;
                    }
                }
                if (i == 0) {
                    c2.put(entry.getKey(), entry.getValue());
                    synchronized (g) {
                        if (!android.text.TextUtils.isEmpty(key) && f.containsKey(key) && f.get(key) != null) {
                            map.put(key, str);
                        }
                    }
                } else {
                    com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> merge: [" + key + "] should be ignored.");
                }
            } else {
                java.lang.String key2 = entry.getKey();
                synchronized (g) {
                    if (!android.text.TextUtils.isEmpty(key2) && f.containsKey(key2) && (arrayList = f.get(key2)) != null) {
                        while (i < arrayList.size()) {
                            arrayList.get(i).onImprintValueChanged(key2, null);
                            i++;
                        }
                    }
                }
                c2.remove(key2);
                this.h.a(key2);
            }
        }
        dVar.a(dVar2.f());
        dVar.a(a(dVar));
        return dVar;
    }

    private void a(java.io.File file) {
        if (this.i == null) {
            return;
        }
        try {
            synchronized (b) {
                byte[] a2 = new com.umeng.analytics.pro.cl().a(this.i);
                java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(file);
                try {
                    fileOutputStream.write(a2);
                    fileOutputStream.flush();
                } finally {
                    com.umeng.commonsdk.statistics.common.HelperUtils.safeClose(fileOutputStream);
                }
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    private static void a(java.lang.String str, com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback uMImprintChangeCallback) {
        synchronized (g) {
            try {
                int i = 0;
                if (f.containsKey(str)) {
                    java.util.ArrayList<com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback> arrayList = f.get(str);
                    int size = arrayList.size();
                    com.umeng.commonsdk.statistics.common.ULog.i("--->>> addCallback: before add: callbacks size is: " + size);
                    while (i < size) {
                        if (uMImprintChangeCallback == arrayList.get(i)) {
                            com.umeng.commonsdk.statistics.common.ULog.i("--->>> addCallback: callback has exist, just exit");
                            return;
                        }
                        i++;
                    }
                    arrayList.add(uMImprintChangeCallback);
                    com.umeng.commonsdk.statistics.common.ULog.i("--->>> addCallback: after add: callbacks size is: " + arrayList.size());
                } else {
                    java.util.ArrayList<com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback> arrayList2 = new java.util.ArrayList<>();
                    int size2 = arrayList2.size();
                    com.umeng.commonsdk.statistics.common.ULog.i("--->>> addCallback: before add: callbacks size is: " + size2);
                    while (i < size2) {
                        if (uMImprintChangeCallback == arrayList2.get(i)) {
                            com.umeng.commonsdk.statistics.common.ULog.i("--->>> addCallback: callback has exist, just exit");
                            return;
                        }
                        i++;
                    }
                    arrayList2.add(uMImprintChangeCallback);
                    com.umeng.commonsdk.statistics.common.ULog.i("--->>> addCallback: after add: callbacks size is: " + arrayList2.size());
                    f.put(str, arrayList2);
                }
            } catch (java.lang.Throwable th) {
                com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(k, th);
            }
        }
    }

    private boolean a(java.lang.String str, java.lang.String str2) {
        return str == null ? str2 == null : str.equals(str2);
    }

    private static void b(java.lang.String str, com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback uMImprintChangeCallback) {
        if (android.text.TextUtils.isEmpty(str) || uMImprintChangeCallback == null) {
            return;
        }
        synchronized (g) {
            try {
                if (f.containsKey(str)) {
                    java.util.ArrayList<com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback> arrayList = f.get(str);
                    if (arrayList.size() > 0) {
                        int size = arrayList.size();
                        com.umeng.commonsdk.statistics.common.ULog.i("--->>> removeCallback: before remove: callbacks size is: " + size);
                        int i = 0;
                        while (true) {
                            if (i >= size) {
                                break;
                            }
                            if (uMImprintChangeCallback == arrayList.get(i)) {
                                com.umeng.commonsdk.statistics.common.ULog.i("--->>> removeCallback: remove index " + i);
                                arrayList.remove(i);
                                break;
                            }
                            i++;
                        }
                        com.umeng.commonsdk.statistics.common.ULog.i("--->>> removeCallback: after remove: callbacks size is: " + arrayList.size());
                        if (arrayList.size() == 0) {
                            com.umeng.commonsdk.statistics.common.ULog.i("--->>> removeCallback: remove key from map: key = " + str);
                            f.remove(str);
                        }
                    }
                }
            } finally {
            }
        }
    }

    private boolean c(com.umeng.commonsdk.statistics.proto.d dVar) {
        if (!dVar.i().equals(a(dVar))) {
            return false;
        }
        for (com.umeng.commonsdk.statistics.proto.e eVar : dVar.c().values()) {
            java.lang.String h = eVar.h();
            if (!android.text.TextUtils.isEmpty(h)) {
                byte[] reverseHexString = com.umeng.commonsdk.statistics.common.DataHelper.reverseHexString(h);
                byte[] a2 = a(eVar);
                for (int i = 0; i < 4; i++) {
                    if (reverseHexString[i] != a2[i]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private com.umeng.commonsdk.statistics.proto.d d(com.umeng.commonsdk.statistics.proto.d dVar) {
        java.util.Map<java.lang.String, com.umeng.commonsdk.statistics.proto.e> c2 = dVar.c();
        if (c2.containsKey(com.umeng.analytics.pro.bo.f)) {
            c2.remove(com.umeng.analytics.pro.bo.f);
            this.h.a(com.umeng.analytics.pro.bo.f);
            dVar.a(dVar.f());
            dVar.a(a(dVar));
        }
        return dVar;
    }

    private com.umeng.commonsdk.statistics.proto.d e(com.umeng.commonsdk.statistics.proto.d dVar) {
        java.util.ArrayList<com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback> arrayList;
        boolean z;
        java.util.ArrayList<com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback> arrayList2;
        com.umeng.commonsdk.statistics.internal.UMImprintPreProcessCallback uMImprintPreProcessCallback;
        java.util.Map<java.lang.String, com.umeng.commonsdk.statistics.proto.e> c2 = dVar.c();
        java.util.ArrayList<java.lang.String> arrayList3 = new java.util.ArrayList(c2.size() / 2);
        java.util.Iterator<java.util.Map.Entry<java.lang.String, com.umeng.commonsdk.statistics.proto.e>> it = c2.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            java.util.Map.Entry<java.lang.String, com.umeng.commonsdk.statistics.proto.e> next = it.next();
            if (next.getValue().d()) {
                java.lang.String key = next.getKey();
                java.lang.String str = next.getValue().a;
                synchronized (p) {
                    z = !android.text.TextUtils.isEmpty(key) && o.containsKey(key) && (uMImprintPreProcessCallback = o.get(key)) != null && uMImprintPreProcessCallback.onPreProcessImprintKey(key, str);
                }
                if (z) {
                    arrayList3.add(key);
                }
                synchronized (g) {
                    if (!android.text.TextUtils.isEmpty(key) && f.containsKey(key) && (arrayList2 = f.get(key)) != null) {
                        for (int i = 0; i < arrayList2.size(); i++) {
                            arrayList2.get(i).onImprintValueChanged(key, str);
                        }
                    }
                }
            } else {
                arrayList3.add(next.getKey());
            }
        }
        for (java.lang.String str2 : arrayList3) {
            synchronized (g) {
                if (!android.text.TextUtils.isEmpty(str2) && f.containsKey(str2) && (arrayList = f.get(str2)) != null) {
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        arrayList.get(i2).onImprintValueChanged(str2, null);
                    }
                }
            }
            c2.remove(str2);
        }
        return dVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0036 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v3, types: [android.content.Context] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void e() {
        java.lang.Throwable th;
        java.io.FileInputStream fileInputStream;
        java.io.File filesDir = k.getFilesDir();
        ?? r2 = c;
        java.io.File file = new java.io.File(filesDir, (java.lang.String) r2);
        synchronized (b) {
            if (file.exists()) {
                byte[] bArr = null;
                try {
                    try {
                        fileInputStream = k.openFileInput(r2);
                        try {
                            bArr = com.umeng.commonsdk.statistics.common.HelperUtils.readStreamToByteArray(fileInputStream);
                            r2 = fileInputStream;
                        } catch (java.lang.Exception e) {
                            e = e;
                            e.printStackTrace();
                            r2 = fileInputStream;
                            com.umeng.commonsdk.statistics.common.HelperUtils.safeClose((java.io.InputStream) r2);
                            if (bArr != null) {
                            }
                        }
                    } catch (java.lang.Throwable th2) {
                        th = th2;
                        com.umeng.commonsdk.statistics.common.HelperUtils.safeClose((java.io.InputStream) r2);
                        throw th;
                    }
                } catch (java.lang.Exception e2) {
                    e = e2;
                    fileInputStream = null;
                } catch (java.lang.Throwable th3) {
                    r2 = 0;
                    th = th3;
                    com.umeng.commonsdk.statistics.common.HelperUtils.safeClose((java.io.InputStream) r2);
                    throw th;
                }
                com.umeng.commonsdk.statistics.common.HelperUtils.safeClose((java.io.InputStream) r2);
                if (bArr != null) {
                    try {
                        com.umeng.commonsdk.statistics.proto.d dVar = new com.umeng.commonsdk.statistics.proto.d();
                        new com.umeng.analytics.pro.cf().a(dVar, bArr);
                        this.i = dVar;
                        this.h.a(dVar);
                        this.i = d(this.i);
                    } catch (java.lang.Exception e3) {
                        e3.printStackTrace();
                    }
                }
            }
        }
    }

    public static synchronized com.umeng.commonsdk.statistics.idtracking.ImprintHandler getImprintService(android.content.Context context) {
        com.umeng.commonsdk.statistics.idtracking.ImprintHandler imprintHandler;
        synchronized (com.umeng.commonsdk.statistics.idtracking.ImprintHandler.class) {
            if (j == null) {
                j = new com.umeng.commonsdk.statistics.idtracking.ImprintHandler(context);
                l = new com.umeng.commonsdk.utils.FileLockUtil();
                l.doFileOperateion(new java.io.File(k.getFilesDir(), c), j, 0);
            }
            imprintHandler = j;
        }
        return imprintHandler;
    }

    public java.lang.String a(com.umeng.commonsdk.statistics.proto.d dVar) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (java.util.Map.Entry entry : new java.util.TreeMap(dVar.c()).entrySet()) {
            sb.append((java.lang.String) entry.getKey());
            if (((com.umeng.commonsdk.statistics.proto.e) entry.getValue()).d()) {
                sb.append(((com.umeng.commonsdk.statistics.proto.e) entry.getValue()).b());
            }
        }
        sb.append(dVar.b);
        return com.umeng.commonsdk.statistics.common.HelperUtils.MD5(sb.toString()).toLowerCase(java.util.Locale.US);
    }

    public void a(com.umeng.commonsdk.statistics.internal.d dVar) {
        this.e = dVar;
    }

    public void a(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (p) {
            try {
                if (o.containsKey(str)) {
                    com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> unregistPreProcessCallback: unregist [" + str + "] success.");
                    f.remove(str);
                } else {
                    com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> unregistPreProcessCallback: can't find [" + str + "], pls regist first.");
                }
            } finally {
            }
        }
    }

    public byte[] a() {
        try {
            synchronized (this) {
                com.umeng.commonsdk.statistics.proto.d dVar = this.i;
                if (dVar == null) {
                    return null;
                }
                if (dVar.b() <= 0) {
                    return null;
                }
                return new com.umeng.analytics.pro.cl().a(this.i);
            }
        } catch (java.lang.Throwable th) {
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(k, th);
            return null;
        }
    }

    public byte[] a(com.umeng.commonsdk.statistics.proto.e eVar) {
        java.nio.ByteBuffer allocate = java.nio.ByteBuffer.allocate(8);
        allocate.order(null);
        allocate.putLong(eVar.e());
        byte[] array = allocate.array();
        byte[] bArr = d;
        byte[] bArr2 = new byte[4];
        for (int i = 0; i < 4; i++) {
            bArr2[i] = (byte) (array[i] ^ bArr[i]);
        }
        return bArr2;
    }

    public synchronized com.umeng.commonsdk.statistics.proto.d b() {
        return this.i;
    }

    public void b(com.umeng.commonsdk.statistics.proto.d dVar) {
        boolean z;
        if (dVar == null) {
            if (com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG) {
                com.umeng.commonsdk.debug.UMRTLog.d(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "Imprint is null");
                return;
            }
            return;
        }
        if (!c(dVar)) {
            if (com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG) {
                com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "Imprint is not valid");
                return;
            }
            return;
        }
        java.lang.String str = com.umeng.commonsdk.statistics.AnalyticsConstants.OS;
        java.util.HashMap hashMap = new java.util.HashMap();
        synchronized (this) {
            com.umeng.commonsdk.statistics.proto.d dVar2 = this.i;
            com.umeng.commonsdk.statistics.proto.d d2 = d(dVar);
            java.lang.String str2 = null;
            java.lang.String i = dVar2 == null ? null : dVar2.i();
            com.umeng.commonsdk.statistics.proto.d e = dVar2 == null ? e(d2) : a(dVar2, d2, hashMap);
            this.i = e;
            if (e != null) {
                str2 = e.i();
            }
            z = !a(i, str2);
        }
        com.umeng.commonsdk.statistics.proto.d dVar3 = this.i;
        if (dVar3 != null && z) {
            this.h.a(dVar3);
            com.umeng.commonsdk.statistics.internal.d dVar4 = this.e;
            if (dVar4 != null) {
                dVar4.onImprintChanged(this.h);
            }
        }
        if (hashMap.size() > 0) {
            synchronized (g) {
                for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : hashMap.entrySet()) {
                    java.lang.String key = entry.getKey();
                    java.lang.String value = entry.getValue();
                    if (!android.text.TextUtils.isEmpty(key) && f.containsKey(key)) {
                        com.umeng.commonsdk.statistics.common.ULog.i("--->>> target imprint key is: " + key + "; value is: " + value);
                        java.util.ArrayList<com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback> arrayList = f.get(key);
                        if (arrayList != null) {
                            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                                arrayList.get(i2).onImprintValueChanged(key, value);
                            }
                        }
                    }
                }
            }
        }
    }

    public com.umeng.commonsdk.statistics.idtracking.ImprintHandler.a c() {
        return this.h;
    }

    public void d() {
        if (this.i == null || l == null) {
            return;
        }
        java.io.File file = new java.io.File(k.getFilesDir(), c);
        if (!file.exists()) {
            try {
                try {
                    file.createNewFile();
                } catch (java.io.IOException e) {
                    com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(k, e);
                }
            } catch (java.io.IOException unused) {
                file.createNewFile();
            }
        }
        l.doFileOperateion(file, j, 1);
    }

    @Override // com.umeng.commonsdk.utils.FileLockCallback
    public boolean onFileLock(java.io.File file, int i) {
        if (i == 0) {
            j.e();
        } else if (i == 1) {
            j.a(file);
        }
        return true;
    }

    @Override // com.umeng.commonsdk.utils.FileLockCallback
    public boolean onFileLock(java.lang.String str) {
        return false;
    }

    @Override // com.umeng.commonsdk.utils.FileLockCallback
    public boolean onFileLock(java.lang.String str, java.lang.Object obj) {
        return false;
    }

    public void registImprintCallback(java.lang.String str, com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback uMImprintChangeCallback) {
        if (android.text.TextUtils.isEmpty(str) || uMImprintChangeCallback == null) {
            return;
        }
        a(str, uMImprintChangeCallback);
    }

    public void registPreProcessCallback(java.lang.String str, com.umeng.commonsdk.statistics.internal.UMImprintPreProcessCallback uMImprintPreProcessCallback) {
        if (android.text.TextUtils.isEmpty(str) || uMImprintPreProcessCallback == null) {
            return;
        }
        synchronized (p) {
            try {
                if (o.containsKey(str)) {
                    com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> key : " + str + " PreProcesser has registed!");
                } else {
                    o.put(str, uMImprintPreProcessCallback);
                    com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> registPreProcessCallback: key : " + str + " regist success.");
                }
            } finally {
            }
        }
    }

    public void unregistImprintCallback(java.lang.String str, com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback uMImprintChangeCallback) {
        if (android.text.TextUtils.isEmpty(str) || uMImprintChangeCallback == null) {
            return;
        }
        b(str, uMImprintChangeCallback);
    }
}
