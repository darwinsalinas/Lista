package com.example.root.lista;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemLongClickListener {

    final List<String> items = new ArrayList<>();
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView lista = (ListView) findViewById(R.id.lista);

        items.add("Oreo");
        items.add("MarsMellows1");
        items.add("MarsMellows2");
        items.add("MarsMellows3");
        items.add("MarsMellows4");
        items.add("MarsMellows5");
        items.add("MarsMellows6");
        items.add("Nugat11");
        items.add("Nugat2");
        items.add("Nugat3");
        items.add("Nugat4");
        items.add("Nugat5");
        items.add("Nugat6");
        items.add("Nugat7");
        items.add("Nugat8");
        items.add("Nugat9");
        items.add("Froyo10");
        items.add("Froyo11");
        items.add("Froyo12");
        items.add("Froyo13");
        items.add("Froyo14");
        items.add("Froyo15");
        items.add("Froyo16");
        items.add("Froyo17");
        items.add("Froyo18");

        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, items);

        lista.setAdapter(adapter);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "presiono el item #" + items.get(position), Toast.LENGTH_SHORT).show();
            }
        });

        lista.setOnItemLongClickListener(this);

        SearchView tvBuscar = (SearchView) findViewById(R.id.searchView);
        tvBuscar.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                adapter.notifyDataSetChanged();
                return false;
            }
        });

    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

        items.remove(position);
        adapter.notifyDataSetChanged();

        return false;
    }

    public void storeItem(View view) {

        EditText text = (EditText)findViewById(R.id.etTextItem);

        items.add(0, text.getText().toString());
        adapter.notifyDataSetChanged();
        text.setText("");
    }
}
