package com.google.android.exoplayer2.util;

/* loaded from: classes22.dex */
public final class Util {
    public static final java.lang.String DEVICE;
    public static final java.lang.String DEVICE_DEBUG_INFO;
    public static final byte[] EMPTY_BYTE_ARRAY;
    public static final java.lang.String MANUFACTURER;
    public static final java.lang.String MODEL;
    public static final int SDK_INT;
    public static final java.util.regex.Pattern a;
    public static final java.util.regex.Pattern b;
    public static final java.util.regex.Pattern c;
    public static final java.util.regex.Pattern d;

    @androidx.annotation.Nullable
    public static java.util.HashMap<java.lang.String, java.lang.String> e;
    public static final java.lang.String[] f;
    public static final java.lang.String[] g;
    public static final int[] h;
    public static final int[] i;

    static {
        int i2 = "R".equals(android.os.Build.VERSION.CODENAME) ? 30 : android.os.Build.VERSION.SDK_INT;
        SDK_INT = i2;
        java.lang.String str = android.os.Build.DEVICE;
        DEVICE = str;
        java.lang.String str2 = android.os.Build.MANUFACTURER;
        MANUFACTURER = str2;
        java.lang.String str3 = android.os.Build.MODEL;
        MODEL = str3;
        java.lang.StringBuilder sb = new java.lang.StringBuilder(java.lang.String.valueOf(str).length() + 17 + java.lang.String.valueOf(str3).length() + java.lang.String.valueOf(str2).length());
        sb.append(str);
        sb.append(", ");
        sb.append(str3);
        sb.append(", ");
        sb.append(str2);
        sb.append(", ");
        sb.append(i2);
        DEVICE_DEBUG_INFO = sb.toString();
        EMPTY_BYTE_ARRAY = new byte[0];
        a = java.util.regex.Pattern.compile("(\\d\\d\\d\\d)\\-(\\d\\d)\\-(\\d\\d)[Tt](\\d\\d):(\\d\\d):(\\d\\d)([\\.,](\\d+))?([Zz]|((\\+|\\-)(\\d?\\d):?(\\d\\d)))?");
        b = java.util.regex.Pattern.compile("^(-)?P(([0-9]*)Y)?(([0-9]*)M)?(([0-9]*)D)?(T(([0-9]*)H)?(([0-9]*)M)?(([0-9.]*)S)?)?$");
        c = java.util.regex.Pattern.compile("%([A-Fa-f0-9]{2})");
        d = java.util.regex.Pattern.compile(".*\\.isml?(?:/(manifest(.*))?)?");
        f = new java.lang.String[]{"alb", com.anythink.expressad.advanced.js.NativeAdvancedJsUtils.n, "arm", "hy", "baq", "eu", "bur", "my", "tib", "bo", "chi", com.anythink.expressad.video.dynview.a.a.Q, "cze", com.aliyun.common.log.struct.AliyunLogKey.KEY_CROP_START_TIME, com.anythink.expressad.d.a.b.ap, "nl", "ger", com.anythink.expressad.video.dynview.a.a.S, "gre", "el", "fre", com.anythink.expressad.video.dynview.a.a.U, "geo", "ka", "ice", "is", "mac", "mk", "mao", com.getui.gtc.extension.distribution.gbd.f.b.i, "may", "ms", "per", "fa", "rum", "ro", "scc", "hbs-srp", "slo", "sk", "wel", "cy", "id", "ms-ind", "iw", "he", "heb", "he", "ji", "yi", "in", "ms-ind", "ind", "ms-ind", "nb", "no-nob", "nob", "no-nob", "nn", "no-nno", "nno", "no-nno", "tw", "ak-twi", "twi", "ak-twi", "bs", "hbs-bos", "bos", "hbs-bos", "hr", "hbs-hrv", "hrv", "hbs-hrv", "sr", "hbs-srp", "srp", "hbs-srp", "cmn", "zh-cmn", "hak", "zh-hak", "nan", "zh-nan", "hsn", "zh-hsn"};
        g = new java.lang.String[]{"i-lux", "lb", "i-hak", "zh-hak", "i-navajo", "nv", "no-bok", "no-nob", "no-nyn", "no-nno", "zh-guoyu", "zh-cmn", "zh-hakka", "zh-hak", "zh-min-nan", "zh-nan", "zh-xiang", "zh-hsn"};
        h = new int[]{0, 79764919, 159529838, 222504665, 319059676, 398814059, 445009330, 507990021, 638119352, 583659535, 797628118, 726387553, 890018660, 835552979, 1015980042, 944750013, 1276238704, 1221641927, 1167319070, 1095957929, 1595256236, 1540665371, 1452775106, 1381403509, 1780037320, 1859660671, 1671105958, 1733955601, 2031960084, 2111593891, 1889500026, 1952343757, -1742489888, -1662866601, -1851683442, -1788833735, -1960329156, -1880695413, -2103051438, -2040207643, -1104454824, -1159051537, -1213636554, -1284997759, -1389417084, -1444007885, -1532160278, -1603531939, -734892656, -789352409, -575645954, -646886583, -952755380, -1007220997, -827056094, -898286187, -231047128, -151282273, -71779514, -8804623, -515967244, -436212925, -390279782, -327299027, 881225847, 809987520, 1023691545, 969234094, 662832811, 591600412, 771767749, 717299826, 311336399, 374308984, 453813921, 533576470, 25881363, 88864420, 134795389, 214552010, 2023205639, 2086057648, 1897238633, 1976864222, 1804852699, 1867694188, 1645340341, 1724971778, 1587496639, 1516133128, 1461550545, 1406951526, 1302016099, 1230646740, 1142491917, 1087903418, -1398421865, -1469785312, -1524105735, -1578704818, -1079922613, -1151291908, -1239184603, -1293773166, -1968362705, -1905510760, -2094067647, -2014441994, -1716953613, -1654112188, -1876203875, -1796572374, -525066777, -462094256, -382327159, -302564546, -206542021, -143559028, -97365931, -17609246, -960696225, -1031934488, -817968335, -872425850, -709327229, -780559564, -600130067, -654598054, 1762451694, 1842216281, 1619975040, 1682949687, 2047383090, 2127137669, 1938468188, 2001449195, 1325665622, 1271206113, 1183200824, 1111960463, 1543535498, 1489069629, 1434599652, 1363369299, 622672798, 568075817, 748617968, 677256519, 907627842, 853037301, 1067152940, 995781531, 51762726, 131386257, 177728840, 240578815, 269590778, 349224269, 429104020, 491947555, -248556018, -168932423, -122852000, -60002089, -500490030, -420856475, -341238852, -278395381, -685261898, -739858943, -559578920, -630940305, -1004286614, -1058877219, -845023740, -916395085, -1119974018, -1174433591, -1262701040, -1333941337, -1371866206, -1426332139, -1481064244, -1552294533, -1690935098, -1611170447, -1833673816, -1770699233, -2009983462, -1930228819, -2119160460, -2056179517, 1569362073, 1498123566, 1409854455, 1355396672, 1317987909, 1246755826, 1192025387, 1137557660, 2072149281, 2135122070, 1912620623, 1992383480, 1753615357, 1816598090, 1627664531, 1707420964, 295390185, 358241886, 404320391, 483945776, 43990325, 106832002, 186451547, 266083308, 932423249, 861060070, 1041341759, 986742920, 613929101, 542559546, 756411363, 701822548, -978770311, -1050133554, -869589737, -924188512, -693284699, -764654318, -550540341, -605129092, -475935807, -413084042, -366743377, -287118056, -257573603, -194731862, -114850189, -35218492, -1984365303, -1921392450, -2143631769, -2063868976, -1698919467, -1635936670, -1824608069, -1744851700, -1347415887, -1418654458, -1506661409, -1561119128, -1129027987, -1200260134, -1254728445, -1309196108};
        i = new int[]{0, 7, 14, 9, 28, 27, 18, 21, 56, 63, 54, 49, 36, 35, 42, 45, 112, 119, 126, 121, 108, 107, 98, 101, 72, 79, 70, 65, 84, 83, 90, 93, 224, 231, 238, 233, com.getui.gtc.extension.distribution.gbd.d.g.aH, 251, 242, 245, 216, 223, 214, com.qq.e.comm.adevent.AdEventType.VIDEO_INIT, 196, 195, 202, com.qq.e.comm.adevent.AdEventType.VIDEO_STOP, 144, 151, com.aliyun.svideosdk.facearengine.FaceARFaceResult.YUNOS_FL51PT_FACE_3D_KEY_POINT_NUM, com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_FUNNEL_TYPE, com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_DOWNLOAD_URL, com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_CLICK_TRACK_URL, 130, com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_IS_AD, 168, 175, com.bytedance.sdk.openadsdk.TTAdConstant.IMAGE_MODE_LIVE, 161, 180, 179, 186, com.google.android.exoplayer2.extractor.ts.PsExtractor.PRIVATE_STREAM_1, 199, 192, 201, com.qq.e.comm.adevent.AdEventType.VIDEO_COMPLETE, 219, 220, com.qq.e.comm.adevent.AdEventType.VIDEO_PRELOAD_ERROR, com.qq.e.comm.adevent.AdEventType.VIDEO_READY, 255, 248, 241, 246, 227, 228, 237, 234, 183, 176, 185, 190, 171, com.google.android.exoplayer2.extractor.ts.TsExtractor.TS_STREAM_TYPE_AC4, 165, 162, com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_MIME_TYPE, com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_PACKAGE_NAME, 129, 134, com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_FILE_NAME, com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_NEED_INDEPENDENT_PROCESS, 157, 154, 39, 32, 41, 46, 59, 60, 53, 50, 31, 24, 17, 22, 3, 4, 13, 10, 87, 80, 89, 94, 75, 76, 69, 66, 111, 104, 97, 102, 115, 116, 125, 122, com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_APP_ICON, com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_NOTIFICATION_JUMP_URL, 135, 128, com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_VERSION_CODE, com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_FILE_PATH, org.apache.tools.tar.TarConstants.PREFIXLEN, 156, 177, 182, 191, 184, 173, 170, 163, 164, 249, com.getui.gtc.extension.distribution.gbd.d.g.aI, 247, 240, 229, 226, 235, 236, 193, 198, com.qq.e.comm.adevent.AdEventType.VIDEO_ERROR, 200, 221, 218, com.qq.e.comm.adevent.AdEventType.VIDEO_LOADING, com.qq.e.comm.adevent.AdEventType.VIDEO_PRELOADED, 105, 110, 103, 96, 117, 114, 123, 124, 81, 86, 95, 88, 77, 74, 67, 68, 25, 30, 23, 16, 5, 2, 11, 12, 33, 38, 47, 40, 61, 58, 51, 52, 78, 73, 64, 71, 82, 85, 92, 91, 118, 113, 120, 127, 106, 109, 100, 99, 62, 57, 48, 55, 34, 37, 44, 43, 6, 1, 8, 15, 26, 29, 20, 19, 174, 169, com.autonavi.amap.mapcore.tools.GlMapUtil.DEVICE_DISPLAY_DPI_NORMAL, 167, 178, 181, com.google.android.exoplayer2.extractor.ts.TsExtractor.TS_PACKET_SIZE, 187, 150, 145, com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_AUTO_INSTALL_WITHOUT_NOTIFICATION, 159, 138, com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_BACKUP_URLS, com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_ID, 131, com.autonavi.amap.mapcore.AMapEngineUtils.ARROW_LINE_OUTER_TEXTURE_ID, 217, com.qq.e.comm.adevent.AdEventType.VIDEO_CLICKED, 215, 194, 197, 204, 203, 230, 225, 232, 239, 250, com.igexin.push.config.c.E, tv.danmaku.ijk.media.player.IjkMediaMeta.FF_PROFILE_H264_HIGH_444_PREDICTIVE, 243};
    }

