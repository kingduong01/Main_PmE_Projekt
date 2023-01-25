package PmE.Kochapp.Adaptors;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import PmE.Kochapp.Domains.CategoryBreakfastDomain;
import PmE.Kochapp.R;

import java.util.ArrayList;

public class CategoryBreakfastAdapter extends RecyclerView.Adapter < CategoryBreakfastAdapter.ViewHolder > {
    ArrayList < CategoryBreakfastDomain > breakfastDomains;
    private CategoryBreakfastRecyclerViewClickListener categoryBreakfastOnclickListener;

    public CategoryBreakfastAdapter ( ArrayList<CategoryBreakfastDomain> breakfastDomains, CategoryBreakfastRecyclerViewClickListener categoryBreakfastOnclickListener ) {
        this.breakfastDomains = breakfastDomains;
        this.categoryBreakfastOnclickListener = categoryBreakfastOnclickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder ( @NonNull ViewGroup parent, int viewType ) {
        View inflate = LayoutInflater.from ( parent.getContext() ) . inflate ( R.layout.viewholder_categorylist,parent,false );
        return new ViewHolder ( inflate );
    }

    @Override
    public void onBindViewHolder ( @NonNull CategoryBreakfastAdapter.ViewHolder holder, int position ) {
        holder.titleBreakfast.setText ( breakfastDomains.get ( position ) .getTitleBreakfast() );
        holder.cookingTimeBreakfast.setText ( breakfastDomains.get (position ) .getCookingTimeBreakfast() );
        holder.difficultyBreakfast.setText ( breakfastDomains.get ( position ) .getDifficultyBreakfast() );

        int drawableRessrceId = holder.itemView.getContext()
                .getResources()
                .getIdentifier ( breakfastDomains.get( position ) .getImgeBreakfast(),
                        "drawable",
                        holder.itemView.getContext() .getPackageName() );

        Glide.with ( holder.itemView.getContext() )
                .load ( drawableRessrceId )
                .into ( holder.imageCategoryBreakfast );
    }

    @Override
    public int getItemCount() {
        return breakfastDomains.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView titleBreakfast, cookingTimeBreakfast, difficultyBreakfast;
        ImageView imageCategoryBreakfast;

        public ViewHolder ( @NonNull View itemView ) {
            super ( itemView );
            titleBreakfast = itemView.findViewById ( R.id.categoryListTitle_id);
            cookingTimeBreakfast = itemView.findViewById ( R.id.categoryListTitleCookingtime_id);
            difficultyBreakfast = itemView.findViewById ( R.id.categoryListDifficulty_id);
            imageCategoryBreakfast = itemView.findViewById ( R.id.categoryListImage_id);

            itemView.setOnClickListener( this );
        }

        @Override
        public void onClick ( View view ) {
            categoryBreakfastOnclickListener.onclickCategoryBreakfast ( view, getAdapterPosition() );

        }
    }

    public interface CategoryBreakfastRecyclerViewClickListener{
        void onclickCategoryBreakfast ( View view, int position );
    }
}
