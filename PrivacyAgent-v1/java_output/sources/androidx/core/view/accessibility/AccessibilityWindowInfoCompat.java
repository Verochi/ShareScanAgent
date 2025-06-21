package androidx.core.view.accessibility;

/* loaded from: classes.dex */
public class AccessibilityWindowInfoCompat {
    public static final int TYPE_ACCESSIBILITY_OVERLAY = 4;
    public static final int TYPE_APPLICATION = 1;
    public static final int TYPE_INPUT_METHOD = 2;
    public static final int TYPE_SPLIT_SCREEN_DIVIDER = 5;
    public static final int TYPE_SYSTEM = 3;
    private static final int UNDEFINED = -1;
    private java.lang.Object mInfo;

    private AccessibilityWindowInfoCompat(java.lang.Object obj) {
        this.mInfo = obj;
    }

    public static androidx.core.view.accessibility.AccessibilityWindowInfoCompat obtain() {
        return wrapNonNullInstance(android.view.accessibility.AccessibilityWindowInfo.obtain());
    }

    public static androidx.core.view.accessibility.AccessibilityWindowInfoCompat obtain(androidx.core.view.accessibility.AccessibilityWindowInfoCompat accessibilityWindowInfoCompat) {
        if (accessibilityWindowInfoCompat == null) {
            return null;
        }
        return wrapNonNullInstance(android.view.accessibility.AccessibilityWindowInfo.obtain((android.view.accessibility.AccessibilityWindowInfo) accessibilityWindowInfoCompat.mInfo));
    }

    private static java.lang.String typeToString(int i) {
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? "<UNKNOWN>" : "TYPE_ACCESSIBILITY_OVERLAY" : "TYPE_SYSTEM" : "TYPE_INPUT_METHOD" : "TYPE_APPLICATION";
    }

    public static androidx.core.view.accessibility.AccessibilityWindowInfoCompat wrapNonNullInstance(java.lang.Object obj) {
        if (obj != null) {
            return new androidx.core.view.accessibility.AccessibilityWindowInfoCompat(obj);
        }
        return null;
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof androidx.core.view.accessibility.AccessibilityWindowInfoCompat)) {
            return false;
        }
        androidx.core.view.accessibility.AccessibilityWindowInfoCompat accessibilityWindowInfoCompat = (androidx.core.view.accessibility.AccessibilityWindowInfoCompat) obj;
        java.lang.Object obj2 = this.mInfo;
        if (obj2 == null) {
            if (accessibilityWindowInfoCompat.mInfo != null) {
                return false;
            }
        } else if (!obj2.equals(accessibilityWindowInfoCompat.mInfo)) {
            return false;
        }
        return true;
    }

    public androidx.core.view.accessibility.AccessibilityNodeInfoCompat getAnchor() {
        android.view.accessibility.AccessibilityNodeInfo anchor;
        if (android.os.Build.VERSION.SDK_INT < 24) {
            return null;
        }
        anchor = ((android.view.accessibility.AccessibilityWindowInfo) this.mInfo).getAnchor();
        return androidx.core.view.accessibility.AccessibilityNodeInfoCompat.wrapNonNullInstance(anchor);
    }

    public void getBoundsInScreen(android.graphics.Rect rect) {
        ((android.view.accessibility.AccessibilityWindowInfo) this.mInfo).getBoundsInScreen(rect);
    }

    public androidx.core.view.accessibility.AccessibilityWindowInfoCompat getChild(int i) {
        return wrapNonNullInstance(((android.view.accessibility.AccessibilityWindowInfo) this.mInfo).getChild(i));
    }

    public int getChildCount() {
        return ((android.view.accessibility.AccessibilityWindowInfo) this.mInfo).getChildCount();
    }

    public int getId() {
        return ((android.view.accessibility.AccessibilityWindowInfo) this.mInfo).getId();
    }

    public int getLayer() {
        return ((android.view.accessibility.AccessibilityWindowInfo) this.mInfo).getLayer();
    }

    public androidx.core.view.accessibility.AccessibilityWindowInfoCompat getParent() {
        return wrapNonNullInstance(((android.view.accessibility.AccessibilityWindowInfo) this.mInfo).getParent());
    }

    public androidx.core.view.accessibility.AccessibilityNodeInfoCompat getRoot() {
        return androidx.core.view.accessibility.AccessibilityNodeInfoCompat.wrapNonNullInstance(((android.view.accessibility.AccessibilityWindowInfo) this.mInfo).getRoot());
    }

    public java.lang.CharSequence getTitle() {
        java.lang.CharSequence title;
        if (android.os.Build.VERSION.SDK_INT < 24) {
            return null;
        }
        title = ((android.view.accessibility.AccessibilityWindowInfo) this.mInfo).getTitle();
        return title;
    }

    public int getType() {
        return ((android.view.accessibility.AccessibilityWindowInfo) this.mInfo).getType();
    }

    public int hashCode() {
        java.lang.Object obj = this.mInfo;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public boolean isAccessibilityFocused() {
        return ((android.view.accessibility.AccessibilityWindowInfo) this.mInfo).isAccessibilityFocused();
    }

    public boolean isActive() {
        return ((android.view.accessibility.AccessibilityWindowInfo) this.mInfo).isActive();
    }

    public boolean isFocused() {
        return ((android.view.accessibility.AccessibilityWindowInfo) this.mInfo).isFocused();
    }

    public void recycle() {
        ((android.view.accessibility.AccessibilityWindowInfo) this.mInfo).recycle();
    }

    @androidx.annotation.NonNull
    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        android.graphics.Rect rect = new android.graphics.Rect();
        getBoundsInScreen(rect);
        sb.append("AccessibilityWindowInfo[");
        sb.append("id=");
        sb.append(getId());
        sb.append(", type=");
        sb.append(typeToString(getType()));
        sb.append(", layer=");
        sb.append(getLayer());
        sb.append(", bounds=");
        sb.append(rect);
        sb.append(", focused=");
        sb.append(isFocused());
        sb.append(", active=");
        sb.append(isActive());
        sb.append(", hasParent=");
        sb.append(getParent() != null);
        sb.append(", hasChildren=");
        sb.append(getChildCount() > 0);
        sb.append(']');
        return sb.toString();
    }
}
