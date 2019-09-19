package com.story_tail.privypics.ui

import android.app.AlertDialog
import android.app.Dialog
import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.story_tail.privypics.R
import com.story_tail.privypics.databinding.DialogFragmentAddImageBinding
import com.story_tail.privypics.viewmodel.ImageViewModel
import splitties.fragmentargs.argOrNull


class AddImageDialogFragment() : DialogFragment() {
    constructor(image: ByteArray) : this() {
        imageArray = image
    }

    var imageArray by argOrNull<ByteArray>()

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        var dialogBuilder = AlertDialog.Builder(requireContext())
        var viewModel = ImageViewModel()
        val bitmap = imageArray?.size?.let { BitmapFactory.decodeByteArray(imageArray, 0, it) }
        viewModel.image = bitmap
        val view = DialogFragmentAddImageBinding.inflate(layoutInflater)
        dialogBuilder.setTitle(R.string.add_image)
            .setView(view.root)
            .setPositiveButton(R.string.save) { _, _ ->
                //TODO: Save Data
                viewModel.saveImage()
            }
            .setNegativeButton(R.string.cancel) { _, _ ->
                viewModel.setImage(null)
            }
        return dialogBuilder.create()

    }
}