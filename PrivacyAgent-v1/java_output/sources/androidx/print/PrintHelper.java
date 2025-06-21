package androidx.print;

/* loaded from: classes.dex */
public final class PrintHelper {

    @android.annotation.SuppressLint({"InlinedApi"})
    public static final int COLOR_MODE_COLOR = 2;

    @android.annotation.SuppressLint({"InlinedApi"})
    public static final int COLOR_MODE_MONOCHROME = 1;
    static final boolean IS_MIN_MARGINS_HANDLING_CORRECT;
    private static final java.lang.String LOG_TAG = "PrintHelper";
    private static final int MAX_PRINT_SIZE = 3500;
    public static final int ORIENTATION_LANDSCAPE = 1;
    public static final int ORIENTATION_PORTRAIT = 2;
    static final boolean PRINT_ACTIVITY_RESPECTS_ORIENTATION;
    public static final int SCALE_MODE_FILL = 2;
    public static final int SCALE_MODE_FIT = 1;
    final android.content.Context mContext;
    android.graphics.BitmapFactory.Options mDecodeOptions = null;
    final java.lang.Object mLock = new java.lang.Object();
    int mScaleMode = 2;
    int mColorMode = 2;
    int mOrientation = 1;

    /* renamed from: androidx.print.PrintHelper$1, reason: invalid class name */
    public class AnonymousClass1 extends android.os.AsyncTask<java.lang.Void, java.lang.Void, java.lang.Throwable> {
        final /* synthetic */ android.print.PrintAttributes val$attributes;
        final /* synthetic */ android.graphics.Bitmap val$bitmap;
        final /* synthetic */ android.os.CancellationSignal val$cancellationSignal;
        final /* synthetic */ android.os.ParcelFileDescriptor val$fileDescriptor;
        final /* synthetic */ int val$fittingMode;
        final /* synthetic */ android.print.PrintAttributes val$pdfAttributes;
        final /* synthetic */ android.print.PrintDocumentAdapter.WriteResultCallback val$writeResultCallback;

        public AnonymousClass1(android.os.CancellationSignal cancellationSignal, android.print.PrintAttributes printAttributes, android.graphics.Bitmap bitmap, android.print.PrintAttributes printAttributes2, int i, android.os.ParcelFileDescriptor parcelFileDescriptor, android.print.PrintDocumentAdapter.WriteResultCallback writeResultCallback) {
            this.val$cancellationSignal = cancellationSignal;
            this.val$pdfAttributes = printAttributes;
            this.val$bitmap = bitmap;
            this.val$attributes = printAttributes2;
            this.val$fittingMode = i;
            this.val$fileDescriptor = parcelFileDescriptor;
            this.val$writeResultCallback = writeResultCallback;
        }

