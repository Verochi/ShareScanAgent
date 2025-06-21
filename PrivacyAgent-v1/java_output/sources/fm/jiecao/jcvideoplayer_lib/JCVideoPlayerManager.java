package fm.jiecao.jcvideoplayer_lib;

/* loaded from: classes9.dex */
public class JCVideoPlayerManager {
    public static java.lang.ref.WeakReference<fm.jiecao.jcvideoplayer_lib.JCMediaPlayerListener> CURRENT_SCROLL_LISTENER;
    public static java.util.LinkedList<java.lang.ref.WeakReference<fm.jiecao.jcvideoplayer_lib.JCMediaPlayerListener>> LISTENERLIST = new java.util.LinkedList<>();

    public static void checkAndPutListener(fm.jiecao.jcvideoplayer_lib.JCMediaPlayerListener jCMediaPlayerListener) {
        if (jCMediaPlayerListener.getScreenType() == 3 || jCMediaPlayerListener.getScreenType() == 2) {
            return;
        }
        int i = -1;
        for (int i2 = 1; i2 < LISTENERLIST.size(); i2++) {
            fm.jiecao.jcvideoplayer_lib.JCMediaPlayerListener jCMediaPlayerListener2 = LISTENERLIST.get(i2).get();
            if (jCMediaPlayerListener2 != null && jCMediaPlayerListener.getUrl().equals(jCMediaPlayerListener2.getUrl())) {
                i = i2;
            }
        }
        if (i != -1) {
            LISTENERLIST.remove(i);
            if (LISTENERLIST.size() <= i) {
                LISTENERLIST.addLast(new java.lang.ref.WeakReference<>(jCMediaPlayerListener));
            } else {
                LISTENERLIST.set(i, new java.lang.ref.WeakReference<>(jCMediaPlayerListener));
            }
        }
    }

    public static void completeAll() {
        for (fm.jiecao.jcvideoplayer_lib.JCMediaPlayerListener popListener = popListener(); popListener != null; popListener = popListener()) {
            popListener.onCompletion();
        }
    }

    public static fm.jiecao.jcvideoplayer_lib.JCMediaPlayerListener getFirst() {
        if (LISTENERLIST.size() == 0) {
            return null;
        }
        return LISTENERLIST.getFirst().get();
    }

    public static fm.jiecao.jcvideoplayer_lib.JCMediaPlayerListener popListener() {
        if (LISTENERLIST.size() == 0) {
            return null;
        }
        return LISTENERLIST.pop().get();
    }

    public static void putListener(fm.jiecao.jcvideoplayer_lib.JCMediaPlayerListener jCMediaPlayerListener) {
        LISTENERLIST.push(new java.lang.ref.WeakReference<>(jCMediaPlayerListener));
    }

    public static void putScrollListener(fm.jiecao.jcvideoplayer_lib.JCMediaPlayerListener jCMediaPlayerListener) {
        if (jCMediaPlayerListener.getScreenType() == 3 || jCMediaPlayerListener.getScreenType() == 2) {
            return;
        }
        CURRENT_SCROLL_LISTENER = new java.lang.ref.WeakReference<>(jCMediaPlayerListener);
    }
}
