package com.alimm.tanx.ui.image.glide.load.data;

/* loaded from: classes.dex */
public class MediaStoreThumbFetcher implements com.alimm.tanx.ui.image.glide.load.data.DataFetcher<java.io.InputStream> {
    private static final com.alimm.tanx.ui.image.glide.load.data.MediaStoreThumbFetcher.ThumbnailStreamOpenerFactory DEFAULT_FACTORY = new com.alimm.tanx.ui.image.glide.load.data.MediaStoreThumbFetcher.ThumbnailStreamOpenerFactory();
    private static final int MINI_HEIGHT = 384;
    private static final int MINI_WIDTH = 512;
    private static final java.lang.String TAG = "MediaStoreThumbFetcher";
    private final android.content.Context context;
    private final com.alimm.tanx.ui.image.glide.load.data.DataFetcher<java.io.InputStream> defaultFetcher;
    private final com.alimm.tanx.ui.image.glide.load.data.MediaStoreThumbFetcher.ThumbnailStreamOpenerFactory factory;
    private final int height;
    private java.io.InputStream inputStream;
    private final android.net.Uri mediaStoreUri;
    private final int width;

    public static class FileService {
        public boolean exists(java.io.File file) {
            return file.exists();
        }

        public java.io.File get(java.lang.String str) {
            return new java.io.File(str);
        }

        public long length(java.io.File file) {
            return file.length();
        }
    }

    public static class ImageThumbnailQuery implements com.alimm.tanx.ui.image.glide.load.data.MediaStoreThumbFetcher.ThumbnailQuery {
        private static final java.lang.String[] PATH_PROJECTION = {"_data"};
        private static final java.lang.String PATH_SELECTION = "kind = 1 AND image_id = ?";

        @Override // com.alimm.tanx.ui.image.glide.load.data.MediaStoreThumbFetcher.ThumbnailQuery
        public android.database.Cursor queryPath(android.content.Context context, android.net.Uri uri) {
            return context.getContentResolver().query(android.provider.MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, PATH_PROJECTION, PATH_SELECTION, new java.lang.String[]{uri.getLastPathSegment()}, null);
        }
    }

    public interface ThumbnailQuery {
        android.database.Cursor queryPath(android.content.Context context, android.net.Uri uri);
    }

    public static class ThumbnailStreamOpener {
        private static final com.alimm.tanx.ui.image.glide.load.data.MediaStoreThumbFetcher.FileService DEFAULT_SERVICE = new com.alimm.tanx.ui.image.glide.load.data.MediaStoreThumbFetcher.FileService();
        private com.alimm.tanx.ui.image.glide.load.data.MediaStoreThumbFetcher.ThumbnailQuery query;
        private final com.alimm.tanx.ui.image.glide.load.data.MediaStoreThumbFetcher.FileService service;

        public ThumbnailStreamOpener(com.alimm.tanx.ui.image.glide.load.data.MediaStoreThumbFetcher.FileService fileService, com.alimm.tanx.ui.image.glide.load.data.MediaStoreThumbFetcher.ThumbnailQuery thumbnailQuery) {
            this.service = fileService;
            this.query = thumbnailQuery;
        }

        public ThumbnailStreamOpener(com.alimm.tanx.ui.image.glide.load.data.MediaStoreThumbFetcher.ThumbnailQuery thumbnailQuery) {
            this(DEFAULT_SERVICE, thumbnailQuery);
        }

        private android.net.Uri parseThumbUri(android.database.Cursor cursor) {
            java.lang.String string = cursor.getString(0);
            if (!android.text.TextUtils.isEmpty(string)) {
                java.io.File file = this.service.get(string);
                if (this.service.exists(file) && this.service.length(file) > 0) {
                    return android.net.Uri.fromFile(file);
                }
            }
            return null;
        }

        public int getOrientation(android.content.Context context, android.net.Uri uri) {
            java.io.InputStream inputStream = null;
            try {
                try {
                    inputStream = context.getContentResolver().openInputStream(uri);
                    int orientation = new com.alimm.tanx.ui.image.glide.load.resource.bitmap.ImageHeaderParser(inputStream).getOrientation();
                    if (inputStream == null) {
                        return orientation;
                    }
                    try {
                        inputStream.close();
                        return orientation;
                    } catch (java.io.IOException unused) {
                        return orientation;
                    }
                } catch (java.io.IOException unused2) {
                    if (android.util.Log.isLoggable(com.alimm.tanx.ui.image.glide.load.data.MediaStoreThumbFetcher.TAG, 3)) {
                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                        sb.append("Failed to open uri: ");
                        sb.append(uri);
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (java.io.IOException unused3) {
                        }
                    }
                    return -1;
                }
            } catch (java.lang.Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (java.io.IOException unused4) {
                    }
                }
                throw th;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:10:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:5:0x001c A[DONT_GENERATE] */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0021  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public java.io.InputStream open(android.content.Context context, android.net.Uri uri) throws java.io.FileNotFoundException {
            android.net.Uri parseThumbUri;
            android.database.Cursor queryPath = this.query.queryPath(context, uri);
            if (queryPath != null) {
                try {
                    if (queryPath.moveToFirst()) {
                        parseThumbUri = parseThumbUri(queryPath);
                        if (queryPath != null) {
                        }
                        if (parseThumbUri == null) {
                            return context.getContentResolver().openInputStream(parseThumbUri);
                        }
                        return null;
                    }
                } finally {
                    queryPath.close();
                }
            }
            parseThumbUri = null;
            if (queryPath != null) {
            }
            if (parseThumbUri == null) {
            }
        }
    }

