package com.aliyun.player;

/* loaded from: classes.dex */
public class UrlVideoPlayer extends com.aliyun.player.AVPBase implements com.aliyun.player.UrlPlayer {
    public UrlVideoPlayer(android.content.Context context, java.lang.String str) {
        super(context, str);
    }

    @Override // com.aliyun.player.AVPBase
    public com.aliyun.player.nativeclass.NativePlayerBase createAlivcMediaPlayer(android.content.Context context) {
        return new com.aliyun.player.nativeclass.JniUrlPlayer(context);
    }

    @Override // com.aliyun.player.UrlPlayer
    public void enableDowngrade(com.aliyun.player.source.UrlSource urlSource, com.aliyun.player.nativeclass.PlayerConfig playerConfig) {
        com.aliyun.player.nativeclass.NativePlayerBase corePlayer = getCorePlayer();
        if (corePlayer instanceof com.aliyun.player.nativeclass.JniSaasPlayer) {
            ((com.aliyun.player.nativeclass.JniSaasPlayer) corePlayer).enableDowngrade(urlSource, playerConfig);
        }
    }

    @Override // com.aliyun.player.UrlPlayer
    public void setDataSource(com.aliyun.player.source.BitStreamSource bitStreamSource) {
        com.aliyun.player.nativeclass.NativePlayerBase corePlayer = getCorePlayer();
        if (corePlayer instanceof com.aliyun.player.nativeclass.JniSaasPlayer) {
            ((com.aliyun.player.nativeclass.JniSaasPlayer) corePlayer).setDataSource(bitStreamSource);
        }
    }

    @Override // com.aliyun.player.UrlPlayer
    public void setDataSource(com.aliyun.player.source.UrlSource urlSource) {
        com.aliyun.player.nativeclass.NativePlayerBase corePlayer = getCorePlayer();
        if (corePlayer instanceof com.aliyun.player.nativeclass.JniSaasPlayer) {
            ((com.aliyun.player.nativeclass.JniSaasPlayer) corePlayer).setDataSource(urlSource);
        }
    }
}
