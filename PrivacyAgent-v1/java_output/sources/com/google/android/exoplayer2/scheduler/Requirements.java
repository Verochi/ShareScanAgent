package com.google.android.exoplayer2.scheduler;

/* loaded from: classes22.dex */
public final class Requirements implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.google.android.exoplayer2.scheduler.Requirements> CREATOR = new com.google.android.exoplayer2.scheduler.Requirements.AnonymousClass1();
    public static final int DEVICE_CHARGING = 8;
    public static final int DEVICE_IDLE = 4;
    public static final int DEVICE_STORAGE_NOT_LOW = 16;
    public static final int NETWORK = 1;
    public static final int NETWORK_UNMETERED = 2;
    private final int requirements;

    /* renamed from: com.google.android.exoplayer2.scheduler.Requirements$1, reason: invalid class name */
    public class AnonymousClass1 implements android.os.Parcelable.Creator<com.google.android.exoplayer2.scheduler.Requirements> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.google.android.exoplayer2.scheduler.Requirements createFromParcel(android.os.Parcel parcel) {
            return new com.google.android.exoplayer2.scheduler.Requirements(parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public com.google.android.exoplayer2.scheduler.Requirements[] newArray(int i) {
            return new com.google.android.exoplayer2.scheduler.Requirements[i];
        }
    }

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface RequirementFlags {
    }

    public Requirements(int i) {
        this.requirements = (i & 2) != 0 ? i | 1 : i;
    }

    private int getNotMetNetworkRequirements(android.content.Context context) {
        if (!isNetworkRequired()) {
            return 0;
        }
        android.net.ConnectivityManager connectivityManager = (android.net.ConnectivityManager) com.google.android.exoplayer2.util.Assertions.checkNotNull(context.getSystemService("connectivity"));
        android.net.NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return (activeNetworkInfo != null && activeNetworkInfo.isConnected() && isInternetConnectivityValidated(connectivityManager)) ? (isUnmeteredNetworkRequired() && connectivityManager.isActiveNetworkMetered()) ? 2 : 0 : this.requirements & 3;
    }

    private boolean isDeviceCharging(android.content.Context context) {
        android.content.Intent registerReceiver = context.registerReceiver(null, new android.content.IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver == null) {
            return false;
        }
        int intExtra = registerReceiver.getIntExtra("status", -1);
        return intExtra == 2 || intExtra == 5;
    }

    private boolean isDeviceIdle(android.content.Context context) {
        boolean isDeviceIdleMode;
        android.os.PowerManager powerManager = (android.os.PowerManager) com.google.android.exoplayer2.util.Assertions.checkNotNull(context.getSystemService("power"));
        int i = com.google.android.exoplayer2.util.Util.SDK_INT;
        if (i < 23) {
            return i < 20 ? !powerManager.isScreenOn() : !powerManager.isInteractive();
        }
        isDeviceIdleMode = powerManager.isDeviceIdleMode();
        return isDeviceIdleMode;
    }

    private static boolean isInternetConnectivityValidated(android.net.ConnectivityManager connectivityManager) {
        android.net.Network activeNetwork;
        android.net.NetworkCapabilities networkCapabilities;
        if (com.google.android.exoplayer2.util.Util.SDK_INT < 24) {
            return true;
        }
        activeNetwork = connectivityManager.getActiveNetwork();
        return (activeNetwork == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null || !networkCapabilities.hasCapability(16)) ? false : true;
    }

    private boolean isStorageNotLow(android.content.Context context) {
        return context.registerReceiver(null, new android.content.IntentFilter("android.intent.action.DEVICE_STORAGE_LOW")) == null;
    }

    public boolean checkRequirements(android.content.Context context) {
        return getNotMetRequirements(context) == 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && com.google.android.exoplayer2.scheduler.Requirements.class == obj.getClass() && this.requirements == ((com.google.android.exoplayer2.scheduler.Requirements) obj).requirements;
    }

    public com.google.android.exoplayer2.scheduler.Requirements filterRequirements(int i) {
        int i2 = this.requirements;
        int i3 = i & i2;
        return i3 == i2 ? this : new com.google.android.exoplayer2.scheduler.Requirements(i3);
    }

    public int getNotMetRequirements(android.content.Context context) {
        int notMetNetworkRequirements = getNotMetNetworkRequirements(context);
        if (isChargingRequired() && !isDeviceCharging(context)) {
            notMetNetworkRequirements |= 8;
        }
        if (isIdleRequired() && !isDeviceIdle(context)) {
            notMetNetworkRequirements |= 4;
        }
        return (!isStorageNotLowRequired() || isStorageNotLow(context)) ? notMetNetworkRequirements : notMetNetworkRequirements | 16;
    }

    public int getRequirements() {
        return this.requirements;
    }

    public int hashCode() {
        return this.requirements;
    }

    public boolean isChargingRequired() {
        return (this.requirements & 8) != 0;
    }

    public boolean isIdleRequired() {
        return (this.requirements & 4) != 0;
    }

    public boolean isNetworkRequired() {
        return (this.requirements & 1) != 0;
    }

    public boolean isStorageNotLowRequired() {
        return (this.requirements & 16) != 0;
    }

    public boolean isUnmeteredNetworkRequired() {
        return (this.requirements & 2) != 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeInt(this.requirements);
    }
}
