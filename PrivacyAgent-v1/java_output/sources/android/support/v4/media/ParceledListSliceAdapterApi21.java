package android.support.v4.media;

@androidx.annotation.RequiresApi(21)
/* loaded from: classes.dex */
class ParceledListSliceAdapterApi21 {
    private static java.lang.reflect.Constructor sConstructor;

    static {
        try {
            sConstructor = java.lang.Class.forName("android.content.pm.ParceledListSlice").getConstructor(java.util.List.class);
        } catch (java.lang.ClassNotFoundException | java.lang.NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    private ParceledListSliceAdapterApi21() {
    }

    public static java.lang.Object newInstance(java.util.List<android.media.browse.MediaBrowser.MediaItem> list) {
        try {
            return sConstructor.newInstance(list);
        } catch (java.lang.IllegalAccessException | java.lang.InstantiationException | java.lang.reflect.InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }
    }
}
