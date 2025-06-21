package androidx.core.provider;

/* loaded from: classes.dex */
public class FontsContractCompat {

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @java.lang.Deprecated
    public static final java.lang.String PARCEL_FONT_RESULTS = "font_results";

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @java.lang.Deprecated
    static final int RESULT_CODE_PROVIDER_NOT_FOUND = -1;

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @java.lang.Deprecated
    static final int RESULT_CODE_WRONG_CERTIFICATES = -2;

    public static final class Columns implements android.provider.BaseColumns {
        public static final java.lang.String FILE_ID = "file_id";
        public static final java.lang.String ITALIC = "font_italic";
        public static final java.lang.String RESULT_CODE = "result_code";
        public static final int RESULT_CODE_FONT_NOT_FOUND = 1;
        public static final int RESULT_CODE_FONT_UNAVAILABLE = 2;
        public static final int RESULT_CODE_MALFORMED_QUERY = 3;
        public static final int RESULT_CODE_OK = 0;
        public static final java.lang.String TTC_INDEX = "font_ttc_index";
        public static final java.lang.String VARIATION_SETTINGS = "font_variation_settings";
        public static final java.lang.String WEIGHT = "font_weight";
    }

    public static class FontFamilyResult {
        public static final int STATUS_OK = 0;
        public static final int STATUS_UNEXPECTED_DATA_PROVIDED = 2;
        public static final int STATUS_WRONG_CERTIFICATES = 1;
        private final androidx.core.provider.FontsContractCompat.FontInfo[] mFonts;
        private final int mStatusCode;

        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        @java.lang.Deprecated
        public FontFamilyResult(int i, @androidx.annotation.Nullable androidx.core.provider.FontsContractCompat.FontInfo[] fontInfoArr) {
            this.mStatusCode = i;
            this.mFonts = fontInfoArr;
        }

        public static androidx.core.provider.FontsContractCompat.FontFamilyResult create(int i, @androidx.annotation.Nullable androidx.core.provider.FontsContractCompat.FontInfo[] fontInfoArr) {
            return new androidx.core.provider.FontsContractCompat.FontFamilyResult(i, fontInfoArr);
        }

        public androidx.core.provider.FontsContractCompat.FontInfo[] getFonts() {
            return this.mFonts;
        }

        public int getStatusCode() {
            return this.mStatusCode;
        }
    }

    public static class FontInfo {
        private final boolean mItalic;
        private final int mResultCode;
        private final int mTtcIndex;
        private final android.net.Uri mUri;
        private final int mWeight;

        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        @java.lang.Deprecated
        public FontInfo(@androidx.annotation.NonNull android.net.Uri uri, @androidx.annotation.IntRange(from = 0) int i, @androidx.annotation.IntRange(from = 1, to = 1000) int i2, boolean z, int i3) {
            this.mUri = (android.net.Uri) androidx.core.util.Preconditions.checkNotNull(uri);
            this.mTtcIndex = i;
            this.mWeight = i2;
            this.mItalic = z;
            this.mResultCode = i3;
        }

        public static androidx.core.provider.FontsContractCompat.FontInfo create(@androidx.annotation.NonNull android.net.Uri uri, @androidx.annotation.IntRange(from = 0) int i, @androidx.annotation.IntRange(from = 1, to = 1000) int i2, boolean z, int i3) {
            return new androidx.core.provider.FontsContractCompat.FontInfo(uri, i, i2, z, i3);
        }

        public int getResultCode() {
            return this.mResultCode;
        }

        @androidx.annotation.IntRange(from = 0)
        public int getTtcIndex() {
            return this.mTtcIndex;
        }

        @androidx.annotation.NonNull
        public android.net.Uri getUri() {
            return this.mUri;
        }

        @androidx.annotation.IntRange(from = 1, to = 1000)
        public int getWeight() {
            return this.mWeight;
        }

        public boolean isItalic() {
            return this.mItalic;
        }
    }

    public static class FontRequestCallback {
        public static final int FAIL_REASON_FONT_LOAD_ERROR = -3;
        public static final int FAIL_REASON_FONT_NOT_FOUND = 1;
        public static final int FAIL_REASON_FONT_UNAVAILABLE = 2;
        public static final int FAIL_REASON_MALFORMED_QUERY = 3;
        public static final int FAIL_REASON_PROVIDER_NOT_FOUND = -1;
        public static final int FAIL_REASON_SECURITY_VIOLATION = -4;
        public static final int FAIL_REASON_WRONG_CERTIFICATES = -2;

        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        @java.lang.Deprecated
        public static final int RESULT_OK = 0;
        static final int RESULT_SUCCESS = 0;

