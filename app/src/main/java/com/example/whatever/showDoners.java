package com.example.whatever;


        import androidx.annotation.NonNull;
        import androidx.appcompat.app.AppCompatActivity;
        import androidx.appcompat.widget.SearchView;
        import androidx.recyclerview.widget.RecyclerView;

        import android.os.Bundle;
        import android.widget.Toast;

        import com.google.firebase.database.DataSnapshot;
        import com.google.firebase.database.DatabaseError;
        import com.google.firebase.database.DatabaseReference;
        import com.google.firebase.database.FirebaseDatabase;
        import com.google.firebase.database.ValueEventListener;

        import java.util.ArrayList;

public class showDoners extends AppCompatActivity {
    DatabaseReference ref;
    ArrayList<Availdoners> list;
    RecyclerView recyclerView;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_doners);
        recyclerView=findViewById(R.id.rv);
        searchView=findViewById(R.id.searchView);
        ref= FirebaseDatabase.getInstance().getReference().child("Doners").child("don");
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (ref!=null){

            ref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if (dataSnapshot.exists()){
                        list= new ArrayList<>();
                        for (DataSnapshot ds:dataSnapshot.getChildren()){
                            list.add(ds.getValue(Availdoners.class));

                        }
                        Adaptclass adapterclass=new Adaptclass(list);
                        recyclerView.setAdapter(adapterclass);
                    }

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    Toast.makeText(showDoners.this,databaseError.getMessage(),Toast.LENGTH_SHORT).show();

                }
            });
        }
        if (searchView!=null){
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    search(newText);
                    return false;
                }
            });
        }
    }
    private void search(String str){
        ArrayList<Availdoners> mylist=new ArrayList<>();
        for (Availdoners object : list){
            if (object.getName().toLowerCase().contains(str.toLowerCase())){
                mylist.add(object);
            }
        }
        Adaptclass adapterclass= new Adaptclass(mylist);
        recyclerView.setAdapter(adapterclass);

    }

}
