package com.alimm.tanx.core.ad.view;

/* loaded from: classes.dex */
public enum ActionMenu implements com.alimm.tanx.core.utils.NotConfused {
    more(1011, com.alimm.tanx.core.R.drawable.tanx_browser_actionbar_more_selector, "更多"),
    refresh(1012, com.alimm.tanx.core.R.drawable.tanx_browser_topbar_more_refresh, "刷新"),
    copy(1016, com.alimm.tanx.core.R.drawable.tanx_browser_topbar_more_copy, "复制"),
    gotoweb(1013, com.alimm.tanx.core.R.drawable.tanx_browser_topbar_more_brower, "浏览器");

    public static final int ID_COPY = 1016;
    public static final int ID_GOTOWEB = 1013;
    public static final int ID_MORE = 1011;
    public static final int ID_REFRESH = 1012;
    public static final int ID_SHARE = 1015;
    public final int drawable;
    public final int id;
    public java.lang.String name;

    ActionMenu(int i, int i2, java.lang.String str) {
        this.id = i;
        this.drawable = i2;
        this.name = str;
    }
}
