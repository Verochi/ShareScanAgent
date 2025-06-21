package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class ed extends android.widget.BaseExpandableListAdapter implements android.widget.ExpandableListView.OnGroupCollapseListener, android.widget.ExpandableListView.OnGroupExpandListener {
    private boolean[] a;
    private int b = -1;
    private java.util.List<com.amap.api.maps.offlinemap.OfflineMapProvince> c;
    private com.amap.api.maps.offlinemap.OfflineMapManager d;
    private android.content.Context e;

    public final class a {
        public com.amap.api.mapcore.util.eh a;

        public a() {
        }
    }

    public ed(java.util.List<com.amap.api.maps.offlinemap.OfflineMapProvince> list, com.amap.api.maps.offlinemap.OfflineMapManager offlineMapManager, android.content.Context context) {
        this.c = list;
        this.d = offlineMapManager;
        this.e = context;
        this.a = new boolean[list.size()];
    }

    private boolean a(int i) {
        return (i == 0 || i == getGroupCount() - 1) ? false : true;
    }

    public final void a() {
        this.b = -1;
        notifyDataSetChanged();
    }

    public final void b() {
        this.b = 0;
        notifyDataSetChanged();
    }

    @Override // android.widget.ExpandableListAdapter
    public final java.lang.Object getChild(int i, int i2) {
        return null;
    }

    @Override // android.widget.ExpandableListAdapter
    public final long getChildId(int i, int i2) {
        return i2;
    }

    @Override // android.widget.ExpandableListAdapter
    public final android.view.View getChildView(int i, int i2, boolean z, android.view.View view, android.view.ViewGroup viewGroup) {
        com.amap.api.mapcore.util.ed.a aVar;
        if (view != null) {
            aVar = (com.amap.api.mapcore.util.ed.a) view.getTag();
        } else {
            aVar = new com.amap.api.mapcore.util.ed.a();
            com.amap.api.mapcore.util.eh ehVar = new com.amap.api.mapcore.util.eh(this.e, this.d);
            ehVar.a(1);
            android.view.View a2 = ehVar.a();
            aVar.a = ehVar;
            a2.setTag(aVar);
            view = a2;
        }
        aVar.a.a(this.c.get(i).getCityList().get(i2));
        return view;
    }

    @Override // android.widget.ExpandableListAdapter
    public final int getChildrenCount(int i) {
        return a(i) ? this.c.get(i).getCityList().size() : this.c.get(i).getCityList().size();
    }

    @Override // android.widget.ExpandableListAdapter
    public final java.lang.Object getGroup(int i) {
        return this.c.get(i).getProvinceName();
    }

    @Override // android.widget.ExpandableListAdapter
    public final int getGroupCount() {
        int i = this.b;
        return i == -1 ? this.c.size() : i;
    }

    @Override // android.widget.ExpandableListAdapter
    public final long getGroupId(int i) {
        return i;
    }

    @Override // android.widget.ExpandableListAdapter
    public final android.view.View getGroupView(int i, boolean z, android.view.View view, android.view.ViewGroup viewGroup) {
        if (view == null) {
            view = (android.widget.RelativeLayout) com.amap.api.mapcore.util.el.a(this.e, com.moji.mjweather.R.array.aqi_index_description);
        }
        android.widget.TextView textView = (android.widget.TextView) view.findViewById(com.moji.mjweather.R.dimen._22dp);
        android.widget.ImageView imageView = (android.widget.ImageView) view.findViewById(com.moji.mjweather.R.dimen._25dp);
        textView.setText(this.c.get(i).getProvinceName());
        if (this.a[i]) {
            imageView.setImageDrawable(com.amap.api.mapcore.util.el.a().getDrawable(com.moji.mjweather.R.animator.fragment_close_exit));
        } else {
            imageView.setImageDrawable(com.amap.api.mapcore.util.el.a().getDrawable(com.moji.mjweather.R.animator.fragment_fade_enter));
        }
        return view;
    }

    @Override // android.widget.ExpandableListAdapter
    public final boolean hasStableIds() {
        return true;
    }

    @Override // android.widget.ExpandableListAdapter
    public final boolean isChildSelectable(int i, int i2) {
        return true;
    }

    @Override // android.widget.ExpandableListView.OnGroupCollapseListener
    public final void onGroupCollapse(int i) {
        this.a[i] = false;
    }

    @Override // android.widget.ExpandableListView.OnGroupExpandListener
    public final void onGroupExpand(int i) {
        this.a[i] = true;
    }
}
