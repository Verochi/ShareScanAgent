package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class ee extends android.widget.BaseAdapter {
    private java.util.List<com.amap.api.maps.offlinemap.OfflineMapCity> a = new java.util.ArrayList();
    private com.amap.api.maps.offlinemap.OfflineMapManager b;
    private android.app.Activity c;

    /* renamed from: com.amap.api.mapcore.util.ee$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.View.OnClickListener {
        final /* synthetic */ com.amap.api.mapcore.util.ee.a a;
        final /* synthetic */ com.amap.api.maps.offlinemap.OfflineMapCity b;

        public AnonymousClass1(com.amap.api.mapcore.util.ee.a aVar, com.amap.api.maps.offlinemap.OfflineMapCity offlineMapCity) {
            this.a = aVar;
            this.b = offlineMapCity;
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            this.a.d.setVisibility(8);
            this.a.c.setVisibility(0);
            this.a.c.setText("下载中");
            try {
                com.amap.api.mapcore.util.ee.this.b.downloadByCityName(this.b.getCity());
                com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
            } catch (com.amap.api.maps.AMapException e) {
                e.printStackTrace();
                com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        }
    }

    public final class a {
        public android.widget.TextView a;
        public android.widget.TextView b;
        public android.widget.TextView c;
        public android.widget.ImageView d;

        public a() {
        }
    }

    public ee(com.amap.api.maps.offlinemap.OfflineMapManager offlineMapManager, com.amap.api.maps.offlinemap.OfflineMapActivity offlineMapActivity) {
        this.b = offlineMapManager;
        this.c = offlineMapActivity;
    }

    public final void a(java.util.List<com.amap.api.maps.offlinemap.OfflineMapCity> list) {
        this.a = list;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return this.a.size();
    }

    @Override // android.widget.Adapter
    public final java.lang.Object getItem(int i) {
        return this.a.get(i);
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public final android.view.View getView(int i, android.view.View view, android.view.ViewGroup viewGroup) {
        com.amap.api.mapcore.util.ee.a aVar;
        int state;
        try {
            com.amap.api.maps.offlinemap.OfflineMapCity offlineMapCity = this.a.get(i);
            if (view == null) {
                aVar = new com.amap.api.mapcore.util.ee.a();
                view = com.amap.api.mapcore.util.el.a(this.c, com.moji.mjweather.R.array.apply_input_age);
                aVar.a = (android.widget.TextView) view.findViewById(com.moji.mjweather.R.dimen._17dp);
                aVar.b = (android.widget.TextView) view.findViewById(com.moji.mjweather.R.dimen._20dp);
                aVar.c = (android.widget.TextView) view.findViewById(com.moji.mjweather.R.dimen._1dp);
                aVar.d = (android.widget.ImageView) view.findViewById(2131165198);
                view.setTag(aVar);
            } else {
                aVar = (com.amap.api.mapcore.util.ee.a) view.getTag();
            }
            aVar.d.setOnClickListener(new com.amap.api.mapcore.util.ee.AnonymousClass1(aVar, offlineMapCity));
            aVar.c.setVisibility(0);
            aVar.a.setText(offlineMapCity.getCity());
            android.widget.TextView textView = aVar.b;
            textView.setText(java.lang.String.valueOf(((int) (((offlineMapCity.getSize() / 1024.0d) / 1024.0d) * 100.0d)) / 100.0d) + " M");
            state = offlineMapCity.getState();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        if (state != -1) {
            if (state == 0 || state == 1) {
                aVar.d.setVisibility(8);
                aVar.c.setText("下载中");
            } else if (state == 2) {
                aVar.d.setVisibility(8);
                aVar.c.setText("等待下载");
            } else if (state == 3) {
                aVar.d.setVisibility(8);
                aVar.c.setText("暂停中");
            } else if (state == 4) {
                aVar.d.setVisibility(8);
                aVar.c.setText("已下载");
            } else if (state != 6) {
                switch (state) {
                }
            } else {
                aVar.d.setVisibility(0);
                aVar.c.setVisibility(8);
            }
            return view;
        }
        aVar.d.setVisibility(8);
        aVar.c.setText("下载失败");
        return view;
    }
}
