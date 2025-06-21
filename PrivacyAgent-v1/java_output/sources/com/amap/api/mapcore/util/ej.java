package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class ej extends com.amap.api.offlineservice.a implements android.text.TextWatcher, android.view.View.OnTouchListener, android.widget.AbsListView.OnScrollListener, com.amap.api.maps.offlinemap.OfflineMapManager.OfflineLoadedListener, com.amap.api.maps.offlinemap.OfflineMapManager.OfflineMapDownloadListener {
    private android.widget.ImageView b;
    private android.widget.RelativeLayout c;
    private com.amap.api.maps.offlinemap.DownLoadExpandListView d;
    private android.widget.ListView e;
    private android.widget.ExpandableListView f;
    private android.widget.ImageView g;
    private android.widget.ImageView h;
    private android.widget.AutoCompleteTextView i;
    private android.widget.RelativeLayout j;
    private android.widget.RelativeLayout k;
    private android.widget.ImageView l;
    private android.widget.ImageView m;
    private android.widget.RelativeLayout n;
    private com.amap.api.mapcore.util.ed p;
    private com.amap.api.mapcore.util.ec r;

    /* renamed from: s, reason: collision with root package name */
    private com.amap.api.mapcore.util.ee f125s;
    private com.amap.api.mapcore.util.ef x;
    private java.util.List<com.amap.api.maps.offlinemap.OfflineMapProvince> o = new java.util.ArrayList();
    private com.amap.api.maps.offlinemap.OfflineMapManager q = null;
    private boolean t = true;
    private boolean u = true;
    private int v = -1;
    private long w = 0;
    private boolean y = true;

    /* renamed from: com.amap.api.mapcore.util.ej$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            try {
                com.amap.api.mapcore.util.ej.this.i.setText("");
                com.amap.api.mapcore.util.ej.this.l.setVisibility(8);
                com.amap.api.mapcore.util.ej.this.a(false);
                android.widget.RelativeLayout.LayoutParams layoutParams = (android.widget.RelativeLayout.LayoutParams) com.amap.api.mapcore.util.ej.this.m.getLayoutParams();
                layoutParams.leftMargin = com.amap.api.mapcore.util.ej.this.a(95.0f);
                com.amap.api.mapcore.util.ej.this.m.setLayoutParams(layoutParams);
                com.amap.api.mapcore.util.ej.this.i.setPadding(com.amap.api.mapcore.util.ej.this.a(105.0f), 0, 0, 0);
                com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        }
    }

    /* renamed from: com.amap.api.mapcore.util.ej$2, reason: invalid class name */
    public class AnonymousClass2 implements java.util.Comparator<com.amap.api.maps.offlinemap.OfflineMapCity> {
        public AnonymousClass2() {
        }

        private static int a(com.amap.api.maps.offlinemap.OfflineMapCity offlineMapCity, com.amap.api.maps.offlinemap.OfflineMapCity offlineMapCity2) {
            char[] charArray = offlineMapCity.getJianpin().toCharArray();
            char[] charArray2 = offlineMapCity2.getJianpin().toCharArray();
            return (charArray[0] >= charArray2[0] && charArray[1] >= charArray2[1]) ? 0 : 1;
        }

        @Override // java.util.Comparator
        public final /* synthetic */ int compare(com.amap.api.maps.offlinemap.OfflineMapCity offlineMapCity, com.amap.api.maps.offlinemap.OfflineMapCity offlineMapCity2) {
            return a(offlineMapCity, offlineMapCity2);
        }
    }

    private void f() {
        try {
            android.widget.RelativeLayout.LayoutParams layoutParams = (android.widget.RelativeLayout.LayoutParams) this.m.getLayoutParams();
            layoutParams.leftMargin = a(18.0f);
            this.m.setLayoutParams(layoutParams);
            this.i.setPadding(a(30.0f), 0, 0, 0);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    private void g() {
        i();
        com.amap.api.mapcore.util.ee eeVar = new com.amap.api.mapcore.util.ee(this.q, this.a);
        this.f125s = eeVar;
        this.e.setAdapter((android.widget.ListAdapter) eeVar);
    }

    private void h() {
        com.amap.api.mapcore.util.ec ecVar = new com.amap.api.mapcore.util.ec(this.a, this, this.q, this.o);
        this.r = ecVar;
        this.d.setAdapter(ecVar);
        this.r.notifyDataSetChanged();
    }

    private void i() {
        java.util.ArrayList<com.amap.api.maps.offlinemap.OfflineMapProvince> offlineMapProvinceList = this.q.getOfflineMapProvinceList();
        this.o.clear();
        this.o.add(null);
        java.util.ArrayList<com.amap.api.maps.offlinemap.OfflineMapCity> arrayList = new java.util.ArrayList<>();
        java.util.ArrayList<com.amap.api.maps.offlinemap.OfflineMapCity> arrayList2 = new java.util.ArrayList<>();
        java.util.ArrayList<com.amap.api.maps.offlinemap.OfflineMapCity> arrayList3 = new java.util.ArrayList<>();
        for (int i = 0; i < offlineMapProvinceList.size(); i++) {
            com.amap.api.maps.offlinemap.OfflineMapProvince offlineMapProvince = offlineMapProvinceList.get(i);
            if (offlineMapProvince.getCityList().size() != 1) {
                this.o.add(i + 1, offlineMapProvince);
            } else {
                java.lang.String provinceName = offlineMapProvince.getProvinceName();
                if (provinceName.contains("香港")) {
                    arrayList2.addAll(offlineMapProvince.getCityList());
                } else if (provinceName.contains("澳门")) {
                    arrayList2.addAll(offlineMapProvince.getCityList());
                } else if (provinceName.contains("全国概要图")) {
                    arrayList3.addAll(0, offlineMapProvince.getCityList());
                } else {
                    arrayList3.addAll(offlineMapProvince.getCityList());
                }
            }
        }
        com.amap.api.maps.offlinemap.OfflineMapProvince offlineMapProvince2 = new com.amap.api.maps.offlinemap.OfflineMapProvince();
        offlineMapProvince2.setProvinceName("基本功能包+直辖市");
        offlineMapProvince2.setCityList(arrayList3);
        this.o.set(0, offlineMapProvince2);
        com.amap.api.maps.offlinemap.OfflineMapProvince offlineMapProvince3 = new com.amap.api.maps.offlinemap.OfflineMapProvince();
        offlineMapProvince3.setProvinceName("直辖市");
        offlineMapProvince3.setCityList(arrayList);
        com.amap.api.maps.offlinemap.OfflineMapProvince offlineMapProvince4 = new com.amap.api.maps.offlinemap.OfflineMapProvince();
        offlineMapProvince4.setProvinceName("港澳");
        offlineMapProvince4.setCityList(arrayList2);
        this.o.add(offlineMapProvince4);
    }

    private void j() {
        android.widget.AutoCompleteTextView autoCompleteTextView = this.i;
        if (autoCompleteTextView == null || !autoCompleteTextView.isFocused()) {
            return;
        }
        this.i.clearFocus();
        android.view.inputmethod.InputMethodManager inputMethodManager = (android.view.inputmethod.InputMethodManager) this.a.getSystemService("input_method");
        if (inputMethodManager != null ? inputMethodManager.isActive() : false) {
            inputMethodManager.hideSoftInputFromWindow(this.i.getWindowToken(), 2);
        }
    }

    @Override // com.amap.api.offlineservice.a
    public final void a(android.view.View view) {
        try {
            int id = view.getId();
            if (id == com.moji.mjweather.R.dimen._32dp) {
                this.a.closeScr();
                return;
            }
            if (id == com.moji.mjweather.R.dimen._100dp) {
                if (this.u) {
                    this.d.setVisibility(8);
                    this.g.setBackgroundResource(com.moji.mjweather.R.animator.fragment_close_enter);
                    this.u = false;
                    return;
                } else {
                    this.d.setVisibility(0);
                    this.g.setBackgroundResource(com.moji.mjweather.R.animator.blocking_out);
                    this.u = true;
                    return;
                }
            }
            if (id == com.moji.mjweather.R.dimen._13dp) {
                if (this.t) {
                    this.p.b();
                    this.h.setBackgroundResource(com.moji.mjweather.R.animator.fragment_close_enter);
                    this.t = false;
                } else {
                    this.p.a();
                    this.h.setBackgroundResource(com.moji.mjweather.R.animator.blocking_out);
                    this.t = true;
                }
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public final void a(com.amap.api.maps.offlinemap.OfflineMapCity offlineMapCity) {
        try {
            if (this.x == null) {
                this.x = new com.amap.api.mapcore.util.ef(this.a, this.q);
            }
            this.x.a(offlineMapCity.getState(), offlineMapCity.getCity());
            this.x.show();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public final void a(boolean z) {
        if (z) {
            this.j.setVisibility(8);
            this.k.setVisibility(8);
            this.d.setVisibility(8);
            this.f.setVisibility(8);
            this.n.setVisibility(8);
            this.e.setVisibility(0);
            return;
        }
        this.j.setVisibility(0);
        this.k.setVisibility(0);
        this.n.setVisibility(0);
        this.d.setVisibility(this.u ? 0 : 8);
        this.f.setVisibility(this.t ? 0 : 8);
        this.e.setVisibility(8);
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(android.text.Editable editable) {
    }

    @Override // com.amap.api.offlineservice.a
    public final void b() {
        android.view.View a = com.amap.api.mapcore.util.el.a(this.a, com.moji.mjweather.R.array.allergy_level_q);
        com.amap.api.maps.offlinemap.DownLoadExpandListView downLoadExpandListView = (com.amap.api.maps.offlinemap.DownLoadExpandListView) a.findViewById(com.moji.mjweather.R.dimen._120dp);
        this.d = downLoadExpandListView;
        downLoadExpandListView.setOnTouchListener(this);
        this.j = (android.widget.RelativeLayout) a.findViewById(com.moji.mjweather.R.dimen._100dp);
        this.g = (android.widget.ImageView) a.findViewById(com.moji.mjweather.R.dimen._11dp);
        this.j.setOnClickListener(this.a);
        this.k = (android.widget.RelativeLayout) a.findViewById(com.moji.mjweather.R.dimen._13dp);
        this.h = (android.widget.ImageView) a.findViewById(com.moji.mjweather.R.dimen._140dp);
        this.k.setOnClickListener(this.a);
        this.n = (android.widget.RelativeLayout) a.findViewById(com.moji.mjweather.R.dimen._12dp);
        android.widget.ImageView imageView = (android.widget.ImageView) this.c.findViewById(com.moji.mjweather.R.dimen._32dp);
        this.b = imageView;
        imageView.setOnClickListener(this.a);
        this.m = (android.widget.ImageView) this.c.findViewById(com.moji.mjweather.R.dimen._38dp);
        android.widget.ImageView imageView2 = (android.widget.ImageView) this.c.findViewById(com.moji.mjweather.R.dimen._40dp);
        this.l = imageView2;
        imageView2.setOnClickListener(new com.amap.api.mapcore.util.ej.AnonymousClass1());
        this.c.findViewById(com.moji.mjweather.R.dimen._41dp).setOnTouchListener(this);
        android.widget.AutoCompleteTextView autoCompleteTextView = (android.widget.AutoCompleteTextView) this.c.findViewById(com.moji.mjweather.R.dimen._3dp);
        this.i = autoCompleteTextView;
        autoCompleteTextView.addTextChangedListener(this);
        this.i.setOnTouchListener(this);
        this.e = (android.widget.ListView) this.c.findViewById(com.moji.mjweather.R.dimen._48dp);
        android.widget.ExpandableListView expandableListView = (android.widget.ExpandableListView) this.c.findViewById(com.moji.mjweather.R.dimen._45dp);
        this.f = expandableListView;
        expandableListView.addHeaderView(a);
        this.f.setOnTouchListener(this);
        this.f.setOnScrollListener(this);
        try {
            com.amap.api.maps.offlinemap.OfflineMapManager offlineMapManager = new com.amap.api.maps.offlinemap.OfflineMapManager(this.a, this);
            this.q = offlineMapManager;
            offlineMapManager.setOnOfflineLoadedListener(this);
        } catch (java.lang.Exception e) {
            "e=".concat(java.lang.String.valueOf(e));
        }
        i();
        com.amap.api.mapcore.util.ed edVar = new com.amap.api.mapcore.util.ed(this.o, this.q, this.a);
        this.p = edVar;
        this.f.setAdapter(edVar);
        this.f.setOnGroupCollapseListener(this.p);
        this.f.setOnGroupExpandListener(this.p);
        this.f.setGroupIndicator(null);
        if (this.t) {
            this.h.setBackgroundResource(com.moji.mjweather.R.animator.blocking_out);
            this.f.setVisibility(0);
        } else {
            this.h.setBackgroundResource(com.moji.mjweather.R.animator.fragment_close_enter);
            this.f.setVisibility(8);
        }
        if (this.u) {
            this.g.setBackgroundResource(com.moji.mjweather.R.animator.blocking_out);
            this.d.setVisibility(0);
        } else {
            this.g.setBackgroundResource(com.moji.mjweather.R.animator.fragment_close_enter);
            this.d.setVisibility(8);
        }
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(java.lang.CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // com.amap.api.offlineservice.a
    public final boolean c() {
        try {
            if (this.e.getVisibility() == 0) {
                this.i.setText("");
                this.l.setVisibility(8);
                a(false);
                return false;
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        return super.c();
    }

    @Override // com.amap.api.offlineservice.a
    public final android.widget.RelativeLayout d() {
        if (this.c == null) {
            this.c = (android.widget.RelativeLayout) com.amap.api.mapcore.util.el.a(this.a, com.moji.mjweather.R.array.array_comment_list_other_mode);
        }
        return this.c;
    }

    @Override // com.amap.api.offlineservice.a
    public final void e() {
        this.q.destroy();
    }

    @Override // com.amap.api.maps.offlinemap.OfflineMapManager.OfflineMapDownloadListener
    public final void onCheckUpdate(boolean z, java.lang.String str) {
    }

    @Override // com.amap.api.maps.offlinemap.OfflineMapManager.OfflineMapDownloadListener
    public final void onDownload(int i, int i2, java.lang.String str) {
        if (i == 101) {
            try {
                android.widget.Toast.makeText(this.a, "网络异常", 0).show();
                this.q.pause();
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                return;
            }
        }
        if (i == 2) {
            this.r.a();
        }
        if (this.v == i) {
            if (java.lang.System.currentTimeMillis() - this.w > 1200) {
                if (this.y) {
                    this.r.notifyDataSetChanged();
                }
                this.w = java.lang.System.currentTimeMillis();
                return;
            }
            return;
        }
        com.amap.api.mapcore.util.ed edVar = this.p;
        if (edVar != null) {
            edVar.notifyDataSetChanged();
        }
        com.amap.api.mapcore.util.ec ecVar = this.r;
        if (ecVar != null) {
            ecVar.notifyDataSetChanged();
        }
        com.amap.api.mapcore.util.ee eeVar = this.f125s;
        if (eeVar != null) {
            eeVar.notifyDataSetChanged();
        }
        this.v = i;
    }

    @Override // com.amap.api.maps.offlinemap.OfflineMapManager.OfflineMapDownloadListener
    public final void onRemove(boolean z, java.lang.String str, java.lang.String str2) {
        com.amap.api.mapcore.util.ec ecVar = this.r;
        if (ecVar != null) {
            ecVar.b();
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScroll(android.widget.AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScrollStateChanged(android.widget.AbsListView absListView, int i) {
        if (i == 2) {
            this.y = false;
        } else {
            this.y = true;
        }
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(java.lang.CharSequence charSequence, int i, int i2, int i3) {
        if (android.text.TextUtils.isEmpty(charSequence)) {
            a(false);
            this.l.setVisibility(8);
            return;
        }
        this.l.setVisibility(0);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.List<com.amap.api.maps.offlinemap.OfflineMapProvince> list = this.o;
        if (list != null && list.size() > 0) {
            java.util.ArrayList<com.amap.api.maps.offlinemap.OfflineMapCity> arrayList2 = new java.util.ArrayList();
            java.util.Iterator<com.amap.api.maps.offlinemap.OfflineMapProvince> it = this.o.iterator();
            while (it.hasNext()) {
                arrayList2.addAll(it.next().getCityList());
            }
            for (com.amap.api.maps.offlinemap.OfflineMapCity offlineMapCity : arrayList2) {
                java.lang.String city = offlineMapCity.getCity();
                java.lang.String pinyin = offlineMapCity.getPinyin();
                java.lang.String jianpin = offlineMapCity.getJianpin();
                if (charSequence.length() == 1) {
                    if (jianpin.startsWith(java.lang.String.valueOf(charSequence))) {
                        arrayList.add(offlineMapCity);
                    }
                } else if (jianpin.startsWith(java.lang.String.valueOf(charSequence)) || pinyin.startsWith(java.lang.String.valueOf(charSequence)) || city.startsWith(java.lang.String.valueOf(charSequence))) {
                    arrayList.add(offlineMapCity);
                }
            }
        }
        if (arrayList.size() <= 0) {
            android.widget.Toast.makeText(this.a, "未找到相关城市", 0).show();
            return;
        }
        a(true);
        java.util.Collections.sort(arrayList, new com.amap.api.mapcore.util.ej.AnonymousClass2());
        com.amap.api.mapcore.util.ee eeVar = this.f125s;
        if (eeVar != null) {
            eeVar.a(arrayList);
            this.f125s.notifyDataSetChanged();
        }
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
        j();
        if (view.getId() != com.moji.mjweather.R.dimen._3dp) {
            return false;
        }
        f();
        return false;
    }

    @Override // com.amap.api.maps.offlinemap.OfflineMapManager.OfflineLoadedListener
    public final void onVerifyComplete() {
        g();
        h();
    }
}
