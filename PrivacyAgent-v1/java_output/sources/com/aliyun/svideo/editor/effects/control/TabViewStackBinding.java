package com.aliyun.svideo.editor.effects.control;

/* loaded from: classes12.dex */
public class TabViewStackBinding implements com.aliyun.svideo.editor.effects.control.TabGroup.OnCheckedChangeListener {
    private com.aliyun.svideo.editor.effects.control.ViewStack _ViewStack;

    public com.aliyun.svideo.editor.effects.control.ViewStack getViewStack() {
        return this._ViewStack;
    }

    @Override // com.aliyun.svideo.editor.effects.control.TabGroup.OnCheckedChangeListener
    public void onCheckedChanged(com.aliyun.svideo.editor.effects.control.TabGroup tabGroup, int i) {
        this._ViewStack.setActiveIndex(i);
    }

    public void setViewStack(com.aliyun.svideo.editor.effects.control.ViewStack viewStack) {
        this._ViewStack = viewStack;
    }
}
