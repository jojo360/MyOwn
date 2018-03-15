package fr.digitecgame.myown;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView T,G;
    private EditText E1,E2,E3;
    private ImageView B,BM;
    private ListView L;

    private Module m1=new Module("Application Mobile",0);
    private Module m2=new Module("Infographie",0);
    private Module m3=new Module("Base de données",0);
    private Module m4=new Module("Sécurité et Cryptographie",0);
    private Module m5=new Module("Rédaction Scientifique",0);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        E1=(EditText)findViewById(R.id.A);
        E2=(EditText)findViewById(R.id.B);
        E3=(EditText)findViewById(R.id.C);
        B=(ImageView) findViewById(R.id.btn);
        BM=(ImageView) findViewById(R.id.btnm);
        L=(ListView)findViewById(R.id.listView);

        List<Module> modules = new ArrayList<Module>();
        modules.add(m1);
        modules.add(m2);
        modules.add(m3);
        modules.add(m4);
        modules.add(m5);

        final ModuleAdapter adapter = new ModuleAdapter(this,
                R.layout.modulelist, modules);
        L.setAdapter(adapter);


        BM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                moyg();
            }
        });


        L.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch(position){
                    case 0:
                        Toast.makeText(MainActivity.this,m1.getNom()+" Selected", Toast.LENGTH_SHORT).show();
                        B.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                m1.setNote(moy(E1,E2,E3,T));adapter.notifyDataSetChanged(); }
                        });break;
                    case 1:
                        Toast.makeText(MainActivity.this,m2.getNom()+" Selected", Toast.LENGTH_SHORT).show();
                        B.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                m2.setNote(moy(E1,E2,E3,T));adapter.notifyDataSetChanged(); }
                        });break;
                    case 2:
                        Toast.makeText(MainActivity.this,m3.getNom()+" Selected", Toast.LENGTH_SHORT).show();
                        B.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                m3.setNote(moy(E1,E2,E3,T));adapter.notifyDataSetChanged(); }
                        });break;
                    case 3:
                        Toast.makeText(MainActivity.this,m4.getNom()+" Selected", Toast.LENGTH_SHORT).show();
                        B.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                m4.setNote(moy(E1,E2,E3,T));adapter.notifyDataSetChanged(); }
                        });break;
                    case 4:
                        Toast.makeText(MainActivity.this,m5.getNom()+" Selected", Toast.LENGTH_SHORT).show();
                        B.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                m5.setNote(moy(E1,E2,E3,T));adapter.notifyDataSetChanged(); }
                        });break;
                }
            }
        });


    }
    public void moyg(){
        double mg;
        mg=((m1.getNote()+m2.getNote()+m3.getNote()+m4.getNote()+m5.getNote())/5);
        AlertDialog.Builder build=new AlertDialog.Builder(MainActivity.this);
        build.setTitle("My App");
        build.setMessage("Votre Moyenne est de  : "+ mg);
        AlertDialog alerti=build.create();
        alerti.show();

    }

    public double moy(EditText a,EditText b,EditText c, TextView res){
        double w;
        try {
            float x=Float.parseFloat(a.getText().toString());
            float y=Float.parseFloat(b.getText().toString());
            float z=Float.parseFloat(c.getText().toString());
            w=((((x+y)*(0.34))/2)+(z*(0.66)));
            AlertDialog.Builder build=new AlertDialog.Builder(MainActivity.this);
            build.setTitle("My App");
            build.setMessage("Moyenne du module:  "+ w);
            AlertDialog alerti=build.create();
            alerti.show();
            return w;
        } catch(NumberFormatException ex){
            AlertDialog.Builder build=new AlertDialog.Builder(MainActivity.this);
            build.setTitle("My App");
            build.setMessage("Veuillez Entrez des chiffres  ");
            AlertDialog alerti=build.create();
            alerti.show();
            return 0;}
    }
}
