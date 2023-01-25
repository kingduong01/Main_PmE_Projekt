package PmE.Kochapp.Activities.CategoryList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import PmE.Kochapp.Activities.Recipes.Pasta.BologneseActivity;
import PmE.Kochapp.Activities.Recipes.Pasta.CabonaraActivity;
import PmE.Kochapp.Activities.Recipes.Pasta.LachsPastaActivity;
import PmE.Kochapp.Adaptors.CategoryPastaAdapter;
import PmE.Kochapp.Domains.CategoryPastaDomain;
import PmE.Kochapp.R;

import java.util.ArrayList;

public class CategoryPastaActivity extends  AppCompatActivity{
    private RecyclerView.Adapter pastaAdapter;

    private RecyclerView recyclerViewPastaList;
    private CategoryPastaAdapter.CategoryPastaRecyclerViewClickListener categoryPastaOnclickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_pasta);

        recyclerViewPasta();
    }

    private void recyclerViewPasta() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager (this, LinearLayoutManager.VERTICAL, false);
        recyclerViewPastaList = findViewById ( R.id.recyclerViewPasta);
        recyclerViewPastaList.setLayoutManager (linearLayoutManager);

        setCategoryPastaOnclickListener();

        ArrayList <CategoryPastaDomain> pastaList = new ArrayList<>();
        pastaList.add ( new CategoryPastaDomain ( "Bolognese", "image_pasta_bolognesee", "30 min", "Einfach" ) );
        pastaList.add ( new CategoryPastaDomain ( "Cabonara", "image_popular_spaghetti_carbonara", "20 min", "Einfach" ) );
        pastaList.add ( new CategoryPastaDomain ( "LachsPasta", "image_popular_nudeln_mit_lachs", "20 Minuten", "Einfach" ) );

        pastaAdapter = new CategoryPastaAdapter ( pastaList, categoryPastaOnclickListener);
        recyclerViewPastaList.setAdapter ( pastaAdapter );
    }

    private void setCategoryPastaOnclickListener(){
        categoryPastaOnclickListener = new CategoryPastaAdapter.CategoryPastaRecyclerViewClickListener()
        {
            @Override
            public void onclickCategoryPasta(View view, int position) {
                if ( position == 0 ){
                    // if clicked on Pancake
                    startActivity ( ( new Intent ( CategoryPastaActivity.this, BologneseActivity.class ) ));
                }
                else if ( position == 1 ){
                    // if clicked on blow
                    startActivity( ( new Intent ( CategoryPastaActivity.this, CabonaraActivity.class ) ));
                }
                else if ( position == 2 ){
                    // if clicked on french toast
                    startActivity( ( new Intent ( CategoryPastaActivity.this, LachsPastaActivity.class ) ));
                }
            }
        };
    }
}
