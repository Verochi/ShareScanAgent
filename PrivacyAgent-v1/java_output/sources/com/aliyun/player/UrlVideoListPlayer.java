package com.aliyun.player;

/* loaded from: classes.dex */
public class UrlVideoListPlayer extends com.aliyun.player.AVPLBase implements com.aliyun.player.UrlListPlayer, com.aliyun.player.UrlPlayer {
    private static final java.lang.String TAG = "NativePlayerBase_UrlVideoListPlayer";
    private com.aliyun.player.UrlVideoPlayer mUrlPrerenderPlayer;
    private com.aliyun.player.UrlVideoPlayer mUrlVideoPlayer;

    public UrlVideoListPlayer(android.content.Context context, java.lang.String str) {
        super(context, str);
        this.mUrlVideoPlayer = null;
        this.mUrlPrerenderPlayer = null;
    }

    @Override // com.aliyun.player.UrlListPlayer
    public void addUrl(java.lang.String str, java.lang.String str2) {
        com.aliyun.player.nativeclass.JniListPlayerBase corePlayer = getCorePlayer();
        if (corePlayer instanceof com.aliyun.player.nativeclass.JniUrlListPlayer) {
            com.cicada.player.utils.Logger.v(TAG, "addUrl = " + str + " , uid = " + str2);
            ((com.aliyun.player.nativeclass.JniUrlListPlayer) corePlayer).addUrl(str, str2);
        }
    }

    @Override // com.aliyun.player.UrlListPlayer
    public void addUrl(java.lang.String str, java.lang.String str2, com.aliyun.player.nativeclass.PreloadConfig preloadConfig) {
        com.aliyun.player.nativeclass.JniListPlayerBase corePlayer = getCorePlayer();
        if (corePlayer instanceof com.aliyun.player.nativeclass.JniUrlListPlayer) {
            ((com.aliyun.player.nativeclass.JniUrlListPlayer) corePlayer).addUrl(str, str2, preloadConfig);
        }
    }

    @Override // com.aliyun.player.AVPLBase
    public com.aliyun.player.nativeclass.JniListPlayerBase createListPlayer(android.content.Context context, java.lang.String str, long j, long j2) {
        return new com.aliyun.player.nativeclass.JniUrlListPlayer(context, j, j2);
    }

    @Override // com.aliyun.player.UrlPlayer
    public void enableDowngrade(com.aliyun.player.source.UrlSource urlSource, com.aliyun.player.nativeclass.PlayerConfig playerConfig) {
        java.lang.Object nativePlayer = getNativePlayer();
        if (nativePlayer instanceof com.aliyun.player.nativeclass.JniSaasPlayer) {
            ((com.aliyun.player.nativeclass.JniSaasPlayer) nativePlayer).enableDowngrade(urlSource, playerConfig);
        }
    }

    @Override // com.aliyun.player.AVPLBase
    public long getCurrentPlayerIndex() {
        com.aliyun.player.nativeclass.JniListPlayerBase corePlayer = getCorePlayer();
        if (!(corePlayer instanceof com.aliyun.player.nativeclass.JniUrlListPlayer)) {
            return 0L;
        }
        com.cicada.player.utils.Logger.v(TAG, "getCurrentPlayerIndex  ");
        return ((com.aliyun.player.nativeclass.JniUrlListPlayer) corePlayer).getCurrentPlayerIndex();
    }

    @Override // com.aliyun.player.AVPLBase
    public com.aliyun.player.IPlayer getNativePlayer(android.content.Context context, java.lang.String str) {
        if (this.mUrlVideoPlayer == null) {
            this.mUrlVideoPlayer = new com.aliyun.player.UrlVideoPlayer(context, str);
        }
        return this.mUrlVideoPlayer;
    }

    public com.aliyun.player.IPlayer getPreRenderPlayer() {
        com.aliyun.player.nativeclass.JniListPlayerBase corePlayer = getCorePlayer();
        if (!(corePlayer instanceof com.aliyun.player.nativeclass.JniUrlListPlayer)) {
            return null;
        }
        com.cicada.player.utils.Logger.v(TAG, "getPreRenderPlayer  ");
        getCurrentPrerenderPlayer(((com.aliyun.player.nativeclass.JniUrlListPlayer) corePlayer).getPreRenderPlayerIndex());
        return null;
    }

    @Override // com.aliyun.player.AVPLBase
    public com.aliyun.player.IPlayer getPrerenderPlayer(android.content.Context context, java.lang.String str) {
        if (this.mUrlPrerenderPlayer == null) {
            this.mUrlPrerenderPlayer = new com.aliyun.player.UrlVideoPlayer(context, str);
        }
        return this.mUrlPrerenderPlayer;
    }