        @Override // android.os.AsyncTask
        public java.lang.Throwable doInBackground(java.lang.Void... voidArr) {
            android.graphics.RectF rectF;
            try {
                if (this.val$cancellationSignal.isCanceled()) {
                    return null;
                }
                android.print.pdf.PrintedPdfDocument printedPdfDocument = new android.print.pdf.PrintedPdfDocument(androidx.print.PrintHelper.this.mContext, this.val$pdfAttributes);
                android.graphics.Bitmap convertBitmapForColorMode = androidx.print.PrintHelper.convertBitmapForColorMode(this.val$bitmap, this.val$pdfAttributes.getColorMode());
                if (this.val$cancellationSignal.isCanceled()) {
                    return null;
                }
                try {
                    android.graphics.pdf.PdfDocument.Page startPage = printedPdfDocument.startPage(1);
                    boolean z = androidx.print.PrintHelper.IS_MIN_MARGINS_HANDLING_CORRECT;
                    if (z) {
                        rectF = new android.graphics.RectF(startPage.getInfo().getContentRect());
                    } else {
                        android.print.pdf.PrintedPdfDocument printedPdfDocument2 = new android.print.pdf.PrintedPdfDocument(androidx.print.PrintHelper.this.mContext, this.val$attributes);
                        android.graphics.pdf.PdfDocument.Page startPage2 = printedPdfDocument2.startPage(1);
                        android.graphics.RectF rectF2 = new android.graphics.RectF(startPage2.getInfo().getContentRect());
                        printedPdfDocument2.finishPage(startPage2);
                        printedPdfDocument2.close();
                        rectF = rectF2;
                    }
                    android.graphics.Matrix matrix = androidx.print.PrintHelper.getMatrix(convertBitmapForColorMode.getWidth(), convertBitmapForColorMode.getHeight(), rectF, this.val$fittingMode);
                    if (!z) {
                        matrix.postTranslate(rectF.left, rectF.top);
                        startPage.getCanvas().clipRect(rectF);
                    }
                    startPage.getCanvas().drawBitmap(convertBitmapForColorMode, matrix, null);
                    printedPdfDocument.finishPage(startPage);
                    if (this.val$cancellationSignal.isCanceled()) {
                        printedPdfDocument.close();
                        android.os.ParcelFileDescriptor parcelFileDescriptor = this.val$fileDescriptor;
                        if (parcelFileDescriptor != null) {
                            try {
                                parcelFileDescriptor.close();
                            } catch (java.io.IOException unused) {
                            }
                        }
                        if (convertBitmapForColorMode != this.val$bitmap) {
                            convertBitmapForColorMode.recycle();
                        }
                        return null;
                    }
                    printedPdfDocument.writeTo(new java.io.FileOutputStream(this.val$fileDescriptor.getFileDescriptor()));
                    printedPdfDocument.close();
                    android.os.ParcelFileDescriptor parcelFileDescriptor2 = this.val$fileDescriptor;
                    if (parcelFileDescriptor2 != null) {
                        try {
                            parcelFileDescriptor2.close();
                        } catch (java.io.IOException unused2) {
                        }
                    }
                    if (convertBitmapForColorMode != this.val$bitmap) {
                        convertBitmapForColorMode.recycle();
                    }
                    return null;
                } finally {
                }
            } catch (java.lang.Throwable th) {
                return th;
            }
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(java.lang.Throwable th) {
            if (this.val$cancellationSignal.isCanceled()) {
                this.val$writeResultCallback.onWriteCancelled();
            } else if (th == null) {
                this.val$writeResultCallback.onWriteFinished(new android.print.PageRange[]{android.print.PageRange.ALL_PAGES});
            } else {
                this.val$writeResultCallback.onWriteFailed(null);
            }
        }
    }

    public interface OnPrintFinishCallback {
        void onFinish();
    }

    @androidx.annotation.RequiresApi(19)
    public class PrintBitmapAdapter extends android.print.PrintDocumentAdapter {
        private android.print.PrintAttributes mAttributes;
        private final android.graphics.Bitmap mBitmap;
        private final androidx.print.PrintHelper.OnPrintFinishCallback mCallback;
        private final int mFittingMode;
        private final java.lang.String mJobName;

        public PrintBitmapAdapter(java.lang.String str, int i, android.graphics.Bitmap bitmap, androidx.print.PrintHelper.OnPrintFinishCallback onPrintFinishCallback) {
            this.mJobName = str;
            this.mFittingMode = i;
            this.mBitmap = bitmap;
            this.mCallback = onPrintFinishCallback;
        }

        @Override // android.print.PrintDocumentAdapter
        public void onFinish() {
            androidx.print.PrintHelper.OnPrintFinishCallback onPrintFinishCallback = this.mCallback;
            if (onPrintFinishCallback != null) {
                onPrintFinishCallback.onFinish();
            }
        }

        @Override // android.print.PrintDocumentAdapter
        public void onLayout(android.print.PrintAttributes printAttributes, android.print.PrintAttributes printAttributes2, android.os.CancellationSignal cancellationSignal, android.print.PrintDocumentAdapter.LayoutResultCallback layoutResultCallback, android.os.Bundle bundle) {
            this.mAttributes = printAttributes2;
            layoutResultCallback.onLayoutFinished(new android.print.PrintDocumentInfo.Builder(this.mJobName).setContentType(1).setPageCount(1).build(), !printAttributes2.equals(printAttributes));
        }

