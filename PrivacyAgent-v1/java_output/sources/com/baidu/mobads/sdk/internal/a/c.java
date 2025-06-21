package com.baidu.mobads.sdk.internal.a;

/* loaded from: classes.dex */
public class c implements com.baidu.mobads.sdk.internal.a.a {
    public static final java.lang.String a = "ViewPager2";
    public static final java.lang.String b = "RVAdapter";
    public static final java.lang.String c = "RVViewHolder";
    public static final java.lang.String d = "ViewCompat";
    public static final java.lang.String e = "Fragment";
    public static final java.lang.String f = "FragmentV4";
    public static final java.lang.String g = "RLRecyclerView";
    public static final java.lang.String h = "p_e";
    private static final java.lang.String i = "p_init";
    private static final java.lang.String j = "p_set_class";
    private static final java.lang.String k = "e_t";
    private static final java.lang.String l = "e_n";
    private static final java.lang.String m = "e_a";
    private static final java.lang.String n = "e_r";
    private static final java.lang.String o = "e_d";
    private final com.baidu.mobads.sdk.api.IAdInterListener p;

    public static class a implements com.baidu.mobads.sdk.api.IOAdEventListener {
        private com.baidu.mobads.sdk.internal.a.a a(java.lang.String str, @androidx.annotation.NonNull com.baidu.mobads.sdk.api.IAdInterListener iAdInterListener, java.lang.Object[] objArr) {
            if (com.baidu.mobads.sdk.internal.a.c.a.equals(str) && com.baidu.mobads.sdk.internal.a.c.a(objArr, (java.lang.Class<?>[]) new java.lang.Class[]{android.content.Context.class})) {
                return new com.baidu.mobads.sdk.internal.concrete.ViewPager2Delegate(iAdInterListener, (android.content.Context) objArr[0]);
            }
            if (com.baidu.mobads.sdk.internal.a.c.b.equals(str)) {
                return new com.baidu.mobads.sdk.internal.concrete.RVAdapterDelegate(iAdInterListener);
            }
            if (com.baidu.mobads.sdk.internal.a.c.c.equals(str) && com.baidu.mobads.sdk.internal.a.c.a(objArr, (java.lang.Class<?>[]) new java.lang.Class[]{android.view.View.class})) {
                return new com.baidu.mobads.sdk.internal.concrete.RVViewHolderDelegate(iAdInterListener, (android.view.View) objArr[0]);
            }
            if (com.baidu.mobads.sdk.internal.a.c.d.equals(str)) {
                return new com.baidu.mobads.sdk.internal.concrete.ViewCompatDelegate(iAdInterListener);
            }
            if (com.baidu.mobads.sdk.internal.a.c.e.equals(str)) {
                return new com.baidu.mobads.sdk.internal.concrete.FragmentDelegate().setDispatcher(iAdInterListener);
            }
            if (com.baidu.mobads.sdk.internal.a.c.f.equals(str)) {
                return new com.baidu.mobads.sdk.internal.concrete.FragmentV4Delegate().setDispatcher(iAdInterListener);
            }
            if (com.baidu.mobads.sdk.internal.a.c.g.equals(str)) {
                return new com.baidu.mobads.sdk.internal.concrete.RLRecyclerViewDelegate(iAdInterListener, objArr);
            }
            return null;
        }

