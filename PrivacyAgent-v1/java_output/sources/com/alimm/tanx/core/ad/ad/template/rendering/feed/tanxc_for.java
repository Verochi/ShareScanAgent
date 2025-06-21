package com.alimm.tanx.core.ad.ad.template.rendering.feed;

/* loaded from: classes.dex */
public class tanxc_for {
    private java.util.List<java.lang.ref.WeakReference<com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxFeedAdNativeView>> tanxc_do;
    private java.util.List<java.lang.ref.WeakReference<com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxFeedAdWebView>> tanxc_for;
    private java.util.List<java.lang.ref.WeakReference<com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxFeedAdInteractionView>> tanxc_if;

    public com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxFeedAdView tanxc_do(com.alimm.tanx.core.view.feed.ITanxFeedCacheContext iTanxFeedCacheContext, android.content.Context context) {
        com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxFeedAdNativeView tanxFeedAdNativeView = null;
        if (iTanxFeedCacheContext == null) {
            return null;
        }
        if (this.tanxc_do == null) {
            this.tanxc_do = new java.util.ArrayList();
        }
        iTanxFeedCacheContext.remove();
        java.util.Iterator<java.lang.ref.WeakReference<com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxFeedAdNativeView>> it = this.tanxc_do.iterator();
        while (it.hasNext()) {
            com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxFeedAdNativeView tanxFeedAdNativeView2 = it.next().get();
            if (tanxFeedAdNativeView2 == null) {
                it.remove();
            } else if (tanxFeedAdNativeView == null && tanxFeedAdNativeView2.getParent() == null) {
                tanxFeedAdNativeView = tanxFeedAdNativeView2;
            }
        }
        if (tanxFeedAdNativeView != null) {
            return tanxFeedAdNativeView;
        }
        com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxFeedAdNativeView tanxFeedAdNativeView3 = new com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxFeedAdNativeView(context);
        this.tanxc_do.add(new java.lang.ref.WeakReference<>(tanxFeedAdNativeView3));
        return tanxFeedAdNativeView3;
    }

    public com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxFeedAdView tanxc_for(com.alimm.tanx.core.view.feed.ITanxFeedCacheContext iTanxFeedCacheContext, android.content.Context context) {
        com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxFeedAdWebView tanxFeedAdWebView = null;
        if (iTanxFeedCacheContext == null) {
            return null;
        }
        if (this.tanxc_for == null) {
            this.tanxc_for = new java.util.ArrayList();
        }
        iTanxFeedCacheContext.remove();
        java.util.Iterator<java.lang.ref.WeakReference<com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxFeedAdWebView>> it = this.tanxc_for.iterator();
        while (it.hasNext()) {
            com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxFeedAdWebView tanxFeedAdWebView2 = it.next().get();
            if (tanxFeedAdWebView2 == null) {
                it.remove();
            } else if (tanxFeedAdWebView == null && tanxFeedAdWebView2.getParent() == null) {
                tanxFeedAdWebView = tanxFeedAdWebView2;
            }
        }
        if (tanxFeedAdWebView != null) {
            return tanxFeedAdWebView;
        }
        com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxFeedAdWebView tanxFeedAdWebView3 = new com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxFeedAdWebView(context);
        this.tanxc_for.add(new java.lang.ref.WeakReference<>(tanxFeedAdWebView3));
        return tanxFeedAdWebView3;
    }

    public com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxFeedAdView tanxc_if(com.alimm.tanx.core.view.feed.ITanxFeedCacheContext iTanxFeedCacheContext, android.content.Context context) {
        com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxFeedAdInteractionView tanxFeedAdInteractionView = null;
        if (iTanxFeedCacheContext == null) {
            return null;
        }
        if (this.tanxc_if == null) {
            this.tanxc_if = new java.util.ArrayList();
        }
        iTanxFeedCacheContext.remove();
        java.util.Iterator<java.lang.ref.WeakReference<com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxFeedAdInteractionView>> it = this.tanxc_if.iterator();
        while (it.hasNext()) {
            com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxFeedAdInteractionView tanxFeedAdInteractionView2 = it.next().get();
            if (tanxFeedAdInteractionView2 == null) {
                it.remove();
            } else if (tanxFeedAdInteractionView == null && tanxFeedAdInteractionView2.getParent() == null) {
                tanxFeedAdInteractionView = tanxFeedAdInteractionView2;
            }
        }
        if (tanxFeedAdInteractionView != null) {
            return tanxFeedAdInteractionView;
        }
        com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxFeedAdInteractionView tanxFeedAdInteractionView3 = new com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxFeedAdInteractionView(context);
        this.tanxc_if.add(new java.lang.ref.WeakReference<>(tanxFeedAdInteractionView3));
        return tanxFeedAdInteractionView3;
    }
}
