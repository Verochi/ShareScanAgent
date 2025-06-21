package com.sensorsdata.analytics.android.sdk.dialog;

/* loaded from: classes19.dex */
class DebugModeSelectDialog extends android.app.Dialog implements android.view.View.OnClickListener {
    private com.sensorsdata.analytics.android.sdk.SensorsDataAPI.DebugMode currentDebugMode;
    private android.content.Context mContext;
    private com.sensorsdata.analytics.android.sdk.dialog.DebugModeSelectDialog.OnDebugModeViewClickListener onDebugModeDialogClickListener;

    public interface OnDebugModeViewClickListener {
        void onCancel(android.app.Dialog dialog);

        void setDebugMode(android.app.Dialog dialog, com.sensorsdata.analytics.android.sdk.SensorsDataAPI.DebugMode debugMode);
    }

    public DebugModeSelectDialog(android.content.Context context, com.sensorsdata.analytics.android.sdk.SensorsDataAPI.DebugMode debugMode) {
        super(context);
        this.mContext = context;
        this.currentDebugMode = debugMode;
    }

    private android.graphics.drawable.StateListDrawable getDrawable() {
        android.graphics.drawable.GradientDrawable gradientDrawable = new android.graphics.drawable.GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(android.graphics.Color.parseColor("#dddddd"));
        android.graphics.drawable.GradientDrawable gradientDrawable2 = new android.graphics.drawable.GradientDrawable();
        gradientDrawable2.setShape(0);
        gradientDrawable2.setColor(-1);
        android.graphics.drawable.StateListDrawable stateListDrawable = new android.graphics.drawable.StateListDrawable();
        stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, gradientDrawable);
        stateListDrawable.addState(new int[]{android.R.attr.state_focused}, gradientDrawable);
        stateListDrawable.addState(new int[0], gradientDrawable2);
        return stateListDrawable;
    }

    private void initView() {
        ((android.widget.TextView) findViewById(com.sensorsdata.analytics.android.sdk.R.id.sensors_analytics_debug_mode_title)).setText(com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(this.mContext, com.sensorsdata.analytics.android.sdk.R.string.sensors_analytics_debug_view_title));
        android.widget.TextView textView = (android.widget.TextView) findViewById(com.sensorsdata.analytics.android.sdk.R.id.sensors_analytics_debug_mode_cancel);
        textView.setText(com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(this.mContext, com.sensorsdata.analytics.android.sdk.R.string.sensors_analytics_common_cancel));
        textView.setOnClickListener(this);
        textView.setFocusable(true);
        android.widget.TextView textView2 = (android.widget.TextView) findViewById(com.sensorsdata.analytics.android.sdk.R.id.sensors_analytics_debug_mode_only);
        textView2.setText(com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(this.mContext, com.sensorsdata.analytics.android.sdk.R.string.sensors_analytics_debug_only));
        textView2.setOnClickListener(this);
        textView2.setFocusable(true);
        android.widget.TextView textView3 = (android.widget.TextView) findViewById(com.sensorsdata.analytics.android.sdk.R.id.sensors_analytics_debug_mode_track);
        textView3.setText(com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(this.mContext, com.sensorsdata.analytics.android.sdk.R.string.sensors_analytics_debug_and_track));
        textView3.setOnClickListener(this);
        textView3.setFocusable(true);
        java.lang.String stringResource = com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(this.mContext, com.sensorsdata.analytics.android.sdk.R.string.sensors_analytics_debug_name_default);
        com.sensorsdata.analytics.android.sdk.SensorsDataAPI.DebugMode debugMode = this.currentDebugMode;
        if (debugMode == com.sensorsdata.analytics.android.sdk.SensorsDataAPI.DebugMode.DEBUG_ONLY) {
            stringResource = com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(this.mContext, com.sensorsdata.analytics.android.sdk.R.string.sensors_analytics_debug_name_only);
        } else if (debugMode == com.sensorsdata.analytics.android.sdk.SensorsDataAPI.DebugMode.DEBUG_AND_TRACK) {
            stringResource = com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(this.mContext, com.sensorsdata.analytics.android.sdk.R.string.sensors_analytics_debug_name_track);
        }
        ((android.widget.TextView) findViewById(com.sensorsdata.analytics.android.sdk.R.id.sensors_analytics_debug_mode_message)).setText(stringResource);
        textView.setBackground(getDrawable());
        textView2.setBackground(getDrawable());
        textView3.setBackground(getDrawable());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(android.view.View view) {
        if (this.onDebugModeDialogClickListener == null) {
            return;
        }
        int id = view.getId();
        if (id == com.sensorsdata.analytics.android.sdk.R.id.sensors_analytics_debug_mode_track) {
            this.onDebugModeDialogClickListener.setDebugMode(this, com.sensorsdata.analytics.android.sdk.SensorsDataAPI.DebugMode.DEBUG_AND_TRACK);
        } else if (id == com.sensorsdata.analytics.android.sdk.R.id.sensors_analytics_debug_mode_only) {
            this.onDebugModeDialogClickListener.setDebugMode(this, com.sensorsdata.analytics.android.sdk.SensorsDataAPI.DebugMode.DEBUG_ONLY);
        } else if (id == com.sensorsdata.analytics.android.sdk.R.id.sensors_analytics_debug_mode_cancel) {
            this.onDebugModeDialogClickListener.onCancel(this);
        }
    }

    @Override // android.app.Dialog
    public void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(com.sensorsdata.analytics.android.sdk.R.layout.sensors_analytics_debug_mode_dialog_content);
        initView();
        android.view.Window window = getWindow();
        if (window != null) {
            android.view.WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.dip2px(getContext(), 270.0f);
            attributes.height = com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.dip2px(getContext(), 240.0f);
            window.setAttributes(attributes);
            android.graphics.drawable.GradientDrawable gradientDrawable = new android.graphics.drawable.GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setColor(-1);
            gradientDrawable.setCornerRadius(com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.dip2px(getContext(), 7.0f));
            window.setBackgroundDrawable(gradientDrawable);
        }
    }

    public void setOnDebugModeDialogClickListener(com.sensorsdata.analytics.android.sdk.dialog.DebugModeSelectDialog.OnDebugModeViewClickListener onDebugModeViewClickListener) {
        this.onDebugModeDialogClickListener = onDebugModeViewClickListener;
    }
}
