package com.story_tail.privypics.ui

import android.app.AlertDialog
import android.app.Dialog
import android.graphics.Bitmap
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.story_tail.privypics.R
import com.story_tail.privypics.databinding.DialogFragmentAddImageBinding
import com.story_tail.privypics.viewmodel.ImageViewModel


class AddImageDialogFragment(val bitmap: Bitmap) : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialogBuilder = AlertDialog.Builder(requireContext())
        val viewModel = ImageViewModel(requireContext())
        viewModel.image = bitmap
        val view = DialogFragmentAddImageBinding.inflate(dialog?.layoutInflater)
        view.viewModel = viewModel
        dialogBuilder.setTitle(R.string.add_image)
            .setView(view.root)
            .setPositiveButton(R.string.save) { _, _ ->
                viewModel.saveImage()
            }
            .setNegativeButton(R.string.cancel) { _, _ ->
                viewModel.setImage(null)
            }
        return dialogBuilder.create()
    }
}