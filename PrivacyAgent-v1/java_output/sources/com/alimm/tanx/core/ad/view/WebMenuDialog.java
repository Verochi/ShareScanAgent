package com.alimm.tanx.core.ad.view;

/* loaded from: classes.dex */
public class WebMenuDialog extends android.app.Dialog implements com.alimm.tanx.core.utils.NotConfused {
    private final android.content.Context mContext;
    private final android.view.LayoutInflater mInflater;
    private final com.alimm.tanx.core.ad.view.WebMenuDialog.MenuClick mMenuClick;
    private final java.util.List<com.alimm.tanx.core.ad.view.ActionMenu> mMenuList;
    private final android.widget.AdapterView.OnItemClickListener onMenuOnItemClickListener;

    /* renamed from: com.alimm.tanx.core.ad.view.WebMenuDialog$1, reason: invalid class name */
    public class AnonymousClass1 implements android.widget.AdapterView.OnItemClickListener {
        public AnonymousClass1() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onItemClick(android.widget.AdapterView<?> adapterView, android.view.View view, int i, long j) {
            com.alimm.tanx.core.ad.view.WebMenuDialog.this.mMenuClick.click(((com.alimm.tanx.core.ad.view.ActionMenu) com.alimm.tanx.core.ad.view.WebMenuDialog.this.mMenuList.get(i)).id);
            com.alimm.tanx.core.ad.view.WebMenuDialog.this.dismiss();
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackListView(adapterView, view, i);
        }
    }

    public interface MenuClick {
        void click(int i);
    }

    public class tanxc_do extends android.widget.BaseAdapter {
        public tanxc_do() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return com.alimm.tanx.core.ad.view.WebMenuDialog.this.mMenuList.size();
        }

        @Override // android.widget.Adapter
        public java.lang.Object getItem(int i) {
            return com.alimm.tanx.core.ad.view.WebMenuDialog.this.mMenuList.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public android.view.View getView(int i, android.view.View view, android.view.ViewGroup viewGroup) {
            android.view.View view2;
            com.alimm.tanx.core.ad.view.WebMenuDialog.tanxc_if tanxc_ifVar;
            if (view == null) {
                tanxc_ifVar = new com.alimm.tanx.core.ad.view.WebMenuDialog.tanxc_if();
                view2 = com.alimm.tanx.core.ad.view.WebMenuDialog.this.mInflater.inflate(com.alimm.tanx.core.R.layout.tanx_layout_browser_simple_popmenu_items, viewGroup, false);
                tanxc_ifVar.tanxc_do = (android.widget.ImageView) view2.findViewById(com.alimm.tanx.core.R.id.tanx_browser_menu_item_img);
                tanxc_ifVar.tanxc_if = (android.widget.TextView) view2.findViewById(com.alimm.tanx.core.R.id.tanx_browser_menu_item_title);
                view2.setTag(tanxc_ifVar);
            } else {
                view2 = view;
                tanxc_ifVar = (com.alimm.tanx.core.ad.view.WebMenuDialog.tanxc_if) view.getTag();
            }
            com.alimm.tanx.core.ad.view.ActionMenu actionMenu = (com.alimm.tanx.core.ad.view.ActionMenu) getItem(i);
            tanxc_ifVar.tanxc_do.setImageResource(actionMenu.drawable);
            tanxc_ifVar.tanxc_if.setText(actionMenu.name);
            return view2;
        }
    }

    public static class tanxc_if {
        android.widget.ImageView tanxc_do;
        android.widget.TextView tanxc_if;
    }

    public WebMenuDialog(android.content.Context context, java.util.List<com.alimm.tanx.core.ad.view.ActionMenu> list, com.alimm.tanx.core.ad.view.WebMenuDialog.MenuClick menuClick) {
        super(context, com.alimm.tanx.core.R.style.Theme_Tanx_Browser_Dialog);
        this.onMenuOnItemClickListener = new com.alimm.tanx.core.ad.view.WebMenuDialog.AnonymousClass1();
        this.mContext = context;
        this.mMenuClick = menuClick;
        this.mMenuList = list;
        this.mInflater = android.view.LayoutInflater.from(context);
    }

    @Override // android.app.Dialog
    public void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        setCanceledOnTouchOutside(true);
        if (getWindow() != null) {
            getWindow().setGravity(53);
            getWindow().getAttributes().y = this.mContext.getResources().getDimensionPixelOffset(com.alimm.tanx.core.R.dimen.tanx_browser_default_height);
            getWindow().getAttributes().width = -2;
            getWindow().getAttributes().height = -2;
        }
        setContentView(com.alimm.tanx.core.R.layout.tanx_layout_browser_popmenu);
        android.widget.ListView listView = (android.widget.ListView) findViewById(com.alimm.tanx.core.R.id.tanx_browser_menu_listview);
        listView.setAdapter((android.widget.ListAdapter) new com.alimm.tanx.core.ad.view.WebMenuDialog.tanxc_do());
        listView.setOnItemClickListener(this.onMenuOnItemClickListener);
    }
}
