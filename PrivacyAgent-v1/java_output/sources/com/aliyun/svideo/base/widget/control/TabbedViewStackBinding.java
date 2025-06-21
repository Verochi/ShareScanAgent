package com.aliyun.svideo.base.widget.control;

/* loaded from: classes.dex */
public class TabbedViewStackBinding implements com.aliyun.svideo.base.widget.control.TabGroup.OnCheckedChangeListener {
    private com.aliyun.svideo.base.widget.control.ViewStack _ViewStack;

    public com.aliyun.svideo.base.widget.control.ViewStack getViewStack() {
        return this._ViewStack;
    }

    @Override // com.aliyun.svideo.base.widget.control.TabGroup.OnCheckedChangeListener
    public void onCheckedChanged(com.aliyun.svideo.base.widget.control.TabGroup tabGroup, int i) {
        this._ViewStack.setActiveIndex(i);
    }

    public void setViewStack(com.aliyun.svideo.base.widget.control.ViewStack viewStack) {
        this._ViewStack = viewStack;
    }
}
