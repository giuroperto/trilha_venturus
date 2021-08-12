package com.gr.android.trilhaventurus_ex5

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import java.io.IOException
import java.io.InputStream
import java.net.URL
import java.util.concurrent.*
import kotlin.jvm.Throws

class MainActivity : AppCompatActivity() {

    private lateinit var imgDownloaded : ImageView
    private lateinit var btnDownload : Button
    private lateinit var edtUrl : EditText
    private lateinit var queuedWork: ExecutorService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imgDownloaded = findViewById(R.id.img_downloaded)
        btnDownload = findViewById(R.id.btn_download)
        edtUrl = findViewById(R.id.edt_picture)

        queuedWork = Executors.newSingleThreadExecutor()

        Log.i("AsyncTask", "ONCREATE - All screen elements were created and processed. Thread: " +
            Thread.currentThread().name)

        btnDownload.setOnClickListener {
            Log.i("AsyncTask", "CLICKLISTENER - Button was clicked. Thread: " +
                Thread.currentThread().name)

            callNewThread(edtUrl.text.toString())

//            callAsyncTask(edtUrl.text.toString())
        }
    }

    private fun setImage(image: Bitmap?) {
        Log.i("AsyncTask", "SETTING IMAGE. Thread: " +
                Thread.currentThread().name)
        image?.let {
            imgDownloaded.setImageBitmap(image)
        }
    }

    private fun showMessage(message: String?) {
        message?.let {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }
    }

    private fun callNewThread(url: String) {
        Log.i("AsyncTask", "CALLING NEW THREAD - New Thread being called. Thread: " +
                Thread.currentThread().name)

//      Looper.prepare()
        Log.i("AsyncTask", "INSIDE NEW THREAD - New thread. Thread: " +
                Thread.currentThread().name)

        showMessage("Please wait! Downloading image...")

        doInBackgroundStyle(url)
    }

    private fun doInBackgroundStyle(url: String) {
        var imageBitmap: Bitmap? = null
        var progress: Int = 0

        try {
            Log.i("AsyncTask", "DOINBACK TRY - Downloading image. Thread: " +
                    Thread.currentThread().name)
            imageBitmap = downloadImage(url).get()
            for (i in 0..2) {
                progress = (i * 100)/2
                showMessage("${progress.toString()}%")
            }
        } catch (e: IOException) {
            Log.i("AsyncTask", "DOINBACK CATCH - " + e.message)
        }

        downloadImage(url).get()

        onPostExecuteStyle(imageBitmap)
    }

    @Throws(IOException::class)
    private fun downloadImage(url: String?) : Future<Bitmap> {
        return queuedWork.submit {
            val urlAddress : URL = URL(url)
            val inputStream : InputStream = urlAddress.openStream()
            val image : Bitmap = BitmapFactory.decodeStream(inputStream)
            inputStream.close()
            return image
        }
    }

    private fun onPostExecuteStyle(result: Bitmap?) {
        if (result != null) {
            Log.i("AsyncTask", "INSIDE HANDLER. Thread: " +
                    Thread.currentThread().name)
            setImage(result)
            Log.i("AsyncTask", "INSIDE IF - Showing bitmap. Thread: " +
                    Thread.currentThread().name)
        } else {
            Log.i("AsyncTask", "INSIDE ELSE - Error downloading image. Thread: " +
                    Thread.currentThread().name)
        }

        Log.i("AsyncTask", "OUT OF IF - Ending PostExecute. Thread: " +
                Thread.currentThread().name)
    }

    private fun callAsyncTask(url: String) {
        val download: DownloadTask = DownloadTask()

        Log.i("AsyncTask", "CALLING TASK - Async being called. Thread: " +
            Thread.currentThread().name)

        download.execute(url)
    }

    private inner class DownloadTask() : AsyncTask<String, Int, Bitmap>() {

        override fun onPreExecute() {
            Log.i("AsyncTask", "ONPREEXECUTED - Showing Toast onscreen. Thread: " +
                    Thread.currentThread().name)
            showMessage("Please wait! Downloading image...")
        }

        override fun doInBackground(vararg params: String?): Bitmap? {
            var imageBitmap: Bitmap? = null

            try {
                Log.i("AsyncTask", "DOINBACK TRY - Downloading image. Thread: " +
                    Thread.currentThread().name)
                imageBitmap = downloadImage(params[0])
                for (i in 0..2) {
                    publishProgress((i * 100)/2, i)
                }
            } catch (e: IOException) {
                Log.i("AsyncTask", "DOINBACK CATCH - " + e.message)
            }

            return imageBitmap
        }

        override fun onPostExecute(result: Bitmap?) {
            if (result != null) {
                setImage(result)
                Log.i("AsyncTask", "INSIDE IF - Showing bitmap. Thread: " +
                    Thread.currentThread().name)
            } else {
                Log.i("AsyncTask", "INSIDE ELSE - Error downloading image. Thread: " +
                        Thread.currentThread().name)
            }

            Log.i("AsyncTask", "OUT OF IF - Ending PostExecute. Thread: " +
                Thread.currentThread().name)
        }

        override fun onProgressUpdate(vararg values: Int?) {
            showMessage("${values[1]} - ${values[0]}%")
        }

        @Throws(IOException::class)
        fun downloadImage(url: String?) : Bitmap {
            val urlAddress : URL
            val inputStream : InputStream
            val image : Bitmap

            urlAddress = URL(url)
            inputStream = urlAddress.openStream()
            image = BitmapFactory.decodeStream(inputStream)

            inputStream.close()

            return image
        }

    }
}