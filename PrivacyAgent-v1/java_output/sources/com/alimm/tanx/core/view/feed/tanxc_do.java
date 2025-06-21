package com.alimm.tanx.core.view.feed;

/* loaded from: classes.dex */
public class tanxc_do {
    private java.util.List<java.lang.ref.WeakReference<com.alimm.tanx.core.ad.ad.feed.TanxVideoView>> tanxc_do;

    public com.alimm.tanx.core.ad.ad.feed.TanxVideoView tanxc_do(com.alimm.tanx.core.view.feed.ITanxFeedCacheContext iTanxFeedCacheContext, android.content.Context context) {
        com.alimm.tanx.core.ad.ad.feed.TanxVideoView tanxVideoView = null;
        if (iTanxFeedCacheContext == null) {
            return null;
        }
        if (this.tanxc_do == null) {
            this.tanxc_do = new java.util.ArrayList();
        }
        iTanxFeedCacheContext.remove();
        java.util.Iterator<java.lang.ref.WeakReference<com.alimm.tanx.core.ad.ad.feed.TanxVideoView>> it = this.tanxc_do.iterator();
        while (it.hasNext()) {
            com.alimm.tanx.core.ad.ad.feed.TanxVideoView tanxVideoView2 = it.next().get();
            if (tanxVideoView2 == null) {
                it.remove();
            } else if (tanxVideoView == null && tanxVideoView2.getParent() == null) {
                tanxVideoView = tanxVideoView2;
            }
        }
        if (tanxVideoView != null) {
            return tanxVideoView;
        }
        com.alimm.tanx.core.ad.ad.feed.TanxVideoView tanxVideoView3 = new com.alimm.tanx.core.ad.ad.feed.TanxVideoView(context);
        this.tanxc_do.add(new java.lang.ref.WeakReference<>(tanxVideoView3));
        return tanxVideoView3;
    }
}
