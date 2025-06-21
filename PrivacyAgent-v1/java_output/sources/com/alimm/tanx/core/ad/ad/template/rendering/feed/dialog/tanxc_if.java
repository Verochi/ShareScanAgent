package com.alimm.tanx.core.ad.ad.template.rendering.feed.dialog;

/* loaded from: classes.dex */
public class tanxc_if {
    private final int tanxc_byte = 60;
    private final android.content.Context tanxc_do;
    private final android.widget.LinearLayout tanxc_for;
    private android.widget.PopupWindow tanxc_if;
    private final android.view.View tanxc_int;
    private final android.view.View tanxc_new;
    private android.view.View.OnClickListener tanxc_try;

    public tanxc_if(android.content.Context context) {
        this.tanxc_do = context;
        android.view.View inflate = android.view.LayoutInflater.from(context).inflate(com.alimm.tanx.core.R.layout.error_popup, (android.view.ViewGroup) null);
        this.tanxc_int = inflate;
        this.tanxc_for = (android.widget.LinearLayout) inflate.findViewById(com.alimm.tanx.core.R.id.ll_ad_close);
        this.tanxc_new = inflate.findViewById(com.alimm.tanx.core.R.id.view_line);
    }

    public void tanxc_do(android.view.View view, android.view.View.OnClickListener onClickListener) {
        if (tanxc_do()) {
            return;
        }
        this.tanxc_try = onClickListener;
        this.tanxc_for.setOnClickListener(onClickListener);
        android.widget.PopupWindow popupWindow = new android.widget.PopupWindow(this.tanxc_do, (android.util.AttributeSet) null, com.alimm.tanx.core.R.style.Transparent_Dialog);
        this.tanxc_if = popupWindow;
        popupWindow.setFocusable(false);
        this.tanxc_if.setOutsideTouchable(false);
        this.tanxc_if.setContentView(this.tanxc_int);
        int screenWidth = (com.alimm.tanx.core.utils.SysUtils.getScreenWidth(this.tanxc_int.getContext()) / 4) * 3;
        this.tanxc_if.setWidth(screenWidth);
        this.tanxc_if.setHeight((int) (screenWidth / 1.7d));
        view.getLocationOnScreen(new int[2]);
        this.tanxc_if.showAtLocation(view, 17, 0, 0);
    }

    public boolean tanxc_do() {
        android.widget.PopupWindow popupWindow = this.tanxc_if;
        if (popupWindow != null) {
            return popupWindow.isShowing();
        }
        return false;
    }

    public void tanxc_if() {
        android.widget.PopupWindow popupWindow = this.tanxc_if;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }
}
