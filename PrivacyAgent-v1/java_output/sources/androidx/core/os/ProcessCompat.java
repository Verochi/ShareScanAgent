package androidx.core.os;

/* loaded from: classes.dex */
public final class ProcessCompat {

    @androidx.annotation.RequiresApi(16)
    public static class Api16Impl {
        private static java.lang.reflect.Method sMethodUserIdIsAppMethod;
        private static boolean sResolved;
        private static final java.lang.Object sResolvedLock = new java.lang.Object();

        private Api16Impl() {
        }

        @android.annotation.SuppressLint({"PrivateApi"})
        public static boolean isApplicationUid(int i) {
            try {
                synchronized (sResolvedLock) {
                    if (!sResolved) {
                        sResolved = true;
                        sMethodUserIdIsAppMethod = java.lang.Class.forName("android.os.UserId").getDeclaredMethod("isApp", java.lang.Integer.TYPE);
                    }
                }
                java.lang.reflect.Method method = sMethodUserIdIsAppMethod;
                if (method != null) {
                    java.lang.Boolean bool = (java.lang.Boolean) method.invoke(null, java.lang.Integer.valueOf(i));
                    if (bool != null) {
                        return bool.booleanValue();
                    }
                    throw new java.lang.NullPointerException();
                }
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
            return true;
        }
    }

    @androidx.annotation.RequiresApi(17)
    public static class Api17Impl {
        private static java.lang.reflect.Method sMethodUserHandleIsAppMethod;
        private static boolean sResolved;
        private static final java.lang.Object sResolvedLock = new java.lang.Object();

        private Api17Impl() {
        }

        @android.annotation.SuppressLint({"DiscouragedPrivateApi"})
        public static boolean isApplicationUid(int i) {
            try {
                synchronized (sResolvedLock) {
                    if (!sResolved) {
                        sResolved = true;
                        sMethodUserHandleIsAppMethod = android.os.UserHandle.class.getDeclaredMethod("isApp", java.lang.Integer.TYPE);
                    }
                }
                java.lang.reflect.Method method = sMethodUserHandleIsAppMethod;
                if (method != null && ((java.lang.Boolean) method.invoke(null, java.lang.Integer.valueOf(i))) == null) {
                    throw new java.lang.NullPointerException();
                }
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
            return true;
        }
    }

    @androidx.annotation.RequiresApi(24)
    public static class Api24Impl {
        private Api24Impl() {
        }

        public static boolean isApplicationUid(int i) {
            boolean isApplicationUid;
            isApplicationUid = android.os.Process.isApplicationUid(i);
            return isApplicationUid;
        }
    }

    private ProcessCompat() {
    }

    public static boolean isApplicationUid(int i) {
        return android.os.Build.VERSION.SDK_INT >= 24 ? androidx.core.os.ProcessCompat.Api24Impl.isApplicationUid(i) : androidx.core.os.ProcessCompat.Api17Impl.isApplicationUid(i);
    }
}