    public static long addWithOverflowDefault(long j, long j2, long j3) {
        long j4 = j + j2;
        return ((j ^ j4) & (j2 ^ j4)) < 0 ? j3 : j4;
    }

    public static boolean areEqual(@androidx.annotation.Nullable java.lang.Object obj, @androidx.annotation.Nullable java.lang.Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public static java.util.HashMap<java.lang.String, java.lang.String> b() {
        java.lang.String[] iSOLanguages = java.util.Locale.getISOLanguages();
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>(iSOLanguages.length + f.length);
        int i2 = 0;
        for (java.lang.String str : iSOLanguages) {
            try {
                java.lang.String iSO3Language = new java.util.Locale(str).getISO3Language();
                if (!android.text.TextUtils.isEmpty(iSO3Language)) {
                    hashMap.put(iSO3Language, str);
                }
            } catch (java.util.MissingResourceException unused) {
            }
        }
        while (true) {
            java.lang.String[] strArr = f;
            if (i2 >= strArr.length) {
                return hashMap;
            }
            hashMap.put(strArr[i2], strArr[i2 + 1]);
            i2 += 2;
        }
    }

    public static <T extends java.lang.Comparable<? super T>> int binarySearchCeil(java.util.List<? extends java.lang.Comparable<? super T>> list, T t, boolean z, boolean z2) {
        int i2;
        int binarySearch = java.util.Collections.binarySearch(list, t);
        if (binarySearch < 0) {
            i2 = ~binarySearch;
        } else {
            int size = list.size();
            do {
                binarySearch++;
                if (binarySearch >= size) {
                    break;
                }
            } while (list.get(binarySearch).compareTo(t) == 0);
            i2 = z ? binarySearch - 1 : binarySearch;
        }
        return z2 ? java.lang.Math.min(list.size() - 1, i2) : i2;
    }

    public static int binarySearchCeil(int[] iArr, int i2, boolean z, boolean z2) {
        int i3;
        int binarySearch = java.util.Arrays.binarySearch(iArr, i2);
        if (binarySearch < 0) {
            i3 = ~binarySearch;
        } else {
            do {
                binarySearch++;
                if (binarySearch >= iArr.length) {
                    break;
                }
            } while (iArr[binarySearch] == i2);
            i3 = z ? binarySearch - 1 : binarySearch;
        }
        return z2 ? java.lang.Math.min(iArr.length - 1, i3) : i3;
    }

    public static int binarySearchCeil(long[] jArr, long j, boolean z, boolean z2) {
        int i2;
        int binarySearch = java.util.Arrays.binarySearch(jArr, j);
        if (binarySearch < 0) {
            i2 = ~binarySearch;
        } else {
            do {
                binarySearch++;
                if (binarySearch >= jArr.length) {
                    break;
                }
            } while (jArr[binarySearch] == j);
            i2 = z ? binarySearch - 1 : binarySearch;
        }
        return z2 ? java.lang.Math.min(jArr.length - 1, i2) : i2;
    }

    public static int binarySearchFloor(com.google.android.exoplayer2.util.LongArray longArray, long j, boolean z, boolean z2) {
        int i2;
        int size = longArray.size() - 1;
        int i3 = 0;
        while (i3 <= size) {
            int i4 = (i3 + size) >>> 1;
            if (longArray.get(i4) < j) {
                i3 = i4 + 1;
            } else {
                size = i4 - 1;
            }
        }
        if (z && (i2 = size + 1) < longArray.size() && longArray.get(i2) == j) {
            return i2;
        }
        if (z2 && size == -1) {
            return 0;
        }
        return size;
    }

    public static <T extends java.lang.Comparable<? super T>> int binarySearchFloor(java.util.List<? extends java.lang.Comparable<? super T>> list, T t, boolean z, boolean z2) {
        int i2;
        int binarySearch = java.util.Collections.binarySearch(list, t);
        if (binarySearch < 0) {
            i2 = -(binarySearch + 2);
        } else {
            do {
                binarySearch--;
                if (binarySearch < 0) {
                    break;
                }
            } while (list.get(binarySearch).compareTo(t) == 0);
            i2 = z ? binarySearch + 1 : binarySearch;
        }
        return z2 ? java.lang.Math.max(0, i2) : i2;
    }

    public static int binarySearchFloor(int[] iArr, int i2, boolean z, boolean z2) {
        int i3;
        int binarySearch = java.util.Arrays.binarySearch(iArr, i2);
        if (binarySearch < 0) {
            i3 = -(binarySearch + 2);
        } else {
            do {
                binarySearch--;
                if (binarySearch < 0) {
                    break;
                }
            } while (iArr[binarySearch] == i2);
            i3 = z ? binarySearch + 1 : binarySearch;
        }
        return z2 ? java.lang.Math.max(0, i3) : i3;
    }

    public static int binarySearchFloor(long[] jArr, long j, boolean z, boolean z2) {
        int i2;
        int binarySearch = java.util.Arrays.binarySearch(jArr, j);
        if (binarySearch < 0) {
            i2 = -(binarySearch + 2);
        } else {
            do {
                binarySearch--;
                if (binarySearch < 0) {
                    break;
                }
            } while (jArr[binarySearch] == j);
            i2 = z ? binarySearch + 1 : binarySearch;
        }
        return z2 ? java.lang.Math.max(0, i2) : i2;
    }

    public static void c(android.view.Display display, android.graphics.Point point) {
        display.getSize(point);
    }

    @org.checkerframework.checker.nullness.qual.EnsuresNonNull({"#1"})
    public static <T> T castNonNull(@androidx.annotation.Nullable T t) {
        return t;
    }

    @org.checkerframework.checker.nullness.qual.EnsuresNonNull({"#1"})
    public static <T> T[] castNonNullTypeArray(T[] tArr) {
        return tArr;
    }

    public static int ceilDivide(int i2, int i3) {
        return ((i2 + i3) - 1) / i3;
    }

    public static long ceilDivide(long j, long j2) {
        return ((j + j2) - 1) / j2;
    }

    public static boolean checkCleartextTrafficPermitted(com.google.android.exoplayer2.MediaItem... mediaItemArr) {
        if (SDK_INT < 24) {
            return true;
        }
        for (com.google.android.exoplayer2.MediaItem mediaItem : mediaItemArr) {
            com.google.android.exoplayer2.MediaItem.PlaybackProperties playbackProperties = mediaItem.playbackProperties;
            if (playbackProperties != null) {
                if (k(playbackProperties.uri)) {
                    return false;
                }
                for (int i2 = 0; i2 < mediaItem.playbackProperties.subtitles.size(); i2++) {
                    if (k(mediaItem.playbackProperties.subtitles.get(i2).uri)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void closeQuietly(@androidx.annotation.Nullable com.google.android.exoplayer2.upstream.DataSource dataSource) {
        if (dataSource != null) {
            try {
                dataSource.close();
            } catch (java.io.IOException unused) {
            }
        }
    }

    public static void closeQuietly(@androidx.annotation.Nullable java.io.Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (java.io.IOException unused) {
            }
        }
    }

    public static int compareLong(long j, long j2) {
        if (j < j2) {
            return -1;
        }
        return j == j2 ? 0 : 1;
    }

    public static float constrainValue(float f2, float f3, float f4) {
        return java.lang.Math.max(f3, java.lang.Math.min(f2, f4));
    }

    public static int constrainValue(int i2, int i3, int i4) {
        return java.lang.Math.max(i3, java.lang.Math.min(i2, i4));
    }

    public static long constrainValue(long j, long j2, long j3) {
        return java.lang.Math.max(j2, java.lang.Math.min(j, j3));
    }

    public static boolean contains(java.lang.Object[] objArr, @androidx.annotation.Nullable java.lang.Object obj) {
        for (java.lang.Object obj2 : objArr) {
            if (areEqual(obj2, obj)) {
                return true;
            }
        }
        return false;
    }

    public static int crc32(byte[] bArr, int i2, int i3, int i4) {
        while (i2 < i3) {
            i4 = h[((i4 >>> 24) ^ (bArr[i2] & 255)) & 255] ^ (i4 << 8);
            i2++;
        }
        return i4;
    }

    public static int crc8(byte[] bArr, int i2, int i3, int i4) {
        while (i2 < i3) {
            i4 = i[i4 ^ (bArr[i2] & 255)];
            i2++;
        }
        return i4;
    }

    public static android.os.Handler createHandler(android.os.Looper looper, @androidx.annotation.Nullable android.os.Handler.Callback callback) {
        return new android.os.Handler(looper, callback);
    }

    public static android.os.Handler createHandlerForCurrentLooper() {
        return createHandlerForCurrentLooper(null);
    }

    public static android.os.Handler createHandlerForCurrentLooper(@androidx.annotation.Nullable android.os.Handler.Callback callback) {
        return createHandler((android.os.Looper) com.google.android.exoplayer2.util.Assertions.checkStateNotNull(android.os.Looper.myLooper()), callback);
    }

    public static android.os.Handler createHandlerForCurrentOrMainLooper() {
        return createHandlerForCurrentOrMainLooper(null);
    }

    public static android.os.Handler createHandlerForCurrentOrMainLooper(@androidx.annotation.Nullable android.os.Handler.Callback callback) {
        return createHandler(getCurrentOrMainLooper(), callback);
    }

    public static java.io.File createTempDirectory(android.content.Context context, java.lang.String str) throws java.io.IOException {
        java.io.File createTempFile = createTempFile(context, str);
        createTempFile.delete();
        createTempFile.mkdir();
        return createTempFile;
    }

    public static java.io.File createTempFile(android.content.Context context, java.lang.String str) throws java.io.IOException {
        return java.io.File.createTempFile(str, null, context.getCacheDir());
    }

    @androidx.annotation.RequiresApi(17)
    public static void d(android.view.Display display, android.graphics.Point point) {
        display.getRealSize(point);
    }

    @androidx.annotation.RequiresApi(23)
    public static void e(android.view.Display display, android.graphics.Point point) {
        android.view.Display.Mode mode;
        int physicalWidth;
        int physicalHeight;
        mode = display.getMode();
        physicalWidth = mode.getPhysicalWidth();
        point.x = physicalWidth;
        physicalHeight = mode.getPhysicalHeight();
        point.y = physicalHeight;
    }

    public static java.lang.String escapeFileName(java.lang.String str) {
        int length = str.length();
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            if (o(str.charAt(i4))) {
                i3++;
            }
        }
        if (i3 == 0) {
            return str;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder((i3 * 2) + length);
        while (i3 > 0) {
            int i5 = i2 + 1;
            char charAt = str.charAt(i2);
            if (o(charAt)) {
                sb.append('%');
                sb.append(java.lang.Integer.toHexString(charAt));
                i3--;
            } else {
                sb.append(charAt);
            }
            i2 = i5;
        }
        if (i2 < length) {
            sb.append((java.lang.CharSequence) str, i2, length);
        }
        return sb.toString();
    }

    @androidx.annotation.RequiresApi(21)
    public static java.lang.String f(java.util.Locale locale) {
        return locale.toLanguageTag();
    }

    public static android.net.Uri fixSmoothStreamingIsmManifestUri(android.net.Uri uri) {
        java.lang.String lowerInvariant = toLowerInvariant(uri.getPath());
        if (lowerInvariant == null) {
            return uri;
        }
        java.util.regex.Matcher matcher = d.matcher(lowerInvariant);
        return (matcher.matches() && matcher.group(1) == null) ? android.net.Uri.withAppendedPath(uri, "Manifest") : uri;
    }

    public static java.lang.String formatInvariant(java.lang.String str, java.lang.Object... objArr) {
        return java.lang.String.format(java.util.Locale.US, str, objArr);
    }

    public static java.lang.String fromUtf8Bytes(byte[] bArr) {
        return new java.lang.String(bArr, com.google.common.base.Charsets.UTF_8);
    }

    public static java.lang.String fromUtf8Bytes(byte[] bArr, int i2, int i3) {
        return new java.lang.String(bArr, i2, i3, com.google.common.base.Charsets.UTF_8);
    }

    public static int g(android.net.NetworkInfo networkInfo) {
        switch (networkInfo.getSubtype()) {
            case 1:
            case 2:
                return 3;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 14:
            case 15:
            case 17:
                return 4;
            case 13:
                return 5;
            case 16:
            case 19:
            default:
                return 6;
            case 18:
                return 2;
            case 20:
                return SDK_INT >= 29 ? 9 : 0;
        }
    }

    @androidx.annotation.Nullable
    public static java.lang.String getAdaptiveMimeTypeForContentType(int i2) {
        if (i2 == 0) {
            return "application/dash+xml";
        }
        if (i2 == 1) {
            return "application/vnd.ms-sstr+xml";
        }
        if (i2 != 2) {
            return null;
        }
        return "application/x-mpegURL";
    }

    public static int getAudioContentTypeForStreamType(int i2) {
        if (i2 != 0) {
            return (i2 == 1 || i2 == 2 || i2 == 4 || i2 == 5 || i2 == 8) ? 4 : 2;
        }
        return 1;
    }

    public static int getAudioTrackChannelConfig(int i2) {
        switch (i2) {
            case 1:
                return 4;
            case 2:
                return 12;
            case 3:
                return 28;
            case 4:
                return 204;
            case 5:
                return 220;
            case 6:
                return com.getui.gtc.extension.distribution.gbd.d.g.aH;
            case 7:
                return 1276;
            case 8:
                int i3 = SDK_INT;
                return (i3 < 23 && i3 < 21) ? 0 : 6396;
            default:
                return 0;
        }
    }

    public static int getAudioUsageForStreamType(int i2) {
        if (i2 == 0) {
            return 2;
        }
        if (i2 == 1) {
            return 13;
        }
        if (i2 == 2) {
            return 6;
        }
        int i3 = 4;
        if (i2 != 4) {
            i3 = 5;
            if (i2 != 5) {
                return i2 != 8 ? 1 : 3;
            }
        }
        return i3;
    }

    public static int getBigEndianInt(java.nio.ByteBuffer byteBuffer, int i2) {
        int i3 = byteBuffer.getInt(i2);
        return byteBuffer.order() == java.nio.ByteOrder.BIG_ENDIAN ? i3 : java.lang.Integer.reverseBytes(i3);
    }

    public static byte[] getBytesFromHexString(java.lang.String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i2 * 2;
            bArr[i2] = (byte) ((java.lang.Character.digit(str.charAt(i3), 16) << 4) + java.lang.Character.digit(str.charAt(i3 + 1), 16));
        }
        return bArr;
    }

    @androidx.annotation.Nullable
    public static java.lang.String getCodecsOfType(@androidx.annotation.Nullable java.lang.String str, int i2) {
        java.lang.String[] splitCodecs = splitCodecs(str);
        if (splitCodecs.length == 0) {
            return null;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (java.lang.String str2 : splitCodecs) {
            if (i2 == com.google.android.exoplayer2.util.MimeTypes.getTrackTypeOfCodec(str2)) {
                if (sb.length() > 0) {
                    sb.append(",");
                }
                sb.append(str2);
            }
        }
        if (sb.length() > 0) {
            return sb.toString();
        }
        return null;
    }

    public static java.lang.String getCommaDelimitedSimpleClassNames(java.lang.Object[] objArr) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (int i2 = 0; i2 < objArr.length; i2++) {
            sb.append(objArr[i2].getClass().getSimpleName());
            if (i2 < objArr.length - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    public static java.lang.String getCountryCode(@androidx.annotation.Nullable android.content.Context context) {
        android.telephony.TelephonyManager telephonyManager;
        if (context != null && (telephonyManager = (android.telephony.TelephonyManager) context.getSystemService(com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE)) != null) {
            java.lang.String networkCountryIso = telephonyManager.getNetworkCountryIso();
            if (!android.text.TextUtils.isEmpty(networkCountryIso)) {
                return toUpperInvariant(networkCountryIso);
            }
        }
        return toUpperInvariant(java.util.Locale.getDefault().getCountry());
    }

    public static android.graphics.Point getCurrentDisplayModeSize(android.content.Context context) {
        return getCurrentDisplayModeSize(context, ((android.view.WindowManager) com.google.android.exoplayer2.util.Assertions.checkNotNull((android.view.WindowManager) context.getSystemService("window"))).getDefaultDisplay());
    }

    public static android.graphics.Point getCurrentDisplayModeSize(android.content.Context context, android.view.Display display) {
        int i2 = SDK_INT;
        if (i2 <= 29 && display.getDisplayId() == 0 && isTv(context)) {
            if ("Sony".equals(MANUFACTURER) && MODEL.startsWith("BRAVIA") && context.getPackageManager().hasSystemFeature("com.sony.dtv.hardware.panel.qfhd")) {
                return new android.graphics.Point(3840, 2160);
            }
            java.lang.String j = i2 < 28 ? j("sys.display-size") : j("vendor.display-size");
            if (!android.text.TextUtils.isEmpty(j)) {
                try {
                    java.lang.String[] split = split(j.trim(), "x");
                    if (split.length == 2) {
                        int parseInt = java.lang.Integer.parseInt(split[0]);
                        int parseInt2 = java.lang.Integer.parseInt(split[1]);
                        if (parseInt > 0 && parseInt2 > 0) {
                            return new android.graphics.Point(parseInt, parseInt2);
                        }
                    }
                } catch (java.lang.NumberFormatException unused) {
                }
                java.lang.String valueOf = java.lang.String.valueOf(j);
                com.google.android.exoplayer2.util.Log.e("Util", valueOf.length() != 0 ? "Invalid display size: ".concat(valueOf) : new java.lang.String("Invalid display size: "));
            }
        }
        android.graphics.Point point = new android.graphics.Point();
        int i3 = SDK_INT;
        if (i3 >= 23) {
            e(display, point);
        } else if (i3 >= 17) {
            d(display, point);
        } else {
            c(display, point);
        }
        return point;
    }

    public static android.os.Looper getCurrentOrMainLooper() {
        android.os.Looper myLooper = android.os.Looper.myLooper();
        return myLooper != null ? myLooper : android.os.Looper.getMainLooper();
    }

    public static android.net.Uri getDataUriForString(java.lang.String str, java.lang.String str2) {
        java.lang.String encodeToString = android.util.Base64.encodeToString(str2.getBytes(), 2);
        java.lang.StringBuilder sb = new java.lang.StringBuilder(java.lang.String.valueOf(str).length() + 13 + java.lang.String.valueOf(encodeToString).length());
        sb.append("data:");
        sb.append(str);
        sb.append(";base64,");
        sb.append(encodeToString);
        return android.net.Uri.parse(sb.toString());
    }

    @androidx.annotation.Nullable
    public static java.util.UUID getDrmUuid(java.lang.String str) {
        java.lang.String lowerInvariant = toLowerInvariant(str);
        lowerInvariant.hashCode();
        switch (lowerInvariant) {
            case "playready":
                return com.google.android.exoplayer2.C.PLAYREADY_UUID;
            case "widevine":
                return com.google.android.exoplayer2.C.WIDEVINE_UUID;
            case "clearkey":
                return com.google.android.exoplayer2.C.CLEARKEY_UUID;
            default:
                try {
                    return java.util.UUID.fromString(str);
                } catch (java.lang.RuntimeException unused) {
                    return null;
                }
        }
    }

    public static int getIntegerCodeForString(java.lang.String str) {
        int length = str.length();
        com.google.android.exoplayer2.util.Assertions.checkArgument(length <= 4);
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            i2 = (i2 << 8) | str.charAt(i3);
        }
        return i2;
    }

    public static java.lang.String getLocaleLanguageTag(java.util.Locale locale) {
        return SDK_INT >= 21 ? f(locale) : locale.toString();
    }

    public static long getMediaDurationForPlayoutDuration(long j, float f2) {
        return f2 == 1.0f ? j : java.lang.Math.round(j * f2);
    }

    public static int getNetworkType(android.content.Context context) {
        android.net.ConnectivityManager connectivityManager;
        int i2 = 0;
        if (context == null || (connectivityManager = (android.net.ConnectivityManager) context.getSystemService("connectivity")) == null) {
            return 0;
        }
        try {
            android.net.NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            i2 = 1;
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                int type = activeNetworkInfo.getType();
                if (type != 0) {
                    if (type == 1) {
                        return 2;
                    }
                    if (type != 4 && type != 5) {
                        if (type != 6) {
                            return type != 9 ? 8 : 7;
                        }
                        return 5;
                    }
                }
                return g(activeNetworkInfo);
            }
        } catch (java.lang.SecurityException unused) {
        }
        return i2;
    }

    public static long getNowUnixTimeMs(long j) {
        return j == -9223372036854775807L ? java.lang.System.currentTimeMillis() : j + android.os.SystemClock.elapsedRealtime();
    }

    public static int getPcmEncoding(int i2) {
        if (i2 == 8) {
            return 3;
        }
        if (i2 == 16) {
            return 2;
        }
        if (i2 == 24) {
            return 536870912;
        }
        if (i2 != 32) {
            return 0;
        }
        return com.google.android.exoplayer2.C.ENCODING_PCM_32BIT;
    }

    public static com.google.android.exoplayer2.Format getPcmFormat(int i2, int i3, int i4) {
        return new com.google.android.exoplayer2.Format.Builder().setSampleMimeType("audio/raw").setChannelCount(i3).setSampleRate(i4).setPcmEncoding(i2).build();
    }

    public static int getPcmFrameSize(int i2, int i3) {
        if (i2 != 2) {
            if (i2 == 3) {
                return i3;
            }
            if (i2 != 4) {
                if (i2 != 268435456) {
                    if (i2 == 536870912) {
                        return i3 * 3;
                    }
                    if (i2 != 805306368) {
                        throw new java.lang.IllegalArgumentException();
                    }
                }
            }
            return i3 * 4;
        }
        return i3 * 2;
    }

    public static long getPlayoutDurationForMediaDuration(long j, float f2) {
        return f2 == 1.0f ? j : java.lang.Math.round(j / f2);
    }

    public static int getStreamTypeForAudioUsage(int i2) {
        if (i2 == 13) {
            return 1;
        }
        switch (i2) {
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

    public static java.lang.String getStringForTime(java.lang.StringBuilder sb, java.util.Formatter formatter, long j) {
        if (j == -9223372036854775807L) {
            j = 0;
        }
        java.lang.String str = j < 0 ? com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER : "";
        long abs = (java.lang.Math.abs(j) + 500) / 1000;
        long j2 = abs % 60;
        long j3 = (abs / 60) % 60;
        long j4 = abs / com.anythink.expressad.d.a.b.P;
        sb.setLength(0);
        return j4 > 0 ? formatter.format("%s%d:%02d:%02d", str, java.lang.Long.valueOf(j4), java.lang.Long.valueOf(j3), java.lang.Long.valueOf(j2)).toString() : formatter.format("%s%02d:%02d", str, java.lang.Long.valueOf(j3), java.lang.Long.valueOf(j2)).toString();
    }

    public static java.lang.String[] getSystemLanguageCodes() {
        java.lang.String[] h2 = h();
        for (int i2 = 0; i2 < h2.length; i2++) {
            h2[i2] = normalizeLanguageCode(h2[i2]);
        }
        return h2;
    }

    public static java.lang.String getTrackTypeString(int i2) {
        switch (i2) {
            case 0:
                return "default";
            case 1:
                return "audio";
            case 2:
                return "video";
            case 3:
                return "text";
            case 4:
                return "metadata";
            case 5:
                return "camera motion";
            case 6:
                return "none";
            default:
                if (i2 < 10000) {
                    return "?";
                }
                java.lang.StringBuilder sb = new java.lang.StringBuilder(20);
                sb.append("custom (");
                sb.append(i2);
                sb.append(")");
                return sb.toString();
        }
    }

    public static java.lang.String getUserAgent(android.content.Context context, java.lang.String str) {
        java.lang.String str2;
        try {
            str2 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
            str2 = "?";
        }
        java.lang.String str3 = android.os.Build.VERSION.RELEASE;
        java.lang.StringBuilder sb = new java.lang.StringBuilder(java.lang.String.valueOf(str).length() + 38 + java.lang.String.valueOf(str2).length() + java.lang.String.valueOf(str3).length());
        sb.append(str);
        sb.append(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR);
        sb.append(str2);
        sb.append(" (Linux;Android ");
        sb.append(str3);
        sb.append(") ");
        sb.append(com.google.android.exoplayer2.ExoPlayerLibraryInfo.VERSION_SLASHY);
        return sb.toString();
    }

    public static byte[] getUtf8Bytes(java.lang.String str) {
        return str.getBytes(com.google.common.base.Charsets.UTF_8);
    }

    public static java.lang.String[] h() {
        android.content.res.Configuration configuration = android.content.res.Resources.getSystem().getConfiguration();
        return SDK_INT >= 24 ? i(configuration) : new java.lang.String[]{getLocaleLanguageTag(configuration.locale)};
    }

    @androidx.annotation.RequiresApi(24)
    public static java.lang.String[] i(android.content.res.Configuration configuration) {
        android.os.LocaleList locales;
        java.lang.String languageTags;
        locales = configuration.getLocales();
        languageTags = locales.toLanguageTags();
        return split(languageTags, ",");
    }

    public static int inferContentType(android.net.Uri uri) {
        java.lang.String path = uri.getPath();
        if (path == null) {
            return 3;
        }
        return inferContentType(path);
    }

    public static int inferContentType(android.net.Uri uri, @androidx.annotation.Nullable java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return inferContentType(uri);
        }
        java.lang.String valueOf = java.lang.String.valueOf(str);
        return inferContentType(valueOf.length() != 0 ? ".".concat(valueOf) : new java.lang.String("."));
    }

    public static int inferContentType(java.lang.String str) {
        java.lang.String lowerInvariant = toLowerInvariant(str);
        if (lowerInvariant.endsWith(".mpd")) {
            return 0;
        }
        if (lowerInvariant.endsWith(".m3u8")) {
            return 2;
        }
        java.util.regex.Matcher matcher = d.matcher(lowerInvariant);
        if (!matcher.matches()) {
            return 3;
        }
        java.lang.String group = matcher.group(2);
        if (group == null) {
            return 1;
        }
        if (group.contains("format=mpd-time-csf")) {
            return 0;
        }
        return group.contains("format=m3u8-aapl") ? 2 : 1;
    }

    public static int inferContentTypeForUriAndMimeType(android.net.Uri uri, @androidx.annotation.Nullable java.lang.String str) {
        if (str == null) {
            return inferContentType(uri);
        }
        switch (str) {
            case "application/x-mpegURL":
                return 2;
            case "application/vnd.ms-sstr+xml":
                return 1;
            case "application/dash+xml":
                return 0;
            default:
                return 3;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0062, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean inflate(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray2, @androidx.annotation.Nullable java.util.zip.Inflater inflater) {
        if (parsableByteArray.bytesLeft() <= 0) {
            return false;
        }
        byte[] data = parsableByteArray2.getData();
        if (data.length < parsableByteArray.bytesLeft()) {
            data = new byte[parsableByteArray.bytesLeft() * 2];
        }
        if (inflater == null) {
            inflater = new java.util.zip.Inflater();
        }
        inflater.setInput(parsableByteArray.getData(), parsableByteArray.getPosition(), parsableByteArray.bytesLeft());
        int i2 = 0;
        while (true) {
            try {
                i2 += inflater.inflate(data, i2, data.length - i2);
                if (!inflater.finished()) {
                    if (inflater.needsDictionary() || inflater.needsInput()) {
                        break;
                    }
                    if (i2 == data.length) {
                        data = java.util.Arrays.copyOf(data, data.length * 2);
                    }
                } else {
                    parsableByteArray2.reset(data, i2);
                    inflater.reset();
                    return true;
                }
            } catch (java.util.zip.DataFormatException unused) {
                return false;
            } finally {
                inflater.reset();
            }
        }
    }

    public static boolean isEncodingHighResolutionPcm(int i2) {
        return i2 == 536870912 || i2 == 805306368 || i2 == 4;
    }

    public static boolean isEncodingLinearPcm(int i2) {
        return i2 == 3 || i2 == 2 || i2 == 268435456 || i2 == 536870912 || i2 == 805306368 || i2 == 4;
    }

    public static boolean isLinebreak(int i2) {
        return i2 == 10 || i2 == 13;
    }

    public static boolean isLocalFileUri(android.net.Uri uri) {
        java.lang.String scheme = uri.getScheme();
        return android.text.TextUtils.isEmpty(scheme) || "file".equals(scheme);
    }

    public static boolean isTv(android.content.Context context) {
        android.app.UiModeManager uiModeManager = (android.app.UiModeManager) context.getApplicationContext().getSystemService("uimode");
        return uiModeManager != null && uiModeManager.getCurrentModeType() == 4;
    }

    @androidx.annotation.Nullable
    public static java.lang.String j(java.lang.String str) {
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("android.os.SystemProperties");
            return (java.lang.String) cls.getMethod(com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_GET, java.lang.String.class).invoke(cls, str);
        } catch (java.lang.Exception e2) {
            java.lang.String valueOf = java.lang.String.valueOf(str);
            com.google.android.exoplayer2.util.Log.e("Util", valueOf.length() != 0 ? "Failed to read system property ".concat(valueOf) : new java.lang.String("Failed to read system property "), e2);
            return null;
        }
    }

    @androidx.annotation.RequiresApi(api = 24)
    public static boolean k(android.net.Uri uri) {
        android.security.NetworkSecurityPolicy networkSecurityPolicy;
        boolean isCleartextTrafficPermitted;
        if (com.alipay.sdk.m.l.a.q.equals(uri.getScheme())) {
            networkSecurityPolicy = android.security.NetworkSecurityPolicy.getInstance();
            isCleartextTrafficPermitted = networkSecurityPolicy.isCleartextTrafficPermitted((java.lang.String) com.google.android.exoplayer2.util.Assertions.checkNotNull(uri.getHost()));
            if (!isCleartextTrafficPermitted) {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ java.lang.Thread l(java.lang.String str, java.lang.Runnable runnable) {
        return new java.lang.Thread(runnable, str);
    }

    public static int linearSearch(int[] iArr, int i2) {
        for (int i3 = 0; i3 < iArr.length; i3++) {
            if (iArr[i3] == i2) {
                return i3;
            }
        }
        return -1;
    }

    public static int linearSearch(long[] jArr, long j) {
        for (int i2 = 0; i2 < jArr.length; i2++) {
            if (jArr[i2] == j) {
                return i2;
            }
        }
        return -1;
    }

    public static java.lang.String m(java.lang.String str) {
        int i2 = 0;
        while (true) {
            java.lang.String[] strArr = g;
            if (i2 >= strArr.length) {
                return str;
            }
            if (str.startsWith(strArr[i2])) {
                java.lang.String valueOf = java.lang.String.valueOf(strArr[i2 + 1]);
                java.lang.String valueOf2 = java.lang.String.valueOf(str.substring(strArr[i2].length()));
                return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new java.lang.String(valueOf);
            }
            i2 += 2;
        }
    }

    public static boolean maybeRequestReadExternalStoragePermission(android.app.Activity activity, android.net.Uri... uriArr) {
        if (SDK_INT < 23) {
            return false;
        }
        for (android.net.Uri uri : uriArr) {
            if (isLocalFileUri(uri)) {
                return n(activity);
            }
        }
        return false;
    }

    public static boolean maybeRequestReadExternalStoragePermission(android.app.Activity activity, com.google.android.exoplayer2.MediaItem... mediaItemArr) {
        if (SDK_INT < 23) {
            return false;
        }
        for (com.google.android.exoplayer2.MediaItem mediaItem : mediaItemArr) {
            com.google.android.exoplayer2.MediaItem.PlaybackProperties playbackProperties = mediaItem.playbackProperties;
            if (playbackProperties != null) {
                if (isLocalFileUri(playbackProperties.uri)) {
                    return n(activity);
                }
                for (int i2 = 0; i2 < mediaItem.playbackProperties.subtitles.size(); i2++) {
                    if (isLocalFileUri(mediaItem.playbackProperties.subtitles.get(i2).uri)) {
                        return n(activity);
                    }
                }
            }
        }
        return false;
    }

    public static <T> void moveItems(java.util.List<T> list, int i2, int i3, int i4) {
        java.util.ArrayDeque arrayDeque = new java.util.ArrayDeque();
        for (int i5 = (i3 - i2) - 1; i5 >= 0; i5--) {
            arrayDeque.addFirst(list.remove(i2 + i5));
        }
        list.addAll(java.lang.Math.min(i4, list.size()), arrayDeque);
    }

    @androidx.annotation.RequiresApi(api = 23)
    public static boolean n(android.app.Activity activity) {
        int checkSelfPermission;
        checkSelfPermission = activity.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE");
        if (checkSelfPermission == 0) {
            return false;
        }
        activity.requestPermissions(new java.lang.String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 0);
        return true;
    }

    public static java.util.concurrent.ExecutorService newSingleThreadExecutor(java.lang.String str) {
        return java.util.concurrent.Executors.newSingleThreadExecutor(new defpackage.y73(str));
    }

    public static java.lang.String normalizeLanguageCode(java.lang.String str) {
        if (str == null) {
            return null;
        }
        java.lang.String replace = str.replace('_', '-');
        if (!replace.isEmpty() && !"und".equals(replace)) {
            str = replace;
        }
        java.lang.String lowerInvariant = toLowerInvariant(str);
        java.lang.String str2 = splitAtFirst(lowerInvariant, com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER)[0];
        if (e == null) {
            e = b();
        }
        java.lang.String str3 = e.get(str2);
        if (str3 != null) {
            java.lang.String valueOf = java.lang.String.valueOf(lowerInvariant.substring(str2.length()));
            lowerInvariant = valueOf.length() != 0 ? str3.concat(valueOf) : new java.lang.String(str3);
            str2 = str3;
        }
        return ("no".equals(str2) || "i".equals(str2) || com.anythink.expressad.video.dynview.a.a.Q.equals(str2)) ? m(lowerInvariant) : lowerInvariant;
    }

    public static <T> T[] nullSafeArrayAppend(T[] tArr, T t) {
        java.lang.Object[] copyOf = java.util.Arrays.copyOf(tArr, tArr.length + 1);
        copyOf[tArr.length] = t;
        return (T[]) castNonNullTypeArray(copyOf);
    }

    public static <T> T[] nullSafeArrayConcatenation(T[] tArr, T[] tArr2) {
        T[] tArr3 = (T[]) java.util.Arrays.copyOf(tArr, tArr.length + tArr2.length);
        java.lang.System.arraycopy(tArr2, 0, tArr3, tArr.length, tArr2.length);
        return tArr3;
    }

    public static <T> T[] nullSafeArrayCopy(T[] tArr, int i2) {
        com.google.android.exoplayer2.util.Assertions.checkArgument(i2 <= tArr.length);
        return (T[]) java.util.Arrays.copyOf(tArr, i2);
    }

    public static <T> T[] nullSafeArrayCopyOfRange(T[] tArr, int i2, int i3) {
        com.google.android.exoplayer2.util.Assertions.checkArgument(i2 >= 0);
        com.google.android.exoplayer2.util.Assertions.checkArgument(i3 <= tArr.length);
        return (T[]) java.util.Arrays.copyOfRange(tArr, i2, i3);
    }

    public static <T> void nullSafeListToArray(java.util.List<T> list, T[] tArr) {
        com.google.android.exoplayer2.util.Assertions.checkState(list.size() == tArr.length);
        list.toArray(tArr);
    }

    public static boolean o(char c2) {
        return c2 == '\"' || c2 == '%' || c2 == '*' || c2 == '/' || c2 == ':' || c2 == '<' || c2 == '\\' || c2 == '|' || c2 == '>' || c2 == '?';
    }

    public static <T extends java.lang.Throwable> void p(java.lang.Throwable th) throws java.lang.Throwable {
        throw th;
    }

    public static long parseXsDateTime(java.lang.String str) throws com.google.android.exoplayer2.ParserException {
        java.util.regex.Matcher matcher = a.matcher(str);
        if (!matcher.matches()) {
            java.lang.String valueOf = java.lang.String.valueOf(str);
            throw new com.google.android.exoplayer2.ParserException(valueOf.length() != 0 ? "Invalid date/time format: ".concat(valueOf) : new java.lang.String("Invalid date/time format: "));
        }
        int i2 = 0;
        if (matcher.group(9) != null && !matcher.group(9).equalsIgnoreCase("Z")) {
            i2 = (java.lang.Integer.parseInt(matcher.group(12)) * 60) + java.lang.Integer.parseInt(matcher.group(13));
            if (com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER.equals(matcher.group(11))) {
                i2 *= -1;
            }
        }
        java.util.GregorianCalendar gregorianCalendar = new java.util.GregorianCalendar(java.util.TimeZone.getTimeZone("GMT"));
        gregorianCalendar.clear();
        gregorianCalendar.set(java.lang.Integer.parseInt(matcher.group(1)), java.lang.Integer.parseInt(matcher.group(2)) - 1, java.lang.Integer.parseInt(matcher.group(3)), java.lang.Integer.parseInt(matcher.group(4)), java.lang.Integer.parseInt(matcher.group(5)), java.lang.Integer.parseInt(matcher.group(6)));
        if (!android.text.TextUtils.isEmpty(matcher.group(8))) {
            java.lang.String valueOf2 = java.lang.String.valueOf(matcher.group(8));
            gregorianCalendar.set(14, new java.math.BigDecimal(valueOf2.length() != 0 ? "0.".concat(valueOf2) : new java.lang.String("0.")).movePointRight(3).intValue());
        }
        long timeInMillis = gregorianCalendar.getTimeInMillis();
        return i2 != 0 ? timeInMillis - (i2 * 60000) : timeInMillis;
    }

    public static long parseXsDuration(java.lang.String str) {
        java.util.regex.Matcher matcher = b.matcher(str);
        if (!matcher.matches()) {
            return (long) (java.lang.Double.parseDouble(str) * 3600.0d * 1000.0d);
        }
        boolean isEmpty = true ^ android.text.TextUtils.isEmpty(matcher.group(1));
        java.lang.String group = matcher.group(3);
        double parseDouble = group != null ? java.lang.Double.parseDouble(group) * 3.1556908E7d : 0.0d;
        java.lang.String group2 = matcher.group(5);
        double parseDouble2 = parseDouble + (group2 != null ? java.lang.Double.parseDouble(group2) * 2629739.0d : 0.0d);
        java.lang.String group3 = matcher.group(7);
        double parseDouble3 = parseDouble2 + (group3 != null ? java.lang.Double.parseDouble(group3) * 86400.0d : 0.0d);
        java.lang.String group4 = matcher.group(10);
        double parseDouble4 = parseDouble3 + (group4 != null ? java.lang.Double.parseDouble(group4) * 3600.0d : 0.0d);
        java.lang.String group5 = matcher.group(12);
        double parseDouble5 = parseDouble4 + (group5 != null ? java.lang.Double.parseDouble(group5) * 60.0d : 0.0d);
        java.lang.String group6 = matcher.group(14);
        long parseDouble6 = (long) ((parseDouble5 + (group6 != null ? java.lang.Double.parseDouble(group6) : 0.0d)) * 1000.0d);
        return isEmpty ? -parseDouble6 : parseDouble6;
    }

    public static boolean postOrRun(android.os.Handler handler, java.lang.Runnable runnable) {
        if (handler.getLooper() != android.os.Looper.myLooper()) {
            return handler.post(runnable);
        }
        runnable.run();
        return true;
    }

    public static boolean readBoolean(android.os.Parcel parcel) {
        return parcel.readInt() != 0;
    }

    public static byte[] readExactly(com.google.android.exoplayer2.upstream.DataSource dataSource, int i2) throws java.io.IOException {
        byte[] bArr = new byte[i2];
        int i3 = 0;
        while (i3 < i2) {
            int read = dataSource.read(bArr, i3, i2 - i3);
            if (read == -1) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder(56);
                sb.append("Not enough data could be read: ");
                sb.append(i3);
                sb.append(" < ");
                sb.append(i2);
                throw new java.lang.IllegalStateException(sb.toString());
            }
            i3 += read;
        }
        return bArr;
    }

    public static byte[] readToEnd(com.google.android.exoplayer2.upstream.DataSource dataSource) throws java.io.IOException {
        byte[] bArr = new byte[1024];
        int i2 = 0;
        int i3 = 0;
        while (i2 != -1) {
            if (i3 == bArr.length) {
                bArr = java.util.Arrays.copyOf(bArr, bArr.length * 2);
            }
            i2 = dataSource.read(bArr, i3, bArr.length - i3);
            if (i2 != -1) {
                i3 += i2;
            }
        }
        return java.util.Arrays.copyOf(bArr, i3);
    }

    public static void recursiveDelete(java.io.File file) {
        java.io.File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (java.io.File file2 : listFiles) {
                recursiveDelete(file2);
            }
        }
        file.delete();
    }

    public static <T> void removeRange(java.util.List<T> list, int i2, int i3) {
        if (i2 < 0 || i3 > list.size() || i2 > i3) {
            throw new java.lang.IllegalArgumentException();
        }
        if (i2 != i3) {
            list.subList(i2, i3).clear();
        }
    }

    public static long scaleLargeTimestamp(long j, long j2, long j3) {
        if (j3 >= j2 && j3 % j2 == 0) {
            return j / (j3 / j2);
        }
        if (j3 < j2 && j2 % j3 == 0) {
            return j * (j2 / j3);
        }
        return (long) (j * (j2 / j3));
    }

    public static long[] scaleLargeTimestamps(java.util.List<java.lang.Long> list, long j, long j2) {
        int size = list.size();
        long[] jArr = new long[size];
        int i2 = 0;
        if (j2 >= j && j2 % j == 0) {
            long j3 = j2 / j;
            while (i2 < size) {
                jArr[i2] = list.get(i2).longValue() / j3;
                i2++;
            }
        } else if (j2 >= j || j % j2 != 0) {
            double d2 = j / j2;
            while (i2 < size) {
                jArr[i2] = (long) (list.get(i2).longValue() * d2);
                i2++;
            }
        } else {
            long j4 = j / j2;
            while (i2 < size) {
                jArr[i2] = list.get(i2).longValue() * j4;
                i2++;
            }
        }
        return jArr;
    }

    public static void scaleLargeTimestampsInPlace(long[] jArr, long j, long j2) {
        int i2 = 0;
        if (j2 >= j && j2 % j == 0) {
            long j3 = j2 / j;
            while (i2 < jArr.length) {
                jArr[i2] = jArr[i2] / j3;
                i2++;
            }
            return;
        }
        if (j2 >= j || j % j2 != 0) {
            double d2 = j / j2;
            while (i2 < jArr.length) {
                jArr[i2] = (long) (jArr[i2] * d2);
                i2++;
            }
            return;
        }
        long j4 = j / j2;
        while (i2 < jArr.length) {
            jArr[i2] = jArr[i2] * j4;
            i2++;
        }
    }

    public static void sneakyThrow(java.lang.Throwable th) {
        p(th);
    }

    public static java.lang.String[] split(java.lang.String str, java.lang.String str2) {
        return str.split(str2, -1);
    }

    public static java.lang.String[] splitAtFirst(java.lang.String str, java.lang.String str2) {
        return str.split(str2, 2);
    }

    public static java.lang.String[] splitCodecs(@androidx.annotation.Nullable java.lang.String str) {
        return android.text.TextUtils.isEmpty(str) ? new java.lang.String[0] : split(str.trim(), "(\\s*,\\s*)");
    }

    @androidx.annotation.Nullable
    public static android.content.ComponentName startForegroundService(android.content.Context context, android.content.Intent intent) {
        android.content.ComponentName startForegroundService;
        if (SDK_INT < 26) {
            return context.startService(intent);
        }
        startForegroundService = context.startForegroundService(intent);
        return startForegroundService;
    }

    public static long subtractWithOverflowDefault(long j, long j2, long j3) {
        long j4 = j - j2;
        return ((j ^ j4) & (j2 ^ j)) < 0 ? j3 : j4;
    }

    public static boolean tableExists(android.database.sqlite.SQLiteDatabase sQLiteDatabase, java.lang.String str) {
        return android.database.DatabaseUtils.queryNumEntries(sQLiteDatabase, "sqlite_master", "tbl_name = ?", new java.lang.String[]{str}) > 0;
    }

    public static byte[] toByteArray(java.io.InputStream inputStream) throws java.io.IOException {
        byte[] bArr = new byte[4096];
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    public static java.lang.String toHexString(byte[] bArr) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(bArr.length * 2);
        for (int i2 = 0; i2 < bArr.length; i2++) {
            sb.append(java.lang.Character.forDigit((bArr[i2] >> 4) & 15, 16));
            sb.append(java.lang.Character.forDigit(bArr[i2] & 15, 16));
        }
        return sb.toString();
    }

    public static long toLong(int i2, int i3) {
        return toUnsignedLong(i3) | (toUnsignedLong(i2) << 32);
    }

    public static java.lang.String toLowerInvariant(java.lang.String str) {
        return str == null ? str : str.toLowerCase(java.util.Locale.US);
    }

    public static long toUnsignedLong(int i2) {
        return i2 & net.lingala.zip4j.util.InternalZipConstants.ZIP_64_LIMIT;
    }

    public static java.lang.String toUpperInvariant(java.lang.String str) {
        return str == null ? str : str.toUpperCase(java.util.Locale.US);
    }

    public static java.lang.CharSequence truncateAscii(java.lang.CharSequence charSequence, int i2) {
        return charSequence.length() <= i2 ? charSequence : charSequence.subSequence(0, i2);
    }

    @androidx.annotation.Nullable
    public static java.lang.String unescapeFileName(java.lang.String str) {
        int length = str.length();
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            if (str.charAt(i4) == '%') {
                i3++;
            }
        }
        if (i3 == 0) {
            return str;
        }
        int i5 = length - (i3 * 2);
        java.lang.StringBuilder sb = new java.lang.StringBuilder(i5);
        java.util.regex.Matcher matcher = c.matcher(str);
        while (i3 > 0 && matcher.find()) {
            char parseInt = (char) java.lang.Integer.parseInt((java.lang.String) com.google.android.exoplayer2.util.Assertions.checkNotNull(matcher.group(1)), 16);
            sb.append((java.lang.CharSequence) str, i2, matcher.start());
            sb.append(parseInt);
            i2 = matcher.end();
            i3--;
        }
        if (i2 < length) {
            sb.append((java.lang.CharSequence) str, i2, length);
        }
        if (sb.length() != i5) {
            return null;
        }
        return sb.toString();
    }

    public static void writeBoolean(android.os.Parcel parcel, boolean z) {
        parcel.writeInt(z ? 1 : 0);
    }
}
