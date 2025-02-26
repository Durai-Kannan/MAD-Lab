import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
  EditText heightEditText, weightEditText;
  Button calculateButton;
  TextView resultTextView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    heightEditText = (EditText) findViewById(R.id.heightEditText);
    weightEditText = (EditText) findViewById(R.id.weightEditText);
    calculateButton = (Button) findViewById(R.id.calculateButton);
    resultTextView = (TextView) findViewById(R.id.resultTextView);

    calculateButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        // Get height and weight input
        String heightStr = heightEditText.getText().toString();
        String weightStr = weightEditText.getText().toString();

        if (heightStr.isEmpty() || weightStr.isEmpty()) {
          Toast.makeText(MainActivity.this, "Please enter both height and weight", Toast.LENGTH_SHORT).show();
          return;
        }

        try {
          // Parse input values
          double height = Double.parseDouble(heightStr);
          double weight = Double.parseDouble(weightStr);

          // BMI calculation
          double bmi = weight / (height * height);

          // Categorize the BMI result
          String bmiCategory;
          if (bmi < 18.5) {
            bmiCategory = "Underweight";
          } else if (bmi >= 18.5 && bmi < 24.9) {
            bmiCategory = "Normal weight";
          } else if (bmi >= 25 && bmi < 29.9) {
            bmiCategory = "Overweight";
          } else {
            bmiCategory = "Obesity";
          }

          // Show the result
          resultTextView.setText("BMI: " + String.format("%.2f", bmi) + "\nCategory: " + bmiCategory);

        } catch (NumberFormatException e) {
          Toast.makeText(MainActivity.this, "Invalid input", Toast.LENGTH_SHORT).show();
        }
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
