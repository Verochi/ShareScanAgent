package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class ec extends android.widget.BaseExpandableListAdapter implements android.widget.ExpandableListView.OnGroupCollapseListener, android.widget.ExpandableListView.OnGroupExpandListener {
    private boolean[] b;
    private android.content.Context c;
    private com.amap.api.mapcore.util.eh d;
    private com.amap.api.mapcore.util.ej f;
    private com.amap.api.maps.offlinemap.OfflineMapManager g;
    private java.util.List<com.amap.api.maps.offlinemap.OfflineMapProvince> e = new java.util.ArrayList();
    java.util.List<com.amap.api.maps.offlinemap.OfflineMapProvince> a = new java.util.ArrayList();

    /* renamed from: com.amap.api.mapcore.util.ec$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.View.OnClickListener {
        final /* synthetic */ com.amap.api.maps.offlinemap.OfflineMapCity a;

        public AnonymousClass1(com.amap.api.maps.offlinemap.OfflineMapCity offlineMapCity) {
            this.a = offlineMapCity;
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            com.amap.api.mapcore.util.ec.this.f.a(this.a);
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public final class a {
        public com.amap.api.mapcore.util.eh a;

        public a() {
        }
    }

    public ec(android.content.Context context, com.amap.api.mapcore.util.ej ejVar, com.amap.api.maps.offlinemap.OfflineMapManager offlineMapManager, java.util.List<com.amap.api.maps.offlinemap.OfflineMapProvince> list) {
        this.c = context;
        this.f = ejVar;
        this.g = offlineMapManager;
        if (list != null && list.size() > 0) {
            this.e.clear();
            this.e.addAll(list);
            for (com.amap.api.maps.offlinemap.OfflineMapProvince offlineMapProvince : this.e) {
                if (offlineMapProvince != null && offlineMapProvince.getDownloadedCityList().size() > 0) {
                    this.a.add(offlineMapProvince);
                }
            }
        }
        this.b = new boolean[this.a.size()];
    }

    public final void a() {
        for (com.amap.api.maps.offlinemap.OfflineMapProvince offlineMapProvince : this.e) {
            if (offlineMapProvince.getDownloadedCityList().size() > 0 && !this.a.contains(offlineMapProvince)) {
                this.a.add(offlineMapProvince);
            }
        }
        this.b = new boolean[this.a.size()];
        notifyDataSetChanged();
    }

    public final void b() {
        try {
            for (int size = this.a.size(); size > 0; size--) {
                com.amap.api.maps.offlinemap.OfflineMapProvince offlineMapProvince = this.a.get(size - 1);
                if (offlineMapProvince.getDownloadedCityList().size() == 0) {
                    this.a.remove(offlineMapProvince);
                }
            }
            this.b = new boolean[this.a.size()];
            notifyDataSetChanged();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.widget.ExpandableListAdapter
    public final java.lang.Object getChild(int i, int i2) {
        return this.a.get(i).getDownloadedCityList().get(i2);
    }

    @Override // android.widget.ExpandableListAdapter
    public final long getChildId(int i, int i2) {
        return i2;
    }

    @Override // android.widget.ExpandableListAdapter
    public final android.view.View getChildView(int i, int i2, boolean z, android.view.View view, android.view.ViewGroup viewGroup) {
        com.amap.api.mapcore.util.ec.a aVar;
        if (view != null) {
            aVar = (com.amap.api.mapcore.util.ec.a) view.getTag();
        } else {
            aVar = new com.amap.api.mapcore.util.ec.a();
            com.amap.api.mapcore.util.eh ehVar = new com.amap.api.mapcore.util.eh(this.c, this.g);
            this.d = ehVar;
            ehVar.a(2);
            view = this.d.a();
            aVar.a = this.d;
            view.setTag(aVar);
        }
        com.amap.api.maps.offlinemap.OfflineMapProvince offlineMapProvince = this.a.get(i);
        if (i2 < offlineMapProvince.getDownloadedCityList().size()) {
            com.amap.api.maps.offlinemap.OfflineMapCity offlineMapCity = offlineMapProvince.getDownloadedCityList().get(i2);
            aVar.a.a(offlineMapCity);
            view.setOnClickListener(new com.amap.api.mapcore.util.ec.AnonymousClass1(offlineMapCity));
        }
        return view;
    }

    @Override // android.widget.ExpandableListAdapter
    public final int getChildrenCount(int i) {
        return this.a.get(i).getDownloadedCityList().size();
    }

    @Override // android.widget.ExpandableListAdapter
    public final java.lang.Object getGroup(int i) {
        return this.a.get(i).getProvinceName();
    }

    @Override // android.widget.ExpandableListAdapter
    public final int getGroupCount() {
        return this.a.size();
    }

    @Override // android.widget.ExpandableListAdapter
    public final long getGroupId(int i) {
        return i;
    }

    @Override // android.widget.ExpandableListAdapter
    public final android.view.View getGroupView(int i, boolean z, android.view.View view, android.view.ViewGroup viewGroup) {
        if (view == null) {
            view = (android.widget.RelativeLayout) com.amap.api.mapcore.util.el.a(this.c, com.moji.mjweather.R.array.aqi_index_description);
        }
        android.widget.TextView textView = (android.widget.TextView) view.findViewById(com.moji.mjweather.R.dimen._22dp);
        android.widget.ImageView imageView = (android.widget.ImageView) view.findViewById(com.moji.mjweather.R.dimen._25dp);
        textView.setText(this.a.get(i).getProvinceName());
        if (this.b[i]) {
            imageView.setImageDrawable(com.amap.api.mapcore.util.el.a().getDrawable(com.moji.mjweather.R.animator.fragment_close_exit));
        } else {
            imageView.setImageDrawable(com.amap.api.mapcore.util.el.a().getDrawable(com.moji.mjweather.R.animator.fragment_fade_enter));
        }
        return view;
    }

    @Override // android.widget.ExpandableListAdapter
    public final boolean hasStableIds() {
        return false;
    }

    @Override // android.widget.ExpandableListAdapter
    public final boolean isChildSelectable(int i, int i2) {
        return true;
    }

    @Override // android.widget.ExpandableListView.OnGroupCollapseListener
    public final void onGroupCollapse(int i) {
        this.b[i] = false;
    }

    @Override // android.widget.ExpandableListView.OnGroupExpandListener
    public final void onGroupExpand(int i) {
        this.b[i] = true;
    }
}
