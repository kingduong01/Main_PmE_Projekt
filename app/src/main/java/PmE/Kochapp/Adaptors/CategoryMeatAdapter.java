package PmE.Kochapp.Adaptors;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import PmE.Kochapp.Domains.CategoryMeatDomain;
import PmE.Kochapp.R;

import java.util.ArrayList;

public class CategoryMeatAdapter extends RecyclerView.Adapter < CategoryMeatAdapter.ViewHolder >{
    ArrayList <CategoryMeatDomain> meatDomains;
    private CategoryMeatAdapter.CategoryMeatRecyclerViewClickListener categoryMeatOnclickListener;

    public CategoryMeatAdapter ( ArrayList<CategoryMeatDomain> meatDomains, CategoryMeatAdapter.CategoryMeatRecyclerViewClickListener categoryMeatOnclickListener ) {
        this.meatDomains = meatDomains;
        this.categoryMeatOnclickListener = categoryMeatOnclickListener;
    }

    @Override
    public CategoryMeatAdapter.ViewHolder onCreateViewHolder (@NonNull ViewGroup parent, int viewType ) {
        View inflate = LayoutInflater.from ( parent.getContext() ) . inflate ( R.layout.viewholder_categorylist,parent,false );
        return new CategoryMeatAdapter.ViewHolder( inflate );
    }



    @Override
    public void onBindViewHolder(@NonNull CategoryMeatAdapter.ViewHolder holder, int position) {
        holder.titleMeat.setText ( meatDomains.get ( position ) .getTitleMeat() );
        holder.cookingTimeMeat.setText ( meatDomains.get (position ) .getCookingTimeMeat() );
        holder.difficultyMeat.setText ( meatDomains.get ( position ) .getDifficultyMeat() );

        int drawableRessrceId = holder.itemView.getContext()
                .getResources()
                .getIdentifier ( meatDomains.get( position ) .getImgeMeat(),
                        "drawable",
                        holder.itemView.getContext() .getPackageName() );

        Glide.with ( holder.itemView.getContext() )
                .load ( drawableRessrceId )
                .into ( holder.imageCategoryMeat );
    }



    @Override
    public int getItemCount() {
        return meatDomains.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView titleMeat, cookingTimeMeat, difficultyMeat;
        ImageView imageCategoryMeat;

        public ViewHolder ( @NonNull View itemView ) {
            super ( itemView );
            titleMeat = itemView.findViewById ( R.id.categoryListTitle_id);
            cookingTimeMeat = itemView.findViewById ( R.id.categoryListTitleCookingtime_id);
            difficultyMeat = itemView.findViewById ( R.id.categoryListDifficulty_id);
            imageCategoryMeat = itemView.findViewById ( R.id.categoryListImage_id);

            itemView.setOnClickListener( this );
        }

        @Override
        public void onClick ( View view ) {
            categoryMeatOnclickListener.onclickCategoryMeat ( view, getAdapterPosition() );

        }
    }

    public interface CategoryMeatRecyclerViewClickListener{
        void onclickCategoryMeat ( View view, int position );
    }

}
