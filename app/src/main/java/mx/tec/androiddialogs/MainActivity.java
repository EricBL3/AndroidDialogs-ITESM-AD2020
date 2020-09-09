package mx.tec.androiddialogs;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = getApplicationContext();

        final Toast myToast = new Toast(context);
        Toast.makeText(context, "I'm a toast", Toast.LENGTH_SHORT).show();

        AlertDialog.Builder dialogConf = new AlertDialog.Builder(this);
        dialogConf.setTitle("Hi Dialog");
        dialogConf.setMessage("Are you sure?");
        dialogConf.setNeutralButton("Close",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int id) {
                        Toast.makeText(context, "You Clicked Cancel", Toast.LENGTH_SHORT).show();
                    }
                });
        dialogConf.setPositiveButton("Yes",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int id) {
                        Toast.makeText(context, "You Clicked Yes", Toast.LENGTH_SHORT).show();
                    }
                });
        dialogConf.setNegativeButton("No",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int id) {
                        Toast.makeText(context, "You Clicked No", Toast.LENGTH_SHORT).show();
                    }
                });
        AlertDialog myDialog = dialogConf.create();
        myDialog.show();

        int NOTIF_ID = 1234;
        Notification.Builder notifBuilder = new Notification.Builder(this);
        notifBuilder.setSmallIcon(R.mipmap.ic_launcher);
        notifBuilder.setContentTitle("This is my shiny notification");
        notifBuilder.setContentText("This is the detail of the notification");

        Intent notificationIntent = new Intent(this, ChildActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(context, 0, notificationIntent, 0);

        notifBuilder.setContentIntent(contentIntent);

        NotificationManager myNotification = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        myNotification.notify(NOTIF_ID, notifBuilder.build());


    }
}