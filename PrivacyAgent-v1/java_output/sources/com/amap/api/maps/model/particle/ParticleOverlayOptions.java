package com.amap.api.maps.model.particle;

@com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
/* loaded from: classes12.dex */
public class ParticleOverlayOptions extends com.amap.api.maps.model.BaseOptions implements android.os.Parcelable, java.lang.Cloneable {

    @com.autonavi.base.amap.mapcore.jbinding.JBindingExclude
    public static final android.os.Parcelable.Creator<com.amap.api.maps.model.particle.ParticleOverlayOptions> CREATOR = new com.amap.api.maps.model.particle.ParticleOverlayOptions.AnonymousClass1();
    private com.amap.api.maps.model.BitmapDescriptor bitmapDescriptor;
    private long duration;
    private boolean isParticleEmissionModuleUpdate;
    private boolean isParticleOverLifeModuleUpdate;
    private boolean isParticleShapeModuleUpdate;
    private boolean isStartColorUpdate;
    private boolean isStartSpeedUpdate;
    private boolean loop;
    private int maxParticles;
    private com.amap.api.maps.model.particle.ParticleEmissionModule particleEmissionModule;
    private long particleLifeTime;
    private com.amap.api.maps.model.particle.ParticleOverLifeModule particleOverLifeModule;
    private com.amap.api.maps.model.particle.ParticleShapeModule particleShapeModule;
    private java.lang.Object particleShapeModuleObject;
    private com.amap.api.maps.model.particle.ColorGenerate startColor;
    private java.lang.Object startColorObject;
    private int startParticleH;
    private int startParticleW;
    private com.amap.api.maps.model.particle.VelocityGenerate startSpeed;
    private java.lang.Object startSpeedObject;
    private boolean visibile;
    private float zIndex;

