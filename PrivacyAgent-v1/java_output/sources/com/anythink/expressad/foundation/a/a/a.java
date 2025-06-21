package com.anythink.expressad.foundation.a.a;

/* loaded from: classes12.dex */
public class a {
    public static final java.lang.String a = "a";
    private static volatile com.anythink.expressad.foundation.a.a.a c;
    android.content.SharedPreferences b;

    private a() {
    }

    public static com.anythink.expressad.foundation.a.a.a a() {
        if (c == null) {
            synchronized (com.anythink.expressad.foundation.a.a.a.class) {
                if (c == null) {
                    c = new com.anythink.expressad.foundation.a.a.a();
                }
            }
        }
        return c;
    }

    private void a(java.lang.String str, int i) {
        try {
            android.content.Context d = com.anythink.expressad.foundation.b.a.b().d();
            if (d == null) {
                return;
            }
            if (this.b == null) {
                this.b = d.getSharedPreferences(com.anythink.expressad.foundation.g.a.o, 0);
            }
            android.content.SharedPreferences.Editor edit = this.b.edit();
            edit.putInt(str, i);
            edit.apply();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    private void a(java.lang.String str, long j) {
        try {
            android.content.Context d = com.anythink.expressad.foundation.b.a.b().d();
            if (d == null) {
                return;
            }
            if (this.b == null) {
                this.b = d.getSharedPreferences(com.anythink.expressad.foundation.g.a.o, 0);
            }
            android.content.SharedPreferences.Editor edit = this.b.edit();
            edit.putLong(str, j);
            edit.apply();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    private int b(java.lang.String str, int i) {
        try {
            android.content.Context d = com.anythink.expressad.foundation.b.a.b().d();
            if (d == null) {
                return i;
            }
            if (this.b == null) {
                this.b = d.getSharedPreferences(com.anythink.expressad.foundation.g.a.o, 0);
            }
            return this.b.getInt(str, i);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return i;
        }
    }

    private java.util.List<java.lang.String> b() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        android.content.Context d = com.anythink.expressad.foundation.b.a.b().d();
        if (d == null) {
            return null;
        }
        if (this.b == null) {
            this.b = d.getSharedPreferences(com.anythink.expressad.foundation.g.a.o, 0);
        }
        java.util.Iterator<java.util.Map.Entry<java.lang.String, ?>> it = this.b.getAll().entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getKey());
        }
        return arrayList;
    }

    private int c(java.lang.String str) {
        try {
            android.content.Context d = com.anythink.expressad.foundation.b.a.b().d();
            if (d == null) {
                return 0;
            }
            if (this.b == null) {
                this.b = d.getSharedPreferences(com.anythink.expressad.foundation.g.a.o, 0);
            }
            return this.b.getInt(str, 0);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    private java.lang.Long d(java.lang.String str) {
        try {
            android.content.Context d = com.anythink.expressad.foundation.b.a.b().d();
            if (d == null) {
                return 0L;
            }
            if (this.b == null) {
                this.b = d.getSharedPreferences(com.anythink.expressad.foundation.g.a.o, 0);
            }
            return java.lang.Long.valueOf(this.b.getLong(str, 0L));
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public final java.lang.String a(java.lang.String str) {
        try {
            android.content.Context d = com.anythink.expressad.foundation.b.a.b().d();
            if (d == null) {
                return null;
            }
            if (this.b == null) {
                this.b = d.getSharedPreferences(com.anythink.expressad.foundation.g.a.o, 0);
            }
            return this.b.getString(str, "");
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final void a(java.lang.String str, java.lang.String str2) {
        try {
            android.content.Context d = com.anythink.expressad.foundation.b.a.b().d();
            if (d == null) {
                return;
            }
            if (this.b == null) {
                this.b = d.getSharedPreferences(com.anythink.expressad.foundation.g.a.o, 0);
            }
            android.content.SharedPreferences.Editor edit = this.b.edit();
            edit.putString(str, str2);
            edit.apply();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public final void b(java.lang.String str) {
        android.content.Context d = com.anythink.expressad.foundation.b.a.b().d();
        if (d == null) {
            return;
        }
        if (this.b == null) {
            this.b = d.getSharedPreferences(com.anythink.expressad.foundation.g.a.o, 0);
        }
        this.b.edit().remove(str).apply();
    }
}
