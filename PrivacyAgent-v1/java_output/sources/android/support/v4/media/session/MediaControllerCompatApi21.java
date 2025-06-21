package android.support.v4.media.session;

@androidx.annotation.RequiresApi(21)
/* loaded from: classes.dex */
class MediaControllerCompatApi21 {

    public interface Callback {
        void onAudioInfoChanged(int i, int i2, int i3, int i4, int i5);

        void onExtrasChanged(android.os.Bundle bundle);

        void onMetadataChanged(java.lang.Object obj);

        void onPlaybackStateChanged(java.lang.Object obj);

        void onQueueChanged(java.util.List<?> list);

        void onQueueTitleChanged(java.lang.CharSequence charSequence);

        void onSessionDestroyed();

        void onSessionEvent(java.lang.String str, android.os.Bundle bundle);
    }

    public static class CallbackProxy<T extends android.support.v4.media.session.MediaControllerCompatApi21.Callback> extends android.media.session.MediaController.Callback {
        protected final T mCallback;

        public CallbackProxy(T t) {
            this.mCallback = t;
        }

        @Override // android.media.session.MediaController.Callback
        public void onAudioInfoChanged(android.media.session.MediaController.PlaybackInfo playbackInfo) {
            this.mCallback.onAudioInfoChanged(playbackInfo.getPlaybackType(), android.support.v4.media.session.MediaControllerCompatApi21.PlaybackInfo.getLegacyAudioStream(playbackInfo), playbackInfo.getVolumeControl(), playbackInfo.getMaxVolume(), playbackInfo.getCurrentVolume());
        }

        @Override // android.media.session.MediaController.Callback
        public void onExtrasChanged(android.os.Bundle bundle) {
            android.support.v4.media.session.MediaSessionCompat.ensureClassLoader(bundle);
            this.mCallback.onExtrasChanged(bundle);
        }

        @Override // android.media.session.MediaController.Callback
        public void onMetadataChanged(android.media.MediaMetadata mediaMetadata) {
            this.mCallback.onMetadataChanged(mediaMetadata);
        }

        @Override // android.media.session.MediaController.Callback
        public void onPlaybackStateChanged(android.media.session.PlaybackState playbackState) {
            this.mCallback.onPlaybackStateChanged(playbackState);
        }

        @Override // android.media.session.MediaController.Callback
        public void onQueueChanged(java.util.List<android.media.session.MediaSession.QueueItem> list) {
            this.mCallback.onQueueChanged(list);
        }

        @Override // android.media.session.MediaController.Callback
        public void onQueueTitleChanged(java.lang.CharSequence charSequence) {
            this.mCallback.onQueueTitleChanged(charSequence);
        }

        @Override // android.media.session.MediaController.Callback
        public void onSessionDestroyed() {
            this.mCallback.onSessionDestroyed();
        }

        @Override // android.media.session.MediaController.Callback
        public void onSessionEvent(java.lang.String str, android.os.Bundle bundle) {
            android.support.v4.media.session.MediaSessionCompat.ensureClassLoader(bundle);
            this.mCallback.onSessionEvent(str, bundle);
        }
    }

    public static class PlaybackInfo {
        private static final int FLAG_SCO = 4;
        private static final int STREAM_BLUETOOTH_SCO = 6;
        private static final int STREAM_SYSTEM_ENFORCED = 7;

        private PlaybackInfo() {
        }

        public static android.media.AudioAttributes getAudioAttributes(java.lang.Object obj) {
            return ((android.media.session.MediaController.PlaybackInfo) obj).getAudioAttributes();
        }

        public static int getCurrentVolume(java.lang.Object obj) {
            return ((android.media.session.MediaController.PlaybackInfo) obj).getCurrentVolume();
        }

        public static int getLegacyAudioStream(java.lang.Object obj) {
            return toLegacyStreamType(getAudioAttributes(obj));
        }

        public static int getMaxVolume(java.lang.Object obj) {
            return ((android.media.session.MediaController.PlaybackInfo) obj).getMaxVolume();
        }

        public static int getPlaybackType(java.lang.Object obj) {
            return ((android.media.session.MediaController.PlaybackInfo) obj).getPlaybackType();
        }

        public static int getVolumeControl(java.lang.Object obj) {
            return ((android.media.session.MediaController.PlaybackInfo) obj).getVolumeControl();
        }

        private static int toLegacyStreamType(android.media.AudioAttributes audioAttributes) {
            if ((audioAttributes.getFlags() & 1) == 1) {
                return 7;
            }
            if ((audioAttributes.getFlags() & 4) == 4) {
                return 6;
            }
            int usage = audioAttributes.getUsage();
            if (usage == 13) {
                return 1;
            }
            switch (usage) {
                case 2:
                    return 0;
                case 3:
                    return 8;
                case 4:
                    return 4;
                case 5:
                case 7:
                case 8:
                case 9:
                case 10:
                    return 5;
                case 6:
                    return 2;
                default:
                    return 3;
            }
        }
    }

    public static class TransportControls {
        private TransportControls() {
        }

        public static void fastForward(java.lang.Object obj) {
            ((android.media.session.MediaController.TransportControls) obj).fastForward();
        }

        public static void pause(java.lang.Object obj) {
            ((android.media.session.MediaController.TransportControls) obj).pause();
        }

        public static void play(java.lang.Object obj) {
            ((android.media.session.MediaController.TransportControls) obj).play();
        }

