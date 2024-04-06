package kz.ayala.lab2animals

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import kz.ayala.lab2animals.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    val adapter = Adapter()

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)



        binding.list.adapter = adapter
        binding.list.layoutManager = LinearLayoutManager(this)
        binding.etSearch.setOnEditorActionListener { it, actionId, _ ->
            if (actionId == android.view.inputmethod.EditorInfo.IME_ACTION_SEARCH) {
                Retr.api.getAnimalsByName(it.text.toString()).enqueue(object :
                    Callback<List<Animal>> {
                    override fun onResponse(call: Call<List<Animal>>, response: Response<List<Animal>>) {
                        if (response.isSuccessful) {
                            adapter.submitList(response.body())
                        }
                    }

                    override fun onFailure(call: Call<List<Animal>>, t: Throwable) {
                        Toast.makeText(this@MainActivity, "Network error", Toast.LENGTH_SHORT).show()
                    }
                })
                true
            } else false
        }

        setContentView(binding.root)
    }
}