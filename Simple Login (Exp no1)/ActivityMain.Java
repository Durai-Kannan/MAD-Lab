import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class MainActivity extends Activity {
    private EditText ed1, ed2;
    private Button bu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1 = (EditText) findViewById(R.id.ed1);
        ed2 = (EditText) findViewById(R.id.ed2);
        bu = (Button) findViewById(R.id.bu);
        bu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = ed1.getText().toString();
                String b = ed2.getText().toString();
                if (a.equals("Welcome") && b.equals("abcd")) {
                    Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Invalid User", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    @Override
    protected void onResume() {
        super.onResume();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
