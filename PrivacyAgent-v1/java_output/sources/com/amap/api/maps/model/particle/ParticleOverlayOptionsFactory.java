package com.amap.api.maps.model.particle;

/* loaded from: classes12.dex */
public class ParticleOverlayOptionsFactory {
    public static final int PARTICLE_TYPE_HAZE = 3;
    public static final int PARTICLE_TYPE_RAIN = 1;
    public static final int PARTICLE_TYPE_SNOWY = 2;
    public static final int PARTICLE_TYPE_SUNNY = 0;

    private static java.util.List<com.amap.api.maps.model.particle.ParticleOverlayOptions> a() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        com.amap.api.maps.model.particle.ParticleOverlayOptions particleOverlayOptions = new com.amap.api.maps.model.particle.ParticleOverlayOptions();
        particleOverlayOptions.setLoop(false);
        particleOverlayOptions.setMaxParticles(1);
        particleOverlayOptions.setDuration(10000L);
        particleOverlayOptions.setParticleEmissionModule(new com.amap.api.maps.model.particle.ParticleEmissionModule(1, 10000));
        particleOverlayOptions.setParticleShapeModule(new com.amap.api.maps.model.particle.SinglePointParticleShape(0.5f, 0.5f, 0.0f, true));
        particleOverlayOptions.setParticleLifeTime(10000L);
        particleOverlayOptions.setParticleStartSpeed(new com.amap.api.maps.model.particle.RandomVelocityBetweenTwoConstants(-10.0f, -0.0f, -0.0f, -20.0f, 0.0f, 0.0f));
        com.amap.api.maps.model.BitmapDescriptor fromAsset = com.amap.api.maps.model.BitmapDescriptorFactory.fromAsset("map_custom/particle/fog.png");
        if (fromAsset != null) {
            particleOverlayOptions.icon(fromAsset);
            particleOverlayOptions.setStartParticleSize(fromAsset.getWidth() * 5, fromAsset.getWidth() * 5);
        }
        arrayList.add(particleOverlayOptions);
        com.amap.api.maps.model.particle.ParticleOverlayOptions particleOverlayOptions2 = new com.amap.api.maps.model.particle.ParticleOverlayOptions();
        particleOverlayOptions2.setMaxParticles(1000);
        particleOverlayOptions2.setDuration(10000L);
        particleOverlayOptions2.setParticleEmissionModule(new com.amap.api.maps.model.particle.ParticleEmissionModule(30, 2500));
        particleOverlayOptions2.setLoop(true);
        particleOverlayOptions2.setParticleShapeModule(new com.amap.api.maps.model.particle.RectParticleShape(0.5f, 0.5f, 1.0f, 1.0f, true));
        particleOverlayOptions2.setParticleLifeTime(10000L);
        particleOverlayOptions2.setParticleStartSpeed(new com.amap.api.maps.model.particle.RandomVelocityBetweenTwoConstants(-100.0f, -100.0f, -1.0f, -200.0f, 100.0f, 1.0f));
        com.amap.api.maps.model.BitmapDescriptor fromAsset2 = com.amap.api.maps.model.BitmapDescriptorFactory.fromAsset("map_custom/particle/haze.png");
        if (fromAsset2 != null) {
            particleOverlayOptions2.icon(fromAsset2);
            particleOverlayOptions2.setStartParticleSize(fromAsset2.getWidth(), fromAsset2.getHeight());
        }
        particleOverlayOptions2.setParticleStartColor(new com.amap.api.maps.model.particle.RandomColorBetWeenTwoConstants(255.0f, 255.0f, 255.0f, 102.0f, 255.0f, 255.0f, 255.0f, 255.0f));
        arrayList.add(particleOverlayOptions2);
        return arrayList;
    }

    private static com.amap.api.maps.model.particle.ParticleOverlayOptions b() {
        com.amap.api.maps.model.particle.ParticleOverlayOptions particleOverlayOptions = new com.amap.api.maps.model.particle.ParticleOverlayOptions();
        particleOverlayOptions.setMaxParticles(1000);
        particleOverlayOptions.setDuration(5000L);
        particleOverlayOptions.setParticleEmissionModule(new com.amap.api.maps.model.particle.ParticleEmissionModule(20, 1000));
        particleOverlayOptions.setLoop(true);
        particleOverlayOptions.setParticleShapeModule(new com.amap.api.maps.model.particle.RectParticleShape(0.0f, 0.0f, 1.0f, 0.1f, true));
        particleOverlayOptions.setParticleLifeTime(10000L);
        particleOverlayOptions.setParticleStartSpeed(new com.amap.api.maps.model.particle.RandomVelocityBetweenTwoConstants(-50.0f, 100.0f, 0.0f, 50.0f, 200.0f, 0.0f));
        com.amap.api.maps.model.BitmapDescriptor fromAsset = com.amap.api.maps.model.BitmapDescriptorFactory.fromAsset("map_custom/particle/snow.png");
        if (fromAsset != null) {
            particleOverlayOptions.icon(fromAsset);
            particleOverlayOptions.setStartParticleSize(fromAsset.getWidth(), fromAsset.getHeight());
        }
        return particleOverlayOptions;
    }

    private static com.amap.api.maps.model.particle.ParticleOverlayOptions c() {
        com.amap.api.maps.model.particle.ParticleOverlayOptions particleOverlayOptions = new com.amap.api.maps.model.particle.ParticleOverlayOptions();
        particleOverlayOptions.setMaxParticles(1000);
        particleOverlayOptions.setDuration(5000L);
        particleOverlayOptions.setParticleEmissionModule(new com.amap.api.maps.model.particle.ParticleEmissionModule(100, 1000));
        particleOverlayOptions.setLoop(true);
        particleOverlayOptions.setParticleLifeTime(5000L);
        particleOverlayOptions.setParticleStartSpeed(new com.amap.api.maps.model.particle.RandomVelocityBetweenTwoConstants(10.0f, 1000.0f, 0.0f, 100.0f, 1000.0f, 0.0f));
        particleOverlayOptions.setParticleShapeModule(new com.amap.api.maps.model.particle.RectParticleShape(0.0f, 0.0f, 1.0f, 0.1f, true));
        com.amap.api.maps.model.BitmapDescriptor fromAsset = com.amap.api.maps.model.BitmapDescriptorFactory.fromAsset("map_custom/particle/rain.png");
        if (fromAsset != null) {
            particleOverlayOptions.icon(fromAsset);
            particleOverlayOptions.setStartParticleSize(fromAsset.getWidth() * 2, fromAsset.getHeight() * 2);
        }
        return particleOverlayOptions;
    }

    private static java.util.List<com.amap.api.maps.model.particle.ParticleOverlayOptions> d() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        com.amap.api.maps.model.particle.ParticleOverlayOptions particleOverlayOptions = new com.amap.api.maps.model.particle.ParticleOverlayOptions();
        particleOverlayOptions.setMaxParticles(1);
        particleOverlayOptions.setDuration(10000L);
        particleOverlayOptions.setParticleEmissionModule(new com.amap.api.maps.model.particle.ParticleEmissionModule(1, 2500));
        particleOverlayOptions.setLoop(true);
        particleOverlayOptions.setParticleShapeModule(new com.amap.api.maps.model.particle.SinglePointParticleShape(0.0f, 0.0f, 0.0f));
        particleOverlayOptions.setParticleLifeTime(10000L);
        particleOverlayOptions.setParticleStartSpeed(new com.amap.api.maps.model.particle.RandomVelocityBetweenTwoConstants(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f));
        particleOverlayOptions.setParticleOverLifeModule(new com.amap.api.maps.model.particle.ParticleOverLifeModule());
        particleOverlayOptions.icon(com.amap.api.maps.model.BitmapDescriptorFactory.fromAsset("map_custom/particle/sun_0.png"));
        particleOverlayOptions.setStartParticleSize(1000, 1000);
        arrayList.add(particleOverlayOptions);
        com.amap.api.maps.model.particle.ParticleOverlayOptions particleOverlayOptions2 = new com.amap.api.maps.model.particle.ParticleOverlayOptions();
        particleOverlayOptions2.setMaxParticles(1);
        particleOverlayOptions2.setDuration(10000L);
        particleOverlayOptions2.setParticleEmissionModule(new com.amap.api.maps.model.particle.ParticleEmissionModule(1, 2500));
        particleOverlayOptions2.setLoop(true);
        particleOverlayOptions2.setParticleShapeModule(new com.amap.api.maps.model.particle.SinglePointParticleShape(0.0f, 0.0f, 0.0f));
        particleOverlayOptions2.setParticleLifeTime(10000L);
        particleOverlayOptions2.setParticleStartSpeed(new com.amap.api.maps.model.particle.RandomVelocityBetweenTwoConstants(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f));
        com.amap.api.maps.model.particle.ParticleOverLifeModule particleOverLifeModule = new com.amap.api.maps.model.particle.ParticleOverLifeModule();
        particleOverLifeModule.setRotateOverLife(new com.amap.api.maps.model.particle.ConstantRotationOverLife(45.0f));
        particleOverlayOptions2.setParticleOverLifeModule(particleOverLifeModule);
        particleOverlayOptions2.icon(com.amap.api.maps.model.BitmapDescriptorFactory.fromAsset("map_custom/particle/sun_1.png"));
        particleOverlayOptions2.setStartParticleSize(1000, 1000);
        arrayList.add(particleOverlayOptions2);
        return arrayList;
    }

    public static java.util.List<com.amap.api.maps.model.particle.ParticleOverlayOptions> defaultOptions(int i) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (i == 0) {
            arrayList.addAll(d());
        } else if (i == 1) {
            arrayList.add(c());
        } else if (i == 2) {
            arrayList.add(b());
        } else if (i == 3) {
            arrayList.addAll(a());
        }
        return arrayList;
    }
}
