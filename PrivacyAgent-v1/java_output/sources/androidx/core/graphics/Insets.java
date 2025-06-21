package androidx.core.graphics;

/* loaded from: classes.dex */
public final class Insets {

    @androidx.annotation.NonNull
    public static final androidx.core.graphics.Insets NONE = new androidx.core.graphics.Insets(0, 0, 0, 0);
    public final int bottom;
    public final int left;
    public final int right;
    public final int top;

    private Insets(int i, int i2, int i3, int i4) {
        this.left = i;
        this.top = i2;
        this.right = i3;
        this.bottom = i4;
    }

    @androidx.annotation.NonNull
    public static androidx.core.graphics.Insets add(@androidx.annotation.NonNull androidx.core.graphics.Insets insets, @androidx.annotation.NonNull androidx.core.graphics.Insets insets2) {
        return of(insets.left + insets2.left, insets.top + insets2.top, insets.right + insets2.right, insets.bottom + insets2.bottom);
    }

    @androidx.annotation.NonNull
    public static androidx.core.graphics.Insets max(@androidx.annotation.NonNull androidx.core.graphics.Insets insets, @androidx.annotation.NonNull androidx.core.graphics.Insets insets2) {
        return of(java.lang.Math.max(insets.left, insets2.left), java.lang.Math.max(insets.top, insets2.top), java.lang.Math.max(insets.right, insets2.right), java.lang.Math.max(insets.bottom, insets2.bottom));
    }

    @androidx.annotation.NonNull
    public static androidx.core.graphics.Insets min(@androidx.annotation.NonNull androidx.core.graphics.Insets insets, @androidx.annotation.NonNull androidx.core.graphics.Insets insets2) {
        return of(java.lang.Math.min(insets.left, insets2.left), java.lang.Math.min(insets.top, insets2.top), java.lang.Math.min(insets.right, insets2.right), java.lang.Math.min(insets.bottom, insets2.bottom));
    }

    @androidx.annotation.NonNull
    public static androidx.core.graphics.Insets of(int i, int i2, int i3, int i4) {
        return (i == 0 && i2 == 0 && i3 == 0 && i4 == 0) ? NONE : new androidx.core.graphics.Insets(i, i2, i3, i4);
    }

    @androidx.annotation.NonNull
    public static androidx.core.graphics.Insets of(@androidx.annotation.NonNull android.graphics.Rect rect) {
        return of(rect.left, rect.top, rect.right, rect.bottom);
    }

    @androidx.annotation.NonNull
    public static androidx.core.graphics.Insets subtract(@androidx.annotation.NonNull androidx.core.graphics.Insets insets, @androidx.annotation.NonNull androidx.core.graphics.Insets insets2) {
        return of(insets.left - insets2.left, insets.top - insets2.top, insets.right - insets2.right, insets.bottom - insets2.bottom);
    }

    @androidx.annotation.NonNull
    @androidx.annotation.RequiresApi(api = 29)
    public static androidx.core.graphics.Insets toCompatInsets(@androidx.annotation.NonNull android.graphics.Insets insets) {
        int i;
        int i2;
        int i3;
        int i4;
        i = insets.left;
        i2 = insets.top;
        i3 = insets.right;
        i4 = insets.bottom;
        return of(i, i2, i3, i4);
    }

    @androidx.annotation.NonNull
    @java.lang.Deprecated
    @androidx.annotation.RequiresApi(api = 29)
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static androidx.core.graphics.Insets wrap(@androidx.annotation.NonNull android.graphics.Insets insets) {
        return toCompatInsets(insets);
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || androidx.core.graphics.Insets.class != obj.getClass()) {
            return false;
        }
        androidx.core.graphics.Insets insets = (androidx.core.graphics.Insets) obj;
        return this.bottom == insets.bottom && this.left == insets.left && this.right == insets.right && this.top == insets.top;
    }

    public int hashCode() {
        return (((((this.left * 31) + this.top) * 31) + this.right) * 31) + this.bottom;
    }

    @androidx.annotation.NonNull
    @androidx.annotation.RequiresApi(api = 29)
    public android.graphics.Insets toPlatformInsets() {
        android.graphics.Insets of;
        of = android.graphics.Insets.of(this.left, this.top, this.right, this.bottom);
        return of;
    }

    public java.lang.String toString() {
        return "Insets{left=" + this.left + ", top=" + this.top + ", right=" + this.right + ", bottom=" + this.bottom + '}';
    }
}
