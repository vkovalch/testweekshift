package net.vlad.testweekshift;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import net.vlad.testweekshift.dummy.DummyContentV;
import net.vlad.testweekshift.model.DayModel;


public class MainActivity extends AppCompatActivity implements BlankFragment.OnFragmentInteractionListener, HItemFragment.OnListFragmentInteractionListener, ItemFragment.OnListFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        android.support.v4.app.FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.fl1, BlankFragment.newInstance("",""));
        ft.commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onListFragmentInteraction(DummyContentV.DummyItem item) {

    }

    @Override
    public void onListFragmentInteraction(DayModel item) {
        Toast.makeText(getApplicationContext(), "Select date:"+item.getFdate().toString("dd/MM/yyyy"), Toast.LENGTH_SHORT).show();

    }
}