    @Override // com.aliyun.player.IPlayer
    public java.lang.String getUserData() {
        return "";
    }

    @Override // com.aliyun.player.UrlListPlayer
    public boolean moveTo(java.lang.String str) {
        com.aliyun.player.nativeclass.JniListPlayerBase corePlayer = getCorePlayer();
        if (!(corePlayer instanceof com.aliyun.player.nativeclass.JniUrlListPlayer)) {
            return false;
        }
        com.cicada.player.utils.Logger.v(TAG, "moveTo uid = " + str);
        return ((com.aliyun.player.nativeclass.JniUrlListPlayer) corePlayer).moveTo(str);
    }

    @Override // com.aliyun.player.UrlListPlayer
    public boolean moveToNext() {
        com.aliyun.player.nativeclass.JniListPlayerBase corePlayer = getCorePlayer();
        if (!(corePlayer instanceof com.aliyun.player.nativeclass.JniUrlListPlayer)) {
            return false;
        }
        com.cicada.player.utils.Logger.v(TAG, "moveToNext  ");
        return ((com.aliyun.player.nativeclass.JniUrlListPlayer) corePlayer).moveToNext(false);
    }

    @Override // com.aliyun.player.UrlListPlayer
    public boolean moveToNextWithPrerendered() {
        com.aliyun.player.nativeclass.JniListPlayerBase corePlayer = getCorePlayer();
        if (!(corePlayer instanceof com.aliyun.player.nativeclass.JniUrlListPlayer)) {
            return false;
        }
        com.cicada.player.utils.Logger.v(TAG, "moveToNextWithPrerendered  ");
        return ((com.aliyun.player.nativeclass.JniUrlListPlayer) corePlayer).moveToNext(true);
    }

    @Override // com.aliyun.player.UrlListPlayer
    public boolean moveToPrev() {
        com.aliyun.player.nativeclass.JniListPlayerBase corePlayer = getCorePlayer();
        if (!(corePlayer instanceof com.aliyun.player.nativeclass.JniUrlListPlayer)) {
            return false;
        }
        com.cicada.player.utils.Logger.v(TAG, "moveToPrev  ");
        return ((com.aliyun.player.nativeclass.JniUrlListPlayer) corePlayer).moveToPrev();
    }

    @Override // com.aliyun.player.UrlPlayer
    public void setDataSource(com.aliyun.player.source.BitStreamSource bitStreamSource) {
        com.aliyun.player.IPlayer nativePlayer = getNativePlayer();
        if (nativePlayer instanceof com.aliyun.player.UrlPlayer) {
            ((com.aliyun.player.UrlPlayer) nativePlayer).setDataSource(bitStreamSource);
        }
    }

    @Override // com.aliyun.player.UrlPlayer
    public void setDataSource(com.aliyun.player.source.UrlSource urlSource) {
        com.aliyun.player.IPlayer nativePlayer = getNativePlayer();
        if (nativePlayer instanceof com.aliyun.player.UrlPlayer) {
            ((com.aliyun.player.UrlPlayer) nativePlayer).setDataSource(urlSource);
        }
    }

    @Override // com.aliyun.player.IListPlayer
    public void setPreloadCount(int i, int i2) {
        com.aliyun.player.nativeclass.JniListPlayerBase corePlayer = getCorePlayer();
        if (corePlayer instanceof com.aliyun.player.nativeclass.JniUrlListPlayer) {
            ((com.aliyun.player.nativeclass.JniUrlListPlayer) corePlayer).setPreloadCount(i, i2);
        }
    }

    @Override // com.aliyun.player.IPlayer
    public void setUserData(java.lang.String str) {
    }

    @Override // com.aliyun.player.UrlListPlayer
    public void updatePreloadConfig(com.aliyun.player.nativeclass.PreloadConfig preloadConfig) {
        com.aliyun.player.nativeclass.JniListPlayerBase corePlayer = getCorePlayer();
        if (corePlayer instanceof com.aliyun.player.nativeclass.JniUrlListPlayer) {
            ((com.aliyun.player.nativeclass.JniUrlListPlayer) corePlayer).updatePreloadConfig(preloadConfig);
        }
    }

    @Override // com.aliyun.player.UrlListPlayer
    public void updatePreloadConfig(java.lang.String str, com.aliyun.player.nativeclass.PreloadConfig preloadConfig) {
        com.aliyun.player.nativeclass.JniListPlayerBase corePlayer = getCorePlayer();
        if (corePlayer instanceof com.aliyun.player.nativeclass.JniUrlListPlayer) {
            ((com.aliyun.player.nativeclass.JniUrlListPlayer) corePlayer).updatePreloadConfig(str, preloadConfig);
        }
    }
}
