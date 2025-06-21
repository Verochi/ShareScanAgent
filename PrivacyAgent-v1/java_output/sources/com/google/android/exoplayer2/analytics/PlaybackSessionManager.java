package com.google.android.exoplayer2.analytics;

/* loaded from: classes22.dex */
public interface PlaybackSessionManager {

    public interface Listener {
        void onAdPlaybackStarted(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, java.lang.String str, java.lang.String str2);

        void onSessionActive(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, java.lang.String str);

        void onSessionCreated(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, java.lang.String str);

        void onSessionFinished(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, java.lang.String str, boolean z);
    }

    boolean belongsToSession(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, java.lang.String str);

    void finishAllSessions(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime);

    java.lang.String getSessionForMediaPeriodId(com.google.android.exoplayer2.Timeline timeline, com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId);

    void setListener(com.google.android.exoplayer2.analytics.PlaybackSessionManager.Listener listener);

    void updateSessions(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime);

    void updateSessionsWithDiscontinuity(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, int i);

    void updateSessionsWithTimelineChange(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime);
}
