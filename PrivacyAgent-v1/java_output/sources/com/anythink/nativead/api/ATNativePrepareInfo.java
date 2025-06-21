package com.anythink.nativead.api;

/* loaded from: classes12.dex */
public class ATNativePrepareInfo {
    android.view.View adFromView;
    android.view.View adLogoView;
    android.widget.FrameLayout.LayoutParams choiceViewLayoutParams;
    private final java.util.List<android.view.View> clickViewList = new java.util.ArrayList();
    android.view.View closeView;
    android.view.View ctaView;
    android.view.View descView;
    private android.view.View domainView;
    android.view.View iconView;
    android.view.View mainImageView;
    android.view.View parentView;
    android.view.View titleView;
    private android.view.View warningView;

    private synchronized void addClickView(android.view.View view) {
        if (view == null) {
            return;
        }
        if (!this.clickViewList.contains(view)) {
            android.view.View view2 = this.closeView;
            if (view2 != null && view2 == view) {
            } else {
                this.clickViewList.add(view);
            }
        }
    }

    public android.view.View getAdFromView() {
        return this.adFromView;
    }

    public android.view.View getAdLogoView() {
        return this.adLogoView;
    }

    public android.widget.FrameLayout.LayoutParams getChoiceViewLayoutParams() {
        return this.choiceViewLayoutParams;
    }

    public java.util.List<android.view.View> getClickViewList() {
        return this.clickViewList;
    }

    public android.view.View getCloseView() {
        return this.closeView;
    }

    public android.view.View getCtaView() {
        return this.ctaView;
    }

    public android.view.View getDescView() {
        return this.descView;
    }

    public android.view.View getDomainView() {
        return this.domainView;
    }

    public android.view.View getIconView() {
        return this.iconView;
    }

    public android.view.View getMainImageView() {
        return this.mainImageView;
    }

    public android.view.View getParentView() {
        return this.parentView;
    }

    public android.view.View getTitleView() {
        return this.titleView;
    }

    public android.view.View getWarningView() {
        return this.warningView;
    }

    public void setAdFromView(android.view.View view) {
        this.adFromView = view;
    }

    public void setAdLogoView(android.view.View view) {
        this.adLogoView = view;
    }

    public void setChoiceViewLayoutParams(android.widget.FrameLayout.LayoutParams layoutParams) {
        this.choiceViewLayoutParams = layoutParams;
    }

    public void setClickViewList(java.util.List<android.view.View> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        java.util.Iterator<android.view.View> it = list.iterator();
        while (it.hasNext()) {
            addClickView(it.next());
        }
    }

    public void setCloseView(android.view.View view) {
        this.closeView = view;
    }

    public void setCtaView(android.view.View view) {
        this.ctaView = view;
        addClickView(view);
    }

    public void setDescView(android.view.View view) {
        this.descView = view;
        addClickView(view);
    }

    public void setDomainView(android.view.View view) {
        this.domainView = view;
    }

    public void setIconView(android.view.View view) {
        this.iconView = view;
        addClickView(view);
    }

    public void setMainImageView(android.view.View view) {
        this.mainImageView = view;
        addClickView(view);
    }

    public void setParentView(android.view.View view) {
        this.parentView = view;
    }

    public void setTitleView(android.view.View view) {
        this.titleView = view;
        addClickView(view);
    }

    public void setWarningView(android.view.View view) {
        this.warningView = view;
    }
}
