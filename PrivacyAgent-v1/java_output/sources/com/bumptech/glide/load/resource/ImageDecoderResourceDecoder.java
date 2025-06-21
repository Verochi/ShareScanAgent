package com.bumptech.glide.load.resource;

@androidx.annotation.RequiresApi(api = 28)
/* loaded from: classes.dex */
public abstract class ImageDecoderResourceDecoder<T> implements com.bumptech.glide.load.ResourceDecoder<android.graphics.ImageDecoder.Source, T> {
    private static final java.lang.String TAG = "ImageDecoder";
    final com.bumptech.glide.load.resource.bitmap.HardwareConfigState hardwareConfigState = com.bumptech.glide.load.resource.bitmap.HardwareConfigState.getInstance();

    /* renamed from: com.bumptech.glide.load.resource.ImageDecoderResourceDecoder$1, reason: invalid class name */
    public class AnonymousClass1 implements android.graphics.ImageDecoder.OnHeaderDecodedListener {
        final /* synthetic */ com.bumptech.glide.load.DecodeFormat val$decodeFormat;
        final /* synthetic */ boolean val$isHardwareConfigAllowed;
        final /* synthetic */ com.bumptech.glide.load.PreferredColorSpace val$preferredColorSpace;
        final /* synthetic */ int val$requestedHeight;
        final /* synthetic */ int val$requestedWidth;
        final /* synthetic */ com.bumptech.glide.load.resource.bitmap.DownsampleStrategy val$strategy;

        /* renamed from: com.bumptech.glide.load.resource.ImageDecoderResourceDecoder$1$1, reason: invalid class name and collision with other inner class name */
        public class C02531 implements android.graphics.ImageDecoder.OnPartialImageListener {
            public C02531() {
            }

            @Override // android.graphics.ImageDecoder.OnPartialImageListener
            public boolean onPartialImage(@androidx.annotation.NonNull android.graphics.ImageDecoder.DecodeException decodeException) {
                return false;
            }
        }

        public AnonymousClass1(int i, int i2, boolean z, com.bumptech.glide.load.DecodeFormat decodeFormat, com.bumptech.glide.load.resource.bitmap.DownsampleStrategy downsampleStrategy, com.bumptech.glide.load.PreferredColorSpace preferredColorSpace) {
            this.val$requestedWidth = i;
            this.val$requestedHeight = i2;
            this.val$isHardwareConfigAllowed = z;
            this.val$decodeFormat = decodeFormat;
            this.val$strategy = downsampleStrategy;
            this.val$preferredColorSpace = preferredColorSpace;
        }

