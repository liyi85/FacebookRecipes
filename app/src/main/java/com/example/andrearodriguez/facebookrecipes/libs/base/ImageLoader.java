package com.example.andrearodriguez.facebookrecipes.libs.base;

import android.widget.ImageView;

/**
 * Created by andrearodriguez on 6/23/16.
 */
public interface ImageLoader {
    void load(ImageView imageView, String URL);
    void setOnFinishedImageLoadingListener(Object listener);
}
