package com.amap.api.maps.model;

/* loaded from: classes12.dex */
public class HeatmapTileProvider implements com.amap.api.maps.model.TileProvider {
    public static final com.amap.api.maps.model.Gradient DEFAULT_GRADIENT;
    private static final int[] DEFAULT_GRADIENT_COLORS;
    private static final float[] DEFAULT_GRADIENT_START_POINTS;
    private static final int DEFAULT_MAX_ZOOM = 11;
    private static final int DEFAULT_MIN_ZOOM = 5;
    public static final double DEFAULT_OPACITY = 0.6d;
    public static final int DEFAULT_RADIUS = 12;
    private static final int MAX_RADIUS = 50;
    private static final int MAX_ZOOM_LEVEL = 21;
    private static final int MIN_RADIUS = 10;
    private static final int SCREEN_SIZE = 1280;
    private static final int TILE_DIM = 256;
    private com.amap.api.mapcore.util.cu mBounds;
    private int[] mColorMap;
    private java.util.Collection<com.amap.api.maps.model.WeightedLatLng> mData;
    private com.amap.api.maps.model.Gradient mGradient;
    private double[] mKernel;
    private double[] mMaxIntensity;
    private double mOpacity;
    private int mRadius;
    private com.amap.api.maps.model.a mTree;

    public static class Builder {
        private java.util.Collection<com.amap.api.maps.model.WeightedLatLng> data;
        private int radius = 12;
        private com.amap.api.maps.model.Gradient gradient = com.amap.api.maps.model.HeatmapTileProvider.DEFAULT_GRADIENT;
        private double opacity = 0.6d;

        public com.amap.api.maps.model.HeatmapTileProvider build() {
            java.util.Collection<com.amap.api.maps.model.WeightedLatLng> collection = this.data;
            if (collection != null && collection.size() != 0) {
                try {
                    return new com.amap.api.maps.model.HeatmapTileProvider(this, (byte) 0);
                } catch (java.lang.Throwable th) {
                    th.printStackTrace();
                    return null;
                }
            }
            try {
                throw new com.amap.api.maps.AMapException("No input points.");
            } catch (com.amap.api.maps.AMapException e) {
                e.getErrorMessage();
                e.printStackTrace();
                return null;
            }
        }

        public com.amap.api.maps.model.HeatmapTileProvider.Builder data(java.util.Collection<com.amap.api.maps.model.LatLng> collection) {
            return weightedData(com.amap.api.maps.model.HeatmapTileProvider.c(collection));
        }

        public com.amap.api.maps.model.HeatmapTileProvider.Builder gradient(com.amap.api.maps.model.Gradient gradient) {
            this.gradient = gradient;
            return this;
        }

        public com.amap.api.maps.model.HeatmapTileProvider.Builder radius(int i) {
            this.radius = java.lang.Math.max(10, java.lang.Math.min(i, 50));
            return this;
        }

        public com.amap.api.maps.model.HeatmapTileProvider.Builder transparency(double d) {
            this.opacity = java.lang.Math.max(0.0d, java.lang.Math.min(d, 1.0d));
            return this;
        }

        public com.amap.api.maps.model.HeatmapTileProvider.Builder weightedData(java.util.Collection<com.amap.api.maps.model.WeightedLatLng> collection) {
            this.data = collection;
            return this;
        }
    }

    static {
        int[] iArr = {android.graphics.Color.rgb(102, 225, 0), android.graphics.Color.rgb(255, 0, 0)};
        DEFAULT_GRADIENT_COLORS = iArr;
        float[] fArr = {0.2f, 1.0f};
        DEFAULT_GRADIENT_START_POINTS = fArr;
        DEFAULT_GRADIENT = new com.amap.api.maps.model.Gradient(iArr, fArr);
    }

    private HeatmapTileProvider(com.amap.api.maps.model.HeatmapTileProvider.Builder builder) {
        this.mData = builder.data;
        this.mRadius = builder.radius;
        com.amap.api.maps.model.Gradient gradient = builder.gradient;
        this.mGradient = gradient;
        if (gradient == null || !gradient.isAvailable()) {
            this.mGradient = DEFAULT_GRADIENT;
        }
        this.mOpacity = builder.opacity;
        int i = this.mRadius;
        this.mKernel = a(i, i / 3.0d);
        a(this.mGradient);
        b(this.mData);
    }

