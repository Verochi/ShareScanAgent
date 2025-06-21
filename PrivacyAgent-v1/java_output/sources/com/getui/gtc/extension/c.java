package com.getui.gtc.extension;

/* loaded from: classes22.dex */
public final class c {
    java.lang.String a;
    java.lang.String b;
    final java.util.Map<java.lang.String, com.getui.gtc.entity.a.C0306a> c;

    /* renamed from: com.getui.gtc.extension.c$1, reason: invalid class name */
    public class AnonymousClass1 extends com.getui.gtc.f.e {
        public AnonymousClass1() {
        }

        @Override // com.getui.gtc.f.e
        public final void a(java.lang.String str) {
        }

        @Override // com.getui.gtc.f.e
        public final void a(java.util.Map<java.lang.String, java.lang.String> map, java.util.Map<java.lang.String, java.lang.String> map2) {
            com.getui.gtc.e.c cVar;
            if (map == null || map2 == null) {
                return;
            }
            com.getui.gtc.entity.a a = com.getui.gtc.entity.a.a(map2);
            com.getui.gtc.entity.a a2 = com.getui.gtc.entity.a.a(map);
            if (a2 != null) {
                int size = a2.a.size();
                java.util.HashSet hashSet = new java.util.HashSet();
                for (int i = 0; i < size; i++) {
                    com.getui.gtc.entity.a.C0306a a3 = a2.a(i);
                    if (a == null || a.b(a3.a) == null || !a.b(a3.a).b.equalsIgnoreCase(a3.b) || !a.b(a3.a).c.equalsIgnoreCase(a3.c)) {
                        hashSet.add(a3.c);
                    }
                }
                com.getui.gtc.h.c.a.a("wait remove: ".concat(java.lang.String.valueOf(hashSet)));
                cVar = com.getui.gtc.e.c.a.a;
                cVar.a.a(hashSet);
            }
            if (a != null) {
                int size2 = a.a.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    com.getui.gtc.entity.a.C0306a a4 = a.a(i2);
                    if (!com.getui.gtc.extension.c.this.a(a4)) {
                        try {
                            com.getui.gtc.g.b.a(a4, com.getui.gtc.extension.c.this.b + java.io.File.separator + a4.c);
                        } catch (java.lang.Exception e) {
                            com.getui.gtc.h.c.a.b(e);
                        }
                    }
                }
            }
        }
    }

    /* renamed from: com.getui.gtc.extension.c$2, reason: invalid class name */
    public class AnonymousClass2 implements com.getui.gtc.extension.a.b {
        final /* synthetic */ com.getui.gtc.entity.a.C0306a a;

        public AnonymousClass2(com.getui.gtc.entity.a.C0306a c0306a) {
            this.a = c0306a;
        }

        @Override // com.getui.gtc.extension.a.b
        public final void a(boolean z) {
            if (z) {
                return;
            }
            com.getui.gtc.extension.c.this.c.remove(this.a.d);
        }
    }

    /* renamed from: com.getui.gtc.extension.c$3, reason: invalid class name */
    public class AnonymousClass3 implements com.getui.gtc.f.c.a {
        final /* synthetic */ com.getui.gtc.api.SdkInfo a;

        public AnonymousClass3(com.getui.gtc.api.SdkInfo sdkInfo) {
            this.a = sdkInfo;
        }

        @Override // com.getui.gtc.f.c.a
        public final void a(java.util.Map<java.lang.String, java.lang.String> map) {
            com.getui.gtc.extension.c.this.a(this.a, com.getui.gtc.entity.a.a(map));
        }
    }

    /* renamed from: com.getui.gtc.extension.c$4, reason: invalid class name */
    public class AnonymousClass4 implements java.lang.Runnable {
        final /* synthetic */ com.getui.gtc.api.SdkInfo a;
        final /* synthetic */ com.getui.gtc.entity.a.C0306a b;
        final /* synthetic */ long c;

        /* renamed from: com.getui.gtc.extension.c$4$1, reason: invalid class name */
        public class AnonymousClass1 implements com.getui.gtc.extension.a.b {
            final /* synthetic */ java.io.File a;

            public AnonymousClass1(java.io.File file) {
                this.a = file;
            }

            @Override // com.getui.gtc.extension.a.b
            public final void a(boolean z) {
                com.getui.gtc.e.c cVar;
                com.getui.gtc.h.b.a.a(this.a);
                if (!z) {
                    com.getui.gtc.extension.c.AnonymousClass4 anonymousClass4 = com.getui.gtc.extension.c.AnonymousClass4.this;
                    com.getui.gtc.extension.c.this.c.remove(anonymousClass4.b.d);
                } else if (com.getui.gtc.extension.c.AnonymousClass4.this.c == 0) {
                    cVar = com.getui.gtc.e.c.a.a;
                    cVar.b.a(com.getui.gtc.extension.c.AnonymousClass4.this.b.a, java.lang.System.currentTimeMillis());
                }
            }
        }

        public AnonymousClass4(com.getui.gtc.api.SdkInfo sdkInfo, com.getui.gtc.entity.a.C0306a c0306a, long j) {
            this.a = sdkInfo;
            this.b = c0306a;
            this.c = j;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.getui.gtc.e.c cVar;
            java.lang.String a = com.getui.gtc.extension.c.this.a(this.a, this.b);
            if (a == null) {
                com.getui.gtc.extension.c.this.c.remove(this.b.d);
                return;
            }
            java.io.File file = new java.io.File(a);
            java.io.File file2 = new java.io.File(a + com.getui.gtc.c.a.b);
            com.getui.gtc.h.a.a.a(file, file2, this.b.f);
            if (this.b.j) {
                com.getui.gtc.extension.b.a(com.getui.gtc.base.GtcProvider.context(), file2.getAbsolutePath(), com.getui.gtc.extension.c.this.a, this.b.d, this.a.getAppid(), this.a.getCid(), new com.getui.gtc.extension.c.AnonymousClass4.AnonymousClass1(file2));
                return;
            }
            try {
                com.getui.gtc.extension.b.a(com.getui.gtc.base.GtcProvider.context(), file2.getAbsolutePath(), com.getui.gtc.extension.c.this.a, this.b.d, this.a.getAppid(), this.a.getCid());
                if (this.c == 0) {
                    cVar = com.getui.gtc.e.c.a.a;
                    cVar.b.a(this.b.a, java.lang.System.currentTimeMillis());
                }
            } catch (java.lang.Throwable th) {
                try {
                    com.getui.gtc.extension.c.this.c.remove(this.b.d);
                    com.getui.gtc.h.c.a.b("net gtcFile filed: ".concat(java.lang.String.valueOf(th)));
                } finally {
                    com.getui.gtc.h.b.a.a(file2);
                }
            }
        }
    }

    public static class a {
        private static final com.getui.gtc.extension.c a = new com.getui.gtc.extension.c((byte) 0);
    }

    private c() {
        com.getui.gtc.e.c cVar;
        com.getui.gtc.e.c cVar2;
        this.c = new java.util.HashMap();
        try {
            this.a = com.getui.gtc.base.GtcProvider.context().getFilesDir().getAbsolutePath();
            java.io.File file = new java.io.File(this.a);
            if (!file.exists()) {
                file.mkdirs();
            }
            this.b = this.a + java.io.File.separator + "libs";
            java.io.File file2 = new java.io.File(this.b);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            cVar = com.getui.gtc.e.c.a.a;
            java.util.HashSet<java.lang.String> hashSet = new java.util.HashSet(cVar.a.n);
            for (java.lang.String str : hashSet) {
                if (a(str)) {
                    cVar2 = com.getui.gtc.e.c.a.a;
                    cVar2.a.f(str);
                    com.getui.gtc.h.c.a.a("remove: ".concat(java.lang.String.valueOf(hashSet)));
                }
            }
            com.getui.gtc.dyc.b.a.a(com.getui.gtc.base.GtcProvider.context(), new com.getui.gtc.extension.c.AnonymousClass1().c);
        } catch (java.lang.Throwable th) {
            com.getui.gtc.h.c.a.c(th);
        }
    }

    public /* synthetic */ c(byte b) {
        this();
    }

    private void b(com.getui.gtc.api.SdkInfo sdkInfo) {
        java.util.List<com.getui.gtc.entity.a.C0306a> stubs = sdkInfo.getStubs();
        for (int i = 0; i < stubs.size(); i++) {
            com.getui.gtc.entity.a.C0306a c0306a = stubs.get(i);
            if (!b(c0306a)) {
                this.c.put(c0306a.d, c0306a);
                if (c0306a.j) {
                    com.getui.gtc.extension.b.a(com.getui.gtc.base.GtcProvider.context(), null, null, c0306a.d, sdkInfo.getAppid(), sdkInfo.getCid(), new com.getui.gtc.extension.c.AnonymousClass2(c0306a));
                } else {
                    try {
                        com.getui.gtc.extension.b.a(com.getui.gtc.base.GtcProvider.context(), c0306a.d, sdkInfo.getAppid(), sdkInfo.getCid());
                    } catch (java.lang.Throwable th) {
                        this.c.remove(c0306a.d);
                        com.getui.gtc.h.c.a.b("local gtcFile failed: ".concat(java.lang.String.valueOf(th)));
                    }
                }
            }
        }
    }

    private boolean b(com.getui.gtc.entity.a.C0306a c0306a) {
        return this.c.containsKey(c0306a.d);
    }

    private com.getui.gtc.entity.a c(com.getui.gtc.api.SdkInfo sdkInfo) {
        java.util.Map<java.lang.String, java.lang.String> a2 = com.getui.gtc.f.c.a(sdkInfo, new com.getui.gtc.extension.c.AnonymousClass3(sdkInfo));
        if (a2 == null) {
            return null;
        }
        return com.getui.gtc.entity.a.a(a2);
    }

    private static boolean c(com.getui.gtc.entity.a.C0306a c0306a) {
        c0306a.d.endsWith(".gws.stub.PushExtension");
        return false;
    }

    public final java.lang.String a(com.getui.gtc.api.SdkInfo sdkInfo, com.getui.gtc.entity.a.C0306a c0306a) {
        com.getui.gtc.entity.a a2;
        com.getui.gtc.entity.a.C0306a b;
        java.io.File file = new java.io.File(this.b + java.io.File.separator + c0306a.c);
        if (a(c0306a)) {
            return file.getAbsolutePath();
        }
        try {
            java.util.Map<java.lang.String, java.lang.String> a3 = com.getui.gtc.dyc.b.a.a(com.getui.gtc.base.GtcProvider.context(), sdkInfo.getModuleName());
            if (a3 == null || (a2 = com.getui.gtc.entity.a.a(a3)) == null || (b = a2.b(c0306a.a)) == null || !b.e.equals(c0306a.e)) {
                return null;
            }
            com.getui.gtc.g.b.a(c0306a, file.getAbsolutePath());
            if (com.getui.gtc.h.b.a.a(file.getAbsolutePath()).equals(c0306a.e)) {
                return file.getAbsolutePath();
            }
            com.getui.gtc.h.b.a.a(file);
            throw new java.lang.Exception("The net gtcFile save failed or has a wrong checksum");
        } catch (java.lang.Exception e) {
            com.getui.gtc.h.c.a.b(e);
            return null;
        }
    }

    public final void a(com.getui.gtc.api.SdkInfo sdkInfo) {
        b(sdkInfo);
        a(sdkInfo, c(sdkInfo));
    }

    public final void a(com.getui.gtc.api.SdkInfo sdkInfo, com.getui.gtc.entity.a aVar) {
        com.getui.gtc.e.c cVar;
        if (aVar == null) {
            return;
        }
        java.util.ArrayList<java.lang.Integer> arrayList = new java.util.ArrayList();
        for (int i = 0; i < aVar.a.size(); i++) {
            com.getui.gtc.entity.a.C0306a a2 = aVar.a(i);
            if (!aVar.b && c(a2)) {
                com.getui.gtc.h.c.a.a("no push, no gws");
            } else if (!b(a2)) {
                cVar = com.getui.gtc.e.c.a.a;
                long a3 = cVar.b.a(a2.a);
                if ((a2.g <= 0 || a3 <= 0 || java.lang.System.currentTimeMillis() - a3 <= a2.g) && (a3 <= 0 || !a2.i)) {
                    this.c.put(a2.d, a2);
                    com.getui.gtc.base.util.ScheduleQueue.getInstance().addSchedule(new com.getui.gtc.extension.c.AnonymousClass4(sdkInfo, a2, a3));
                } else {
                    arrayList.add(java.lang.Integer.valueOf(i));
                }
            }
        }
        for (java.lang.Integer num : arrayList) {
            a(aVar.a(num.intValue()).c);
            aVar.c(num.intValue());
        }
    }

    public final boolean a(com.getui.gtc.entity.a.C0306a c0306a) {
        java.io.File file = new java.io.File(this.b + java.io.File.separator + c0306a.c);
        if (file.exists() && file.isFile()) {
            return com.getui.gtc.h.b.a.a(file.getAbsolutePath()).equals(c0306a.e);
        }
        return false;
    }

    public final boolean a(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            com.getui.gtc.h.b.a.a(this.a, str);
            java.lang.String a2 = com.getui.gtc.extension.a.a(str);
            if (android.text.TextUtils.isEmpty(a2)) {
                return true;
            }
            com.getui.gtc.h.b.a.a(new java.io.File(this.a + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + a2));
            return true;
        } catch (java.lang.Exception e) {
            com.getui.gtc.h.c.a.c(e);
            return false;
        }
    }
}