        public static void playFromMediaId(java.lang.Object obj, java.lang.String str, android.os.Bundle bundle) {
            ((android.media.session.MediaController.TransportControls) obj).playFromMediaId(str, bundle);
        }

        public static void playFromSearch(java.lang.Object obj, java.lang.String str, android.os.Bundle bundle) {
            ((android.media.session.MediaController.TransportControls) obj).playFromSearch(str, bundle);
        }

        public static void rewind(java.lang.Object obj) {
            ((android.media.session.MediaController.TransportControls) obj).rewind();
        }

        public static void seekTo(java.lang.Object obj, long j) {
            ((android.media.session.MediaController.TransportControls) obj).seekTo(j);
        }

        public static void sendCustomAction(java.lang.Object obj, java.lang.String str, android.os.Bundle bundle) {
            ((android.media.session.MediaController.TransportControls) obj).sendCustomAction(str, bundle);
        }

        public static void setRating(java.lang.Object obj, java.lang.Object obj2) {
            ((android.media.session.MediaController.TransportControls) obj).setRating((android.media.Rating) obj2);
        }

        public static void skipToNext(java.lang.Object obj) {
            ((android.media.session.MediaController.TransportControls) obj).skipToNext();
        }

        public static void skipToPrevious(java.lang.Object obj) {
            ((android.media.session.MediaController.TransportControls) obj).skipToPrevious();
        }

        public static void skipToQueueItem(java.lang.Object obj, long j) {
            ((android.media.session.MediaController.TransportControls) obj).skipToQueueItem(j);
        }

        public static void stop(java.lang.Object obj) {
            ((android.media.session.MediaController.TransportControls) obj).stop();
        }
    }

    private MediaControllerCompatApi21() {
    }

    public static void adjustVolume(java.lang.Object obj, int i, int i2) {
        ((android.media.session.MediaController) obj).adjustVolume(i, i2);
    }

    public static java.lang.Object createCallback(android.support.v4.media.session.MediaControllerCompatApi21.Callback callback) {
        return new android.support.v4.media.session.MediaControllerCompatApi21.CallbackProxy(callback);
    }

    public static boolean dispatchMediaButtonEvent(java.lang.Object obj, android.view.KeyEvent keyEvent) {
        return ((android.media.session.MediaController) obj).dispatchMediaButtonEvent(keyEvent);
    }

    public static java.lang.Object fromToken(android.content.Context context, java.lang.Object obj) {
        return new android.media.session.MediaController(context, (android.media.session.MediaSession.Token) obj);
    }

    public static android.os.Bundle getExtras(java.lang.Object obj) {
        return ((android.media.session.MediaController) obj).getExtras();
    }

    public static long getFlags(java.lang.Object obj) {
        return ((android.media.session.MediaController) obj).getFlags();
    }

    public static java.lang.Object getMediaController(android.app.Activity activity) {
        return activity.getMediaController();
    }

    public static java.lang.Object getMetadata(java.lang.Object obj) {
        return ((android.media.session.MediaController) obj).getMetadata();
    }

    public static java.lang.String getPackageName(java.lang.Object obj) {
        return ((android.media.session.MediaController) obj).getPackageName();
    }

    public static java.lang.Object getPlaybackInfo(java.lang.Object obj) {
        return ((android.media.session.MediaController) obj).getPlaybackInfo();
    }

    public static java.lang.Object getPlaybackState(java.lang.Object obj) {
        return ((android.media.session.MediaController) obj).getPlaybackState();
    }

    public static java.util.List<java.lang.Object> getQueue(java.lang.Object obj) {
        java.util.List<android.media.session.MediaSession.QueueItem> queue = ((android.media.session.MediaController) obj).getQueue();
        if (queue == null) {
            return null;
        }
        return new java.util.ArrayList(queue);
    }

    public static java.lang.CharSequence getQueueTitle(java.lang.Object obj) {
        return ((android.media.session.MediaController) obj).getQueueTitle();
    }

    public static int getRatingType(java.lang.Object obj) {
        return ((android.media.session.MediaController) obj).getRatingType();
    }

    public static android.app.PendingIntent getSessionActivity(java.lang.Object obj) {
        return ((android.media.session.MediaController) obj).getSessionActivity();
    }

    public static java.lang.Object getSessionToken(java.lang.Object obj) {
        return ((android.media.session.MediaController) obj).getSessionToken();
    }

    public static java.lang.Object getTransportControls(java.lang.Object obj) {
        return ((android.media.session.MediaController) obj).getTransportControls();
    }

    public static void registerCallback(java.lang.Object obj, java.lang.Object obj2, android.os.Handler handler) {
        ((android.media.session.MediaController) obj).registerCallback((android.media.session.MediaController.Callback) obj2, handler);
    }

    public static void sendCommand(java.lang.Object obj, java.lang.String str, android.os.Bundle bundle, android.os.ResultReceiver resultReceiver) {
        ((android.media.session.MediaController) obj).sendCommand(str, bundle, resultReceiver);
    }

    public static void setMediaController(android.app.Activity activity, java.lang.Object obj) {
        activity.setMediaController((android.media.session.MediaController) obj);
    }

    public static void setVolumeTo(java.lang.Object obj, int i, int i2) {
        ((android.media.session.MediaController) obj).setVolumeTo(i, i2);
    }

    public static void unregisterCallback(java.lang.Object obj, java.lang.Object obj2) {
        ((android.media.session.MediaController) obj).unregisterCallback((android.media.session.MediaController.Callback) obj2);
    }
}
