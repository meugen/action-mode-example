package def.meugeninua.defaultandroid.ui.activities.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import def.meugeninua.defaultandroid.R;
import def.meugeninua.defaultandroid.ui.activities.base.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
