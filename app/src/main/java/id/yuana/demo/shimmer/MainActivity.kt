package id.yuana.demo.shimmer

import android.content.Context
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import com.bumptech.glide.Glide
import com.facebook.shimmer.Shimmer
import com.facebook.shimmer.ShimmerDrawable
import com.google.android.material.imageview.ShapeableImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val shapeableImageView = findViewById<ShapeableImageView>(R.id.shapeableImageView)
        val imageView = findViewById<ImageView>(R.id.imageView)
        val appCompatImageView = findViewById<AppCompatImageView>(R.id.appCompatImageView)

        //initialize shimmer
        val shimmer = Shimmer.AlphaHighlightBuilder()
            .setBaseAlpha(0.7f)
            .setHighlightAlpha(0.9f)
            .setDuration(1800)
            .setDirection(Shimmer.Direction.LEFT_TO_RIGHT)
            .setAutoStart(true)
            .build()

        //create ShimmerDrawable()
        val shimmerDrawable = ShimmerDrawable()
        shimmerDrawable.setShimmer(shimmer)

        val shimmerDrawable2 = ShimmerDrawable()
        shimmerDrawable2.setShimmer(shimmer)

        val shimmerDrawable3 = ShimmerDrawable()
        shimmerDrawable3.setShimmer(shimmer)

        //shapeableImageView
        Glide.with(applicationContext)
            .load("https://pbs.twimg.com/profile_images/1223572104400031744/dNUw2Un6_400x400.jpg")
            .placeholder(shimmerDrawable)
            .error(shimmerDrawable)
            .into(shapeableImageView)

        //imageView
        Glide.with(applicationContext)
            .load("https://pbs.twimg.com/profile_images/1223572104400031744/dNUw2Un6_400x400.jpg")
            .placeholder(shimmerDrawable2)
            .error(shimmerDrawable2)
            .into(imageView)

        //appCompatImageView
        Glide.with(applicationContext)
            .load("https://pbs.twimg.com/profile_images/1223572104400031744/dNUw2Un6_400x400.jpg")
            .placeholder(shimmerDrawable3)
            .error(shimmerDrawable3)
            .into(appCompatImageView)


    }

    fun dpToPx(context: Context, dp: Int): Int {
        return (dp * context.resources.displayMetrics.density).toInt()
    }
}