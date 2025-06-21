package com.aliyun.svideo.editor.msg.body;

/* loaded from: classes12.dex */
public class FilterTabClick {
    public static final int POSITION_ANIMATION_FILTER = 1;
    public static final int POSITION_COLOR_FILTER = 0;
    private int position;

    public FilterTabClick(int i) {
        this.position = i;
    }

    public int getPosition() {
        return this.position;
    }
}
