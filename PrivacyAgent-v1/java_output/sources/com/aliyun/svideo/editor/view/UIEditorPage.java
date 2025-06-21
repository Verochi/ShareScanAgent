package com.aliyun.svideo.editor.view;

/* loaded from: classes12.dex */
public enum UIEditorPage {
    FILTER_EFFECT,
    OVERLAY,
    CAPTION,
    MV,
    AUDIO_MIX,
    PAINT,
    TIME,
    TRANSITION,
    FONT;

    public static com.aliyun.svideo.editor.view.UIEditorPage get(int i) {
        return values()[i];
    }

    public int index() {
        return ordinal();
    }
}
