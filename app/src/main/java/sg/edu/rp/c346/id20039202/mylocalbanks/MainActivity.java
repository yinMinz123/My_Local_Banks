package sg.edu.rp.c346.id20039202.mylocalbanks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tvDBS, tvOCBC, tvUOB;
    String selected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDBS = findViewById(R.id.textViewDBS);
        registerForContextMenu(tvDBS);              //registering tvDBS to context menu
        tvOCBC = findViewById(R.id.textViewOCBC);
        registerForContextMenu(tvOCBC);
        tvUOB = findViewById(R.id.textViewUOB);
        registerForContextMenu(tvUOB);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        //creating context menu
        menu.add(0, 0, 0, "Website");
        menu.add(0, 1, 1, "Contact the bank");
        menu.add(0,2,2,"Toggle Favourite");



        if (v == tvDBS) {
            selected = "DBS";
        } else if (v == tvOCBC) {
            selected = "OCBC";
        } else if (v == tvUOB) {
            selected = "UOB";
        }


    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == 0) {
            Toast.makeText(MainActivity.this, "Website Selected", Toast.LENGTH_LONG).show();
            if (selected.equalsIgnoreCase("DBS")) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
                startActivity(i);
            } else if (selected.equalsIgnoreCase("OCBC")) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
                startActivity(i);
            } else if (selected.equalsIgnoreCase("UOB")) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
                startActivity(i);
            }

        } else if (item.getItemId() == 1) {
            Toast.makeText(MainActivity.this, "Contact Selected", Toast.LENGTH_LONG).show();
            if (selected.equalsIgnoreCase("DBS")) {
                Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "18001111111"));
                startActivity(i);
            } else if (selected.equalsIgnoreCase("OCBC")) {
                Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "18003633333"));
                startActivity(i);
            } else if (selected.equalsIgnoreCase("UOB")) {
                Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "18002222121"));
                startActivity(i);
            }
        } else if(item.getItemId() == 2) {
            if (selected.equalsIgnoreCase("DBS")){
                if(tvDBS.getCurrentTextColor() == Color.RED){
                    tvDBS.setTextColor(Color.BLACK);
                }else{
                    tvDBS.setTextColor(Color.RED);
                }
            }else if (selected.equalsIgnoreCase("OCBC")){
                if(tvOCBC.getCurrentTextColor() == Color.RED){
                    tvOCBC.setTextColor(Color.BLACK);
                }else{
                    tvOCBC.setTextColor(Color.RED);
                }
            }else if (selected.equalsIgnoreCase("UOB")){
                if(tvUOB.getCurrentTextColor() == Color.RED){
                    tvUOB.setTextColor(Color.BLACK);
                }else{
                    tvUOB.setTextColor(Color.RED);
                }
            }
        }

        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.englishSelection){
            tvDBS.setText("DBS");
            tvOCBC.setText("OCBC");
            tvUOB.setText("UOB");

        }else if(item.getItemId() == R.id.chineseSelection){
            tvDBS.setText("星展银行");
            tvOCBC.setText("华侨银行");
            tvUOB.setText("大华银行");
        }
        return super.onOptionsItemSelected(item);
    }
}






