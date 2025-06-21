package androidx.core.widget;

/* loaded from: classes.dex */
public final class ListViewCompat {
    private ListViewCompat() {
    }

    public static boolean canScrollList(@androidx.annotation.NonNull android.widget.ListView listView, int i) {
        return listView.canScrollList(i);
    }

    public static void scrollListBy(@androidx.annotation.NonNull android.widget.ListView listView, int i) {
        listView.scrollListBy(i);
    }
}
