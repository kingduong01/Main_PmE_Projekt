package PmE.Kochapp.Activities.Main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import PmE.Kochapp.Activities.CategoryList.CategoryBreakfastActivity;
import PmE.Kochapp.Activities.CategoryList.CategoryPastaActivity;
import PmE.Kochapp.Adaptors.CategoryAdapter;
import PmE.Kochapp.Adaptors.PopularAdapter;
import PmE.Kochapp.Domains.CategoryDomain;
import PmE.Kochapp.Domains.PopularDomain;
import PmE.Kochapp.R;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity{
    private RecyclerView.Adapter categoryAdapter, popularAdapter;
    private RecyclerView recyclerViewCategoryList, recyclerViewPopularList;
    private CategoryAdapter.CategoryRecyclerViewClickListener categoryOnclickListener;
    private PopularAdapter.PopularRecyclerViewClickListener popularOnclickListener;

    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_home );

        recyclerViewCategory();
        recyclerViewPopular();
    }


    private void recyclerViewCategory () {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager (this, LinearLayoutManager.HORIZONTAL,false );
        recyclerViewCategoryList = findViewById ( R.id.recyclerViewCategory );
        recyclerViewCategoryList.setLayoutManager ( linearLayoutManager );

        setCategoryOnclickListener();

        ArrayList<CategoryDomain> categoryList = new ArrayList<>();

        categoryList.add(new CategoryDomain ("Frühstück", "image_1" ));
        categoryList.add(new CategoryDomain ("Pasta", "image_2" ));
        categoryList.add(new CategoryDomain ("Vegetarisch", "image_3" ));
        categoryList.add(new CategoryDomain ("Fleischgerichte", "image_4" ));
        categoryList.add(new CategoryDomain ("Dessert", "image_5" ));

        categoryAdapter = new CategoryAdapter ( categoryList, categoryOnclickListener );
        recyclerViewCategoryList.setAdapter ( categoryAdapter );

    }


    private void setCategoryOnclickListener() {
        categoryOnclickListener = new CategoryAdapter.CategoryRecyclerViewClickListener()
        {
            @Override
            public void onclickCategory(View view, int position) {
                if ( position == 0){
                    // if clicked on Breakfast
                    startActivity ( new Intent (HomeActivity.this, CategoryBreakfastActivity.class ) );
                }
                else if ( position == 1) {
                    // if clicked on Pasta
                    startActivity ( new Intent (HomeActivity.this, CategoryPastaActivity.class ) );
                }
                else if ( position == 2) {
                    // if clicked on Vegetarian -- Activity missing!!
                    startActivity ( new Intent (HomeActivity.this, CategoryPastaActivity.class ) );
                }
                else if ( position == 3) {
                    // if clicked on Meat -- Activity missing!!
                    startActivity ( new Intent (HomeActivity.this, CategoryPastaActivity.class ) );
                }
                else if ( position == 4) {
                    // if clicked on Dessert -- Activity missing!!
                    startActivity ( new Intent (HomeActivity.this, CategoryPastaActivity.class ) );
                }
            }
        };
    }


    private void recyclerViewPopular () {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager ( this, LinearLayoutManager.HORIZONTAL, false );
        recyclerViewPopularList = findViewById ( R.id.recyclerViewPopular);
        recyclerViewPopularList.setLayoutManager ( linearLayoutManager );

        ArrayList<PopularDomain> popularList = new ArrayList<>();

        setPopularOnclickListener();

        popularList.add (new PopularDomain ( "Creme Brulee", "image_popular_cremebrulee", "90 Minuten", "Einfach" ));
        popularList.add (new PopularDomain ( "French Toast", "image_popular_french_toast", "15 Minuten", "Einfach" ));
        popularList.add (new PopularDomain ( "Gemüse-Curry", "image_popular_gemuese_curry", "25 Minuten", "Einfach" ));
        popularList.add (new PopularDomain ( "Spaghetti Cabonara", "image_popular_spaghetti_carbonara", "20 Minuten", "Einfach" ));
        popularList.add (new PopularDomain ( "Pasta mit Lachs", "image_popular_nudeln_mit_lachs", "20 Minuten", "Einfach" ));

        popularAdapter = new PopularAdapter ( popularList, popularOnclickListener );
        recyclerViewPopularList.setAdapter( popularAdapter );

    }

    private void setPopularOnclickListener() {
        popularOnclickListener = new PopularAdapter.PopularRecyclerViewClickListener() {
            @Override
            public void onclickPopular(View view, int position) {
                if ( position == 0){
                    // if clicked on 1. popular recipe -- Activity missing!!
                    startActivity ( new Intent (HomeActivity.this, CategoryBreakfastActivity.class) );
                }
                else if ( position == 1) {
                    // if clicked on 2. popular recipe -- Activity missing!!
                    startActivity ( new Intent (HomeActivity.this, CategoryPastaActivity.class) );
                }
                else if ( position == 2) {
                    // if clicked on 3. popular recipe -- Activity missing!!
                    startActivity ( new Intent (HomeActivity.this, CategoryPastaActivity.class) );
                }
                else if ( position == 3) {
                    // if clicked on 4. popular recipe -- Activity missing!!
                    startActivity ( new Intent (HomeActivity.this, CategoryPastaActivity.class) );
                }
                else if ( position == 4) {
                    // if clicked on 4. popular recipe -- Activity missing!!
                    startActivity ( new Intent (HomeActivity.this, CategoryPastaActivity.class) );
                }
            }
        };
    }
}
