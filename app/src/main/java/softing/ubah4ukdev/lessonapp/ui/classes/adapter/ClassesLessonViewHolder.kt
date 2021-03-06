package softing.ubah4ukdev.lessonapp.ui.classes.adapter

import android.view.View
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import softing.ubah4ukdev.lessonapp.R
import softing.ubah4ukdev.lessonapp.databinding.ClassesLessonItemBinding
import softing.ubah4ukdev.lessonapp.domain.models.Lesson
import softing.ubah4ukdev.lessonapp.utils.extensions.click
import softing.ubah4ukdev.lessonapp.utils.extensions.setPointBackground

class ClassesLessonViewHolder(
    view: View
) : RecyclerView.ViewHolder(view) {

    private val viewBinding: ClassesLessonItemBinding by viewBinding()

    fun bind(lesson: Lesson, delegate: Adapter.Delegate?) {
        with(viewBinding) {
            title.text = lesson.title
            openInArea.isVisible = lesson.useRemote
            circle.setPointBackground(lesson.isTop)
            date.text = lesson.scheduler.toString()
            teacher.text = String.format(TEACHER_STRING_TEMPLATE, lesson.teacher)

            Glide.with(icon)
                .load(lesson.icon)
                .circleCrop()
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .skipMemoryCache(true)
                .transition(DrawableTransitionOptions().crossFade(800))
                .placeholder(R.drawable.ic_no_image)
                .error(R.drawable.ic_no_image)
                .into(icon)

            openInArea.click { delegate?.onRunSkype() }
            root.click { delegate?.onLessonItemPicked(lesson) }
        }
    }

    companion object {
        const val DELAY = 800
        const val TEACHER_STRING_TEMPLATE = "Учитель: %s"
    }
}