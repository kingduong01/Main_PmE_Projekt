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

    /**
     * This method is called by the RecyclerView to display the data at the specified position.
     * It updates the contents of the ViewHolder to reflect the item at the given position.
     *
     * @param holder The ViewHolder which should be updated to represent the contents of the item at the given position.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull CategoryMeatAdapter.ViewHolder holder, int position) {

        // Set the title, cooking time, and difficulty of the meat item in the ViewHolder
        holder.titleMeat.setText ( meatDomains.get ( position ) .getTitleMeat() );
        holder.cookingTimeMeat.setText ( meatDomains.get (position ) .getCookingTimeMeat() );
        holder.difficultyMeat.setText ( meatDomains.get ( position ) .getDifficultyMeat() );

        // Get the ID of the drawable resource for the meat item image
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

    /**
     * The ViewHolder class holds references to the views that make up each item in the RecyclerView.
     * It also implements an OnClickListener to handle clicks on each item.
     */
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView titleMeat, cookingTimeMeat, difficultyMeat;
        ImageView imageCategoryMeat;

        /**
         * Constructor for the ViewHolder class.
         * @param itemView The View that represents each item in the RecyclerView.
         */
        public ViewHolder ( @NonNull View itemView ) {
            super ( itemView );
            titleMeat = itemView.findViewById ( R.id.categoryListTitle_id);
            cookingTimeMeat = itemView.findViewById ( R.id.categoryListTitleCookingtime_id);
            difficultyMeat = itemView.findViewById ( R.id.categoryListDifficulty_id);
            imageCategoryMeat = itemView.findViewById ( R.id.categoryListImage_id);

            itemView.setOnClickListener( this );
        }

        /**
         * Override of the onClick method from the OnClickListener interface.
         * @param view The View that was clicked.
         */
        @Override
        public void onClick ( View view ) {
            // Call the onclickCategoryMeat method on the categoryMeatOnclickListener,
            // passing in the clicked view and the position of the ViewHolder in the adapter
            categoryMeatOnclickListener.onclickCategoryMeat ( view, getAdapterPosition() );

        }
    }

    public interface CategoryMeatRecyclerViewClickListener{
        void onclickCategoryMeat ( View view, int position );
    }

}
