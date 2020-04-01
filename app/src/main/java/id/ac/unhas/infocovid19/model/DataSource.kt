package id.ac.unhas.infocovid19.model

import android.content.Context
import com.google.gson.Gson
import java.io.IOException

class DataSource {
    companion object {
        fun createDataSetProvinsi(jsonString: String): DataProvinsi {
            val gson = Gson()
            val data: DataProvinsi = gson.fromJson(jsonString, DataProvinsi::class.java)
            return data
        }

        fun createDataSetPerKasus(jsonString: String): DataPerkasus {
            val gson = Gson()
            val data: DataPerkasus = gson.fromJson(jsonString, DataPerkasus::class.java)
            return data
        }

        fun createDataSetHarian(jsonString: String): DataHarian {
            val gson = Gson()
            val data: DataHarian = gson.fromJson(jsonString, DataHarian::class.java)
            return data
        }

        fun getJsonDataFromAsset(context: Context, fileName: String): String? {
            val jsonString: String
            try {
                jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
            } catch (ioException: IOException) {
                ioException.printStackTrace()
                return null
            }
            return jsonString
        }
    }
}