    /* renamed from: com.amap.api.maps.model.particle.ParticleOverlayOptions$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.amap.api.maps.model.particle.ParticleOverlayOptions> {
        private static com.amap.api.maps.model.particle.ParticleOverlayOptions a(android.os.Parcel parcel) {
            return new com.amap.api.maps.model.particle.ParticleOverlayOptions(parcel);
        }

        private static com.amap.api.maps.model.particle.ParticleOverlayOptions[] a(int i) {
            return new com.amap.api.maps.model.particle.ParticleOverlayOptions[i];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.amap.api.maps.model.particle.ParticleOverlayOptions createFromParcel(android.os.Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.amap.api.maps.model.particle.ParticleOverlayOptions[] newArray(int i) {
            return a(i);
        }
    }

    public ParticleOverlayOptions() {
        this.zIndex = 1.0f;
        this.maxParticles = 100;
        this.loop = true;
        this.duration = 5000L;
        this.particleLifeTime = 5000L;
        this.startSpeed = null;
        this.startParticleW = 32;
        this.startParticleH = 32;
        this.visibile = true;
        this.isParticleEmissionModuleUpdate = false;
        this.isParticleShapeModuleUpdate = false;
        this.isStartSpeedUpdate = false;
        this.isStartColorUpdate = false;
        this.isParticleOverLifeModuleUpdate = false;
        this.type = "ParticleOptions";
    }

    @com.autonavi.base.amap.mapcore.jbinding.JBindingExclude
    public ParticleOverlayOptions(android.os.Parcel parcel) {
        this.zIndex = 1.0f;
        this.maxParticles = 100;
        this.loop = true;
        this.duration = 5000L;
        this.particleLifeTime = 5000L;
        this.startSpeed = null;
        this.startParticleW = 32;
        this.startParticleH = 32;
        this.visibile = true;
        this.isParticleEmissionModuleUpdate = false;
        this.isParticleShapeModuleUpdate = false;
        this.isStartSpeedUpdate = false;
        this.isStartColorUpdate = false;
        this.isParticleOverLifeModuleUpdate = false;
        this.bitmapDescriptor = (com.amap.api.maps.model.BitmapDescriptor) parcel.readParcelable(com.amap.api.maps.model.BitmapDescriptor.class.getClassLoader());
        this.zIndex = parcel.readFloat();
        this.maxParticles = parcel.readInt();
        this.loop = parcel.readByte() != 0;
        this.duration = parcel.readLong();
        this.particleLifeTime = parcel.readLong();
        this.startParticleW = parcel.readInt();
        this.startParticleH = parcel.readInt();
        this.visibile = parcel.readByte() != 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long getDuration() {
        return this.duration;
    }

    public com.amap.api.maps.model.BitmapDescriptor getIcon() {
        return this.bitmapDescriptor;
    }

    public int getMaxParticles() {
        return this.maxParticles;
    }

    public com.amap.api.maps.model.particle.ParticleEmissionModule getParticleEmissionModule() {
        return this.particleEmissionModule;
    }

    public long getParticleLifeTime() {
        return this.particleLifeTime;
    }

    public com.amap.api.maps.model.particle.ParticleOverLifeModule getParticleOverLifeModule() {
        return this.particleOverLifeModule;
    }

    public com.amap.api.maps.model.particle.ParticleShapeModule getParticleShapeModule() {
        return this.particleShapeModule;
    }

    public com.amap.api.maps.model.particle.ColorGenerate getParticleStartColor() {
        return this.startColor;
    }

    public com.amap.api.maps.model.particle.VelocityGenerate getParticleStartSpeed() {
        return this.startSpeed;
    }

    public int getStartParticleW() {
        return this.startParticleW;
    }

    public float getZIndex() {
        return this.zIndex;
    }

    public int getstartParticleH() {
        return this.startParticleH;
    }

    public com.amap.api.maps.model.particle.ParticleOverlayOptions icon(com.amap.api.maps.model.BitmapDescriptor bitmapDescriptor) {
        try {
            this.bitmapDescriptor = bitmapDescriptor;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        return this;
    }

    public boolean isLoop() {
        return this.loop;
    }

    public boolean isVisibile() {
        return this.visibile;
    }

    public com.amap.api.maps.model.particle.ParticleOverlayOptions setDuration(long j) {
        this.duration = j;
        return this;
    }

    public com.amap.api.maps.model.particle.ParticleOverlayOptions setLoop(boolean z) {
        this.loop = z;
        return this;
    }

    public com.amap.api.maps.model.particle.ParticleOverlayOptions setMaxParticles(int i) {
        this.maxParticles = i;
        return this;
    }

    public com.amap.api.maps.model.particle.ParticleOverlayOptions setParticleEmissionModule(com.amap.api.maps.model.particle.ParticleEmissionModule particleEmissionModule) {
        this.particleEmissionModule = particleEmissionModule;
        this.isParticleEmissionModuleUpdate = true;
        return this;
    }

    public com.amap.api.maps.model.particle.ParticleOverlayOptions setParticleLifeTime(long j) {
        this.particleLifeTime = j;
        return this;
    }

    public com.amap.api.maps.model.particle.ParticleOverlayOptions setParticleOverLifeModule(com.amap.api.maps.model.particle.ParticleOverLifeModule particleOverLifeModule) {
        this.particleOverLifeModule = particleOverLifeModule;
        this.isParticleOverLifeModuleUpdate = true;
        return this;
    }

    public com.amap.api.maps.model.particle.ParticleOverlayOptions setParticleShapeModule(com.amap.api.maps.model.particle.ParticleShapeModule particleShapeModule) {
        this.particleShapeModule = particleShapeModule;
        this.particleShapeModuleObject = particleShapeModule;
        this.isParticleShapeModuleUpdate = true;
        return this;
    }

    public com.amap.api.maps.model.particle.ParticleOverlayOptions setParticleStartColor(com.amap.api.maps.model.particle.ColorGenerate colorGenerate) {
        this.startColor = colorGenerate;
        this.startColorObject = colorGenerate;
        this.isStartColorUpdate = true;
        return this;
    }

    public com.amap.api.maps.model.particle.ParticleOverlayOptions setParticleStartSpeed(com.amap.api.maps.model.particle.VelocityGenerate velocityGenerate) {
        this.startSpeed = velocityGenerate;
        this.startSpeedObject = velocityGenerate;
        this.isStartSpeedUpdate = true;
        return this;
    }

    public com.amap.api.maps.model.particle.ParticleOverlayOptions setStartParticleSize(int i, int i2) {
        this.startParticleW = i;
        this.startParticleH = i2;
        return this;
    }

    public com.amap.api.maps.model.particle.ParticleOverlayOptions setVisible(boolean z) {
        this.visibile = z;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeParcelable(this.bitmapDescriptor, i);
        parcel.writeFloat(this.zIndex);
        parcel.writeInt(this.maxParticles);
        parcel.writeByte(this.loop ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.duration);
        parcel.writeLong(this.particleLifeTime);
        parcel.writeInt(this.startParticleW);
        parcel.writeInt(this.startParticleH);
        parcel.writeByte(this.visibile ? (byte) 1 : (byte) 0);
    }

    public com.amap.api.maps.model.particle.ParticleOverlayOptions zIndex(float f) {
        this.zIndex = f;
        return this;
    }
}