        @Override // com.baidu.mobads.sdk.api.IOAdEventListener
        public void run(com.baidu.mobads.sdk.api.IOAdEvent iOAdEvent) {
            java.util.Map<java.lang.String, java.lang.Object> data;
            com.baidu.mobads.sdk.internal.a.a a;
            if (iOAdEvent != null) {
                try {
                    if (com.baidu.mobads.sdk.internal.a.c.h.equals(iOAdEvent.getType()) && (data = iOAdEvent.getData()) != null && !data.isEmpty()) {
                        java.lang.Object obj = data.get(com.baidu.mobads.sdk.internal.a.c.k);
                        java.lang.Object obj2 = data.get(com.baidu.mobads.sdk.internal.a.c.l);
                        java.lang.Object obj3 = data.get(com.baidu.mobads.sdk.internal.a.c.m);
                        java.lang.Object[] objArr = obj3 instanceof java.lang.Object[] ? (java.lang.Object[]) obj3 : null;
                        if ((obj2 instanceof java.lang.String) && (obj instanceof java.lang.String)) {
                            if (com.baidu.mobads.sdk.internal.a.c.i.equals((java.lang.String) obj2)) {
                                java.lang.Object obj4 = data.get(com.baidu.mobads.sdk.internal.a.c.o);
                                if (!(obj4 instanceof com.baidu.mobads.sdk.api.IAdInterListener) || (a = a((java.lang.String) obj, (com.baidu.mobads.sdk.api.IAdInterListener) obj4, objArr)) == null) {
                                    return;
                                }
                                data.put(com.baidu.mobads.sdk.internal.a.c.n, a);
                                return;
                            }
                            if (com.baidu.mobads.sdk.internal.a.c.j.equals((java.lang.String) obj2) && (obj3 instanceof java.util.Map)) {
                                java.util.Map map = (java.util.Map) obj3;
                                map.put(com.baidu.mobads.sdk.internal.a.c.a, com.baidu.mobads.sdk.internal.widget.ViewPager2.class);
                                map.put(com.baidu.mobads.sdk.internal.a.c.b, androidx.recyclerview.widget.RecyclerView.Adapter.class);
                                map.put(com.baidu.mobads.sdk.internal.a.c.c, androidx.recyclerview.widget.RecyclerView.ViewHolder.class);
                            }
                        }
                    }
                } catch (java.lang.Throwable th) {
                    com.baidu.mobads.sdk.internal.bt.a().b(th.getMessage());
                }
            }
        }
    }

    private c(@androidx.annotation.NonNull com.baidu.mobads.sdk.api.IAdInterListener iAdInterListener, @androidx.annotation.NonNull com.baidu.mobads.sdk.internal.a.a aVar) {
        this.p = iAdInterListener;
        iAdInterListener.addEventListener(h, new com.baidu.mobads.sdk.internal.a.d(this, aVar));
    }

    public static com.baidu.mobads.sdk.internal.a.c a(@androidx.annotation.NonNull com.baidu.mobads.sdk.api.IAdInterListener iAdInterListener, @androidx.annotation.NonNull com.baidu.mobads.sdk.internal.a.a aVar) {
        return new com.baidu.mobads.sdk.internal.a.c(iAdInterListener, aVar);
    }

    public static boolean a(java.lang.Object[] objArr, java.lang.Class<?>... clsArr) {
        boolean z = objArr == null || objArr.length == 0;
        boolean z2 = clsArr == null || clsArr.length == 0;
        if (z && z2) {
            return true;
        }
        if (z || z2 || clsArr == null || objArr == null || clsArr.length != objArr.length) {
            return false;
        }
        for (int i2 = 0; i2 < clsArr.length; i2++) {
            if (!clsArr[i2].isInstance(objArr[i2])) {
                return false;
            }
        }
        return true;
    }

    public final java.lang.Object a(java.lang.String str, java.lang.Object... objArr) {
        java.util.HashMap hashMap = new java.util.HashMap();
        hashMap.put(m, objArr);
        this.p.onAdTaskProcess(str, hashMap);
        return hashMap.get(n);
    }

    public final void a(java.lang.String str) {
        this.p.onAdTaskProcess(str);
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public int getCode() {
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public java.util.Map<java.lang.String, java.lang.Object> getData() {
        return null;
    }

    @Override // com.baidu.mobads.sdk.internal.a.a
    @androidx.annotation.NonNull
    public com.baidu.mobads.sdk.api.IAdInterListener getDelegator() {
        return this.p;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public java.lang.String getMessage() {
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public java.lang.Object getTarget() {
        return this.p;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public java.lang.String getType() {
        return null;
    }

    @Override // com.baidu.mobads.sdk.internal.a.a
    public final java.lang.Object handleEvent(java.lang.String str, java.lang.String str2, java.lang.Object[] objArr) {
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public void setTarget(java.lang.Object obj) {
    }
}
