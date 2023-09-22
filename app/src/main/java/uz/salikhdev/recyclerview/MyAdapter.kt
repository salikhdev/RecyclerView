package uz.salikhdev.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.salikhdev.recyclerview.databinding.ItemWordBinding

class MyAdapter : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private val data = ArrayList<String>()

    fun setData(data: ArrayList<String>) {
        this.data.addAll(data)
        notifyDataSetChanged()
    }

    fun addData(data: String) {
        this.data.add(data)
        notifyItemInserted(this.data.size)
    }

    fun changeData(text: String, position: Int) {
        this.data[position] = text
        notifyItemChanged(position)
        //notifyDataSetChanged()
    }

    fun deleteData(position: Int) {
        this.data.removeAt(position)
        notifyItemRemoved(position)
    }

    fun addMoreData(data: ArrayList<String>) {
        this.data.addAll(data) // 100  10
        notifyItemRangeInserted(this.data.size, data.size)
    }

    fun deleteModeData(data: ArrayList<String>) {
        this.data.removeAll(data.toSet())
        notifyItemRangeRemoved(this.data.size, data.size)

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            ItemWordBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindData(data[position])
    }

    inner class MyViewHolder(private val binding: ItemWordBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindData(data: String) {

            binding.text2.text = data

        }

    }

}