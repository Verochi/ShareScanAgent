package com.alimm.tanx.core.ad.ad.template.rendering.reward;

/* loaded from: classes.dex */
public class tanxc_do {
    public static java.lang.String tanxc_do(com.alimm.tanx.core.view.player.core.PlayerBufferingState playerBufferingState) {
        return playerBufferingState == com.alimm.tanx.core.view.player.core.PlayerBufferingState.BUFFERING_START ? "buffering" : "playing";
    }

    public static java.lang.String tanxc_do(com.alimm.tanx.core.view.player.core.PlayerState playerState) {
        return (playerState == com.alimm.tanx.core.view.player.core.PlayerState.IDLE || playerState == com.alimm.tanx.core.view.player.core.PlayerState.INITIALIZED || playerState == com.alimm.tanx.core.view.player.core.PlayerState.PREPARING) ? "preparing" : playerState == com.alimm.tanx.core.view.player.core.PlayerState.PREPARED ? "ready" : playerState == com.alimm.tanx.core.view.player.core.PlayerState.STARTED ? "playing" : (playerState == com.alimm.tanx.core.view.player.core.PlayerState.PAUSED || playerState == com.alimm.tanx.core.view.player.core.PlayerState.STOPPED) ? "pausing" : playerState == com.alimm.tanx.core.view.player.core.PlayerState.ERROR ? "error" : (playerState == com.alimm.tanx.core.view.player.core.PlayerState.COMPLETED || playerState == com.alimm.tanx.core.view.player.core.PlayerState.END) ? "end" : "unknown";
    }
}
