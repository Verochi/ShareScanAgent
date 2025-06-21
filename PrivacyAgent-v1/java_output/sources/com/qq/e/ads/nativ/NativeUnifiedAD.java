package com.qq.e.ads.nativ;

/* loaded from: classes19.dex */
public class NativeUnifiedAD extends com.qq.e.ads.NativeAbstractAD<com.qq.e.comm.pi.NUADI> {
    private com.qq.e.ads.nativ.NativeUnifiedAD.AdListenerAdapter h;
    private com.qq.e.ads.nativ.NativeADUnifiedListener i;
    private java.util.List<java.lang.Integer> j = new java.util.ArrayList();
    private java.util.List<java.lang.String> k;
    private volatile int l;
    private volatile int m;
    private java.lang.String n;
    private com.qq.e.comm.constants.LoadAdParams o;

    public static class AdListenerAdapter implements com.qq.e.comm.adevent.ADListener {
        private com.qq.e.ads.nativ.NativeADUnifiedListener a;

        public AdListenerAdapter(com.qq.e.ads.nativ.NativeADUnifiedListener nativeADUnifiedListener) {
            this.a = nativeADUnifiedListener;
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(com.qq.e.comm.adevent.ADEvent aDEvent) {
            java.lang.Integer num;
            if (this.a != null) {
                int type = aDEvent.getType();
                if (type != 100) {
                    if (type == 101 && (num = (java.lang.Integer) aDEvent.getParam(java.lang.Integer.class)) != null) {
                        this.a.onNoAD(com.qq.e.comm.util.AdErrorConvertor.formatErrorCode(num.intValue()));
                        return;
                    }
                    return;
                }
                java.util.List list = (java.util.List) aDEvent.getParam(java.util.List.class);
                if (list == null || list.size() <= 0) {
                    return;
                }
                java.util.ArrayList arrayList = new java.util.ArrayList();
                java.util.Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(new com.qq.e.ads.nativ.NativeUnifiedADDataAdapter((com.qq.e.ads.nativ.NativeUnifiedADData) it.next()));
                }
                this.a.onADLoaded(arrayList);
            }
        }
    }

    public NativeUnifiedAD(android.content.Context context, java.lang.String str, com.qq.e.ads.nativ.NativeADUnifiedListener nativeADUnifiedListener) {
        this.i = nativeADUnifiedListener;
        this.h = new com.qq.e.ads.nativ.NativeUnifiedAD.AdListenerAdapter(nativeADUnifiedListener);
        a(context, str);
    }

    public NativeUnifiedAD(android.content.Context context, java.lang.String str, com.qq.e.ads.nativ.NativeADUnifiedListener nativeADUnifiedListener, java.lang.String str2) {
        this.i = nativeADUnifiedListener;
        this.h = new com.qq.e.ads.nativ.NativeUnifiedAD.AdListenerAdapter(nativeADUnifiedListener);
        a(context, str, str2);
    }

    private void a(int i, boolean z) {
        if (a()) {
            if (!b()) {
                if (z) {
                    this.j.add(java.lang.Integer.valueOf(i));
                    return;
                }
                return;
            }
            T t = this.a;
            if (t != 0) {
                com.qq.e.comm.constants.LoadAdParams loadAdParams = this.o;
                com.qq.e.comm.pi.NUADI nuadi = (com.qq.e.comm.pi.NUADI) t;
                if (loadAdParams != null) {
                    nuadi.loadData(i, loadAdParams);
                } else {
                    nuadi.loadData(i);
                }
            }
        }
    }

    @Override // com.qq.e.ads.AbstractAD
    public java.lang.Object a(android.content.Context context, com.qq.e.comm.pi.POFactory pOFactory, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        return pOFactory.getNativeAdManagerDelegate(context, str, str2, str3, this.h);
    }

    @Override // com.qq.e.ads.NativeAbstractAD, com.qq.e.ads.AbstractAD
    public void a(java.lang.Object obj) {
        com.qq.e.comm.pi.NUADI nuadi = (com.qq.e.comm.pi.NUADI) obj;
        nuadi.setMinVideoDuration(this.l);
        nuadi.setMaxVideoDuration(this.m);
        nuadi.setVastClassName(this.n);
        java.util.List<java.lang.String> list = this.k;
        if (list != null) {
            setCategories(list);
        }
        java.util.Iterator<java.lang.Integer> it = this.j.iterator();
        while (it.hasNext()) {
            a(it.next().intValue(), false);
        }
    }

    @Override // com.qq.e.ads.AbstractAD
    public void b(int i) {
        com.qq.e.ads.nativ.NativeADUnifiedListener nativeADUnifiedListener = this.i;
        if (nativeADUnifiedListener != null) {
            nativeADUnifiedListener.onNoAD(com.qq.e.comm.util.AdErrorConvertor.formatErrorCode(i));
        }
    }

    public java.lang.String getAdNetWorkName() {
        T t = this.a;
        if (t != 0) {
            return ((com.qq.e.comm.pi.NUADI) t).getAdNetWorkName();
        }
        a("getAdNetWorkName");
        return null;
    }

    public void loadData(int i) {
        a(i, true);
    }

    public void loadData(int i, com.qq.e.comm.constants.LoadAdParams loadAdParams) {
        this.o = loadAdParams;
        loadData(i);
    }

    public void setCategories(java.util.List<java.lang.String> list) {
        this.k = list;
        T t = this.a;
        if (t == 0 || list == null) {
            return;
        }
        ((com.qq.e.comm.pi.NUADI) t).setCategories(list);
    }

    public void setMaxVideoDuration(int i) {
        this.m = i;
        if (this.m > 0 && this.l > this.m) {
            com.qq.e.comm.util.GDTLogger.e("maxVideoDuration 设置值非法，不得小于minVideoDuration");
        }
        T t = this.a;
        if (t != 0) {
            ((com.qq.e.comm.pi.NUADI) t).setMaxVideoDuration(this.m);
        }
    }

    public void setMinVideoDuration(int i) {
        this.l = i;
        if (this.m > 0 && this.l > this.m) {
            com.qq.e.comm.util.GDTLogger.e("minVideoDuration 设置值非法，不得大于maxVideoDuration");
        }
        T t = this.a;
        if (t != 0) {
            ((com.qq.e.comm.pi.NUADI) t).setMinVideoDuration(this.l);
        }
    }

    public void setVastClassName(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            com.qq.e.comm.util.GDTLogger.e("Vast class name 不能为空");
            return;
        }
        this.n = str;
        T t = this.a;
        if (t != 0) {
            ((com.qq.e.comm.pi.NUADI) t).setVastClassName(str);
        }
    }
}
