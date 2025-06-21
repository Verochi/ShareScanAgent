package androidx.media;

@androidx.annotation.RequiresApi(21)
/* loaded from: classes.dex */
class MediaSessionManagerImplApi21 extends androidx.media.MediaSessionManagerImplBase {
    public MediaSessionManagerImplApi21(android.content.Context context) {
        super(context);
        this.mContext = context;
    }

    private boolean hasMediaControlPermission(@androidx.annotation.NonNull androidx.media.MediaSessionManager.RemoteUserInfoImpl remoteUserInfoImpl) {
        return getContext().checkPermission("android.permission.MEDIA_CONTENT_CONTROL", remoteUserInfoImpl.getPid(), remoteUserInfoImpl.getUid()) == 0;
    }

    @Override // androidx.media.MediaSessionManagerImplBase, androidx.media.MediaSessionManager.MediaSessionManagerImpl
    public boolean isTrustedForMediaControl(@androidx.annotation.NonNull androidx.media.MediaSessionManager.RemoteUserInfoImpl remoteUserInfoImpl) {
        return hasMediaControlPermission(remoteUserInfoImpl) || super.isTrustedForMediaControl(remoteUserInfoImpl);
    }
}
