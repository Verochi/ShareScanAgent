package androidx.core.view;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class KeyEventDispatcher {
    private static boolean sActionBarFieldsFetched;
    private static java.lang.reflect.Method sActionBarOnMenuKeyMethod;
    private static boolean sDialogFieldsFetched;
    private static java.lang.reflect.Field sDialogKeyListenerField;

    public interface Component {
        boolean superDispatchKeyEvent(android.view.KeyEvent keyEvent);
    }

    private KeyEventDispatcher() {
    }

    private static boolean actionBarOnMenuKeyEventPre28(android.app.ActionBar actionBar, android.view.KeyEvent keyEvent) {
        if (!sActionBarFieldsFetched) {
            try {
                sActionBarOnMenuKeyMethod = actionBar.getClass().getMethod("onMenuKeyEvent", android.view.KeyEvent.class);
            } catch (java.lang.NoSuchMethodException unused) {
            }
            sActionBarFieldsFetched = true;
        }
        java.lang.reflect.Method method = sActionBarOnMenuKeyMethod;
        if (method != null) {
            try {
                return ((java.lang.Boolean) method.invoke(actionBar, keyEvent)).booleanValue();
            } catch (java.lang.IllegalAccessException | java.lang.reflect.InvocationTargetException unused2) {
            }
        }
        return false;
    }

    private static boolean activitySuperDispatchKeyEventPre28(android.app.Activity activity, android.view.KeyEvent keyEvent) {
        activity.onUserInteraction();
        android.view.Window window = activity.getWindow();
        if (window.hasFeature(8)) {
            android.app.ActionBar actionBar = activity.getActionBar();
            if (keyEvent.getKeyCode() == 82 && actionBar != null && actionBarOnMenuKeyEventPre28(actionBar, keyEvent)) {
                return true;
            }
        }
        if (window.superDispatchKeyEvent(keyEvent)) {
            return true;
        }
        android.view.View decorView = window.getDecorView();
        if (androidx.core.view.ViewCompat.dispatchUnhandledKeyEventBeforeCallback(decorView, keyEvent)) {
            return true;
        }
        return keyEvent.dispatch(activity, decorView != null ? decorView.getKeyDispatcherState() : null, activity);
    }

    private static boolean dialogSuperDispatchKeyEventPre28(android.app.Dialog dialog, android.view.KeyEvent keyEvent) {
        android.content.DialogInterface.OnKeyListener dialogKeyListenerPre28 = getDialogKeyListenerPre28(dialog);
        if (dialogKeyListenerPre28 != null && dialogKeyListenerPre28.onKey(dialog, keyEvent.getKeyCode(), keyEvent)) {
            return true;
        }
        android.view.Window window = dialog.getWindow();
        if (window.superDispatchKeyEvent(keyEvent)) {
            return true;
        }
        android.view.View decorView = window.getDecorView();
        if (androidx.core.view.ViewCompat.dispatchUnhandledKeyEventBeforeCallback(decorView, keyEvent)) {
            return true;
        }
        return keyEvent.dispatch(dialog, decorView != null ? decorView.getKeyDispatcherState() : null, dialog);
    }

    public static boolean dispatchBeforeHierarchy(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull android.view.KeyEvent keyEvent) {
        return androidx.core.view.ViewCompat.dispatchUnhandledKeyEventBeforeHierarchy(view, keyEvent);
    }

    public static boolean dispatchKeyEvent(@androidx.annotation.NonNull androidx.core.view.KeyEventDispatcher.Component component, @androidx.annotation.Nullable android.view.View view, @androidx.annotation.Nullable android.view.Window.Callback callback, @androidx.annotation.NonNull android.view.KeyEvent keyEvent) {
        if (component == null) {
            return false;
        }
        return android.os.Build.VERSION.SDK_INT >= 28 ? component.superDispatchKeyEvent(keyEvent) : callback instanceof android.app.Activity ? activitySuperDispatchKeyEventPre28((android.app.Activity) callback, keyEvent) : callback instanceof android.app.Dialog ? dialogSuperDispatchKeyEventPre28((android.app.Dialog) callback, keyEvent) : (view != null && androidx.core.view.ViewCompat.dispatchUnhandledKeyEventBeforeCallback(view, keyEvent)) || component.superDispatchKeyEvent(keyEvent);
    }

    private static android.content.DialogInterface.OnKeyListener getDialogKeyListenerPre28(android.app.Dialog dialog) {
        if (!sDialogFieldsFetched) {
            try {
                java.lang.reflect.Field declaredField = android.app.Dialog.class.getDeclaredField("mOnKeyListener");
                sDialogKeyListenerField = declaredField;
                declaredField.setAccessible(true);
            } catch (java.lang.NoSuchFieldException unused) {
            }
            sDialogFieldsFetched = true;
        }
        java.lang.reflect.Field field = sDialogKeyListenerField;
        if (field == null) {
            return null;
        }
        try {
            return (android.content.DialogInterface.OnKeyListener) field.get(dialog);
        } catch (java.lang.IllegalAccessException unused2) {
            return null;
        }
    }
}
