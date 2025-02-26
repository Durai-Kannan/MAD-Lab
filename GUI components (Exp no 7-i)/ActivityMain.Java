import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
public class MainActivity extends Activity {
  Button b1, b2;
  TextView t1;
  float font;
  int i = 1;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    b1 = (Button) findViewById(R.id.button1);
    t1 = (TextView) findViewById(R.id.textView1);
    b1.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View arg0) {
        // TODO Auto-generated method stub
        t1.setTextSize(font);
        font = font + 4;
        if (font == 40)
          font = 20;
      }
    });
    b2 = (Button) findViewById(R.id.button2);
    b2.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        // TODO Auto-generated method stub
        switch (i) {
        case 1:
          t1.setTextColor(Color.parseColor("#0000FF"));
          break;
        case 2:
          t1.setTextColor(Color.parseColor("#00FF00"));
          break;
        case 3:
          t1.setTextColor(Color.parseColor("#FF0000"));
          break;
        default:
          t1.setTextColor(Color.parseColor("#800000"));
          break;
        }
        i++;
        if (i == 5)
          i = 1;
      }
    });
  }
  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.main, menu);
    return true;
  }
}
