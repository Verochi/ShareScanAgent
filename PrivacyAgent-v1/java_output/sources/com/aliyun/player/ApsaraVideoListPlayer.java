package com.aliyun.player;

/* loaded from: classes.dex */
class ApsaraVideoListPlayer extends com.aliyun.player.UrlVideoListPlayer implements com.aliyun.player.AliListPlayer, com.aliyun.player.AliPlayer {
    private static final java.lang.String TAG = "NativePlayerBase_ApsaraVideListPlayer";
    private com.aliyun.player.ApsaraVideoPlayer mSaaSPrerenderPlayer;
    private com.aliyun.player.ApsaraVideoPlayer mSaasVideoPlayer;

    public ApsaraVideoListPlayer(android.content.Context context, java.lang.String str) {
        super(context, str);
        this.mSaasVideoPlayer = null;
        this.mSaaSPrerenderPlayer = null;
    }

    @Override // com.aliyun.player.AliListPlayer
    public void addVid(java.lang.String str, java.lang.String str2) {
        com.aliyun.player.nativeclass.JniListPlayerBase corePlayer = getCorePlayer();
        if (corePlayer instanceof com.aliyun.player.nativeclass.JniSaasListPlayer) {
            com.cicada.player.utils.Logger.v(TAG, "addVid = " + str + " , uid = " + str2);
            ((com.aliyun.player.nativeclass.JniSaasListPlayer) corePlayer).addVid(str, str2);
        }
    }

    @Override // com.aliyun.player.UrlVideoListPlayer, com.aliyun.player.AVPLBase
    public com.aliyun.player.nativeclass.JniListPlayerBase createListPlayer(android.content.Context context, java.lang.String str, long j, long j2) {
        return new com.aliyun.player.nativeclass.JniSaasListPlayer(context, j, j2);
    }

    @Override // com.aliyun.player.UrlVideoListPlayer, com.aliyun.player.AVPLBase
    public long getCurrentPlayerIndex() {
        com.aliyun.player.nativeclass.JniListPlayerBase corePlayer = getCorePlayer();
        if (!(corePlayer instanceof com.aliyun.player.nativeclass.JniSaasListPlayer)) {
            return 0L;
        }
        com.cicada.player.utils.Logger.v(TAG, "getCurrentPlayerIndex  ");
        return ((com.aliyun.player.nativeclass.JniSaasListPlayer) corePlayer).getCurrentPlayerIndex();
    }

    @Override // com.aliyun.player.UrlVideoListPlayer, com.aliyun.player.AVPLBase
    public com.aliyun.player.IPlayer getNativePlayer(android.content.Context context, java.lang.String str) {
        if (this.mSaasVideoPlayer == null) {
            this.mSaasVideoPlayer = new com.aliyun.player.ApsaraVideoPlayer(context, str);
        }
        return this.mSaasVideoPlayer;
    }

    @Override // com.aliyun.player.UrlVideoListPlayer, com.aliyun.player.UrlListPlayer
    public com.aliyun.player.IPlayer getPreRenderPlayer() {
        com.aliyun.player.nativeclass.JniListPlayerBase corePlayer = getCorePlayer();
        if (!(corePlayer instanceof com.aliyun.player.nativeclass.JniSaasListPlayer)) {
            return null;
        }
        com.cicada.player.utils.Logger.v(TAG, "getPreRenderPlayer  ");
        return getCurrentPrerenderPlayer(((com.aliyun.player.nativeclass.JniSaasListPlayer) corePlayer).getPreRenderPlayerIndex());
    }

    @Override // com.aliyun.player.UrlVideoListPlayer, com.aliyun.player.AVPLBase
    public com.aliyun.player.IPlayer getPrerenderPlayer(android.content.Context context, java.lang.String str) {
        if (this.mSaaSPrerenderPlayer == null) {
            this.mSaaSPrerenderPlayer = new com.aliyun.player.ApsaraVideoPlayer(context, str);
        }
        return this.mSaaSPrerenderPlayer;
    }

    @Override // com.aliyun.player.AliPlayer
    public void invokeComponent(java.lang.String str) {
        com.aliyun.player.IPlayer nativePlayer = getNativePlayer();
        if (nativePlayer instanceof com.aliyun.player.ApsaraVideoPlayer) {
            ((com.aliyun.player.ApsaraVideoPlayer) nativePlayer).invokeComponent(str);
        }
    }

