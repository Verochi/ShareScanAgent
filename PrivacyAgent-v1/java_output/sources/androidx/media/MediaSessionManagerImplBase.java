package androidx.media;

/* loaded from: classes.dex */
class MediaSessionManagerImplBase implements androidx.media.MediaSessionManager.MediaSessionManagerImpl {
    private static final boolean DEBUG = androidx.media.MediaSessionManager.DEBUG;
    private static final java.lang.String ENABLED_NOTIFICATION_LISTENERS = "enabled_notification_listeners";
    private static final java.lang.String PERMISSION_MEDIA_CONTENT_CONTROL = "android.permission.MEDIA_CONTENT_CONTROL";
    private static final java.lang.String PERMISSION_STATUS_BAR_SERVICE = "android.permission.STATUS_BAR_SERVICE";
    private static final java.lang.String TAG = "MediaSessionManager";
    android.content.ContentResolver mContentResolver;
    android.content.Context mContext;

    public static class RemoteUserInfoImplBase implements androidx.media.MediaSessionManager.RemoteUserInfoImpl {
        private java.lang.String mPackageName;
        private int mPid;
        private int mUid;

        public RemoteUserInfoImplBase(java.lang.String str, int i, int i2) {
            this.mPackageName = str;
            this.mPid = i;
            this.mUid = i2;
        }

        public boolean equals(java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof androidx.media.MediaSessionManagerImplBase.RemoteUserInfoImplBase)) {
                return false;
            }
            androidx.media.MediaSessionManagerImplBase.RemoteUserInfoImplBase remoteUserInfoImplBase = (androidx.media.MediaSessionManagerImplBase.RemoteUserInfoImplBase) obj;
            return android.text.TextUtils.equals(this.mPackageName, remoteUserInfoImplBase.mPackageName) && this.mPid == remoteUserInfoImplBase.mPid && this.mUid == remoteUserInfoImplBase.mUid;
        }

        @Override // androidx.media.MediaSessionManager.RemoteUserInfoImpl
        public java.lang.String getPackageName() {
            return this.mPackageName;
        }

        @Override // androidx.media.MediaSessionManager.RemoteUserInfoImpl
        public int getPid() {
            return this.mPid;
        }

        @Override // androidx.media.MediaSessionManager.RemoteUserInfoImpl
        public int getUid() {
            return this.mUid;
        }

        public int hashCode() {
            return androidx.core.util.ObjectsCompat.hash(this.mPackageName, java.lang.Integer.valueOf(this.mPid), java.lang.Integer.valueOf(this.mUid));
        }
    }

    public MediaSessionManagerImplBase(android.content.Context context) {
        this.mContext = context;
        this.mContentResolver = context.getContentResolver();
    }

    private boolean isPermissionGranted(androidx.media.MediaSessionManager.RemoteUserInfoImpl remoteUserInfoImpl, java.lang.String str) {
        return remoteUserInfoImpl.getPid() < 0 ? this.mContext.getPackageManager().checkPermission(str, remoteUserInfoImpl.getPackageName()) == 0 : this.mContext.checkPermission(str, remoteUserInfoImpl.getPid(), remoteUserInfoImpl.getUid()) == 0;
    }

    @Override // androidx.media.MediaSessionManager.MediaSessionManagerImpl
    public android.content.Context getContext() {
        return this.mContext;
    }

    public boolean isEnabledNotificationListener(@androidx.annotation.NonNull androidx.media.MediaSessionManager.RemoteUserInfoImpl remoteUserInfoImpl) {
        java.lang.String string = android.provider.Settings.Secure.getString(this.mContentResolver, ENABLED_NOTIFICATION_LISTENERS);
        if (string != null) {
            for (java.lang.String str : string.split(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR)) {
                android.content.ComponentName unflattenFromString = android.content.ComponentName.unflattenFromString(str);
                if (unflattenFromString != null && unflattenFromString.getPackageName().equals(remoteUserInfoImpl.getPackageName())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // androidx.media.MediaSessionManager.MediaSessionManagerImpl
    public boolean isTrustedForMediaControl(@androidx.annotation.NonNull androidx.media.MediaSessionManager.RemoteUserInfoImpl remoteUserInfoImpl) {
        try {
            if (this.mContext.getPackageManager().getApplicationInfo(remoteUserInfoImpl.getPackageName(), 0).uid == remoteUserInfoImpl.getUid()) {
                return isPermissionGranted(remoteUserInfoImpl, PERMISSION_STATUS_BAR_SERVICE) || isPermissionGranted(remoteUserInfoImpl, PERMISSION_MEDIA_CONTENT_CONTROL) || remoteUserInfoImpl.getUid() == 1000 || isEnabledNotificationListener(remoteUserInfoImpl);
            }
            if (DEBUG) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("Package name ");
                sb.append(remoteUserInfoImpl.getPackageName());
                sb.append(" doesn't match with the uid ");
                sb.append(remoteUserInfoImpl.getUid());
            }
            return false;
        } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
            if (DEBUG) {
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                sb2.append("Package ");
                sb2.append(remoteUserInfoImpl.getPackageName());
                sb2.append(" doesn't exist");
            }
            return false;
        }
    }
}
