package com.alimm.tanx.core.ad.ad.template.rendering.feed.dialog;

/* loaded from: classes.dex */
public class tanxc_for {
    private final android.view.View tanxc_byte;
    private final android.widget.TextView tanxc_case;
    private final android.widget.TextView tanxc_char;
    private final android.content.Context tanxc_do;
    private final android.widget.ImageView tanxc_else;
    private final android.widget.LinearLayout tanxc_for;
    private final android.widget.ImageView tanxc_goto;
    private android.widget.PopupWindow tanxc_if;
    private final android.widget.LinearLayout tanxc_int;
    private final int tanxc_long = 60;
    private final android.widget.LinearLayout tanxc_new;
    private final com.alimm.tanx.core.ad.bean.MediaRenderingMode tanxc_this;
    private final android.view.View tanxc_try;

    public tanxc_for(android.content.Context context, com.alimm.tanx.core.ad.bean.MediaRenderingMode mediaRenderingMode) {
        this.tanxc_do = context;
        this.tanxc_this = mediaRenderingMode;
        android.view.View inflate = android.view.LayoutInflater.from(context).inflate(com.alimm.tanx.core.R.layout.tips_popup, (android.view.ViewGroup) null);
        this.tanxc_try = inflate;
        this.tanxc_for = (android.widget.LinearLayout) inflate.findViewById(com.alimm.tanx.core.R.id.ll_uninterested);
        this.tanxc_int = (android.widget.LinearLayout) inflate.findViewById(com.alimm.tanx.core.R.id.ll_poor_content);
        this.tanxc_new = (android.widget.LinearLayout) inflate.findViewById(com.alimm.tanx.core.R.id.ll_background);
        this.tanxc_case = (android.widget.TextView) inflate.findViewById(com.alimm.tanx.core.R.id.tv_uninterested);
        this.tanxc_char = (android.widget.TextView) inflate.findViewById(com.alimm.tanx.core.R.id.tv_poor_content);
        this.tanxc_else = (android.widget.ImageView) inflate.findViewById(com.alimm.tanx.core.R.id.iv_uninterested);
        this.tanxc_goto = (android.widget.ImageView) inflate.findViewById(com.alimm.tanx.core.R.id.iv_poor_content);
        this.tanxc_byte = inflate.findViewById(com.alimm.tanx.core.R.id.view_line);
    }

    private int tanxc_do(int i) {
        return com.alimm.tanx.core.utils.SysUtils.getScreenWidth(this.tanxc_try.getContext()) - i;
    }

    private int tanxc_do(android.view.View view, int i) {
        return com.alimm.tanx.core.utils.SysUtils.getScreenHeight(this.tanxc_try.getContext()) / 2 > i ? i + view.getMeasuredHeight() : i - com.alimm.tanx.core.utils.DimenUtil.dp2px(this.tanxc_try.getContext(), 60.0f);
    }

    public java.util.List<android.view.View> tanxc_do() {
        return java.util.Arrays.asList(this.tanxc_for, this.tanxc_int);
    }

    public void tanxc_do(android.view.View view, com.alimm.tanx.core.ad.ad.template.rendering.feed.dialog.ErrorInterface errorInterface) {
        try {
            if (tanxc_if()) {
                return;
            }
            android.widget.PopupWindow popupWindow = new android.widget.PopupWindow(this.tanxc_do, (android.util.AttributeSet) null, com.alimm.tanx.core.R.style.Transparent_Dialog);
            this.tanxc_if = popupWindow;
            popupWindow.setFocusable(true);
            this.tanxc_if.setOutsideTouchable(true);
            this.tanxc_if.setContentView(this.tanxc_try);
            this.tanxc_if.setWidth(com.alimm.tanx.core.utils.SysUtils.getScreenWidth(this.tanxc_try.getContext()) / 3);
            this.tanxc_if.setHeight(com.alimm.tanx.core.utils.DimenUtil.dp2px(this.tanxc_try.getContext(), 60.0f));
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            int tanxc_do = tanxc_do(iArr[0] + view.getMeasuredWidth());
            int tanxc_do2 = tanxc_do(view, iArr[1]);
            android.content.Context context = this.tanxc_do;
            if (context instanceof android.app.Activity) {
                this.tanxc_if.showAtLocation(((android.app.Activity) context).getWindow().getDecorView().getRootView(), 53, tanxc_do, tanxc_do2);
            } else {
                this.tanxc_if.showAtLocation(view, 53, tanxc_do, tanxc_do2);
            }
            tanxc_int();
        } catch (java.lang.Exception e) {
            com.alimm.tanx.core.utils.LogUtils.e("TipsPopUp", e);
            errorInterface.error(com.alimm.tanx.core.utils.LogUtils.getStackTraceMessage(e));
        }
    }

    public void tanxc_for() {
        android.widget.PopupWindow popupWindow = this.tanxc_if;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    public boolean tanxc_if() {
        android.widget.PopupWindow popupWindow = this.tanxc_if;
        if (popupWindow != null) {
            return popupWindow.isShowing();
        }
        return false;
    }

    public void tanxc_int() {
        if (com.alimm.tanx.core.TanxCoreSdk.getConfig() != null) {
            if (com.alimm.tanx.core.TanxCoreSdk.getConfig().getSettingConfig().isNightSwitch()) {
                android.widget.LinearLayout linearLayout = this.tanxc_new;
                linearLayout.setBackground(linearLayout.getContext().getDrawable(com.alimm.tanx.core.R.drawable.tanx_shape_close_pop_night));
                android.widget.ImageView imageView = this.tanxc_else;
                imageView.setImageDrawable(imageView.getContext().getDrawable(com.alimm.tanx.core.R.mipmap.uninterested_night));
                android.widget.ImageView imageView2 = this.tanxc_goto;
                imageView2.setImageDrawable(imageView2.getContext().getDrawable(com.alimm.tanx.core.R.mipmap.poor_content_night));
                this.tanxc_byte.setBackgroundResource(com.alimm.tanx.core.R.color.close_pop_line_color_night);
                this.tanxc_case.setTextColor(android.graphics.Color.parseColor("#EDEDED"));
                this.tanxc_char.setTextColor(android.graphics.Color.parseColor("#EDEDED"));
                return;
            }
            android.widget.LinearLayout linearLayout2 = this.tanxc_new;
            linearLayout2.setBackground(linearLayout2.getContext().getDrawable(com.alimm.tanx.core.R.drawable.tanx_shape_close_pop_write));
            android.widget.ImageView imageView3 = this.tanxc_else;
            imageView3.setImageDrawable(imageView3.getContext().getDrawable(com.alimm.tanx.core.R.mipmap.uninterested_write));
            android.widget.ImageView imageView4 = this.tanxc_goto;
            imageView4.setImageDrawable(imageView4.getContext().getDrawable(com.alimm.tanx.core.R.mipmap.poor_content_write));
            this.tanxc_byte.setBackgroundResource(com.alimm.tanx.core.R.color.close_pop_line_color_write);
            this.tanxc_case.setTextColor(android.graphics.Color.parseColor("#1C1C1C"));
            this.tanxc_char.setTextColor(android.graphics.Color.parseColor("#1C1C1C"));
        }
    }
}
