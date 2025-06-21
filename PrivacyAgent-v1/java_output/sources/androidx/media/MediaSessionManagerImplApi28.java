package androidx.media;

@androidx.annotation.RequiresApi(28)
/* loaded from: classes.dex */
class MediaSessionManagerImplApi28 extends androidx.media.MediaSessionManagerImplApi21 {
    android.media.session.MediaSessionManager mObject;

    public static final class RemoteUserInfoImplApi28 implements androidx.media.MediaSessionManager.RemoteUserInfoImpl {
        final android.media.session.MediaSessionManager.RemoteUserInfo mObject;

        public RemoteUserInfoImplApi28(android.media.session.MediaSessionManager.RemoteUserInfo remoteUserInfo) {
            this.mObject = remoteUserInfo;
        }

        public RemoteUserInfoImplApi28(java.lang.String str, int i, int i2) {
            this.mObject = new android.media.session.MediaSessionManager.RemoteUserInfo(str, i, i2);
        }

        public boolean equals(java.lang.Object obj) {
            boolean equals;
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof androidx.media.MediaSessionManagerImplApi28.RemoteUserInfoImplApi28)) {
                return false;
            }
            equals = this.mObject.equals(((androidx.media.MediaSessionManagerImplApi28.RemoteUserInfoImplApi28) obj).mObject);
            return equals;
        }

        @Override // androidx.media.MediaSessionManager.RemoteUserInfoImpl
        public java.lang.String getPackageName() {
            java.lang.String packageName;
            packageName = this.mObject.getPackageName();
            return packageName;
        }

        @Override // androidx.media.MediaSessionManager.RemoteUserInfoImpl
        public int getPid() {
            int pid;
            pid = this.mObject.getPid();
            return pid;
        }

        @Override // androidx.media.MediaSessionManager.RemoteUserInfoImpl
        public int getUid() {
            int uid;
            uid = this.mObject.getUid();
            return uid;
        }

        public int hashCode() {
            return androidx.core.util.ObjectsCompat.hash(this.mObject);
        }
    }

    public MediaSessionManagerImplApi28(android.content.Context context) {
        super(context);
        this.mObject = (android.media.session.MediaSessionManager) context.getSystemService("media_session");
    }

    @Override // androidx.media.MediaSessionManagerImplApi21, androidx.media.MediaSessionManagerImplBase, androidx.media.MediaSessionManager.MediaSessionManagerImpl
    public boolean isTrustedForMediaControl(androidx.media.MediaSessionManager.RemoteUserInfoImpl remoteUserInfoImpl) {
        boolean isTrustedForMediaControl;
        if (!(remoteUserInfoImpl instanceof androidx.media.MediaSessionManagerImplApi28.RemoteUserInfoImplApi28)) {
            return false;
        }
        isTrustedForMediaControl = this.mObject.isTrustedForMediaControl(((androidx.media.MediaSessionManagerImplApi28.RemoteUserInfoImplApi28) remoteUserInfoImpl).mObject);
        return isTrustedForMediaControl;
    }
}
