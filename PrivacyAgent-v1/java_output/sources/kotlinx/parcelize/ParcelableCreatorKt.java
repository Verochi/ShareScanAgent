package kotlinx.parcelize;

@kotlin.Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001b\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\u0086\b¨\u0006\u0004"}, d2 = {"parcelableCreator", "Landroid/os/Parcelable$Creator;", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "Landroid/os/Parcelable;", "parcelize-runtime"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes16.dex */
public final class ParcelableCreatorKt {
    public static final /* synthetic */ <T extends android.os.Parcelable> android.os.Parcelable.Creator<T> parcelableCreator() {
        kotlin.jvm.internal.Intrinsics.reifiedOperationMarker(4, androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE);
        java.lang.Object obj = android.os.Parcelable.class.getDeclaredField("CREATOR").get(null);
        android.os.Parcelable.Creator<T> creator = obj instanceof android.os.Parcelable.Creator ? (android.os.Parcelable.Creator) obj : null;
        if (creator != null) {
            return creator;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("Could not access CREATOR field in class ");
        kotlin.jvm.internal.Intrinsics.reifiedOperationMarker(4, androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE);
        sb.append(kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(android.os.Parcelable.class).getSimpleName());
        throw new java.lang.IllegalArgumentException(sb.toString());
    }
}
