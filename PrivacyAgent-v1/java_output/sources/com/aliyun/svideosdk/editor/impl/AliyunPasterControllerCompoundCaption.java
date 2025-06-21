package com.aliyun.svideosdk.editor.impl;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public class AliyunPasterControllerCompoundCaption extends com.aliyun.svideosdk.editor.impl.AliyunPasterAbstractController<com.aliyun.svideosdk.common.AliyunCaption> {
    public static final int AlignCenter = 4;
    public static final int AlignLeft = 1;
    public static final int AlignRight = 2;

    public AliyunPasterControllerCompoundCaption(com.aliyun.svideosdk.common.AliyunCaption aliyunCaption, com.aliyun.svideosdk.editor.AliyunPasterRender aliyunPasterRender) {
        super(aliyunCaption, aliyunPasterRender);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int addFrameAnimation(com.aliyun.svideosdk.common.struct.effect.ActionBase actionBase) {
        actionBase.setTargetId(((com.aliyun.svideosdk.common.AliyunCaption) this.mModel).getId());
        int hashCode = actionBase.hashCode();
        actionBase.setId(hashCode);
        ((com.aliyun.svideosdk.common.AliyunCaption) this.mModel).addAction(actionBase);
        return hashCode;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int apply() {
        return ((com.aliyun.svideosdk.common.AliyunCaption) this.mModel).getId() == 0 ? this.mRender.addCaption((com.aliyun.svideosdk.common.AliyunCaption) this.mModel) : this.mRender.updateCaption((com.aliyun.svideosdk.common.AliyunCaption) this.mModel);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int clearFrameAnimation() {
        ((com.aliyun.svideosdk.common.AliyunCaption) this.mModel).clearAction();
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public com.aliyun.svideosdk.common.AliyunColor getBackgroundColor() {
        return ((com.aliyun.svideosdk.common.AliyunCaption) this.mModel).getBackgroundColor();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public float getBackgroundCornerRadius() {
        return ((com.aliyun.svideosdk.common.AliyunCaption) this.mModel).getBackgroundCornerRadius() * this.mRender.getDisplaySize().getWidth();
    }

    public java.lang.String getBubbleEffectTemplate() {
        if (getBubbleEffectTemplateSource() != null) {
            return getBubbleEffectTemplateSource().getPath();
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public com.aliyun.svideosdk.common.ISource getBubbleEffectTemplateSource() {
        return ((com.aliyun.svideosdk.common.AliyunCaption) this.mModel).getBubbleSource();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public com.aliyun.svideosdk.common.AliyunColor getColor() {
        return ((com.aliyun.svideosdk.common.AliyunCaption) this.mModel).getColor();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.aliyun.svideosdk.editor.AliyunIPasterController
    public long getDuration() {
        return ((com.aliyun.svideosdk.common.AliyunCaption) this.mModel).getDuration();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public java.lang.String getFontEffectTemplate() {
        if (((com.aliyun.svideosdk.common.AliyunCaption) this.mModel).getFontEffectSource() != null) {
            return ((com.aliyun.svideosdk.common.AliyunCaption) this.mModel).getFontEffectSource().getPath();
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public com.aliyun.svideosdk.common.ISource getFontEffectTemplateSource() {
        return ((com.aliyun.svideosdk.common.AliyunCaption) this.mModel).getFontEffectSource();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public com.aliyun.svideosdk.common.ISource getFontPath() {
        return ((com.aliyun.svideosdk.common.AliyunCaption) this.mModel).getFontSource();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @java.lang.Deprecated
    public com.aliyun.svideosdk.common.AliyunFontStyle getFontStyle() {
        return ((com.aliyun.svideosdk.common.AliyunCaption) this.mModel).getFontStyle();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public com.aliyun.svideosdk.common.AliyunTypeface getFontTypeface() {
        return ((com.aliyun.svideosdk.common.AliyunCaption) this.mModel).getFontStyle().getTypeface();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public java.util.List<com.aliyun.svideosdk.common.struct.effect.ActionBase> getFrameAnimations() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Iterator<java.lang.Object> it = ((com.aliyun.svideosdk.common.AliyunCaption) this.mModel).getActionList().iterator();
        while (it.hasNext()) {
            arrayList.add((com.aliyun.svideosdk.common.struct.effect.ActionBase) it.next());
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public com.aliyun.svideosdk.common.AliyunColor getOutlineColor() {
        return ((com.aliyun.svideosdk.common.AliyunCaption) this.mModel).getOutlineColor();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public float getOutlineWidth() {
        return ((com.aliyun.svideosdk.common.AliyunCaption) this.mModel).getOutlineWidth();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.aliyun.svideosdk.editor.AliyunIPasterController
    public android.graphics.PointF getPosition() {
        android.graphics.PointF position = ((com.aliyun.svideosdk.common.AliyunCaption) this.mModel).getPosition();
        com.aliyun.common.utils.Size displaySize = this.mRender.getDisplaySize();
        position.x *= displaySize.getWidth();
        position.y *= displaySize.getHeight();
        return position;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.aliyun.svideosdk.editor.AliyunIPasterController
    public float getRotate() {
        return ((com.aliyun.svideosdk.common.AliyunCaption) this.mModel).getRotate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public float getScale() {
        return ((com.aliyun.svideosdk.common.AliyunCaption) this.mModel).getScale();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public com.aliyun.svideosdk.common.AliyunColor getShadowColor() {
        return ((com.aliyun.svideosdk.common.AliyunCaption) this.mModel).getShadowColor();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public android.graphics.PointF getShadowOffset() {
        return ((com.aliyun.svideosdk.common.AliyunCaption) this.mModel).getShadowOffset();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.aliyun.svideosdk.editor.AliyunIPasterController
    public android.graphics.RectF getSize() {
        android.graphics.RectF size = ((com.aliyun.svideosdk.common.AliyunCaption) this.mModel).getSize();
        com.aliyun.common.utils.Size displaySize = this.mRender.getDisplaySize();
        size.left *= displaySize.getWidth();
        size.right *= displaySize.getWidth();
        size.top *= displaySize.getHeight();
        size.bottom *= displaySize.getHeight();
        return size;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.aliyun.svideosdk.editor.AliyunIPasterController
    public long getStartTime() {
        return ((com.aliyun.svideosdk.common.AliyunCaption) this.mModel).getStartTime();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public java.lang.String getText() {
        return ((com.aliyun.svideosdk.common.AliyunCaption) this.mModel).getText();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int getTextAlignment() {
        return ((com.aliyun.svideosdk.common.AliyunCaption) this.mModel).getTextAlignment();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIPasterController
    public int getType() {
        return 2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.aliyun.svideosdk.editor.impl.h
    public int remove() {
        return this.mRender.removeCaption((com.aliyun.svideosdk.common.AliyunCaption) this.mModel);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int removeFrameAnimation(com.aliyun.svideosdk.common.struct.effect.ActionBase actionBase) {
        return ((com.aliyun.svideosdk.common.AliyunCaption) this.mModel).removeAction(actionBase);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setBackgroundColor(com.aliyun.svideosdk.common.AliyunColor aliyunColor) {
        ((com.aliyun.svideosdk.common.AliyunCaption) this.mModel).setBackgroundColor(aliyunColor);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setBackgroundCornerRadius(float f) {
        ((com.aliyun.svideosdk.common.AliyunCaption) this.mModel).setBackgroundCornerRadius(f / this.mRender.getDisplaySize().getWidth());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setBubbleEffectTemplate(com.aliyun.svideosdk.common.struct.project.Source source) {
        ((com.aliyun.svideosdk.common.AliyunCaption) this.mModel).setBubbleSource(source);
    }

    public void setBubbleEffectTemplate(java.lang.String str) {
        setBubbleEffectTemplate(new com.aliyun.svideosdk.common.struct.project.Source(str));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setColor(com.aliyun.svideosdk.common.AliyunColor aliyunColor) {
        ((com.aliyun.svideosdk.common.AliyunCaption) this.mModel).setColor(aliyunColor);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.aliyun.svideosdk.editor.AliyunIPasterController
    public void setDuration(long j, java.util.concurrent.TimeUnit timeUnit) {
        ((com.aliyun.svideosdk.common.AliyunCaption) this.mModel).setDuration(timeUnit.toMicros(j));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setFontEffectTemplate(com.aliyun.svideosdk.common.struct.project.Source source) {
        ((com.aliyun.svideosdk.common.AliyunCaption) this.mModel).setFontEffectSource(source);
    }

    public void setFontEffectTemplate(java.lang.String str) {
        setFontEffectTemplate(new com.aliyun.svideosdk.common.struct.project.Source(str));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setFontPath(com.aliyun.svideosdk.common.ISource iSource) {
        com.aliyun.svideosdk.common.AliyunFontStyle fontStyle = ((com.aliyun.svideosdk.common.AliyunCaption) this.mModel).getFontStyle();
        fontStyle.setFontSource(iSource);
        ((com.aliyun.svideosdk.common.AliyunCaption) this.mModel).setFontStyle(fontStyle);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @java.lang.Deprecated
    public void setFontStyle(com.aliyun.svideosdk.common.AliyunFontStyle aliyunFontStyle) {
        ((com.aliyun.svideosdk.common.AliyunCaption) this.mModel).setFontStyle(aliyunFontStyle);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setFontTypeface(com.aliyun.svideosdk.common.AliyunTypeface aliyunTypeface) {
        com.aliyun.svideosdk.common.AliyunFontStyle fontStyle = ((com.aliyun.svideosdk.common.AliyunCaption) this.mModel).getFontStyle();
        fontStyle.setTypeface(aliyunTypeface);
        ((com.aliyun.svideosdk.common.AliyunCaption) this.mModel).setFontStyle(fontStyle);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int setFrameAnimation(com.aliyun.svideosdk.common.struct.effect.ActionBase actionBase) {
        if (actionBase == null) {
            return ((com.aliyun.svideosdk.common.AliyunCaption) this.mModel).clearAction();
        }
        actionBase.setTargetId(((com.aliyun.svideosdk.common.AliyunCaption) this.mModel).getId());
        int hashCode = actionBase.hashCode();
        actionBase.setId(hashCode);
        ((com.aliyun.svideosdk.common.AliyunCaption) this.mModel).clearAction();
        ((com.aliyun.svideosdk.common.AliyunCaption) this.mModel).addAction(actionBase);
        return hashCode;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setOutlineColor(com.aliyun.svideosdk.common.AliyunColor aliyunColor) {
        ((com.aliyun.svideosdk.common.AliyunCaption) this.mModel).setOutlineColor(aliyunColor);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setOutlineWidth(float f) {
        ((com.aliyun.svideosdk.common.AliyunCaption) this.mModel).setOutlineWidth(f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.aliyun.svideosdk.editor.AliyunIPasterController
    public void setPosition(android.graphics.PointF pointF) {
        android.graphics.PointF pointF2 = new android.graphics.PointF();
        com.aliyun.common.utils.Size displaySize = this.mRender.getDisplaySize();
        pointF2.x = pointF.x / displaySize.getWidth();
        pointF2.y = pointF.y / displaySize.getHeight();
        ((com.aliyun.svideosdk.common.AliyunCaption) this.mModel).setPosition(pointF2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.aliyun.svideosdk.editor.AliyunIPasterController
    public void setRotate(float f) {
        ((com.aliyun.svideosdk.common.AliyunCaption) this.mModel).setRotate(f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setScale(float f) {
        ((com.aliyun.svideosdk.common.AliyunCaption) this.mModel).setScale(f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setShadowColor(com.aliyun.svideosdk.common.AliyunColor aliyunColor) {
        ((com.aliyun.svideosdk.common.AliyunCaption) this.mModel).setShadowColor(aliyunColor);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setShadowOffset(android.graphics.PointF pointF) {
        ((com.aliyun.svideosdk.common.AliyunCaption) this.mModel).setShadowOffset(pointF);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.aliyun.svideosdk.editor.AliyunIPasterController
    public void setStartTime(long j, java.util.concurrent.TimeUnit timeUnit) {
        ((com.aliyun.svideosdk.common.AliyunCaption) this.mModel).setStartTime(timeUnit.toMicros(j));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setText(java.lang.String str) {
        ((com.aliyun.svideosdk.common.AliyunCaption) this.mModel).setText(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setTextAlignment(int i) {
        ((com.aliyun.svideosdk.common.AliyunCaption) this.mModel).setTextAlignment(i);
    }
}
