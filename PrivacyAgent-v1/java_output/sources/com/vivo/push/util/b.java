package com.vivo.push.util;

/* loaded from: classes19.dex */
public class b {
    protected android.content.Context a;
    private java.lang.String b;
    private volatile android.content.SharedPreferences c;
    private java.util.HashMap<java.lang.String, java.lang.String> d = new java.util.HashMap<>();
    private java.util.HashMap<java.lang.String, java.lang.Long> e = new java.util.HashMap<>();
    private java.util.HashMap<java.lang.String, java.lang.Integer> f = new java.util.HashMap<>();
    private java.util.HashMap<java.lang.String, java.lang.Boolean> g = new java.util.HashMap<>();

    public static void a(android.content.SharedPreferences.Editor editor) {
        if (editor == null) {
            return;
        }
        if (android.os.Looper.myLooper() == android.os.Looper.getMainLooper()) {
            editor.apply();
        } else {
            editor.commit();
        }
    }

    private void a(java.util.Map<java.lang.String, java.lang.String> map) {
        if (map.size() > 0) {
            b();
            if (this.c != null) {
                android.content.SharedPreferences.Editor edit = this.c.edit();
                for (java.lang.String str : map.keySet()) {
                    java.lang.String str2 = map.get(str);
                    this.d.put(str, str2);
                    edit.putString(str, str2);
                }
                a(edit);
            }
        }
    }

    private void b() {
        if (this.c == null) {
            android.content.Context context = this.a;
            if (context == null) {
                throw new java.lang.RuntimeException("SharedPreferences is not init", new java.lang.Throwable());
            }
            this.c = context.getSharedPreferences(this.b, 0);
        }
    }

    private java.util.List<java.lang.String> c(java.lang.String str) {
        java.lang.Object a;
        java.lang.String[] split;
        if (this.a == null) {
            com.vivo.push.util.p.c("BaseSharePreference", " parsLocalIv error mContext is null ");
            return null;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        try {
            android.content.Context context = this.a;
            a = com.vivo.push.util.z.a(context, context.getPackageName(), str);
        } catch (java.lang.Exception e) {
            com.vivo.push.util.p.c("BaseSharePreference", " parsLocalIv error e =" + e.getMessage());
            e.printStackTrace();
        }
        if (a == null) {
            return null;
        }
        java.lang.String str2 = new java.lang.String(android.util.Base64.decode(a.toString(), 2));
        if (!android.text.TextUtils.isEmpty(str2) && (split = str2.split(",#@")) != null && split.length >= 4) {
            for (java.lang.String str3 : split) {
                arrayList.add(str3.replace(",#@", ""));
            }
            if (arrayList.size() >= 4) {
                return arrayList;
            }
        }
        return null;
    }

    public final int a(java.lang.String str) {
        java.lang.Integer num = this.f.get(str);
        if (num != null) {
            return num.intValue();
        }
        b();
        if (this.c != null) {
            num = java.lang.Integer.valueOf(this.c.getInt(str, 0));
            if (!num.equals(0)) {
                this.f.put(str, num);
            }
        }
        return num.intValue();
    }

    public final void a() {
        this.e.clear();
        this.f.clear();
        this.g.clear();
        this.d.clear();
        b();
        if (this.c != null) {
            android.content.SharedPreferences.Editor edit = this.c.edit();
            edit.clear();
            a(edit);
        }
    }

    public final void a(android.content.Context context, java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            throw new java.lang.RuntimeException("sharedFileName can't be null");
        }
        this.b = str;
        this.c = context.getSharedPreferences(str, 0);
        this.a = context;
        java.util.List<java.lang.String> c = c("local_iv");
        if (c == null || c.size() < 4) {
            com.vivo.push.util.p.a("BaseSharePreference", " initSecureCode error list is null ");
            return;
        }
        java.util.HashMap hashMap = new java.util.HashMap();
        hashMap.put("com.vivo.push.secure_sub_iv", c.get(1));
        hashMap.put("com.vivo.push.secure_sub_key", c.get(2));
        hashMap.put("com.vivo.push.secure_cache_iv", c.get(3));
        hashMap.put("com.vivo.push.secure_cache_key", c.get(0));
        a(hashMap);
    }

    public final void a(java.lang.String str, int i) {
        this.f.put(str, java.lang.Integer.valueOf(i));
        b();
        if (this.c != null) {
            android.content.SharedPreferences.Editor edit = this.c.edit();
            edit.putInt(str, i);
            a(edit);
        }
    }

    public final void a(java.lang.String str, long j) {
        this.e.put(str, java.lang.Long.valueOf(j));
        b();
        if (this.c != null) {
            android.content.SharedPreferences.Editor edit = this.c.edit();
            edit.putLong(str, j);
            a(edit);
        }
    }

    public final void a(java.lang.String str, java.lang.String str2) {
        this.d.put(str, str2);
        b();
        if (this.c != null) {
            android.content.SharedPreferences.Editor edit = this.c.edit();
            edit.putString(str, str2);
            a(edit);
        }
    }

    public final long b(java.lang.String str, long j) {
        java.lang.Long l = this.e.get(str);
        if (l != null) {
            return l.longValue();
        }
        b();
        if (this.c != null) {
            l = java.lang.Long.valueOf(this.c.getLong(str, j));
            if (!l.equals(java.lang.Long.valueOf(j))) {
                this.e.put(str, l);
            }
        }
        return l.longValue();
    }

    public final java.lang.String b(java.lang.String str, java.lang.String str2) {
        java.lang.String str3 = this.d.get(str);
        if (str3 != null) {
            return str3;
        }
        b();
        if (this.c != null) {
            str3 = this.c.getString(str, str2);
            if (!android.text.TextUtils.isEmpty(str3) && !str3.equals(str2)) {
                this.d.put(str, str3);
            }
        }
        return str3;
    }

    public final void b(java.lang.String str) {
        this.e.remove(str);
        this.f.remove(str);
        this.g.remove(str);
        this.d.remove(str);
        b();
        if (this.c != null) {
            android.content.SharedPreferences.Editor edit = this.c.edit();
            if (this.c.contains(str)) {
                edit.remove(str);
                a(edit);
            }
        }
    }
}
