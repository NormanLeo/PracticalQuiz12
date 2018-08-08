package sg.edu.rp.c346.practicalquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    Spinner spnWeb;
    WebView wvShow;
    ArrayList<String> alWebsite;
    ArrayAdapter<String> aaWebsite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spnWeb = findViewById(R.id.spinnerWebsite);
        wvShow = findViewById(R.id.webViewShow);
        alWebsite = new ArrayList<>();
        aaWebsite = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, alWebsite);
        spnWeb.setAdapter(aaWebsite);
        String[] web = getResources().getStringArray(R.array.website);
        alWebsite.addAll(Arrays.asList(web));

        wvShow.setWebViewClient(new WebViewClient());
        wvShow.getSettings().setJavaScriptEnabled(true);
        wvShow.getSettings().setAllowFileAccess(false);
        wvShow.getSettings().setBuiltInZoomControls(true);

        spnWeb.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
                switch (i){
                    case 0:
                        wvShow.loadUrl("https://www.facebook.com/");
                        break;
                    case 1:
                        wvShow.loadUrl("https://twitter.com/?lang=en");
                        break;
                }
                aaWebsite.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