    public /* synthetic */ HeatmapTileProvider(com.amap.api.maps.model.HeatmapTileProvider.Builder builder, byte b) {
        this(builder);
    }

    private static double a(java.util.Collection<com.amap.api.maps.model.WeightedLatLng> collection, com.amap.api.mapcore.util.cu cuVar, int i, int i2) {
        double d = cuVar.a;
        double d2 = cuVar.c;
        double d3 = cuVar.b;
        double d4 = d2 - d;
        double d5 = cuVar.d - d3;
        if (d4 <= d5) {
            d4 = d5;
        }
        double d6 = ((int) ((i2 / (i * 2)) + 0.5d)) / d4;
        androidx.collection.LongSparseArray longSparseArray = new androidx.collection.LongSparseArray();
        double d7 = 0.0d;
        for (com.amap.api.maps.model.WeightedLatLng weightedLatLng : collection) {
            double d8 = weightedLatLng.getPoint().x;
            int i3 = (int) ((weightedLatLng.getPoint().y - d3) * d6);
            long j = (int) ((d8 - d) * d6);
            androidx.collection.LongSparseArray longSparseArray2 = (androidx.collection.LongSparseArray) longSparseArray.get(j);
            if (longSparseArray2 == null) {
                longSparseArray2 = new androidx.collection.LongSparseArray();
                longSparseArray.put(j, longSparseArray2);
            }
            long j2 = i3;
            java.lang.Double d9 = (java.lang.Double) longSparseArray2.get(j2);
            if (d9 == null) {
                d9 = java.lang.Double.valueOf(0.0d);
            }
            androidx.collection.LongSparseArray longSparseArray3 = longSparseArray;
            double d10 = d;
            java.lang.Double valueOf = java.lang.Double.valueOf(d9.doubleValue() + weightedLatLng.intensity);
            longSparseArray2.put(j2, valueOf);
            if (valueOf.doubleValue() > d7) {
                d7 = valueOf.doubleValue();
            }
            longSparseArray = longSparseArray3;
            d = d10;
        }
        return d7;
    }

    private static android.graphics.Bitmap a(double[][] dArr, int[] iArr, double d) {
        int i = iArr[iArr.length - 1];
        double length = (iArr.length - 1) / d;
        int length2 = dArr.length;
        int[] iArr2 = new int[length2 * length2];
        for (int i2 = 0; i2 < length2; i2++) {
            for (int i3 = 0; i3 < length2; i3++) {
                double d2 = dArr[i3][i2];
                int i4 = (i2 * length2) + i3;
                int i5 = (int) (d2 * length);
                if (d2 == 0.0d) {
                    iArr2[i4] = 0;
                } else if (i5 < iArr.length) {
                    iArr2[i4] = iArr[i5];
                } else {
                    iArr2[i4] = i;
                }
            }
        }
        android.graphics.Bitmap createBitmap = android.graphics.Bitmap.createBitmap(length2, length2, android.graphics.Bitmap.Config.ARGB_8888);
        createBitmap.setPixels(iArr2, 0, length2, 0, 0, length2, length2);
        return createBitmap;
    }

