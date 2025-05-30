package com.ahmeterdem.foodica.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup

class FavAdapter(val mContext: Context,
                       var favoriliste : List<FavoriYemekler> ,
                       val viewModel: FavorilerFragmentViewModel) : RecyclerView.Adapter<FavorilerAdapter.FavoriAdapterTutucu>() {

    inner class FavoriAdapterTutucu(var binding : FavorilerAdapterBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FavoriAdapterTutucu {
        val binding = FavorilerAdapterBinding.inflate(LayoutInflater.from(mContext),parent,false)
        return FavoriAdapterTutucu(binding)
    }

    override fun onBindViewHolder(
        holder: FavoriAdapterTutucu,
        position: Int
    ) {

        var favoriler = favoriliste[position]

        var t = holder.binding


        t.kart = favoriler





        t.imageDelete.setOnClickListener {
            Snackbar.make(it, "Silmek istediğinize emin misiniz ?", Snackbar.LENGTH_LONG).setAction("EVET") {
                viewModel.favoridenYemekSil(favoriler.yemek_id)
            }.show()
        }

        Glide.with(mContext).load("http://kasimadalan.pe.hu/yemekler/resimler/${favoriler.yemek_resim_adi}").override(300,300).into(t.textMealImage)





    }

    override fun getItemCount(): Int {
        return favoriliste.size
    }


}