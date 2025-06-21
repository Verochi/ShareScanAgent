package androidx.media;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class MediaBrowserCompatUtils {
    private MediaBrowserCompatUtils() {
    }

    public static boolean areSameOptions(android.os.Bundle bundle, android.os.Bundle bundle2) {
        if (bundle == bundle2) {
            return true;
        }
        return bundle == null ? bundle2.getInt(android.support.v4.media.MediaBrowserCompat.EXTRA_PAGE, -1) == -1 && bundle2.getInt(android.support.v4.media.MediaBrowserCompat.EXTRA_PAGE_SIZE, -1) == -1 : bundle2 == null ? bundle.getInt(android.support.v4.media.MediaBrowserCompat.EXTRA_PAGE, -1) == -1 && bundle.getInt(android.support.v4.media.MediaBrowserCompat.EXTRA_PAGE_SIZE, -1) == -1 : bundle.getInt(android.support.v4.media.MediaBrowserCompat.EXTRA_PAGE, -1) == bundle2.getInt(android.support.v4.media.MediaBrowserCompat.EXTRA_PAGE, -1) && bundle.getInt(android.support.v4.media.MediaBrowserCompat.EXTRA_PAGE_SIZE, -1) == bundle2.getInt(android.support.v4.media.MediaBrowserCompat.EXTRA_PAGE_SIZE, -1);
    }

    public static boolean hasDuplicatedItems(android.os.Bundle bundle, android.os.Bundle bundle2) {
        int i;
        int i2;
        int i3;
        int i4 = bundle == null ? -1 : bundle.getInt(android.support.v4.media.MediaBrowserCompat.EXTRA_PAGE, -1);
        int i5 = bundle2 == null ? -1 : bundle2.getInt(android.support.v4.media.MediaBrowserCompat.EXTRA_PAGE, -1);
        int i6 = bundle == null ? -1 : bundle.getInt(android.support.v4.media.MediaBrowserCompat.EXTRA_PAGE_SIZE, -1);
        int i7 = bundle2 == null ? -1 : bundle2.getInt(android.support.v4.media.MediaBrowserCompat.EXTRA_PAGE_SIZE, -1);
        int i8 = Integer.MAX_VALUE;
        if (i4 == -1 || i6 == -1) {
            i = Integer.MAX_VALUE;
            i2 = 0;
        } else {
            i2 = i4 * i6;
            i = (i6 + i2) - 1;
        }
        if (i5 == -1 || i7 == -1) {
            i3 = 0;
        } else {
            i3 = i5 * i7;
            i8 = (i7 + i3) - 1;
        }
        return i >= i3 && i8 >= i2;
    }
}
