package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class ap extends java.lang.Thread {
    private android.content.Context a;
    private com.amap.api.mapcore.util.bb b;

    public ap(android.content.Context context) {
        this.a = context;
        this.b = com.amap.api.mapcore.util.bb.a(context);
    }

    private static com.amap.api.mapcore.util.aw a(java.io.File file) {
        java.lang.String a = com.amap.api.mapcore.util.dl.a(file);
        com.amap.api.mapcore.util.aw awVar = new com.amap.api.mapcore.util.aw();
        awVar.b(a);
        return awVar;
    }

    private com.amap.api.mapcore.util.aw a(java.lang.String str) {
        if (str.equals("quanguo")) {
            str = "quanguogaiyaotu";
        }
        com.amap.api.mapcore.util.am a = com.amap.api.mapcore.util.am.a(this.a);
        com.amap.api.mapcore.util.aw awVar = null;
        if (a != null) {
            java.lang.String g = a.g(str);
            java.io.File[] listFiles = new java.io.File(com.amap.api.mapcore.util.dl.c(this.a)).listFiles();
            if (listFiles == null) {
                return null;
            }
            for (java.io.File file : listFiles) {
                if ((file.getName().contains(g) || file.getName().contains(str)) && file.getName().endsWith(".zip.tmp.dt")) {
                    awVar = a(file);
                    if (awVar.c() != null) {
                        return awVar;
                    }
                }
            }
        }
        return awVar;
    }

    private void a() {
        com.amap.api.mapcore.util.aw a;
        java.lang.String b;
        int indexOf;
        boolean z;
        java.lang.String b2;
        int indexOf2;
        java.lang.String b3;
        int indexOf3;
        java.util.ArrayList<java.lang.String> arrayList = new java.util.ArrayList<>();
        java.util.ArrayList<com.amap.api.mapcore.util.aw> a2 = this.b.a();
        a(arrayList, "vmap/");
        a(arrayList, "map/");
        b(arrayList, "map/");
        java.util.ArrayList<java.lang.String> b4 = b();
        java.util.Iterator<com.amap.api.mapcore.util.aw> it = a2.iterator();
        while (it.hasNext()) {
            com.amap.api.mapcore.util.aw next = it.next();
            if (next != null && next.c() != null) {
                int i = next.l;
                boolean z2 = true;
                if (i == 4 || i == 7) {
                    boolean contains = arrayList.contains(next.h());
                    if (contains || (b = com.amap.api.mapcore.util.bj.b(next.f())) == null || (indexOf = arrayList.indexOf(b)) == -1) {
                        z2 = contains;
                    } else {
                        arrayList.set(indexOf, next.h());
                    }
                    if (!z2) {
                        this.b.b(next);
                    }
                } else {
                    if (i == 0 || i == 1) {
                        z = b4.contains(next.e()) || b4.contains(next.h());
                        if (z || (b2 = com.amap.api.mapcore.util.bj.b(next.f())) == null || (indexOf2 = b4.indexOf(b2)) == -1) {
                            z2 = z;
                        } else {
                            b4.set(indexOf2, next.h());
                        }
                        if (!z2) {
                            this.b.b(next);
                        }
                    } else if (i == 3 && next.g() != 0) {
                        z = b4.contains(next.e()) || b4.contains(next.h());
                        if (z || (b3 = com.amap.api.mapcore.util.bj.b(next.f())) == null || (indexOf3 = b4.indexOf(b3)) == -1) {
                            z2 = z;
                        } else {
                            b4.set(indexOf3, next.h());
                        }
                        if (!z2) {
                            this.b.b(next);
                        }
                    }
                }
            }
        }
        java.util.Iterator<java.lang.String> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            java.lang.String next2 = it2.next();
            if (!a(next2, a2) && (a = a(next2)) != null) {
                this.b.a(a);
            }
        }
        com.amap.api.mapcore.util.am a3 = com.amap.api.mapcore.util.am.a(this.a);
        if (a3 != null) {
            a3.b();
        }
    }

    private void a(java.util.ArrayList<java.lang.String> arrayList, java.lang.String str) {
        java.io.File[] listFiles;
        java.lang.String name;
        int lastIndexOf;
        java.io.File file = new java.io.File(com.amap.api.mapcore.util.dl.b(this.a) + str);
        if (file.exists() && (listFiles = file.listFiles()) != null) {
            for (java.io.File file2 : listFiles) {
                if (file2.getName().endsWith(".dat") && (lastIndexOf = (name = file2.getName()).lastIndexOf(46)) >= 0 && lastIndexOf < name.length()) {
                    java.lang.String substring = name.substring(0, lastIndexOf);
                    if (!arrayList.contains(substring)) {
                        arrayList.add(substring);
                    }
                }
            }
        }
    }

    private static boolean a(java.lang.String str, java.util.ArrayList<com.amap.api.mapcore.util.aw> arrayList) {
        java.util.Iterator<com.amap.api.mapcore.util.aw> it = arrayList.iterator();
        while (it.hasNext()) {
            if (str.equals(it.next().h())) {
                return true;
            }
        }
        return false;
    }

    private java.util.ArrayList<java.lang.String> b() {
        java.io.File[] listFiles;
        java.lang.String name;
        int lastIndexOf;
        java.util.ArrayList<java.lang.String> arrayList = new java.util.ArrayList<>();
        java.io.File file = new java.io.File(com.amap.api.mapcore.util.dl.c(this.a));
        if (!file.exists() || (listFiles = file.listFiles()) == null) {
            return arrayList;
        }
        for (java.io.File file2 : listFiles) {
            if (file2.getName().endsWith(".zip") && (lastIndexOf = (name = file2.getName()).lastIndexOf(46)) >= 0 && lastIndexOf < name.length()) {
                arrayList.add(name.substring(0, lastIndexOf));
            }
        }
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x0086, code lost:
    
        if (r10 != false) goto L41;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x008f A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(java.util.ArrayList<java.lang.String> arrayList, java.lang.String str) {
        java.io.File[] listFiles;
        java.lang.String[] list;
        java.io.File file = new java.io.File(com.amap.api.mapcore.util.dl.a(this.a) + str);
        if (file.exists() && (listFiles = file.listFiles()) != null) {
            for (java.io.File file2 : listFiles) {
                if (file2.isDirectory()) {
                    java.lang.String name = file2.getName();
                    if (!android.text.TextUtils.isEmpty(name) && (list = file2.list()) != null && list.length > 0 && !arrayList.contains(name)) {
                        boolean z = true;
                        if (name.equals("a0")) {
                            for (java.lang.String str2 : list) {
                                if ("m1.ans".equals(str2)) {
                                    break;
                                }
                            }
                            z = false;
                            if (!z) {
                                arrayList.add(name);
                            }
                        } else {
                            boolean z2 = false;
                            boolean z3 = false;
                            for (java.lang.String str3 : list) {
                                if ("m1.ans".equals(str3)) {
                                    z2 = true;
                                }
                                if ("m3.ans".equals(str3)) {
                                    z3 = true;
                                }
                            }
                            if (z2) {
                            }
                            z = false;
                            if (!z) {
                            }
                        }
                    }
                }
            }
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        try {
            a();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }
}
