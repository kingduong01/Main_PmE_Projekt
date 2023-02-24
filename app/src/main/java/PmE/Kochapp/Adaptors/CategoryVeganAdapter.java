package PmE.Kochapp.Adaptors;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import PmE.Kochapp.Domains.CategoryVeganDomain;
import PmE.Kochapp.R;

import java.util.ArrayList;

public class CategoryVeganAdapter extends RecyclerView.Adapter < CategoryVeganAdapter.ViewHolder >{
    ArrayList <CategoryVeganDomain> veganDomains;
    private CategoryVeganAdapter.CategoryVeganRecyclerViewClickListener categoryVeganOnclickListener;

    public CategoryVeganAdapter ( ArrayList<CategoryVeganDomain> veganDomains, CategoryVeganAdapter.CategoryVeganRecyclerViewClickListener categoryVeganOnclickListener ) {
        this.veganDomains = veganDomains;
        this.categoryVeganOnclickListener = categoryVeganOnclickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder (@NonNull ViewGroup parent, int viewType ) {
        View inflate = LayoutInflater.from ( parent.getContext() ) . inflate ( R.layout.viewholder_categorylist,parent,false );
        return new CategoryVeganAdapter.ViewHolder( inflate );
    }

    /**
     * This method is called by the RecyclerView to display the data at the specified position.
     * It updates the contents of the ViewHolder to reflect the item at the given position.
     *
     * @param holder The ViewHolder which should be updated to represent the contents of the item at the given position.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        // Set the title, cooking time, and difficulty of the vegan item in the ViewHolder
        holder.titleVegan.setText ( veganDomains.get ( position ) .getTitleVegan() );
        holder.cookingTimeVegan.setText ( veganDomains.get (position ) .getCookingTimeVegan() );
        holder.difficultyVegan.setText ( veganDomains.get ( position ) .getDifficultyVegan() );

        // Get the ID of the drawable resource for the vegan item image
        int drawableRessrceId = holder.itemView.getContext()
                .getResources()
                .getIdentifier ( veganDomains.get( position ) .getImgeVegan(),
                        "drawable",
                        holder.itemView.getContext() .getPackageName() );

        Glide.with ( holder.itemView.getContext() )
                .load ( drawableRessrceId )
                .into ( holder.imageCategoryVegan );
    }



    @Override
    public int getItemCount() {
        return veganDomains.size();
    }

    /**
     * The ViewHolder class holds references to the views that make up each item in the RecyclerView.
     * It also implements an OnClickListener to handle clicks on each item.
     */
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView titleVegan, cookingTimeVegan, difficultyVegan;
        ImageView imageCategoryVegan;

        /**
         * Constructor for the ViewHolder class.
         * @param itemView The View that represents each item in the RecyclerView.
         */
        public ViewHolder ( @NonNull View itemView ) {
            super ( itemView );
            titleVegan = itemView.findViewById ( R.id.categoryListTitle_id);
            cookingTimeVegan = itemView.findViewById ( R.id.categoryListTitleCookingtime_id);
            difficultyVegan = itemView.findViewById ( R.id.categoryListDifficulty_id);
            imageCategoryVegan = itemView.findViewById ( R.id.categoryListImage_id);

            itemView.setOnClickListener( this );
        }

        /**
         * Override of the onClick method from the OnClickListener interface.
         * @param view The View that was clicked.
         */
        @Override
        public void onClick ( View view ) {
            // Call the onclickCategoryVegan method on the categoryVeganOnclickListener,
            // passing in the clicked view and the position of the ViewHolder in the adapter
            categoryVeganOnclickListener.onclickCategoryVegan ( view, getAdapterPosition() );

        }
    }

    public interface CategoryVeganRecyclerViewClickListener{
        void onclickCategoryVegan ( View view, int position );
    }
}
