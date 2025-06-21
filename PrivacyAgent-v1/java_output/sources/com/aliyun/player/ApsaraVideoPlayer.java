package com.aliyun.player;

/* loaded from: classes.dex */
class ApsaraVideoPlayer extends com.aliyun.player.UrlVideoPlayer implements com.aliyun.player.AliPlayer {
    private com.aliyun.player.AliPlayer.OnVerifyTimeExpireCallback mInnerOnVerifyTimeExpireCallback;
    private com.aliyun.player.AliPlayer.OnVerifyTimeExpireCallback mOutOnVerifyCallback;

    public static class InnerOnVerifyTimeExpireCallback implements com.aliyun.player.AliPlayer.OnVerifyTimeExpireCallback {
        private java.lang.ref.WeakReference<com.aliyun.player.ApsaraVideoPlayer> avpBaseWR;

        public InnerOnVerifyTimeExpireCallback(com.aliyun.player.ApsaraVideoPlayer apsaraVideoPlayer) {
            this.avpBaseWR = new java.lang.ref.WeakReference<>(apsaraVideoPlayer);
        }

        @Override // com.aliyun.player.AliPlayer.OnVerifyTimeExpireCallback
        public com.aliyun.player.AliPlayer.Status onVerifyAuth(com.aliyun.player.source.VidAuth vidAuth) {
            com.aliyun.player.ApsaraVideoPlayer apsaraVideoPlayer = this.avpBaseWR.get();
            return apsaraVideoPlayer != null ? apsaraVideoPlayer.onVerifyAuth(vidAuth) : com.aliyun.player.AliPlayer.Status.Invalid;
        }

        @Override // com.aliyun.player.AliPlayer.OnVerifyTimeExpireCallback
        public com.aliyun.player.AliPlayer.Status onVerifySts(com.aliyun.player.source.StsInfo stsInfo) {
            com.aliyun.player.ApsaraVideoPlayer apsaraVideoPlayer = this.avpBaseWR.get();
            return apsaraVideoPlayer != null ? apsaraVideoPlayer.onVerifySts(stsInfo) : com.aliyun.player.AliPlayer.Status.Invalid;
        }
    }

