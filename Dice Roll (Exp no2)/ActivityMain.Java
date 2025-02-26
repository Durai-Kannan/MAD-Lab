import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import java.util.Random;

public class MainActivity extends Activity {
    public static final Random RANDOM = new Random();
    private Button rollDices;
    private ImageView imageView1, imageView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rollDices = (Button) findViewById(R.id.rollDices);
        imageView1 = (ImageView) findViewById(R.id.imageView1);
        imageView2 = (ImageView) findViewById(R.id.imageView2);

        rollDices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rollDice();
            }
        });
    }

    private void rollDice() {
        int value1 = randomDiceValue();
        int value2 = randomDiceValue();
        int res1 = getResources().getIdentifier("dice_" + value1, "drawable", getPackageName());
        int res2 = getResources().getIdentifier("dice_" + value2, "drawable", getPackageName());
        imageView1.setImageResource(res1);
        imageView2.setImageResource(res2);
    }

    public static int randomDiceValue() {
        return RANDOM.nextInt(6) +1;
    }
}
