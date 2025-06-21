package com.aliyun.svideo.editor.util;

/* loaded from: classes12.dex */
public class CompatUtil {
    @android.annotation.TargetApi(16)
    public static void generateSpacingmultAndSpacingadd(float[] fArr, android.widget.TextView textView) {
        fArr[0] = textView.getLineSpacingMultiplier();
        fArr[1] = textView.getLineSpacingExtra();
    }
}
