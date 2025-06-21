package com.xiaomi.push.service;

/* loaded from: classes19.dex */
public class ad {
    private static volatile com.xiaomi.push.service.ad c;
    protected android.content.SharedPreferences a;
    protected android.content.SharedPreferences b;
    private java.util.HashSet<com.xiaomi.push.service.ad.a> d = new java.util.HashSet<>();

    public static abstract class a implements java.lang.Runnable {
        private java.lang.String mDescription;
        private int mId;

        public a(int i, java.lang.String str) {
            this.mId = i;
            this.mDescription = str;
        }

        public boolean equals(java.lang.Object obj) {
            return (obj instanceof com.xiaomi.push.service.ad.a) && this.mId == ((com.xiaomi.push.service.ad.a) obj).mId;
        }

        public int hashCode() {
            return this.mId;
        }

        public abstract void onCallback();

        @Override // java.lang.Runnable
        public final void run() {
            onCallback();
        }
    }

    private ad(android.content.Context context) {
        this.a = context.getSharedPreferences("mipush_oc_normal", 0);
        this.b = context.getSharedPreferences("mipush_oc_custom", 0);
    }

    public static com.xiaomi.push.service.ad a(android.content.Context context) {
        if (c == null) {
            synchronized (com.xiaomi.push.service.ad.class) {
                if (c == null) {
                    c = new com.xiaomi.push.service.ad(context);
                }
            }
        }
        return c;
    }

    private static java.lang.String a(com.xiaomi.push.gq gqVar) {
        return "oc_version_" + gqVar.c;
    }

    private static void a(android.content.SharedPreferences.Editor editor, android.util.Pair<java.lang.Integer, java.lang.Object> pair, java.lang.String str) {
        java.lang.Object obj = pair.second;
        if (obj instanceof java.lang.Integer) {
            editor.putInt(str, ((java.lang.Integer) obj).intValue());
            return;
        }
        if (obj instanceof java.lang.Long) {
            editor.putLong(str, ((java.lang.Long) obj).longValue());
            return;
        }
        if (!(obj instanceof java.lang.String)) {
            if (obj instanceof java.lang.Boolean) {
                editor.putBoolean(str, ((java.lang.Boolean) obj).booleanValue());
            }
        } else {
            java.lang.String str2 = (java.lang.String) obj;
            if (str.equals(b(com.xiaomi.push.gp.AppIsInstalledList.bw))) {
                editor.putString(str, com.xiaomi.push.al.a(str2));
            } else {
                editor.putString(str, str2);
            }
        }
    }

    private static java.lang.String b(int i) {
        return "oc_".concat(java.lang.String.valueOf(i));
    }

    public final int a(int i, int i2) {
        try {
            java.lang.String b = b(i);
            return this.b.contains(b) ? this.b.getInt(b, 0) : this.a.contains(b) ? this.a.getInt(b, 0) : i2;
        } catch (java.lang.Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(i + " oc int error " + e);
            return i2;
        }
    }

    public final int a(com.xiaomi.push.gq gqVar, int i) {
        try {
            return this.a.getInt(a(gqVar), i);
        } catch (java.lang.Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(gqVar + " version error " + e);
            return i;
        }
    }

    public final long a(int i) {
        try {
            java.lang.String b = b(i);
            if (this.b.contains(b)) {
                return this.b.getLong(b, 0L);
            }
            if (this.a.contains(b)) {
                return this.a.getLong(b, 0L);
            }
            return 777600000L;
        } catch (java.lang.Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(i + " oc long error " + e);
            return 777600000L;
        }
    }

    public final java.lang.String a(int i, java.lang.String str) {
        try {
            java.lang.String b = b(i);
            return this.b.contains(b) ? this.b.getString(b, null) : this.a.contains(b) ? this.a.getString(b, null) : str;
        } catch (java.lang.Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(i + " oc string error " + e);
            return str;
        }
    }

    public final synchronized void a() {
        this.d.clear();
    }

    public final synchronized void a(com.xiaomi.push.service.ad.a aVar) {
        if (!this.d.contains(aVar)) {
            this.d.add(aVar);
        }
    }

    public final void a(java.util.List<android.util.Pair<java.lang.Integer, java.lang.Object>> list) {
        if (com.xiaomi.push.h.a(list)) {
            return;
        }
        android.content.SharedPreferences.Editor edit = this.b.edit();
        for (android.util.Pair<java.lang.Integer, java.lang.Object> pair : list) {
            java.lang.Object obj = pair.first;
            if (obj != null) {
                java.lang.String b = b(((java.lang.Integer) obj).intValue());
                if (pair.second == null) {
                    edit.remove(b);
                } else {
                    a(edit, pair, b);
                }
            }
        }
        edit.apply();
    }

    public final void a(java.util.List<android.util.Pair<com.xiaomi.push.gq, java.lang.Integer>> list, java.util.List<android.util.Pair<java.lang.Integer, java.lang.Object>> list2) {
        if (com.xiaomi.push.h.a(list) || com.xiaomi.push.h.a(list2)) {
            com.xiaomi.channel.commonutils.logger.b.a("not update oc, because versions or configs are empty");
            return;
        }
        android.content.SharedPreferences.Editor edit = this.a.edit();
        edit.clear();
        for (android.util.Pair<com.xiaomi.push.gq, java.lang.Integer> pair : list) {
            java.lang.Object obj = pair.first;
            if (obj != null && pair.second != null) {
                edit.putInt(a((com.xiaomi.push.gq) obj), ((java.lang.Integer) pair.second).intValue());
            }
        }
        for (android.util.Pair<java.lang.Integer, java.lang.Object> pair2 : list2) {
            java.lang.Object obj2 = pair2.first;
            if (obj2 != null && pair2.second != null) {
                a(edit, pair2, b(((java.lang.Integer) obj2).intValue()));
            }
        }
        edit.apply();
    }

    public final boolean a(int i, boolean z) {
        try {
            java.lang.String b = b(i);
            return this.b.contains(b) ? this.b.getBoolean(b, false) : this.a.contains(b) ? this.a.getBoolean(b, false) : z;
        } catch (java.lang.Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(i + " oc boolean error " + e);
            return z;
        }
    }

    public final void b() {
        com.xiaomi.channel.commonutils.logger.b.c("OC_Callback : receive new oc data");
        java.util.HashSet hashSet = new java.util.HashSet();
        synchronized (this) {
            hashSet.addAll(this.d);
        }
        java.util.Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            com.xiaomi.push.service.ad.a aVar = (com.xiaomi.push.service.ad.a) it.next();
            if (aVar != null) {
                aVar.run();
            }
        }
        hashSet.clear();
    }
}
