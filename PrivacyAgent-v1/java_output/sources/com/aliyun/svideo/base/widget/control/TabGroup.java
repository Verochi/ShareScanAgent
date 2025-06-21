package com.aliyun.svideo.base.widget.control;

/* loaded from: classes.dex */
public class TabGroup implements android.view.View.OnClickListener {
    private com.aliyun.svideo.base.widget.control.TabGroup.OnCheckedChangeListener _Listener;
    private final java.util.ArrayList<android.view.View> _ViewList = new java.util.ArrayList<>();
    private int _CheckedIndex = -1;

    public interface OnCheckedChangeListener {
        void onCheckedChanged(com.aliyun.svideo.base.widget.control.TabGroup tabGroup, int i);
    }

    public void addView(android.view.View view) {
        view.setOnClickListener(this);
        this._ViewList.add(view);
    }

    public int getCheckedID() {
        int i = this._CheckedIndex;
        if (i < 0) {
            return -1;
        }
        return this._ViewList.get(i).getId();
    }

    public int getCheckedIndex() {
        return this._CheckedIndex;
    }

    public android.view.View getCheckedView() {
        int i = this._CheckedIndex;
        if (i < 0) {
            return null;
        }
        return this._ViewList.get(i);
    }

    public android.view.View getView(int i) {
        if (i < 0 || i >= this._ViewList.size()) {
            return null;
        }
        return this._ViewList.get(i);
    }

    @Override // android.view.View.OnClickListener
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onClick(android.view.View view) {
        setCheckedView(view);
        com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void setCheckedId(int i) {
        int size = this._ViewList.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this._ViewList.get(i2).getId() == i) {
                setCheckedIndex(i2);
                return;
            }
        }
        setCheckedIndex(-1);
    }

    public void setCheckedIndex(int i) {
        int i2 = this._CheckedIndex;
        if (i == i2) {
            return;
        }
        if (i2 >= 0) {
            this._ViewList.get(i2).setActivated(false);
        }
        this._CheckedIndex = i;
        if (i >= 0) {
            this._ViewList.get(i).setActivated(true);
        }
        com.aliyun.svideo.base.widget.control.TabGroup.OnCheckedChangeListener onCheckedChangeListener = this._Listener;
        if (onCheckedChangeListener != null) {
            onCheckedChangeListener.onCheckedChanged(this, this._CheckedIndex);
        }
    }

    public void setCheckedView(android.view.View view) {
        setCheckedIndex(this._ViewList.indexOf(view));
    }

    public void setOnCheckedChangeListener(com.aliyun.svideo.base.widget.control.TabGroup.OnCheckedChangeListener onCheckedChangeListener) {
        this._Listener = onCheckedChangeListener;
    }
}
