package com.huania.sdk.utils;

/* loaded from: classes22.dex */
public class PlaySound {
    public static com.huania.sdk.utils.PlaySound h;
    public java.lang.Runnable c;
    public int g;
    public int a = 485;
    public android.os.Handler b = new android.os.Handler();
    public java.util.List<java.lang.Integer> e = new java.util.ArrayList();
    public java.util.HashMap<java.lang.Integer, java.lang.Integer> f = new java.util.HashMap<>();
    public android.media.SoundPool d = new android.media.SoundPool.Builder().setMaxStreams(15).setAudioAttributes(new android.media.AudioAttributes.Builder().setLegacyStreamType(3).setUsage(1).setContentType(2).build()).build();

    /* renamed from: com.huania.sdk.utils.PlaySound$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int size = com.huania.sdk.utils.PlaySound.this.e.size();
            if (size == 0) {
                com.huania.sdk.utils.PlaySound.this.b.removeCallbacks(com.huania.sdk.utils.PlaySound.this.c);
                return;
            }
            com.huania.sdk.utils.PlaySound playSound = com.huania.sdk.utils.PlaySound.this;
            playSound.g = playSound.d.play(((java.lang.Integer) com.huania.sdk.utils.PlaySound.this.e.get(0)).intValue(), 1.0f, 1.0f, 0, 0, 1.0f);
            com.huania.sdk.utils.PlaySound.this.e.remove(0);
            if (size > 10) {
                com.huania.sdk.utils.PlaySound.this.b.postDelayed(this, com.huania.sdk.utils.PlaySound.this.a);
            } else {
                com.huania.sdk.utils.PlaySound.this.b.postDelayed(this, 1280L);
            }
        }
    }

    public PlaySound(android.content.Context context) {
        this.f.put(0, java.lang.Integer.valueOf(this.d.load(context, com.huania.sdk.R.raw.dingdong, 10)));
        this.f.put(1, java.lang.Integer.valueOf(this.d.load(context, com.huania.sdk.R.raw.one, 1)));
        this.f.put(2, java.lang.Integer.valueOf(this.d.load(context, com.huania.sdk.R.raw.two, 1)));
        this.f.put(3, java.lang.Integer.valueOf(this.d.load(context, com.huania.sdk.R.raw.three, 1)));
        this.f.put(4, java.lang.Integer.valueOf(this.d.load(context, com.huania.sdk.R.raw.four, 1)));
        this.f.put(5, java.lang.Integer.valueOf(this.d.load(context, com.huania.sdk.R.raw.five, 1)));
        this.f.put(6, java.lang.Integer.valueOf(this.d.load(context, com.huania.sdk.R.raw.six, 1)));
        this.f.put(7, java.lang.Integer.valueOf(this.d.load(context, com.huania.sdk.R.raw.seven, 1)));
        this.f.put(8, java.lang.Integer.valueOf(this.d.load(context, com.huania.sdk.R.raw.eight, 1)));
        this.f.put(9, java.lang.Integer.valueOf(this.d.load(context, com.huania.sdk.R.raw.nine, 1)));
        this.f.put(10, java.lang.Integer.valueOf(this.d.load(context, com.huania.sdk.R.raw.ten, 1)));
        this.f.put(11, java.lang.Integer.valueOf(this.d.load(context, com.huania.sdk.R.raw.non, 1)));
        this.f.put(12, java.lang.Integer.valueOf(this.d.load(context, com.huania.sdk.R.raw.di, 1)));
        this.f.put(13, java.lang.Integer.valueOf(this.d.load(context, com.huania.sdk.R.raw.didi, 1)));
        this.f.put(14, java.lang.Integer.valueOf(this.d.load(context, com.huania.sdk.R.raw.wu, 1)));
    }

    public static com.huania.sdk.utils.PlaySound getInstance(android.content.Context context) {
        if (h == null) {
            synchronized (com.huania.sdk.utils.PlaySound.class) {
                if (h == null) {
                    h = new com.huania.sdk.utils.PlaySound(context);
                }
            }
        }
        return h;
    }

    public void clear() {
        this.b.removeCallbacks(this.c);
        this.e.clear();
        this.d.stop(this.g);
    }

    public final void g(int i, int i2) {
        this.e.clear();
        boolean z = false;
        for (int i3 = i2; i3 > -10; i3--) {
            if (i3 == i2) {
                this.e.add(this.f.get(0));
            } else if (i3 <= 0) {
                this.e.add(this.f.get(14));
            } else if (i3 > 0 && i3 <= 10) {
                this.e.add(this.f.get(java.lang.Integer.valueOf(i3)));
                if (i == 0) {
                    this.e.add(this.f.get(11));
                } else if (1 == i) {
                    this.e.add(this.f.get(12));
                } else if (2 == i) {
                    this.e.add(this.f.get(13));
                }
            } else if (i3 <= 99) {
                int i4 = i3 / 10;
                int i5 = i3 % 10;
                if (z) {
                    if (i == 0) {
                        this.e.add(this.f.get(11));
                    } else if (1 == i) {
                        this.e.add(this.f.get(12));
                    } else if (2 == i) {
                        this.e.add(this.f.get(13));
                    }
                    this.e.add(this.f.get(11));
                    z = false;
                } else {
                    if (1 == i4) {
                        this.e.add(this.f.get(10));
                    } else {
                        this.e.add(this.f.get(java.lang.Integer.valueOf(i4)));
                    }
                    if (i5 == 0) {
                        this.e.add(this.f.get(10));
                    } else {
                        this.e.add(this.f.get(java.lang.Integer.valueOf(i5)));
                    }
                    z = true;
                }
            } else {
                this.e.add(this.f.get(11));
                this.e.add(this.f.get(11));
            }
        }
    }

    public final void h(int i, int i2) {
        this.e.clear();
        boolean z = false;
        while (i2 > -10) {
            if (i2 <= 0) {
                this.e.add(this.f.get(14));
            } else if (i2 > 0 && i2 <= 10) {
                this.e.add(this.f.get(java.lang.Integer.valueOf(i2)));
                if (i == 0) {
                    this.e.add(this.f.get(11));
                } else if (1 == i) {
                    this.e.add(this.f.get(12));
                } else if (2 == i) {
                    this.e.add(this.f.get(13));
                }
            } else if (i2 <= 99) {
                int i3 = i2 / 10;
                int i4 = i2 % 10;
                if (z) {
                    if (i == 0) {
                        this.e.add(this.f.get(11));
                    } else if (1 == i) {
                        this.e.add(this.f.get(12));
                    } else if (2 == i) {
                        this.e.add(this.f.get(13));
                    }
                    this.e.add(this.f.get(11));
                    z = false;
                } else {
                    if (1 == i3) {
                        this.e.add(this.f.get(10));
                    } else {
                        this.e.add(this.f.get(java.lang.Integer.valueOf(i3)));
                    }
                    if (i4 == 0) {
                        this.e.add(this.f.get(10));
                    } else {
                        this.e.add(this.f.get(java.lang.Integer.valueOf(i4)));
                    }
                    z = true;
                }
            } else {
                this.e.add(this.f.get(11));
                this.e.add(this.f.get(11));
            }
            i2--;
        }
    }

    public final void i() {
        com.huania.sdk.utils.PlaySound.AnonymousClass1 anonymousClass1 = new com.huania.sdk.utils.PlaySound.AnonymousClass1();
        this.c = anonymousClass1;
        this.b.postDelayed(anonymousClass1, 0L);
    }

    public boolean isPlaying() {
        return this.e.size() > 0;
    }

    public void play(int i, float f) {
        clear();
        com.huania.sdk.utils.Logger.INSTANCE.d("play," + i);
        if (f <= 3.0f) {
            g(0, i);
        } else if (f <= 5.0f) {
            g(1, i);
        } else {
            g(2, i);
        }
        i();
    }

    public void playDingdong() {
        clear();
        com.huania.sdk.utils.Logger.INSTANCE.e("playDingdong");
        this.e.clear();
        this.e.add(this.f.get(0));
        i();
    }

    public void playWithoutDingdong(int i, float f) {
        clear();
        com.huania.sdk.utils.Logger.INSTANCE.d("playWithoutDingdong," + i);
        if (f <= 3.0f) {
            h(0, i);
        } else if (f <= 5.0f) {
            h(1, i);
        } else {
            h(2, i);
        }
        i();
    }

    public void playWuwu() {
        clear();
        com.huania.sdk.utils.Logger.INSTANCE.e("wuwuwuwuwuwu");
        this.e.clear();
        this.e.add(this.f.get(0));
        for (int i = 0; i < 9; i++) {
            this.e.add(this.f.get(14));
        }
        i();
    }

    public void playWuwuWithoutDingdong() {
        clear();
        com.huania.sdk.utils.Logger.INSTANCE.e("playWuwuWithoutDingdong");
        this.e.clear();
        for (int i = 0; i < 10; i++) {
            this.e.add(this.f.get(14));
        }
        i();
    }

    public void stop() {
        this.b.removeCallbacks(this.c);
        this.e.clear();
        this.d.stop(this.g);
    }
}