    public ApsaraVideoPlayer(android.content.Context context, java.lang.String str) {
        super(context, str);
        this.mOutOnVerifyCallback = null;
        this.mInnerOnVerifyTimeExpireCallback = new com.aliyun.player.ApsaraVideoPlayer.InnerOnVerifyTimeExpireCallback(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.aliyun.player.AliPlayer.Status onVerifyAuth(com.aliyun.player.source.VidAuth vidAuth) {
        com.aliyun.player.AliPlayer.OnVerifyTimeExpireCallback onVerifyTimeExpireCallback = this.mOutOnVerifyCallback;
        return onVerifyTimeExpireCallback != null ? onVerifyTimeExpireCallback.onVerifyAuth(vidAuth) : com.aliyun.player.AliPlayer.Status.Invalid;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.aliyun.player.AliPlayer.Status onVerifySts(com.aliyun.player.source.StsInfo stsInfo) {
        com.aliyun.player.AliPlayer.OnVerifyTimeExpireCallback onVerifyTimeExpireCallback = this.mOutOnVerifyCallback;
        return onVerifyTimeExpireCallback != null ? onVerifyTimeExpireCallback.onVerifySts(stsInfo) : com.aliyun.player.AliPlayer.Status.Invalid;
    }

    @Override // com.aliyun.player.UrlVideoPlayer, com.aliyun.player.AVPBase
    public com.aliyun.player.nativeclass.NativePlayerBase createAlivcMediaPlayer(android.content.Context context) {
        com.aliyun.player.nativeclass.JniSaasPlayer jniSaasPlayer = new com.aliyun.player.nativeclass.JniSaasPlayer(context);
        if (this.mInnerOnVerifyTimeExpireCallback == null) {
            this.mInnerOnVerifyTimeExpireCallback = new com.aliyun.player.ApsaraVideoPlayer.InnerOnVerifyTimeExpireCallback(this);
        }
        jniSaasPlayer.setOnVerifyTimeExpireCallback(this.mInnerOnVerifyTimeExpireCallback);
        return jniSaasPlayer;
    }

    @Override // com.aliyun.player.AliPlayer
    public void invokeComponent(java.lang.String str) {
        com.aliyun.player.nativeclass.NativePlayerBase corePlayer = getCorePlayer();
        if (corePlayer instanceof com.aliyun.player.nativeclass.JniSaasPlayer) {
            ((com.aliyun.player.nativeclass.JniSaasPlayer) corePlayer).invokeComponent(str);
        }
    }

    @Override // com.aliyun.player.AliPlayer
    public void setDataSource(com.aliyun.player.source.LiveSts liveSts) {
        com.aliyun.player.nativeclass.NativePlayerBase corePlayer = getCorePlayer();
        if (corePlayer instanceof com.aliyun.player.nativeclass.JniSaasPlayer) {
            ((com.aliyun.player.nativeclass.JniSaasPlayer) corePlayer).setDataSource(liveSts);
        }
    }

    @Override // com.aliyun.player.AliPlayer
    public void setDataSource(com.aliyun.player.source.VidAuth vidAuth) {
        com.aliyun.player.nativeclass.NativePlayerBase corePlayer = getCorePlayer();
        if (corePlayer instanceof com.aliyun.player.nativeclass.JniSaasPlayer) {
            ((com.aliyun.player.nativeclass.JniSaasPlayer) corePlayer).setDataSource(vidAuth);
        }
    }

    @Override // com.aliyun.player.AliPlayer
    public void setDataSource(com.aliyun.player.source.VidMps vidMps) {
        com.aliyun.player.nativeclass.NativePlayerBase corePlayer = getCorePlayer();
        if (corePlayer instanceof com.aliyun.player.nativeclass.JniSaasPlayer) {
            ((com.aliyun.player.nativeclass.JniSaasPlayer) corePlayer).setDataSource(vidMps);
        }
    }

    @Override // com.aliyun.player.AliPlayer
    public void setDataSource(com.aliyun.player.source.VidSts vidSts) {
        com.aliyun.player.nativeclass.NativePlayerBase corePlayer = getCorePlayer();
        if (corePlayer instanceof com.aliyun.player.nativeclass.JniSaasPlayer) {
            ((com.aliyun.player.nativeclass.JniSaasPlayer) corePlayer).setDataSource(vidSts);
        }
    }

    @Override // com.aliyun.player.AliPlayer
    public void setOnVerifyTimeExpireCallback(com.aliyun.player.AliPlayer.OnVerifyTimeExpireCallback onVerifyTimeExpireCallback) {
        this.mOutOnVerifyCallback = onVerifyTimeExpireCallback;
    }

    @Override // com.aliyun.player.AliPlayer
    public void updateStsInfo(com.aliyun.player.source.StsInfo stsInfo) {
        com.aliyun.player.nativeclass.NativePlayerBase corePlayer = getCorePlayer();
        if (corePlayer instanceof com.aliyun.player.nativeclass.JniSaasPlayer) {
            ((com.aliyun.player.nativeclass.JniSaasPlayer) corePlayer).updateStsInfo(stsInfo);
        }
    }

    @Override // com.aliyun.player.AliPlayer
    public void updateVidAuth(com.aliyun.player.source.VidAuth vidAuth) {
        com.aliyun.player.nativeclass.NativePlayerBase corePlayer = getCorePlayer();
        if (corePlayer instanceof com.aliyun.player.nativeclass.JniSaasPlayer) {
            ((com.aliyun.player.nativeclass.JniSaasPlayer) corePlayer).updateVidAuth(vidAuth);
        }
    }
}
