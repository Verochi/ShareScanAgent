package com.aliyun.subtitle;

/* loaded from: classes.dex */
public class TextSytle {
    public static void setTextColor(android.text.SpannableStringBuilder spannableStringBuilder, java.util.Map<java.lang.String, java.lang.Object> map, java.lang.String str) {
        if (map != null && map.containsKey(com.aliyun.subtitle.SubtitleView.EXTRA_COLOR__STRING)) {
            str = (java.lang.String) map.get(com.aliyun.subtitle.SubtitleView.EXTRA_COLOR__STRING);
        }
        spannableStringBuilder.setSpan(new android.text.style.ForegroundColorSpan(android.graphics.Color.parseColor(str)), 0, spannableStringBuilder.length(), 17);
    }

    public static void setTextSize(android.text.SpannableStringBuilder spannableStringBuilder, java.util.Map<java.lang.String, java.lang.Object> map, int i) {
        if (map != null && map.containsKey(com.aliyun.subtitle.SubtitleView.EXTRA_SIZE_PX__INT)) {
            i = ((java.lang.Integer) map.get(com.aliyun.subtitle.SubtitleView.EXTRA_SIZE_PX__INT)).intValue();
        }
        spannableStringBuilder.setSpan(new android.text.style.AbsoluteSizeSpan(i), 0, spannableStringBuilder.length(), 17);
    }
}