    private static com.amap.api.maps.model.Tile a(android.graphics.Bitmap bitmap) {
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        bitmap.compress(android.graphics.Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        return com.amap.api.maps.model.Tile.obtain(256, 256, byteArrayOutputStream.toByteArray());
    }

    private void a(com.amap.api.maps.model.Gradient gradient) {
        this.mGradient = gradient;
        this.mColorMap = gradient.generateColorMap(this.mOpacity);
    }

    private double[] a(int i) {
        int i2;
        double[] dArr = new double[21];
        int i3 = 5;
        while (true) {
            if (i3 >= 11) {
                break;
            }
            dArr[i3] = a(this.mData, this.mBounds, i, (int) (java.lang.Math.pow(2.0d, i3) * 1280.0d));
            if (i3 == 5) {
                for (int i4 = 0; i4 < i3; i4++) {
                    dArr[i4] = dArr[i3];
                }
            }
            i3++;
        }
        for (i2 = 11; i2 < 21; i2++) {
            dArr[i2] = dArr[10];
        }
        return dArr;
    }

    private static double[] a(int i, double d) {
        double[] dArr = new double[(i * 2) + 1];
        for (int i2 = -i; i2 <= i; i2++) {
            dArr[i2 + i] = java.lang.Math.exp(((-i2) * i2) / ((2.0d * d) * d));
        }
        return dArr;
    }

    private static double[][] a(double[][] dArr, double[] dArr2) {
        int floor = (int) java.lang.Math.floor(dArr2.length / 2.0d);
        int length = dArr.length;
        int i = length - (floor * 2);
        int i2 = 1;
        int i3 = (floor + i) - 1;
        double[][] dArr3 = (double[][]) java.lang.reflect.Array.newInstance((java.lang.Class<?>) java.lang.Double.TYPE, length, length);
        int i4 = 0;
        while (true) {
            double d = 0.0d;
            if (i4 >= length) {
                break;
            }
            int i5 = 0;
            while (i5 < length) {
                double d2 = dArr[i4][i5];
                if (d2 != d) {
                    int i6 = i4 + floor;
                    if (i3 < i6) {
                        i6 = i3;
                    }
                    int i7 = i6 + 1;
                    int i8 = i4 - floor;
                    for (int i9 = floor > i8 ? floor : i8; i9 < i7; i9++) {
                        double[] dArr4 = dArr3[i9];
                        dArr4[i5] = dArr4[i5] + (dArr2[i9 - i8] * d2);
                    }
                }
                i5++;
                d = 0.0d;
            }
            i4++;
        }
        double[][] dArr5 = (double[][]) java.lang.reflect.Array.newInstance((java.lang.Class<?>) java.lang.Double.TYPE, i, i);
        int i10 = floor;
        while (i10 < i3 + 1) {
            int i11 = 0;
            while (i11 < length) {
                double d3 = dArr3[i10][i11];
                if (d3 != 0.0d) {
                    int i12 = i11 + floor;
                    if (i3 < i12) {
                        i12 = i3;
                    }
                    int i13 = i12 + i2;
                    int i14 = i11 - floor;
                    for (int i15 = floor > i14 ? floor : i14; i15 < i13; i15++) {
                        double[] dArr6 = dArr5[i10 - floor];
                        int i16 = i15 - floor;
                        dArr6[i16] = dArr6[i16] + (dArr2[i15 - i14] * d3);
                    }
                }
                i11++;
                i2 = 1;
            }
            i10++;
            i2 = 1;
        }
        return dArr5;
    }

    private void b(java.util.Collection<com.amap.api.maps.model.WeightedLatLng> collection) {
        try {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            for (com.amap.api.maps.model.WeightedLatLng weightedLatLng : collection) {
                double d = weightedLatLng.latLng.latitude;
                if (d < 85.0d && d > -85.0d) {
                    arrayList.add(weightedLatLng);
                }
            }
            this.mData = arrayList;
            com.amap.api.mapcore.util.cu d2 = d(arrayList);
            this.mBounds = d2;
            this.mTree = new com.amap.api.maps.model.a(d2);
            java.util.Iterator<com.amap.api.maps.model.WeightedLatLng> it = this.mData.iterator();
            while (it.hasNext()) {
                this.mTree.a(it.next());
            }
            this.mMaxIntensity = a(this.mRadius);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static java.util.Collection<com.amap.api.maps.model.WeightedLatLng> c(java.util.Collection<com.amap.api.maps.model.LatLng> collection) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Iterator<com.amap.api.maps.model.LatLng> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(new com.amap.api.maps.model.WeightedLatLng(it.next()));
        }
        return arrayList;
    }

    private static com.amap.api.mapcore.util.cu d(java.util.Collection<com.amap.api.maps.model.WeightedLatLng> collection) {
        java.util.Iterator<com.amap.api.maps.model.WeightedLatLng> it = collection.iterator();
        com.amap.api.maps.model.WeightedLatLng next = it.next();
        double d = next.getPoint().x;
        double d2 = next.getPoint().x;
        double d3 = d;
        double d4 = d2;
        double d5 = next.getPoint().y;
        double d6 = next.getPoint().y;
        while (it.hasNext()) {
            com.amap.api.maps.model.WeightedLatLng next2 = it.next();
            double d7 = next2.getPoint().x;
            double d8 = next2.getPoint().y;
            if (d7 < d3) {
                d3 = d7;
            }
            if (d7 > d4) {
                d4 = d7;
            }
            if (d8 < d5) {
                d5 = d8;
            }
            if (d8 > d6) {
                d6 = d8;
            }
        }
        return new com.amap.api.mapcore.util.cu(d3, d4, d5, d6);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x00ab  */
    @Override // com.amap.api.maps.model.TileProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.amap.api.maps.model.Tile getTile(int i, int i2, int i3) {
        double d;
        double d2;
        com.amap.api.mapcore.util.cu cuVar;
        com.amap.api.mapcore.util.cu cuVar2;
        double pow = 1.0d / java.lang.Math.pow(2.0d, i3);
        double d3 = (this.mRadius * pow) / 256.0d;
        double d4 = ((2.0d * d3) + pow) / ((r10 * 2) + 256);
        double d5 = (i * pow) - d3;
        double d6 = ((i + 1) * pow) + d3;
        double d7 = (i2 * pow) - d3;
        double d8 = ((i2 + 1) * pow) + d3;
        java.util.Collection<com.amap.api.maps.model.WeightedLatLng> arrayList = new java.util.ArrayList<>();
        if (d5 < 0.0d) {
            arrayList = this.mTree.a(new com.amap.api.mapcore.util.cu(d5 + 1.0d, 1.0d, d7, d8));
            d = -1.0d;
        } else {
            d = 1.0d;
            if (d6 <= 1.0d) {
                d2 = 0.0d;
                cuVar = new com.amap.api.mapcore.util.cu(d5, d6, d7, d8);
                cuVar2 = this.mBounds;
                if (cuVar.a(new com.amap.api.mapcore.util.cu(cuVar2.a - d3, cuVar2.c + d3, cuVar2.b - d3, cuVar2.d + d3))) {
                    return com.amap.api.maps.model.TileProvider.NO_TILE;
                }
                java.util.Collection<com.amap.api.maps.model.WeightedLatLng> a = this.mTree.a(cuVar);
                if (a.isEmpty()) {
                    return com.amap.api.maps.model.TileProvider.NO_TILE;
                }
                int i4 = this.mRadius;
                double[][] dArr = (double[][]) java.lang.reflect.Array.newInstance((java.lang.Class<?>) java.lang.Double.TYPE, (i4 * 2) + 256, (i4 * 2) + 256);
                for (com.amap.api.maps.model.WeightedLatLng weightedLatLng : a) {
                    com.autonavi.amap.mapcore.DPoint point = weightedLatLng.getPoint();
                    int i5 = (int) ((point.x - d5) / d4);
                    int i6 = (int) ((point.y - d7) / d4);
                    double[] dArr2 = dArr[i5];
                    dArr2[i6] = dArr2[i6] + weightedLatLng.intensity;
                }
                for (com.amap.api.maps.model.WeightedLatLng weightedLatLng2 : arrayList) {
                    com.autonavi.amap.mapcore.DPoint point2 = weightedLatLng2.getPoint();
                    int i7 = (int) (((point2.x + d2) - d5) / d4);
                    int i8 = (int) ((point2.y - d7) / d4);
                    double[] dArr3 = dArr[i7];
                    dArr3[i8] = dArr3[i8] + weightedLatLng2.intensity;
                }
                return a(a(a(dArr, this.mKernel), this.mColorMap, this.mMaxIntensity[i3]));
            }
            arrayList = this.mTree.a(new com.amap.api.mapcore.util.cu(0.0d, d6 - 1.0d, d7, d8));
        }
        d2 = d;
        cuVar = new com.amap.api.mapcore.util.cu(d5, d6, d7, d8);
        cuVar2 = this.mBounds;
        if (cuVar.a(new com.amap.api.mapcore.util.cu(cuVar2.a - d3, cuVar2.c + d3, cuVar2.b - d3, cuVar2.d + d3))) {
        }
    }

    @Override // com.amap.api.maps.model.TileProvider
    public int getTileHeight() {
        return 256;
    }

    @Override // com.amap.api.maps.model.TileProvider
    public int getTileWidth() {
        return 256;
    }
}
