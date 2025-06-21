package com.sensorsdata.analytics.android.autotrack.utils;

/* loaded from: classes19.dex */
public class KeyboardViewUtil {
    private static final java.lang.String MATCH_RULE_KEYBOARD = "^([A-Za-z]|[0-9])";
    private static final java.lang.String TAG_KEYBOARD = "keyboard_tag";
    private static boolean isSensorsCheckKeyboard = true;

    private static boolean getKeyboardSimilarFatherView(android.view.View view) {
        boolean z;
        if (!(view.getParent() instanceof android.view.ViewGroup)) {
            return false;
        }
        android.view.ViewGroup viewGroup = (android.view.ViewGroup) view.getParent();
        if (viewGroup.getTag(com.sensorsdata.analytics.android.autotrack.R.id.sensors_analytics_tag_view_keyboard) != null) {
            return true;
        }
        int childCount = viewGroup.getChildCount();
        if (childCount <= 1) {
            return false;
        }
        int indexOfChild = viewGroup.indexOfChild(view);
        for (int i = 0; i < childCount; i++) {
            if (indexOfChild != i) {
                android.view.View childAt = viewGroup.getChildAt(i);
                int i2 = com.sensorsdata.analytics.android.autotrack.R.id.sensors_analytics_tag_view_keyboard;
                if (childAt.getTag(i2) == null) {
                    if (childAt instanceof android.view.ViewGroup) {
                        android.view.ViewGroup viewGroup2 = (android.view.ViewGroup) childAt;
                        int childCount2 = viewGroup2.getChildCount();
                        int i3 = 0;
                        while (true) {
                            if (i3 >= childCount2) {
                                z = false;
                                break;
                            }
                            if (java.util.regex.Pattern.matches(MATCH_RULE_KEYBOARD, com.sensorsdata.analytics.android.sdk.util.SAViewUtils.getViewContent(viewGroup2.getChildAt(i3)))) {
                                z = true;
                                break;
                            }
                            i3++;
                        }
                        if (z) {
                            int i4 = com.sensorsdata.analytics.android.autotrack.R.id.sensors_analytics_tag_view_keyboard;
                            viewGroup2.setTag(i4, TAG_KEYBOARD);
                            viewGroup.setTag(i4, TAG_KEYBOARD);
                        }
                    } else if (java.util.regex.Pattern.matches(MATCH_RULE_KEYBOARD, com.sensorsdata.analytics.android.sdk.util.SAViewUtils.getViewContent(childAt))) {
                        childAt.setTag(i2, TAG_KEYBOARD);
                        viewGroup.setTag(i2, TAG_KEYBOARD);
                    }
                }
                return true;
            }
        }
        return false;
    }

    private static boolean getKeyboardSimilarView(android.view.View view) {
        if (!(view.getParent() instanceof android.view.ViewGroup)) {
            return getKeyboardSimilarFatherView((android.view.View) view.getParent());
        }
        android.view.ViewGroup viewGroup = (android.view.ViewGroup) view.getParent();
        if (viewGroup.getTag(com.sensorsdata.analytics.android.autotrack.R.id.sensors_analytics_tag_view_keyboard) != null) {
            return true;
        }
        int indexOfChild = viewGroup.indexOfChild(view);
        int childCount = viewGroup.getChildCount();
        if (childCount <= 1) {
            return getKeyboardSimilarFatherView(viewGroup);
        }
        boolean z = false;
        int i = 0;
        while (true) {
            if (i < childCount) {
                if (indexOfChild != i && java.util.regex.Pattern.matches(MATCH_RULE_KEYBOARD, com.sensorsdata.analytics.android.sdk.util.SAViewUtils.getViewContent(viewGroup.getChildAt(i)))) {
                    z = true;
                    break;
                }
                i++;
            } else {
                break;
            }
        }
        if (!z) {
            return getKeyboardSimilarFatherView(viewGroup);
        }
        viewGroup.setTag(com.sensorsdata.analytics.android.autotrack.R.id.sensors_analytics_tag_view_keyboard, TAG_KEYBOARD);
        return true;
    }

    public static boolean isKeyboardView(android.view.View view) {
        if (isSensorsCheckKeyboard && view != null && java.util.regex.Pattern.matches(MATCH_RULE_KEYBOARD, com.sensorsdata.analytics.android.sdk.util.SAViewUtils.getViewContent(view))) {
            return getKeyboardSimilarView(view);
        }
        return false;
    }
}
