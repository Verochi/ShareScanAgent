package com.cicada.player.utils;

@com.cicada.player.utils.NativeUsed
/* loaded from: classes31.dex */
public class ContentDataSource {
    private static final int EINVAL = 22;
    private static final int EIO = 5;
    private static final int ENOENT = 2;
    private static final int SEEK_CUR = 1;
    private static final int SEEK_END = 2;
    private static final int SEEK_SET = 0;
    private static final int SEEK_SIZE = 65536;
    private static final java.lang.String TAG = "ContentDataSource";
    private static android.content.Context sContext;
    private java.lang.String mUri = null;
    private java.io.InputStream mStream = null;
    private int mStreamSize = -1;
    private long mOffset = 0;

    public static void setContext(android.content.Context context) {
        if (context == null || sContext != null) {
            return;
        }
        sContext = context.getApplicationContext();
    }

    private long skip(long j) throws java.io.IOException {
        try {
            return this.mStream.skip(j);
        } catch (java.io.IOException unused) {
            long j2 = (int) (this.mOffset + j);
            close();
            open(0);
            return this.mStream.skip(j2);
        }
    }

    public void close() {
        java.io.InputStream inputStream = this.mStream;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (java.io.IOException unused) {
            }
        }
    }

    public int open(int i) {
        android.content.Context context;
        if (android.text.TextUtils.isEmpty(this.mUri) || (context = sContext) == null) {
            return -22;
        }
        try {
            java.io.InputStream openInputStream = context.getContentResolver().openInputStream(android.net.Uri.parse(this.mUri));
            this.mStream = openInputStream;
            if (openInputStream == null) {
                return -22;
            }
            try {
                this.mOffset = 0L;
                this.mStreamSize = openInputStream.available();
                return 0;
            } catch (java.io.IOException unused) {
                return -5;
            }
        } catch (java.io.FileNotFoundException unused2) {
            return -2;
        }
    }

    public int read(byte[] bArr) {
        java.io.InputStream inputStream = this.mStream;
        if (inputStream == null) {
            return -22;
        }
        try {
            int read = inputStream.read(bArr);
            this.mOffset += read;
            return read;
        } catch (java.io.IOException unused) {
            return -5;
        }
    }

    public long seek(long j, int i) {
        java.io.InputStream inputStream = this.mStream;
        if (inputStream == null) {
            return -22L;
        }
        if (i == 65536) {
            int i2 = this.mStreamSize;
            if (i2 <= 0) {
                return -22L;
            }
            return i2;
        }
        if (i == 2) {
            try {
                j = inputStream.available();
            } catch (java.io.IOException unused) {
                return -5L;
            }
        } else if (i == 0) {
            j -= this.mOffset;
        } else if (i != 1) {
            return -22L;
        }
        try {
            long skip = this.mOffset + skip(j);
            this.mOffset = skip;
            return skip;
        } catch (java.io.IOException unused2) {
            return -5L;
        }
    }

    public void setUri(java.lang.String str) {
        this.mUri = str;
    }
}