    @Override // com.aliyun.player.AliListPlayer
    public boolean moveTo(java.lang.String str, com.aliyun.player.source.PlayAuthInfo playAuthInfo) {
        com.aliyun.player.nativeclass.JniListPlayerBase corePlayer = getCorePlayer();
        if (!(corePlayer instanceof com.aliyun.player.nativeclass.JniSaasListPlayer)) {
            return false;
        }
        com.cicada.player.utils.Logger.v(TAG, "moveTo playauth uid = " + str);
        return ((com.aliyun.player.nativeclass.JniSaasListPlayer) corePlayer).moveTo(str, playAuthInfo);
    }

    @Override // com.aliyun.player.AliListPlayer
    public boolean moveTo(java.lang.String str, com.aliyun.player.source.StsInfo stsInfo) {
        com.aliyun.player.nativeclass.JniListPlayerBase corePlayer = getCorePlayer();
        if (!(corePlayer instanceof com.aliyun.player.nativeclass.JniSaasListPlayer)) {
            return false;
        }
        com.cicada.player.utils.Logger.v(TAG, "moveTo sts uid = " + str);
        return ((com.aliyun.player.nativeclass.JniSaasListPlayer) corePlayer).moveTo(str, stsInfo);
    }

    @Override // com.aliyun.player.AliListPlayer
    public boolean moveToNext(com.aliyun.player.source.PlayAuthInfo playAuthInfo) {
        com.aliyun.player.nativeclass.JniListPlayerBase corePlayer = getCorePlayer();
        if (!(corePlayer instanceof com.aliyun.player.nativeclass.JniSaasListPlayer)) {
            return false;
        }
        com.cicada.player.utils.Logger.v(TAG, "moveToNext playauth ");
        return ((com.aliyun.player.nativeclass.JniSaasListPlayer) corePlayer).moveToNext(playAuthInfo, false);
    }

    @Override // com.aliyun.player.AliListPlayer
    public boolean moveToNext(com.aliyun.player.source.StsInfo stsInfo) {
        com.aliyun.player.nativeclass.JniListPlayerBase corePlayer = getCorePlayer();
        if (!(corePlayer instanceof com.aliyun.player.nativeclass.JniSaasListPlayer)) {
            return false;
        }
        com.cicada.player.utils.Logger.v(TAG, "moveToNext sts ");
        return ((com.aliyun.player.nativeclass.JniSaasListPlayer) corePlayer).moveToNext(stsInfo, false);
    }

    @Override // com.aliyun.player.AliListPlayer
    public boolean moveToNextWithPrerendered(com.aliyun.player.source.PlayAuthInfo playAuthInfo) {
        com.aliyun.player.nativeclass.JniListPlayerBase corePlayer = getCorePlayer();
        if (!(corePlayer instanceof com.aliyun.player.nativeclass.JniSaasListPlayer)) {
            return false;
        }
        com.cicada.player.utils.Logger.v(TAG, "moveToNextWithPrerendered playauth ");
        return ((com.aliyun.player.nativeclass.JniSaasListPlayer) corePlayer).moveToNext(playAuthInfo, true);
    }

    @Override // com.aliyun.player.AliListPlayer
    public boolean moveToNextWithPrerendered(com.aliyun.player.source.StsInfo stsInfo) {
        com.aliyun.player.nativeclass.JniListPlayerBase corePlayer = getCorePlayer();
        if (!(corePlayer instanceof com.aliyun.player.nativeclass.JniSaasListPlayer)) {
            return false;
        }
        com.cicada.player.utils.Logger.v(TAG, "moveToNextWithPrerendered sts ");
        return ((com.aliyun.player.nativeclass.JniSaasListPlayer) corePlayer).moveToNext(stsInfo, true);
    }

    @Override // com.aliyun.player.AliListPlayer
    public boolean moveToPrev(com.aliyun.player.source.PlayAuthInfo playAuthInfo) {
        com.aliyun.player.nativeclass.JniListPlayerBase corePlayer = getCorePlayer();
        if (!(corePlayer instanceof com.aliyun.player.nativeclass.JniSaasListPlayer)) {
            return false;
        }
        com.cicada.player.utils.Logger.v(TAG, "moveToPrev playauth ");
        return ((com.aliyun.player.nativeclass.JniSaasListPlayer) corePlayer).moveToPrev(playAuthInfo);
    }

