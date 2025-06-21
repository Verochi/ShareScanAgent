package androidx.databinding.adapters;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class TabHostBindingAdapter {

    /* renamed from: androidx.databinding.adapters.TabHostBindingAdapter$1, reason: invalid class name */
    public class AnonymousClass1 implements android.widget.TabHost.OnTabChangeListener {
        final /* synthetic */ androidx.databinding.InverseBindingListener val$attrChange;
        final /* synthetic */ android.widget.TabHost.OnTabChangeListener val$listener;

        public AnonymousClass1(android.widget.TabHost.OnTabChangeListener onTabChangeListener, androidx.databinding.InverseBindingListener inverseBindingListener) {
            this.val$listener = onTabChangeListener;
            this.val$attrChange = inverseBindingListener;
        }

        @Override // android.widget.TabHost.OnTabChangeListener
        public void onTabChanged(java.lang.String str) {
            android.widget.TabHost.OnTabChangeListener onTabChangeListener = this.val$listener;
            if (onTabChangeListener != null) {
                onTabChangeListener.onTabChanged(str);
            }
            this.val$attrChange.onChange();
        }
    }

    @androidx.databinding.InverseBindingAdapter(attribute = "android:currentTab")
    public static int getCurrentTab(android.widget.TabHost tabHost) {
        return tabHost.getCurrentTab();
    }

    @androidx.databinding.InverseBindingAdapter(attribute = "android:currentTab")
    public static java.lang.String getCurrentTabTag(android.widget.TabHost tabHost) {
        return tabHost.getCurrentTabTag();
    }

    @androidx.databinding.BindingAdapter({"android:currentTab"})
    public static void setCurrentTab(android.widget.TabHost tabHost, int i) {
        if (tabHost.getCurrentTab() != i) {
            tabHost.setCurrentTab(i);
        }
    }

    @androidx.databinding.BindingAdapter({"android:currentTab"})
    public static void setCurrentTabTag(android.widget.TabHost tabHost, java.lang.String str) {
        java.lang.String currentTabTag = tabHost.getCurrentTabTag();
        if ((currentTabTag == null || currentTabTag.equals(str)) && (currentTabTag != null || str == null)) {
            return;
        }
        tabHost.setCurrentTabByTag(str);
    }

    @androidx.databinding.BindingAdapter(requireAll = false, value = {"android:onTabChanged", "android:currentTabAttrChanged"})
    public static void setListeners(android.widget.TabHost tabHost, android.widget.TabHost.OnTabChangeListener onTabChangeListener, androidx.databinding.InverseBindingListener inverseBindingListener) {
        if (inverseBindingListener == null) {
            tabHost.setOnTabChangedListener(onTabChangeListener);
        } else {
            tabHost.setOnTabChangedListener(new androidx.databinding.adapters.TabHostBindingAdapter.AnonymousClass1(onTabChangeListener, inverseBindingListener));
        }
    }
}
