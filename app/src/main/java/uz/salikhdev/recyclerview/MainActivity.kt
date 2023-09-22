package uz.salikhdev.recyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import uz.salikhdev.recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val adapter by lazy { MyAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        loadAdapter()
        val data = getData()

        adapter.setData(data)

        var a = 5
        binding.addButton.setOnClickListener {

            //adapter.addData("salikh")
            //adapter.changeData("Text ${a++}" , 4)
            //adapter.deleteData(1)
            adapter.addMoreData(getData())

        }


    }

    private fun getData(): ArrayList<String> {
        val data = ArrayList<String>()
        for (i in 1..10) {
            if (i % 2 == 0) {
                data.add("Text asdfd $i")
            } else {
                data.add("Tadssdfda asdasd redsads")
            }
        }

        return data
    }

    private fun loadAdapter() {
        binding.recyclerView.adapter = adapter
        //binding.recyclerView.layoutManager = LinearLayoutManager(this ,LinearLayoutManager.HORIZONTAL,false)
        //binding.recyclerView.layoutManager = GridLayoutManager(this, 2)
        //binding.recyclerView.layoutManager = StaggeredGridLayoutManager(2 , StaggeredGridLayoutManager.VERTICAL)
    }


}