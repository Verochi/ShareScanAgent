package com.aliyun.svideo.editor.effects.control;

/* loaded from: classes12.dex */
public class TabGroup implements android.view.View.OnClickListener {
    private static final long MIN_CLICK_INTERVAL = 1000;
    private long lastTimeMillis;
    private com.aliyun.svideo.editor.effects.control.TabGroup.OnCheckedChangeListener mOnCheckedChangeistener;
    private com.aliyun.svideo.editor.effects.control.OnTabChangeListener mOnTabChangeListener;
    private final java.util.ArrayList<android.view.View> mViewList = new java.util.ArrayList<>();
    private int mCheckedIndex = -1;

    public interface OnCheckedChangeListener {
        void onCheckedChanged(com.aliyun.svideo.editor.effects.control.TabGroup tabGroup, int i);
    }

    public void addView(android.view.View view) {
        view.setOnClickListener(this);
        this.mViewList.add(view);
    }

    public int getCheckedIndex() {
        return this.mCheckedIndex;
    }

    public boolean isTimeEnabled() {
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        if (currentTimeMillis - this.lastTimeMillis <= 1000) {
            return false;
        }
        this.lastTimeMillis = currentTimeMillis;
        return true;
    }

    @Override // android.view.View.OnClickListener
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onClick(android.view.View view) {
        if (isTimeEnabled()) {
            setCheckedView(view);
            com.aliyun.svideo.editor.effects.control.OnTabChangeListener onTabChangeListener = this.mOnTabChangeListener;
            if (onTabChangeListener != null) {
                onTabChangeListener.onTabChange();
            }
        }
        com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void setCheckedIndex(int i) {
        int i2 = this.mCheckedIndex;
        if (i2 >= 0) {
            this.mViewList.get(i2).setActivated(false);
        }
        this.mCheckedIndex = i;
        if (i >= 0) {
            this.mViewList.get(i).setActivated(true);
        }
        com.aliyun.svideo.editor.effects.control.TabGroup.OnCheckedChangeListener onCheckedChangeListener = this.mOnCheckedChangeistener;
        if (onCheckedChangeListener != null) {
            onCheckedChangeListener.onCheckedChanged(this, this.mCheckedIndex);
        }
    }

    public void setCheckedView(android.view.View view) {
        setCheckedIndex(this.mViewList.indexOf(view));
    }

    public void setOnCheckedChangeListener(com.aliyun.svideo.editor.effects.control.TabGroup.OnCheckedChangeListener onCheckedChangeListener) {
        this.mOnCheckedChangeistener = onCheckedChangeListener;
    }

    public void setOnTabChangeListener(com.aliyun.svideo.editor.effects.control.OnTabChangeListener onTabChangeListener) {
        this.mOnTabChangeListener = onTabChangeListener;
    }
}
