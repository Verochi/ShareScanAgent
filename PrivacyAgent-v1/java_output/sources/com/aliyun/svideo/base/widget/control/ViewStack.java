package com.aliyun.svideo.base.widget.control;

/* loaded from: classes.dex */
public class ViewStack {
    private int _ActiveIndex;
    private final int _Invisible;
    private final java.util.ArrayList<android.view.View> _ViewList;

    public ViewStack() {
        this(8);
    }

    public ViewStack(int i) {
        this._ViewList = new java.util.ArrayList<>();
        this._ActiveIndex = -1;
        this._Invisible = i;
    }

    public void addView(android.view.View view) {
        this._ViewList.add(view);
        view.setVisibility(this._Invisible);
    }

    public int getActiveIndex() {
        return this._ActiveIndex;
    }

    public void setActiveIndex(int i) {
        int i2 = this._ActiveIndex;
        if (i2 >= 0) {
            this._ViewList.get(i2).setVisibility(this._Invisible);
        }
        this._ActiveIndex = i;
        if (i >= 0) {
            this._ViewList.get(i).setVisibility(0);
        }
    }

    public void setActiveViewID(int i) {
        int size = this._ViewList.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this._ViewList.get(i2).getId() == i) {
                setActiveIndex(i2);
                return;
            }
        }
        setActiveIndex(-1);
    }
}
