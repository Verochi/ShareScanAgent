package androidx.core.app;

/* loaded from: classes.dex */
public final class AlarmManagerCompat {
    private AlarmManagerCompat() {
    }

    public static void setAlarmClock(@androidx.annotation.NonNull android.app.AlarmManager alarmManager, long j, @androidx.annotation.NonNull android.app.PendingIntent pendingIntent, @androidx.annotation.NonNull android.app.PendingIntent pendingIntent2) {
        alarmManager.setAlarmClock(new android.app.AlarmManager.AlarmClockInfo(j, pendingIntent), pendingIntent2);
    }

    public static void setAndAllowWhileIdle(@androidx.annotation.NonNull android.app.AlarmManager alarmManager, int i, long j, @androidx.annotation.NonNull android.app.PendingIntent pendingIntent) {
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            alarmManager.setAndAllowWhileIdle(i, j, pendingIntent);
        } else {
            alarmManager.set(i, j, pendingIntent);
        }
    }

    public static void setExact(@androidx.annotation.NonNull android.app.AlarmManager alarmManager, int i, long j, @androidx.annotation.NonNull android.app.PendingIntent pendingIntent) {
        alarmManager.setExact(i, j, pendingIntent);
    }

    public static void setExactAndAllowWhileIdle(@androidx.annotation.NonNull android.app.AlarmManager alarmManager, int i, long j, @androidx.annotation.NonNull android.app.PendingIntent pendingIntent) {
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            alarmManager.setExactAndAllowWhileIdle(i, j, pendingIntent);
        } else {
            setExact(alarmManager, i, j, pendingIntent);
        }
    }
}
