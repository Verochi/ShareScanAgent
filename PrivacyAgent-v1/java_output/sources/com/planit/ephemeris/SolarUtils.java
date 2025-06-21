package com.planit.ephemeris;

/* loaded from: classes19.dex */
public class SolarUtils {
    public static double TOLERANCE = 2.5d;
    public static double b = 3600000.0d;
    public static double c = -1.0d;
    public static double d = -2.0d;
    public static int e = 170;
    public com.planit.ephemeris.SolarNativeUtils a = new com.planit.ephemeris.SolarNativeUtils();

    /* renamed from: com.planit.ephemeris.SolarUtils$1, reason: invalid class name */
    public class AnonymousClass1 implements com.planit.ephemeris.SolarUtils.Get {
        public final /* synthetic */ double a;
        public final /* synthetic */ double b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;
        public final /* synthetic */ int e;
        public final /* synthetic */ double f;
        public final /* synthetic */ double g;
        public final /* synthetic */ int h;

        public AnonymousClass1(double d, double d2, int i, int i2, int i3, double d3, double d4, int i4) {
            this.a = d;
            this.b = d2;
            this.c = i;
            this.d = i2;
            this.e = i3;
            this.f = d3;
            this.g = d4;
            this.h = i4;
        }

        @Override // com.planit.ephemeris.SolarUtils.Get
        public double get(int i) {
            return com.planit.ephemeris.SolarUtils.this.e(this.a, this.b, this.c, this.d, this.e, (int) this.f, 0, i, this.g, this.h, 8).moon_elevation;
        }
    }

    public interface Get {
        double get(int i);
    }

    public static class PhaseCalendar {
        public java.util.Calendar calendar;
        public com.planit.ephemeris.MoonPhase phase;

        public PhaseCalendar(java.util.Calendar calendar, com.planit.ephemeris.MoonPhase moonPhase) {
            this.calendar = calendar;
            this.phase = moonPhase;
        }
    }

    public static int b(com.planit.ephemeris.SolarUtils.Get get, int i, double d2, int i2, double d3, double d4, boolean z) {
        int i3 = (i + i2) >>> 1;
        if (i3 == i || i3 == i2) {
            return ~i;
        }
        double d5 = get.get(i3);
        if (java.lang.Math.abs(d5 - d4) < 0.0040472d) {
            return i3;
        }
        if (z) {
            if (d2 <= d4 && d4 <= d5) {
                return c(get, i, i3, d4);
            }
            if (d5 <= d4 && d4 <= d3) {
                return c(get, i3, i2, d4);
            }
            if (d5 >= d2 && d5 <= d3) {
                int b2 = b(get, i, d2, i3, d5, d4, true);
                return b2 < 0 ? b(get, i3, d5, i2, d3, d4, true) : b2;
            }
        } else {
            if (d2 >= d4 && d4 >= d5) {
                return d(get, i, i3, d4);
            }
            if (d5 >= d4 && d4 >= d3) {
                return d(get, i3, i2, d4);
            }
            if (d5 <= d2 && d5 >= d3) {
                int b3 = b(get, i, d2, i3, d5, d4, false);
                return b3 < 0 ? b(get, i3, d5, i2, d3, d4, false) : b3;
            }
        }
        return ~i;
    }

    public static int c(com.planit.ephemeris.SolarUtils.Get get, int i, int i2, double d2) {
        int i3 = i2 - 1;
        while (i <= i3) {
            int i4 = (i + i3) >>> 1;
            double d3 = get.get(i4);
            if (java.lang.Math.abs(d3 - d2) < 0.0040472d) {
                return i4;
            }
            if (d3 < d2) {
                i = i4 + 1;
            } else {
                i3 = i4 - 1;
            }
        }
        return ~i;
    }

    public static int d(com.planit.ephemeris.SolarUtils.Get get, int i, int i2, double d2) {
        int i3 = i2 - 1;
        while (i <= i3) {
            int i4 = (i + i3) >>> 1;
            double d3 = get.get(i4);
            if (java.lang.Math.abs(d3 - d2) < 0.0040472d) {
                return i4;
            }
            if (d3 > d2) {
                i = i4 + 1;
            } else {
                i3 = i4 - 1;
            }
        }
        return ~i;
    }

    public static double getMoonPercentage(double d2) {
        return java.lang.Math.round((((k(d2) + 1.0d) * 100.0d) / 2.0d) * 10.0d) / 10.0d;
    }

