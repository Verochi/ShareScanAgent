package com.xiaomi.a.c;

/* loaded from: classes19.dex */
public class d implements com.xiaomi.a.c.b {
    protected android.content.Context a;
    private java.util.HashMap<java.lang.String, java.util.HashMap<java.lang.String, com.xiaomi.a.a.d>> b;

    public d(android.content.Context context) {
        this.a = context;
    }

    @Override // com.xiaomi.a.c.e
    public final void a() {
        com.xiaomi.push.as.a(this.a, "perf", "perfUploading");
        java.io.File[] b = com.xiaomi.push.as.b(this.a, "perfUploading");
        if (b == null || b.length <= 0) {
            return;
        }
        for (java.io.File file : b) {
            if (file != null) {
                java.util.List<java.lang.String> a = com.xiaomi.a.c.g.a(file.getAbsolutePath());
                file.delete();
                a(a);
            }
        }
    }

    @Override // com.xiaomi.a.c.f
    public final void a(com.xiaomi.a.a.d dVar) {
        if ((dVar instanceof com.xiaomi.a.a.c) && this.b != null) {
            com.xiaomi.a.a.c cVar = (com.xiaomi.a.a.c) dVar;
            java.lang.String str = java.lang.String.valueOf(cVar.e) + "#" + cVar.f;
            java.lang.String a = com.xiaomi.a.c.g.a(cVar);
            java.util.HashMap<java.lang.String, com.xiaomi.a.a.d> hashMap = this.b.get(str);
            if (hashMap == null) {
                hashMap = new java.util.HashMap<>();
            }
            com.xiaomi.a.a.c cVar2 = (com.xiaomi.a.a.c) hashMap.get(a);
            if (cVar2 != null) {
                cVar.b += cVar2.b;
                cVar.c += cVar2.c;
            }
            hashMap.put(a, cVar);
            this.b.put(str, hashMap);
        }
    }

    @Override // com.xiaomi.a.c.b
    public final void a(java.util.HashMap<java.lang.String, java.util.HashMap<java.lang.String, com.xiaomi.a.a.d>> hashMap) {
        this.b = hashMap;
    }

    public void a(java.util.List<java.lang.String> list) {
        com.xiaomi.push.as.a(this.a, list);
    }

    @Override // com.xiaomi.a.c.f
    public final void b() {
        java.lang.String str;
        java.lang.String absolutePath;
        java.util.HashMap<java.lang.String, java.util.HashMap<java.lang.String, com.xiaomi.a.a.d>> hashMap = this.b;
        if (hashMap == null) {
            return;
        }
        if (hashMap.size() > 0) {
            java.util.Iterator<java.lang.String> it = this.b.keySet().iterator();
            while (it.hasNext()) {
                java.util.HashMap<java.lang.String, com.xiaomi.a.a.d> hashMap2 = this.b.get(it.next());
                if (hashMap2 != null && hashMap2.size() > 0) {
                    com.xiaomi.a.a.d[] dVarArr = new com.xiaomi.a.a.d[hashMap2.size()];
                    hashMap2.values().toArray(dVarArr);
                    int i = 0;
                    com.xiaomi.a.a.d dVar = dVarArr[0];
                    int i2 = dVar.e;
                    java.lang.String str2 = dVar.f;
                    if (i2 <= 0 || android.text.TextUtils.isEmpty(str2)) {
                        str = "";
                    } else {
                        str = java.lang.String.valueOf(i2) + "#" + str2;
                    }
                    java.io.File externalFilesDir = this.a.getExternalFilesDir("perf");
                    java.lang.String str3 = null;
                    if (externalFilesDir == null) {
                        com.xiaomi.channel.commonutils.logger.b.d("cannot get folder when to write perf");
                        absolutePath = null;
                    } else {
                        if (!externalFilesDir.exists()) {
                            externalFilesDir.mkdirs();
                        }
                        absolutePath = new java.io.File(externalFilesDir, str).getAbsolutePath();
                    }
                    if (!android.text.TextUtils.isEmpty(absolutePath)) {
                        while (true) {
                            if (i >= 20) {
                                break;
                            }
                            java.lang.String str4 = absolutePath + i;
                            if (com.xiaomi.push.as.a(this.a, str4)) {
                                str3 = str4;
                                break;
                            }
                            i++;
                        }
                    }
                    if (!android.text.TextUtils.isEmpty(str3)) {
                        com.xiaomi.a.c.g.a(str3, dVarArr);
                    }
                }
            }
        }
        this.b.clear();
    }
}
