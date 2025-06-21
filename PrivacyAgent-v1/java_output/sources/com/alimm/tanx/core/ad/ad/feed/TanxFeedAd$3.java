package com.alimm.tanx.core.ad.ad.feed;

/* loaded from: classes.dex */
public class TanxFeedAd$3 extends com.alimm.tanx.core.ad.listener.ViewClickListener {
    final /* synthetic */ com.alimm.tanx.core.ad.ad.feed.tanxc_do this$0;
    final /* synthetic */ java.util.List val$dislikeList;
    final /* synthetic */ com.alimm.tanx.core.ad.ad.feed.ITanxFeedAd.DislikeOnClickListener val$dislikeOnClickListener;

    public TanxFeedAd$3(com.alimm.tanx.core.ad.ad.feed.tanxc_do tanxc_doVar, java.util.List list, com.alimm.tanx.core.ad.ad.feed.ITanxFeedAd.DislikeOnClickListener dislikeOnClickListener) {
        this.this$0 = tanxc_doVar;
        this.val$dislikeList = list;
        this.val$dislikeOnClickListener = dislikeOnClickListener;
    }

    @Override // com.alimm.tanx.core.ad.listener.ViewClickListener
    public void viewClick(android.view.View view) {
        com.alimm.tanx.core.ad.ad.feed.ITanxFeedInteractionListener iTanxFeedInteractionListener;
        com.alimm.tanx.core.ad.ad.feed.ITanxFeedInteractionListener iTanxFeedInteractionListener2;
        iTanxFeedInteractionListener = this.this$0.tanxc_do;
        if (iTanxFeedInteractionListener != null) {
            iTanxFeedInteractionListener2 = this.this$0.tanxc_do;
            iTanxFeedInteractionListener2.onAdClose();
            if (this.val$dislikeList.size() > 1) {
                if (this.val$dislikeList.get(0) == view) {
                    com.alimm.tanx.core.ad.event.track.interaction.InteractionUpload interactionUpload = com.alimm.tanx.core.ad.event.track.interaction.InteractionUpload.getInstance();
                    java.util.List<com.alimm.tanx.core.ad.listener.bean.NewTrackItem> eventTrack = this.this$0.getBidInfo().getEventTrack();
                    com.alimm.tanx.core.ad.event.track.interaction.InteractionUpload.getInstance();
                    interactionUpload.uploadInteraction(eventTrack, 4);
                    com.alimm.tanx.core.ut.impl.TanxFeedUt.utClose(this.this$0, 0);
                } else {
                    com.alimm.tanx.core.ad.event.track.interaction.InteractionUpload interactionUpload2 = com.alimm.tanx.core.ad.event.track.interaction.InteractionUpload.getInstance();
                    java.util.List<com.alimm.tanx.core.ad.listener.bean.NewTrackItem> eventTrack2 = this.this$0.getBidInfo().getEventTrack();
                    com.alimm.tanx.core.ad.event.track.interaction.InteractionUpload.getInstance();
                    interactionUpload2.uploadInteraction(eventTrack2, 5);
                    com.alimm.tanx.core.ut.impl.TanxFeedUt.utClose(this.this$0, 1);
                }
            }
        }
        com.alimm.tanx.core.ad.ad.feed.ITanxFeedAd.DislikeOnClickListener dislikeOnClickListener = this.val$dislikeOnClickListener;
        if (dislikeOnClickListener != null) {
            dislikeOnClickListener.onClick(view);
        }
    }
}