    public static double getMoonSizePercentage(double d2) {
        double d3 = d2 * 2.0d * 60.0d;
        return d3 >= 31.06829083450455d ? java.lang.Math.pow(d3 / 31.06829083450455d, 2.0d) - 1.0d : -(java.lang.Math.pow(31.06829083450455d / d3, 2.0d) - 1.0d);
    }

    public static java.util.List<com.planit.ephemeris.SolarUtils.PhaseCalendar> getPhasesForYear(int i) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        double floor = java.lang.Math.floor((i - 1900) * 12.3685d) - 4.0d;
        double d2 = 0.0d;
        double d3 = 0.0d;
        int i2 = 0;
        int i3 = 0;
        int i4 = -1;
        while (true) {
            i2++;
            int i5 = i2 % 4;
            double t = t(floor, d3, e);
            int[] s2 = s(t);
            if (s2[0] >= i) {
                i3++;
            }
            com.planit.ephemeris.SolarUtils.PhaseCalendar phaseCalendar = new com.planit.ephemeris.SolarUtils.PhaseCalendar(i(t), d3 == d2 ? com.planit.ephemeris.MoonPhase.New : d3 == 0.25d ? com.planit.ephemeris.MoonPhase.FirstQuarter : d3 == 0.5d ? com.planit.ephemeris.MoonPhase.Full : com.planit.ephemeris.MoonPhase.LastQuarter);
            if (arrayList.size() > i3) {
                arrayList.set(i3, phaseCalendar);
            } else {
                if (i4 == -1) {
                    i4 = (int) (d3 / 0.25d);
                }
                arrayList.add(phaseCalendar);
            }
            if (s2[0] > i) {
                return arrayList;
            }
            if (i5 == 0) {
                floor += 1.0d;
            }
            d3 += 0.25d;
            if (d3 >= 1.0d) {
                d3 -= 1.0d;
            }
            d2 = 0.0d;
        }
    }

    public static java.util.Calendar i(double d2) {
        double d3 = d2 + 3.4722222222222224E-4d;
        int[] s2 = s(d3);
        int[] r = r(d3);
        java.util.Calendar calendar = java.util.Calendar.getInstance(new java.util.SimpleTimeZone(0, "GMT"));
        calendar.set(s2[0], s2[1] - 1, s2[2], r[0], r[1], r[2]);
        return calendar;
    }

    public static java.util.Calendar j(java.util.Calendar calendar, double d2) {
        if (d2 == c || d2 == d) {
            return null;
        }
        java.util.Calendar p = p(calendar);
        p.setTimeInMillis(p.getTimeInMillis() + ((long) (d2 * 8.64E7d)));
        return p;
    }

    public static double k(double d2) {
        return java.lang.Math.cos(d2 * 0.017453292519943295d);
    }

    public static double l(double d2) {
        return java.lang.Math.cos(n(d2));
    }

    public static double m(double d2) {
        return java.lang.Math.sin(n(d2));
    }

    public static double n(double d2) {
        return (d2 * 3.141592653589793d) / 180.0d;
    }

    public static int o(java.util.Calendar calendar) {
        java.util.TimeZone timeZone = calendar.getTimeZone();
        if (timeZone == null || !timeZone.inDaylightTime(calendar.getTime())) {
            return 0;
        }
        return (int) (timeZone.getDSTSavings() / b);
    }

    public static java.util.Calendar p(java.util.Calendar calendar) {
        java.util.Calendar calendar2 = (java.util.Calendar) calendar.clone();
        calendar2.set(11, 0);
        calendar2.set(12, 0);
        calendar2.set(13, 0);
        calendar2.set(14, 0);
        return calendar2;
    }

    public static double q(java.util.Calendar calendar) {
        if (calendar.getTimeZone() != null) {
            return calendar.getTimeZone().getRawOffset() / b;
        }
        return 0.0d;
    }

    public static int[] r(double d2) {
        double d3 = d2 + 0.5d;
        double floor = (d3 - java.lang.Math.floor(d3)) * 86400.0d;
        return new int[]{(int) java.lang.Math.floor(floor / 3600.0d), (int) java.lang.Math.floor((floor / 60.0d) % 60.0d), (int) java.lang.Math.floor(floor % 60.0d)};
    }

    public static int[] s(double d2) {
        double d3 = d2 + 0.5d;
        double floor = java.lang.Math.floor(d3);
        double d4 = d3 - floor;
        if (floor >= 2299161.0d) {
            double floor2 = java.lang.Math.floor((floor - 1867216.25d) / 36524.25d);
            floor = ((floor + 1.0d) + floor2) - java.lang.Math.floor(floor2 / 4.0d);
        }
        double d5 = floor + 1524.0d;
        double floor3 = java.lang.Math.floor((d5 - 122.1d) / 365.25d);
        double floor4 = d5 - java.lang.Math.floor(365.25d * floor3);
        double floor5 = java.lang.Math.floor(floor4 / 30.6001d);
        int floor6 = (int) java.lang.Math.floor(floor5 - (floor5 >= 14.0d ? 13.0d : 1.0d));
        int[] iArr = new int[3];
        iArr[0] = (int) java.lang.Math.floor(floor3 - (floor6 > 2 ? 4716.0d : 4715.0d));
        iArr[1] = floor6;
        iArr[2] = (int) java.lang.Math.floor((floor4 - java.lang.Math.floor(floor5 * 30.6001d)) + d4);
        return iArr;
    }

    public static double t(double d2, double d3, int i) {
        double d4 = d2 + d3;
        double d5 = d4 / 1236.85d;
        double d6 = d5 * d5;
        double d7 = d6 * d5;
        double m = ((((29.53058868d * d4) + 2415020.75933d) + (1.178E-4d * d6)) - (1.55E-7d * d7)) + (m(((132.87d * d5) + 166.56d) - (0.009173d * d6)) * 3.3E-4d);
        double d8 = (((29.10535608d * d4) + 359.2242d) - (3.33E-5d * d6)) - (3.47E-6d * d7);
        double d9 = (385.81691806d * d4) + 306.0253d + (0.0107306d * d6) + (1.236E-5d * d7);
        double d10 = (((d4 * 390.67050646d) + 21.2964d) - (d6 * 0.0016528d)) - (d7 * 2.39E-6d);
        if (d3 < 0.01d || java.lang.Math.abs(d3 - 0.5d) < 0.01d) {
            double m2 = (((0.1734d - (d5 * 3.93E-4d)) * m(d8)) + (m(d8 * 2.0d) * 0.0021d)) - (m(d9) * 0.4068d);
            double d11 = d9 * 2.0d;
            double d12 = d10 * 2.0d;
            m += ((((((((m2 + (m(d11) * 0.0161d)) - (m(3.0d * d9) * 4.0E-4d)) + (m(d12) * 0.0104d)) - (m(d8 + d9) * 0.0051d)) - (m(d8 - d9) * 0.0074d)) + (m(d12 + d8) * 4.0E-4d)) - (m(d12 - d8) * 4.0E-4d)) - (m(d12 + d9) * 6.0E-4d)) + (m(d12 - d9) * 0.001d) + (m(d8 + d11) * 5.0E-4d);
        } else if (java.lang.Math.abs(d3 - 0.25d) < 0.01d || java.lang.Math.abs(d3 - 0.75d) < 0.01d) {
            double m3 = (0.1721d - (d5 * 4.0E-4d)) * m(d8);
            double d13 = d8 * 2.0d;
            double d14 = d9 * 2.0d;
            double d15 = d10 * 2.0d;
            double m4 = m + ((((((((((((((m3 + (m(d13) * 0.0021d)) - (m(d9) * 0.628d)) + (m(d14) * 0.0089d)) - (m(3.0d * d9) * 4.0E-4d)) + (m(d15) * 0.0079d)) - (m(d8 + d9) * 0.0119d)) - (m(d8 - d9) * 0.0047d)) + (m(d15 + d8) * 3.0E-4d)) - (m(d15 - d8) * 4.0E-4d)) - (m(d15 + d9) * 6.0E-4d)) + (m(d15 - d9) * 0.0021d)) + (m(d8 + d14) * 3.0E-4d)) + (m(d8 - d14) * 4.0E-4d)) - (m(d13 + d9) * 3.0E-4d));
            m = d3 < 0.5d ? m4 + (0.0028d - (l(d8) * 4.0E-4d)) + (l(d9) * 3.0E-4d) : m4 + (((l(d8) * 4.0E-4d) - 0.0028d) - (l(d9) * 3.0E-4d));
        }
        return m - (i / 86400.0d);
    }

    public com.planit.ephemeris.SolarData calculate(com.planit.ephemeris.LatLng latLng, java.util.Calendar calendar) {
        if (calendar == null || latLng == null) {
            return null;
        }
        return f(latLng.latitude, latLng.longitude, calendar, 65535);
    }

    public final com.planit.ephemeris.SolarData e(double d2, double d3, int i, int i2, int i3, int i4, int i5, int i6, double d4, int i7, int i8) {
        com.planit.ephemeris.Moon.SolarData solarData = new com.planit.ephemeris.Moon.SolarData();
        solarData.sunData = new com.planit.ephemeris.Sun.SunData();
        solarData.moonData = new com.planit.ephemeris.Moon.MoonData();
        com.planit.ephemeris.Sun.SunData sunData = solarData.sunData;
        sunData.year = i;
        sunData.month = i2;
        sunData.day = i3;
        sunData.hour = i4;
        sunData.minute = i5;
        sunData.second = i6;
        sunData.timezone = d4 + i7;
        sunData.latitude = d2;
        sunData.longitude = d3;
        sunData.elevation = 0.0d;
        sunData.delta_ut1 = 0.0d;
        sunData.delta_t = 67.0d;
        sunData.pressure = 1013.25d;
        sunData.temperature = 11.0d;
        sunData.slope = 30.0d;
        sunData.azm_rotation = -10.0d;
        sunData.atmos_refract = 0.5667d;
        boolean z = (i8 & 64) != 0;
        boolean z2 = (i8 & 256) != 0;
        sunData.function = z ? com.planit.ephemeris.Sun.Params.SUN_PARAM_ZA_RTS : com.planit.ephemeris.Sun.Params.SUN_PARAM_ZA;
        solarData.function = com.planit.ephemeris.Moon.Params.MOON_PARAM_NO_IRR;
        double[] a = this.a.a(solarData);
        if (a == null || a.length <= 1) {
            return new com.planit.ephemeris.SolarData(0.0d, 0.0d);
        }
        double d5 = (i8 & 32) != 0 ? a[7] : 0.0d;
        com.planit.ephemeris.SolarData solarData2 = z ? new com.planit.ephemeris.SolarData(a[0], a[1], a[8], a[9], a[2], a[3], d5) : new com.planit.ephemeris.SolarData(a[0], a[1], a[2], a[3], d5);
        solarData2.sun_disk_radius = a[4];
        solarData2.moon_disk_radius = a[5];
        solarData2.sun_disk_ratio = a[12];
        solarData2.moon_disk_ratio = a[13];
        solarData2.moon_rotation = a[14];
        if (z2) {
            solarData2.moon_distance = a[6];
        }
        return solarData2;
    }

    public final com.planit.ephemeris.SolarData f(double d2, double d3, java.util.Calendar calendar, int i) {
        return e(d2, d3, calendar.get(1), calendar.get(2) + 1, calendar.get(5), calendar.get(11), calendar.get(12), calendar.get(13), q(calendar), o(calendar), i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x00c4, code lost:
    
        if (r6[r23] >= r13) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00ea, code lost:
    
        if (r6[r11] < r13) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public double g(double d2, double d3, int i, int i2, int i3, double d4, int i4, boolean z, double d5) {
        int i5;
        int i6;
        double d6;
        int i7;
        int i8;
        double d7;
        int i9;
        int i10;
        int i11;
        double[] dArr = new double[25];
        boolean[] zArr = new boolean[25];
        double d8 = e(d2, d3, i, i2, i3, 0, 0, 0, d4, i4, 8).moon_elevation;
        dArr[0] = d8;
        zArr[0] = true;
        double d9 = d8 >= d5 ? d : c;
        dArr[24] = e(d2, d3, i, i2, i3, 24, 0, 0, d4, i4, 8).moon_elevation;
        zArr[24] = true;
        int i12 = 24;
        boolean z2 = false;
        int i13 = 0;
        while (true) {
            int i14 = i12 - i13;
            if (i14 <= 1) {
                i5 = i14;
                i6 = i12;
                d6 = d5;
                break;
            }
            int round = i13 + java.lang.Math.round(i14 / 2);
            if (zArr[round]) {
                i5 = i14;
                i11 = i12;
            } else {
                i5 = i14;
                i11 = i12;
                dArr[round] = e(d2, d3, i, i2, i3, round, 0, 0, d4, i4, 8).moon_elevation;
                zArr[round] = true;
            }
            if (z) {
                d6 = d5;
                if (dArr[i13] <= d6) {
                }
            } else {
                d6 = d5;
            }
            if (z || dArr[i13] < d6 || dArr[round] > d6) {
                if (!z || dArr[round] > d6) {
                    i6 = i11;
                } else {
                    i6 = i11;
                }
                if (z) {
                    break;
                }
                if (dArr[round] < d6) {
                    break;
                }
                if (dArr[i6] > d6) {
                    break;
                }
                i12 = i6;
                i13 = round;
                z2 = true;
            }
            i12 = round;
            z2 = true;
        }
        if (!z2 && i5 > 1) {
            int i15 = i13;
            while (i15 < i6) {
                int i16 = i15 + 1;
                if (zArr[i16]) {
                    i9 = i6;
                    i10 = i15;
                } else {
                    i9 = i6;
                    i10 = i15;
                    dArr[i16] = e(d2, d3, i, i2, i3, i16, 0, 0, d4, i4, 8).moon_elevation;
                    zArr[i16] = true;
                }
                if (z) {
                    d6 = d5;
                    if (dArr[i10] <= d6 && dArr[i16] >= d6) {
                        i8 = i16;
                        i7 = i10;
                        z2 = true;
                        break;
                    }
                } else {
                    d6 = d5;
                }
                if (!z && dArr[i10] >= d6 && dArr[i16] <= d6) {
                    i8 = i16;
                    i7 = i10;
                    z2 = true;
                    break;
                }
                i15 = i16;
                i6 = i9;
                z2 = false;
            }
        }
        int i17 = i6;
        i7 = i13;
        i8 = i17;
        if (!z2) {
            return d9;
        }
        if (java.lang.Math.abs(dArr[i7] - d6) < 0.0040472d) {
            d7 = i7;
        } else {
            if (java.lang.Math.abs(dArr[i8] - d6) >= 0.0040472d) {
                double d10 = i7;
                int i18 = i7;
                com.planit.ephemeris.SolarUtils.AnonymousClass1 anonymousClass1 = new com.planit.ephemeris.SolarUtils.AnonymousClass1(d2, d3, i, i2, i3, d10, d4, i4);
                int b2 = b(anonymousClass1, 0, dArr[i18], com.anythink.expressad.d.a.b.ck, dArr[i8], d5, z);
                if (java.lang.Math.abs(b2) > 3600) {
                    java.io.PrintStream printStream = java.lang.System.out;
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append("The binarySearch returns the wrong result \n");
                    sb.append(d2);
                    sb.append(", ");
                    sb.append(d3);
                    sb.append(" on ");
                    sb.append(i);
                    sb.append(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR);
                    sb.append(i2);
                    sb.append(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR);
                    sb.append(i3);
                    sb.append(" ");
                    sb.append(d5);
                    sb.append(z ? " rise" : " set");
                    sb.append("\n");
                    sb.append(b2);
                    sb.append(" [");
                    sb.append(i18);
                    sb.append(" - ");
                    sb.append(i8);
                    sb.append("] elh: [");
                    sb.append(dArr[i18]);
                    sb.append(" - ");
                    sb.append(dArr[i8]);
                    sb.append("]");
                    printStream.println(sb.toString());
                    b2 = com.anythink.expressad.d.a.b.ck;
                } else {
                    int i19 = i8;
                    if (b2 < 0) {
                        java.io.PrintStream printStream2 = java.lang.System.out;
                        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                        sb2.append("The binarySearch cannot find an exact result \n");
                        sb2.append(d2);
                        sb2.append(", ");
                        sb2.append(d3);
                        sb2.append(" on ");
                        sb2.append(i);
                        sb2.append(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR);
                        sb2.append(i2);
                        sb2.append(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR);
                        sb2.append(i3);
                        sb2.append(" ");
                        sb2.append(d5);
                        sb2.append(z ? " rise" : " set");
                        sb2.append("\n");
                        sb2.append(b2);
                        sb2.append(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER);
                        sb2.append(anonymousClass1.get(b2));
                        sb2.append(" [");
                        sb2.append(i18);
                        sb2.append(" - ");
                        sb2.append(i19);
                        sb2.append("] elh: [");
                        sb2.append(dArr[i18]);
                        sb2.append(" - ");
                        sb2.append(dArr[i19]);
                        sb2.append("]");
                        printStream2.println(sb2.toString());
                    }
                }
                if (b2 >= 0 && b2 <= 3600) {
                    return (d10 + (b2 / 3600.0d)) / 24.0d;
                }
                return c;
            }
            d7 = i8;
        }
        return d7 / 24.0d;
    }

    public java.util.Calendar h(double d2, double d3, java.util.Calendar calendar, boolean z, double d4) {
        return j(calendar, g(d2, d3, calendar.get(1), calendar.get(2) + 1, calendar.get(5), q(calendar), o(calendar), z, d4));
    }

    public java.util.Calendar moonrise(com.planit.ephemeris.LatLng latLng, java.util.Calendar calendar) {
        return h(latLng.latitude, latLng.longitude, calendar, true, 0.0d);
    }

    public java.util.Calendar moonset(com.planit.ephemeris.LatLng latLng, java.util.Calendar calendar) {
        return h(latLng.latitude, latLng.longitude, calendar, false, 0.0d);
    }
}
