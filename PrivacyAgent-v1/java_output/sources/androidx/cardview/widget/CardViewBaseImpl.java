package androidx.cardview.widget;

/* loaded from: classes.dex */
class CardViewBaseImpl implements androidx.cardview.widget.CardViewImpl {
    final android.graphics.RectF mCornerRect = new android.graphics.RectF();

    /* renamed from: androidx.cardview.widget.CardViewBaseImpl$1, reason: invalid class name */
    public class AnonymousClass1 implements androidx.cardview.widget.RoundRectDrawableWithShadow.RoundRectHelper {
        public AnonymousClass1() {
        }

        @Override // androidx.cardview.widget.RoundRectDrawableWithShadow.RoundRectHelper
        public void drawRoundRect(android.graphics.Canvas canvas, android.graphics.RectF rectF, float f, android.graphics.Paint paint) {
            float f2 = 2.0f * f;
            float width = (rectF.width() - f2) - 1.0f;
            float height = (rectF.height() - f2) - 1.0f;
            if (f >= 1.0f) {
                float f3 = f + 0.5f;
                float f4 = -f3;
                androidx.cardview.widget.CardViewBaseImpl.this.mCornerRect.set(f4, f4, f3, f3);
                int save = canvas.save();
                canvas.translate(rectF.left + f3, rectF.top + f3);
                canvas.drawArc(androidx.cardview.widget.CardViewBaseImpl.this.mCornerRect, 180.0f, 90.0f, true, paint);
                canvas.translate(width, 0.0f);
                canvas.rotate(90.0f);
                canvas.drawArc(androidx.cardview.widget.CardViewBaseImpl.this.mCornerRect, 180.0f, 90.0f, true, paint);
                canvas.translate(height, 0.0f);
                canvas.rotate(90.0f);
                canvas.drawArc(androidx.cardview.widget.CardViewBaseImpl.this.mCornerRect, 180.0f, 90.0f, true, paint);
                canvas.translate(width, 0.0f);
                canvas.rotate(90.0f);
                canvas.drawArc(androidx.cardview.widget.CardViewBaseImpl.this.mCornerRect, 180.0f, 90.0f, true, paint);
                canvas.restoreToCount(save);
                float f5 = (rectF.left + f3) - 1.0f;
                float f6 = rectF.top;
                canvas.drawRect(f5, f6, (rectF.right - f3) + 1.0f, f6 + f3, paint);
                float f7 = (rectF.left + f3) - 1.0f;
                float f8 = rectF.bottom;
                canvas.drawRect(f7, f8 - f3, (rectF.right - f3) + 1.0f, f8, paint);
            }
            canvas.drawRect(rectF.left, rectF.top + f, rectF.right, rectF.bottom - f, paint);
        }
    }

    private androidx.cardview.widget.RoundRectDrawableWithShadow createBackground(android.content.Context context, android.content.res.ColorStateList colorStateList, float f, float f2, float f3) {
        return new androidx.cardview.widget.RoundRectDrawableWithShadow(context.getResources(), colorStateList, f, f2, f3);
    }

    private androidx.cardview.widget.RoundRectDrawableWithShadow getShadowBackground(androidx.cardview.widget.CardViewDelegate cardViewDelegate) {
        return (androidx.cardview.widget.RoundRectDrawableWithShadow) cardViewDelegate.getCardBackground();
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public android.content.res.ColorStateList getBackgroundColor(androidx.cardview.widget.CardViewDelegate cardViewDelegate) {
        return getShadowBackground(cardViewDelegate).getColor();
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public float getElevation(androidx.cardview.widget.CardViewDelegate cardViewDelegate) {
        return getShadowBackground(cardViewDelegate).getShadowSize();
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public float getMaxElevation(androidx.cardview.widget.CardViewDelegate cardViewDelegate) {
        return getShadowBackground(cardViewDelegate).getMaxShadowSize();
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public float getMinHeight(androidx.cardview.widget.CardViewDelegate cardViewDelegate) {
        return getShadowBackground(cardViewDelegate).getMinHeight();
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public float getMinWidth(androidx.cardview.widget.CardViewDelegate cardViewDelegate) {
        return getShadowBackground(cardViewDelegate).getMinWidth();
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public float getRadius(androidx.cardview.widget.CardViewDelegate cardViewDelegate) {
        return getShadowBackground(cardViewDelegate).getCornerRadius();
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void initStatic() {
        androidx.cardview.widget.RoundRectDrawableWithShadow.sRoundRectHelper = new androidx.cardview.widget.CardViewBaseImpl.AnonymousClass1();
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void initialize(androidx.cardview.widget.CardViewDelegate cardViewDelegate, android.content.Context context, android.content.res.ColorStateList colorStateList, float f, float f2, float f3) {
        androidx.cardview.widget.RoundRectDrawableWithShadow createBackground = createBackground(context, colorStateList, f, f2, f3);
        createBackground.setAddPaddingForCorners(cardViewDelegate.getPreventCornerOverlap());
        cardViewDelegate.setCardBackground(createBackground);
        updatePadding(cardViewDelegate);
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void onCompatPaddingChanged(androidx.cardview.widget.CardViewDelegate cardViewDelegate) {
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void onPreventCornerOverlapChanged(androidx.cardview.widget.CardViewDelegate cardViewDelegate) {
        getShadowBackground(cardViewDelegate).setAddPaddingForCorners(cardViewDelegate.getPreventCornerOverlap());
        updatePadding(cardViewDelegate);
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void setBackgroundColor(androidx.cardview.widget.CardViewDelegate cardViewDelegate, @androidx.annotation.Nullable android.content.res.ColorStateList colorStateList) {
        getShadowBackground(cardViewDelegate).setColor(colorStateList);
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void setElevation(androidx.cardview.widget.CardViewDelegate cardViewDelegate, float f) {
        getShadowBackground(cardViewDelegate).setShadowSize(f);
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void setMaxElevation(androidx.cardview.widget.CardViewDelegate cardViewDelegate, float f) {
        getShadowBackground(cardViewDelegate).setMaxShadowSize(f);
        updatePadding(cardViewDelegate);
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void setRadius(androidx.cardview.widget.CardViewDelegate cardViewDelegate, float f) {
        getShadowBackground(cardViewDelegate).setCornerRadius(f);
        updatePadding(cardViewDelegate);
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void updatePadding(androidx.cardview.widget.CardViewDelegate cardViewDelegate) {
        android.graphics.Rect rect = new android.graphics.Rect();
        getShadowBackground(cardViewDelegate).getMaxShadowAndCornerPadding(rect);
        cardViewDelegate.setMinWidthHeightInternal((int) java.lang.Math.ceil(getMinWidth(cardViewDelegate)), (int) java.lang.Math.ceil(getMinHeight(cardViewDelegate)));
        cardViewDelegate.setShadowPadding(rect.left, rect.top, rect.right, rect.bottom);
    }
}
