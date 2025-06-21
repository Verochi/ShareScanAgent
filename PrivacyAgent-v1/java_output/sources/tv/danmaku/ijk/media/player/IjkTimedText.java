package tv.danmaku.ijk.media.player;

/* loaded from: classes21.dex */
public final class IjkTimedText {
    private android.graphics.Rect mTextBounds;
    private java.lang.String mTextChars;

    public IjkTimedText(android.graphics.Rect rect, java.lang.String str) {
        this.mTextBounds = rect;
        this.mTextChars = str;
    }

    public android.graphics.Rect getBounds() {
        return this.mTextBounds;
    }

    public java.lang.String getText() {
        return this.mTextChars;
    }
}
