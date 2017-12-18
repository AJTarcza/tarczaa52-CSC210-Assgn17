package edu.sunyulster.tarczamy.namethatsong;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.EditText;
import com.napster.cedar.Napster;
import com.napster.cedar.internal.AppInfo;
import com.napster.cedar.player.Player;
import com.napster.cedar.player.data.Track;
import com.napster.cedar.player.data.Track.Format;
import com.napster.cedar.player.notification.NotificationAction;
import com.napster.cedar.session.SessionManager;
import java.util.LinkedList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private Napster napster;
    private SessionManager sessionManager;

    AppInfo appInfo;
    NapsterApp app;
    Player player;

    EditText songTitle;
    EditText songArtist;
    EditText album;
    ImageButton playButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        songTitle = (EditText) findViewById(R.id.name);
        songArtist = (EditText) findViewById(R.id.artist);
        album = (EditText) findViewById(R.id.album);
        playButton = (ImageButton) findViewById(R.id.playButton);

        //final String[][] list = new String[20][];
        //final Uri.Builder builder = new Uri.Builder();

        app = new NapsterApp() {
            @Override
            public AppInfo getAppInfo() {
                return null;
            }

            @Override
            public void onNotificationAction(NotificationAction notificationAction) {

            }
        };

        napster = app.getNapster();
        appInfo = app.getAppInfo();
        sessionManager = app.getSessionManager();
        player = app.getPlayer();

        playButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //When the button is clicked
                final int DURATION = 30;

                List<Format> formats = new LinkedList<Format>();
                Format format1 = new Format(320, "AAC");
                Format format2 = new Format(192, "AAC");
                Format format3 = new Format(64, "AAC PLUS");

                formats.add(format1);
                formats.add(format2);
                formats.add(format3);

                if (player != null) {
                    player.play(new Track("track", "tra.5156528", "Say It Ain't So", "Weezer", "Weezer (Blue Album) (Deluxe Edition)", formats, "alb.5153820", null, "http://listen.vo.llnwd.net/g2/4/2/4/9/8/911189424.mp3", DURATION));
                }

                //int offset = (int) (8900000 * (Math.random()));
            }
        });

    }
}