        @Override // android.print.PrintDocumentAdapter
        public void onWrite(android.print.PageRange[] pageRangeArr, android.os.ParcelFileDescriptor parcelFileDescriptor, android.os.CancellationSignal cancellationSignal, android.print.PrintDocumentAdapter.WriteResultCallback writeResultCallback) {
            androidx.print.PrintHelper.this.writeBitmap(this.mAttributes, this.mFittingMode, this.mBitmap, parcelFileDescriptor, cancellationSignal, writeResultCallback);
        }
    }

    @androidx.annotation.RequiresApi(19)
    public class PrintUriAdapter extends android.print.PrintDocumentAdapter {
        android.print.PrintAttributes mAttributes;
        android.graphics.Bitmap mBitmap = null;
        final androidx.print.PrintHelper.OnPrintFinishCallback mCallback;
        final int mFittingMode;
        final android.net.Uri mImageFile;
        final java.lang.String mJobName;
        android.os.AsyncTask<android.net.Uri, java.lang.Boolean, android.graphics.Bitmap> mLoadBitmap;

        /* renamed from: androidx.print.PrintHelper$PrintUriAdapter$1, reason: invalid class name */
        public class AnonymousClass1 extends android.os.AsyncTask<android.net.Uri, java.lang.Boolean, android.graphics.Bitmap> {
            final /* synthetic */ android.os.CancellationSignal val$cancellationSignal;
            final /* synthetic */ android.print.PrintDocumentAdapter.LayoutResultCallback val$layoutResultCallback;
            final /* synthetic */ android.print.PrintAttributes val$newPrintAttributes;
            final /* synthetic */ android.print.PrintAttributes val$oldPrintAttributes;

            /* renamed from: androidx.print.PrintHelper$PrintUriAdapter$1$1, reason: invalid class name and collision with other inner class name */
            public class C00011 implements android.os.CancellationSignal.OnCancelListener {
                public C00011() {
                }

                @Override // android.os.CancellationSignal.OnCancelListener
                public void onCancel() {
                    androidx.print.PrintHelper.PrintUriAdapter.this.cancelLoad();
                    androidx.print.PrintHelper.PrintUriAdapter.AnonymousClass1.this.cancel(false);
                }
            }

            public AnonymousClass1(android.os.CancellationSignal cancellationSignal, android.print.PrintAttributes printAttributes, android.print.PrintAttributes printAttributes2, android.print.PrintDocumentAdapter.LayoutResultCallback layoutResultCallback) {
                this.val$cancellationSignal = cancellationSignal;
                this.val$newPrintAttributes = printAttributes;
                this.val$oldPrintAttributes = printAttributes2;
                this.val$layoutResultCallback = layoutResultCallback;
            }

            @Override // android.os.AsyncTask
            public android.graphics.Bitmap doInBackground(android.net.Uri... uriArr) {
                try {
                    androidx.print.PrintHelper.PrintUriAdapter printUriAdapter = androidx.print.PrintHelper.PrintUriAdapter.this;
                    return androidx.print.PrintHelper.this.loadConstrainedBitmap(printUriAdapter.mImageFile);
                } catch (java.io.FileNotFoundException unused) {
                    return null;
                }
            }

            @Override // android.os.AsyncTask
            public void onCancelled(android.graphics.Bitmap bitmap) {
                this.val$layoutResultCallback.onLayoutCancelled();
                androidx.print.PrintHelper.PrintUriAdapter.this.mLoadBitmap = null;
            }

            @Override // android.os.AsyncTask
            public void onPostExecute(android.graphics.Bitmap bitmap) {
                android.print.PrintAttributes.MediaSize mediaSize;
                super.onPostExecute((androidx.print.PrintHelper.PrintUriAdapter.AnonymousClass1) bitmap);
                if (bitmap != null && (!androidx.print.PrintHelper.PRINT_ACTIVITY_RESPECTS_ORIENTATION || androidx.print.PrintHelper.this.mOrientation == 0)) {
                    synchronized (this) {
                        mediaSize = androidx.print.PrintHelper.PrintUriAdapter.this.mAttributes.getMediaSize();
                    }
                    if (mediaSize != null && mediaSize.isPortrait() != androidx.print.PrintHelper.isPortrait(bitmap)) {
                        android.graphics.Matrix matrix = new android.graphics.Matrix();
                        matrix.postRotate(90.0f);
                        bitmap = android.graphics.Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                    }
                }
                androidx.print.PrintHelper.PrintUriAdapter.this.mBitmap = bitmap;
                if (bitmap != null) {
                    this.val$layoutResultCallback.onLayoutFinished(new android.print.PrintDocumentInfo.Builder(androidx.print.PrintHelper.PrintUriAdapter.this.mJobName).setContentType(1).setPageCount(1).build(), true ^ this.val$newPrintAttributes.equals(this.val$oldPrintAttributes));
                } else {
                    this.val$layoutResultCallback.onLayoutFailed(null);
                }
                androidx.print.PrintHelper.PrintUriAdapter.this.mLoadBitmap = null;
            }

