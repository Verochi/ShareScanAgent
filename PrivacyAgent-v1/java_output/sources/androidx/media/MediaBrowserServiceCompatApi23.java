package androidx.media;

@androidx.annotation.RequiresApi(23)
/* loaded from: classes.dex */
class MediaBrowserServiceCompatApi23 {

    public static class MediaBrowserServiceAdaptor extends androidx.media.MediaBrowserServiceCompatApi21.MediaBrowserServiceAdaptor {
        public MediaBrowserServiceAdaptor(android.content.Context context, androidx.media.MediaBrowserServiceCompatApi23.ServiceCompatProxy serviceCompatProxy) {
            super(context, serviceCompatProxy);
        }

        @Override // android.service.media.MediaBrowserService
        public void onLoadItem(java.lang.String str, android.service.media.MediaBrowserService.Result<android.media.browse.MediaBrowser.MediaItem> result) {
            ((androidx.media.MediaBrowserServiceCompatApi23.ServiceCompatProxy) this.mServiceProxy).onLoadItem(str, new androidx.media.MediaBrowserServiceCompatApi21.ResultWrapper<>(result));
        }
    }

    public interface ServiceCompatProxy extends androidx.media.MediaBrowserServiceCompatApi21.ServiceCompatProxy {
        void onLoadItem(java.lang.String str, androidx.media.MediaBrowserServiceCompatApi21.ResultWrapper<android.os.Parcel> resultWrapper);
    }

    private MediaBrowserServiceCompatApi23() {
    }

    public static java.lang.Object createService(android.content.Context context, androidx.media.MediaBrowserServiceCompatApi23.ServiceCompatProxy serviceCompatProxy) {
        return new androidx.media.MediaBrowserServiceCompatApi23.MediaBrowserServiceAdaptor(context, serviceCompatProxy);
    }
}
