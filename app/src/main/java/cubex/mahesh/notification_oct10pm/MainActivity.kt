package cubex.mahesh.notification_oct10pm

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Vibrator
import android.support.v4.app.NotificationCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        notify.setOnClickListener {

         var nManager =   getSystemService(
                 Context.NOTIFICATION_SERVICE) as NotificationManager
         var nCompact = NotificationCompat.Builder(this@MainActivity)
         nCompact.setTicker("Sample Notification")
         nCompact.setSmallIcon(R.drawable.ic_beach_access_black_24dp)
         nCompact.setContentTitle("Sample Notification for Demo")
         nCompact.setContentText("sample notification for demo @OCT-10 PM")
         nCompact.setAutoCancel(true)
         var intent = Intent(this@MainActivity,
                                                    MainActivity::class.java)
         var pIntent = PendingIntent.getActivity(this@MainActivity,
                 0,intent,0)
         nCompact.setContentIntent(pIntent)
         nManager.notify(++count,nCompact.build())
        }

        vibrate.setOnClickListener {

            var vib = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
            vib.vibrate(10000)
        }

    }
}
