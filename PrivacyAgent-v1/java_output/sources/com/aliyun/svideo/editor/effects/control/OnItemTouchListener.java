package com.aliyun.svideo.editor.effects.control;

/* loaded from: classes12.dex */
public interface OnItemTouchListener {
    public static final int EVENT_DOWN = 1;
    public static final int EVENT_MOVE = 3;
    public static final int EVENT_UP = 2;

    void onTouchEvent(int i, int i2, com.aliyun.svideo.editor.effects.control.EffectInfo effectInfo);
}
