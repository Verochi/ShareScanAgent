package kotlin;

@kotlin.SinceKotlin(version = "1.1")
@kotlin.Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0016\b\u0007\u0018\u0000 \u001d2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u001dB\u001f\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\f\u001a\u00020\b\u0012\u0006\u0010\u000e\u001a\u00020\b¢\u0006\u0004\b\u001a\u0010\u001bB\u0019\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\f\u001a\u00020\b¢\u0006\u0004\b\u001a\u0010\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0013\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0096\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\u0011\u0010\n\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0000H\u0096\u0002J\u0016\u0010\r\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bJ\u001e\u0010\r\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bJ \u0010\u000f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bH\u0002R\u0017\u0010\u000b\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\f\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013R\u0017\u0010\u000e\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013R\u0014\u0010\u0019\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0011¨\u0006\u001e"}, d2 = {"Lkotlin/KotlinVersion;", "", "", "toString", "", "other", "", "equals", "", com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_HASHCODE, "compareTo", "major", "minor", "isAtLeast", "patch", "a", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "I", "getMajor", "()I", "t", "getMinor", com.umeng.analytics.pro.bo.aN, "getPatch", "v", "version", "<init>", "(III)V", "(II)V", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class KotlinVersion implements java.lang.Comparable<kotlin.KotlinVersion> {
    public static final int MAX_COMPONENT_VALUE = 255;

    /* renamed from: n, reason: from kotlin metadata */
    public final int major;

    /* renamed from: t, reason: from kotlin metadata */
    public final int minor;

    /* renamed from: u, reason: from kotlin metadata */
    public final int patch;

    /* renamed from: v, reason: from kotlin metadata */
    public final int version;

    @kotlin.jvm.JvmField
    @org.jetbrains.annotations.NotNull
    public static final kotlin.KotlinVersion CURRENT = kotlin.KotlinVersionCurrentValue.a();

    public KotlinVersion(int i, int i2) {
        this(i, i2, 0);
    }

    public KotlinVersion(int i, int i2, int i3) {
        this.major = i;
        this.minor = i2;
        this.patch = i3;
        this.version = a(i, i2, i3);
    }

    public final int a(int major, int minor, int patch) {
        boolean z = false;
        if (new kotlin.ranges.IntRange(0, 255).contains(major) && new kotlin.ranges.IntRange(0, 255).contains(minor) && new kotlin.ranges.IntRange(0, 255).contains(patch)) {
            z = true;
        }
        if (z) {
            return (major << 16) + (minor << 8) + patch;
        }
        throw new java.lang.IllegalArgumentException(("Version components are out of range: " + major + '.' + minor + '.' + patch).toString());
    }

    @Override // java.lang.Comparable
    public int compareTo(@org.jetbrains.annotations.NotNull kotlin.KotlinVersion other) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(other, "other");
        return this.version - other.version;
    }

    public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object other) {
        if (this == other) {
            return true;
        }
        kotlin.KotlinVersion kotlinVersion = other instanceof kotlin.KotlinVersion ? (kotlin.KotlinVersion) other : null;
        return kotlinVersion != null && this.version == kotlinVersion.version;
    }

    public final int getMajor() {
        return this.major;
    }

    public final int getMinor() {
        return this.minor;
    }

    public final int getPatch() {
        return this.patch;
    }

    /* renamed from: hashCode, reason: from getter */
    public int getVersion() {
        return this.version;
    }

    public final boolean isAtLeast(int major, int minor) {
        int i = this.major;
        return i > major || (i == major && this.minor >= minor);
    }

    public final boolean isAtLeast(int major, int minor, int patch) {
        int i;
        int i2 = this.major;
        return i2 > major || (i2 == major && ((i = this.minor) > minor || (i == minor && this.patch >= patch)));
    }

    @org.jetbrains.annotations.NotNull
    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(this.major);
        sb.append('.');
        sb.append(this.minor);
        sb.append('.');
        sb.append(this.patch);
        return sb.toString();
    }
}
