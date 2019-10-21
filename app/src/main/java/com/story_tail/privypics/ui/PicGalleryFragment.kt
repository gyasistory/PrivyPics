package com.story_tail.privypics.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.story_tail.privypics.R
import com.story_tail.privypics.viewmodel.ContactGalleryViewModel

/**
 * A simple [Fragment] subclass.
 *
 */
class PicGalleryFragment : Fragment() {
    private val viewModel by lazy {
        ViewModelProviders.of(this).get(ContactGalleryViewModel::class.java)
    }

    private val adapter by lazy {
        PicGalleryAdapter().apply {
            viewModel.getByCategory(null).observe(viewLifecycleOwner, Observer { list ->
                setPics(list)
            })
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pic_gallary, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val recyclerView = view?.findViewById<RecyclerView>(R.id.image_recyclerView)
        recyclerView?.adapter = adapter
    }
}
