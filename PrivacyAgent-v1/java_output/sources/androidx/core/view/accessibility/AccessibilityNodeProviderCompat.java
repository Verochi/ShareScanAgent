package androidx.core.view.accessibility;

/* loaded from: classes.dex */
public class AccessibilityNodeProviderCompat {
    public static final int HOST_VIEW_ID = -1;
    private final java.lang.Object mProvider;

    @androidx.annotation.RequiresApi(16)
    public static class AccessibilityNodeProviderApi16 extends android.view.accessibility.AccessibilityNodeProvider {
        final androidx.core.view.accessibility.AccessibilityNodeProviderCompat mCompat;

        public AccessibilityNodeProviderApi16(androidx.core.view.accessibility.AccessibilityNodeProviderCompat accessibilityNodeProviderCompat) {
            this.mCompat = accessibilityNodeProviderCompat;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public android.view.accessibility.AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
            androidx.core.view.accessibility.AccessibilityNodeInfoCompat createAccessibilityNodeInfo = this.mCompat.createAccessibilityNodeInfo(i);
            if (createAccessibilityNodeInfo == null) {
                return null;
            }
            return createAccessibilityNodeInfo.unwrap();
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public java.util.List<android.view.accessibility.AccessibilityNodeInfo> findAccessibilityNodeInfosByText(java.lang.String str, int i) {
            java.util.List<androidx.core.view.accessibility.AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByText = this.mCompat.findAccessibilityNodeInfosByText(str, i);
            if (findAccessibilityNodeInfosByText == null) {
                return null;
            }
            java.util.ArrayList arrayList = new java.util.ArrayList();
            int size = findAccessibilityNodeInfosByText.size();
            for (int i2 = 0; i2 < size; i2++) {
                arrayList.add(findAccessibilityNodeInfosByText.get(i2).unwrap());
            }
            return arrayList;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public boolean performAction(int i, int i2, android.os.Bundle bundle) {
            return this.mCompat.performAction(i, i2, bundle);
        }
    }

    @androidx.annotation.RequiresApi(19)
    public static class AccessibilityNodeProviderApi19 extends androidx.core.view.accessibility.AccessibilityNodeProviderCompat.AccessibilityNodeProviderApi16 {
        public AccessibilityNodeProviderApi19(androidx.core.view.accessibility.AccessibilityNodeProviderCompat accessibilityNodeProviderCompat) {
            super(accessibilityNodeProviderCompat);
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public android.view.accessibility.AccessibilityNodeInfo findFocus(int i) {
            androidx.core.view.accessibility.AccessibilityNodeInfoCompat findFocus = this.mCompat.findFocus(i);
            if (findFocus == null) {
                return null;
            }
            return findFocus.unwrap();
        }
    }

    @androidx.annotation.RequiresApi(26)
    public static class AccessibilityNodeProviderApi26 extends androidx.core.view.accessibility.AccessibilityNodeProviderCompat.AccessibilityNodeProviderApi19 {
        public AccessibilityNodeProviderApi26(androidx.core.view.accessibility.AccessibilityNodeProviderCompat accessibilityNodeProviderCompat) {
            super(accessibilityNodeProviderCompat);
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public void addExtraDataToAccessibilityNodeInfo(int i, android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo, java.lang.String str, android.os.Bundle bundle) {
            this.mCompat.addExtraDataToAccessibilityNodeInfo(i, androidx.core.view.accessibility.AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo), str, bundle);
        }
    }

    public AccessibilityNodeProviderCompat() {
        if (android.os.Build.VERSION.SDK_INT >= 26) {
            this.mProvider = new androidx.core.view.accessibility.AccessibilityNodeProviderCompat.AccessibilityNodeProviderApi26(this);
        } else {
            this.mProvider = new androidx.core.view.accessibility.AccessibilityNodeProviderCompat.AccessibilityNodeProviderApi19(this);
        }
    }

    public AccessibilityNodeProviderCompat(java.lang.Object obj) {
        this.mProvider = obj;
    }

    public void addExtraDataToAccessibilityNodeInfo(int i, @androidx.annotation.NonNull androidx.core.view.accessibility.AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, @androidx.annotation.NonNull java.lang.String str, @androidx.annotation.Nullable android.os.Bundle bundle) {
    }

    @androidx.annotation.Nullable
    public androidx.core.view.accessibility.AccessibilityNodeInfoCompat createAccessibilityNodeInfo(int i) {
        return null;
    }

    @androidx.annotation.Nullable
    public java.util.List<androidx.core.view.accessibility.AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByText(java.lang.String str, int i) {
        return null;
    }

    @androidx.annotation.Nullable
    public androidx.core.view.accessibility.AccessibilityNodeInfoCompat findFocus(int i) {
        return null;
    }

    public java.lang.Object getProvider() {
        return this.mProvider;
    }

    public boolean performAction(int i, int i2, android.os.Bundle bundle) {
        return false;
    }
}
