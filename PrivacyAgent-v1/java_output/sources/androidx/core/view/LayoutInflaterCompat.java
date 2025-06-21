package androidx.core.view;

/* loaded from: classes.dex */
public final class LayoutInflaterCompat {
    private static final java.lang.String TAG = "LayoutInflaterCompatHC";
    private static boolean sCheckedField;
    private static java.lang.reflect.Field sLayoutInflaterFactory2Field;

    public static class Factory2Wrapper implements android.view.LayoutInflater.Factory2 {
        final androidx.core.view.LayoutInflaterFactory mDelegateFactory;

        public Factory2Wrapper(androidx.core.view.LayoutInflaterFactory layoutInflaterFactory) {
            this.mDelegateFactory = layoutInflaterFactory;
        }

        @Override // android.view.LayoutInflater.Factory2
        public android.view.View onCreateView(android.view.View view, java.lang.String str, android.content.Context context, android.util.AttributeSet attributeSet) {
            return this.mDelegateFactory.onCreateView(view, str, context, attributeSet);
        }

        @Override // android.view.LayoutInflater.Factory
        public android.view.View onCreateView(java.lang.String str, android.content.Context context, android.util.AttributeSet attributeSet) {
            return this.mDelegateFactory.onCreateView(null, str, context, attributeSet);
        }

        @androidx.annotation.NonNull
        public java.lang.String toString() {
            return getClass().getName() + "{" + this.mDelegateFactory + com.alipay.sdk.m.u.i.d;
        }
    }

    private LayoutInflaterCompat() {
    }

    private static void forceSetFactory2(android.view.LayoutInflater layoutInflater, android.view.LayoutInflater.Factory2 factory2) {
        if (!sCheckedField) {
            try {
                java.lang.reflect.Field declaredField = android.view.LayoutInflater.class.getDeclaredField("mFactory2");
                sLayoutInflaterFactory2Field = declaredField;
                declaredField.setAccessible(true);
            } catch (java.lang.NoSuchFieldException unused) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("forceSetFactory2 Could not find field 'mFactory2' on class ");
                sb.append(android.view.LayoutInflater.class.getName());
                sb.append("; inflation may have unexpected results.");
            }
            sCheckedField = true;
        }
        java.lang.reflect.Field field = sLayoutInflaterFactory2Field;
        if (field != null) {
            try {
                field.set(layoutInflater, factory2);
            } catch (java.lang.IllegalAccessException unused2) {
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                sb2.append("forceSetFactory2 could not set the Factory2 on LayoutInflater ");
                sb2.append(layoutInflater);
                sb2.append("; inflation may have unexpected results.");
            }
        }
    }

    @java.lang.Deprecated
    public static androidx.core.view.LayoutInflaterFactory getFactory(android.view.LayoutInflater layoutInflater) {
        android.view.LayoutInflater.Factory factory = layoutInflater.getFactory();
        if (factory instanceof androidx.core.view.LayoutInflaterCompat.Factory2Wrapper) {
            return ((androidx.core.view.LayoutInflaterCompat.Factory2Wrapper) factory).mDelegateFactory;
        }
        return null;
    }

    @java.lang.Deprecated
    public static void setFactory(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.NonNull androidx.core.view.LayoutInflaterFactory layoutInflaterFactory) {
        layoutInflater.setFactory2(layoutInflaterFactory != null ? new androidx.core.view.LayoutInflaterCompat.Factory2Wrapper(layoutInflaterFactory) : null);
    }

    public static void setFactory2(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.NonNull android.view.LayoutInflater.Factory2 factory2) {
        layoutInflater.setFactory2(factory2);
    }
}
