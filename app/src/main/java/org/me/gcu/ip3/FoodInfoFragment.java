package org.me.gcu.ip3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.squareup.picasso.Picasso;

public class FoodInfoFragment extends Fragment {
    private TextView mFoodInfoText;
    private TextView mLabelTextView;
    private TextView mNutrientsTextView;
    private TextView mBrandTextView;
    private TextView mCategoryTextView;
    private TextView mFoodContentsTextView;
    private ImageView mFoodImageView;

    private FoodItem foodItem;

    public FoodInfoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            foodItem = (FoodItem) getArguments().getSerializable("foodItem");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_food_info, container, false);

        mFoodInfoText = rootView.findViewById(R.id.food_info_text);
        mLabelTextView = rootView.findViewById(R.id.label_text_view);
        mNutrientsTextView = rootView.findViewById(R.id.nutrients_text_view);
        mBrandTextView = rootView.findViewById(R.id.brand_text_view);
        mCategoryTextView = rootView.findViewById(R.id.category_text_view);
        mFoodContentsTextView = rootView.findViewById(R.id.food_contents_text_view);
        mFoodImageView = rootView.findViewById(R.id.food_image_view);

        // Set the text for the TextViews and load the image using Picasso
        mLabelTextView.setText(foodItem.getLabel() != null ? foodItem.getLabel() : "N/A");
        mNutrientsTextView.setText(foodItem.getNutrients() != null ? foodItem.getNutrients().toString() : "N/A");
        mBrandTextView.setText(foodItem.getBrand() != null ? foodItem.getBrand() : "N/A");
        mCategoryTextView.setText(foodItem.getCategory() != null ? foodItem.getCategory() : "N/A");
        mFoodContentsTextView.setText(foodItem.getFoodContentsLabel() != null ? foodItem.getFoodContentsLabel() : "N/A");

        if (foodItem.getImage() != null) {
            Picasso.get().load(foodItem.getImage()).into(mFoodImageView);
        } else {
            // Set a default image or a placeholder if the image URL is null
            mFoodImageView.setImageResource(R.drawable.placeholder_image);
        }
        return rootView;
    }
}
