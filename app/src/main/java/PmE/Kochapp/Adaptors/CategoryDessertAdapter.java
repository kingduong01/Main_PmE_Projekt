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

    /**
     * This method is called by the RecyclerView to display the data at the specified position.
     * It updates the contents of the ViewHolder to reflect the item at the given position.
     *
     * @param holder The ViewHolder which should be updated to represent the contents of the item at the given position.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull CategoryDessertAdapter.ViewHolder holder, int position) {

        // Set the title, cooking time, and difficulty of the dessert item in the ViewHolder
        holder.titleDessert.setText ( dessertDomains.get ( position ) .getTitleDessert() );
        holder.cookingTimeDessert.setText ( dessertDomains.get (position ) .getCookingTimeDessert() );
        holder.difficultyDessert.setText ( dessertDomains.get ( position ) .getDifficultyDessert() );

        // Get the ID of the drawable resource for the dessert item image
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

    /**
     * The ViewHolder class holds references to the views that make up each item in the RecyclerView.
     * It also implements an OnClickListener to handle clicks on each item.
     */
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView titleDessert, cookingTimeDessert, difficultyDessert;
        ImageView imageCategoryDessert;

        /**
         * Constructor for the ViewHolder class.
         * @param itemView The View that represents each item in the RecyclerView.
         */
        public ViewHolder ( @NonNull View itemView ) {
            super ( itemView );
            titleDessert = itemView.findViewById ( R.id.categoryListTitle_id);
            cookingTimeDessert = itemView.findViewById ( R.id.categoryListTitleCookingtime_id);
            difficultyDessert = itemView.findViewById ( R.id.categoryListDifficulty_id);
            imageCategoryDessert = itemView.findViewById ( R.id.categoryListImage_id);

            itemView.setOnClickListener( this );
        }
        /**
         * Override of the onClick method from the OnClickListener interface.
         * @param view The View that was clicked.
         */
        @Override
        public void onClick ( View view ) {
            // Call the onclickCategoryDessert method on the categoryDessertOnclickListener,
            // passing in the clicked view and the position of the ViewHolder in the adapter
            categoryDessertOnclickListener.onclickCategoryDessert ( view, getAdapterPosition() );

        }
    }

    public interface CategoryDessertRecyclerViewClickListener{
        void onclickCategoryDessert ( View view, int position );
    }
}
