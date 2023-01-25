package PmE.Kochapp.Activities.CategoryList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import PmE.Kochapp.Activities.Recipes.Meat.SchnitzelActivity;
import PmE.Kochapp.Activities.Recipes.Meat.LasagneActivity;
import PmE.Kochapp.Activities.Recipes.Meat.HackbratenActivity;
import PmE.Kochapp.Adaptors.CategoryMeatAdapter;
import PmE.Kochapp.Domains.CategoryMeatDomain;
import PmE.Kochapp.R;

import java.util.ArrayList;

public class CategoryMeatActivity extends  AppCompatActivity{
    private RecyclerView.Adapter meatAdapter;

    private RecyclerView recyclerViewMeatList;
    private CategoryMeatAdapter.CategoryMeatRecyclerViewClickListener categoryMeatOnclickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_meat);

        recyclerViewMeat();
    }

    private void recyclerViewMeat() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager (this, LinearLayoutManager.VERTICAL, false);
        recyclerViewMeatList = findViewById ( R.id.recyclerViewMeat);
        recyclerViewMeatList.setLayoutManager (linearLayoutManager);

        setCategoryMeatOnclickListener();

        ArrayList <CategoryMeatDomain> meatList = new ArrayList<>();
        meatList.add ( new CategoryMeatDomain ( "Schnitzel", "image_meat_schnitzel", "30 min", "Mittel" ) );
        meatList.add ( new CategoryMeatDomain ( "Lasagne", "image_meat_lasagne", "100 min", "Mittel" ) );
        meatList.add ( new CategoryMeatDomain ( "Hackbraten", "image_meat_hackbraten", "85 Minuten", "Mittel" ) );

        meatAdapter = new CategoryMeatAdapter ( meatList, categoryMeatOnclickListener);
        recyclerViewMeatList.setAdapter ( meatAdapter );
    }

    private void setCategoryMeatOnclickListener(){
        categoryMeatOnclickListener = new CategoryMeatAdapter.CategoryMeatRecyclerViewClickListener()
        {
            @Override
            public void onclickCategoryMeat(View view, int position) {
                if ( position == 0 ){
                    // if clicked on Pancake
                    startActivity ( ( new Intent ( CategoryMeatActivity.this, SchnitzelActivity.class ) ));
                }
                else if ( position == 1 ){
                    // if clicked on blow
                    startActivity( ( new Intent ( CategoryMeatActivity.this, LasagneActivity.class ) ));
                }
                else if ( position == 2 ){
                    // if clicked on french toast
                    startActivity( ( new Intent ( CategoryMeatActivity.this, HackbratenActivity.class ) ));
                }
            }
        };
    }
}
