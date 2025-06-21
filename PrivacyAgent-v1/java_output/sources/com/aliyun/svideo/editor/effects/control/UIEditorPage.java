package com.aliyun.svideo.editor.effects.control;

/* loaded from: classes12.dex */
public enum UIEditorPage {
    FILTER,
    AUDIO_MIX,
    OVERLAY,
    COMPOUND_CAPTION,
    CAPTION,
    MV,
    SOUND,
    FILTER_EFFECT,
    TIME,
    TRANSITION,
    PAINT,
    COVER,
    VIDEOEQ,
    ROLL_CAPTION,
    PIP,
    LUT,
    FONT;

    public static com.aliyun.svideo.editor.effects.control.UIEditorPage get(int i) {
        return values()[i];
    }

    public int index() {
        return ordinal();
    }
}
