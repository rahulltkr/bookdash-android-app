package org.bookdash.android.presentation.utils;

import android.databinding.BindingAdapter;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;



public class BindingUtils {

    @BindingAdapter({"bind:imageUrlWeb"})
    public static void loadImage(ImageView view, String url) {
        Glide.with(view.getContext()).load(url).into(view);
    }

    @BindingAdapter("bind:specialTag")
    public static void setSpecialTag(View view, Object value) {
        view.setTag(value);
    }

    @BindingAdapter("bind:contentScrim")
    public static void setContentScrim(View view, Object value) {
        view.setTag(value);
    }

    @BindingAdapter({"bind:parseImageFile"})
    public static void loadImageFromParse(final ImageView view, Object parseFile) {
        if (parseFile == null){
            return;
        }

    }
}
