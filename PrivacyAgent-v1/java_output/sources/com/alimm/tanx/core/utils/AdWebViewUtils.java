package com.alimm.tanx.core.utils;

/* loaded from: classes.dex */
public class AdWebViewUtils implements com.alimm.tanx.core.utils.NotConfused {
    private static final java.lang.String TAG = "AdClickUtils";

    public static boolean isDestroyed(android.app.Activity activity) {
        return activity == null || activity.isFinishing() || activity.isDestroyed();
    }

    public static boolean isNormalWebTitleValid(java.lang.CharSequence charSequence, android.webkit.WebView webView) {
        android.webkit.WebBackForwardList copyBackForwardList;
        android.webkit.WebHistoryItem currentItem;
        java.lang.String str = null;
        if (webView != null) {
            try {
                copyBackForwardList = webView.copyBackForwardList();
            } catch (java.lang.Throwable th) {
                com.alimm.tanx.core.utils.LogUtils.d(TAG, "isNormalWebTitleValid exception: title = " + ((java.lang.Object) charSequence), th);
            }
        } else {
            copyBackForwardList = null;
        }
        if (copyBackForwardList != null && (currentItem = copyBackForwardList.getCurrentItem()) != null) {
            str = currentItem.getUrl();
        }
        com.alimm.tanx.core.utils.LogUtils.d(TAG, "isNormalWebTitleValid: url = " + str + ", title = " + ((java.lang.Object) charSequence));
        if (str != null && !android.text.TextUtils.isEmpty(charSequence)) {
            java.lang.String lowerCase = str.toLowerCase();
            if (charSequence instanceof java.lang.String) {
                charSequence = ((java.lang.String) charSequence).toLowerCase();
            }
            if (!lowerCase.contains(charSequence)) {
                return true;
            }
        }
        return false;
    }

    public static void setShowAsAction(android.view.Menu menu, com.alimm.tanx.core.ad.view.ActionMenu actionMenu) {
        android.view.MenuItem add = menu.add(0, actionMenu.id, 0, actionMenu.name);
        add.setIcon(actionMenu.drawable);
        androidx.core.view.MenuItemCompat.setShowAsAction(add, 2);
    }
}