    @Override // com.aliyun.player.AliListPlayer
    public boolean moveToPrev(com.aliyun.player.source.StsInfo stsInfo) {
        com.aliyun.player.nativeclass.JniListPlayerBase corePlayer = getCorePlayer();
        if (!(corePlayer instanceof com.aliyun.player.nativeclass.JniSaasListPlayer)) {
            return false;
        }
        com.cicada.player.utils.Logger.v(TAG, "moveToPrev sts ");
        return ((com.aliyun.player.nativeclass.JniSaasListPlayer) corePlayer).moveToPrev(stsInfo);
    }

    @Override // com.aliyun.player.AliPlayer
    public void setDataSource(com.aliyun.player.source.LiveSts liveSts) {
        com.aliyun.player.IPlayer nativePlayer = getNativePlayer();
        if (nativePlayer instanceof com.aliyun.player.ApsaraVideoPlayer) {
            ((com.aliyun.player.ApsaraVideoPlayer) nativePlayer).setDataSource(liveSts);
        }
    }

    @Override // com.aliyun.player.AliPlayer
    public void setDataSource(com.aliyun.player.source.VidAuth vidAuth) {
        com.aliyun.player.IPlayer nativePlayer = getNativePlayer();
        if (nativePlayer instanceof com.aliyun.player.ApsaraVideoPlayer) {
            ((com.aliyun.player.ApsaraVideoPlayer) nativePlayer).setDataSource(vidAuth);
        }
    }

    @Override // com.aliyun.player.AliPlayer
    public void setDataSource(com.aliyun.player.source.VidMps vidMps) {
        com.aliyun.player.IPlayer nativePlayer = getNativePlayer();
        if (nativePlayer instanceof com.aliyun.player.ApsaraVideoPlayer) {
            ((com.aliyun.player.ApsaraVideoPlayer) nativePlayer).setDataSource(vidMps);
        }
    }

    @Override // com.aliyun.player.AliPlayer
    public void setDataSource(com.aliyun.player.source.VidSts vidSts) {
        com.aliyun.player.IPlayer nativePlayer = getNativePlayer();
        if (nativePlayer instanceof com.aliyun.player.ApsaraVideoPlayer) {
            ((com.aliyun.player.ApsaraVideoPlayer) nativePlayer).setDataSource(vidSts);
        }
    }

    @Override // com.aliyun.player.AliListPlayer
    public void setDefinition(java.lang.String str) {
        com.aliyun.player.nativeclass.JniListPlayerBase corePlayer = getCorePlayer();
        if (corePlayer instanceof com.aliyun.player.nativeclass.JniSaasListPlayer) {
            com.cicada.player.utils.Logger.v(TAG, "setDefinition = " + str);
            ((com.aliyun.player.nativeclass.JniSaasListPlayer) corePlayer).setDefinition(str);
        }
    }

    @Override // com.aliyun.player.AliPlayer
    public void setOnVerifyTimeExpireCallback(com.aliyun.player.AliPlayer.OnVerifyTimeExpireCallback onVerifyTimeExpireCallback) {
        com.aliyun.player.IPlayer nativePlayer = getNativePlayer();
        if (nativePlayer instanceof com.aliyun.player.ApsaraVideoPlayer) {
            ((com.aliyun.player.ApsaraVideoPlayer) nativePlayer).setOnVerifyTimeExpireCallback(onVerifyTimeExpireCallback);
        }
    }

    @Override // com.aliyun.player.AVPLBase, com.aliyun.player.IPlayer
    public void stop() {
        super.stop();
        com.aliyun.player.nativeclass.JniListPlayerBase corePlayer = getCorePlayer();
        if (corePlayer instanceof com.aliyun.player.nativeclass.JniSaasListPlayer) {
            ((com.aliyun.player.nativeclass.JniSaasListPlayer) corePlayer).stop();
        }
    }

    @Override // com.aliyun.player.AliPlayer
    public void updateStsInfo(com.aliyun.player.source.StsInfo stsInfo) {
        com.aliyun.player.IPlayer nativePlayer = getNativePlayer();
        if (nativePlayer instanceof com.aliyun.player.ApsaraVideoPlayer) {
            ((com.aliyun.player.ApsaraVideoPlayer) nativePlayer).updateStsInfo(stsInfo);
        }
    }

    @Override // com.aliyun.player.AliPlayer
    public void updateVidAuth(com.aliyun.player.source.VidAuth vidAuth) {
        com.aliyun.player.IPlayer nativePlayer = getNativePlayer();
        if (nativePlayer instanceof com.aliyun.player.ApsaraVideoPlayer) {
            ((com.aliyun.player.ApsaraVideoPlayer) nativePlayer).updateVidAuth(vidAuth);
        }
    }
}
