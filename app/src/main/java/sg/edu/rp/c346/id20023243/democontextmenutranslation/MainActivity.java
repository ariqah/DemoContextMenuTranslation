package sg.edu.rp.c346.id20023243.democontextmenutranslation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvTranslatedText, tvTranslatedText2;
    String wordClicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //to register for context menu
        tvTranslatedText = findViewById(R.id.textViewTranslatedText);
        registerForContextMenu(tvTranslatedText);

        tvTranslatedText2 = findViewById(R.id.textViewTranslatedText2);
        registerForContextMenu(tvTranslatedText2);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0, 0, 3, "English"); //group_id (to change all elements in this group to x)
        menu.add(0, 1, 1, "Italian"); //the smaller order number appear first

        if (v == tvTranslatedText) {
            wordClicked = "Hello";
        }
        else if (v == tvTranslatedText2) {
            wordClicked = "Bye";
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == 0) {
            Toast.makeText(MainActivity.this, "English Selected", Toast.LENGTH_LONG).show();

            if (wordClicked.equalsIgnoreCase("hello")) {
                tvTranslatedText.setText("Hello");
            }
            else if (wordClicked.equalsIgnoreCase("bye")) {
                tvTranslatedText2.setText("Bye");
            }
            return true; //menu item successfully handled
        }

        else if (item.getItemId() == 1) {
            Toast.makeText(MainActivity.this, "Italian Selected", Toast.LENGTH_LONG).show();
            if (wordClicked.equalsIgnoreCase("hello")) {
                tvTranslatedText.setText("Ciao");
            } else if (wordClicked.equalsIgnoreCase("bye")) {
                tvTranslatedText2.setText("Addio");
            }
            return true; //menu item successfully handled
        }

        return super.onContextItemSelected(item);
    }
}