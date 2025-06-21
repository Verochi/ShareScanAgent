package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class ef extends com.amap.api.mapcore.util.eg implements android.view.View.OnClickListener {
    private com.amap.api.maps.offlinemap.OfflineMapManager a;
    private android.view.View b;
    private android.widget.TextView c;
    private android.widget.TextView d;
    private android.widget.TextView e;
    private android.widget.TextView f;
    private int g;
    private java.lang.String h;

    /* renamed from: com.amap.api.mapcore.util.ef$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            com.amap.api.mapcore.util.ef.this.dismiss();
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public ef(android.content.Context context, com.amap.api.maps.offlinemap.OfflineMapManager offlineMapManager) {
        super(context);
        this.a = offlineMapManager;
    }

    @Override // com.amap.api.mapcore.util.eg
    public final void a() {
        android.view.View a = com.amap.api.mapcore.util.el.a(getContext(), com.moji.mjweather.R.array.allergy_type_q);
        this.b = a;
        setContentView(a);
        this.b.setOnClickListener(new com.amap.api.mapcore.util.ef.AnonymousClass1());
        this.c = (android.widget.TextView) this.b.findViewById(com.moji.mjweather.R.dimen._14dp);
        android.widget.TextView textView = (android.widget.TextView) this.b.findViewById(com.moji.mjweather.R.dimen._15dp);
        this.d = textView;
        textView.setText("暂停下载");
        this.e = (android.widget.TextView) this.b.findViewById(com.moji.mjweather.R.dimen._160dp);
        this.f = (android.widget.TextView) this.b.findViewById(com.moji.mjweather.R.dimen._16dp);
        this.d.setOnClickListener(this);
        this.e.setOnClickListener(this);
        this.f.setOnClickListener(this);
    }

    public final void a(int i, java.lang.String str) {
        this.c.setText(str);
        if (i == 0) {
            this.d.setText("暂停下载");
            this.d.setVisibility(0);
            this.e.setText("取消下载");
        }
        if (i == 2) {
            this.d.setVisibility(8);
            this.e.setText("取消下载");
        } else if (i == -1 || i == 101 || i == 102 || i == 103) {
            this.d.setText("继续下载");
            this.d.setVisibility(0);
        } else if (i == 3) {
            this.d.setVisibility(0);
            this.d.setText("继续下载");
            this.e.setText("取消下载");
        } else if (i == 4) {
            this.e.setText("删除");
            this.d.setVisibility(8);
        }
        this.g = i;
        this.h = str;
    }

    @Override // android.view.View.OnClickListener
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public final void onClick(android.view.View view) {
        try {
            int id = view.getId();
            if (id != com.moji.mjweather.R.dimen._15dp) {
                if (id == com.moji.mjweather.R.dimen._160dp) {
                    if (!android.text.TextUtils.isEmpty(this.h)) {
                        this.a.remove(this.h);
                        dismiss();
                        com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
                        return;
                    }
                } else if (id == com.moji.mjweather.R.dimen._16dp) {
                    dismiss();
                }
                com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
                return;
            }
            int i = this.g;
            if (i == 0) {
                this.d.setText("继续下载");
                this.a.pauseByName(this.h);
            } else if (i == 3 || i == -1 || i == 101 || i == 102 || i == 103) {
                this.d.setText("暂停下载");
                this.a.downloadByCityName(this.h);
            }
            dismiss();
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }
}
