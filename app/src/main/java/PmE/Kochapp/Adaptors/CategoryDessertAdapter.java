package PmE.Kochapp.Adaptors;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import PmE.Kochapp.Domains.CategoryDessertDomain;
import PmE.Kochapp.Domains.CategoryMeatDomain;
import PmE.Kochapp.R;

import java.util.ArrayList;

public class CategoryDessertAdapter extends RecyclerView.Adapter < CategoryDessertAdapter.ViewHolder >{
    ArrayList <CategoryDessertDomain> dessertDomains;
    private CategoryDessertAdapter.CategoryDessertRecyclerViewClickListener categoryDessertOnclickListener;

    public CategoryDessertAdapter ( ArrayList<CategoryDessertDomain> dessertDomains, CategoryDessertAdapter.CategoryDessertRecyclerViewClickListener categoryDessertOnclickListener ) {
        this.dessertDomains = dessertDomains;
        this.categoryDessertOnclickListener = categoryDessertOnclickListener;
    }

    @Override
    public CategoryDessertAdapter.ViewHolder onCreateViewHolder (@NonNull ViewGroup parent, int viewType ) {
        View inflate = LayoutInflater.from ( parent.getContext() ) . inflate ( R.layout.viewholder_categorylist,parent,false );
        return new CategoryDessertAdapter.ViewHolder( inflate );
    }



    @Override
    public void onBindViewHolder(@NonNull CategoryDessertAdapter.ViewHolder holder, int position) {
        holder.titleDessert.setText ( dessertDomains.get ( position ) .getTitleDessert() );
        holder.cookingTimeDessert.setText ( dessertDomains.get (position ) .getCookingTimeDessert() );
        holder.difficultyDessert.setText ( dessertDomains.get ( position ) .getDifficultyDessert() );

        int drawableRessrceId = holder.itemView.getContext()
                .getResources()
                .getIdentifier ( dessertDomains.get( position ) .getImgeDessert(),
                        "drawable",
                        holder.itemView.getContext() .getPackageName() );

        Glide.with ( holder.itemView.getContext() )
                .load ( drawableRessrceId )
                .into ( holder.imageCategoryDessert );
    }



    @Override
    public int getItemCount() {
        return dessertDomains.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView titleDessert, cookingTimeDessert, difficultyDessert;
        ImageView imageCategoryDessert;

        public ViewHolder ( @NonNull View itemView ) {
            super ( itemView );
            titleDessert = itemView.findViewById ( R.id.categoryListTitle_id);
            cookingTimeDessert = itemView.findViewById ( R.id.categoryListTitleCookingtime_id);
            difficultyDessert = itemView.findViewById ( R.id.categoryListDifficulty_id);
            imageCategoryDessert = itemView.findViewById ( R.id.categoryListImage_id);

            itemView.setOnClickListener( this );
        }

        @Override
        public void onClick ( View view ) {
            categoryDessertOnclickListener.onclickCategoryDessert ( view, getAdapterPosition() );

        }
    }

    public interface CategoryDessertRecyclerViewClickListener{
        void onclickCategoryDessert ( View view, int position );
    }
}
