package PmE.Kochapp.Activities.CategoryList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import PmE.Kochapp.Activities.Recipes.Dessert.CremeBruleeActivity;
import PmE.Kochapp.Activities.Recipes.Dessert.MousseAuChocolatActivity;
import PmE.Kochapp.Activities.Recipes.Dessert.PannaCottaActivity;
import PmE.Kochapp.Adaptors.CategoryDessertAdapter;
import PmE.Kochapp.Domains.CategoryDessertDomain;
import PmE.Kochapp.R;

import java.util.ArrayList;

public class CategoryDessertActivity extends AppCompatActivity {
    private RecyclerView.Adapter dessertAdapter;

    private RecyclerView recyclerViewDessertList;
    private CategoryDessertAdapter.CategoryDessertRecyclerViewClickListener categoryDessertOnclickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_dessert);

        recyclerViewDessert();
    }

    private void recyclerViewDessert() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager (this, LinearLayoutManager.VERTICAL, false);
        recyclerViewDessertList = findViewById ( R.id.recyclerViewDessert);
        recyclerViewDessertList.setLayoutManager (linearLayoutManager);

        setCategoryDessertOnclickListener();

        ArrayList <CategoryDessertDomain> dessertList = new ArrayList<>();
        dessertList.add ( new CategoryDessertDomain ( "Creme Brulee", "image_popular_cremebrulee", "90 min", "Einfach" ) );
        dessertList.add ( new CategoryDessertDomain ( "Panna Cotta", "image_dessert_pannacotta", "30 min", "Einfach" ) );
        dessertList.add ( new CategoryDessertDomain ( "Panna Cotta", "image_dessert_mousseauchocolat", "20 Minuten", "Einfach" ) );

        dessertAdapter = new CategoryDessertAdapter ( dessertList, categoryDessertOnclickListener);
        recyclerViewDessertList.setAdapter ( dessertAdapter );
    }

    private void setCategoryDessertOnclickListener(){
        categoryDessertOnclickListener = new CategoryDessertAdapter.CategoryDessertRecyclerViewClickListener()
        {
            @Override
            public void onclickCategoryDessert(View view, int position) {
                if ( position == 0 ){
                    // if clicked on Pancake
                    startActivity ( ( new Intent ( CategoryDessertActivity.this, CremeBruleeActivity.class ) ));
                }
                else if ( position == 1 ){
                    // if clicked on blow
                    startActivity( ( new Intent ( CategoryDessertActivity.this, PannaCottaActivity.class ) ));
                }
                else if ( position == 2 ){
                    // if clicked on french toast
                    startActivity( ( new Intent ( CategoryDessertActivity.this, MousseAuChocolatActivity.class ) ));
                }
            }
        };
    }
}