        @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public @interface FontRequestFailReason {
        }

        public void onTypefaceRequestFailed(int i) {
        }

        public void onTypefaceRetrieved(android.graphics.Typeface typeface) {
        }
    }

    private FontsContractCompat() {
    }

    @androidx.annotation.Nullable
    public static android.graphics.Typeface buildTypeface(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.os.CancellationSignal cancellationSignal, @androidx.annotation.NonNull androidx.core.provider.FontsContractCompat.FontInfo[] fontInfoArr) {
        return androidx.core.graphics.TypefaceCompat.createFromFontInfo(context, cancellationSignal, fontInfoArr, 0);
    }

    @androidx.annotation.NonNull
    public static androidx.core.provider.FontsContractCompat.FontFamilyResult fetchFonts(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.os.CancellationSignal cancellationSignal, @androidx.annotation.NonNull androidx.core.provider.FontRequest fontRequest) throws android.content.pm.PackageManager.NameNotFoundException {
        return androidx.core.provider.FontProvider.getFontFamilyResult(context, fontRequest, cancellationSignal);
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @java.lang.Deprecated
    public static android.graphics.Typeface getFontSync(android.content.Context context, androidx.core.provider.FontRequest fontRequest, @androidx.annotation.Nullable androidx.core.content.res.ResourcesCompat.FontCallback fontCallback, @androidx.annotation.Nullable android.os.Handler handler, boolean z, int i, int i2) {
        return requestFont(context, fontRequest, i2, z, i, androidx.core.content.res.ResourcesCompat.FontCallback.getHandler(handler), new androidx.core.graphics.TypefaceCompat.ResourcesCallbackAdapter(fontCallback));
    }

    @androidx.annotation.VisibleForTesting
    @java.lang.Deprecated
    @androidx.annotation.Nullable
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static android.content.pm.ProviderInfo getProvider(@androidx.annotation.NonNull android.content.pm.PackageManager packageManager, @androidx.annotation.NonNull androidx.core.provider.FontRequest fontRequest, @androidx.annotation.Nullable android.content.res.Resources resources) throws android.content.pm.PackageManager.NameNotFoundException {
        return androidx.core.provider.FontProvider.getProvider(packageManager, fontRequest, resources);
    }

    @androidx.annotation.RequiresApi(19)
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @java.lang.Deprecated
    public static java.util.Map<android.net.Uri, java.nio.ByteBuffer> prepareFontData(android.content.Context context, androidx.core.provider.FontsContractCompat.FontInfo[] fontInfoArr, android.os.CancellationSignal cancellationSignal) {
        return androidx.core.graphics.TypefaceCompatUtil.readFontInfoIntoByteBuffer(context, fontInfoArr, cancellationSignal);
    }

    @androidx.annotation.Nullable
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
    public static android.graphics.Typeface requestFont(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull androidx.core.provider.FontRequest fontRequest, int i, boolean z, @androidx.annotation.IntRange(from = 0) int i2, @androidx.annotation.NonNull android.os.Handler handler, @androidx.annotation.NonNull androidx.core.provider.FontsContractCompat.FontRequestCallback fontRequestCallback) {
        androidx.core.provider.CallbackWithHandler callbackWithHandler = new androidx.core.provider.CallbackWithHandler(fontRequestCallback, handler);
        return z ? androidx.core.provider.FontRequestWorker.requestFontSync(context, fontRequest, callbackWithHandler, i, i2) : androidx.core.provider.FontRequestWorker.requestFontAsync(context, fontRequest, i, null, callbackWithHandler);
    }

    public static void requestFont(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull androidx.core.provider.FontRequest fontRequest, @androidx.annotation.NonNull androidx.core.provider.FontsContractCompat.FontRequestCallback fontRequestCallback, @androidx.annotation.NonNull android.os.Handler handler) {
        androidx.core.provider.CallbackWithHandler callbackWithHandler = new androidx.core.provider.CallbackWithHandler(fontRequestCallback);
        androidx.core.provider.FontRequestWorker.requestFontAsync(context.getApplicationContext(), fontRequest, 0, androidx.core.provider.RequestExecutor.createHandlerExecutor(handler), callbackWithHandler);
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @java.lang.Deprecated
    public static void resetCache() {
        androidx.core.provider.FontRequestWorker.resetTypefaceCache();
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.TESTS})
    @androidx.annotation.VisibleForTesting
    public static void resetTypefaceCache() {
        androidx.core.provider.FontRequestWorker.resetTypefaceCache();
    }
}
