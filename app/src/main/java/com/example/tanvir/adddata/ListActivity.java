package com.example.tanvir.adddata;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ListActivity extends AppCompatActivity {
    EditText editTextInput;
    Button buttonAdd;
    ListView listView;

    ArrayList<Item> arrayList;
    BaseAdapter baseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        //finding all UI tools
        editTextInput=findViewById(R.id.EditTextWishXmlId);
        buttonAdd=findViewById(R.id.ButtonAddXmlId);
        listView=findViewById(R.id.ListViewXmlId);

        arrayList=new ArrayList<Item>();
        //adapter for connecting listView
        baseAdapter = new BaseAdapter() {

            //LayoutInflator for creating view to listView
            LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            @Override
            public int getCount() {
                return arrayList.size();
            }

            @Override
            public Object getItem(int position) {
                return arrayList.get(position);
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }

            @Override
            public View getView(int position, View view, ViewGroup viewGroup) {
                if(view==null){ //if our view is null then we create a new view
                    view=inflater.inflate(R.layout.listshape,null);
                }

                //finding listView properties
                TextView textViewList = view.findViewById(R.id.TextViewWishXmlId);
                TextView textViewDateList = view.findViewById(R.id.TextViewDateXmlId);

                //setting Wish and date on TextView
                textViewList.setText(arrayList.get(position).getWishString());
                Date d = arrayList.get(position).getDate();
                textViewDateList.setText(android.text.format.DateFormat.format("dd/MM/yyyy HH:mm:ss a",d));

                return view;
            }
        };

        //setting listview   with adapter
        listView.setAdapter(baseAdapter);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String wish = editTextInput.getText().toString();
                Date date = new Date();

                Item item = new Item(wish,date);
                arrayList.add(item);

                baseAdapter.notifyDataSetChanged(); //Knocking adapter for modifying adapter

                editTextInput.setText("");

                InputMethodManager inputMethodManager= (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);//hiding keyboard to show output
                inputMethodManager.hideSoftInputFromWindow(editTextInput.getWindowToken(),0);

                Toast.makeText(getBaseContext(),"New Wish added",Toast.LENGTH_SHORT).show();
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                arrayList.remove(i);
                baseAdapter.notifyDataSetChanged();

                Toast.makeText(getBaseContext(),"Wish removed",Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }
}
