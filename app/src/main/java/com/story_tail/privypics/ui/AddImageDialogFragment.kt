package com.story_tail.privypics.ui

import android.app.AlertDialog
import android.app.Dialog
import android.graphics.Bitmap
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.DialogFragment
import com.story_tail.privypics.R
import com.story_tail.privypics.databinding.DialogFragmentAddImageBinding
import com.story_tail.privypics.viewmodel.ImageViewModel


class AddImageDialogFragment(val bitmap: Bitmap) : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialogBuilder = AlertDialog.Builder(requireContext())
        val view = DialogFragmentAddImageBinding.inflate(LayoutInflater.from(requireContext()))
        val viewModel = ImageViewModel(requireContext())
        viewModel.image = bitmap
        view.viewModel = viewModel
        dialogBuilder.setTitle(R.string.add_image)
            .setView(view.root)
            .setPositiveButton(R.string.save) { _, _ ->
                view.viewModel?.saveImage()
            }
            .setNegativeButton(R.string.cancel) { _, _ ->
                view.viewModel?.setImage(null)
            }
        return dialogBuilder.create()
    }
}