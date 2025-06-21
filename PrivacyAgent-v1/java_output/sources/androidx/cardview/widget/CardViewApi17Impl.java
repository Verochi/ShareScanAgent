package androidx.cardview.widget;

@androidx.annotation.RequiresApi(17)
/* loaded from: classes.dex */
class CardViewApi17Impl extends androidx.cardview.widget.CardViewBaseImpl {

    /* renamed from: androidx.cardview.widget.CardViewApi17Impl$1, reason: invalid class name */
    public class AnonymousClass1 implements androidx.cardview.widget.RoundRectDrawableWithShadow.RoundRectHelper {
        public AnonymousClass1() {
        }

        @Override // androidx.cardview.widget.RoundRectDrawableWithShadow.RoundRectHelper
        public void drawRoundRect(android.graphics.Canvas canvas, android.graphics.RectF rectF, float f, android.graphics.Paint paint) {
            canvas.drawRoundRect(rectF, f, f, paint);
        }
    }

    @Override // androidx.cardview.widget.CardViewBaseImpl, androidx.cardview.widget.CardViewImpl
    public void initStatic() {
        androidx.cardview.widget.RoundRectDrawableWithShadow.sRoundRectHelper = new androidx.cardview.widget.CardViewApi17Impl.AnonymousClass1();
    }
}
