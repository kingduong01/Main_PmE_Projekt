package PmE.Kochapp.Activities.CategoryList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import PmE.Kochapp.Activities.Recipes.Breakfast.BowlActivity;
import PmE.Kochapp.Activities.Recipes.Breakfast.FrenchToastActivity;
import PmE.Kochapp.Activities.Recipes.Breakfast.PancakeActivity;
import PmE.Kochapp.Adaptors.CategoryBreakfastAdapter;
import PmE.Kochapp.Domains.CategoryBreakfastDomain;
import PmE.Kochapp.R;

import java.util.ArrayList;

/**
 * Class     : CategoryBreakfastActivity
 * Methods   : recyclerViewBreakfast(), setCategoryBreakfastOnclickListener()
 *
 * */
public class CategoryBreakfastActivity extends AppCompatActivity {
    private RecyclerView.Adapter breakfastAdapter;

    private RecyclerView recyclerViewBreakfastList;
    private CategoryBreakfastAdapter.CategoryBreakfastRecyclerViewClickListener categoryBreakfastOnclickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_breakfast);

        recyclerViewBreakfast();
    }


    /**
    * It's a recyclerView for the category Breakfast
    * Here the recipes are loaded into an arraylist
    * All recipes are provided with an onclick
    *
    * @See      List with the receipts and there information
    * */
    private void recyclerViewBreakfast() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager (this, LinearLayoutManager.VERTICAL, false);
        recyclerViewBreakfastList = findViewById ( R.id.recyclerViewBreakfast);
        recyclerViewBreakfastList.setLayoutManager (linearLayoutManager);

        setCategoryBreakfastOnclickListener();

        ArrayList < CategoryBreakfastDomain > breakfastList = new ArrayList<>();
        breakfastList.add ( new CategoryBreakfastDomain ( "Pancake", "image_breakfast_pancake", "10 min", "Einfach" ) );
        breakfastList.add ( new CategoryBreakfastDomain ( "Blow", "image_breakfastblow", "15 min", "Einfach" ) );
        breakfastList.add ( new CategoryBreakfastDomain ( "French Toast", "image_popular_french_toast", "15 Minuten", "Einfach" ) );

        breakfastAdapter = new CategoryBreakfastAdapter ( breakfastList, categoryBreakfastOnclickListener);
        recyclerViewBreakfastList.setAdapter ( breakfastAdapter );
    }

    /**
    * This is the OnclickListener for the individual recipes from the Breakfast category.
    * When the user clicks on one of the recipes, he will be redirected to the corresponding page.
    * */
    private void setCategoryBreakfastOnclickListener(){
        categoryBreakfastOnclickListener = new CategoryBreakfastAdapter.CategoryBreakfastRecyclerViewClickListener()
        {
            @Override
            public void onclickCategoryBreakfast(View view, int position) {
                if ( position == 0 ){
                    // if clicked on Pancake
                    startActivity ( ( new Intent ( CategoryBreakfastActivity.this, PancakeActivity.class ) ));
                }
                else if ( position == 1 ){
                    // if clicked on blow
                    startActivity( ( new Intent ( CategoryBreakfastActivity.this, BowlActivity.class ) ));
                }
                else if ( position == 2 ){
                    // if clicked on french toast
                    startActivity( ( new Intent ( CategoryBreakfastActivity.this, FrenchToastActivity.class ) ));
                }
            }
        };
    }
}
