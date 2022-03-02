package softing.ubah4ukdev.lessonapp.ui.home.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import softing.ubah4ukdev.lessonapp.R
import softing.ubah4ukdev.lessonapp.databinding.HomeWorkItemBinding
import softing.ubah4ukdev.lessonapp.domain.models.HomeWork
import softing.ubah4ukdev.lessonapp.utils.extensions.click
import softing.ubah4ukdev.lessonapp.utils.extensions.dayLeftFrom
import softing.ubah4ukdev.lessonapp.utils.extensions.setData

class HomeWorkViewHolder(
    view: View
) : RecyclerView.ViewHolder(view) {

    private val viewBinding: HomeWorkItemBinding by viewBinding()

    fun bind(homeWork: HomeWork, delegate: HomeWorkAdapter.Delegate?) {
        with(viewBinding) {
            title.text = homeWork.title
            root.click { delegate?.onHomeWorkItemPicked(homeWork) }
            work.text = homeWork.work
            deadLine.setData(dayLeftFrom(homeWork.deadLine))

            Glide.with(icon)
                .load(homeWork.icon)
                .circleCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .transition(DrawableTransitionOptions().crossFade(DELAY))
                .placeholder(R.drawable.ic_no_image)
                .error(R.drawable.ic_no_image)
                .into(icon)

            Glide.with(iconOne)
                .load(homeWork.tagIconOne)
                .circleCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .transition(DrawableTransitionOptions().crossFade(DELAY))
                .placeholder(R.drawable.ic_no_image)
                .error(R.drawable.ic_no_image)
                .into(iconOne)

            Glide.with(iconTwo)
                .load(homeWork.tagIconTwo)
                .circleCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .transition(DrawableTransitionOptions().crossFade(DELAY))
                .placeholder(R.drawable.ic_no_image)
                .error(R.drawable.ic_no_image)
                .into(iconTwo)
        }
    }

    companion object {
        const val DELAY = 800
    }
}