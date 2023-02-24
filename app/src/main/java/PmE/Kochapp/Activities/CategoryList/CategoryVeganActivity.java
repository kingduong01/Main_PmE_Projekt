package PmE.Kochapp.Activities.CategoryList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import PmE.Kochapp.Activities.Recipes.Vegan.SalatActivity;
import PmE.Kochapp.Activities.Recipes.Vegan.GemueseCurryActivity;
import PmE.Kochapp.Activities.Recipes.Vegan.KartoffelauflaufActivity;
import PmE.Kochapp.Adaptors.CategoryVeganAdapter;
import PmE.Kochapp.Domains.CategoryVeganDomain;
import PmE.Kochapp.R;

import java.util.ArrayList;

/**
* Class     : CategoryVeganActivity
* Methods   : recyclerViewVegan(), setCategoryVeganOnclickListener()
*
* */
public class CategoryVeganActivity extends  AppCompatActivity{
    private RecyclerView.Adapter veganAdapter;

    private RecyclerView recyclerViewVeganList;
    private CategoryVeganAdapter.CategoryVeganRecyclerViewClickListener categoryVeganOnclickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_vegan);

        recyclerViewVegan();
    }

    /**
     * It's a recyclerView for the category Vegan
     * Here the recipes are loaded into an arraylist
     * All recipes are provided with an onclick
     *
     * @See      List with the receipts and there information
     * */
    private void recyclerViewVegan() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager (this, LinearLayoutManager.VERTICAL, false);
        recyclerViewVeganList = findViewById ( R.id.recyclerViewVegan);
        recyclerViewVeganList.setLayoutManager (linearLayoutManager);

        setCategoryVeganOnclickListener();

        ArrayList <CategoryVeganDomain> veganList = new ArrayList<>();
        veganList.add ( new CategoryVeganDomain ( "Salat", "image_vegan_salat", "15 min", "Einfach" ) );
        veganList.add ( new CategoryVeganDomain ( "GemüseCurry", "image_vegan_gemuesecurry", "35 min", "Einfach" ) );
        veganList.add ( new CategoryVeganDomain ( "Kartoffelauflauf", "image_vegan_kartoffelauflauf", "55 Minuten", "Einfach" ) );

        veganAdapter = new CategoryVeganAdapter ( veganList, categoryVeganOnclickListener);
        recyclerViewVeganList.setAdapter ( veganAdapter );
    }

    /**
     * This is the OnclickListener for the individual recipes from the Vegan category.
     * When the user clicks on one of the recipes, he will be redirected to the corresponding page.
     * */
    private void setCategoryVeganOnclickListener(){
        categoryVeganOnclickListener = new CategoryVeganAdapter.CategoryVeganRecyclerViewClickListener()
        {
            @Override
            public void onclickCategoryVegan(View view, int position) {
                if ( position == 0 ){
                    // if clicked on Pancake
                    startActivity ( ( new Intent ( CategoryVeganActivity.this, SalatActivity.class ) ));
                }
                else if ( position == 1 ){
                    // if clicked on blow
                    startActivity( ( new Intent ( CategoryVeganActivity.this, GemueseCurryActivity.class ) ));
                }
                else if ( position == 2 ){
                    // if clicked on french toast
                    startActivity( ( new Intent ( CategoryVeganActivity.this, KartoffelauflaufActivity.class ) ));
                }
            }
        };
    }
}