    public static class ThumbnailStreamOpenerFactory {
        public com.alimm.tanx.ui.image.glide.load.data.MediaStoreThumbFetcher.ThumbnailStreamOpener build(android.net.Uri uri, int i, int i2) {
            if (!com.alimm.tanx.ui.image.glide.load.data.MediaStoreThumbFetcher.isMediaStoreUri(uri) || i > 512 || i2 > com.alimm.tanx.ui.image.glide.load.data.MediaStoreThumbFetcher.MINI_HEIGHT) {
                return null;
            }
            return com.alimm.tanx.ui.image.glide.load.data.MediaStoreThumbFetcher.isMediaStoreVideo(uri) ? new com.alimm.tanx.ui.image.glide.load.data.MediaStoreThumbFetcher.ThumbnailStreamOpener(new com.alimm.tanx.ui.image.glide.load.data.MediaStoreThumbFetcher.VideoThumbnailQuery()) : new com.alimm.tanx.ui.image.glide.load.data.MediaStoreThumbFetcher.ThumbnailStreamOpener(new com.alimm.tanx.ui.image.glide.load.data.MediaStoreThumbFetcher.ImageThumbnailQuery());
        }
    }

    public static class VideoThumbnailQuery implements com.alimm.tanx.ui.image.glide.load.data.MediaStoreThumbFetcher.ThumbnailQuery {
        private static final java.lang.String[] PATH_PROJECTION = {"_data"};
        private static final java.lang.String PATH_SELECTION = "kind = 1 AND video_id = ?";

        @Override // com.alimm.tanx.ui.image.glide.load.data.MediaStoreThumbFetcher.ThumbnailQuery
        public android.database.Cursor queryPath(android.content.Context context, android.net.Uri uri) {
            return context.getContentResolver().query(android.provider.MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, PATH_PROJECTION, PATH_SELECTION, new java.lang.String[]{uri.getLastPathSegment()}, null);
        }
    }

    public MediaStoreThumbFetcher(android.content.Context context, android.net.Uri uri, com.alimm.tanx.ui.image.glide.load.data.DataFetcher<java.io.InputStream> dataFetcher, int i, int i2) {
        this(context, uri, dataFetcher, i, i2, DEFAULT_FACTORY);
    }

    public MediaStoreThumbFetcher(android.content.Context context, android.net.Uri uri, com.alimm.tanx.ui.image.glide.load.data.DataFetcher<java.io.InputStream> dataFetcher, int i, int i2, com.alimm.tanx.ui.image.glide.load.data.MediaStoreThumbFetcher.ThumbnailStreamOpenerFactory thumbnailStreamOpenerFactory) {
        this.context = context;
        this.mediaStoreUri = uri;
        this.defaultFetcher = dataFetcher;
        this.width = i;
        this.height = i2;
        this.factory = thumbnailStreamOpenerFactory;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isMediaStoreUri(android.net.Uri uri) {
        return uri != null && "content".equals(uri.getScheme()) && "media".equals(uri.getAuthority());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isMediaStoreVideo(android.net.Uri uri) {
        return isMediaStoreUri(uri) && uri.getPathSegments().contains("video");
    }

    private java.io.InputStream openThumbInputStream(com.alimm.tanx.ui.image.glide.load.data.MediaStoreThumbFetcher.ThumbnailStreamOpener thumbnailStreamOpener) {
        java.io.InputStream inputStream;
        try {
            inputStream = thumbnailStreamOpener.open(this.context, this.mediaStoreUri);
        } catch (java.io.FileNotFoundException unused) {
            inputStream = null;
        }
        int orientation = inputStream != null ? thumbnailStreamOpener.getOrientation(this.context, this.mediaStoreUri) : -1;
        return orientation != -1 ? new com.alimm.tanx.ui.image.glide.load.data.ExifOrientationStream(inputStream, orientation) : inputStream;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.data.DataFetcher
    public void cancel() {
    }

    @Override // com.alimm.tanx.ui.image.glide.load.data.DataFetcher
    public void cleanup() {
        java.io.InputStream inputStream = this.inputStream;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (java.io.IOException unused) {
            }
        }
        this.defaultFetcher.cleanup();
    }

    @Override // com.alimm.tanx.ui.image.glide.load.data.DataFetcher
    public java.lang.String getId() {
        return this.mediaStoreUri.toString();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.alimm.tanx.ui.image.glide.load.data.DataFetcher
    public java.io.InputStream loadData(com.alimm.tanx.ui.image.glide.Priority priority) throws java.lang.Exception {
        com.alimm.tanx.ui.image.glide.load.data.MediaStoreThumbFetcher.ThumbnailStreamOpener build = this.factory.build(this.mediaStoreUri, this.width, this.height);
        if (build != null) {
            this.inputStream = openThumbInputStream(build);
        }
        if (this.inputStream == null) {
            this.inputStream = this.defaultFetcher.loadData(priority);
        }
        return this.inputStream;
    }
}