            @Override // android.os.AsyncTask
            public void onPreExecute() {
                this.val$cancellationSignal.setOnCancelListener(new androidx.print.PrintHelper.PrintUriAdapter.AnonymousClass1.C00011());
            }
        }

        public PrintUriAdapter(java.lang.String str, android.net.Uri uri, androidx.print.PrintHelper.OnPrintFinishCallback onPrintFinishCallback, int i) {
            this.mJobName = str;
            this.mImageFile = uri;
            this.mCallback = onPrintFinishCallback;
            this.mFittingMode = i;
        }

        public void cancelLoad() {
            synchronized (androidx.print.PrintHelper.this.mLock) {
                android.graphics.BitmapFactory.Options options = androidx.print.PrintHelper.this.mDecodeOptions;
                if (options != null) {
                    if (android.os.Build.VERSION.SDK_INT < 24) {
                        options.requestCancelDecode();
                    }
                    androidx.print.PrintHelper.this.mDecodeOptions = null;
                }
            }
        }

        @Override // android.print.PrintDocumentAdapter
        public void onFinish() {
            super.onFinish();
            cancelLoad();
            android.os.AsyncTask<android.net.Uri, java.lang.Boolean, android.graphics.Bitmap> asyncTask = this.mLoadBitmap;
            if (asyncTask != null) {
                asyncTask.cancel(true);
            }
            androidx.print.PrintHelper.OnPrintFinishCallback onPrintFinishCallback = this.mCallback;
            if (onPrintFinishCallback != null) {
                onPrintFinishCallback.onFinish();
            }
            android.graphics.Bitmap bitmap = this.mBitmap;
            if (bitmap != null) {
                bitmap.recycle();
                this.mBitmap = null;
            }
        }

        @Override // android.print.PrintDocumentAdapter
        public void onLayout(android.print.PrintAttributes printAttributes, android.print.PrintAttributes printAttributes2, android.os.CancellationSignal cancellationSignal, android.print.PrintDocumentAdapter.LayoutResultCallback layoutResultCallback, android.os.Bundle bundle) {
            synchronized (this) {
                this.mAttributes = printAttributes2;
            }
            if (cancellationSignal.isCanceled()) {
                layoutResultCallback.onLayoutCancelled();
            } else if (this.mBitmap != null) {
                layoutResultCallback.onLayoutFinished(new android.print.PrintDocumentInfo.Builder(this.mJobName).setContentType(1).setPageCount(1).build(), !printAttributes2.equals(printAttributes));
            } else {
                this.mLoadBitmap = new androidx.print.PrintHelper.PrintUriAdapter.AnonymousClass1(cancellationSignal, printAttributes2, printAttributes, layoutResultCallback).execute(new android.net.Uri[0]);
            }
        }

        @Override // android.print.PrintDocumentAdapter
        public void onWrite(android.print.PageRange[] pageRangeArr, android.os.ParcelFileDescriptor parcelFileDescriptor, android.os.CancellationSignal cancellationSignal, android.print.PrintDocumentAdapter.WriteResultCallback writeResultCallback) {
            androidx.print.PrintHelper.this.writeBitmap(this.mAttributes, this.mFittingMode, this.mBitmap, parcelFileDescriptor, cancellationSignal, writeResultCallback);
        }
    }

    static {
        int i = android.os.Build.VERSION.SDK_INT;
        PRINT_ACTIVITY_RESPECTS_ORIENTATION = i > 23;
        IS_MIN_MARGINS_HANDLING_CORRECT = i != 23;
    }