        @Override // android.graphics.ImageDecoder.OnHeaderDecodedListener
        @android.annotation.SuppressLint({"Override"})
        public void onHeaderDecoded(android.graphics.ImageDecoder imageDecoder, android.graphics.ImageDecoder.ImageInfo imageInfo, android.graphics.ImageDecoder.Source source) {
            android.util.Size size;
            android.graphics.ColorSpace.Named named;
            android.graphics.ColorSpace colorSpace;
            android.graphics.ColorSpace colorSpace2;
            android.graphics.ColorSpace colorSpace3;
            android.graphics.ColorSpace colorSpace4;
            boolean isWideGamut;
            boolean z = false;
            if (com.bumptech.glide.load.resource.ImageDecoderResourceDecoder.this.hardwareConfigState.isHardwareConfigAllowed(this.val$requestedWidth, this.val$requestedHeight, this.val$isHardwareConfigAllowed, false)) {
                imageDecoder.setAllocator(3);
            } else {
                imageDecoder.setAllocator(1);
            }
            if (this.val$decodeFormat == com.bumptech.glide.load.DecodeFormat.PREFER_RGB_565) {
                imageDecoder.setMemorySizePolicy(0);
            }
            imageDecoder.setOnPartialImageListener(new com.bumptech.glide.load.resource.ImageDecoderResourceDecoder.AnonymousClass1.C02531());
            size = imageInfo.getSize();
            int i = this.val$requestedWidth;
            if (i == Integer.MIN_VALUE) {
                i = size.getWidth();
            }
            int i2 = this.val$requestedHeight;
            if (i2 == Integer.MIN_VALUE) {
                i2 = size.getHeight();
            }
            float scaleFactor = this.val$strategy.getScaleFactor(size.getWidth(), size.getHeight(), i, i2);
            int round = java.lang.Math.round(size.getWidth() * scaleFactor);
            int round2 = java.lang.Math.round(size.getHeight() * scaleFactor);
            if (android.util.Log.isLoggable(com.bumptech.glide.load.resource.ImageDecoderResourceDecoder.TAG, 2)) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("Resizing from [");
                sb.append(size.getWidth());
                sb.append("x");
                sb.append(size.getHeight());
                sb.append("] to [");
                sb.append(round);
                sb.append("x");
                sb.append(round2);
                sb.append("] scaleFactor: ");
                sb.append(scaleFactor);
            }
            imageDecoder.setTargetSize(round, round2);
            int i3 = android.os.Build.VERSION.SDK_INT;
            if (i3 < 28) {
                if (i3 >= 26) {
                    named = android.graphics.ColorSpace.Named.SRGB;
                    colorSpace = android.graphics.ColorSpace.get(named);
                    imageDecoder.setTargetColorSpace(colorSpace);
                    return;
                }
                return;
            }
            if (this.val$preferredColorSpace == com.bumptech.glide.load.PreferredColorSpace.DISPLAY_P3) {
                colorSpace3 = imageInfo.getColorSpace();
                if (colorSpace3 != null) {
                    colorSpace4 = imageInfo.getColorSpace();
                    isWideGamut = colorSpace4.isWideGamut();
                    if (isWideGamut) {
                        z = true;
                    }
                }
            }
            colorSpace2 = android.graphics.ColorSpace.get(z ? android.graphics.ColorSpace.Named.DISPLAY_P3 : android.graphics.ColorSpace.Named.SRGB);
            imageDecoder.setTargetColorSpace(colorSpace2);
        }
    }

    public abstract com.bumptech.glide.load.engine.Resource<T> decode(android.graphics.ImageDecoder.Source source, int i, int i2, android.graphics.ImageDecoder.OnHeaderDecodedListener onHeaderDecodedListener) throws java.io.IOException;

    @Override // com.bumptech.glide.load.ResourceDecoder
    @androidx.annotation.Nullable
    public final com.bumptech.glide.load.engine.Resource<T> decode(@androidx.annotation.NonNull android.graphics.ImageDecoder.Source source, int i, int i2, @androidx.annotation.NonNull com.bumptech.glide.load.Options options) throws java.io.IOException {
        com.bumptech.glide.load.DecodeFormat decodeFormat = (com.bumptech.glide.load.DecodeFormat) options.get(com.bumptech.glide.load.resource.bitmap.Downsampler.DECODE_FORMAT);
        com.bumptech.glide.load.resource.bitmap.DownsampleStrategy downsampleStrategy = (com.bumptech.glide.load.resource.bitmap.DownsampleStrategy) options.get(com.bumptech.glide.load.resource.bitmap.DownsampleStrategy.OPTION);
        com.bumptech.glide.load.Option<java.lang.Boolean> option = com.bumptech.glide.load.resource.bitmap.Downsampler.ALLOW_HARDWARE_CONFIG;
        return decode(source, i, i2, new com.bumptech.glide.load.resource.ImageDecoderResourceDecoder.AnonymousClass1(i, i2, options.get(option) != null && ((java.lang.Boolean) options.get(option)).booleanValue(), decodeFormat, downsampleStrategy, (com.bumptech.glide.load.PreferredColorSpace) options.get(com.bumptech.glide.load.resource.bitmap.Downsampler.PREFERRED_COLOR_SPACE)));
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public final boolean handles(@androidx.annotation.NonNull android.graphics.ImageDecoder.Source source, @androidx.annotation.NonNull com.bumptech.glide.load.Options options) {
        return true;
    }
}
