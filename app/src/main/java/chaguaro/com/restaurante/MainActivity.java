package chaguaro.com.restaurante;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static int INICIO=0;
    public static int MEDICAMENTOS=1;
    public static int SUPLEMENTOS=2;
    public static int HOGAR=3;
    public static int NATURISTAS=4;


    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    //ir al home
                    cargarFragment(new HomeFragment());

                    return true;
                case R.id.navigation_medicamentos:
                    mTextMessage.setText(R.string.title_medicamentos);
                    //cargar menu de entradas

                    MenuFragment menuMed=new MenuFragment();
                    menuMed.cargaItems(MEDICAMENTOS);
                    cargarFragment(menuMed);

                    return true;
                case R.id.navigation_suplementos:
                    mTextMessage.setText(R.string.title_suplementos);
                    //cargar menu de carnes

                    MenuFragment menuSlu=new MenuFragment();
                    menuSlu.cargaItems(SUPLEMENTOS);
                    cargarFragment(menuSlu);

                    return true;
                case R.id.navigation_hogar:
                    mTextMessage.setText(R.string.title_hogar);
                    //cargar menu de bebidas

                    MenuFragment menuHog=new MenuFragment();
                    menuHog.cargaItems(HOGAR);
                    cargarFragment(menuHog);

                    return true;
                case R.id.navigation_naturistas:
                    mTextMessage.setText(R.string.title_naturistas);
                    //cargar menu de postres

                    MenuFragment menuNat=new MenuFragment();
                    menuNat.cargaItems(NATURISTAS);
                    cargarFragment(menuNat);

                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.titulo);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


    }

    public void cargarFragment(Fragment fragment) {
        try {

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            Fragment fragmentContainer = getSupportFragmentManager().findFragmentById(R.id.fragmentContenido);
            fragmentContainer.onDetach();

            Fragment oldFragment = getSupportFragmentManager().findFragmentByTag("tag");
            if(oldFragment != null)
                transaction.remove(oldFragment);

            transaction.replace(R.id.fragmentContenido, fragment, "tag");
            transaction.addToBackStack(null);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