    public PrintHelper(@androidx.annotation.NonNull android.content.Context context) {
        this.mContext = context;
    }

    public static android.graphics.Bitmap convertBitmapForColorMode(android.graphics.Bitmap bitmap, int i) {
        if (i != 1) {
            return bitmap;
        }
        android.graphics.Bitmap createBitmap = android.graphics.Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), android.graphics.Bitmap.Config.ARGB_8888);
        android.graphics.Canvas canvas = new android.graphics.Canvas(createBitmap);
        android.graphics.Paint paint = new android.graphics.Paint();
        android.graphics.ColorMatrix colorMatrix = new android.graphics.ColorMatrix();
        colorMatrix.setSaturation(0.0f);
        paint.setColorFilter(new android.graphics.ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        canvas.setBitmap(null);
        return createBitmap;
    }

    @androidx.annotation.RequiresApi(19)
    private static android.print.PrintAttributes.Builder copyAttributes(android.print.PrintAttributes printAttributes) {
        int duplexMode;
        int duplexMode2;
        android.print.PrintAttributes.Builder minMargins = new android.print.PrintAttributes.Builder().setMediaSize(printAttributes.getMediaSize()).setResolution(printAttributes.getResolution()).setMinMargins(printAttributes.getMinMargins());
        if (printAttributes.getColorMode() != 0) {
            minMargins.setColorMode(printAttributes.getColorMode());
        }
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            duplexMode = printAttributes.getDuplexMode();
            if (duplexMode != 0) {
                duplexMode2 = printAttributes.getDuplexMode();
                minMargins.setDuplexMode(duplexMode2);
            }
        }
        return minMargins;
    }

    public static android.graphics.Matrix getMatrix(int i, int i2, android.graphics.RectF rectF, int i3) {
        android.graphics.Matrix matrix = new android.graphics.Matrix();
        float f = i;
        float width = rectF.width() / f;
        float max = i3 == 2 ? java.lang.Math.max(width, rectF.height() / i2) : java.lang.Math.min(width, rectF.height() / i2);
        matrix.postScale(max, max);
        matrix.postTranslate((rectF.width() - (f * max)) / 2.0f, (rectF.height() - (i2 * max)) / 2.0f);
        return matrix;
    }

    public static boolean isPortrait(android.graphics.Bitmap bitmap) {
        return bitmap.getWidth() <= bitmap.getHeight();
    }

    private android.graphics.Bitmap loadBitmap(android.net.Uri uri, android.graphics.BitmapFactory.Options options) throws java.io.FileNotFoundException {
        android.content.Context context;
        if (uri == null || (context = this.mContext) == null) {
            throw new java.lang.IllegalArgumentException("bad argument to loadBitmap");
        }
        java.io.InputStream inputStream = null;
        try {
            java.io.InputStream openInputStream = context.getContentResolver().openInputStream(uri);
            try {
                android.graphics.Bitmap decodeStream = android.graphics.BitmapFactory.decodeStream(openInputStream, null, options);
                if (openInputStream != null) {
                    try {
                        openInputStream.close();
                    } catch (java.io.IOException unused) {
                    }
                }
                return decodeStream;
            } catch (java.lang.Throwable th) {
                th = th;
                inputStream = openInputStream;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (java.io.IOException unused2) {
                    }
                }
                throw th;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    public static boolean systemSupportsPrint() {
        return true;
    }

    public int getColorMode() {
        return this.mColorMode;
    }

    public int getOrientation() {
        int i = this.mOrientation;
        if (i == 0) {
            return 1;
        }
        return i;
    }

    public int getScaleMode() {
        return this.mScaleMode;
    }

    public android.graphics.Bitmap loadConstrainedBitmap(android.net.Uri uri) throws java.io.FileNotFoundException {
        android.graphics.BitmapFactory.Options options;
        if (uri == null || this.mContext == null) {
            throw new java.lang.IllegalArgumentException("bad argument to getScaledBitmap");
        }
        android.graphics.BitmapFactory.Options options2 = new android.graphics.BitmapFactory.Options();
        options2.inJustDecodeBounds = true;
        loadBitmap(uri, options2);
        int i = options2.outWidth;
        int i2 = options2.outHeight;
        if (i > 0 && i2 > 0) {
            int max = java.lang.Math.max(i, i2);
            int i3 = 1;
            while (max > MAX_PRINT_SIZE) {
                max >>>= 1;
                i3 <<= 1;
            }
            if (i3 > 0 && java.lang.Math.min(i, i2) / i3 > 0) {
                synchronized (this.mLock) {
                    options = new android.graphics.BitmapFactory.Options();
                    this.mDecodeOptions = options;
                    options.inMutable = true;
                    options.inSampleSize = i3;
                }
                try {
                    android.graphics.Bitmap loadBitmap = loadBitmap(uri, options);
                    synchronized (this.mLock) {
                        this.mDecodeOptions = null;
                    }
                    return loadBitmap;
                } catch (java.lang.Throwable th) {
                    synchronized (this.mLock) {
                        this.mDecodeOptions = null;
                        throw th;
                    }
                }
            }
        }
        return null;
    }

    public void printBitmap(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull android.graphics.Bitmap bitmap) {
        printBitmap(str, bitmap, (androidx.print.PrintHelper.OnPrintFinishCallback) null);
    }

    public void printBitmap(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull android.graphics.Bitmap bitmap, @androidx.annotation.Nullable androidx.print.PrintHelper.OnPrintFinishCallback onPrintFinishCallback) {
        if (bitmap == null) {
            return;
        }
        ((android.print.PrintManager) this.mContext.getSystemService("print")).print(str, new androidx.print.PrintHelper.PrintBitmapAdapter(str, this.mScaleMode, bitmap, onPrintFinishCallback), new android.print.PrintAttributes.Builder().setMediaSize(isPortrait(bitmap) ? android.print.PrintAttributes.MediaSize.UNKNOWN_PORTRAIT : android.print.PrintAttributes.MediaSize.UNKNOWN_LANDSCAPE).setColorMode(this.mColorMode).build());
    }

    public void printBitmap(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull android.net.Uri uri) throws java.io.FileNotFoundException {
        printBitmap(str, uri, (androidx.print.PrintHelper.OnPrintFinishCallback) null);
    }

    public void printBitmap(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull android.net.Uri uri, @androidx.annotation.Nullable androidx.print.PrintHelper.OnPrintFinishCallback onPrintFinishCallback) throws java.io.FileNotFoundException {
        androidx.print.PrintHelper.PrintUriAdapter printUriAdapter = new androidx.print.PrintHelper.PrintUriAdapter(str, uri, onPrintFinishCallback, this.mScaleMode);
        android.print.PrintManager printManager = (android.print.PrintManager) this.mContext.getSystemService("print");
        android.print.PrintAttributes.Builder builder = new android.print.PrintAttributes.Builder();
        builder.setColorMode(this.mColorMode);
        int i = this.mOrientation;
        if (i == 1 || i == 0) {
            builder.setMediaSize(android.print.PrintAttributes.MediaSize.UNKNOWN_LANDSCAPE);
        } else if (i == 2) {
            builder.setMediaSize(android.print.PrintAttributes.MediaSize.UNKNOWN_PORTRAIT);
        }
        printManager.print(str, printUriAdapter, builder.build());
    }

    public void setColorMode(int i) {
        this.mColorMode = i;
    }

    public void setOrientation(int i) {
        this.mOrientation = i;
    }

    public void setScaleMode(int i) {
        this.mScaleMode = i;
    }

    @androidx.annotation.RequiresApi(19)
    public void writeBitmap(android.print.PrintAttributes printAttributes, int i, android.graphics.Bitmap bitmap, android.os.ParcelFileDescriptor parcelFileDescriptor, android.os.CancellationSignal cancellationSignal, android.print.PrintDocumentAdapter.WriteResultCallback writeResultCallback) {
        new androidx.print.PrintHelper.AnonymousClass1(cancellationSignal, IS_MIN_MARGINS_HANDLING_CORRECT ? printAttributes : copyAttributes(printAttributes).setMinMargins(new android.print.PrintAttributes.Margins(0, 0, 0, 0)).build(), bitmap, printAttributes, i, parcelFileDescriptor, writeResultCallback).execute(new java.lang.Void[0]);
    }
}
