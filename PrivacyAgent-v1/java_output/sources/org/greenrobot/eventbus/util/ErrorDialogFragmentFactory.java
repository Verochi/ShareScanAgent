package org.greenrobot.eventbus.util;

/* loaded from: classes26.dex */
public abstract class ErrorDialogFragmentFactory<T> {
    protected final org.greenrobot.eventbus.util.ErrorDialogConfig config;

    @android.annotation.TargetApi(11)
    public static class Honeycomb extends org.greenrobot.eventbus.util.ErrorDialogFragmentFactory<android.app.Fragment> {
        public Honeycomb(org.greenrobot.eventbus.util.ErrorDialogConfig errorDialogConfig) {
            super(errorDialogConfig);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.greenrobot.eventbus.util.ErrorDialogFragmentFactory
        public android.app.Fragment createErrorFragment(org.greenrobot.eventbus.util.ThrowableFailureEvent throwableFailureEvent, android.os.Bundle bundle) {
            org.greenrobot.eventbus.util.ErrorDialogFragments.Honeycomb honeycomb = new org.greenrobot.eventbus.util.ErrorDialogFragments.Honeycomb();
            honeycomb.setArguments(bundle);
            return honeycomb;
        }
    }

    public static class Support extends org.greenrobot.eventbus.util.ErrorDialogFragmentFactory<androidx.fragment.app.Fragment> {
        public Support(org.greenrobot.eventbus.util.ErrorDialogConfig errorDialogConfig) {
            super(errorDialogConfig);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.greenrobot.eventbus.util.ErrorDialogFragmentFactory
        public androidx.fragment.app.Fragment createErrorFragment(org.greenrobot.eventbus.util.ThrowableFailureEvent throwableFailureEvent, android.os.Bundle bundle) {
            org.greenrobot.eventbus.util.ErrorDialogFragments.Support support = new org.greenrobot.eventbus.util.ErrorDialogFragments.Support();
            support.setArguments(bundle);
            return support;
        }
    }

    public ErrorDialogFragmentFactory(org.greenrobot.eventbus.util.ErrorDialogConfig errorDialogConfig) {
        this.config = errorDialogConfig;
    }

    public abstract T createErrorFragment(org.greenrobot.eventbus.util.ThrowableFailureEvent throwableFailureEvent, android.os.Bundle bundle);

    public java.lang.String getMessageFor(org.greenrobot.eventbus.util.ThrowableFailureEvent throwableFailureEvent, android.os.Bundle bundle) {
        return this.config.a.getString(this.config.getMessageIdForThrowable(throwableFailureEvent.throwable));
    }

    public java.lang.String getTitleFor(org.greenrobot.eventbus.util.ThrowableFailureEvent throwableFailureEvent, android.os.Bundle bundle) {
        org.greenrobot.eventbus.util.ErrorDialogConfig errorDialogConfig = this.config;
        return errorDialogConfig.a.getString(errorDialogConfig.b);
    }

    public T prepareErrorFragment(org.greenrobot.eventbus.util.ThrowableFailureEvent throwableFailureEvent, boolean z, android.os.Bundle bundle) {
        int i;
        java.lang.Class<?> cls;
        if (throwableFailureEvent.isSuppressErrorUi()) {
            return null;
        }
        android.os.Bundle bundle2 = bundle != null ? (android.os.Bundle) bundle.clone() : new android.os.Bundle();
        if (!bundle2.containsKey(org.greenrobot.eventbus.util.ErrorDialogManager.KEY_TITLE)) {
            bundle2.putString(org.greenrobot.eventbus.util.ErrorDialogManager.KEY_TITLE, getTitleFor(throwableFailureEvent, bundle2));
        }
        if (!bundle2.containsKey(org.greenrobot.eventbus.util.ErrorDialogManager.KEY_MESSAGE)) {
            bundle2.putString(org.greenrobot.eventbus.util.ErrorDialogManager.KEY_MESSAGE, getMessageFor(throwableFailureEvent, bundle2));
        }
        if (!bundle2.containsKey(org.greenrobot.eventbus.util.ErrorDialogManager.KEY_FINISH_AFTER_DIALOG)) {
            bundle2.putBoolean(org.greenrobot.eventbus.util.ErrorDialogManager.KEY_FINISH_AFTER_DIALOG, z);
        }
        if (!bundle2.containsKey(org.greenrobot.eventbus.util.ErrorDialogManager.KEY_EVENT_TYPE_ON_CLOSE) && (cls = this.config.i) != null) {
            bundle2.putSerializable(org.greenrobot.eventbus.util.ErrorDialogManager.KEY_EVENT_TYPE_ON_CLOSE, cls);
        }
        if (!bundle2.containsKey(org.greenrobot.eventbus.util.ErrorDialogManager.KEY_ICON_ID) && (i = this.config.h) != 0) {
            bundle2.putInt(org.greenrobot.eventbus.util.ErrorDialogManager.KEY_ICON_ID, i);
        }
        return createErrorFragment(throwableFailureEvent, bundle2);
    }
}
