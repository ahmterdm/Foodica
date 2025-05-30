package com.ahmeterdem.foodica.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import kotlin.getValue

@AndroidEntryPoint
class FavorilerFragment : Fragment() {

    private lateinit var binding: FragmentFavorilerBinding
    private val viewModel: FavorilerFragmentViewModel by viewModels()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavorilerBinding.inflate(inflater, container, false)

        binding.buttonDetayClose3.setOnClickListener {
            Navigation.findNavController(it).popBackStack()
        }


        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        viewModel.favorilistesi.observe(viewLifecycleOwner) { liste ->
            val adapter = FavorilerAdapter(requireContext(), liste, viewModel)
            binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
            binding.recyclerView.adapter = adapter




            if (liste.isNullOrEmpty()) {

                binding.emptyView.visibility = View.VISIBLE
                binding.recyclerView.visibility = View.GONE
            } else {

                binding.emptyView.visibility = View.GONE
                binding.recyclerView.visibility = View.VISIBLE
                adapter.favoriliste = liste
                adapter.notifyDataSetChanged()
            }
        }

        viewModel.favoriYemekleriYukle()
    }
}