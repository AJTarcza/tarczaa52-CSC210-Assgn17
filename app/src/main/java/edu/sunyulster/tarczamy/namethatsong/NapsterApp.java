package edu.sunyulster.tarczamy.namethatsong;

import android.app.Application;

import com.napster.cedar.Napster;
import com.napster.cedar.internal.AppInfo;
import com.napster.cedar.player.PlaybackFormat;
import com.napster.cedar.player.PlaybackState;
import com.napster.cedar.player.Player;
import com.napster.cedar.player.PlayerStateListener;
import com.napster.cedar.player.data.Track;
import com.napster.cedar.player.notification.AbstractNotificationProperties;
import com.napster.cedar.player.notification.NotificationActionListener;
import com.napster.cedar.session.SessionManager;

public abstract class NapsterApp extends Application implements NotificationActionListener {
    protected Napster napster;
    protected Player player;
    protected SessionManager sessionManager;

    @Override
    public void onCreate() {
        super.onCreate();

        try {
            napster = Napster.register(this, getApiKey(), getSecret());
            player = new Player() {
                @Override
                public void addStateListener(PlayerStateListener playerStateListener) {

                }

                @Override
                public void removeStateListener(PlayerStateListener playerStateListener) {

                }

                @Override
                public void registerNotificationActionListener(NotificationActionListener notificationActionListener) {

                }

                @Override
                public void setNotificationProperties(AbstractNotificationProperties abstractNotificationProperties) {

                }

                @Override
                public void enableDefaultAudioFocusChangeListener(boolean b) {

                }

                @Override
                public void stop() {
                    player.stop();
                }

                @Override
                public void pause() {
                    player.pause();
                }

                @Override
                public void resume() {
                    player.resume();
                }

                @Override
                public void togglePause() {
                    player.togglePause();
                }

                @Override
                public Track getCurrentTrack() {
                    return null;
                }

                @Override
                public int getPlayheadPosition() {
                    return 0;
                }

                @Override
                public int getCurrentTrackDuration() {
                    return 0;
                }

                @Override
                public PlaybackState getPlaybackState() {
                    return null;
                }

                @Override
                public boolean isPlaying() {
                    return false;
                }

                @Override
                public void seek(int i, boolean b) {

                }

                @Override
                public void play(Track track) {
                    player.play(track);
                }

                @Override
                public void play(Track track, String s) {
                    player.play(track, s);
                }

                @Override
                public void setDesiredPlaybackFormat(PlaybackFormat playbackFormat) {

                }
            };
        }

        catch (IllegalStateException e) {
            return;
        }

        player = napster.getPlayer();
        player.registerNotificationActionListener(this);
        sessionManager = napster.getSessionManager();
    }

    public Napster getNapster() {
        return napster;
    }

    public String getApiKey() {
        return "OTM4Nzg2NjMtZmM1Ni00ZDk0LWFkOGMtMDU3MjdiZjZmMjhk";
    }

    public String getSecret() {
        return "MjA0YWFjOWEtMzM1Yy00ZjY2LWExNzktMjQ5YjMxY2I4YzNl" ;
    }

    public String getRedirectUrl() {
        return "Name That Song App";
    }

    public Player getPlayer() {
        return player;
    }

    public SessionManager getSessionManager() {
        return sessionManager;
    }

    public abstract AppInfo getAppInfo();

}
