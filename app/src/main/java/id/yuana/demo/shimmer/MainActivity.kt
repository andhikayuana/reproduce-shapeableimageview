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
import com.mikhaellopez.circularimageview.CircularImageView
import de.hdodenhof.circleimageview.CircleImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val shapeableImageView = findViewById<ShapeableImageView>(R.id.shapeableImageView)
        val imageView = findViewById<ImageView>(R.id.imageView)
        val appCompatImageView = findViewById<AppCompatImageView>(R.id.appCompatImageView)
        val circleImageView1 = findViewById<CircleImageView>(R.id.circleImageView1)
        val circularImageView1 = findViewById<CircularImageView>(R.id.circularImageView1)

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

        val shimmerDrawable4 = ShimmerDrawable()
        shimmerDrawable4.setShimmer(shimmer)

        val shimmerDrawable5 = ShimmerDrawable()
        shimmerDrawable5.setShimmer(shimmer)

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


        //circleImageView1
        Glide.with(applicationContext)
            .load("https://pbs.twimg.com/profile_images/1223572104400031744/dNUw2Un6_400x400.jpg")
            .placeholder(shimmerDrawable4)
            .error(shimmerDrawable4)
            .into(circleImageView1)


        //circleImageView1
        Glide.with(applicationContext)
            .load("https://pbs.twimg.com/profile_images/1223572104400031744/dNUw2Un6_400x400.jpg")
            .placeholder(shimmerDrawable5)
            .error(shimmerDrawable5)
            .into(circularImageView1)

    }

    fun dpToPx(context: Context, dp: Int): Int {
        return (dp * context.resources.displayMetrics.density).toInt()
    }
}