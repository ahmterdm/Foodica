package com.ahmeterdem.foodica.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation

class DiscountAdapter(var mContext: Context,
                      var sepetListesi : List<SepetYemek>,
                      var viewModel: CartDiscountViewModel
) : RecyclerView.Adapter<DiscountAdapter.AdapterTutucu>() {

    inner class AdapterTutucu(var binding: HolderDiscountAdapterBinding) : RecyclerView.ViewHolder(binding.root)



    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AdapterTutucu {
        val binding : HolderDiscountAdapterBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.holder_discount_adapter,parent,false)
        return AdapterTutucu(binding)

    }

    override fun onBindViewHolder(holder: AdapterTutucu, position: Int) {
        val sepet = sepetListesi[position]
        val t = holder.binding




        t.kart = sepet

        // Silme butonu click listener dışarıda olsun
        t.imageDelete.setOnClickListener {
            Snackbar.make(it, "Silmek istediğinize emin misiniz ?", Snackbar.LENGTH_LONG).setAction("EVET") {
                viewModel.sepettenYemekSil(sepet.sepet_yemek_id)
            }.show()
        }

        // Tüm item tıklaması (nesne) ayrı ve silmeden bağımsız olsun
        t.nesne.setOnClickListener {
            val action = CartDiscountDirections.discountToDetail(sepet = sepet, yemek = null)
            Navigation.gecisYap(it, action)
        }



        val imageName = sepet.yemek_resim_adi ?: ""
        if (imageName.isNotBlank()) {
            val url = "http://kasimadalan.pe.hu/yemekler/resimler/$imageName"
            Glide.with(mContext)
                .load(url)
                .override(300, 300)
                .into(t.textMealImage)
        } else {
            t.textMealImage.setImageResource(R.drawable.ic_launcher_background)
        }
    }


    override fun getItemCount(): Int {
        return sepetListesi.size
    }


}