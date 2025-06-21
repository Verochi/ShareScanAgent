package com.aliyun.subtitle;

/* loaded from: classes.dex */
public class LocationStyle {
    public static final int Location_Bottom = 8;
    public static final int Location_Center = 64;
    public static final int Location_CenterH = 16;
    public static final int Location_CenterV = 32;
    public static final int Location_Left = 1;
    public static final int Location_Right = 4;
    public static final int Location_Top = 2;

    public static void setLocation(android.widget.RelativeLayout.LayoutParams layoutParams, java.util.Map<java.lang.String, java.lang.Object> map, int i) {
        if (map != null && map.containsKey(com.aliyun.subtitle.SubtitleView.EXTRA_LOCATION__INT)) {
            i = ((java.lang.Integer) map.get(com.aliyun.subtitle.SubtitleView.EXTRA_LOCATION__INT)).intValue();
        }
        if ((i & 8) == 8) {
            layoutParams.addRule(12);
        }
        if ((i & 1) == 1) {
            layoutParams.addRule(9);
        }
        if ((i & 2) == 2) {
            layoutParams.addRule(10);
        }
        if ((i & 4) == 4) {
            layoutParams.addRule(11);
        }
        if ((i & 16) == 16) {
            layoutParams.addRule(14);
        }
        if ((i & 32) == 32) {
            layoutParams.addRule(15);
        }
        if ((i & 64) == 64) {
            layoutParams.addRule(13);
        }
    }
}
