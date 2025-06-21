package com.anythink.expressad.videocommon.b;

/* loaded from: classes12.dex */
public final class d implements com.anythink.expressad.videocommon.b.i.c {
    private static java.lang.String a = "DownLoadH5SourceListener";
    private java.util.concurrent.ConcurrentMap<java.lang.String, com.anythink.expressad.videocommon.b.d> b;
    private com.anythink.expressad.videocommon.b.m c;
    private java.util.concurrent.CopyOnWriteArrayList<com.anythink.expressad.videocommon.b.i.d> d;
    private java.lang.String e;

    public d(java.util.concurrent.ConcurrentMap<java.lang.String, com.anythink.expressad.videocommon.b.d> concurrentMap, com.anythink.expressad.videocommon.b.m mVar, com.anythink.expressad.videocommon.b.i.d dVar, java.lang.String str) {
        java.util.concurrent.CopyOnWriteArrayList<com.anythink.expressad.videocommon.b.i.d> copyOnWriteArrayList = new java.util.concurrent.CopyOnWriteArrayList<>();
        this.d = copyOnWriteArrayList;
        this.b = concurrentMap;
        this.c = mVar;
        copyOnWriteArrayList.add(dVar);
        this.e = str;
    }

    @Override // com.anythink.expressad.videocommon.b.i.c
    public final void a() {
    }

    public final void a(com.anythink.expressad.videocommon.b.i.d dVar) {
        this.d.add(dVar);
    }

    @Override // com.anythink.expressad.videocommon.b.i.c
    public final void a(java.lang.String str) {
        java.util.concurrent.ConcurrentMap<java.lang.String, com.anythink.expressad.videocommon.b.d> concurrentMap;
        try {
            concurrentMap = this.b;
        } catch (java.lang.Exception e) {
            if (com.anythink.expressad.a.a) {
                e.printStackTrace();
            }
            try {
                str = e.getMessage();
            } catch (java.lang.Throwable th) {
                th.getMessage();
            }
        }
        if (concurrentMap == null) {
            java.util.Iterator<com.anythink.expressad.videocommon.b.i.d> it = this.d.iterator();
            while (it.hasNext()) {
                com.anythink.expressad.videocommon.b.i.d next = it.next();
                if (next != null) {
                    next.a(this.e, "mResDownloadingMap  is null");
                    this.d.remove(next);
                }
            }
            return;
        }
        if (concurrentMap.containsKey(this.e)) {
            this.b.remove(this.e);
        }
        java.util.Iterator<com.anythink.expressad.videocommon.b.i.d> it2 = this.d.iterator();
        while (it2.hasNext()) {
            com.anythink.expressad.videocommon.b.i.d next2 = it2.next();
            if (next2 != null) {
                next2.a(this.e, str);
                this.d.remove(next2);
            }
        }
    }

    @Override // com.anythink.expressad.videocommon.b.i.c
    public final void a(byte[] bArr, java.lang.String str) {
        java.lang.String str2;
        java.util.concurrent.ConcurrentMap<java.lang.String, com.anythink.expressad.videocommon.b.d> concurrentMap;
        try {
            concurrentMap = this.b;
        } catch (java.lang.Exception e) {
            if (com.anythink.expressad.a.a) {
                e.printStackTrace();
            }
            try {
                str2 = e.getMessage();
            } catch (java.lang.Throwable th) {
                th.getMessage();
                str2 = "";
            }
        }
        if (concurrentMap == null) {
            java.util.Iterator<com.anythink.expressad.videocommon.b.i.d> it = this.d.iterator();
            while (it.hasNext()) {
                com.anythink.expressad.videocommon.b.i.d next = it.next();
                if (next != null) {
                    next.a(str, "mResDownloadingMap  is null");
                    this.d.remove(next);
                }
            }
            return;
        }
        if (concurrentMap.containsKey(str)) {
            this.b.remove(str);
        }
        if (bArr == null || bArr.length <= 0) {
            str2 = "response data is error";
        } else {
            java.lang.String a2 = this.c.a(str, bArr);
            if (android.text.TextUtils.isEmpty(a2)) {
                java.util.Iterator<com.anythink.expressad.videocommon.b.i.d> it2 = this.d.iterator();
                while (it2.hasNext()) {
                    com.anythink.expressad.videocommon.b.i.d next2 = it2.next();
                    if (next2 != null) {
                        next2.a(str);
                        this.d.remove(next2);
                    }
                }
                return;
            }
            str2 = "data save failed:".concat(java.lang.String.valueOf(a2));
        }
        java.util.Iterator<com.anythink.expressad.videocommon.b.i.d> it3 = this.d.iterator();
        while (it3.hasNext()) {
            com.anythink.expressad.videocommon.b.i.d next3 = it3.next();
            if (next3 != null) {
                next3.a(str, str2);
            }
        }
    }
}
